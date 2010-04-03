/*
 * @(#)ODMModelParser.java   
 *
 * Copyright (C) 2006-2008 www.interpss.org
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
 * @Date 02/01/2008
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

import org.ieee.odm.model.ModelContansts;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.ConverterXmlType;
import org.ieee.odm.schema.DCLineData2TXmlType;
import org.ieee.odm.schema.IDRecordXmlType;
import org.ieee.odm.schema.IDRefRecordXmlType;
import org.ieee.odm.schema.NetAreaXmlType;
import org.ieee.odm.schema.PSSNetworkXmlType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StudyCaseXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;

public class JaxbODMModelParser {
	// add "No" to the bus number to create Bus Id
	public static final String BusIdPreFix = "Bus";
	
	public static final String Token_nsPrefix = "pss";
	public static final String Token_nsUrl = "http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1";

	// bus and branch object cache for fast lookup. 
	private Hashtable<String,IDRecordXmlType> objectCache = null;

	private StudyCaseXmlType pssStudyCase = null;
	
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
			this.pssStudyCase = new StudyCaseXmlType();
			// init the default study scenario
			//scase.addNewScenarioList();
		}	
		return this.pssStudyCase;
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
	 * Get the cashed bus object by id
	 * 
	 * @param id
	 * @return
	 */
	public BusRecordXmlType getBusRecord(String id) {
		return (BusRecordXmlType)this.getCachedObject(id);
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

	public BranchRecordXmlType getBranchRecord(String fromId, String toId, String cirId) {
		String id = ModelStringUtil.formBranchId(fromId, toId, cirId);
		return (BranchRecordXmlType)this.getCachedObject(id);
	}
	
	public BranchRecordXmlType getBranchRecord(String fromId, String toId, String tertId, String cirId) {
		String id = ModelStringUtil.formBranchId(fromId, toId, tertId, cirId);
		return (BranchRecordXmlType)this.getCachedObject(id);
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
	 * Get the baseCase element
	 * 
	 * @return
	 */
	public PSSNetworkXmlType getBaseCase() {
		if (getStudyCase().getBaseCase() == null) {
			PSSNetworkXmlType baseCase = new PSSNetworkXmlType();
			getStudyCase().setBaseCase(baseCase);
		}
		return getStudyCase().getBaseCase();
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
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public BusRecordXmlType addNewBaseCaseBus() {
		BusRecordXmlType busRec = new BusRecordXmlType();
		getStudyCase().getBaseCase().getBusList().getBus().add(busRec);
		return busRec;
	}	
	
	/**
	 * add a new bus record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public BusRecordXmlType addNewBaseCaseBus(String id, long number) throws Exception {
		BusRecordXmlType bus = new BusRecordXmlType();
		getStudyCase().getBaseCase().getBusList().getBus().add(bus);
		bus.setId(id);
		bus.setNumber(number);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Bus record duplication, bus id: " + id);
		}
		this.objectCache.put(id, bus);
		return bus;
	}	

	/**
	 * add a new Branch record to the base case
	 * 
	 * @return
	 */
	public BranchRecordXmlType addNewBaseCaseBranch() {
		BranchRecordXmlType branchRec = new BranchRecordXmlType();
		getStudyCase().getBaseCase().getBranchList().getBranch().add(branchRec);
		return branchRec;
	}
	
	/**
	 * add a new branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public BranchRecordXmlType addNewBaseCaseBranch(String id) throws Exception {
		BranchRecordXmlType branch = new BranchRecordXmlType();
		getStudyCase().getBaseCase().getBranchList().getBranch().add(branch);
		branch.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);
		return branch;
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
	 * add a new area record to the base case
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.AreaList getAreaList(){
		//if(getStudyCase().getBaseCase().getAreaList()==null){
		//	getStudyCase().getBaseCase().addNewAreaList();
		//}
		return getStudyCase().getBaseCase().getAreaList();
	}
	
	/**
	 * create an area object and added to the net.areaList
	 * 
	 * @return
	 */
	
	public NetAreaXmlType addNewBaseCaseArea() {
		NetAreaXmlType area = new NetAreaXmlType();
		getAreaList().getArea().add(area);
		return area;
	}
	
	/**
	 * get the net.tieLineList 
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.TieLineList getTielineList(){
		return getStudyCase().getBaseCase().getTieLineList();
	}
	
	/**
	 * create a tieLine object
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.TieLineList.Tieline addNewBaseCaseTieline() {
		PSSNetworkXmlType.TieLineList.Tieline tieLine = new PSSNetworkXmlType.TieLineList.Tieline();
		getTielineList().getTieline().add(tieLine);
		return tieLine;
	}
	
	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		 return this.pssStudyCase.toString(); 
	}
}
