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
import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.dep.xbean.psse.v30.XBeanPSSEV30Adapter;
import org.ieee.odm.model.dep.xbean.XBeanODMModelParser;
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
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class GuideSampleTestCases extends BaseTestSetup {
	//@Test
	public void testCase() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/psse/PSSE_GuideSample.raw");
  		//System.out.println(simuCtx.getAclfNet().net2String());
		AclfNetwork net = simuCtx.getAclfNet();
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("3011");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW);
  		System.out.println("------>" + p.getReal() + ", " + p.getImaginary());

//  		assertTrue(Math.abs(p.getReal()-258.657)<0.01);
//  		assertTrue(Math.abs(p.getImaginary()-104.043)<0.01);
  		
  		assertTrue(Math.abs(p.getReal()-250.182)<0.01);
  		assertTrue(Math.abs(p.getImaginary()+124.559)<0.01);
	}

	@Test
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new XBeanPSSEV30Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testData/psse/PSSE_GuideSample.raw"));		
		
		IEEEODMMapper<XBeanODMModelParser> mapper = new IEEEODMMapper<XBeanODMModelParser>(msg);
		SimuContext simuCtx = mapper.map2Model((XBeanODMModelParser)adapter.getModel());
		AclfNetwork net = simuCtx.getAclfNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = net.getAclfBus("Bus3011");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW);
  		//System.out.println(p.getReal() + ", " + p.getImaginary());
  		assertTrue(Math.abs(p.getReal()-258.657)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-104.043)<0.01);
	}
}
