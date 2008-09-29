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
import org.interpss.schema.BaseRecordXmlType;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.ContingencyAnalysisXmlType;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RuleBaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.UnitDataType;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;

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
	 * Get the busRec in the net object
	 * 
	 * @param busRec
	 * @param net
	 * @return
	 */
	public static Bus getBus(BusRecXmlType busRec, Network net) {
		String busId = busRec.getBusId();
		Bus bus = net.getBus(busId);
		if (bus == null) {
			IpssLogger.getLogger().warning("Bus not found, busId: " + busId);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Error in Xml", "Bus not found, busId: " + busId);
		}
		return bus;
	}

	/**
	 * Get the braRec from the net object
	 * 
	 * @param braRec
	 * @param net
	 * @return
	 */
	public static Branch getBranch(BranchRecXmlType braRec, Network net) {
		String fromId = braRec.getFromBusId();
		String toId = braRec.getToBusId();
		String cirNo = braRec.getCircuitNumber();
		Branch branch = null;
		if (cirNo != null)
			branch = net.getBranch(fromId, toId, cirNo);
		else
			branch = net.getBranch(fromId, toId);

		if (branch == null && net.isSwitchBreakModel()) {
			// if switch/branch model, the bus id might be dummy bus id
			branch = net.getSwitchBreakBranch(fromId, null);
			if (branch == null)
				branch = net.getSwitchBreakBranch(toId, null);
			
			// check if branch cir no is correct
			if (branch != null && cirNo != null) {
				if (!cirNo.equals(branch.getCircuitNumber())) {
					branch = null;
					IpssLogger.getLogger().warning(
							"Branch with dummy bus found, but cir no mismatch, fromId, toId, cirNo: " 
							+ fromId + ", "	+ toId + ", " + cirNo);
				}
			}
		}
		
		if (branch == null) {
			IpssLogger.getLogger().warning(
					"Branch not found, fromId, toId, cirNo: " + fromId + ", "
							+ toId + ", " + cirNo);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Error in Xml",
					"Branch not found, fromId, toId, cirNo: " + fromId + ", "
							+ toId + ", " + cirNo);
		}
		return branch;
	}	
	
	/**
	 * Get record name list from the record list 
	 * 
	 * @param list
	 * @return
	 */
	public static String[] getRecNameArray(BaseRecordXmlType[] list) {
		String[] sAry = new String[list.length];
		int cnt = 0;
		for (BaseRecordXmlType scase : list) {
			sAry[cnt++] = scase.getRecName();
		}
		return sAry;
	}	
	
	/**
	 * Get recod by name from the record list
	 * 
	 * @param recName
	 * @param list
	 * @return
	 */
	public static BaseRecordXmlType getRecord(String recName, BaseRecordXmlType[] list) {
		for (BaseRecordXmlType scase : list) {
			if (scase.getRecName().equals(recName))
				return scase;
		}
		IpssLogger.getLogger().severe("Programming error, StudyCase cannot be found, recId: " + recName);
		return null;
	}
	
	/**
	 * map Xml unit type to InterPSS UnitType
	 * 
	 * @param type
	 * @return
	 */
	public static byte mapXmlUnitType2IpssUnitType(UnitDataType.Enum type) {
		if (type == UnitDataType.PU)
			return UnitType.PU;
		else if (type == UnitDataType.PERCENT)
			return UnitType.Percent;

		else if (type == UnitDataType.DEG)
			return UnitType.Deg;
		else if (type == UnitDataType.RAD)
			return UnitType.Rad;

		else if (type == UnitDataType.VOLT)
			return UnitType.Volt;
		else if (type == UnitDataType.K_V)
			return UnitType.kV;

		else if (type == UnitDataType.AMP)
			return UnitType.Amp;
		else if (type == UnitDataType.K_AMP)
			return UnitType.kAmp;
		else if (type == UnitDataType.MILLI_AMP)
			return UnitType.MilliAmp;

		else if (type == UnitDataType.WATT)
			return UnitType.Watt;
		else if (type == UnitDataType.KW)
			return UnitType.kW;
		else if (type == UnitDataType.M_W)
			return UnitType.mW;

		else if (type == UnitDataType.VAR)
			return UnitType.Var;
		else if (type == UnitDataType.K_VAR)
			return UnitType.kVar;
		else if (type == UnitDataType.M_VAR)
			return UnitType.mVar;

		else if (type == UnitDataType.VA)
			return UnitType.VA;
		else if (type == UnitDataType.KVA)
			return UnitType.kVA;
		else if (type == UnitDataType.M_VA)
			return UnitType.mVA;

		return UnitType.NotDefined;
	}
	
	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		 return this.ipssDoc.getInterPSS().toString(); 
	}	
	
	public static String toXmlDocString(InterPSSDocument xmlDoc) {
		return xmlDoc.xmlText();
	}
}
