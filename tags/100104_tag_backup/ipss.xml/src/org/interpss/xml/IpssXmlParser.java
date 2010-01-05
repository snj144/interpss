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
import org.interpss.schema.ContingencyAnalysisXmlType;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RuleBaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;

import com.interpss.common.util.IpssLogger;

public class IpssXmlParser {
	private InterPSSDocument ipssDoc = null;

	/**
	 * default Constructor
	 * 
	 * @param type Analysis run type
	 */
	public IpssXmlParser(RunStudyCaseXmlType.AnalysisRunType.Enum type) {
		this.ipssDoc = InterPSSDocument.Factory.newInstance();
		InterPSSXmlType ipss = ipssDoc.addNewInterPSS();
		ipss.addNewRunStudyCase();
		getRunStudyCase().setAnalysisRunType(type);
		if (type == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF) {
			getRunStudyCase().addNewStandardRun().addNewRunAclfStudyCase();
			getRunAclfStudyCase().addNewAclfStudyCaseList();
		}
		else if (type == RunStudyCaseXmlType.AnalysisRunType.CONTINGENCY_ANALYSIS) {
			getRunStudyCase().addNewContingencyAnalysis();
			getContingencyAnalysis().addNewAclfStudyCaseList();
		}
	}

	/**
	 * Constructor using an Xml file
	 * 
	 * @param xmlFile
	 * @throws Exception
	 */
	public IpssXmlParser(File xmlFile) throws Exception {
		this.ipssDoc = InterPSSDocument.Factory.parse(xmlFile);
	}

	/**
	 * Constructor using an Xml string
	 * 
	 * @param xmlString
	 * @throws XmlException
	 */
	public IpssXmlParser(String xmlString) throws XmlException {
		this.ipssDoc = InterPSSDocument.Factory.parse(xmlString);
		if (!ipssDoc.validate()) {
			IpssLogger.getLogger().severe("Error: invalid Xml scripts, " + xmlString);
			throw new XmlException("Invalid Xml scripts");
		}
	}
	
	/**
	 * Get the root document
	 * 
	 * @return
	 */
	public InterPSSDocument getRootDoc() {
		return this.ipssDoc;
	}
	
	/**
	 * Get the RunStudyCaseXmlType element
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType getRunStudyCase() {
		return this.ipssDoc.getInterPSS().getRunStudyCase();
	}

	/**
	 * Get the RunDclfStudyCase element
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.StandardRun.RunDclfStudyCase getRunDclfStudyCase() {
		return this.ipssDoc.getInterPSS().getRunStudyCase().getStandardRun().getRunDclfStudyCase();
	}

	/**
	 * Get the RunAclfStudyCase element
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.StandardRun.RunAclfStudyCase getRunAclfStudyCase() {
		return this.ipssDoc.getInterPSS().getRunStudyCase().getStandardRun().getRunAclfStudyCase();
	}

	/**
	 * Get the AcscStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.StandardRun.RunAcscStudyCase getRunAcscStudyCase() {
		return this.ipssDoc.getInterPSS().getRunStudyCase().getStandardRun().getRunAcscStudyCase();
	}

	/**
	 * Get the AcscStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.StandardRun.RunDStabStudyCase getRunDStabStudyCase() {
		return this.ipssDoc.getInterPSS().getRunStudyCase().getStandardRun().getRunDStabStudyCase();
	}

	/**
	 * Get the ContingencyAnalysis element list
	 * 
	 * @return
	 */
	public ContingencyAnalysisXmlType getContingencyAnalysis() {
		return this.ipssDoc.getInterPSS().getRunStudyCase().getContingencyAnalysis();
	}

	/**
	 * Get the RuleBase object
	 * 
	 * @return
	 */
	public RuleBaseXmlType getRuleBase() {
		return this.ipssDoc.getInterPSS().getRunStudyCase().getRuleBase();
	}

	/**
	 * Get the schema top-level modification element
	 * 
	 * @return
	 */
	public ModificationXmlType getModification() {
		return this.ipssDoc.getInterPSS().getModification();
	}

	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		 return this.ipssDoc.getInterPSS().toString(); 
	}	
}
