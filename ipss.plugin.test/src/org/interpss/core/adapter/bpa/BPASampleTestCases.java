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

package org.interpss.core.adapter.bpa;

import org.interpss.PluginTestSetup;

public class BPASampleTestCases extends PluginTestSetup {
/*
	@Test
	public void odmAdapterTestCase() throws Exception {
		IODMAdapter adapter = new BPAAdapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testdata/bpa/IEEE9.dat"));		
		
		IEEEODMMapper<XBeanODMModelParser> mapper = new IEEEODMMapper<XBeanODMModelParser>(msg);
		SimuContext simuCtx = mapper.map2Model((XBeanODMModelParser)adapter.getModel());
		AclfNetwork net = simuCtx.getAclfNet();
		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("Gen1");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-1.0586)<0.01);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()-0.6635)<0.01);
	}	

	@Test
	public void odmAdapterTestCase1() throws Exception {
		IODMAdapter adapter = new BPAAdapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testdata/bpa/Test009bpa.dat"));		
		
		IEEEODMMapper<XBeanODMModelParser> mapper = new IEEEODMMapper<XBeanODMModelParser>(msg);
		SimuContext simuCtx = mapper.map2Model((XBeanODMModelParser)adapter.getModel());
		AclfNetwork net = simuCtx.getAclfNet();
		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.loadflow();
		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("bus-1");
		SwingBusAdapter swing = swingBus.toSwingBus();
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-0.7164)<0.01);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()-0.2705)<0.01);
	}
*/
}

