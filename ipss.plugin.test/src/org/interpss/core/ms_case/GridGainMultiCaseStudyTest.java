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

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.resources.GridLocalNodeIdResource;
import org.interpss.BaseTestSetup;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.ms_case.aclf.AbstractAclfStudyCaseRunner;
import org.interpss.core.ms_case.aclf.AclfBusResult;
import org.interpss.core.ms_case.aclf.AclfStudyCaseUtilFunc;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.ui.SerializeEMFObjectUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.ms_case.impl.AbstractGridStudyCaseRunner;
import com.interpss.core.ms_case.result.GridAclfNetResult;
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
		gridMCase.setCaseRunner(new AbstractGridStudyCaseRunner() {
			@Override
			public boolean gridRunCase() {
				try {
					// get the containing GridMultiStudyCase object
					GridMultiStudyCase gridMCase = (GridMultiStudyCase)this.eContainer;
					Object[] results = (Object[])
						IpssGridGainUtil.performGridTask("Test Custom IpssGrid Task impl ", gridMCase);
					for (Object obj : results) {
						String modelStr = (String)obj;
						//System.out.println((String)obj);
						GridAclfNetResult rnet = (GridAclfNetResult)SerializeEMFObjectUtil.loadModel(modelStr);
						if (!rnet.isLfConverged())
							return false;
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
				try {
					int index = studyCase.getCaseNumber()-1;
					
					String busId = "1";
					AclfBusResult r = (AclfBusResult)baseCase.getBusResult(busId);
					AclfStudyCaseUtilFunc.increaseBusLoad(r, pFactorList[index], qFactorList[index]);
					IpssLogger.getLogger().info("Study Case generted - " + baseCase.getId() + ", # " + studyCase.getCaseNumber());
				} catch (InterpssException e) {
					SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
					return false;
				}
				return true;
			}			
		});
		
		// step-5 : define grid task jobs
		for (int i = 1; i <= 24; i++ ) {
			// create study case i
			int caseNumber = i;
			CoreObjectFactory.createStudyCase("StudyCase"+i, "Case" + i, caseNumber, gridMCase);
			gridMCase.getNetwork().setSortNumber(caseNumber);
			String modelStr = SerializeEMFObjectUtil.saveModel(gridMCase.getNetwork());
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
					
					return IpssGridGainUtil.serializeAclfResult(nodeId.toString(), net);
			    }

			});
		}

		// ste-6 : run all grid task jobs 
		assertTrue(gridMCase.runAllCase());
	}	
}
