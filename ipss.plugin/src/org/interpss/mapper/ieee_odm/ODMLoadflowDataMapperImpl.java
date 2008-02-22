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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;


public class ODMLoadflowDataMapperImpl {
	public static boolean setBusLoadflowData(LoadflowBusDataXmlType busXmlData, AclfBus aclfBus, IPSSMsgHub msg) {
		double vpu = busXmlData.getVoltage().getUnit() == VoltageXmlType.Unit.PU ? 
						busXmlData.getVoltage().getVoltage() : ( busXmlData.getVoltage().getUnit() == VoltageXmlType.Unit.VOLT? 
							busXmlData.getVoltage().getVoltage()/aclfBus.getBaseVoltage() :
								busXmlData.getVoltage().getVoltage()*1000.0/aclfBus.getBaseVoltage());   // KV unit
		aclfBus.setVoltageMag(vpu);
		
		double ang = 0.0;
		if (busXmlData.getAngle() != null) 
			ang = busXmlData.getAngle().getUnit() == AngleXmlType.Unit.DEG? 
					busXmlData.getAngle().getAngle()*Constants.DtoR : busXmlData.getAngle().getAngle();
		aclfBus.setVoltageAng(ang);
		
		if (busXmlData.getGenData() != null) {
			if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PQ) {
				/*
				bus.setGenCode(AclfGenCode.GEN_PQ);
				PQBusAdapter pqBus = (PQBusAdapter) bus.adapt(PQBusAdapter.class);
				pqBus
						.setGen(new Complex(busData.getGenP(), busData.getGenQ()),
								UnitType.toUnit(busData.getGenUnit()), aclfNet
										.getBaseKva());
				*/						
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PV) {
				/*
				bus.setGenCode(AclfGenCode.GEN_PV);
				PVBusAdapter pvBus = (PVBusAdapter) bus.adapt(PVBusAdapter.class);
				pvBus.setGenP(busData.getGenP(), UnitType.toUnit(busData
						.getGenUnit()), aclfNet.getBaseKva());
				// VoltgeMsg is used to hold PV-VSpec, ReQVolt-VSpec and
				// ReQMvarFlow-MvarSpec
				pvBus.setVoltMag(busData.getVoltageMag(), UnitType.toUnit(busData
						.getVoltageMagUnit()));
				*/		
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.SWING) {
				/*
				 * bus.setGenCode(AclfGenCode.SWING);
				SwingBusAdapter swing = (SwingBusAdapter) bus
						.adapt(SwingBusAdapter.class);
				swing.setVoltMag(busData.getVoltageMag(), UnitType.toUnit(busData
						.getVoltageMagUnit()));
				swing.setVoltAng(busData.getVoltageAng(), UnitType.toUnit(busData
						.getVoltageAngUnit()));
				*/		
			} 
			else {
				return false;
			}
		}
		else {
			aclfBus.setGenCode(AclfGenCode.NON_GEN);
		}
		
		if (busXmlData.getLoadData() != null) {
/*
			
				LoadBusAdapter loadBus = (LoadBusAdapter) bus
						.adapt(LoadBusAdapter.class);
				if (!busData.getLoadCode().equals(AclfBusData.LoadCode_NonLoad))
					loadBus.setLoad(new Complex(busData.getLoadP(), busData
							.getLoadQ()), UnitType.toUnit(busData.getLoadUnit()),
							aclfNet.getBaseKva());
 */
			if (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_P) {
				
			}
			else if (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_I) {
				
			}
			else if (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_I) {
				
			}
			else if (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_Z) {
				
			}
			else {
				return false;
			}
		}
		else {
			aclfBus.setLoadCode(AclfLoadCode.NON_LOAD);
		}
		
		if (busXmlData.getShuntY() != null) {
/*
			Complex ypu = UnitType.yConversion(new Complex(busData.getShuntG(),
					busData.getShuntB()), bus.getBaseVoltage(), aclfNet
					.getBaseKva(), UnitType.toUnit(busData.getShuntYUnit()),
					UnitType.PU);
			bus.setShuntY(ypu);
*/		
		}
		
		return true;
	}

	public static boolean setBranchLoadflowData(LoadflowBranchDataXmlType braXmlData, AclfBranch aclfBranch, IPSSMsgHub msg) {
		if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.LINE) {
			/*
			AclfBranchData data = branchForm.getAcscBranchData();
			branch.setBranchCode(AclfBranchCode.LINE);
			LineAdapter line = (LineAdapter) branch.adapt(LineAdapter.class);
			line.setZ(new Complex(data.getZR(), data.getZX()), UnitType
					.toUnit(data.getZUnit()), branch.getFromAclfBus()
					.getBaseVoltage(), net.getBaseKva(), msg);
			line.setHShuntY(new Complex(0.0, data.getHalfShuntB()), UnitType
					.toUnit(data.getHalfShuntBUnit()), branch.getFromAclfBus()
					.getBaseVoltage(), net.getBaseKva());
						 */
			
		}
		else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.TRANSFORMER) {
			/*
			AclfBranchData data = branchForm.getAcscBranchData();
			branch.setBranchCode(AclfBranchCode.XFORMER);
			double fromBaseV = branch.getFromAclfBus().getBaseVoltage(), toBaseV = branch
					.getToAclfBus().getBaseVoltage();
			// the follow only applies if zUnit is in Ohms, which is very
			// unlikely
			double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
			XfrAdapter xfr = (XfrAdapter) branch.adapt(XfrAdapter.class);
			xfr.setZ(new Complex(data.getZR(), data.getZX()), UnitType
					.toUnit(data.getZUnit()), baseV, net.getBaseKva(), msg);

			xfr.setFromTurnRatio(data.getXfrTapFromSideTap(), UnitType
					.toUnit(data.getXfrTapUnit()));
			xfr.setToTurnRatio(data.getXfrTapToSideTap(), UnitType.toUnit(data
					.getXfrTapUnit()));
			 */
			
		}
		else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER) {
			/*
		branch.setBranchCode(AclfBranchCode.PS_XFORMER);
		PSXfrAdapter psXfr = (PSXfrAdapter) branch.adapt(PSXfrAdapter.class);
		psXfr.setFromAngle(data.getPhaseShiftAngle(), UnitType.toUnit(data
				.getPhaseShiftAngleUnit()));
			 */
			
		}
		else {
			return false;
		}
		
		if (braXmlData.getRatingLimit() != null) {
/*
			line.setMvaRating1(data.getRating1());
			line.setMvaRating2(data.getRating2());
			line.setMvaRating3(data.getRating3());
 */			
		}
		
		return true;
	}
}