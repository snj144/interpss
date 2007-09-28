 /*
  * @(#)IpssGridGainTask.java   
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

package org.interpss.core.grid.gridgain;

import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.GridTaskSplitAdapter;
import org.gridgain.grid.resources.GridTaskSessionResource;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCaseCreationType;

public class IpssGridGainTask extends GridTaskSplitAdapter<GridMultiStudyCase> {
	private static final long serialVersionUID = 1;
	
	public static final String Token_CreationType = "creationType";
	public static final String Token_RefNetwork = "refNetwork";
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;	

	@Override
	protected Collection<? extends GridJob> split(int gridSize, GridMultiStudyCase model) throws GridException {
		session.setAttribute(Token_CreationType, model.getCaseCreationType());
		if (model.getCaseCreationType() == StudyCaseCreationType.DISTRIBUTED_CREATION) {
			// for distributed study case creation, the ref network is sent to remote node for case creation
			session.setAttribute(Token_RefNetwork, SerializeEMFObjectUtil.saveModel(model.getNetwork()));
		}
		return model.getGridJobs();
     }

	@Override
	public Object reduce(List<GridJobResult> results) throws GridException {
		Object[] objList = new Object[results.size()];
		int cnt = 0;
		for (GridJobResult result : results) {
			objList[cnt++] = result.getData();
		}
		return objList;
	}
}
