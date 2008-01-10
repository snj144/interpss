 /*
  * @(#)IpssGridGainAllfJob.java   
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

package org.interpss.gridgain.job;

import java.io.Serializable;


import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class IpssGridGainAclfJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;

	public IpssGridGainAclfJob(String arg) {
		super(arg);
	}
	
	/**
	 * perform the actual grid job computation
	 * 
	 * @param modelStr serialized AclfNet object
	 */
	protected Serializable performGridJob(String modelStr) {
		AclfNetwork net = null;
		Object model = SerializeEMFObjectUtil.loadModel(modelStr);
		if (model instanceof AclfNetwork)
			net = (AclfNetwork) model;
		else if (model instanceof AclfAdjNetwork)
			net = (AclfAdjNetwork) model;

		// get serialized algo string from the task session
		String algoStr = (String) getSession().getAttribute(Constants.GridToken_AclfAlgo + net.getId());
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

		// perform loadflow calculation
		algo.loadflow(SpringAppContext.getIpssMsgHub());

		// send the calculated Aclf object back to the master node
		net.setDesc(getGrid().getLocalNode().getId().toString());
		return SerializeEMFObjectUtil.saveModel(net);
	}
}
