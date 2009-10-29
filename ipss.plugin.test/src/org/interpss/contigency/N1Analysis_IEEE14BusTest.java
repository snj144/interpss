 /*
  * @(#)N1Analysis_IEEE14BusTest.java   
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

import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.interpss.BaseTestSetup;
import org.interpss.display.ContingencyOutFunc;
import org.interpss.mapper.IpssXmlMapper;
import org.interpss.schema.BranchChangeRecXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.xml.IpssXmlUtilFunc;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.ContingencyAnalysisType;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class N1Analysis_IEEE14BusTest extends BaseTestSetup {
	@Test
	public void sampleTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, net);
	  	
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.setNonDivergent(true);
		algo.setTolerance(0.001);
		
		mscase.analysis(algo, ContingencyAnalysisType.N1);

		System.out.println(ContingencyOutFunc.securityMargin(mscase));		
	}
	
	@Test
	public void qImplTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, net);
	  	
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.setNonDivergent(true);
		algo.setTolerance(0.001);
		
		int cnt = 0;
		for (Branch branch : net.getBranchList()) {
			if (branch.isActive()) {
				String caseId = "[x]"+branch.getId();
				String caseName = "Open Branch "+branch.getId();
				AclfStudyCase scase = SimuObjectFactory.createAclfStudyCase(caseId, caseName, ++cnt, mscase);
				
				ModificationXmlType mod = IpssXmlUtilFunc.createTurnOffBranchRec(branch);
				scase.setModifyModelString(mod.xmlText());
			}
		}
		
		mscase.setLfTolerance(algo.getTolerance());
		algo.loadflow();
		algo.setInitBusVoltage(false);
	  	IpssMapper mapper = new IpssXmlMapper();
		while (!mscase.getStudyCaseList().isEmpty()) {
			ChangeRecorder recorder = new ChangeRecorder(algo.getAclfAdjNetwork());
			
			AclfStudyCase scase = (AclfStudyCase)mscase.getStudyCaseList().poll();
			
		  	mapper.mapping(ModificationXmlType.Factory.parse(scase.getModifyModelString()), 
		  			algo.getAclfAdjNetwork(), ModificationXmlType.class);
			
			scase.runLoadflow(algo, mscase);
	  		
			recorder.endRecording().apply();
		}
		
		System.out.println(ContingencyOutFunc.securityMargin(mscase));		
	}
}

