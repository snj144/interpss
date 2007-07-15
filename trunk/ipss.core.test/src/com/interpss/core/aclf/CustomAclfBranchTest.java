 /*
  * @(#)CustomAclfBusTest.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package com.interpss.core.aclf;

import static org.junit.Assert.assertTrue;

import org.apache.commons.math.complex.Complex;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.impl.BaseAclfBranchImpl;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class CustomAclfBranchTest extends BaseTestSetup {
	@Test
	public void lineBranchTests() {
		lineBranchTest(AclfMethod.NR_LITERAL, 10);
		lineBranchTest(AclfMethod.PQ_LITERAL, 20);
		lineBranchTest(AclfMethod.GS_LITERAL, 1000);
	}
	
	private void lineBranchTest(AclfMethod method, int maxItr) {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
  		AclfBranch branch = (AclfBranch)net.getBranch("1", "2");
  		branch.setBranchCode(AclfBranchCode.BRANCH_SCRIPTING_LITERAL);
  		branch.setExternalAclfBranch(new BaseAclfBranchImpl() {
  			private final Complex z = new Complex(0.04,0.25);   // pu
  			private final Complex y = ComplexFunc.div(1.0, z);   // pu
  			private final double  hB = 0.25;  //pu

  			public double b11ft() {
			   	return -y.getImaginary();
  			}

  			public double b11tf() {
  				return b11ft();
  			}

  			public double b1ft() {
				return 1.0 / z.getImaginary();
  			}

  			public double b1tf() {
  				return b1ft();
  			}

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
  			});

  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(method);
	  	algo.setMaxIterations(maxItr);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
	}
}

