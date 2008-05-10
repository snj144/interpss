 /*
  * @(#)ContingencyAnalysisResultHandler.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 05/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.secass;

import org.gridgain.grid.GridTaskSession;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;
import com.interpss.simu.multicase.result.MCaseResultPackage;
import com.interpss.simu.multicase.result.StudyCaseResult;

public class ContingencyAnalysisResultHandler implements IRemoteResult {
    private static MCaseResultPackage mCaseResultPackage = null;

    public ContingencyAnalysisResultHandler() {
    	if (mCaseResultPackage == null)
    		mCaseResultPackage = MCaseResultPackage.eINSTANCE;
    }
    
	/**
	 * Save remote simulation results into the result table, which will be sent from
	 * a remote node to the master node
	 * 
	 * @param resultTable
	 * @param caseId study case id
	 * @param remoteId remote grid node UUID
	 * @param net AclfNetwork object after completing a Loadflow run 
	 * @param session
	 */
	public void saveRemoteResult(RemoteMessageTable resultTable, String caseId, String remoteId, LoadflowAlgorithm algo, GridTaskSession session) {
		AclfAdjNetwork net = algo.getAclfAdjNetwork();
		net.setDesc(remoteId);

		resultTable.put(RemoteMessageTable.KEY_sInOut_RemoteNodeId, remoteId);
		resultTable.put(RemoteMessageTable.KEY_sInOut_StudyCaseId, caseId);
		
		resultTable.put(RemoteMessageTable.KEY_bOut_AclfConverged, net.isLfConverged()? Boolean.TRUE : Boolean.FALSE);
		
  		AclfStudyCase scase = SimuObjectFactory.createAclfStudyCase();
  		scase.getResult().transferAclfResult(net);		
		//System.out.println(scase.getResult().toString());
		resultTable.put(RemoteMessageTable.KEY_sOut_AclfResult, SerializeEMFObjectUtil.saveModel(scase.getResult()));
	}
	
	/**
	 * Transfer the results save to the resultTable to the multi-study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferRemoteResult(MultiStudyCase mCaseContainer, RemoteMessageTable resultTable) {
		// deserialize the AclfNet model string for Net.id
		AclfStudyCase studyCase = (AclfStudyCase)mCaseContainer.getStudyCase(resultTable.getStudyCaseId());
		studyCase.setDesc("Loadflow by Remote Node: " + IpssGridGainUtil.nodeNameLookup(resultTable.getRemoteNodeId()));

		studyCase.setRemoteReturnStatus(resultTable.getReturnStatus());
		studyCase.setRemoteReturnMessage(resultTable.getReturnMessage());
		
		studyCase.setAclfConverged(resultTable.getAclfConvergeStatus());
		
		//System.out.println(resultTable.getAclfResult());
		StudyCaseResult result = (StudyCaseResult)SerializeEMFObjectUtil.loadModel(resultTable.getAclfResult()); 
		((ContingencyAnalysis)mCaseContainer).updateResult(studyCase.getName(), result);
	}
	
	/**
	 * Convert the content of the multicase container to a String for display purpose. 
	 * 
	 * @param mCaseContainer
	 * @return
	 */
	public StringBuffer toString(MultiStudyCase mCaseContainer) {
		StringBuffer buf = new StringBuffer();
		buf.append(((ContingencyAnalysis)mCaseContainer).toString());
    	return buf;
	}
}
