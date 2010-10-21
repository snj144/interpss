 /*
  * @(#)WECC_10212010_TestCase.java   
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

package org.interpss.odm.psse.v30;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.psse.v30.PSSEV30Adapter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.util.IpssLogger;

public class WECC_10212010_TestCase extends BaseTestSetup { 
	@Test
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new PSSEV30Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testdata/psse/PSSE_5Bus_Test.raw"));
		
		AclfModelParser parser = (AclfModelParser)adapter.getModel();
		//parser.stdout();		
		
	}
}


