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

package org.ieee.pes.odm.pss.test.bpa;

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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetAreaXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetZoneXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.bpa.BPAAdapter;
import org.ieee.pes.odm.pss.model.ParserHelper;
import org.junit.Test;

public class BPA_ODMTest { 
	@Test
	public void testCase2() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new BPAAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/bpa/Test009bpa.dat"));
	}
	
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new BPAAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/bpa/IEEE9.dat"));
		
		PSSNetworkXmlType baseCaseNet = adapter.getModel().getBaseCase();
		assertTrue(baseCaseNet.getBusList().getBusArray().length == 9);
		assertTrue(baseCaseNet.getBranchList().getBranchArray().length == 9);

		assertTrue(baseCaseNet.getBasePower().getValue() == 100.0);
		assertTrue(baseCaseNet.getBasePower().getUnit() == ApparentPowerUnitType.MVA);
		
		// check area and zone data
		// A  NF        Gen1     16.5           01    
		// one area: NF, the swing bus in the area is Gen1, with its rated voltage 16.5. 
		// there is only one zone in the area:01.
		
		String area_1="NF";
		NetAreaXmlType area= ParserHelper.getAreaRecordByAreaName(area_1, baseCaseNet);
		//System.out.println(area.getName());
		assertTrue(area.getName().equals("NF"));
		assertTrue(area.getNumber()==1);
		assertTrue(area.getSwingBusId().getName().equals("Gen1"));
		//System.out.println(area.getRatedVoltage().getValue());
		assertTrue(area.getRatedVoltage().getValue() == 16.0);
		assertTrue(area.getRatedVoltage().getUnit() == VoltageUnitType.KV);
		NetZoneXmlType zone= ParserHelper.getZoneRecord("01", area);
		assertTrue(zone.getName().equals("01"));
		assertTrue(zone.getNumber() == 10);
		

		// Check Bus Data
		// ==============
		
		// Bus 1 is a swing bus
		// BS    Gen1    16.501                      999. 999.      1.01    		  
		BusRecordXmlType busRec = ParserHelper.findBusRecord("Gen1", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getBaseVoltage().getValue() == 16.5);
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 1.01);
		assertTrue(busRec.getLoadflowData().getAngle().getValue() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.SWING);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// Gen2 is a PV bus with load
		// BE    Gen2    18.001                      163. 999       1.01     
		busRec = ParserHelper.findBusRecord("Gen2", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PV);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getRe() == 163.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getMax() == 999.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getMin() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getUnit() == ReactivePowerUnitType.MVAR);
		
		//assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_P);
		//assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 21.7);
		//assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 12.7);
		//assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);

		// BusA is a load bus, with a shunt of 20 mvar, which converted to pu system would be equal to 0.0004;
		//B     BusA    230.01 125. 70.0     20.      
		busRec = ParserHelper.findBusRecord("BusA", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_P);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 125.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 70);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);
		
		assertTrue(busRec.getLoadflowData().getShuntY().getRe() == 0.0);
		assertTrue(busRec.getLoadflowData().getShuntY().getIm() == 4.0E-4);// 20/(230*230)
		assertTrue(busRec.getLoadflowData().getShuntY().getUnit() == YUnitType.PU);
		
		// Bus3 is non-gen and non-load bus
		// B     Bus3    230.01
		busRec = ParserHelper.findBusRecord("Bus3", baseCaseNet);
		//assertTrue(busRec.getLoadflowData().getGenData() == null);
		assertTrue(busRec.getLoadflowData() == null);
		//assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// Check Branch Data
		// =================
		
		// Branch Bus1->BusA is a LIne
		//    L     Bus1    230. BusA    230.       .0100 .0850        .0440
		BranchRecordXmlType braRec = ParserHelper.findBranchRecord("Bus1", "BusA", "1", baseCaseNet);
		LoadflowBranchDataXmlType branchData = ParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.LINE); 
		assertTrue(branchData.getZ().getRe() == 0.01); 
		assertTrue(branchData.getZ().getIm() == 0.085); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.PU); 
		assertTrue(branchData.getTotalShuntY().getRe() == 0.0); 
		assertTrue(branchData.getTotalShuntY().getIm() == 0.088); 
		assertTrue(branchData.getTotalShuntY().getUnit() == YUnitType.PU); 
		
		// Branch Gen1->Bus1 is a Xfr
		// T     Gen1    16.5 Bus1    230.             .0567             16.5 242.
		braRec = ParserHelper.findBranchRecord("Gen1", "Bus1", "1", baseCaseNet);
		branchData = ParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER); 
		assertTrue(branchData.getZ().getRe() == 0.0); 
		assertTrue(branchData.getZ().getIm() == 0.0567); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.PU); 
		//System.out.println(braRec.getLoadflowData().getXformerData().getFromTap());
		//System.out.println(braRec.getLoadflowData().getXformerData().getToTap());
		assertTrue(branchData.getFromTap().getValue() == 1.0); 
		assertTrue(branchData.getToTap().getValue() == 1.0522); 
	}
}


