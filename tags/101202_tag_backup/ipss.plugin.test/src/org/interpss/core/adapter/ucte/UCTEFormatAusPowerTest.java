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
import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ucte.UCTE_DEFAdapter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringCtx;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.mapper.odm.dep.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class UCTEFormatAusPowerTest extends BaseTestSetup { 
	@Test 
	public void testCaseAclfNet() throws Exception {
		IODMPSSAdapter adapter = new UCTE_DEFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testData/ucte/MarioTest1_Simple.uct");
		
		AclfNetwork net = PluginSpringCtx
				.getOdm2AclfMapper()
				.map2Model((AclfModelParser)adapter.getModel())
				.getAclfNet();
  		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = net.getAclfBus("B4____1");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		Complex p = swing.getGenResults(UnitType.mW);
  		assertTrue(Math.abs(p.getReal()-6.326)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+1289.429)<0.01);
	}
	
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest1_Simple.uct");

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet(), CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("B4____1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW);
  		assertTrue(Math.abs(p.getReal()-6.326)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+1289.429)<0.01);
	}

	//@Test
	public void testCase2() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest2_Xfr.uct");

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet(), CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("B4____1");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		Complex p = swing.getGenResults(UnitType.mW);
  		assertTrue(Math.abs(p.getReal()-6.483)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+1200.454)<0.01);
	}

	//@Test
	public void testCase3() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest3_XfrReg.uct");
  		//System.out.println(simuCtx.getAclfNet().net2String());

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet(), CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("OB4___1");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		Complex p = swing.getGenResults(UnitType.mW);
  		assertTrue(Math.abs(p.getReal()-13.981)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+987.239)<0.01);
	}

	//@Test
	public void testCase4() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest4_PSXfr1.uct");
  		//System.out.println(simuCtx.getAclfNet().net2String());

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet(), CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("OB4___1");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		Complex p = swing.getGenResults(UnitType.mW);
  		assertTrue(Math.abs(p.getReal()-8.172)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+1077.244)<0.01);
	}}

