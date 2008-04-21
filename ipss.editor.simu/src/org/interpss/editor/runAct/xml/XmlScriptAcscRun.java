/*
 * @(#)XmlScriptAcscRun.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 01/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.editor.runAct.xml;

import org.interpss.PluginSpringAppContext;
import org.interpss.editor.runAct.RunActUtilFunc;
import org.interpss.schema.AcscStudyCaseXmlType;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunAcscStudyCase.AcscStudyCaseList.AcscStudyCaseRec;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;

public class XmlScriptAcscRun {
	/**
	 * Run Acsc run or run(s) defined in the Xml scripts
	 * 
	 * @param parser The InterPSS xml parser object
	 * @param aclfNet
	 * @param msg
	 * @return
	 */
	public static boolean runAcsc(InterPSSXmlType ipssXmlDoc,
			SimpleFaultNetwork faultNet, IPSSMsgHub msg) {
		IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
		if (ipssXmlDoc.getRunStudyCase().getRunAcscStudyCase() != null) {
			RunStudyCaseXmlType.RunAcscStudyCase xmlRunCase = ipssXmlDoc.getRunStudyCase()
					.getRunAcscStudyCase();
			SimpleFaultAlgorithm algo = CoreObjectFactory
					.createSimpleFaultAlgorithm(faultNet);
			
			AcscStudyCaseXmlType xmlDefaultCase = xmlRunCase.getDefaultAcscStudyCase(); 
			
			for ( AcscStudyCaseRec rec : xmlRunCase.getAcscStudyCaseList().getAcscStudyCaseRecArray()) {
				if (rec.getModification() != null) {
					// TODO: apply the modification
				}

				AcscStudyCaseXmlType xmlCase = rec.getAcscStudyCase();
				if (xmlCase == null) {
					if (xmlDefaultCase == null) {
						msg.sendErrorMsg("No Acsc study case defined");
						return false;
					}
					xmlCase = xmlDefaultCase;
					rec.setAcscStudyCase(xmlDefaultCase);
				} 
				if (rec.getModification() != null)
					mapper.mapping(rec.getModification(), faultNet, ModificationXmlType.class);
				mapper.mapping(rec, algo, AcscStudyCaseXmlType.class);
				Object fault = faultNet.getFaultList().get(0);
				if (fault instanceof AcscBusFault)
					algo.calculateBusFault((AcscBusFault) fault, msg);
				else
					algo.calculateBranchFault((AcscBranchFault) fault, msg);
				RunActUtilFunc.displayAcscSummaryResult(faultNet);
			}
		}
		return true;
	}
}
