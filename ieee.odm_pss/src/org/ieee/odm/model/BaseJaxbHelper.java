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

package org.ieee.odm.model;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BaseRecordXmlType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabNetXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NameValuePairListXmlType;
import org.ieee.odm.schema.NameValuePairXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.OpfNetworkXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.ShortCircuitNetXmlType;

public class BaseJaxbHelper {
	/**
	 * warp the network object for substitutionGroup
	 * 
	 * @param net
	 * @return
	 */
	public static JAXBElement<NetworkXmlType> network(NetworkXmlType net) {
		if (net instanceof LoadflowNetXmlType) 
			return getFactory().createAclfNet(net);
		else if (net instanceof ShortCircuitNetXmlType) 
			return getFactory().createAcscNet(net);
		else if (net instanceof DStabNetXmlType) 
			return getFactory().createDstabNet(net);
		else if (net instanceof OpfNetworkXmlType) 
			return getFactory().createOpfNet(net);
		else
			return getFactory().createBaseCase(net);
	}
	
	/**
	 * warp the branch object for substitutionGroup
	 * 
	 * @param branch
	 * @return
	 */
	public static JAXBElement<BaseBranchXmlType> branch(BaseBranchXmlType branch) {
		if (branch instanceof BranchRecordXmlType) 
			return getFactory().createBranch(branch);
		else
			return getFactory().createAclfBranch(branch);
	}
	
	/**
	 * warp the bus object for substitutionGroup
	 * 
	 * @param bus
	 * @return
	 */
	public static JAXBElement<BusXmlType> bus(BusXmlType bus) {
		if (bus instanceof BusRecordXmlType) 
			return getFactory().createBus(bus);
		else
			return getFactory().createAclfBus(bus);
	}
	
	/**
	 * add a name/value pair to the name/value pair List
	 * 
	 * @param nvList name/value pair list
	 * @param name name string
	 * @param value value string
	 */
	public static void addNVPair(NameValuePairListXmlType nvList, String name, 
					String value) {
    	NameValuePairXmlType nvPair = getFactory().createNameValuePairXmlType();
    	nvList.getNvPair().add(nvPair);
    	nvPair.setName(name);
    	nvPair.setValue(value);
	}
	
	/**
	 * add an owner record to the BaseRecord
	 * 
	 * @param rec
	 * @param id
	 * @param ownership in pu
	 */
	public static void addOwner(BaseRecordXmlType rec, String id) {
		addOwner(rec, id, 1.0);
	}
	public static void addOwner(BaseRecordXmlType rec, String id, 
			double ownership) {
		if(rec.getOwnerList() == null)
			rec.setOwnerList(getFactory().createBaseRecordXmlTypeOwnerList());
		BaseRecordXmlType.OwnerList.Owner owner = getFactory().createBaseRecordXmlTypeOwnerListOwner();
		rec.getOwnerList().getOwner().add(owner);
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

	
	
	private static ObjectFactory _factory = null;	
	public static ObjectFactory getFactory() {
		if (_factory == null)
			_factory = new ObjectFactory();
		return _factory;
	}	
}
