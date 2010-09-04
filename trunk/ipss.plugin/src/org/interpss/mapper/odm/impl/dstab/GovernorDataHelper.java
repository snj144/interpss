/*
 * @(#)GovernorDataHelper.java   
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
 * @Date 08/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.GovSimpleTypeXmlType;
import org.ieee.odm.schema.GovernorModelXmlType;
import org.interpss.dstab.control.gov.GovernorObjectFactory;
import org.interpss.dstab.control.gov.simple.SimpleGovernor;

import com.interpss.common.exp.InterpssException;
import com.interpss.dstab.mach.Machine;



public class GovernorDataHelper {
	private Machine mach = null;

	public GovernorDataHelper(Machine mach) {
		this.mach = mach;
	}
	
	/**
	 * create the gov model and add to its parent machine object
	 * 
	 * @param govXmlRec ODM governor model record
	 */
	public void createGovernor(GovernorModelXmlType govXmlRec) throws InterpssException  {
		if (govXmlRec instanceof GovSimpleTypeXmlType) {
			GovSimpleTypeXmlType govXml = (GovSimpleTypeXmlType)govXmlRec;
			SimpleGovernor gov = GovernorObjectFactory.createSimpleGovernor(mach.getId()+"_Gov", govXml.getName(), mach);
			gov.getData().setK(govXml.getK());
			gov.getData().setT1(govXml.getT1().getValue());
			gov.getData().setPmax(govXml.getPmax());
			gov.getData().setPmin(govXml.getPmin());
		}
		else {
			throw new InterpssException("Governor type invalid or not implemented, type " + govXmlRec.getClass().getSimpleName());
		}
		
	}
}