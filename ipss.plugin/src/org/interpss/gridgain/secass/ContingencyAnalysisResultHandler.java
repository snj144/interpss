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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
import com.interpss.simu.multicase.result.AclfBranchResultRec;
import com.interpss.simu.multicase.result.AclfBusResultRec;
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


	
	public StringBuffer toString(byte type, MultiStudyCase mCaseContainer) {
		StringBuffer buf = new StringBuffer();
		
		ContingencyAnalysis mcase = (ContingencyAnalysis)mCaseContainer;
		if (type == IRemoteResult.DisplayType_SecViolation) {
			List<Record> elemList = new ArrayList<Record>();
			Enumeration<String> keys = mcase.getBranchResult().keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				AclfBranchResultRec r = mcase.getBranchResult().get(key);
				if (r.getRating().getThermalMvaRating() > 0.0 && r.getMvaFlow()>r.getRating().getThermalMvaRating()) {
					double percent = (r.getMvaFlow()-r.getRating().getThermalMvaRating()) / r.getRating().getThermalMvaRating();
					elemList.add(new Record(key, percent*100, r));
				}	
			}
			
			boolean done = false;
			while (!done) {
				done = true;
				for (int i = 0; i < elemList.size()-1; i++) {
					if (elemList.get(i).violatePer < elemList.get(i+1).violatePer) {
						Record temp = elemList.get(i);
						elemList.set(i, elemList.get(i+1));
						elemList.set(i+1, temp);
						done = false;
					}
				}
			}

			buf.append("\n");
			buf.append("                    Branch MVA Rating Violation Report\n");
			buf.append("\n");

			buf.append("       Branch Id     MvaFlow   MvaRating   Violation    Description\n");
			buf.append("  ===========================================================================\n");
			for (Record rec : elemList) {
				String str = String.format("%3.0f%s", rec.violatePer, "%");
				buf.append(String.format("  %16s  %8.1f  %8.1f       %s      %s%n", 
							rec.key, rec.value.getMvaFlow(), rec.value.getRating().getThermalMvaRating(), 
							str, rec.value.getDesc()));
			}
		}
		else {
			buf.append("\n");
			buf.append("                     Security Margin Report\n");
			buf.append("\n");

			double max = mcase.getBusVoltageUpperLimitPU(), 
			       min = mcase.getBusVoltageLowerLimitPU();
			buf.append("\n");
			buf.append(String.format("   Bus Voltage Limit: [%4.2f, %4.2f]\n", max, min));
			buf.append("\n");

			buf.append("    Bus Id       HighVolt UpperMargin   LowVolt LowMargin    Description\n");
			buf.append("===========================================================================\n");
			Enumeration<String> keys = mcase.getBusResult().keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				AclfBusResultRec r = mcase.getBusResult().get(key);
				buf.append(String.format("  %10s    %8.4f    %4.1f%s     %8.4f    %4.1f%s     %s%n", key, 
						r.getHighVoltMagPU(), (max-r.getHighVoltMagPU())*100.0, "%",
						r.getLowVoltMagPU(), (r.getLowVoltMagPU()-min)*100.0, "%", r.getDesc()));
			}
			buf.append("\n");
			
			buf.append("       Branch Id     MvaFlow   MvaRating       P + jQ       Margin      Description\n");
			buf.append("  ===========================================================================================\n");
			keys = mcase.getBranchResult().keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				AclfBranchResultRec r = mcase.getBranchResult().get(key);
				String str = "    ";
				if (r.getRating().getThermalMvaRating() > 0.0) {
					double margin = (r.getRating().getThermalMvaRating()-r.getMvaFlow()) / r.getRating().getThermalMvaRating();
					str = String.format("%3.0f%s", margin*100.0, "%");
				}	
				buf.append(String.format("  %16s  %8.1f  %8.1f    (%6.1f%s%6.1f)   %s      %s%n", 
						key, r.getMvaFlow(), r.getRating().getThermalMvaRating(), r.getPFlow(), "+j", r.getQFlow(), str, r.getDesc()));
			}
		}
		
		return buf;
	}
	
	private static class Record {
		public String key = "";
		public double violatePer = 0.0;
		public AclfBranchResultRec value = null;
		
		public Record(String key, double per, AclfBranchResultRec value) {
			this.key = key;
			this.violatePer = per;
			this.value = value;
		}
	}	
}
