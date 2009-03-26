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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.pssl.IpssAclf;

public class ODMLoadflowDataMapperImpl {
	public static AclfAdjNetwork mapNetworkData(PSSNetworkXmlType xmlNet) throws Exception {
		return IpssAclf.createAclfNetwork(xmlNet.getId())
					.setName(xmlNet.getName())
					.setDesc(xmlNet.getDesc())
					.setBaseKva(xmlNet.getBasePower()*(xmlNet.getBasePowerUnit()==PSSNetworkXmlType.BasePowerUnit.MVA?1000.0:1.0))
									// BasePowerUnit [ MVA, KVA]
					.setAllowParallelBranch(true)
					.getAclfNet();
	}
	
	public static AclfBus mapBusData(BusRecordXmlType busRec, AclfAdjNetwork adjNet) throws Exception {
		AclfBus aclfBus = IpssAclf.addAclfBus(busRec.getId(), busRec.getName(), adjNet)
					.setStatus(!busRec.getOffLine())
					.setDesc(busRec.getDesc())
					.setAreaNumber(busRec.getArea())
					.setZoneNumber(busRec.getZone())		
					.setBaseVoltage(busRec.getBaseVoltage().getUnit()==VoltageXmlType.Unit.KV ?    // Base V unit [KV, Volt] 
									busRec.getBaseVoltage().getVoltage()*1000.0	: busRec.getBaseVoltage().getVoltage())
					.getAclfBus();
		
		if (busRec.getLoadflowBusData() != null) {
			ODMLoadflowDataMapperImpl.setBusLoadflowData(busRec.getLoadflowBusData(), aclfBus, adjNet);
		}
		return aclfBus;
	}
	
	public static AclfBranch mapBranchData(BranchRecordXmlType branchRec, AclfAdjNetwork adjNet) throws Exception {
		AclfBranch aclfBranch = IpssAclf.addAclfBranch(branchRec.getFromBus().getIdRef(),
									branchRec.getToBus().getIdRef(), branchRec.getCircuitId(), adjNet)
					.setName(branchRec.getName())
					.setStatus(!branchRec.getOffLine())
					.setAreaNumber(branchRec.getArea())
					.setZoneNumber(branchRec.getZone())
					.getAclfBranch();
		if (branchRec.getLoadflowBranchData() != null)
			ODMLoadflowDataMapperImpl.setBranchLoadflowData( branchRec.getLoadflowBranchData(),	aclfBranch,	adjNet);
		return aclfBranch;
	}
	
	private static void setBusLoadflowData(LoadflowBusDataXmlType busXmlData, AclfBus aclfBus, AclfAdjNetwork adjNet) throws Exception {
		double vpu = UnitType.vConversion(busXmlData.getVoltage().getVoltage(),
				aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(busXmlData.getVoltage().getUnit()), UnitType.PU);
		double angRad = busXmlData.getAngle() ==  null? 0.0 :
			UnitType.angleConversion(busXmlData.getAngle().getAngle(),
					ODMXmlHelper.toUnit(busXmlData.getAngle().getUnit()), UnitType.Rad);
		IpssAclf.wrapAclfBus(aclfBus, adjNet)
					.setInitVoltage(vpu, angRad);

		if (busXmlData.getGenData() != null) {
			GenDataXmlType genData = busXmlData.getGenData().getGen();
			if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PQ) {
				IpssAclf.wrapAclfBus(aclfBus, adjNet)
						.setGenCode(AclfGenCode.GEN_PQ)
						.setGen(new Complex(genData.getPower().getP(), genData.getPower().getQ()),
						           ODMXmlHelper.toUnit(genData.getPower().getUnit()));
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PV) {
				IpssAclf.wrapAclfBus(aclfBus, adjNet)
						.setGenCode(AclfGenCode.GEN_PV)
						.setGenP_VMag(genData.getPower().getP(), ODMXmlHelper.toUnit(genData.getPower().getUnit()), 
									  vpu, UnitType.PU);
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.SWING) {
				IpssAclf.wrapAclfBus(aclfBus, adjNet)
						.setGenCode(AclfGenCode.SWING)
						.setVoltageSpec(vpu, UnitType.PU, angRad, UnitType.Rad);
			} else {
				throw new Exception("Error: wrong LoadflowData.GenData.Code: " + busXmlData.getGenData().getCode());
			}
		} else {
			IpssAclf.wrapAclfBus(aclfBus, adjNet)
					.setGenCode(AclfGenCode.NON_GEN);
		}

		if (busXmlData.getLoadData() != null) {
			PowerXmlType loadData = busXmlData.getLoadData().getLoad();
			IpssAclf.wrapAclfBus(aclfBus, adjNet)
					.setLoadCode(busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_I ? 
							AclfLoadCode.CONST_I : (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_Z ? 
									AclfLoadCode.CONST_Z : AclfLoadCode.CONST_P))
					.setLoad(new Complex(loadData.getP(), loadData.getQ()),	ODMXmlHelper.toUnit(loadData.getUnit()));
		} else {
			IpssAclf.wrapAclfBus(aclfBus, adjNet)
					.setLoadCode(AclfLoadCode.NON_LOAD);
		}

		if (busXmlData.getShuntY() != null) {
			IpssAclf.wrapAclfBus(aclfBus, adjNet)
						.setShuntY(new Complex(busXmlData.getShuntY().getG(), busXmlData.getShuntY().getB()),
								ODMXmlHelper.toUnit(busXmlData.getShuntY().getUnit()));
		}
	}

	private static void setBranchLoadflowData(LoadflowBranchDataXmlType braXmlData, AclfBranch aclfBra, AclfAdjNetwork adjNet) throws Exception {
		YXmlType fromShuntY = null, toShuntY = null;
		double baseKva = adjNet.getBaseKva();
		
		if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.LINE) {
			if (braXmlData.getLineData() != null) {
				ZXmlType z = braXmlData.getLineData().getZ();
				IpssAclf.wrapAclfBranch(aclfBra, adjNet)
							.setBranchCode(AclfBranchCode.LINE)
							.setZ(new Complex(z.getR(), z.getX()), ODMXmlHelper.toUnit(z.getUnit()));
				if (braXmlData.getLineData().getTotalShuntY() != null) {
					YXmlType y = braXmlData.getLineData().getTotalShuntY();
					IpssAclf.wrapAclfBranch(aclfBra, adjNet)
								.setShuntY(new Complex(y.getG(), y.getB()), ODMXmlHelper.toUnit(y.getUnit()));
				}
				fromShuntY = braXmlData.getLineData().getFromShuntY();
				toShuntY = braXmlData.getLineData().getToShuntY();
			} else {
				throw new Exception("Error: LoadflowBranchData.LineData not defined for branch code Line");
			}
		} else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.TRANSFORMER) {
			if (braXmlData.getXformerData() != null) {
				IpssAclf.wrapAclfBranch(aclfBra, adjNet)
							.setBranchCode(AclfBranchCode.XFORMER);
				setXformerLoadflowData(aclfBra, braXmlData.getXformerData(), adjNet);
			} else {
				throw new Exception("Error: LoadflowBranchData.XformerData not defined for branch Transformer");
			}
			fromShuntY = braXmlData.getXformerData().getFromShuntY();
			toShuntY = braXmlData.getXformerData().getToShuntY();
		} else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER) {
			if (braXmlData.getPhaseShiftXfrData() != null) {
				IpssAclf.wrapAclfBranch(aclfBra, adjNet)
							.setBranchCode(AclfBranchCode.PS_XFORMER);
				setXformerLoadflowData(aclfBra, braXmlData.getPhaseShiftXfrData(), adjNet);

				if(braXmlData.getPhaseShiftXfrData().getFromAngle() != null)
					IpssAclf.wrapAclfBranch(aclfBra, adjNet)
								.setFromShiftAngle(braXmlData.getPhaseShiftXfrData().getFromAngle().getAngle(), 
										ODMXmlHelper.toUnit(braXmlData.getPhaseShiftXfrData().getFromAngle().getUnit()));
				if(braXmlData.getPhaseShiftXfrData().getToAngle() != null)
					IpssAclf.wrapAclfBranch(aclfBra, adjNet)
								.setToShiftAngle(braXmlData.getPhaseShiftXfrData().getToAngle().getAngle(), 
										ODMXmlHelper.toUnit(braXmlData.getPhaseShiftXfrData().getToAngle().getUnit()));
			} else {
				throw new Exception("Error: LoadflowBranchData.PhaseShiftXfrData not defined for branch Phase-shifting Transformer");
			}
			fromShuntY = braXmlData.getPhaseShiftXfrData().getFromShuntY();
			toShuntY = braXmlData.getPhaseShiftXfrData().getToShuntY();
		} else {
			throw new Exception("Error: LoadflowBranchData.code type, "+ braXmlData.toString());
		}

		if (fromShuntY != null) {
			IpssAclf.wrapAclfBranch(aclfBra, adjNet)
						.setFromShuntY(new Complex(fromShuntY.getG(), fromShuntY.getB()), 
								       ODMXmlHelper.toUnit(fromShuntY.getUnit()));
		}
		if (toShuntY != null) {
			IpssAclf.wrapAclfBranch(aclfBra, adjNet)
						.setToShuntY(new Complex(toShuntY.getG(), toShuntY.getB()), 
										ODMXmlHelper.toUnit(toShuntY.getUnit()));
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
	}

	private static void setXformerLoadflowData(AclfBranch aclfBra, TransformerDataXmlType xfrData, AclfAdjNetwork adjNet) {
		double fromBaseV = aclfBra.getFromAclfBus().getBaseVoltage(), 
		       toBaseV = aclfBra.getToAclfBus().getBaseVoltage();
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = xfrData.getRatingData().getFromRatedVoltage().getVoltage();
		double toRatedV = xfrData.getRatingData().getToRatedVoltage().getVoltage();
    	double ratio = (fromRatedV/fromBaseV) / (toRatedV/toBaseV) ;
		
		IpssAclf.wrapAclfBranch(aclfBra, adjNet)
					.setZ(new Complex(xfrData.getZ().getR(), xfrData.getZ().getX()), ODMXmlHelper.toUnit(xfrData.getZ().getUnit()))
					.setTurnRatio(xfrData.getFromTurnRatio() == 0.0 ? 1.0 : xfrData.getFromTurnRatio()*ratio,
							      xfrData.getToTurnRatio() == 0.0 ? 1.0 : xfrData.getToTurnRatio()/ratio, UnitType.PU);
	}
}