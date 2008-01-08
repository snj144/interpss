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
import org.interpss.core.gridgain.aclf.Aclf5BusSampleAclfStudyCaseRunner;
import org.interpss.core.gridgain.aclf.SampleGridGainJob;
import org.interpss.core.gridgain.aclf.SampleGridStudyCaseRunner;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InterpssException;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCaseCreationType;
import com.interpss.core.util.sample.SampleCases;

public class GridGain_DC_MultiCaseStudyTest extends BaseTestSetup {
	@Test
	public void loadProfileCaseTest() throws InterpssException {
		// step-1: define and load a EMF network object
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		// step-2: create a GridMultiStudyCase object, holding the net object
		GridMultiStudyCase gridMCase = CoreObjectFactory.createGridMultiStudyCase(net, StudyCaseCreationType.DISTRIBUTED_CREATION);
		
		// step-3: define a GridStudyCaseRunner
		gridMCase.setCaseRunner(new SampleGridStudyCaseRunner());
		
		// step-4: define an actual case runner to run the case. The actual work is 
		//         delegated to the case runner
		gridMCase.getGridStudyCaseRunner().setCaseRunner(new Aclf5BusSampleAclfStudyCaseRunner());
		
		// step-5 : define grid task jobs
		gridMCase.createBaseCase();
		for (int i = 1; i <= 24; i++ ) {
			// create study case i
			int caseNumber = i;
			gridMCase.getGridJobs().add(new SampleGridGainJob(Integer.toString(caseNumber)));
		}

		// ste-6 : run all grid task jobs 
		assertTrue(gridMCase.runAllCase());
/*		
		StudyCase case1 = gridMCase.getStudyCase("StudyCase1");
		assertTrue(((AclfNetworkResult)case1.getNetResult()).isLfConverged());
		AclfBusResult busResult = (AclfBusResult)case1.getBusResult("1");
		assertTrue(Math.abs(busResult.getLoad().getReal()-0.48)<0.0001);
		assertTrue(Math.abs(busResult.getLoad().getImaginary()-0.16) < 0.0001);

		StudyCase case12 = gridMCase.getStudyCase("StudyCase12");
		assertTrue(((AclfNetworkResult)case12.getNetResult()).isLfConverged());
		busResult = (AclfBusResult)case12.getBusResult("1");
		assertTrue(Math.abs(busResult.getLoad().getReal()-1.6)<0.0001);
		assertTrue(Math.abs(busResult.getLoad().getImaginary()-0.8)<0.0001);
		
		StudyCase case24 = gridMCase.getStudyCase("StudyCase24");
		assertTrue(((AclfNetworkResult)case24.getNetResult()).isLfConverged());
		busResult = (AclfBusResult)case24.getBusResult("1");
		assertTrue(Math.abs(busResult.getLoad().getReal()-0.16)<0.0001);
		assertTrue(Math.abs(busResult.getLoad().getImaginary()-0.08)<0.0001);
		*/			
	}	
}