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

import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.ZXmlType;

public class ODMXmlUtil {
	/**
	 * 
	 * 
	 * @param nvList
	 * @param name
	 * @param value
	 */
	public static void addNVPair(NameValuePairListXmlType nvList, String name, String value) {
    	NameValuePairXmlType nvPair = nvList.addNewNvPair();
    	nvPair.setName(name);
    	nvPair.setValue(value);
	}

	/**
	 * 
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
	 * 
	 * 
	 * @param z
	 * @param r
	 * @param x
	 * @param unit
	 */
	public static void setZ(ZXmlType z, double r, double x, ZXmlType.Unit.Enum unit) {
		z.setR(r);
		z.setX(x);
		z.setUnit(unit);
	}
 
	/**
	 * 
	 * 
	 * @param y
	 * @param g
	 * @param b
	 * @param unit
	 */
	public static void setY(YXmlType y, double g, double b, YXmlType.Unit.Enum unit) {
		y.setG(g);
		y.setB(b);
		y.setUnit(unit);
	}
	
	public static void setPower(PowerXmlType power, double p, double q, PowerXmlType.Unit.Enum unit) {
    	power.setP(p);
    	power.setQ(q);
    	power.setUnit(unit);		
	}
}
