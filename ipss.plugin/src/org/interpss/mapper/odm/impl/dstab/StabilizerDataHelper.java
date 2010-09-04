/*
 * @(#)StabilizerDataHelper.java   
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

import org.ieee.odm.schema.PssSimpleTypeXmlType;
import org.ieee.odm.schema.StabilizerModelXmlType;
import org.interpss.dstab.control.pss.StabilizerObjectFactory;
import org.interpss.dstab.control.pss.simple.SimpleStabilizer;

import com.interpss.common.exp.InterpssException;
import com.interpss.dstab.mach.Machine;



public class StabilizerDataHelper {
	private Machine mach = null;
	
	public StabilizerDataHelper(Machine mach) {
		this.mach = mach;
	}
	
	/**
	 * create the pss model and add to its parent machine object
	 * 
	 * @param pssXmlRec ODM stabilizer model record
	 */
	public void createStabilizer(StabilizerModelXmlType pssXmlRec) throws InterpssException {
		if (pssXmlRec instanceof PssSimpleTypeXmlType) {
			PssSimpleTypeXmlType pssXml = (PssSimpleTypeXmlType)pssXmlRec;
			SimpleStabilizer pss = StabilizerObjectFactory.createSimpleStabilizer(mach.getId()+"_Pss", pssXml.getName(), mach);
			pss.getData().setKs(pssXml.getKs());
			pss.getData().setT1(pssXml.getT1().getValue());
			pss.getData().setT2(pssXml.getT2().getValue());
			pss.getData().setT3(pssXml.getT3().getValue());
			pss.getData().setT4(pssXml.getT4().getValue());
			pss.getData().setVsmax(pssXml.getVsmax());
			pss.getData().setVsmin(pssXml.getVsmin());
		}
		else {
			throw new InterpssException("Stabilizer type invalid or not implemented, type " + pssXmlRec.getClass().getSimpleName());
		}
		
	}
}