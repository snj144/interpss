 /*
  * @(#)NEIsoEDTestCases.java   
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

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringCtx;
import org.interpss.custom.IpssFileAdapter;
import org.junit.Test;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class NEIsoEDTestCases extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("psse");
		//SimuContext simuCtx = adapter.load("testData/psse/test_model_V29.raw", SpringAppContext.getIpssMsgHub());
		SimuContext simuCtx = adapter.load("testData/psse/test_model_V30.raw");
  		//System.out.println(simuCtx.getAclfNet().net2String());

		AclfNetwork net = simuCtx.getAclfNet();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.setNonDivergent(true);
	  	algo.setLfMethod(AclfMethod.NR);
	  	net.setBypassDataCheck(true);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	}
}
