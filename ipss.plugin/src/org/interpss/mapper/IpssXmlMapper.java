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

package org.interpss.mapper;

import org.interpss.mapper.runCase.Xml2AlgorithmMapperImpl;
import org.interpss.mapper.runCase.Xml2DStabAlgorithmMapperImpl;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AcscStudyCaseXmlType;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunAcscStudyCase.AcscStudyCaseList.AcscStudyCaseRec;
import org.interpss.xml.XmlNetParamModifier;

import com.interpss.common.mapper.AbstractMapper;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.net.Network;
import com.interpss.dstab.DynamicSimuAlgorithm;

public class IpssXmlMapper extends AbstractMapper {

	public IpssXmlMapper() {
	}

	/**
	 * map info store in the fromObj to the toObj
	 * 
	 * @param fromObj the fromObj object
	 * @param toObj the to object
	 * @param kclass class type, used to determine mapping details 
	 */
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		if (klass == AclfAlgorithmXmlType.class) {
			// map an AclfAlgorithmXmlType xml record to an LoadflowAlgorithm object
			Xml2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(
					(AclfAlgorithmXmlType) fromObj,
					(LoadflowAlgorithm) toObj, msg);
		} else if (klass == AcscStudyCaseXmlType.class) {
			/*
			 * map an AcscStudyCase xml record to an LoadflowAlgorithm object
			 */
			AcscStudyCaseRec caseRec = (AcscStudyCaseRec)fromObj;
			String faultIdStr = caseRec.getRecId();
			return Xml2AlgorithmMapperImpl.acscCaseData2AlgoMapping(
					caseRec.getAcscStudyCase(),
					(SimpleFaultAlgorithm) toObj, 
					faultIdStr, msg);
		} else if (klass == DStabStudyCaseXmlType.class) {
			/*
			 * map a DStabStudyCase xml record (fromObj) to an LoadflowAlgorithm object (toObj)
			 */
			return Xml2DStabAlgorithmMapperImpl.dstabCaseData2AlgoMapping(
					(DStabStudyCaseXmlType) fromObj,
					(DynamicSimuAlgorithm) toObj, msg);

		} else if (klass == ModificationXmlType.class) {
			/*
			 * Apply the modification (fromObj) info to the Network object (toObj) 
			 */ 
			XmlNetParamModifier.applyModification(
				(Network) toObj, 
				(ModificationXmlType) fromObj, msg);
		}
		return true;
	}
}
