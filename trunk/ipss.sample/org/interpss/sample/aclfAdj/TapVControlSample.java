 /*
  * @(#)TapVControlSample.java   
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

package org.interpss.sample.aclfAdj;

import org.interpss.test.user.core.AclfAdjFixture;

public class TapVControlSample {
	private static void runSample() {
		AclfAdjFixture fixture = new AclfAdjFixture();
		fixture.createAclfNetwork();
	    fixture.setBaseKva(100000);

	    fixture.addSwingBus("Bus1,4000,1.0,0.0,0.0,0.0");
	    fixture.addLoadBus("Bus2,4000,1.0,0.8");
	    fixture.addPQBus("Bus3,4000,0.5,0.4,0.0,0.0");
	   
	    fixture.addXformerBranch("Bus1,Bus2,0.05,0.1,1.0,1.0");
	    fixture.addLineBranch("Bus3,Bus2,0.05,0.1,0.0");
	    fixture.addLineBranch("Bus1,Bus3,0.05,0.1,0.0");
	   
	    
		// format: xfrFromBusId,xfrToBusId,MvaSpec_PU,maxTap,minTap,adjSteps,tapOnFromSide(true/false),flowFrom2To(true/false)
		fixture.addTapControlMvarFlow("Bus1,Bus2,0.35,1.1,0.9,0,true,true,true");
	    
	    fixture.runAcLoadFlow();
	    fixture.outputAclfDebugInfo();
	}
	
	public static void main(String args[]) {
		runSample();
	}		

}
