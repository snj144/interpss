/*
 * @(#)AbstractMultiCaseTask.java   
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

package org.interpss.gridgain.task.multicase;

/**
 *  An abstract GridTask for implement multiple study cases. 
 */

import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.GridTaskSplitAdapter;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.gridgain.job.AbstractIpssGridGainJob;
import org.interpss.gridgain.result.RmoteResultTable;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.datatype.Constants;
import com.interpss.simu.multicase.MultiStudyCase;

public abstract class AbstractMultiCaseTask extends
		GridTaskSplitAdapter<MultiStudyCase> {
	private static final long serialVersionUID = 1;

	/** Grid task session will be injected. */
	@GridTaskSessionResource
	private GridTaskSession session = null;

	protected GridTaskSession getSession() {
		return this.session;
	}

	/**
	 * create a list jobs for remote node. The job will be assigned to the remote node randomly.
	 */
	@Override
	protected Collection<? extends GridJob> split(int gridSize,
			MultiStudyCase model) throws GridException {
		// Send master node id to all remote nodes.
		getSession().setAttribute(Constants.GridToken_MasterNodeId,
				IpssGridGainUtil.MasterNodeId);
		getSession().setAttribute(Constants.GridToken_RemoteNodeDebug,
				new Boolean(IpssGridGainUtil.RemoteNodeDebug));

		return createRemoteJobList(model);
	}

	/**
	 * create remote job list. The method needs to be implemented by the subclass
	 * 
	 * @param model
	 * @return
	 * @throws GridException
	 */
	abstract protected List<? extends AbstractIpssGridGainJob> createRemoteJobList(MultiStudyCase model) throws GridException;
	
	/**
	 * Multiple study case, return a String array
	 */
	@Override
	public Object reduce(List<GridJobResult> results) throws GridException {
		RmoteResultTable[] objList = new RmoteResultTable[results.size()];
		int cnt = 0;
		for (GridJobResult result : results) {
			objList[cnt++] = (RmoteResultTable)result.getData();
		}
		return objList;
	}
}
