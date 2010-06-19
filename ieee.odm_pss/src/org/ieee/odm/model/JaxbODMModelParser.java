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

package org.ieee.odm.model;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.xmlbeans.XmlException;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusRefRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.ConverterXmlType;
import org.ieee.odm.schema.DCLineData2TXmlType;
import org.ieee.odm.schema.IDRecordXmlType;
import org.ieee.odm.schema.InterchangeXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetAreaXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StudyCaseXmlType;
import org.ieee.odm.schema.TielineXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;

public class JaxbODMModelParser implements ODMModelParser {
	// add "No" to the bus number to create Bus Id
	public static final String BusIdPreFix = "Bus";
	
	// bus and branch object cache for fast lookup. 
	private Hashtable<String,IDRecordXmlType> objectCache = null;
	public Hashtable<String,IDRecordXmlType> getObjectCache() { return this.objectCache; }

	private StudyCaseXmlType pssStudyCase = null;
	
	private ObjectFactory _factory = null;
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public JaxbODMModelParser(File xmlFile) throws Exception {
		JAXBElement<StudyCaseXmlType> elem = (JAXBElement<StudyCaseXmlType>)createUnmarshaller().unmarshal(xmlFile);
		this.pssStudyCase = elem.getValue();
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	@SuppressWarnings("unchecked")
	public JaxbODMModelParser(String xmlString) throws Exception {
		ByteArrayInputStream bStr = new ByteArrayInputStream(xmlString.getBytes());
		JAXBElement<StudyCaseXmlType> elem = (JAXBElement<StudyCaseXmlType>)createUnmarshaller().unmarshal(bStr);
		this.pssStudyCase = elem.getValue();
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
	}
	
	/**
	 * Constructor using an Xml string
	 * 
	 * @param in
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public JaxbODMModelParser(InputStream in) throws Exception {
		JAXBElement<StudyCaseXmlType> elem = (JAXBElement<StudyCaseXmlType>)createUnmarshaller().unmarshal(in);
		this.pssStudyCase = elem.getValue();
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
	}

	/**
	 * Default Constructor 
	 * 
	 */
	public JaxbODMModelParser() {
		this._factory = new ObjectFactory();		
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
		//this.doc = PSSStudyCaseDocument.Factory.newInstance();
		this.getStudyCase().setId("ODM_StudyCase");
		this.getStudyCase().setSchemaVersion(ModelContansts.ODM_Schema_Version);
	}
	
	public ObjectFactory getFactory() {
		return this._factory;
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
		this.pssStudyCase.setBaseCase(createAclfBaseCase());
	}
	
	/**
	 * create a ref record with id
	 * 
	 * @param id
	 * @return
	 */
	public BusRefRecordXmlType createBusRef(String id) {
		BusRecordXmlType rec = this.getBusRecord(id);
		BusRefRecordXmlType refBus = getFactory().createBusRefRecordXmlType();
		refBus.setIdRef(rec);
		return refBus;
	}	
	
	/**
	 * Get the baseCase element
	 * 
	 * @return
	 */
	public LoadflowNetXmlType getAclfBaseCase() {
		if (getStudyCase() == null) 
			createStudyCase();
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
	 * Get the cashed object by id
	 * 
	 * @param id
	 */
	private void removeCachedObject(String id) {
		this.objectCache.remove(id);
	}

	/**
	 * Get the cashed bus object by id
	 * 
	 * @param id
	 * @return
	 */
	public BusXmlType getBus(String id) {
		return (BusXmlType)this.getCachedObject(id);
	}
	
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
		getAclfBaseCase().getBusList().getBus().add(busRec);
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
	 * Get the cashed branch object by id
	 * 
	 * @param id
	 * @return
	 */
	public BranchXmlType getBranch(String branchId) {
		return (BranchXmlType)this.getCachedObject(branchId); 
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
		getAclfBaseCase().getBranchList().getBranch().add(branchRec);
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
		if(getAclfBaseCase().getAreaList()==null){
			getAclfBaseCase().setAreaList(this.getFactory().createNetworkXmlTypeAreaList());
		}
		NetAreaXmlType area = this.getFactory().createNetAreaXmlType();
		getAclfBaseCase().getAreaList().getArea().add(area);
		return area;
	}
	
	/**
	 * create an area object and added to the net.areaList
	 * 
	 * @return
	 */
	public NetZoneXmlType createNetworkLossZone() {
		if(getAclfBaseCase().getLossZoneList() == null){
			getAclfBaseCase().setLossZoneList(this.getFactory().createNetworkXmlTypeLossZoneList());
		}
		NetZoneXmlType zone = this.getFactory().createNetZoneXmlType();
		getAclfBaseCase().getLossZoneList().getLossZone().add(zone);
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
		if (getAclfBaseCase().getDcLineList() == null)
			getAclfBaseCase().setDcLineList(this.getFactory().createLoadflowNetXmlTypeDcLineList());
		getAclfBaseCase().getDcLineList().getDcLint2T().add(dcLine);
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
	
	public Unmarshaller createUnmarshaller() throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(ModelContansts.ODM_Schema_NS);
		return	jaxbContext.createUnmarshaller();	
	}	
	
	/**
	 * create a Jaxb marshaller to marshall the odm object to an Xml document
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
			JAXBElement<StudyCaseXmlType> element = getFactory().createPSSStudyCase(getStudyCase());
			createMarshaller().marshal( element, System.out );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toXmlDoc(boolean addXsi) {
		OutputStream ostream = new ByteArrayOutputStream();
		try {
			JAXBElement<StudyCaseXmlType> element = getFactory().createPSSStudyCase(getStudyCase());
			createMarshaller().marshal( element, ostream );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ostream.toString();
	}	
}
