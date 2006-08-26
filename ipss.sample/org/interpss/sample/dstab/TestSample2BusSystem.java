package org.interpss.sample.dstab;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.datatype.DStabSimuTimeEvent;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DStabSimuTimeEventHandler;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class TestSample2BusSystem extends TestSetupBase {
	
	public void testCase1() {
		System.out.println("Begin TestSample2BusSystem.testCase1()");

 		IpssLogger.getLogger().setLevel(Level.INFO);
		
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET_LITERAL, msg);
		TestCommonUtil.loadCaseData("testData/DStab-2Bus.ipss", simuCtx, msg);
		
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		assertTrue(net.getBusList().size() == 2);
		assertTrue(net.getBranchList().size() == 1);

		assertTrue(net.getDStabBus("0001").getMachine() != null);
		assertTrue(net.getDStabBus("0001").getMachine().getType() == MachineType.EQ1_MODEL_LITERAL);

		assertTrue(net.getDStabBus("0002").getMachine() != null);
		assertTrue(net.getDStabBus("0002").getMachine().getType() == MachineType.ECONSTANT_LITERAL);
		
		assertTrue(net.getDEventList().size() == 0);

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

		// define a bus fault event
		DynamicEvent event1 = DStabObjectFactory.createDEvent("event1", "Bus Fault at 0001", DynamicEventType.BUS_FAULT_LITERAL, net, msg);
		event1.setStartTimeSec(0.1);
		event1.setDurationSec(0.1);
		
		DStabBus faultBus = net.getDStabBus("0001");
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at 0001");
  		fault.setAcscBus(faultBus);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P_LITERAL);
		fault.setZLGFault(Constants.SmallScZ);
		fault.setZLLFault(new Complex(0.0, 0.0));
		event1.setBusFault(fault);			
		
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
				try{
					System.out.print(DStabOutFunc.getStateStr(states));
				} catch (Exception ex) {}
			}	
			net.solveNetEqn(false, msg);
			t += dt;
			System.out.println("");
		}
		
		//System.out.println(net.getDStabBus("0001").getMachine().getAngle());
		//System.out.println(net.getDStabBus("0001").getMachine().getPe());

		//assertTrue(Math.abs(net.getDStabBus("0001").getMachine().getAngle()-0.108146) < 0.0001);
		//assertTrue(Math.abs(net.getDStabBus("0001").getMachine().getPe()-1.66668) < 0.0001);
		
		System.out.println("End TestSample2BusSystem.testCase1()");
	}
}
