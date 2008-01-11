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

package org.interpss.gridgain.dstab;

import static org.junit.Assert.assertTrue;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.interpss.dstab.ieeeModel.DStabTestSetupBase;
import org.interpss.gridgain.task.assignJob.AbstractAssignJob2NodeTask;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.GridMessageRouter;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.ui.Workspace;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.DatabaseSimuOutputHandler;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DStab_5BusGridGainTest extends DStabTestSetupBase {
	@Test
	public void testDStab5BusCase() throws InterpssException, GridException {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
		loadCaseData("testData/dstab_test/DStab-5Bus.ipss", simuCtx);
		
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		net.setId("NetId");
		addDynamicEventData(net);
		//System.out.println(net.net2String());
		
		DynamicSimuAlgorithm algo = createDStabAlgo(net);
		//algo.setTotalSimuTimeSec(0.2);
		
    	GridFactory.start();
        try {
        	Grid grid = GridFactory.getGrid();
        	
        	GridMessageRouter msgRouter = new GridMessageRouter(msg);
        	grid.addMessageListener(msgRouter);
        	
    		Workspace.setCurrentType(Workspace.Type.Sample);
    		
    		IDStabSimuDatabaseOutputHandler dstabBbHandler = new DatabaseSimuOutputHandler();
    		try {
    			assertTrue(dstabBbHandler.init(83, "DStab-5Bus"+" SimuRecord"));
    		} catch (Exception e) {
    			IpssLogger.logErr(e);
    			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to Create DB SimuRecord", 
    					e.toString() + "\nPlease contact InterPSS support");
    		}

        	//msgRouter.setIDStabSimuDatabaseOutputHandler(dstabBbHandler);
        	
/*
		setDbSimuCaseId(handler.getCaseId());
		// setup if there is output filtering
		handler.setOutputFilter(dStabCaseData.isOutputFilter());
		if (handler.isOutputFilter()) 
			handler.setOutputVarIdList(dStabCaseData.getOutVarList());
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(handler);
 */        	
        	String[] list = IpssGridGainUtil.gridNodeNameList(grid, false);
    		assertTrue(list.length > 0);
    		
    		String nodeId = IpssGridGainUtil.nodeIdLookup(list[list.length-1]);
    		if (list.length >= 2)  // there is remote node in this case
    			assertTrue(nodeId != null);
    		
    		AssignJob2NodeDStabTask.RemoteNodeId = nodeId;
    		AbstractAssignJob2NodeTask.MasterNodeId = grid.getLocalNode().getId().toString();
    		
        	Boolean rtn = (Boolean)IpssGridGainUtil.performGridTask(grid, "Grid DStab 5-Bus Sample system", algo, 0);
        	assertTrue(rtn.booleanValue());
        }
        finally {
        	GridFactory.stop(true);
        }
	}
}
