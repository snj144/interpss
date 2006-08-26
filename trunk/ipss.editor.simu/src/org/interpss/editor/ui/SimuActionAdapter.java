package org.interpss.editor.ui;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.graph.GraphSimuUtilFunc;
import org.interpss.editor.runAct.SimuRunWorker;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.jgraph.JGraph;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.IIpssGraphModel;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuSpringAppContext;

public class SimuActionAdapter {

	public static void menu_run_aclf(boolean graphView, JGraph graph) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		
		IGFormContainer gFormContainer = null ;
		if (appSimuCtx.isSimuNetDataDirty() && graphView) {
			gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
			IpssLogger.getLogger().info("SimuNetData is dirty, rebuild AclfNet object");
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		else {
			// for non-graphic document, use the default setting for loadflow calculation
			// This may need to be changed in the future.
			gFormContainer = GraphSpringAppContext.getEditorFormContainer();
		}
		simuCtx.setLoadflowAlgorithm(SimuSpringAppContext.getLoadflowAlgorithm());

		try {
			ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_Aclf, gFormContainer, appSimuCtx);
			if (dialog.isReturnOk()) {
				SimuRunWorker worker = new SimuRunWorker("Aclf SimuRunWorker");
				worker.configRun(SimuRunWorker.RUN_TYPE_ACLF, simuCtx, graph);
				worker.start();
				appSimuCtx.setLastRunType(SimuRunWorker.RUN_TYPE_ACLF);
			}
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showMsgDialog("Error", "See log file for details\n" + e.toString());
		}
	}

	public static void menu_run_acsc(boolean graphView, JGraph graph) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		IGFormContainer gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
		if (appSimuCtx.isSimuNetDataDirty() && graphView) {
			IpssLogger.getLogger().info("SimuNetData is dirty, rebuild FaultNet object");
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		simuCtx.setSimpleFaultAlgorithm(SimuSpringAppContext.getSimpleFaultAlgorithm());

		try {
			ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_Acsc, gFormContainer, appSimuCtx);
			if (dialog.isReturnOk()) {
				SimuRunWorker worker = new SimuRunWorker("Acsc SimuRunWorker");
				worker.configRun(SimuRunWorker.RUN_TYPE_ACSC, simuCtx, graph);
				worker.start();
				appSimuCtx.setLastRunType(SimuRunWorker.RUN_TYPE_ACSC);
			}
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getIpssMsgHub().sendErrorMsg("See log file for details\n" + e.toString());
		}
	}

	public static void menu_run_dstab(boolean graphView, JGraph graph) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		IGFormContainer gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
		IpssLogger.getLogger().info("SimuNetData is dirty, rebuild DStabNet object");
		IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
		if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
			return;
		appSimuCtx.setSimuNetDataDirty(false);
		
		simuCtx.setDynSimuAlgorithm(SimuSpringAppContext.getDynamicSimuAlgorithm());

		ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_DStab, gFormContainer, appSimuCtx);
		if (dialog.isReturnOk()) {
			SimuRunWorker worker = new SimuRunWorker("DStab SimuRunWorker");
			worker.configRun(SimuRunWorker.RUN_TYPE_DSTAB, simuCtx, null);
			worker.start();
			appSimuCtx.setLastRunType(SimuRunWorker.RUN_TYPE_DSTAB);
		}	
	}
	
	public static void menu_annotate_loadflow(JGraph graph) {
		if (graph != null) {
			SimuContext simuCtx = (SimuContext)GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext().getSimuCtx();
			GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACLF);
		}		
	}

	public static void menu_annotate_acscPositive(JGraph graph) {
		if (graph != null) {
			SimuContext simuCtx = (SimuContext)GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext().getSimuCtx();
			GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACSC_POSITIVE);
		}		
	}

	public static void menu_annotate_acscNegative(JGraph graph) {
		if (graph != null) {
			SimuContext simuCtx = (SimuContext)GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext().getSimuCtx();
			GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACSC_NEGATIVE);
		}		
	}

	public static void menu_annotate_acscZero(JGraph graph) {
		if (graph != null) {
			SimuContext simuCtx = (SimuContext)GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext().getSimuCtx();
			GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_ACSC_ZERO);
		}		
	}

	public static void menu_annotate_clear(JGraph graph) {
		if (graph != null) {
			SimuContext simuCtx = (SimuContext)GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext().getSimuCtx();
			GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph, GraphSimuUtilFunc.LABEL_ACT_CLEAR);
		}		
	}

	public static void menu_tools_debug_projDataInfo(IAppSimuContext appSimuContext) {
		XmlUtil.ToolKid = XmlUtil.TOOL_JDK;
		String str = appSimuContext.getProjData().toString();
		XmlUtil.ToolKid = XmlUtil.TOOL_CASTOR;
  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Project data");
  		dialog.display(str);		
	}
	
	public static void menu_tools_debug_netDataInfo(IGFormContainer gFormContainer) {
		XmlUtil.ToolKid = XmlUtil.TOOL_JDK;
		String str = gFormContainer.toString();
		XmlUtil.ToolKid = XmlUtil.TOOL_CASTOR;
  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Network data");
  		dialog.display(str);		
	}

	public static void menu_tools_debug_refData() {
		String str = SpringAppContext.getRefDataManager().toString();
  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Reference Data");
  		dialog.display(str);		
	}

	public static void menu_tools_debug_simuCtxInfo() {
		IAppSimuContext project = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)project.getSimuCtx();
		String str = simuCtx.toString();
  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("SimuNetwork object info");
  		dialog.display(str);		
	}
}
