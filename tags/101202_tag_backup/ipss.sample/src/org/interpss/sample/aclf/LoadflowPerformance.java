 /*
  * @(#)LoadflowPerformance.java   
  *
  * Copyright (C) 2010 www.interpss.org
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
  * @Date 07/15/2010
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.aclf;

import java.util.logging.Level;

import org.interpss.PluginSpringCtx;
import org.interpss.custom.IpssFileAdapter;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.PerformanceTimer;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.pssl.simu.IpssAclf;
import com.interpss.simu.SimuContext;


public class LoadflowPerformance {
	public static void main(String args[]) throws Exception {
		CoreCommonSpringCtx.setAppContext(Constants.SpringConfigPath_Plugin);

		IpssLogger.getLogger().setLevel(Level.WARNING);

	  	PerformanceTimer timer = new PerformanceTimer();

	  	/*
	  	 * time loading data, create ODM and InterPSS Simulation object
	  	 */
	  	timer.start();
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/UCTE_2000_WinterOffPeak.ieee");
	  	timer.logStd("Time for loading the case: ");

		AclfNetwork adjNet = simuCtx.getAclfNet();
		IPSSMsgHub msg = IpssAclf.getMsgHub();

		/*
		 * time running a full NR loadflow
		 */
		timer.start();
	  	LoadflowAlgorithm algoLF = CoreObjectFactory.createLoadflowAlgorithm(adjNet, msg);
	  	algoLF.setLfMethod(AclfMethod.NR);
	  	algoLF.loadflow();
	  	timer.logStd("Time for running Loadflow: ");

	  	/*
	  	 * time running a step of NR method
	  	 */
		timer.start();
	  	algoLF.setLfMethod(AclfMethod.NR_STEP);
	  	algoLF.loadflow();
	  	timer.logStd("Time for running one step NR Loadflow: ");

	  	/*
	  	 * time bus number arrangement
	  	 */
	  	timer.start();
	  	adjNet.setBusNumberArranged(false);
	  	adjNet.accept(CoreObjectFactory.createBusNoArrangeVisitor(msg));
	  	timer.logStd("Time for bus arrangement: ");
	}	
}