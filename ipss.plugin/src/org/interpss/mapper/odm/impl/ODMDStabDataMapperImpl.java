/*
 * @(#)ODMDStabDataMapperImpl.java   
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
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 02/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabBusXmlType;
import org.ieee.odm.schema.DStabNetXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.simu.SimuContext;


public class ODMDStabDataMapperImpl {

	
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(DStabModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		if (parser.getDStabNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.TRANSIENT_STABILITY) {
			DStabNetXmlType xmlNet = parser.getDStabNet();
			try {
				DStabilityNetwork dstabNet = mapNetworkData(xmlNet);
				simuCtx.setDStabilityNet(dstabNet);

				for (JAXBElement<BusXmlType> bus : xmlNet.getBusList().getBus()) {
					DStabBusXmlType busRec = (DStabBusXmlType) bus.getValue();
					ODMAclfDataMapperImpl.mapBusData(busRec, dstabNet);
				}

				for (JAXBElement<BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					ODMAclfDataMapperImpl.mapBranchData(b.getValue(), dstabNet, simuCtx.getMsgHub());
				}
			} catch (Exception e) {
				e.printStackTrace();
				IpssLogger.getLogger().severe(e.toString());
				noError = false;
			}
		} 
		else {
			IpssLogger.getLogger().severe( "Error: wrong Transmission NetworkType and/or ApplicationType");
			return false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}
	
	private static DStabilityNetwork mapNetworkData(DStabNetXmlType xmlNet) throws Exception {
		DStabilityNetwork dstabNet = DStabObjectFactory.createDStabilityNetwork();
		ODMAclfDataMapperImpl.mapNetworkData(dstabNet, xmlNet);
		return dstabNet;
	}	
}