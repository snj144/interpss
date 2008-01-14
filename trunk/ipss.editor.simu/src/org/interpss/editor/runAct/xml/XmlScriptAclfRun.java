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
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
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
	public static boolean runAclf(IpssXmlParser parser,
			AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		IpssMapper mapper = SimuAppSpringAppContext
				.getRunForm2AlgorithmMapper();
		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase();

		if (parser.getRunAclfStudyCaseList().length > 0) {
			if (parser.getRunAclfStudyCaseList().length == 1) {
				RunAclfStudyCaseXmlType aclfCase = parser
						.getRunAclfStudyCaseList()[0];

				LoadflowAlgorithm algo = CoreObjectFactory
						.createLoadflowAlgorithm(aclfNet);
				mapper.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);

				if (IpssGridGainUtil.isGridEnabled()
						&& xmlStudyCase.getEnableGridRun()) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					AssignJob2NodeDStabTask.RemoteNodeId = IpssGridGainUtil
							.getAnyRemoteNodeId();
					IpssGridGainUtil.MasterNodeId = grid
							.getLocalNode().getId().toString();
					try {
						String str = (String) IpssGridGainUtil.performGridTask(
								grid, "InterPSS Grid Aclf Calculation", algo,
								xmlStudyCase.getGridTimeout());
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

				if (aclfCase.getDiaplaySummary()) {
					IOutputTextDialog dialog = UISpringAppContext
							.getOutputTextDialog("Loadflow Analysis Info");
					dialog.display(aclfNet);
				}
			} else {
				// save the base case Network model to the netStr
				String netStr = SerializeEMFObjectUtil.saveModel(aclfNet);
				// create a multi-case container
				MultiStudyCase mCaseContainer = SimuObjectFactory
						.createMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
				int cnt = 0;
				for (RunAclfStudyCaseXmlType aclfCase : parser
						.getRunAclfStudyCaseList()) {
					// deserialize the base case
					AclfAdjNetwork net = (AclfAdjNetwork) SerializeEMFObjectUtil
							.loadModel(netStr);
					LoadflowAlgorithm algo = CoreObjectFactory
							.createLoadflowAlgorithm(net);
					// map to the Algo object including network modification at
					// case level
					mapper.mapping(aclfCase, algo,
							RunAclfStudyCaseXmlType.class);

					// net.id is used to retrieve study case info at remote
					// node. so we need to
					// sure net.id and studyCase.id are the same for Grid
					// computing.
					net.setId(aclfCase.getRecId());
					try {
						StudyCase studyCase = SimuObjectFactory
								.createStudyCase(aclfCase.getRecId(), aclfCase
										.getRecName(), ++cnt, mCaseContainer);
						if (IpssGridGainUtil.isGridEnabled()
								&& xmlStudyCase.getEnableGridRun()) {
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
				if (IpssGridGainUtil.isGridEnabled()
						&& xmlStudyCase.getEnableGridRun()) {
					Grid grid = IpssGridGainUtil.getDefaultGrid();
					IpssGridGainUtil.MasterNodeId = grid
							.getLocalNode().getId().toString();
					try {
						Object[] objAry = (Object[]) IpssGridGainUtil
								.performGridTask(grid,
										"InterPSS Grid Aclf Calculation",
										mCaseContainer, xmlStudyCase
												.getGridTimeout());
						for (Object obj : objAry) {
							String str = (String) obj;
							// deserialize the AclfNet model string for Net.id
							AclfAdjNetwork net = (AclfAdjNetwork) SerializeEMFObjectUtil
									.loadModel(str);
							// update StudyCase AclfNet model string from the
							// result coming back from remote node.
							StudyCase studyCase = mCaseContainer
									.getStudyCase(net.getId());
							studyCase.setNetModelString(str);
							studyCase.setDesc("Loadflow by Remote Node: "
									+ IpssGridGainUtil.nodeNameLookup(net
											.getDesc()));
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
}
