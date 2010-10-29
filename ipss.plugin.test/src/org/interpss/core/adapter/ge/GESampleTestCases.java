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

package org.interpss.core.adapter.ge;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.xbean.ge.XBeanGE_PSLF_Adapter;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.algorithm.AclfAdjustAlgorithm;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class GESampleTestCases extends BaseTestSetup {
	@Test
	public void testCase2() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ge");
		SimuContext simuCtx = adapter.load("testData/ge/Sample18Bus.epc");
		GeAclfNetwork net = (GeAclfNetwork)simuCtx.getAclfNet();

		assertTrue(net.getNoBus() == 18);
		assertTrue(net.getNoBranch() == 24);
		
		AclfAdjustAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("101");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-5.234)<0.01);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()-1.108)<0.01);
	}	

	@Test
	public void odmAdapterTestCase() throws Exception {
		IODMPSSAdapter adapter = new XBeanGE_PSLF_Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testdata/ge/Sample18Bus.epc"));		
		
		AclfNetwork net = null;
		IEEEODMMapper mapper = new IEEEODMMapper();
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, SpringAppContext.getIpssMsgHub());
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
		
		assertTrue(net.getNoBus() == 18);
		assertTrue(net.getNoBranch() == 24);
		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("Bus101");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-5.234)<0.01);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()-1.108)<0.01);
	}	
}

