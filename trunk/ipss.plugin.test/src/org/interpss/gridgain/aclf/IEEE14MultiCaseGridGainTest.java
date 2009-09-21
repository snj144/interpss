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
import org.interpss.PluginSpringAppContext;
import org.interpss.editor.runAct.xml.XmlScriptUtilFunc;
import org.interpss.gridgain.GridBaseTestSetup;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeAclfTask;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.RuleBaseXmlType;
import org.interpss.xml.PreventiveRuleHanlder;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.aclf.AclfMultiStudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class IEEE14MultiCaseGridGainTest extends GridBaseTestSetup {
	@Test
	public void AlgoCaseTest() throws Exception {
    	SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		//System.out.println(net.net2String());	
		// network id needs to be set. It is used for identification purpse
		net.setId("IEEE 14_Bus");
		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, msg);
	  	//algo.setLfMethod(AclfMethod.PQ);

		AclfMultiStudyCase mCaseContainer = SimuObjectFactory.createAclfMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
		// save the base case Network model to the netStr
		mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(net));

		boolean reJobCreation = true;
			
		int caseNo = 1;
		AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase("caseId", 
									"caseName", caseNo, mCaseContainer);
		// if Grid computing, save the Algo object to the study case object
		studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));
		
		//if (reJobCreation && xmlCase.getModification() != null) {
				// persist modification to be sent to the remote grid node
			//studyCase.setModifyModelString(xmlCase.getModification().xmlText());
		//} 
	  	
	  	
		Grid grid = IpssGridGainUtil.getDefaultGrid();
		String nodeId = IpssGridGainUtil.getAnyRemoteNodeId();
		
    	// set remote and master node id
    	AssignJob2NodeAclfTask.RemoteNodeId = nodeId;

    	RemoteMessageTable result = IpssGridGainUtil.performGridTask(grid, "Grid Aclf IEEE 14-Bus system", algo, 0);
		System.out.println(result);
    	assertTrue(result.getReturnStatus());
		
		String str = result.getSerializedAclfNet();
		AclfAdjNetwork adjNet = (AclfAdjNetwork) SerializeEMFObjectUtil.loadModel(str);
		adjNet.rebuildLookupTable();
		assert(adjNet.isLfConverged());
    	
  		AclfBus swingBus = (AclfBus)net.getBus("0001");
  		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
		System.out.println(ComplexFunc.toString(swing.getGenResults(UnitType.PU, net.getBaseKva())));
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-0.11824)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-0.37383)<0.0001);
	}	
}
