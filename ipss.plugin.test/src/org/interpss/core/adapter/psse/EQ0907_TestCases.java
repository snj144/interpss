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
import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter;
import org.interpss.BaseTestSetup;
import org.interpss.display.AclfOutFunc;
import org.interpss.display.impl.AclfOut_PSSE;
import org.interpss.mapper.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class EQ0907_TestCases extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new PSSEV30Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testData/psse/V30/EQ0907.raw"));	
		//FileUtil.writeText2File("testData/output.xml", adapter.getModel().toString());
		
		AclfAdjNetwork net = null;
		IEEEODMMapper mapper = new IEEEODMMapper();
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, SpringAppContext.getIpssMsgHub());
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName("EQ0907");
  	  		simuCtx.setDesc("This project is created by input file adapter.getModel()");
  			net = simuCtx.getAclfAdjNet();
  			//System.out.println(net.net2String());
		}
		else {
  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
  	  		return;
		}	
		
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	
		algo.getAdjAlgorithm().setLimitBackoffCheck(false);
		
		algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	algo.loadflow();

	  	//System.out.println(net.getAclfBus("Bus10357").toString(net.getBaseKva()));
	  	/*
	  	for (Bus bus : net.getBusList()) {
	  		AclfBus aclfBus = (AclfBus)bus;
		  	if (aclfBus.mismatch(AclfMethod.NR).abs() > 0.1)
		  		System.out.println(bus.getId() + " " + ComplexFunc.toString(aclfBus.mismatch(AclfMethod.NR)));
	  	}
		*/
	  	System.out.println(AclfOutFunc.lfResultsPsseStyle(net, AclfOut_PSSE.Format.GUI)); 
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("Bus30117");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		Complex p = swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva());
  		assertTrue(Math.abs(p.getReal()-276.5)<0.1);
  		assertTrue(Math.abs(p.getImaginary()+6.3)<0.1);		  	
	}
}

