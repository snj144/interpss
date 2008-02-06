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

package org.interpss.core.adapter.ucte;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class UCTEFormatMarioTest extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("uct");
		SimuContext simuCtx = adapter.load("testData/ucte/MarioTest1.uct", SpringAppContext.getIpssMsgHub());

		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfNet());
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(simuCtx.getAclfNet().net2String());
  		
  		//System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	  	
  		AclfBus swingBus = simuCtx.getAclfNet().getAclfBus("B4____1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.mW, simuCtx.getAclfNet().getBaseKva()).getReal()-6.33)<0.01);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.mVar, simuCtx.getAclfNet().getBaseKva()).getImaginary()+1289.43)<0.1);
	}
}

