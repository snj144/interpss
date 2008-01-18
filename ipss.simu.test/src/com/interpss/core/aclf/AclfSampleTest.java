 /*
  * @(#)AclfSampleTest.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package com.interpss.core.aclf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class AclfSampleTest extends BaseTestSetup {
	/*
	 * load the 5-bus system
	 */
	@Test
	public void sampleTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		//System.out.println("Area1 output power: " + net.areaOutputPower(1, UnitType.PU));
  		assertEquals(true, Math.abs(net.areaOutputPower(1, UnitType.PU)-1.28164)<0.0001);

  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()));
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
	}
}

