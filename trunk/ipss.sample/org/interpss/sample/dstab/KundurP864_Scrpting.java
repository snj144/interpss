 /*
  * @(#)KundurP864_NoFault.java   
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

package org.interpss.sample.dstab;

/*
 * This sample will be a two bus system. 
 */

import java.util.Iterator;

import org.interpss.dstab.control.script.ScriptingExciter;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.datatype.DStabSimuTimeEvent;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DynamicEventProcessor;

public class KundurP864_Scrpting {


    public static void main(String[] args) {
		IPSSMsgHub msg = new IPSSMsgHub();
		KundurP864_Common.setUp(msg);
 		
		DStabilityNetwork net = KundurP864_Common.setNetworkData(msg);
		KundurP864_Common.addDSimuData(net, msg);
        
		ScriptingExciter exc = new ScriptingExciter("LT", "Exc1", "InterPSS");
		exc.setScripts(KundurP864_Common.scripts);
		net.getMachine("LT").addExciter(exc);		
		
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
		
		DynamicEventProcessor handler = new DynamicEventProcessor(msg);
		while (t <= totalTime) {
			handler.onMsgEventStatus(new DStabSimuTimeEvent(DStabSimuTimeEvent.ProessDynamicEvent, net, t));

			for (Iterator itr = net.getDBusDeviceList().iterator(); itr.hasNext(); ) {
				Machine mach = (Machine)itr.next();
					
				// solve DEqn for the step. This includes all controller's nextStep() call
				mach.nextStep(dt, DynamicSimuMethods.MODIFIED_EULER_LITERAL,  mach.getMachineBus(), net, msg);  

				KundurP864_Common.outputSimuResults(mach.getMachineBus(), refMach, t, dt);
			}	
			net.solveNetEqn(false, msg);
			t += dt;
			System.out.println("");
		}
	}
 }
