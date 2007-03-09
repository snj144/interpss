 /*
  * @(#)WireHelper.java   
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
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.common.CIMLogger;
import org.opencim.datatype.exp.CIMException;

/**
 * A helper class for wire (Line, Xfr) related objects. It holds a ref to the SimulationModel object and has methods
 * to manipulate the object. 
 *
 */
public class WireHelper {
	private SimulationModel model = null;

	/**
	 * constructor
	 * 
	 * @param model a SimulationModel object
	 */
	public WireHelper(SimulationModel model) {
		this.model = model;
	}
	
	/**
	 * Add a Line object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Line object
	 */
	public Line addLine(String mRID, String name, String desc) {
		if (model.getPsResource(mRID, Line.class) != null) {
			CIMLogger.getLogger().severe("Error in adding Line, MRID duplication");
			return null;
		}
		try {
			Line line = SimuModelFactory.createLine(mRID, name, desc);
			model.getPsResources().add(line);
			return line;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding Line, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the Line object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Line object
	 */		
	public Line getLine(String mRID) {
		return (Line)model.getPsResource(mRID, Line.class);
	}	

	/**
	 * Add a ACLineSegment object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created ACLineSegment object
	 */
	public ACLineSegment addACLineSegment(String mRID, String name, String desc,
								Line line, ConnectivityNode from_cnode, ConnectivityNode to_cnode) {
		if (model.getPsResource(mRID, Equipment.class) != null) {
			CIMLogger.getLogger().severe("Error in adding ACLineSegment, MRID duplication");
			return null;
		}
		try {
			ACLineSegment lseg = SimuModelFactory.createACLineSegment(mRID, name, desc);
			line.getACLineSegments().add(lseg);
			lseg.getTerminals().add(TopologyHelper.addTerminal(from_cnode, model));
			lseg.getTerminals().add(TopologyHelper.addTerminal(to_cnode, model));
			return lseg;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding ACLineSegment, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the ACLineSegment object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the ACLineSegment object
	 */	
	public ACLineSegment getACLineSegment(String mRID) {
		return (ACLineSegment)model.getPsResource(mRID, ACLineSegment.class);
	}	

	/**
	 * Get the ACLineSegment object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param parent the parent container
	 * @return the ACLineSegment object
	 */	
	public ACLineSegment getACLineSegment(String mRID, Line parent) {
		return (ACLineSegment)model.getPsResource(mRID, ACLineSegment.class, parent);
	}
	
	/**
	 * Add a PowerTransformer object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created PowerTransformer object
	 */
	public PowerTransformer addPowerTransformer(EquipmentContainer container, String mRID, String name, String desc) {
		if (model.getPsResource(mRID, Equipment.class) != null) {
			CIMLogger.getLogger().severe("Error in adding PowerTransformer, MRID duplication");
			return null;
		}
		try {
			PowerTransformer xfr = SimuModelFactory.createPowerTransformer(mRID, name, desc);
			container.getEquipments().add(xfr);
			return xfr;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding PowerTransformer, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the PowerTransformer object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the PowerTransformer object
	 */	
	public PowerTransformer getPowerTransformer(String mRID) {
		return (PowerTransformer)model.getPsResource(mRID, Equipment.class);
	}	

	/**
	 * Get the PowerTransformer object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param parent the parent container
	 * @return the PowerTransformer object
	 */	
	public PowerTransformer getPowerTransformer(String mRID, EquipmentContainer container) {
		return (PowerTransformer)model.getPsResource(mRID, Equipment.class, container);
	}
	
	/**
	 * Add a PowerTransformer object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created PowerTransformer object
	 */
	public TransformerWinding addTransformerWinding(EquipmentContainer container, String mRID, String name, String desc,
								PowerTransformer xfr, ConnectivityNode cNode) {
		if (model.getPsResource(mRID, Equipment.class) != null) {
			CIMLogger.getLogger().severe("Error in adding TransformerWinding, MRID duplication");
			return null;
		}
		try {
			TransformerWinding w = SimuModelFactory.createTransformerWinding(mRID, name, desc);
			container.getEquipments().add(w);
			TopologyHelper.addTerminal(cNode, model).setConductingEquipment(w);
			w.setPowerTransformer(xfr);
			return w;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding TransformerWinding, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the TransformerWinding object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the TransformerWinding object
	 */	
	public TransformerWinding getTransformerWinding(String mRID) {
		return (TransformerWinding)model.getPsResource(mRID, Equipment.class);
	}	
	
	/**
	 * Get the TransformerWinding object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param parent the parent container
	 * @return the TransformerWinding object
	 */	
	public TransformerWinding getTransformerWinding(String mRID, EquipmentContainer container) {
		return (TransformerWinding)model.getPsResource(mRID, Equipment.class, container);
	}	
}
