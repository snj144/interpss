/*
 * @(#)IEEECDF_ODMTest.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 02/01/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.dstab.odm;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.common.IDStabBusVisitor;
import com.interpss.dstab.mach.Machine;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DStab_Ipss5BusTest extends BaseTestSetup { 		
	@Test
	public void testCase() throws Exception {
		File file = new File("testdata/ieee_odm/Tran_5bus.xml");
		DStabModelParser parser = ODMObjectFactory.createDStabModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));

			IEEEODMMapper mapper = new IEEEODMMapper();
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
			if (!mapper.mapping(parser, simuCtx, SimuContext.class)) {
				System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
				return;
			}	

			DStabilityNetwork dstabNet = simuCtx.getDStabilityNet();
			dstabNet.forEachDStabBus(new IDStabBusVisitor() {
				public void visit(DStabBus bus) {
					if (bus.getMachine() != null) {
						Machine mach = bus.getMachine();
						// transfer SC3PMva ... info to mach data
						mach.setBusAcscInfo(bus);			
					}					
				}
			});		

			DynamicSimuAlgorithm dstabAlgo = simuCtx.getDynSimuAlgorithm();
			LoadflowAlgorithm lfAlgo = dstabAlgo.getAclfAlgorithm();
			lfAlgo.loadflow();
					
			
			//System.out.println(AclfOutFunc.loadFlowSummary(dstabNet));
			assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageMag() - 0.86011) < 0.0001);
			assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageAng(UnitType.Deg) + 4.8) < 0.1);

			if (dstabAlgo.initialization()) {
				System.out.println("Running DStab simulation ...");
				dstabAlgo.performSimulation();
			}			
		}
	}
}

