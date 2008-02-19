/*
 * @(#)CmdLineRun.java   
 *
 * Copyright (C) 2006 www.interpss.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 01/30/2007
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.cmd;

import java.io.File;

import org.interpss.AppConstants;
import org.interpss.InterPSS;
import org.interpss.PluginSpringAppContext;
import org.interpss.editor.runAct.xml.XmlScriptAclfRun;
import org.interpss.editor.runAct.xml.XmlScriptAcscRun;
import org.interpss.editor.runAct.xml.XmlScriptDStabRun;
import org.interpss.editor.runAct.xml.XmlScriptDclfRun;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.output.IOutputSimuResult;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;
import org.interpss.xml.XmlNetParamModifier;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.SimuRunType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.io.IpssFileAdapter;

public class CmdLineRunner {
	private static SimuRunType runType = SimuRunType.NotDefined;
	
	/**
	 * Run InterPSS simulation in cmd line mode
	 * 
	 * @param inputFilename input file name. Its extension will be used to determine input file load adapter
	 * @param runTypeStr Dclf|Aclf|Acsc|DStab to overide the default run type, which is decided by the input data network type
	 * @param xmlContrlFile an xml file to control interpss run
	 * @param outFilename output file name
	 * @return returning a object (Net, SimuCtx) for testing purpose
	 */
	public static Object cmdLineRun(
			String inputFilename, 
			String runTypeStr, 
			String xmlControlFile,
			String outFilename) {

		SimuContext simuCtx = inputData(inputFilename);
		if (simuCtx != null) {
			if (runStudyCase(simuCtx, runTypeStr, xmlControlFile)) {
				String f = outFilename;
				if (f == null || f.trim().equals("")) {
					String str = StringUtil.getFileNameNoExt(inputFilename);
					f = AppConstants.APP_BASE_DIR + AppConstants.OUTPUT_DEFAULT_DIR 
							+ System.getProperty("file.separator") + str
							+ AppConstants.OUTPUT_FILE_EXT;
				}
				outputResult(simuCtx, runType, f);
			}
		}
		return simuCtx;
	}

	/**
	 * Run InterPSS simulation in cmd line mode
	 * 
	 * @param inputFilename input file name. Its extension will be used to determine input file load adapter
	 * @return returning a object (Net, SimuCtx) for testing purpose
	 */
	public static Object cmdLineRun(String inputFilename) {
		return cmdLineRun(inputFilename, null, null, null);
	}

	private static SimuContext inputData(String filename) {
		try {
			if (filename == null || filename.trim().equals("")) {
				IpssLogger.getLogger().severe("Error, You need a input file -in filename");
				return null;
			}
			
			String ext = StringUtil.getFileExt(filename);
			IpssFileAdapter adapter = PluginSpringAppContext
					.getCustomFileAdapter(ext);
			if (adapter == null) {
				IpssLogger.getLogger().severe("Wrong file type, no adapter is available, ext: " + ext);
				return null;
			}
			SimuContext simuCtx = adapter.load(filename, SpringAppContext
					.getIpssMsgHub());
			return simuCtx;
		} catch (Exception e) {
			IpssLogger.logErr(e);
			return null;
		}
	}

	private static boolean runStudyCase(SimuContext simuCtx, String runTypeStr, String xmlControlFile) {
		IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
		if (xmlControlFile != null && !xmlControlFile.equals("")) {
			IpssLogger.getLogger().info("Run CmdLine using xml control file, " + xmlControlFile);
		
			IpssXmlParser parser;
			try {
				parser = new IpssXmlParser(new File(xmlControlFile));
			} catch (Exception e) {
				IpssLogger.logErr(e);
				msg.sendErrorMsg("Error to load control Xml file, " + e.toString());
				return false;
			}
			
			// Apply the modification to the base Network object
			if (parser.getModification() != null)
				XmlNetParamModifier.applyModification(simuCtx.getNetwork(),
						parser.getModification(), msg);

			RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase();
			IpssGridGainUtil.RemoteNodeDebug = xmlStudyCase.getGridRun() != null
					&& xmlStudyCase.getGridRun().getRemoteNodeDebug();
			if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF) {
				runType = SimuRunType.Aclf;
				return XmlScriptAclfRun.runAclf(parser, simuCtx.getAclfAdjNet(),
						msg);
			} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_DCLF) {
				runType = SimuRunType.Dclf;
				return XmlScriptDclfRun.runDclf(parser, simuCtx.getAclfNet(),
						msg);
			} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACSC) {
				runType = SimuRunType.Acsc;
				return XmlScriptAcscRun.runAcsc(parser, simuCtx.getAcscFaultNet(),
						msg);
			} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_D_STAB) {
				runType = SimuRunType.DStab;
				return XmlScriptDStabRun.runDStab(parser, simuCtx, msg);
			}
			return true;			
		}
		else if (runTypeStr != null && !runTypeStr.equals("")) {
			IpssLogger.getLogger().info("Run CmdLine, runType = " + runTypeStr);
			if (InterPSS.RunAclfStr.equals(runTypeStr)) {
				// create the default loadflow algorithm
				LoadflowAlgorithm algo = CoreObjectFactory
						.createLoadflowAlgorithm(simuCtx.getAclfAdjNet());
				// use the loadflow algorithm to perform loadflow calculation
				algo.loadflow(msg);
				runType = SimuRunType.Aclf;
			} else if (runTypeStr != null && InterPSS.RunDclfStr.equals(runTypeStr)) {
				DclfAlgorithm algo = CoreObjectFactory
						.createDclfAlgorithm(simuCtx.getAclfAdjNet());
				simuCtx.setDclfAlgorithm(algo);
				if (algo.checkCondition(msg))
					algo.calculateDclf(msg);
				runType = SimuRunType.Dclf;
			}
		} else {
			IpssLogger.getLogger().info("Run CmdLine according network type");
			if (simuCtx.getNetType() == SimuCtxType.ACLF_NETWORK
					|| simuCtx.getNetType() == SimuCtxType.ACLF_ADJ_NETWORK) {
				// create the default loadflow algorithm
				LoadflowAlgorithm algo = CoreObjectFactory
						.createLoadflowAlgorithm(simuCtx.getAclfAdjNet());
				// use the loadflow algorithm to perform loadflow calculation
				algo.loadflow(msg);
				runType = SimuRunType.Aclf;
			}
			else {
				IpssLogger.getLogger().warning("InterPSS CmdLine mode currently only supput Dclf and Aclf run type");
				return false;
			}
		}
		return true;
	}

	private static void outputResult(SimuContext simuCtx, SimuRunType runType,
			String outFilename) {
		IOutputSimuResult out = PluginSpringAppContext.getSimuResultOutput();
		if (runType == SimuRunType.Dclf) {
			if (InterPSS.RunAclfStr.equals(runType)) {
				out.outAclfResult(simuCtx.getAclfAdjNet(), outFilename);
			} else if (runType != null && InterPSS.RunDclfStr.equals(runType)) {
				out.outDclfResult(simuCtx.getDclfAlgorithm(), outFilename);
			}
		} 
		else if (runType == SimuRunType.Aclf) {
			if (simuCtx.getNetType() == SimuCtxType.ACLF_NETWORK
					|| simuCtx.getNetType() == SimuCtxType.ACLF_ADJ_NETWORK) {
				out.outAclfResult(simuCtx.getAclfAdjNet(), outFilename);
			}
		}
	}
}
