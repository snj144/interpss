 /*
  * @(#)DStab_5Bus.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.dstab;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.IDStabSimuOutputHandler;
import com.interpss.dstab.util.TextSimuOutputHandler;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DStab_5Bus extends TestSetupBase {
	
	public void testCase() {
		System.out.println("Begin DStab_5Bus.testCase()");

		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET_LITERAL, msg);
		TestCommonUtil.loadCaseData("testData/DStab-5bus.ipss", simuCtx, msg);
		
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		
		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, msg);
		algo.setSimuStepSec(0.01);
		algo.setTotalSimuTimeSec(1.0);
		
		Machine mach = net.getMachine("Mach@0005");
//		mach = null;
		algo.setRefMachine(mach);

		net.removeAllDEvent();
				
		// set up output and run the simulation
		IDStabSimuOutputHandler handler = new TextSimuOutputHandler();
		algo.setSimuOutputHandler(handler);
		IpssLogger.getLogger().setLevel(Level.WARNING);
		if (algo.initialization(msg)) {
			try {
				handler.init(0, "");
			} catch (Exception e) {
				IpssLogger.logErr(e);
			}
			algo.performSimulation(msg);
		}
		
		System.out.println("End DStab_5Bus.testCase()");
	}
}
