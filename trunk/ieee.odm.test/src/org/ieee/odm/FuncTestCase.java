package org.ieee.odm;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.ieee.odm.model.JaxbODMModelParser;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.junit.Test;

public class FuncTestCase {
	static String PSSStudyCaseHead = "<PSSStudyCase xmlns=\"http://www.ieee.org/odm/Schema/2008\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">";
	static String PSSStudyCaseEnd = "</PSSStudyCase>";
	
	static String BusListHead = PSSStudyCaseHead + "<baseCase xsi:type=\"LoadflowNetXmlType\"><busList>";
	static String BusListEnd = "</busList></baseCase>" + PSSStudyCaseEnd; 

	static String BranchListHead = PSSStudyCaseHead + "<baseCase xsi:type=\"LoadflowNetXmlType\"><branchList>";
	static String BranchListEnd = "</branchList></baseCase>" + PSSStudyCaseEnd; 

	@Test
	public void parseLodflowBusXmlTypeTestCase() throws Exception {
		String str = PSSStudyCaseHead +
			"<baseCase xsi:type=\"LoadflowNetXmlType\" id=\"Base_Case_from_IEEECDF_format\">" +
			"   <networkCategory>Transmission</networkCategory>" +
			"   <analysisCategory>Loadflow</analysisCategory>" +
			"   <basePower value=\"100.0\" unit=\"MVA\" />" +
			"</baseCase>" +
			PSSStudyCaseEnd;
		
		JaxbODMModelParser parser = new JaxbODMModelParser(str);
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

		parser = new JaxbODMModelParser(str);
		LoadflowBusXmlType bus = (LoadflowBusXmlType)parser.getAclfBaseCase().getBusList().getBus().get(0);
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

		parser = new JaxbODMModelParser(str);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getId() != null);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getFromBus() != null);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getZ().getRe() == .01938);
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
		
		JaxbODMModelParser parser = new JaxbODMModelParser(str);
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

		parser = new JaxbODMModelParser(str);
		assertTrue(parser.getAclfBaseCase().getBusList().getBus().get(0).getId() != null);
		assertTrue(parser.getAclfBaseCase().getBusList().getBus().get(0).getBaseVoltage().getValue() == 132.0);
		
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

		parser = new JaxbODMModelParser(str);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getId() != null);
		assertTrue(parser.getAclfBaseCase().getBranchList().getBranch().get(0).getFromBus() != null);
//		assertTrue(xml.getPSSStudyCase().getBaseCase().getBranchList().getBranchArray(0).getLoadflowDataArray(0).getZ().getRe() == .01938);
	}

	@Test
	public void parseODM1_TestCase() throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream("testdata/ieee_odm/Ieee14Bus_odm.xml"));
		JaxbODMModelParser parser = new JaxbODMModelParser(in);
		
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
