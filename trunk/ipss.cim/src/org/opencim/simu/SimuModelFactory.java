 /*
  * @(#)SimuModelFactory.java   
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

package org.opencim.simu;

import org.opencim.cim.SimulationModel;
import org.opencim.cim.cimFactory;
import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.CoreFactory;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.cim.iec61970.domain.CompanyType;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.gen.production.ProductionFactory;
import org.opencim.cim.iec61970.load.EquivalentLoad;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.LoadFactory;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.iec61970.topology.TopologyFactory;
import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.cim.iec61970.wire.WireFactory;
import org.opencim.common.CIMLogger;
import org.opencim.datatype.exp.CIMException;
import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Voltage;
import org.opencim.datatype.util.UtilFunc;

/**
 * A factory class for creating CIM objects for the SimulationModel 
 *
 */
public class SimuModelFactory {
	/**
	 * Create a SimulationModel object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created SimulationModel object
	 * @throws CIMException
	 */
	public static SimulationModel createSimulationModel(String mRID, String name, String desc) throws CIMException {
		SimulationModel simuModel = cimFactory.eINSTANCE.createSimulationModel();
		setNamingAttrib(simuModel, mRID, name, desc);
		return simuModel;
	}
	
	/**
	 * Create a BasePower object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param baseMva the name attribute per CIM specification
	 * @return the created BasePower object
	 * @throws CIMException
	 */
	public static BasePower createBasePower(String mRID, double baseMva) throws CIMException {
		BasePower basePower = CoreFactory.eINSTANCE.createBasePower();
		setNamingAttrib(basePower, mRID, "Base Power: "+mRID, "");
		basePower.setBasePower(new ApparentPower(baseMva));  // power in MVA
		return basePower;
	}

	/**
	 * Create a BaseVoltage object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param baseKV the name attribute per CIM specification
	 * @return the created BaseVoltage object
	 * @throws CIMException
	 */
	public static BaseVoltage createBaseVoltage(String mRID, double baseKV) throws CIMException {
		BaseVoltage baseVolt = CoreFactory.eINSTANCE.createBaseVoltage();
		setNamingAttrib(baseVolt, mRID, "Base Voltage: "+mRID, "");
		baseVolt.setNominalVoltage(new Voltage(baseKV));   // voltage in kV
		return baseVolt;
	}

	/**
	 * Create a Company object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @param type the company type
	 * @return the created BaseVoltage object
	 * @throws CIMException
	 */
	public static Company createCompany(String mRID, String name, String desc, CompanyType type) throws CIMException {
		Company company = CoreFactory.eINSTANCE.createCompany();
		setNamingAttrib(company, mRID, name, desc);
		company.setCompanyType(type);
		return company;
	}

	/**
	 * Create a TopologicalIsland object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created TopologicalIsland object
	 * @throws CIMException
	 */
	public static TopologicalIsland createTopologicalIsland(String mRID, String name, String desc) throws CIMException {
		TopologicalIsland tisland = TopologyFactory.eINSTANCE.createTopologicalIsland();
		setNamingAttrib(tisland, mRID, name, desc);
		return tisland;
	}

	/**
	 * Create a TopologicalNode object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created TopologicalNode object
	 * @throws CIMException
	 */
	public static TopologicalNode createTopologicalNode(String mRID, String name, String desc) throws CIMException {
		TopologicalNode tnode = TopologyFactory.eINSTANCE.createTopologicalNode();
		setNamingAttrib(tnode, mRID, name, desc);
		return tnode;
	}

	/**
	 * Create a ConnectivityNode object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created ConnectivityNode object
	 * @throws CIMException
	 */
	public static ConnectivityNode createConnectivityNode(String mRID, String name, String desc) throws CIMException {
		ConnectivityNode cnode = TopologyFactory.eINSTANCE.createConnectivityNode();
		setNamingAttrib(cnode, mRID, name, desc);
		return cnode;
	}
	
	/**
	 * Create a Terminal object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Terminal object
	 * @throws CIMException
	 */
	public static Terminal createTerminal(String mRID, String name, String desc) throws CIMException {
		Terminal t = CoreFactory.eINSTANCE.createTerminal();
		setNamingAttrib(t, mRID, name, desc);
		return t;
	}

	/**
	 * Create a SubControlArea object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created SubControlArea object
	 * @throws CIMException
	 */
	public static SubControlArea createSubControlArea(String mRID, String name, String desc) throws CIMException {
		SubControlArea carea = CoreFactory.eINSTANCE.createSubControlArea();
		setNamingAttrib(carea, mRID, name, desc);
		return carea;
	}

	/**
	 * Create a Substation object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Substation object
	 * @throws CIMException
	 */
	public static Substation createSubstation(String mRID, String name, String desc) throws CIMException {
		Substation substation = CoreFactory.eINSTANCE.createSubstation();
		setNamingAttrib(substation, mRID, name, desc);
		return substation;
	}

	/**
	 * Create a VoltageLevel object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created VoltageLevel object
	 * @throws CIMException
	 */
	public static VoltageLevel createVoltageLevel(String mRID, String name, String desc) throws CIMException {
		VoltageLevel vlevel = CoreFactory.eINSTANCE.createVoltageLevel();
		setNamingAttrib(vlevel, mRID, name, desc);
		return vlevel;
	}

	/**
	 * Create a Bay object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Bay object
	 * @throws CIMException
	 */
	public static Bay createBay(String mRID, String name, String desc) throws CIMException {
		Bay bay = CoreFactory.eINSTANCE.createBay();
		setNamingAttrib(bay, mRID, name, desc);
		bay.setBayEnergyMeasFlag(false);
		bay.setBayPowerMeasFlag(false);
		return bay;
	}

	/**
	 * Create a LoadArea object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created LoadArea object
	 * @throws CIMException
	 */
	public static LoadArea createLoadArea(String mRID, String name, String desc) throws CIMException {
		LoadArea larea = LoadFactory.eINSTANCE.createLoadArea();
		setNamingAttrib(larea, mRID, name, desc);
		return larea;
	}
	
	/**
	 * Create a EnergyConsumer object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created EnergyConsumer object
	 * @throws CIMException
	 */
	public static EnergyConsumer createEnergyConsumer(String mRID, String name, String desc) throws CIMException {
		EnergyConsumer load = WireFactory.eINSTANCE.createEnergyConsumer();
		setNamingAttrib(load, mRID, name, desc);
		return load;
	}

	/**
	 * Create a EquivalentLoad object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created EquivalentLoad object
	 * @throws CIMException
	 */
	public static EquivalentLoad createEquivalentLoad(String mRID, String name, String desc) throws CIMException {
		EquivalentLoad load = LoadFactory.eINSTANCE.createEquivalentLoad();
		setNamingAttrib(load, mRID, name, desc);
		return load;
	}

	/**
	 * Create a GeneratingUnit object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created GeneratingUnit object
	 * @throws CIMException
	 */
	public static GeneratingUnit createGeneratingUnit(String mRID, String name, String desc) throws CIMException {
		GeneratingUnit gen = ProductionFactory.eINSTANCE.createGeneratingUnit();
		setNamingAttrib(gen, mRID, name, desc);
		return gen;
	}

	/**
	 * Create a SynchronousMachine object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created SynchronousMachine object
	 * @throws CIMException
	 */
	public static SynchronousMachine createSynchronousMachine(String mRID, String name, String desc) throws CIMException {
		SynchronousMachine gen = WireFactory.eINSTANCE.createSynchronousMachine();
		setNamingAttrib(gen, mRID, name, desc);
		return gen;
	}
	
	/**
	 * Create a Line object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Line object
	 * @throws CIMException
	 */	
	public static Line createLine(String mRID, String name, String desc) throws CIMException {
		Line line = WireFactory.eINSTANCE.createLine();
		setNamingAttrib(line, mRID, name, desc);
		return line;
	}

	/**
	 * Create a ACLineSegment object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created ACLineSegment object
	 * @throws CIMException
	 */
	public static ACLineSegment createACLineSegment(String mRID, String name, String desc) throws CIMException {
		ACLineSegment line = WireFactory.eINSTANCE.createACLineSegment();
		setNamingAttrib(line, mRID, name, desc);
		return line;
	}
	
	/**
	 * Create a PowerTransformer object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created PowerTransformer object
	 * @throws CIMException
	 */	
	public static PowerTransformer createPowerTransformer(String mRID, String name, String desc) throws CIMException {
		PowerTransformer xfr = WireFactory.eINSTANCE.createPowerTransformer();
		setNamingAttrib(xfr, mRID, name, desc);
		return xfr;
	}

	/**
	 * Create a TransformerWinding object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created TransformerWinding object
	 * @throws CIMException
	 */	
	public static TransformerWinding createTransformerWinding(String mRID, String name, String desc) throws CIMException {
		TransformerWinding xfrWinding = WireFactory.eINSTANCE.createTransformerWinding();
		setNamingAttrib(xfrWinding, mRID, name, desc);
		return xfrWinding;
	}

	private static void setNamingAttrib(Naming elem, String mRID, String name, String desc) throws CIMException {
		if (mRID == null || mRID.equals("") || UtilFunc.hasMRIDIlegalChar(mRID)) {
			CIMLogger.getLogger().severe("Element MRID is invalid, " + mRID);
			throw new CIMException("Element MRID is invalid, " + mRID);
		}
		elem.setMRID(mRID);
		elem.setName(name);
		elem.setDescription(desc);
		elem.setAliasName("AliasName");
		elem.setPathName("PathName");
	}
}
