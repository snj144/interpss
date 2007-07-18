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

import static org.junit.Assert.assertTrue;

import org.apache.commons.math.complex.Complex;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.util.TestUtilFunc;
import com.interpss.core.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.acsc.impl.BaseAcscBranchImpl;
import com.interpss.core.acsc.impl.BaseAcscBusImpl;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.CoreUtilFunc;
import com.interpss.core.util.input.AcscInputUtilFunc;
import com.interpss.core.util.sample.SampleCases;

public class CustomAcscBranchTest extends BaseTestSetup {
	@Test
	public void sampleTest() {
  		SimpleFaultNetwork faultNet = CoreObjectFactory.createSimpleFaultNetwork();
		SampleCases.load_SC_5BusSystem(faultNet, SpringAppContext.getIpssMsgHub());
		//System.out.println(faultNet.net2String());

  		assertTrue((faultNet.getBusList().size() == 5 && faultNet.getBranchList().size() == 5));
  		
  		AcscBranch branch = (AcscBranch)faultNet.getBranch("1", "2");
  		branch.setBranchCode(AclfBranchCode.BRANCH_SCRIPTING);
  		branch.setExternalAcscBranch(new BaseAcscBranchImpl() {
  			private final Complex z = new Complex(0.00,0.25);   // pu
  			private final Complex y = ComplexFunc.div(1.0, z);   // pu
  			private final double  hB = 0.0;  //pu

  			private final Complex z0 = new Complex(0.0,0.7);   // pu
  			private final Complex y0 = ComplexFunc.div(1.0, z0);   // pu
  			private final double  hB0 = 0.0;  //pu

  			public Complex yff() {
  			   Complex yff = ComplexFunc.add(y, new Complex(0.0, hB));
  			   return yff;
  			}

  			public Complex ytt() {
  				return yff();
  			}

  			public Complex yft() {
  			   return ComplexFunc.mul(-1.0, y);
  			}

  			public Complex ytf() {
  				return yft();
  			}
  			
  			public Complex yff0() {
				return ComplexFunc.add(y0, new Complex(0.0, hB0) );
  			}

  			public Complex ytt0() {
				return yff0();
  			}

  			public Complex yft0() {
				return ComplexFunc.mul(-1.0, y0);
  			}

  			public Complex ytf0() {
				return yft0();
  			}

  			public Complex yft2() {
				return ytf();
  			}

  			public Complex ytf2() {
				return ytf();
  			}
  		});
  		
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

