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
 * @Author Stephen Hau
 * @Version 1.0
 * @Date 09/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.schema.AcscFaultCategoryDataType;
import org.ieee.odm.schema.AcscFaultDataType;
import org.ieee.odm.schema.AcscFaultXmlType;
import org.ieee.odm.schema.AnalysisTypeXmlType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.PreFaultBusVoltageType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.ZXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;

public class AcscScenarioHelper {
	private SimpleFaultNetwork acscFaultNet = null;
	
	public AcscScenarioHelper(SimpleFaultNetwork acscFaultNet) {
		this.acscFaultNet = acscFaultNet;
	}
	
	public void mapAcscFaultNetwork( ScenarioXmlType faultXml){
		AnalysisTypeXmlType faultAnalysisXml= faultXml.getAnalysisType();		
		AcscFaultXmlType scFaultXml = faultAnalysisXml.getAcscAnalysis();
		
		String idStr = scFaultXml.getName() != null? scFaultXml.getName() : scFaultXml.getDesc(); 
		
		if(scFaultXml.getFaultType()== AcscFaultDataType.BUS_FAULT){			
			String faultBusId=((BusXmlType)scFaultXml.getBusBranchId().getIdRef()).getId();
			AcscBusFault acscBusFault = CoreObjectFactory.createAcscBusFault(faultBusId);
			AcscBus bus = acscFaultNet.getAcscBus(faultBusId);
			double baseV=bus.getBaseVoltage();
			double baseKVA= bus.getNetwork().getBaseKva();

			setFaultInfo(scFaultXml, acscBusFault, baseV, baseKVA);
			
			acscFaultNet.addBusFault(faultBusId, idStr, acscBusFault);

			processPreFaultInfo(scFaultXml);
		}
		else if(scFaultXml.getFaultType()== AcscFaultDataType.BRANCH_FAULT){
			String faultBranchId=((BaseBranchXmlType)scFaultXml.getBusBranchId().getIdRef()).getId();
			AcscBranchFault acscBraFault = CoreObjectFactory.createAcscBranchFault(faultBranchId);
			AcscBranch acscBra = acscFaultNet.getAcscBranch(faultBranchId);
			double baseV = acscBra.getFromAclfBus().getBaseVoltage();
			double baseKVA= acscBra.getNetwork().getBaseKva();

			// AcscBranchFault is a subclass of AcscBusFault
			setFaultInfo(scFaultXml, acscBraFault, baseV, baseKVA);
			// set fault distance
			double faultDis = scFaultXml.getDistance();
			acscBraFault.setDistance(faultDis);			
			
			acscFaultNet.addBranchFault(faultBranchId, idStr, acscBraFault);
			
			processPreFaultInfo(scFaultXml);
		}
	}
	
	private void setFaultInfo(AcscFaultXmlType scFaultXml, AcscBusFault acscBusFault, double baseV, double baseKVA) {
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
	}
	
	private void processPreFaultInfo(AcscFaultXmlType scFaultXml) {
		// set pre fault bus voltage type-- load flow, fixed or Mfactor%
		PreFaultBusVoltageType preFaultV = scFaultXml.getPreFaultBusVoltage();
		if(preFaultV.equals(PreFaultBusVoltageType.LOADFLOW)){
			
			
		}else if (preFaultV.equals(PreFaultBusVoltageType.FIXED)){
			
			
		}else if (preFaultV.equals(PreFaultBusVoltageType.M_FACTOR_IN_PERCENTAGE)){
			
			
		}
	}
}