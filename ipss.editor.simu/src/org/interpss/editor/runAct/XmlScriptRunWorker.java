 /*
  * @(#)XmlScriptRunWorker.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 01/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.runAct;

import org.apache.xmlbeans.XmlException;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.gridgain.task.assignJob.AbstractAssignJob2NodeTask;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.GridMessageRouter;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.AnalysisRunTaskXmlData;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.RunAcscStudyCaseXmlType;
import org.interpss.schema.RunDStabStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;
import org.interpss.xml.XmlNetParamModifier;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.SimuRunType;
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
import com.interpss.dstab.DStabilityNetwork;
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
	 * @param scripts run scripts, a string representing an XML document
	 * @param simuCtx the SimuContext object
	 * @return
	 */
	public static boolean runCase(String scripts, SimuContext simuCtx) {
		// create the XML parser and parse the run scripts
		IpssXmlParser parser;
		try {
  			parser = new IpssXmlParser(scripts);
		} catch (XmlException e) {
			IpssLogger.logErr(e);
  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", e.toString());
			return false;
		}
		
	  	IPSSMsgHub msg = simuCtx.getMsgHub();

	  	// Apply the modification to the base Network object
  		if (parser.getModification() != null)
  			XmlNetParamModifier.applyModification2Net(simuCtx.getNetwork(), parser.getModification());
 	  	
  		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase(); 
		if (xmlStudyCase.getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_ACLF ) {
			return runAclf(parser, simuCtx.getAclfAdjNet(), msg);
		}
		else if (xmlStudyCase.getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_ACSC ) {
		  	return runAcsc(parser, simuCtx.getAcscFaultNet(), msg);
		}
		else if (xmlStudyCase.getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_D_STAB ) {
	  		return runDStab(parser, simuCtx, msg);
		}
		return true;
	}
	
	private static boolean runAclf(IpssXmlParser parser, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
	  	IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase(); 

  		if (parser.getRunAclfStudyCaseList().length > 0) {
		  	if (parser.getRunAclfStudyCaseList().length == 1) {
			  	RunAclfStudyCaseXmlType aclfCase = parser.getRunAclfStudyCaseList()[0];

		  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(aclfNet);
			  	mapper.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);
							  	
				if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
	  				Grid grid = IpssGridGainUtil.getDefaultGrid();
	  				AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil.getAnyRemoteNodeId();
	  				AbstractAssignJob2NodeTask.MasterNodeId = grid.getLocalNode().getId().toString();
	  				try {
	  					String str = (String)IpssGridGainUtil.performGridTask(grid,
	  									"InterPSS Grid Aclf Calculation", algo,	xmlStudyCase.getGridTimeout());
	  					aclfNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(str);
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
				  	dialog.display(aclfNet);
			  	}
		  	}
		  	else {
		  		// save the base case Network model to the netStr
		  		String netStr = SerializeEMFObjectUtil.saveModel(aclfNet);
		  		// create a multi-case container
		  		MultiStudyCase mCaseContainer = SimuObjectFactory.createMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
		  		int cnt = 0;
		  		for (RunAclfStudyCaseXmlType aclfCase : parser.getRunAclfStudyCaseList()) {
		  			// deserialize the base case
					AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
					LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
				  	// map to the Algo object including network modification at case level
					mapper.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);

				  	// net.id is used to retrieve study case info at remote node. so we need to
				  	// sure net.id and studyCase.id are the same for Grid computing. 
					net.setId(aclfCase.getRecId());
			  		try {
			  			StudyCase studyCase = SimuObjectFactory.createStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mCaseContainer);
						if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
							// if Grid computing, save the Algo object to the study case object
							studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));
						}
						else {
							// if not grid computing, perform Loadflow
							algo.loadflow(msg);
					  		studyCase.setDesc("Loadflow by Local Node");
						}
						// persist the AclfNet object to study case. It contains case level modification
						// in the case of non grid computing, it contains Loadflow results
				  		studyCase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
			  		} catch (Exception e) {
	  					SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Study Case Creation Error", e.toString());
			  			return false;
			  		}
		  		}
		  		
		  		// if Grid computing, send the MultiCase container to perform remote grid computing
				if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
	  				Grid grid = IpssGridGainUtil.getDefaultGrid();
	  				try {
	  					Object[] objAry = (Object[])IpssGridGainUtil.performGridTask(grid,
	  										"InterPSS Grid Aclf Calculation", mCaseContainer, xmlStudyCase.getGridTimeout());
	  					for (Object obj : objAry) {
	  						String str = (String)obj;
	  						// deserialize the AclfNet model string for Net.id
	  						AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(str);
	  						// update StudyCase AclfNet model string from the result coming back from remote node.
	  						StudyCase studyCase = mCaseContainer.getStudyCase(net.getId());
	  						studyCase.setNetModelString(str);
					  		studyCase.setDesc("Loadflow by Remote Node: " + IpssGridGainUtil.nodeNameLookup(net.getDesc()));
	  					}
	  				} catch (GridException e) {
	  					SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error", e.toString());
	  					return false;
	  				}
				}
		  		
		  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
			  	dialog.display(mCaseContainer);
		  	}
	  	}
	  	else {
  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runAclfStudyCase element not defined");
			return false;
	  	}
  		return true;
	}

	private static boolean runAcsc(IpssXmlParser parser, SimpleFaultNetwork faultNet, IPSSMsgHub msg) {
	  	IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
	  	if (parser.getRunAcscStudyCaseList().length > 0) {
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
		  		for (RunAcscStudyCaseXmlType acscCase : parser.getRunAcscStudyCaseList()) {
		  		}
	  	}
	  	else {
  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runAcscStudyCase element not defined");
			return false;
	  	}
		return true;
	}

	private static boolean runDStab(IpssXmlParser parser, SimuContext simuCtx, IPSSMsgHub msg) {
		DStabilityNetwork dstabNet = simuCtx.getDStabilityNet();
  		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase(); 

	  	if (parser.getRunDStabStudyCaseList().length > 0) {
		  	if (parser.getRunDStabStudyCaseList().length == 1) {
			  	RunDStabStudyCaseXmlType dstabCase = parser.getRunDStabStudyCaseList()[0];
		  		DynamicSimuAlgorithm dstabAlgo = DStabObjectFactory.createDynamicSimuAlgorithm(dstabNet, msg);
		  		if (!configDStaAlgo(dstabAlgo, dstabCase, msg))
		  			return false;

				if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
					// get any remote node
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil.getAnyRemoteNodeId();
					AbstractAssignJob2NodeTask.MasterNodeId = grid.getLocalNode().getId().toString();
					
					/*
					 * The simuMsg sending from remote node to the master node will be routed
					 * by the router to the msg object. The simuMsg will be then routed to the 
					 * DBSimuDataHandler
					 */
			    	GridMessageRouter msgRouter = new GridMessageRouter(msg);
			    	grid.addMessageListener(msgRouter);
			    	msgRouter.setDStabSimuDbOutputHandler(dstabAlgo.getSimuOutputHandler());

					try {
						Boolean rtn = (Boolean)IpssGridGainUtil.performGridTask(grid,
												"InterPSS Transient Stability Simulation", dstabAlgo, xmlStudyCase.getGridTimeout());
						// init the Net object for plotting purpose. it is inited at the remote grid node
						// before DStab simulation.
						dstabNet.initialization(msg);
						// set the DStabNet object back to the SimuCtx
						simuCtx.setDStabilityNet(dstabNet);
						return rtn.booleanValue();
					} catch (GridException e) {
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid DStab Error", e.toString());
						return false;
					}
				}
				else {
					runLocalDStabRun(dstabAlgo, dstabCase, msg);
				}
		  	}
		  	/*
		  	 * Multi-DStab run case
		  	 * ====================
		  	 */
		  	else {
				IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
				appSimuCtx.setLastRunType(SimuRunType.ScriptsMultiCase);

		  		// save the base case Network model to the netStr
		  		String netStr = SerializeEMFObjectUtil.saveModel(dstabNet);
		  		// create a multi-case container
		  		MultiStudyCase mCaseContainer = SimuObjectFactory.createMultiStudyCase(SimuCtxType.DSTABILITY_NET);
		  		int cnt = 0;
		  		for (RunDStabStudyCaseXmlType dstabCase : parser.getRunDStabStudyCaseList()) {
		  			// deserialize the base case
		  			DStabilityNetwork net = (DStabilityNetwork)SerializeEMFObjectUtil.loadModel(netStr);
			  		DynamicSimuAlgorithm dstabAlgo = DStabObjectFactory.createDynamicSimuAlgorithm(net, msg);
			  		if (!configDStaAlgo(dstabAlgo, dstabCase, msg))
			  			return false;

					if (IpssGridGainUtil.isGridEnabled() && xmlStudyCase.getEnableGridRun()) {
					}
					else {
						runLocalDStabRun(dstabAlgo, dstabCase, msg);
					}
					simuCtx.setDStabilityNet(dstabNet);
		  		}
		  	}
	  	}
	  	else {
  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runDStabStudyCase element not defined");
			return false;
	  	}
		return true;
	}
	
	private static boolean configDStaAlgo(DynamicSimuAlgorithm dstabAlgo, RunDStabStudyCaseXmlType dstabCase, IPSSMsgHub msg) {
  		// map the Xml study case data to dstabAlgo, including modification to the network model data
		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(dstabCase, dstabAlgo, RunDStabStudyCaseXmlType.class);
  		if (!RunActUtilFunc.checkDStabSimuData(dstabAlgo, msg))
  			return false;  // if something is wrong, we stop running here

  		// create a DB handler to store simulation result, a Db simu case will be created if not existed.
  		// to get db case id: dstabDbHandler.getDBCaseId()
		IDStabSimuDatabaseOutputHandler dstabDbHandler = RunActUtilFunc.createDBOutputHandler(dstabAlgo, dstabCase);
		if (dstabDbHandler == null)
				return false;

		// correlate net.id, case.id and dbCaseId
		dstabAlgo.getDStabNet().setId(dstabCase.getRecId());
		dstabDbHandler.addDBCaseId(dstabCase.getRecId(), dstabDbHandler.getDBCaseId());
		
		// transfer output variable filter info to the DStabAlgo object, which then
		// will be carried by the object to the remote grid node, in case of grid computing 
		dstabDbHandler.setOutputFilter(dstabAlgo.isOutputFilted());
		if (dstabDbHandler.isOutputFilter())
			dstabDbHandler.setOutputVarIdList(StringUtil
					.convertStrAry2StrList(dstabAlgo.getOutputVarIdList()));
		
		// set the DB handler to the algo object
		dstabAlgo.setSimuOutputHandler(dstabDbHandler);
		return true;
	}

	private static boolean runLocalDStabRun(DynamicSimuAlgorithm dstabAlgo, RunDStabStudyCaseXmlType dstabCase, IPSSMsgHub msg) {
		dstabAlgo.getDStabNet().setNetChangeListener(CoreSpringAppContext.getNetChangeHandler());

		LoadflowAlgorithm aclfAlgo = dstabAlgo.getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
		if (dstabCase.getAclfAlgorithm().getDiaplaySummary())
			RunActUtilFunc.displayAclfSummaryResult(dstabAlgo);
		if (!dstabAlgo.getDStabNet().isLfConverged()) {
			msg.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
			return false;
		}

		if (dstabAlgo.initialization(msg)) {
			dstabAlgo.performSimulation(msg);
		}
		return true;
	}
}
