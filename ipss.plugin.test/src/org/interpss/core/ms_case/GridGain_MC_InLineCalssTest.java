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

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.resources.GridLocalNodeIdResource;
import org.interpss.BaseTestSetup;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.grid.gridgain.util.IpssGridUtilFunc;
import org.interpss.core.ms_case.aclf.AbstractAclfStudyCaseRunner;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.ms_case.impl.AbstractGridStudyCaseRunner;
import com.interpss.core.util.sample.SampleCases;

public class GridGain_MC_InLineCalssTest extends BaseTestSetup {
	@Test
	public void loadProfileInlineClassCaseTest() throws InterpssException {
		// step-1: define and load a EMF network object
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		// step-2: create a GridMultiStudyCase object, holding the net object
		GridMultiStudyCase gridMCase = CoreObjectFactory.createGridMultiStudyCase(net);
		
		// step-3: define a GridStudyCaseRunner
		gridMCase.setCaseRunner(new AbstractGridStudyCaseRunner() {
			@Override
			public boolean gridRunCase() {
				try {
					// get the containing GridMultiStudyCase object
					GridMultiStudyCase gridMCase = (GridMultiStudyCase)getParent();

					// use grid node(s) to perform GridMultiStudyCase computation
		        	Object[] results;
			        try {
			        	Grid grid = GridFactory.getGrid();
			        	results = (Object[])IpssGridGainUtil.performGridTask(grid, "Test Custom IpssGrid Task impl ", gridMCase, 0);
			        }
			        finally {
			        	GridFactory.stop(true);
			        }
					
					// persist calculation results to study cases
					for (Object obj : results) {
						// deserialize the result from remote node
						String modelStr = (String)obj;
/*						
						AclfNetworkResult rnet = (AclfNetworkResult)SerializeEMFObjectUtil.loadModel(modelStr);
						// transfer result to StudyCase, use case number for object correlation
						StudyCase studyCase = gridMCase.getStudyCase(rnet.getCaseNumber()); 
						// reference relationship between AclfNetwork and AclfNetworkResult will also build
						AclfStudyCaseUtilFunc.setAclfNetResult2StudyCase(studyCase, rnet);
						*/
					}
					return true;
				} catch (Exception e) {
					IpssLogger.getLogger().severe(e.toString());
					return false;
				}
			}
		});
		
		// step-4: define an actual case runner to run the case. The actual work is 
		//         delegated to the case runner
		gridMCase.getGridStudyCaseRunner().setCaseRunner(new AbstractAclfStudyCaseRunner() {
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
					IpssLogger.getLogger().info("Base Study Case created - " + baseCase.getId());
				}
					int index = studyCase.getCaseNumber()-1;
					
					String busId = "1";
/*					
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult(busId);
					AclfStudyCaseUtilFunc.increaseBusLoad(r, pFactorList[index], qFactorList[index]);
*/					
					IpssLogger.getLogger().info("Study Case generted - " + baseCase.getId() + ", # " + studyCase.getCaseNumber());
				return true;
			}			
		});
		
		// step-5 : define grid task jobs
		// create the base case, including solve Loadflow for the base case
		gridMCase.createBaseCase();
		
		for (int i = 1; i <= 24; i++ ) {
			// create study case i
			int caseNumber = i;
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+i, "Case" + i, caseNumber, gridMCase);
			gridMCase.getGridStudyCaseRunner().generateCaseData(studyCase);
			
			// set case number to the network for grid node result correlation. SortNumber is used to hold the number
//			gridMCase.getNetwork().setSortNumber(caseNumber);

			// serialize the network model to a string 
			String modelStr = SerializeEMFObjectUtil.saveModel(gridMCase);
			
			// add a Grid job to perform computation the model
			gridMCase.getGridJobs().add(new AbstractIpssGridGainJob(modelStr) {
				private static final long serialVersionUID = 1;
				
				@GridLocalNodeIdResource
				private UUID nodeId;
				
			    public Serializable execute() {
			    	initEMFPackage();
			    	// de-serialized the model to a AclfNetwork object 
			    	String modelStr = getArgument();
					AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
					 
					// perform loadflow calculation
					LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
					algo.loadflow(SpringAppContext.getIpssMsgHub());
					
					// serialize the Aclf result to a string
					return IpssGridUtilFunc.serializeGridAclfResult(nodeId.toString(), net);
			    }

			    @Override
				protected Serializable performGridJob(String modelStr) {
					return null;
				}
			});
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
