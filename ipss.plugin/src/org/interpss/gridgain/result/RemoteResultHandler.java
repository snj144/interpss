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

import org.interpss.display.AclfOutFunc;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class RemoteResultHandler implements IRemoteResult {
	/**
	 * Save remote simulation results into the result table
	 * 
	 * @param resultTable
	 * @param net
	 */
	public void saveAclfResult(RmoteResultTable resultTable, String caseId, String remoteId, AclfNetwork net) {
		resultTable.put(RmoteResultTable.KEY_RemoteNodeId, remoteId);
		resultTable.put(RmoteResultTable.KEY_StudyCaseId, caseId);
		resultTable.put(RmoteResultTable.KEY_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
	}
	
	/**
	 * Transfer the results save to the resultTable to the multi study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferAclfResult(MultiStudyCase mCaseContainer, RmoteResultTable resultTable) {
		String str = resultTable.getSerializedAclfNet();
		// deserialize the AclfNet model string for Net.id
		if (str != null) {
			StudyCase studyCase = mCaseContainer.getStudyCase(resultTable.getStudyCaseId());
			studyCase.setNetModelString(str);
			studyCase.setDesc("Loadflow by Remote Node: "
						+ IpssGridGainUtil.nodeNameLookup(resultTable.getRemoteNodeId()));
		}
	}
	
	/**
	 * Convert the contect of the multicase container to a String for display purpose. 
	 * 
	 * @param mCaseContainer
	 * @return
	 */
	public StringBuffer toString(MultiStudyCase mCaseContainer) {
		StringBuffer buf = new StringBuffer();
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		AclfAdjNetwork aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
    		buf.append("\n");
    		buf.append(scase.getDesc() + "\n");
    		buf.append("\n");
    		buf.append(AclfOutFunc.loadFlowSummary(aclfAdjNet));
    	}	
    	return buf;
	}
}
