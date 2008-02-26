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

package org.interpss.core.adapter.ucte;

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
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class UCTEFormatAusPowerTest extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest1_Simple.uct", SpringAppContext.getIpssMsgHub());

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet());
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("B4____1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()-6.326)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+1289.429)<0.1);
	}

	@Test
	public void testCase2() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest2_Xfr.uct", SpringAppContext.getIpssMsgHub());

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet());
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("B4____1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()-10.881)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+1192.742)<0.1);
	}

	@Test
	public void testCase3() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest3_XfrReg.uct", SpringAppContext.getIpssMsgHub());
  		//System.out.println(simuCtx.getAclfNet().net2String());

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet());
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("OB4___1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()+5621.435)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-2711.046)<0.1);
	}
}

