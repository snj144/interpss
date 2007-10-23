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

package org.interpss.core.grid.gridgain.aclf;

/**
 *  An implementation of GridTask for AclfNetwor or AclfAdjNetwork. The job will be assigned to
 *  the node identified by the nodeId attribute.  
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridNode;
import org.gridgain.grid.GridTaskAdapter;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;

public class IpssAclfNetGridGainTask extends GridTaskAdapter<AclfNetwork> {
	private static final long serialVersionUID = 1;
	
	public static String nodeId = "";
	
	@Override
	public Map<? extends GridJob,GridNode> map(List<GridNode> subgrid, AclfNetwork net) throws GridException {
		Map<GridJob, GridNode> jobMap = new HashMap<GridJob, GridNode>();
		// if nodeId = null, there is only one node in the list
		GridNode node = null;
		if (nodeId == null)
			node = subgrid.get(0);
		else {
			// select calculation node by nodeId
			for (GridNode n : subgrid) {
				if (nodeId.equals(n.getId().toString())) {
					node = n;
					break;
				}
			}
		}
		if (node == null) {
			throw new GridException("Cannot find a grid node");
		}
		String modelStr = SerializeEMFObjectUtil.saveModel(net);
		jobMap.put(new AclfNetGridGainJob(modelStr), node);	
		return jobMap;
     }

	@Override
	public Object reduce(List<GridJobResult> results) throws GridException {
		// There should be only one return
		if (results.size() != 1) {
			throw new GridException("Programming error, return results.size() != 1");
		}
		if (results.get(0).getException() != null) {
            throw results.get(0).getException();
        }
		return results.get(0).getData();
	}
}
