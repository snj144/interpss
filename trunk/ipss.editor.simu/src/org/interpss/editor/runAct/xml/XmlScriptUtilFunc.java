/*
 * @(#)XmlScriptUtilFunc.java   
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

import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RuleBaseXmlType;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.multicase.MultiStudyCase;

public class XmlScriptUtilFunc {
	public static void mapRuleBase(boolean applyRuleBase, MultiStudyCase mscase, RuleBaseXmlType ruleBase) {
		mscase.getRuleBase().setApplyRuleBase(applyRuleBase);
		if (ruleBase != null)
			mscase.getRuleBase().setRuleBaseXmlString(ruleBase.xmlText());
	}
	
	public static boolean mapAclfStudyCase(IpssMapper mapper, AclfStudyCaseXmlType xmlCase, 
						LoadflowAlgorithm algo, AclfAlgorithmXmlType xmlDefaultAlgo, 
						boolean remoteJobCreation, IPSSMsgHub msg) {
		if (xmlCase.getAclfAlgorithm() == null) {
			if (xmlDefaultAlgo == null) {
				msg.sendErrorMsg("No Aclf Algorithm defined");
				return false;
			}
			xmlCase.setAclfAlgorithm(xmlDefaultAlgo);
		}
		if (xmlCase.getModification() != null && !remoteJobCreation)
			mapper.mapping(xmlCase.getModification(), algo.getAclfAdjNetwork(), ModificationXmlType.class);
		mapper.mapping(xmlCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		
		return true;
	}
}
