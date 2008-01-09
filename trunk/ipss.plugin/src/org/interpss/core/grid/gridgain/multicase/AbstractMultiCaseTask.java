 /*
  * @(#)AbstractAssignJob2NodeTask.java   
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

package org.interpss.core.grid.gridgain.multicase;

/**
 *  An abstract GridTask for implement one node per task. The job will be assigned to
 *  the node identified by the nodeId attribute.  
 */

import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.GridTaskSplitAdapter;
import org.gridgain.grid.resources.GridTaskSessionResource;

import com.interpss.common.datatype.Constants;
import com.interpss.core.ms_case.MultiStudyCase;

public abstract class AbstractMultiCaseTask extends GridTaskSplitAdapter<MultiStudyCase> {
	private static final long serialVersionUID = 1;
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;	
    
	// Master node id
	public static String MasterNodeId = "";

	protected GridTaskSession getSession() {
		return this.session;
	}
	
	@Override
	protected Collection<? extends GridJob> split(int gridSize, MultiStudyCase model) throws GridException {
        // Send master node id to all remote nodes.
        getSession().setAttribute(Constants.GridToken_MasterNodeId, MasterNodeId);
        
        return null;
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
