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
import org.interpss.core.grid.gridgain.AbstractIpssGridGainTask;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.grid.gridgain.assignJob.AssignJob2NodeDStabTask;
import org.interpss.core.grid.gridgain.util.GridMessageRouter;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;

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
	private int dbSimuCaseId = 0;
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
	public void displayAclfSummaryResult(SimuContext simuCtx) {
	  	if (getAclfCaseData().getShowSummary()) {
	  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
	  		dialog.display(simuCtx.getDynSimuAlgorithm());
	  	}
	}
	
	/**
	 * Run DStab simulation
	 * 
	 * @param simuCtx
	 * @param msg
	 */
	public boolean runCase(SimuContext simuCtx, IPSSMsgHub msg) {
		if (!preprocessing(simuCtx, msg))
			return false;
		
		LoadflowAlgorithm aclfAlgo = simuCtx.getDynSimuAlgorithm().getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
	  	if (!simuCtx.getDStabilityNet().isLfConverged()) {
	  		msg.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
	  		return false;
	  	}

	  	// set up output and run the simulation
		IDStabSimuDatabaseOutputHandler handler = initDBOutputHandler(simuCtx);
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
	  		displayAclfSummaryResult(simuCtx);
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
		if (!preprocessing(simuCtx, msg))
			return false;
		
		// get the selected remote node
		Grid grid = IpssGridGainUtil.getDefaultGrid();
		String nodeId = IpssGridGainUtil.nodeIdLookup(dStabCaseData.getGridNodeName());
		AssignJob2NodeDStabTask.RemoteNodeId = nodeId;
		AbstractIpssGridGainTask.MasterNodeId = grid.getLocalNode().getId().toString();
		
    	GridMessageRouter msgRouter = new GridMessageRouter();
    	grid.addMessageListener(msgRouter);
    	msgRouter.setIPSSMsgHub(msg);
    	
		IDStabSimuDatabaseOutputHandler dstabDbHandler = initDBOutputHandler(simuCtx);
		if (dstabDbHandler == null)
			return false;
    	msgRouter.setIDStabSimuDatabaseOutputHandler(dstabDbHandler);
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(dstabDbHandler);
		
		simuCtx.getDynSimuAlgorithm().setOutputFilted(dStabCaseData.isOutputFilter());
		if (simuCtx.getDynSimuAlgorithm().isOutputFilted()) { 
			String[] slist = new String[dStabCaseData.getOutVarList().size()];
			int cnt = 0;
			for (String str : dStabCaseData.getOutVarList())
				slist[cnt++] = str;
			simuCtx.getDynSimuAlgorithm().setOutputVarIdList(slist);
		}

		try {
			long timeout = 0;
			DStabilityNetwork net = simuCtx.getDStabilityNet();
			// make sure net.id defined here. It has to be unique if run multiple grid runs
			String caseId = "DStabNetId"; 
			net.setId(caseId);
			dstabDbHandler.addDBCaseId(caseId, dstabDbHandler.getDBCaseId());
			Boolean rtn = (Boolean)IpssGridGainUtil.performGridTask(grid,
									"InterPSS Transient Stability Simulation", 
									simuCtx.getDynSimuAlgorithm(), 
									timeout);
			simuCtx.setDStabilityNet(net);
			// for plotting purpose
			net.initialization(msg);
			return rtn.booleanValue();
		} catch (GridException e) {
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Grid DStab Error", e.toString());
			return false;
		}
	}

	/**
	 * @return Returns the dbSimuCaseId.
	 */
	public int getDbSimuCaseId() {
		return dbSimuCaseId;
	}
	/**
	 * @param dbSimuCaseId The dbSimuCaseId to set.
	 */
	public void setDbSimuCaseId(int dbSimuCaseId) {
		this.dbSimuCaseId = dbSimuCaseId;
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

	private boolean preprocessing(SimuContext simuCtx, IPSSMsgHub msg) {
		simuCtx.getDStabilityNet().removeAllDEvent();
		
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(this, simuCtx.getDynSimuAlgorithm(), DynamicSimuAlgorithm.class);

		if (!simuCtx.getDynSimuAlgorithm().checkData(msg)) {
			IpssLogger.getLogger().warning("DStab simulation data checking failed");
			return false;
		}

		// dstab net data changed in the mapping process
		if (!simuCtx.getDStabilityNet().checkData(msg)) {
			IpssLogger.getLogger().warning("DStab network data checking failed");
			return false;
		}
		return true;
	}
	
	private IDStabSimuDatabaseOutputHandler initDBOutputHandler(SimuContext simuCtx) {
		IDStabSimuDatabaseOutputHandler handler = (IDStabSimuDatabaseOutputHandler)simuCtx.getDynSimuAlgorithm().getSimuOutputHandler();
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		ProjData projData = (ProjData)appSimuCtx.getProjData();
		// to avoid conflict with StudyCase name, we add " SimuRecord" to the SimuRecord case.
		try {
			if (!handler.init(projData.getProjectDbId(), projData.getDStabCaseName()+" SimuRecord"))
				return null;
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to Create DB SimuRecord", 
					e.toString() + "\nPlease contact InterPSS support");
		}
		setDbSimuCaseId(handler.getDBCaseId());
		return handler;
	}
}