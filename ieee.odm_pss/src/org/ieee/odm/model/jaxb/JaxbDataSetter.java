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

package org.ieee.odm.model.jaxb;

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
	 * Set apparent power, unit = kva
	 * 
	 * @param power
	 * @param kva
	 */
	public static void setPowerKva(ApparentPowerXmlType power, double kva) {
		power.setValue(kva);   
		power.setUnit(ApparentPowerUnitType.KVA); 		
	}
	
	/**
	 * Set apparent power, unit = mva
	 * 
	 * @param power
	 * @param mva
	 */
	public static void setPowerMva(ApparentPowerXmlType power, double mva) {
		power.setValue(mva);   
		power.setUnit(ApparentPowerUnitType.MVA); 		
	}

	/**
	 * Set apparent power
	 * 
	 * @param power
	 * @param p
	 * @param unit
	 */
	public static void setActivePower(ActivePowerXmlType power, double p, ActivePowerUnitType unit) {
		power.setValue(p);   
		power.setUnit(unit); 		
	}

	/**
	 * set reactive power
	 * 
	 * @param power
	 * @param q
	 * @param unit
	 */
	public static void setReactivePower(ReactivePowerXmlType power, double q, ReactivePowerUnitType unit) {
		power.setValue(q);   
		power.setUnit(unit); 		
	}
	
	/**
	 * Set value (r, x, unit) to the z object
	 * 
	 * @param z
	 * @param r
	 * @param x
	 * @param unit
	 */
	public static void setZValue(ZXmlType z, double r, double x, ZUnitType unit) {
		z.setRe(r);
		z.setIm(x);
		z.setUnit(unit);
	}
 
	public static void setRValue(RXmlType rRec, double r, ZUnitType unit) {
		rRec.setR(r);
		rRec.setUnit(unit);
	}

	/**
	 * Set value (g, b, unit) to the y object
	 * 
	 * @param y
	 * @param g
	 * @param b
	 * @param unit
	 */
	public static void setYData(YXmlType y, double g, double b, YUnitType unit) {
		y.setRe(g);
		y.setIm(b);
		y.setUnit(unit);
	}
	
	public static void setGData(GXmlType gRec, double g, YUnitType unit) {
		gRec.setG(g);
		gRec.setUnit(unit);
	}
	
	/**
	 * Set value (p, q, unit) to the power object
	 * 
	 * @param power
	 * @param p
	 * @param q
	 * @param unit
	 */
	public static void setPowerData(PowerXmlType power, double p, double q, ApparentPowerUnitType unit) {
    	power.setRe(p);
    	power.setIm(q);
    	power.setUnit(unit);		
	}
	
	/**
	 * Set tap, unit = PU
	 * 
	 * @param tap
	 * @param p
	 */
	public static void setTapPU(TapXmlType tap, double p) {
    	tap.setValue(p);
    	tap.setUnit(TurnRatioUnitType.PU);		
	}
	
	public static void setTurnRatioPU(TurnRatioXmlType r, double p) {
    	r.setValue(p);
    	r.setUnit(TurnRatioUnitType.PU);		
	}
	
	/**
	 * set value (v, unit) to the voltage object
	 * 
	 * @param voltage
	 * @param v
	 * @param unit
	 */
	public static void setVoltageData(VoltageXmlType voltage, double v, VoltageUnitType unit) {
    	voltage.setValue(v);
    	voltage.setUnit(unit);		
	}
	
	/**
	 * set value (i, unit) to the current object
	 * 
	 * @param current
	 * @param i
	 * @param unit
	 */
	public static void setCurrentData(CurrentXmlType current, double i, CurrentUnitType unit) {
    	current.setValue(i);
    	current.setUnit(unit);
    			
	}

	/**
	 * set value (a, unit) to the angle object
	 * 
	 * @param angle
	 * @param a
	 * @param unit
	 */
	public static void setAngleData(AngleXmlType angle, double a, AngleUnitType unit) {
    	angle.setValue(a);
    	angle.setUnit(unit);		
	}
	
	/**
	 * Set time/period
	 * 
	 * @param time
	 * @param t
	 * @param unit
	 */
	public static void setTimePeriodData(TimePeriodXmlType time, double t,TimePeriodUnitType unit){
		time.setValue(t);
		time.setUnit(unit);
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
	 * set voltage limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static void setVoltageLimitData(VoltageLimitXmlType limit, double max, double min, VoltageUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}

	/**
	 * Set active power limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static void setActivePowerLimitData(ActivePowerLimitXmlType limit, double max, double min, ActivePowerUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}

	/**
	 * Set reactive power limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static void setReactivePowerLimitData(ReactivePowerLimitXmlType limit, double max, double min, ReactivePowerUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}

	/**
	 * set tap limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 */
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

	/**
	 * set angle limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static void setAngleLimitData(AngleLimitXmlType limit, double max, double min, AngleUnitType unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
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
    	PowerXmlType power = factory.createPowerXmlType();
    	equivLoad.setConstPLoad(power);
    	setPowerData(power, p, q, unit);
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
   		PowerXmlType power = factory.createPowerXmlType();
   		equivGen.setPower(power);
   		setPowerData(power, p, q, pUnit);
   		if (code == LFGenCodeEnumType.PV) {
   			VoltageXmlType voltage = factory.createVoltageXmlType();
   			equivGen.setDesiredVoltage(voltage);
   			setVoltageData(voltage, v, vUnit);
   		}
   		else if (code == LFGenCodeEnumType.SWING) {
   			VoltageXmlType voltage = factory.createVoltageXmlType();
   			AngleXmlType angle = factory.createAngleXmlType();
   			setVoltageData(voltage, v, vUnit);
   			setAngleData(angle, ang, angUnit);
   			equivGen.setDesiredVoltage(voltage);
   			equivGen.setDesiredAngle(angle);
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
			             double g, double b, YUnitType yUnit,
			             ObjectFactory factory) {
		branchData.setCode(LFBranchCodeEnumType.LINE);
		ZXmlType z = new ZXmlType();
		setZValue(z, r, x, zUnit);
		branchData.setZ(z);
		if (g != 0.0 || b != 0.0) {
			YXmlType y = factory.createYXmlType();
			setYData(y, g, b, yUnit);
			branchData.setTotalShuntY(y);
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
			             double gFrom, double bFrom, double gTo, double bTo, YUnitType yUnit, ObjectFactory factory) {
		branchData.setCode(LFBranchCodeEnumType.TRANSFORMER);
		setXformerData(branchData,
				r, x, zUnit, fromTap, toTap,
				gFrom, bFrom, gTo, bTo, yUnit, factory);
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
            double r, double x, ZUnitType zUnit, double fromTap, double toTap, ObjectFactory factory) {
		createXformerData(branchData, r, x, zUnit, fromTap, toTap, 
				0.0, 0.0, 0.0, 0.0, YUnitType.PU, factory);
	}
	

	private static void setXformerData(LoadflowBranchDataXmlType xfrData,
			double r, double x, ZUnitType zUnit, 
			double fromTap, double toTap,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType yUnit,
			ObjectFactory factory) {
		ZXmlType z = new ZXmlType();
		setZValue(z, r, x, zUnit);
		xfrData.setZ(z);
		TurnRatioXmlType fromRatio = factory.createTurnRatioXmlType();
		TurnRatioXmlType toRatio = factory.createTurnRatioXmlType();
		setTurnRatioPU(fromRatio, fromTap);
		setTurnRatioPU(toRatio, toTap);
		xfrData.setFromTurnRatio(fromRatio);
		xfrData.setToTurnRatio(toRatio);
		if (gFrom != 0.0 || bFrom != 0.0) {
			YXmlType y = factory.createYXmlType();
			setYData(y, gFrom, bFrom, yUnit);
			xfrData.setFromShuntY(y);
		}	
		if (gTo != 0.0 || bTo != 0.0) {
			YXmlType y = factory.createYXmlType();
			setYData(y, gTo, bTo, yUnit);
			xfrData.setToShuntY(y);
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
			double gFrom, double bFrom, double gTo, double bTo, YUnitType yUnit, ObjectFactory factory) {
		branchData.setCode(LFBranchCodeEnumType.PHASE_SHIFT_XFORMER);
		setXformerData(branchData,
				r, x, zUnit, fromTap, toTap, gFrom, bFrom, gTo, bTo, yUnit, factory);
		if (fromAng != 0.0) {
			AngleXmlType angle = new AngleXmlType();
			setAngleData(angle, fromAng, angUnit);
			branchData.setFromAngle(angle);
		}
		if (toAng != 0.0) {
			AngleXmlType angle = new AngleXmlType();
			setAngleData(angle, toAng, angUnit);
			branchData.setToAngle(angle);
		}
	}

	public static void createPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZUnitType zUnit,
			double fromTap, double toTap,
			double fromAng, double toAng, AngleUnitType angUnit,
			ObjectFactory factory) {
		createPhaseShiftXfrData(branchData, r, x, zUnit,
				fromTap, toTap, fromAng, toAng, angUnit,
				0.0, 0.0, 0.0, 0.0, YUnitType.PU, factory);
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
				double current, CurrentUnitType curUnit, ObjectFactory factory) {
    	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0 || current != 0.0) {
        	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0) {
        		MvaRatingXmlType mvaRating = factory.createMvaRatingXmlType();
        		branchLimit.setMva(mvaRating);
        		mvaRating.setRating1(mvar1);
        		mvaRating.setRating2(mvar2);
        		mvaRating.setRating3(mvar3);
        		mvaRating.setUnit(mvarUnit);
        	}

        	if (current != 0.0) {
        		CurrentXmlType limit = factory.createCurrentXmlType();
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
				double mvar1, double mvar2, double mvar3, ApparentPowerUnitType mvarUnit,
				ObjectFactory factory) {
		setBranchRatingLimitData(branchLimit, mvar1, mvar2, mvar3, mvarUnit, 0.0, null, factory);
	}

	public static void setBranchRatingLimitData(BranchRatingLimitXmlType branchLimit, 
			double[] mvarAry, ApparentPowerUnitType mvarUnit,
			ObjectFactory factory) {
		setBranchRatingLimitData(branchLimit, mvarAry[0], mvarAry[1], mvarAry[2], mvarUnit, factory);
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
				double current, CurrentUnitType curUnit, ObjectFactory factory) {
		setBranchRatingLimitData(branchLimit, 0.0, 0.0, 0.0, null, current, curUnit, factory);
	}
	
	/**
	 * Set branch ownership
	 * 
	 * @param branchData
	 * @param oAry
	 * @param pAry
	 */
	public static void setBranchOwnership(LoadflowBranchDataXmlType branchData,	int[] oAry, double[] pAry,
							ObjectFactory factory) {
		BaseRecordXmlType.OwnerList ownerList = factory.createBaseRecordXmlTypeOwnerList(); 
		branchData.setOwnerList(ownerList);
		for ( int i = 0; i < oAry.length; i++) {
			if (oAry[i] > 0) {
				Owner owner = factory.createBaseRecordXmlTypeOwnerListOwner();
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
			double normialMva, ApparentPowerUnitType pUnit,
			ObjectFactory factory) {
		if (branchData.getXfrInfo() == null) {
			LoadflowBranchDataXmlType.XfrInfo xfrInfo = factory.createLoadflowBranchDataXmlTypeXfrInfo();
			branchData.setXfrInfo(xfrInfo);
		}
		LoadflowBranchDataXmlType.XfrInfo xfrInfo = branchData.getXfrInfo();
		VoltageXmlType fromRatedVolt = factory.createVoltageXmlType();
		xfrInfo.setRatedVoltage1(fromRatedVolt);
		fromRatedVolt.setValue(fromRatedV);
		fromRatedVolt.setUnit(vUnit);
		VoltageXmlType toRatedVolt = factory.createVoltageXmlType();
		xfrInfo.setRatedVoltage2(toRatedVolt);
		toRatedVolt.setValue(toRatedV);
		toRatedVolt.setUnit(vUnit);
   		if (normialMva != 0.0) {
   			ApparentPowerXmlType ratedMva = factory.createApparentPowerXmlType();
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
			double fromRatedV, double toRatedV, VoltageUnitType vUnit,
			ObjectFactory factory) {
		setXfrRatingData(xfrData, fromRatedV, toRatedV, vUnit, 0.0, null, factory);
	}
}
