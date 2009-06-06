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

package org.ieee.pes.odm.pss.model;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

import java.io.File;
import java.util.Hashtable;

import org.apache.xmlbeans.XmlException;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.IDRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetAreaXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSStudyCaseDocument;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ScenarioXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;

public class ODMModelParser {
	// add "No" to the bus number to create Bus Id
	public static final String BusIdPreFix = "Bus";
	
	public static final String Token_nsPrefix = "pss";
	public static final String Token_nsUrl = "http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1";

	private static final StudyCaseXmlType.SchemaVersion.Enum CurrentSchemaVerion = StudyCaseXmlType.SchemaVersion.V_0_3;
	
	// bus and branch object cache for fast lookup. 
	private Hashtable<String,IDRecordXmlType> objectCache = null;

	private PSSStudyCaseDocument doc = null;
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public ODMModelParser(File xmlFile) throws Exception {
		this.doc = PSSStudyCaseDocument.Factory.parse(xmlFile);
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
		if (!doc.validate()) 
			throw new Exception("Error: input XML document is invalid, file: " + xmlFile.getName());
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public ODMModelParser(String xmlString) throws XmlException {
		this.doc = PSSStudyCaseDocument.Factory.parse(xmlString);
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
	}
	
	/**
	 * Default Constructor 
	 * 
	 */
	public ODMModelParser() {
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
		this.doc = PSSStudyCaseDocument.Factory.newInstance();
		this.getStudyCase().setId("ODM_StudyCase");
		this.getStudyCase().setSchemaVersion(CurrentSchemaVerion);
	}
	
	/**
	 * Get the root schema element StudyCase
	 * 
	 * @return
	 */
	public StudyCaseXmlType getStudyCase() {
		if (this.doc.getPSSStudyCase() == null) {
			StudyCaseXmlType scase = this.doc.addNewPSSStudyCase();
			// init the base case
			getBaseCase();
			// init the default study scenario
			scase.addNewScenarioList();
		}	
		return this.doc.getPSSStudyCase();
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
	public BranchRecordXmlType getBranchRecord(String fromId, String toId, String cirId) {
		String id = StringUtil.formBranchId(fromId, toId, cirId);
		return (BranchRecordXmlType)this.getCachedObject(id);
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
			PSSNetworkXmlType baseCase = getStudyCase().addNewBaseCase();
			baseCase.addNewBusList();
			baseCase.addNewBranchList();		
		}
		return getStudyCase().getBaseCase();
	}

	/**
	 * Get the default scenario
	 * 
	 * @return
	 */
	public ScenarioXmlType getDefaultScenario() {
		return getStudyCase().getScenarioList().getScenarioArray()[0];
	}

	/**
	 * Get the transient stability simulation record of the default scenario
	 *  
	 * @return
	 */
	public TransientSimulationXmlType getDefaultTransSimu(){
		return TranStabSimuHelper.getTransientSimlation(getDefaultScenario());
	}
	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public BusRecordXmlType addNewBaseCaseBus() {
		return getStudyCase().getBaseCase().getBusList().addNewBus();
	}	
	
	/**
	 * add a new bus record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public BusRecordXmlType addNewBaseCaseBus(String id) throws Exception {
		BusRecordXmlType bus = getStudyCase().getBaseCase().getBusList().addNewBus();
		bus.setId(id);
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
		return getStudyCase().getBaseCase().getBranchList().addNewBranch();		
	}
	
	/**
	 * add a new branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public BranchRecordXmlType addNewBaseCaseBranch(String id) throws Exception {
		BranchRecordXmlType branch = getStudyCase().getBaseCase().getBranchList().addNewBranch();
		branch.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Branch record duplication, bus id: " + id);
		}
		this.objectCache.put(id, branch);
		return branch;
	}
	
	/**
	 * add a new area record to the base case
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.AreaList getAreaList(){
		if(getStudyCase().getBaseCase().getAreaList()==null){
			getStudyCase().getBaseCase().addNewAreaList();
		}
		return getStudyCase().getBaseCase().getAreaList();
	}
	
	/**
	 * create an area object and added to the net.areaList
	 * 
	 * @return
	 */
	
	public NetAreaXmlType addNewBaseCaseArea() {
		return getAreaList().addNewArea();
	}
	
	/**
	 * get the net.tieLineList 
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.TieLineList getTielineList(){
		if(getStudyCase().getBaseCase().getTieLineList()==null){
			getStudyCase().getBaseCase().addNewTieLineList();
		}
		return getStudyCase().getBaseCase().getTieLineList();
	}
	
	/**
	 * create a tieLine object
	 * 
	 * @return
	 */
	public PSSNetworkXmlType.TieLineList.Tieline addNewBaseCaseTieline() {
		return getTielineList().addNewTieline();
	}
	
	/**
	 * add a new DC line bus record to the base case
	 * 
	 * @return
	 */
	@Deprecated
	public PSSNetworkXmlType.DcLineList.DcLineBusList getDCLineBusList(){
		if(getStudyCase().getBaseCase().getDcLineList()==null){
			getStudyCase().getBaseCase().addNewDcLineList();			
		}
		if(getStudyCase().getBaseCase().getDcLineList().getDcLineBusList()==null){
			getStudyCase().getBaseCase().getDcLineList().addNewDcLineBusList();
		}
		return getStudyCase().getBaseCase().getDcLineList().getDcLineBusList();
	}
	
	/**
	 * create a DCLineBus object
	 * 
	 * @return
	 */
	@Deprecated
	public DCLineBusRecordXmlType addNewBaseCaseDCLineBus() {
		DCLineBusRecordXmlType dcLineBus =  getDCLineBusList().addNewDcLineBus();
		dcLineBus.addNewConverter().addNewData();
		return dcLineBus;
	}
	
	/**
	 * add a new DC line Branch record to the base case
	 * 
	 * @return
	 */
	@Deprecated
	public PSSNetworkXmlType.DcLineList.DcLineBranchList getDCLineBranchList(){
		if(getStudyCase().getBaseCase().getDcLineList()==null){
			getStudyCase().getBaseCase().addNewDcLineList();
		}
		if(getStudyCase().getBaseCase().getDcLineList().getDcLineBranchList()==null){
			getStudyCase().getBaseCase().getDcLineList().addNewDcLineBranchList();
		}
		return getStudyCase().getBaseCase().getDcLineList().getDcLineBranchList();
	}
	
	/**
	 * 
	 * @return
	 */
	@Deprecated
	public DCLineBranchRecordXmlType addNewBaseCaseDCLineBranch() {
		DCLineBranchRecordXmlType dcLineBranch = getDCLineBranchList().addNewDcLineBranch();
		dcLineBranch.addNewData();
		return dcLineBranch;
	}
	
	public String toXmlDoc(boolean addXsi) {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pss:PSSStudyCase xmlns:pss=\"" + Token_nsUrl + "\"";
		if (addXsi)
			return this.doc.xmlText(ParserHelper.getXmlOpts()).replaceFirst("<pss:PSSStudyCase", 
				 str + " " + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
		else
			return this.doc.xmlText(ParserHelper.getXmlOpts()).replaceFirst("<pss:PSSStudyCase", str);
	}

	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		 return this.doc.toString(); 
	}
}
