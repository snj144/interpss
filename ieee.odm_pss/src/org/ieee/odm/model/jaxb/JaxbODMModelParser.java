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
import java.util.Hashtable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.xmlbeans.XmlException;
import org.ieee.odm.model.ModelContansts;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.ODMModelParser;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusRefRecordXmlType;
import org.ieee.odm.schema.ConverterXmlType;
import org.ieee.odm.schema.DCLineData2TXmlType;
import org.ieee.odm.schema.IDRecordXmlType;
import org.ieee.odm.schema.IDRefRecordXmlType;
import org.ieee.odm.schema.NetAreaXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.PSSNetworkXmlType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StudyCaseXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;

public class JaxbODMModelParser extends ODMModelParser {
	// bus and branch object cache for fast lookup. 
	private Hashtable<String,IDRecordXmlType> objectCache = null;

	private StudyCaseXmlType pssStudyCase = null;
	
	private ObjectFactory factory = null;
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public JaxbODMModelParser(File xmlFile) throws Exception {
		//this.doc = PSSStudyCaseDocument.Factory.parse(xmlFile);
		//this.objectCache = new Hashtable<String, IDRecordXmlType>();
		//if (!doc.validate()) 
		//	throw new Exception("Error: input XML document is invalid, file: " + xmlFile.getName());
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public JaxbODMModelParser(String xmlString) throws Exception {
		//this.doc = PSSStudyCaseDocument.Factory.parse(xmlString);
		//this.objectCache = new Hashtable<String, IDRecordXmlType>();
	}
	
	/**
	 * Constructor using an Xml string
	 * 
	 * @param in
	 * @throws Exception
	 */
	public JaxbODMModelParser(InputStream in) throws Exception {
		//this.doc = PSSStudyCaseDocument.Factory.parse(in);
		//this.objectCache = new Hashtable<String, IDRecordXmlType>();
	}

	/**
	 * Default Constructor 
	 * 
	 */
	public JaxbODMModelParser() {
		this.factory = new ObjectFactory();		
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
		//this.doc = PSSStudyCaseDocument.Factory.newInstance();
		this.getStudyCase().setId("ODM_StudyCase");
		this.getStudyCase().setSchemaVersion(ModelContansts.ODM_Schema_Version);
	}
	
	/**
	 * Get the root schema element StudyCase
	 * 
	 * @return
	 */
	public StudyCaseXmlType getStudyCase() {
		if (this.pssStudyCase == null) {
			createStudyCase();
		}	
		return this.pssStudyCase;
	}

	private void createStudyCase() {
		this.pssStudyCase = new StudyCaseXmlType();
		this.pssStudyCase.setBaseCase(createBaseCase());
	}
	
	/**
	 * Get the baseCase element
	 * 
	 * @return
	 */
	public PSSNetworkXmlType getBaseCase() {
		if (getStudyCase() == null) 
			createStudyCase();
		if (getStudyCase().getBaseCase() == null) {
			PSSNetworkXmlType baseCase = createBaseCase();
			getStudyCase().setBaseCase(baseCase);
		}
		return getStudyCase().getBaseCase();
	}
	
	private PSSNetworkXmlType createBaseCase() {
		PSSNetworkXmlType baseCase = new PSSNetworkXmlType();
		
		baseCase.setBusList(new PSSNetworkXmlType.BusList());
		baseCase.setBranchList(new PSSNetworkXmlType.BranchList());
				
		return baseCase;
	}
	
	/**
	 * Get the cashed object by id
	 * 
	 * @param id
	 * @return
	 */
	private IDRecordXmlType getCachedObject(String id) {
		return this.objectCache.get(id);
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
		return (BusRecordXmlType)this.getCachedObject(id);
	}
	
	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public BusRecordXmlType createBusRecord() {
		BusRecordXmlType busRec = this.factory.createBusRecordXmlType();
		getBaseCase().getBusList().getBus().add(busRec);
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
		BusRefRecordXmlType nonMeteredBusRef = this.factory.createBusRefRecordXmlType();
		if (getBusRecord(refBusId) == null) {
			throw new Exception("Bus record not found in the network, id " + refBusId);
		}
		nonMeteredBusRef.setIdRef(getBusRecord(refBusId));		
		return nonMeteredBusRef;
	}
	
	/**
	 * Get the cashed branch object by id
	 * 
	 * @param id
	 * @return
	 */
	public BranchRecordXmlType getBranchRecord(String branchId) {
		return (BranchRecordXmlType)this.getCachedObject(branchId); 
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
		return (BranchRecordXmlType)this.getCachedObject(id);
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
		return (BranchRecordXmlType)this.getCachedObject(id);
	}

	/**
	 * add a new Branch record to the base case
	 * 
	 * @return
	 */
	public BranchRecordXmlType createBranchRecord() {
		BranchRecordXmlType branchRec = new BranchRecordXmlType();
		getBaseCase().getBranchList().getBranch().add(branchRec);
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
			getBaseCase().setAreaList(this.factory.createPSSNetworkXmlTypeAreaList());
		}
		NetAreaXmlType area = this.factory.createNetAreaXmlType();
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
			getBaseCase().setLossZoneList(this.factory.createPSSNetworkXmlTypeLossZoneList());
		}
		NetZoneXmlType zone = this.factory.createNetZoneXmlType();
		getBaseCase().getLossZoneList().getLossZone().add(zone);
		return zone;
	}

	/**
	 * create a tieLine object
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.TieLineList.Tieline createTieline() {
		if (getBaseCase().getTieLineList() == null)
			getBaseCase().setTieLineList(this.factory.createPSSNetworkXmlTypeTieLineList());
		PSSNetworkXmlType.TieLineList.Tieline tieLine = this.factory.createPSSNetworkXmlTypeTieLineListTieline();
		getBaseCase().getTieLineList().getTieline().add(tieLine);
		return tieLine;
	}
	
	/**
	 * create a tieLine object
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.InterchangeList.Interchange createInterchange() {
		if (getBaseCase().getInterchangeList() == null)
			getBaseCase().setInterchangeList(this.factory.createPSSNetworkXmlTypeInterchangeList());
		PSSNetworkXmlType.InterchangeList.Interchange interchange = this.factory.createPSSNetworkXmlTypeInterchangeListInterchange();
		getBaseCase().getInterchangeList().getInterchange().add(interchange);
		return interchange;
	}

	/**
	 * Get the cashed dcLine2T object by id
	 * 
	 * @param id
	 * @return
	 */
	public DCLineData2TXmlType getDcLine2TRecord(String recId, String invId, int number) {
		String id = ModelStringUtil.formBranchId(recId, invId, new Integer(number).toString());
		return (DCLineData2TXmlType)this.getCachedObject(id);
	}
	
	/**
	 * Get the cashed object by id
	 * 
	 * @param id
	 */
	public void removeCachedObject(String id) {
		this.objectCache.remove(id);
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
	
	/**
	 * add a new 2T DcLine record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public DCLineData2TXmlType addNewBaseCaseDCLine2T(String recId, String invId, long number) throws Exception {
		//if (getStudyCase().getBaseCase().getDcLineList() == null)
		//	getStudyCase().getBaseCase().addNewDcLineList();
		DCLineData2TXmlType dcLine = new DCLineData2TXmlType();
		getStudyCase().getBaseCase().getDcLineList().getDcLint2T().add(dcLine);
		String branchId = ModelStringUtil.formBranchId(recId, invId, new Long(number).toString());
		dcLine.setId(branchId);
		dcLine.setNumber(number);
		if (this.objectCache.get(branchId) != null) {
			throw new Exception("DCLine record duplication, bus id: " + branchId);
		}
		this.objectCache.put(branchId, dcLine);

		ConverterXmlType rectifier = new ConverterXmlType();
		dcLine.setRectifier(rectifier);
		IDRefRecordXmlType idRef = new IDRefRecordXmlType(); 
		idRef.setIdRef(recId);
		dcLine.getRectifier().setBusId(idRef);

		ConverterXmlType inverter = new ConverterXmlType();
		dcLine.setInverter(inverter);
		IDRefRecordXmlType idRefIn = new IDRefRecordXmlType();
		idRefIn.setIdRef(invId);
		dcLine.getInverter().setBusId(idRefIn);
		return dcLine;
	}

	/**
	 * create a Jaxb marshaller
	 * 
	 * @return
	 * @throws JAXBException
	 */
	public Marshaller createMarshaller() throws JAXBException {
		JAXBContext jaxbContext	= JAXBContext.newInstance(ModelContansts.ODM_Schema_NS);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}
	
	/**
	 * print the Xml doc to the std out
	 * 
	 */
	public void stdout() {
		try {
			JAXBElement<StudyCaseXmlType> element = (new ObjectFactory()).createPSSStudyCase(getStudyCase());
			createMarshaller().marshal( element, System.out );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
