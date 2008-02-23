/*
 * @(#)ODMLoadflowDataMapperImpl.java   
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
 * @Date 02/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.ieee_odm;

import org.apache.commons.math.complex.Complex;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;

public class ODMLoadflowDataMapperImpl {
	public static boolean setBusLoadflowData(LoadflowBusDataXmlType busXmlData,
			AclfBus aclfBus, double baseKva, IPSSMsgHub msg) {
		double vpu = UnitType.vConversion(busXmlData.getVoltage().getVoltage(),
				aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(busXmlData
						.getVoltage().getUnit()), UnitType.PU);
		aclfBus.setVoltageMag(vpu);

		double angRad = 0.0;
		if (busXmlData.getAngle() != null)
			angRad = UnitType.angleConversion(busXmlData.getAngle().getAngle(),
					ODMXmlHelper.toUnit(busXmlData.getAngle().getUnit()),
					UnitType.Rad);
		aclfBus.setVoltageAng(angRad);

		if (busXmlData.getGenData() != null) {
			if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PQ) {
				aclfBus.setGenCode(AclfGenCode.GEN_PQ);
				PQBusAdapter pqBus = (PQBusAdapter) aclfBus
						.adapt(PQBusAdapter.class);
				pqBus.setGen(new Complex(busXmlData.getGenData().getGen()
						.getP(), busXmlData.getGenData().getGen().getQ()),
						ODMXmlHelper.toUnit(busXmlData.getGenData().getGen()
								.getUnit()), baseKva);
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PV) {
				aclfBus.setGenCode(AclfGenCode.GEN_PV);
				PVBusAdapter pvBus = (PVBusAdapter) aclfBus
						.adapt(PVBusAdapter.class);
				pvBus.setGenP(busXmlData.getGenData().getGen().getP(),
						ODMXmlHelper.toUnit(busXmlData.getGenData().getGen()
								.getUnit()), baseKva);
				pvBus.setVoltMag(vpu, UnitType.PU);
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.SWING) {
				aclfBus.setGenCode(AclfGenCode.SWING);
				SwingBusAdapter swing = (SwingBusAdapter) aclfBus
						.adapt(SwingBusAdapter.class);
				swing.setVoltMag(vpu, UnitType.PU);
				swing.setVoltAng(angRad, UnitType.Rad);
			} else {
				msg.sendErrorMsg("Error: wrong LoadflowData.GenData.Code: "
						+ busXmlData.getGenData().getCode());
				return false;
			}
		} else {
			aclfBus.setGenCode(AclfGenCode.NON_GEN);
		}

		if (busXmlData.getLoadData() != null) {
			aclfBus
					.setLoadCode(busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_I ? AclfLoadCode.CONST_I
							: (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_Z ? AclfLoadCode.CONST_Z
									: AclfLoadCode.CONST_P));
			LoadBusAdapter loadBus = (LoadBusAdapter) aclfBus
					.adapt(LoadBusAdapter.class);
			loadBus.setLoad(new Complex(busXmlData.getLoadData().getLoad()
					.getP(), busXmlData.getLoadData().getLoad().getQ()),
					ODMXmlHelper.toUnit(busXmlData.getLoadData().getLoad()
							.getUnit()), baseKva);
		} else {
			aclfBus.setLoadCode(AclfLoadCode.NON_LOAD);
		}

		if (busXmlData.getShuntY() != null) {
			Complex ypu = UnitType.yConversion(new Complex(busXmlData
					.getShuntY().getG(), busXmlData.getShuntY().getB()),
					aclfBus.getBaseVoltage(), baseKva, ODMXmlHelper
							.toUnit(busXmlData.getShuntY().getUnit()),
					UnitType.PU);
			aclfBus.setShuntY(ypu);
		}

		return true;
	}

	public static boolean setBranchLoadflowData(
			LoadflowBranchDataXmlType braXmlData, AclfBranch aclfBra,
			double baseKva, IPSSMsgHub msg) {
		YXmlType fromShuntY = null, toShuntY = null;
		
		if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.LINE) {
			if (braXmlData.getLineData() != null) {
				aclfBra.setBranchCode(AclfBranchCode.LINE);
				LineAdapter line = (LineAdapter) aclfBra
						.adapt(LineAdapter.class);
				line
						.setZ(
								new Complex(braXmlData.getLineData().getZ()
										.getR(), braXmlData.getLineData()
										.getZ().getX()), ODMXmlHelper
										.toUnit(braXmlData.getLineData().getZ()
												.getUnit()), aclfBra
										.getFromAclfBus().getBaseVoltage(),
								baseKva, msg);
				if (braXmlData.getLineData().getTotalShuntY() != null)
					line
							.setHShuntY(new Complex(0.5 * braXmlData
									.getLineData().getTotalShuntY().getG(),
									0.5 * braXmlData.getLineData()
											.getTotalShuntY().getB()),
									ODMXmlHelper.toUnit(braXmlData
											.getLineData().getTotalShuntY()
											.getUnit()), aclfBra
											.getFromAclfBus().getBaseVoltage(),
									baseKva);
				fromShuntY = braXmlData.getLineData().getFromShuntY();
				toShuntY = braXmlData.getLineData().getToShuntY();
			} else {
				msg
						.sendErrorMsg("Error: LoadflowBranchData.LineData not defined for branch code Line");
				return false;
			}
		} else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.TRANSFORMER) {
			if (braXmlData.getXformerData() != null) {
				aclfBra.setBranchCode(AclfBranchCode.XFORMER);
				setXformerLoadflowData(aclfBra, braXmlData.getXformerData(),
						baseKva, msg);
			} else {
				msg
						.sendErrorMsg("Error: LoadflowBranchData.XformerData not defined for branch Transformer");
				return false;
			}
			fromShuntY = braXmlData.getXformerData().getFromShuntY();
			toShuntY = braXmlData.getXformerData().getToShuntY();
		} else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER) {
			if (braXmlData.getPhaseShiftXfrData() != null) {
				aclfBra.setBranchCode(AclfBranchCode.PS_XFORMER);
				PSXfrAdapter psXfr = (PSXfrAdapter) aclfBra
						.adapt(PSXfrAdapter.class);
				setXformerLoadflowData(aclfBra, braXmlData
						.getPhaseShiftXfrData(), baseKva, msg);
				if(braXmlData.getPhaseShiftXfrData().getFromAngle() != null)
					psXfr.setFromAngle(braXmlData.getPhaseShiftXfrData()
						.getFromAngle().getAngle(), ODMXmlHelper
						.toUnit(braXmlData.getPhaseShiftXfrData()
								.getFromAngle().getUnit()));
				if(braXmlData.getPhaseShiftXfrData().getToAngle() != null)
					psXfr.setToAngle(braXmlData.getPhaseShiftXfrData().getToAngle()
						.getAngle(), ODMXmlHelper.toUnit(braXmlData
						.getPhaseShiftXfrData().getToAngle().getUnit()));
			} else {
				msg
						.sendErrorMsg("Error: LoadflowBranchData.PhaseShiftXfrData not defined for branch Phase-shifting Transformer");
				return false;
			}
			fromShuntY = braXmlData.getPhaseShiftXfrData().getFromShuntY();
			toShuntY = braXmlData.getPhaseShiftXfrData().getToShuntY();
		} else {
			msg.sendErrorMsg("Error: LoadflowBranchData.code type, "
					+ braXmlData.toString());
			return false;
		}

		if (fromShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getG(),	fromShuntY.getB()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toUnit(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
		if (toShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(toShuntY.getG(),	toShuntY.getB()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toUnit(toShuntY.getUnit()), UnitType.PU);
			aclfBra.setToShuntY(ypu);
		}

		if (braXmlData.getRatingLimit() != null) {
			double factor = 1.0;
			if (braXmlData.getRatingLimit().getMvaRatingUnit() == LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.PU)
				factor = baseKva * 0.001;
			else if (braXmlData.getRatingLimit().getMvaRatingUnit() == LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.KVA)
				factor = 0.001;
			aclfBra.setRatingMva1(braXmlData.getRatingLimit().getMvaRating1()
					* factor);
			aclfBra.setRatingMva2(braXmlData.getRatingLimit().getMvaRating2()
					* factor);
			aclfBra.setRatingMva3(braXmlData.getRatingLimit().getMvaRating3()
					* factor);
		}

		return true;
	}

	private static void setXformerLoadflowData(AclfBranch aclfBra,
			TransformerDataXmlType xfrData, double baseKva, IPSSMsgHub msg) {
		double fromBaseV = aclfBra.getFromAclfBus().getBaseVoltage(), 
		       toBaseV = aclfBra.getToAclfBus().getBaseVoltage();
		// it is assumed that Z, Y are measure at High V side
		double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
		XfrAdapter xfr = (XfrAdapter) aclfBra.adapt(XfrAdapter.class);
		xfr.setZ(new Complex(xfrData.getZ().getR(), xfrData.getZ().getX()),
				ODMXmlHelper.toUnit(xfrData.getZ().getUnit()), baseV, baseKva,
				msg);
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = xfrData.getRatingData().getFromRatedVoltage().getVoltage();
		double toRatedV = xfrData.getRatingData().getToRatedVoltage().getVoltage();
    	double ratio = (fromRatedV/fromBaseV) / (toRatedV/toBaseV) ;
		
		xfr.setFromTurnRatio(xfrData.getFromTurnRatio() == 0.0 ? 1.0 : xfrData
				.getFromTurnRatio()*ratio, UnitType.PU);
		xfr.setToTurnRatio(xfrData.getToTurnRatio() == 0.0 ? 1.0 : xfrData
				.getToTurnRatio()/ratio, UnitType.PU);
	}
}