 /*
  * @(#)TestDStabController.java   
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

package org.interpss.test.simu.spring;

import java.util.List;

import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.datatype.Constants;
import com.interpss.simu.SimuSpringAppContext;
import com.interpss.simu.util.SimuSpringAppCtxUtil;

public class TestDStabController extends TestBaseAppCtx {
	public void testSimuControllerList() {
		System.out.println("\nBegin TestDStabController.testSimuControllerList");
		
		List excList = SimuSpringAppContext.getControllerList(Constants.SID_ExciterList);
		assertTrue(excList.size() > 0);
		assertTrue(SimuSpringAppCtxUtil.getExciter("Simple Exciter") != null);
		
		List govList = SimuSpringAppContext.getControllerList(Constants.SID_GovernorList);
		assertTrue(govList.size() > 0);
		assertTrue(SimuSpringAppCtxUtil.getGovernor("Simple Governor") != null);

		List pssList = SimuSpringAppContext.getControllerList(Constants.SID_StabilizerList);
		assertTrue(pssList.size() > 0);
		assertTrue(SimuSpringAppCtxUtil.getStabilizer("Simple Stabilizer") != null);

		System.out.println("\nEnd TestDStabController.testSimuControllerList");
	}
}
