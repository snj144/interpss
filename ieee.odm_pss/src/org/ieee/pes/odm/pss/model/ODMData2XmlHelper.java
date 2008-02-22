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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;

public class ODMData2XmlHelper {
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
		// the combination of form bus id, to bus id and cirId should be always unique
		return fromId + "_to_" + toId + "_cirId_" + cirId;
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
	
	/**
	 * set value (v, unit) to the voltage object
	 * 
	 * @param voltage
	 * @param v
	 * @param unit
	 */
	public static void setVoltageData(VoltageXmlType voltage, double v, VoltageXmlType.Unit.Enum unit) {
    	voltage.setVoltage(v);
    	voltage.setUnit(unit);		
	}

	/**
	 * set value (a, unit) to the angle object
	 * 
	 * @param angle
	 * @param a
	 * @param unit
	 */
	public static void setAngleData(AngleXmlType angle, double a, AngleXmlType.Unit.Enum unit) {
    	angle.setAngle(a);
    	angle.setUnit(unit);		
	}

	/**
	 * set value (max, min) to the limit object
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 */
	public static void setLimitData(LimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
	}
	
	/**
	 * add a LoadData object to the busData object, then set value(code, p, q, unit) to the created LoadData object
	 * 
	 * @param busData
	 * @param code
	 * @param p
	 * @param q
	 * @param unit
	 */
	public static void setLoadData(LoadflowBusDataXmlType busData, LoadflowBusDataXmlType.LoadData.Code.Enum code, 
			double p, double q, PowerXmlType.Unit.Enum unit) {
		busData.addNewLoadData();
    	busData.getLoadData().setCode(code);
    	ODMData2XmlHelper.setPowerData(busData.getLoadData().addNewLoad(), p, q, unit);
	}
	
	/**
	 * add a GenData object to the busData object, then set value(code, p, q, unit) to the created GenData object
	 * 
	 * @param busData
	 * @param code
	 * @param p
	 * @param q
	 * @param unit
	 */
	public static void setGenData(LoadflowBusDataXmlType busData, LoadflowBusDataXmlType.GenData.Code.Enum code, 
			double p, double q, PowerXmlType.Unit.Enum unit) {
   		busData.addNewGenData();
   		busData.getGenData().setCode(code);
   		ODMData2XmlHelper.setPowerData(busData.getGenData().addNewGen(), p, q, unit);
	}
	
	/**
	 * add a LineData object to the branchData object, then set value(r, x, zUnit, g, b, yUnit) 
	 * to the created LineData object
	 * 
	 * @param branchData
	 * @param r
	 * @param x
	 * @param zUnit
	 * @param g
	 * @param b
	 * @param bUnit
	 */
	public static void setLineData(LoadflowBranchDataXmlType branchData, 
			             double r, double x, ZXmlType.Unit.Enum zUnit, 
			             double g, double b, YXmlType.Unit.Enum yUnit) {
		branchData.addNewLineData();
		ODMData2XmlHelper.setZValue(branchData.getLineData().addNewZ(), r, x, zUnit);
		if (g != 0.0 || b != 0.0) 
			ODMData2XmlHelper.setYData(branchData.getLineData().addNewTotalShuntY(), g, b, yUnit);
	}

	/**
	 * add a XformerData object to the branchData object, then set value(r, x, zUnit, gFrom, bFrom, gTo, bTo, yUnit) to the created XfomerData object
	 * 
	 * @param branchData
	 * @param r
	 * @param x
	 * @param zUnit
	 * @param gFrom
	 * @param bFrom
	 * @param gTo
	 * @param bTo
	 * @param bUnit
	 */
	public static void setXformerData(LoadflowBranchDataXmlType branchData, 
			             double r, double x, ZXmlType.Unit.Enum zUnit, 
			             double gFrom, double bFrom, double gTo, double bTo, YXmlType.Unit.Enum yUnit) {
		branchData.addNewXformerData();
		setXformerData(branchData.getXformerData(),
				r, x, zUnit, gFrom, bFrom, gTo, bTo, yUnit);
	}

	/**
	 * add a PhaseShiftXfrData object to the branchData object, then set value(r, x, zUnit, gFrom, bFrom, gTo, bTo, yUnit) 
	 * to the created PhaseShiftXfrData object
	 * 
	 * @param branchData
	 * @param r
	 * @param x
	 * @param zUnit
	 * @param gFrom
	 * @param bFrom
	 * @param gTo
	 * @param bTo
	 * @param bUnit
	 */
	public static void setPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZXmlType.Unit.Enum zUnit, double gFrom,
			double bFrom, double gTo, double bTo, YXmlType.Unit.Enum yUnit) {
		branchData.addNewPhaseShiftXfrData();
		setXformerData(branchData.getPhaseShiftXfrData(),
				r, x, zUnit, gFrom, bFrom, gTo, bTo, yUnit);
	}

	private static void setXformerData(TransformerDataXmlType xfrData,
			double r, double x, ZXmlType.Unit.Enum zUnit, double gFrom,
			double bFrom, double gTo, double bTo, YXmlType.Unit.Enum yUnit) {
		ODMData2XmlHelper
				.setZValue(xfrData.addNewZ(), r, x, zUnit);
		if (gFrom != 0.0 || bFrom != 0.0)
			ODMData2XmlHelper.setYData(xfrData.addNewFromShuntY(),
					gFrom, bFrom, yUnit);
		if (gTo != 0.0 || bTo != 0.0)
			ODMData2XmlHelper.setYData(xfrData.addNewToShuntY(),
					gTo, bTo, yUnit);
	}
	
	/**
	 * add a RatingLimitData object to the branchData object, then set value(mvarLimit1, mvarLimit2, mvarLimit3, mvarUnit, curLimit, curUnit) 
	 * to the created RatingLimitData object
	 * 
	 * @param branchData
	 * @param mvar1
	 * @param mvar2
	 * @param mvar3
	 * @param mvarUnit
	 * @param current
	 * @param curUnit
	 */
	public static void setBranchRatingLimitData(LoadflowBranchDataXmlType branchData, 
				double mvar1, double mvar2, double mvar3, LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.Enum mvarUnit,
				double current, LoadflowBranchDataXmlType.RatingLimit.CurrentRatingUnit.Enum curUnit) {
    	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0 || current != 0.0) {
    		branchData.addNewRatingLimit();
        	if (mvar1 != 0.0) 
        		branchData.getRatingLimit().setMvaRating1(mvar1);
        	if (mvar2 != 0.0) 
        		branchData.getRatingLimit().setMvaRating2(mvar2);
        	if (mvar3 != 0.0) 
        		branchData.getRatingLimit().setMvaRating3(mvar3);
        	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0)
        		branchData.getRatingLimit().setMvaRatingUnit(mvarUnit);

        	if (current != 0.0) {
        		branchData.getRatingLimit().setCurrentRating(current);
        		branchData.getRatingLimit().setCurrentRatingUnit(curUnit);
        	}
    	}
		
	}
}
