/*
 * @(#)DStabOutFunc.java   
 *
 * Copyright (C) 2006 www.interpss.org
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
 * @Date 11/27/2007
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.dstab.output;

import java.util.Hashtable;

import org.apache.commons.math.complex.Complex;
import org.interpss.numeric.datatype.Unit.Type;
import org.interpss.numeric.util.Number2String;
import org.jfree.util.UnitType;

import com.interpss.common.datatype.Constants;
import com.interpss.core.aclf.adpter.CapacitorBusAdapter;
import com.interpss.core.aclf.adpter.GenBusAdapter;
import com.interpss.core.net.Bus;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.algo.DynamicSimuAlgorithm;
import com.interpss.dstab.common.DStabOutSymbol;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineType;

public class DStabOutFunc {
	public static String getStateTitleStr() {
		String str = "Time        MachId         Angle        Speed          Pe           Pm        Voltage        E/Eq1        Efd        Vs(pss)\n"
				   + "-----    -------------   ----------   ----------   ----------   ----------   ----------   ----------   ----------   ----------";
		return str;
	}

	@SuppressWarnings("unchecked")
	public static String getStateStr(Hashtable<String, Object> table)
			throws Exception {
		boolean strFmt = true;
		if (table.get(DStabOutSymbol.OUT_SYMBOL_TIME) instanceof Double)
			strFmt = false;

		String str = "";
		double time = strFmt ? new Double((String) table
				.get(DStabOutSymbol.OUT_SYMBOL_TIME)).doubleValue()
				: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_TIME))
						.doubleValue();
		str += Number2String.toStr("00.000", time) + " ";

		str += Number2String.toStr(15, (String) table
				.get(DStabOutSymbol.OUT_SYMBOL_MACH_ID))
				+ " ";

		double angle = strFmt ? new Double((String) table
				.get(DStabOutSymbol.OUT_SYMBOL_MACH_ANG)).doubleValue()
				: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_MACH_ANG))
						.doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", angle))
				+ "   ";

		double speed = strFmt ? new Double((String) table
				.get(DStabOutSymbol.OUT_SYMBOL_MACH_SPEED)).doubleValue()
				: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_MACH_SPEED))
						.doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", speed))
				+ "   ";

		double pe = strFmt ? new Double((String) table
				.get(DStabOutSymbol.OUT_SYMBOL_MACH_PE)).doubleValue()
				: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_MACH_PE))
						.doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", pe))
				+ "   ";

		double pm = strFmt ? new Double((String) table
				.get(DStabOutSymbol.OUT_SYMBOL_MACH_PM)).doubleValue()
				: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_MACH_PM))
						.doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", pm))
				+ "   ";

		double volt = strFmt ? new Double((String) table
				.get(DStabOutSymbol.OUT_SYMBOL_BUS_VMAG)).doubleValue()
				: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_BUS_VMAG))
						.doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", volt))
				+ "   ";

		if (table.get(DStabOutSymbol.OUT_SYMBOL_MACH_E) != null) {
			double e = strFmt ? new Double((String) table
					.get(DStabOutSymbol.OUT_SYMBOL_MACH_E)).doubleValue()
					: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_MACH_E))
							.doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", e))
					+ "   ";
		} else if (table.get(DStabOutSymbol.OUT_SYMBOL_MACH_EQ1) != null) {
			double eq1 = strFmt ? new Double((String) table
					.get(DStabOutSymbol.OUT_SYMBOL_MACH_EQ1)).doubleValue()
					: ((Double) table.get(DStabOutSymbol.OUT_SYMBOL_MACH_EQ1))
							.doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", eq1))
					+ "   ";
		} else
			str += "     -       ";

		if (table.get(Constants.Token_ExciterState) != null) {
			Hashtable<String, Object> excStatess = (Hashtable<String, Object>) table
					.get(Constants.Token_ExciterState);
			double efd = strFmt ? new Double((String) excStatess
					.get(DStabOutSymbol.OUT_SYMBOL_EXC_EFD)).doubleValue()
					: ((Double) excStatess
							.get(DStabOutSymbol.OUT_SYMBOL_EXC_EFD))
							.doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", efd))
					+ "   ";
		} else
			str += "     -       ";

		if (table.get(Constants.Token_StabilizerState) != null) {
			Hashtable<String, Object> pssStatess = (Hashtable<String, Object>) table
					.get(Constants.Token_StabilizerState);
			double pssVs = strFmt ? new Double((String) pssStatess
					.get(DStabOutSymbol.OUT_SYMBOL_PSS_VS)).doubleValue()
					: ((Double) pssStatess
							.get(DStabOutSymbol.OUT_SYMBOL_PSS_VS))
							.doubleValue();
			str += Number2String
					.toStr(10, Number2String.toStr("0.0000", pssVs))
					+ "   ";
		} else
			str += "     -       ";

		str += "\n";
		return str;
	}

	public static String initConditionSummary(DynamicSimuAlgorithm algo) {
		DStabilityNetwork net = algo.getDStabNet();
		StringBuffer str = new StringBuffer("");
		try {
			double refAng = 0.0;
			Machine refMach = algo.getRefMachine();
			if (refMach != null)
				refAng = Math.toDegrees(refMach.getAngle());

			str.append("\n                          Initial Condition Summary\n");
			str.append("     BusID     Volt(pu)     Angle(deg)   P(pu)     Q(pu)   Mach Model     PowerAng(deg)\n");
			str.append("  -------------------------------------------------------------------------------------\n");

			for (Bus b : net.getBusList()) {
				DStabBus bus = (DStabBus) b;
				GenBusAdapter genBus = bus.toGenBus();
				Complex busPQ = genBus.getGenResults(Type.PU);
				busPQ = busPQ.subtract(genBus.getLoadResults(Type.PU));
				if (bus.isCapacitor()) {
					CapacitorBusAdapter cap = bus.toCapacitorBus();
					busPQ = busPQ.add(new Complex(0.0, cap.getQResults(bus
							.getVoltageMag(), Type.PU)));
				}
				str.append(Number2String.toStr(2, " "));
				str.append(Number2String.toStr(-12, bus.getId()) + "  ");
				str.append(Number2String.toStr("###0.000", bus
						.getVoltageMag(Type.PU))
						+ " ");
				str.append(Number2String.toStr("######0.0", (bus
						.getVoltageAng(Type.Deg))
						- refAng)
						+ "  ");
				str.append(Number2String.toStr("####0.0000", busPQ.getReal()));
				str.append(Number2String.toStr("####0.0000", busPQ
						.getImaginary())
						+ "  ");
				if (bus.getMachine() != null) {
					Machine mach = bus.getMachine();
					str.append(machModelStr(mach) + "   ");
					str.append(Number2String.toStr("####0.0", Math.toDegrees(mach.getAngle()) - refAng));
				} else if (bus.getScriptDynamicBusDevice() != null) {
					// Machine mach = bus.getMachine();
					str.append("Dyn Bus Device   " + " ");
				}
				/*
				 * else if (bus.getScriptDBusDevice() != null) { //Machine mach =
				 * bus.getMachine(); str.append("Script Bus Device" + " "); }
				 */
				str.append("\n");
			}
		} catch (Exception emsg) {
			str.append(emsg.toString());
		}
		return str.toString();
	}

	private static String machModelStr(Machine mach) {
		if (mach.getMachType() == MachineType.ECONSTANT)
			return "     E-Constant";
		else if (mach.getMachType() == MachineType.EQ1_MODEL)
			return "      Eq1 Model";
		else if (mach.getMachType() == MachineType.EQ1_ED1_MODEL)
			return "  Eq1 Ed1 Model";
		else if (mach.getMachType() == MachineType.EQ11_SALIENT_POLE)
			return "E11 SalinetPole";
		else if (mach.getMachType() == MachineType.EQ11_ED11_ROUND_ROTOR)
			return " E11 RoundRotor";
		return "    Not Defined";
	}
}
