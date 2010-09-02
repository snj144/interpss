package org.ieee.odm;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.jaxb.JaxbODMModelParser;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.junit.Test;

public class FuncTestCase {
	static String PSSStudyCaseHead = "<pssStudyCase xmlns=\"http://www.ieee.org/odm/Schema/2008\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">";
	static String PSSStudyCaseEnd = "</pssStudyCase>";
	
	static String BusListHead = PSSStudyCaseHead + "<baseCase xsi:type=\"LoadflowNetXmlType\"><busList>";
	static String BusListEnd = "</busList></baseCase>" + PSSStudyCaseEnd; 

	static String BranchListHead = PSSStudyCaseHead + "<baseCase xsi:type=\"LoadflowNetXmlType\"><branchList>";
	static String BranchListEnd = "</branchList></baseCase>" + PSSStudyCaseEnd; 

	@Test
	public void removeObjectTestCase() throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream("testdata/ieee_odm/Ieee14Bus_odm.xml"));
		JaxbODMModelParser parser = new JaxbODMModelParser();
		parser.parse(in);
		
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().size() == 20);
		assertTrue(parser.getAclfBaseCase().getBusList().getBus().size() == 14);

		assertTrue(parser.getBus("Bus1") != null);
		
//		parser.removeBus("Bus1");
//		assertTrue(parser.getAclfBaseCase().getBusList().getBus().size() == 13);
//		assertTrue(parser.getBus("Bus1") == null);

//		assertTrue(parser.getBranch("Bus4_to_Bus7_cirId_1") != null);
//		parser.removeBranch("Bus4_to_Bus7_cirId_1");
//		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().size() == 19);
//		assertTrue(parser.getBranch("Bus4_to_Bus7_cirId_1") == null);
	}
	
	@Test
	public void castingTestCase() throws Exception {
		String str = BranchListHead +
		      "<aclfXfr areaNumber=\"1\" zoneNumber=\"1\" circuitId=\"1\" id=\"Bus4_to_Bus7_cirId_1\">" +
		      "  <fromBus idRef=\"Bus4\"/>" +
		      "  <toBus idRef=\"Bus7\"/>" +
		      "    <z re=\"0.0\" im=\"0.20912\" unit=\"PU\"/>" +
		      "    <fromTurnRatio value=\"0.978\" unit=\"PU\"/>" +
		      "    <toTurnRatio value=\"1.0\" unit=\"PU\"/>" +
		      "    <xfrInfo>" +
		      "      <fromRatedVoltage value=\"132.0\" unit=\"KV\"/>" +
		      "      <toRatedVoltage value=\"35.0\" unit=\"KV\"/>" +
		      "    </xfrInfo>" +
		      "</aclfXfr>" + 
		      BranchListEnd;		
		
		AclfModelParser parser = ODMObjectFactory.createAclfModelParser();
		if (parser.parse(str)) {
			XfrBranchXmlType xfr = (XfrBranchXmlType)parser.getAclfNet().getBranchList().getBranch().get(0).getValue();
			
			PSXfrBranchXmlType psXfr = (PSXfrBranchXmlType)ModelStringUtil.casting(xfr, "aclfXfr", "aclfPSXfr");
			assertTrue(psXfr.getId() != null);
			assertTrue(psXfr.getFromBus() != null);
			assertTrue(psXfr.getZ().getIm() == .20912);
		}
	}
	
	@Test
	public void parseLodflowBusXmlTypeTestCase() throws Exception {
		String str = PSSStudyCaseHead +
			"<baseCase xsi:type=\"LoadflowNetXmlType\" id=\"Base_Case_from_IEEECDF_format\">" +
			"   <networkCategory>Transmission</networkCategory>" +
			"   <analysisCategory>Loadflow</analysisCategory>" +
			"   <basePower value=\"100.0\" unit=\"MVA\" />" +
			"</baseCase>" +
			PSSStudyCaseEnd;
		
		JaxbODMModelParser parser = new JaxbODMModelParser();
		parser.parse(str);
		assertTrue(parser.getAclfBaseCase().getBasePower().getValue() == 100.0);
		assertTrue(parser.getAclfBaseCase().getId() != null);
		
		str = BusListHead +
		"<bus xsi:type=\"LoadflowBusXmlType\" id=\"Bus1\" >" +
		  "<baseVoltage value=\"132.0\" unit=\"KV\"/>" +
		  "<genData code=\"Swing\">" +
			"<equivGen>" +
				"<desiredVoltage value=\"1.06\" unit=\"PU\" />" +
				"<desiredAngle value=\"0.0\" unit=\"DEG\" />" +
			"</equivGen>" +
		  "</genData>" +
		"</bus>" +
		BusListEnd;

		parser = new JaxbODMModelParser();
		parser.parse(str);
		LoadflowBusXmlType bus = (LoadflowBusXmlType)parser.getAclfBaseCase().getBusList().getBus().get(0).getValue();
		assertTrue(bus.getId() != null);
		assertTrue(bus.getBaseVoltage().getValue() == 132.0);
		assertTrue(bus.getGenData().getEquivGen().getDesiredVoltage().getValue() == 1.06);
		
		str = BranchListHead +
		"<branch xsi:type=\"LineBranchXmlType\" circuitId=\"1\" id=\"Bus1_to_Bus2_cirId_1\">" +
			"<fromBus idRef=\"Bus1\" />" +
			"<toBus idRef=\"Bus2\" />" +
			"<z re=\"0.01938\" im=\"0.05917\" unit=\"PU\" />" +
			"<totalShuntY re=\"0.0\" im=\"0.0528\" unit=\"PU\" />" +
		"</branch>" +
		BranchListEnd;

		parser = new JaxbODMModelParser();
		parser.parse(str);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getValue().getId() != null);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getValue().getFromBus() != null);
		assertTrue(((LineBranchXmlType)(parser.getAclfBaseCase().getBranchList().getBranch().get(0)).getValue()).getZ().getRe() == .01938);
	}

	@Test
	public void parseTestCase() throws Exception {
		String str = PSSStudyCaseHead +
			"<baseCase xsi:type=\"LoadflowNetXmlType\" id=\"Base_Case_from_IEEECDF_format\">" +
			"   <networkCategory>Transmission</networkCategory>" +
			"   <analysisCategory>Loadflow</analysisCategory>" +
			"   <basePower value=\"100.0\" unit=\"MVA\" />" +
			"</baseCase>" +
			PSSStudyCaseEnd;
		
		JaxbODMModelParser parser = new JaxbODMModelParser();
		parser.parse(str);
		assertTrue(parser.getAclfBaseCase().getBasePower().getValue() == 100.0);
		assertTrue(parser.getAclfBaseCase().getId() != null);
		
		str = BusListHead +
		"<bus xsi:type=\"BusRecordXmlType\" id=\"Bus1\" >" +
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

		parser = new JaxbODMModelParser();
		parser.parse(str);
		assertTrue(parser.getAclfBaseCase().getBusList().getBus().get(0).getValue().getId() != null);
		assertTrue(parser.getAclfBaseCase().getBusList().getBus().get(0).getValue().getBaseVoltage().getValue() == 132.0);
		
		str = BranchListHead +
		"<branch xsi:type=\"LineBranchXmlType\" circuitId=\"1\" id=\"Bus1_to_Bus2_cirId_1\">" +
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

		parser = new JaxbODMModelParser();
		parser.parse(str);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getValue().getId() != null);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getValue().getFromBus() != null);
//		assertTrue(xml.getPSSStudyCase().getBaseCase().getBranchList().getBranchArray(0).getLoadflowDataArray(0).getZ().getRe() == .01938);
	}

	@Test
	public void parseODM1_TestCase() throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream("testdata/ieee_odm/Ieee14Bus_odm.xml"));
		JaxbODMModelParser parser = new JaxbODMModelParser();
		parser.parse(in);
		
		assertTrue(parser.getAclfBaseCase().getBasePower().getValue() == 100.0);
		
		LoadflowBusXmlType bus = (LoadflowBusXmlType)parser.getBus("Bus1");
		assertTrue(bus != null);
		/*
      <bus xsi:type="LoadflowBusXmlType" id="Bus1" name="Bus 1     HV" areaNumber="1" zoneNumber="1">
        <baseVoltage value="132.0" unit="KV"/>
          <voltage value="1.06" unit="PU"/>
          <angle value="0.0" unit="DEG"/>
          <genData>
            <equivGen id="Bus1_Gen" code="Swing">
              <power re="232.4" im="-16.9" unit="MVA"/>
              <desiredVoltage value="1.06" unit="PU"/>
              <desiredAngle value="0.0" unit="DEG"/>
            </equivGen>
          </genData>
      </bus>		 */
		assertTrue(bus.getBaseVoltage().getValue() == 132.0);
		assertTrue(bus.getGenData().getEquivGen().getPower().getRe() == 232.4);
		
		/*
      <branch xsi:type="LineBranchXmlType" areaNumber="1" zoneNumber="1" circuitId="1" id="Bus1_to_Bus2_cirId_1">
        <fromBus idRef="Bus1"/>
        <toBus idRef="Bus2"/>
          <z re="0.01938" im="0.05917" unit="PU"/>
          <totalShuntY re="0.0" im="0.0528" unit="PU"/>
      </branch>		 */
		LineBranchXmlType line = (LineBranchXmlType)parser.getBranch("Bus1_to_Bus2_cirId_1");
		assertTrue(line != null);
		assertTrue(line.getZ().getRe() == 0.01938);
		
		/*
	      <branch xsi:type="XfrBranchXmlType" areaNumber="1" zoneNumber="1" circuitId="1" id="Bus4_to_Bus7_cirId_1">
	        <fromBus idRef="Bus4"/>
	        <toBus idRef="Bus7"/>
	          <z re="0.0" im="0.20912" unit="PU"/>
	          <fromTurnRatio value="0.978" unit="PU"/>
	          <toTurnRatio value="1.0" unit="PU"/>
	          <xfrInfo>
	            <fromRatedVoltage value="132.0" unit="KV"/>
	            <toRatedVoltage value="35.0" unit="KV"/>
	          </xfrInfo>
	      </branch>  */		
		XfrBranchXmlType xfr = (XfrBranchXmlType)parser.getBranch("Bus4_to_Bus7_cirId_1");
		assertTrue(xfr != null);
		assertTrue(xfr.getZ().getIm() == 0.20912);
		assertTrue(xfr.getFromTurnRatio().getValue() == 0.978);
		assertTrue(xfr.getXfrInfo().getFromRatedVoltage().getValue() == 132.0);
	}
}
