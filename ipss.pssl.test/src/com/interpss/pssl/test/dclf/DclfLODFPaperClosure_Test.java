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

package com.interpss.pssl.test.dclf;

import org.interpss.numeric.exp.IpssNumericException;
import org.junit.Test;

import com.interpss.common.exp.InterpssException;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.contingency.BranchOutageType;
import com.interpss.core.dclf.LODFSenAnalysisType;
import com.interpss.core.dclf.common.OutageConnectivityException;
import com.interpss.core.dclf.common.ReferenceBusException;
import com.interpss.pssl.plugin.IpssAdapter;
import com.interpss.pssl.simu.IpssDclf.DclfAlgorithmDSL;
import com.interpss.pssl.simu.IpssPTrading;
import com.interpss.pssl.test.BaseTestSetup;

public class DclfLODFPaperClosure_Test extends BaseTestSetup {
	@Test 
	public void lodfTest_BranchClosure()  throws ReferenceBusException, OutageConnectivityException, InterpssException, IpssNumericException   {
		AclfNetwork net = IpssAdapter.importAclfNet("testData/aclf/ieee14.ieee")
				.setFormat(IpssAdapter.FileFormat.IEEECommonFormat)
				.load()
				.getAclfNet();		
		
		DclfAlgorithmDSL algoDsl = IpssPTrading.createDclfAlgorithm(net)
										.runDclfAnalysis();
		

		algoDsl.setLODFAnalysisType(LODFSenAnalysisType.MULTI_BRANCH)
				.addOutageBranch("Bus1", "Bus5", "1", BranchOutageType.OPEN)
				.addOutageBranch("Bus3", "Bus4", "1", BranchOutageType.OPEN)
				.addOutageBranch("Bus6", "Bus11", "1", BranchOutageType.CLOSE);

		algoDsl.setRefBus("Bus14");
		
		algoDsl.calLineOutageDFactors("ContId");
	}
}

