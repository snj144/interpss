 /*
  * @(#)IpssGridGainDStabJob.java   
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

/*
 *  This Class is for performing grid computing for DStab network model 
 */

package org.interpss.gridgain.job;

import java.io.Serializable;

import org.interpss.gridgain.util.DStabSimuGridOutputHandler;
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.DynamicEventProcessor;
import com.interpss.dstab.util.IDStabSimuOutputHandler;

public class IpssGridGainDStabJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;

	/**
	 * Constructor
	 * 
	 * @param modelStr the string object sent to this job node 
	 */
	public IpssGridGainDStabJob(RemoteMessageTable remoteMsg) {
		super(remoteMsg);
	}

	/**
	 * perform the actual grid job computation
	 * 
	 * @param modelStr serialized DStabNet object
	 */
	protected Serializable performGridJob(RemoteMessageTable remoteMsg) {
		// deserialized the model into DStabNet object 
		DStabilityNetwork net = (DStabilityNetwork) SerializeEMFObjectUtil
				.loadModel(remoteMsg.getStudyCaseNetworkModel());
		// we always assume that the case id is carried to the remote grid node by the id field
		String caseId = net.getId();

		// get serialized algo string from the task session
		String algoStr = getSesStringAttrib(Constants.GridToken_DStabAlgo + caseId);
		//System.out.println(algoStr);
		DynamicSimuAlgorithm dstabAlgo;
		if (algoStr != null) {
			dstabAlgo = (DynamicSimuAlgorithm) SerializeEMFObjectUtil
					.loadModel(algoStr);

			algoStr = (String) getSession().getAttribute(
					Constants.GridToken_AclfAlgo + caseId);
			LoadflowAlgorithm lfAlgo = (LoadflowAlgorithm) SerializeEMFObjectUtil
					.loadModel(algoStr);
			dstabAlgo.setAclfAlgorithm(lfAlgo);

			dstabAlgo.setDynamicEventHandler(new DynamicEventProcessor(
					getMsgHub()));
			dstabAlgo.setDStabNet(net);
		} else {
			// this approach is more for testing purpose
			dstabAlgo = DStabObjectFactory.createDynamicSimuAlgorithm(net,
					getMsgHub());
			dstabAlgo.setSimuStepSec(0.01);
			dstabAlgo.setTotalSimuTimeSec(10.0);
		}

		// set simulation result handler
		IDStabSimuOutputHandler handler = new DStabSimuGridOutputHandler(
				getMsgHub(), caseId);
		dstabAlgo.setSimuOutputHandler(handler);

		// set output var filter info, which is carried to the remote node by
		// the DStabAlgo object
		handler.setOutputFilter(dstabAlgo.isOutputFilted());
		if (dstabAlgo.isOutputFilted()) {
			for (String str : dstabAlgo.getOutputVarIdList())
				handler.getOutputVarIdList().add(str);
			IpssLogger.getLogger().info(
					"Output Var List: " + handler.getOutputVarIdList());
		}
		
		if (getSesBooleanAttrib(Constants.GridToken_RemoteNodeDebug))
			debugOut(net, dstabAlgo);

		// perform load flow calculation
		LoadflowAlgorithm aclfAlgo = dstabAlgo.getAclfAlgorithm();
		aclfAlgo.loadflow(getMsgHub());

		getRemoteResult().put(RemoteMessageTable.KEY_StudyCaseId, getGrid().getLocalNode().getId().toString());
		getRemoteResult().put(RemoteMessageTable.KEY_StudyCaseId, caseId);
		if (dstabAlgo.initialization(getMsgHub())) {
			getMsgHub().sendStatusMsg(
					"Running DStab simulation at remote node "
							+ getGrid().getLocalNode());
			if (dstabAlgo.performSimulation(getMsgHub())) {
				getRemoteResult().put(RemoteMessageTable.KEY_DStabRunStatus, Boolean.TRUE);
				return getRemoteResult();
			}
		}

		getRemoteResult().put(RemoteMessageTable.KEY_DStabRunStatus, Boolean.FALSE);
		return getRemoteResult();
	}
	
	private synchronized void debugOut(AclfNetwork net, DynamicSimuAlgorithm dstabAlgo) {
		IpssLogger.getLogger().info("CaseId: " + net.getId());
		IpssLogger.getLogger().info("DStabNet -->" + net.net2String());
		IpssLogger.getLogger().info("DStabAlgo -->" + dstabAlgo.toString());
	}
}
