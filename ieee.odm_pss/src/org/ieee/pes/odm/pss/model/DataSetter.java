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

package org.ieee.pes.odm.pss.model;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFLoadCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowGenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.MvaRatingXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.RXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType.OwnerList.Owner;

public class DataSetter {
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
	public static void setActivePower(ActivePowerXmlType power, double p, ActivePowerUnitType.Enum unit) {
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
	public static void setReactivePower(ReactivePowerXmlType power, double q, ReactivePowerUnitType.Enum unit) {
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
	public static void setZValue(ZXmlType z, double r, double x, ZUnitType.Enum unit) {
		z.setRe(r);
		z.setIm(x);
		z.setUnit(unit);
	}
 
	public static void setRValue(RXmlType rRec, double r, ZUnitType.Enum unit) {
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
	public static void setYData(YXmlType y, double g, double b, YUnitType.Enum unit) {
		y.setRe(g);
		y.setIm(b);
		y.setUnit(unit);
	}
	
	public static void setGData(GXmlType gRec, double g, YUnitType.Enum unit) {
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
	public static void setPowerData(PowerXmlType power, double p, double q, ApparentPowerUnitType.Enum unit) {
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
    	tap.setUnit(TapUnitType.PU);		
	}
	
	/**
	 * set value (v, unit) to the voltage object
	 * 
	 * @param voltage
	 * @param v
	 * @param unit
	 */
	public static void setVoltageData(VoltageXmlType voltage, double v, VoltageUnitType.Enum unit) {
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
	public static void setCurrentData(CurrentXmlType current, double i, CurrentUnitType.Enum unit) {
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
	public static void setAngleData(AngleXmlType angle, double a, AngleUnitType.Enum unit) {
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
	public static void setTimePeriodData(TimePeriodXmlType time, double t,TimePeriodUnitType.Enum unit){
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
	public static void setVoltageLimitData(VoltageLimitXmlType limit, double max, double min, VoltageUnitType.Enum unit) {
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
	public static void setActivePowerLimitData(ActivePowerLimitXmlType limit, double max, double min, ActivePowerUnitType.Enum unit) {
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
	public static void setReactivePowerLimitData(ReactivePowerLimitXmlType limit, double max, double min, ReactivePowerUnitType.Enum unit) {
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
		limit.setUnit(TapUnitType.PU);
	}

	/**
	 * set angle limit data
	 * 
	 * @param limit
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static void setAngleLimitData(AngleLimitXmlType limit, double max, double min, AngleUnitType.Enum unit) {
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
	public static void setLoadData(LoadflowBusDataXmlType busData, LFLoadCodeEnumType.Enum code, 
			double p, double q, ApparentPowerUnitType.Enum unit) {
		busData.addNewLoadData().addNewEquivLoad();
    	busData.getLoadData().getEquivLoad().setCode(code);
    	setPowerData(busData.getLoadData().getEquivLoad().addNewConstPLoad(), p, q, unit);
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
	public static void setGenData(LoadflowBusDataXmlType busData, LFGenCodeEnumType.Enum code, 
			double v, VoltageUnitType.Enum vUnit,
			double ang, AngleUnitType.Enum angUnit,
			double p, double q, ApparentPowerUnitType.Enum pUnit) {
   		busData.addNewGenData();
   		LoadflowGenDataXmlType equivGen = busData.getGenData().addNewEquivGen();
   		equivGen.setCode(code);
   		setPowerData(equivGen.addNewPower(), p, q, pUnit);
   		if (code == LFGenCodeEnumType.PV) {
   			setVoltageData(equivGen.addNewDesiredVoltage(), v, vUnit);
   		}
   		else if (code == LFGenCodeEnumType.SWING) {
   			setVoltageData(equivGen.addNewDesiredVoltage(), v, vUnit);
   			setAngleData(equivGen.addNewDesiredAngle(), ang, angUnit);
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
			             double r, double x, ZUnitType.Enum zUnit, 
			             double g, double b, YUnitType.Enum yUnit) {
		branchData.setCode(LFBranchCodeEnumType.LINE);
		setZValue(branchData.addNewZ(), r, x, zUnit);
		if (g != 0.0 || b != 0.0) 
			setYData(branchData.addNewTotalShuntY(), g, b, yUnit);
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
			             double r, double x, ZUnitType.Enum zUnit,
			             double fromTap, double toTap,
			             double gFrom, double bFrom, double gTo, double bTo, YUnitType.Enum yUnit) {
		branchData.setCode(LFBranchCodeEnumType.TRANSFORMER);
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
            double r, double x, ZUnitType.Enum zUnit, double fromTap, double toTap) {
		createXformerData(branchData, r, x, zUnit, fromTap, toTap, 0.0, 0.0, 0.0, 0.0, YUnitType.PU);
	}
	

	private static void setXformerData(LoadflowBranchDataXmlType xfrData,
			double r, double x, ZUnitType.Enum zUnit, 
			double fromTap, double toTap,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType.Enum yUnit) {
		setZValue(xfrData.addNewZ(), r, x, zUnit);
		setTapPU(xfrData.addNewFromTap(), fromTap);
		setTapPU(xfrData.addNewToTap(), toTap);
		if (gFrom != 0.0 || bFrom != 0.0)
			setYData(xfrData.addNewFromShuntY(),
					gFrom, bFrom, yUnit);
		if (gTo != 0.0 || bTo != 0.0)
			setYData(xfrData.addNewToShuntY(), gTo, bTo, yUnit);
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
			double r, double x, ZUnitType.Enum zUnit,
			double fromTap, double toTap, double fromAng, double toAng, AngleUnitType.Enum angUnit,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType.Enum yUnit) {
		branchData.setCode(LFBranchCodeEnumType.PHASE_SHIFT_XFORMER);
		setXformerData(branchData,
				r, x, zUnit, fromTap, toTap, gFrom, bFrom, gTo, bTo, yUnit);
		if (fromAng != 0.0)
			setAngleData(branchData.addNewFromAngle(), fromAng, angUnit);
		if (toAng != 0.0)
			setAngleData(branchData.addNewToAngle(), toAng, angUnit);
	}

	public static void createPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZUnitType.Enum zUnit,
			double fromTap, double toTap,
			double fromAng, double toAng, AngleUnitType.Enum angUnit) {
		createPhaseShiftXfrData(branchData, r, x, zUnit,
				fromTap, toTap, fromAng, toAng, angUnit,
				0.0, 0.0, 0.0, 0.0, YUnitType.PU);
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
				double mvar1, double mvar2, double mvar3, ApparentPowerUnitType.Enum mvarUnit,
				double current, CurrentUnitType.Enum curUnit) {
    	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0 || current != 0.0) {
    		branchData.addNewBranchRatingLimit();
        	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0) {
        		MvaRatingXmlType mvaRating = branchData.getBranchRatingLimit().addNewMva();
        		mvaRating.setRating1(mvar1);
        		mvaRating.setRating2(mvar2);
        		mvaRating.setRating3(mvar3);
        		mvaRating.setUnit(mvarUnit);
        	}

        	if (current != 0.0) {
        		CurrentXmlType limit = branchData.getBranchRatingLimit().addNewCurrent();
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
	public static void setBranchRatingLimitData(LoadflowBranchDataXmlType branchData, 
				double mvar1, double mvar2, double mvar3, ApparentPowerUnitType.Enum mvarUnit) {
		setBranchRatingLimitData(branchData, mvar1, mvar2, mvar3, mvarUnit, 0.0, null);
	}

	public static void setBranchRatingLimitData(LoadflowBranchDataXmlType branchData, 
			double[] mvarAry, ApparentPowerUnitType.Enum mvarUnit) {
		setBranchRatingLimitData(branchData, mvarAry[0], mvarAry[1], mvarAry[2], mvarUnit);
		MvaRatingXmlType mvaRating = branchData.getBranchRatingLimit().getMva();
		mvaRating.addNewRatingAry();
		for (double x : mvarAry)
			if (x > 0.0)
				mvaRating.addRatingAry(x);
	}
	/**
	 * add a RatingLimitData object to the branchData object, then set value(curLimit, curUnit) 
	 * to the created RatingLimitData object
	 * 
	 * @param branchData
	 * @param current
	 * @param curUnit
	 */
	public static void setBranchRatingLimitData(LoadflowBranchDataXmlType branchData, 
				double current, CurrentUnitType.Enum curUnit) {
		setBranchRatingLimitData(branchData, 0.0, 0.0, 0.0, null, current, curUnit);
	}
	
	/**
	 * Set branch ownership
	 * 
	 * @param branchData
	 * @param oAry
	 * @param pAry
	 */
	public static void setBranchOwnership(LoadflowBranchDataXmlType branchData,	int[] oAry, double[] pAry) {
		branchData.addNewOwnerList();
		for ( int i = 0; i < oAry.length; i++) {
			if (oAry[i] > 0) {
				Owner owner = branchData.getOwnerList().addNewOwner();
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
			double fromRatedV, double toRatedV, VoltageUnitType.Enum vUnit,
			double normialMva, ApparentPowerUnitType.Enum pUnit) {
		if (branchData.getXfrInfo() == null)
			branchData.addNewXfrInfo();
		LoadflowBranchDataXmlType.XfrInfo xfrInfo = branchData.getXfrInfo();
		VoltageXmlType fromRatedVolt = xfrInfo.addNewRatedVoltage1();
		fromRatedVolt.setValue(fromRatedV);
		fromRatedVolt.setUnit(vUnit);
		VoltageXmlType toRatedVolt = xfrInfo.addNewRatedVoltage2();
		toRatedVolt.setValue(toRatedV);
		toRatedVolt.setUnit(vUnit);
   		if (normialMva != 0.0) {
   			ApparentPowerXmlType ratedMva = xfrInfo.addNewRatedPower12();
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
			double fromRatedV, double toRatedV, VoltageUnitType.Enum vUnit) {
		setXfrRatingData(xfrData, fromRatedV, toRatedV, vUnit, 0.0, null);
	}
}
