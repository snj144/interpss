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

import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.impl.BaseAclfBusImpl;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class CustomAclfBusTest extends BaseTestSetup {
	@Test
	public void loadBusTests() {
		loadBusTest(AclfMethod.NR_LITERAL, 20);
		loadBusTest(AclfMethod.PQ_LITERAL, 20);
		loadBusTest(AclfMethod.GS_LITERAL, 1000);
	}
	
	private void loadBusTest(AclfMethod method, int maxItr) {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
  		AclfBus loadBus = (AclfBus)net.getBus("1");
  		loadBus.setLoadCode(AclfLoadCode.LOAD_SCRIPTING_LITERAL);
  		loadBus.setExternalAclfBus(new BaseAclfBusImpl() {
  			public boolean isLoad() {
  				return true; }
  			public double getLoadP() {
  				return 1.6;	}
  			public double getLoadQ() {
  				return 0.8;	}
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
	
	@Test
	public void pqBusTests() {
		pqBusTest(AclfMethod.NR_LITERAL, 20);
		pqBusTest(AclfMethod.PQ_LITERAL, 20);
		pqBusTest(AclfMethod.GS_LITERAL, 1000);
	}
	
	private void pqBusTest(AclfMethod method, int maxItr) {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
  		AclfBus loadBus = (AclfBus)net.getBus("1");
  		loadBus.setGenCode(AclfGenCode.GEN_SCRIPTING_LITERAL);
  		loadBus.setExternalAclfBus(new BaseAclfBusImpl() {
  			public boolean isGenPQ() {
  				return true; }
  			public double getGenP() {
  				return 0.0;	}
  			public double getGenQ() {
  				return 0.0;	}
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

	@Test
	public void pvBusTests() {
		pvBusTest(AclfMethod.NR_LITERAL, 20);
		pvBusTest(AclfMethod.PQ_LITERAL, 20);
		pvBusTest(AclfMethod.GS_LITERAL, 1000);
	}

	private void pvBusTest(AclfMethod method, int maxItr) {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
  		AclfBus pvBus = (AclfBus)net.getBus("4");
  		pvBus.setGenCode(AclfGenCode.GEN_SCRIPTING_LITERAL);
  		pvBus.setExternalAclfBus(new BaseAclfBusImpl() {
  			public boolean isGenPV() {
  				return true; }
  			public double getGenP() {
  				return 5.0;	}
  			public double getVoltageMag() {
  				return 1.05;	}
  			});

  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(method);
	  	algo.setMaxIterations(maxItr);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
	}

	@Test
	public void swingBusTests() {
		swingBusTest(AclfMethod.NR_LITERAL, 20);
		swingBusTest(AclfMethod.PQ_LITERAL, 20);
		swingBusTest(AclfMethod.GS_LITERAL, 1000);
	}

	private void swingBusTest(AclfMethod method, int maxItr) {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
  		AclfBus pvBus = (AclfBus)net.getBus("5");
  		pvBus.setGenCode(AclfGenCode.GEN_SCRIPTING_LITERAL);
  		pvBus.setExternalAclfBus(new BaseAclfBusImpl() {
  			public boolean isSwing() {
  				return true; }
  			public double getVoltageMag() {
  				return 1.05;	}
  			public double getVoltageAng() {
  				return 0.0;	}
  			});

  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(method);
	  	algo.setMaxIterations(maxItr);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
	}
}

