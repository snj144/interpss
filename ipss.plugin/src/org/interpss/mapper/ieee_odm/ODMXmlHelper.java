/*
 * @(#)ODMXmlHelper.java   
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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;

import com.interpss.common.datatype.UnitType;


public class ODMXmlHelper {
	/**
	 * convert XML power unit to Ipss UnitType
	 * 
	 * @param unit power unit 
	 * @return
	 */
	public static byte toUnit(ApparentPowerUnitType.Enum unit) {
		if (unit == ApparentPowerUnitType.KVA)
			return UnitType.kVA;
		else if (unit == ApparentPowerUnitType.MVA)
			return UnitType.mVA;
		return UnitType.PU;
	}

	public static byte toUnit(ZUnitType.Enum unit) {
		if (unit == ZUnitType.OHM)
			return UnitType.Ohm;
		return UnitType.PU;
	}

	/**
	 * convert XML Y unit to Ipss UnitType
	 * 
	 * @param unit power unit 
	 * @return
	 */
	public static byte toUnit(YUnitType.Enum unit) {
		if (unit == YUnitType.MHO)
			return UnitType.Mho;
		else if (unit == YUnitType.MICROMHO)
			return UnitType.MicroMho;
		return UnitType.PU;
	}

	/**
	 * convert XML voltage unit to Ipss UnitType
	 * 
	 * @param unit power unit 
	 * @return
	 */
	public static byte toUnit(VoltageUnitType.Enum unit) {
		if (unit == VoltageUnitType.VOLT)
			return UnitType.Volt;
		else if (unit == VoltageUnitType.KV)
			return UnitType.kV;
		return UnitType.PU;
	}

	/**
	 * convert XML angle unit to Ipss UnitType
	 * 
	 * @param unit power unit 
	 * @return
	 */
	public static byte toUnit(AngleUnitType.Enum unit) {
		if (unit == AngleUnitType.DEG)
			return UnitType.Deg;
		return UnitType.Rad;
	}
}
