package org.ieee.pes.odm.pss.adapter.sample;

import java.io.File;

import org.ieee.cmte.psace.oss.odm.pss.schema.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.BusRecordXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public class CreateSimpleNetwork {
	public static void main(String[] args) {
		IEEEODMPSSModelParser parser = null;
		try {
			parser = new IEEEODMPSSModelParser(new File(
					"samples/SimpleStudyCase.xml"));
		} catch (Exception e) {
			System.err.println("Error to load control Xml file, "
					+ e.toString());
			System.exit(0);
		}

		for (BusRecordXmlType bus : parser.getStucyCase().getBaseCase()
				.getBusList().getBusArray()) {
			System.out.println("Bus Id: " + bus.getId());
		}

		for (BranchRecordXmlType branch : parser.getStucyCase().getBaseCase()
				.getBranchList().getBranchArray()) {
			System.out.println("Branch Id: " + branch.getId()
					+ " connected from: " + branch.getFromBus().getIdRef()
					+ " to: " + branch.getToBus().getIdRef());
		}
	}
}
