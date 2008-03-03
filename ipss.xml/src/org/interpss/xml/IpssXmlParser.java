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

package org.interpss.xml;

/**
 * A Xml parser for the InterPSS.xsd schema. 
 */

import java.io.File;

import org.apache.xmlbeans.XmlException;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.UnitXmlData;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;

public class IpssXmlParser {
	private InterPSSXmlType ipss = null;

	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public IpssXmlParser(File xmlFile) throws Exception {
		InterPSSDocument ipssDoc = InterPSSDocument.Factory.parse(xmlFile);
		this.ipss = ipssDoc.getInterPSS();
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public IpssXmlParser(String xmlString) throws XmlException {
		InterPSSDocument ipssDoc = InterPSSDocument.Factory.parse(xmlString);
		if (!ipssDoc.validate()) {
			IpssLogger.getLogger().severe("Error: invalid Xml scripts, " + xmlString);
			throw new XmlException("Invalid Xml scripts");
		}
		this.ipss = ipssDoc.getInterPSS();
	}

	/**
	 * Get the RunStudyCaseXmlType element
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType getRunStudyCase() {
		return ipss.getRunStudyCase();
	}

	/**
	 * Get the DclfStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.DclfStudyCaseList.DclfStudyCase[] getRunDclfStudyCaseList() {
		return ipss.getRunStudyCase().getDclfStudyCaseList().getDclfStudyCaseArray();
	}

	/**
	 * Get the AclfStudyCase element list
	 * 
	 * @return
	 */
	public RunAclfStudyCaseXmlType[] getRunAclfStudyCaseList() {
		return ipss.getRunStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray();
	}

	/**
	 * Get the AcscStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.AcscStudyCaseList.AcscStudyCase[] getRunAcscStudyCaseList() {
		return ipss.getRunStudyCase().getAcscStudyCaseList().getAcscStudyCaseArray();
	}

	/**
	 * Get the AcscStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.DstabStudyCaseList.DstabStudyCase[] getRunDStabStudyCaseList() {
		return ipss.getRunStudyCase().getDstabStudyCaseList().getDstabStudyCaseArray();
	}

	/**
	 * Get the schema top-level modification element
	 * 
	 * @return
	 */
	public ModificationXmlType getModification() {
		return ipss.getModification();
	}

	/**
	 * map Xml unit type to InterPSS UnitType
	 * 
	 * @param type
	 * @return
	 */
	public static byte mapXmlUnitType2IpssUnitType(UnitXmlData.Enum type) {
		if (type == UnitXmlData.PU)
			return UnitType.PU;
		else if (type == UnitXmlData.PERCENT)
			return UnitType.Percent;

		else if (type == UnitXmlData.DEG)
			return UnitType.Deg;
		else if (type == UnitXmlData.RAD)
			return UnitType.Rad;

		else if (type == UnitXmlData.VOLT)
			return UnitType.Volt;
		else if (type == UnitXmlData.K_V)
			return UnitType.kV;

		else if (type == UnitXmlData.AMP)
			return UnitType.Amp;
		else if (type == UnitXmlData.K_AMP)
			return UnitType.kAmp;
		else if (type == UnitXmlData.MILLI_AMP)
			return UnitType.MilliAmp;

		else if (type == UnitXmlData.WATT)
			return UnitType.Watt;
		else if (type == UnitXmlData.KW)
			return UnitType.kW;
		else if (type == UnitXmlData.M_W)
			return UnitType.mW;

		else if (type == UnitXmlData.VAR)
			return UnitType.Var;
		else if (type == UnitXmlData.K_VAR)
			return UnitType.kVar;
		else if (type == UnitXmlData.M_VAR)
			return UnitType.mVar;

		else if (type == UnitXmlData.VA)
			return UnitType.VA;
		else if (type == UnitXmlData.KVA)
			return UnitType.kVA;
		else if (type == UnitXmlData.M_VA)
			return UnitType.mVA;

		return UnitType.NotDefined;
	}
}
