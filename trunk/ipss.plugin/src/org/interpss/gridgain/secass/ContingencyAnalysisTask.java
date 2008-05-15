/*
 * @(#)MultiCaseAclfTask.java   
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

/*
 *  This Class is for performing grid computing on the GridMultiStudyCase model 
 */

package org.interpss.gridgain.secass;

import java.util.ArrayList;
import java.util.List;

import org.gridgain.grid.GridException;
import org.interpss.gridgain.task.multicase.AbstractMultiCaseTask;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.ext.gridgain.AbstractIpssGridGainJob;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class ContingencyAnalysisTask extends AbstractMultiCaseTask {
	private static final long serialVersionUID = 1;

	protected List<? extends AbstractIpssGridGainJob> createRemoteJobList(MultiStudyCase model) throws GridException {
		setTaskSessionAttributes((ContingencyAnalysis)model);
		
		List<ContingencyAnaysisJob> jobList = new ArrayList<ContingencyAnaysisJob>();
		for (StudyCase studyCase : model.getStudyCaseList()) {
			ContingencyAnaysisJob job = createJob((AclfStudyCase)studyCase, (ContingencyAnalysis)model);
			jobList.add(job);
		}
		return jobList;
	}
	
	private void setTaskSessionAttributes(ContingencyAnalysis model) throws GridException {
		getSession().setAttribute(Constants.GridToken_BaseStudyCaseNetworkModel, model.getBaseNetModelString());

		getSession().setAttribute(Constants.GridToken_BusVoltageUpperLimitPU, new Double(model.getBusVoltageUpperLimitPU()));
		getSession().setAttribute(Constants.GridToken_BusVoltageLowerLimitPU, new Double(model.getBusVoltageLowerLimitPU()));
		
		// send protective rule set
		getSession().setAttribute(Constants.GridToken_ApplyRuleBase, 
							model.getRuleBase().isApplyRuleBase()?Boolean.TRUE : Boolean.FALSE);
		if (model.getRuleBase().isApplyRuleBase())
			getSession().setAttribute(Constants.GridToken_RuleBaseXml, model.getRuleBase().getRuleBaseXmlString());
	}

	private ContingencyAnaysisJob createJob(AclfStudyCase studyCase, ContingencyAnalysis model) throws GridException {
		// send the Aclf Net model (String) the remote node directly
		RemoteMessageTable remoteMsg = new RemoteMessageTable();
		remoteMsg.put(RemoteMessageTable.KEY_sInOut_StudyCaseId, studyCase.getId());
		if (studyCase.getModifyModelString() != null) {
			remoteMsg.put(RemoteMessageTable.KEY_sIn_StudyCaseModification, studyCase.getModifyModelString());
		}
		remoteMsg.put(RemoteMessageTable.KEY_sIn_AclfAlgorithm, studyCase.getAclfAlgoModelString());

		if (IpssGridGainUtil.RemoteNodeDebug) {
			IpssLogger.getLogger().info("CaseId: " + studyCase.getId());
			IpssLogger.getLogger().info("Model String: " + studyCase.getNetModelString());
			IpssLogger.getLogger().info("AclfAlgo String: " + studyCase.getAclfAlgoModelString());
		}
		
		return new ContingencyAnaysisJob(remoteMsg);
	}
}
