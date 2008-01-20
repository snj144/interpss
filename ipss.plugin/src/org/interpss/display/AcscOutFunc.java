/*
 * @(#)AcscOutFunc.java   
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

import java.util.List;

import org.apache.commons.math.complex.ComplexFormat;

import com.interpss.common.datatype.Complex3x1;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Number2String;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

public class AcscOutFunc {
	public static String faultResult2String(SimpleFaultNetwork faultNet) {
		StringBuffer sb = new StringBuffer();
		IpssLogger.getLogger().fine(
				"# of Fault objects = " + faultNet.getFaultList().size());
		for (Object fault : faultNet.getFaultList()) {
			if (fault instanceof AcscBranchFault) {
				AcscBranchFault fBranch = (AcscBranchFault) fault;
				sb.append(branchFaultInfo(fBranch, faultNet));
			} else {
				AcscBusFault fBus = (AcscBusFault) fault;
				sb.append(busFaultInfo(fBus, faultNet));
			}
		}
		return sb.toString();
	}

	private static String branchFaultInfo(AcscBranchFault bf, AcscNetwork net) {
		StringBuffer str = new StringBuffer("");
		try {
			double baseKVA = net.getBaseKva();
			// fault branch is always a line/feeder branch
			double baseV = bf.getFaultBranch().getFromAcscBus()
					.getBaseVoltage();

			str.append("\n\n              Branch Fault Info\n");
			str.append("              =================\n\n");

			str.append("          Fault Id:      " + bf.getId() + "\n");
			str.append("          Fault type:    " + bf.getFaultCode() + "\n");
			str.append("          Branch name:   "
					+ bf.getFaultBranch().getName() + "\n");
			str.append("          Fault type:    " + bf.getFaultCode() + "\n");
			str.append("          Fault current: "
					+ ComplexFormat.formatComplex(bf.getFaultResult()
							.getSCCurrent_012().b_1) + " pu\n");
			str.append("                         "
					+ ComplexFormat
							.formatComplex(bf.getFaultResult()
									.getSCCurrent_012(UnitType.Amp, baseV,
											baseKVA).b_1) + " amps\n");
			if (bf.getFaultResult().getZFault(UnitType.Ohm, baseV, baseKVA)
					.abs() > 0.0)
				str.append("          Fault z:       "
						+ ComplexFormat.formatComplex(bf.getFaultResult()
								.getZFault(UnitType.Ohm, baseV, baseKVA))
						+ " ohms\n");

			str.append(displayBusVoltage(bf, net));
			str.append(displayBranchCurrent(bf, net));
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		return str.toString();
	}

	private static String busFaultInfo(AcscBusFault bf, AcscNetwork net) {
		StringBuffer str = new StringBuffer("");
		try {
			double baseKVA = net.getBaseKva();
			double baseV = bf.getAcscBus().getBaseVoltage();

			str.append("\n\n              Bus Fault Info\n");
			str.append("              ==============\n\n");

			str.append("          Fault Id:      " + bf.getId() + "\n");
			str.append("          Bus name:      " + bf.getAcscBus().getName()
					+ "\n");
			str.append("          Fault type:    " + bf.getFaultCode() + "\n");
			str.append("          Fault current: "
					+ ComplexFormat.formatComplex(bf.getFaultResult()
							.getSCCurrent_012().b_1) + " pu\n");
			str.append("                         "
					+ ComplexFormat
							.formatComplex(bf.getFaultResult()
									.getSCCurrent_012(UnitType.Amp, baseV,
											baseKVA).b_1) + " amps\n");
			if (bf.getFaultResult().getZFault(UnitType.Ohm, baseV, baseKVA)
					.abs() > 0.0)
				str.append("          Fault z:       "
						+ ComplexFormat.formatComplex(bf.getFaultResult()
								.getZFault(UnitType.Ohm, baseV, baseKVA))
						+ " ohms\n");

			str.append(displayBusVoltage(bf, net));
			str.append(displayBranchCurrent(bf, net));
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		return str.toString();
	}

	private static String displayBusVoltage(AcscBusFault bf, AcscNetwork net) {
		try {
			bf.getFaultResult().calContributingCurrent(net);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			return e.toString();
		}

		StringBuffer str = new StringBuffer("");
		if (bf.getFaultCode() == SimpleFaultCode.GROUND_3P) {
			str.append("\n");
			str
					.append("      BusID         FaultVoltage            ContribAmps\n");
			str
					.append("                 (pu)        (volts)      (pu)       (amps)\n");
			str
					.append("     --------   --------   ----------   --------   ----------\n");
			for (Bus b : net.getBusList()) {
				AcscBus bus = (AcscBus) b;
				str
						.append("     " + Number2String.toStr(-8, bus.getId())
								+ " ");
				double vpu = bf.getFaultResult().getFaultVoltage_012(
						bus.getSortNumber()).b_1.abs();
				Complex3x1 ampPu = bf.getFaultResult().getContriAmps_012(
						bus.getSortNumber());
				Complex3x1 amps = bf.getFaultResult().getContriAmps_012(
						bus.getSortNumber(), UnitType.Amp,
						bus.getBaseVoltage(), net.getBaseKva());
				str.append(Number2String.toStr("#####0.###", vpu) + "   ");
				str.append(Number2String.toStr("#######0.#", vpu
						* bus.getBaseVoltage()));
				str.append(Number2String.toStr("#####0.###", ampPu.b_1.abs())
						+ "   ");
				str.append(Number2String.toStr("#######0.#", amps.b_1.abs())
						+ "\n");
			}
		} else {
			str.append("\n\n");
			str
					.append("      BusID         FaultVolt(1)           FaultVolt(0)           FaultVolt(2)\n");
			str
					.append("                  (pu)      (volts)      (pu)      (volts)      (pu)      (volts)\n");
			str
					.append("     --------   --------   ----------  --------   ----------  --------   ----------\n");
			for (Bus b : net.getBusList()) {
				AcscBus bus = (AcscBus) b;
				str
						.append("     " + Number2String.toStr(-8, bus.getId())
								+ " ");
				Complex3x1 v012 = bf.getFaultResult().getFaultVoltage_012(
						bus.getSortNumber());
				double vpu1 = v012.b_1.abs();
				str.append(Number2String.toStr("#####0.###", vpu1) + "   ");
				str.append(Number2String.toStr("#######0.#", vpu1
						* bus.getBaseVoltage())
						+ "");
				double vpu0 = v012.a_0.abs();
				str.append(Number2String.toStr("#####0.###", vpu0) + "   ");
				str.append(Number2String.toStr("#######0.#", vpu0
						* bus.getBaseVoltage())
						+ "");
				double vpu2 = v012.c_2.abs();
				str.append(Number2String.toStr("#####0.###", vpu2) + " ");
				str.append(Number2String.toStr("#######0.#", vpu2
						* bus.getBaseVoltage())
						+ "\n");
			}

			str.append("\n\n");
			str
					.append("      BusID         FaultVolt(a)          FaultVolt(b)           FaultVolt(c)\n");
			str
					.append("                  (pu)       (volts)    (pu)        (volts)    (pu)        (volts)\n");
			str
					.append("     --------   --------   ----------  --------   ----------  --------   ----------\n");
			for (Bus b : net.getBusList()) {
				AcscBus bus = (AcscBus) b;
				str
						.append("     " + Number2String.toStr(-8, bus.getId())
								+ " ");
				Complex3x1 v012 = bf.getFaultResult().getFaultVoltage_012(
						bus.getSortNumber());
				Complex3x1 vabc = Complex3x1.z12_to_abc(v012);
				double vpu1 = vabc.a_0.abs();
				str.append(Number2String.toStr("#####0.###", vpu1) + "   ");
				str.append(Number2String.toStr("#######0.#", vpu1
						* bus.getBaseVoltage())
						+ "");
				double vpu0 = vabc.b_1.abs();
				str.append(Number2String.toStr("#####0.###", vpu0) + "   ");
				str.append(Number2String.toStr("#######0.#", vpu0
						* bus.getBaseVoltage())
						+ "");
				double vpu2 = vabc.c_2.abs();
				str.append(Number2String.toStr("#####0.###", vpu2) + " ");
				str.append(Number2String.toStr("#######0.#", vpu2
						* bus.getBaseVoltage())
						+ "\n");
			}
		}
		return str.toString();
	}

	private static String displayBranchCurrent(AcscBusFault bf, AcscNetwork net) {
		try {
			bf.getFaultResult().calBranchCurrent(net);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			return e.toString();
		}

		StringBuffer str = new StringBuffer("");
		if (bf.getFaultCode() == SimpleFaultCode.GROUND_3P) {
			str.append("\n\n");
			str.append("        BranchID                FaultAmps\n");
			str.append("                              (pu)       (Amp) \n");
			str.append("     --------------------   --------   ----------\n");

			List<Branch> branchList = net.getBranchList();
			int cnt = 0;
			for (int n = 0; n < branchList.size(); n++) {
				AcscBranch bra = (AcscBranch) branchList.get(n);
				str.append("     " + Number2String.toStr(-20, bra.getId())
						+ "   ");
				try {
					Complex3x1 cpu = bf.getFaultResult()
							.getFaultAmps_012From2To(++cnt);
					Complex3x1 camp = bf.getFaultResult()
							.getFaultAmps_012From2To(cnt, UnitType.Amp,
									bra.getFromBus().getBaseVoltage(),
									net.getBaseKva());
					str.append(Number2String.toStr("###0.###", cpu.b_1.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.b_1.abs())
							+ "\n");
				} catch (Exception e) {
					IpssLogger.logErr(e);
					str.append(e.toString() + "\n");
				}
			}
		} else {
			str.append("\n\n");
			str
					.append("        BranchID                FaultAmps(1)             FaultAmps(0)            FaultAmps(2)\n");
			str
					.append("                              (pu)       (Amp)        (pu)       (Amp)        (pu)       (Amp) \n");
			str
					.append("     --------------------   --------   ----------   --------   ----------   --------   ----------\n");

			List<Branch> branchList = net.getBranchList();
			int cnt = 0;
			for (int n = 0; n < branchList.size(); n++) {
				AcscBranch bra = (AcscBranch) branchList.get(n);
				try {
					Complex3x1 cpu = bf.getFaultResult()
							.getFaultAmps_012From2To(++cnt);
					Complex3x1 camp = bf.getFaultResult()
							.getFaultAmps_012From2To(cnt, UnitType.Amp,
									bra.getFromBus().getBaseVoltage(),
									net.getBaseKva());
					str.append("     " + Number2String.toStr(-20, bra.getId())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.b_1.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.b_1.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.a_0.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.a_0.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.c_2.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.c_2.abs())
							+ "\n");

					cpu = bf.getFaultResult().getFaultAmps_012To2From(cnt);
					camp = bf.getFaultResult().getFaultAmps_012To2From(cnt,
							UnitType.Amp, bra.getToBus().getBaseVoltage(),
							net.getBaseKva());
					str.append("     " + Number2String.toStr(-9, " ") + "<-"
							+ Number2String.toStr(-9, " ") + "   ");
					str.append(Number2String.toStr("###0.###", cpu.b_1.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.b_1.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.a_0.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.a_0.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.c_2.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.c_2.abs())
							+ "\n");
				} catch (Exception e) {
					IpssLogger.logErr(e);
					str.append(e.toString() + "\n");
				}
			}

			str.append("\n\n");
			str
					.append("        BranchID                FaultAmps(a)             FaultAmps(b)            FaultAmps(c)\n");
			str
					.append("                              (pu)       (Amp)        (pu)       (Amp)        (pu)       (Amp) \n");
			str
					.append("     --------------------   --------   ----------   --------   ----------   --------   ----------\n");

			cnt = 0;
			for (int n = 0; n < branchList.size(); n++) {
				AcscBranch bra = (AcscBranch) branchList.get(n);
				str.append("     " + Number2String.toStr(-20, bra.getId())
						+ "   ");
				try {
					Complex3x1 cpu = bf.getFaultResult()
							.getFaultAmps_abcFrom2To(++cnt);
					Complex3x1 camp = bf.getFaultResult()
							.getFaultAmps_abcFrom2To(cnt, UnitType.Amp,
									bra.getFromBus().getBaseVoltage(),
									net.getBaseKva());
					str.append(Number2String.toStr("###0.###", cpu.a_0.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.a_0.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.b_1.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.b_1.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.c_2.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.c_2.abs())
							+ "\n");

					cpu = bf.getFaultResult().getFaultAmps_abcTo2From(cnt);
					camp = bf.getFaultResult().getFaultAmps_abcTo2From(cnt,
							UnitType.Amp, bra.getToBus().getBaseVoltage(),
							net.getBaseKva());
					str.append("     " + Number2String.toStr(-9, " ") + "<-"
							+ Number2String.toStr(-9, " ") + "   ");
					str.append(Number2String.toStr("###0.###", cpu.a_0.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.a_0.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.b_1.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.b_1.abs())
							+ "   ");
					str.append(Number2String.toStr("###0.###", cpu.c_2.abs())
							+ "   "
							+ Number2String.toStr("#######0.#", camp.c_2.abs())
							+ "\n");
				} catch (Exception e) {
					IpssLogger.logErr(e);
					str.append(e.toString() + "\n");
				}
			}
		}
		return str.toString();
	}
}
