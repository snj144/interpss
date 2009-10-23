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
import com.interpss.simu.multicase.result.BranchResult;

public class N11Analysis_IEEE14BusTest extends BaseTestSetup {
	@Test
	public void sampleTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		//System.out.println(net.net2String());

	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, net);
		
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.setNonDivergent(true);
		algo.setTolerance(0.01);
		
		int cnt = 0;
		for (Branch branch1 : net.getBranchList()) {
			ChangeRecorder recorder = new ChangeRecorder(net);

			branch1.setStatus(false);

			System.out.println("====================\nTurn off branch " + branch1.getId());
			if (!algo.checkSwingBus())
				algo.assignSwingBus();

			assertTrue(algo.loadflow());
			
			// transfer aclf results to the study case
	  		AclfStudyCase scase = SimuObjectFactory.createAclfStudyCase("OpenBranch"+branch1.getId(), "Open Branch "+branch1.getId(), ++cnt, mscase);
	  		scase.getResult().transferAclfResult(net);
		
	  		// update contingency summary results
	  		mscase.updateResult("OpenBranch"+branch1.getId(), scase.getResult());			
			
			recorder.endRecording().apply();

			for (Branch branch2 : net.getBranchList()) {
				if (!branch1.getId().equals(branch2.getId())) {
					// if rating violation
					BranchResult result = scase.getResult().getBranchResult(branch2.getId());
					if (result.getAclfBranchRec().getMvaLoadingPercent() > 100.0) {
						recorder = new ChangeRecorder(net);

						branch1.setStatus(false);
						
						branch2.setStatus(false);
						System.out.println("====================\nTurn off branches " + 
								branch1.getId() + ", " + branch2.getId() + ", " 
								+ result.getAclfBranchRec().getMvaLoadingPercent() + "%");
						
						if (!algo.checkSwingBus())
							algo.assignSwingBus();

						assertTrue(algo.loadflow());

						// transfer aclf results to the study case
						String caseId = "OpenBranch"+branch1.getId()+","+branch2.getId();
				  		scase = SimuObjectFactory.createAclfStudyCase(caseId, 
				  				"Open Branch "+branch1.getId()+ ", " + branch2.getId(), ++cnt, mscase);
				  		scase.getResult().transferAclfResult(net);
					
				  		// update contingency summary results
				  		mscase.updateResult(caseId, scase.getResult());			

						recorder.endRecording().apply();
					}
				}
			}
		}
		
		ContingencyAnalysisResultHandler handler = new ContingencyAnalysisResultHandler();
		//System.out.println(handler.toString(IRemoteResult.DisplayType_SecViolation, mscase));

		System.out.println(handler.toString(IRemoteResult.DisplayType_SecAssessment, mscase));		
	}
}

