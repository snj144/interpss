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
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabBusXmlType;
import org.ieee.odm.schema.DStabNetXmlType;
import org.ieee.odm.schema.DcBranchXmlType;
import org.ieee.odm.schema.DcBusXmlType;
import org.ieee.odm.schema.DcNetworkXmlType;
import org.ieee.odm.schema.IDRecordXmlType;
import org.ieee.odm.schema.IDRefRecordXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LineDStabXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NameValuePairListXmlType;
import org.ieee.odm.schema.NameValuePairXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.OpfGenBusXmlType;
import org.ieee.odm.schema.OpfNetworkXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.PSXfrDStabXmlType;
import org.ieee.odm.schema.ShortCircuitNetXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.ieee.odm.schema.XfrDStabXmlType;

public class BaseJaxbHelper {
	/**
	 * get the id of the id ref record
	 * 
	 * @param idRefRec
	 * @return
	 */
	public static String getRecId(IDRefRecordXmlType idRefRec) {
		return ((IDRecordXmlType)idRefRec.getIdRef()).getId();
	}
	
	/**
	 * warp the network object for substitutionGroup
	 * 
	 * @param net
	 * @return
	 */
	public static JAXBElement<? extends NetworkXmlType> network(NetworkXmlType net) {
		// be careful with inheritance here 
		if (net instanceof DStabNetXmlType) 
			return getFactory().createDstabNet((DStabNetXmlType)net);
		else if (net instanceof OpfNetworkXmlType) 
			return getFactory().createOpfNet((OpfNetworkXmlType)net);
		else if (net instanceof ShortCircuitNetXmlType) 
			return getFactory().createAcscNet((ShortCircuitNetXmlType)net);
		else if (net instanceof LoadflowNetXmlType) 
			return getFactory().createAclfNet((LoadflowNetXmlType)net);
		else if (net instanceof DcNetworkXmlType) 
			return getFactory().createDcNet((DcNetworkXmlType)net);
		else
			return getFactory().createBaseCase(net);
	}
	
	/**
	 * warp the branch object for substitutionGroup
	 * 
	 * @param branch
	 * @return
	 */
	public static JAXBElement<? extends BaseBranchXmlType> branch(BaseBranchXmlType branch) {
		// be careful with inheritance here 
		if (branch instanceof LineDStabXmlType) 
			return getFactory().createDstabLine((LineDStabXmlType)branch);
		else if (branch instanceof PSXfrDStabXmlType) 
			return getFactory().createDstabPSXfr((PSXfrDStabXmlType)branch);
		else if (branch instanceof XfrDStabXmlType) 
			return getFactory().createDstabXfr((XfrDStabXmlType)branch);
		else if (branch instanceof LineBranchXmlType) 
			return getFactory().createAclfLine((LineBranchXmlType)branch);
		else if (branch instanceof PSXfrBranchXmlType) 
			return getFactory().createAclfPSXfr((PSXfrBranchXmlType)branch);
		else if (branch instanceof XfrBranchXmlType) 
			return getFactory().createAclfXfr((XfrBranchXmlType)branch);
		else if (branch instanceof DcBranchXmlType) 
			return getFactory().createDcBranch((DcBranchXmlType)branch);
		else
			return getFactory().createBranch(branch);
	}
	
	/**
	 * warp the bus object for substitutionGroup
	 * 
	 * @param bus
	 * @return
	 */
	public static JAXBElement<? extends BusXmlType> bus(BusXmlType bus) {
		// be careful with inheritance here 
		if (bus instanceof DStabBusXmlType)
			return getFactory().createDstabBus((DStabBusXmlType)bus);
		else if (bus instanceof OpfGenBusXmlType)
			return getFactory().createOpfGenBus((OpfGenBusXmlType)bus);
		else if (bus instanceof LoadflowBusXmlType)
			return getFactory().createAclfBus((LoadflowBusXmlType)bus);
		else if (bus instanceof DcBusXmlType)
			return getFactory().createDcBus((DcBusXmlType)bus);
		else
			return getFactory().createBus(bus);
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

	/**
	 * Set branch ownership
	 * 
	 * @param branchData
	 * @param oAry
	 * @param pAry
	 */
	public static void setBranchOwnership(BaseRecordXmlType rec, int[] oAry, double[] pAry) {
		for ( int i = 0; i < oAry.length; i++) {
			if (oAry[i] > 0) {
				addOwner(rec, new Integer(oAry[i]).toString(), pAry[i]);
			}
		}
	}		
	
	private static ObjectFactory _factory = null;	
	public static ObjectFactory getFactory() {
		if (_factory == null)
			_factory = new ObjectFactory();
		return _factory;
	}	
}