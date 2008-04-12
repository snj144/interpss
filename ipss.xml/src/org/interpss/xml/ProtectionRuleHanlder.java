/*
 * @(#)ProtectionRuleHanlder.java   
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
 * @Date 04/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.xml;

import org.interpss.schema.ProtectionConditionXmlType;
import org.interpss.schema.ProtectionRuleBaseXmlType;
import org.interpss.schema.ProtectionRuleSetXmlType;
import org.interpss.schema.ProtectionConditionXmlType.BranchConditionSet.BranchCondition;
import org.interpss.schema.ProtectionConditionXmlType.BusConditionSet.BusCondition;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.net.Network;

public class ProtectionRuleHanlder {

	/**
	 * Apply the protection rule set the network object
	 * 
	 * @param net a Network/AclfNetwork/AclfAdjNetwork/... object to be modified
	 * @param mod the modification record
	 */
	public static boolean applyAclfRuleSet(Network net, ProtectionRuleBaseXmlType protect, 
					int priority, double vMaxPU, double vMinPU, IPSSMsgHub msg) {
		boolean rtn = true;
		for (ProtectionRuleSetXmlType rule : protect.getProtectionRuleSetList().getProtectionRuleSetArray()) {
			if (rule.getPriority() == priority) {
				for (ProtectionRuleSetXmlType.BusProtectionRule busRule : rule.getBusProtectionRuleArray()) {
					if (evlBusCondition(busRule.getCondition(), net, vMaxPU, vMinPU, msg))
						if(!XmlNetParamModifier.applyBusChange(busRule.getAction(), net, msg))
							rtn = false;
				}
				
				for (ProtectionRuleSetXmlType.BranchProtectionRule braRule : rule.getBranchProtectionRuleArray()) {
					if (evlBranchCondition(braRule.getCondition(), net, msg)) 
						if (!XmlNetParamModifier.applyBranchChange(braRule.getAction(), net, msg))
							rtn = false;
				}
			}
		}
		return rtn;
	}
	
	/**
	 * Evaluate bus condition for protection
	 * 
	 * @param cond
	 * @param net
	 * @param vMaxPU
	 * @param vMinPU
	 * @param msg
	 * @return
	 */
	public static boolean evlBusCondition(ProtectionConditionXmlType cond, Network net, double vMaxPU, double vMinPU, IPSSMsgHub msg) {
		boolean evalCond = false;
		for (ProtectionConditionXmlType.BusConditionSet busCond : cond.getBusConditionSetArray()) {
			AclfBus bus = (AclfBus)IpssXmlParser.getBus(busCond, net);
			if (bus == null) {
				msg.sendErrorMsg("Error: cannot fin bus, id: " + busCond.getRecId());
				return false;
			}
			
			if (busCond.getBusCondition() == BusCondition.LOWER_VOLTAGE_LIMIT_VIOLATION) {
				evalCond = bus.getVoltageMag() < vMinPU;
				if (evalCond)
					msg.sendInfoMsg("Protection condition, Lower voltage limit violation at bus " + busCond.getRecId());
			}
			else if (busCond.getBusCondition() == BusCondition.UPPER_VOLTAGE_LIMIT_VIOLATION) {
				evalCond = bus.getVoltageMag() > vMaxPU;
				if (evalCond)
					msg.sendInfoMsg("Protection condition, upper voltage limit violation at bus " + busCond.getRecId());
			}
			if (cond.getConditionType() == ProtectionConditionXmlType.ConditionType.AND && evalCond == false)
				return false;
			else if (evalCond)
				return true;
		}
		return false;
	}

	/**
	 * Evaluate branch condition for protection
	 * 
	 * @param cond
	 * @param net
	 * @param msg
	 * @return
	 */
	public static boolean evlBranchCondition(ProtectionConditionXmlType cond, Network net, IPSSMsgHub msg) {
		boolean evalCond = false;
		for (ProtectionConditionXmlType.BranchConditionSet braCond : cond.getBranchConditionSetArray()) {
			AclfBranch branch = (AclfBranch)IpssXmlParser.getBranch(braCond, net);
			if (branch == null) {
				msg.sendErrorMsg("Error: cannot fin branch, " + braCond.getFromBusId() + "->" + braCond.getToBusId());
				return false;
			}

			double amps = branch.current(UnitType.Amp, net.getBaseKva());
			double mva = branch.mvaFlow(UnitType.mVA, net.getBaseKva());
			if (braCond.getBranchCondition() == BranchCondition.RATING_MVA_1_VIOLATION) {
				evalCond = mva > branch.getRatingMva1();
				if (evalCond)
					msg.sendInfoMsg("Protection condition, RatingMva1 violation at branch, " + braCond.getFromBusId() + "->" + braCond.getToBusId());
			}
			else if (braCond.getBranchCondition() == BranchCondition.RATING_MVA_2_VIOLATION) {
				evalCond = mva > branch.getRatingMva2();
				if (evalCond)
					msg.sendInfoMsg("Protection condition, RatingMva2 violation at branch, " + braCond.getFromBusId() + "->" + braCond.getToBusId());
			}
			else if (braCond.getBranchCondition() == BranchCondition.RATING_MVA_3_VIOLATION) {
				evalCond = mva > branch.getRatingMva3();
				if (evalCond)
					msg.sendInfoMsg("Protection condition, RatingMva3 violation at branch, " + braCond.getFromBusId() + "->" + braCond.getToBusId());
			}
			else if (braCond.getBranchCondition() == BranchCondition.RATING_AMPS_VIOLATION) {
				evalCond = amps > branch.getRatingAmps();
				if (evalCond)
					msg.sendInfoMsg("Protection condition, RatingAmps violation at branch, " + braCond.getFromBusId() + "->" + braCond.getToBusId());
			}
			
			if (cond.getConditionType() == ProtectionConditionXmlType.ConditionType.AND && evalCond == false)
				return false;
			else if (evalCond)
				return true;
		}
		return false;
	}
}