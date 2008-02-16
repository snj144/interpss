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

import org.apache.commons.math.complex.Complex;
import org.interpss.schema.AclfLoadCodeChangeXmlType;
import org.interpss.schema.AclfLoadCodeXmlData;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.ChangeActionXmlData;
import org.interpss.schema.ComplexValueChangeXmlType;
import org.interpss.schema.ComplexXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.UnitXmlData;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;

public class XmlNetParamModifier {
	private static enum ParamType {
		Power, Z
	};

	/**
	 * Apply the modification record to the network object
	 * 
	 * @param net
	 *            a Network/AclfNetwork/AclfAdjNetwork/... object to be modified
	 * @param mod
	 *            the modification record
	 */
	public static boolean applyModification2Net(Network net,
			ModificationXmlType mod) {
		// apply the Network-level changes
		if (mod.getBusChangeRecList() != null) {
			for (ModificationXmlType.BusChangeRecList.BusChangeRec busRec : mod
					.getBusChangeRecList().getBusChangeRecArray()) {
				Bus bus = getBus(busRec, net);
				bus.setStatus(busRec.getSetSatus());
				IpssLogger.getLogger().info(
						"Bus " + bus.getId() + " status has been set to "
								+ bus.isActive());
			}
		}

		if (mod.getBranchChangeRecList() != null) {
			for (ModificationXmlType.BranchChangeRecList.BranchChangeRec braRec : mod
					.getBranchChangeRecList().getBranchChangeRecArray()) {
				Branch branch = getBranch(braRec, net);
				if (branch != null) {
					branch.setStatus(braRec.getSetInService());
					IpssLogger.getLogger().info(
							"Branch " + branch.getId()
									+ " service status has been set to "
									+ branch.isActive());
				} else {
					return false;
				}
			}
		}

		// apply the AclfNetwork-level changes
		if (net instanceof AclfNetwork) {
			AclfNetwork aclfNet = (AclfNetwork) net;
			if (mod.getBusChangeRecList() != null) {
				for (ModificationXmlType.BusChangeRecList.BusChangeRec busRec : mod
						.getBusChangeRecList().getBusChangeRecArray()) {
					AclfBus bus = (AclfBus) getBus(busRec, aclfNet);
					if (bus != null) {
						if (busRec.getAclfBusChangeData().getLoadChangeData() != null) {
							// modify load value
							if (busRec.getAclfBusChangeData().getLoadChangeData().getValueChange() != null) {
								Complex x = applyPowerChangeRec(
										bus.getLoad(),
										busRec.getAclfBusChangeData().getLoadChangeData().getValueChange(),
										aclfNet.getBaseKva());
								bus.setLoadP(x.getReal());
								bus.setLoadQ(x.getImaginary());
							}

							// modify load code
							if (busRec.getAclfBusChangeData().getLoadChangeData().getCodeChange() != null) {
								ModificationXmlType.BusChangeRecList.BusChangeRec.AclfBusChangeData.LoadChangeData.CodeChange 
										codeChange = busRec.getAclfBusChangeData().getLoadChangeData().getCodeChange();
								bus.setLoadCode(codeChange.getCode() == AclfLoadCodeXmlData.CONST_P ? AclfLoadCode.CONST_P
												: (codeChange.getCode() == AclfLoadCodeXmlData.CONST_I ? AclfLoadCode.CONST_I
														: (codeChange.getCode() == AclfLoadCodeXmlData.CONST_Z ? AclfLoadCode.CONST_Z
																: (codeChange
																		.getCode() == AclfLoadCodeXmlData.EXPONENTIAL ? AclfLoadCode.EXPONENTIAL
																		: AclfLoadCode.NON_LOAD))));
								if (bus.getLoadCode() == AclfLoadCode.EXPONENTIAL) {
									bus.setExpLoadP(codeChange.getExpLoadP());
									bus.setExpLoadQ(codeChange.getExpLoadQ());
								}
							}
						}
					} else {
						return false;
					}
				}
			}

			if (mod.getBranchChangeRecList() != null) {
				for (ModificationXmlType.BranchChangeRecList.BranchChangeRec braRec : mod
						.getBranchChangeRecList().getBranchChangeRecArray()) {
					AclfBranch branch = (AclfBranch) getBranch(braRec, aclfNet);
					if (branch != null) {
						if (braRec.getAclfBranchChangeData().getBranchZChange() != null) {
							Complex z = applyComplexParamChangeRec(branch
									.getZ(), braRec.getAclfBranchChangeData().getBranchZChange(), ParamType.Z,
									aclfNet.getBaseKva(), branch
											.getHigherBaseVoltage());
							branch.setZ(z);
						}
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static Bus getBus(BusRecXmlType busRec, Network net) {
		String busId = busRec.getBusId();
		Bus bus = net.getBus(busId);
		if (bus == null) {
			IpssLogger.getLogger().warning("Bus not found, busId: " + busId);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Error in Xml", "Bus not found, busId: " + busId);
		}
		return bus;
	}

	private static Branch getBranch(BranchRecXmlType braRec, Network net) {
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

	private static Complex applyPowerChangeRec(Complex original,
			ComplexValueChangeXmlType changeRec, double baseKva) {
		return applyComplexParamChangeRec(original, changeRec, ParamType.Power,
				baseKva, 1.0);
	}

	private static Complex applyComplexParamChangeRec(Complex original,
			ComplexValueChangeXmlType changeRec, ParamType ptype,
			double baseKva, double busBaseVolt) {
		if (changeRec.getAction() == ChangeActionXmlData.ADD
				|| changeRec.getAction() == ChangeActionXmlData.SET) {
			// for add/set, use value and unit (PU or power unit)
			ComplexXmlType c = changeRec.getValue();
			double re = c.getRe(), im = c.getIm();
			if (changeRec.getUnit() != UnitXmlData.PU) {
				// convert set/add value to PU
				byte unit = IpssXmlParser.mapXmlUnitType2IpssUnitType(changeRec
						.getUnit());
				if (ptype == ParamType.Power) {
					re = UnitType.pConversion(re, baseKva, unit, UnitType.PU);
					im = UnitType.pConversion(im, baseKva, unit, UnitType.PU);
				} else if (ptype == ParamType.Z) {
					Complex z = UnitType.zConversion(new Complex(re, im),
							busBaseVolt, baseKva, unit, UnitType.PU);
					re = z.getReal();
					im = z.getImaginary();
				}
			}
			if (changeRec.getAction() == ChangeActionXmlData.ADD) {
				re += original.getReal();
				im += original.getImaginary();
			}
			return new Complex(re, im);
		} else if (changeRec.getAction() == ChangeActionXmlData.INCREASE
				|| changeRec.getAction() == ChangeActionXmlData.DECREASE) {
			// for increase/decrease, use percent and unit (PU or percent)
			double factor = changeRec.getPercent();
			if (changeRec.getUnit() == UnitXmlData.PERCENT)
				factor *= 0.01;
			if (changeRec.getAction() == ChangeActionXmlData.DECREASE)
				factor = -factor;
			return new Complex(original.getReal() * (1.0 + factor), original
					.getImaginary()
					* (1.0 + factor));
		}

		IpssLogger.getLogger().warning(
				"Wrong ChangeAction, changeRec: " + changeRec.toString());
		return original;
	}
}