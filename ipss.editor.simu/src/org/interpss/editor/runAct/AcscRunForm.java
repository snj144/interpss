 /*
  * @(#)AcscRunForm.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.runAct;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.proj.AcscCaseData;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.outfunc.AcscOut;
import com.interpss.dist.DistNetwork;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class AcscRunForm extends BaseRunForm implements ISimuCaseRunner {
	public AcscRunForm() {}
	
	private AcscCaseData acscCaseData;
	public AcscCaseData getAcscCaseData() { return this.acscCaseData; }
	public void setAcscCaseData(AcscCaseData acase) {this.acscCaseData = acase;}

  	public boolean runCase(SimuContext simuCtx, IPSSMsgHub msg) {
	  	simuCtx.getAcscFaultNet().removeAllFault();
	  	if (simuCtx.getNetType() == SimuCtxType.DISTRIBUTE_NET) {
	  		runShortCircuit(simuCtx.getDistNet(), simuCtx.getSimpleFaultAlgorithm(), simuCtx.getMsgHub());
	  	}
	  	else {
	  		if (simuCtx.getNetType() == SimuCtxType.DSTABILITY_NET) {
	  			simuCtx.getDStabilityNet().initialization(simuCtx.getMsgHub());
	  		}
	  		runShortCircuit(simuCtx.getAcscFaultNet(), simuCtx.getSimpleFaultAlgorithm(), simuCtx.getMsgHub());
	  	}
	  	return true;
	}	
	
	public void displayResult(SimuContext simuCtx) {
  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Short Circuit Analysis Result Summary");
  		dialog.display(AcscOut.faultResult2String(simuCtx.getAcscFaultNet()));
	}
	
  	private void runShortCircuit(DistNetwork distNet, SimpleFaultAlgorithm algo, IPSSMsgHub msg) {
	  	if (distNet.getScPointNetData().getScPointList().size() > 1) {
	  		for (int i = 0; i < distNet.getScPointNetData().getScPointList().size(); i++) {
	  			distNet.updateAcscNetData(i, msg);
		  		runShortCircuit(distNet.getFaultNet(), "ScPoint"+(i+1), algo, msg);
	  		}
	  	}
	  	else {
	  		runShortCircuit(distNet.getFaultNet(), "", algo, msg);
	  	}
	}
  	
  	private void runShortCircuit(SimpleFaultNetwork faultNet, SimpleFaultAlgorithm algo, IPSSMsgHub msg) {
  		runShortCircuit(faultNet, "", algo, msg);
  	}
  	
  	/**
  	 * Calculate short circuit based on the form data and the faultNet object
  	 * 
  	 * @param faultNet a SimpleFaultNetwork object
  	 * @param faultIdStr a string append to the fault object id, normally use ScPoint<n>
  	 * @param msg the SessionMsg object
  	 */
  	public void runShortCircuit(SimpleFaultNetwork faultNet, String faultIdStr, SimpleFaultAlgorithm algo, IPSSMsgHub msg) {
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(this, algo, SimpleFaultAlgorithm.class);
		
  	  	if (getAcscCaseData().getFaultData().getCategory().equals(AcscFaultData.FaultCaty_Fault_All)) {
  	  		for (int i = 0; i < 4; i++) {
  	  			String fCaty = i == 0? AcscFaultData.FaultCaty_Fault_3P :
  	  							( i == 1? AcscFaultData.FaultCaty_Fault_LL :
  	  								( i == 2? AcscFaultData.FaultCaty_Fault_LLG : AcscFaultData.FaultCaty_Fault_LG));
  	  			getAcscCaseData().getFaultData().setCategory(fCaty); // temporarilly set fault Caty for the calculation
  	  			calFault(getAcscCaseData().getFaultData().getType(), faultIdStr, faultNet, algo, msg);
  	  		}
  	  		getAcscCaseData().getFaultData().setCategory(AcscFaultData.FaultCaty_Fault_All); // set to original value
  	  	}
  	  	else {
  	  		calFault(getAcscCaseData().getFaultData().getType(), faultIdStr, faultNet, algo, msg);
  	  	}
  	}
  	
  	private void calFault(String ftype, String idStr, SimpleFaultNetwork faultNet, SimpleFaultAlgorithm algo, IPSSMsgHub msg) {
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		if (getAcscCaseData().getFaultData().getType().equals(AcscFaultData.FaultType_BusFault)) {
	  		AcscBus faultBus = (AcscBus)faultNet.getBus(getAcscCaseData().getFaultData().getBusId());
			if (faultBus == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found");
	  			return;
	  		}
			AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at " + 
					getAcscCaseData().getFaultData().getBusId());
			mapper.mapping(getAcscCaseData().getFaultData(), fault, AcscBusFault.class);
			faultNet.addBusFault(faultBus.getId(), idStr, fault);
	  		algo.calculateBusFault(fault, msg);	  		
		}
		else {
	  		AcscBranch faultBranch = (AcscBranch)faultNet.getBranch(getAcscCaseData().getFaultData().getBusId()+"(1)");
			if (faultBranch == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found");
	  			return;
	  		}
			AcscBranchFault fault = CoreObjectFactory.createAcscBranchFault("Branch Fault at " + 
					getAcscCaseData().getFaultData().getBusId());
			mapper.mapping(getAcscCaseData().getFaultData(), fault, AcscBranchFault.class);
			faultNet.addBranchFault(faultBranch.getId(), idStr, fault);
			algo.calculateBranchFault(fault, msg);	 		
		}
  	}
}