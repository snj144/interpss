 /*
  * @(#)BaseTestSetup.java   
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

package org.interpss.gridgain;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.math.complex.Complex;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridMessageListener;
import org.interpss.BaseTestSetup;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.Machine;

public class GridBaseTestSetup extends BaseTestSetup {
	protected static IPSSMsgHub msg;

	@BeforeClass
	public static void startGridEnv() {
		IpssGridGainUtil.startDefaultGrid();
		assertTrue(IpssGridGainUtil.isGridEnabled());
		if (IpssGridGainUtil.getDefaultGrid().getAllNodes().size() <= 1)
			System.out.println("Please start a least one Gridgain agent for the test");
		assertTrue(IpssGridGainUtil.getDefaultGrid().getAllNodes().size() > 1);
		
		Grid grid = IpssGridGainUtil.getDefaultGrid();
		IpssGridGainUtil.MasterNodeId = grid.getLocalNode().getId().toString();
		IpssGridGainUtil.RemoteNodeDebug = false;

		// make sure Grid env is setup properly
		String[] list = IpssGridGainUtil.gridNodeNameList(grid, false);
		assertTrue(list.length > 0);
		
		// message from remote note are printed out
    	grid.addMessageListener(new GridMessageListener() {
    		public void onMessage(UUID arg0, Serializable arg1) {
    			//System.out.println(arg1);
    		}        		
    	});
	}
	
	@AfterClass
	public static void stopGridEnv() {
		IpssGridGainUtil.stopDefaultGrid();		
	}
	
	public DynamicSimuAlgorithm createDStabAlgo(DStabilityNetwork net) {
		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, msg);
		algo.setSimuStepSec(0.002);
		algo.setTotalSimuTimeSec(10.0);
		
		Machine mach = net.getMachine("Mach@0003");
		algo.setRefMachine(mach);	
		return algo;
	}
	
	public void addDynamicEventData(DStabilityNetwork net) {
		// define a bus fault event
		DynamicEvent event1 = DStabObjectFactory.createDEvent("BusFault3P@0003", "Bus Fault 3P@0003", 
				DynamicEventType.BUS_FAULT, net, msg);
		event1.setStartTimeSec(1.0);
		event1.setDurationSec(0.1);
		
		DStabBus faultBus = net.getDStabBus("0003");
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault 3P@0003" );
  		fault.setAcscBus(faultBus);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		fault.setZLGFault(Constants.SmallScZ);
		fault.setZLLFault(new Complex(0.0, 0.0));
		event1.setBusFault(fault);		
	}		
}

