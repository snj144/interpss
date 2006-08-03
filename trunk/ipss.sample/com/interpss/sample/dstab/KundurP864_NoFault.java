package com.interpss.sample.dstab;

/*
 * This sample will be a two bus system. 
 */

import java.util.Iterator;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;

import com.interpss.dstab.DynamicSimuMethods;

import com.interpss.dstab.datatype.DStabSimuTimeEvent;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DStabSimuTimeEventHandler;

public class KundurP864_NoFault {
	public static void main(String[] args) {
		IPSSMsgHub msg = new IPSSMsgHub();
		KundurP864_Common.setUp(msg);
 		
		DStabilityNetwork net = KundurP864_Common.setNetworkData(msg);
		KundurP864_Common.addDSimuData(net, msg);
		
		// run loadflow
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ_LITERAL);
	  	algo.setMaxIterations(20);
	  	algo.setTolerance(0.0001);
	  	algo.loadflow(msg);
		//System.out.println(net.net2String());
	  	
	  	if (!net.isLfConverged()) {
	  		System.out.println("Loadflow diverged");
	  		System.exit(0);
	  	}
	  	
		System.out.println(DStabOutFunc.getStateTitleStr());

		// initial bus sc data, transfer machine sc info to bus.
		net.initialization(msg);
	  	//System.out.println(net.net2String());
	
		double totalTime = 0.5;
		double t = 0.0;
		double dt = 0.05;

		Machine refMach = net.getMachine("InfBus");
		
		DStabSimuTimeEventHandler handler = new DStabSimuTimeEventHandler(msg);
		while (t <= totalTime) {
			handler.onMsgEventStatus(new DStabSimuTimeEvent(DStabSimuTimeEvent.ProessDynamicEvent, net, t));

			for (Iterator itr = net.getMachineList().iterator(); itr.hasNext(); ) {
				Machine mach = (Machine)itr.next();
					
				// solve DEqn for the step. This includes all controller's nextStep() call
				mach.nextStep(dt, DynamicSimuMethods.MODIFIED_EULER_LITERAL, net.getFrequency(), msg);  

				KundurP864_Common.outputSimuResults(mach, refMach, t, dt);
			}	
			net.solveNetEqn(false, msg);
			t += dt;
			System.out.println("");
		}
	}
 }
