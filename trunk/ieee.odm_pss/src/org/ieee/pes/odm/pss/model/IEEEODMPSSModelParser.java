/*
 * @(#)IEEEODMPSSModelParser.java   
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
 * A Xml parser for the InterPSS.xsd schema. 
 */

import java.io.File;

import org.apache.xmlbeans.XmlException;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBranchListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadCharacteristicXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NegativeSequenceDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetAreaXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSStudyCaseDocument;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PostiveSequenceDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ScenarioXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZeroSequenceDataListXmlType;

public class IEEEODMPSSModelParser {
	public static final String Token_nsPrefix = "pss";
	public static final String Token_nsUrl = "http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1";

	private static final StudyCaseXmlType.SchemaVersion.Enum CurrentSchemaVerion = StudyCaseXmlType.SchemaVersion.V_1_00_DEV;

	private PSSStudyCaseDocument doc = null;
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public IEEEODMPSSModelParser(File xmlFile) throws Exception {
		this.doc = PSSStudyCaseDocument.Factory.parse(xmlFile);
		if (!doc.validate()) 
			throw new Exception("Error: input XML document is invalid, file: " + xmlFile.getName());
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public IEEEODMPSSModelParser(String xmlString) throws XmlException {
		this.doc = PSSStudyCaseDocument.Factory.parse(xmlString);
	}
	
	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public IEEEODMPSSModelParser() {
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
			getBaseCase();
			scase.addNewScenarioList().addNewScenario();
		}	
		return this.doc.getPSSStudyCase();
	}
	
	public ScenarioXmlType getDefaultScenario() {
		return getStudyCase().getScenarioList().getScenarioArray()[0];
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
	
	public TransientSimulationXmlType getTransientSimlation(){
		return getTransientSimlation(getDefaultScenario());
	}
	
	public TransientSimulationXmlType getTransientSimlation(ScenarioXmlType scenario){
		if(scenario.getTransientSimlation()==null){
			TransientSimulationXmlType tranSimu=scenario.addNewTransientSimlation();
			tranSimu.addNewDynamicDataList();
			tranSimu.getDynamicDataList().addNewFaultList();
			tranSimu.getDynamicDataList().addNewBranchDynDataList();
			tranSimu.getDynamicDataList().addNewBusDynDataList();
			tranSimu.getDynamicDataList().addNewSequenceDataList();			
			tranSimu.getDynamicDataList().getSequenceDataList().addNewNegativeSequenceDataList();
			tranSimu.getDynamicDataList().getSequenceDataList().getNegativeSequenceDataList().
			                    addNewGeneratorNegativeList();
			tranSimu.getDynamicDataList().getSequenceDataList().getNegativeSequenceDataList()
			                   .addNewShuntLoadNegativeList();
			tranSimu.getDynamicDataList().getSequenceDataList().addNewPostiveSequenceDataList();
			tranSimu.getDynamicDataList().getSequenceDataList().getPostiveSequenceDataList()
			                   .addNewGeneratorPostiveList();
			tranSimu.getDynamicDataList().getSequenceDataList().addNewZeroSequenceDataList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
			                   .addNewGeneratorZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                               .addNewLineZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                               .addNewMutualImpedanceZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                              .addNewShuntLoadZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                              .addNewSwitchShuntedZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                              .addNewXfrZeroList();
			tranSimu.getDynamicDataList().getBusDynDataList().addNewGeneratorDataList();
			tranSimu.getDynamicDataList().getBusDynDataList().addNewLoadCharacteristicDataList();
			
			//tranSimu.addNewOutPutSetting();
			//tranSimu.addNewPowerFlowInitialization();
			//tranSimu.addNewSimulationSetting();
		}
		return scenario.getTransientSimlation();
	}	
	
	
	public FaultListXmlType.Fault addNewFault(ScenarioXmlType scenario){		
		return scenario.getTransientSimlation().getDynamicDataList().getFaultList().addNewFault();
	}
	
	public GeneratorXmlType addNewGen(ScenarioXmlType scenario){		
		return scenario.getTransientSimlation().getDynamicDataList().
		             getBusDynDataList().getGeneratorDataList().addNewGenerator();
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
	public NetAreaXmlType addNewBaseCaseArea() {
		return getAreaList().addNewArea();
	}
	
	public ExciterDataListXmlType getExciterList(TransientSimulationXmlType tranSimu){
		if(tranSimu.getDynamicDataList().
				getBusDynDataList().getExciterDataList()==null){
			tranSimu.getDynamicDataList().
			getBusDynDataList().addNewExciterDataList();
		}
		return tranSimu.getDynamicDataList().getBusDynDataList().getExciterDataList();
	}
	
	public ExciterXmlType addNewExciter(TransientSimulationXmlType tranSimu){
		return getExciterList(tranSimu).addNewExciter();
	}
	
	public TurbineGovernorDataListXmlType getTurbineGovernorDataList(TransientSimulationXmlType tranSimu){
		if(tranSimu.getDynamicDataList().
				getBusDynDataList().getTurbineGovernorDataList()==null){
			tranSimu.getDynamicDataList().getBusDynDataList().addNewTurbineGovernorDataList();
		}
		return tranSimu.getDynamicDataList().getBusDynDataList().getTurbineGovernorDataList();
	}
	
	public TurbineGovernorXmlType addNewTurbineGovernor(TransientSimulationXmlType tranSimu){
		return getTurbineGovernorDataList(tranSimu).addNewTurbineGovernor();
	}
	
	public StabilizerDataListXmlType getPSSDataList(TransientSimulationXmlType tranSimu){
		if(tranSimu.getDynamicDataList().
				getBusDynDataList().getStabilizerDataList()==null){
			tranSimu.getDynamicDataList().getBusDynDataList().addNewStabilizerDataList();
		}
		return tranSimu.getDynamicDataList().getBusDynDataList().getStabilizerDataList();
	}
	
	public StabilizerXmlType addNewStablilizerGovernor(TransientSimulationXmlType tranSimu){
		return getPSSDataList(tranSimu).addNewStabilizer();
	}
	
	
	public LoadCharacteristicXmlType addNewLoad(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList().
		    getBusDynDataList().getLoadCharacteristicDataList().addNewLoad();
	}
	
	public PSSNetworkXmlType.TieLineList getTielineList(){
		if(getStudyCase().getBaseCase().getTieLineList()==null){
			getStudyCase().getBaseCase().addNewTieLineList();
		}
		return getStudyCase().getBaseCase().getTieLineList();
	}
	public PSSNetworkXmlType.TieLineList.Tieline addNewBaseCaseTieline() {
		return getTielineList().addNewTieline();
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
	 * add a new Branch record to the base case
	 * 
	 * @return
	 */
	public BranchRecordXmlType addNewBaseCaseBranch() {
		return getStudyCase().getBaseCase().getBranchList().addNewBranch();		
	}
	
	/**
	 * add a new DC line bus record to the base case
	 * 
	 * @return
	 */
	public DCLineBusListXmlType getDCLineBusList(){
		if(getStudyCase().getBaseCase().getDcLineList()==null){
			getStudyCase().getBaseCase().addNewDcLineList();			
		}
		if(getStudyCase().getBaseCase().getDcLineList().getDcLineBusList()==null){
			getStudyCase().getBaseCase().getDcLineList().addNewDcLineBusList();
		}
		return getStudyCase().getBaseCase().getDcLineList().getDcLineBusList();
		
	}
	public DCLineBusRecordXmlType addNewBaseCaseDCLineBus() {
		return  getDCLineBusList().addNewDcLineBus();				
	}
	
	/**
	 * add a new DC line Branch record to the base case
	 * 
	 * @return
	 */
	public DCLineBranchListXmlType getDCLineBranchList(){
		if(getStudyCase().getBaseCase().getDcLineList()==null){
			getStudyCase().getBaseCase().addNewDcLineList();
		}
		if(getStudyCase().getBaseCase().getDcLineList().getDcLineBranchList()==null){
			getStudyCase().getBaseCase().getDcLineList().addNewDcLineBranchList();
		}
		return getStudyCase().getBaseCase().getDcLineList().getDcLineBranchList();
	}
	public DCLineBranchRecordXmlType addNewBaseCaseDCLineBranch() {
		return getDCLineBranchList().addNewDcLineBranch();		
	}
	
	public ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero addNewGenZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList().
		       getGeneratorZeroList().addNewGeneratorZero();
	}
	
	public ZeroSequenceDataListXmlType.LineZeroList.LineZero addNewLineZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getLineZeroList().addNewLineZero();
	}
	
	public ZeroSequenceDataListXmlType.MutualImpedanceZeroList.MutualImpedanceZero addNewMutualZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getMutualImpedanceZeroList().addNewMutualImpedanceZero();
	}
	
	public ZeroSequenceDataListXmlType.ShuntLoadZeroList.ShuntLoadZero addNewShuntLoadZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getShuntLoadZeroList().addNewShuntLoadZero();
	}
	
	public ZeroSequenceDataListXmlType.SwitchShuntedZeroList.SwitchShuntedZeroType addNewSwitchShuntZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getSwitchShuntedZeroList().addNewSwitchShuntedZeroType();
	}
	
	public ZeroSequenceDataListXmlType.XfrZeroList.XfrZero addNewXfrZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getXfrZeroList().addNewXfrZero();
	}
	
	public PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive addNewGenPos(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getPostiveSequenceDataList().getGeneratorPostiveList()
		.addNewGerneratorPostive();
	}
	
	public NegativeSequenceDataListXmlType.GeneratorNegativeList.GeneratorNegative addNewGenNeg(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getNegativeSequenceDataList().getGeneratorNegativeList()
		.addNewGeneratorNegative();
	}
	
	public NegativeSequenceDataListXmlType.ShuntLoadNegativeList.ShuntLoadNegative addNewShuntLoadNeg(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getNegativeSequenceDataList().getShuntLoadNegativeList()
		.addNewShuntLoadNegative();
	}

	public String toXmlDoc(boolean addXsi) {
		 if (addXsi)
			 return this.doc.xmlText(ODMData2XmlHelper.getXmlOpts()).replaceFirst("<pss:PSSStudyCase", 
				 "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pss:PSSStudyCase xmlns:pss=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\" " +
				 "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
		 else
			 return this.doc.xmlText(ODMData2XmlHelper.getXmlOpts()).replaceFirst("<pss:PSSStudyCase", 
				 "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pss:PSSStudyCase xmlns:pss=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\"");
	}

	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		 return this.doc.toString(); 
	}
}
