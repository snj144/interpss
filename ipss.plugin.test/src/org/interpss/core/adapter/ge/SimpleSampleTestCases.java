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

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.ext.ge.aclf.GeAclfBranch;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.simu.SimuContext;

public class SimpleSampleTestCases extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ge");
		SimuContext simuCtx = adapter.load("testData/ge/SimpleTest.epc", SpringAppContext.getIpssMsgHub());
		GeAclfNetwork net = (GeAclfNetwork)simuCtx.getAclfAdjNet();
		//System.out.println(simuCtx.getAclfNet().net2String());
		assertTrue(net.getGeAreaList().size() == 4);
		assertTrue(net.getGeZoneList().size() == 5);
		assertTrue(net.getGeOwnerList().size() == 1);

		assertTrue(net.getGeInterfaceList().size() == 4);
		assertTrue(net.getInterface(1).getInfBranchList().size() == 4);
		assertTrue(net.getInterface(2).getInfBranchList().size() == 1);
		
		assertTrue(net.getNoBus() == 5);
		assertTrue(net.getNoBranch() == 2);
		
		assertTrue(((GeAclfBus)net.getBus("1")).getGenList().size() == 2);
		assertTrue(((GeAclfBus)net.getBus("1")).getLoadList().size() == 0);
		assertTrue(((GeAclfBus)net.getBus("2")).getGenList().size() == 1);
		assertTrue(((GeAclfBus)net.getBus("2")).getLoadList().size() == 1);
		assertTrue(((GeAclfBus)net.getBus("3")).getGenList().size() == 0);
		assertTrue(((GeAclfBus)net.getBus("3")).getLoadList().size() == 1);
		
		assertTrue(((GeAclfBranch)net.getBranch("1", "2", "1 ")).getBranchSecList().size() == 1);
		assertTrue(((GeAclfBranch)net.getBranch("1", "2", "2 ")).getBranchSecList().size() == 1);
	}
}

