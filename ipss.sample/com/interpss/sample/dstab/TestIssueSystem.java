package com.interpss.sample.dstab;

import java.util.Hashtable;
import java.util.Iterator;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.datatype.DStabSimuTimeEvent;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DStabSimuTimeEventHandler;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class TestIssueSystem extends TestSetupBase {
	
	public void testCase1() {
		System.out.println("Begin TestIssueSystem.testCase1()");

		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET_LITERAL, msg);
		TestCommonUtil.loadCaseData("testData/TSTest_3_30_06.ipss", simuCtx, msg);
		
		DStabilityNetwork net = simuCtx.getDStabilityNet();

		// run loadflow
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ_LITERAL);
	  	algo.setMaxIterations(20);
	  	algo.setTolerance(0.0001);
	  	algo.loadflow(msg);
		System.out.println(net.net2String());
	  	
	  	if (!net.isLfConverged()) {
	  		System.out.println("Loadflow diverged");
	  		System.exit(0);
	  	}
	  	
		// initial bus sc data, transfer machine sc info to bus.
		net.initialization(msg);
	  	//System.out.println(net.net2String());	  	

	  	double totalTime = 1.0;
		double t = 0.0;
		double dt = 0.01;

		DStabSimuTimeEventHandler handler = new DStabSimuTimeEventHandler(msg);
		while (t <= totalTime) {
			handler.onMsgEvent(new DStabSimuTimeEvent(DStabSimuTimeEvent.ProessDynamicEvent, net, t));

			for (Iterator itr = net.getMachineList().iterator(); itr.hasNext(); ) {
				Machine mach = (Machine)itr.next();
					
				// solve DEqn for the step. This includes all controller's nextStep() call
				mach.nextStep(dt, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 50.0, msg);  

				Hashtable states = mach.getStates(null);
				states.put(DStabOutFunc.OUT_SYMBOL_MACH_ID, mach.getId());
				states.put(DStabOutFunc.OUT_SYMBOL_TIME, new Double(t+dt));
				try {
					System.out.print(DStabOutFunc.getStateStr(states));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			net.solveNetEqn(false, msg);
			t += dt;
			System.out.println("");
		}

		System.out.println("End TestIssueSystem.testCase1()");
	}
}
