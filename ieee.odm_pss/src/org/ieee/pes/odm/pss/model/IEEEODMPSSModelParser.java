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
import org.ieee.cmte.psace.oss.odm.pss.schema.PSSStudyCaseDocument;
import org.ieee.cmte.psace.oss.odm.pss.schema.StudyCaseXmlType;

public class IEEEODMPSSModelParser {
	private StudyCaseXmlType pssStudyCase = null;
	
	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public IEEEODMPSSModelParser(File xmlFile) throws Exception {
		PSSStudyCaseDocument doc = PSSStudyCaseDocument.Factory.parse(xmlFile);
		this.pssStudyCase = doc.getPSSStudyCase();
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public IEEEODMPSSModelParser(String xmlString) throws XmlException {
		PSSStudyCaseDocument doc = PSSStudyCaseDocument.Factory.parse(xmlString);
		this.pssStudyCase = doc.getPSSStudyCase();
	}
	
	/**
	 * Get the root schema element
	 * 
	 * @return
	 */
	public StudyCaseXmlType getStucyCase() {
		return this.pssStudyCase;
	}
}
