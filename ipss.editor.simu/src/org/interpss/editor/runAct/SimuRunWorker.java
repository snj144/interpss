 /*
  * @(#)SimuRunWorker.java   
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
import org.interpss.editor.graph.GraphSimuUtilFunc;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.app.IAppStatus;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.jgraph.JGraph;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.util.outfunc.AcscOut;
import com.interpss.simu.SimuContext;

public class SimuRunWorker extends Thread {
	public static final int RUN_TYPE_ACLF = 1;
	public static final int RUN_TYPE_ACSC = 2;
	public static final int RUN_TYPE_DSTAB = 3;
	
	private int runType = 0;
	private SimuContext simuCtx = null;
	private JGraph graph = null;
	
	
	public SimuRunWorker(String str) { 
		super(str); 
	} 

	public void configRun(int aRunType, SimuContext aCtx, JGraph aGraph) {
		this.runType = aRunType;
		this.simuCtx = aCtx;
		this.graph = aGraph;
	}
	
	public void run() { 
		IAppStatus appStatus = GraphSpringAppContext.getIpssGraphicEditor().getAppStatus();
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		switch (this.runType) {
			case RUN_TYPE_ACLF : {
				appStatus.busyStart(
						Constants.StatusBusyIndicatorPeriod, "Run AC Loadflow Analysis ...", "Run Aclf");
				IpssLogger.getLogger().info("SimuRunWorker starts Run AC Loadflow");
				
				boolean converge = SimuAppSpringAppContext.getAclfRunForm().runLoadflow(simuCtx);
				appSimuCtx.setLfConverged(converge);
				
			  	appStatus.busyStop("Run AC Loadflow Analysis finished");
				
			  	if (graph != null) {
					GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACLF);
				}
				break;
			}
			case RUN_TYPE_ACSC : {
				appStatus.busyStart(	
						Constants.StatusBusyIndicatorPeriod, "Run AC Short Circuit Analysis ...", "Run Acsc");
				IpssLogger.getLogger().info("SimuRunWorker starts Run AC Short Circuit");

				SimuAppSpringAppContext.getAcscRunForm().runShortCircuit(simuCtx);
				
				appStatus.busyStop("Run AC Short Circuit Analysis finished");
				
		  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Short Circuit Analysis Result Summary");
		  		dialog.display(AcscOut.faultResult2String(simuCtx.getAcscFaultNet()));
				if (graph != null) {
					GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACSC_POSITIVE);
				}
				break;
			}
			case RUN_TYPE_DSTAB : {
				appStatus.busyStart(Constants.StatusBusyIndicatorPeriod, "Run Transient Stability Simulation ...", "Run DStab");
				IpssLogger.getLogger().info("SimuRunWorker starts Run Transient Stability");
				
			  	DStabRunForm runForm = SimuAppSpringAppContext.getDStabRunForm();
				runForm.runDStab(simuCtx, simuCtx.getMsgHub());

				appStatus.busyStop("Run Transient Stability Simulation finished");
				break;
			}
		}
	}
}
