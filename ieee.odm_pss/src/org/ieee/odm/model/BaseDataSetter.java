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

import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.AngleXmlType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.CurrentUnitType;
import org.ieee.odm.schema.CurrentXmlType;
import org.ieee.odm.schema.GXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.PowerXmlType;
import org.ieee.odm.schema.RXmlType;
import org.ieee.odm.schema.TapXmlType;
import org.ieee.odm.schema.TurnRatioUnitType;
import org.ieee.odm.schema.TurnRatioXmlType;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.VoltageXmlType;
import org.ieee.odm.schema.YUnitType;
import org.ieee.odm.schema.YXmlType;
import org.ieee.odm.schema.ZUnitType;
import org.ieee.odm.schema.ZXmlType;


public class BaseDataSetter {
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
	
	public static TurnRatioXmlType createTurnRatioPU(double p) {
		TurnRatioXmlType r = getFactory().createTurnRatioXmlType();
		r.setValue(p);
    	r.setUnit(TurnRatioUnitType.PU);
    	return r;
	}	
	
	private static ObjectFactory _factory = null;	
	protected static ObjectFactory getFactory() {
		if (_factory == null)
			_factory = new ObjectFactory();
		return _factory;
	}
}
