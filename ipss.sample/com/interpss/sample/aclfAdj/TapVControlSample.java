package com.interpss.sample.aclfAdj;

import com.interpss.test.user.core.AclfAdjFixture;

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
