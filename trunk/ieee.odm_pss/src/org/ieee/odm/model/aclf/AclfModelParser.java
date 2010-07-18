/*
 * @(#)JaxbODMModelParser.java   
 *
 * Copyright (C) 2006-2010 www.interpss.org
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
 * @Date 02/01/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.model.aclf;

import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.InterchangeXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.TielineXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

public class AclfModelParser extends AbstractModelParser {
	/**
	 * get the base case object of type LoadflowXmlType
	 * 
	 * @return
	 */
	public LoadflowNetXmlType getAclfBaseCase() {
		return (LoadflowNetXmlType)getBaseCase();
	}
	
	/**
	 * create the base case object of type LoadflowXmlType
	 */
	@Override
	public NetworkXmlType createBaseCase() {
		if (getStudyCase().getBaseCase() == null) {
			LoadflowNetXmlType baseCase = createAclfBaseCase();
			getStudyCase().setBaseCase(baseCase);
		}
		return (LoadflowNetXmlType)getStudyCase().getBaseCase();
	}
	
	private LoadflowNetXmlType createAclfBaseCase() {
		LoadflowNetXmlType baseCase = this.getFactory().createLoadflowNetXmlType();
		
		baseCase.setBusList(this.getFactory().createNetworkXmlTypeBusList());
		baseCase.setBranchList(this.getFactory().createNetworkXmlTypeBranchList());
				
		return baseCase;
	}
	
	/*
	 * 		Bus functions
	 * 		=============
	 */

	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public LoadflowBusXmlType createBusXmlType() {
		LoadflowBusXmlType busRec = this.getFactory().createLoadflowBusXmlType();
		busRec.setOffLine(false);
		busRec.setAreaNumber(1);
		busRec.setZoneNumber(1);
		getBaseCase().getBusList().getBus().add(busRec);
		return busRec;
	}	
	
	public LoadflowBusXmlType createBusXmlType(String id) throws Exception {
		LoadflowBusXmlType busRec = createBusXmlType();
		busRec.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Bus record duplication, bus id: " + id);
		}
		this.objectCache.put(id, busRec);
		return busRec;
	}		
	
	public LoadflowBusXmlType getAclfBus(String id) {
		return (LoadflowBusXmlType)getBus(id);
	}

	/*
	 * 		Branch functions
	 * 		================
	 */
	public LineBranchXmlType getLineBranch(String fromId, String toId, String cirId) {
		return (LineBranchXmlType)getBranch(fromId, toId, cirId);
	}
	
	public XfrBranchXmlType getXfrBranch(String fromId, String toId, String cirId) {
		return (XfrBranchXmlType)getBranch(fromId, toId, cirId);
	}

	public PSXfrBranchXmlType getPSXfrBranch(String fromId, String toId, String cirId) {
		return (PSXfrBranchXmlType)getBranch(fromId, toId, cirId);
	}

	public LineBranchXmlType createLineBranchXmlType() {
		LineBranchXmlType branch = this.getFactory().createLineBranchXmlType();
		intiBranchData(branch);
		return branch;
	}
	
	public XfrBranchXmlType createXfrBranchXmlType() {
		XfrBranchXmlType branch = this.getFactory().createXfrBranchXmlType();
		intiBranchData(branch);
		return branch;
	}

	public PSXfrBranchXmlType createPSXfrBranchXmlType() {
		PSXfrBranchXmlType branch = this.getFactory().createPSXfrBranchXmlType();
		intiBranchData(branch);
		return branch;
	}

	private void intiBranchData(BranchXmlType branch) {
		getBaseCase().getBranchList().getBranch().add(branch);
		branch.setOffLine(false);
		branch.setAreaNumber(1);
		branch.setZoneNumber(1);
	}
	
	/**
	 * add a new branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public LineBranchXmlType createLineBranchXmlType(String id) throws Exception {
		LineBranchXmlType branch = createLineBranchXmlType();
		add2CacheTable(id, branch);
		return branch;
	}
	
	public XfrBranchXmlType createXfrBranchXmlType(String id) throws Exception {
		XfrBranchXmlType branch = createXfrBranchXmlType();
		add2CacheTable(id, branch);
		return branch;
	}

	public PSXfrBranchXmlType createPSXfrBranchXmlType(String id) throws Exception {
		PSXfrBranchXmlType branch = createPSXfrBranchXmlType();
		add2CacheTable(id, branch);
		return branch;
	}

	private void add2CacheTable(String id, BranchXmlType branch) throws Exception {
		if (this.objectCache.get(id) != null) {
			throw new Exception("Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);		
	}
	
	/*
	 * 		Network object functions
	 * 		========================
	 */
	/**
	 * create a tieLine object
	 * 
	 * @return
	 */
	public TielineXmlType createTieline() {
		if (getAclfBaseCase().getTieLineList() == null)
			getAclfBaseCase().setTieLineList(this.getFactory().createLoadflowNetXmlTypeTieLineList());
		TielineXmlType tieLine = this.getFactory().createTielineXmlType();
		getAclfBaseCase().getTieLineList().getTieline().add(tieLine);
		return tieLine;
	}	
	
	public NetZoneXmlType createNetworkLossZone() {
		if(getBaseCase().getLossZoneList() == null){
			getBaseCase().setLossZoneList(this.getFactory().createNetworkXmlTypeLossZoneList());
		}
		NetZoneXmlType zone = this.getFactory().createNetZoneXmlType();
		getBaseCase().getLossZoneList().getLossZone().add(zone);
		return zone;
	}
	
	public InterchangeXmlType createInterchange() {
		if (getAclfBaseCase().getInterchangeList() == null)
			getAclfBaseCase().setInterchangeList(this.getFactory().createLoadflowNetXmlTypeInterchangeList());
		InterchangeXmlType interchange = this.getFactory().createInterchangeXmlType();
		getAclfBaseCase().getInterchangeList().getInterchange().add(interchange);
		return interchange;
	}	
}
