/*
 * @(#)StudyCaseHanlder.java   
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
 * @Date 09/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.xml;

import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.GridComputingXmlType;
import org.interpss.schema.InterPSSDocument;


public class StudyCaseHanlder {
	private InterPSSDocument ipssXmlDoc;

	public StudyCaseHanlder(InterPSSDocument ipssXmlDoc) {
		this.ipssXmlDoc = ipssXmlDoc;
	}
	
	/**
	 * Get the Ipss Xml document
	 * 
	 * @return
	 */
	public InterPSSDocument getIpssXmlDoc() {
		return this.ipssXmlDoc;
	}
	
	/**
	 * Get the grid computing option record from the Ipss Xml document
	 * 
	 * @return
	 */
	public GridComputingXmlType getGridOption() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getGridRunOption();
	}
	
	/**
	 * Get the AclfStudyCase record list
	 * 
	 * @return
	 */
	public AclfStudyCaseXmlType[] getAclfStudyCaseList() {
		return this.ipssXmlDoc.getInterPSS().
				getRunStudyCase().getStandardRun().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray();
	}

	/**
	 * Get the AclfStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public AclfStudyCaseXmlType getAclfStudyCase(String recName) {
		return 	(AclfStudyCaseXmlType)IpssXmlParser.getRecord(recName, getAclfStudyCaseList());
	}
	
	/**
	 * Get AclfStudyCase name array
	 * 
	 * @return
	 */
	public String[] getAclfStudyCaseNameArray() {
		return IpssXmlParser.getRecNameArray(getAclfStudyCaseList());
	}
/*
	public AcscStudyCaseXmlType[] getAcscStudyCaseList() {
		return this.ipssXmlDoc.getInterPSS().
				getRunStudyCase().getStandardRun().getRunAcscStudyCase().getAcscStudyCaseList().getAcscStudyCaseRecArray();
	}

	public AcscStudyCaseXmlType getAcscStudyCase(String recName) {
		return 	(AcscStudyCaseXmlType)IpssXmlParser.getRecord(recName, getAcscStudyCaseList());
	}
	
	public String[] getAcscStudyCaseNameArray() {
		return IpssXmlParser.getRecNameArray(getAcscStudyCaseList());
	}
*/	
}