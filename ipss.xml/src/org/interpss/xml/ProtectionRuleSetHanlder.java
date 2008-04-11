/*
 * @(#)XmlNetParamModifier.java   
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

import org.interpss.schema.ProtectionConditionXmlType;
import org.interpss.schema.ProtectionConditionXmlType.BranchConditionSet.BranchCondition;
import org.interpss.schema.ProtectionConditionXmlType.BusConditionSet.BusCondition;
import org.interpss.schema.ProtectionRuleXmlType;
import org.interpss.schema.ProtectionXmlType;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.net.Network;

public class ProtectionRuleSetHanlder {

	/**
	 * Apply the modification record to the network object
	 * 
	 * @param net
	 *            a Network/AclfNetwork/AclfAdjNetwork/... object to be modified
	 * @param mod
	 *            the modification record
	 */
	public static boolean applyAclfRuleSet(Network net, ProtectionXmlType protect, int priority, IPSSMsgHub msg) {
		boolean rtn = true;
		for (ProtectionRuleXmlType rule : protect.getProtectionRuleSetArray()) {
			if (rule.getPriority() == priority) {
				for (ProtectionRuleXmlType.BusProtectionRule busRule : rule.getBusProtectionRuleArray()) {
					if (applyBusRuleSet(busRule, net, msg))
						rtn = false;
				}
				
				for (ProtectionRuleXmlType.BranchProtectionRule braRule : rule.getBranchProtectionRuleArray()) {
					if (applyBranchRuleSet(braRule, net, msg))
						rtn = false;
				}
			}
		}
		return rtn;
	}
	
	private static boolean applyBusRuleSet(ProtectionRuleXmlType.BusProtectionRule busRule, Network net, IPSSMsgHub msg) {
		if (evlCondition(busRule.getCondition(), net, msg)) {
			
		}
		return true;
	}

	private static boolean applyBranchRuleSet(ProtectionRuleXmlType.BranchProtectionRule braRule, Network net, IPSSMsgHub msg) {
		if (evlCondition(braRule.getCondition(), net, msg)) {
			
		}
		return true;
	}
	
	private static boolean evlCondition(ProtectionConditionXmlType cond, Network net, IPSSMsgHub ms) {
		boolean condUpperVolt = false;
		boolean condLoewrVolt = false;
		boolean condMvar1 = false;
		boolean condMvar2 = false;
		boolean condMvar3 = false;
		boolean condAmps = false;
		for (ProtectionConditionXmlType.BusConditionSet busCond : cond.getBusConditionSetArray()) {
			if (busCond.getBusCondition() == BusCondition.LOWER_VOLTAGE_LIMIT_VIOLATION) {
				
			}
			else if (busCond.getBusCondition() == BusCondition.UPPER_VOLTAGE_LIMIT_VIOLATION) {
				
			}
		}
		for (ProtectionConditionXmlType.BranchConditionSet braCond : cond.getBranchConditionSetArray()) {
			if (braCond.getBranchCondition() == BranchCondition.RATING_MVAR_1_VIOLATION) {
				
			}
			else if (braCond.getBranchCondition() == BranchCondition.RATING_MVAR_2_VIOLATION) {
				
			}
			else if (braCond.getBranchCondition() == BranchCondition.RATING_MVAR_3_VIOLATION) {
				
			}
			else if (braCond.getBranchCondition() == BranchCondition.RATING_AMPS_VIOLATION) {
				
			}
		}
		if (cond.getConditionType() == ProtectionConditionXmlType.ConditionType.AND)
			return condUpperVolt && condLoewrVolt && condMvar1 && condMvar2 && condMvar3 && condAmps;
		else if (cond.getConditionType() == ProtectionConditionXmlType.ConditionType.OR)
			return condUpperVolt || condLoewrVolt || condMvar1 || condMvar2 || condMvar3 || condAmps;
		else
			return false;
	}
}