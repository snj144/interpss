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
import org.ieee.odm.schema.BaseRecordXmlType;
import org.ieee.odm.schema.BranchRatingLimitXmlType;
import org.ieee.odm.schema.CurrentUnitType;
import org.ieee.odm.schema.CurrentXmlType;
import org.ieee.odm.schema.GXmlType;
import org.ieee.odm.schema.IDRefRecordXmlType;
import org.ieee.odm.schema.LFBranchCodeEnumType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LimitXmlType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.LoadflowBusDataXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowLoadDataXmlType;
import org.ieee.odm.schema.MvaRatingXmlType;
import org.ieee.odm.schema.ObjectFactory;
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
import org.ieee.odm.schema.BaseRecordXmlType.OwnerList.Owner;

public class JaxbDataSetter {
	/**
	 * create a ref record with id
	 * 
	 * @param id
	 * @return
	 */
	public static IDRefRecordXmlType createIdRef(String id) {
		IDRefRecordXmlType refBus = getFactory().createIDRefRecordXmlType();
		refBus.setIdRef(id);
		return refBus;
	}
	
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
	public static ApparentPowerXmlType createPowerKva(double kva) {
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
	/*
	public static void setPowerMva(ApparentPowerXmlType power, double mva) {
		power.setValue(mva);   
		power.setUnit(ApparentPowerUnitType.MVA); 		
	}
	*/
	public static ApparentPowerXmlType createPowerMva(double mva) {
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
	/*
	public static void setActivePower(ActivePowerXmlType power, double p, ActivePowerUnitType unit) {
		power.setValue(p);   
		power.setUnit(unit); 		
	}
	*/
	public static ActivePowerXmlType createActivePower(double p, ActivePowerUnitType unit) {
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
	/*
	public static void setReactivePower(ReactivePowerXmlType power, double q, ReactivePowerUnitType unit) {
		power.setValue(q);   
		power.setUnit(unit); 		
	}
	*/
	public static ReactivePowerXmlType createReactivePower(double q, ReactivePowerUnitType unit) {
		ReactivePowerXmlType power = getFactory().createReactivePowerXmlType();
		power.setValue(q);   
		power.setUnit(unit); 		
		return power;
	}	
	/**
	 * Set value (r, x, unit) to the z object
	 * 
	 * @param z
	 * @param r
	 * @param x
	 * @param unit
	 */
	/*
	public static void setZValue(ZXmlType z, double r, double x, ZUnitType unit) {
		z.setRe(r);
		z.setIm(x);
		z.setUnit(unit);
	}
	public static void setRValue(RXmlType rRec, double r, ZUnitType unit) {
		rRec.setR(r);
		rRec.setUnit(unit);
	}
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
	/*
	public static void setYData(YXmlType y, double g, double b, YUnitType unit) {
		y.setRe(g);
		y.setIm(b);
		y.setUnit(unit);
	}
	public static void setGData(GXmlType gRec, double g, YUnitType unit) {
		gRec.setG(g);
		gRec.setUnit(unit);
	}
	*/
	
	public static YXmlType createYData(double g, double b, YUnitType unit) {
		YXmlType y = getFactory().createYXmlType();  
		y.setRe(g);
		y.setIm(b);
		y.setUnit(unit);
		return y;
	}
	
	public static GXmlType createGData(double g, YUnitType unit) {
		GXmlType gRec = getFactory().createGXmlType();
		gRec.setG(g);
		gRec.setUnit(unit);
		return gRec;
	}
	
	/**
	 * Set value (p, q, unit) to the power object
	 * 
	 * @param power
	 * @param p
	 * @param q
	 * @param unit
	 */
	/*
	public static void setPowerData(PowerXmlType power, double p, double q, ApparentPowerUnitType unit) {
    	power.setRe(p);
    	power.setIm(q);
    	power.setUnit(unit);		
	}
	*/
	public static PowerXmlType createPowerData(double p, double q, ApparentPowerUnitType unit) {
		PowerXmlType power = getFactory().createPowerXmlType();
		power.setRe(p);
    	power.setIm(q);
    	power.setUnit(unit);
    	return power;
	}
	
	/**
	 * Set tap, unit = PU
	 * 
	 * @param tap
	 * @param p
	 */
	/*
	public static void setTapPU(TapXmlType tap, double p) {
    	tap.setValue(p);
    	tap.setUnit(TurnRatioUnitType.PU);		
	}
	
	public static void setTurnRatioPU(TurnRatioXmlType r, double p) {
    	r.setValue(p);
    	r.setUnit(TurnRatioUnitType.PU);		
	}
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
	
	/**
	 * set value (v, unit) to the voltage object
	 * 
	 * @param voltage
	 * @param v
	 * @param unit
	 */
	/*
	public static void setVoltageData(VoltageXmlType voltage, double v, VoltageUnitType unit) {
    	voltage.setValue(v);
    	voltage.setUnit(unit);		
	}
	*/
	public static VoltageXmlType createVoltageData(double v, VoltageUnitType unit) {
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
	/*
	public static void setCurrentData(CurrentXmlType current, double i, CurrentUnitType unit) {
    	current.setValue(i);
    	current.setUnit(unit);
    			
	}
	*/
	public static CurrentXmlType createCurrentData(double i, CurrentUnitType unit) {
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
	/*
	public static void setAngleData(AngleXmlType angle, double a, AngleUnitType unit) {
    	angle.setValue(a);
    	angle.setUnit(unit);		
	}
    */
	public static AngleXmlType createAngleData(double a, AngleUnitType unit) {
		AngleXmlType angle = getFactory().createAngleXmlType();
    	angle.setValue(a);
    	angle.setUnit(unit);		
    	return angle;
	}
	
	/**
	 * Set time/period
	 * 
	 * @param time
	 * @param t
	 * @param unit
	 */
	/*
	public static void setTimePeriodData(TimePeriodXmlType time, double t,TimePeriodUnitType unit){
		time.setValue(t);
		time.setUnit(unit);
	}
	*/
	public static TimePeriodXmlType createTimePeriodData(double t,TimePeriodUnitType unit){
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
	public static void setLimitData(LimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
	}

	public static LimitXmlType createLimitData(double max, double min) {
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
	/*
	public static void setVoltageLimitData(VoltageLimitXmlType limit, double max, double min, VoltageUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}
	*/
	public static VoltageLimitXmlType createVoltageLimitData(double max, double min, VoltageUnitType unit) {
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
	/*
	public static void setActivePowerLimitData(ActivePowerLimitXmlType limit, double max, double min, ActivePowerUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}
	*/
	public static ActivePowerLimitXmlType createActivePowerLimitData(double max, double min, ActivePowerUnitType unit) {
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
	/*
	public static void setReactivePowerLimitData(ReactivePowerLimitXmlType limit, double max, double min, ReactivePowerUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}
	*/
	public static ReactivePowerLimitXmlType createReactivePowerLimitData(double max, double min, ReactivePowerUnitType unit) {
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
	/*
	public static void setTapLimitData(TapLimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(TurnRatioUnitType.PU);
	}
	public static void setTurnRatioLimitData(TurnRatioLimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(TurnRatioUnitType.PU);
	}
	*/
	public static TapLimitXmlType createTapLimitData(double max, double min) {
		TapLimitXmlType limit = getFactory().createTapLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(TurnRatioUnitType.PU);
		return limit;
	}

	public static TurnRatioLimitXmlType createTurnRatioLimitData(double max, double min) {
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
	/*
	public static void setAngleLimitData(AngleLimitXmlType limit, double max, double min, AngleUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}
	*/
	public static AngleLimitXmlType createAngleLimitData(double max, double min, AngleUnitType unit) {
		AngleLimitXmlType limit = getFactory().createAngleLimitXmlType();
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
		return limit;
	}
	
	/**
	 * set load data, first create an equivLoad object, then set value(code, p, q, unit) to the created EquivLoadData object
	 * 
	 * @param busData
	 * @param code
	 * @param p
	 * @param q
	 * @param unit
	 */
	public static void setLoadData(LoadflowBusDataXmlType busData, 
			LFLoadCodeEnumType code, 
			double p, double q, ApparentPowerUnitType unit,
			ObjectFactory factory) {
		LoadflowBusDataXmlType.LoadData loadData = factory.createLoadflowBusDataXmlTypeLoadData();
		busData.setLoadData(loadData);
		LoadflowLoadDataXmlType equivLoad = factory.createLoadflowLoadDataXmlType();
		loadData.setEquivLoad(equivLoad);
    	busData.getLoadData().getEquivLoad().setCode(code);
    	equivLoad.setConstPLoad(createPowerData(p, q, unit));
	}
	
	/**
	 * set EquivGen object, then set value(code, p, q, unit) to the created EquivGenData object
	 * 
	 * @param busData
	 * @param code
	 * @param p
	 * @param q
	 * @param pUnit
	 */
	public static void setGenData(LoadflowBusDataXmlType busData, LFGenCodeEnumType code, 
			double v, VoltageUnitType vUnit,
			double ang, AngleUnitType angUnit,
			double p, double q, ApparentPowerUnitType pUnit,
			ObjectFactory factory) {
   		busData.setGenData(factory.createLoadflowBusDataXmlTypeGenData());
   		LoadflowGenDataXmlType equivGen = factory.createLoadflowGenDataXmlType();
   		busData.getGenData().setEquivGen(equivGen);
   		equivGen.setCode(code);
   		equivGen.setPower(createPowerData(p, q, pUnit));
   		if (code == LFGenCodeEnumType.PV) {
   			equivGen.setDesiredVoltage(createVoltageData(v, vUnit));
   		}
   		else if (code == LFGenCodeEnumType.SWING) {
   			equivGen.setDesiredVoltage(createVoltageData(v, vUnit));
   			equivGen.setDesiredAngle(createAngleData(ang, angUnit));
   		}
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
			             double r, double x, ZUnitType zUnit, 
			             double g, double b, YUnitType yUnit) {
		branchData.setCode(LFBranchCodeEnumType.LINE);
		ZXmlType z = createZValue(r, x, zUnit);
		branchData.setZ(z);
		if (g != 0.0 || b != 0.0) {
			branchData.setTotalShuntY(createYData(g, b, yUnit));
		}
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
	public static void createXformerData(LoadflowBranchDataXmlType branchData, 
			             double r, double x, ZUnitType zUnit,
			             double fromTap, double toTap,
			             double gFrom, double bFrom, double gTo, double bTo, YUnitType yUnit) {
		branchData.setCode(LFBranchCodeEnumType.TRANSFORMER);
		branchData.setXfrInfo(getFactory().createLoadflowBranchDataXmlTypeXfrInfo());
		branchData.getXfrInfo().setDataOnSystemBase(true);
		setXformerData(branchData,
				r, x, zUnit, fromTap, toTap,
				gFrom, bFrom, gTo, bTo, yUnit);
	}

	/**
	 * 
	 * 
	 * @param branchData
	 * @param r
	 * @param x
	 * @param zUnit
	 * @param fromTap
	 * @param toTap
	 */
	public static void createXformerData(LoadflowBranchDataXmlType branchData, 
            double r, double x, ZUnitType zUnit, double fromTap, double toTap) {
		createXformerData(branchData, r, x, zUnit, fromTap, toTap, 
				0.0, 0.0, 0.0, 0.0, YUnitType.PU);
	}
	

	private static void setXformerData(LoadflowBranchDataXmlType xfrData,
			double r, double x, ZUnitType zUnit, 
			double fromTap, double toTap,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType yUnit) {
		ZXmlType z = createZValue(r, x, zUnit);
		xfrData.setZ(z);
		xfrData.setFromTurnRatio(createTurnRatioPU(fromTap));
		xfrData.setToTurnRatio(createTurnRatioPU(toTap));
		if (gFrom != 0.0 || bFrom != 0.0) {
			xfrData.setFromShuntY(createYData(gFrom, bFrom, yUnit));
		}	
		if (gTo != 0.0 || bTo != 0.0) {
			xfrData.setToShuntY(createYData(gTo, bTo, yUnit));
		}
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
	public static void createPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZUnitType zUnit,
			double fromTap, double toTap, double fromAng, double toAng, AngleUnitType angUnit,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType yUnit) {
		branchData.setCode(LFBranchCodeEnumType.PHASE_SHIFT_XFORMER);
		setXformerData(branchData,
				r, x, zUnit, fromTap, toTap, gFrom, bFrom, gTo, bTo, yUnit);
		if (fromAng != 0.0) {
			branchData.setFromAngle(createAngleData(fromAng, angUnit));
		}
		if (toAng != 0.0) {
			branchData.setToAngle(createAngleData(toAng, angUnit));
		}
	}

	public static void createPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZUnitType zUnit,
			double fromTap, double toTap,
			double fromAng, double toAng, AngleUnitType angUnit) {
		createPhaseShiftXfrData(branchData, r, x, zUnit,
				fromTap, toTap, fromAng, toAng, angUnit,
				0.0, 0.0, 0.0, 0.0, YUnitType.PU);
	}

	
	/**
	 * add a RatingLimitData object to the branchData object, then set value(mvarLimit1, mvarLimit2, mvarLimit3, mvarUnit, curLimit, curUnit) 
	 * to the created RatingLimitData object
	 * 
	 * @param branchLimit
	 * @param mvar1
	 * @param mvar2
	 * @param mvar3
	 * @param mvarUnit
	 * @param current
	 * @param curUnit
	 */
	public static void setBranchRatingLimitData(BranchRatingLimitXmlType branchLimit, 
				double mvar1, double mvar2, double mvar3, ApparentPowerUnitType mvarUnit,
				double current, CurrentUnitType curUnit) {
    	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0 || current != 0.0) {
        	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0) {
        		MvaRatingXmlType mvaRating = getFactory().createMvaRatingXmlType();
        		branchLimit.setMva(mvaRating);
        		mvaRating.setRating1(mvar1);
        		mvaRating.setRating2(mvar2);
        		mvaRating.setRating3(mvar3);
        		mvaRating.setUnit(mvarUnit);
        	}

        	if (current != 0.0) {
        		CurrentXmlType limit = getFactory().createCurrentXmlType();
        		branchLimit.setCurrent(limit);
        		limit.setValue(current);
        		limit.setUnit(curUnit);
        	}
    	}
		
	}

	/**
	 * add a RatingLimitData object to the branchData object, then set value(mvarLimit1, mvarLimit2, mvarLimit3, mvarUnit) 
	 * to the created RatingLimitData object
	 * 
	 * @param branchData
	 * @param mvar1
	 * @param mvar2
	 * @param mvar3
	 * @param mvarUnit
	 */
	public static void setBranchRatingLimitData(BranchRatingLimitXmlType branchLimit, 
				double mvar1, double mvar2, double mvar3, ApparentPowerUnitType mvarUnit) {
		setBranchRatingLimitData(branchLimit, mvar1, mvar2, mvar3, mvarUnit, 0.0, null);
	}

	public static void setBranchRatingLimitData(BranchRatingLimitXmlType branchLimit, 
			double[] mvarAry, ApparentPowerUnitType mvarUnit) {
		setBranchRatingLimitData(branchLimit, mvarAry[0], mvarAry[1], mvarAry[2], mvarUnit);
		MvaRatingXmlType mvaRating = branchLimit.getMva();
		for (double x : mvarAry)
			if (x > 0.0) {
				mvaRating.getRatingAry().add(x);
			}
	}
	/**
	 * add a RatingLimitData object to the branchData object, then set value(curLimit, curUnit) 
	 * to the created RatingLimitData object
	 * 
	 * @param branchData
	 * @param current
	 * @param curUnit
	 */
	public static void setBranchRatingLimitData(BranchRatingLimitXmlType branchLimit, 
				double current, CurrentUnitType curUnit) {
		setBranchRatingLimitData(branchLimit, 0.0, 0.0, 0.0, null, current, curUnit);
	}
	
	/**
	 * Set branch ownership
	 * 
	 * @param branchData
	 * @param oAry
	 * @param pAry
	 */
	public static void setBranchOwnership(LoadflowBranchDataXmlType branchData,	int[] oAry, double[] pAry) {
		BaseRecordXmlType.OwnerList ownerList = getFactory().createBaseRecordXmlTypeOwnerList(); 
		branchData.setOwnerList(ownerList);
		for ( int i = 0; i < oAry.length; i++) {
			if (oAry[i] > 0) {
				Owner owner = getFactory().createBaseRecordXmlTypeOwnerListOwner();
				branchData.getOwnerList().getOwner().add(owner);
				owner.setId(new Integer(oAry[i]).toString());
				owner.setOwnership(pAry[i]);
			}
		}
	}
	
	/**
	 * set transformer rating data
	 *  
	 * @param branchData
	 * @param fromRatedV
	 * @param toRatedV
	 * @param vUnit
	 * @param normialMva
	 * @param pUnit
	 */
	public static void setXfrRatingData(LoadflowBranchDataXmlType branchData, 
			double fromRatedV, double toRatedV, VoltageUnitType vUnit,
			double normialMva, ApparentPowerUnitType pUnit) {
		if (branchData.getXfrInfo() == null) {
			LoadflowBranchDataXmlType.XfrInfo xfrInfo = getFactory().createLoadflowBranchDataXmlTypeXfrInfo();
			branchData.setXfrInfo(xfrInfo);
		}
		LoadflowBranchDataXmlType.XfrInfo xfrInfo = branchData.getXfrInfo();
		VoltageXmlType fromRatedVolt = getFactory().createVoltageXmlType();
		xfrInfo.setRatedVoltage1(fromRatedVolt);
		fromRatedVolt.setValue(fromRatedV);
		fromRatedVolt.setUnit(vUnit);
		VoltageXmlType toRatedVolt = getFactory().createVoltageXmlType();
		xfrInfo.setRatedVoltage2(toRatedVolt);
		toRatedVolt.setValue(toRatedV);
		toRatedVolt.setUnit(vUnit);
   		if (normialMva != 0.0) {
   			ApparentPowerXmlType ratedMva = getFactory().createApparentPowerXmlType();
   			xfrInfo.setRatedPower12(ratedMva);
   			ratedMva.setValue(normialMva);
   			ratedMva.setUnit(pUnit);		
   		}
	}

	/**
	 * set transformer rating data
	 * 
	 * @param xfrData
	 * @param fromRatedV
	 * @param toRatedV
	 * @param vUnit
	 */
	public static void setXfrRatingData(LoadflowBranchDataXmlType xfrData, 
			double fromRatedV, double toRatedV, VoltageUnitType vUnit) {
		setXfrRatingData(xfrData, fromRatedV, toRatedV, vUnit, 0.0, null);
	}
	
	private static ObjectFactory _factory = null;	
	private static ObjectFactory getFactory() {
		if (_factory == null)
			_factory = new ObjectFactory();
		return _factory;
	}
}
