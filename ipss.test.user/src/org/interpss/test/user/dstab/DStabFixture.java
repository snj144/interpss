 /*
  * @(#)DistFixture.java   
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
  * @Date 11/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.user.dstab;

import org.interpss.test.user.core.AcscFixture;

import com.interpss.simu.SimuSpringAppContext;

public class DStabFixture extends AcscFixture {
	public void createDStabNetwork() {
		simuCtx = SimuSpringAppContext.getSimuContextTypeDStab();
	}	

	/**
	 * Create DynamicSimulationAlgorithm and set the parameters
	 * 
	 * @param startTime
	 * @param timeStep
	 */
	public void setSimulationTimecreateDynamicSimuAlgorithm(double startTime, double timeStep, String simuMethod) {
	}

	public void setRefMachineId(String refMachId) {
	}
	
	public void createDynamicEvent(String id, String name, String type) {
	}
	
	public void setDynamicEventTiming(double startTime, double duration, boolean permanent) {
		
	}
	
	public void outputDStabDebugInfo() {
		System.out.println(simuCtx.getDStabilityNet().net2String());
	}
}
