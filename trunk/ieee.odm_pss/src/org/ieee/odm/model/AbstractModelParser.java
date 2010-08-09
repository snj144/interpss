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
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusRefRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.ContentInfoXmlType;
import org.ieee.odm.schema.IDRecordXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.StudyCaseXmlType;

public abstract class AbstractModelParser implements IODMModelParser {
	// add "Bus" pre-fix to the bus number to create Bus Id
	public static final String BusIdPreFix = "Bus";
	
	/*
	 *	property definition
	 * 	=================== 
	 */
	
	// bus and branch object cache for fast lookup. 
	protected Hashtable<String,IDRecordXmlType> objectCache = null;
	public Hashtable<String,IDRecordXmlType> getObjectCache() { return this.objectCache; }

	protected StudyCaseXmlType pssStudyCase = null;
	
	protected ObjectFactory _factory = null;
	public ObjectFactory getFactory() {	return this._factory == null? new ObjectFactory() : this._factory; }
	
	/*
	 *	Constructor 
	 *  ===========
	 */
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public AbstractModelParser(File xmlFile) throws Exception {
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
	public AbstractModelParser(String xmlString) throws Exception {
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
	public AbstractModelParser(InputStream in) throws Exception {
		JAXBElement<StudyCaseXmlType> elem = (JAXBElement<StudyCaseXmlType>)createUnmarshaller().unmarshal(in);
		this.pssStudyCase = elem.getValue();
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
		// cache the loaded bus and branch objects
		for (JAXBElement<BusXmlType> bus : this.getBaseCase().getBusList().getBus()) {
			BusXmlType b = bus.getValue();
			this.objectCache.put(b.getId(), b);
		}
		for (JAXBElement<BaseBranchXmlType> branch : this.getBaseCase().getBranchList().getBranch()) {
			BaseBranchXmlType b = branch.getValue();
			this.objectCache.put(b.getId(), b);
		}
	}

	/**
	 * Default Constructor 
	 * 
	 */
	public AbstractModelParser() {
		this.objectCache = new Hashtable<String, IDRecordXmlType>();
		this.getStudyCase().setId("ODM_StudyCase");
		this.getStudyCase().setSchemaVersion(ModelContansts.ODM_Schema_Version);
	}
	
	/*
	 * 	Abstract functions
	 * 	================== 
	 */

	/**
	 * create BaseCase object, which shold be a child of NetworkXmlType, for
	 * example LoadflowXmlType
	 */
	public abstract NetworkXmlType createBaseCase();
	
	/*
	 * 	Case/Network level functions
	 * 	=========================== 
	 */

	/**
	 * Set BaseCase to Loadflow and Transmission 
	 * 
	 * @param parser
	 * @param originalFormat
	 */
	public void setLFTransInfo(OriginalDataFormatEnumType originalDataFormat) {
		ContentInfoXmlType info = getFactory().createContentInfoXmlType();
		getStudyCase().setContentInfo(info);
		info.setOriginalDataFormat(originalDataFormat);
		info.setAdapterProviderName("www.interpss.org");
		info.setAdapterProviderVersion("1.00");
		
		getStudyCase().getBaseCase().setAnalysisCategory(
				AnalysisCategoryEnumType.LOADFLOW);
		getStudyCase().getBaseCase().setNetworkCategory(
				NetworkCategoryEnumType.TRANSMISSION);		
	}	
	
	/**
	 * Get the root schema element StudyCase
	 * 
	 * @return
	 */
	public StudyCaseXmlType getStudyCase() {
		if (this.pssStudyCase == null) {
			this.pssStudyCase = new StudyCaseXmlType();
			this.pssStudyCase.setBaseCase(createBaseCase());
		}	
		return this.pssStudyCase;
	}

	protected NetworkXmlType getBaseCase() {
		return this.pssStudyCase.getBaseCase();
	}

	/*
	 * 	Bus/Branch object, reference functions
	 * 	======================================
	 */
	
	/**
	 * Get the cashed object by id
	 * 
	 * @param id
	 * @return
	 */
	protected IDRecordXmlType getCachedObject(String id) {
		return this.objectCache.get(id);
	}	
	
	/**
	 * Get the cashed object by id
	 * 
	 * @param id
	 */
	protected void removeCachedObject(String id) {
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

//	public boolean removeBus(String busId) {
//		Object bus = this.objectCache.get(busId);
//		this.removeCachedObject(busId);
//		return this.getBaseCase().getBusList().getBus().remove(bus); 
//	}

	/**
	 * create a ref record with id
	 * 
	 * @param id
	 * @return
	 */
	public BusRefRecordXmlType createBusRef(String id) {
		BusXmlType rec = this.getBus(id);
		BusRefRecordXmlType refBus = getFactory().createBusRefRecordXmlType();
		refBus.setIdRef(rec);
		return refBus;
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

	public boolean removeBranch(String branchId) {
		Object branch = this.objectCache.get(branchId);
		this.removeCachedObject(branchId);
		return this.getBaseCase().getBranchList().getBranch().remove(branch); 
	}

//	public boolean removeBranch(String fromId, String toId, String cirId) {
//		String id = ModelStringUtil.formBranchId(fromId, toId, cirId);
//		return removeBranch(id);
//	}
	
	/**
	 * get the cashed branch record using fromId, toId and cirId
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public BranchXmlType getBranch(String fromId, String toId, String cirId) {
		String id = ModelStringUtil.formBranchId(fromId, toId, cirId);
		return this.getBranch(id);
	}	
	
	public BranchXmlType getBranch(String fromId, String toId, String tertId, String cirId) {
		String id = ModelStringUtil.formBranchId(fromId, toId, tertId, cirId);
		return this.getBranch(id);
	}	

	/*
	 * 	marshall/unmarshall, out functions
	 * 	==================================
	 */

	/**
	 * create a Jaxb unmarshaller to unmarshall Xml document to odm object
	 *  
	 * @return
	 * @throws JAXBException
	 */
	private static Unmarshaller unmarshaller = null;
	public Unmarshaller createUnmarshaller() throws JAXBException {
		if (unmarshaller == null) {
			JAXBContext jaxbContext = JAXBContext.newInstance(ModelContansts.ODM_Schema_NS);
			unmarshaller = jaxbContext.createUnmarshaller();
		}
		return unmarshaller;
	}	

	/**
	 * create a Jaxb marshaller to marshall the odm object to an Xml document
	 * 
	 * @return
	 * @throws JAXBException
	 */
	private Marshaller marshaller = null;
	public Marshaller createMarshaller() throws JAXBException {
		if (marshaller == null) {
			JAXBContext jaxbContext	= JAXBContext.newInstance(ModelContansts.ODM_Schema_NS);
			marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		}
		return marshaller;
	}
	
	/**
	 * print the Xml doc to the std out
	 * 
	 */
	public void stdout() {
		try {
			JAXBElement<StudyCaseXmlType> element = getFactory().createPssStudyCase(getStudyCase());
			createMarshaller().marshal( element, System.out );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param addXsi not used in Jabx. It is for XmlBeans
	 */
	public String toXmlDoc(boolean addXsi) {
		OutputStream ostream = new ByteArrayOutputStream();
		try {
			JAXBElement<StudyCaseXmlType> element = getFactory().createPssStudyCase(getStudyCase());
			createMarshaller().marshal( element, ostream );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ostream.toString();
	}	
}
