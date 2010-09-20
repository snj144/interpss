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

package org.interpss.mapper.odm.impl.acsc;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.schema.AcscFaultAnalysisXmlType;
import org.ieee.odm.schema.AcscFaultCategoryEnumType;
import org.ieee.odm.schema.AcscFaultTypeEnumType;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.IpssStudyScenarioXmlType;
import org.ieee.odm.schema.PreFaultBusVoltageEnumType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.ZXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;
import org.ieee.odm.schema.AcscFaultXmlType;

import com.interpss.common.exp.InterpssException;
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

	/**
	 * This method assumes there is only one acsc analysis scenario defined
	 * 
	 * @param faultXml
	 */
	public void mapOneFaultScenario( IpssStudyScenarioXmlType sScenarioXml) throws InterpssException {
		if(sScenarioXml.getAnalysisCategory() == AnalysisCategoryEnumType.SHORT_CIRCUIT &&
				sScenarioXml.getScenarioList().getScenario() != null &&
				sScenarioXml.getScenarioList().getScenario().size() == 1){
			// first we check if acsc analysis type, scenario is defined and only one scenario 
			// is defined
			ScenarioXmlType scenario = sScenarioXml.getScenarioList().getScenario().get(0);
			if (scenario.getSimuAlgo() != null && scenario.getSimuAlgo().getAcscAnalysis() != null)
				// then we check if simuAlgo and acscAnalysis info if defined
				mapFault(scenario.getSimuAlgo().getAcscAnalysis());
			else
				throw new InterpssException("Acsc Scenario mapping error: data not defined properly");
		}
		else {
			throw new InterpssException("Acsc StudyScenario mapping error: data not defined properly");
		}
	}

	private void mapFault(AcscFaultAnalysisXmlType scAnalysisXml) throws InterpssException {
		String idStr = scAnalysisXml.getName() != null? scAnalysisXml.getName() : scAnalysisXml.getDesc(); 

		if (scAnalysisXml.getFault() == null)
			throw new InterpssException("acscAnalysis.fault not defined");
		
		AcscFaultXmlType faultXml = scAnalysisXml.getFault();
		if(faultXml.getFaultType() == AcscFaultTypeEnumType.BUS_FAULT){			
			String faultBusId=((BusXmlType)faultXml.getBusBranchId().getIdRef()).getId();
			AcscBusFault acscBusFault = CoreObjectFactory.createAcscBusFault(faultBusId);
			AcscBus bus = acscFaultNet.getAcscBus(faultBusId);
			double baseV=bus.getBaseVoltage();
			double baseKVA= bus.getNetwork().getBaseKva();

			setFaultInfo(faultXml, acscBusFault, baseV, baseKVA);

			acscFaultNet.addBusFault(faultBusId, idStr, acscBusFault);

			processPreFaultInfo(scAnalysisXml);
		}
		else if(faultXml.getFaultType()== AcscFaultTypeEnumType.BRANCH_FAULT){
			String faultBranchId=((BaseBranchXmlType)faultXml.getBusBranchId().getIdRef()).getId();
			AcscBranchFault acscBraFault = CoreObjectFactory.createAcscBranchFault(faultBranchId);
			AcscBranch acscBra = acscFaultNet.getAcscBranch(faultBranchId);
			double baseV = acscBra.getFromAclfBus().getBaseVoltage();
			double baseKVA= acscBra.getNetwork().getBaseKva();

			// AcscBranchFault is a subclass of AcscBusFault
			setFaultInfo(faultXml, acscBraFault, baseV, baseKVA);
			// set fault distance
			double faultDis = faultXml.getDistance();
			acscBraFault.setDistance(faultDis);			

			acscFaultNet.addBranchFault(faultBranchId, idStr, acscBraFault);

			processPreFaultInfo(scAnalysisXml);
		}

	}
	private void setFaultInfo(AcscFaultXmlType scFaultXml, AcscBusFault acscBusFault, double baseV, double baseKVA) {
		// set fault type
		AcscFaultCategoryEnumType faultCate = scFaultXml.getFaultCategory();
		if(faultCate.equals(AcscFaultCategoryEnumType.FAULT_3_PHASE)){
			acscBusFault.setFaultCode(SimpleFaultCode.GROUND_3P);
		}else if (faultCate.equals(AcscFaultCategoryEnumType.LINE_TO_GROUND)){
			acscBusFault.setFaultCode(SimpleFaultCode.GROUND_LG);
		}else if (faultCate.equals(AcscFaultCategoryEnumType.LINE_TO_LINE)){
			acscBusFault.setFaultCode(SimpleFaultCode.GROUND_LL);
		}else if (faultCate.equals(AcscFaultCategoryEnumType.LINE_LINE_TO_GROUND)){
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

	private void processPreFaultInfo(AcscFaultAnalysisXmlType scFaultXml) {
		// set pre fault bus voltage type-- load flow, fixed or Mfactor%
		PreFaultBusVoltageEnumType preFaultV = scFaultXml.getPreFaultBusVoltage();
		if(preFaultV !=null){
			if(preFaultV.equals(PreFaultBusVoltageEnumType.LOADFLOW)){
				//(TODO:)

			}else if (preFaultV.equals(PreFaultBusVoltageEnumType.FIXED)){
				//(TODO:)

			}else if (preFaultV.equals(PreFaultBusVoltageEnumType.M_FACTOR_IN_PERCENTAGE)){
				//(TODO:)

			}
		}

	}
}