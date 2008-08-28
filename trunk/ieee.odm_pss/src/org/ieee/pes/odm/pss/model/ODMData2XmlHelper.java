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

import org.apache.xmlbeans.XmlOptions;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CycleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PhaseShiftXfrDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimeXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;

public class ODMData2XmlHelper {
	public static final double Deg2Rad = Math.PI / 180.0;
	public static final double Rad2Deg = 180.0/ Math.PI;
	
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
	 * add an owner record to the BaseRecord
	 * 
	 * @param rec
	 * @param id
	 * @param ownership
	 */
	public static void addOwner(BaseRecordXmlType rec, String id, double ownership) {
		if (rec.getOwnerList() == null) {
			rec.addNewOwnerList();
		}
		BaseRecordXmlType.OwnerList.Owner owner = rec.getOwnerList().addNewOwner();
		owner.setId(id);
		owner.setOwnership(ownership);
	}
	
	/**
	 * add an owner records to the BaseRecord
	 * 
	 * @param rec
	 * @param id
	 * @param ownership
	 */
	public static void addOwner(BaseRecordXmlType rec, 
			String id1, double ownership1,
			String id2, double ownership2,
			String id3, double ownership3,
			String id4, double ownership4) {
		if (id1 != null)
			addOwner(rec, id1, ownership1);
		if (id2 != null)
			addOwner(rec, id2, ownership2);
		if (id1 != null)
			addOwner(rec, id3, ownership3);
		if (id1 != null)
			addOwner(rec, id4, ownership4);
	}

	/**
	 * Get bus record with the id
	 * 
	 * @param id
	 * @param baseCaseNet
	 * @return
	 */
	public static BusRecordXmlType getBusRecord(String id, PSSNetworkXmlType baseCaseNet) {
		for (BusRecordXmlType busRec : baseCaseNet.getBusList().getBusArray()) {
			if (id.equals(busRec.getId()))
				return busRec;
		}
		return null;
	}
	
	/**
	 * Get bus record with the id
	 * 
	 * @param id
	 * @param baseCaseNet
	 * @return
	 */
	public static BranchRecordXmlType getBranchRecord(String fromId, String toId, String cirId, PSSNetworkXmlType baseCaseNet) {
		for (BranchRecordXmlType braRec : baseCaseNet.getBranchList().getBranchArray()) {
			if (fromId.equals(braRec.getFromBus().getIdRef()) &&
					toId.equals(braRec.getToBus().getIdRef()) &&
							cirId.equals(braRec.getCircuitId()))
				return braRec;
		}
		return null;
	}
	
	/**
	 * Get converter record with the name
	 * 
	 * @param name
	 * @param baseCaseNet
	 * @return
	 */
	public static DCLineBusRecordXmlType.Converter getConverterRecord(String name, PSSNetworkXmlType baseCaseNet) {
		for (DCLineBusRecordXmlType dcLine : 
			baseCaseNet.getDcLineList().getDcLineBusList().getDcLineBusArray()) {
			DCLineBusRecordXmlType.Converter converter= dcLine.getConverter();
			if (name.equals(converter.getBusId().getName()))
				return converter;
		}
		return null;
	}
	
	/**
	 * Get transformer branch record with the id
	 * 
	 * @param id
	 * @param baseCaseNet
	 * @return
	 */
	public static BranchRecordXmlType getXfrBranchRecord(String fromId, String toId,PSSNetworkXmlType baseCaseNet) {
		for (BranchRecordXmlType braRec : baseCaseNet.getBranchList().getBranchArray()) {
			if (fromId.equals(braRec.getFromBus().getIdRef()) &&
					toId.equals(braRec.getToBus().getIdRef()))
				return braRec;
		}
		return null;
	}
	
	/**
	 * Get area record with the areaname
	 * 
	 * @param areaName
	 * @param baseCaseNet
	 * @return
	 */
	public static PSSNetworkXmlType.AreaList.Area getAreaRecordByAreaName(String areaName, PSSNetworkXmlType baseCaseNet) {
		for (PSSNetworkXmlType.AreaList.Area area:baseCaseNet.getAreaList().getAreaArray()) {
			if (areaName.equals(area.getAreaName()))
				return area;
		}
		return null;
	}
	
	/**
	 * Get area record with the zone
	 * 
	 * @param zoneName
	 * @param baseCaseNet
	 * @return
	 */
	public static PSSNetworkXmlType.AreaList.Area getAreaRecordByZone(String zoneName, PSSNetworkXmlType baseCaseNet) {
		for (PSSNetworkXmlType.AreaList.Area area:baseCaseNet.getAreaList().getAreaArray()) {
			for(PSSNetworkXmlType.AreaList.Area.ZoneList.Zone zone:
				area.getZoneList().getZoneArray()){
				if (zoneName.equals(zone.getZoneName()))
					return area;
			}			
		}
		return null;
	}
	
	public static FaultListXmlType.Fault getFaultRecord(TransientSimulationXmlType tranSimu,
			FaultListXmlType.Fault.FaultType.Enum faultType,String fbus,String tbus){
		if(tranSimu.getDynamicDataList().getFaultList().getFaultArray()!=null){			
			for(FaultListXmlType.Fault fault:tranSimu.getDynamicDataList().getFaultList().getFaultArray()){				
				if(faultType.equals(fault.getFaultType())){					
					if(faultType.equals(FaultListXmlType.Fault.FaultType.BUS_FAULT)){						
						FaultListXmlType.Fault.BusFault busFault=fault.getBusFault();
						if(fbus.equals(busFault.getFaultedBus().getName())&&
								tbus.equals(busFault.getRemoteEndBus().getName())){							
							return fault;							
						}
					}
				}				
			}		
		   }
		return tranSimu.getDynamicDataList().getFaultList().addNewFault();
		
		}		
  
	
	public static FaultListXmlType.Fault.BusFault getBusFaultRecord(TransientSimulationXmlType tranSimu,
			String fbus,String tbus){
		
		for(FaultListXmlType.Fault fault:tranSimu.getDynamicDataList().getFaultList().getFaultArray()){
			if(fault.getBusFault()!=null){
				FaultListXmlType.Fault.BusFault busFault=fault.getBusFault();				
				if(fbus.equals(busFault.getFaultedBus().getName())&& 
						tbus.equals(busFault.getRemoteEndBus().getName()))					
			         return busFault;
			}else{
				return fault.addNewBusFault();
			}			
		}
		return null;
	}
	
	public static FaultListXmlType.Fault.BranchFault getBranchFaultRecord(TransientSimulationXmlType tranSimu,
			String fbus,String tbus){
		
		for(FaultListXmlType.Fault fault:tranSimu.getDynamicDataList().getFaultList().getFaultArray()){
			if(fault.getBranchFault()!=null){
				FaultListXmlType.Fault.BranchFault braFault=fault.getBranchFault();
				
				if(fbus.equals(braFault.getFromBus().getName())&& tbus.equals(braFault.getToBus().getName()))
			         return braFault;
			}else{
				return fault.addNewBranchFault();
			}			
		}
		return null;
	}
	
	public static FaultListXmlType.Fault.DcLineFault getDCFaultRecord(TransientSimulationXmlType tranSimu,
			String fbus,String tbus){
		for(FaultListXmlType.Fault fault: tranSimu.getDynamicDataList().getFaultList().getFaultArray()){
			if(fault.getDcLineFault()!=null){				
				FaultListXmlType.Fault.DcLineFault dcFault= fault.getDcLineFault();				
				if(fbus.equals(dcFault.getFromACBusId().getName())&&
						tbus.equals(dcFault.getToACBusId().getName())){					
					return dcFault;
				}else {					
					return fault.addNewDcLineFault();
				}
			}
		}
		return null;
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
	 * set value (i, unit) to the current object
	 * 
	 * @param current
	 * @param i
	 * @param unit
	 */
	public static void setCurrentData(CurrentXmlType current, double i, CurrentXmlType.Unit.Enum unit) {
    	current.setCurrent(i);
    	current.setUnit(unit);
    			
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
	public static void setTimeData(CycleXmlType time, double t, TimeXmlType.Unit.Enum unit){
		time.setValue(t);
		time.setUnit(CycleXmlType.Unit.CYCLE);
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
   		ODMData2XmlHelper.setPowerData(busData.getGenData().addNewGen().addNewPower(), p, q, unit);
	}
	
	/**
	 * add a GenData.QGenLimit object and set max, min and unit
	 * 
	 * @param busData
	 * @param max
	 * @param min
	 * @param unit
	 */
	public static void setGenQLimitData(LoadflowBusDataXmlType.GenData genData,  
			double max, double min, GenDataXmlType.QGenLimit.QLimitUnit.Enum unit) {
		genData.getGen().addNewQGenLimit();
		ODMData2XmlHelper.setLimitData(genData.getGen().getQGenLimit()
				.addNewQLimit(), max, min);
		genData.getGen().getQGenLimit().setQLimitUnit(unit);	
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
		branchData.setCode(LoadflowBranchDataXmlType.Code.LINE);
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
		branchData.setCode(LoadflowBranchDataXmlType.Code.TRANSFORMER);
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
		branchData.setCode(LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER);
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
				double mvar1, double mvar2, double mvar3, LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.Enum mvarUnit) {
		setBranchRatingLimitData(branchData, mvar1, mvar2, mvar3, mvarUnit, 0.0, null);
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
				double current, LoadflowBranchDataXmlType.RatingLimit.CurrentRatingUnit.Enum curUnit) {
		setBranchRatingLimitData(branchData, 0.0, 0.0, 0.0, null, current, curUnit);
	}
	
	/**
	 * set transformer rating data
	 *  
	 * @param xfrData
	 * @param fromRatedV
	 * @param toRatedV
	 * @param vUnit
	 * @param normialMva
	 * @param pUnit
	 */
	public static void setXfrRatingData(TransformerDataXmlType xfrData, 
			double fromRatedV, double toRatedV, VoltageXmlType.Unit.Enum vUnit,
			double normialMva, PowerXmlType.Unit.Enum pUnit) {
		TransformerDataXmlType.RatingData ratingData = xfrData.addNewRatingData();
		VoltageXmlType fromRatedVolt = ratingData.addNewFromRatedVoltage();
		fromRatedVolt.setVoltage(fromRatedV);
		fromRatedVolt.setUnit(vUnit);
		VoltageXmlType toRatedVolt = ratingData.addNewToRatedVoltage();
		toRatedVolt.setVoltage(toRatedV);
		toRatedVolt.setUnit(vUnit);
   		if (normialMva != 0.0) {
   			PowerXmlType ratedMva = ratingData.addNewRatedPower();
   			ratedMva.setP(normialMva);
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
	public static void setXfrRatingData(TransformerDataXmlType xfrData, 
			double fromRatedV, double toRatedV, VoltageXmlType.Unit.Enum vUnit) {
		setXfrRatingData(xfrData, fromRatedV, toRatedV, vUnit, 0.0, null);
	}
	
	/**
	 * Transfer branch Xfr data to Phase shifting transformer
	 * 
	 * @param xfr
	 * @param psXfr
	 */
	public static void branchXfrData2PsXfr(LoadflowBranchDataXmlType branchData) {
		branchData.setCode(LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER);
		PhaseShiftXfrDataXmlType psXfr = branchData.addNewPhaseShiftXfrData();
		TransformerDataXmlType xfr = branchData.getXformerData();

		psXfr.setZ(xfr.getZ());
		psXfr.setRatingData(xfr.getRatingData());
		if (xfr.getFromTurnRatio() != 0.0)
			psXfr.setFromTurnRatio(xfr.getFromTurnRatio());
		if (xfr.getToTurnRatio() != 0.0)
			psXfr.setToTurnRatio(xfr.getToTurnRatio());
		if (xfr.getFromShuntY() != null)
			psXfr.setFromShuntY(xfr.getFromShuntY());
		if (xfr.getToShuntY() != null)
			psXfr.setToShuntY(xfr.getToShuntY());
		
		branchData.setXformerData(null);		
	}
	
	public static XmlOptions getXmlOpts() {
		 XmlOptions opts = new XmlOptions();
		 java.util.Map<String, String> prefixMap = new java.util.HashMap<String, String>();
		 prefixMap.put(IEEEODMPSSModelParser.Token_nsPrefix, IEEEODMPSSModelParser.Token_nsUrl);
		 opts.setSaveImplicitNamespaces(prefixMap);
		 return opts;
	}
}
