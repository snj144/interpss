 /*
  * @(#)SimuModelHelper.java   
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

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.opencim.cim.SimulationModel;
import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.cim.iec61970.domain.CompanyType;
import org.opencim.common.CIMLogger;
import org.opencim.datatype.exp.CIMException;

/**
 * A helper class for a root level simulation model object. It holds a ref to the object and has methods
 * to manipulate the object. 
 *
 */
public class SimuModelHelper {
	public static String SimuModel_FileExt = "xml";
	/**
	 * BasePower object MRID
	 */
	public static final String MRID_BasePower = "BasePower"; 
	
	private SimulationModel model = null;

	/**
	 * constructor
	 * 
	 * @param model a SimulationModel object
	 */
	public SimuModelHelper(SimulationModel model) {
		this.model = model;
	}
	
	/**
	 * Defined the base power for the simulation object. There should be only one such a object
	 * 
	 * @param mva base power mva
	 * @return true if base power is defined properly
	 */
	public boolean defineBasePower(double mva) {
		try {
			BasePower basePower = SimuModelFactory.createBasePower(MRID_BasePower, mva);  // power in MVA
			model.setBasePower(basePower);
			return true;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in defining BasePower, " + e.toString());
		}
		return false;
	}

	/**
	 * Add a base voltage to the simulation object by creating a BaseVoltage object.
	 * 
	 * @param mrid BaseVoltage object MRID, has to be unique
	 * @param kv base voltage kv
	 * @return the created BaseVoltage object, null if there is an error
	 */
	public BaseVoltage addBaseVoltage(String mRID, double kv) {
		if (model.getBaseVoltage(mRID) != null) {
			CIMLogger.getLogger().severe("Error in adding BaseVoltage, MRID duplication");
			return null;
		}
		try {
			BaseVoltage baseVolt = SimuModelFactory.createBaseVoltage(mRID, kv);
			model.getBasePower().getBaseVoltages().add(baseVolt);
			return baseVolt;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding BaseVoltage, " + e.toString());
		}
		return null;
	}

	/**
	 * Add a Company object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @param type company type	 
	 * @return the created Company object
	 */
	public Company addCompany(String mRID, String name, String desc, CompanyType type) {
		if (model.getCompany(mRID) != null) {
			CIMLogger.getLogger().severe("Error in adding Company, MRID duplication");
			return null;
		}
		try {
			Company company = SimuModelFactory.createCompany(mRID, name, desc, type);
			model.getCompanies().add(company);
			return company;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding Company, " + e.toString());
		}
		return null;
	}
	
	/**
	 * Set the equipment object base voltage to its container object
	 * 
	 * @param container the container object
	 * @param equipment the equipment object
	 */
	public static void setBaseVoltage(EquipmentContainer container, ConductingEquipment equipment) {
		if (container instanceof Bay)
			equipment.setBaseVoltage(((Bay)container).getVoltageLevel().getBaseVoltage());
		else if (container instanceof VoltageLevel)
			equipment.setBaseVoltage(((VoltageLevel)container).getBaseVoltage());		
	}
}
