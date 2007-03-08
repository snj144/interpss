 /*
  * @(#)TopologyHelper.java   
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
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.datatype.CIMLogger;
import org.opencim.datatype.exp.CIMException;

/**
 * A helper class for topological related objects. It holds a ref to the SimulationModel object and has methods
 * to manipulate the object. 
 *
 */
public class TopologyHelper {
	private SimulationModel model = null;

	/**
	 * constructor
	 * 
	 * @param model a SimulationModel object
	 */
	public TopologyHelper(SimulationModel model) {
		this.model = model;
	}
	
	/**
	 * Add a TopologicalIsland object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created TopologicalIsland object
	 */
	public TopologicalIsland addTopologicalIsland(String mRID, String name, String desc) {
		if (model.getTopologicalObject(mRID, TopologicalIsland.class) != null) {
			CIMLogger.getLogger().severe("Error in adding TopologicalIsland, MRID duplication");
			return null;
		}
		try {
			TopologicalIsland tisland = SimuModelFactory.createTopologicalIsland(mRID, name, desc);
			model.getTopologicalIslands().add(tisland);
			return tisland;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding TopologicalIsland, " + e.toString());
		}
		return null;
	}

	public TopologicalIsland getTopologicalIsland(String mRID) {
		return (TopologicalIsland)model.getTopologicalObject(mRID, TopologicalIsland.class);
	}

	/**
	 * Add a TopologicalNode object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created TopologicalNode object
	 */
	public TopologicalNode addTopologicalNode(TopologicalIsland tIsland, String mRID, String name, String desc) {
		if (model.getTopologicalObject(mRID, TopologicalNode.class) != null) {
			CIMLogger.getLogger().severe("Error in adding TopologicalNode, MRID duplication");
			return null;
		}
		try {
			TopologicalNode tnode = SimuModelFactory.createTopologicalNode(mRID, name, desc);
			tIsland.getTopologicalNodes().add(tnode);
			return tnode;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding TopologicalNode, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the TopologicalNode object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the TopologicalNode object
	 */
	public TopologicalNode getTopologicalNode(String mRID) {
		return (TopologicalNode)model.getTopologicalObject(mRID, TopologicalNode.class);
	}

	/**
	 * Get the TopologicalNode object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the TopologicalNode object
	 */
	public TopologicalNode getTopologicalNode(String mRID, TopologicalIsland parent) {
		return (TopologicalNode)model.getTopologicalObject(mRID, TopologicalNode.class, parent);
	}

	/**
	 * Add a ConnectivityNode object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created ConnectivityNode object
	 */
	public ConnectivityNode addConnectivityNode(TopologicalNode tNode, String mRID, String name, String desc) {
		if (model.getTopologicalObject(mRID, ConnectivityNode.class) != null) {
			CIMLogger.getLogger().severe("Error in adding ConnectivityNode, MRID duplication");
			return null;
		}
		try {
			ConnectivityNode cnode = SimuModelFactory.createConnectivityNode(mRID, name, desc);
			tNode.getConnectivityNodes().add(cnode);
			return cnode;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding ConnectivityNode, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the ConnectivityNode object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the ConnectivityNode object
	 */
	public ConnectivityNode getConnectivityNode(String mRID) {
		return (ConnectivityNode)model.getTopologicalObject(mRID, ConnectivityNode.class);
	}

	/**
	 * Get the ConnectivityNode object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the ConnectivityNode object
	 */	
	public ConnectivityNode getConnectivityNode(String mRID, TopologicalNode parent) {
		return (ConnectivityNode)model.getTopologicalObject(mRID, ConnectivityNode.class, parent);
	}

	/**
	 * Add a Terminal object to the simulaiton model object
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @param name the name attribute per CIM specification
	 * @param desc the description attribute per CIM specification
	 * @return the created Terminal object
	 */
	public Terminal addTerminal(ConnectivityNode cNode, String mRID, String name, String desc) {
		if (model.getTopologicalObject(mRID, Terminal.class) != null) {
			CIMLogger.getLogger().severe("Error in adding ConnectivityNode, MRID duplication");
			return null;
		}
		try {
			Terminal t = SimuModelFactory.createTerminal(mRID, name, desc);
			cNode.getTerminals().add(t);
			return t;
		} catch (CIMException e) {
			CIMLogger.getLogger().severe("Error in adding Terminal, " + e.toString());
		}
		return null;
	}

	/**
	 * Get the Terminal object in the model identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Terminal object
	 */	
	public Terminal getTerminal(String mRID) {
		return (Terminal)model.getTopologicalObject(mRID, Terminal.class);
	}

	/**
	 * Get the Terminal object contained in the parent object identified by mRID
	 * 
	 * @param mRID the MRID attribute per CIM specification
	 * @return the Terminal object
	 */
	public Terminal getTerminal(String mRID, ConnectivityNode parent) {
		return (Terminal)model.getTopologicalObject(mRID, Terminal.class, parent);
	}
}
