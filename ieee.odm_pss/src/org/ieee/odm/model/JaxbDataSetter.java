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
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.ApparentPowerXmlType;
import org.ieee.odm.schema.BaseRecordXmlType;
import org.ieee.odm.schema.BranchRatingLimitXmlType;
import org.ieee.odm.schema.CurrentUnitType;
import org.ieee.odm.schema.CurrentXmlType;
import org.ieee.odm.schema.LFBranchCodeEnumType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.LoadflowBusDataXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowLoadDataXmlType;
import org.ieee.odm.schema.MvaRatingXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.VoltageXmlType;
import org.ieee.odm.schema.YUnitType;
import org.ieee.odm.schema.ZUnitType;
import org.ieee.odm.schema.ZXmlType;
import org.ieee.odm.schema.BaseRecordXmlType.OwnerList.Owner;

public class JaxbDataSetter extends BaseDataSetter {
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
    	equivLoad.setConstPLoad(createPowerValue(p, q, unit));
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
			double p, double q, ApparentPowerUnitType pUnit) {
   		busData.setGenData(getFactory().createLoadflowBusDataXmlTypeGenData());
   		LoadflowGenDataXmlType equivGen = getFactory().createLoadflowGenDataXmlType();
   		busData.getGenData().setEquivGen(equivGen);
   		equivGen.setCode(code);
   		equivGen.setPower(createPowerValue(p, q, pUnit));
   		if (code == LFGenCodeEnumType.PV) {
   			equivGen.setDesiredVoltage(createVoltageValue(v, vUnit));
   		}
   		else if (code == LFGenCodeEnumType.SWING) {
   			equivGen.setDesiredVoltage(createVoltageValue(v, vUnit));
   			equivGen.setDesiredAngle(createAngleValue(ang, angUnit));
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
			branchData.setTotalShuntY(createYValue(g, b, yUnit));
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
			xfrData.setFromShuntY(createYValue(gFrom, bFrom, yUnit));
		}	
		if (gTo != 0.0 || bTo != 0.0) {
			xfrData.setToShuntY(createYValue(gTo, bTo, yUnit));
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
			branchData.setFromAngle(createAngleValue(fromAng, angUnit));
		}
		if (toAng != 0.0) {
			branchData.setToAngle(createAngleValue(toAng, angUnit));
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
}
