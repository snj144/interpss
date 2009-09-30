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

package org.interpss.contigency;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class N2Analysis_IEEE14BusTest extends BaseTestSetup {
	@Test
	public void sampleTest() {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);

		AclfNetwork net = simuCtx.getAclfNet();
		
		//System.out.println(net.net2String());
/*		
		AclfBus bus1 = net.getAclfBus("1");
		bus1.setLoadCode(AclfLoadCode.EXPONENTIAL);
		bus1.setExpLoadP(0.9);
		bus1.setExpLoadQ(3.0);
*/		

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.setNonDivergent(true);
		
		for (Branch branch1 : net.getBranchList()) {
			branch1.setStatus(false);
			
			for (Branch branch2 : net.getBranchList()) {
				if (!branch1.getId().equals(branch2.getId())) {
					ChangeRecorder recorder = new ChangeRecorder(net);
					
					branch2.setStatus(false);
					System.out.println("====================\nTurn off branches " + 
							branch1.getId() + ", " + branch2.getId());
					
					if (!algo.checkSwingBus())
						algo.assignSwingBus();
/*
					if (branch1.getId().equals("0007->0008(1)")) {
						for (Bus bus : net.getBusList())
							System.out.println("id, intFlag, status: " + 
								bus.getId() + ", " + bus.getIntFlag() + ", " + bus.isActive());
						for (Branch b : net.getBranchList()) 
							System.out.println("id, status: " + 
								b.getId() + ", " + b.isActive());
					}
				
*/					assertTrue(algo.loadflow());

					recorder.endRecording().apply();
				}
			}
			
	  		branch1.setStatus(true);
		}
		
	}
}

