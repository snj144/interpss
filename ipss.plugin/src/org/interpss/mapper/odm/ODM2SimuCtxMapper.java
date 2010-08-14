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

package org.interpss.mapper.odm;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.model.jaxb.JaxbODMModelParser;
import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabNetXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OPFNetworkXmlType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.interpss.mapper.odm.impl.ODMAclfDataMapperImpl;
import org.interpss.mapper.odm.old.ODMV07DataMapperImpl;

import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ODM2SimuCtxMapper {
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
			OPFNetworkXmlType xmlNet = parser.getOpfNet();
			noError = false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}
	
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
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.OPF) {
			DStabNetXmlType xmlNet = parser.getDStabNet();
			noError = false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}

	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(AclfModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		// Map transmission and Loadflow
		if (parser.getAclfNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.LOADFLOW) {

			LoadflowNetXmlType xmlNet = parser.getAclfNet();
			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			try {
				simuCtx.setAclfAdjNet(ODMAclfDataMapperImpl.mapNetworkData(xmlNet));

				for (JAXBElement<BusXmlType> bus : xmlNet.getBusList().getBus()) {
					LoadflowBusXmlType busRec = (LoadflowBusXmlType) bus.getValue();
					ODMAclfDataMapperImpl.mapBusData(busRec, simuCtx.getAclfAdjNet());
				}

				for (JAXBElement<BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					BaseBranchXmlType branch = b.getValue();
					if (branch instanceof LineBranchXmlType) {
						LineBranchXmlType branchRec = (LineBranchXmlType) branch;
						ODMAclfDataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
					}
					else if (branch instanceof XfrBranchXmlType) {
						XfrBranchXmlType branchRec = (XfrBranchXmlType) branch;
						ODMAclfDataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
					}
					else if (branch instanceof LineBranchXmlType) {
						PSXfrBranchXmlType branchRec = (PSXfrBranchXmlType) branch;
						ODMAclfDataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
					}
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
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}

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
		if (parser.getAclfBaseCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfBaseCase().getAnalysisCategory() == AnalysisCategoryEnumType.LOADFLOW) {

			LoadflowNetXmlType xmlNet = parser.getAclfBaseCase();
			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			try {
				simuCtx.setAclfAdjNet(ODMAclfDataMapperImpl.mapNetworkData(xmlNet));

				for (JAXBElement<BusXmlType> bus : xmlNet.getBusList().getBus()) {
					BusRecordXmlType busRec = (BusRecordXmlType) bus.getValue();
					ODMV07DataMapperImpl.mapBusData(busRec, simuCtx.getAclfAdjNet());
				}

				for (JAXBElement<BaseBranchXmlType> branch : xmlNet.getBranchList().getBranch()) { 
					BranchRecordXmlType branchRec = (BranchRecordXmlType) branch.getValue();
					ODMV07DataMapperImpl.mapBranchData(branchRec, simuCtx.getAclfAdjNet(), simuCtx.getMsgHub());
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
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}
}