 /*
  * @(#)RunForm2AlgorithmMapper.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.mapper;

import org.interpss.editor.runAct.AclfRunForm;
import org.interpss.editor.runAct.AcscRunForm;
import org.interpss.editor.runAct.DStabRunForm;
import org.interpss.mapper.runCase.CaseData2AlgorithmMapperImpl;
import org.interpss.mapper.runCase.Xml2AlgorithmMapperImpl;
import org.interpss.mapper.runCase.Xml2DStabAlgorithmMapperImpl;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.RunAcscStudyCaseXmlType;
import org.interpss.schema.RunDStabStudyCaseXmlType;

import com.interpss.common.mapper.AbstractMapper;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.dstab.DynamicSimuAlgorithm;

public class RunForm2AlgorithmMapper extends AbstractMapper {

	public RunForm2AlgorithmMapper() {
	}

	/**
	 * map(load) a <*>RunForm object into an Algorithm object
	 * 
	 * @param fromObj a <*>RunForm object
	 * @param toObj an Algorithm object
	 * @param kclass class type of the toObj 
	 */	
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		if (klass == LoadflowAlgorithm.class) {
			AclfRunForm runForm = (AclfRunForm)fromObj;
	  		LoadflowAlgorithm algo = (LoadflowAlgorithm)toObj;
			CaseData2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(runForm.getAclfCaseData(), algo);
		}
		else if (klass == SimpleFaultAlgorithm.class) {
			AcscRunForm runForm = (AcscRunForm)fromObj;
			SimpleFaultAlgorithm algo = (SimpleFaultAlgorithm)toObj;
			return CaseData2AlgorithmMapperImpl.acscCaseData2AlgoMapping(runForm.getAcscCaseData(), algo);
		}
		else if (klass == DynamicSimuAlgorithm.class) {
			DStabRunForm runForm = (DStabRunForm)fromObj;
			DynamicSimuAlgorithm algo = (DynamicSimuAlgorithm)toObj;
			return CaseData2AlgorithmMapperImpl.dstabCaseData2AlgoMapping(
					runForm.getDStabCaseData(), runForm.getAclfCaseData(), algo, msg);
		}
		else if (klass == RunAclfStudyCaseXmlType.class) {
			// map an AclfStudyCase xml record to an LoadflowAlgorithm object
		  	Xml2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(
		  			(RunAclfStudyCaseXmlType)fromObj, (LoadflowAlgorithm)toObj);
		}
		else if (klass == RunAcscStudyCaseXmlType.class) {
			// map an AcscStudyCase xml record to an LoadflowAlgorithm object
		  	return Xml2AlgorithmMapperImpl.acscCaseData2AlgoMapping(
		  			(RunAcscStudyCaseXmlType)fromObj, (SimpleFaultAlgorithm)toObj);
		}
		else if (klass == RunDStabStudyCaseXmlType.class) {
			// map a DStabStudyCase xml record to an LoadflowAlgorithm object
		  	return Xml2DStabAlgorithmMapperImpl.dstabCaseData2AlgoMapping(
		  			(RunDStabStudyCaseXmlType)fromObj, (DynamicSimuAlgorithm)toObj, msg);
		}
		return true;
	}
}
