 /*
  * @(#)CR_UserTestCases.java   
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
  * @Date 02/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.adapter.psse;

import org.interpss.PluginTestSetup;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.spring.PluginSpringCtx;
import org.junit.Test;

import com.interpss.simu.SimuContext;

public class Ver30_3_TestCases extends PluginTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/psse/HEonly_with_loads_added_for_interconnects.raw");
//  		System.out.println(simuCtx.getAclfNet().net2String());
/*
		AclfAdjNetwork net = simuCtx.getAclfAdjNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()-22.547)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-15.852)<0.01);
  		*/	  	
	}
}

