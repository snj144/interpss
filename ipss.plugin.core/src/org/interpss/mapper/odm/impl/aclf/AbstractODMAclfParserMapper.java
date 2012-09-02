/*
 * @(#)AbstractODMAclfDataMapper.java   
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

package org.interpss.mapper.odm.impl.aclf;

import static com.interpss.common.util.IpssLogger.ipssLogger;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.interpss.mapper.odm.AbstractODMSimuCtxDataMapper;
import org.interpss.mapper.odm.ODMAclfNetMapper;
import org.interpss.mapper.odm.ODMHelper;

import com.interpss.simu.SimuContext;

/**
 * abstract mapper implementation to map ODM Aclf parser object to InterPSS AclfNet object
 * 
 * @author mzhou
 * @param Tfrom from object type
 */
public abstract class AbstractODMAclfParserMapper<Tfrom> extends AbstractODMSimuCtxDataMapper<Tfrom> {
	/**
	 * constructor
	 * 
	 */
	public AbstractODMAclfParserMapper() {
	}
	
	/**
	 * map into store in the ODM parser into simuCtx object
	 * 
	 * @param p ODM parser object, representing a ODM xml file
	 * @param simuCtx
	 */
	@Override public boolean map2Model(Tfrom p, SimuContext simuCtx) {
		boolean noError = true;
		AclfModelParser parser = (AclfModelParser)p;
		if (parser.getStudyCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION ) {
			LoadflowNetXmlType xmlNet = parser.getAclfNet();
			noError = new ODMAclfNetMapper().map2Model(xmlNet, simuCtx);
		} else {
			ipssLogger.severe("Error: currently only Transmission NetworkType has been implemented");
			return false;
		}
		
		OriginalDataFormatEnumType ofmt = 
				parser.getStudyCase().getContentInfo() != null?
						parser.getStudyCase().getContentInfo().getOriginalDataFormat() :
							OriginalDataFormatEnumType.CUSTOM;
		simuCtx.getNetwork().setOriginalDataFormat(ODMHelper.map(ofmt));		
		return noError;
	}
}