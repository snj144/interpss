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
import org.interpss.schema.ProtectionRuleSetXmlType;
import org.interpss.schema.ProtectionConditionXmlType.ConditionType;
import org.interpss.schema.ProtectionConditionXmlType.BranchConditionSet.BranchCondition;
import org.interpss.schema.ProtectionConditionXmlType.BusConditionSet.BusCondition;
import org.interpss.schema.ProtectionRuleSetXmlType.ProtectionRuleList.ProtectionRule;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfRuleBase;

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
	 * @param aclfRuleBase aclf rule base
	 * @param priority protection rule priority to be applied. Only rule.priority = priority will be applied
	 * @param vMaxPU upper voltage limit for voltage violation check
	 * @param vMinPU lower voltage limit for voltage violation check
	 * @param msg the IPSS Msg object
	 * @return true if rules applied and changes are made
	 */
	public static boolean applyAclfRuleSet(Network net, AclfRuleBase aclfRuleBase, 
					int priority, double vMaxPU, double vMinPU, IPSSMsgHub msg) {
		boolean rtn = false;
		for (ProtectionRuleSetXmlType ruleSet : aclfRuleBase.getProtectionRuleSetList().getProtectionRuleSetArray()) {
			if (ruleSet.getPriority() == priority) {
				for (ProtectionRule rule : ruleSet.getProtectionRuleList().getProtectionRuleArray()) {
					if (rule.getCondition().getBusConditionSetArray().length == 0 &&
						rule.getCondition().getBranchConditionSetArray().length == 0)
						return false;

					boolean busCond = false;
					boolean braCond = false;
					if (rule.getCondition().getConditionType() == ConditionType.AND) {
						busCond = true;
						braCond = true;
					}
							
					if (rule.getCondition().getBusConditionSetArray().length > 0)
						busCond = evlBusCondition(rule.getCondition(), net, vMaxPU, vMinPU, msg);
					if (rule.getCondition().getBranchConditionSetArray().length > 0)
						braCond = evlBranchCondition(rule.getCondition(), net, msg);

					if (rule.getCondition().getConditionType() == ConditionType.AND &&
							(busCond && braCond) ||
						rule.getCondition().getConditionType() == ConditionType.OR &&
							(busCond || braCond)) {
						if (rule.getBusAction() != null)
							if(XmlNetParamModifier.applyBusChange(rule.getBusAction(), net, msg))
								rtn = true;
						if (rule.getBranchAction() != null)
							if(XmlNetParamModifier.applyBranchChange(rule.getBranchAction(), net, msg))
								rtn = true;
					}
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