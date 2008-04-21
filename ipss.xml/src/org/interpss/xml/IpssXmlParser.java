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
import org.interpss.schema.AclfRuleBaseXmlType;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.ProtectionRuleSetXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.UnitXmlData;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;

public class IpssXmlParser {
	private InterPSSXmlType ipss = null;

	/**
	 * default Constructor
	 * 
	 * @param type Analysis run type
	 */
	public IpssXmlParser(RunStudyCaseXmlType.AnalysisRunType.Enum type) {
		InterPSSDocument ipssDoc = InterPSSDocument.Factory.newInstance();
		this.ipss = ipssDoc.addNewInterPSS();
		this.ipss.addNewRunStudyCase();
		if (type == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF) {
			getRunStudyCase().setAnalysisRunType(RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
			getRunStudyCase().addNewRunAclfStudyCase();
			getRunAclfStudyCase().addNewAclfStudyCaseList();
		}
	}

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
	 * Get the root document
	 * 
	 * @return
	 */
	public InterPSSXmlType getRootDoc() {
		return this.ipss;
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
	 * Get the RunDclfStudyCase element
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.RunDclfStudyCase getRunDclfStudyCase() {
		return ipss.getRunStudyCase().getRunDclfStudyCase();
	}

	/**
	 * Get the RunAclfStudyCase element
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.RunAclfStudyCase getRunAclfStudyCase() {
		return ipss.getRunStudyCase().getRunAclfStudyCase();
	}

	/**
	 * Get the AcscStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.RunAcscStudyCase getRunAcscStudyCase() {
		return ipss.getRunStudyCase().getRunAcscStudyCase();
	}

	/**
	 * Get the AcscStudyCase element list
	 * 
	 * @return
	 */
	public RunStudyCaseXmlType.RunDStabStudyCase getRunDStabStudyCase() {
		return ipss.getRunStudyCase().getRunDStabStudyCase();
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
		Branch branch = null;
		String cirNo = braRec.getCircuitNumber();
		if (cirNo != null)
			branch = net.getBranch(fromId, toId, cirNo);
		else
			branch = net.getBranch(fromId, toId);
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
	 * Find the largest priority number. 
	 * 
	 * @param aclfRuleBase
	 * @return
	 */
	public static int getUpperPriority(AclfRuleBaseXmlType aclfRuleBase) {
		int p = 1;   // priority starts from 1, max 10
		for (ProtectionRuleSetXmlType ruleSet : aclfRuleBase.getProtectionRuleSetList().getProtectionRuleSetArray()) {
			if (ruleSet.getPriority() > p)
				p = ruleSet.getPriority();
		}
		return p;
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
	
	/**
	 * convert the document object to an XML string
	 */
	public String toString() {
		 return this.ipss.toString(); 
	}	
}
