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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AnalysisCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetworkCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

import com.interpss.common.util.IpssLogger;
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
	public static boolean odm2SimuCtxMapping(IEEEODMPSSModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		if (parser.getStudyCase().getBaseCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getStudyCase().getBaseCase().getAnalysisCategory() == AnalysisCategoryEnumType.LOADFLOW) {

			PSSNetworkXmlType xmlNet = parser.getBaseCase();

			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			try {
				simuCtx.setAclfAdjNet(ODMLoadflowDataMapperImpl.mapNetworkData(xmlNet));

				for (BusRecordXmlType busRec : xmlNet.getBusList().getBusArray()) 
					ODMLoadflowDataMapperImpl.mapBusData(busRec, simuCtx.getAclfAdjNet());

				for (BranchRecordXmlType branchRec : xmlNet.getBranchList().getBranchArray()) 
					ODMLoadflowDataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
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
		return noError;
	}
}