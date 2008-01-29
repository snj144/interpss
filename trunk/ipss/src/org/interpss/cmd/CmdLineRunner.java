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

import org.interpss.AppConstants;
import org.interpss.InterPSS;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.output.IOutputSimuResult;

import com.interpss.common.SpringAppContext;
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
	/**
	 * Run InterPSS simulation in cmd line mode
	 * 
	 * @param inputFilename input file name. Its extension will be used to determine input file load adapter
	 * @param outFilename output file name
	 * @return returning a object (Net, SimuCtx) for testing purpose
	 */
	public static Object cmdLineRun(String inputFilename, String runType,
			String outFilename) {

		SimuContext simuCtx = inputData(inputFilename);
		if (simuCtx != null) {
			if (runStudyCase(simuCtx, runType)) {
				String f = outFilename;
				if (f == null || f.trim().equals("")) {
					String str = StringUtil.getFileNameNoExt(inputFilename);
					f = AppConstants.APP_BASE_DIR
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
		return cmdLineRun(inputFilename, null, null);
	}

	private static SimuContext inputData(String filename) {
		try {
			String ext = StringUtil.getFileExt(filename);
			IpssFileAdapter adapter = SimuAppSpringAppCtxUtil
					.getCustomFileAdapter(ext);
			SimuContext simuCtx = adapter.load(filename, SpringAppContext
					.getIpssMsgHub());
			return simuCtx;
		} catch (Exception e) {
			IpssLogger.logErr(e);
			return null;
		}
	}

	private static boolean runStudyCase(SimuContext simuCtx, String runType) {
		IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
		if (runType != null && !runType.equals("")) {
			if (InterPSS.RunAclfStr.equals(runType)) {
				// create the default loadflow algorithm
				LoadflowAlgorithm algo = CoreObjectFactory
						.createLoadflowAlgorithm(simuCtx.getAclfAdjNet());
				// use the loadflow algorithm to perform loadflow calculation
				algo.loadflow(msg);
			} else if (runType != null && InterPSS.RunDclfStr.equals(runType)) {
				DclfAlgorithm algo = CoreObjectFactory
						.createDclfAlgorithm(simuCtx.getAclfAdjNet());
				simuCtx.setDclfAlgorithm(algo);
				if (algo.checkCondition(msg))
					algo.calculateDclf(msg);
			}
		} else {
			if (simuCtx.getNetType() == SimuCtxType.ACLF_NETWORK
					|| simuCtx.getNetType() == SimuCtxType.ACLF_ADJ_NETWORK) {
				// create the default loadflow algorithm
				LoadflowAlgorithm algo = CoreObjectFactory
						.createLoadflowAlgorithm(simuCtx.getAclfAdjNet());
				// use the loadflow algorithm to perform loadflow calculation
				algo.loadflow(msg);
			}
		}
		return true;
	}

	private static void outputResult(SimuContext simuCtx, String runType,
			String outFilename) {
		IOutputSimuResult out = SimuAppSpringAppContext.getSimuResultOutput();
		if (runType != null && !runType.equals("")) {
			if (InterPSS.RunAclfStr.equals(runType)) {
				out.outAclfResult(simuCtx.getAclfAdjNet(), outFilename);
			} else if (runType != null && InterPSS.RunDclfStr.equals(runType)) {
				out.outDclfResult(simuCtx.getDclfAlgorithm(), outFilename);
			}
		} else {
			if (simuCtx.getNetType() == SimuCtxType.ACLF_NETWORK
					|| simuCtx.getNetType() == SimuCtxType.ACLF_ADJ_NETWORK) {
				out.outAclfResult(simuCtx.getAclfAdjNet(), outFilename);
			}
		}
	}
}
