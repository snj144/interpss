 /*
  * @(#)NetworkImplTest.java   
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

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.NetPackage;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;

/**
 * @author mzhou
 *
 */
public class NetworkImplTest extends TestBaseAppCtx {
  	private ResourceSet resourceSet = null;

  	public NetworkImplTest() {
  		super();
  		
	  	this.resourceSet = new ResourceSetImpl();
	  	// the following registeration only needed for stand-alone applicaiton.
	  	this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	  			"net", new XMIResourceFactoryImpl()); 	
	  	NetPackage packageInstance = NetPackage.eINSTANCE;
  	}
  	
	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.net.test.NetworkImplTest ...");
	}
	
	public void testSetToEmpty() {
		Network net = createSimpleNet();
  		assertTrue(net.getBusList().size() == 3);
  		assertTrue(net.getBranchList().size() == 3);
  		net.setToEmpty();
  		assertTrue(net.getBusList().size() == 0);
  		assertTrue(net.getBranchList().size() == 0);
	}

	/*
	 * Class under test for Area getArea(int)
	 */
	public void testGetAreaint() {
		Network net = createSimpleNet();
  		assertTrue(net.getArea(1) != null);
	}

	/*
	 * Class under test for Zone getZone(int, int)
	 */
	public void testGetZoneintint() {
		Network net = createSimpleNet();
		assertTrue(net.getZone(1) != null);
	}

	public void testGetNoBus() {
		Network net = createSimpleNet();
		assertTrue(net.getNoBus() == 3);
	}

	public void testGetBus() {
		Network net = createSimpleNet();

		Bus bus1 = net.getBus("Bus1");
		assertTrue(bus1.getFromBranchList().size() == 1);
  		assertTrue(bus1.getToBranchList().size() == 1);
  		assertTrue(bus1.getBranchList().size() == 2);

		Bus bus2 = net.getBus("Bus2");
  		assertTrue(bus2.getFromBranchList().size() == 1);
  		assertTrue(bus2.getToBranchList().size() == 1);

		Bus bus3 = net.getBus("Bus3");
  		assertTrue(bus3.getBranchList().size() == 2);
  	}
	
	public void testGetBusList() {
		Network net = createSimpleNet();
  		assertTrue(net.getBusList().size() == 3);
	}

	public void testGetBranchList() {
		Network net = createSimpleNet();
  		assertTrue(net.getBranchList().size() == 3);
	}

	public void testGetNoBranch() {
		Network net = createSimpleNet();
		assertTrue(net.getNoBranch() == 3);
	}

	/*
	 * Class under test for Branch getBranch(String)
	 */
	public void testGetBranchString() {
		Network net = NetRuleTest.buildTestNet();
		Branch bra1 = net.getBranch("Bus1->Bus2(1)");
		assertTrue(bra1 != null);
  	}

	/*
	 * Class under test for Branch getBranch(String, String)
	 */
	public void testGetBranchStringString() {
		Network net = NetRuleTest.buildTestNet();
		Branch bra1 = net.getBranch("Bus1", "Bus2");
		assertTrue(bra1 != null);
  	}

	/*
	 * Class under test for Branch getBranch(String, String, int)
	 */
	public void testGetBranchStringStringint() {
		Network net = NetRuleTest.buildTestNet();
		Branch bra1 = net.getBranch("Bus1", "Bus2", "1");
		assertTrue(bra1 != null);
	}

	/*
	 * tested in the NetRuleTest.java
	 */
	public void testRemoveBranchStringStringint() {
	}

	/*
	 * tested in the NetRuleTest.java
	 */
	public void testRemoveBranchBusBusint() {
	}
	
	/*
	 * Test creating a simple network by using the network object creation methods
	 */
	public void testBuildSimpleNet() {
	  	Network net = NetRuleTest.buildTestNet(); 

  		assertEquals(true, (net.getBusList().size() == 3 && net.getBranchList().size() == 3));
  		System.out.println("\nBuild a simple network case_2, sccessful");
	}

	/*
	 * Test save network object to an xml file
	 */
	public void testSaveFile() {
	  	Network net = NetRuleTest.buildTestNet(); 
	  	
	  	String path = new File("testData/testNetwork.net").getAbsolutePath();
  		//System.out.println("path: " + path);
	  	URI fileURI = URI.createFileURI(path);
	  	Resource netRe = this.resourceSet.createResource(fileURI);
	  	netRe.getContents().add(net);
	  	try {
	  		netRe.save(null);
	  		System.out.println("\ntestNetwork.net created, path: " + path);
	  	} catch (Exception e) {
	  		System.out.println("Save net file failed, " + e);
	  		e.printStackTrace();
	  		return;
	  	}
	  	
  		System.out.println("Net test, save file sucessful");
	}
	  	
	/*
	 * Test loading a network object from an xml file
	 */
	public void testLoadFile() {
	  	Network net = loadNetwork("testData/testNetwork.net");
  		assertEquals(true, (net.getBusList().size() == 3 && net.getBranchList().size() == 3));
  		System.out.println("Net test, load file sucessful");
	}

	public void testEnd() {
 		System.out.println("End com.interpss.core.net.test.NetworkImplTest");
	}
	
	private Network loadNetwork(String filename) {
	  	String path = new File(filename).getAbsolutePath();
  		//System.out.println("path: " + path);
	  	URI fileURI = URI.createFileURI(path);
	  	Resource netRe = this.resourceSet.getResource(fileURI, true);
	  	Network net = (Network)netRe.getContents().get(0);
  		System.out.println("\nNetwork object loaded, xml file path: " + path);
  		return net;
	}

	public Network createSimpleNet() {
	  	Network net = CoreObjectFactory.createNetwork();
	  	
	  	Area area1 = CoreObjectFactory.createArea(1, net);
	  	Zone zone1 = CoreObjectFactory.createZone(1, net);
	  	assertTrue(net.getZoneList().size() == 1);
	  	assertTrue(net.getAreaList().size() == 1);
	  	
	  	/* duplication area and zone already added when created
	  	area1.getZoneList().add(zone1);
	  	net.getAreaList().add(area1);
	  	*/
	  	
  		Bus bus1 = CoreObjectFactory.createBus("Bus1");
  		bus1.setName("Bus 1");
  		bus1.setArea(area1);
  		bus1.setZone(zone1);
  		net.getBusList().add(bus1);
  		
  		Bus bus2 = CoreObjectFactory.createBus("Bus2");
  		bus2.setId("Bus2");
  		bus2.setName("Bus 2");
  		bus2.setArea(area1);
  		bus2.setZone(zone1);
  		net.getBusList().add(bus2);

  		Bus bus3 = CoreObjectFactory.createBus("Bus3");
  		bus3.setId("Bus3");
  		bus3.setName("Bus 3");
  		bus3.setArea(area1);
  		bus3.setZone(zone1);
  		net.getBusList().add(bus3);

  		Branch bra1 = CoreObjectFactory.createBranch();
  		bra1.setId("1->2");
  		bra1.setName("Branch 1->2");
  		bra1.setFromBus(bus1);
  		bra1.setToBus(bus2);
  		net.getBranchList().add(bra1);
  		
  		Branch bra2 = CoreObjectFactory.createBranch();
  		bra2.setId("2->3");
  		bra2.setName("Branch 2->3");
  		bra2.setFromBus(bus2);
  		bra2.setToBus(bus3);
  		net.getBranchList().add(bra2);

  		Branch bra3 = CoreObjectFactory.createBranch();
  		bra3.setId("3->1");
  		bra3.setName("Branch 3->1");
  		bra3.setFromBus(bus3);
  		bra3.setToBus(bus1);
  		net.getBranchList().add(bra3);

  		return net;
	}	
}
