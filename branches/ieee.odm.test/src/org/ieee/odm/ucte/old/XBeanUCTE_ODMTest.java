 /*
  * @(#)UCTE_ODMTest.java   
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

package org.ieee.odm.ucte.old;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.dep.xbean.XBeanUCTE_DEFAdapter;
import org.ieee.odm.model.dep.xbean.XBeanODMModelParser;
import org.ieee.odm.model.dep.xbean.XBeanParserHelper;
import org.junit.Test;

public class XBeanUCTE_ODMTest {
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMAdapter adapter = new XBeanUCTE_DEFAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/ucte/AusPower_TestCase_Xfr.uct"));
		
		PSSNetworkXmlType baseCaseNet = ((XBeanODMModelParser)adapter.getModel()).getBaseCase();
		assertTrue(baseCaseNet.getBusList().getBusArray().length == 18);
		assertTrue(baseCaseNet.getBranchList().getBranchArray().length == 30);
		
		// A1____1 is a load bus, voltage code 1 -> 380kv
		// A1    1                 0        280.000 .000000 .000000 .000000               
		BusRecordXmlType busRec = XBeanParserHelper.findBusRecord("A1____1", baseCaseNet);
		assertTrue(busRec.getBaseVoltage().getValue() == 380.0);
		assertTrue(busRec.getBaseVoltage().getUnit() == VoltageUnitType.KV);
		// if voltage not defined, it is equal to the base voltage
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 380.0);
		assertTrue(busRec.getLoadflowData().getVoltage().getUnit() == VoltageUnitType.KV);
		assertTrue(busRec.getLoadflowData().getGenData() == null);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 280.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// A2____1 is a load bus
		// A2    1                 0        .000000 .000000 -150.00 .000000                
		busRec = XBeanParserHelper.findBusRecord("A2____1", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PQ);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getRe() == 150.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		
		// B4____1 is a swing bus
		// B4    1                 3 405.00 70.0000 .000000 .000000 .000000                
		busRec = XBeanParserHelper.findBusRecord("B4____1", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 405.0);
		assertTrue(busRec.getLoadflowData().getVoltage().getUnit() == VoltageUnitType.KV);
		assertTrue(busRec.getLoadflowData().getAngle().getValue() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.SWING);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 70.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);

		// A1____1->A2____1 is a line
		// A1    1  A2    1  1 0 1.3600 19.350 240.9601    480 
		BranchRecordXmlType braRec = XBeanParserHelper.findBranchRecord("A1____1", "A2____1", "1", baseCaseNet);
		LoadflowBranchDataXmlType branchData = XBeanParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.LINE); 
		assertTrue(branchData.getZ().getRe() == 1.3600); 
		assertTrue(branchData.getZ().getIm() == 19.350); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.OHM); 
		assertTrue(branchData.getTotalShuntY().getRe() == 0.0); 
		assertTrue(branchData.getTotalShuntY().getIm() == 240.9601); 
		assertTrue(branchData.getTotalShuntY().getUnit() == YUnitType.MICROMHO); 
		assertTrue(branchData.getBranchRatingLimit().getCurrent().getValue() == 480.0); 
		assertTrue(branchData.getBranchRatingLimit().getCurrent().getUnit() == CurrentUnitType.AMP); 
		
		// D1____1->D3____2 is a Xfr
		// D1    1  D3    2  1 0 400.  230.  600.0 .20000 15.000 -16.0000 5.0000   1000 
		braRec = XBeanParserHelper.findBranchRecord("D1____1", "D3____2", "1", baseCaseNet);
		branchData = XBeanParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER); 
		assertTrue(branchData.getZ().getRe() == 0.20); 
		assertTrue(branchData.getZ().getIm() == 15.0); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.OHM); 		
		
		assertTrue(branchData.getFromTurnRatio().getValue() == 1.0); // from ratio not defined, set to default 1.0
		assertTrue(branchData.getToTurnRatio().getValue() == 1.0); 

		assertTrue(branchData.getFromShuntY() == null); 
		assertTrue(branchData.getToShuntY().getRe() == 5.0); 
		assertTrue(branchData.getToShuntY().getIm() == -16.0); 
		assertTrue(branchData.getToShuntY().getUnit() == YUnitType.MICROMHO); 
		
		assertTrue(branchData.getXfrInfo().getRatedVoltage1().getValue() == 400.0); 		
		assertTrue(branchData.getXfrInfo().getRatedVoltage1().getUnit() == VoltageUnitType.KV); 		
		assertTrue(branchData.getXfrInfo().getRatedVoltage2().getValue() == 230.0); 		
		assertTrue(branchData.getXfrInfo().getRatedVoltage2().getUnit() == VoltageUnitType.KV); 		
		assertTrue(branchData.getXfrInfo().getRatedPower12().getValue() == 600.0); 		
		assertTrue(branchData.getXfrInfo().getRatedPower12().getUnit() == ApparentPowerUnitType.MVA); 		
		
		assertTrue(branchData.getBranchRatingLimit().getCurrent().getValue() == 1000.0); 
	}
}

