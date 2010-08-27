/*
 * @(#)ODM2SimuCtxMapperImpl.java   
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

package org.interpss.mapper.odm.impl.old.xbean;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AnalysisCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetworkCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.net.OriginalDataFormat;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class XmlBeansODM2SimuCtxMapperImpl {
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(XBeanODMModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		// Map transmission and Loadflow
		if (parser.getStudyCase().getBaseCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getStudyCase().getBaseCase().getAnalysisCategory() == AnalysisCategoryEnumType.LOADFLOW) {

			PSSNetworkXmlType xmlNet = parser.getBaseCase();
			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			try {
				simuCtx.setAclfAdjNet(XmlBeansODMLoadflowDataMapperImpl.mapNetworkData(xmlNet));

				for (BusRecordXmlType busRec : xmlNet.getBusList().getBusArray()) 
					XmlBeansODMLoadflowDataMapperImpl.mapBusData(busRec, simuCtx.getAclfAdjNet());

				for (BranchRecordXmlType branchRec : xmlNet.getBranchList().getBranchArray()) 
					XmlBeansODMLoadflowDataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
			} catch (Exception e) {
				e.printStackTrace();
				IpssLogger.getLogger().severe(e.toString());
				noError = false;
			}
		} else {
			IpssLogger.getLogger().severe(
							"Error: currently only Transmission NetworkType and Loadflow ApplicationType has been implemented");
			return false;
		}
		
		StudyCaseXmlType.ContentInfo.OriginalDataFormat.Enum ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(
				ofmt == StudyCaseXmlType.ContentInfo.OriginalDataFormat.IEEE_CDF? OriginalDataFormat.IEEECDF :
					(ofmt == StudyCaseXmlType.ContentInfo.OriginalDataFormat.CIM? OriginalDataFormat.CIM :
						(ofmt == StudyCaseXmlType.ContentInfo.OriginalDataFormat.PSS_E? OriginalDataFormat.PSSE :
							(ofmt == StudyCaseXmlType.ContentInfo.OriginalDataFormat.UCTE_DEF? OriginalDataFormat.UCTE :
								(ofmt == StudyCaseXmlType.ContentInfo.OriginalDataFormat.GE_PSLF? OriginalDataFormat.GE_PSLF :
									(ofmt == StudyCaseXmlType.ContentInfo.OriginalDataFormat.BPA? OriginalDataFormat.BPA :
										OriginalDataFormat.IPSS_EDITOR))))));		
		return noError;
	}
}