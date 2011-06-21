 /*
  * @(#)BranchImplTest.java   
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

package org.interpss.test.simu.core.net;

import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;

/**
 * @author mzhou
 *
 */
public class BranchImplTest extends TestBaseAppCtx {
  	
	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.net.test.BranchImplTest ...");
	}

	/*
	 * Class under test for void setAttributes(String, String, int)
	 */
	public void testSetAttributesStringStringint() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Branch bra = net.getBranch("Bus1->Bus2(1)");
	  	bra.setAttributes("name", "desc", "2");
  		assertTrue(bra.getName().equals("name"));
  		assertTrue(bra.getDesc().equals("desc"));
  		assertTrue(bra.getCircuitNumber().equals("2"));
	}

	/*
	 * Class under test for void setAttributes(String, String, int, Area, Zone)
	 */
	public void testSetAttributesStringStringintAreaZone() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Branch bra = net.getBranch("Bus1->Bus2(1)");
	  	Area area = CoreObjectFactory.createArea(2, net);
	  	Zone zone = CoreObjectFactory.createZone(3, net);
	  	bra.setAttributes("name", "desc", "2", area, zone);
  		assertTrue(bra.getName().equals("name"));
  		assertTrue(bra.getDesc().equals("desc"));
  		assertTrue(bra.getCircuitNumber().equals("2"));
  		assertTrue(bra.getArea().getNumber() == 2);
  		assertTrue(bra.getZone().getNumber() == 3);  		
  	}

	public void testIsGroundBranch() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	Branch bra = CoreObjectFactory.createBranch();
  		net.addBranch(bra, "Bus1", null);
  		assertTrue(bra.isGroundBranch());  		
  	}

	public void testEnd() {
 		System.out.println("End com.interpss.core.net.test.BranchImplTest");
	}
}