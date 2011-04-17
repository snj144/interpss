/*
 * @(#)AclfMultiJobTask.java   
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

package org.interpss.sample.grid.impl.multi;

import org.gridgain.grid.GridException;
import org.interpss.grid.gridgain.GridConstants;
import org.interpss.grid.gridgain.job.AbstractGridGainJob;
import org.interpss.grid.gridgain.task.multiJob.AbstractMultiJobTask;
import org.interpss.grid.msg.RemoteMessageTable;

import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;
import com.interpss.simu.multicase.aclf.AclfMultiStudyCase;

public class CustomMultiLocalTask extends AbstractMultiJobTask {
	private static final long serialVersionUID = 1;

	// this method is called at the beginning of grid computing
	@Override
	protected void setMultiCaseContext(MultiStudyCase model) throws GridException {
		AclfMultiStudyCase aclfModel = (AclfMultiStudyCase)model;

		// use grid session to sent network model to the remote node at the
		// starting of calculation
		getSession().setAttribute(GridConstants.Key_RemoteJobCreation, Boolean.TRUE);
		getSession().setAttribute(GridConstants.Key_BaseStudyCaseNetworkModel, aclfModel.getBaseNetModelString());
	}

	// this method is called to send a study case from the master node to a slave grid node
	@Override
	protected RemoteMessageTable serializeStudyCaseModel(StudyCase scase, MultiStudyCase model) throws GridException {
		RemoteMessageTable remoteMsg = new RemoteMessageTable();
		remoteMsg.put(RemoteMessageTable.KEY_sRqtRsp_StudyCaseId, scase.getId());
		// use the any string field to send the graph xml to the remote node
		remoteMsg.put(RemoteMessageTable.KEY_sRqt_StudyCaseModification, scase.getModification().getAny());
		return remoteMsg;
	}
	
	@Override
	protected AbstractGridGainJob createStudyCaseJob(RemoteMessageTable remoteMsg) {
		return new CustomMultiRemoteJob(remoteMsg);
	}
}
