package com.interpss.test.unit.core.sample;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.*;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.outfunc.AcscOut;
import com.interpss.core.util.sample.SampleCases;
import com.interpss.test.unit.TestBaseAppCtx;

public class TestSample extends TestBaseAppCtx {
	/*
	 * load the 5-bus system
	 */
	public void testCase1() {
  		System.out.println("Begin TestSample.testCase1()");

  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()));
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
  		
		System.out.println("End TestSample.testCase1()");
	}

	public void testCase2() {
  		System.out.println("Begin TestSample.testCase2()");

  		SimpleFaultNetwork faultNet = CoreObjectFactory.createSimpleFaultNetwork();
		SampleCases.load_SC_5BusSystem(faultNet, SpringAppContext.getIpssMsgHub());
		//System.out.println(faultNet.net2String());

  		assertEquals(true, (faultNet.getBusList().size() == 5 && faultNet.getBranchList().size() == 5));
  		
  		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("2", faultNet);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P_LITERAL);
		fault.setZLGFault(new Complex(0.0, 0.0));
		fault.setZLLFault(new Complex(0.0, 0.0));
		
	  	SimpleFaultAlgorithm algo = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet);
	  	algo.calculateBusFault(fault, SpringAppContext.getIpssMsgHub());
  		//System.out.println(fault.toString(faultBus.getBaseVoltage(), faultNet.getBaseKva()));
		/*
		 fault amps(1): (  0.0000 + j 32.57143) pu
		 fault amps(2): (  0.0000 + j  0.0000) pu
		 fault amps(0): (  0.0000 + j  0.0000) pu
		 */
		assertEquals(true, compare(fault.getFaultResult().getSCCurrent_012(), 0.0, 0.0, 0.0, 32.57143, 0.0, 0.0) );
		
		System.out.println(AcscOut.faultResult2String(faultNet));
		
		System.out.println("End TestSample.testCase2()");
	}
}

