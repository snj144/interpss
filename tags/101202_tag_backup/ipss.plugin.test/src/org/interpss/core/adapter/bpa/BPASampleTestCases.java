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

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.bpa.xbean.BPAAdapter;
import org.ieee.odm.model.dep.xbean.XBeanODMModelParser;
import org.interpss.BaseTestSetup;
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

public class BPASampleTestCases extends BaseTestSetup {
	@Test
	public void odmAdapterTestCase() throws Exception {
		IODMPSSAdapter adapter = new BPAAdapter(IpssLogger.getLogger());
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
		/*
		 * This test case results are the sample as BPA China results
		 */
		IODMPSSAdapter adapter = new BPAAdapter(IpssLogger.getLogger());
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
}
