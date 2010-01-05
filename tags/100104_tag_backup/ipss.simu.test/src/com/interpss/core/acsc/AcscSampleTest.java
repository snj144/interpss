 /*
  * @(#)AcscSampleTest.java   
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

package com.interpss.core.acsc;

import static org.junit.Assert.*;
import org.junit.*;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.TestUtilFunc;
import com.interpss.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class AcscSampleTest extends BaseTestSetup {
	@Test
	public void sampleTest() {
  		SimpleFaultNetwork faultNet = CoreObjectFactory.createSimpleFaultNetwork();
		SampleCases.load_SC_5BusSystem(faultNet, SpringAppContext.getIpssMsgHub());
		//System.out.println(faultNet.net2String());

  		assertTrue((faultNet.getBusList().size() == 5 && faultNet.getBranchList().size() == 5));
  		
  		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("2", faultNet);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
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
	  	assertTrue(TestUtilFunc.compare(fault.getFaultResult().getSCCurrent_012(), 
	  			0.0, 0.0, 0.0, 32.57142857157701, 0.0, 0.0) );
		
		//System.out.println(AcscOut.faultResult2String(faultNet));
	}
}

