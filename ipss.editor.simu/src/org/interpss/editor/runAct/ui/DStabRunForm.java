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

package org.interpss.editor.runAct.ui;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.editor.runAct.RunActUtilFunc;
import org.interpss.gridgain.GridRunner;
import org.interpss.gridgain.msg.GridMessageRouter;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.task.singleJob.DStabSingleJobTask;
import org.interpss.gridgain.util.GridUtil;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.GridComputingXmlType;
import org.interpss.spring.PluginSpringCtx;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.dstab.DStabSpringAppContext;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.common.IDStabSimuDatabaseOutputHandler;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;
import com.interpss.spring.CoreCommonSpringCtx;
import com.interpss.spring.CoreSpringCtx;

public class DStabRunForm extends BaseRunForm implements ISimuCaseRunner {
	//private AclfCaseData aclfCaseData = null;
	//private DStabCaseData dStabCaseData = null;

	private DStabStudyCaseXmlType xmCaseData;
	private GridComputingXmlType xmlGridOpt;

	public DStabRunForm() {
	}
/*
	public DStabCaseData getDStabCaseData() {
		return dStabCaseData;
	}

	public void setDStabCaseData(DStabCaseData stabCaseData) {
		dStabCaseData = stabCaseData;
	}
*/
	public DStabStudyCaseXmlType getXmlCaseData() {
		return this.xmCaseData;
	}

	public GridComputingXmlType getXmlGridData() {
		return this.xmlGridOpt;
	}
	
	public void setXmlCaseData(DStabStudyCaseXmlType scase, GridComputingXmlType xmlGridOpt) {
		this.xmCaseData = scase;
		this.xmlGridOpt = xmlGridOpt;
	}
	
	/**
	 * Display Aclf summary if selected by the user
	 * 
	 * @param simuCtx
	 */
	public void displaySummaryResult(SimuContext simuCtx) {
		if (this.xmCaseData.getAclfAlgorithm().getDisplaySummary()) {
			RunActUtilFunc.displayAclfSummaryResult(simuCtx
					.getDynSimuAlgorithm());
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
		aclfAlgo.loadflow();
		if (!simuCtx.getDStabilityNet().isLfConverged()) {
			msg.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
			return false;
		}

		// set up output and run the simulation
		IDStabSimuDatabaseOutputHandler handler = null;
		try {
			handler = RunActUtilFunc
				.createDBOutputHandler(simuCtx.getDynSimuAlgorithm());
		} catch (Exception ex) {
			IpssLogger.logErr(ex);
		}	
		if (handler == null)
			return false;
		
		// setup if there is output filtering
		handler.setOutputFilter(this.xmCaseData.getOutputConfig().getOutputFilter());
		if (handler.isOutputFilter())
			handler.setOutputVarIdList(this.xmCaseData.getOutputConfig().getOutputVarList().getVariableNameArray());
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(handler);

		IDStabSimuDatabaseOutputHandler scriptHandler = null;
		if (this.xmCaseData.getOutputScripting().getScripting()) {
			scriptHandler = (IDStabSimuDatabaseOutputHandler) DStabSpringAppContext
					.getDStabScriptOutputHandler();
			simuCtx.getDynSimuAlgorithm().setScriptOutputHandler(scriptHandler);
			try {
				if (!scriptHandler.init(
						this.xmCaseData.getOutputScripting().getScriptingFilename(), simuCtx
								.getDStabilityNet()))
					return false;
			} catch (Exception e) {
				IpssLogger.logErr(e);
				return false;
			}
		}

		simuCtx.getDStabilityNet().setNetChangeListener(
				CoreSpringCtx.getNetChangeHandler());

		if (simuCtx.getDynSimuAlgorithm().initialization()) {
			displaySummaryResult(simuCtx);
			simuCtx.getDynSimuAlgorithm().performSimulation();
		}

		if (this.xmCaseData.getOutputScripting().getScripting()) {
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
		Grid grid = GridUtil.getDefaultGrid();
		String nodeId = GridUtil.nodeIdLookup(this.xmlGridOpt.getRemoteNodeName());
		DStabSingleJobTask.RemoteNodeId = nodeId;
		GridRunner.MasterNodeId = grid.getLocalNode().getId().toString();

		/*
		 * The simuMsg sending from remote node to the master node will be routed
		 * by the router to the msg object. The simuMsg will be then routed to the 
		 * DBSimuDataHandler
		 */
		GridMessageRouter msgRouter = new GridMessageRouter(msg);
		grid.addMessageListener(msgRouter);

		IDStabSimuDatabaseOutputHandler dstabDbHandler = null;
		try {
			dstabDbHandler = RunActUtilFunc
				.createDBOutputHandler(simuCtx.getDynSimuAlgorithm());
		} catch (Exception ex) {
			IpssLogger.getLogger().severe(ex.toString());
		}
		if (dstabDbHandler == null)
			return false;
		
		msgRouter.addDStabSimuDbOutputHandler(dstabDbHandler);
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(dstabDbHandler);

		// transfer output variable filter info to the DStabAlgo object, which then 
		// will be carried by the object to the remote grid node
		simuCtx.getDynSimuAlgorithm().setOutputFiltered(this.xmCaseData.getOutputConfig().getOutputFilter());
		if (simuCtx.getDynSimuAlgorithm().isOutputFiltered()) {
			String[] slist = new String[this.xmCaseData.getOutputConfig().getOutputVarList().getVariableNameArray().length];
			int cnt = 0;
			for (String str : this.xmCaseData.getOutputConfig().getOutputVarList().getVariableNameArray())
				slist[cnt++] = str;
			simuCtx.getDynSimuAlgorithm().setOutputVarIdList(slist);
		}

		try {
			long timeout = 0; // no timeout
			DStabilityNetwork net = simuCtx.getDStabilityNet();
			// make sure net.id defined here. It has to be unique if run multiple grid runs
			String caseId = "DStabNetId";
			net.setId(caseId);
			PluginSpringCtx.getSimuRecManager().addDBCaseId(caseId, dstabDbHandler.getDBCaseId());
			RemoteMessageTable result = new GridRunner(grid,
					"InterPSS Transient Stability Simulation", simuCtx
							.getDynSimuAlgorithm()).executeTask(timeout);
			// init the Net object for plotting purpose. it is inited at the remote grid node
			// before DStab simulation.
			simuCtx.setDStabilityNet(net);
			net.initialization();
			return result.getReturnStatus();
		} catch (GridException e) {
			CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
					"Grid DStab Error", e.toString());
			return false;
		}
	}
/*
	public AclfCaseData getAclfCaseData() {
		if (aclfCaseData == null)
			aclfCaseData = new AclfCaseData();
		return aclfCaseData;
	}

	public void setAclfCaseData(AclfCaseData aclfCaseData) {
		this.aclfCaseData = aclfCaseData;
	}
*/
	private boolean prepareSimuRunDataCheckError(SimuContext simuCtx, IPSSMsgHub msg) {
		simuCtx.getDStabilityNet().removeAllDEvent();

		PluginSpringCtx.getXml2DStabAlgorithmMapper()
				.map2Model(this.getXmlCaseData(), simuCtx.getDynSimuAlgorithm());

		return RunActUtilFunc.checkDStabSimuData(simuCtx.getDynSimuAlgorithm(),
				msg);
	}
}