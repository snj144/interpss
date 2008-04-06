/*
 * @(#)XmlScriptAclfRun.java   
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
import org.interpss.editor.runAct.RunActUtilFunc;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.result.RmoteResultTable;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class XmlScriptAclfRun {
	/**
	 * Run Aclf run or run(s) defined in the Xml scripts
	 * 
	 * @param parser The InterPSS xml parser object
	 * @param aclfNet
	 * @param msg
	 * @return
	 */
	public static boolean runAclf(IpssXmlParser parser, AclfAdjNetwork aclfNet,
			IPSSMsgHub msg) {
		IpssMapper mapper = PluginSpringAppContext
				.getRunForm2AlgorithmMapper();
		RunStudyCaseXmlType.RunAclfStudyCase xmlRunCase = parser.getRunAclfStudyCase();

		if (xmlRunCase != null) {
			AclfAlgorithmXmlType xmlDefaultAlgo = xmlRunCase.getDefaultAclfAlgorithm(); 
			
			if (xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray().length == 1) {
				AclfStudyCase xmlCase = xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray()[0];

				LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(aclfNet);
				if (!mapAclfStudy(mapper, xmlCase, algo, xmlDefaultAlgo, msg))
					return false;

				if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil
							.getAnyRemoteNodeId();
					IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId()
							.toString();
					try {
						RmoteResultTable result = IpssGridGainUtil.performGridTask(
								grid, "InterPSS Grid Aclf Calculation", algo,
								parser.getRunStudyCase().getGridRun().getTimeout());
						String str = result.getSerializedAclfNet();
						aclfNet = (AclfAdjNetwork) SerializeEMFObjectUtil
								.loadModel(str);
					} catch (GridException e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Grid Aclf Error",
										e.toString());
						return false;
					}
				} else {
					algo.loadflow(msg);
				}

				if (xmlCase.getAclfAlgorithm().getDiaplaySummary()) {
					IOutputTextDialog dialog = UISpringAppContext
							.getOutputTextDialog("Loadflow Analysis Info");
					dialog.display(aclfNet);
				}
			} else {
				MultiStudyCase mCaseContainer = SimuObjectFactory
						.createMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
				// save the base case Network model to the netStr
				mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(aclfNet));
				
				int cnt = 0;
				for (AclfStudyCase xmlCase : xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray()) {
					// deserialize the base case
					AclfAdjNetwork net = (AclfAdjNetwork) SerializeEMFObjectUtil
							.loadModel(mCaseContainer.getBaseNetModelString());
					LoadflowAlgorithm algo = CoreObjectFactory
							.createLoadflowAlgorithm(net);
					// map to the Algo object including network modification at
					// case level
					if (!mapAclfStudy(mapper, xmlCase, algo, xmlDefaultAlgo, msg))
						return false;

					// net.id is used to retrieve study case info at remote
					// node. so we need to
					// sure net.id and studyCase.id are the same for Grid
					// computing.
					net.setId(xmlCase.getRecId());
					try {
						StudyCase studyCase = SimuObjectFactory
								.createStudyCase(xmlCase.getRecId(), xmlCase
										.getRecName(), ++cnt, mCaseContainer);
						if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
							// if Grid computing, save the Algo object to the
							// study case object
							studyCase
									.setAclfAlgoModelString(SerializeEMFObjectUtil
											.saveModel(algo));
						} else {
							// if not grid computing, perform Loadflow
							algo.loadflow(msg);
							studyCase.setDesc("Loadflow by Local Node");
						}
						// persist the AclfNet object to study case. It contains
						// case level modification
						// in the case of non grid computing, it contains
						// Loadflow results
						studyCase.setName(xmlCase.getRecDesc());
						studyCase.setNetModelString(SerializeEMFObjectUtil
								.saveModel(net));
					} catch (Exception e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Study Case Creation Error",
										e.toString());
						return false;
					}
				}

				// if Grid computing, send the MultiCase container to perform
				// remote grid computing
				if (RunActUtilFunc.isGridEnabled(parser.getRunStudyCase())) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId().toString();
					
					setAclfRunOpt(mCaseContainer, parser.getRunStudyCase());
					
					try {
						RmoteResultTable[] objAry = IpssGridGainUtil.performMultiGridTask(grid,
										"InterPSS Grid Aclf Calculation", mCaseContainer, 
										parser.getRunStudyCase().getGridRun().getTimeout(),
										parser.getRunStudyCase().getGridRun().getRemoteJobCreation());
						for (RmoteResultTable result : objAry) {
							IRemoteResult resultHandler = RemoteResultFactory.createRemoteResultHandler();
							resultHandler.transferAclfResult(mCaseContainer, result);
						}
					} catch (GridException e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Grid Aclf Error",
										e.toString());
						return false;
					} 
				}

				IOutputTextDialog dialog = UISpringAppContext
						.getOutputTextDialog("Loadflow Analysis Info");
				dialog.display(mCaseContainer);
			}
		} else {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", "runAclfStudyCase element not defined");
			return false;
		}
		return true;
	}

	private static boolean mapAclfStudy(IpssMapper mapper, AclfStudyCase xmlCase, 
						LoadflowAlgorithm algo, AclfAlgorithmXmlType xmlDefaultAlgo, IPSSMsgHub msg) {
		if (xmlCase.getAclfAlgorithm() == null) {
			if (xmlDefaultAlgo == null) {
				msg.sendErrorMsg("No Aclf Algorithm defined");
				return false;
			}
			xmlCase.setAclfAlgorithm(xmlDefaultAlgo);
		}
		if (xmlCase.getModification() != null)
			mapper.mapping(xmlCase.getModification(), algo.getAclfAdjNetwork(), ModificationXmlType.class);
		mapper.mapping(xmlCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		
		return true;
	}
	
	private static void setAclfRunOpt(MultiStudyCase mCaseContainer, RunStudyCaseXmlType runCase) {
		mCaseContainer.setRemoteJobCreation(runCase.getGridRun().getRemoteJobCreation());
		if (runCase.getGridRun().getAclfOption() != null) {
			RunStudyCaseXmlType.GridRun.AclfOption opt = runCase.getGridRun().getAclfOption();
			mCaseContainer.getAclfGridOption().setReturnOnlyViolationCase(opt.getReturnOnlyViolationCase());
			mCaseContainer.getAclfGridOption().setCalBranchLimitViolation(opt.getCalBranchLimitViolation());
			mCaseContainer.getAclfGridOption().setCalBusVoltageViolation(opt.getCalBusVoltageViolation());
			mCaseContainer.getAclfGridOption().setBusVoltageUpperLimitPU(opt.getBusVoltagePULimit().getMax());
			mCaseContainer.getAclfGridOption().setBusVoltageLowerLimitPU(opt.getBusVoltagePULimit().getMin());
		}		
	}
}
