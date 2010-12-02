/*
 * @(#)IEEEODMMapper.java   
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
 * @Date 02/21/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.dep;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.acsc.AcscModelParser;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.model.jaxb.JaxbODMModelParser;
import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.model.xbean.XBeanODMModelParser;
import org.interpss.mapper.odm.ODMAclfDataMapper;
import org.interpss.mapper.odm.ODMAcscDataMapper;
import org.interpss.mapper.odm.ODMDStabDataMapper;
import org.interpss.mapper.odm.ODMOpfDataMapper;

import com.interpss.common.mapper.dep.AbstractMapper;
import com.interpss.simu.SimuContext;

public class IEEEODMMapper extends AbstractMapper {

	public IEEEODMMapper() {
	}

	/**
	 * map(load) a IEEEODMPSSModelParser object into an InterPSS object of Type Class
	 * 
	 * @param fromObj a IEEEODMPSSModelParser object
	 * @param toObj an object of type Class
	 * @param kclass class type of the toObj 
	 */
	@Override
	public <T> boolean mapping(Object fromObj, T toObj) {
		if (toObj instanceof SimuContext) {
			if (fromObj instanceof OpfModelParser) {
				OpfModelParser parser = (OpfModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return new ODMOpfDataMapper(msg)
								.map2Model(parser, simuCtx);
			}
			else if (fromObj instanceof DStabModelParser) {
				DStabModelParser parser = (DStabModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return new ODMDStabDataMapper(msg)
								.map2Model(parser, simuCtx);
			}
			else if (fromObj instanceof AcscModelParser) {
				AcscModelParser parser = (AcscModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return new ODMAcscDataMapper(msg)
								.map2Model(parser, simuCtx);
			}
			else if (fromObj instanceof AclfModelParser) {
				AclfModelParser parser = (AclfModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return new ODMAclfDataMapper(msg)
								.map2Model(parser, simuCtx);
			}			
			else if (fromObj instanceof XBeanODMModelParser) {
				XBeanODMModelParser parser = (XBeanODMModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return org.interpss.mapper.odm.impl.old.xbean.XmlBeansODM2SimuCtxMapperImpl.odm2SimuCtxMapping(parser, simuCtx);
			}
			else if (fromObj instanceof JaxbODMModelParser) {
				JaxbODMModelParser parser = (JaxbODMModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return org.interpss.mapper.odm.impl.old.v07.ODM2SimuCtxMapper.odm2SimuCtxMapping(parser, simuCtx);
			}
		} 
		return true;
	}
}
