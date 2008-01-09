 /*
  * @(#)XmlScriptRunWorker.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.runAct;

import org.apache.xmlbeans.XmlException;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainTask;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.grid.gridgain.assignJob.AssignJob2NodeDStabTask;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.schema.AnalysisRunTaskXmlData;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.RunAcscStudyCaseXmlType;
import org.interpss.schema.RunDStabStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;
import org.interpss.xml.XmlNetParamModifier;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.common.util.StringUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.CoreSpringAppContext;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class XmlScriptRunWorker {
	/**
	 * Run the XMl scripts
	 * 
	 * @param scripts run scripts, a XML document
	 * @param simuCtx
	 * @return
	 */
	public static boolean runCase(String scripts, SimuContext simuCtx) {
		IpssXmlParser parser;
		try {
  			parser = new IpssXmlParser(scripts);
		} catch (XmlException e) {
			IpssLogger.logErr(e);
  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", e.toString());
			return false;
		}
		
  		if (parser.getModification() != null)
  			XmlNetParamModifier.applyModification2Net(simuCtx.getNetwork(), parser.getModification());
 
  		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase(); 
	  	IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
	  	IPSSMsgHub msg = simuCtx.getMsgHub();
		if (xmlStudyCase.getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_ACLF ) {
		  	if (parser.getRunAclfStudyCaseList().length > 0) {
			  	if (parser.getRunAclfStudyCaseList().length == 1) {
			  		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
			  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
				  	RunAclfStudyCaseXmlType aclfCase = parser.getRunAclfStudyCaseList()[0];
				  	mapper.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);
								  	
					if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
		  				Grid grid = IpssGridGainUtil.getDefaultGrid();
		  				AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil.getAnyRemoteNodeId();
		  	    		AbstractIpssGridGainTask.MasterNodeId = grid.getLocalNode().getId().toString();
		  				try {
		  					String str = (String)IpssGridGainUtil.performGridTask(grid,
		  									"InterPSS Grid Aclf Calculation", algo,	xmlStudyCase.getGridTimeout());
		  	  				net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(str);
		  				} catch (GridException e) {
		  					SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error", e.toString());
		  					return false;
		  				}
					}
					else {
						algo.loadflow(msg);
					}
				  	if (aclfCase.getDiaplaySummary()) {
				  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
					  	dialog.display(net);
				  	}
			  	}
			  	else {
			  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());
				  	MultiStudyCase mscase = SimuObjectFactory.createMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
				  	int cnt = 0;
			  		for (RunAclfStudyCaseXmlType aclfCase : parser.getRunAclfStudyCaseList()) {
						AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
						LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
					  	mapper.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);

					  	// net.id is used to retrieve study case info at remote node. so we need to
					  	// sure net.id and studyCase.id are the same for Grid computing. 
						net.setId(aclfCase.getRecId());
				  		StudyCase scase = SimuObjectFactory.createStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
						if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
							scase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));
						}
						else {
							algo.loadflow(msg);
						}
				  		scase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
			  		}
			  		
					if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
		  				Grid grid = IpssGridGainUtil.getDefaultGrid();
		  				try {
		  					Object[] strAry = (Object[])IpssGridGainUtil.performGridTask(grid,
		  										"InterPSS Grid Aclf Calculation", mscase, xmlStudyCase.getGridTimeout());
		  					for (Object obj : strAry) {
		  						String str = (String)obj;
		  						AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(str);
		  						StudyCase studyCase = mscase.getStudyCase(net.getId());
		  						studyCase.setNetModelString(str);
		  					}
		  				} catch (GridException e) {
		  					SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error", e.toString());
		  					return false;
		  				}
					}
			  		
			  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
				  	dialog.display(mscase);
			  	}
		  	}
		  	else {
	  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runAclfStudyCase element not defined");
				return false;
		  	}
		}
		else if (xmlStudyCase.getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_ACSC ) {
		  	if (parser.getRunAcscStudyCaseList().length > 0) {
		  		SimpleFaultNetwork faultNet = simuCtx.getAcscFaultNet();
			  	if (parser.getRunAcscStudyCaseList().length == 1) {
				  	RunAcscStudyCaseXmlType acscCase = parser.getRunAcscStudyCaseList()[0];
			  		SimpleFaultAlgorithm algo = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet);
			  		mapper.mapping(acscCase, algo, RunAcscStudyCaseXmlType.class);
			  		Object fault = faultNet.getFaultList().get(0);
			  		if (fault instanceof AcscBusFault) 
			  			algo.calculateBusFault((AcscBusFault)fault, msg);
			  		else
			  			algo.calculateBranchFault((AcscBranchFault)fault, msg);
					RunActUtilFunc.displayAcscSummaryResult(faultNet);
			  	}
			  	else
			  		for (RunDStabStudyCaseXmlType dstabCase : parser.getRunDStabStudyCaseList()) {
			  		}
		  	}
		  	else {
	  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runAcscStudyCase element not defined");
				return false;
		  	}
		}
		else if (xmlStudyCase.getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_D_STAB ) {
	  		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(simuCtx.getDStabilityNet(), msg);
		  	if (parser.getRunDStabStudyCaseList().length > 0) {
			  	if (parser.getRunDStabStudyCaseList().length == 1) {
				  	RunDStabStudyCaseXmlType dstabCase = parser.getRunDStabStudyCaseList()[0];
			  		mapper.mapping(dstabCase, algo, RunDStabStudyCaseXmlType.class);
			  		
			  		if (!RunActUtilFunc.checkDStabSimuData(algo, msg))
			  			return false;
					
					LoadflowAlgorithm aclfAlgo = algo.getAclfAlgorithm();
					aclfAlgo.loadflow(msg);
			  		if (dstabCase.getAclfAlgorithm().getDiaplaySummary())
			  			RunActUtilFunc.displayAclfSummaryResult(algo);
				  	if (!algo.getDStabNet().isLfConverged()) {
				  		msg.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
				  		return false;
				  	}

				  	// set up output and run the simulation
					IDStabSimuDatabaseOutputHandler handler = RunActUtilFunc.createDBOutputHandler(algo);
					if (handler == null)
						return false;
					
					// setup if there is output filtering
					handler.setOutputFilter(algo.isOutputFilted());
					if (handler.isOutputFilter()) 
						handler.setOutputVarIdList(StringUtil.convertStrAry2StrList(algo.getOutputVarIdList()));
					algo.setSimuOutputHandler(handler);

					algo.getDStabNet().setNetChangeListener(CoreSpringAppContext.getNetChangeHandler());
					
				  	if (algo.initialization(msg)) {
					  	algo.performSimulation(msg);
					}
				  	return true;
			  	}
			  	else
			  		for (RunDStabStudyCaseXmlType dstabCase : parser.getRunDStabStudyCaseList()) {
			  		}
		  	}
		  	else {
	  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runDStabStudyCase element not defined");
				return false;
		  	}
		}
		return true;
	}
}
