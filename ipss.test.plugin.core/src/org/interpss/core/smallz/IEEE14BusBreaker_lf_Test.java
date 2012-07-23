 /*
  * @(#)SampleLoadflow.java   
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

package org.interpss.core.smallz;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;

import org.interpss.CorePluginTestSetup;
import org.interpss.algo.ZeroZBranchProcesor;
import org.interpss.numeric.datatype.Unit.UnitType;
import org.junit.Test;

import com.interpss.CoreObjectFactory;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.AclfSwingBus;
import com.interpss.core.algo.AclfMethod;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.pssl.plugin.IpssAdapter;


public class IEEE14BusBreaker_lf_Test extends CorePluginTestSetup {
	@Test 
	public void case1_regularMethod() throws  InterpssException {
		// Create an AclfNetwork object
		AclfNetwork net = IpssAdapter.importAclfNet("testData/ieee_odm/ieee14Bus_breaker.xml")
				.setFormat(IpssAdapter.FileFormat.IEEE_ODM)
				.load()
				.getAclfNet();
	  	//System.out.println(net.net2String());

	  	// create the default loadflow algorithm
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);

	  	// use the loadflow algorithm to perform loadflow calculation
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow();
	  	
	  	// output loadflow calculation results
	  	//System.out.println(AclfOutFunc.loadFlowSummary(net));

	  	//	  	System.out.println("Active buses: " + net.getNoActiveBus() + ", branches: " + net.getNoActiveBranch());
	  	//assertTrue(net.getNoActiveBus() == 18);
	  	//assertTrue(net.getNoActiveBranch() == 24);
	  	
  		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
  		AclfSwingBus swing = swingBus.toSwingBus();
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-2.3239)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()+0.1655)<0.0001);
    }	

	@Test 
	public void case2_zeroZBranchProcessing()  throws InterpssException {
		// Create an AclfNetwork object
		AclfNetwork net = IpssAdapter.importAclfNet("testData/ieee_odm/ieee14Bus_breaker.xml")
				.setFormat(IpssAdapter.FileFormat.IEEE_ODM)
				.load()
				.getAclfNet();

		IpssLogger.getLogger().setLevel(Level.INFO);
		
	  	// process zero impedance branches in the network
	  	double smallBranchZ = 0.00001;
	  	net.accept(new ZeroZBranchProcesor(smallBranchZ));
	  	assertTrue(net.isZeroZBranchProcessed());
	  	//System.out.println(net.net2String());

	  	// create the default loadflow algorithm
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);

	  	// use the loadflow algorithm to perform loadflow calculation
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow();
	  	
	  	// output loadflow calculation results
	  	//System.out.println(AclfOutFunc.loadFlowSummary(net));

	  	//System.out.println("Active buses: " + net.getNoActiveBus() + ", branches: " + net.getNoActiveBranch());
	  	assertTrue(net.getNoActiveBus() == 14);
	  	assertTrue(net.getNoActiveBranch() == 20);

  		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
  		AclfSwingBus swing = swingBus.toSwingBus();
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getReal()-2.3239)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU).getImaginary()+0.1655)<0.0001);
	}	
}
