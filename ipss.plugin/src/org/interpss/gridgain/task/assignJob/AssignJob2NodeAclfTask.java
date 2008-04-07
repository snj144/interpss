/*
 * @(#)AssignJob2NodeAclfTask.java   
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

package org.interpss.gridgain.task.assignJob;

/**
 *  An abstract GridTask for implement one node per task. The job will be assigned to
 *  the node identified by the nodeId attribute.  
 */

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.interpss.gridgain.job.IpssGridGainAclfJob;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class AssignJob2NodeAclfTask extends AbstractAssignJob2NodeTask {
	private static final long serialVersionUID = 1;

	@Override
	protected GridJob createGridJob(String modelStr) {
		RemoteMessageTable remoteMsg = new RemoteMessageTable();
		remoteMsg.put(RemoteMessageTable.KEY_StudyCaseNetworkModel, modelStr);
		return new IpssGridGainAclfJob(remoteMsg);
	}

	@Override
	protected String serializeModel(Object model) throws GridException {
		String modelStr = "";
		if (model instanceof LoadflowAlgorithm) {
			LoadflowAlgorithm algo = (LoadflowAlgorithm) model;
			AclfNetwork net = algo.getAclfNetwork();

			String lfAlgoStr = SerializeEMFObjectUtil.saveModel(algo);
			getSession().setAttribute(
					Constants.GridToken_AclfAlgo + net.getId(), lfAlgoStr);
			modelStr = SerializeEMFObjectUtil.saveModel(net);

			if (IpssGridGainUtil.RemoteNodeDebug) {
				IpssLogger.getLogger().info("CaseId: " + net.getId());
				IpssLogger.getLogger().info("Model String: " + modelStr);
				IpssLogger.getLogger().info("AclfAlgo String: " + lfAlgoStr);
			}
		} else if (model instanceof AclfAdjNetwork) {
			AclfAdjNetwork net = (AclfAdjNetwork) model;
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		} else {
			AclfNetwork net = (AclfNetwork) model;
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		
		return modelStr;
	}
}
