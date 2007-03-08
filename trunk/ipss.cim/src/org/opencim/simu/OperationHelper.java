 /*
  * @(#)OperationHelper.java   
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
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.datatype.CIMLogger;
import org.opencim.datatype.exp.CIMException;
import org.opencim.datatype.real.Voltage;

/**
 * A helper class for operation related objects. It holds a ref to the SimulationModel object and has methods
 * to manipulate the object. 
 *
 */
public class OperationHelper {
	private SimulationModel model = null;

	/**
	 * constructor
	 * 
	 * @param model a SimulationModel object
	 */
	public OperationHelper(SimulationModel model) {
		this.model = model;
	}
	
	/**
	 * Add a SubControlArea object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created SubControlArea object
	 */
	public SubControlArea addSubControlArea(String mRID, String name, String desc) {
		if (model.getPsResource(mRID, SubControlArea.class) != null) {
			CIMLogger.getLogger().severe("Error in adding SubControlArea, MRID duplication");
			return null;
		}
		try {
			SubControlArea carea = SimuModelFactory.createSubControlArea(mRID, name, desc);
			model.getPsResources().add(carea);
			return carea;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding SubControlArea, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the SubControlArea object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the SubControlArea object
	 */	
	public SubControlArea getSubControlArea(String mRID) {
		return (SubControlArea)model.getPsResource(mRID, SubControlArea.class);
	}
	
	/**
	 * Add a Substation object to the SubControlArea object
	 * 
	 * @param carea a SubControlArea object
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Substation object
	 */
	public Substation addSubstation(SubControlArea carea, String mRID, String name, String desc) {
		if (model.getPsResource(mRID, Substation.class) != null) {
			CIMLogger.getLogger().severe("Error in adding Substation, MRID duplication");
			return null;
		}
		try {
			Substation sub = SimuModelFactory.createSubstation(mRID, name, desc);
			carea.getSubstations().add(sub);
			return sub;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding Substation, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the Substation object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Substation object
	 */	
	public Substation getSubstation(String mRID) {
		return (Substation)model.getPsResource(mRID, Substation.class);
	}

	/**
	 * Get the Substation object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Substation object
	 */	
	public Substation getSubstation(String mRID, SubControlArea parent) {
		return (Substation)model.getPsResource(mRID, Substation.class, parent);
	}
	
	/**
	 * Add a VoltageLevel object to the Substation object
	 * 
	 * @param sub a Substation object
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created VoltageLevel object
	 */
	public VoltageLevel addVoltageLevel(Substation sub, String mRID, BaseVoltage baseV, double hVoltLimit, double lVoltLimit) {
		if (model.getPsResource(mRID, VoltageLevel.class) != null) {
			CIMLogger.getLogger().severe("Error in adding VoltageLevel, MRID duplication");
			return null;
		}
		try {
			VoltageLevel vlevel = SimuModelFactory.createVoltageLevel(mRID,
					"Voltage Level "+mRID , "VoltageLevel " + mRID);
			vlevel.setBaseVoltage(baseV);
			vlevel.setHighVoltageLimit(new Voltage(hVoltLimit));
			vlevel.setLowVoltageLimit(new Voltage(lVoltLimit));
			sub.getVoltageLevels().add(vlevel);
			return vlevel;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding VoltageLevel, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the VoltageLevel object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the VoltageLevel object
	 */
	public VoltageLevel getVoltageLevel(String mRID) {
		return (VoltageLevel)model.getPsResource(mRID, VoltageLevel.class);
	}

	/**
	 * Get the VoltageLevel object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the VoltageLevel object
	 */
	public VoltageLevel getVoltageLevel(String mRID, Substation parent) {
		return (VoltageLevel)model.getPsResource(mRID, VoltageLevel.class, parent);
	}
	
	/**
	 * Add a Bay object to the VoltageLevel object
	 * 
	 * @param vlevel a VoltageLevel object
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Bay object
	 */
	public Bay addBay(VoltageLevel vlevel, String mRID, String name, String desc) {
		if (model.getPsResource(mRID, Bay.class) != null) {
			CIMLogger.getLogger().severe("Error in adding Bay, MRID duplication");
			return null;
		}
		try {
			Bay bay = SimuModelFactory.createBay(mRID, name, desc);
			vlevel.getBays().add(bay);
			return bay;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding Bay to VoltageLevel, " + e.toString());
		}
		return null;
	}

	/**
	 * Add a Bay object to the Substation object
	 * 
	 * @param sub a Substation object
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Bay object
	 */
	public Bay addBay(Substation sub, String mRID, String name, String desc) {
		if (model.getPsResource(mRID, Bay.class) != null) {
			CIMLogger.getLogger().severe("Error in adding Bay, MRID duplication");
			return null;
		}
		try {
			Bay bay = SimuModelFactory.createBay(mRID, name, desc);
			sub.getBays().add(bay);
			return bay;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding Bay to Substation, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the Bay object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Bay object
	 */	
	public Bay getBay(String mRID) {
		return (Bay)model.getPsResource(mRID, Bay.class);
	}

	/**
	 * Get the Bay object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Bay object
	 */	
	public Bay getBay(String mRID, Substation parent) {
		return (Bay)model.getPsResource(mRID, Bay.class, parent);
	}

	/**
	 * Get the Bay object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Bay object
	 */	
	public Bay getBay(String mRID, VoltageLevel parent) {
		return (Bay)model.getPsResource(mRID, Bay.class, parent);
	}
}
