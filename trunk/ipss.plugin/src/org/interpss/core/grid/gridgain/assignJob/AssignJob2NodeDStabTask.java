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

package org.interpss.core.grid.gridgain.assignJob;

/**
 *  An abstract GridTask for implement one node per task. The job will be assigned to
 *  the node identified by the nodeId attribute.  
 */

import java.io.Serializable;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainTask;
import org.interpss.core.grid.gridgain.util.DStabSimuGridOutputHandler;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.DynamicEventProcessor;
import com.interpss.dstab.util.IDStabSimuOutputHandler;

public class AssignJob2NodeDStabTask extends AbstractAssignJob2NodeTask {
	private static final long serialVersionUID = 1;

	
	@Override
	protected GridJob createGridJob(String modelStr) {
		return new AbstractIpssGridGainJob(modelStr) {
			private static final long serialVersionUID = 1;

			protected Serializable performGridJob(String modelStr) {
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
		};
	}

	@Override
	protected String serializeModel(Object model) throws GridException {
		String modelStr = "";
		if (model instanceof DynamicSimuAlgorithm) {
	        DynamicSimuAlgorithm dstabAlgo = (DynamicSimuAlgorithm)model; 
			
			// serialize the network object
			DStabilityNetwork net = dstabAlgo.getDStabNet(); 
			modelStr = SerializeEMFObjectUtil.saveModel(net);

			String lfAlgoStr = SerializeEMFObjectUtil.saveModel(dstabAlgo.getAclfAlgorithm());
	        getSession().setAttribute(Token_AclfAlgo+net.getId(), lfAlgoStr);
			
	        // TODO - this part should be implemented in the future
	        dstabAlgo.setSimuOutputHandler(null);
	        String dstabAlgoStr = SerializeEMFObjectUtil.saveModel(dstabAlgo);
	        getSession().setAttribute(Token_DStabAlgo+net.getId(), dstabAlgoStr);
		}
		else if (model instanceof DStabilityNetwork) {
			DStabilityNetwork net = (DStabilityNetwork)model; 
			modelStr = SerializeEMFObjectUtil.saveModel(net);
		}
		return modelStr;
	}
	
}
