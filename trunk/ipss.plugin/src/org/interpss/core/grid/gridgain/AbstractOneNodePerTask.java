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

public abstract class AbstractOneNodePerTask<T> extends GridTaskAdapter<T> {
	private static final long serialVersionUID = 1;
	
	// Remote node id, the node will be assigned to perform the Task - One job task
	public static String RemoteNodeId = "";
	
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
			throw new GridException("Cannot find a grid node");
		}
		return node;
     }
}
