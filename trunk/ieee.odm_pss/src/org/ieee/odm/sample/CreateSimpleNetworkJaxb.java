 /*
  * @(#)CreateSimpleNetwork.java   
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.sample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.ieee.odm.model.jaxb.JaxbODMModelParser;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusRefRecordXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.PSSNetworkXmlType;
import org.ieee.odm.schema.StudyCaseXmlType;

public class CreateSimpleNetworkJaxb {
	public static void main(String[] args) throws Exception {
		ObjectFactory factory = new ObjectFactory();

		JaxbODMModelParser parser = new JaxbODMModelParser();
		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();

		PSSNetworkXmlType.BusList busList = baseCaseNet.getBusList();
		BusRecordXmlType bus1 = factory.createBusRecordXmlType();
		busList.getBus().add(bus1);
		bus1.setId("Bus-1");

		BusRecordXmlType bus2 = factory.createBusRecordXmlType();
		busList.getBus().add(bus2);
		bus2.setId("Bus-2");
		
		PSSNetworkXmlType.BranchList branchList = baseCaseNet.getBranchList();
		BranchRecordXmlType branch = factory.createBranchRecordXmlType();
		branchList.getBranch().add(branch);
		branch.setId("Bus-1_Bus-2");
		BusRefRecordXmlType fromBus = factory.createBusRefRecordXmlType();
		BusRefRecordXmlType toBus = factory.createBusRefRecordXmlType();
		fromBus.setIdRef(bus1);
		toBus.setIdRef(bus2);;
		branch.setFromBus(fromBus);
		branch.setToBus(toBus);
		
		JAXBElement<StudyCaseXmlType> element = (new ObjectFactory()).createPSSStudyCase(parser.getStudyCase());
		JAXBContext jaxbContext	= JAXBContext.newInstance("org.ieee.odm.schema");
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal( element, System.out );
	}
}
