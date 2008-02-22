 /*
  * @(#)Test_IEEECommonFormat.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.adapter.ieee;

import java.io.File;
import static org.junit.Assert.assertTrue;

import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.IEEEODMMapper;
import org.junit.Test;

import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuSpringAppContext;

public class IEEEODMXmlTest extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		File xmlFile = new File("testData/ieee_odm/Ieee14Bus.xml");
		IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
		
		SimuContext simuCtx = SimuSpringAppContext.getSimuContext();
		IEEEODMMapper mapper = new IEEEODMMapper();
		assertTrue(mapper.mapping(parser, simuCtx, SimuContext.class));
		//System.out.println(simuCtx.getAclfAdjNet().net2String());

		assertTrue(simuCtx.getAclfAdjNet().getNoBus() == 14);
		assertTrue(simuCtx.getAclfAdjNet().getNoBranch() == 20);
	}
}

