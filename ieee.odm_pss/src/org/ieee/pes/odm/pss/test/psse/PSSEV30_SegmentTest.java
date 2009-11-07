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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter;
import org.junit.Test;

public class PSSEV30_SegmentTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new PSSEV30Adapter(logger);
		assertTrue(adapter.parseInputFile("testData/psse/PSSE30_SegTest.raw"));
		//System.out.println(adapter.getModel());
		
		BranchRecordXmlType branch = adapter.getModel().getBranchRecord("Bus36309", "Bus36703", "Bus36106", "1");
		assertTrue(branch.getLoadflowDataArray()[0].getZ().getRe() == 8.318333333333334E-4);
		assertTrue(branch.getLoadflowDataArray()[0].getZ().getIm() == 0.06339454277227304);
		assertTrue(branch.getLoadflowDataArray()[0].getFromTurnRatio().getValue() == 0.9804347826086957);
		assertTrue(branch.getLoadflowDataArray()[0].getToTurnRatio().getValue() == 1.0);
		
		assertTrue(branch.getLoadflowDataArray()[0].getXfrInfo().getZ23().getRe() == 0.0012787962962962963);
		assertTrue(branch.getLoadflowDataArray()[0].getXfrInfo().getZ31().getRe() == 0.0012266203703703705);
		
		assertTrue(branch.getLoadflowDataArray()[0].getXfrInfo().getRatedVoltage1().getValue() == 345.0);
		
	}
}


