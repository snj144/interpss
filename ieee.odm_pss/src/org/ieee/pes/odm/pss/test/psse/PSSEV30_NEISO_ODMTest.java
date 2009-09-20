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

package org.ieee.pes.odm.pss.test.psse;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.junit.Test;

public class PSSEV30_NEISO_ODMTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new PSSEV30Adapter(logger);
		assertTrue(adapter.parseInputFile("testData/psse/Model_testV30.raw"));
		//System.out.println(adapter.getModel());
		
		ODMModelParser parser = adapter.getModel();
		PSSNetworkXmlType net = parser.getBaseCase();
		assertTrue(net.getBasePower().getValue() == 100.0);
		/*
     <bus id="Bus1" number="1" areaNumber="1" name="'0000        '" offLine="false">
        <ownerList>
          <owner id="1"/>
        </ownerList>
        <baseVoltage value="345.0" unit="KV"/>
        <loadflowData>
          <voltage value="1.0384173" unit="PU"/>
          <angle value="3.08" unit="DEG"/>
          <genData>
            <equivGen code="NoneGen"/>
          </genData>
        </loadflowData>
      </bus>
      		 */
		BusRecordXmlType bus = parser.getBusRecord("Bus1");
		assertTrue(bus.getBaseVoltage().getValue() == 345.0);
		assertTrue(bus.getBaseVoltage().getUnit() == VoltageUnitType.KV);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.NONE_GEN);

		/*
      <bus id="Bus3" number="3" areaNumber="1" name="'0001        '" offLine="false">
        <loadflowData>
          <genData>
            <equivGen code="PV">
              <power re="0.0" im="-65.628" unit="MVA"/>
              <desiredVoltage value="1.0384173" unit="PU"/>
              <remoteVoltageControlBus idRef="Bus1"/>
              <qLimit max="441.0" min="-155.0" unit="MVAR"/>
              <pLimit max="9999.0" min="-9999.0" unit="MW"/>
            </equivGen>
            <contributeGenList>
              <contributeGen id="'1 '" name="Gen:'1 '(3)" offLine="false">
                <ratedMva value="100.0" unit="MVA"/>
                <genData>
                  <power re="0.0" im="-65.628" unit="MVA"/>
                  <desiredVoltage value="1.03842" unit="PU"/>
                  <remoteVoltageControlBus idRef="Bus1"/>
                  <qLimit max="441.0" min="-155.0" unit="MVAR"/>
                  <pLimit max="9999.0" min="-9999.0" unit="MW"/>
                </genData>
                <sourceZ re="0.0" im="1.0" unit="PU"/>
                <mvarVControlParticipateFactor>1.0</mvarVControlParticipateFactor>
              </contributeGen>
            </contributeGenList>
          </genData>
        </loadflowData>
      </bus>
        */
		bus = parser.getBusRecord("Bus3");
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PV);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getPower().getRe() == 0.0);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getPower().getIm() == -65.628);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getDesiredVoltage().getValue() == 1.0384173);
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getRemoteVoltageControlBus().getIdRef().equals("Bus1"));
		assertTrue(bus.getLoadflowData().getGenData().getEquivGen().getQLimit().getMax() == 441.0);
		assertTrue(bus.getLoadflowData().getGenData().getContributeGenList().getContributeGenArray().length == 1);
	}
}


