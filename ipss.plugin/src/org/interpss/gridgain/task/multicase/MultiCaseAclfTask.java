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

package org.interpss.gridgain.task.multicase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.interpss.gridgain.job.IpssGridGainAclfJob;

import com.interpss.common.datatype.Constants;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class MultiCaseAclfTask extends AbstractMultiCaseTask {
	private static final long serialVersionUID = 1;

	/**
	 * create a list jobs for remote node. The job will be assigned to the remote node randomly.
	 */
	@Override
	protected Collection<? extends GridJob> split(int gridSize,
			MultiStudyCase model) throws GridException {
		// Send master node id to all remote nodes.
		getSession().setAttribute(Constants.GridToken_MasterNodeId,
				MasterNodeId);

		List<IpssGridGainAclfJob> jobList = new ArrayList<IpssGridGainAclfJob>();
		for (StudyCase studyCase : model.getStudyCaseList()) {
			// send the Aclf Net model (String) the remote node directly
			IpssGridGainAclfJob job = new IpssGridGainAclfJob(studyCase
					.getNetModelString());

			// send the AclfAlgo string to the remote node through the task session
			// net.getId is used as the id for retrieving StudyCase info
			getSession().setAttribute(
					Constants.GridToken_AclfAlgo + studyCase.getId(),
					studyCase.getAclfAlgoModelString());

			jobList.add(job);
		}
		return jobList;
	}
}
