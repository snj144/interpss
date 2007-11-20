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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridNode;
import org.interpss.core.grid.gridgain.job.IpssGridGainJob;
import org.interpss.core.grid.gridgain.util.IpssGridUtilFunc;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;

public class AssignJob2NodeTask extends AbstractIpssGridGainTask<Object> {
	private static final long serialVersionUID = 1;
	
	// Remote node id, the node will be assigned to perform the Task - One job task
	public static String RemoteNodeId = "";
	
	@Override
	public Map<? extends GridJob, GridNode> map(List<GridNode> subgrid, Object model) throws GridException {
        // Send master node id to all nodes.
        getSession().setAttribute(Token_MasterNodeId, MasterNodeId);
        
        // serialize the model object
		String modelStr = "";
		if (model instanceof DynamicSimuAlgorithm || model instanceof DStabilityNetwork) {
			modelStr = serializeDStabModel(model);
		}
		else if (model instanceof LoadflowAlgorithm || model instanceof AclfAdjNetwork ||
				 model instanceof AclfNetwork ) {
			modelStr = serializeAclfModel(model);
		}

		Map<GridJob, GridNode> jobMap = new HashMap<GridJob, GridNode>();
		// get the remote grid node
		GridNode node = getRemoteNode(subgrid);
		// set the DStab object with the Algorithm info to the remote node
		jobMap.put(new IpssGridGainJob(modelStr), node);	
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
		// for Grid DStab the return is a Boolean object
		return results.get(0).getData();
	}

	private String serializeAclfModel(Object model) throws GridException {
		String modelStr = "";
        getSession().setAttribute(Token_TaskType, TaskType_Aclf_Job2Node);
		if (model instanceof LoadflowAlgorithm) {
			LoadflowAlgorithm algo = (LoadflowAlgorithm)model;
			AclfNetwork net = algo.getAclfNetwork();

			String lfAlgoStr = IpssGridUtilFunc.serializeAclfAlgorithm(algo);
	        getSession().setAttribute(Token_AclfAlgo+net.getId(), lfAlgoStr);
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		else if (model instanceof AclfAdjNetwork) {
			AclfAdjNetwork net = (AclfAdjNetwork)model;
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		else {
			AclfNetwork net = (AclfNetwork)model;
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		return modelStr;
	}
	
	private String serializeDStabModel(Object model) throws GridException {
		String modelStr = "";
        getSession().setAttribute(Token_TaskType, TaskType_DStab_Job2Node);
		if (model instanceof DynamicSimuAlgorithm) {
	        DynamicSimuAlgorithm algo = (DynamicSimuAlgorithm)model; 
			
			// serialize the network object
			DStabilityNetwork net = algo.getDStabNet(); 
			modelStr = SerializeEMFObjectUtil.saveModel(net);

			String lfAlgoStr = IpssGridUtilFunc.serializeAclfAlgorithm(algo.getAclfAlgorithm());
	        getSession().setAttribute(Token_AclfAlgo+net.getId(), lfAlgoStr);
			
			String dstabAlgoStr = IpssGridUtilFunc.serializeDStabAlgorithm(algo);
	        getSession().setAttribute(Token_DStabAlgo+net.getId(), dstabAlgoStr);
		}
		else if (model instanceof DStabilityNetwork) {
			DStabilityNetwork net = (DStabilityNetwork)model; 
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		return modelStr;
	}
	
	/**
	 * Using the remoteNodeId to locate the remote node to distribute grid jobs. If RemoteNodeId == null
	 * the first available node will be selected.
	 * 
	 * @param subgrid list of all grid nodes in the grid
	 * @return the select remote grid node
	 * @throws GridException
	 */
	private GridNode getRemoteNode(List<GridNode> subgrid) throws GridException {
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
