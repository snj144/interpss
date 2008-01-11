 /*
  * @(#)DStabRunForm.java   
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

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.gridgain.task.assignJob.AbstractAssignJob2NodeTask;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.util.GridMessageRouter;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreSpringAppContext;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabSpringAppContext;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;

public class DStabRunForm extends BaseRunForm  implements ISimuCaseRunner {
	private AclfCaseData aclfCaseData = null;
	private DStabCaseData dStabCaseData = null;
	
	public DStabRunForm() {}
	
	/**
	 * get the DStabCaseData object
	 * 
	 * @return the dStabCaseData
	 */
	public DStabCaseData getDStabCaseData() {
		return dStabCaseData;
	}

	/**
	 * set the DStabCaseData object
	 * 
	 * @param stabCaseData the dStabCaseData to set
	 */
	public void setDStabCaseData(DStabCaseData stabCaseData) {
		dStabCaseData = stabCaseData;
	}
	
	/**
	 * Display Aclf summary if selected by the user
	 * 
	 * @param simuCtx
	 */
	public void displaySummaryResult(SimuContext simuCtx) {
	  	if (getAclfCaseData().getShowSummary()) {
	  		RunActUtilFunc.displayAclfSummaryResult(simuCtx.getDynSimuAlgorithm());
	  	}
	}
	
	/**
	 * Run DStab simulation
	 * 
	 * @param simuCtx
	 * @param msg
	 */
	public boolean runCase(SimuContext simuCtx, IPSSMsgHub msg) {
		if (!prepareSimuRunDataCheckError(simuCtx, msg))
			return false;
		
		LoadflowAlgorithm aclfAlgo = simuCtx.getDynSimuAlgorithm().getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
	  	if (!simuCtx.getDStabilityNet().isLfConverged()) {
	  		msg.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
	  		return false;
	  	}

	  	// set up output and run the simulation
		IDStabSimuDatabaseOutputHandler handler = RunActUtilFunc.createDBOutputHandler(simuCtx.getDynSimuAlgorithm());
		if (handler == null)
			return false;
		
		// setup if there is output filtering
		handler.setOutputFilter(dStabCaseData.isOutputFilter());
		if (handler.isOutputFilter()) 
			handler.setOutputVarIdList(dStabCaseData.getOutVarList());
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(handler);

		IDStabSimuDatabaseOutputHandler scriptHandler = null;
		if (dStabCaseData.isOutputScripting()) {
			scriptHandler = (IDStabSimuDatabaseOutputHandler)DStabSpringAppContext.getDStabScriptOutputHandler();
			simuCtx.getDynSimuAlgorithm().setScriptOutputHandler(scriptHandler);
			try {
				if (!scriptHandler.init(dStabCaseData.getOutputScriptFilename(), simuCtx.getDStabilityNet()))
					return false;
			} catch (Exception e) {
				IpssLogger.logErr(e);
				return false;
			}
		}
		
		simuCtx.getDStabilityNet().setNetChangeListener(CoreSpringAppContext.getNetChangeHandler());
		
	  	if (simuCtx.getDynSimuAlgorithm().initialization(msg)) {
	  		displaySummaryResult(simuCtx);
		  	simuCtx.getDynSimuAlgorithm().performSimulation(msg);
		}

	  	if (dStabCaseData.isOutputScripting()) {
	  		if (scriptHandler != null)
	  			scriptHandler.close();	
		}
	  	return true;
	}
	
	/**
	 * Run DStab grid simulation
	 * 
	 * @param simuCtx
	 * @param msg
	 */
	public boolean runGridCase(SimuContext simuCtx, IPSSMsgHub msg) {
		if (!prepareSimuRunDataCheckError(simuCtx, msg))
			return false;
		
		// get the selected remote node
		Grid grid = IpssGridGainUtil.getDefaultGrid();
		String nodeId = IpssGridGainUtil.nodeIdLookup(dStabCaseData.getGridNodeName());
		AssignJob2NodeDStabTask.RemoteNodeId = nodeId;
		AbstractAssignJob2NodeTask.MasterNodeId = grid.getLocalNode().getId().toString();
		
		/*
		 * The simuMsg sending from remote node to the master node will be routed
		 * by the router to the msg object. The simuMsg will be then routed to the 
		 * DBSimuDataHandler
		 */
    	GridMessageRouter msgRouter = new GridMessageRouter(msg);
    	grid.addMessageListener(msgRouter);
    	
		IDStabSimuDatabaseOutputHandler dstabDbHandler = RunActUtilFunc.createDBOutputHandler(simuCtx.getDynSimuAlgorithm());
		if (dstabDbHandler == null)
			return false;
    	msgRouter.setDStabSimuDbOutputHandler(dstabDbHandler);
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(dstabDbHandler);
		
		// transfer output variable filter info to the DStabAlgo object, which then 
		// will be carried by the object to the remote grid node
		simuCtx.getDynSimuAlgorithm().setOutputFilted(dStabCaseData.isOutputFilter());
		if (simuCtx.getDynSimuAlgorithm().isOutputFilted()) { 
			String[] slist = new String[dStabCaseData.getOutVarList().size()];
			int cnt = 0;
			for (String str : dStabCaseData.getOutVarList())
				slist[cnt++] = str;
			simuCtx.getDynSimuAlgorithm().setOutputVarIdList(slist);
		}

		try {
			long timeout = 0;  // no timeout
			DStabilityNetwork net = simuCtx.getDStabilityNet();
			// make sure net.id defined here. It has to be unique if run multiple grid runs
			String caseId = "DStabNetId"; 
			net.setId(caseId);
			dstabDbHandler.addDBCaseId(caseId, dstabDbHandler.getDBCaseId());
			Boolean rtn = (Boolean)IpssGridGainUtil.performGridTask(grid,
									"InterPSS Transient Stability Simulation", 
									simuCtx.getDynSimuAlgorithm(), 
									timeout);
			// init the Net object for plotting purpose. it is inited at the remote grid node
			// before DStab simulation.
			simuCtx.setDStabilityNet(net);
			net.initialization(msg);
			return rtn.booleanValue();
		} catch (GridException e) {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid DStab Error", e.toString());
			return false;
		}
	}

	/**
	 * @return the aclfCaseData
	 */
	public AclfCaseData getAclfCaseData() {
		if (aclfCaseData == null)
			aclfCaseData = new AclfCaseData();
		return aclfCaseData;
	}
	/**
	 * @param aclfCaseData the aclfCaseData to set
	 */
	public void setAclfCaseData(AclfCaseData aclfCaseData) {
		this.aclfCaseData = aclfCaseData;
	}

	private boolean prepareSimuRunDataCheckError(SimuContext simuCtx, IPSSMsgHub msg) {
		simuCtx.getDStabilityNet().removeAllDEvent();
		
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(this, simuCtx.getDynSimuAlgorithm(), DynamicSimuAlgorithm.class);

  		return RunActUtilFunc.checkDStabSimuData(simuCtx.getDynSimuAlgorithm(), msg);
	}
}