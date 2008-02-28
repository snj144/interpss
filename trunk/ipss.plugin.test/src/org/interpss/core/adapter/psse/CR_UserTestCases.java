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

import static org.junit.Assert.assertTrue;

import org.apache.commons.math.complex.Complex;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class CR_UserTestCases extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/psse/PSSE_5Bus_Test.raw", SpringAppContext.getIpssMsgHub());
  		System.out.println(simuCtx.getAclfNet().net2String());

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()-22.547)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-15.852)<0.01);	  	
	}

	@Test
	public void testCase2() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/psse/MXV-1120MW_FNC475_FEC196_FAC212_InterPSS_3d.raw", SpringAppContext.getIpssMsgHub());
  		System.out.println(simuCtx.getAclfNet().net2String());

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());

	  	AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()-1841.530)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-11.485)<0.01);	  	
	}
}

