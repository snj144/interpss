 /*
  * @(#)AclfModelParser.java   
  *
  * Copyright (C) 2009 www.interpss.org
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

package org.ieee.odm.model.aclf;

import org.ieee.odm.common.ODMException;
import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.model.BaseJaxbHelper;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.ConverterXmlType;
import org.ieee.odm.schema.DCLineData2TXmlType;
import org.ieee.odm.schema.InterchangeXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.PSXfr3WBranchXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.TielineXmlType;
import org.ieee.odm.schema.Xfr3WBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

public class AclfModelParser extends AbstractModelParser {
	/**
	 * Default Constructor 
	 * 
	 */
	public AclfModelParser() {
		super();
	}	
	
	/**
	 * get the base case object of type LoadflowXmlType
	 * 
	 * @return
	 */
	public LoadflowNetXmlType getAclfNet() {
		return (LoadflowNetXmlType)getBaseCase();
	}
	
	/**
	 * create the base case object of type LoadflowXmlType
	 */
	@Override
	public NetworkXmlType createBaseCase() {
		if (getStudyCase().getBaseCase() == null) {
			LoadflowNetXmlType baseCase = this.getFactory().createLoadflowNetXmlType();
			
			baseCase.setBusList(this.getFactory().createNetworkXmlTypeBusList());
			baseCase.setBranchList(this.getFactory().createNetworkXmlTypeBranchList());
			getStudyCase().setBaseCase(BaseJaxbHelper.network(baseCase));
		}
		return getStudyCase().getBaseCase().getValue();
	}
	
	/*
	 * 		Bus functions
	 * 		=============
	 */

	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public LoadflowBusXmlType createAclfBus() {
		LoadflowBusXmlType busRec = this.getFactory().createLoadflowBusXmlType();
		busRec.setOffLine(false);
		busRec.setAreaNumber(1);
		busRec.setZoneNumber(1);
		busRec.setNvPairList(this.getFactory().createNameValuePairListXmlType());
		getBaseCase().getBusList().getBus().add(BaseJaxbHelper.bus(busRec));
		return busRec;
	}	
	
	/**
	 * create a bus object with the id, make sure there is no duplication
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LoadflowBusXmlType createAclfBus(String id) throws ODMException {
		LoadflowBusXmlType busRec = createAclfBus();
		busRec.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new ODMException("Bus record duplication, bus id: " + id);
		}
		this.objectCache.put(id, busRec);
		return busRec;
	}		
	
	/**
	 * add a new bus record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public LoadflowBusXmlType createAclfBus(String id, long number) throws ODMException {
		LoadflowBusXmlType busRec = createAclfBus(id);
		busRec.setNumber(number);
		return busRec;
	}	
	
	/**
	 * get the bus object using the id
	 * 
	 * @param id
	 * @return
	 */
	public LoadflowBusXmlType getAclfBus(String id) {
		return (LoadflowBusXmlType)getBus(id);
	}

	/*
	 * 		Branch functions
	 * 		================
	 */
	
	/**
	 * get the Line branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public LineBranchXmlType getLineBranch(String fromId, String toId, String cirId) {
		return (LineBranchXmlType)getBranch(fromId, toId, cirId);
	}
	
	/**
	 * get the xfr branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public XfrBranchXmlType getXfrBranch(String fromId, String toId, String cirId) {
		return (XfrBranchXmlType)getBranch(fromId, toId, cirId);
	}
	public Xfr3WBranchXmlType getXfr3WBranch(String fromId, String toId, String tertId, String cirId) {
		return (Xfr3WBranchXmlType)getBranch(fromId, toId, tertId, cirId);
	}

	/**
	 * get the ps xfr branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public PSXfrBranchXmlType getPSXfrBranch(String fromId, String toId, String cirId) {
		return (PSXfrBranchXmlType)getBranch(fromId, toId, cirId);
	}
	public PSXfr3WBranchXmlType getPSXfr3WBranch(String fromId, String toId, String tertId, String cirId) {
		return (PSXfr3WBranchXmlType)getBranch(fromId, toId, tertId, cirId);
	}

	/**
	 * create a LineBranchXmlType object
	 * 
	 * @return
	 */
	public LineBranchXmlType createLineBranch() {
		LineBranchXmlType branch = this.getFactory().createLineBranchXmlType();
		branch.setRatingLimit(this.getFactory().createBranchRatingLimitXmlType());
		branch.setLineInfo(this.getFactory().createLineBranchInfoXmlType());
		branch.setNvPairList(this.getFactory().createNameValuePairListXmlType());
		intiBranchData(branch);
		return branch;
	}
	
	/**
	 * create a XfrBranchXmlType object
	 * 
	 * @return
	 */
	public XfrBranchXmlType createXfrBranch() {
		XfrBranchXmlType branch = this.getFactory().createXfrBranchXmlType();
		branch.setXfrInfo(this.getFactory().createTransformerInfoXmlType());
		intiBranchData(branch);
		return branch;
	}
	public Xfr3WBranchXmlType createXfr3WBranch() {
		Xfr3WBranchXmlType branch = this.getFactory().createXfr3WBranchXmlType();
		intiBranchData(branch);
		return branch;
	}

	/**
	 * create a PSXfrBranchXmlType object
	 * 
	 * @return
	 */
	public PSXfrBranchXmlType createPSXfrBranch() {
		PSXfrBranchXmlType branch = this.getFactory().createPSXfrBranchXmlType();
		intiBranchData(branch);
		return branch;
	}
	public PSXfr3WBranchXmlType createPSXfr3WBranch() {
		PSXfr3WBranchXmlType branch = this.getFactory().createPSXfr3WBranchXmlType();
		intiBranchData(branch);
		return branch;
	}
	
	/**
	 * add a new Line branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public LineBranchXmlType createLineBranch(String fromId, String toId, String cirId) throws ODMException {
		LineBranchXmlType branch = createLineBranch();
		addBranch2BaseCase(branch, fromId, toId, null, cirId);
		return branch;
	}

	/**
	 * add a new Xfr branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public XfrBranchXmlType createXfrBranch(String fromId, String toId, String cirId) throws Exception {
		XfrBranchXmlType branch = createXfrBranch();
		addBranch2BaseCase(branch, fromId, toId, null, cirId);
		return branch;
	}
	public Xfr3WBranchXmlType createXfr3WBranch(String fromId, String toId, String tertId, String cirId) throws Exception {
		Xfr3WBranchXmlType branch = createXfr3WBranch();
		addBranch2BaseCase(branch, fromId, toId, tertId, cirId);
		return branch;
	}

	/**
	 * add a new PS Xfr branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public PSXfrBranchXmlType createPSXfrBranch(String fromId, String toId, String cirId) throws Exception {
		PSXfrBranchXmlType branch = createPSXfrBranch();
		addBranch2BaseCase(branch, fromId, toId, null, cirId);
		return branch;
	}
	public PSXfr3WBranchXmlType createPSXfr3WBranch(String fromId, String toId, String tertId, String cirId) throws Exception {
		PSXfr3WBranchXmlType branch = createPSXfr3WBranch();
		addBranch2BaseCase(branch, fromId, toId, tertId, cirId);
		return branch;
	}
	
	/**
	 * Get the cashed dcLine2T object by id
	 * 
	 * @param id
	 * @return
	 */
	public DCLineData2TXmlType getDcLine2TRecord(String recId, String invId, long number) {
		String id = ModelStringUtil.formBranchId(recId, invId, new Long(number).toString());
		return (DCLineData2TXmlType)this.getCachedObject(id);
	}
	
	/**
	 * add a new 2T DcLine record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public DCLineData2TXmlType createDCLine2TRecord(String recId, String invId, long number) throws Exception {
		DCLineData2TXmlType dcLine = getFactory().createDCLineData2TXmlType();
		addBranch2BaseCase(dcLine, recId, invId, null, new Long(number).toString());
		
		ConverterXmlType rectifier = getFactory().createConverterXmlType();
		dcLine.setRectifier(rectifier);
		dcLine.getRectifier().setBusId(createBusRef(recId));
	
		ConverterXmlType inverter = getFactory().createConverterXmlType();
		dcLine.setInverter(inverter);
		dcLine.getInverter().setBusId(createBusRef(invId));
		return dcLine;
	}	
	
	/*
	 * 		Network object functions
	 * 		========================
	 */
	
	/**
	 * create a tieLine object
	 * 
	 * @return
	 */
	public TielineXmlType createTieline() {
		if (getAclfNet().getTieLineList() == null)
			getAclfNet().setTieLineList(this.getFactory().createLoadflowNetXmlTypeTieLineList());
		TielineXmlType tieLine = this.getFactory().createTielineXmlType();
		getAclfNet().getTieLineList().getTieline().add(tieLine);
		return tieLine;
	}	
	
	/**
	 * create a Interchange object
	 * 
	 * @return
	 */
	public InterchangeXmlType createInterchange() {
		if (getAclfNet().getInterchangeList() == null)
			getAclfNet().setInterchangeList(this.getFactory().createLoadflowNetXmlTypeInterchangeList());
		InterchangeXmlType interchange = this.getFactory().createInterchangeXmlType();
		getAclfNet().getInterchangeList().getInterchange().add(interchange);
		return interchange;
	}	
}
