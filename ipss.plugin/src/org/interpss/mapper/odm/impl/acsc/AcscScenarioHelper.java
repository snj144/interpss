/*
 * @(#)AcscScenarioHelper.java   
 *
 * Copyright (C) 2008-2010 www.interpss.org
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 09/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

/*
Key concepts:
	- Acsc Fault : defined using Fault Type (BusFault, BranchFault, BranchOutage) and Fault Category (3P, LG, LL, LLG)
*/

package org.interpss.mapper.odm.impl.acsc;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.model.base.BaseJaxbHelper;
import org.ieee.odm.schema.AcscFaultAnalysisXmlType;
import org.ieee.odm.schema.AcscFaultCategoryEnumType;
import org.ieee.odm.schema.AcscFaultTypeEnumType;
import org.ieee.odm.schema.AcscFaultXmlType;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.IpssStudyScenarioXmlType;
import org.ieee.odm.schema.PreFaultBusVoltageEnumType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.ZXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.exp.InterpssException;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.fault.AcscBranchFault;
import com.interpss.core.acsc.fault.AcscBusFault;
import com.interpss.core.acsc.fault.SimpleFaultCode;
import com.interpss.core.algo.ScBusVoltageType;
import com.interpss.core.algo.SimpleFaultAlgorithm;
import com.interpss.dstab.devent.BranchOutageType;

public class AcscScenarioHelper {
	private AcscNetwork acscFaultNet = null;
	SimpleFaultAlgorithm acscAglo = null;
	
	public AcscScenarioHelper(AcscNetwork acscFaultNet, SimpleFaultAlgorithm acscAglo) {
		this.acscFaultNet = acscFaultNet;
		this.acscAglo = acscAglo;
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
			if (scenario.getSimuAlgo() != null && scenario.getSimuAlgo().getAcscAnalysis() != null) {
				// then we check if simuAlgo and acscAnalysis info if defined
				AcscFaultAnalysisXmlType scAnalysisXml = scenario.getSimuAlgo().getAcscAnalysis();
				mapFault(scAnalysisXml);
				
				if (scAnalysisXml.getMultiFactor() != null && scAnalysisXml.getMultiFactor() != 0.0)
					this.acscAglo.setMultiFactor(scAnalysisXml.getMultiFactor() * 0.01);
				
				// algo.multiFactor in PU and acscData.getMFactor in %
				if (scAnalysisXml.getPreFaultBusVoltage() != null)
					this.acscAglo.setScBusVoltage(scAnalysisXml.getPreFaultBusVoltage() == 
						PreFaultBusVoltageEnumType.UNIT_VOLT ? 
										ScBusVoltageType.UNIT_VOLT : ScBusVoltageType.LOADFLOW_VOLT); // UnitV | LFVolt
			}
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
			String faultBusId = BaseJaxbHelper.getRecId(faultXml.getRefBusBranch());
			AcscBusFault acscBusFault = CoreObjectFactory.createAcscBusFault(faultBusId, acscFaultNet);
			acscAglo.addBusFault(faultBusId, idStr, acscBusFault);

			AcscBus bus = acscFaultNet.getAcscBus(faultBusId);
			double baseV=bus.getBaseVoltage();
			double baseKVA= bus.getNetwork().getBaseKva();

			setBusFaultInfo(faultXml, acscBusFault, baseV, baseKVA);
		}
		else if(faultXml.getFaultType()== AcscFaultTypeEnumType.BRANCH_FAULT){
			String faultBranchId = BaseJaxbHelper.getRecId(faultXml.getRefBusBranch());
			AcscBranchFault acscBraFault = CoreObjectFactory.createAcscBranchFault(faultBranchId, acscFaultNet);
			acscAglo.addBranchFault(faultBranchId, idStr, acscBraFault);

			AcscBranch acscBra = acscFaultNet.getAcscBranch(faultBranchId);
			double baseV = acscBra.getFromAclfBus().getBaseVoltage();
			double baseKVA= acscBra.getNetwork().getBaseKva();

			setBranchFaultInfo(faultXml, acscBraFault, baseV, baseKVA);
		}
		else if(faultXml.getFaultType()== AcscFaultTypeEnumType.BRANCH_OUTAGE){
			throw new InterpssException("Acsc branch outtage fault not implemented");
		}

	}
	
	public static void setBusFaultInfo(AcscFaultXmlType scFaultXml, AcscBusFault acscBusFault, double baseV, double baseKVA) {
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

	public static void setBranchFaultInfo(AcscFaultXmlType scFaultXml, AcscBranchFault acscBusFault, double baseV, double baseKVA) {
		// AcscBranchFault is a subclass of AcscBusFault
		setBusFaultInfo(scFaultXml, acscBusFault, baseV, baseKVA);
		// set fault distance
		double faultDis = scFaultXml.getDistance();
		acscBusFault.setDistance(faultDis);			
	}
	
	public static BranchOutageType getBranchOutageType(AcscFaultCategoryEnumType caty) {
		if (caty == AcscFaultCategoryEnumType.OUTAGE_1_PHASE)
			return BranchOutageType.SINGLE_PHASE;
		else if (caty == AcscFaultCategoryEnumType.OUTAGE_2_PHASE)
			return BranchOutageType.DOUBLE_PHASE;		
		return BranchOutageType.THREE_PHASE;
	}
}