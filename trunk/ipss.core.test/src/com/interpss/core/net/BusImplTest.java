 /*
  * @(#)BusImplTest.java   
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
import org.junit.*;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;

/**
 * @author mzhou
 *
 */
public class BusImplTest {
	/*
	 * Class under test for void setAttributes(String, String)
	 */
	@Test
	public void setAttributesStringStringTest() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Bus bus = net.getBus("Bus1");
	  	bus.setAttributes("name", "desc");
  		assertTrue(bus.getName().equals("name"));
  		assertTrue(bus.getDesc().equals("desc"));
	}

	/*
	 * Class under test for void setAttributes(String, String, Area, Zone)
	 */
	@Test
	public void setAttributesStringStringAreaZoneTest() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Bus bus = net.getBus("Bus1");
	  	Area area = CoreObjectFactory.createArea(2, net);
	  	Zone zone = CoreObjectFactory.createZone(3, net);
	  	bus.setAttributes("name", "desc", area, zone);
  		assertTrue(bus.getName().equals("name"));
  		assertTrue(bus.getDesc().equals("desc"));
  		assertTrue(bus.getArea().getNumber() == 2);
  		assertTrue(bus.getZone().getNumber() == 3);
	}

	@Test
	public void noBranchConnectedTest() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Bus bus1 = net.getBus("Bus1");
  		assertTrue(bus1.nBranchConnected() == 2);
	}

	@Test
	public void noNonGroundBranchConnectedTest() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Bus bus = net.getBus("Bus1");

	  	Branch bra = CoreObjectFactory.createBranch();
  		net.addBranch(bra, "Bus1", null);

  		assertTrue(bus.nBranchConnected() == 3);
  		assertTrue(bus.nNonGroundBranchConnected() == 2);
	}

	@Test
	public void getConnectBranchTest() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Bus bus = net.getBus("Bus1");
	  	assertTrue(bus.getConnectBranch("Bus1->Bus2(1)") != null);
	}

	/*
	 * Class under test for void setBaseVoltage(double, byte)
	 */
	@Test
	public void setBaseVoltagedoublebyteTest() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Bus bus = net.getBus("Bus1");
	  	bus.setBaseVoltage(10.0, UnitType.kV);
	  	assertTrue(bus.getBaseVoltage()-10000.0 < 0.01);
	}
}
