 /*
  * @(#)LoadHelper.java   
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
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.load.EquivalentLoad;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.common.CIMLogger;
import org.opencim.datatype.exp.CIMException;
import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.ReactivePower;

/**
 * A helper class for load related objects. It holds a ref to the SimulationModel object and has methods
 * to manipulate the object. 
 *
 */
public class LoadHelper {
	public static boolean CheckLoadObjectDup = false;
	
	private SimulationModel model = null;

	/**
	 * constructor
	 * 
	 * @param model a SimulationModel object
	 */
	public LoadHelper(SimulationModel model) {
		this.model = model;
	}
	
	/**
	 * Add a LoadArea object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created LoadArea object
	 */
	public LoadArea addLoadArea(String mRID, String name, String desc, Company company) {
		if (CheckLoadObjectDup)
			if (model.getPsResource(mRID, LoadArea.class) != null) {
				CIMLogger.getLogger().severe("Error in adding LoadArea, MRID duplication");
				return null;
			}
		try {
			LoadArea larea = SimuModelFactory.createLoadArea(mRID, name, desc);
			model.getPsResources().add(larea);
			larea.getCompanies().add(company);
			return larea;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding LoadArea, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the LoadArea object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the LoadArea object
	 */		
	public LoadArea getLoadArea(String mRID) {
		return (LoadArea)model.getPsResource(mRID, LoadArea.class);
	}

	/**
	 * Add a EnergyConsumer or its sub-type object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @param klass Class type of the object to be added. It has to be a sub-type of EnergyConsumer
	 * @return the created EnergyConsumer object
	 */
	public EnergyConsumer addEnergyConsumer(EquipmentContainer container, String mRID, String name, String desc, Class klass) {
		if (CheckLoadObjectDup)
			if (model.getPsResource(mRID, EnergyConsumer.class) != null) {
				CIMLogger.getLogger().severe("Error in adding EnergyConsumer, MRID duplication");
				return null;
			}
		try {
			EnergyConsumer energy;
			if (klass == EquivalentLoad.class)
				energy = SimuModelFactory.createEquivalentLoad(mRID, name, desc);
			else	
				energy = SimuModelFactory.createEnergyConsumer(mRID, name, desc);
			container.getEquipments().add(energy);
			SimuModelHelper.setBaseVoltage(container, energy);
			return energy;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding EnergyConsumer, " + e.toString());
		}
		return null;
	}
	
	/**
	 * Add a EnergyConsumer object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created EnergyConsumer object
	 */
	public EnergyConsumer addEnergyConsumer(EquipmentContainer container, String mRID, String name, String desc) {
		return (EnergyConsumer)addEnergyConsumer(container, mRID, name, desc, EnergyConsumer.class);
	}

	/**
	 * Get the EnergyConsumer object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the EnergyConsumer object
	 */		
	public EnergyConsumer getEnergyConsumer(String mRID) {
		return (EnergyConsumer)model.getPsResource(mRID, EnergyConsumer.class);
	}

	/**
	 * Get the EnergyConsumer object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the EnergyConsumer object
	 */	
    public EnergyConsumer getEnergyConsumer(String mRID, EquipmentContainer container) {
    	return (EquivalentLoad)model.getPsResource(mRID, Equipment.class, container);
    }

	/**
	 * Add a EquivalentLoad object to the load area, coonecting to the topological terminal and resource bay 
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param pMw 
	 * @param qMw
	 * @param loadArea
	 * @param node
	 * @param bay
	 * @return the created EquivalentLoad object
	 */
	public EquivalentLoad addEquivalentLoad(String mRID, double pMw, double qMw, LoadArea loadArea, Bay bay, ConnectivityNode cnode) {
		EquivalentLoad load = (EquivalentLoad)addEnergyConsumer(bay, mRID, 
				"Load1Name", "Sample Load Desc", EquivalentLoad.class);
		load.setPfixed(new ActivePower(pMw));
		load.setQfixed(new ReactivePower(qMw));
		SimuModelHelper.setBaseVoltage(bay, load);
		loadArea.getEnergyConsumers().add(load);
		// Add to the Topological View
		load.getTerminals().add(TopologyHelper.addTerminal(cnode, model));
		return load;
	}

	/**
	 * Get the EquivalentLoad object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the EquivalentLoad object
	 */		
    public EquivalentLoad getEquivalentLoad(String mRID) {
    	return (EquivalentLoad)model.getPsResource(mRID, Equipment.class);
    }
}
