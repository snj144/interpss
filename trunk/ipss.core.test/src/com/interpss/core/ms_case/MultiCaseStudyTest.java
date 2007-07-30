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

package com.interpss.core.ms_case;

import static org.junit.Assert.assertTrue;

import org.apache.commons.math.complex.Complex;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.core.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.impl.StudyCaseRunnerImpl;
import com.interpss.core.net.Bus;
import com.interpss.core.util.sample.SampleCases;

public class MultiCaseStudyTest extends BaseTestSetup {
	/*
	 * load the 5-bus system
	 */
	@Test
	public void sampleTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		MultiStudyCase mcase = CoreObjectFactory.createMultiStudyCase(net);
		
		CoreObjectFactory.createStudyCase("StudyCase1", "Case1", 1, mcase);
		assertTrue(mcase.getStudyCase("StudyCase1") != null);

		CoreObjectFactory.createStudyCase("StudyCase2", "Case1", 2, mcase);
		assertTrue(mcase.getStudyCase("StudyCase2") != null);
	}

	@Test
	public void generateCaseNoLoadChangeTest() throws InterpssException {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		MultiStudyCase mcase = CoreObjectFactory.createMultiStudyCase(net);
		mcase.setCaseRunner(new AbstractStudyCaseRunner() {
			private StudyCase baseCase = null;
			public boolean generateCaseData(StudyCase studyCase) {
				if (baseCase == null) {
					baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
				}
				try {
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult("1");
					Complex p = r.getPowerIntoNet();
					AclfBus bus = (AclfBus)r.getBus();
					bus.setLoadP(-p.getReal());
					bus.setLoadQ(-p.getImaginary());
				} catch (InterpssException e) {
					SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
					return false;
				}
				return true;
			}			
		});

		mcase.createBaseCase();
		StudyCase baseCase = mcase.getStudyCase(Constants.BaseStudyCaseName);
		assertTrue(((AclfNetworkResult)baseCase.getNetResult()).isLfConverged());

  		AclfBusResult swingBusResult = (AclfBusResult)baseCase.getBusResult("5");
		assertTrue(Math.abs(swingBusResult.getPowerIntoNet().getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swingBusResult.getPowerIntoNet().getImaginary()-2.2994)<0.0001);

		for (int i = 1; i <= 10; i++ ) {
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+i, "Case"+i, i, mcase);
			mcase.runStudyCase(studyCase);
		}

		StudyCase case1 = mcase.getStudyCase("StudyCase1");
		assertTrue(((AclfNetworkResult)case1.getNetResult()).isLfConverged());
  		swingBusResult = (AclfBusResult)case1.getBusResult("5");
		assertTrue(Math.abs(swingBusResult.getPowerIntoNet().getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swingBusResult.getPowerIntoNet().getImaginary()-2.2994)<0.0001);

		StudyCase case9 = mcase.getStudyCase("StudyCase9");
		assertTrue(((AclfNetworkResult)case9.getNetResult()).isLfConverged());
  		swingBusResult = (AclfBusResult)case9.getBusResult("5");
		assertTrue(Math.abs(swingBusResult.getPowerIntoNet().getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swingBusResult.getPowerIntoNet().getImaginary()-2.2994)<0.0001);
	}

	@Test
	public void generateVaribaleLoadCaseTest() throws InterpssException {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		MultiStudyCase mcase = CoreObjectFactory.createMultiStudyCase(net);
		mcase.setCaseRunner(new AbstractStudyCaseRunner() {
			private StudyCase baseCase = null;
			public boolean generateCaseData(StudyCase studyCase) {
				if (baseCase == null) {
					baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
				}
				try {
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult("1");
					Complex p = r.getPowerIntoNet();
					AclfBus bus = (AclfBus)r.getBus();
					bus.setLoadP(-p.getReal() + studyCase.getCaseNumber()*0.1);
					bus.setLoadQ(-p.getImaginary() + studyCase.getCaseNumber()*0.05);
				} catch (InterpssException e) {
					SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
					return false;
				}
				return true;
			}			
		});
		
		mcase.createBaseCase();

		int cnt = 0;
		for (int i = 1; i <= 50; i++ ) {
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+i, "Case"+i, i, mcase);
			cnt++;
			if (!mcase.runStudyCase(studyCase))
				break;
		}
		assertTrue(cnt == 5);
		StudyCase case4 = mcase.getStudyCase("StudyCase4");
		assertTrue(((AclfNetworkResult)case4.getNetResult()).isLfConverged());
	}

	private class AbstractStudyCaseRunner extends StudyCaseRunnerImpl {
			public boolean runCase(StudyCase studyCase) {
				LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(studyCase.getParent().getNetwork());
				algo.loadflow(SpringAppContext.getIpssMsgHub());
				return ((AclfNetwork)studyCase.getParent().getNetwork()).isLfConverged();
			}			

			public boolean saveCase(StudyCase studyCase) {
				AclfNetwork aclfNet = (AclfNetwork)studyCase.getParent().getNetwork();
				AclfNetworkResult rNet = CoreObjectFactory.createAclfNetworkResult(aclfNet);
				studyCase.setNetResult(rNet);
				for (Bus b : aclfNet.getBusList()) {
					AclfBus bus = (AclfBus)b;
					AclfBusResult r = CoreObjectFactory.createAclfBusResult(bus);
					studyCase.getBusResultList().add(r);
				}
				return true;
			}			
	}
}

