/*
 * @(#)AssignJob2NodeDStabTask.java   
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
 * An abstract GridTask for implement one node per task. The job will be
 * assigned to the node identified by the nodeId attribute.
 */

import org.gridgain.grid.GridException;
import org.interpss.gridgain.job.AbstractIpssGridGainJob;
import org.interpss.gridgain.job.IpssGridGainDStabJob;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;

public class AssignJob2NodeDStabTask extends AbstractAssignJob2NodeTask {
	private static final long serialVersionUID = 1;

	/**
	 * Serialize the model object to a string
	 * 
	 * @param model,
	 *            Model object, could be DStabAlgo or DStabNet object
	 * @return the serialized object (String)
	 */
	@Override
	protected RemoteMessageTable serializeModel(Object model) throws GridException {
		RemoteMessageTable remoteMsg = new RemoteMessageTable();

		String modelStr = "", lfAlgoStr = "", dstabAlgoStr = "";
		if (model instanceof DynamicSimuAlgorithm) {
			DynamicSimuAlgorithm dstabAlgo = (DynamicSimuAlgorithm) model;

			// serialize the network object
			DStabilityNetwork net = dstabAlgo.getDStabNet();
			modelStr = SerializeEMFObjectUtil.saveModel(net);
			this.studyCaseId = net.getId();
				
			lfAlgoStr = SerializeEMFObjectUtil.saveModel(dstabAlgo.getAclfAlgorithm());
			remoteMsg.put(RemoteMessageTable.KEY_sIn_AclfAlgorithm, lfAlgoStr);

			// done - this part should be implemented in the future
			// dstabAlgo.setSimuOutputHandler(null);
			dstabAlgoStr = SerializeEMFObjectUtil.saveModel(dstabAlgo);
			remoteMsg.put(RemoteMessageTable.KEY_sIn_DStabAlgorithm, dstabAlgoStr);

			if (IpssGridGainUtil.RemoteNodeDebug) {
				IpssLogger.getLogger().info("CaseId: " + net.getId());
				IpssLogger.getLogger().info("Model String: " + modelStr);
				IpssLogger.getLogger().info("AclfAlgo String: " + lfAlgoStr);
				IpssLogger.getLogger().info("DStabAlgo String: " + dstabAlgoStr);
			}
		} else if (model instanceof DStabilityNetwork) {
			DStabilityNetwork net = (DStabilityNetwork) model;
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		
		remoteMsg.put(RemoteMessageTable.KEY_sIn_StudyCaseNetworkModel, modelStr);
		return remoteMsg;
	}


	@Override
	protected AbstractIpssGridGainJob createJob(RemoteMessageTable remoteMsg) {
		remoteMsg.put(RemoteMessageTable.KEY_sInOut_StudyCaseId, studyCaseId);
		return new IpssGridGainDStabJob(remoteMsg);
	}
}
