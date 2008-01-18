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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.ElementDuplicationException;
import com.interpss.common.exp.ElementNotFoundException;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;

public class NetRuleTest extends BaseTestSetup {
	/*
	 * Test duplication detacting, non-existing bus, parallel branch, ground branch
	 */
	@Test(expected=ElementDuplicationException.class)
	public void netTest1() {
	  	Network net = buildTestNet(); 

  		// Check bus duplicaiton detection
	  	Bus bus1 = net.getBus("Bus1");
  		assertEquals(true, bus1 != null);
		net.addBus(bus1);

		// add parallel branches
	  	net.setAllowParallelBranch(true);
  		Branch bra4 = CoreObjectFactory.createBranch();
  		net.addBranch(bra4, "Bus1", "Bus2");
  		Branch bra5 = CoreObjectFactory.createBranch();
  		net.addBranch(bra5, "Bus1", "Bus2");

  		// add a ground branch
  		Branch bra6 = CoreObjectFactory.createBranch();
  		net.addBranch(bra6, "Bus1", null);

  		assertEquals(true, bus1.getArea().getNumber() == 1);
  		assertEquals(true, bus1.getZone().getNumber() == 1);
  		
  		assertEquals(true, bus1.getConnectBranch("Bus1->Bus2(2)") != null);
  		assertEquals(true, bus1.getConnectBranch("Bus1->Bus2(1)") != null);
  		assertEquals(true, bus1.getConnectBranch("Bus1->Bus2(2)") != null);
  		assertEquals(true, bus1.getConnectBranch("Bus1->Bus2(3)") != null);

  		//System.out.println("nBranchConnected()" + bus1.nBranchConnected());
  		//System.out.println("nNonGroundBranchConnected()" + bus1.nNonGroundBranchConnected());
  		assertEquals(true, bus1.nBranchConnected() == 5);
  		assertEquals(true, bus1.nNonGroundBranchConnected() == 4);

  		assertEquals(true, (net.getBusList().size() == 3 && net.getBranchList().size() == 6));
	}

	@Test(expected=ElementNotFoundException.class)
	public void netTest2() {
	  	Network net = buildTestNet(); 
  		// check branch connecting to non-existing bus detection
  		Branch bra1 = net.getBranch("Bus1", "Bus2", "1");
  		assertEquals(true, bra1 != null);
		net.addBranch(bra1, "Bus4", "Bus2");
	}

	@Test(expected=ElementDuplicationException.class)
	public void netTest3() {
	  	Network net = buildTestNet(); 
  		// Check branch duplicaiton detection
	  	net.setAllowParallelBranch(false);
  		Branch bra1 = net.getBranch("Bus1", "Bus2", "1");
		net.addBranch(bra1, "Bus1", "Bus2");
	}

	@Test(expected=InvalidOperationException.class)
	public void removeBusBranchTest1() {
	  	Network net = buildTestNet(); 
	  	// Check removeBus with branches connected
	  	net.removeBus("Bus1");
	}

	@Test(expected=InvalidParameterException.class)
	public void removeBusBranchTest2() {
	  	Network net = buildTestNet(); 
	  	// Check removeBus, invalid bus id
	  	net.removeBus("Bus4");
	}

	@Test(expected=InvalidParameterException.class)
	public void removeBusBranchTest3() {
	  	Network net = buildTestNet(); 
	  	// Check removeBus, invalid bus id
	  	net.removeBranch("Bus1", "Bus2", "2");
	}

	@Test
	public void removeBusBranchTest4() {
	  	Network net = buildTestNet(); 
  		//System.out.println("Branch connected: " + net.getBus("Bus1").nBranchConnected());
  		net.removeBranch("Bus1", "Bus2", "1");
  		net.removeBranch("Bus3", "Bus1", "1");
  		//System.out.println("Branch connected: " + net.getBus("Bus1").nBranchConnected());
  		net.removeBus("Bus1");
  		assertEquals(true, (net.getBusList().size() == 2 && net.getBranchList().size() == 1));
	}

	@Test
	public void checkDataTest() {
	  	Network net = buildTestNet(); 
  		assertEquals(true, net.checkData(SpringAppContext.getIpssMsgHub()));
  		
  		// check for island bus
  		net.removeBranch("Bus1", "Bus2", "1");
  		net.removeBranch("Bus3", "Bus1", "1");
  		assertEquals(true, !net.checkData(SpringAppContext.getIpssMsgHub()));
  		
  		// check for missing bus
	  	net = buildTestNet(); 
  		net.setAllowGroundBranch(true);
  		Branch bra1 = CoreObjectFactory.createBranch();
  		net.addBranch(bra1, "Bus1", null);
  		assertEquals(true, net.checkData(SpringAppContext.getIpssMsgHub()));

  		net.setAllowGroundBranch(false);
  		assertEquals(true, !net.checkData(SpringAppContext.getIpssMsgHub()));
	}

    @Test
	public void test_eIsProxy() {
	  	Network net = buildTestNet(); 
  		System.out.println("\n");

  		assertEquals(true, !net.getBus("Bus1").eIsProxy());
  		assertEquals(true, !net.getBus("Bus2").eIsProxy());
  		assertEquals(true, !net.getBus("Bus3").eIsProxy());
  		
  		assertEquals(true, !net.getBranch("Bus1", "Bus2", "1").eIsProxy());
	}

	@Test(expected=InvalidParameterException.class)
	public void idTest1() {
		CoreObjectFactory.createBus("Bus1->");
	}

	@Test(expected=InvalidParameterException.class)
	public void idTest2() {
	  	CoreObjectFactory.createBus("Bus 1");
	}

	@Test(expected=InvalidParameterException.class)
	public void idTest3() {
  		CoreObjectFactory.createBus("Bus 1)");
	}

	@Test(expected=InvalidParameterException.class)
	public void idTest4() {
  		  	CoreObjectFactory.createBus("Bus (");
	}

	public static Network buildTestNet() {
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
  		net.addBranch(bra1, "Bus1", "Bus2");

  		Branch bra2 = CoreObjectFactory.createBranch();
		bra2.setAttributes("Branch 2", "", "1");
  		net.addBranch(bra2, "Bus2", "Bus3");

  		Branch bra3 = CoreObjectFactory.createBranch();
  		bra3.setAttributes("Branch 3", "", "1");
  		net.addBranch(bra3, "Bus3", "Bus1");
 		
  		//System.out.println("\n");
  		//System.out.println(net.net2String());

  		return net;
	}
}

