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

package org.ieee.pes.odm.pss.sample;

import java.io.File;

import org.ieee.cmte.psace.oss.odm.pss.schema.BranchRecordListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.BusRecordListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.PSSNetworkXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public class CreateSimpleNetwork {
	public static void main(String[] args) {
		IEEEODMPSSModelParser parser = null;
		try {
			parser = new IEEEODMPSSModelParser(new File("samples/SimpleStudyCase.xml"));
		} catch (Exception e) {
			System.err.println("Error to load control Xml file, "
					+ e.toString());
			System.exit(0);
		}

		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		for (BusRecordXmlType bus : baseCaseNet.getBusList().getBusArray()) {
			System.out.println("Bus Id: " + bus.getId());
		}

		for (BranchRecordXmlType branch : baseCaseNet.getBranchList().getBranchArray()) {
			System.out.println("Branch Id: " + branch.getId()
					+ " connected from: " + branch.getFromBus().getIdRef()
					+ " to: " + branch.getToBus().getIdRef());
		}
		
		parser = new IEEEODMPSSModelParser();
		baseCaseNet = parser.getBaseCase();

		BusRecordListXmlType busList = baseCaseNet.addNewBusList();
		BusRecordXmlType bus1 = busList.addNewBus();
		bus1.setId("Bus-1");

		BusRecordXmlType bus2 = busList.addNewBus();
		bus2.setId("Bus-2");
		
		BranchRecordListXmlType branchList = baseCaseNet.addNewBranchList();
		BranchRecordXmlType branch = branchList.addNewBranch();
		branch.setId("Bus-1_Bus-2");
		branch.addNewFromBus().setIdRef("Bus-1");
		branch.addNewFromBus().setIdRef("Bus-2");;
		
		System.out.println(parser.toString());
	}
}
