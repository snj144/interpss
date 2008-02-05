/*
 * @(#)IpssXmlParser.java   
 *
 * Copyright (C) 2006-2007 www.interpss.org
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
 * @Date 09/15/2007
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
import org.ieee.cmte.psace.oss.odm.pss.schema.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.PSSStudyCaseDocument;
import org.ieee.cmte.psace.oss.odm.pss.schema.StudyCaseXmlType;

public class IEEEODMPSSModelParser {
	private PSSStudyCaseDocument doc = null;
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public IEEEODMPSSModelParser(File xmlFile) throws Exception {
		this.doc = PSSStudyCaseDocument.Factory.parse(xmlFile);
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
	}
	
	/**
	 * Get the root schema element StudyCase
	 * 
	 * @return
	 */
	public StudyCaseXmlType getStucyCase() {
		if (this.doc.getPSSStudyCase() == null)
			this.doc.addNewPSSStudyCase();
		return this.doc.getPSSStudyCase();
	}
	
	/**
	 * Get the baseCase element
	 * 
	 * @return
	 */
	public PSSNetworkXmlType getBaseCase() {
		if (getStucyCase().getBaseCase() == null)
			getStucyCase().addNewBaseCase();
		return getStucyCase().getBaseCase();
	}
	
	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		return this.doc.toString();
	}
}
