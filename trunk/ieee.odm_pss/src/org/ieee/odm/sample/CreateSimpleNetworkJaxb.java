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

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.JaxbODMModelParser;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.StudyCaseXmlType;

public class CreateSimpleNetworkJaxb {
	public static void main(String[] args) throws Exception {
		JaxbODMModelParser parser = new JaxbODMModelParser();

		parser.createBusRecord("Bus-1");
		parser.createBusRecord("Bus-2");
		
		BranchRecordXmlType branch = parser.createBranchRecord("Bus-1_Bus-2");
		branch.setFromBus(parser.createBusRecRef("Bus-1"));
		branch.setToBus(parser.createBusRecRef("Bus-2"));
		
		JAXBElement<StudyCaseXmlType> element = (new ObjectFactory()).createPSSStudyCase(parser.getStudyCase());
		parser.createMarshaller().marshal( element, System.out );
	}
}
