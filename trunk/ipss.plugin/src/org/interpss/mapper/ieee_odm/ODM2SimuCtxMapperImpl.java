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

package org.interpss.mapper.ieee_odm;

import org.ieee.odm.model.JaxbODMModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.net.OriginalDataFormat;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ODM2SimuCtxMapperImpl {
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(JaxbODMModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		//parser.stdout();
		
		// Map transmission and Loadflow
		if (parser.getStudyCase().getBaseCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getStudyCase().getBaseCase().getAnalysisCategory() == AnalysisCategoryEnumType.LOADFLOW) {

			LoadflowNetXmlType xmlNet = parser.getAclfBaseCase();
			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			try {
				simuCtx.setAclfAdjNet(ODMLoadflowDataMapperImpl.mapNetworkData(xmlNet));

				for (BusXmlType bus : xmlNet.getBusList().getBus()) {
					BusRecordXmlType busRec = (BusRecordXmlType) bus;
					ODMLoadflowDataMapperImpl.mapBusData(busRec, simuCtx.getAclfAdjNet());
				}

				for (BranchXmlType branch : xmlNet.getBranchList().getBranch()) { 
					BranchRecordXmlType branchRec = (BranchRecordXmlType) branch;
					ODMLoadflowDataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
				}
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
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(
				ofmt == OriginalDataFormatEnumType.IEEE_CDF? OriginalDataFormat.IEEECDF :
					(ofmt == OriginalDataFormatEnumType.CIM? OriginalDataFormat.CIM :
						(ofmt == OriginalDataFormatEnumType.PSS_E? OriginalDataFormat.PSSE :
							(ofmt == OriginalDataFormatEnumType.UCTE_DEF? OriginalDataFormat.UCTE :
								(ofmt == OriginalDataFormatEnumType.GE_PSLF? OriginalDataFormat.GE_PSLF :
									(ofmt == OriginalDataFormatEnumType.BPA? OriginalDataFormat.BPA :
										OriginalDataFormat.IPSS_EDITOR))))));		
		return noError;
	}
}