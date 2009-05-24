 /*
  * @(#)ContainerHelper.java   
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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ConverterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DcLineFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultTypeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetAreaXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetZoneXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;

public class ContainerHelper {
	public static final double Deg2Rad = Math.PI / 180.0;
	public static final double Rad2Deg = 180.0/ Math.PI;
	
	/**
	 * Get bus record with the id
	 * 
	 * @param id
	 * @param baseCaseNet
	 * @return
	 */
	public static BusRecordXmlType findBusRecord(String id, PSSNetworkXmlType baseCaseNet) {
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
	public static BranchRecordXmlType findBranchRecord(String fromId, String toId, String cirId, PSSNetworkXmlType baseCaseNet) {
		for (BranchRecordXmlType braRec : baseCaseNet.getBranchList().getBranchArray()) {
			if (fromId.equals(braRec.getFromBus().getIdRef()) &&
					toId.equals(braRec.getToBus().getIdRef()) &&
							cirId.equals(braRec.getCircuitId()))
				return braRec;
		}
		return null;
	}
	
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


	public static DCLineBusRecordXmlType getDCLineBusRecord(String id, PSSNetworkXmlType baseCaseNet) {
		for (DCLineBusRecordXmlType busRec : baseCaseNet.getDcLineList().getDcLineBusList()
				.getDcLineBusArray()) {
			if (id.equals(busRec.getConverter().getBusId().getName()))
				return busRec;
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
	
	/**
	 * Get zone record with the zonename
	 * 
	 * @param zoneName
	 * @param area
	 * @return
	 */
	public static NetZoneXmlType getZoneRecord(String zoneName, NetAreaXmlType area) {
		for (NetZoneXmlType zone:area.getZoneList().getZoneArray()) {
			if (zoneName.equals(zone.getName()))
				return zone;
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
	
	public static XmlOptions getXmlOpts() {
		 XmlOptions opts = new XmlOptions();
		 java.util.Map<String, String> prefixMap = new java.util.HashMap<String, String>();
		 prefixMap.put(ODMModelParser.Token_nsPrefix, ODMModelParser.Token_nsUrl);
		 opts.setSaveImplicitNamespaces(prefixMap);
		 return opts;
	}
}
