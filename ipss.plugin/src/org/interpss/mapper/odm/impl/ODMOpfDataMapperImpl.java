/*
 * @(#)ODMOpfDataMapperImpl.java   
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

package org.interpss.mapper.odm.impl;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OpfGenBusXmlType;
import org.ieee.odm.schema.OpfNetworkXmlType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.util.IpssLogger;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;
import com.interpss.opf.OpfObjectFactory;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;


public class ODMOpfDataMapperImpl {
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(OpfModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		if (parser.getOpfNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.OPF) {
			OpfNetworkXmlType xmlNet = parser.getOpfNet();
			simuCtx.setNetType(SimuCtxType.OPF_NET);
			try {
				OpfNetwork opfNet = mapNetworkData(xmlNet);
				simuCtx.setOpfNet(opfNet);

				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					if (bus.getValue() instanceof OpfGenBusXmlType) {
						OpfGenBusXmlType busRec = (OpfGenBusXmlType) bus.getValue();
						mapGenBusData(busRec, opfNet);
					} 
					else {
						LoadflowBusXmlType busRec = (LoadflowBusXmlType) bus.getValue();
						ODMAclfDataMapperImpl.mapBusData(busRec, opfNet);
					}
				}

				for (JAXBElement<? extends BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					ODMAclfDataMapperImpl.mapBranchData(b.getValue(), opfNet, simuCtx.getMsgHub());
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
	
	/**
	 * Map a bus record
	 * 
	 * @param busRec
	 * @param adjNet
	 * @return
	 * @throws Exception
	 */
	public static OpfGenBus mapGenBusData(OpfGenBusXmlType busRec, OpfNetwork net) throws Exception {
		OpfGenBus aclfBus = OpfObjectFactory.createOpfGenBus(busRec.getId());
		net.addBus(aclfBus);
		ODMAclfDataMapperImpl.mapBaseBusData(busRec, aclfBus, net);
		ODMAclfDataMapperImpl.setBusLoadflowData(busRec, aclfBus, net);
		return aclfBus;
	}
	
	private static OpfNetwork mapNetworkData(OpfNetworkXmlType xmlNet) throws Exception {
		OpfNetwork opfNet = OpfObjectFactory.createOpfNetwork();
		ODMAclfDataMapperImpl.mapNetworkData(opfNet, xmlNet);
		opfNet.setAnglePenaltyFactor(xmlNet.getAnglePenaltyFactor());	
		return opfNet;
	}
}