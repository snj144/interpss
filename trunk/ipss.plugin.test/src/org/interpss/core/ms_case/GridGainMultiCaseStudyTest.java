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

package org.interpss.core.ms_case;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.util.sample.SampleCases;

public class GridGainMultiCaseStudyTest extends BaseTestSetup {
	@Test
	public void loadProfileCaseTest() throws InterpssException {
		// step-1: define and load a EMF network object
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		// step-2: create a GridMultiStudyCase object, holding the net object
		GridMultiStudyCase gridMCase = CoreObjectFactory.createGridMultiStudyCase(net);
		
		// step-3: define a GridStudyCaseRunner
		gridMCase.setCaseRunner(new TestGridStudyCaseRunner());
		
		// step-4: define an actual case runner to run the case. The actual work is 
		//         delegated to the case runner
		gridMCase.getGridStudyCaseRunner().setCaseRunner(new TestAclfStudyCaseRunner());
		
		// step-5 : define grid task jobs
		gridMCase.createBaseCase();
		for (int i = 1; i <= 24; i++ ) {
			// create study case i
			int caseNumber = i;
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+i, "Case" + i, caseNumber, gridMCase);
			gridMCase.getNetwork().setSortNumber(caseNumber);
			gridMCase.getGridStudyCaseRunner().generateCaseData(studyCase);
			String modelStr = SerializeEMFObjectUtil.saveModel(gridMCase.getNetwork());
			gridMCase.getGridJobs().add(new TestGridGainJob(modelStr));
		}

		// ste-6 : run all grid task jobs 
		assertTrue(gridMCase.runAllCase());
	}	
}