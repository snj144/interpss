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
import org.ieee.odm.model.acsc.AcscModelParser;
import org.ieee.odm.schema.AcscFaultCategoryDataType;
import org.ieee.odm.schema.AcscFaultDataType;
import org.ieee.odm.schema.AcscFaultXmlType;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.AnalysisTypeXmlType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.GroundingEnumType;
import org.ieee.odm.schema.GroundingXmlType;
import org.ieee.odm.schema.LineShortCircuitXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfrShortCircuitXmlType;
import org.ieee.odm.schema.PreFaultBusVoltageType;
import org.ieee.odm.schema.ScSimpleBusXmlType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.ShortCircuitBusEnumType;
import org.ieee.odm.schema.ShortCircuitBusXmlType;
import org.ieee.odm.schema.ShortCircuitNetXmlType;
import org.ieee.odm.schema.XformerConnectionXmlType;
import org.ieee.odm.schema.XformrtConnectionEnumType;
import org.ieee.odm.schema.XfrShortCircuitXmlType;
import org.ieee.odm.schema.YXmlType;
import org.ieee.odm.schema.ZXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.AcscLineAdapter;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.AcscXfrAdapter;
import com.interpss.core.acsc.BusGroundCode;
import com.interpss.core.acsc.BusScCode;
import com.interpss.core.acsc.SequenceCode;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.acsc.XfrConnectCode;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ODMAcscDataMapperImpl {
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(AcscModelParser parser, SimuContext simuCtx) {
		boolean noError = true;

		if (parser.getAcscNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.SHORT_CIRCUIT) {
			// get the base net xml record from the parser object
			ShortCircuitNetXmlType xmlNet = parser.getAcscNet();
			try {
				// create a AcscFaultNetwork object and map the net info 
				SimpleFaultNetwork acscFaultNet =  CoreObjectFactory.createSimpleFaultNetwork();						
				simuCtx.setAcscFaultNet(acscFaultNet);
				simuCtx.setNetType(SimuCtxType.ACSC_FAULT_NET);

				mapNetworkData(acscFaultNet,xmlNet);

				// map the bus info
				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					// for short circuit, the bus could be acscBus or acscNoLFBus 
					AcscBus acscBus = CoreObjectFactory.createAcscBus(bus.getValue().getId(), acscFaultNet);		
					// add the acscBus object into acscNet and build bus <-> net relationship
					//acscNet.addBus(acscBus);
					if (bus.getValue() instanceof ShortCircuitBusXmlType) {
						// lf info included
						ShortCircuitBusXmlType acscBusXml = (ShortCircuitBusXmlType) bus.getValue();
						// map the base bus info part
						ODMNetDataMapperImpl.mapBaseBusData(acscBusXml, acscBus, acscFaultNet);
						// map the Aclf info part						
						ODMAclfDataMapperImpl.setAclfBusData(acscBusXml, acscBus, acscFaultNet);
						ODMAcscDataMapperImpl.setAcscBusData(acscBusXml, acscBus);
					} else if (bus.getValue() instanceof ScSimpleBusXmlType){
						// no loadflow info included
						ScSimpleBusXmlType acscBusXml = (ScSimpleBusXmlType) bus.getValue();
						// map the base bus info part
						ODMNetDataMapperImpl.mapBaseBusData(acscBusXml, acscBus, acscFaultNet);
						ODMAcscDataMapperImpl.setAcscBusNoLFData(acscBusXml, acscBus);
					}
					else {
						IpssLogger.getLogger().severe( "Error: only scscBus and pss:acscNoLFBus could be used for DStab study");
						noError = false;
					}
				}

				// map the branch info
				for (JAXBElement<? extends BaseBranchXmlType> branch : xmlNet.getBranchList().getBranch()) {
					if (branch.getValue() instanceof LineShortCircuitXmlType || 
							branch.getValue() instanceof XfrShortCircuitXmlType ||
							branch.getValue() instanceof PSXfrShortCircuitXmlType) {
						AcscBranch acscBranch = CoreObjectFactory.createAcscBranch();
						BranchXmlType acscBraXml = (BranchXmlType)branch.getValue();
						// the branch is added into acscNet in the mapAclfBranchData() method
						ODMAclfDataMapperImpl.mapAclfBranchData(branch.getValue(), acscBranch, acscFaultNet, simuCtx.getMsgHub());
						ODMAcscDataMapperImpl.setAcscBranchData(acscBraXml, acscBranch, simuCtx.getMsgHub());
					}
					else {
						IpssLogger.getLogger().severe( "Error: only acsc<Branch> could be used for SC study");
						noError = false;
					}
				}		
				
				// map the fault network information
				if(parser.getStudyCase().getScenarioList()!=null){
					for (ScenarioXmlType scenario : parser.getStudyCase().getScenarioList().getScenario()) {
						mapAcscFaultNetwork(scenario, acscFaultNet);
					}
				}
			} catch (InterpssException e) {
				IpssLogger.getLogger().severe(e.toString());
				e.printStackTrace();
				noError = false;
			}
		} 
		else {
			IpssLogger.getLogger().severe( "Error: wrong Transmission NetworkType and/or ApplicationType");
			return false;
		}

		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getAcscFaultNet().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}

	/**
	 * Map the network info only
	 * 
	 * @param xmlNet
	 * @return
	 */
	public static void mapNetworkData(AcscNetwork net, ShortCircuitNetXmlType xmlNet) {
		ODMAclfDataMapperImpl.mapNetworkData(net, xmlNet);
		net.setPositiveSeqDataOnly(xmlNet.isPositiveSeqDataOnly());		
	}	

	/**
	 * Set SC bus info only
	 * 
	 * @param acscBusXml
	 * @param acscBus
	 */
	public static void setAcscBusData(ShortCircuitBusXmlType acscBusXml, AcscBus acscBus) throws InterpssException {
		if (acscBusXml.getScCode() == ShortCircuitBusEnumType.CONTRIBUTING) {
			setContributeBusInfo(acscBusXml, acscBus);
		} else { // non-contributing
			setNonContributeBusFormInfo(acscBus);
		} 
	}

	public static void setAcscBusNoLFData(ScSimpleBusXmlType acscBusXml, AcscBus acscBus) throws InterpssException {
		if (acscBusXml.getScCode() == ShortCircuitBusEnumType.CONTRIBUTING) {
			setContributeBusNoLFInfo(acscBusXml, acscBus);
		} else { // non-contributing
			setNonContributeBusFormInfo(acscBus);
		} 
	}

	private static void setNonContributeBusFormInfo(AcscBus acscBus) {
		acscBus.setScCode(BusScCode.NON_CONTRI);
		acscBus.setZ(Constants.LargeBusZ, SequenceCode.POSITIVE);
		acscBus.setZ(Constants.LargeBusZ, SequenceCode.NEGATIVE);
		acscBus.setZ(Constants.LargeBusZ, SequenceCode.ZERO);
		acscBus.getGrounding().setCode(BusGroundCode.UNGROUNDED);
		acscBus.getGrounding().setZ(Constants.LargeBusZ);
	}

	private static void setContributeBusInfo(ShortCircuitBusXmlType busData, AcscBus acscBus) {
		acscBus.setScCode(BusScCode.CONTRIBUTE);
		if (busData.getScGenData() != null) {
			setBusScZ(acscBus, acscBus.getNetwork().getBaseKva(), 
					busData.getScGenData().getPotiveZ(),
					busData.getScGenData().getNegativeZ(),
					busData.getScGenData().getZeroZ());
			setBusScZg(acscBus, acscBus.getBaseVoltage(), acscBus.getNetwork().getBaseKva(), 
					busData.getScGenData().getGrounding());
		}
	}

	private static void setContributeBusNoLFInfo(ScSimpleBusXmlType busData, AcscBus acscBus) {
		acscBus.setScCode(BusScCode.CONTRIBUTE);
		if (busData.getScGenData() != null) {
			setBusScZ(acscBus, acscBus.getNetwork().getBaseKva(), 
					busData.getScGenData().getPotiveZ(),
					busData.getScGenData().getNegativeZ(),
					busData.getScGenData().getZeroZ());
			if(busData.getScGenData().getGrounding() != null){
				setBusScZg(acscBus, acscBus.getBaseVoltage(), acscBus.getNetwork().getBaseKva(), 
						busData.getScGenData().getGrounding());
			}

		}
	}

	private static void setBusScZ(AcscBus bus, double baseKVA, 
			ZXmlType z1, ZXmlType z2, ZXmlType z0) {
		byte zUnit = ODMXmlHelper.toUnit(z1.getUnit());
		bus.setZ(new Complex(z1.getRe(), z1.getIm()), SequenceCode.POSITIVE, zUnit);
		bus.setZ(new Complex(z2.getRe(), z2.getIm()), SequenceCode.NEGATIVE, zUnit);
		bus.setZ(new Complex(z0.getRe(), z0.getIm()), SequenceCode.ZERO, zUnit);
	}

	private static void setBusScZg(AcscBus bus, double baseV, double baseKVA, GroundingXmlType g) {
		ZXmlType z = g.getGroundZ();
		bus.getGrounding().setCode(ODMXmlHelper.toBusGroundCode(g.getConnection()));
		if(z != null){
			byte zgUnit = ODMXmlHelper.toUnit(z.getUnit());			
			bus.getGrounding().setZ(new Complex(z.getRe(), z.getIm()), zgUnit, baseV, baseKVA);
		}
	}

	/**
	 * Set SC branch info only
	 * 
	 * @param acscBraXml
	 * @param acscBra
	 * @param msg
	 * @return
	 */
	public static void setAcscBranchData(BranchXmlType acscBraXml, AcscBranch acscBra, IPSSMsgHub msg) {

		if (acscBraXml instanceof LineShortCircuitXmlType) { // line branch
			setAcscLineFormInfo((LineShortCircuitXmlType)acscBraXml, acscBra, msg);
		} 
		else if ( acscBraXml instanceof XfrShortCircuitXmlType ||
				acscBraXml instanceof PSXfrShortCircuitXmlType) { // xfr or psxfr branch
			setAcscXfrFormInfo((XfrShortCircuitXmlType)acscBraXml, acscBra, msg);
		}
	}

	private static void setAcscLineFormInfo(LineShortCircuitXmlType braXml,	AcscBranch acscBra, IPSSMsgHub msg) {
		double baseV = acscBra.getFromAclfBus().getBaseVoltage();
		AcscLineAdapter line = (AcscLineAdapter) acscBra.getAdapter(AcscLineAdapter.class);
		ZXmlType z0 = braXml.getZ0();
		if (z0 != null)
			line.setZ0(new Complex(z0.getRe(), z0.getIm()),	ODMXmlHelper.toUnit(z0.getUnit()), baseV, msg);
		YXmlType y0 = braXml.getY0Shunt();
		if (y0 != null)
			line.setHB0(0.5*y0.getIm(), ODMXmlHelper.toUnit(y0.getUnit()), baseV);
	}

	// for SC, Xfr and PSXfr behave the same
	private static void setAcscXfrFormInfo(XfrShortCircuitXmlType braXml, AcscBranch acscBra, IPSSMsgHub msg) {
		double baseV = acscBra.getFromAclfBus().getBaseVoltage() > acscBra
		.getToAclfBus().getBaseVoltage() ? acscBra.getFromAclfBus()
				.getBaseVoltage() : acscBra.getToAclfBus().getBaseVoltage();
				AcscXfrAdapter xfr = (AcscXfrAdapter) acscBra.getAdapter(AcscXfrAdapter.class);
				ZXmlType z0 = braXml.getZ0();
				if (z0 != null)
					xfr.setZ0(new Complex(z0.getRe(), z0.getIm()), ODMXmlHelper.toUnit(z0.getUnit()), baseV, msg);

				XformerConnectionXmlType connect = braXml.getFromSideConnection();
				if(connect != null){
					XfrConnectCode conCode=calXfrConnectCode(connect);
					acscBra.setXfrFromConnectCode(conCode);
					if(connect.getGrounding() != null){
						ZXmlType z = connect.getGrounding().getGroundZ();
						if (z != null) 
							xfr.setFromConnectGroundZ(calXfrConnectCode(connect), new Complex(z.getRe(), z.getIm()),
									ODMXmlHelper.toUnit(z.getUnit()));
					}
				}				

				connect = braXml.getToSideConnection();
				if(connect != null){
					XfrConnectCode conCode=calXfrConnectCode(connect);
					acscBra.setXfrToConnectCode(conCode);
					if(connect.getGrounding() != null){
						ZXmlType z = connect.getGrounding().getGroundZ();
						if (z != null) 
							xfr.setFromConnectGroundZ(calXfrConnectCode(connect), new Complex(z.getRe(), z.getIm()),
									ODMXmlHelper.toUnit(z.getUnit()));
					}
				}	
	}

	private static XfrConnectCode calXfrConnectCode(XformerConnectionXmlType connect) {
		// connectCode : [Delta | Wye]
		// groundCode : [SolidGrounded | ZGrounded | Ungrounded ]
		if (connect.getConnection() == XformrtConnectionEnumType.DELTA)
			return XfrConnectCode.DELTA;
		else {  // Wye connection
			if (connect.getGrounding().getConnection() == GroundingEnumType.SOLID_GROUNDED)
				return XfrConnectCode.WYE_SOLID_GROUNDED;
			else if (connect.getGrounding().getConnection() == GroundingEnumType.Z_GROUNDED)
				return XfrConnectCode.WYE_ZGROUNDED;
			else 
				return XfrConnectCode.WYE_UNGROUNDED;
		}
	}
	
	private static void mapAcscFaultNetwork( ScenarioXmlType faultXml,	SimpleFaultNetwork acscFaultNet){
		//acscFaultNet.set.setAnalysisCategory(AnalysisCategoryEnumType.SHORT_CIRCUIT);
		AnalysisTypeXmlType faultAnalysisXml= faultXml.getAnalysisType();		
		AcscFaultXmlType scFaultXml = faultAnalysisXml.getAcscAnalysis();
		
		String idStr = scFaultXml.getName() != null? scFaultXml.getName() : scFaultXml.getDesc(); 
		
		if(scFaultXml.getFaultType()== AcscFaultDataType.BUS_FAULT){			
			String faultBusId=((BusXmlType)scFaultXml.getBusBranchId().getIdRef()).getId();
			AcscBusFault acscBusFault = CoreObjectFactory.createAcscBusFault(faultBusId);
			AcscBus bus = acscFaultNet.getAcscBus(faultBusId);
			double baseV=bus.getBaseVoltage();
			double baseKVA= bus.getNetwork().getBaseKva();
			// set fault type
			AcscFaultCategoryDataType faultCate = scFaultXml.getFaultCategory();
			if(faultCate.equals(AcscFaultCategoryDataType.FAULT_3_P)){
				acscBusFault.setFaultCode(SimpleFaultCode.GROUND_3P);
			}else if (faultCate.equals(AcscFaultCategoryDataType.FAULT_LG)){
				acscBusFault.setFaultCode(SimpleFaultCode.GROUND_LG);
			}else if (faultCate.equals(AcscFaultCategoryDataType.FAULT_LL)){
				acscBusFault.setFaultCode(SimpleFaultCode.GROUND_LL);
			}else if (faultCate.equals(AcscFaultCategoryDataType.FAULT_LLG)){
				acscBusFault.setFaultCode(SimpleFaultCode.GROUND_LLG);
			}
			// set zLG and zLL
			ZXmlType zLG= scFaultXml.getZLG();
			ZXmlType zLL= scFaultXml.getZLL();			
			if(zLG!=null){
				acscBusFault.setZLGFault(new Complex(zLG.getRe(), zLG.getIm()), 
						ODMXmlHelper.toUnit(zLG.getUnit()), baseV, baseKVA);
			}
			if(zLL!=null){
				acscBusFault.setZLLFault(new Complex(zLL.getRe(), zLL.getIm()), 
						ODMXmlHelper.toUnit(zLL.getUnit()), baseV, baseKVA);
			}	
			
			acscFaultNet.addBusFault(faultBusId, idStr, acscBusFault);
			// set pre fault bus voltage type-- load flow, fixed or Mfactor%
			PreFaultBusVoltageType preFaultV = scFaultXml.getPreFaultBusVoltage();
			if(preFaultV.equals(PreFaultBusVoltageType.LOADFLOW)){
				
				
			}else if (preFaultV.equals(PreFaultBusVoltageType.FIXED)){
				
				
			}else if (preFaultV.equals(PreFaultBusVoltageType.M_FACTOR_IN_PERCENTAGE)){
				
				
			}
		}
		else if(scFaultXml.getFaultType()== AcscFaultDataType.BRANCH_FAULT){
			String faultBranchId=((BaseBranchXmlType)scFaultXml.getBusBranchId().getIdRef()).getId();
			AcscBranchFault acscBraFault = CoreObjectFactory.createAcscBranchFault(faultBranchId);
			AcscBranch acscBra = acscFaultNet.getAcscBranch(faultBranchId);
			double baseV = acscBra.getFromAclfBus().getBaseVoltage();
			double baseKVA= acscBra.getNetwork().getBaseKva();
			// set fault type
			AcscFaultCategoryDataType faultCate = scFaultXml.getFaultCategory();
			if(faultCate.equals(AcscFaultCategoryDataType.FAULT_3_P)){
				acscBraFault.setFaultCode(SimpleFaultCode.GROUND_3P);
			}else if (faultCate.equals(AcscFaultCategoryDataType.FAULT_LG)){
				acscBraFault.setFaultCode(SimpleFaultCode.GROUND_LG);
			}else if (faultCate.equals(AcscFaultCategoryDataType.FAULT_LL)){
				acscBraFault.setFaultCode(SimpleFaultCode.GROUND_LL);
			}else if (faultCate.equals(AcscFaultCategoryDataType.FAULT_LLG)){
				acscBraFault.setFaultCode(SimpleFaultCode.GROUND_LLG);
			}
			// set zLG and zLL
			ZXmlType zLG= scFaultXml.getZLG();
			ZXmlType zLL= scFaultXml.getZLL();			
			if(zLG!=null){
				acscBraFault.setZLGFault(new Complex(zLG.getRe(), zLG.getIm()), 
						ODMXmlHelper.toUnit(zLG.getUnit()), baseV, baseKVA);
			}
			if(zLL!=null){
				acscBraFault.setZLLFault(new Complex(zLL.getRe(), zLL.getIm()), 
						ODMXmlHelper.toUnit(zLL.getUnit()), baseV, baseKVA);
			}
			// set fault distance
			double faultDis = scFaultXml.getDistance();
			acscBraFault.setDistance(faultDis);			
			
			acscFaultNet.addBusFault(faultBranchId, idStr, acscBraFault);
			
			// set pre fault bus voltage type-- load flow, fixed or Mfactor%
			PreFaultBusVoltageType preFaultV = scFaultXml.getPreFaultBusVoltage();
			if(preFaultV.equals(PreFaultBusVoltageType.LOADFLOW)){
				
				
			}else if (preFaultV.equals(PreFaultBusVoltageType.FIXED)){
				
				
			}else if (preFaultV.equals(PreFaultBusVoltageType.M_FACTOR_IN_PERCENTAGE)){
				
				
			}
			
		}
		
	}
}