/*
 * @(#)DclfOutFunc.java   
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

import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfBusSensitivityXmlType;
import org.interpss.schema.DclfPowerTransferDistFactorXmlType;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.dclf.DclfSensitivityType;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

public class DclfOutFunc {
	/**
	 * Out put Dclf voltage angle results
	 * 
	 * @param net
	 * @param algo
	 * @return
	 */
	public static String dclfResults(DclfAlgorithm algo) {
		String str = "\n\n";
		str += "      DC Loadflow Results\n\n";
		str += "   Bud Id       VoltAng(deg)\n";
		str += "=================================\n";
		for (Bus bus : algo.getAclfNetwork().getBusList()) {
			int n = bus.getSortNumber();
			double angle = algo.getBusAngle(n) * Constants.RtoD;
			str += Number2String.toFixLengthStr(8, bus.getId()) + "        "
					+ Number2String.toStr(angle) + "\n";
		}

		str += "\n\n";
		str += "       FromId->ToId       Power Flow(pu)\n";
		str += "==========================================\n";
		for (Branch bra : algo.getAclfNetwork().getBranchList()) {
			double fAng = algo.getBusAngle(bra.getFromBus().getSortNumber()) * Constants.RtoD;
			double tAng = algo.getBusAngle(bra.getToBus().getSortNumber()) * Constants.RtoD;
			AclfBranch aclfBra = (AclfBranch)bra;
			str += Number2String.toFixLengthStr(20, bra.getId()) + "     "  
					+ Number2String.toStr((fAng-tAng)*aclfBra.getZ().getImaginary()) + "\n";
		}
		return str;
	}

	/**
	 * out power angle sensitivity calculation results
	 * 
	 * @param sen XML sensitivity calculation records
	 * @param algo
	 * @param msg
	 * @return
	 */
	public static String pAngleSensitivityResults(
			DclfBusSensitivityXmlType sen, DclfAlgorithm algo, IPSSMsgHub msg) {
		String str = "\n\n";
		str += "  Power-Angle Sensitivity\n\n";
		str += "   Inject BusId : " + sen.getInjectBusId() + "\n\n";
		str += "   Bud Id       dAng/dP\n";
		str += "=================================\n";
		for (BusRecXmlType bus : sen.getBusArray()) {
			double pang = algo.getBusSensitivity(DclfSensitivityType.PANGLE, sen.getInjectBusId(),
					bus.getBusId(), msg);
			str += Number2String.toFixLengthStr(8, bus.getBusId()) + "       "
					+ Number2String.toStr(pang) + "\n";
		}
		return str;
	}

	/**
	 * Out Q voltage sensitivity calculation results
	 * 
	 * @param sen XML sensitivity calculation records
	 * @param algo
	 * @param msg
	 * @return
	 */
	public static String qVoltageSensitivityResults(
			DclfBusSensitivityXmlType sen, DclfAlgorithm algo, IPSSMsgHub msg) {
		String str = "\n\n";
		str += "   Q-Voltage Sensitivity\n\n";
		str += "    Inject BusId : " + sen.getInjectBusId() + "\n\n";
		str += "   Bud Id         dV/dQ\n";
		str += "=================================\n";
		for (BusRecXmlType bus : sen.getBusArray()) {
			double x = algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE, sen.getInjectBusId(), bus.getBusId(), msg);
			str += Number2String.toFixLengthStr(8, bus.getBusId()) + "       "
					+ Number2String.toStr(x) + "\n";
		}
		return str;
	}

	/**
	 * out generator shift factor calculation results
	 * 
	 * @param gsFactor XML sensitivity calculation records
	 * @param algo
	 * @param msg
	 * @return
	 */
	public static String genShiftFactorResults(
			DclfBranchSensitivityXmlType gsFactor, DclfAlgorithm algo,
			IPSSMsgHub msg) {
		String str = "\n\n";
		str += "   Generator Shift Factor\n\n";
		str += "    Inject BusId : " + gsFactor.getInjectBusId() + "\n\n";
		str += "       Branch Id          GSF\n";
		str += "=========================================\n";
		for (BranchRecXmlType branch : gsFactor.getBranchArray()) {
			double gsf = algo.getGenShiftFactor(gsFactor.getInjectBusId(), branch.getFromBusId(), branch
					.getToBusId(), msg);
			str += Number2String.toFixLengthStr(16, branch.getFromBusId()
					+ "->" + branch.getToBusId())
					+ "       " + Number2String.toStr(gsf) + "\n";
		}
		return str;
	}

	/**
	 * out power transfer distribution factor calculation results
	 * 
	 * @param tdFactor XML sensitivity calculation records
	 * @param algo
	 * @param msg
	 * @return
	 */
	public static String pTransferDistFactorResults(
			DclfPowerTransferDistFactorXmlType tdFactor, DclfAlgorithm algo,
			IPSSMsgHub msg) {
		String str = "\n\n";
		str += "   Power Transfer Distribution Factor\n\n";
		str += "    Inject BusId   : " + tdFactor.getInjectBusId() + "\n";
		if (tdFactor.getWithdrawBusId() != null)
			str += "    Withdraw BusId : " + tdFactor.getWithdrawBusId() + "\n\n";
		else
			str += "    Withdraw BusId : " + tdFactor.getWithdrawBusList().toString() + "\n\n";
		str += "       Branch Id          PTDF\n";
		str += "========================================\n";
		for (BranchRecXmlType branch : tdFactor.getBranchArray()) {
			double ptdf = 0.0;
			if (tdFactor.getWithdrawBusId() != null)
				ptdf = algo.getPTransferDistFactor(tdFactor.getInjectBusId(), tdFactor.getWithdrawBusId(),
								branch.getFromBusId(),	branch.getToBusId(), msg);
			else 
				ptdf = algo.getPTransferDistFactor(tdFactor.getInjectBusId(), 
								branch.getFromBusId(),	branch.getToBusId(), msg);
			str += Number2String.toFixLengthStr(16, branch.getFromBusId()
					+ "->" + branch.getToBusId())
					+ "       " + Number2String.toStr(ptdf) + "\n";
		}
		return str;
	}
}