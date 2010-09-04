/*
 * @(#)ExciterDataHelper.java   
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

import org.ieee.odm.schema.ExcSimpleTypeXmlType;
import org.ieee.odm.schema.ExciterModelXmlType;
import org.interpss.dstab.control.exc.ExciterObjectFactory;
import org.interpss.dstab.control.exc.simple.SimpleExciter;

import com.interpss.common.exp.InterpssException;
import com.interpss.dstab.mach.Machine;

public class ExciterDataHelper {
	private Machine mach = null;
	
	public ExciterDataHelper(Machine mach) {
		this.mach = mach;
	}

	/**
	 * create the exc model and add to its parent machine object
	 * 
	 * @param excXmlRec ODM exciter model record
	 */
	public void createExciter(ExciterModelXmlType excXmlRec) throws InterpssException {
		if (excXmlRec instanceof ExcSimpleTypeXmlType) {
			ExcSimpleTypeXmlType excXml = (ExcSimpleTypeXmlType)excXmlRec;
			SimpleExciter exc = ExciterObjectFactory.createSimpleExciter(mach.getId()+"_Exc", excXml.getName(), mach);
			exc.getData().setKa(excXml.getKa());
			exc.getData().setTa(excXml.getTa().getValue());
			exc.getData().setVrmax(excXml.getVrmax());
			exc.getData().setVrmin(excXml.getVrmin());
		}
		else {
			throw new InterpssException("Exciter type invalid or not implemented, type " + excXmlRec.getClass().getSimpleName());
		}
	}
}