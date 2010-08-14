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

import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OPFNetworkXmlType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.simu.SimuContext;


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
			OPFNetworkXmlType xmlNet = parser.getOpfNet();
			noError = false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}	
}