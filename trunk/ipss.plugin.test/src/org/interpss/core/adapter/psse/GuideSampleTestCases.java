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
import org.ieee.odm.adapter.xbean.psse.v30.XBeanPSSEV30Adapter;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.mapper.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adj.AclfAdjNetwork;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class GuideSampleTestCases extends BaseTestSetup {
	@Test
	public void testCase() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/psse/PSSE_GuideSample.raw");
  		//System.out.println(simuCtx.getAclfNet().net2String());
		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("3011");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW);
  		//System.out.println(p.getReal() + ", " + p.getImaginary());
  		assertTrue(Math.abs(p.getReal()-258.657)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-104.043)<0.01);
	}

	@Test
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new XBeanPSSEV30Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testData/psse/PSSE_GuideSample.raw"));		
		
		AclfNetwork net = null;
		IEEEODMMapper mapper = new IEEEODMMapper();
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, SpringAppContext.getIpssMsgHub());
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName("Sample18Bus");
  	  		simuCtx.setDesc("This project is created by input file adapter.getModel()");
  			net = simuCtx.getAclfNet();
  			//System.out.println(net.net2String());
		}
		else {
  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
  	  		return;
		}	

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("Bus3011");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW);
  		//System.out.println(p.getReal() + ", " + p.getImaginary());
  		assertTrue(Math.abs(p.getReal()-258.657)<0.01);
  		assertTrue(Math.abs(p.getImaginary()-104.043)<0.01);
	}
}

