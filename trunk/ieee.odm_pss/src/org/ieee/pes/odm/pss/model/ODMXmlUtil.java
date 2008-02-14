 /*
  * @(#)ODMXmlUtil.java   
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
  * @Date 02/11/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.pes.odm.pss.model;

import org.ieee.cmte.psace.oss.odm.pss.schema.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.LimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.ZXmlType;

public class ODMXmlUtil {
	/**
	 * add a name/value pair to the name/value pair List
	 * 
	 * @param nvList name/value pair list
	 * @param name name string
	 * @param value value string
	 */
	public static void addNVPair(NameValuePairListXmlType nvList, String name, String value) {
    	NameValuePairXmlType nvPair = nvList.addNewNvPair();
    	nvPair.setName(name);
    	nvPair.setValue(value);
	}

	/**
	 * form branch id based on from node id, to node id and branch circuit id 
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public static String formBranchId(String fromId, String toId, String cirId) {
		return fromId + "_" + toId + "_" + cirId;
	}
	
	/**
	 * Set value (r, x, unit) to the z object
	 * 
	 * @param z
	 * @param r
	 * @param x
	 * @param unit
	 */
	public static void setZValue(ZXmlType z, double r, double x, ZXmlType.Unit.Enum unit) {
		z.setR(r);
		z.setX(x);
		z.setUnit(unit);
	}
 
	/**
	 * Set value (g, b, unit) to the y object
	 * 
	 * @param y
	 * @param g
	 * @param b
	 * @param unit
	 */
	public static void setYData(YXmlType y, double g, double b, YXmlType.Unit.Enum unit) {
		y.setG(g);
		y.setB(b);
		y.setUnit(unit);
	}
	
	/**
	 * Set value (p, q, unit) to the power object
	 * 
	 * @param power
	 * @param p
	 * @param q
	 * @param unit
	 */
	public static void setPowerData(PowerXmlType power, double p, double q, PowerXmlType.Unit.Enum unit) {
    	power.setP(p);
    	power.setQ(q);
    	power.setUnit(unit);		
	}
	
	public static void setVoltageData(VoltageXmlType voltage, double v, VoltageXmlType.Unit.Enum unit) {
    	voltage.setVoltage(v);
    	voltage.setUnit(unit);		
	}

	public static void setAngleData(AngleXmlType angle, double a, AngleXmlType.Unit.Enum unit) {
    	angle.setAngle(a);
    	angle.setUnit(unit);		
	}

	public static void setLimitData(LimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
	}
	
	public static void setLoadData(LoadflowBusDataXmlType busData, LoadflowBusDataXmlType.LoadData.Code.Enum code, 
			double p, double q, PowerXmlType.Unit.Enum unit) {
		busData.addNewLoadData();
    	busData.getLoadData().setCode(code);
    	ODMXmlUtil.setPowerData(busData.getLoadData().addNewLoad(), p, q, unit);
	}
	
	public static void setGenData(LoadflowBusDataXmlType busData, LoadflowBusDataXmlType.GenData.Code.Enum code, 
			double p, double q, PowerXmlType.Unit.Enum unit) {
   		busData.addNewGenData();
   		busData.getGenData().setCode(code);
   		ODMXmlUtil.setPowerData(busData.getGenData().addNewGen(), p, q, unit);
	}
	
	public static void setLineData(LoadflowBranchDataXmlType branchData, 
			             double r, double x, ZXmlType.Unit.Enum zUnit, 
			             double g, double b, YXmlType.Unit.Enum bUnit) {
		branchData.addNewLineData();
		ODMXmlUtil.setZValue(branchData.getLineData().addNewZ(), r, x, zUnit);
		if (b != 0.0) 
			ODMXmlUtil.setYData(branchData.getLineData().addNewTotalShuntY(), g, b, bUnit);
	}
}
