 /*
  * @(#)RemoteResultHandler.java   
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
  * @Date 03/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.result;

import java.util.ArrayList;
import java.util.List;

import org.gridgain.grid.GridTaskSession;
import org.interpss.display.AclfOutFunc;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.ViolationType;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class RemoteResultHandler implements IRemoteResult {
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
		
		// calculate branch mvar violation index = sqrt[ sum(e*e) ], where e = ( mvar - mvarLimit ) in case of violation
		// calculate branch current violation index = sqrt[ sum(e*e) ], where e = ( amps - ampsLimit ) in case of violation
		if (session.getAttribute(Constants.GridToken_AclfOpt_CalculateViolation) != null &&
				((Boolean)session.getAttribute(Constants.GridToken_AclfOpt_CalculateViolation)).booleanValue()) {
			List<Object> msgList = new ArrayList<Object>();
			double max = ((Double)session.getAttribute(Constants.GridToken_AclfOpt_BusVoltageUpperLimitPU)).doubleValue();
			double min = ((Double)session.getAttribute(Constants.GridToken_AclfOpt_BusVoltageLowerLimitPU)).doubleValue();
			algo.violation(ViolationType.ALL, max, min, msgList);
			resultTable.addReturnMessage(msgList);
		}

		if (session.getAttribute(Constants.GridToken_AclfOpt_ReturnStudyCase) != null) { 
			int returnOpt = ((Integer)session.getAttribute(Constants.GridToken_AclfOpt_ReturnStudyCase)).intValue();
			if (returnOpt == RemoteMessageTable.Const_ReturnAllStudyCase) {
				resultTable.put(RemoteMessageTable.KEY_sOut_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
			}
			else if (returnOpt == RemoteMessageTable.Const_ReturnDivergedCase) {
				if (!resultTable.getReturnStatus() || !net.isLfConverged()) 
					resultTable.put(RemoteMessageTable.KEY_sOut_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
			}
			else {
				;// do nothing
			}
		}
		else {
			resultTable.put(RemoteMessageTable.KEY_sOut_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
		}
	}
	
	/**
	 * Transfer the results save to the resultTable to the multi-study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferAclfResult(MultiStudyCase mCaseContainer, RemoteMessageTable resultTable) {
		// deserialize the AclfNet model string for Net.id
		StudyCase studyCase = mCaseContainer.getStudyCase(resultTable.getStudyCaseId());
		studyCase.setDesc("Loadflow by Remote Node: " + IpssGridGainUtil.nodeNameLookup(resultTable.getRemoteNodeId()));

		studyCase.setRemoteReturnStatus(resultTable.getReturnStatus());
		studyCase.setRemoteReturnMessage(resultTable.getReturnMessage());
		
		studyCase.setAclfConverged(resultTable.getAclfConvergeStatus());
		studyCase.setNetModelString(resultTable.getSerializedAclfNet());
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
    		buf.append("\n");
    		buf.append(scase.getDesc() + "\n");
    		if (scase.getName() != null)
    			buf.append("Case Description: " + scase.getName() + "\n");

    		if (scase.getRemoteReturnMessage() != null) 
    			if (scase.isRemoteReturnStatus())
    				buf.append(scase.getRemoteReturnMessage() + "\n");
    			else 
    				buf.append("Remote error message: " + scase.getRemoteReturnMessage() + "\n");

    		AclfAdjNetwork aclfAdjNet = null;
    		if (scase.getNetModelString() != null) {
    			aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
    		}

			buf.append("Loadflow converged: " + scase.isAclfConverged());
        	buf.append("\n");
        	if (aclfAdjNet != null) {
        		buf.append("\n");
    			buf.append(AclfOutFunc.loadFlowSummary(aclfAdjNet));
        		buf.append("\n");
        	}
    		
    		buf.append("\n");
    	}	
    	return buf;
	}
}
