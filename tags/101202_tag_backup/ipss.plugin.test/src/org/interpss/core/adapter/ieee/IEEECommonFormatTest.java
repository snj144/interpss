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

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringCtx;
import org.interpss.custom.IpssFileAdapter;
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

public class IEEECommonFormatTest extends BaseTestSetup {
	@Test 
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/ieee_format/Ieee14Bus.ieee");
		
		AclfNetwork net = PluginSpringCtx
				.getOdm2AclfMapper()
				.map2Model((AclfModelParser)adapter.getModel())
				.getAclfNet();
		
  		//System.out.println(net.net2String());
		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-2.32393)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()+0.16549)<0.0001);
	}

	@Test
	public void testCase2() throws Exception{
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee30.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 30 && net.getBranchList().size() == 41));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		assertTrue( Math.abs(swing.getGenResults(UnitType.PU).getReal()-2.6095)<0.0001);
  		assertTrue( Math.abs(swing.getGenResults(UnitType.PU).getImaginary()+0.1653)<0.0001);
  		
  		//System.out.println(AclfOut.lfResultsBusStyle(net));
	}

	@Test
	public void testCase3() throws Exception{
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee57.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 57 && net.getBranchList().size() == 80));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-4.7942)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()-1.2951)<0.0001);
  		
  		//System.out.println(AclfOut.lfResultsBusStyle(net));
	}

	@Test
	public void testCase4() throws Exception{
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee118.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 118 && net.getBranchList().size() == 186));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus69");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
		System.out.println(swing.getGenResults(UnitType.PU).getReal());
		System.out.println(swing.getGenResults(UnitType.PU).getImaginary());
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-5.13442)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()+0.82383)<0.0001);
	}
}
