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
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
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
	public void saveAclfResult(RemoteMessageTable resultTable, String caseId, String remoteId, AclfNetwork net, GridTaskSession session) {
		net.setDesc(remoteId);

		resultTable.put(RemoteMessageTable.KEY_RemoteNodeId, remoteId);
		resultTable.put(RemoteMessageTable.KEY_StudyCaseId, caseId);
		
		resultTable.put(RemoteMessageTable.KEY_AclfConverged, net.isLfConverged()? Boolean.TRUE : Boolean.FALSE);
		
		double 	mva1Index = 0.0, 
	       		mva2Index = 0.0, 
	       		mva3Index = 0.0, 
	       		ampsIndex = 0.0,
				vIndex = 0.0;

		// calculate branch mvar violation index = sqrt[ sum(e*e) ], where e = ( mvar - mvarLimit ) in case of violation
		// calculate branch current violation index = sqrt[ sum(e*e) ], where e = ( amps - ampsLimit ) in case of violation
		if (session.getAttribute(Constants.GridToken_AclfOpt_CalBranchLimitViolation) != null &&
				((Boolean)session.getAttribute(Constants.GridToken_AclfOpt_CalBranchLimitViolation)).booleanValue()) {
			for (Branch bra : net.getBranchList()) {
				AclfBranch aclfBra = (AclfBranch) bra;
				double amps = aclfBra.current(UnitType.Amp, net.getBaseKva());
				double mva = aclfBra.mvaFlow(UnitType.mVA, net.getBaseKva());
				if (aclfBra.getRatingMva1() > 0.0) 
					if (mva > aclfBra.getRatingMva1()) {
						double e = (mva - aclfBra.getRatingMva1()) / aclfBra.getRatingMva1();
						mva1Index += e*e;
						IpssLogger.getLogger().info("Branch Mva1 limit violated, " + mva + " mva1Limit " + 
								aclfBra.getRatingMva1() + " at branch " + aclfBra.getId());
					}
				if (aclfBra.getRatingMva2() > 0.0) 
					if (mva > aclfBra.getRatingMva2()) {
						double e = (mva - aclfBra.getRatingMva2()) / aclfBra.getRatingMva2();
						mva2Index += e*e;
						IpssLogger.getLogger().info("Branch Mva2 limit violated, " + mva + " mva2Limit " + 
								aclfBra.getRatingMva2() + " at branch " + aclfBra.getId());
					}
				if (aclfBra.getRatingMva3() > 0.0) 
					if (mva > aclfBra.getRatingMva3()) {
						double e = (mva - aclfBra.getRatingMva3()) / aclfBra.getRatingMva3();
						mva3Index += e*e;
						IpssLogger.getLogger().info("Branch Mva3 limit violated, " + mva + " mva3Limit " + 
								aclfBra.getRatingMva3() + " at branch " + aclfBra.getId());
					}
				if (aclfBra.getRatingAmps() > 0.0) 
					if (amps > aclfBra.getRatingAmps()) {
						double e = (amps - aclfBra.getRatingAmps()) / aclfBra.getRatingAmps();
						ampsIndex += e*e;
						IpssLogger.getLogger().info("Branch Amps limit violated, " + mva + " ampsLimit " + 
								aclfBra.getRatingAmps() + " at branch " + aclfBra.getId());
					}
			}
			resultTable.put(RemoteMessageTable.KEY_BranchMva1LimintViolationIndex, new Double(mva1Index));
			resultTable.put(RemoteMessageTable.KEY_BranchMva2LimintViolationIndex, new Double(mva2Index));
			resultTable.put(RemoteMessageTable.KEY_BranchMva3LimintViolationIndex, new Double(mva3Index));
			resultTable.put(RemoteMessageTable.KEY_BranchAmpsLimintViolationIndex, new Double(ampsIndex));
		}

		// calculate voltage violation index = sqrt[ sum(e*e) ], where e = ( v - max ) or ( mix - v ) in case of violation
		if (session.getAttribute(Constants.GridToken_AclfOpt_CalBusVoltViolation) != null &&
				((Boolean)session.getAttribute(Constants.GridToken_AclfOpt_CalBusVoltViolation)).booleanValue()) {
			double max = ((Double)session.getAttribute(Constants.GridToken_AclfOpt_BusVoltageUpperLimitPU)).doubleValue();
			double min = ((Double)session.getAttribute(Constants.GridToken_AclfOpt_BusVoltageLowerLimitPU)).doubleValue();
			IpssLogger.getLogger().info("Calculate voltage violation index, max, min = " + max + "," + min);
			for (Bus bus : net.getBusList()) {
				AclfBus aclfBus = (AclfBus) bus;
				double v = aclfBus.getVoltageMag();
				if (v > max) {
					vIndex += (v-max)*(v-max);
					IpssLogger.getLogger().info("Voltage upper limit violated, " + v + " at bus " + aclfBus.getId());
				}
				else if (v < min) { 
					vIndex += (min-v)*(min-v);
					IpssLogger.getLogger().info("Voltage lower limit violated, " + v + " at bus " + aclfBus.getId());
				}
			}
			resultTable.put(RemoteMessageTable.KEY_BusVoltageLimintViolationIndex, new Double(Math.sqrt(vIndex)));
		}

		if (session.getAttribute(Constants.GridToken_AclfOpt_ReturnStudyCase) != null) { 
			int returnOpt = ((Integer)session.getAttribute(Constants.GridToken_AclfOpt_ReturnStudyCase)).intValue();
			if (returnOpt == RemoteMessageTable.Const_ReturnAllStudyCase) {
				resultTable.put(RemoteMessageTable.KEY_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
			}
			else if (returnOpt == RemoteMessageTable.Const_ReturnDivergedCase) {
				if (!resultTable.getReturnStatus() || !net.isLfConverged()) 
					resultTable.put(RemoteMessageTable.KEY_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
			}
			else if (returnOpt == RemoteMessageTable.Const_ReturnDivergedViolation) {
				if ( !resultTable.getReturnStatus() || !net.isLfConverged() ||
						mva1Index > 0.0 || mva2Index > 0.0 || mva3Index > 0.0 || vIndex > 0.0)
					resultTable.put(RemoteMessageTable.KEY_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
			}
			else {
				;// do nothing
			}
		}
		else {
			resultTable.put(RemoteMessageTable.KEY_SerializedAclfNet, SerializeEMFObjectUtil.saveModel(net));
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
		
		if (mCaseContainer.getAclfGridOption().isCalBranchLimitViolation()) {
			studyCase.setBranchMva1LimitViolationIndex(resultTable.getBranchMva1LimintViolationIndex());
			studyCase.setBranchMva2LimitViolationIndex(resultTable.getBranchMva2LimintViolationIndex());
			studyCase.setBranchMva3LimitViolationIndex(resultTable.getBranchMva3LimintViolationIndex());
			studyCase.setBranchAmpsLimitViolationIndex(resultTable.getBranchAmpsLimintViolationIndex());
		}

		if (mCaseContainer.getAclfGridOption().isCalBusVoltageViolation()) {
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
		double upperVLimit = mCaseContainer.getAclfGridOption().getBusVoltageUpperLimitPU();
		double lowerVLimit = mCaseContainer.getAclfGridOption().getBusVoltageLowerLimitPU();
		
		StringBuffer buf = new StringBuffer();
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		buf.append("\n");
    		buf.append(scase.getDesc() + "\n");
    		if (scase.getName() != null)
    			buf.append("Case Description: " + scase.getName() + "\n");
    		if (!scase.isRemoteReturnStatus())
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
    		
    		if (mCaseContainer.getAclfGridOption().isCalBranchLimitViolation()) {
        		if (scase.getBranchMva1LimitViolationIndex() > 0.0) {
        			buf.append("Branch Mvar1 limit violation index: " + String.format("%5.3f", scase.getBranchMva1LimitViolationIndex()));
        			buf.append("\n");
        		}
        		if (scase.getBranchMva2LimitViolationIndex() > 0.0) {
        			buf.append("Branch Mvar2 limit violation index: " + String.format("%5.3f", scase.getBranchMva2LimitViolationIndex()));
        			buf.append("\n");
        		}
        		if (scase.getBranchMva3LimitViolationIndex() > 0.0) {
        			buf.append("Branch Mvar3 limit violation index: " + String.format("%5.3f", scase.getBranchMva3LimitViolationIndex()));
        			buf.append("\n");
        		}
        		if (scase.getBranchAmpsLimitViolationIndex() > 0.0) {
        			buf.append("Branch Amps limit violation index: " + String.format("%5.3f", scase.getBranchAmpsLimitViolationIndex()));
        			buf.append("\n");
        		}
    		}

    		if (mCaseContainer.getAclfGridOption().isCalBusVoltageViolation()) {
        		if (scase.getBusVoltageViolationIndex() > 0.0) {
        			buf.append("Bus voltage limit violation index: " + String.format("%5.3f", scase.getBusVoltageViolationIndex()));
        			buf.append("\n");
        		}
    		}

    		if (aclfAdjNet != null)
    			if (mCaseContainer.getAclfGridOption().isCalBranchLimitViolation() &&
    				( scase.getBranchMva1LimitViolationIndex() > 0.0 ||
        		      scase.getBranchMva2LimitViolationIndex() > 0.0 ||
        		      scase.getBranchMva3LimitViolationIndex() > 0.0 ||
        		      scase.getBranchAmpsLimitViolationIndex() > 0.0       ) ||
        		      mCaseContainer.getAclfGridOption().isCalBusVoltageViolation() &&
        			  scase.getBusVoltageViolationIndex() > 0.0) {
        			for (Branch bra : aclfAdjNet.getBranchList()) {
        				AclfBranch aclfBra = (AclfBranch) bra;
        				double mvarf_t = aclfBra.powerFrom2To(UnitType.mVar, aclfAdjNet.getBaseKva()).abs();
        				double mvart_f = aclfBra.powerTo2From(UnitType.mVar, aclfAdjNet.getBaseKva()).abs();
        				double amps = aclfBra.current(UnitType.Amp, aclfAdjNet.getBaseKva());
        				double mvar = mvarf_t > mvart_f? mvarf_t : mvart_f;
        				if (aclfBra.getRatingMva1() > 0.0) 
        					if (mvar > aclfBra.getRatingMva1()) {
        						buf.append("Branch Mvar1 limit violated, " + String.format("%5.3f", mvar) + " mvar1Limit " + 
        								String.format("%5.3f", aclfBra.getRatingMva1()) + " at branch " + aclfBra.getId());
        	        			buf.append("\n");
        					}
        				if (aclfBra.getRatingMva2() > 0.0) 
        					if (mvar > aclfBra.getRatingMva2()) {
        						buf.append("Branch Mvar2 limit violated, " + String.format("%5.3f", mvar) + " mvar2Limit " + 
        								String.format("%5.3f", aclfBra.getRatingMva2()) + " at branch " + aclfBra.getId());
        	        			buf.append("\n");
        					}
        				if (aclfBra.getRatingMva3() > 0.0) 
        					if (mvar > aclfBra.getRatingMva3()) {
        						buf.append("Branch Mvar3 limit violated, " + String.format("%5.3f", mvar) + " mvar3Limit " + 
        								String.format("%5.3f", aclfBra.getRatingMva3()) + " at branch " + aclfBra.getId());
        	        			buf.append("\n");
        					}
        				if (aclfBra.getRatingAmps() > 0.0) 
        					if (amps > aclfBra.getRatingAmps()) {
        						buf.append("Branch Amps limit violated, " + String.format("%5.3f", amps) + " ampsLimit " + 
        								String.format("%5.3f", aclfBra.getRatingAmps()) + " at branch " + aclfBra.getId());
        	        			buf.append("\n");
        					}
        			}

        			for (Bus bus : aclfAdjNet.getBusList()) {
        				AclfBus aclfBus = (AclfBus) bus;
        				double v = aclfBus.getVoltageMag();
        				if (v > upperVLimit) {
        					buf.append("Voltage upper limit violated, " + String.format("%6.4f", v) + " at bus " + aclfBus.getId());
                			buf.append("\n");
        				}
        				else if (v < lowerVLimit) { 
        					buf.append("Voltage lower limit violated, " + String.format("%6.4f", v) + " at bus " + aclfBus.getId());
                			buf.append("\n");
        				}
        			}
    			}
    		buf.append("\n");
    	}	
    	return buf;
	}
}
