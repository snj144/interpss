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
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.SpringAppContext;
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
	public static boolean runAcsc(IpssXmlParser parser,
			SimpleFaultNetwork faultNet, IPSSMsgHub msg) {
		IpssMapper mapper = PluginSpringAppContext
				.getRunForm2AlgorithmMapper();
		if (parser.getRunAcscStudyCaseList().length > 0) {
			if (parser.getRunAcscStudyCaseList().length == 1) {
				RunStudyCaseXmlType.AcscStudyCaseList.AcscStudyCase acscCase = parser
						.getRunAcscStudyCaseList()[0];
				SimpleFaultAlgorithm algo = CoreObjectFactory
						.createSimpleFaultAlgorithm(faultNet);
				mapper.mapping(acscCase, algo, RunStudyCaseXmlType.AcscStudyCaseList.AcscStudyCase.class);
				Object fault = faultNet.getFaultList().get(0);
				if (fault instanceof AcscBusFault)
					algo.calculateBusFault((AcscBusFault) fault, msg);
				else
					algo.calculateBranchFault((AcscBranchFault) fault, msg);
				RunActUtilFunc.displayAcscSummaryResult(faultNet);
			} else
				for (RunStudyCaseXmlType.AcscStudyCaseList.AcscStudyCase acscCase : parser
						.getRunAcscStudyCaseList()) {
				}
		} else {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", "runAcscStudyCase element not defined");
			return false;
		}
		return true;
	}
}
