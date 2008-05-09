/*
 * @(#)XmlScriptContingency.java   
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
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.secass.ContingencyAnaysisJob;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.ContingencyAnalysisXmlType;
import org.interpss.schema.InterPSSXmlType;

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
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class XmlScriptContingency {
	public static long GridgainTimeout = 0; 
	
	/**
	 * Run Aclf run or run(s) defined in the Xml scripts
	 * 
	 * @param ipssXmlDoc The InterPSS xml doc object
	 * @param aclfNet
	 * @param msg
	 * @return
	 */
	public static boolean runAclf(InterPSSXmlType ipssXmlDoc, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		ContingencyAnalysisXmlType xmlRunCase = ipssXmlDoc.getRunStudyCase().getContingencyAnalysis();
		if (xmlRunCase == null) {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", "runAclfStudyCase element not defined");
			return false;
		}
		
		ContingencyAnalysis mCaseContainer = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, aclfNet);
		// save the base case Network model to the netStr
		mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(aclfNet));

		int cnt = 0;
		for (AclfStudyCaseXmlType xmlCase : xmlRunCase.getAclfStudyCaseList().getAclfStudyCaseArray()) {
			LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(aclfNet);
			// map to the Algo object including network modification at the study case level
			IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
			if (!XmlScriptAclfRun.mapAclfStudyCase(mapper, xmlCase, algo, 
					xmlRunCase.getDefaultAclfAlgorithm(), true, msg))
				return false;

			try {
				AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase(xmlCase.getRecId(), 
										xmlCase.getRecName(), ++cnt, mCaseContainer);
				studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));
				if (xmlCase.getModification() != null)
					// persist modification to be sent to the remote grid node
					studyCase.setModifyModelString(xmlCase.getModification().xmlText());
				studyCase.setId(xmlCase.getRecId());
				studyCase.setName(xmlCase.getRecDesc());

				Grid grid = IpssGridGainUtil.getDefaultGrid();
				IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId().toString();
					
				RemoteMessageTable[] objAry = IpssGridGainUtil.performMultiGridTask(grid,
										"InterPSS Grid Aclf Calculation", mCaseContainer, 
										GridgainTimeout, true);
				for (RemoteMessageTable result : objAry) {
					IRemoteResult resultHandler = RemoteResultFactory.createHandler(ContingencyAnaysisJob.class);
					resultHandler.transferAclfResult(mCaseContainer, result);
				}
			} catch (GridException e) {
				SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error",	e.toString());
				return false;
			} catch (Exception e) {
				SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Study Case Creation Error", e.toString());
				return false;
			}
		}
			
		// display the simulation results
		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Contingency Analysis");
		dialog.display(mCaseContainer);
		return true;
	}
}
