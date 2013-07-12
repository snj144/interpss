 /*
  * @(#)AcscParserHelper.java   
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
  * @Date 08/11/2010
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.model.acsc;

import static org.ieee.odm.ODMObjectFactory.odmObjFactory;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.common.ODMException;
import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.model.aclf.AclfParserHelper;
import org.ieee.odm.model.base.BaseDataSetter;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.BusGenDataXmlType;
import org.ieee.odm.schema.BusLoadDataXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.GroundingEnumType;
import org.ieee.odm.schema.GroundingXmlType;
import org.ieee.odm.schema.LineShortCircuitXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowLoadDataXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.PSXfrShortCircuitXmlType;
import org.ieee.odm.schema.ShortCircuitBusXmlType;
import org.ieee.odm.schema.ShortCircuitGenDataXmlType;
import org.ieee.odm.schema.ShortCircuitLoadDataXmlType;
import org.ieee.odm.schema.ShortCircuitNetXmlType;
import org.ieee.odm.schema.XformerConnectionXmlType;
import org.ieee.odm.schema.XfrShortCircuitXmlType;
import org.ieee.odm.schema.ZUnitType;

/**
 * Acsc ODM model parser helper utility functions
 * 
 * @author mzhou
 *
 */
public class AcscParserHelper extends AclfParserHelper {
	/**
	 * create Acsc equiv gen
	 * 
	 * @return
	 */
	public static JAXBElement<ShortCircuitGenDataXmlType> createAcscEquivGen() {
		ShortCircuitGenDataXmlType equivGen = odmObjFactory.createShortCircuitGenDataXmlType();
		return odmObjFactory.createAcscEquivGen(equivGen);
	}
	
	/**
	 * get Acsc Gen Data object on the acscBus with id = genId
	 * 
	 * @param acscBus
	 * @param genId
	 * @return null if acscGenData not found
	 */
	public static ShortCircuitGenDataXmlType getAcscContritueGen(ShortCircuitBusXmlType acscBus, String genId) throws ODMException {
		for (JAXBElement<? extends LoadflowGenDataXmlType> elem : acscBus.getGenData().getContributeGen()) {
			ShortCircuitGenDataXmlType scGenData = (ShortCircuitGenDataXmlType)elem.getValue();
			if (scGenData.getId().equals(genId))
				return scGenData;
		}
    	throw new ODMException("Generator not found, ID: " + genId + "@Bus:" + acscBus.getId());
	}
	
	/**
	 * create a Acsc Contributing Generator object
	 * 
	 */
	public static ShortCircuitGenDataXmlType createAcscContributeGen(ShortCircuitBusXmlType busRec) {
		BusGenDataXmlType genData = busRec.getGenData();
		if (genData == null) {
			genData = odmObjFactory.createBusGenDataXmlType();
			busRec.setGenData(genData);
			genData.setEquivGen(createAcscEquivGen());
		}
		// some model does not need ContributeGenList
		ShortCircuitGenDataXmlType contribGen = odmObjFactory.createShortCircuitGenDataXmlType();
		genData.getContributeGen().add(odmObjFactory.createAcscContributeGen(contribGen));
		return contribGen;
	}
	
	/**
	 * create Acsc equiv load
	 * 
	 * @return
	 */
	public static JAXBElement<ShortCircuitLoadDataXmlType> createAcscEquivLoad() {
		ShortCircuitLoadDataXmlType equivLoad = odmObjFactory.createShortCircuitLoadDataXmlType();
		return odmObjFactory.createAcscEquivLoad(equivLoad);
	}

	/**
	 * create a ShortCircuit Contribution Load object
	 * 
	 */
	public static ShortCircuitLoadDataXmlType createAcscContributeLoad(ShortCircuitBusXmlType busRec) {
		BusLoadDataXmlType loadData = busRec.getLoadData();
		if (loadData == null) { 
			loadData = odmObjFactory.createBusLoadDataXmlType();
			busRec.setLoadData(loadData);
			ShortCircuitLoadDataXmlType equivLoad = odmObjFactory.createShortCircuitLoadDataXmlType();
			loadData.setEquivLoad(odmObjFactory.createAcscEquivLoad(equivLoad));
		}
		ShortCircuitLoadDataXmlType contribLoad = odmObjFactory.createShortCircuitLoadDataXmlType();
	    loadData.getContributeLoad().add(odmObjFactory.createAcscEquivLoad(contribLoad)); 
	    return contribLoad;
	}	
	
	/**
	 * create directed or solid grounding xfr connection xml Type
	 * @return
	 */
	public static XformerConnectionXmlType createDirectedGroundingConnection(){
		XformerConnectionXmlType  xfrConnect = odmObjFactory.createXformerConnectionXmlType();
		GroundingXmlType ground = odmObjFactory.createGroundingXmlType();
		ground.setGroundingConnection(GroundingEnumType.SOLID_GROUNDED);
		xfrConnect.setGrounding(ground);
		return xfrConnect;
	}
	
	/**
	 * create impdeance grounding xfr connection xml Type
	 * ZG = rg + j* xg
	 * @param rg
	 * @param xg
	 * @return
	 */
	public static XformerConnectionXmlType createZGroundingConnection(double rg, double xg){
		XformerConnectionXmlType  xfrConnect = odmObjFactory.createXformerConnectionXmlType();
		GroundingXmlType ground = odmObjFactory.createGroundingXmlType();
		ground.setGroundingConnection(GroundingEnumType.Z_GROUNDED);
		ground.setGroundingZ(BaseDataSetter.createZValue(rg, xg, ZUnitType.PU));
		xfrConnect.setGrounding(ground);
		return xfrConnect;
	}
	
	/**
	 * create ungrounding xfr connection xml Type
	 * @return
	 */
	public static XformerConnectionXmlType createUnGroundingConnection(){
		XformerConnectionXmlType  xfrConnect = odmObjFactory.createXformerConnectionXmlType();
		GroundingXmlType ground = odmObjFactory.createGroundingXmlType();
		ground.setGroundingConnection(GroundingEnumType.UNGROUNDED);
		xfrConnect.setGrounding(ground);
		return xfrConnect;
	}
	
	/**
	 * create bus EquivData info
	 * 
	 * @param parser
	 * @return
	 */
	public static boolean createBusScEquivData(IODMModelParser parser) throws ODMException {
		createBusScEquivGenData(parser);
		
		createBusScEquivLoadData(parser);

		return true;
	}	
	
	/**
	 * consolidate bus scGenContributionList to the equiv gen 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static boolean createBusScEquivGenData(IODMModelParser parser ) throws ODMException {
		LoadflowNetXmlType baseCaseNet = ((AbstractModelParser<ShortCircuitNetXmlType, ShortCircuitBusXmlType, LineShortCircuitXmlType, XfrShortCircuitXmlType, PSXfrShortCircuitXmlType>) parser).getNet();
		
		for ( JAXBElement<? extends BusXmlType> busXml : baseCaseNet.getBusList().getBus()) {
			ShortCircuitBusXmlType scBusXml = (ShortCircuitBusXmlType)busXml.getValue();
			//Consolidate the positive and negative sequence to scEquivLoadData
			ShortCircuitGenDataXmlType scEquivData = (ShortCircuitGenDataXmlType)scBusXml.getGenData().getEquivGen().getValue();
			for( JAXBElement<? extends LoadflowGenDataXmlType> scContriGenEle : scBusXml.getGenData().getContributeGen()) {
				ShortCircuitGenDataXmlType contriGenData = (ShortCircuitGenDataXmlType) scContriGenEle.getValue();
				/*
				 * ZSource is based on GEN MVABASE, therefore, it requires to convert it to system MVABASE
				 *  before setting it to BusScZ
				 */
				double machRatedMva = contriGenData.getRatedMachPower().getValue();
				if (contriGenData.getRatedMachPower().getUnit() == ActivePowerUnitType.MW)   // possible unit PU, W, KW, MW, HP;
				   ;  // do nothing
				else if (contriGenData.getRatedMachPower().getUnit() == ActivePowerUnitType.KW)
					machRatedMva *= 0.001;
				else if (contriGenData.getRatedMachPower().getUnit() == ActivePowerUnitType.W)
					machRatedMva *= 0.000001;
				else {
					throw new ODMException("Wrong acscGen.retedMachPower.unit, " + contriGenData.getRatedMachPower().getUnit());
				}
				
				/*
				double factor =acscBus.getNetwork().getBaseMva()/ machRatedMva;
				ZXmlType z=contriGenData.getPotiveZ();
				 
				acscBus.addScGenZ(new Complex(z.getRe()*factor, z.getIm()*factor),SequenceCode.POSITIVE);
				if(contriGenData.getNegativeZ()!=null){
					z=contriGenData.getNegativeZ();
					acscBus.addScGenZ(new Complex(z.getRe()*factor, z.getIm()*factor),SequenceCode.NEGATIVE);
				}
				if(contriGenData.getZeroZ()!=null){
					z=contriGenData.getZeroZ();
					//Based on PSS/E convention, if Tap-up transformer is modeled as part of generator
					//then, the generator is open from the zero sequence network, which can be model by LargeBusZ , or not adding ScZ.
					boolean zeroOpen =(contriGenData.getXfrZ()==null)? false:(contriGenData.getXfrZ().getIm()==0)?false:true;
					
					if(!zeroOpen && z.getIm()!=0)acscBus.addScGenZ(new Complex(z.getRe()*factor, z.getIm()*factor),SequenceCode.ZERO);
				}
				
				//TODO It is very hard to consolidate the grounding Zg of multi-generators , since they are in series of ZZERO of gens
				 * 
				 */
			}
		   // generator data is modeled at the equivalent Gen level or has been consolidated already. 			
		}
		return true;
	}

	/**
	 * consolidate bus scLoadContributionList to the equiv load 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static boolean createBusScEquivLoadData(IODMModelParser parser ) {
		LoadflowNetXmlType baseCaseNet = ((AbstractModelParser<LoadflowNetXmlType, LoadflowBusXmlType, LineShortCircuitXmlType, XfrShortCircuitXmlType, PSXfrShortCircuitXmlType>) parser).getNet();

		for ( JAXBElement<? extends BusXmlType> busXml : baseCaseNet.getBusList().getBus()) {
			ShortCircuitBusXmlType scBusXml = (ShortCircuitBusXmlType)busXml.getValue();
			ShortCircuitLoadDataXmlType scEquivData = (ShortCircuitLoadDataXmlType)scBusXml.getLoadData().getEquivLoad().getValue();
			for( JAXBElement<? extends LoadflowLoadDataXmlType> scContriLoadEle : scBusXml.getLoadData().getContributeLoad()) {
				ShortCircuitLoadDataXmlType contriLoadData = (ShortCircuitLoadDataXmlType) scContriLoadEle.getValue();
				
				// TODO
			}			
		}
		
		return true;
	}
}
