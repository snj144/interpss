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
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.cim.iec61970.domain.CompanyType;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.datatype.Units;
import org.opencim.simu.GenerationHelper;
import org.opencim.simu.LoadHelper;
import org.opencim.simu.OperationHelper;
import org.opencim.simu.SimuModelFactory;
import org.opencim.simu.SimuModelHelper;
import org.opencim.simu.TopologyHelper;
import org.opencim.simu.WireHelper;

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
		TopologyHelper   topoHelper = new TopologyHelper(simuModel);
		
	    setSampleSimuModel(simuModel);
		
	    TopologicalIsland tIsland = topoHelper.getTopologicalIsland("TIslandId");
		assertTrue(tIsland != null);
		assertTrue(tIsland.getTopologicalNodes().size() == 2);

		TopologicalNode bus1 = topoHelper.getTopologicalNode("Bus-1"); 
		assertTrue(bus1 != null);
		assertTrue(topoHelper.getTopologicalNode("Bus-1", tIsland) != null);
		assertTrue(bus1.getTopologicalIsland().getMRID().equals("TIslandId"));
		
		TopologicalNode bus2 = topoHelper.getTopologicalNode("Bus-2"); 
		assertTrue(bus2 != null);
		assertTrue(bus2.getTopologicalIsland().getMRID().equals("TIslandId"));

		ConnectivityNode cnode1 = topoHelper.getConnectivityNode("Bus-1_CNode-1");
		assertTrue(cnode1 != null);
		assertTrue(cnode1.getTopologicalNode().getMRID().equals("Bus-1"));
		
		ConnectivityNode cnode2 = topoHelper.getConnectivityNode("Bus-1_CNode-2");
		assertTrue(cnode2 != null);
		assertTrue(topoHelper.getConnectivityNode("Bus-1_CNode-2", bus1) != null);

		ConnectivityNode cnode3 = topoHelper.getConnectivityNode("Bus-2_CNode-2");
		assertTrue(cnode3 != null);

		System.out.println("TestSimuModelCase testCase2 ends");
	}


	public void testCase3() throws Exception {
  		System.out.println("TestSimuModelCase testCase3 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);
		OperationHelper resHelper = new OperationHelper(simuModel);
		
	    setSampleSimuModel(simuModel);

		SubControlArea subArea = resHelper.getSubControlArea("SubCArea-1");
		assertTrue(subArea != null);
		assertTrue(subArea.getCompanies().size() == 1);
		assertTrue(simuModel.getCompany("OpenCIM").getPSRs().size() == 2);  // SubCArea and LoadArea
		assertTrue(subArea.getSubstations().size() == 1);
		
		Substation substation = resHelper.getSubstation("Sub-1");
		assertTrue(substation != null);
		assertTrue(resHelper.getSubstation("Sub-1", subArea) != null);
		assertTrue(substation.getSubControlArea().getMRID().equals("SubCArea-1"));
		assertTrue(substation.getVoltageLevels().size() == 2);
		
		VoltageLevel v35kv = resHelper.getVoltageLevel("sub1-vLevel35kv");
		assertTrue(v35kv != null);
		assertTrue(v35kv.getBaseVoltage().getNominalVoltage().getValue() == 35.0);
		assertTrue(v35kv.getBaseVoltage().getNominalVoltage().getUnits().equals(Units.kV));
		
		VoltageLevel v110kv = resHelper.getVoltageLevel("sub1-vLevel110kv");
		assertTrue(v110kv != null);
		assertTrue(resHelper.getVoltageLevel("sub1-vLevel110kv", substation) != null);
		assertTrue(v110kv.getBaseVoltage().getNominalVoltage().getValue() == 110.0);

		assertTrue(v35kv.getBays().size() == 1);
		assertTrue(v110kv.getBays().size() == 1);
		
		Bay bay1 = resHelper.getBay("sub1-vLevel35kv-bay");
		assertTrue(bay1 != null);
		assertTrue(resHelper.getBay("sub1-vLevel35kv-bay", v35kv) != null);
		assertTrue(bay1.getVoltageLevel().getHighVoltageLimit().getValue() == 36.0);
		assertTrue(bay1.getVoltageLevel().getLowVoltageLimit().getValue() == 34.0);

		Bay bay2 = resHelper.getBay("sub1-vLevel110kv-bay");
		assertTrue(bay2 != null);
		assertTrue(resHelper.getBay("sub1-vLevel110kv-bay", v110kv) != null);
		assertTrue(bay2.getVoltageLevel().getHighVoltageLimit().getValue() == 120.0);
		assertTrue(bay2.getVoltageLevel().getLowVoltageLimit().getValue() == 100.0);

		System.out.println("TestSimuModelCase testCase3 ends");
	}	

	/**
	 * test MRID duplication
	 * 
	 * @throws Exception
	 */
	public void xtestCase4() throws Exception {
  		System.out.println("TestSimuModelCase testCase4 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);
		TopologyHelper   topoHelper = new TopologyHelper(simuModel);
		OperationHelper resHelper = new OperationHelper(simuModel);
		
	    setSampleSimuModel(simuModel);

	    TopologicalIsland tIsland = topoHelper.getTopologicalIsland("TIslandId");
		assertTrue(topoHelper.addTopologicalIsland("TIslandId", "", "") == null);
		assertTrue(topoHelper.addTopologicalNode(tIsland, "Bus-1", "", "") == null);

		TopologicalNode tnode = topoHelper.getTopologicalNode("Bus-1"); 
		assertTrue(topoHelper.addConnectivityNode(tnode, "Bus-1_CNode-1", "", "") == null);
		assertTrue(topoHelper.addConnectivityNode(tnode, "Bus-1_CNode-2", "", "") == null);

		assertTrue(topoHelper.addTopologicalNode(tIsland, "Bus-2", "", "") == null);
		assertTrue(topoHelper.addConnectivityNode(tnode, "Bus-2_CNode-2", "", "") == null);
		
		assertTrue(resHelper.addSubControlArea("SubCArea-1", "", "", null) == null);

		SubControlArea carea = resHelper.getSubControlArea("SubCArea-1");
		assertTrue(resHelper.addSubstation(carea, "Sub-1", "", "") == null);
		
		Substation sub = resHelper.getSubstation("Sub-1");
		BaseVoltage bVolt35kV = sModelHelper.addBaseVoltage("35.0kV", 35.0);
		assertTrue(resHelper.addVoltageLevel(sub, "sub1-vLevel35kv", bVolt35kV, 36.0, 34.0) == null);

		VoltageLevel v35kv = resHelper.getVoltageLevel("sub1-vLevel35kv");
		assertTrue(resHelper.addBay(v35kv, "sub1-vLevel35kv-bay", "", "") == null);
		BaseVoltage bVolt110kV = sModelHelper.addBaseVoltage("110.0kV", 110.0);
		assertTrue(resHelper.addVoltageLevel(sub, "sub1-vLevel110kv", bVolt110kV, 120.0, 100.0) == null);

		VoltageLevel v110kv = resHelper.getVoltageLevel("sub1-vLevel110kv");
		assertTrue(resHelper.addBay(v110kv, "sub1-vLevel110kv-bay", "", "") == null);
		
		System.out.println("TestSimuModelCase testCase4 ends");
	}	

	/**
	 * test Load and Gen
	 * 
	 * @throws Exception
	 */
	public void testCase5() throws Exception {
  		System.out.println("TestSimuModelCase testCase5 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		OperationHelper  resHelper = new OperationHelper(simuModel);
		LoadHelper       loadHelper = new LoadHelper(simuModel);
		GenerationHelper genHelper = new GenerationHelper(simuModel);
		
	    setSampleSimuModel(simuModel);

//		loadHelper.addEquivalentLoad("Load1", 20.0, 30.0, loadArea, bay35kv, t1);
//		loadHelper.addEquivalentLoad("Load2", 40.0, 50.0, loadArea, bay110kv, t2);

	    assertTrue(loadHelper.getEquivalentLoad("Load1") != null);
		Bay bay35kv = resHelper.getBay("sub1-vLevel35kv-bay");
		EnergyConsumer load1 = loadHelper.getEnergyConsumer("Load1", bay35kv);
	    assertTrue(load1 != null);
	    assertTrue(load1.getLoadArea().getMRID().equals("LoadAreaId"));
	    assertTrue(load1.getTerminals().size() == 1);
	    assertTrue(load1.getBaseVoltage().getNominalVoltage().getValue() == 35.0);
	    assertTrue(load1.getPfixed().getValue() == 20.0);
	    assertTrue(load1.getQfixed().getValue() == 30.0);
	    
	    assertTrue(loadHelper.getEquivalentLoad("Load2") != null);
		Bay bay110kv = resHelper.getBay("sub1-vLevel110kv-bay");
	    assertTrue(loadHelper.getEnergyConsumer("Load2", bay110kv) != null);

//		GeneratingUnit gen = genHelper.addGeneratingUnit(bay35kv, "Gen1", "name", "desc", carea);
//		SynchronousMachine mach = genHelper.addSynchronousMachine(bay35kv, "Mach1", "name", "desc", gen, t3);

	    GeneratingUnit gen = genHelper.getGeneratingUnit("Gen1");
	    assertTrue(gen != null);
	    assertTrue(genHelper.getGeneratingUnit("Gen1", bay35kv) != null);

	    SynchronousMachine mach = genHelper.getSynchronousMachine("Mach1");
	    assertTrue(mach != null);
	    assertTrue(mach.getTerminals().size() == 1);
	    assertTrue(mach.getGeneratingUnit().getMRID().equals("Gen1"));
	    assertTrue(mach.getBaseVoltage().getNominalVoltage().getValue() == 35.0);
	    assertTrue(genHelper.getSynchronousMachine("Mach1", bay35kv) != null);
	    
	    System.out.println("TestSimuModelCase testCase5 ends");
	}	

	/**
	 * test Line and Xfr
	 * 
	 * @throws Exception
	 */
	public void testCase6() throws Exception {
  		System.out.println("TestSimuModelCase testCase6 begins ...");
  		
		SimulationModel simuModel = SimuModelFactory.createSimulationModel(
				"simuModelId", "OpenCIM", "Sample OpenCIM Simulation Model");
		OperationHelper  resHelper = new OperationHelper(simuModel);
		LoadHelper       loadHelper = new LoadHelper(simuModel);
		GenerationHelper genHelper = new GenerationHelper(simuModel);
		WireHelper       wireHelper = new WireHelper(simuModel);		
		TopologyHelper   topoHelper = new TopologyHelper(simuModel);
		
	    setSampleSimuModel(simuModel);

//		Line line = wireHelper.addLine("Bus-1->Bus-2", "name", "desc");
//		wireHelper.addACLineSegment("Bus-1->Bus-2-seg-1", "name", "desc", line, t4, t5);
	    Line line = wireHelper.getLine("Bus-1->Bus-2");
	    assertTrue(line != null);
	    assertTrue(line.getACLineSegments().size() == 1);
	    
	    ACLineSegment lseg = wireHelper.getACLineSegment("Bus-1->Bus-2-seg-1");
	    assertTrue(lseg != null);
	    assertTrue(wireHelper.getACLineSegment("Bus-1->Bus-2-seg-1", line) != null);
	    assertTrue(lseg.getTerminals().size() == 2);
	    
//		PowerTransformer xfr = wireHelper.addPowerTransformer(sub, "T-Bus-1->Bus-2", "name", "desc");
//		wireHelper.addTransformerWinding(sub, "W1-Bus-1->Bus-2", "name", "desc", xfr, t6);
//		wireHelper.addTransformerWinding(sub, "W2-Bus-1->Bus-2", "name", "desc", xfr, t7);		
		PowerTransformer xfr = wireHelper.getPowerTransformer("T-Bus-1->Bus-2");
	    assertTrue(xfr != null);
	    assertTrue(xfr.getEquipmentContainer().getMRID().equals("Sub-1"));
	    Substation sub = resHelper.getSubstation("Sub-1");
	    assertTrue(wireHelper.getPowerTransformer("T-Bus-1->Bus-2", sub) != null);

	    assertTrue(xfr.getTransformerWindings().size() == 2);
	    TransformerWinding w1 = wireHelper.getTransformerWinding("W1-Bus-1->Bus-2");
	    TransformerWinding w2 = wireHelper.getTransformerWinding("W2-Bus-1->Bus-2");		
	    assertTrue(w1 != null);
	    assertTrue(w2 != null);
	    assertTrue(wireHelper.getTransformerWinding("W1-Bus-1->Bus-2", sub) != null);
	    assertTrue(wireHelper.getTransformerWinding("W2-Bus-1->Bus-2", sub) != null);
	    assertTrue(w1.getPowerTransformer().getMRID().equals("T-Bus-1->Bus-2"));
	    assertTrue(w2.getPowerTransformer().getMRID().equals("T-Bus-1->Bus-2"));

	    System.out.println("TestSimuModelCase testCase6 ends");
	}	

	private void setSampleSimuModel(SimulationModel simuModel) {
		SimuModelHelper sModelHelper = new SimuModelHelper(simuModel);
		OperationHelper resHelper = new OperationHelper(simuModel);
		TopologyHelper   topoHelper = new TopologyHelper(simuModel);
		LoadHelper       loadHelper = new LoadHelper(simuModel);
		GenerationHelper genHelper = new GenerationHelper(simuModel);
		WireHelper       wireHelper = new WireHelper(simuModel);		
		
		Company company = sModelHelper.addCompany("OpenCIM", "CompanyName", "", CompanyType.POOL_LITERAL);
		LoadArea loadArea = loadHelper.addLoadArea("LoadAreaId", "LoadAreaName", "Sample LoadArea Desc", company);
		
		// Base Power and Voltage
		// ======================
		sModelHelper.defineBasePower(100.0);  // power in MVA

		BaseVoltage bVolt110kV = sModelHelper.addBaseVoltage("110.0kV", 110.0);
		BaseVoltage bVolt35kV = sModelHelper.addBaseVoltage("35.0kV", 35.0);
  		
		// Define Topological objects
		// ==========================
		TopologicalIsland tIsland = topoHelper.addTopologicalIsland("TIslandId", "TopolicalIslandName", "Sample TopolicalIsland Desc");

		TopologicalNode tn1 = topoHelper.addTopologicalNode(tIsland, "Bus-1", "Bus-1", "T-node, bus-1");
		ConnectivityNode cn1 = topoHelper.addConnectivityNode(tn1, "Bus-1_CNode-1", "Bus-1_CNode-1", "T-node, bus-1_CNode-1");
		ConnectivityNode cn2 = topoHelper.addConnectivityNode(tn1, "Bus-1_CNode-2", "Bus-1_CNode-2", "T-node, bus-1_CNode-2");

		TopologicalNode tn2 = topoHelper.addTopologicalNode(tIsland, "Bus-2", "Bus-2", "T-node, bus-2");
		ConnectivityNode cn3 = topoHelper.addConnectivityNode(tn2, "Bus-2_CNode-2", "Bus-2_CNode-2", "T-node, bus-2_CNode-2");
		
		// Define Operational objects
		// ==========================
		SubControlArea carea = resHelper.addSubControlArea(
				"SubCArea-1", "SubControlAreaName", "Sample SubControlArea Desc", company);
		
		Substation sub = resHelper.addSubstation(carea, 
				"Sub-1", "Substation-1 Name", "Sample Substation-1 Desc");
		sub.setLoadArea(loadArea);
		
		VoltageLevel vlevel = resHelper.addVoltageLevel(sub, "sub1-vLevel35kv", bVolt35kV, 36.0, 34.0);

		Bay bay35kv = resHelper.addBay(vlevel, "sub1-vLevel35kv-bay", "BayName", "Sample Bay Desc");
		
		vlevel = resHelper.addVoltageLevel(sub, "sub1-vLevel110kv", bVolt110kV, 120.0, 100.0);

		Bay bay110kv = resHelper.addBay(vlevel, "sub1-vLevel110kv-bay", "BayName", "Sample Bay Desc");    
		
		// Define Load objects
		// ===================
		loadHelper.addEquivalentLoad("Load1", 20.0, 30.0, loadArea, bay35kv, cn1);
		loadHelper.addEquivalentLoad("Load2", 40.0, 50.0, loadArea, bay110kv, cn1);

		// Define Gen objects
		// ==================
		GeneratingUnit gen = genHelper.addGeneratingUnit(bay35kv, "Gen1", "name", "desc", carea);
		genHelper.addSynchronousMachine(bay35kv, "Mach1", "name", "desc", gen, cn1);
		
		// Line and Xfr
		Line line = wireHelper.addLine("Bus-1->Bus-2", "name", "desc");
		wireHelper.addACLineSegment("Bus-1->Bus-2-seg-1", "name", "desc", line, cn1, cn2);

		PowerTransformer xfr = wireHelper.addPowerTransformer(sub, "T-Bus-1->Bus-2", "name", "desc");
		wireHelper.addTransformerWinding(sub, "W1-Bus-1->Bus-2", "name", "desc", xfr, cn1);
		wireHelper.addTransformerWinding(sub, "W2-Bus-1->Bus-2", "name", "desc", xfr, cn2);		
	}
}

