 /*
  * @(#)DStab_5BusGridGainTest.java   
  *
  * Copyright (C) 2007 www.interpss.org
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
  * @Date 10/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.aclf;

import static org.junit.Assert.assertTrue;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.gridgain.GridBaseTestSetup;
import org.interpss.gridgain.GridRunner;
import org.interpss.gridgain.job.GridAclfJob;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.util.GridUtil;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.BranchChangeRecXmlType;
import org.interpss.schema.ModificationXmlType;
import org.junit.Test;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.adj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfAdjustAlgorithm;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.RemoteMessageType;
import com.interpss.simu.multicase.ReturnRemoteCaseOpt;
import com.interpss.simu.multicase.StudyCase;
import com.interpss.simu.multicase.aclf.AclfMultiStudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;
import com.interpss.simu.multicase.modify.BranchModification;
import com.interpss.simu.multicase.modify.Modification;

public class IEEE14MCase_Modification_GridTest extends GridBaseTestSetup {
	@Test
	public void AlgoEMFModificationCaseTest() throws Exception {
		/*
		 * step-1 Build the base case
		 */
    	SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		//System.out.println(net.net2String());	
		// network id needs to be set. It is used for identification purpse
		net.setId("IEEE 14_Bus");
		
		/*
		 * step-2 Define LF algorithm
		 */
		AclfAdjustAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, msg);
	  	//algo.setLfMethod(AclfMethod.PQ);

	  	/*
	  	 * step-3 define multiple study cases
	  	 */
		AclfMultiStudyCase mCaseContainer = SimuObjectFactory.createAclfMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
		// save the base case Network model to the netStr
		mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(net));

		for (int caseNo = 1; caseNo <= 10; caseNo++) {
			AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase("caseId"+caseNo, 
					"caseName", caseNo, mCaseContainer);
			// if Grid computing, save the Algo object to the study case object
			studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));

			BranchModification braMod = SimuObjectFactory.createBranchModification("0005", "0006", "1", net);
			braMod.setOutService(true);
			
			Modification mod = SimuObjectFactory.createModification(braMod);

			/*
			// break the reference, since the Aclf object is not persisted in the file
			mod.breakReference();
			String modelString = SerializeEMFObjectUtil.saveModel(mod);

			studyCase.setModificationString(modelString);
			studyCase.setModStringType(RemoteMessageType.IPSS_EMF_MODEL);
			*/
			studyCase.setModification(mod);
		}

		/*
		 * Step-4 define study options
		 */
		boolean reJobCreation = true;
		mCaseContainer.setRemoteJobCreation(reJobCreation);
		mCaseContainer.getAclfGridOption().setReturnCase(ReturnRemoteCaseOpt.ALL_STUDY_CASE);
		mCaseContainer.getAclfGridOption().setCalculateViolation(true);
		mCaseContainer.getAclfGridOption().setBusVoltageUpperLimitPU(1.1);
		mCaseContainer.getAclfGridOption().setBusVoltageLowerLimitPU(0.9);
		
		/**
		 * Step-5 perform grid computing
		 */
		try {
			Grid grid = GridUtil.getDefaultGrid();
			long timeout = 0;
			RemoteMessageTable[] objAry = new GridRunner(grid, "InterPSS Grid Aclf Calculation", 
						mCaseContainer).executeMultiJob(timeout);
			for (RemoteMessageTable result : objAry) {
				IRemoteResult resultHandler = RemoteResultFactory.createHandler(GridAclfJob.class);
				resultHandler.transferRemoteResult(mCaseContainer, result);
			}
		} catch (GridException e) {
			System.out.println(e.toString());
		} 
		
		/**
		 * Step-6 process results
		 */
		//IRemoteResult resultHandler = RemoteResultFactory.createHandler(IpssGridGainAclfJob.class);
		//System.out.println(resultHandler.toString(IRemoteResult.DisplayType_NoUsed, mCaseContainer).toString());
		
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		if (scase.getNetModelString() != null) {
    			AclfAdjNetwork aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
    			aclfAdjNet.rebuildLookupTable();
    			assertTrue(aclfAdjNet.isLfConverged());
    			assertTrue(!aclfAdjNet.getBranch("0005", "0006", "1").isActive());
    		}
    	}	
	}	

	@Test
	public void AlgoXmlModificationCaseTest() throws Exception {
		/*
		 * step-1 Build the base case
		 */
    	SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		//System.out.println(net.net2String());	
		// network id needs to be set. It is used for identification purpse
		net.setId("IEEE 14_Bus");
		
		/*
		 * step-2 Define LF algorithm
		 */
	  	LoadflowAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, msg);
	  	//algo.setLfMethod(AclfMethod.PQ);

	  	/*
	  	 * step-3 define multiple study cases
	  	 */
		AclfMultiStudyCase mCaseContainer = SimuObjectFactory.createAclfMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
		// save the base case Network model to the netStr
		mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(net));

		for (int caseNo = 1; caseNo <= 10; caseNo++) {
			AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase("caseId"+caseNo, 
					"caseName", caseNo, mCaseContainer);
			// if Grid computing, save the Algo object to the study case object
			studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));

			// define modification to the case
			AclfStudyCaseXmlType xmlCase = AclfStudyCaseXmlType.Factory.newInstance();
			ModificationXmlType mod = xmlCase.addNewModification();
			// define modification
			BranchChangeRecXmlType branchChange = mod.addNewBranchChangeRecList().addNewBranchChangeRec();
			branchChange.setFromBusId("0005");
			branchChange.setToBusId("0006");
			branchChange.setCircuitNumber("1");
			branchChange.setOffLine(true);
			
			if (xmlCase.getModification() != null) {
				// persist modification to be sent to the remote grid node
				studyCase.setModificationString(xmlCase.getModification().xmlText());
				studyCase.setModStringType(RemoteMessageType.IPSS_XML);
			} 
		}

		/*
		 * Step-4 define study options
		 */
		boolean reJobCreation = true;
		mCaseContainer.setRemoteJobCreation(reJobCreation);
		mCaseContainer.getAclfGridOption().setReturnCase(ReturnRemoteCaseOpt.ALL_STUDY_CASE);
		mCaseContainer.getAclfGridOption().setCalculateViolation(true);
		mCaseContainer.getAclfGridOption().setBusVoltageUpperLimitPU(1.1);
		mCaseContainer.getAclfGridOption().setBusVoltageLowerLimitPU(0.9);
		
		/**
		 * Step-5 perform grid computing
		 */
		try {
			Grid grid = GridUtil.getDefaultGrid();
			long timeout = 0;
			RemoteMessageTable[] objAry = new GridRunner(grid, "InterPSS Grid Aclf Calculation", 
						mCaseContainer).executeMultiJob(timeout);
			for (RemoteMessageTable result : objAry) {
				IRemoteResult resultHandler = RemoteResultFactory.createHandler(GridAclfJob.class);
				resultHandler.transferRemoteResult(mCaseContainer, result);
			}
		} catch (GridException e) {
			System.out.println(e.toString());
		} 
		
		/**
		 * Step-6 process results
		 */
		//IRemoteResult resultHandler = RemoteResultFactory.createHandler(IpssGridGainAclfJob.class);
		//System.out.println(resultHandler.toString(IRemoteResult.DisplayType_NoUsed, mCaseContainer).toString());
		
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		if (scase.getNetModelString() != null) {
    			AclfAdjNetwork aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
    			aclfAdjNet.rebuildLookupTable();
    			assertTrue(aclfAdjNet.isLfConverged());
    			assertTrue(!aclfAdjNet.getBranch("0005", "0006", "1").isActive());
    		}
    	}	
	}	
}
