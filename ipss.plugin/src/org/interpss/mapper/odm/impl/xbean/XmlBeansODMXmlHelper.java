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

package org.interpss.mapper.odm.impl.xbean;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;

import com.interpss.common.datatype.UnitType;


public class XmlBeansODMXmlHelper {
	static String PSSStudyCaseHead = "<PSSStudyCase xmlns=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\">";
	static String PSSStudyCaseEnd = "</PSSStudyCase>";
	
	static String BusListHead = PSSStudyCaseHead + "<baseCase><busList>";
	static String BusListEnd = "</busList></baseCase>" + PSSStudyCaseEnd; 

	static String BranchListHead = PSSStudyCaseHead + "<baseCase><branchList>";
	static String BranchListEnd = "</branchList></baseCase>" + PSSStudyCaseEnd; 
	
	/**
	 * warp the base case xml string for parsing
	 * 
	 * @param str
	 * @return
	 */
	public static String wrapBaseCase(String str) {
		return PSSStudyCaseHead + str + PSSStudyCaseEnd;
	}

	/**
	 * warp the bus list xml string for parsing
	 * 
	 * @param str
	 * @return
	 */
	public static String wrapBusList(String str) {
		return BusListHead + str + BusListEnd;
	}

	/**
	 * warp the branch list xml string for parsing
	 * 
	 * @param str
	 * @return
	 */
	public static String wrapBranchList(String str) {
		return BranchListHead + str + BranchListEnd;
	}
	
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

	public static byte toUnit(ActivePowerUnitType.Enum unit) {
		if (unit == ActivePowerUnitType.KW)
			return UnitType.kVA;
		else if (unit == ActivePowerUnitType.MW)
			return UnitType.mVA;
		return UnitType.PU;
	}

	public static byte toUnit(ReactivePowerUnitType.Enum unit) {
		if (unit == ReactivePowerUnitType.KVAR)
			return UnitType.kVA;
		else if (unit == ReactivePowerUnitType.MVAR)
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
