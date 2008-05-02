 /*
  * @(#)NetRuleTest.java   
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

package com.interpss.core.net;

import static org.junit.Assert.*;

import org.junit.Test;

import com.interpss.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;

public class SwitchBreakModelTest extends BaseTestSetup {
	@Test
	public void busSecTestCase() throws Exception {
		Network net = buildTestNet();
		
		assertTrue(net.getBus("Bus1") != null);
		assertTrue(net.getBus("Bus1", 1) != null);
		assertTrue(net.getBus("Bus1", 2) != null);

		assertTrue(net.getBus("Bus1").isActive());
		assertTrue(!net.getBus("Bus1", 1).isActive());
		assertTrue(!net.getBus("Bus1", 2).isActive());

		assertTrue(net.getBus("Bus1").getBranchList().size() == 2);
		assertTrue(net.getBus("Bus1").getConnectBranch("Bus1[1]->Bus2(1)") != null);
		assertTrue(net.getBus("Bus1").getConnectBranch("Bus3->Bus1[2](1)") != null);

		assertTrue(net.getBus("Bus1").nBranchConnected() == 2);
		
		net.getBus("Bus1").splitSection(1);
		assertTrue(net.getBus("Bus1").getBranchList().size() == 1);
		assertTrue(net.getBus("Bus1").getConnectBranch("Bus1[1]->Bus2(1)") == null);
		assertTrue(net.getBus("Bus1").getConnectBranch("Bus3->Bus1[2](1)") != null);

		assertTrue(net.getBus("Bus1").isActive());
		assertTrue(net.getBus("Bus1", 1).isActive());
		assertTrue(!net.getBus("Bus1", 2).isActive());

		net.getBus("Bus1").connectSection(1);
		assertTrue(net.getBus("Bus1").getBranchList().size() == 2);
		assertTrue(net.getBus("Bus1").getConnectBranch("Bus1[1]->Bus2(1)") != null);
		assertTrue(net.getBus("Bus1").getConnectBranch("Bus3->Bus1[2](1)") != null);

		assertTrue(net.getBus("Bus1").isActive());
		assertTrue(!net.getBus("Bus1", 1).isActive());
		assertTrue(!net.getBus("Bus1", 2).isActive());
	}

	public static Network buildTestNet() throws Exception  {
	  	Network net = CoreObjectFactory.createNetwork();
	  	net.setId("test net");
	  	net.setCheckElementDuplication(true);
	  	net.setAllowParallelBranch(false);
	  	
	  	Area area = CoreObjectFactory.createArea(1, net);
	  	Zone zone = CoreObjectFactory.createZone(1, net);

  		Bus bus1 = CoreObjectFactory.createBus("Bus1");
  		bus1.setBaseVoltage(1.0);
  		bus1.setAttributes("Bus 1", "", area, zone);
  		net.addBus(bus1);
  		
  		Bus bus1_1 = CoreObjectFactory.createBus("Bus1", 1, net);
  		bus1_1.setBaseVoltage(1.0);
  		bus1_1.setAttributes("Bus 1", "", area, zone);

  		Bus bus1_2 = CoreObjectFactory.createBus("Bus1", 2, net);
  		bus1_2.setBaseVoltage(1.0);
  		bus1_2.setAttributes("Bus 1", "", area, zone);

  		Bus bus2 = CoreObjectFactory.createBus("Bus2");
  		bus2.setBaseVoltage(1.0);
  		bus2.setAttributes("Bus 2", "", area, zone);
  		net.addBus(bus2);
  		
  		Bus bus3 = CoreObjectFactory.createBus("Bus3");
  		bus3.setBaseVoltage(1.0);
  		bus3.setAttributes("Bus 3", "", area, zone);
  		net.addBus(bus3);

  		Branch bra1 = CoreObjectFactory.createBranch();
  		bra1.setAttributes("Branch 1", "", "1");
  		net.addBranch(bra1, "Bus1", 1, "Bus2", 0);

  		Branch bra2 = CoreObjectFactory.createBranch();
		bra2.setAttributes("Branch 2", "", "1");
  		net.addBranch(bra2, "Bus2", "Bus3");

  		Branch bra3 = CoreObjectFactory.createBranch();
  		bra3.setAttributes("Branch 3", "", "1");
  		net.addBranch(bra3, "Bus3", 0, "Bus1", 2);
 		
  		//System.out.println(net.net2String());

  		return net;
	}
}

