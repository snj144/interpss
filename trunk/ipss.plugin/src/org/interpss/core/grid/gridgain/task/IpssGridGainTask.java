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

package org.interpss.core.grid.gridgain.task;

/**
 *  An abstract GridTask for implement one node per task. The job will be assigned to
 *  the node identified by the nodeId attribute.  
 */

import org.gridgain.grid.GridTaskAdapter;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridTaskSessionResource;

public abstract class IpssGridGainTask<T> extends GridTaskAdapter<T> {
	private static final long serialVersionUID = 1;
	
	public static final String Token_TaskType              = "Gridgain_TaskType";
	public static final String TaskType_Aclf_Job2Node      = "Aclf_Job2Node";
	public static final String TaskType_DStab_Job2Node     = "DStab_Job2Node";

	public static final String Token_MasterNodeId = "MasterNodeId";
	public static final String Token_DStabAlgo    = "DStabAlgorithm";
	public static final String Token_AclfAlgo     = "LoadflowAlgorithm";
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;
    
	// Master node id
	public static String MasterNodeId = "";

	public GridTaskSession getSession() {
		return this.session;
	}
}
