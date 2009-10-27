 /*
  * @(#)N11Analysis_IEEE14BusTest.java   
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

package org.interpss.contigency;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.display.ContingencyOutFunc;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.ContingencyAnalysisType;

public class N11Analysis_CR_Test extends BaseTestSetup {
	@Test
	public void sampleTest() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/psse/MXV-1120MW_FNC475_FEC196_FAC212_InterPSS_3d.raw");

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		//System.out.println(net.net2String());

	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, net);
		
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.setNonDivergent(true);
		algo.setTolerance(0.01);
		
		mscase.analysis(algo, ContingencyAnalysisType.N11);
		
		System.out.println(ContingencyOutFunc.securityMargin(mscase));		
	}
}

