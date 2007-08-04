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
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.ms_case.BusResult;
import com.interpss.core.ms_case.MultiStudyCase;
import com.interpss.core.ms_case.StudyCase;
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
		mcase.setCaseRunner(new AbstractAclfStudyCaseRunner() {
			private StudyCase baseCase = null;
			public boolean generateCaseData(StudyCase studyCase) {
				if (baseCase == null) {
					baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
				}
				try {
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult("1");
					AclfBus bus = (AclfBus)r.getBus();
					bus.setLoadP(r.load.getReal());
					bus.setLoadQ(r.load.getImaginary());
				} catch (InterpssException e) {
					SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
					return false;
				}
				return true;
			}			
		});

		mcase.createBaseCase();
		StudyCase baseCase = mcase.getStudyCase(Constants.BaseStudyCaseName);
		assertTrue(((AclfNetworkResult)baseCase.getNetResult()).converged);

		AclfBusResult swingBusResult = (AclfBusResult)baseCase.getBusResult("5");
		assertTrue(Math.abs(swingBusResult.gen.getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swingBusResult.gen.getImaginary()-2.2994)<0.0001);

		for (int i = 1; i <= 10; i++ ) {
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+i, "Case"+i, i, mcase);
			mcase.runStudyCase(studyCase);
		}

		StudyCase case1 = mcase.getStudyCase("StudyCase1");
		assertTrue(((AclfNetworkResult)case1.getNetResult()).converged);
  		swingBusResult = (AclfBusResult)case1.getBusResult("5");
		assertTrue(Math.abs(swingBusResult.gen.getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swingBusResult.gen.getImaginary()-2.2994)<0.0001);

		StudyCase case9 = mcase.getStudyCase("StudyCase9");
		assertTrue(((AclfNetworkResult)case9.getNetResult()).converged);
  		swingBusResult = (AclfBusResult)case9.getBusResult("5");
		assertTrue(Math.abs(swingBusResult.gen.getReal()-2.57943)<0.0001);
		assertTrue(Math.abs(swingBusResult.gen.getImaginary()-2.2994)<0.0001);
	}

	@Test
	public void generateVaribaleLoadCaseTest() throws InterpssException {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		MultiStudyCase mcase = CoreObjectFactory.createMultiStudyCase(net);
		mcase.setCaseRunner(new AbstractAclfStudyCaseRunner() {
			private StudyCase baseCase = null;
			public boolean generateCaseData(StudyCase studyCase) {
				if (baseCase == null) {
					baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
				}
				try {
					double dP = studyCase.getCaseNumber()*0.1;
					studyCase.setDesc(" increase load(pu) " + dP);
					
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult("1");
					AbstractAclfStudyCaseRunner.increaseBusLoadConstPF(r, dP);
					
					r = (AclfBusResult)baseCase.getBusResult("4");
					AbstractAclfStudyCaseRunner.increaseBusGenConstPF(r, dP*0.5);
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
			if (!mcase.runStudyCase(studyCase)) {
				System.out.println("LF Diverged, cnt: " + i);
				break;
			}
		}
		/*
		for ( StudyCase c : mcase.getStudyCaseList()) {
			System.out.println("StudyCase: " + c.getCaseNumber() + ", " + c.getName());
			for (BusResult r : c.getBusResultList()) {
				AbstractAclfStudyCaseRunner.AclfBusResult result = (AbstractAclfStudyCaseRunner.AclfBusResult)r;
				System.out.println(result);
			}
		}
		*/
	}

	@Test
	public void loadProfileCaseTest() throws InterpssException {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		MultiStudyCase mcase = CoreObjectFactory.createMultiStudyCase(net);
		mcase.setCaseRunner(new AbstractAclfStudyCaseRunner() {
			private double[] pFactorList = {
					0.3, 0.3, 0.3, 0.3, 1.0, 1.0,
					1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
					1.0, 1.0, 1.4, 1.3, 1.3, 1.0,
					1.0, 1.0, 0.2, 0.2, 0.2, 0.1
					};
			private double[] qFactorList = {
					0.2, 0.2, 0.2, 0.2, 0.3, 1.0,
					1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
					1.0, 1.0, 1.0, 1.2, 1.2, 1.2,
					1.0, 1.0, 1.0, 0.1, 0.1, 0.1
					};
			private StudyCase baseCase = null;
			public boolean generateCaseData(StudyCase studyCase) {
				if (baseCase == null) {
					baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
				}
				try {
					int index = studyCase.getCaseNumber()-1;
					
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult("1");
					AbstractAclfStudyCaseRunner.increaseBusLoad(r, pFactorList[index], qFactorList[index]);
				} catch (InterpssException e) {
					SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
					return false;
				}
				return true;
			}			
		});
		
		mcase.createBaseCase();

		for (int i = 1; i <= 24; i++ ) {
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+i, "Case"+i, i, mcase);
			mcase.runStudyCase(studyCase);
		}
		
		StudyCase case1 = mcase.getStudyCase("StudyCase1");
		assertTrue(((AclfNetworkResult)case1.getNetResult()).converged);
		AclfBusResult busResult = (AclfBusResult)case1.getBusResult("1");
		assertTrue(Math.abs(busResult.load.getReal()-0.48)<0.0001);
		assertTrue(Math.abs(busResult.load.getImaginary()-0.16) < 0.0001);

		StudyCase case12 = mcase.getStudyCase("StudyCase12");
		assertTrue(((AclfNetworkResult)case12.getNetResult()).converged);
		busResult = (AclfBusResult)case12.getBusResult("1");
		assertTrue(Math.abs(busResult.load.getReal()-1.6)<0.0001);
		assertTrue(Math.abs(busResult.load.getImaginary()-0.8)<0.0001);
		
		StudyCase case24 = mcase.getStudyCase("StudyCase24");
		assertTrue(((AclfNetworkResult)case24.getNetResult()).converged);
		busResult = (AclfBusResult)case24.getBusResult("1");
		assertTrue(Math.abs(busResult.load.getReal()-0.16)<0.0001);
		assertTrue(Math.abs(busResult.load.getImaginary()-0.08)<0.0001);

		for ( StudyCase c : mcase.getStudyCaseList()) {
			System.out.println("StudyCase: " + c.getCaseNumber() + ", " + c.getName());
			for (BusResult r : c.getBusResultList()) {
				AclfBusResult result = (AclfBusResult)r;
				System.out.println(result);
			}
		}
	}
}

