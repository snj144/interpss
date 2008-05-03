 /*
  * @(#)AclfSampleTest.java   
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.interpss.BaseTestSetup;
import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.input.AclfInputUtilFunc;
import com.interpss.core.util.sample.SampleCases;

public class AclfSampleTest extends BaseTestSetup {
	/*
	 * load the 5-bus system
	 */
	@Test
	public void sampleTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		//System.out.println("Area1 output power: " + net.areaOutputPower(1, UnitType.PU));
  		assertEquals(true, Math.abs(net.areaOutputPower(1, UnitType.PU)-1.28164)<0.0001);

  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()));
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
	}

	@Test
	public void swModel6BusTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());

  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(ComplexFunc.toString(swing.getGenResults(UnitType.PU, net.getBaseKva())));
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.61841)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.31359)<0.0001);
	}
	
	@Test
	public void swModel_1Test() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		load_LF_5BusSystem_SBModel_1(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
//  		System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()));
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
	}

	@Test
	public void swModel_1SplitBusTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		load_LF_5BusSystem_SBModel_1(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
  		AclfBus bus1 = (AclfBus)net.getBus("1");
  		bus1.splitSection(1);

  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());
  		
  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(ComplexFunc.toString(swing.getGenResults(UnitType.PU, net.getBaseKva())));
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.61841)<0.0001);
		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.31359)<0.0001);
	}

	@Test
	public void swModel_2Test() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		load_LF_5BusSystem_SBModel_2(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());

		assertTrue(!((AclfBus)net.getBus("1")).checkData(SpringAppContext.getIpssMsgHub()));
	}

	private void load_LF_5BusSystem_SBModel_1( AclfNetwork net, IPSSMsgHub msgHub )	{
		net.setId( "ACLF 5-bus test system" );
		net.setBaseKva(100000.0);

		/*
		1   1   1    1.6   0.8     1.0    0.0
		2   2   1    2     1       1.0    0.0
		3   3   1    3.7   1.3     1.0    0.0
		4   4   2    5     0.0     1.05   0.0
		5   5   3    0.0   0.0     1.05   0.0
		*/

		AclfInputUtilFunc.addNonGenNonLoadBusTo( net, "1", 13800, 1, 1);
		try {
			AclfInputUtilFunc.addLoadBusTo( net, "1", 1, 13800, 1, 1, AclfLoadCode.CONST_P, 1.2, 0.6, UnitType.PU );
			AclfInputUtilFunc.addLoadBusTo( net, "1", 2, 13800, 1, 1, AclfLoadCode.CONST_P, 0.4, 0.2, UnitType.PU );
		} catch (Exception e) {
			e.printStackTrace();
		}

		AclfInputUtilFunc.addLoadBusTo( net, "2", 13800, 1, 1, AclfLoadCode.CONST_P, 2.0, 1.0, UnitType.PU );
		AclfInputUtilFunc.addLoadBusTo( net, "3", 13800, 2, 1, AclfLoadCode.CONST_P, 3.7, 1.3, UnitType.PU );
		AclfInputUtilFunc.addPVBusTo(   net, "4", 1000,  1, 1, 5.0, UnitType.PU, 1.05, UnitType.PU );
		AclfInputUtilFunc.addSwingBusTo(net, "5", 4000,  2, 1, 1.05, UnitType.PU, 0.0, UnitType.Deg );

		/*
		1   1   2    0.04    0.25    -0.25
		2   1   3    0.1     0.35     0.0
		3   2   3    0.08    0.3     -0.25
		4   4   2    0.0     0.015    1.05
		5   5   3    0.0     0.03     1.05 
		*/

		AclfInputUtilFunc.addLineBranchTo(net, "1", 1, "2", 0, .04, .25, UnitType.PU, .25, UnitType.PU, msgHub );
		AclfInputUtilFunc.addLineBranchTo(net, "1", 2, "3", 0, .1,  .35, UnitType.PU, .0,  UnitType.PU, msgHub );
		AclfInputUtilFunc.addLineBranchTo(net, "2", "3", .08, .3,  UnitType.PU, .25, UnitType.PU, msgHub );
		AclfInputUtilFunc.addXfrBranchTo( net, "4", "2", .0,  .015,UnitType.PU, 1.0, 1.05 , UnitType.PU, msgHub);
		AclfInputUtilFunc.addXfrBranchTo( net, "5", "3", .0,  .03, UnitType.PU, 1.0, 1.05, UnitType.PU, msgHub );

		net.setLfDataLoaded(true);
		msgHub.sendStatusMsg( "ACLF 5-bus test system loaded" );
	}


	private void load_LF_5BusSystem_SBModel_2( AclfNetwork net, IPSSMsgHub msgHub )	{
		net.setId( "ACLF 5-bus test system" );
		net.setBaseKva(100000.0);

		/*
		1   1   1    1.6   0.8     1.0    0.0
		2   2   1    2     1       1.0    0.0
		3   3   1    3.7   1.3     1.0    0.0
		4   4   2    5     0.0     1.05   0.0
		5   5   3    0.0   0.0     1.05   0.0
		*/

		AclfInputUtilFunc.addNonGenNonLoadBusTo( net, "1", 13800, 1, 1);
		try {
			AclfInputUtilFunc.addLoadBusTo( net, "1", 1, 13800, 1, 1, AclfLoadCode.CONST_P, 1.2, 0.6, UnitType.PU );
			AclfInputUtilFunc.addLoadBusTo( net, "1", 2, 13800, 1, 1, AclfLoadCode.CONST_P, 0.4, 0.2, UnitType.PU );
		} catch (Exception e) {
			e.printStackTrace();
		}

		AclfInputUtilFunc.addLoadBusTo( net, "2", 13800, 1, 1, AclfLoadCode.CONST_P, 2.0, 1.0, UnitType.PU );
		AclfInputUtilFunc.addLoadBusTo( net, "3", 13800, 2, 1, AclfLoadCode.CONST_P, 3.7, 1.3, UnitType.PU );
		AclfInputUtilFunc.addPVBusTo(   net, "4", 1000,  1, 1, 5.0, UnitType.PU, 1.05, UnitType.PU );
		AclfInputUtilFunc.addSwingBusTo(net, "5", 4000,  2, 1, 1.05, UnitType.PU, 0.0, UnitType.Deg );

		/*
		1   1   2    0.04    0.25    -0.25
		2   1   3    0.1     0.35     0.0
		3   2   3    0.08    0.3     -0.25
		4   4   2    0.0     0.015    1.05
		5   5   3    0.0     0.03     1.05 
		*/

		AclfInputUtilFunc.addLineBranchTo(net, "1", 1, "2", 0, .04, .25, UnitType.PU, .25, UnitType.PU, msgHub );
		AclfInputUtilFunc.addLineBranchTo(net, "1", "3", .1,  .35, UnitType.PU, .0,  UnitType.PU, msgHub );
		AclfInputUtilFunc.addLineBranchTo(net, "2", "3", .08, .3,  UnitType.PU, .25, UnitType.PU, msgHub );
		AclfInputUtilFunc.addXfrBranchTo( net, "4", "2", .0,  .015,UnitType.PU, 1.0, 1.05 , UnitType.PU, msgHub);
		AclfInputUtilFunc.addXfrBranchTo( net, "5", "3", .0,  .03, UnitType.PU, 1.0, 1.05, UnitType.PU, msgHub );

		net.setLfDataLoaded(true);
		msgHub.sendStatusMsg( "ACLF 5-bus test system loaded" );
	}

	private void load_LF_5BusSystem( AclfNetwork net, IPSSMsgHub msgHub )	{
		net.setId( "ACLF 5-bus test system" );
		net.setBaseKva(100000.0);

		/*
		1   1   1    1.6   0.8     1.0    0.0
		2   2   1    2     1       1.0    0.0
		3   3   1    3.7   1.3     1.0    0.0
		4   4   2    5     0.0     1.05   0.0
		5   5   3    0.0   0.0     1.05   0.0
		*/

		AclfInputUtilFunc.addLoadBusTo( net, "1_1", 13800, 1, 1, AclfLoadCode.CONST_P, 1.2, 0.6, UnitType.PU );
		AclfInputUtilFunc.addLoadBusTo( net, "1_2", 13800, 1, 1, AclfLoadCode.CONST_P, 0.4, 0.2, UnitType.PU );
		AclfInputUtilFunc.addLoadBusTo( net, "2", 13800, 1, 1, AclfLoadCode.CONST_P, 2.0, 1.0, UnitType.PU );
		AclfInputUtilFunc.addLoadBusTo( net, "3", 13800, 2, 1, AclfLoadCode.CONST_P, 3.7, 1.3, UnitType.PU );
		AclfInputUtilFunc.addPVBusTo(   net, "4", 1000,  1, 1, 5.0, UnitType.PU, 1.05, UnitType.PU );
		AclfInputUtilFunc.addSwingBusTo(net, "5", 4000,  2, 1, 1.05, UnitType.PU, 0.0, UnitType.Deg );

		/*
		1   1   2    0.04    0.25    -0.25
		2   1   3    0.1     0.35     0.0
		3   2   3    0.08    0.3     -0.25
		4   4   2    0.0     0.015    1.05
		5   5   3    0.0     0.03     1.05
		*/

		AclfInputUtilFunc.addLineBranchTo(net, "1_1", "2", .04, .25, UnitType.PU, .25, UnitType.PU, msgHub );
		AclfInputUtilFunc.addLineBranchTo(net, "1_2", "3", .1,  .35, UnitType.PU, .0,  UnitType.PU, msgHub );
		AclfInputUtilFunc.addLineBranchTo(net, "2", "3", .08, .3,  UnitType.PU, .25, UnitType.PU, msgHub );
		AclfInputUtilFunc.addXfrBranchTo( net, "4", "2", .0,  .015,UnitType.PU, 1.0, 1.05 , UnitType.PU, msgHub);
		AclfInputUtilFunc.addXfrBranchTo( net, "5", "3", .0,  .03, UnitType.PU, 1.0, 1.05, UnitType.PU, msgHub );

		net.setLfDataLoaded(true);
		msgHub.sendStatusMsg( "ACLF 5-bus test system loaded" );
	}
	
}

