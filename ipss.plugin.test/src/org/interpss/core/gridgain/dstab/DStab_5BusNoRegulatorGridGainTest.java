 /*
  * @(#)DStab_5BusGridGainTest.java   
  *
  * Copyright (C) 2007 www.interpss.org
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
  * @Date 10/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.gridgain.dstab;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.GridMessageListener;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.grid.gridgain.task.AssignJob2NodeTask;
import org.interpss.core.grid.gridgain.task.IpssGridGainTask;
import org.interpss.dstab.ieeeModel.DStabTestSetupBase;
import org.junit.Test;

import com.interpss.common.exp.InterpssException;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DStab_5BusNoRegulatorGridGainTest extends DStabTestSetupBase {
	@Test
	public void testDStab5BusCase() throws InterpssException, GridException {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
		loadCaseData("testData/dstab_test/DStab-5BusNoReg.ipss", simuCtx);
		
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		//System.out.println(net.net2String());
		
    	String str;
    	GridFactory.start();
        try {
        	Grid grid = GridFactory.getGrid();
        	
        	grid.addMessageListener(new GridMessageListener() {
        		public void onMessage(UUID arg0, Serializable arg1) {
        			System.out.println(arg1);
        		}        		
        	});

        	String[] list = IpssGridGainUtil.gridNodeNameList(grid, false);
    		assertTrue(list.length > 0);
    		
    		String nodeId = IpssGridGainUtil.nodeIdLookup(list[list.length-1]);
    		if (list.length >= 2)  // there is remote node in this case
    			assertTrue(nodeId != null);
    		
    		AssignJob2NodeTask.RemoteNodeId = nodeId;
    		IpssGridGainTask.MasterNodeId = grid.getLocalNode().getId().toString();

        	Boolean rtn = (Boolean)IpssGridGainUtil.performGridTask(grid, "Grid Aclf 5-Bus Sample system", net, 0);
        	assertTrue(rtn.booleanValue());
        }
        finally {
        	GridFactory.stop(true);
        }
	}
}
