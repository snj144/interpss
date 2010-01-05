 /*
  * @(#)CustomFuncLoadTest.java   
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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.UnitType;
import com.interpss.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class CustomFuncLoadTest extends BaseTestSetup {
	@Test
	public void fLoadBusTests() throws Exception {
  		fLoadBusTest(new CustomFunctionLoad());
  		fLoadBusTest(CustomFunctionLoad.createObject());
	}

	private void fLoadBusTest(CustomFunctionLoad fload) {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
  		AclfBus loadBus = (AclfBus)net.getBus("1");
  		loadBus.setLoadCode(AclfLoadCode.LOAD_SCRIPTING);
  		loadBus.setExternalAclfBus(fload);

  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		System.out.println(ComplexFunc.toString(swing.getGenResults(UnitType.PU, net.getBaseKva())));
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.4082)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.23437)<0.0001);
	}
}

