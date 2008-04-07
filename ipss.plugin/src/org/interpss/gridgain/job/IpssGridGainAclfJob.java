/*
 * @(#)IpssGridGainAclfJob.java   
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

import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class IpssGridGainAclfJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;

	/**
	 * Constructor
	 * 
	 * @param modelStr the string object sent to this job node 
	 */
	public IpssGridGainAclfJob(RemoteMessageTable remoteMsg) {
		super(remoteMsg);
	}

	/**
	 * perform the actual grid job computation
	 * 
	 * @param modelStr serialized AclfNet object
	 */
	protected Serializable performGridJob(RemoteMessageTable remoteMsg) {
		AclfNetwork net = null;
		
		Object model = null;
		if (getSesBooleanAttrib(Constants.GridToken_RemoteJobCreation)) {
			model = SerializeEMFObjectUtil.loadModel(getSesStringAttrib(Constants.GridToken_BaseStudyCaseNetworkModel));
			IpssLogger.getLogger().info("Remote job contructed using the base study case");
		}
		else {
			String modelStr = remoteMsg.getStudyCaseNetworkModel();
			model = SerializeEMFObjectUtil.loadModel(modelStr);
			IpssLogger.getLogger().info("Remote job contructed using the current study case");
		}
		
		if (model instanceof AclfNetwork)
			net = (AclfNetwork) model;
		else if (model instanceof AclfAdjNetwork)
			net = (AclfAdjNetwork) model;

		// we always assume that the case id is carried to the remote grid node by the id field
		String caseId = net.getId();
		if (getSesBooleanAttrib(Constants.GridToken_RemoteJobCreation))
			caseId = remoteMsg.getStudyCaseId();
		else
			caseId = net.getId();

		// get serialized algo string from the task session
		String algoStr = getSesStringAttrib(Constants.GridToken_AclfAlgo + caseId);
		//System.out.println(algoStr);
		LoadflowAlgorithm algo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			algo = (LoadflowAlgorithm) SerializeEMFObjectUtil
					.loadModel(algoStr);
			if (net instanceof AclfAdjNetwork) {
				//algo.setAdjAlgorithm(AlgorithmFactory.eINSTANCE.createAclfAdjustAlgorithm());
				algo.setAclfAdjNetwork((AclfAdjNetwork) net);
			} else {
				algo.setAclfNetwork(net);
			}
		} else {
			// this is more for testing purpose
			algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		}

		if (((Boolean) getSession().getAttribute(
				Constants.GridToken_RemoteNodeDebug)).booleanValue()) {
			debugOut(net, algo);
		}
		
		// perform loadflow calculation
		algo.loadflow(SpringAppContext.getIpssMsgHub());

		// send the calculated Aclf object back to the master node
		net.setDesc(getGrid().getLocalNode().getId().toString());

		IRemoteResult resultHandler = RemoteResultFactory.createRemoteResultHandler();
		resultHandler.saveAclfResult(getRemoteResult(), caseId, getGrid().getLocalNode().getId().toString(), net, getSession());
		return getRemoteResult();
	}
	
	private synchronized void debugOut(AclfNetwork net, LoadflowAlgorithm algo) {
		IpssLogger.getLogger().info("CaseId: " + net.getId());
		IpssLogger.getLogger().info("AclfNet -->" + net.net2String());
		IpssLogger.getLogger().info("AclfAlgo -->" + algo.toString());
	}
}
