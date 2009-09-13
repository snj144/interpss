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

import org.interpss.PluginSpringAppContext;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.schema.RuleBaseXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.xml.PreventiveRuleHanlder;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.ext.gridgain.AbstractIpssGridGainJob;
import com.interpss.ext.gridgain.IRemoteResult;
import com.interpss.ext.gridgain.RemoteMessageTable;

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
		net.rebuildLookupTable();
		
		String caseId = remoteMsg.getStudyCaseId();
		if (getSesBooleanAttrib(Constants.GridToken_RemoteJobCreation)) {
			if (remoteMsg.getStudyCaseModification() != null) {
				try {
					//IpssLogger.getLogger().info("Study Case Modification: " + remoteMsg.getStudyCaseModification());
					ModificationXmlType mod = ModificationXmlType.Factory.parse(remoteMsg.getStudyCaseModification());
					IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
					mapper.mapping(mod, net, ModificationXmlType.class);
				} catch (Exception e) {
					IpssLogger.logErr(e);
					//e.printStackTrace();
				}
			}
		}

		// get serialized algo string from the task session
		String algoStr = remoteMsg.getAclfAlgorithm();
		//System.out.println(algoStr);
		LoadflowAlgorithm algo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			algo = (LoadflowAlgorithm) SerializeEMFObjectUtil.loadModel(algoStr);
			algo.setMsgHub(SpringAppContext.getIpssMsgHub());
			if (net instanceof AclfAdjNetwork) {
				algo.setAclfAdjNetwork((AclfAdjNetwork) net);
			} else {
				algo.setAclfNetwork(net);
			}
		} else {
			// this is more for testing purpose
			algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		}

		// perform loadflow calculation
		try {
			algo.loadflow();
			if (getSesBooleanAttrib(Constants.GridToken_RemoteNodeDebug))
				IpssLogger.getLogger().info("Loadflow converged: " + net.isLfConverged());
			
			if (getSesBooleanAttrib(Constants.GridToken_ApplyRuleBase)) {
				IpssLogger.getLogger().info("Apply Rule Base");
				String str = getSesStringAttrib(Constants.GridToken_RuleBaseXml);
				if (str != null) {
					//IpssLogger.getLogger().info("Rule Base " + str);
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
			e.printStackTrace();
		}
 
		if (getSesBooleanAttrib(Constants.GridToken_RemoteNodeDebug))
			debugOut(net, algo);
		
		IRemoteResult resultHandler = RemoteResultFactory.createHandler(IpssGridGainAclfJob.class);
		resultHandler.saveRemoteResult(getRemoteResult(), caseId, getGrid().getLocalNode().getId().toString(), algo, getSession());
		return getRemoteResult();
	}
	
	private synchronized void debugOut(AclfNetwork net, LoadflowAlgorithm algo) {
		IpssLogger.getLogger().info("CaseId: " + net.getId());
		//IpssLogger.getLogger().info("AclfNet -->" + net.net2String());
		IpssLogger.getLogger().info("AclfAlgo -->" + algo.toString());
	}
}
