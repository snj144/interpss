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

import com.interpss.common.util.IpssLogger;


public class StudyCaseHanlder {
	private InterPSSDocument ipssXmlDoc;

	public StudyCaseHanlder(InterPSSDocument ipssXmlDoc) {
		this.ipssXmlDoc = ipssXmlDoc;
	}
	
	public InterPSSDocument getIpssXmlDoc() {
		return this.ipssXmlDoc;
	}
	
	public GridComputingXmlType getGridComputing() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getGridRunOption();
	}
	
	public AclfStudyCaseXmlType[] getAclfStudyCaseList() {
		return this.ipssXmlDoc.getInterPSS().
				getRunStudyCase().getStandardRun().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray();
	}

	public AclfStudyCaseXmlType getAclfStudyCase(String recName) {
		for (AclfStudyCaseXmlType scase : getAclfStudyCaseList()) {
			if (scase.getRecName().equals(recName))
				return scase;
		}
		IpssLogger.getLogger().severe("Programming error, AclfStudyCase cannot be found, recId: " + recName);
		return null;
	}
	
	public String[] getStudyCaseNameArray() {
		return IpssXmlParser.getRecNameArray(getAclfStudyCaseList());
	}
}