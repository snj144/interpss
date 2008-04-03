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

import org.gridgain.grid.GridTaskSession;
import org.interpss.display.AclfOutFunc;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
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
	public void saveAclfResult(RmoteResultTable resultTable, String caseId, String remoteId, AclfNetwork net, GridTaskSession session) {
		resultTable.put(RmoteResultTable.KEY_RemoteNodeId, remoteId);
		resultTable.put(RmoteResultTable.KEY_StudyCaseId, caseId);
		
		resultTable.put(RmoteResultTable.KEY_AclfConverged, net.isLfConverged()? Boolean.TRUE : Boolean.FALSE);
		
		if (!((Boolean)session.getAttribute(Constants.GridToken_AclfOpt_ReturnOnlyViolationCase)).booleanValue()
				|| !net.isLfConverged()) {
			resultTable.put(RmoteResultTable.KEY_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
		}

		// calculate branch mvar violation index = sqrt[ sum(e*e) ], where e = ( mvar - mvarLimit ) in case of violation
		// calculate branch current violation index = sqrt[ sum(e*e) ], where e = ( amps - ampsLimit ) in case of violation
		if (((Boolean)session.getAttribute(Constants.GridToken_AclfOpt_CalBranchLimitViolation)).booleanValue()) {
			double mvar1Index = 0.0, 
			       mvar2Index = 0.0, 
			       mvar3Index = 0.0, 
			       ampsIndex = 0.0;
			for (Branch bra : net.getBranchList()) {
				AclfBranch aclfBra = (AclfBranch) bra;
				double mvarf_t = aclfBra.powerFrom2To(UnitType.mVar, net.getBaseKva()).abs();
				double mvart_f = aclfBra.powerTo2From(UnitType.mVar, net.getBaseKva()).abs();
				double amps = aclfBra.current(UnitType.Amp, net.getBaseKva());
				double mvar = mvarf_t > mvart_f? mvarf_t : mvart_f;
				if (aclfBra.getRatingMva1() > 0.0) 
					if (mvar > aclfBra.getRatingMva1()) {
						double e = (mvar - aclfBra.getRatingMva1()) / aclfBra.getRatingMva1();
						mvar1Index += e*e;
					}
				if (aclfBra.getRatingMva2() > 0.0) 
					if (mvar > aclfBra.getRatingMva2()) {
						double e = (mvar - aclfBra.getRatingMva2()) / aclfBra.getRatingMva2();
						mvar2Index += e*e;
					}
				if (aclfBra.getRatingMva3() > 0.0) 
					if (mvar > aclfBra.getRatingMva3()) {
						double e = (mvar - aclfBra.getRatingMva3()) / aclfBra.getRatingMva3();
						mvar3Index += e*e;
					}
				if (aclfBra.getRatingAmps() > 0.0) 
					if (amps > aclfBra.getRatingAmps()) {
						double e = (amps - aclfBra.getRatingAmps()) / aclfBra.getRatingAmps();
						ampsIndex += e*e;
					}
			}
			resultTable.put(RmoteResultTable.KEY_BranchMvar1LimintViolationIndex, new Double(mvar1Index));
			resultTable.put(RmoteResultTable.KEY_BranchMvar2LimintViolationIndex, new Double(mvar2Index));
			resultTable.put(RmoteResultTable.KEY_BranchMvar3LimintViolationIndex, new Double(mvar3Index));
			resultTable.put(RmoteResultTable.KEY_BranchAmpsLimintViolationIndex, new Double(ampsIndex));
		}

		// calculate voltage violation index = sqrt[ sum(e*e) ], where e = ( v - max ) or ( mix - v ) in case of violation
		if (((Boolean)session.getAttribute(Constants.GridToken_AclfOpt_CalBusVoltViolation)).booleanValue()) {
			double max = ((Double)session.getAttribute(Constants.GridToken_AclfOpt_BusVoltageUpperLimitPU)).doubleValue();
			double min = ((Double)session.getAttribute(Constants.GridToken_AclfOpt_BusVoltageLowerLimitPU)).doubleValue();
			double vIndex = 0.0;
			for (Bus bus : net.getBusList()) {
				AclfBus aclfBus = (AclfBus) bus;
				double v = aclfBus.getVoltageMag();
				if (v > max) 
					vIndex += (v-max)*(v-max);
				else if (v < min) 
					vIndex += (min-v)*(min-v);
			}
			resultTable.put(RmoteResultTable.KEY_BusVoltageLimintViolationIndex, new Double(Math.sqrt(vIndex)));
		}
	}
	
	/**
	 * Transfer the results save to the resultTable to the multi-study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferAclfResult(MultiStudyCase mCaseContainer, RmoteResultTable resultTable) {
		// deserialize the AclfNet model string for Net.id
		StudyCase studyCase = mCaseContainer.getStudyCase(resultTable.getStudyCaseId());
		studyCase.setDesc("Loadflow by Remote Node: " + IpssGridGainUtil.nodeNameLookup(resultTable.getRemoteNodeId()));

		studyCase.setAclfConverged(resultTable.getAclfConvergeStatus());
		studyCase.setNetModelString(resultTable.getSerializedAclfNet());
		
		if (mCaseContainer.isAclfCalBranchLimitViolation()) {
			studyCase.setBranchMvar1LimitViolationIndex(resultTable.getBranchMvar1LimintViolationIndex());
			studyCase.setBranchMvar2LimitViolationIndex(resultTable.getBranchMvar2LimintViolationIndex());
			studyCase.setBranchMvar3LimitViolationIndex(resultTable.getBranchMvar3LimintViolationIndex());
			studyCase.setBranchAmpsLimitViolationIndex(resultTable.getBranchAmpsLimintViolationIndex());
		}

		if (mCaseContainer.isAclfCalBusVoltageViolation()) {
			studyCase.setBusVoltageViolationIndex(resultTable.getBusVoltageLimintViolationIndex());
		}
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
    		if (scase.getNetModelString() != null) {
    			AclfAdjNetwork aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
        		buf.append("\n");
    			buf.append(AclfOutFunc.loadFlowSummary(aclfAdjNet));
    		}
    		else {
        		buf.append("Loadflow converged " + scase.isAclfConverged());
    		}
    		
    		if (mCaseContainer.isAclfCalBranchLimitViolation()) {
        		if (scase.getBranchMvar1LimitViolationIndex() > 0.0)
        			buf.append("Branch Mvar1 limit violation index " + scase.getBranchMvar1LimitViolationIndex());
        		if (scase.getBranchMvar2LimitViolationIndex() > 0.0)
        			buf.append("Branch Mvar2 limit violation index " + scase.getBranchMvar2LimitViolationIndex());
        		if (scase.getBranchMvar3LimitViolationIndex() > 0.0)
        			buf.append("Branch Mvar3 limit violation index " + scase.getBranchMvar3LimitViolationIndex());
        		if (scase.getBranchAmpsLimitViolationIndex() > 0.0)
        			buf.append("Branch Amps limit violation index " + scase.getBranchAmpsLimitViolationIndex());
    		}

    		if (mCaseContainer.isAclfCalBusVoltageViolation()) {
        		if (scase.getBusVoltageViolationIndex() > 0.0)
        			buf.append("Bus voltage limit violation index " + scase.getBusVoltageViolationIndex());
    		}

    		buf.append("\n");
    	}	
    	return buf;
	}
}
