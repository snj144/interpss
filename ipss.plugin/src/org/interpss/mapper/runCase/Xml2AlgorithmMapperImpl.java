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

import org.interpss.core.adapter.IpssXmlAdapter;
import org.interpss.core.adapter.XmlNetParamModifier;
import org.interpss.schema.AclfMethodXmlData;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.UnitXmlData;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class Xml2AlgorithmMapperImpl {
	/**
	 * Map AclfCaseData to a LoadflowAlgorithm object. Modifications defined inside the study case
	 * also applied to the AclfNetwork object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static boolean aclfCaseData2AlgoMapping(RunAclfStudyCaseXmlType caseData, LoadflowAlgorithm algo) {
	  	algo.setLfMethod(caseData.getLfMethod()==AclfMethodXmlData.NR? AclfMethod.NR :
	  				       (caseData.getLfMethod()==AclfMethodXmlData.PQ? AclfMethod.PQ : 
	  				    	   AclfMethod.GS));
	  	algo.setMaxIterations(caseData.getMaxIterations());
  		double e = caseData.getTolerance();
	  	if (caseData.getToleranceUnit() != UnitXmlData.PU) {
	  		byte unit = IpssXmlAdapter.mapXmlUnitType2IpssUnitType(caseData.getToleranceUnit());
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
	  	return true;
	}
}