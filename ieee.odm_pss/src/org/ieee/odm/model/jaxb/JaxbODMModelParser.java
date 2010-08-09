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

package org.ieee.odm.model.jaxb;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

import java.io.File;
import java.io.InputStream;

import org.apache.xmlbeans.XmlException;
import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusRefRecordXmlType;
import org.ieee.odm.schema.ConverterXmlType;
import org.ieee.odm.schema.DCLineData2TXmlType;
import org.ieee.odm.schema.InterchangeXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetAreaXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.TielineXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;

public class JaxbODMModelParser extends AbstractModelParser {
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public JaxbODMModelParser(File xmlFile) throws Exception {
		super(xmlFile);
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public JaxbODMModelParser(String xmlString) throws Exception {
		super(xmlString);
	}
	
	/**
	 * Constructor using an Xml string
	 * 
	 * @param in
	 * @throws Exception
	 */
	public JaxbODMModelParser(InputStream in) throws Exception {
		super(in);
	}

	/**
	 * Default Constructor 
	 * 
	 */
	public JaxbODMModelParser() {
		super();
	}
	
	/**
	 * Get the baseCase element
	 * 
	 * @return
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
	
	public LoadflowNetXmlType getAclfBaseCase() {
		return (LoadflowNetXmlType)getBaseCase();
	}
	
	/**
	 *  Bus/branch util functions
	 *  =========================
	 */
	
	/**
	 * Get the cashed bus object by id
	 * 
	 * @param id
	 * @return
	 */
	public BusRecordXmlType getBusRecord(String id) {
		return (BusRecordXmlType)this.getBus(id);
	}
	
	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public BusRecordXmlType createBusRecord() {
		BusRecordXmlType busRec = this.getFactory().createBusRecordXmlType();
		busRec.setOffLine(false);
		busRec.setAreaNumber(1);
		busRec.setZoneNumber(1);
		getBaseCase().getBusList().getBus().add(JaxbParserHelper.bus(busRec));
		return busRec;
	}	
	
	public BusRecordXmlType createBusRecord(String id) throws Exception {
		BusRecordXmlType busRec = createBusRecord();
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
	public BusRecordXmlType createBusRecord(String id, long number) throws Exception {
		BusRecordXmlType busRec = createBusRecord(id);
		busRec.setNumber(number);
		return busRec;
	}	

	/**
	 * create a bus reference record, referencing to the bus identified by refBusId
	 * 
	 * @param refBusId
	 * @return
	 * @throws Exception
	 */
	public BusRefRecordXmlType createBusRecRef(String refBusId) throws Exception {
		BusRefRecordXmlType nonMeteredBusRef = this.getFactory().createBusRefRecordXmlType();
		if (getBusRecord(refBusId) == null) {
			throw new Exception("Bus record not found in the network, id " + refBusId);
		}
		nonMeteredBusRef.setIdRef(getBusRecord(refBusId));		
		return nonMeteredBusRef;
	}
	
	/**
	 * Get the cashed branch record object by id
	 * 
	 * @param id
	 * @return
	 */
	public BranchRecordXmlType getBranchRecord(String branchId) {
		return (BranchRecordXmlType)this.getBranch(branchId); 
	}
	
	/**
	 * get the cashed branch record using fromId, toId and cirId
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public BranchRecordXmlType getBranchRecord(String fromId, String toId, String cirId) {
		String id = ModelStringUtil.formBranchId(fromId, toId, cirId);
		return (BranchRecordXmlType)this.getBranchRecord(id);
	}
	
	/**
	 * get the cashed branch record for 3W transformer branch
	 * 
	 * @param fromId
	 * @param toId
	 * @param tertId
	 * @param cirId
	 * @return
	 */
	public BranchRecordXmlType getBranchRecord(String fromId, String toId, String tertId, String cirId) {
		String id = ModelStringUtil.formBranchId(fromId, toId, tertId, cirId);
		return (BranchRecordXmlType)this.getBranchRecord(id);
	}

	/**
	 * add a new Branch record to the base case
	 * 
	 * @return
	 */
	public BranchRecordXmlType createBranchRecord() {
		BranchRecordXmlType branchRec = new BranchRecordXmlType();
		getBaseCase().getBranchList().getBranch().add(JaxbParserHelper.branch(branchRec));
		branchRec.setOffLine(false);
		branchRec.setAreaNumber(1);
		branchRec.setZoneNumber(1);
		return branchRec;
	}
	
	/**
	 * add a new branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public BranchRecordXmlType createBranchRecord(String id) throws Exception {
		BranchRecordXmlType branch = createBranchRecord();
		if (this.objectCache.get(id) != null) {
			throw new Exception("Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);
		return branch;
	}
	
	/**
	 * Area, zone, tieline, interchange functions
	 * ==========================================
	 */
	
	/**
	 * create an area object and added to the net.areaList
	 * 
	 * @return
	 */
	public NetAreaXmlType createNetworkArea() {
		if(getBaseCase().getAreaList()==null){
			getBaseCase().setAreaList(this.getFactory().createNetworkXmlTypeAreaList());
		}
		NetAreaXmlType area = this.getFactory().createNetAreaXmlType();
		getBaseCase().getAreaList().getArea().add(area);
		return area;
	}
	
	/**
	 * create an area object and added to the net.areaList
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
	 * create a tieLine object
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

	/**
	 * Get the cashed dcLine2T object by id
	 * 
	 * @param id
	 * @return
	 */
	public DCLineData2TXmlType getDcLine2TRecord(String recId, String invId, long number) {
		String id = ModelStringUtil.formBranchId(recId, invId, new Long(number).toString());
		return (DCLineData2TXmlType)this.getCachedObject(id);
	}
	
	/**
	 * add a new 2T DcLine record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public DCLineData2TXmlType createDCLine2TRecord(String recId, String invId, long number) throws Exception {
		//if (getStudyCase().getBaseCase().getDcLineList() == null)
		//	getStudyCase().getBaseCase().addNewDcLineList();
		DCLineData2TXmlType dcLine = getFactory().createDCLineData2TXmlType();
/*
		if (getAclfBaseCase().getDcLineList() == null)
			getAclfBaseCase().setDcLineList(this.getFactory().createLoadflowNetXmlTypeDcLineList());
		getAclfBaseCase().getDcLineList().getDcLint2T().add(dcLine);
		*/
		String branchId = ModelStringUtil.formBranchId(recId, invId, new Long(number).toString());
		dcLine.setId(branchId);
		dcLine.setNumber(number);
		if (this.objectCache.get(branchId) != null) {
			throw new Exception("DCLine record duplication, bus id: " + branchId);
		}
		this.objectCache.put(branchId, dcLine);
	
		ConverterXmlType rectifier = getFactory().createConverterXmlType();
		dcLine.setRectifier(rectifier);
		dcLine.getRectifier().setBusId(createBusRef(recId));
	
		ConverterXmlType inverter = getFactory().createConverterXmlType();
		dcLine.setInverter(inverter);
		dcLine.getInverter().setBusId(createBusRef(invId));
		return dcLine;
	}

	/**
	 * Get the default scenario
	 * 
	 * @return
	 */
	public ScenarioXmlType getDefaultScenario() {
		return getStudyCase().getScenarioList().getScenario().get(0);
	}

	/**
	 * Get the transient stability simulation record of the default scenario
	 *  
	 * @return
	 */
	public TransientSimulationXmlType getDefaultTransSimu(){
		return JaxbTranStabSimuHelper.getTransientSimlation(getDefaultScenario());
	}
}
