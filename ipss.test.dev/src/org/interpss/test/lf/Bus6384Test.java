 /*
  * @(#)Test_Bus6384.java   
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

package org.interpss.test.lf;

import static org.junit.Assert.assertTrue;

import org.interpss.fadapter.IpssFileAdapter;
import org.interpss.spring.EditorPluginSpringFactory;
import org.interpss.test.DevTestSetup;
import org.junit.Test;

import com.interpss.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algo.AclfMethod;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class Bus6384Test extends DevTestSetup {
	@Test
	public void testCase1() throws Exception {
  		System.out.println("Start loading data ...");
		IpssFileAdapter adapter = EditorPluginSpringFactory.getCustomFileAdapter("ipssdat");
		SimuContext simuCtx = adapter.load("testData/ipssdata/BUS6384.ipssdat");
  		System.out.println("End loading data ...");

		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
  		assertTrue((net.getBusList().size() == 6384));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.loadflow();
	  	
  		//System.out.println(net.net2String());
	  	
  		assertTrue( net.isLfConverged());		
	}
}

