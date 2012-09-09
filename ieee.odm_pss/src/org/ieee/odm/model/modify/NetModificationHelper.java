/*
 * @(#)NetModificationHelper.java   
 *
 * Copyright (C) 2006-2012 www.interpss.org
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
 * @Date 08/30/2012
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.model.modify;

import static org.ieee.odm.ODMObjectFactory.odmObjFactory;

import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.schema.BranchChangeRecSetXmlType;
import org.ieee.odm.schema.BranchChangeRecXmlType;
import org.ieee.odm.schema.BusChangeRecSetXmlType;
import org.ieee.odm.schema.BusChangeRecXmlType;
import org.ieee.odm.schema.ModifyRecordXmlType;
import org.ieee.odm.schema.NetModificationXmlType;

/**
 *
 */
public class NetModificationHelper {
	private IODMModelParser parser = null;
	
	public NetModificationHelper (IODMModelParser parser) {
		this.parser = parser;
	}
	
	/**
	 * create an NetModificationXmlType for net modification records
	 * 
	 * @return
	 */
	public NetModificationXmlType createNetModificationList(String id, String desc) {
		NetModificationXmlType rec = odmObjFactory.createNetModificationXmlType();
		rec.setId(id);
		rec.setDesc(desc);
		addModifyRecord(rec);
		return rec;
	}	
	
	/**
	 * create an BranchChangeRecSetXmlType record and added to the netModifyList
	 * 
	 * @return
	 */	
	public BranchChangeRecSetXmlType createBranchChangeRecSetXmlType(NetModificationXmlType netModifyList) {
		BranchChangeRecSetXmlType branchChangeSet = odmObjFactory.createBranchChangeRecSetXmlType();
		netModifyList.getBranchChangeRecSet().add(branchChangeSet);
		return branchChangeSet;
	}
	
	/**
	 * create an BranchChangeRecXmlType record and added to the branchSet
	 * 
	 * @return
	 */	
	public BranchChangeRecXmlType createBranchChangeRecXmlType(BranchChangeRecSetXmlType branchSet) {
		BranchChangeRecXmlType branchChange = odmObjFactory.createBranchChangeRecXmlType();
		branchSet.getBranchChangeRec().add(branchChange);
		return branchChange;
	}
	
	/**
	 * create an BusChangeRecSetXmlType record and added to the netModifyList
	 * 
	 * @return
	 */	
	public BusChangeRecSetXmlType createBusChangeRecSetXmlType(NetModificationXmlType netModifyList) {
		BusChangeRecSetXmlType busChangeSet = odmObjFactory.createBusChangeRecSetXmlType();
		netModifyList.getBusChangeRecSet().add(busChangeSet);
		return busChangeSet;
	}
	
	/**
	 * create an BusChangeRecXmlType record and added to the busSet
	 * 
	 * @return
	 */	
	public BusChangeRecXmlType createBusChangeRecXmlType(BusChangeRecSetXmlType busSet) {
		BusChangeRecXmlType busChange = odmObjFactory.createBusChangeRecXmlType();
		busSet.getBusChangeRec().add(busChange);
		return busChange;
	}	

	/**
	 * When NetModificationXmlType is used for contingency analysis, return the
	 * contingency list
	 * 
	 * @return
	 */
	public NetModificationXmlType getContingencyList() {
		return (NetModificationXmlType)parser.getModification();
	}	

	/**
	 * When NetModificationXmlType is used for contingency analysis, get contingency
	 * by id
	 * 
	 * @param id
	 * @return
	 */
	public BranchChangeRecSetXmlType getContingency(String id) {
		for ( BranchChangeRecSetXmlType contingency : getContingencyList().getBranchChangeRecSet()) {
			if (id.equals(contingency.getId()))
				return contingency;
		}
		return null;
	}	
	
	private void addModifyRecord(ModifyRecordXmlType rec) {
		if (this.parser.getStudyCase().getModificationList() == null) {
			this.parser.getStudyCase().setModificationList(odmObjFactory.createStudyCaseXmlTypeModificationList());
		}
		this.parser.getStudyCase().getModificationList().getModification().add(rec);
	}	
}
