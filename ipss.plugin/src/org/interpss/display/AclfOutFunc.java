 /*
  * @(#)AclfOutFunc.java   
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

package org.interpss.display;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FlowControlType;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.aclfadj.XfrTapControlType;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.datatype.Mismatch;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

public class AclfOutFunc {

	public static String b11MatrixToString(AclfNetwork net) {
		try {
			String str = "\n        B11-matrix\n";

			for (Bus b : net.getBusList()) {
				AclfBus bus = (AclfBus) b;
				str += "bus: " + bus.getId() + "    " + "bii: "
						+ Number2String.toStr(bus.b11ii()) + "\n";
				for (Object br : bus.getBranchList()) {
					AclfBranch bra = (AclfBranch) br;
					str += "          " + bra.getId() + "   " + "bij: "
							+ Number2String.toStr(bra.b11ft()) + "\n";
				}
			}
			return str + "\n";
		} catch (Exception emsg) {
			return emsg.toString();
		}
	}

	public static String b1MatrixToString(AclfNetwork net) {
		String str = "\n        B1-matrix\n";

		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			str += "bus: " + bus.getId() + "    " + "bii: "
					+ Number2String.toStr(bus.b1ii()) + "\n";
			for (Branch br : bus.getBranchList()) {
				AclfBranch bra = (AclfBranch) br;
				str += "          " + bra.getId() + "   " + "bij: "
						+ Number2String.toStr(bra.b1ft()) + "\n";
			}
		}
		return str + "\n";
	}

	public static String lfResultsBusStyle(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		try {
			double baseKVA = net.getBaseKva();

			str
					.append("\n\n                                              Load Flow Results\n\n");
			str
					.append("-------------------------------------------------------------------------------------------------------------------------------------\n");
			str
					.append(" Bus ID             Bus Voltage         Generation           Load             To             Branch P+jQ          Xfr Ratio   PS-Xfr\n");
			str
					.append("               base     Mag   Ang     (mW)    (mVar)    (mW)    (mVar)      Bus ID      (mW)    (mVar)   (kA)   (From)  (To)   Angle\n");
			str
					.append("-------------------------------------------------------------------------------------------------------------------------------------\n");

			for (Bus b : net.getBusList()) {
				AclfBus bus = (AclfBus) b;
				GenBusAdapter genBus = (GenBusAdapter) bus
						.adapt(GenBusAdapter.class);
				Complex busGen = genBus.getGenResults(UnitType.mVA, baseKVA);
				Complex busLoad = genBus.getLoadResults(UnitType.mVA, baseKVA);
				if (bus.isCapacitor()) {
					CapacitorBusAdapter cap = (CapacitorBusAdapter) bus
							.adapt(CapacitorBusAdapter.class);
					busGen = busGen.add(new Complex(0.0, cap.getQResults(bus
							.getVoltageMag(), UnitType.PU, baseKVA)));
				}
				str.append(Number2String.toStr(-12, bus.getId()) + " ");
				str.append(Number2String
						.toStr("#######0", bus.getBaseVoltage())
						+ " ");
				str.append(Number2String.toStr("0.0000", bus
						.getVoltageMag(UnitType.PU))
						+ " ");
				str.append(Number2String.toStr("##0.0", bus
						.getVoltageAng(UnitType.Deg))
						+ " ");
				str.append(Number2String.toStr("####0.00", busGen.getReal())
						+ " ");
				str.append(Number2String.toStr("####0.00", busGen
						.getImaginary())
						+ " ");
				str.append(Number2String.toStr("####0.00", busLoad.getReal())
						+ " ");
				str.append(Number2String.toStr("####0.00", busLoad
						.getImaginary())
						+ " ");
				// str.append( " - - - - - - - - - - -\n" );

				int cnt = 0;
				for (Branch br : bus.getBranchList()) {
					AclfBranch bra = (AclfBranch) br;
					AclfBus busj;
					if (bus.equals(bra.getFromAclfBus()))
						busj = bra.getToAclfBus();
					else
						busj = bra.getFromAclfBus();

					Complex pq = new Complex(0.0, 0.0);
					double amp = 0.0, fromRatio = 1.0, toRatio = 1.0;
					if (bra.isActive()) {
						if (bus.equals(bra.getFromAclfBus())) {
							pq = bra.powerFrom2To(UnitType.mVA, baseKVA);
							amp = UnitType.iConversion(bra.current(UnitType.PU,
									baseKVA), bra.getFromAclfBus()
									.getBaseVoltage(), baseKVA, UnitType.PU,
									UnitType.Amp);
							if (bra.isXfr() || bra.isPSXfr()) {
								fromRatio = bra.getFromTurnRatio();
								toRatio = bra.getToTurnRatio();
							}
						} else {
							pq = bra.powerTo2From(UnitType.mVA, baseKVA);
							amp = UnitType.iConversion(bra.current(UnitType.PU,
									baseKVA), bra.getToAclfBus()
									.getBaseVoltage(), baseKVA, UnitType.PU,
									UnitType.Amp);
							if (bra.isXfr() || bra.isPSXfr()) {
								toRatio = bra.getFromTurnRatio();
								fromRatio = bra.getToTurnRatio();
							}
						}
					}
					if (cnt++ > 0)
						str.append(Number2String.toStr(67, " ") + "    ");
					str.append(" " + Number2String.toStr(-12, busj.getId())
							+ " ");
					str.append(Number2String.toStr("####0.00", pq.getReal())
							+ " ");
					str.append(Number2String.toStr("####0.00", pq
							.getImaginary())
							+ " ");
					str.append(Number2String.toStr("##0.0##", 0.001 * amp)
							+ " ");
					if (bra.isXfr() || bra.isPSXfr()) {
						if (fromRatio != 1.0)
							str.append(Number2String.toStr("0.0###", fromRatio)
									+ " ");
						else
							str.append("       ");

						if (toRatio != 1.0)
							str.append(Number2String.toStr("0.0###", toRatio));
						else
							str.append("      ");

						if (bra.isPSXfr()) {
							PSXfrAdapter psXfr = (PSXfrAdapter) bra
									.adapt(PSXfrAdapter.class);
							str.append("   "
									+ Number2String.toStr("##0.0", psXfr
											.getFromAngle(UnitType.Deg)));
						}
						str.append("\n");
					} else {
						str.append("\n");
					}
				}
			}
			str
					.append("-------------------------------------------------------------------------------------------------------------------------------------\n");
		} catch (Exception emsg) {
			str.append(emsg.toString());
		}
		return str.toString();
	}

	public static String loadFlowSummary(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		try {
			double baseKVA = net.getBaseKva();

			str.append("\n                          Load Flow Summary\n");
			str.append(AclfOutFunc.maxMismatchToString(net) + "\n");
			str
					.append("     BusID         Code              Volt(pu)   Angle(deg)     P(pu)     Q(pu)\n");
			str
					.append("  ----------------------------------------------------------------------------\n");

			for (Bus b : net.getBusList()) {
				AclfBus bus = (AclfBus) b;
				GenBusAdapter genBus = (GenBusAdapter) bus
						.adapt(GenBusAdapter.class);
				Complex busPQ = genBus.getGenResults(UnitType.PU, baseKVA);
				busPQ = busPQ.subtract(genBus.getLoadResults(UnitType.PU,
						baseKVA));
				if (bus.isCapacitor()) {
					CapacitorBusAdapter cap = (CapacitorBusAdapter) bus
							.adapt(CapacitorBusAdapter.class);
					busPQ = busPQ.add(new Complex(0.0, cap.getQResults(bus
							.getVoltageMag(), UnitType.PU, baseKVA)));
				}
				str.append(Number2String.toStr(2, " "));
				str.append(Number2String.toStr(-12, bus.getId()) + "  ");
				str.append(Number2String.toStr(-17, bus.code2String()) + " ");
				str.append(Number2String.toStr("###0.00000", bus
						.getVoltageMag(UnitType.PU))
						+ " ");
				str.append(Number2String.toStr("######0.0", bus
						.getVoltageAng(UnitType.Deg))
						+ "   ");
				str.append(Number2String.toStr("####0.0000", busPQ.getReal()));
				str.append(Number2String.toStr("####0.0000", busPQ
						.getImaginary())
						+ "\n");
			}
		} catch (Exception emsg) {
			str.append(emsg.toString());
		}

		str.append(branchMvaRatingViolationList(net));

		return str.toString();
	}

	public static String loadFlowSummary(AclfAdjNetwork net) {
		StringBuffer str = new StringBuffer(loadFlowSummary((AclfNetwork) net));
		try {
			if (net.getPvBusLimitList().size() > 0)
				str.append(pvBusLimitToString(net));

			if (net.getPqBusLimitList().size() > 0)
				str.append(pqBusLimitToString(net));

			if (net.getRemoteQBusList().size() > 0)
				str.append(remoteQBusToString(net));

			if (net.getFunctionLoadList().size() > 0)
				str.append(aclfFuncLoadToString(net));

			if (net.getTapControlList().size() > 0)
				str.append(tapVControlToString(net));

			if (net.getPsXfrPControlList().size() > 0)
				str.append(psXfrPControlToString(net));
		} catch (Exception emsg) {
			str.append(emsg.toString());
		}
		return str.toString();
	}

	public static String maxMismatchToString(AclfNetwork net) {
		try {
			double baseKVA = net.getBaseKva();
			String str = "\n                         Max Power Mismatches\n"
					+ "             Bus          dPmax       Bus          dQmax\n"
					+ "            ---------------------------------------------------\n";
			Mismatch mis = net.maxMismatch(AclfMethod.NR);
			str += Number2String.toStr(12, " ");
			str += Number2String.toStr(-8, mis.maxPBus.getId()) + " ";
			str += Number2String.toStr("####0.000000", mis.maxMis.getReal())
					+ "    ";
			str += Number2String.toStr(-8, mis.maxQBus.getId()) + " ";
			str += Number2String.toStr("####0.000000", mis.maxMis
					.getImaginary())
					+ " (pu)\n";
			str += Number2String.toStr(21, " ");
			str += Number2String.toStr("####0.000000", baseKVA
					* mis.maxMis.getReal())
					+ " ";
			str += Number2String.toStr(12, " ");
			str += Number2String.toStr("####0.000000", baseKVA
					* mis.maxMis.getImaginary())
					+ " (kva)\n";
			return str;
		} catch (Exception emsg) {
			return emsg.toString();
		}
	}

	public static String branchMvaRatingViolationList(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		if (net.hasBranchMavRatingViolation()) {
			str.append("\n\n");
			str
					.append("                        Branch MvaRating Violation List\n\n");
			str
					.append("         BranchID        MvaFlow      Side    MvaRating1   MvaRating2   MvaRating3\n");
			str
					.append("     ----------------- ------------ -------- ------------ ------------ ------------\n");
			for (Branch b : net.getBranchList()) {
				AclfBranch bra = (AclfBranch) b;
				if (bra.isMvaRatingViolated(net.getBaseKva())) {
					str.append(Number2String.toStr(5, " "));
					str.append(Number2String.toStr(-16, bra.getId()));
					double mva = bra.powerFrom2To(UnitType.mVA,
							net.getBaseKva()).abs();
					String side = "From";
					if (bra.powerFrom2To(UnitType.mVA, net.getBaseKva()).abs() < bra
							.powerTo2From(UnitType.mVA, net.getBaseKva()).abs()) {
						mva = bra.powerTo2From(UnitType.mVA, net.getBaseKva())
								.abs();
						side = "To";
					}

					str.append("     " + Number2String.toStr("####0.0", mva));
					str.append("     " + Number2String.toStr(-4, side));
					str.append("      "
							+ Number2String.toStr("####0.0", bra
									.getRatingMva1()));
					str.append("      "
							+ Number2String.toStr("####0.0", bra
									.getRatingMva2()));
					str.append("      "
							+ Number2String.toStr("####0.0", bra
									.getRatingMva3()));
					str.append("\n");
				}
			}
		}
		return str.toString();
	}

	public static String pvBusLimitToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  PV Bus Limit Adjustment/Control\n\n");
		str
				.append("      BusID     Vact     Vspec      Q      Qmax     Qmin   Status\n");
		str
				.append("     -------- -------- -------- -------- -------- -------- ------\n");

		for (PVBusLimit pv : net.getPvBusLimitList()) {
			GenBusAdapter genBus = (GenBusAdapter) pv.getAclfBus().adapt(
					GenBusAdapter.class);
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-8, pv.getAclfBus().getId()));
			str.append(Number2String.toStr("###0.0000", pv.getAclfBus()
					.getVoltageMag(UnitType.PU)));
			str.append(Number2String.toStr("###0.0000", pv
					.getVSpecified(UnitType.PU)));
			str.append(Number2String.toStr("#####0.00", genBus.getGenResults(
					UnitType.PU, baseKVA).getImaginary()));
			str.append(Number2String.toStr("#####0.00", pv.getQLimit(
					UnitType.PU, baseKVA).getMax()));
			str.append(Number2String.toStr("#####0.00", pv.getQLimit(
					UnitType.PU, baseKVA).getMin()));
			str.append(Number2String.toStr(6, pv.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String pqBusLimitToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  PQ Bus Limit Adjustment/Control\n\n");
		str
				.append("      BusID     Qact     Qspec      V      Vmax     Vmin   Status\n");
		str
				.append("     -------- -------- -------- -------- -------- -------- ------\n");

		for (PQBusLimit pq : net.getPqBusLimitList()) {
			GenBusAdapter genBus = (GenBusAdapter) pq.getAclfBus().adapt(
					GenBusAdapter.class);
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-8, pq.getAclfBus().getId()) + " ");
			str.append(Number2String.toStr("####0.00", genBus.getGenResults(
					UnitType.PU, baseKVA).getImaginary())
					+ " ");
			str.append(Number2String.toStr("####0.00", pq.getQSpecified(
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", pq.getAclfBus()
					.getVoltageMag(UnitType.PU))
					+ " ");
			str.append(Number2String.toStr("##0.0000", pq
					.getVLimit(UnitType.PU).getMax())
					+ " ");
			str.append(Number2String.toStr("##0.0000", pq
					.getVLimit(UnitType.PU).getMin())
					+ " ");
			str.append(Number2String.toStr(5, pq.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String remoteQBusToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                Remote Q Voltage Adjustment/Control\n\n");
		str
				.append("       VcBus    Type    ReQBus/Branch   Actual    Spec       Q      Qmax     Qmin   Status\n");
		str
				.append("     -------- -------- --------------- -------- -------- -------- -------- -------- ------\n");

		for (RemoteQBus re : net.getRemoteQBusList()) {
			GenBusAdapter genBus = (GenBusAdapter) re.getAclfBus().adapt(
					GenBusAdapter.class);
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-9, re.getAclfBus().getId()));
			str
					.append(Number2String
							.toStr(
									-9,
									(re.getControlType() == RemoteQControlType.BUS_VOLTAGE ? " Voltage"
											: "MvarFlow")));
			str.append(Number2String.toStr(15,
					re.getControlType() == RemoteQControlType.BUS_VOLTAGE ? re
							.getRemoteBus().getId() : re.getRemoteBranch()
							.getId()));
			str.append(Number2String.toStr("###0.0000",
					re.getControlType() == RemoteQControlType.BUS_VOLTAGE ? re
							.getRemoteBus().getVoltageMag(UnitType.PU) : re
							.getMvarFlowCalculated(re.getRemoteBranch(),
									UnitType.PU, baseKVA)));
			str.append(Number2String.toStr("###0.0000", re
					.getVSpecified(UnitType.PU)));
			str.append(Number2String.toStr("#####0.00", genBus.getGenResults(
					UnitType.PU, baseKVA).getImaginary()));
			str.append(Number2String.toStr("#####0.00", re.getQLimit(
					UnitType.PU, baseKVA).getMax()));
			str.append(Number2String.toStr("#####0.00", re.getQLimit(
					UnitType.PU, baseKVA).getMin()));
			str.append(Number2String.toStr(6, re.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String aclfFuncLoadToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  Aclf FuncLoad Adjustment/Control\n\n");
		str
				.append("      BusID     Pact     Qact       V      P(0)     Q(0)   Status\n");
		str
				.append("     -------- -------- -------- -------- -------- -------- ------\n");

		for (FunctionLoad x : net.getFunctionLoadList()) {
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-8, x.getAclfBus().getId()) + " ");
			double vpu = x.getAclfBus().getVoltage().abs();
			str.append(Number2String.toStr("##0.0000", x.getP().getLoad(vpu,
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getQ().getLoad(vpu,
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getAclfBus()
					.getVoltageMag(UnitType.PU))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getP().getLoad0(
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getQ().getLoad0(
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr(5, x.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String tapVControlToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKva = net.getBaseKva();

		str.append("\n\n");
		str
				.append("                          Tap Voltage Adjustment/Control\n\n");
		str
				.append("          BranchID     VC BusID  Actual   Spec/Range     Tap  Tmax  Tmin  StepSize Status\n");
		str
				.append("     ----------------- -------- -------- -------------- ----- ----- -----   -----  ------\n");

		for (TapControl x : net.getTapControlList()) {
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-17, x.getAclfBranch().getId())
					+ " ");

			if (x.getControlType() == XfrTapControlType.BUS_VOLTAGE) {
				str.append(Number2String.toStr(-8, x.getVcBus().getId()) + " ");
				str.append(Number2String.toStr("##0.0000", x.getVcBus()
						.getVoltageMag(UnitType.PU))
						+ " ");
				if (x.getFlowControlType() == FlowControlType.POINT_CONTROL)
					str.append(Number2String.toStr("##0.0000", x
							.getVSpecified(UnitType.PU))
							+ " ");
				else
					str.append(x.getControlRange() + " ");
			} else {
				str.append(Number2String.toStr(-8, " "));
				str.append(Number2String.toStr("##0.0000", x
						.getMvarFlowCalculated(UnitType.PU, baseKva))
						+ " ");
				if (x.getFlowControlType() == FlowControlType.POINT_CONTROL)
					str.append("   "
							+ Number2String.toStr("##0.0000", x
									.getMvarSpecified(UnitType.PU, baseKva))
							+ "    ");
				else
					str.append(x.getControlRange() + " ");
			}

			str.append(Number2String.toStr("0.000",
					(x.isControlOnFromSide() ? x.getAclfBranch()
							.getFromTurnRatio() : x.getAclfBranch()
							.getToTurnRatio()))
					+ " ");
			str.append(Number2String.toStr("0.000", x.getTapLimit().getMax())
					+ " ");
			str.append(Number2String.toStr("0.000", x.getTapLimit().getMin())
					+ "   ");
			str.append(Number2String.toStr("####0", x.getTapStepSize()) + "  ");
			str.append(Number2String.toStr(6, x.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String psXfrPControlToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  PSXfr Power Adjustment/Control\n\n");
		str
				.append("          BranchID       Pact     Spec/Range    Ang   Max   Min  Status\n");
		str
				.append("     ----------------- -------- -------------- ----- ----- ----- ------\n");

		for (PSXfrPControl x : net.getPsXfrPControlList()) {
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-17, x.getAclfBranch().getId())
					+ " ");
			str.append(Number2String.toStr("##0.0000",
					(x.isControlOnFromSide() ? x.getAclfBranch().powerFrom2To(
							UnitType.PU, baseKVA).getReal() : x.getAclfBranch()
							.powerTo2From(UnitType.PU, baseKVA).getReal()))
					+ " ");

			if (x.getFlowControlType() == FlowControlType.POINT_CONTROL)
				str.append(Number2String.toStr("   " + "##0.0000", x
						.getPSpecified(UnitType.PU, baseKVA))
						+ "    ");
			else
				str.append(x.getControlRange() + " ");

			PSXfrAdapter psXfr = (PSXfrAdapter) x.getAclfBranch().adapt(
					PSXfrAdapter.class);
			str.append(Number2String.toStr("#0.00", psXfr
					.getFromAngle(UnitType.Deg))
					+ " ");
			str.append(Number2String.toStr("#0.00", x.getAngLimit(UnitType.Deg)
					.getMax())
					+ " ");
			str.append(Number2String.toStr("#0.00", x.getAngLimit(UnitType.Deg)
					.getMin())
					+ " ");
			str.append(Number2String.toStr(6, x.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String yMatrixToString(AclfNetwork net) {
		String str = "\n        Y-matrix\n";

		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			str += "bus: " + bus.getId() + "    " + "yii: "
					+ bus.yii().toString() + "\n";
			for (Branch br : bus.getBranchList()) {
				AclfBranch bra = (AclfBranch) br;
				str += "          " + bra.getId()
						+ "   "
						+
						//"  yff:" + Num2Str.toStr(bra.yff()) +
						//"  ytt:" + Num2Str.toStr(bra.ytt()) +
						"  yft:" + Number2String.toStr(bra.ytf()) + "  ytf:"
						+ Number2String.toStr(bra.yft()) + "\n";
			}
		}
		return str + "\n";
	}
}