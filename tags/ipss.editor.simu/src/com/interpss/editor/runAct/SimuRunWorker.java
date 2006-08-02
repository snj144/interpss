package com.interpss.editor.runAct;

import org.jgraph.JGraph;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.util.outfunc.AcscOut;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.graph.GraphSimuUtilFunc;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppStatus;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.ui.IOutputTextDialog;
import com.interpss.editor.ui.UISpringAppContext;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

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
				
			  	if (!converge)
			  		simuCtx.getMsgHub().sendWarnMsg("Loadflow does not converge!");
			  	
			  	if (graph != null) {
					if (simuCtx.getNetType() == SimuCtxType.DISTRIBUTE_NET_LITERAL)
						GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACLF);
					else
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
					if (simuCtx.getNetType() == SimuCtxType.DISTRIBUTE_NET_LITERAL)
						GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACSC_POSITIVE);
					else
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
