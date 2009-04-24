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

package org.ieee.pes.odm.pss.test.ieeecdf;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BasePowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowGenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.junit.Test;

public class IEEECDF_ODMTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new IeeeCDFAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/ieeecdf/Ieee14Bus.ieee"));
		
		PSSNetworkXmlType baseCaseNet = adapter.getModel().getBaseCase();
		assertTrue(baseCaseNet.getBusList().getBusArray().length == 14);
		assertTrue(baseCaseNet.getBranchList().getBranchArray().length == 20);

		assertTrue(baseCaseNet.getBasePower().getValue() == 100.0);
		assertTrue(baseCaseNet.getBasePower().getUnit() == BasePowerXmlType.Unit.MVA);

		// Check Bus Data
		// ==============
		
		// Bus 1 is a swing bus
		//    1 Bus 1     HV  1  1  3 1.060    0.0      0.0      0.0    232.4   -16.9   132.0  1.060     0.0     0.0   0.0    0.0        0
		BusRecordXmlType busRec = ODMData2XmlHelper.getBusRecord("No1", baseCaseNet);
		assertTrue(busRec.getBaseVoltage().getValue() == 132.0);
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 1.060);
		assertTrue(busRec.getLoadflowData().getAngle().getValue() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.SWING);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// Bus 2 is a PV bus with load
		//   2 Bus 2     HV  1  1  2 1.045  -4.98     21.7     12.7     40.0    42.4   132.0  1.045    50.0   -40.0   0.0    0.0        0
		busRec = ODMData2XmlHelper.getBusRecord("No2", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getGenData().getCode() == LoadflowBusDataXmlType.GenData.Code.PV);
		assertTrue(busRec.getLoadflowData().getGenData().getGen().getPower().getRe() == 40.0);
		assertTrue(busRec.getLoadflowData().getGenData().getGen().getPower().getUnit() == PowerXmlType.Unit.MVA);
		assertTrue(busRec.getLoadflowData().getGenData().getGen().getQGenLimit().getQLimit().getMax() == 50.0);
		assertTrue(busRec.getLoadflowData().getGenData().getGen().getQGenLimit().getQLimit().getMin() == -40.0);
		assertTrue(busRec.getLoadflowData().getGenData().getGen().getQGenLimit().getQLimitUnit() == LoadflowGenDataXmlType.QGenLimit.QLimitUnit.MVAR);
		
		assertTrue(busRec.getLoadflowData().getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_P);
		assertTrue(busRec.getLoadflowData().getLoadData().getLoad().getRe() == 21.7);
		assertTrue(busRec.getLoadflowData().getLoadData().getLoad().getIm() == 12.7);
		assertTrue(busRec.getLoadflowData().getLoadData().getLoad().getUnit() == PowerXmlType.Unit.MVA);

		// Bus 9 is a load bus, also there is a capacitor of 0.19 pu
		//    9 Bus 9     LV  1  1  0 1.056 -14.94     29.5     16.6      0.0     0.0    35.0  0.0       0.0     0.0   0.0    0.19       0
		busRec = ODMData2XmlHelper.getBusRecord("No9", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getLoadData().getCode() == LoadflowBusDataXmlType.LoadData.Code.CONST_P);
		assertTrue(busRec.getLoadflowData().getLoadData().getLoad().getRe() == 29.5);
		assertTrue(busRec.getLoadflowData().getLoadData().getLoad().getIm() == 16.6);
		assertTrue(busRec.getLoadflowData().getLoadData().getLoad().getUnit() == PowerXmlType.Unit.MVA);
		
		assertTrue(busRec.getLoadflowData().getShuntY().getRe() == 0.0);
		assertTrue(busRec.getLoadflowData().getShuntY().getIm() == 0.19);
		assertTrue(busRec.getLoadflowData().getShuntY().getUnit() == YXmlType.Unit.PU);
		
		// Bus 7 is non-gen and non-load bus
		//    7 Bus 7     ZV  1  1  0 1.062 -13.37      0.0      0.0      0.0     0.0    35.0  0.0       0.0     0.0   0.0    0.0        0
		busRec = ODMData2XmlHelper.getBusRecord("No7", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getGenData() == null);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// Check Branch Data
		// =================
		
		// Branch 1->2 is a LIne
		//    1    2  1  1 1 0  0.01938   0.05917     0.0528     0     0     0    0 0  0.0       0.0 0.0    0.0     0.0    0.0   0.0
		BranchRecordXmlType braRec = ODMData2XmlHelper.getBranchRecord("No1", "No2", "1", baseCaseNet);
		assertTrue(braRec.getLoadflowData().getCode() == LoadflowBranchDataXmlType.Code.LINE); 
		assertTrue(braRec.getLoadflowData().getLineData().getZ().getRe() == 0.01938); 
		assertTrue(braRec.getLoadflowData().getLineData().getZ().getIm() == 0.05917); 
		assertTrue(braRec.getLoadflowData().getLineData().getZ().getUnit() == ZXmlType.Unit.PU); 
		assertTrue(braRec.getLoadflowData().getLineData().getTotalShuntY().getRe() == 0.0); 
		assertTrue(braRec.getLoadflowData().getLineData().getTotalShuntY().getIm() == 0.0528); 
		assertTrue(braRec.getLoadflowData().getLineData().getTotalShuntY().getUnit() == YXmlType.Unit.PU); 
		
		// Branch 4->7 is a Xfr
		//   4    7  1  1 1 1  0.0       0.20912     0.0        0     0     0    0 0  0.978     0.0 0.0    0.0     0.0    0.0   0.0
		braRec = ODMData2XmlHelper.getBranchRecord("No4", "No7", "1", baseCaseNet);
		assertTrue(braRec.getLoadflowData().getCode() == LoadflowBranchDataXmlType.Code.TRANSFORMER); 
		assertTrue(braRec.getLoadflowData().getXformerData().getZ().getRe() == 0.0); 
		assertTrue(braRec.getLoadflowData().getXformerData().getZ().getIm() == 0.20912); 
		assertTrue(braRec.getLoadflowData().getXformerData().getZ().getUnit() == ZXmlType.Unit.PU); 
		assertTrue(braRec.getLoadflowData().getXformerData().getFromTurnRatio() == 0.978); 
		assertTrue(braRec.getLoadflowData().getXformerData().getToTurnRatio() == 0.0); 
	}
}

