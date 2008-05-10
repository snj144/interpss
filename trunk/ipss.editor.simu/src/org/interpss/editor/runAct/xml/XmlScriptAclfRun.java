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
import org.interpss.gridgain.job.IpssGridGainAclfJob;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AclfRuleBaseXmlType;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.GridComputingXmlType;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.GridComputingXmlType.AclfOption.ReturnStudyCase;
import org.interpss.xml.PreventiveRuleHanlder;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.ReturnRemoteCaseOpt;
import com.interpss.simu.multicase.aclf.AclfMultiStudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class XmlScriptAclfRun {
	public static double DefaultUpperVoltageLimit = 1.2, DefaultLowerVoltageLimit = 0.8; 
	
	/**
	 * Run Aclf run or run(s) defined in the Xml scripts
	 * 
	 * @param parser The InterPSS xml parser object
	 * @param aclfNet
	 * @param msg
	 * @return
	 */
	public static boolean runAclf(InterPSSXmlType ipssXmlDoc, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		RunStudyCaseXmlType.RunAclfStudyCase xmlRunCase = ipssXmlDoc.getRunStudyCase().getRunAclfStudyCase();
		boolean applyRuleBase = ipssXmlDoc.getRunStudyCase().getApplyRuleBase();

		if (xmlRunCase != null) {
			AclfAlgorithmXmlType xmlDefaultAlgo = xmlRunCase.getDefaultAclfAlgorithm(); 
			AclfRuleBaseXmlType ruleBase = xmlRunCase.getAclfRuleBase();
			boolean gridRun = RunActUtilFunc.isGridEnabled(ipssXmlDoc.getRunStudyCase());
			long  timeout = ipssXmlDoc.getRunStudyCase().getGridRun().getTimeout();
			
			if (xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray().length == 1) {
				AclfStudyCaseXmlType xmlCase = xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray()[0];
				if (!aclfSingleRun(aclfNet, xmlCase, xmlDefaultAlgo, ruleBase, 
						applyRuleBase, gridRun, timeout, msg));
					return false;
			} 
			else {
				IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
				AclfMultiStudyCase mCaseContainer = SimuObjectFactory.createAclfMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
				// save the base case Network model to the netStr
				mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(aclfNet));

				if (applyRuleBase) {
					mCaseContainer.getRuleBase().setApplyAclfRuleBase(applyRuleBase);
					if (xmlRunCase.getAclfRuleBase() != null)
						mCaseContainer.getRuleBase().setAclfRuleBaseXmlString(xmlRunCase.getAclfRuleBase().xmlText());
				}
				
				boolean reJobCreation = ipssXmlDoc.getRunStudyCase().getGridRun().getRemoteJobCreation() && gridRun;
				
				int cnt = 0;
				for (AclfStudyCaseXmlType xmlCase : xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray()) {
					// deserialize the base case, if necessary
					AclfAdjNetwork net = aclfNet;
					if (!gridRun || !reJobCreation) 
						// only deserialized the network if not the case of remote job creation
						net = (AclfAdjNetwork) SerializeEMFObjectUtil.loadModel(mCaseContainer.getBaseNetModelString());

					LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
					// map to the Algo object including network modification at the study case level
					if (!mapAclfStudyCase(mapper, xmlCase, algo, xmlDefaultAlgo, reJobCreation, msg))
						return false;

					try {
						AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase(xmlCase.getRecId(), 
										xmlCase.getRecName(), ++cnt, mCaseContainer);
						if (gridRun) {
							// if Grid computing, save the Algo object to the study case object
							studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));
							if (reJobCreation)
								if (xmlCase.getModification() != null)
									// persist modification to be sent to the remote grid node
									studyCase.setModifyModelString(xmlCase.getModification().xmlText());
						} else {
							// if not grid computing, perform Loadflow for the study case
							algo.loadflow(msg);
							if (applyRuleBase) {
								PreventiveRuleHanlder.applyAclfRuleSet(algo, ruleBase, DefaultUpperVoltageLimit, DefaultLowerVoltageLimit, msg);
							}
							studyCase.setDesc("Loadflow by Local Node");
							studyCase.setRemoteReturnStatus(true);
							studyCase.setAclfConverged(algo.getAclfAdjNetwork().isLfConverged());
						}
						studyCase.setId(xmlCase.getRecId());
						studyCase.setName(xmlCase.getRecDesc());
						if (!gridRun || !reJobCreation) {
							net.setId(xmlCase.getRecId());
							// persist the AclfNet object to study case. It contains case level modification for
							// grid computing when remoteJobCreation = false.
							// in the case of non grid computing, it contains Loadflow results
							studyCase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
						}
					} catch (Exception e) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Study Case Creation Error",
										e.toString());
						return false;
					}
				}

				// if Grid computing, send the MultiCase container to perform
				// remote grid computing
				if (gridRun) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId().toString();
					
					setAclfRunOpt(mCaseContainer, ipssXmlDoc.getRunStudyCase());
					
					try {
						RemoteMessageTable[] objAry = IpssGridGainUtil.performMultiGridTask(grid,
										"InterPSS Grid Aclf Calculation", mCaseContainer, 
										timeout,	reJobCreation);
						for (RemoteMessageTable result : objAry) {
							IRemoteResult resultHandler = RemoteResultFactory.createHandler(IpssGridGainAclfJob.class);
							resultHandler.transferRemoteResult(mCaseContainer, result);
						}
					} catch (GridException e) {
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error",	e.toString());
						return false;
					} 
				}

				// display the simulation results
				IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
				dialog.display(mCaseContainer);
			}
		} else {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", "runAclfStudyCase element not defined");
			return false;
		}
		return true;
	}

	private static boolean aclfSingleRun(AclfAdjNetwork aclfNet, AclfStudyCaseXmlType xmlCase, AclfAlgorithmXmlType xmlDefaultAlgo, 
				AclfRuleBaseXmlType ruleBase, boolean applyRuleBase, boolean gridRun, long timeout, IPSSMsgHub msg) {
		IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(aclfNet);
		if (!mapAclfStudyCase(mapper, xmlCase, algo, xmlDefaultAlgo, false, msg))
			return false;

		if (gridRun) {
			Grid grid = IpssGridGainUtil.getDefaultGrid();
			AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil.getAnyRemoteNodeId();
			IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId().toString();
			try {
				RemoteMessageTable result = IpssGridGainUtil.performGridTask(
						grid, "InterPSS Grid Aclf Calculation", algo, timeout);
				String str = result.getSerializedAclfNet();
				aclfNet = (AclfAdjNetwork) SerializeEMFObjectUtil.loadModel(str);
			} catch (GridException e) {
				SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error", e.toString());
				return false;
			}
		} else {
			algo.loadflow(msg);
			if (applyRuleBase) {
				PreventiveRuleHanlder.applyAclfRuleSet(algo, ruleBase, DefaultUpperVoltageLimit, DefaultLowerVoltageLimit, msg);
			}
		}

		if (xmlCase.getAclfAlgorithm().getDiaplaySummary()) {
			IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
			dialog.display(aclfNet);
		}
		return true;
	}
	
	public static boolean mapAclfStudyCase(IpssMapper mapper, AclfStudyCaseXmlType xmlCase, 
						LoadflowAlgorithm algo, AclfAlgorithmXmlType xmlDefaultAlgo, 
						boolean remoteJobCreation, IPSSMsgHub msg) {
		if (xmlCase.getAclfAlgorithm() == null) {
			if (xmlDefaultAlgo == null) {
				msg.sendErrorMsg("No Aclf Algorithm defined");
				return false;
			}
			xmlCase.setAclfAlgorithm(xmlDefaultAlgo);
		}
		if (xmlCase.getModification() != null && !remoteJobCreation)
			mapper.mapping(xmlCase.getModification(), algo.getAclfAdjNetwork(), ModificationXmlType.class);
		mapper.mapping(xmlCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		
		return true;
	}
	
	private static void setAclfRunOpt(AclfMultiStudyCase mCaseContainer, RunStudyCaseXmlType runCase) {
		mCaseContainer.setRemoteJobCreation(runCase.getGridRun().getRemoteJobCreation());
		if (runCase.getGridRun().getAclfOption() != null) {
			GridComputingXmlType.AclfOption opt = runCase.getGridRun().getAclfOption();
			mCaseContainer.getAclfGridOption().setReturnCase(
					opt.getReturnStudyCase()==ReturnStudyCase.ALL_STUDY_CASE? ReturnRemoteCaseOpt.ALL_STUDY_CASE :
						(opt.getReturnStudyCase()==ReturnStudyCase.DIVERGED_CASE? ReturnRemoteCaseOpt.DIVERGED_CASE :
							ReturnRemoteCaseOpt.NO_STUDY_CASE));
			mCaseContainer.getAclfGridOption().setCalculateViolation(opt.getCalculateViolation());
			if (opt.getBusVoltagePULimit() != null) {
				mCaseContainer.getAclfGridOption().setBusVoltageUpperLimitPU(opt.getBusVoltagePULimit().getMax());
				mCaseContainer.getAclfGridOption().setBusVoltageLowerLimitPU(opt.getBusVoltagePULimit().getMin());
			}
		}		
	}
}
