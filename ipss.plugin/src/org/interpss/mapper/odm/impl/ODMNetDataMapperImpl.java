/*
 * @(#)ODMNetDataMapperImpl.java   
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
 * @Date 02/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl;

import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.CimRdfXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.VoltageUnitType;

import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.CimRecord;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;

public class ODMNetDataMapperImpl {
	/**
	 * Map the network info only
	 * 
	 * @param xmlNet
	 * @return
	 */
	public static void mapNetworkData(Network net, NetworkXmlType xmlNet) {
		net.setId(xmlNet.getId());
		net.setName(xmlNet.getName() == null? "ODM Loadflow Case" : xmlNet.getName());
		net.setDesc(xmlNet.getDesc());
		net.setBaseKva(xmlNet.getBasePower().getValue()*
				(xmlNet.getBasePower().getUnit()==ApparentPowerUnitType.MVA?1000.0:1.0));
				// BasePowerUnit [ MVA, KVA]
		net.setAllowParallelBranch(true);
	}
	
	/**
	 * transfer the info stored in the bus xml record to the bus object
	 * 
	 * @param busRec
	 * @param bus
	 * @param net
	 */
	public static void mapBaseBusData(BusXmlType busRec, Bus bus, Network net) {
		if (busRec.getNumber() != null)
			bus.setNumber(busRec.getNumber());
		bus.setName(busRec.getName() == null? "Bus" : busRec.getName());
		bus.setDesc(busRec.getDesc() == null? "Bus Desc" : busRec.getDesc());
		bus.setStatus(!busRec.isOffLine());
		if (!bus.isActive()) {
			IpssLogger.getLogger().info("Bus is not active, " + bus.getId());
		}
		
		if (busRec.getCimRdfRecords() != null && busRec.getCimRdfRecords().getRdfRec().size() > 0) {
			for (CimRdfXmlType cimRec : busRec.getCimRdfRecords().getRdfRec()) {
				CimRecord rec = CoreObjectFactory.createCimRecod(cimRec.getRdfId(), cimRec.getName());
				bus.getCimRec().add(rec);
			}
		}
		
		bus.setDesc(busRec.getDesc());
		Area area = CoreObjectFactory.createArea(busRec.getAreaNumber(), net);
		bus.setArea(area);
		Zone zone = CoreObjectFactory.createZone(busRec.getZoneNumber(), net);
		bus.setZone(zone);
		bus.setBaseVoltage(busRec.getBaseVoltage().getUnit()==VoltageUnitType.KV ?    // Base V unit [KV, Volt] 
									busRec.getBaseVoltage().getValue()*1000.0	: busRec.getBaseVoltage().getValue());
	}

	/**
	 * transfer the info stored in the branch xml rec to the branch object
	 * 
	 * @param branchRec
	 * @param branch
	 * @param net
	 * @throws InterpssException
	 */
	public static void mapBaseBranchRec(BranchXmlType branchRec, Branch branch, Network net) throws InterpssException {
		branch.setCircuitNumber(branchRec.getCircuitId());
		try {
			BusXmlType fromBus = (BusXmlType)branchRec.getFromBus().getIdRef();
			BusXmlType toBus = (BusXmlType)branchRec.getToBus().getIdRef();
			net.addBranch(branch, fromBus.getId(), toBus.getId());
		} catch (Exception e) {
			throw new InterpssException(e.toString() + ", the branch is ignored");
		}

		branch.setName(branchRec.getName() == null ? "" : branchRec.getName());
		branch.setDesc(branchRec.getDesc() == null ? "" : branchRec.getDesc());
		branch.setStatus(!branchRec.isOffLine());
		if (!branch.isActive()) {
			IpssLogger.getLogger().info("Branch is not active, " + branch.getId());
		}
		Area area = CoreObjectFactory.createArea(branchRec.getAreaNumber(), net);
		branch.setArea(area);
		Zone zone = CoreObjectFactory.createZone(branchRec.getZoneNumber(), net);
		branch.setZone(zone);
	}
}