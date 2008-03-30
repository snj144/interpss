/*
 * @(#)XmlScriptDStabRun.java   
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

package org.interpss.editor.runAct.xml;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.PluginSpringAppContext;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.runAct.RunActUtilFunc;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.GridMessageRouter;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunDStabStudyCase.DStabStudyCaseList.DStabStudyCaseRec;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.SimuRunType;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.common.util.StringUtil;
import com.interpss.core.CoreSpringAppContext;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class XmlScriptDStabRun {
	/**
	 * Run DStab run or run(s) defined in the Xml scripts
	 * 
	 * @param parser
	 *            The InterPSS xml parser object, which contents the Xml Run
	 *            scripts
	 * @param simuCtx
	 *            the SimuContext object
	 * @param msg
	 * @return
	 */
	public static boolean runDStab(IpssXmlParser parser, SimuContext simuCtx,
			IPSSMsgHub msg) {
		// get the RunStudyCase object, root level modification has already
		// applied
		// to the DStabNet object
		RunStudyCaseXmlType.RunDStabStudyCase xmlRunCase = parser.getRunDStabStudyCase();

		if (xmlRunCase != null) {
			IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
			DStabilityNetwork dstabNet = simuCtx.getDStabilityNet();
			DStabStudyCaseXmlType xmlDefaultCase = xmlRunCase.getDefaultDStabStudyCase(); 

			// single run case
			if (xmlRunCase.getDStabStudyCaseList().getDStabStudyCaseRecArray().length == 1) {
				appSimuCtx.setLastRunType(SimuRunType.DStab);

				// get the run case info defined in the Xml scripts
				DStabStudyCaseRec dstabRec = xmlRunCase.getDStabStudyCaseList().getDStabStudyCaseRecArray()[0];
				// config the DStabAlgo object, including apply case-level
				// modification to the DStabNet object
				DynamicSimuAlgorithm dstabAlgo = DStabObjectFactory
						.createDynamicSimuAlgorithm(dstabNet, msg);

				DStabStudyCaseXmlType xmlCase = dstabRec.getDStabStudyCase(); 
				if (xmlCase == null) {
					if (xmlDefaultCase == null) {
						msg.sendErrorMsg("No DStab case defined");
						return false;
					}
					xmlCase = xmlDefaultCase;
					dstabRec.setDStabStudyCase(xmlDefaultCase);				
				}
				if (!configDStaAlgo(dstabAlgo, dstabRec, msg))
					return false;

				if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					// get any remote node to distribute the simulation job
					AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil
							.getAnyRemoteNodeId();
					// set the master node id, so that remote msg could be sent
					// to the master node
					IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId()
							.toString();

					/*
					 * The simuMsg sending from remote node to the master node
					 * will be routed by the router to msg object, excepting
					 * DStab simu msg, which will be handled by the
					 * dbSimuDataHandler object
					 */
					GridMessageRouter msgRouter = new GridMessageRouter(msg);
					grid.addMessageListener(msgRouter);
					msgRouter.addDStabSimuDbOutputHandler(dstabAlgo
							.getSimuOutputHandler());

					try {
						// run DStab simu at a remote node
						Boolean rtn = (Boolean) IpssGridGainUtil
								.performGridTask(
										grid,
										"InterPSS Transient Stability Simulation",
										dstabAlgo, parser.getRunStudyCase().getGridRun()
												.getTimeout());
						// init the Net object for plotting purpose.
						dstabNet.initialization(msg);
						// set the DStabNet object back to the SimuCtx
						simuCtx.setDStabilityNet(dstabNet);
						return rtn.booleanValue();
					} catch (GridException e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Grid DStab Error",
										e.toString());
						return false;
					}
				} else {
					runLocalDStabRun(dstabAlgo, xmlCase, msg);
				}
			} else {
				// Multi-DStab run case
				appSimuCtx.setLastRunType(SimuRunType.ScriptsMultiCase);
				SpringAppContext.getSimuRecManager().clearDbCaseIdLookup();
				
				GridMessageRouter msgRouter = null;
				if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId()
							.toString();
					msgRouter = new GridMessageRouter(msg);
					grid.addMessageListener(msgRouter);
				}

				// save the base case Network model to the netStr
				String netStr = SerializeEMFObjectUtil.saveModel(dstabNet);
				// create a multi-case container
				MultiStudyCase mCaseContainer = SimuObjectFactory
						.createMultiStudyCase(SimuCtxType.DSTABILITY_NET);
				int cnt = 0;
				for (DStabStudyCaseRec dstabRec : xmlRunCase.getDStabStudyCaseList().getDStabStudyCaseRecArray()) {
					// deserialize the base case
					DStabilityNetwork net = (DStabilityNetwork) SerializeEMFObjectUtil
							.loadModel(netStr);
					DynamicSimuAlgorithm dstabAlgo = DStabObjectFactory
							.createDynamicSimuAlgorithm(net, msg);
					
					DStabStudyCaseXmlType xmlCase = dstabRec.getDStabStudyCase(); 
					if (xmlCase == null) {
						if (xmlDefaultCase == null) {
							msg.sendErrorMsg("No DStab case defined");
							return false;
						}
						xmlCase = xmlDefaultCase;
					}
					if (!configDStaAlgo(dstabAlgo, dstabRec, msg))
						return false;

					// net.id is used to retrieve study case info at remote
					// node. so we need to sure net.id and studyCase.id are
					// the same for Grid computing.
					net.setId(dstabRec.getRecId());
					try {
						StudyCase studyCase = SimuObjectFactory
								.createStudyCase(dstabRec.getRecId(),
										dstabRec.getRecName(), ++cnt,
										mCaseContainer);
						if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
							// if Grid computing, save the net and algo objects
							// to the study case object
							studyCase.setNetModelString(SerializeEMFObjectUtil
									.saveModel(net));
							studyCase
									.setAclfAlgoModelString(SerializeEMFObjectUtil
											.saveModel(dstabAlgo
													.getAclfAlgorithm()));
							studyCase
									.setDstabAlgoModelString(SerializeEMFObjectUtil
											.saveModel(dstabAlgo));
							msgRouter.addDStabSimuDbOutputHandler(dstabAlgo
									.getSimuOutputHandler());
						} else {
							// if not grid computing, perform DStab run
							runLocalDStabRun(dstabAlgo, xmlCase, msg);
							studyCase.setDesc("DStab by Local Node");
						}
					} catch (Exception e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Study Case Creation Error",
										e.toString());
						return false;
					}
				}

				if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					try {
						Object[] objAry = (Object[]) IpssGridGainUtil
								.performGridTask(
										grid,
										"InterPSS Transient Stability Simulation",
										mCaseContainer, parser.getRunStudyCase()
												.getGridRun().getTimeout());
						for (Object obj : objAry) {
							if (!((Boolean) obj).booleanValue()) {
								SpringAppContext
										.getEditorDialogUtil()
										.showWarnMsgDialog("Grid DStab Error",
												"Please check InterPSS log file for details");
								return false;
							}
						}
					} catch (GridException e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Grid DStab Error",
										e.toString());
						return false;
					}
				}
				// init the Net object for plotting purpose.
				dstabNet.initialization(msg);
				// set the DStabNet object back to the SimuCtx
				simuCtx.setDStabilityNet(dstabNet);
			}
		} else {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", "runDStabStudyCase element not defined");
			return false;
		}
		return true;
	}

	private static boolean configDStaAlgo(DynamicSimuAlgorithm dstabAlgo,
			DStabStudyCaseRec dstabRec, IPSSMsgHub msg) {
		// map the Xml study case data to dstabAlgo, including modification to
		// the network model data
		IpssMapper mapper = PluginSpringAppContext
				.getRunForm2AlgorithmMapper();
		mapper.mapping(dstabRec, dstabAlgo, DStabStudyCaseXmlType.class);
		if (!RunActUtilFunc.checkDStabSimuData(dstabAlgo, msg))
			return false; // if something is wrong, we stop running here

		// create a DB handler to store simulation result, a Db simu case will
		// be created if not existed.
		// to get db case id: dstabDbHandler.getDBCaseId()
		IDStabSimuDatabaseOutputHandler dstabDbHandler = RunActUtilFunc
				.createDBOutputHandler(dstabAlgo, dstabRec);
		if (dstabDbHandler == null)
			return false;

		// correlate net.id, case.id and dbCaseId
		dstabAlgo.getDStabNet().setId(dstabRec.getRecId());
		SpringAppContext.getSimuRecManager().addDBCaseId(dstabRec.getRecId(), dstabDbHandler
				.getDBCaseId());

		// transfer output variable filter info to the DStabAlgo object, which
		// then
		// will be carried by the object to the remote grid node, in case of
		// grid computing
		dstabDbHandler.setOutputFilter(dstabAlgo.isOutputFilted());
		if (dstabDbHandler.isOutputFilter())
			dstabDbHandler.setOutputVarIdList(StringUtil
					.convertStrAry2StrList(dstabAlgo.getOutputVarIdList()));

		// set the DB handler to the algo object
		dstabAlgo.setSimuOutputHandler(dstabDbHandler);
		return true;
	}

	private static boolean runLocalDStabRun(DynamicSimuAlgorithm dstabAlgo,
			DStabStudyCaseXmlType dstabCase, IPSSMsgHub msg) {
		dstabAlgo.getDStabNet().setNetChangeListener(
				CoreSpringAppContext.getNetChangeHandler());

		LoadflowAlgorithm aclfAlgo = dstabAlgo.getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
		if (dstabCase.getDiaplaySummary())
			RunActUtilFunc.displayAclfSummaryResult(dstabAlgo);
		if (!dstabAlgo.getDStabNet().isLfConverged()) {
			msg
					.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
			return false;
		}

		if (dstabAlgo.initialization(msg)) {
			dstabAlgo.performSimulation(msg);
		}
		return true;
	}
}
