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
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.test.ieeecdf;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFLoadCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.odm.model.ParserHelper;
import org.junit.Test;

public class IEEECDF_ODMTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new IeeeCDFAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/ieee_format/Ieee14Bus.ieee"));
		
		PSSNetworkXmlType baseCaseNet = adapter.getModel().getBaseCase();
		assertTrue(baseCaseNet.getBusList().getBusArray().length == 14);
		assertTrue(baseCaseNet.getBranchList().getBranchArray().length == 20);

		assertTrue(baseCaseNet.getBasePower().getValue() == 100.0);
		assertTrue(baseCaseNet.getBasePower().getUnit() == ApparentPowerUnitType.MVA);

		// Check Bus Data
		// ==============
		
		// Bus 1 is a swing bus
		//    1 Bus 1     HV  1  1  3 1.060    0.0      0.0      0.0    232.4   -16.9   132.0  1.060     0.0     0.0   0.0    0.0        0
		BusRecordXmlType busRec = ParserHelper.findBusRecord("Bus1", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getBaseVoltage().getValue() == 132.0);
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 1.060);
		assertTrue(busRec.getLoadflowData().getAngle().getValue() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.SWING);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// Bus 2 is a PV bus with load
		//   2 Bus 2     HV  1  1  2 1.045  -4.98     21.7     12.7     40.0    42.4   132.0  1.045    50.0   -40.0   0.0    0.0        0
		busRec = ParserHelper.findBusRecord("Bus2", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PV);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getRe() == 40.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getMax() == 50.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getMin() == -40.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getUnit() == ReactivePowerUnitType.MVAR);
		
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_P);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 21.7);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 12.7);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);

		// Bus 9 is a load bus, also there is a capacitor of 0.19 pu
		//    9 Bus 9     LV  1  1  0 1.056 -14.94     29.5     16.6      0.0     0.0    35.0  0.0       0.0     0.0   0.0    0.19       0
		busRec = ParserHelper.findBusRecord("Bus9", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_P);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 29.5);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 16.6);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);
		
		assertTrue(busRec.getLoadflowData().getShuntY().getRe() == 0.0);
		assertTrue(busRec.getLoadflowData().getShuntY().getIm() == 0.19);
		assertTrue(busRec.getLoadflowData().getShuntY().getUnit() == YUnitType.PU);
		
		// Bus 7 is non-gen and non-load bus
		//    7 Bus 7     ZV  1  1  0 1.062 -13.37      0.0      0.0      0.0     0.0    35.0  0.0       0.0     0.0   0.0    0.0        0
		busRec = ParserHelper.findBusRecord("Bus7", baseCaseNet);
		//assertTrue(busRec.getLoadflowData().getGenData() == null);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// Check Branch Data
		// =================
		
		// Branch 1->2 is a LIne
		//    1    2  1  1 1 0  0.01938   0.05917     0.0528     0     0     0    0 0  0.0       0.0 0.0    0.0     0.0    0.0   0.0
		BranchRecordXmlType braRec = ParserHelper.findBranchRecord("Bus1", "Bus2", "1", baseCaseNet);
		LoadflowBranchDataXmlType branchData = ParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.LINE); 
		assertTrue(branchData.getZ().getRe() == 0.01938); 
		assertTrue(branchData.getZ().getIm() == 0.05917); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.PU); 
		assertTrue(branchData.getTotalShuntY().getRe() == 0.0); 
		assertTrue(branchData.getTotalShuntY().getIm() == 0.0528); 
		assertTrue(branchData.getTotalShuntY().getUnit() == YUnitType.PU); 
		
		// Branch 4->7 is a Xfr
		//   4    7  1  1 1 1  0.0       0.20912     0.0        0     0     0    0 0  0.978     0.0 0.0    0.0     0.0    0.0   0.0
		braRec = ParserHelper.findBranchRecord("Bus4", "Bus7", "1", baseCaseNet);
		branchData = ParserHelper.getDefaultBranchData(braRec);
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER); 
		assertTrue(branchData.getZ().getRe() == 0.0); 
		assertTrue(branchData.getZ().getIm() == 0.20912); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.PU); 
		//System.out.println(braRec.getLoadflowData().getXformerData().getFromTap());
		//System.out.println(braRec.getLoadflowData().getXformerData().getToTap());
		assertTrue(branchData.getFromTurnRatio().getValue() == 0.978); 
		assertTrue(branchData.getToTurnRatio().getValue() == 1.0); 
	}
	
	public void testCase2() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new IeeeCDFAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/ieee_format/Ieee300Bus.txt"));
	}
}

