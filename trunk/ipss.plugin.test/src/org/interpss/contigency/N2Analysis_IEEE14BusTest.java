 /*
  * @(#)N2Analysis_IEEE14BusTest.java   
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

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.interpss.BaseTestSetup;
import org.interpss.gridgain.secass.ContingencyAnalysisResultHandler;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.ext.gridgain.IRemoteResult;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class N2Analysis_IEEE14BusTest extends BaseTestSetup {
	@Test
	public void sampleTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, net);

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.setNonDivergent(true);
		algo.setTolerance(0.01);
		
		int cnt = 0;
		for (Branch branch1 : net.getBranchList()) {
			branch1.setStatus(false);
			
			for (Branch branch2 : net.getBranchList()) {
				if (!branch1.getId().equals(branch2.getId())) {
					ChangeRecorder recorder = new ChangeRecorder(net);
					
					branch2.setStatus(false);
					System.out.println("====================\nTurn off branches " + 
							branch1.getId() + ", " + branch2.getId());
					
					if (!algo.checkSwingBus())
						algo.assignSwingBus();
					assertTrue(algo.loadflow());

					// transfer aclf results to the study case
					String caseId = "OpenBranch"+branch1.getId()+","+branch2.getId();
					AclfStudyCase scase = SimuObjectFactory.createAclfStudyCase(caseId, 
			  				"Open Branch "+branch1.getId()+ ", " + branch2.getId(), ++cnt, mscase);
			  		scase.getResult().transferAclfResult(net);
				
			  		// update contingency summary results
			  		mscase.updateResult(caseId, scase.getResult());		
			  		
					recorder.endRecording().apply();
				}
			}
			
	  		branch1.setStatus(true);
		}
		
		ContingencyAnalysisResultHandler handler = new ContingencyAnalysisResultHandler();
		//System.out.println(handler.toString(IRemoteResult.DisplayType_SecViolation, mscase));

		System.out.println(handler.toString(IRemoteResult.DisplayType_SecAssessment, mscase));			
	}
}

