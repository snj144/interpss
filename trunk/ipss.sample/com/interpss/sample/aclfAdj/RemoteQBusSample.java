package com.interpss.sample.aclfAdj;

import com.interpss.test.user.core.AclfAdjFixture;

public class RemoteQBusSample {
	private static void runSample() {
		AclfAdjFixture fixture = new AclfAdjFixture();
		fixture.createAclfNetwork();
	    fixture.setBaseKva(100000);
	    
	    fixture.addSwingBus("Bus1,4000,1.0,0.0,0.0,0.0");
	    fixture.addLoadBus("Bus2,4000,1.0,0.8");
	    fixture.addPQBus("Bus3,4000,0.5,0.4,0.0,0.0");
	   
	    fixture.addLineBranch("Bus1,Bus2,0.05,0.1,0.0");
	    fixture.addLineBranch("Bus3,Bus2,0.05,0.1,0.0");
	    
		// format: controlBusId,remoteBranchId,spec_PU,maxQ,minQ,onFromSide(true/false),flowFrom2To(true/false)
	    fixture.addRemoteQBusMvarFlow("Bus3,Bus3->Bus2(1),0.5,1.0,0.0,false,true");
	    
	    fixture.runAcLoadFlow();
	    fixture.outputAclfDebugInfo();
	}
	
	public static void main(String args[]) {
		runSample();
	}		

}
