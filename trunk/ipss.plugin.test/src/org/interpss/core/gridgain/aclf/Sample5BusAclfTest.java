 /*
  * @(#)AclfSampleTest.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.gridgain.aclf;

import static org.junit.Assert.assertTrue;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.interpss.BaseTestSetup;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.grid.gridgain.aclf.IpssAclfNetGridGainTask;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class Sample5BusAclfTest extends BaseTestSetup {
	@Test
	public void aclfSampleCaseTest() throws InterpssException, GridException {
		// step-1: define and load a EMF network object
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		algo.setTolerance(0.001);
		algo.setMaxIterations(30);

		String str;
    	GridFactory.start();
        try {
        	Grid grid = GridFactory.getGrid();

        	String[] list = IpssGridGainUtil.gridNodeNameList(grid, false);
    		assertTrue(list.length > 0);
    		
    		String nodeId = IpssGridGainUtil.nodeIdLookup(list[list.length-1]);
    		if (list.length >= 2)  // there is remote node in this case
    			assertTrue(nodeId != null);
    		
    		IpssAclfNetGridGainTask.RemoteNodeId = nodeId;

        	str = (String)IpssGridGainUtil.performGridTask(grid, "Grid Aclf 5-Bus Sample system", algo, 0);
        }
        finally {
        	GridFactory.stop(true);
        }
		net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(str);
		assertTrue(net.isLfConverged());
	}	
}