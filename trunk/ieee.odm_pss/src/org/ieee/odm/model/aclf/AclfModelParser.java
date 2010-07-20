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

import java.io.InputStream;

import org.apache.xmlbeans.XmlException;
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
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public AclfModelParser(String xmlString) throws Exception {
		super(xmlString);
	}
	
	/**
	 * Constructor using an Xml string
	 * 
	 * @param in
	 * @throws Exception
	 */
	public AclfModelParser(InputStream in) throws Exception {
		super(in);
	}
	
	/**
	 * Default Constructor 
	 * 
	 */
	public AclfModelParser() {
		super();
	}	
	
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
			LoadflowNetXmlType baseCase = this.getFactory().createLoadflowNetXmlType();
			
			baseCase.setBusList(this.getFactory().createNetworkXmlTypeBusList());
			baseCase.setBranchList(this.getFactory().createNetworkXmlTypeBranchList());
			getStudyCase().setBaseCase(baseCase);
		}
		return (LoadflowNetXmlType)getStudyCase().getBaseCase();
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
	public LoadflowBusXmlType createAclfBus() {
		LoadflowBusXmlType busRec = this.getFactory().createLoadflowBusXmlType();
		busRec.setOffLine(false);
		busRec.setAreaNumber(1);
		busRec.setZoneNumber(1);
		getBaseCase().getBusList().getBus().add(busRec);
		return busRec;
	}	
	
	/**
	 * create a bus object with the id, make sure there is no duplication
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LoadflowBusXmlType createAclfBus(String id) throws Exception {
		LoadflowBusXmlType busRec = createAclfBus();
		busRec.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Bus record duplication, bus id: " + id);
		}
		this.objectCache.put(id, busRec);
		return busRec;
	}		
	
	/**
	 * add a new bus record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public LoadflowBusXmlType createAclfBus(String id, long number) throws Exception {
		LoadflowBusXmlType busRec = createAclfBus(id);
		busRec.setNumber(number);
		return busRec;
	}	
	
	/**
	 * get the bus object using the id
	 * 
	 * @param id
	 * @return
	 */
	public LoadflowBusXmlType getAclfBus(String id) {
		return (LoadflowBusXmlType)getBus(id);
	}

	/*
	 * 		Branch functions
	 * 		================
	 */
	
	public void addAclfBaseBranch(BranchXmlType branch) {
		getBaseCase().getBranchList().getBranch().add(branch);
		this.objectCache.put(branch.getId(), branch);
	}
	
	/**
	 * get the Line branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public LineBranchXmlType getLineBranch(String fromId, String toId, String cirId) {
		return (LineBranchXmlType)getBranch(fromId, toId, cirId);
	}
	
	/**
	 * get the xfr branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public XfrBranchXmlType getXfrBranch(String fromId, String toId, String cirId) {
		return (XfrBranchXmlType)getBranch(fromId, toId, cirId);
	}

	/**
	 * get the ps xfr branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public PSXfrBranchXmlType getPSXfrBranch(String fromId, String toId, String cirId) {
		return (PSXfrBranchXmlType)getBranch(fromId, toId, cirId);
	}

	/**
	 * create a LineBranchXmlType object
	 * 
	 * @return
	 */
	public LineBranchXmlType createLineBranch() {
		LineBranchXmlType branch = this.getFactory().createLineBranchXmlType();
		intiBranchData(branch);
		return branch;
	}
	
	/**
	 * create a XfrBranchXmlType object
	 * 
	 * @return
	 */
	public XfrBranchXmlType createXfrBranch() {
		XfrBranchXmlType branch = this.getFactory().createXfrBranchXmlType();
		intiBranchData(branch);
		return branch;
	}

	/**
	 * create a PSXfrBranchXmlType object
	 * 
	 * @return
	 */
	public PSXfrBranchXmlType createPSXfrBranch() {
		PSXfrBranchXmlType branch = this.getFactory().createPSXfrBranchXmlType();
		intiBranchData(branch);
		return branch;
	}

	/**
	 * init the branch object
	 * 
	 * @param branch
	 */
	private void intiBranchData(BranchXmlType branch) {
		getBaseCase().getBranchList().getBranch().add(branch);
		branch.setOffLine(false);
		branch.setAreaNumber(1);
		branch.setZoneNumber(1);
	}
	
	/**
	 * add a new Line branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public LineBranchXmlType createLineBranch(String id) throws Exception {
		LineBranchXmlType branch = createLineBranch();
		add2CacheTable(id, branch);
		return branch;
	}
	
	/**
	 * add a new Xfr branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public XfrBranchXmlType createXfrBranch(String id) throws Exception {
		XfrBranchXmlType branch = createXfrBranch();
		add2CacheTable(id, branch);
		return branch;
	}

	/**
	 * add a new PS Xfr branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public PSXfrBranchXmlType createPSXfrBranch(String id) throws Exception {
		PSXfrBranchXmlType branch = createPSXfrBranch();
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
	
	/**
	 * create a LossZone object
	 * 
	 * @return
	 */
	public NetZoneXmlType createNetworkLossZone() {
		if(getBaseCase().getLossZoneList() == null){
			getBaseCase().setLossZoneList(this.getFactory().createNetworkXmlTypeLossZoneList());
		}
		NetZoneXmlType zone = this.getFactory().createNetZoneXmlType();
		getBaseCase().getLossZoneList().getLossZone().add(zone);
		return zone;
	}
	
	/**
	 * create a Interchange object
	 * 
	 * @return
	 */
	public InterchangeXmlType createInterchange() {
		if (getAclfBaseCase().getInterchangeList() == null)
			getAclfBaseCase().setInterchangeList(this.getFactory().createLoadflowNetXmlTypeInterchangeList());
		InterchangeXmlType interchange = this.getFactory().createInterchangeXmlType();
		getAclfBaseCase().getInterchangeList().getInterchange().add(interchange);
		return interchange;
	}	
}
