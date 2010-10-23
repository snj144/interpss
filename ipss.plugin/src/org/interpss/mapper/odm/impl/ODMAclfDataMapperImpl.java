/*
 * @(#)ODMAclfDataMapperImpl.java   
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

package org.interpss.mapper.odm.impl;

import javax.xml.bind.JAXBElement;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.model.BaseJaxbHelper;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.schema.AngleXmlType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowLoadDataXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.PowerXmlType;
import org.ieee.odm.schema.TransformerInfoXmlType;
import org.ieee.odm.schema.VoltageXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.ieee.odm.schema.YXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.adj.PQBusLimit;
import com.interpss.core.aclf.adj.PVBusLimit;
import com.interpss.core.aclf.adj.RemoteQBus;
import com.interpss.core.aclf.adj.RemoteQControlType;
import com.interpss.core.aclf.adpter.LineAdapter;
import com.interpss.core.aclf.adpter.LoadBusAdapter;
import com.interpss.core.aclf.adpter.PQBusAdapter;
import com.interpss.core.aclf.adpter.PSXfrAdapter;
import com.interpss.core.aclf.adpter.PVBusAdapter;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.aclf.adpter.XfrAdapter;
import com.interpss.core.aclf.netAdj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ODMAclfDataMapperImpl {
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(AclfModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		if (parser.getAclfNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION ) {

			LoadflowNetXmlType xmlNet = parser.getAclfNet();
			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			try {
				AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
				mapNetworkData(adjNet, xmlNet);
				simuCtx.setAclfAdjNet(adjNet);

				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					LoadflowBusXmlType busRec = (LoadflowBusXmlType) bus.getValue();
					mapAclfBusData(busRec, adjNet);
				}

				for (JAXBElement<? extends BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					AclfBranch aclfBranch = CoreObjectFactory.createAclfBranch();
					mapAclfBranchData(b.getValue(), aclfBranch, adjNet, simuCtx.getMsgHub());
				}
			} catch (InterpssException e) {
				e.printStackTrace();
				IpssLogger.getLogger().severe(e.toString());
				noError = false;
			}
		} else {
			IpssLogger.getLogger().severe(
							"Error: currently only Transmission NetworkType has been implemented");
			return false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}
	
	/**
	 * Map the network info only
	 * 
	 * @param xmlNet
	 * @return
	 */
	public static void mapNetworkData(AclfAdjNetwork net, LoadflowNetXmlType xmlNet) {
		ODMNetDataMapperImpl.mapNetworkData(net, xmlNet);
	}
	
	/**
	 * Map a bus record
	 * 
	 * @param busRec
	 * @param adjNet
	 * @return
	 * @throws Exception
	 */
	public static AclfBus mapAclfBusData(LoadflowBusXmlType busRec, AclfAdjNetwork adjNet) throws InterpssException {
		AclfBus aclfBus = CoreObjectFactory.createAclfBus(busRec.getId(), adjNet);
		//adjNet.addBus(aclfBus);
		ODMNetDataMapperImpl.mapBaseBusData(busRec, aclfBus, adjNet);
		setAclfBusData(busRec, aclfBus, adjNet);
		return aclfBus;
	}
	
	public static void setAclfBusData(LoadflowBusXmlType busXmlData, AclfBus aclfBus, AclfAdjNetwork adjNet) throws InterpssException {
		VoltageXmlType vXml = busXmlData.getVoltage();
		double vpu = vXml == null ? 1.0 : UnitType.vConversion(vXml.getValue(),
				aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(vXml.getUnit()), UnitType.PU);
		double angRad = busXmlData.getAngle() ==  null? 0.0 :
			UnitType.angleConversion(busXmlData.getAngle().getValue(),
					ODMXmlHelper.toUnit(busXmlData.getAngle().getUnit()), UnitType.Rad);
		aclfBus.setVoltage(vpu, angRad);

		if (busXmlData.getGenData() != null) {
			LoadflowGenDataXmlType xmlEquivGenData = busXmlData.getGenData().getEquivGen();
			if (xmlEquivGenData.getCode() == LFGenCodeEnumType.PQ) {
				aclfBus.setGenCode(AclfGenCode.GEN_PQ);
				PQBusAdapter pqBus = (PQBusAdapter) aclfBus.getAdapter(PQBusAdapter.class);
				pqBus.setGen(new Complex(xmlEquivGenData.getPower().getRe(), 
						                 xmlEquivGenData.getPower().getIm()),
						           ODMXmlHelper.toUnit(xmlEquivGenData.getPower().getUnit()));
				if (xmlEquivGenData.getVoltageLimit() != null) {
  			  		final PQBusLimit pqLimit = CoreObjectFactory.createPQBusLimit(aclfBus);
  			  		pqLimit.setVLimit(new LimitType(xmlEquivGenData.getVoltageLimit().getMax(), 
  			  										xmlEquivGenData.getVoltageLimit().getMin()), 
  			  				ODMXmlHelper.toUnit(xmlEquivGenData.getVoltageLimit().getUnit()));						
				}
			} else if (xmlEquivGenData.getCode() == LFGenCodeEnumType.PV &&
					xmlEquivGenData != null) {
				if (xmlEquivGenData.getRemoteVoltageControlBus() == null) {
					aclfBus.setGenCode(AclfGenCode.GEN_PV);
					PVBusAdapter pvBus = (PVBusAdapter) aclfBus.getAdapter(PVBusAdapter.class);
					//if (xmlEquivGenData == null)
					//	System.out.print(busXmlData);
					pvBus.setGenP(xmlEquivGenData.getPower().getRe(),
								ODMXmlHelper.toUnit(xmlEquivGenData.getPower().getUnit()));
					vXml = xmlEquivGenData.getDesiredVoltage();
					if (vXml == null)
						throw new InterpssException("For Gen PV bus, equivGenData.desiredVoltage has to be defined, busId: " + aclfBus.getId());
					vpu = UnitType.vConversion(vXml.getValue(),
							aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(vXml.getUnit()), UnitType.PU);
					pvBus.setVoltMag(vpu, UnitType.PU);
					if (xmlEquivGenData.getQLimit() != null) {
	  			  		final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(aclfBus);
	  			  		pvLimit.setQLimit(new LimitType(xmlEquivGenData.getQLimit().getMax(), 
	  			  										xmlEquivGenData.getQLimit().getMin()), 
	  			  				ODMXmlHelper.toUnit(xmlEquivGenData.getQLimit().getUnit()));						
					}
				}
				else {
					// remote bus voltage
  					IpssLogger.getLogger().fine("Bus is a RemoteQBus, id: " + aclfBus.getId());
  					aclfBus.setGenCode(AclfGenCode.GEN_PQ);
  					// The remote bus to be adjusted is normally defined as a PV bus. It needs to
  					// be changed to PQ bus
  					String remoteId = BaseJaxbHelper.getRecId(xmlEquivGenData.getRemoteVoltageControlBus());
  					if (remoteId != null) {
  						AclfBus remoteBus = adjNet.getAclfBus(remoteId);
  	  					if (remoteBus != null) {
  	  	  					if (remoteBus.isGenPV())
  	  	  						remoteBus.setGenCode(AclfGenCode.GEN_PQ);
  	  	  			  		final RemoteQBus reQBus = CoreObjectFactory.createRemoteQBus(aclfBus, 
  	  	  			  				RemoteQControlType.BUS_VOLTAGE, adjNet, remoteId);
  	  			  			final PQBusAdapter gen = (PQBusAdapter)aclfBus.getAdapter(PQBusAdapter.class);
  	  			  			gen.setGen(new Complex(xmlEquivGenData.getPower().getRe(),
  	  			  					               xmlEquivGenData.getPower().getIm()), 
  	  			  					               ODMXmlHelper.toUnit(xmlEquivGenData.getPower().getUnit()));
  	  	  			  		reQBus.setQLimit(new LimitType(xmlEquivGenData.getQLimit().getMax(), 
  	  														xmlEquivGenData.getQLimit().getMin()), 
  	  										ODMXmlHelper.toUnit(xmlEquivGenData.getQLimit().getUnit()));						
  	  	  			  		reQBus.setVSpecified(UnitType.vConversion(xmlEquivGenData.getDesiredVoltage().getValue(),
  	  								aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(vXml.getUnit()), UnitType.PU));					
  	  					}
  					}
				}
			} else if (xmlEquivGenData.getCode() == LFGenCodeEnumType.SWING) {
				aclfBus.setGenCode(AclfGenCode.SWING);
				SwingBusAdapter swing = (SwingBusAdapter) aclfBus.getAdapter(SwingBusAdapter.class);
				vXml = busXmlData.getGenData().getEquivGen().getDesiredVoltage();
				vpu = UnitType.vConversion(vXml.getValue(),
						aclfBus.getBaseVoltage(), ODMXmlHelper.toUnit(vXml.getUnit()), UnitType.PU);
				AngleXmlType angXml = busXmlData.getGenData().getEquivGen().getDesiredAngle(); 
				angRad = UnitType.angleConversion(angXml.getValue(),
							ODMXmlHelper.toUnit(angXml.getUnit()), UnitType.Rad);				
				swing.setVoltMag(vpu, UnitType.PU);
				swing.setVoltAng(angRad, UnitType.Rad);				
			} else {
				aclfBus.setGenCode(AclfGenCode.NON_GEN);
			}
		} else {
			aclfBus.setGenCode(AclfGenCode.NON_GEN);
		}

		if (busXmlData.getLoadData() != null) {
			aclfBus.setLoadCode(busXmlData.getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_I ? 
							AclfLoadCode.CONST_I : (busXmlData.getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_Z ? 
									AclfLoadCode.CONST_Z : AclfLoadCode.CONST_P));
			LoadBusAdapter loadBus = (LoadBusAdapter) aclfBus.getAdapter(LoadBusAdapter.class);
			LoadflowLoadDataXmlType xmlEquivLoad = busXmlData.getLoadData().getEquivLoad();
			if (xmlEquivLoad != null) {
				PowerXmlType p;
				if (aclfBus.getLoadCode() == AclfLoadCode.CONST_P)
					p = xmlEquivLoad.getConstPLoad();
				else if (aclfBus.getLoadCode() == AclfLoadCode.CONST_I)
					p = xmlEquivLoad.getConstILoad();
				else	
					p = xmlEquivLoad.getConstZLoad();
				if (p != null)
					loadBus.setLoad(new Complex(p.getRe(), p.getIm()),
							ODMXmlHelper.toUnit(p.getUnit()));
			}
		} else {
			aclfBus.setLoadCode(AclfLoadCode.NON_LOAD);
		}

		if (busXmlData.getShuntY() != null) {
			Complex ypu = UnitType.yConversion(new Complex(busXmlData.getShuntY().getRe(), busXmlData.getShuntY().getIm()),
					aclfBus.getBaseVoltage(), adjNet.getBaseKva(), ODMXmlHelper.toUnit(busXmlData.getShuntY().getUnit()),
					UnitType.PU);
			aclfBus.setShuntY(ypu);			
		}
	}
	
	/**
	 * 
	 * @param branch
	 * @param adjNet
	 * @param msg
	 * @throws Exception
	 */
	public static void mapAclfBranchData(BaseBranchXmlType branch, AclfBranch aclfBranch, AclfAdjNetwork adjNet, IPSSMsgHub msg) throws InterpssException {
		setAclfBranchData((BranchXmlType)branch, aclfBranch, adjNet);
		if (branch instanceof LineBranchXmlType) {
			LineBranchXmlType branchRec = (LineBranchXmlType) branch;
			setLineBranchData(branchRec, aclfBranch, adjNet, msg);
		}
		else if (branch instanceof XfrBranchXmlType) {
			XfrBranchXmlType branchRec = (XfrBranchXmlType) branch;
			setXfrBranchData(branchRec, aclfBranch, adjNet, msg);
		}
		else if (branch instanceof LineBranchXmlType) {
			PSXfrBranchXmlType branchRec = (PSXfrBranchXmlType) branch;
			setPsXfrBranchData(branchRec, aclfBranch, adjNet, msg);
		}		
	}
	
	private static void setAclfBranchData(BranchXmlType branchRec, AclfBranch aclfBranch, AclfAdjNetwork adjNet) throws InterpssException {
		ODMNetDataMapperImpl.mapBaseBranchRec(branchRec, aclfBranch, adjNet);		
		if (branchRec.getRatingLimit() != null && branchRec.getRatingLimit().getMva() != null) {
			double factor = 1.0;
			if (branchRec.getRatingLimit().getMva().getUnit() == ApparentPowerUnitType.PU)
				factor = adjNet.getBaseKva() * 0.001;
			else if (branchRec.getRatingLimit().getMva().getUnit() == ApparentPowerUnitType.KVA)
				factor = 0.001;
			aclfBranch.setRatingMva1(branchRec.getRatingLimit().getMva().getRating1() * factor);
			if (branchRec.getRatingLimit().getMva().getRating2() != null)
				aclfBranch.setRatingMva2(branchRec.getRatingLimit().getMva().getRating2() * factor);
			if (branchRec.getRatingLimit().getMva().getRating3() != null)
				aclfBranch.setRatingMva3(branchRec.getRatingLimit().getMva().getRating3() * factor);
			//if (branchRec.getRatingLimit().getMva().getRating4())
			//	aclfBranch.setRatingMva4(branchRec.getRatingLimit().getMva().getRating3() * factor);
		}
	}

	private static void setLineBranchData(LineBranchXmlType braLine, AclfBranch aclfBra, 
							AclfAdjNetwork adjNet, IPSSMsgHub msg) throws InterpssException {
		YXmlType fromShuntY = null, toShuntY = null;
		double baseKva = adjNet.getBaseKva();
		
		aclfBra.setBranchCode(AclfBranchCode.LINE);
		//System.out.println(braXmlData.getLineData().getZ().getIm());
		LineAdapter line = aclfBra.toLine();
		if (braLine.getZ() == null) {
			throw new InterpssException("Line data error, Z == null, branch id: " + braLine.getId());
		}
		
		line.setZ(new Complex(braLine.getZ().getRe(), braLine.getZ().getIm()), 
					ODMXmlHelper.toUnit(braLine.getZ().getUnit()), 
					aclfBra.getFromAclfBus().getBaseVoltage(), msg);
		if (braLine.getTotalShuntY() != null)
			line.setHShuntY(new Complex(0.5 * braLine.getTotalShuntY().getRe(),
							0.5 * braLine.getTotalShuntY().getIm()),
					ODMXmlHelper.toUnit(braLine.getTotalShuntY().getUnit()), 
					aclfBra.getFromAclfBus().getBaseVoltage());
		
		fromShuntY = braLine.getFromShuntY();
		toShuntY = braLine.getToShuntY();

		if (fromShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getRe(),	fromShuntY.getIm()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toUnit(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
		if (toShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(toShuntY.getRe(),	toShuntY.getIm()),
					aclfBra.getToAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toUnit(toShuntY.getUnit()), UnitType.PU);
			aclfBra.setToShuntY(ypu);
		}
	}

	private static void setXfrBranchData(XfrBranchXmlType braXfr, AclfBranch aclfBra, 
			AclfAdjNetwork adjNet, IPSSMsgHub msg) throws InterpssException {
		YXmlType fromShuntY = null;
		double baseKva = adjNet.getBaseKva();
		
		aclfBra.setBranchCode(AclfBranchCode.XFORMER);
		setXformerInfoData(aclfBra, braXfr, adjNet, msg);
		fromShuntY = braXfr.getMagnitizingY();

		if (fromShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getRe(),	fromShuntY.getIm()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toUnit(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
	}
	
	private static void setPsXfrBranchData(PSXfrBranchXmlType braPsXfr, AclfBranch aclfBra, 
			AclfAdjNetwork adjNet, IPSSMsgHub msg) throws InterpssException {
		aclfBra.setBranchCode(AclfBranchCode.PS_XFORMER);

		setXfrBranchData(braPsXfr, aclfBra, adjNet, msg);
		
		PSXfrAdapter psXfr = aclfBra.toPSXfr();
		if(braPsXfr.getFromAngle() != null)
			psXfr.setFromAngle(braPsXfr.getFromAngle().getValue(), 
						ODMXmlHelper.toUnit(braPsXfr.getFromAngle().getUnit()));
		if(braPsXfr.getToAngle() != null)
			psXfr.setToAngle(braPsXfr.getToAngle().getValue(), 
						ODMXmlHelper.toUnit(braPsXfr.getToAngle().getUnit()));
	}

	private static void setXformerInfoData(AclfBranch aclfBra, XfrBranchXmlType xfrBranch, 
						AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		double fromBaseV = aclfBra.getFromAclfBus().getBaseVoltage(), 
		       toBaseV = aclfBra.getToAclfBus().getBaseVoltage();
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = fromBaseV;
		double toRatedV = toBaseV;
		double zratio = 1.0;
		double tapratio = 1.0;
		
		TransformerInfoXmlType xfrData = xfrBranch.getXfrInfo();
		if (xfrData != null) {
			if (xfrData.getFromRatedVoltage() != null)
				fromRatedV = xfrData.getFromRatedVoltage().getValue();
			if (xfrData.getToRatedVoltage() != null)
				toRatedV = xfrData.getToRatedVoltage().getValue();

			if (xfrData != null &&
					!xfrData.isDataOnSystemBase() &&
					xfrData.getRatedPower() != null && 
					xfrData.getRatedPower().getValue() > 0.0) 
				zratio = xfrData.getRatedPower().getUnit() == ApparentPowerUnitType.KVA?
						adjNet.getBaseKva() / xfrData.getRatedPower().getValue() :
							0.001 * adjNet.getBaseKva() / xfrData.getRatedPower().getValue();

			if (!xfrData.isDataOnSystemBase())
				tapratio = (fromRatedV/fromBaseV) / (toRatedV/toBaseV) ;
		}
		
		double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
		XfrAdapter xfr = aclfBra.toXfr();
		xfr.setZ(new Complex(xfrBranch.getZ().getRe()*zratio, xfrBranch.getZ().getIm()*zratio),
				ODMXmlHelper.toUnit(xfrBranch.getZ().getUnit()), baseV,	msg);
		xfr.setFromTurnRatio(xfrBranch.getFromTurnRatio().getValue() == 0.0 ? 1.0 : 
				xfrBranch.getFromTurnRatio().getValue()*tapratio, UnitType.PU);
		xfr.setToTurnRatio(xfrBranch.getToTurnRatio().getValue() == 0.0 ? 1.0 : 
				xfrBranch.getToTurnRatio().getValue()/tapratio, UnitType.PU);
	}
}