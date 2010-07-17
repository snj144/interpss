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

import java.io.File;
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
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public AclfModelParser(File xmlFile) throws Exception {
		super(xmlFile);
	}

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
	
	public LoadflowNetXmlType getAclfBaseCase() {
		return (LoadflowNetXmlType)getBaseCase();
	}
	
	@Override
	public NetworkXmlType createBaseCase() {
		return null;
	}
	
	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public LoadflowBusXmlType createBusRecord() {
		LoadflowBusXmlType busRec = this.getFactory().createLoadflowBusXmlType();
		busRec.setOffLine(false);
		busRec.setAreaNumber(1);
		busRec.setZoneNumber(1);
		getBaseCase().getBusList().getBus().add(busRec);
		return busRec;
	}	
	
	public LoadflowBusXmlType createBusRecord(String id) throws Exception {
		LoadflowBusXmlType busRec = createBusRecord();
		busRec.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Bus record duplication, bus id: " + id);
		}
		this.objectCache.put(id, busRec);
		return busRec;
	}		
	
	/**
	 * add a new Branch record to the base case
	 * 
	 * @return
	 */
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
		if (this.objectCache.get(id) != null) {
			throw new Exception("Line Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);
		return branch;
	}
	
	public XfrBranchXmlType createXfrBranchXmlType(String id) throws Exception {
		XfrBranchXmlType branch = createXfrBranchXmlType();
		if (this.objectCache.get(id) != null) {
			throw new Exception("Xfr Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);
		return branch;
	}

	public PSXfrBranchXmlType createPSXfrBranchXmlType(String id) throws Exception {
		PSXfrBranchXmlType branch = createPSXfrBranchXmlType();
		if (this.objectCache.get(id) != null) {
			throw new Exception("PSXfr Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);
		return branch;
	}

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
