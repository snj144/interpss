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

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class AssignJob2NodeAclfTask extends AbstractAssignJob2NodeTask {
	private static final long serialVersionUID = 1;
	
	@Override
	protected GridJob createGridJob(String modelStr) {
		return new AbstractIpssGridGainJob(modelStr) {
			private static final long serialVersionUID = 1;
			
		    protected Serializable performGridJob(String modelStr) {
				AclfNetwork net = null;
				Object model = SerializeEMFObjectUtil.loadModel(modelStr);
				if (model instanceof AclfNetwork)
					net = (AclfNetwork)model;
				else if (model instanceof AclfAdjNetwork)
					net = (AclfAdjNetwork)model;
				 
				// get serialized algo string from the task session
				String algoStr = (String)getSession().getAttribute(AbstractIpssGridGainTask.Token_AclfAlgo+net.getId());
				//System.out.println(algoStr);
				LoadflowAlgorithm algo;
				if (algoStr != null) {
					// set algo attributes. These attributes are not serialized
					algo = (LoadflowAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
			  		if (net instanceof AclfAdjNetwork) {
			  			//algo.setAdjAlgorithm(AlgorithmFactory.eINSTANCE.createAclfAdjustAlgorithm());
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
		};
	}
	
	@Override
	protected String serializeModel(Object model) throws GridException {
		String modelStr = "";
		if (model instanceof LoadflowAlgorithm) {
			LoadflowAlgorithm algo = (LoadflowAlgorithm)model;
			AclfNetwork net = algo.getAclfNetwork();

			String lfAlgoStr = SerializeEMFObjectUtil.saveModel(algo);
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
}
