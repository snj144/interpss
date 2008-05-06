/*
 * @(#)AssignJob2NodeAclfTask.java   
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
 * @Date 09/15/2007
 * 
 *   Revision History
 *   ================
 *
 */

/*
 *  This Class is for performing grid computing on the GridMultiStudyCase model 
 */

package org.interpss.gridgain.task.multicase;

import java.util.ArrayList;
import java.util.List;

import org.gridgain.grid.GridException;
import org.interpss.gridgain.job.IpssGridGainDStabJob;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.util.IpssLogger;
import com.interpss.ext.gridgain.AbstractIpssGridGainJob;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class MultiCaseDStabTask extends AbstractMultiCaseTask {
	private static final long serialVersionUID = 1;

	/**
	 * create remote job list for DStab run
	 */
	protected List<? extends AbstractIpssGridGainJob> createRemoteJobList(MultiStudyCase model) throws GridException {
		List<IpssGridGainDStabJob> jobList = new ArrayList<IpssGridGainDStabJob>();
		for (StudyCase studyCase : model.getStudyCaseList()) {
			IpssGridGainDStabJob job = createJob(studyCase, model);
			jobList.add(job);
		}
		return jobList;
	}
	
	private IpssGridGainDStabJob createJob(StudyCase studyCase, MultiStudyCase model) throws GridException {
		// send the Net model (String) the remote node directly
		RemoteMessageTable remoteMsg = new RemoteMessageTable();
		if (model.isRemoteJobCreation()) {
			remoteMsg.put(RemoteMessageTable.KEY_sInOut_StudyCaseId, studyCase.getId());
		}
		else {
			remoteMsg.put(RemoteMessageTable.KEY_sIn_StudyCaseNetworkModel, studyCase.getNetModelString());
		}
		remoteMsg.put(RemoteMessageTable.KEY_sIn_AclfAlgorithm, studyCase.getAclfAlgoModelString());
		remoteMsg.put(RemoteMessageTable.KEY_sIn_DStabAlgorithm, studyCase.getDstabAlgoModelString());
		IpssGridGainDStabJob job = new IpssGridGainDStabJob(remoteMsg);
		
		if (IpssGridGainUtil.RemoteNodeDebug) {
			IpssLogger.getLogger().info("CaseId: " + studyCase.getId());
			IpssLogger.getLogger().info("Model String: " + studyCase.getNetModelString());
			IpssLogger.getLogger().info("AclfAlgo String: "	+ studyCase.getAclfAlgoModelString());
			IpssLogger.getLogger().info("DStabAlgo String: " + studyCase.getDstabAlgoModelString());
		}	
		return job;
	}
	
}
