 /*
  * @(#)IEEECDF_ODMTest.java   
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
  * @Author Stephen Hou
  * @Version 1.0
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.psse.old;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.dep.v07.psse.v30.PSSEV30Adapter;
import org.ieee.odm.model.dep.jaxb.JaxbODMModelParser;
import org.ieee.odm.model.dep.jaxb.JaxbParserHelper;
import org.ieee.odm.schema.BranchMeterLocationEnumType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.LFBranchCodeEnumType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.junit.Test;

public class XBeanPSSEV30_ODMTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new PSSEV30Adapter(logger);
		assertTrue(adapter.parseInputFile("testdata/psse/PSSE_5Bus_Test.raw"));
		
//		System.out.println(adapter.getModel().toString());
		
		JaxbODMModelParser parser = (JaxbODMModelParser)adapter.getModel();
		//parser.stdout();		
		
		LoadflowNetXmlType net = parser.getAclfBaseCase();
		assertTrue(net.getBasePower().getValue() == 100.0);

/*
      <bus id="Bus1" number="1" areaNumber="1" name="'UNO-U1      '" offLine="false">
        <baseVoltage value="13.8" unit="KV"/>
        <loadflowData>
          <voltage value="1.0" unit="PU"/>
          <angle value="0.0" unit="DEG"/>
          <genData>
            <equivGen code="Swing">
              <power re="22.546" im="15.854" unit="MVA"/>
              <desiredVoltage value="1.0" unit="PU"/>
              <desiredAngle value="0.0" unit="DEG"/>
              <qLimit max="35.0" min="-35.0" unit="MVAR"/>
              <pLimit max="45.0" min="15.0" unit="MW"/>
            </equivGen>
          </genData>
        </loadflowData>
      </bus>
 */
		BusRecordXmlType bus = parser.getBusRecord("Bus1");
		assertTrue(bus.getBaseVoltage().getValue() == 13.8);
		LoadflowGenDataXmlType equivGen = bus.getLoadflowData().getGenData().getEquivGen();
		assertTrue(equivGen.getCode() == LFGenCodeEnumType.SWING);
		assertTrue(equivGen.getDesiredVoltage().getValue() == 1.0);
		assertTrue(equivGen.getDesiredAngle().getValue() == 0.0);
		assertTrue(equivGen.getPLimit().getMax() == 45.0);
		assertTrue(equivGen.getPLimit().getMin() == 15.0);
		assertTrue(equivGen.getQLimit().getMax() == 35.0);
		assertTrue(equivGen.getQLimit().getMin() == -35.0);
		
/*		
      <bus id="Bus2" number="2" areaNumber="1" name="'UNO-230     '" offLine="false">
        <ownerList>
          <owner id="1"/>
        </ownerList>
        <baseVoltage value="230.0" unit="KV"/>
        <loadflowData>
          <voltage value="0.97352" unit="PU"/>
          <angle value="-2.2818" unit="DEG"/>
          <genData>
            <equivGen code="NoneGen"/>
          </genData>
        </loadflowData>
      </bus>
*/
		bus = parser.getBusRecord("Bus2");
		assertTrue(bus.getLoadflowData().getLoadData() == null);
		equivGen = bus.getLoadflowData().getGenData().getEquivGen();
		assertTrue(equivGen.getCode() == LFGenCodeEnumType.NONE_GEN);
		
/*
      <bus id="Bus5" number="5" areaNumber="1" name="'UNO-U2      '" offLine="false">
        <ownerList>
          <owner id="1"/>
        </ownerList>
        <baseVoltage value="13.8" unit="KV"/>
        <loadflowData>
          <voltage value="1.0" unit="PU"/>
          <angle value="-0.0047" unit="DEG"/>
          <genData>
            <equivGen code="PV">
              <power re="22.5" im="15.852" unit="MVA"/>
              <desiredVoltage value="1.0" unit="PU"/>
              <qLimit max="35.0" min="-35.0" unit="MVAR"/>
              <pLimit max="45.0" min="15.0" unit="MW"/>
            </equivGen>
          </genData>
        </loadflowData>
      </bus>
*/
		bus = parser.getBusRecord("Bus5");
		assertTrue(bus.getLoadflowData().getLoadData() == null);
		equivGen = bus.getLoadflowData().getGenData().getEquivGen();
		assertTrue(equivGen.getCode() == LFGenCodeEnumType.PV);
		assertTrue(equivGen.getPower().getRe() == 22.5);
		assertTrue(equivGen.getPower().getIm() == 15.852);
		assertTrue(equivGen.getDesiredVoltage().getValue() == 1.0);
		assertTrue(equivGen.getPLimit().getMax() == 45.0);
		assertTrue(equivGen.getPLimit().getMin() == 15.0);
		assertTrue(equivGen.getQLimit().getMax() == 35.0);
		assertTrue(equivGen.getQLimit().getMin() == -35.0);
		
/*
    <branchList>
      <branch id="Bus2_to_Bus3_cirId_1" circuitId="1" offLine="false">
        <ownerList>
          <owner id="1" ownership="1.0"/>
        </ownerList>
        <fromBus idRef="Bus2"/>
        <toBus idRef="Bus3"/>
        <loadflowData code="Line">
          <z re="0.0015" im="0.0085" unit="PU"/>
          <totalShuntY re="0.0" im="0.0164" unit="PU"/>
          <meterLocation>FromSide</meterLocation>
          <branchRatingLimit>
            <mva rating1="300.0" rating2="330.0" rating3="0.0" unit="MVA"/>
          </branchRatingLimit>
        </loadflowData>
      </branch>
*/
		BranchRecordXmlType branch = parser.getBranchRecord("Bus2", "Bus3", "1");
		LoadflowBranchDataXmlType branchData = JaxbParserHelper.getDefaultBranchData(branch);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.LINE);
		assertTrue(branchData.getZ().getRe() == 0.0015);
		assertTrue(branchData.getZ().getIm() == 0.0085);
		assertTrue(branchData.getTotalShuntY().getRe() == 0.0);
		assertTrue(branchData.getTotalShuntY().getIm() == 0.0164);
		assertTrue(branchData.getMeterLocation() == BranchMeterLocationEnumType.FROM_SIDE);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating1() == 300.0);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating2() == 330.0);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating3() == 0.0);
		
/*
      <branch id="Bus2_to_Bus1_cirId_1" circuitId="1" name="T1          " offLine="false">
        <ownerList>
          <owner id="1" ownership="1.0"/>
        </ownerList>
        <fromBus idRef="Bus2"/>
        <toBus idRef="Bus1"/>
        <loadflowData code="Transformer">
          <z re="0.0" im="0.17191" unit="PU"/>
          <fromTap value="1.0" unit="PU"/>
          <toTap value="1.0" unit="PU"/>
          <meterLocation>ToSide</meterLocation>
          <xfrInfo>
            <ratedPower value="100.0" unit="MVA"/>
            <dataOnSystemBase>true</dataOnSystemBase>
          </xfrInfo>
          <branchRatingLimit>
            <mva rating1="79.0" rating2="118.5" rating3="0.0" unit="MVA"/>
          </branchRatingLimit>
        </loadflowData>
      </branch>
 */
		branch = parser.getBranchRecord("Bus2", "Bus1", "1");
		branchData = JaxbParserHelper.getDefaultBranchData(branch);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER);
		assertTrue(branchData.getZ().getRe() == 0.0);
		assertTrue(branchData.getZ().getIm() == 0.17191);
		assertTrue(branchData.getFromTurnRatio().getValue() == 1.0);
		assertTrue(branchData.getToTurnRatio().getValue() == 1.0);
		assertTrue(branchData.getMeterLocation() == BranchMeterLocationEnumType.TO_SIDE);
		assertTrue(branchData.getMeterLocation() == BranchMeterLocationEnumType.TO_SIDE);
		assertTrue(branchData.getXfrInfo().getRatedPower12().getValue() == 100.0 );
		assertTrue(branchData.getXfrInfo().isDataOnSystemBase());
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating2() == 118.5);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating3() == 0.0);
	}

}


