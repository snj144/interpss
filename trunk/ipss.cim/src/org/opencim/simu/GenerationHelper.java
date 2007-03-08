 /*
  * @(#)GenerationHelper.java   
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
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.datatype.CIMLogger;
import org.opencim.datatype.exp.CIMException;

/**
 * A helper class for generation related objects. It holds a ref to the SimulationModel object and has methods
 * to manipulate the object. 
 *
 */
public class GenerationHelper {
	private SimulationModel model = null;

	/**
	 * constructor
	 * 
	 * @param model a SimulationModel object
	 */
	public GenerationHelper(SimulationModel model) {
		this.model = model;
	}
	
	/**
	 * Add a GeneratingUnit object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created GeneratingUnit object
	 */
	public GeneratingUnit addGeneratingUnit(EquipmentContainer container, String mRID, String name, String desc, SubControlArea subCArea) {
		if (model.getPsResource(mRID, Equipment.class) != null) {
			CIMLogger.getLogger().severe("Error in adding GeneratingUnit, MRID duplication");
			return null;
		}
		try {
			GeneratingUnit gen = SimuModelFactory.createGeneratingUnit(mRID, name, desc);
			container.getEquipments().add(gen);
			gen.setSubControlArea(subCArea);
			return gen;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding GeneratingUnit, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the GeneratingUnit object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the GeneratingUnit object
	 */		
	public GeneratingUnit getGeneratingUnit(String mRID) {
		return (GeneratingUnit)model.getPsResource(mRID, Equipment.class);
	}
	
	/**
	 * Get the GeneratingUnit object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the GeneratingUnit object
	 */	
    public GeneratingUnit getGeneratingUnit(String mRID, EquipmentContainer container) {
    	return (GeneratingUnit)model.getPsResource(mRID, Equipment.class, container);
    }
	
	/**
	 * Add a SynchronousMachine object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created SynchronousMachine object
	 */
	public SynchronousMachine addSynchronousMachine(EquipmentContainer container, String mRID, String name, String desc,
								GeneratingUnit genUnit, Terminal terminal) {
		if (model.getPsResource(mRID, Equipment.class) != null) {
			CIMLogger.getLogger().severe("Error in adding SynchronousMachine, MRID duplication");
			return null;
		}
		try {
			SynchronousMachine mach = SimuModelFactory.createSynchronousMachine(mRID, name, desc);
			container.getEquipments().add(mach);
			genUnit.getSynchronousMachines().add(mach);
			mach.getTerminals().add(terminal);
			SimuModelHelper.setBaseVoltage(container, mach);
			return mach;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding SynchronousMachine, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the SynchronousMachine object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the SynchronousMachine object
	 */	
	public SynchronousMachine getSynchronousMachine(String mRID) {
		return (SynchronousMachine)model.getPsResource(mRID, Equipment.class);
	}	
	
	/**
	 * Get the SynchronousMachine object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the SynchronousMachine object
	 */	
    public SynchronousMachine getSynchronousMachine(String mRID, EquipmentContainer container) {
    	return (SynchronousMachine)model.getPsResource(mRID, Equipment.class, container);
    }	
}
