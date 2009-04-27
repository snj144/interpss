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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ConverterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DcLineFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultTypeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFLoadCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LineDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.MvaRatingXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetAreaXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetZoneXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PhaseShiftXfrDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageLimitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
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
		if (id1 != null && ownership1 > 0.0)
			addOwner(rec, id1, ownership1);
		if (id2 != null && ownership2 > 0.0)
			addOwner(rec, id2, ownership2);
		if (id1 != null && ownership3 > 0.0)
			addOwner(rec, id3, ownership3);
		if (id1 != null && ownership4 > 0.0)
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
	
	public static DCLineBusRecordXmlType getDCLineBusRecord(String id, PSSNetworkXmlType baseCaseNet) {
		for (DCLineBusRecordXmlType busRec : baseCaseNet.getDcLineList().getDcLineBusList()
				.getDcLineBusArray()) {
			if (id.equals(busRec.getConverter().getBusId().getName()))
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
	public static ConverterXmlType getConverterRecord(String name, PSSNetworkXmlType baseCaseNet) {
		for (DCLineBusRecordXmlType dcLine : 
			baseCaseNet.getDcLineList().getDcLineBusList().getDcLineBusArray()) {
			ConverterXmlType converter= dcLine.getConverter();
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
	public static NetAreaXmlType getAreaRecordByAreaName(String areaName, PSSNetworkXmlType baseCaseNet) {
		for (NetAreaXmlType area:baseCaseNet.getAreaList().getAreaArray()) {
			if (areaName.equals(area.getName()))
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
	public static NetAreaXmlType getAreaRecordByZone(int zoneNo, PSSNetworkXmlType baseCaseNet) {
		for (NetAreaXmlType area:baseCaseNet.getAreaList().getAreaArray()) {
			for(NetZoneXmlType zone : area.getZoneList().getZoneArray()){
				if (zoneNo == zone.getNumber())
					return area;
			}			
		}
		return null;
	}
	
	public static FaultXmlType getFaultRecord(TransientSimulationXmlType tranSimu,
			FaultTypeEnumType.Enum faultType,String fbus,String tbus){
		if(tranSimu.getDynamicDataList().getFaultList().getFaultArray()!=null){			
			for(FaultXmlType fault:tranSimu.getDynamicDataList().getFaultList().getFaultArray()){				
				if(faultType.equals(fault.getFaultType())){					
					if(faultType.equals(FaultTypeEnumType.BUS_FAULT)){						
						BusFaultXmlType busFault=fault.getBusFault();
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
  
	
	public static BusFaultXmlType getBusFaultRecord(TransientSimulationXmlType tranSimu,
			String fbus,String tbus){
		
		for(FaultXmlType fault:tranSimu.getDynamicDataList().getFaultList().getFaultArray()){
			if(fault.getBusFault()!=null){
				BusFaultXmlType busFault=fault.getBusFault();				
				if(fbus.equals(busFault.getFaultedBus().getName())&& 
						tbus.equals(busFault.getRemoteEndBus().getName()))					
			         return busFault;
			}else{
				return fault.addNewBusFault();
			}			
		}
		return null;
	}
	
	public static BranchFaultXmlType getBranchFaultRecord(TransientSimulationXmlType tranSimu,
			String fbus,String tbus){		
		for(FaultXmlType fault:tranSimu.getDynamicDataList().getFaultList().getFaultArray()){
			if(fault.getBranchFault()!=null){
				BranchFaultXmlType braFault=fault.getBranchFault();				
				if(fbus.equals(braFault.getFromBus().getName())&& tbus.equals(braFault.getToBus().getName()))
			         return braFault;
			}else{
				return fault.addNewBranchFault();
			}			
		}
		return null;
	}
	
	public static DcLineFaultXmlType getDCFaultRecord(TransientSimulationXmlType tranSimu,
			String fbus,String tbus){
		for(FaultXmlType fault: tranSimu.getDynamicDataList().getFaultList().getFaultArray()){
			if(fault.getDcLineFault()!=null){				
				DcLineFaultXmlType dcFault= fault.getDcLineFault();				
				if(fbus.equals(dcFault.getFromACBus().getName())&&
						tbus.equals(dcFault.getToACBus().getName())){					
					return dcFault;
				}else {					
					return fault.addNewDcLineFault();
				}
			}
		}
		return null;
	}
	
	public static GeneratorXmlType getGeneratorRecord(TransientSimulationXmlType tranSimu,
			   String busId,String genId){		
		for(GeneratorXmlType gen: tranSimu.getDynamicDataList().getBusDynDataList()
				.getGeneratorDataList().getGeneratorArray()){						
			if(busId.equals(gen.getLocatedBus().getName())){
				if(gen.getGenId()!=null){
					if(genId.equals(gen.getGenId().getName())){
						return gen;
					}
				}else{
					return gen;
				}			
			}
		}		
		return null;		
	}
	
	public static ExciterXmlType getExciterRecord(TransientSimulationXmlType tranSimu,
			 String busId, String excId){
		for(ExciterXmlType exc: tranSimu.getDynamicDataList().getBusDynDataList().
				       getExciterDataList().getExciterArray()){
			if(busId.equals(exc.getLocatedBus().getName())){
				if(exc.getExcId()!=null){
					if(excId.equals(exc.getExcId().getName())){
						return exc;
					}
				}else{
					return exc;
				}
			}			
		}		
		return null;		
	}
	
	public static TurbineGovernorXmlType getTGRecord(TransientSimulationXmlType tranSimu,
			 String busId, String tgId){
		for(TurbineGovernorXmlType tg: tranSimu.getDynamicDataList().getBusDynDataList()
                   .getTurbineGovernorDataList().getTurbineGovernorArray()){
			if(busId.equals(tg.getLocatedBus().getName())){
				if(tg.getTgId()!=null){
					if(tgId.equals(tg.getTgId().getName())){
						return tg;
					}
				}else{
					return tg;
				}
			}			
		}	
		return null;		
	}
	
	public static StabilizerXmlType getPSSRecord(TransientSimulationXmlType tranSimu,
			 String busId, String macId){
		for(StabilizerXmlType pss: tranSimu.getDynamicDataList().getBusDynDataList()
                  .getStabilizerDataList().getStabilizerArray()){
			if(busId.equals(pss.getLocatedBus().getName())){
				if(pss.getMacId()!=null){
					if(macId.equals(pss.getMacId().getName())){
						return pss;
					}
				}else{
					return pss;
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
	
	public static void setPowerKva(ApparentPowerXmlType power, double kva) {
		power.setValue(kva);   
		power.setUnit(ApparentPowerUnitType.KVA); 		
	}
	
	public static void setPowerMva(ApparentPowerXmlType power, double mva) {
		power.setValue(mva);   
		power.setUnit(ApparentPowerUnitType.MVA); 		
	}

	public static void setActivePower(ActivePowerXmlType power, double p, ActivePowerUnitType.Enum unit) {
		power.setValue(p);   
		power.setUnit(unit); 		
	}

	public static void setReactivePower(ReactivePowerXmlType power, double p, ReactivePowerUnitType.Enum unit) {
		power.setValue(p);   
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
	
	public static void setVoltageLimitData(VoltageLimitXmlType limit, double max, double min, VoltageUnitType.Enum unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}

	public static void setActivePowerLimitData(ActivePowerLimitXmlType limit, double max, double min, ActivePowerUnitType.Enum unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}

	public static void setReactivePowerLimitData(ReactivePowerLimitXmlType limit, double max, double min, ReactivePowerUnitType.Enum unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
	}

	public static void setTapLimitData(TapLimitXmlType limit, double max, double min) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(TapUnitType.PU);
	}

	public static void setAngleLimitData(AngleLimitXmlType limit, double max, double min, AngleUnitType.Enum unit) {
		limit.setMax(max);
		limit.setMin(min);
		limit.setUnit(unit);
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
	public static void setLoadData(LoadflowBusDataXmlType busData, LFLoadCodeEnumType.Enum code, 
			double p, double q, ApparentPowerUnitType.Enum unit) {
		busData.addNewLoadData();
    	busData.getLoadData().setCode(code);
    	ODMData2XmlHelper.setPowerData(busData.getLoadData().addNewEquivLoad().addNewConstPLoad(), p, q, unit);
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
	public static void setGenData(LoadflowBusDataXmlType busData, LFGenCodeEnumType.Enum code, 
			double p, double q, ApparentPowerUnitType.Enum unit) {
   		busData.addNewGenData();
   		busData.getGenData().setCode(code);
   		ODMData2XmlHelper.setPowerData(busData.getGenData().addNewEquivGen().addNewPower(), p, q, unit);
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
			double max, double min, ReactivePowerUnitType.Enum unit) {
		setReactivePowerLimitData(genData.getEquivGen().addNewQLimit(), max, min, unit);	
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
	public static LineDataXmlType setLineData(LoadflowBranchDataXmlType branchData, 
			             double r, double x, ZUnitType.Enum zUnit, 
			             double g, double b, YUnitType.Enum yUnit) {
		branchData.setCode(LFBranchCodeEnumType.LINE);
		branchData.addNewLineData();
		ODMData2XmlHelper.setZValue(branchData.getLineData().addNewZ(), r, x, zUnit);
		if (g != 0.0 || b != 0.0) 
			ODMData2XmlHelper.setYData(branchData.getLineData().addNewTotalShuntY(), g, b, yUnit);
		return branchData.getLineData();
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
	public static TransformerDataXmlType createXformerData(LoadflowBranchDataXmlType branchData, 
			             double r, double x, ZUnitType.Enum zUnit,
			             double fromTap, double toTap,
			             double gFrom, double bFrom, double gTo, double bTo, YUnitType.Enum yUnit) {
		branchData.setCode(LFBranchCodeEnumType.TRANSFORMER);
		branchData.addNewXformerData();
		setXformerData(branchData.getXformerData(),
				r, x, zUnit, fromTap, toTap,
				gFrom, bFrom, gTo, bTo, yUnit);
		return branchData.getXformerData();
	}

	public static TransformerDataXmlType createXformerData(LoadflowBranchDataXmlType branchData, 
            double r, double x, ZUnitType.Enum zUnit, double fromTap, double toTap) {
		return createXformerData(branchData, r, x, zUnit, fromTap, toTap, 0.0, 0.0, 0.0, 0.0, YUnitType.PU);
	}
	

	private static void setXformerData(TransformerDataXmlType xfrData,
			double r, double x, ZUnitType.Enum zUnit, 
			double fromTap, double toTap,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType.Enum yUnit) {
		ODMData2XmlHelper.setZValue(xfrData.addNewZ(), r, x, zUnit);
		setTapPU(xfrData.addNewFromTap(), fromTap);
		setTapPU(xfrData.addNewToTap(), fromTap);
		if (gFrom != 0.0 || bFrom != 0.0)
			ODMData2XmlHelper.setYData(xfrData.addNewFromShuntY(),
					gFrom, bFrom, yUnit);
		if (gTo != 0.0 || bTo != 0.0)
			ODMData2XmlHelper.setYData(xfrData.addNewToShuntY(),
					gTo, bTo, yUnit);
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
	public static PhaseShiftXfrDataXmlType createPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZUnitType.Enum zUnit,
			double fromTap, double toTap, double fromAng, double toAng, AngleUnitType.Enum angUnit,
			double gFrom, double bFrom, double gTo, double bTo, YUnitType.Enum yUnit) {
		branchData.setCode(LFBranchCodeEnumType.PHASE_SHIFT_XFORMER);
		branchData.addNewPhaseShiftXfrData();
		setXformerData(branchData.getPhaseShiftXfrData(),
				r, x, zUnit, fromTap, toTap, gFrom, bFrom, gTo, bTo, yUnit);
		if (fromAng != 0.0)
			setAngleData(branchData.getPhaseShiftXfrData().addNewFromAngle(), fromAng, angUnit);
		if (toAng != 0.0)
			setAngleData(branchData.getPhaseShiftXfrData().addNewToAngle(), toAng, angUnit);
		return branchData.getPhaseShiftXfrData();
	}

	public static PhaseShiftXfrDataXmlType createPhaseShiftXfrData(LoadflowBranchDataXmlType branchData,
			double r, double x, ZUnitType.Enum zUnit,
			double fromTap, double toTap,
			double fromAng, double toAng, AngleUnitType.Enum angUnit) {
		return createPhaseShiftXfrData(branchData, r, x, zUnit,
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
    		branchData.addNewRatingLimit();
        	if (mvar1 != 0.0 || mvar2 != 0.0 || mvar3 != 0.0) {
        		MvaRatingXmlType mvaRating = branchData.getRatingLimit().addNewMva();
        		mvaRating.setRating1(mvar1);
        		mvaRating.setRating2(mvar2);
        		mvaRating.setRating3(mvar3);
        		mvaRating.setUnit(mvarUnit);
        	}

        	if (current != 0.0) {
        		CurrentXmlType limit = branchData.getRatingLimit().addNewCurrent();
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
			double fromRatedV, double toRatedV, VoltageUnitType.Enum vUnit,
			double normialMva, ApparentPowerUnitType.Enum pUnit) {
		TransformerDataXmlType.RatingData ratingData = xfrData.addNewRatingData();
		VoltageXmlType fromRatedVolt = ratingData.addNewFromRatedVoltage();
		fromRatedVolt.setValue(fromRatedV);
		fromRatedVolt.setUnit(vUnit);
		VoltageXmlType toRatedVolt = ratingData.addNewToRatedVoltage();
		toRatedVolt.setValue(toRatedV);
		toRatedVolt.setUnit(vUnit);
   		if (normialMva != 0.0) {
   			ApparentPowerXmlType ratedMva = ratingData.addNewRatedPower();
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
	public static void setXfrRatingData(TransformerDataXmlType xfrData, 
			double fromRatedV, double toRatedV, VoltageUnitType.Enum vUnit) {
		setXfrRatingData(xfrData, fromRatedV, toRatedV, vUnit, 0.0, null);
	}
	
	/**
	 * Transfer branch Xfr data to Phase shifting transformer
	 * 
	 * @param xfr
	 * @param psXfr
	 */
	public static void branchXfrData2PsXfr(LoadflowBranchDataXmlType branchData) {
		branchData.setCode(LFBranchCodeEnumType.PHASE_SHIFT_XFORMER);
		PhaseShiftXfrDataXmlType psXfr = branchData.addNewPhaseShiftXfrData();
		TransformerDataXmlType xfr = branchData.getXformerData();

		psXfr.setZ(xfr.getZ());
		psXfr.setRatingData(xfr.getRatingData());
		if (xfr.getFromTap().getValue() != 0.0)
			psXfr.setFromTap(xfr.getFromTap());
		if (xfr.getToTap().getValue() != 0.0)
			psXfr.setToTap(xfr.getToTap());
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
