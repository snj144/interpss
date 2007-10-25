 /*
  * @(#)AclfRunForm.java   
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

import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.grid.gridgain.aclf.IpssAclfNetGridGainTask;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Bus;
import com.interpss.dist.DistBus;
import com.interpss.dist.DistBusAdapter;
import com.interpss.dist.DistNetwork;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class AclfRunForm extends BaseRunForm implements ISimuCaseRunner {
	public AclfRunForm() {}

	private AclfCaseData aclfCaseData;
	public AclfCaseData getAclfCaseData() {	return this.aclfCaseData; }
	public void setAclfCaseData(AclfCaseData acase) {this.aclfCaseData = acase;}
	
  	public boolean runCase(SimuContext simuCtx, IPSSMsgHub msg) {
  		boolean converge = false;
  		if (simuCtx.getNetType() == SimuCtxType.DISTRIBUTE_NET) {
  			converge = runLoadflow(simuCtx.getDistNet(), simuCtx);
  		}
  		else {
  			if (aclfCaseData.isGridComputing()) {
  				String nodeId = IpssGridGainUtil.nodeIdLookup(aclfCaseData.getGridNodeName());
  				IpssAclfNetGridGainTask.RemoteNodeId = nodeId;
  				try {
  					String str = (String)IpssGridGainUtil.performGridTask(IpssGridGainUtil.getDefaultGrid(),
  									"Grid Aclf 5-Bus Sample system", simuCtx.getAclfAdjNet(), aclfCaseData.getGridTimeout());
  	  				AclfAdjNetwork adjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(str);
  	  				simuCtx.setAclfAdjNet(adjNet);
  	  				converge = adjNet.isLfConverged();
  	  				if (getAclfCaseData().getShowSummary()) {
  	  					IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Run by Remote " + aclfCaseData.getGridNodeName());
  	  					dialog.display(adjNet);
  	  				}
  				} catch (GridException e) {
  					SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid Aclf Error", e.toString());
  					return false;
  				}
  			}
  			else
  				converge = runLoadflow(simuCtx.getAclfAdjNet(), simuCtx);
  		}
  		return converge;
  	}
  	
	public void displayResult(SimuContext simuCtx) {
	  	if (getAclfCaseData().getShowSummary()) {
	  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
	  		dialog.display(simuCtx.getAclfAdjNet());
	  	}
	}
  	
  	private boolean runLoadflow(DistNetwork distNet, SimuContext simuCtx) {
  		boolean converge = true;
  		if (distNet.getLoadNetData().getSchedulePoints() == 0) {
  			distNet.setNameplateAclfNetData(simuCtx.getMsgHub());
			converge = runLoadflow_internal(distNet.getAcscNet(), simuCtx.getLoadflowAlgorithm(), simuCtx.getMsgHub());
		  	
		  	if (getAclfCaseData().getShowSummary()) {
		  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
		  		dialog.display(distNet.getAcscNet());
		  	}
		}
  		else {
  			double loss = 0.0;
  			for (int i = 0; i < distNet.getLoadNetData().getSchedulePoints(); i++) {
  				distNet.setPointAclfNetData(i, simuCtx.getMsgHub());
  				if (!runLoadflow_internal(distNet.getAcscNet(), simuCtx.getLoadflowAlgorithm(), simuCtx.getMsgHub()))
  					converge = false;
  				
  				for( Bus b : distNet.getBusList()) {
  					DistBus distBus = (DistBus)b;
  			  		DistBusAdapter aBusApt = (DistBusAdapter)distBus.adapt(DistBusAdapter.class);
  			  		aBusApt.setPointVoltage(distBus.getAcscBus().getVoltage(), i);
  				}
  			}

		  	distNet.getLoadNetData().setTotalLossKwHr(loss);  		
		  	if (getAclfCaseData().getShowSummary()) {
		  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Distribution Loadflow Analysis Info");
		  		dialog.display(distNet);
		  	}
  		}
  		return converge; 
  	}
  	
  	private boolean runLoadflow(AclfAdjNetwork aclfAdjNet, SimuContext simuCtx) {
  	  	boolean converge = runLoadflow_internal(aclfAdjNet, simuCtx.getLoadflowAlgorithm(), simuCtx.getMsgHub());
	  	if (!converge)
	  		simuCtx.getMsgHub().sendWarnMsg("Loadflow does not converge!");
	  	displayResult(simuCtx);
  	  	return converge;
  	}
  	
  	private boolean runLoadflow_internal(AclfAdjNetwork aclfAdjNet, LoadflowAlgorithm algo, IPSSMsgHub msg) {
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(this, algo, LoadflowAlgorithm.class);

		algo.loadflow(msg);

	  	return aclfAdjNet.isLfConverged();
  	}
}