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

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;
import com.interpss.simu.multicase.result.AclfBranchResultRec;
import com.interpss.simu.multicase.result.AclfBusResultRec;

public class ContingencyAnalysisResultHandler implements IRemoteResult {
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
	public void saveAclfResult(RemoteMessageTable resultTable, String caseId, String remoteId, LoadflowAlgorithm algo, GridTaskSession session) {
		AclfNetwork net = algo.getAclfNetwork();
		net.setDesc(remoteId);

		resultTable.put(RemoteMessageTable.KEY_sInOut_RemoteNodeId, remoteId);
		resultTable.put(RemoteMessageTable.KEY_sInOut_StudyCaseId, caseId);
		
		resultTable.put(RemoteMessageTable.KEY_bOut_AclfConverged, net.isLfConverged()? Boolean.TRUE : Boolean.FALSE);
	}
	
	/**
	 * Transfer the results save to the resultTable to the multi-study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferAclfResult(MultiStudyCase mCaseContainer, RemoteMessageTable resultTable) {
		// deserialize the AclfNet model string for Net.id
		AclfStudyCase studyCase = (AclfStudyCase)mCaseContainer.getStudyCase(resultTable.getStudyCaseId());
		studyCase.setDesc("Loadflow by Remote Node: " + IpssGridGainUtil.nodeNameLookup(resultTable.getRemoteNodeId()));

		studyCase.setRemoteReturnStatus(resultTable.getReturnStatus());
		studyCase.setRemoteReturnMessage(resultTable.getReturnMessage());
		
		studyCase.setAclfConverged(resultTable.getAclfConvergeStatus());
	}
	
	/**
	 * Convert the content of the multicase container to a String for display purpose. 
	 * 
	 * @param mCaseContainer
	 * @return
	 */
	public StringBuffer toString(MultiStudyCase mCaseContainer) {
		StringBuffer buf = new StringBuffer();
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		AclfStudyCase aclfCase = (AclfStudyCase)scase;
    		buf.append("\n");
    		buf.append(scase.getDesc() + "\n");
    		if (scase.getName() != null)
    			buf.append("Case Description: " + scase.getName() + "\n");

    		if (scase.getRemoteReturnMessage() != null) 
    			if (scase.isRemoteReturnStatus())
    				buf.append(scase.getRemoteReturnMessage() + "\n");
    			else 
    				buf.append("Remote error message: " + scase.getRemoteReturnMessage() + "\n");

			buf.append("Loadflow converged: " + aclfCase.isAclfConverged());
    		
    		buf.append("\n");
    	}	
    	return buf;
	}
	
	public static void updateResult(AclfNetwork net, ContingencyAnalysis caCase) {
		for (Bus bus : net.getBusList()) {
			AclfBus aclfBus = (AclfBus) bus;
			AclfBusResultRec rec = caCase.getBusResult().get(bus.getId());
			if (aclfBus.getVoltageMag() > rec.getHighVoltMagPU())
				rec.setHighVoltMagPU(aclfBus.getVoltageMag());
			else if (aclfBus.getVoltageMag() < rec.getLowVoltMagPU())
				rec.setLowVoltMagPU(aclfBus.getVoltageMag());
		}
		
		for (Branch bra : net.getBranchList()) {
			AclfBranch aclfBra = (AclfBranch) bra;
			AclfBranchResultRec rec = caCase.getBranchResult().get(bra.getId());
			double mva = aclfBra.mvaFlow(UnitType.mVA, net.getBaseKva());
			if (mva > rec.getMvaFlow()) {
				rec.setMvaFlow(mva);
			}
		}
	}
}
