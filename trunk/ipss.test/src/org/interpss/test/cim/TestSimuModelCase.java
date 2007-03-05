 /*
  * @(#)TestSimuModelCase.java   
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

package org.interpss.test.cim;

import junit.framework.TestCase;

import org.opencim.cim.SimulationModel;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.datatype.Units;
import org.opencim.simu.SimuModelFactory;
import org.opencim.simu.SimuModelHelper;

public class TestSimuModelCase extends TestCase {
	public void testCase1() throws Exception {
  		System.out.println("TestSimuModelCase testCase1 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);

		// Base Power and Voltage
		// ======================
		sModelHelper.defineBasePower(100.0);  // power in MVA

		sModelHelper.addBaseVoltage("110.0kV", 110.0);
		sModelHelper.addBaseVoltage("35.0kV", 35.0);
  		
		assertTrue(simuModel.getBasePower().getBasePower().getValue() == 100.0);

		assertTrue(simuModel.getBaseVoltage("110.0kV").getNominalVoltage().getValue() == 110.0);
		assertTrue(simuModel.getBaseVoltage("35.0kV").getNominalVoltage().getValue() == 35.0);
		
		assertTrue(simuModel.getBasePower().getBaseVoltages().size() == 2);
		assertTrue(simuModel.getBaseVoltage("35.0kV").getBasePower().getBasePower().getValue() == 100.0);
		
  		System.out.println("TestSimuModelCase testCase1 ends");
	}

	public void testCase2() throws Exception {
  		System.out.println("TestSimuModelCase testCase2 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);

		// Base Power and Voltage
		// ======================
		sModelHelper.defineBasePower(100.0);  // power in MVA

		sModelHelper.addBaseVoltage("110.0kV", 110.0);
		sModelHelper.addBaseVoltage("35.0kV", 35.0);
		
		// Define Topological ojects
		// =========================
		TopologicalIsland tIsland = sModelHelper.addTopologicalIsland(
				"TIslandId", "TopolicalIslandName", "Sample TopolicalIsland Desc");

		TopologicalNode tnode = sModelHelper.addTopologicalNode(tIsland, "Bus-1", "Bus-1", "T-node, bus-1");

		sModelHelper.addConnectivityNode(tnode, "Bus-1_CNode-1", "Bus-1_CNode-1", "T-node, bus-1_CNode-1");
		sModelHelper.addConnectivityNode(tnode, "Bus-1_CNode-2", "Bus-1_CNode-2", "T-node, bus-1_CNode-2");

		tnode = sModelHelper.addTopologicalNode(tIsland, "Bus-2", "Bus-2", "T-node, bus-2");
		sModelHelper.addConnectivityNode(tnode, "Bus-2_CNode-1", "Bus-2_CNode-1", "T-node, bus-2_CNode-1");
  		
		tIsland = simuModel.getTopologicalIsland("TIslandId");
		assertTrue(tIsland != null);
		assertTrue(tIsland.getTopologicalNodes().size() == 2);

		TopologicalNode bus1 = simuModel.getTopologicalNode("Bus-1"); 
		assertTrue(bus1 != null);
		assertTrue(simuModel.getTopologicalNode("Bus-1", tIsland) != null);
		assertTrue(bus1.getTopologicalIsland().getMRID().equals("TIslandId"));
		
		TopologicalNode bus2 = simuModel.getTopologicalNode("Bus-2"); 
		assertTrue(bus2 != null);
		assertTrue(bus2.getTopologicalIsland().getMRID().equals("TIslandId"));

		ConnectivityNode cnode1 = simuModel.getConnectivityNode("Bus-1_CNode-1");
		assertTrue(cnode1 != null);
		assertTrue(cnode1.getTopologicalNode().getMRID().equals("Bus-1"));
		
		ConnectivityNode cnode2 = simuModel.getConnectivityNode("Bus-1_CNode-2");
		assertTrue(cnode2 != null);
		assertTrue(simuModel.getConnectivityNode("Bus-1_CNode-2", bus1) != null);

		ConnectivityNode cnode3 = simuModel.getConnectivityNode("Bus-2_CNode-1");
		assertTrue(cnode3 != null);

  		System.out.println("TestSimuModelCase testCase2 ends");
	}


	public void testCase3() throws Exception {
  		System.out.println("TestSimuModelCase testCase3 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);

		// Base Power and Voltage
		// ======================
		sModelHelper.defineBasePower(100.0);  // power in MVA

		BaseVoltage bVolt110kV = sModelHelper.addBaseVoltage("110.0kV", 110.0);
		BaseVoltage bVolt35kV = sModelHelper.addBaseVoltage("35.0kV", 35.0);
  		
		// Define Operational objects
		// ==========================
		SubControlArea carea = sModelHelper.addSubControlArea(
				"SubCArea-1", "SubControlAreaName", "Sample SubControlArea Desc");
		
		Substation sub = sModelHelper.addSubstation(carea, 
				"Sub-1", "Substation-1 Name", "Sample Substation-1 Desc");
		
		VoltageLevel vlevel = sModelHelper.addVoltageLevel(sub, "sub1-vLevel35kv", bVolt35kV, 36.0, 34.0);

		sModelHelper.addBay(vlevel, "sub1-vLevel35kv-bay", "BayName", "Sample Bay Desc");
		
		vlevel = sModelHelper.addVoltageLevel(sub, "sub1-vLevel110kv", bVolt110kV, 120.0, 100.0);

		sModelHelper.addBay(vlevel, "sub1-vLevel110kv-bay", "BayName", "Sample Bay Desc");

		SubControlArea subArea = simuModel.getSubControlArea("SubCArea-1");
		assertTrue(subArea != null);
		assertTrue(subArea.getSubstations().size() == 1);
		
		Substation substation = simuModel.getSubstation("Sub-1");
		assertTrue(substation != null);
		assertTrue(simuModel.getSubstation("Sub-1", subArea) != null);
		assertTrue(substation.getSubControlArea().getMRID().equals("SubCArea-1"));
		assertTrue(substation.getVoltageLevels().size() == 2);
		
		VoltageLevel v35kv = simuModel.getVoltageLevel("sub1-vLevel35kv");
		assertTrue(v35kv != null);
		assertTrue(v35kv.getBaseVoltage().getNominalVoltage().getValue() == 35.0);
		assertTrue(v35kv.getBaseVoltage().getNominalVoltage().getUnits().equals(Units.kV));
		
		VoltageLevel v110kv = simuModel.getVoltageLevel("sub1-vLevel110kv");
		assertTrue(v110kv != null);
		assertTrue(simuModel.getVoltageLevel("sub1-vLevel110kv", substation) != null);
		assertTrue(v110kv.getBaseVoltage().getNominalVoltage().getValue() == 110.0);

		assertTrue(v35kv.getBays().size() == 1);
		assertTrue(v110kv.getBays().size() == 1);
		
		Bay bay1 = simuModel.getBay("sub1-vLevel35kv-bay");
		assertTrue(bay1 != null);
		assertTrue(simuModel.getBay("sub1-vLevel35kv-bay", v35kv) != null);
		assertTrue(bay1.getVoltageLevel().getHighVoltageLimit().getValue() == 36.0);
		assertTrue(bay1.getVoltageLevel().getLowVoltageLimit().getValue() == 34.0);

		Bay bay2 = simuModel.getBay("sub1-vLevel110kv-bay");
		assertTrue(bay2 != null);
		assertTrue(simuModel.getBay("sub1-vLevel110kv-bay", v110kv) != null);
		assertTrue(bay2.getVoltageLevel().getHighVoltageLimit().getValue() == 120.0);
		assertTrue(bay2.getVoltageLevel().getLowVoltageLimit().getValue() == 100.0);

		System.out.println("TestSimuModelCase testCase3 ends");
	}	

	/**
	 * test MRID duplication
	 * 
	 * @throws Exception
	 */
	public void testCase4() throws Exception {
  		System.out.println("TestSimuModelCase testCase4 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);

		// Base Power and Voltage
		// ======================
		sModelHelper.defineBasePower(100.0);  // power in MVA

		BaseVoltage bVolt110kV = sModelHelper.addBaseVoltage("110.0kV", 110.0);
		BaseVoltage bVolt35kV = sModelHelper.addBaseVoltage("35.0kV", 35.0);
  		
		// Define Topological ojects
		// =========================
		TopologicalIsland tIsland = sModelHelper.addTopologicalIsland(
				"TIslandId", "TopolicalIslandName", "Sample TopolicalIsland Desc");

		TopologicalNode tnode = sModelHelper.addTopologicalNode(tIsland, "Bus-1", "Bus-1", "T-node, bus-1");

		sModelHelper.addConnectivityNode(tnode, "Bus-1_CNode-1", "Bus-1_CNode-1", "T-node, bus-1_CNode-1");
		sModelHelper.addConnectivityNode(tnode, "Bus-1_CNode-2", "Bus-1_CNode-2", "T-node, bus-1_CNode-2");

		tnode = sModelHelper.addTopologicalNode(tIsland, "Bus-2", "Bus-2", "T-node, bus-2");
		sModelHelper.addConnectivityNode(tnode, "Bus-2_CNode-1", "Bus-2_CNode-1", "T-node, bus-2_CNode-1");

		// Define Operational objects
		// ==========================
		SubControlArea carea = sModelHelper.addSubControlArea(
				"SubCArea-1", "SubControlAreaName", "Sample SubControlArea Desc");
		
		Substation sub = sModelHelper.addSubstation(carea, 
				"Sub-1", "Substation-1 Name", "Sample Substation-1 Desc");
		
		VoltageLevel vlevel = sModelHelper.addVoltageLevel(sub, "sub1-vLevel35kv", bVolt35kV, 36.0, 34.0);

		sModelHelper.addBay(vlevel, "sub1-vLevel35kv-bay", "BayName", "Sample Bay Desc");
		
		vlevel = sModelHelper.addVoltageLevel(sub, "sub1-vLevel110kv", bVolt110kV, 120.0, 100.0);

		sModelHelper.addBay(vlevel, "sub1-vLevel110kv-bay", "BayName", "Sample Bay Desc");

		assertTrue(sModelHelper.addTopologicalIsland("TIslandId", "", "") == null);
		assertTrue(sModelHelper.addTopologicalNode(tIsland, "Bus-1", "", "") == null);

		assertTrue(sModelHelper.addConnectivityNode(tnode, "Bus-1_CNode-1", "", "") == null);
		assertTrue(sModelHelper.addConnectivityNode(tnode, "Bus-1_CNode-2", "", "") == null);

		assertTrue(sModelHelper.addTopologicalNode(tIsland, "Bus-2", "", "") == null);
		assertTrue(sModelHelper.addConnectivityNode(tnode, "Bus-2_CNode-1", "", "") == null);
		
		assertTrue(sModelHelper.addSubControlArea("SubCArea-1", "", "") == null);
		assertTrue(sModelHelper.addSubstation(carea, "Sub-1", "", "") == null);
		assertTrue(sModelHelper.addVoltageLevel(sub, "sub1-vLevel35kv", bVolt35kV, 36.0, 34.0) == null);
		assertTrue(sModelHelper.addBay(vlevel, "sub1-vLevel35kv-bay", "", "") == null);
		assertTrue(sModelHelper.addVoltageLevel(sub, "sub1-vLevel110kv", bVolt110kV, 120.0, 100.0) == null);
		assertTrue(sModelHelper.addBay(vlevel, "sub1-vLevel110kv-bay", "", "") == null);
		
		System.out.println("TestSimuModelCase testCase4 ends");
	}	
}

