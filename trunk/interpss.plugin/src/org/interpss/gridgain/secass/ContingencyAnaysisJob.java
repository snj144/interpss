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

package org.interpss.gridgain.secass;

import java.io.Serializable;

import org.interpss.PluginSpringAppContext;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RuleBaseXmlType;
import org.interpss.xml.PreventiveRuleHanlder;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.ext.gridgain.AbstractIpssGridGainJob;
import com.interpss.ext.gridgain.IRemoteResult;
import com.interpss.ext.gridgain.RemoteMessageTable;

public class ContingencyAnaysisJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;

	/**
	 * Constructor
	 * 
	 * @param modelStr the string object sent to this job node 
	 */
	public ContingencyAnaysisJob(RemoteMessageTable remoteMsg) {
		super(remoteMsg);
	}

	/**
	 * perform the actual grid job computation
	 * 
	 * @param modelStr serialized AclfNet object
	 */
	protected Serializable performGridJob(RemoteMessageTable remoteMsg) {
		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(
				getSesStringAttrib(Constants.GridToken_BaseStudyCaseNetworkModel));;
		// get serialized algo string from the task session
		LoadflowAlgorithm algo = (LoadflowAlgorithm) SerializeEMFObjectUtil.loadModel(
								remoteMsg.getAclfAlgorithm());
		algo.setAclfAdjNetwork(net);

		if (remoteMsg.getStudyCaseModification() != null) {
			try {
				//IpssLogger.getLogger().info("Study Case Modification: " + remoteMsg.getStudyCaseModification());
				ModificationXmlType mod = ModificationXmlType.Factory.parse(remoteMsg.getStudyCaseModification());
				IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
				mapper.mapping(mod, net, ModificationXmlType.class);
			} catch (Exception e) {
				getRemoteResult().put(RemoteMessageTable.KEY_bRsp_ReturnStatus, Boolean.FALSE);
				getRemoteResult().addReturnMessage(e.toString());
			}
		}

		if (getSesBooleanAttrib(Constants.GridToken_RemoteNodeDebug))
			debugOut(net, algo);
		
		// perform loadflow calculation
		try {
			algo.loadflow(SpringAppContext.getIpssMsgHub());
			if (getSesBooleanAttrib(Constants.GridToken_ApplyRuleBase)) {
				IpssLogger.getLogger().info("Apply Aclf Rule Base");
				String str = getSesStringAttrib(Constants.GridToken_RuleBaseXml);
				if (str != null) {
					// IpssLogger.getLogger().info("Rule Base " + str);
					RuleBaseXmlType ruleBase = RuleBaseXmlType.Factory.parse(str);
					double max = getSesDoubleAttrib(Constants.GridToken_BusVoltageUpperLimitPU);
					double min = getSesDoubleAttrib(Constants.GridToken_BusVoltageLowerLimitPU);
					getRemoteResult().addReturnMessage(
							PreventiveRuleHanlder.applyRuleSet2AclfNet(algo, ruleBase, max, min, this.getMsgHub()));
				}
			}
		} catch (Exception e) {
			getRemoteResult().put(RemoteMessageTable.KEY_bRsp_ReturnStatus, Boolean.FALSE);
			getRemoteResult().addReturnMessage(e.toString());
		}

		// persist loadflow results and send back to the master node
		IRemoteResult resultHandler = RemoteResultFactory.createHandler(ContingencyAnaysisJob.class);
		resultHandler.saveRemoteResult(getRemoteResult(), remoteMsg.getStudyCaseId(), 
							getGrid().getLocalNode().getId().toString(), algo, getSession());
		return getRemoteResult();
	}
	
	private synchronized void debugOut(AclfNetwork net, LoadflowAlgorithm algo) {
		IpssLogger.getLogger().info("CaseId: " + net.getId());
		IpssLogger.getLogger().info("AclfNet -->" + net.net2String());
		IpssLogger.getLogger().info("AclfAlgo -->" + algo.toString());
	}
}
