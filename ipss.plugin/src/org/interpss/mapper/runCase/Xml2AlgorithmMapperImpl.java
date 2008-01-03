 /*
  * @(#)Xml2AlgorithmMapperImpl.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.mapper.runCase;

import org.apache.commons.math.complex.Complex;
import org.interpss.schema.AclfMethodXmlData;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.FaultCategoryXmlData;
import org.interpss.schema.FaultTypeXmlData;
import org.interpss.schema.FaultVoltInitXmlData;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.RunAcscStudyCaseXmlType;
import org.interpss.schema.UnitXmlData;
import org.interpss.xml.IpssXmlParser;
import org.interpss.xml.XmlNetParamModifier;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.ScBusVoltage;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;

public class Xml2AlgorithmMapperImpl {
	/**
	 * Map RunAclfStudyCaseXmlType object to a LoadflowAlgorithm object. Modifications defined inside the study case
	 * also applied to the AclfNetwork object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static void aclfCaseData2AlgoMapping(RunAclfStudyCaseXmlType caseData, LoadflowAlgorithm algo) {
	  	algo.setLfMethod(caseData.getLfMethod()==AclfMethodXmlData.NR? AclfMethod.NR :
	  				       (caseData.getLfMethod()==AclfMethodXmlData.PQ? AclfMethod.PQ : 
	  				    	   AclfMethod.GS));
	  	algo.setMaxIterations(caseData.getMaxIterations());
  		double e = caseData.getTolerance();
	  	if (caseData.getToleranceUnit() != null && caseData.getToleranceUnit() != UnitXmlData.PU) {
	  		byte unit = IpssXmlParser.mapXmlUnitType2IpssUnitType(caseData.getToleranceUnit());
	  		e = UnitType.pConversion(e, algo.getAclfNetwork().getBaseKva(), unit, UnitType.PU);
	  	}
  		algo.setTolerance(e);
	  	algo.setInitBusVoltage(caseData.getInitBusVoltage());
	  	algo.setAdjustChangeStep(caseData.getAdjustChangeStep());
	  	if (caseData.getAccFactor() != 0.0 && algo.getLfMethod() == AclfMethod.GS)	
	  		algo.setGsAccFactor(caseData.getAccFactor());
	  	
	  	if (caseData.getModification() != null) {
	  		// apply the enclosed modification record to the AclfNet object
	  		ModificationXmlType mod = caseData.getModification();
	  		XmlNetParamModifier.applyModification2Net(algo.getAclfNetwork(), mod);
	  	}
	}

	/**
	 * Map RunAcscStudyCaseXmlType object to a SimpleFaultAlgorithm object. Modifications defined inside the study case
	 * also applied to the SimpleFaultNetwork object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static boolean acscCaseData2AlgoMapping(RunAcscStudyCaseXmlType caseData, SimpleFaultAlgorithm algo) {
		SimpleFaultNetwork faultNet = algo.getSimpleFaultNetwork();
		String faultIdStr = caseData.getRecId();
		if (caseData.getFaultData().getType() == FaultTypeXmlData.BUS_FAULT) {
	  		AcscBus faultBus = (AcscBus)faultNet.getBus(caseData.getFaultData().getBusBranchId());
			if (faultBus == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found");
	  			return false;
	  		}
			
			AcscBusFault fault = CoreObjectFactory.createAcscBusFault(Constants.Token_BusFaultId +	faultBus.getId());
  	  		acscFaultData2AcscBusFaultMapping(caseData.getFaultData(), fault);
			faultNet.addBusFault(faultBus.getId(), faultIdStr, fault);
		}
		else {
	  		AcscBranch faultBranch = (AcscBranch)faultNet.getBranch(caseData.getFaultData().getBusBranchId()+Constants.Token_DefaultBranchCirNo);
			if (faultBranch == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found, this maybe a parallel branch issue");
	  			return false;
	  		}
			
			AcscBranchFault fault = CoreObjectFactory.createAcscBranchFault(Constants.Token_BranchFaultId + faultBranch.getId());
  	  		acscFaultData2AcscBranchFaultMapping(caseData.getFaultData(), fault);
			faultNet.addBranchFault(faultBranch.getId(), faultIdStr, fault);
		}
		
  	  	if (caseData.getMultiFactor() != 0.0)
  	  		algo.setMultiFactor(caseData.getMultiFactor()*0.01);
		// algo.multiFactor in PU and acscData.getMFactor in %
		if (caseData.getBusInitVolt() != null)
			algo.setScBusVoltage(caseData.getBusInitVolt() == FaultVoltInitXmlData.UNIT_VOLT?
						ScBusVoltage.UNIT_VOLT : ScBusVoltage.LOADFLOW_VOLT); // UnitV | LFVolt
		return true;
	}
	
	/**
	 * Acsc bus fault xml data to AcscBusFault object mapping
	 * 
	 * @param data
	 * @param fault
	 */
	public static void acscFaultData2AcscBusFaultMapping(AcscFaultXmlType data, AcscBusFault fault) {
		fault.setFaultCode(data.getCategory() == FaultCategoryXmlData.FAULT_LLG? SimpleFaultCode.GROUND_LLG :
							(data.getCategory() == FaultCategoryXmlData.FAULT_LG? SimpleFaultCode.GROUND_LG :
								(data.getCategory() == FaultCategoryXmlData.FAULT_LL? SimpleFaultCode.GROUND_LL :
									SimpleFaultCode.GROUND_3P)));
		if (data.getZLG() != null)
			fault.setZLGFault(new Complex(data.getZLG().getRe(), data.getZLG().getIm()));
		if (data.getZLL() != null)
			fault.setZLLFault(new Complex(data.getZLL().getRe(), data.getZLL().getIm())); 
	}
	
	/**
	 * Acsc branch fault xml data to AcscBranchFault object mapping
	 * 
	 * @param data
	 * @param fault
	 */
	public static void acscFaultData2AcscBranchFaultMapping(AcscFaultXmlType data, AcscBranchFault fault) {
		acscFaultData2AcscBusFaultMapping(data, fault);
		fault.setDistance(data.getDistance(), UnitType.Percent);
	}
}