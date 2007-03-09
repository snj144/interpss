 /*
  * @(#)Sample_5BusSystem.java   
  *
  * Copyright (C) 2007 www.opencim.org
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
  * @Date 03/04/2007
  * 
  *   Revision History
  *   ================
  *
  */

/**
 * A 5-bus sample system to build a SimulationModel object
 */

package org.opencim.sample;

import org.opencim.cim.SimulationModel;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.cim.iec61970.domain.CompanyType;
import org.opencim.cim.iec61970.domain.GeneratorOperatingMode;
import org.opencim.cim.iec61970.domain.TransformerType;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.common.FileUtil;
import org.opencim.datatype.exp.CIMException;
import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.simu.GenerationHelper;
import org.opencim.simu.LoadHelper;
import org.opencim.simu.OperationHelper;
import org.opencim.simu.SimuModelFactory;
import org.opencim.simu.SimuModelHelper;
import org.opencim.simu.TopologyHelper;
import org.opencim.simu.WireHelper;

public class Sample_5BusSystem {
	public static void main(String[] args) {
		SimulationModel simuModel = createSimuModel();
		System.out.println(simuModel.toString());
		
		FileUtil.saveModel(simuModel, "cim/cim_5bus.xml", SimuModelHelper.SimuModel_FileExt);
		
//		simuModel = (SimulationModel)FileUtil.loadModel("cim/cim_5bus.xml", SimuModelHelper.SimuModel_FileExt);
//		System.out.println(simuModel.toString());
	}

	public static SimulationModel createSimuModel() {
		try {
			SimulationModel simuModel = SimuModelFactory.createSimulationModel(
					"OpenCIM-5BusTestSimuModel", "OpenCIM-5Bus", "A 5-bus system for OpenCIM testing purpose");
			SimuModelHelper  sModelHelper = new SimuModelHelper(simuModel);
			TopologyHelper   topoHelper = new TopologyHelper(simuModel);
			OperationHelper  resHelper = new OperationHelper(simuModel);
			LoadHelper       loadHelper = new LoadHelper(simuModel);
			GenerationHelper genHelper = new GenerationHelper(simuModel);
			WireHelper       wireHelper = new WireHelper(simuModel);

			Company companyOpenCIM = sModelHelper.addCompany("OpenCIM", "www.opencim.org", 
					"A open-source CIM implementation", CompanyType.POOL_LITERAL);
			
			TopologicalIsland tNet = topoHelper.addTopologicalIsland("TNetwork", "", "");


			SubControlArea subCArea = resHelper.addSubControlArea("SubCArea", "", "", companyOpenCIM);

			LoadArea loadArea = loadHelper.addLoadArea("LoadArea", "", "", companyOpenCIM);

			// Base Power and Voltage
			// ======================
			sModelHelper.defineBasePower(100.0);  // power in MVA

			BaseVoltage bVolt110kV = sModelHelper.addBaseVoltage("110.0kV", 110.0);
			BaseVoltage bVolt35kV = sModelHelper.addBaseVoltage("35.0kV", 35.0);
			BaseVoltage bVolt10kV = sModelHelper.addBaseVoltage("10.0kV", 10.0);
			
			// Define Topological objects
			// ==========================

			// Define Bus-1
			TopologicalNode  bus1_tn = topoHelper.addTopologicalNode(tNet, "Bus-1", "", "");
			ConnectivityNode bus1_cn = topoHelper.addConnectivityNode(bus1_tn, "Bus-1_CN-1", "", "");

			// Define Bus-2
			TopologicalNode  bus2_tn = topoHelper.addTopologicalNode(tNet, "Bus-2", "", "");
			ConnectivityNode bus2_cn = topoHelper.addConnectivityNode(bus2_tn, "Bus-2_CN-1", "", "");

			// Define Bus-3
			TopologicalNode  bus3_tn = topoHelper.addTopologicalNode(tNet, "Bus-3", "", "");
			ConnectivityNode bus3_cn = topoHelper.addConnectivityNode(bus3_tn, "Bus-3_CN-1", "", "");

			// Define Bus-4
			TopologicalNode  bus4_tn = topoHelper.addTopologicalNode(tNet, "Bus-4", "", "");
			ConnectivityNode bus4_cn = topoHelper.addConnectivityNode(bus4_tn, "Bus-4_CN-1", "", "");

			// Define Bus-5
			TopologicalNode  bus5_tn = topoHelper.addTopologicalNode(tNet, "Bus-5", "", "");
			ConnectivityNode bus5_cn = topoHelper.addConnectivityNode(bus5_tn, "Bus-5_CN-1", "", "");
			
			// Define Operational objects
			// ==========================

			// Substation-1
			Substation sub1 = resHelper.addSubstation(subCArea, "Sub-1", "", "");
			sub1.setLoadArea(loadArea);
			
			VoltageLevel sub1_10kv = resHelper.addVoltageLevel(sub1, "Sub1-VL10kv", bVolt10kV, 10.5, 9.5);
			Bay sub1_10kvBay = resHelper.addBay(sub1_10kv, "Sub1-VL10kv-Bay", "", "");
			
			VoltageLevel sub1_110kv = resHelper.addVoltageLevel(sub1, "Sus1-VL110kv", bVolt110kV, 120.0, 100.0);
			Bay sub1_110kvBay = resHelper.addBay(sub1_110kv, "Sus1-VL110kv-bay", "", "");

			// Substation-2
			Substation sub2 = resHelper.addSubstation(subCArea, "Sub-2", "", "");
			sub2.setLoadArea(loadArea);

			VoltageLevel sub2_35kv = resHelper.addVoltageLevel(sub2, "Sub2-VL35kv", bVolt35kV, 36.0, 34.0);
			Bay sub2_35kvBay = resHelper.addBay(sub2_35kv, "Sub2-VL35kv-Bay", "", "");
			
			VoltageLevel sub2_110kv = resHelper.addVoltageLevel(sub2, "Sus2-VL110kv", bVolt110kV, 120.0, 100.0);
			Bay sub2_110kvBay = resHelper.addBay(sub2_110kv, "Sus2-VL110kv-bay", "", "");

			// Substation-3
			Substation sub3 = resHelper.addSubstation(subCArea, "Sub-3", "", "");
			sub3.setLoadArea(loadArea);

			VoltageLevel sub3_110kv = resHelper.addVoltageLevel(sub3, "Sus3-VL110kv", bVolt110kV, 120.0, 100.0);
			Bay sub3_110kvBay = resHelper.addBay(sub3_110kv, "Sus3-VL110kv-bay", "", "");

			// Define Load objects
			// ===================
			loadHelper.addEquivalentLoad("Load@Bus-1", 20.0, 30.0, loadArea, sub3_110kvBay, bus1_cn);
			loadHelper.addEquivalentLoad("Load@Bus-2", 40.0, 50.0, loadArea, sub2_110kvBay, bus2_cn);
			loadHelper.addEquivalentLoad("Load@Bus-3", 10.0, 20.0, loadArea, sub1_110kvBay, bus3_cn);

			// Define Gen objects
			// ==================
			GeneratingUnit gen1 = genHelper.addGeneratingUnit(sub1_10kvBay, "Gen@Bus-4", "", "", subCArea);
			gen1.setInitialMW(new ActivePower(50.0));
			gen1.setGenOperatingMode(GeneratorOperatingMode.FIXED_LITERAL);
			genHelper.addSynchronousMachine(sub1_10kvBay, "Mach@Bus-4", "", "", gen1, bus4_cn);

			GeneratingUnit gen2 = genHelper.addGeneratingUnit(sub2_35kvBay, "Gen@Bus-5", "", "", subCArea);
			gen2.setInitialMW(new ActivePower(70.0));
			gen2.setGenOperatingMode(GeneratorOperatingMode.FIXED_LITERAL);
			genHelper.addSynchronousMachine(sub2_35kvBay, "Mach@Bus-5", "", "", gen2, bus5_cn);

			// Define Line objects
			// ===================
			Line line1 = wireHelper.addLine("Bus-2->Bus-3", "", "");
			ACLineSegment seg1 = wireHelper.addACLineSegment("Line1-seg1", "", "", line1, bus2_cn, bus3_cn);
			seg1.setR(new Resistance(0.1));
			seg1.setX(new Reactance(1.0));
			
			Line line2 = wireHelper.addLine("Bus-2->Bus-1", "", "");
			ACLineSegment seg2 = wireHelper.addACLineSegment("Line2-seg1", "", "", line2, bus2_cn, bus1_cn);
			seg2.setR(new Resistance(0.1));
			seg2.setX(new Reactance(1.0));
			
			Line line3 = wireHelper.addLine("Bus-1->Bus-3", "", "");
			ACLineSegment seg3 = wireHelper.addACLineSegment("Line3-seg1", "", "", line3, bus1_cn, bus3_cn);
			seg3.setR(new Resistance(0.1));
			seg3.setX(new Reactance(1.0));

			// Define Xfr objects
			// ==================
			PowerTransformer xfr1 = wireHelper.addPowerTransformer(sub1, "Xfr1", "", "");
			xfr1.setTransformerType(TransformerType.VOLTAGE_CONTROL_LITERAL);
			TransformerWinding w1 = wireHelper.addTransformerWinding(sub1, "W1-Xfr1", "", "", xfr1, bus4_cn);
			w1.setRatedMVA(new ApparentPower(100.0));
			w1.setR(new Resistance(0.01));
			w1.setX(new Reactance(0.1));
			TransformerWinding w2 = wireHelper.addTransformerWinding(sub1, "W2-Xfr1", "", "", xfr1, bus2_cn);
			w2.setRatedMVA(new ApparentPower(100.0));
			w2.setR(new Resistance(0.02));
			w2.setX(new Reactance(0.2));
			
			PowerTransformer xfr2 = wireHelper.addPowerTransformer(sub2, "Xfr2", "", "");
			xfr2.setTransformerType(TransformerType.VOLTAGE_CONTROL_LITERAL);
			w1 = wireHelper.addTransformerWinding(sub2, "W1-Xfr2", "", "", xfr2, bus5_cn);
			w1.setRatedMVA(new ApparentPower(70.0));
			w1.setR(new Resistance(0.01));
			w1.setX(new Reactance(0.1));
			w2 = wireHelper.addTransformerWinding(sub2, "W2-Xfr2", "", "", xfr2, bus3_cn);
			w2.setRatedMVA(new ApparentPower(70.0));
			w2.setR(new Resistance(0.02));
			w2.setX(new Reactance(0.2));

			return simuModel;
		} catch (CIMException e) {
			e.printStackTrace();
		}
		return null;
	}
}
