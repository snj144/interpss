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

/**
 *  An abstract GridTask for implement one node per task. The job will be assigned to
 *  the node identified by the nodeId attribute.  
 */

import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridNode;
import org.gridgain.grid.GridTaskAdapter;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridTaskSessionResource;

public abstract class AbstractAssignJob2NodeTask<T> extends GridTaskAdapter<T> {
	private static final long serialVersionUID = 1;
	
	public static final String Token_MasterNodeId = "MasterNodeId";
	public static final String Token_DStabAlgo = "DStabAlgorithm";
	public static final String Token_AclfAlgo = "LoadflowAlgorithm";
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;
    
	// Remote node id, the node will be assigned to perform the Task - One job task
	public static String RemoteNodeId = "";
	
	// Master node id
	public static String MasterNodeId = "";

	public GridTaskSession getSession() {
		return this.session;
	}
	
	/**
	 * Using the remoteNodeId to locate the remote node to distribute grid jobs. If RemoteNodeId == null
	 * the first available node will be selected.
	 * 
	 * @param subgrid list of all grid nodes in the grid
	 * @return the select remote grid node
	 * @throws GridException
	 */
	public GridNode getRemoteNode(List<GridNode> subgrid) throws GridException {
		GridNode node = null;
		if (RemoteNodeId == null)
			node = subgrid.get(0);
		else {
			// select calculation node by nodeId
			for (GridNode n : subgrid) {
				if (RemoteNodeId.equals(n.getId().toString())) {
					node = n;
					break;
				}
			}
		}
		if (node == null) {
			throw new GridException("Cannot find a grid node to distribute the grid job");
		}
		return node;
     }
}
