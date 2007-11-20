
 /*
  * @(#)IpssGridGainJob.java   
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

package org.interpss.core.grid.gridgain.job;

import java.io.Serializable;

import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.job.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.task.AbstractIpssGridGainTask;
import org.interpss.core.grid.gridgain.util.DStabSimuGridOutputHandler;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AlgorithmFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.DynamicEventProcessor;
import com.interpss.dstab.util.IDStabSimuOutputHandler;

public class IpssGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	public IpssGridGainJob(String model) {
		super(model);
	}
	
	@Override
	public Serializable execute() throws GridException {
    	initEMFPackage();

		// de-serialized the model to a DSatbilityNetwork object 
		String modelStr = getArgument();
		
		String taskType = (String)getSession().getAttribute(AbstractIpssGridGainTask.Token_TaskType);
		if (taskType.equals(AbstractIpssGridGainTask.TaskType_Aclf_Job2Node)) {
		    return performAclfJob(modelStr);
		}
		else if (taskType.equals(AbstractIpssGridGainTask.TaskType_DStab_Job2Node)) {
		    return performDStabJob(modelStr);
		}
		throw new GridException("Wrong ipss gridgain taks type " + taskType);
    }
    
    private Serializable performDStabJob(String modelStr) {
		DStabilityNetwork net = (DStabilityNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
		
		// get serialized algo string from the task session
		String algoStr = (String)getSession().getAttribute(AbstractIpssGridGainTask.Token_DStabAlgo+net.getId());
		System.out.println(algoStr);
		DynamicSimuAlgorithm dstabAlgo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			dstabAlgo = (DynamicSimuAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
			
			algoStr = (String)getSession().getAttribute(AbstractIpssGridGainTask.Token_AclfAlgo+net.getId());
			LoadflowAlgorithm lfAlgo = (LoadflowAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
			dstabAlgo.setAclfAlgorithm(lfAlgo);

			dstabAlgo.setDynamicEventHandler(new DynamicEventProcessor(getMsgHub()));
			dstabAlgo.setDStabNet(net);
    	}
		else {
			// this is more for testing purpose
			dstabAlgo = DStabObjectFactory.createDynamicSimuAlgorithm(net, getMsgHub());
			dstabAlgo.setSimuStepSec(0.01);
			dstabAlgo.setTotalSimuTimeSec(10.0);
		}
		
		// set simulation result handler
		IDStabSimuOutputHandler handler = new DStabSimuGridOutputHandler(getMsgHub());
		if (dstabAlgo.getSimuOutputHandler() != null) {
			// transfer info to the GridOutputHandler
		}
		dstabAlgo.setSimuOutputHandler(handler);
		
		// perform load flow calculation
		LoadflowAlgorithm aclfAlgo = dstabAlgo.getAclfAlgorithm();
		aclfAlgo.loadflow(getMsgHub());
		
		if (dstabAlgo.initialization(getMsgHub())) {
			getMsgHub().sendStatusMsg("Running DStab simulation at remote node " + getGrid().getLocalNode());
			if (dstabAlgo.performSimulation(getMsgHub()))
				return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
    }
    
    private Serializable performAclfJob(String modelStr) {
		AclfNetwork net = null;
		Object model = SerializeEMFObjectUtil.loadModel(modelStr);
		if (model instanceof AclfNetwork)
			net = (AclfNetwork)model;
		else if (model instanceof AclfAdjNetwork)
			net = (AclfAdjNetwork)model;
		 
		// get serialized algo string from the task session
		String algoStr = (String)getSession().getAttribute(AbstractIpssGridGainTask.Token_AclfAlgo+net.getId());
		LoadflowAlgorithm algo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			algo = (LoadflowAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
	  		if (net instanceof AclfAdjNetwork) {
	  			algo.setAdjAlgorithm(AlgorithmFactory.eINSTANCE.createAclfAdjustAlgorithm());
	  			algo.setAclfAdjNetwork((AclfAdjNetwork)net);
	  		}
	  		else {
	  			algo.setAclfNetwork(net);
	  		}
    	}
		else {
			// this is more for testing purpose
			algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		}

		// perform loadflow calculation
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		// send the calculated Aclf object back to the master node
		return SerializeEMFObjectUtil.saveModel(net);    	
    }
}
