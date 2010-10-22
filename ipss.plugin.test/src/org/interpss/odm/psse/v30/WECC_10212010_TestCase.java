 /*
  * @(#)WECC_10212010_TestCase.java   
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
  * @Author Stephen Hou
  * @Version 1.0
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.odm.psse.v30;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.psse.v30.PSSEV30Adapter;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.netAdj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class WECC_10212010_TestCase extends BaseTestSetup { 
	@Test
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new PSSEV30Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testdata/psse/v30/WECC_10212010_09hs2sbp.raw"));
		
		IEEEODMMapper mapper = new IEEEODMMapper();
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		if (!mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
  	  		return;
		}	
  		simuCtx.setName("Sample");
 	  	simuCtx.setDesc("This project is created by input file adapter.getModel()");
 	  	AclfAdjNetwork net = simuCtx.getAclfAdjNet();
 	  	
	  	LoadflowAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, msg);
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	algo.loadflow(); 	  	
	}
}


