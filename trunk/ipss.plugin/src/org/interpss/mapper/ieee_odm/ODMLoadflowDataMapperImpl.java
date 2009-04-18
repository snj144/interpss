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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowGenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
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
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.net.Area;
import com.interpss.core.net.Zone;

public class ODMLoadflowDataMapperImpl {
	public static AclfAdjNetwork mapNetworkData(PSSNetworkXmlType xmlNet) throws Exception {
		AclfAdjNetwork net = CoreObjectFactory.createAclfAdjNetwork();
		net.setId(xmlNet.getId());
		net.setName(xmlNet.getName());
		net.setDesc(xmlNet.getDesc());
		net.setBaseKva(xmlNet.getBasePower()*(xmlNet.getBasePowerUnit()==PSSNetworkXmlType.BasePowerUnit.MVA?1000.0:1.0));
				// BasePowerUnit [ MVA, KVA]
		net.setAllowParallelBranch(true);
		return net;
	}
	
	public static AclfBus mapBusData(BusRecordXmlType busRec, AclfAdjNetwork adjNet) throws Exception {
		AclfBus aclfBus = CoreObjectFactory.createAclfBus(busRec.getId());
		adjNet.addBus(aclfBus);
		aclfBus.setName(busRec.getName());
		aclfBus.setStatus(!busRec.getOffLine());
		aclfBus.setDesc(busRec.getDesc());
		Area area = CoreObjectFactory.createArea(busRec.getAreaNumber(), adjNet);
		aclfBus.setArea(area);
		Zone zone = CoreObjectFactory.createZone(busRec.getZoneNumber(), adjNet);
		aclfBus.setZone(zone);
		aclfBus.setBaseVoltage(busRec.getBaseVoltage().getUnit()==VoltageXmlType.Unit.KV ?    // Base V unit [KV, Volt] 
									busRec.getBaseVoltage().getVoltage()*1000.0	: busRec.getBaseVoltage().getVoltage());
		if (busRec.getLoadflowData() != null) {
			ODMLoadflowDataMapperImpl.setBusLoadflowData(busRec.getLoadflowData(), aclfBus, adjNet);
		}
		return aclfBus;
	}
	
	public static AclfBranch mapBranchData(BranchRecordXmlType branchRec, AclfAdjNetwork adjNet, IPSSMsgHub msg) throws Exception {
		AclfBranch aclfBranch = CoreObjectFactory.createAclfBranch();
		aclfBranch.setCircuitNumber(branchRec.getCircuitId());
		adjNet.addBranch(aclfBranch, branchRec.getFromBus().getIdRef(), branchRec.getToBus().getIdRef());
		aclfBranch.setName(branchRec.getName());
		aclfBranch.setStatus(!branchRec.getOffLine());
		Area area = CoreObjectFactory.createArea(branchRec.getAreaNumber(), adjNet);
		aclfBranch.setArea(area);
		Zone zone = CoreObjectFactory.createZone(branchRec.getZoneNumber(), adjNet);
		aclfBranch.setZone(zone);
		if (branchRec.getLoadflowData() != null)
			ODMLoadflowDataMapperImpl.setBranchLoadflowData( branchRec.getLoadflowData(),	aclfBranch,	adjNet, msg);
		return aclfBranch;
	}
	
	private static void setBusLoadflowData(LoadflowBusDataXmlType busXmlData, AclfBus aclfBus, AclfAdjNetwork adjNet) throws Exception {
		double vpu = UnitType.vConversion(busXmlData.getVoltage().getVoltage(),
				aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(busXmlData.getVoltage().getUnit()), UnitType.PU);
		double angRad = busXmlData.getAngle() ==  null? 0.0 :
			UnitType.angleConversion(busXmlData.getAngle().getAngle(),
					ODMXmlHelper.toUnit(busXmlData.getAngle().getUnit()), UnitType.Rad);
		aclfBus.setVoltage(vpu, angRad);

		if (busXmlData.getGenData() != null) {
			LoadflowGenDataXmlType genData = busXmlData.getGenData().getGen();
			if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PQ) {
				aclfBus.setGenCode(AclfGenCode.GEN_PQ);
				PQBusAdapter pqBus = (PQBusAdapter) aclfBus.getAdapter(PQBusAdapter.class);
				pqBus.setGen(new Complex(genData.getPower().getP(), genData.getPower().getQ()),
						           ODMXmlHelper.toUnit(genData.getPower().getUnit()), adjNet.getBaseKva());
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PV) {
				aclfBus.setGenCode(AclfGenCode.GEN_PV);
				PVBusAdapter pvBus = (PVBusAdapter) aclfBus.getAdapter(PVBusAdapter.class);
				pvBus.setGenP(busXmlData.getGenData().getGen().getPower().getP(),
							ODMXmlHelper.toUnit(busXmlData.getGenData().getGen().getPower().getUnit()), adjNet.getBaseKva());
				pvBus.setVoltMag(vpu, UnitType.PU);
			} else if (busXmlData.getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.SWING) {
				aclfBus.setGenCode(AclfGenCode.SWING);
				SwingBusAdapter swing = (SwingBusAdapter) aclfBus.getAdapter(SwingBusAdapter.class);
				swing.setVoltMag(vpu, UnitType.PU);
				swing.setVoltAng(angRad, UnitType.Rad);				
			} else {
				throw new Exception("Error: wrong LoadflowData.GenData.Code: " + busXmlData.getGenData().getCode());
			}
		} else {
			aclfBus.setGenCode(AclfGenCode.NON_GEN);
		}

		if (busXmlData.getLoadData() != null) {
			aclfBus.setLoadCode(busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_I ? 
							AclfLoadCode.CONST_I : (busXmlData.getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_Z ? 
									AclfLoadCode.CONST_Z : AclfLoadCode.CONST_P));
			LoadBusAdapter loadBus = (LoadBusAdapter) aclfBus.getAdapter(LoadBusAdapter.class);
			loadBus.setLoad(new Complex(busXmlData.getLoadData().getLoad().getP(), busXmlData.getLoadData().getLoad().getQ()),
						ODMXmlHelper.toUnit(busXmlData.getLoadData().getLoad().getUnit()), adjNet.getBaseKva());
		} else {
			aclfBus.setLoadCode(AclfLoadCode.NON_LOAD);
		}

		if (busXmlData.getShuntY() != null) {
			Complex ypu = UnitType.yConversion(new Complex(busXmlData.getShuntY().getG(), busXmlData.getShuntY().getB()),
					aclfBus.getBaseVoltage(), adjNet.getBaseKva(), ODMXmlHelper.toUnit(busXmlData.getShuntY().getUnit()),
					UnitType.PU);
			aclfBus.setShuntY(ypu);			
		}
	}

	private static void setBranchLoadflowData(LoadflowBranchDataXmlType braXmlData, AclfBranch aclfBra, 
							AclfAdjNetwork adjNet, IPSSMsgHub msg) throws Exception {
		YXmlType fromShuntY = null, toShuntY = null;
		double baseKva = adjNet.getBaseKva();
		
		if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.LINE) {
			if (braXmlData.getLineData() != null) {
				aclfBra.setBranchCode(AclfBranchCode.LINE);
				LineAdapter line = (LineAdapter) aclfBra.getAdapter(LineAdapter.class);
				line.setZ(new Complex(braXmlData.getLineData().getZ().getR(), braXmlData.getLineData().getZ().getX()), 
							ODMXmlHelper.toUnit(braXmlData.getLineData().getZ().getUnit()), 
							aclfBra.getFromAclfBus().getBaseVoltage(),	baseKva, msg);
				if (braXmlData.getLineData().getTotalShuntY() != null)
					line.setHShuntY(new Complex(0.5 * braXmlData.getLineData().getTotalShuntY().getG(),
									0.5 * braXmlData.getLineData().getTotalShuntY().getB()),
							ODMXmlHelper.toUnit(braXmlData.getLineData().getTotalShuntY().getUnit()), 
							aclfBra.getFromAclfBus().getBaseVoltage(), baseKva);
				
				fromShuntY = braXmlData.getLineData().getFromShuntY();
				toShuntY = braXmlData.getLineData().getToShuntY();
			} else {
				throw new Exception("Error: LoadflowBranchData.LineData not defined for branch code Line");
			}
		} else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.TRANSFORMER) {
			if (braXmlData.getXformerData() != null) {
				aclfBra.setBranchCode(AclfBranchCode.XFORMER);
				setXformerLoadflowData(aclfBra, braXmlData.getXformerData(), adjNet, msg);
			} else {
				throw new Exception("Error: LoadflowBranchData.XformerData not defined for branch Transformer");
			}
			fromShuntY = braXmlData.getXformerData().getFromShuntY();
			toShuntY = braXmlData.getXformerData().getToShuntY();
		} else if (braXmlData.getCode() == LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER) {
			if (braXmlData.getPhaseShiftXfrData() != null) {
				aclfBra.setBranchCode(AclfBranchCode.PS_XFORMER);
				setXformerLoadflowData(aclfBra, braXmlData.getPhaseShiftXfrData(), adjNet, msg);
				PSXfrAdapter psXfr = (PSXfrAdapter) aclfBra.getAdapter(PSXfrAdapter.class);
				if(braXmlData.getPhaseShiftXfrData().getFromAngle() != null)
					psXfr.setFromAngle(braXmlData.getPhaseShiftXfrData().getFromAngle().getAngle(), 
							ODMXmlHelper.toUnit(braXmlData.getPhaseShiftXfrData().getFromAngle().getUnit()));
				if(braXmlData.getPhaseShiftXfrData().getToAngle() != null)
					psXfr.setToAngle(braXmlData.getPhaseShiftXfrData().getToAngle().getAngle(), 
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
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getG(),	fromShuntY.getB()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toUnit(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
		if (toShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(toShuntY.getG(),	toShuntY.getB()),
					aclfBra.getToAclfBus().getBaseVoltage(), baseKva,
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
	}

	private static void setXformerLoadflowData(AclfBranch aclfBra, TransformerDataXmlType xfrData, 
						AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		double fromBaseV = aclfBra.getFromAclfBus().getBaseVoltage(), 
		       toBaseV = aclfBra.getToAclfBus().getBaseVoltage();
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = xfrData.getRatingData().getFromRatedVoltage().getVoltage();
		double toRatedV = xfrData.getRatingData().getToRatedVoltage().getVoltage();
    	double ratio = (fromRatedV/fromBaseV) / (toRatedV/toBaseV) ;
		
		double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
		XfrAdapter xfr = (XfrAdapter) aclfBra.getAdapter(XfrAdapter.class);
		xfr.setZ(new Complex(xfrData.getZ().getR(), xfrData.getZ().getX()),
				ODMXmlHelper.toUnit(xfrData.getZ().getUnit()), baseV, adjNet.getBaseKva(),
				msg);
		xfr.setFromTap(xfrData.getFromTurnRatio() == 0.0 ? 1.0 : xfrData
				.getFromTurnRatio()*ratio, UnitType.PU);
		xfr.setToTap(xfrData.getToTurnRatio() == 0.0 ? 1.0 : xfrData
				.getToTurnRatio()/ratio, UnitType.PU);
		
	}
}