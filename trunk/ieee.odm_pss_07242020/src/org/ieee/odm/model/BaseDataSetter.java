 /*
  * @(#)DataSetter.java   
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
  * @Date 04/11/2009
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.model;

import org.ieee.odm.schema.ActivePowerLimitXmlType;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.ActivePowerXmlType;
import org.ieee.odm.schema.AngleLimitXmlType;
import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.AngleXmlType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.ApparentPowerXmlType;
import org.ieee.odm.schema.CurrentUnitType;
import org.ieee.odm.schema.CurrentXmlType;
import org.ieee.odm.schema.GXmlType;
import org.ieee.odm.schema.LimitXmlType;
import org.ieee.odm.schema.PowerXmlType;
import org.ieee.odm.schema.RXmlType;
import org.ieee.odm.schema.ReactivePowerLimitXmlType;
import org.ieee.odm.schema.ReactivePowerUnitType;
import org.ieee.odm.schema.ReactivePowerXmlType;
import org.ieee.odm.schema.TapLimitXmlType;
import org.ieee.odm.schema.TapXmlType;
import org.ieee.odm.schema.TimePeriodUnitType;
import org.ieee.odm.schema.TimePeriodXmlType;
import org.ieee.odm.schema.TurnRatioLimitXmlType;
import org.ieee.odm.schema.TurnRatioUnitType;
import org.ieee.odm.schema.TurnRatioXmlType;
import org.ieee.odm.schema.VoltageLimitXmlType;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.VoltageXmlType;
import org.ieee.odm.schema.YUnitType;
import org.ieee.odm.schema.YXmlType;
import org.ieee.odm.schema.ZUnitType;
import org.ieee.odm.schema.ZXmlType;


public class BaseDataSetter extends BaseJaxbHelper {
	/**
	 * Set apparent power, unit = kva
	 * 
	 * @param power
	 * @param kva
	 */
	/*
	public static void setPowerKva(ApparentPowerXmlType power, double kva) {
		power.setValue(kva);   
		power.setUnit(ApparentPowerUnitType.KVA); 		
	}
	*/
	public static ApparentPowerXmlType createPowerKvaValue(double kva) {
		ApparentPowerXmlType power = getFactory().createApparentPowerXmlType();
		power.setValue(kva);   
		power.setUnit(ApparentPowerUnitType.KVA); 		
		return power;
	}
	
	/**
	 * Set apparent power, unit = mva
	 * 
	 * @param power
	 * @param mva
	 */
	public static ApparentPowerXmlType createPowerMvaValue(double mva) {
		ApparentPowerXmlType power = getFactory().createApparentPowerXmlType();
		power.setValue(mva);   
		power.setUnit(ApparentPowerUnitType.MVA); 		
		return power;
	}

	/**
	 * Set apparent power
	 * 
	 * @param power
	 * @param p
	 * @param unit
	 */
	public static ActivePowerXmlType createActivePowerValue(double p, ActivePowerUnitType unit) {
		ActivePowerXmlType power = getFactory().createActivePowerXmlType();
		power.setValue(p);   
		power.setUnit(unit);
		return power;
	}

	/**
	 * set reactive power
	 * 
	 * @param power
	 * @param q
	 * @param unit
	 */
	public static ReactivePowerXmlType createReactivePowerValue(double q, ReactivePowerUnitType unit) {
		ReactivePowerXmlType power = getFactory().createReactivePowerXmlType();
		power.setValue(q);   
		power.setUnit(unit); 		
		return power;
	}	
	
	/**
	 * Set time/period
	 * 
	 * @param time
	 * @param t
	 * @param unit
	 */
	public static TimePeriodXmlType createTimePeriodValue(double t,TimePeriodUnitType unit){
		TimePeriodXmlType time = getFactory().createTimePeriodXmlType();
		time.setValue(t);
		time.setUnit(unit);
		return time;
	}

	/**
	 * set value (max, min) to the limit object
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 */
	public static void setLimit(LimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
	}

	public static LimitXmlType createLimit(double max, double min) {
		LimitXmlType limit = getFactory().createLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		return limit;
	}
	
	/**
	 * set voltage limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static VoltageLimitXmlType createVoltageLimit(double max, double min, VoltageUnitType unit) {
		VoltageLimitXmlType limit = getFactory().createVoltageLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
		return limit;
	}

	/**
	 * Set active power limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static ActivePowerLimitXmlType createActivePowerLimit(double max, double min, ActivePowerUnitType unit) {
		ActivePowerLimitXmlType limit = getFactory().createActivePowerLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
		return limit;
	}

	/**
	 * Set reactive power limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static ReactivePowerLimitXmlType createReactivePowerLimit(double max, double min, ReactivePowerUnitType unit) {
		ReactivePowerLimitXmlType limit = getFactory().createReactivePowerLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
		return limit;
	}

	/**
	 * set tap limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 */
	public static TapLimitXmlType createTapLimit(double max, double min) {
		TapLimitXmlType limit = getFactory().createTapLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(TurnRatioUnitType.PU);
		return limit;
	}

	public static TurnRatioLimitXmlType createTurnRatioLimit(double max, double min) {
		TurnRatioLimitXmlType limit = getFactory().createTurnRatioLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(TurnRatioUnitType.PU);
		return limit;
	}

	/**
	 * set angle limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static AngleLimitXmlType createAngleLimit(double max, double min, AngleUnitType unit) {
		AngleLimitXmlType limit = getFactory().createAngleLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
		return limit;
	}
	
	/**
	 * Create and Set value (p, q, unit) to the power object
	 * 
	 * @param power
	 * @param p
	 * @param q
	 * @param unit
	 */
	public static PowerXmlType createPowerValue(double p, double q, ApparentPowerUnitType unit) {
		PowerXmlType power = getFactory().createPowerXmlType();
		power.setRe(p);
    	power.setIm(q);
    	power.setUnit(unit);
    	return power;
	}	
	
	/**
	 * set value (v, unit) to the voltage object
	 * 
	 * @param voltage
	 * @param v
	 * @param unit
	 */
	public static VoltageXmlType createVoltageValue(double v, VoltageUnitType unit) {
		VoltageXmlType voltage = getFactory().createVoltageXmlType();
		voltage.setValue(v);
    	voltage.setUnit(unit);
    	return voltage;
	}
	
	/**
	 * set value (i, unit) to the current object
	 * 
	 * @param current
	 * @param i
	 * @param unit
	 */
	public static CurrentXmlType createCurrentValue(double i, CurrentUnitType unit) {
		CurrentXmlType current = getFactory().createCurrentXmlType();
		current.setValue(i);
    	current.setUnit(unit);
    	return current;		
	}

	/**
	 * set value (a, unit) to the angle object
	 * 
	 * @param angle
	 * @param a
	 * @param unit
	 */
	public static AngleXmlType createAngleValue(double a, AngleUnitType unit) {
		AngleXmlType angle = getFactory().createAngleXmlType();
    	angle.setValue(a);
    	angle.setUnit(unit);		
    	return angle;
	}
	
	/**
	 * Set value (r, x, unit) to the z object
	 * 
	 * @param z
	 * @param r
	 * @param x
	 * @param unit
	 */
	public static ZXmlType createZValue(double r, double x, ZUnitType unit) {
		ZXmlType z = getFactory().createZXmlType();
		z.setRe(r);
		z.setIm(x);
		z.setUnit(unit);
		return z;
	}
 
	/**
	 * Set value (r, unit) to the r object
	 * 
	 * @param r
	 * @param unit
	 */
	public static RXmlType createRValue(double r, ZUnitType unit) {
		RXmlType rRec = getFactory().createRXmlType();
		rRec.setR(r);
		rRec.setUnit(unit);
		return rRec;
	}

	/**
	 * Set value (g, b, unit) to the y object
	 * 
	 * @param y
	 * @param g
	 * @param b
	 * @param unit
	 */
	public static YXmlType createYValue(double g, double b, YUnitType unit) {
		YXmlType y = getFactory().createYXmlType();  
		y.setRe(g);
		y.setIm(b);
		y.setUnit(unit);
		return y;
	}
	
	/**
	 * Set value (g, unit) to the G object
	 * 
	 * @param g
	 * @param unit
	 */
	public static GXmlType createGValue(double g, YUnitType unit) {
		GXmlType gRec = getFactory().createGXmlType();
		gRec.setG(g);
		gRec.setUnit(unit);
		return gRec;
	}
	
	/**
	 * Set tap, unit = PU
	 * 
	 * @param tap
	 * @param p
	 */
	public static TapXmlType createTapPU(double p) {
		TapXmlType tap = getFactory().createTapXmlType();
		tap.setValue(p);
    	tap.setUnit(TurnRatioUnitType.PU);
    	return tap;
	}
	
	/**
	 * Set the turnratio object
	 * 
	 * @param p
	 * @return
	 */
	public static TurnRatioXmlType createTurnRatioPU(double p) {
		TurnRatioXmlType r = getFactory().createTurnRatioXmlType();
		r.setValue(p);
    	r.setUnit(TurnRatioUnitType.PU);
    	return r;
	}	
}
