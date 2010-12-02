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
import org.ieee.odm.adapter.dep.v07.psse.v26.PSSEV26Adapter;
import org.ieee.odm.model.dep.jaxb.JaxbODMModelParser;
import org.ieee.odm.model.dep.jaxb.JaxbParserHelper;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.LFBranchCodeEnumType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.junit.Test;

public class XBeanPSSEV26_ODMTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new PSSEV26Adapter(logger);
		assertTrue(adapter.parseInputFile("testData/psse/LFModel_testV26.raw"));
		//System.out.println(adapter.getModel());
		
		JaxbODMModelParser parser = (JaxbODMModelParser)adapter.getModel();
		LoadflowNetXmlType net = parser.getAclfBaseCase();
		assertTrue(net.getBasePower().getValue() == 100.0);
		/*
        <bus id="No15021" number="15021" name="'PVERDE 1'" areaNumber="2" zoneNumber="4">
          <genData code="Swing">
            <equivGen>
              <desiredVoltage value="1.07" unit="PU"/>
              <desiredAngle value="3.1024" unit="DEG"/>
            </equivGen>
        </bus>
      		 */
		BusRecordXmlType bus = parser.getBusRecord("Bus15021");
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.SWING);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getDesiredVoltage().getValue() == 1.07);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getDesiredAngle().getValue() == 3.1024);
				
		/*
        <baseVoltage value="115.0" unit="KV"/>
        <loadflowData>
          <voltage value="1.01273" unit="PU"/>
          <angle value="-10.5533" unit="DEG"/>
          <loadData/>
        </loadflowData>
        */
		bus = parser.getBusRecord("Bus31212");
		assertTrue(bus.getBaseVoltage().getValue() == 115.0);
		assertTrue(bus.getLoadflowData().getVoltage().getValue() == 1.01273);
				assertTrue(bus.getLoadflowData().getAngle().getValue() == -10.5533);			
		
		/*
          <genData code="PV">
            <equivGen>
              <power re="8.52" im="2.51" unit="MVA"/>
              <desiredVoltage value="1.0203" unit="PU"/>
              <qLimit max="10.0" min="-6.0" unit="MVAR"/>
            </equivGen>
          </genData>
		 */
						
		// gen bus
		bus = parser.getBusRecord("Bus31435");
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PV);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getPower().getRe() == 8.52);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getPower().getIm() == 2.51);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getDesiredVoltage().getValue() == 1.0203);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getQLimit().getMax() == 10.0);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getQLimit().getMin() == -6.0);

		/*
          <loadData code="CONST_P">
            <equivLoad>
              <constPLoad re="6.5" im="3.86" unit="MVA"/>
            </equivLoad>
          </loadData>
		 */
		bus = parser.getBusRecord("Bus36016");
		assertTrue(bus.getLoadflowData().getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_P);
		assertTrue(bus.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 6.5);
		assertTrue(bus.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 3.86);

		/*
          <shuntQData>
            <equivQ value="75.0" unit="MVAR"/>
          </shuntQData>
		 */
		bus = parser.getBusRecord("Bus30810");
		assertTrue(bus.getLoadflowData().getShuntCompensatorData().getEquivQ().getValue() == 75.0);

		// two loads on a bus, also, gen on the bus is turned off
		/*
      <bus id="No32252" number="32252" name="'APLHIL 1'" areaNumber="1" zoneNumber="1">
        <loadflowData>
          <genData code="OFF">
            <equivGen/>
            <contributeGenList>
              <contributeGen id="' 1'" offLine="true">
              </contributeGen>
            </contributeGenList>
          </genData>
          <loadData code="CONST_P">
            <equivLoad>
              <constPLoad re="20.32" im="0.9199999999999999" unit="MVA"/>
            </equivLoad>
          </loadData>
        </loadflowData>
      </bus>
		 */
		bus = parser.getBusRecord("Bus32252");
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.OFF);
		assertTrue(bus.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 20.32);
		
		// bus turned off case
/*
      <bus id="No367" number="367" name="'MORAGA 2'" offLine="true" areaNumber="1" zoneNumber="1">
        <loadflowData>
          <genData code="OFF">
            <equivGen/>
            <contributeGenList>
            </contributeGenList>
          </genData>
        </loadflowData>
      </bus>
 */
		bus = parser.getBusRecord("Bus32252");
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.OFF);

		// Branch info
		// =========
		/*
      <branch circuitId="' 1'" id="No31212_to_No31210_cirId_' 1'" offLine="false">
        <fromBus idRef="No31212"/>
        <toBus idRef="No31210"/>
        <loadflowData code="Line">
          <lineData>
            <z re="0.00392" im="0.01132" unit="PU"/>
            <totalShuntY re="0.0" im="0.0015" unit="PU"/>
          </lineData>
          <ratingLimit>
            <mva rating1="97.8" rating2="111.7" rating3="0.0" unit="MVA"/>
          </ratingLimit>
        </loadflowData>
      </branch>
		 */
		BranchRecordXmlType branch = parser.getBranchRecord("Bus31212", "Bus31210", "_1");
		LoadflowBranchDataXmlType branchData = JaxbParserHelper.getDefaultBranchData(branch);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.LINE);
		assertTrue(branchData.getZ().getRe() == 0.00392);
		assertTrue(branchData.getZ().getIm() == 0.01132);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating1() == 97.8);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating2() == 111.7);
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating3() == 0.0);
		
		/*
      <branch circuitId="' 1'" id="No31212_to_No31435_cirId_' 1'" offLine="false">
        <fromBus idRef="No31212"/>
        <toBus idRef="No31435"/>
        <loadflowData code="Transformer">
          <xformerData>
            <z re="0.0" im="0.266667" unit="PU"/>
            <fromTap value="1.0" unit="PU"/>
            <toTap value="1.0" unit="PU"/>
          </xformerData>
          <ratingLimit>
            <mva rating1="30.0" rating2="30.0" rating3="0.0" unit="MVA"/>
          </ratingLimit>
        </loadflowData>
      </branch>
		 */
		branch = parser.getBranchRecord("Bus31212", "Bus31435", "_1");
		branchData = JaxbParserHelper.getDefaultBranchData(branch);

		assertTrue(branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER);
		assertTrue(branchData.getZ().getRe() == 0.0);
		assertTrue(branchData.getZ().getIm() == 0.266667);
		assertTrue(branchData.getFromTurnRatio().getValue() == 1.0);
		assertTrue(branchData.getToTurnRatio().getValue() == 1.0);
	}
}


