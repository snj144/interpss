package org.ieee.pes.odm.pss.test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSStudyCaseDocument;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.junit.Test;

public class FuncTestCase {
	static String PSSStudyCaseHead = "<PSSStudyCase xmlns=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\">";
	static String PSSStudyCaseEnd = "</PSSStudyCase>";
	
	static String BusListHead = PSSStudyCaseHead + "<baseCase><busList>";
	static String BusListEnd = "</busList></baseCase>" + PSSStudyCaseEnd; 

	static String BranchListHead = PSSStudyCaseHead + "<baseCase><branchList>";
	static String BranchListEnd = "</branchList></baseCase>" + PSSStudyCaseEnd; 

	@Test
	public void parseTestCase() throws Exception {
		String str = PSSStudyCaseHead +
			"<baseCase id=\"Base_Case_from_IEEECDF_format\">" +
			"   <networkCategory>Transmission</networkCategory>" +
			"   <analysisCategory>Loadflow</analysisCategory>" +
			"   <basePower value=\"100.0\" unit=\"MVA\" />" +
			"</baseCase>" +
			PSSStudyCaseEnd;
		
		PSSStudyCaseDocument xml = PSSStudyCaseDocument.Factory.parse(str);
		assertTrue(xml.getPSSStudyCase().getBaseCase().getBasePower().getValue() == 100.0);
		assertTrue(xml.getPSSStudyCase().getBaseCase().getId() != null);
		
		str = BusListHead +
		"<bus id=\"Bus1\" >" +
		  "<baseVoltage value=\"132.0\" unit=\"KV\"/>" +
		  "<loadflowData>" +
			"<genData code=\"Swing\">" +
				"<equivGen>" +
					"<desiredVoltage value=\"1.06\" unit=\"PU\" />" +
					"<desiredAngle value=\"0.0\" unit=\"DEG\" />" +
				"</equivGen>" +
			"</genData>" +
		  "</loadflowData>" +
		"</bus>" +
		BusListEnd;

		xml = PSSStudyCaseDocument.Factory.parse(str);
		assertTrue(xml.getPSSStudyCase().getBaseCase().getBusList().getBusArray(0).getId() != null);
		assertTrue(xml.getPSSStudyCase().getBaseCase().getBusList().getBusArray(0).getBaseVoltage().getValue() == 132.0);
		
		str = BranchListHead +
		"<branch circuitId=\"1\" id=\"Bus1_to_Bus2_cirId_1\">" +
			"<fromBus idRef=\"Bus1\" />" +
			"<toBus idRef=\"Bus2\" />" +
			"<loadflowData code=\"Line\">" +
				"<lineData>" +
					"<z re=\"0.01938\" im=\"0.05917\" unit=\"PU\" />" +
					"<totalShuntY re=\"0.0\" im=\"0.0528\" unit=\"PU\" />" +
				"</lineData>" +
			"</loadflowData>" +
		"</branch>" +
		BranchListEnd;

		xml = PSSStudyCaseDocument.Factory.parse(str);
		assertTrue(xml.getPSSStudyCase().getBaseCase().getBranchList().getBranchArray(0).getId() != null);
		assertTrue(xml.getPSSStudyCase().getBaseCase().getBranchList().getBranchArray(0).getFromBus() != null);
//		assertTrue(xml.getPSSStudyCase().getBaseCase().getBranchList().getBranchArray(0).getLoadflowDataArray(0).getZ().getRe() == .01938);
	}

	@Test
	public void parseODM1_TestCase() throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream("testdata/ieee_odm/Ieee14Bus_odm.xml"));
		PSSStudyCaseDocument doc = PSSStudyCaseDocument.Factory.parse(in);
		
		assertTrue(doc.getPSSStudyCase().getBaseCase().getBasePower().getValue() == 100.0);
	}

	@Test
	public void parseODM2_TestCase() throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream("testdata/ieee_odm/Ieee14Bus_odm.xml"));
		ODMModelParser parser = new ODMModelParser(in);
		
		assertTrue(parser.getBaseCase().getBasePower().getValue() == 100.0);
	}
}
