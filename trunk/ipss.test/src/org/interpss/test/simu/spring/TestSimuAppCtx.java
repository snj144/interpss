 /*
  * @(#)TestSimuAppCtx.java   
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

import org.apache.commons.math.complex.Complex;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.sample.SampleCases;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuSpringAppContext;

public class TestSimuAppCtx extends TestBaseAppCtx {
	
	public void testSimuCtxAclf() {
		System.out.println("\nBegin TestSimuCtx.testSimuCtxAclf");
		
		SimuContext simuCtx = SimuSpringAppContext.getSimuContextTypeAclf();
		SampleCases.load_LF_5BusSystem(simuCtx.getAclfNet(), SpringAppContext.getIpssMsgHub());
		simuCtx.setLoadflowAlgorithm(SimuSpringAppContext.getLoadflowAlgorithm());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = simuCtx.getLoadflowAlgorithm();
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, simuCtx.getAclfNet().isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)(simuCtx.getAclfNet()).getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()));
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, simuCtx.getAclfNet().getBaseKva()).getReal()-2.57943)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, simuCtx.getAclfNet().getBaseKva()).getImaginary()-2.2994)<0.0001);		
		
		System.out.println("\nEnd TestSimuCtx.testSimuCtxAclf");
	}

	public void testSimuCtxAcsc() {
		System.out.println("\nBegin TestSimuCtx.testSimuCtxAcsc");
		
		SimuContext simuCtx = SimuSpringAppContext.getSimuContextTypeAcscFault();
		SampleCases.load_SC_5BusSystem(simuCtx.getAcscFaultNet(), SpringAppContext.getIpssMsgHub());
		simuCtx.setSimpleFaultAlgorithm(SimuSpringAppContext.getSimpleFaultAlgorithm());
		//System.out.println(simuCtx.getAcscFaultNet().net2String());

  		assertEquals(true, (simuCtx.getAcscFaultNet().getBusList().size() == 5 && 
  					       simuCtx.getAcscFaultNet().getBranchList().size() == 5));
  		
  		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("2", simuCtx.getAcscFaultNet());
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		fault.setZLGFault(new Complex(0.0, 0.0));
		fault.setZLLFault(new Complex(0.0, 0.0));
		
	  	SimpleFaultAlgorithm algo = simuCtx.getSimpleFaultAlgorithm();
	  	algo.calculateBusFault(fault, SpringAppContext.getIpssMsgHub());
  		//System.out.println(fault.toString(faultBus.getBaseVoltage(), faultNet.getBaseKva()));
		/*
		 fault amps(1): (  0.0000 + j 32.57143) pu
		 fault amps(2): (  0.0000 + j  0.0000) pu
		 fault amps(0): (  0.0000 + j  0.0000) pu
		 */
		assertEquals(true, compare(fault.getFaultResult().getSCCurrent_012(), 0.0, 0.0, 0.0, 32.57143, 0.0, 0.0) );
		
		//System.out.println(AcscOut.faultResult2String(simuCtx.getAcscFaultNet()));
		
		System.out.println("\nEnd TestSimuCtx.testSimuCtxAcsc");
	}
}
