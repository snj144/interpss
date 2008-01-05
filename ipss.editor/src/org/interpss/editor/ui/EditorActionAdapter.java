 /*
  * @(#)EditorActionAdapter.java   
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

package org.interpss.editor.ui;

import java.io.File;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.app.ProjectScriptFileUtil;
import org.interpss.editor.chart.DStabPlotSelectionDialog;
import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.coreframework.IpssReportDocument;
import org.interpss.editor.coreframework.IpssTextFile;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.doc.IpssProjectItem;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.IIpssGraphModel;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.editor.jgraph.ui.form.IGNetForm;
import org.interpss.editor.report.ReportUtil;
import org.interpss.editor.runAct.SimuRunWorker;
import org.interpss.editor.util.Utilities;
import org.interpss.report.IpssReportFactory;
import org.jgraph.JGraph;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.SimuRunType;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.rec.IpssDBCase;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreSpringAppContext;
import com.interpss.dstab.DStabSpringAppContext;
import com.interpss.simu.SimuContext;

public class EditorActionAdapter {
	
	public static void menu_run(SimuRunType type, boolean graphView, JGraph graph, IpssEditorDocument doc) {
		if (type == SimuRunType.Dclf || type == SimuRunType.GenShiftFactor ||
				type == SimuRunType.LineOutageDistFactor || type == SimuRunType.PowerTransferDistFactor)
			menu_run_dclf(type, graphView, graph, doc);
		else if (type == SimuRunType.Aclf)
			menu_run_aclf(graphView, graph, doc);
		else if (type == SimuRunType.Acsc)
			menu_run_acsc(graphView, graph, doc);
		else if (type == SimuRunType.DStab)
			menu_run_dstab(graphView, graph, doc);
		else if (type == SimuRunType.Scripts)
			menu_run_scripting(graphView, graph, doc);
	}

	private static void menu_run_dclf(SimuRunType type, boolean graphView, JGraph graph, IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		
		IGFormContainer gFormContainer = null ;
		if (graphView) {
			gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		
		IpssLogger.getLogger().info("Run " + type.toString() + " analysis");
		SimuRunWorker worker = new SimuRunWorker("Dclf SimuRunWorker");
		worker.configRun(type, simuCtx, graph);
		worker.start();
		appSimuCtx.setLastRunType(type);
	}
	
	private static void menu_run_aclf(boolean graphView, JGraph graph, IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		
		IGFormContainer gFormContainer = null ;
		if (graphView) {
			gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		simuCtx.setLoadflowAlgorithm(CoreSpringAppContext.getLoadflowAlgorithm());

		try {
			ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_Aclf);
			dialog.init(gFormContainer, appSimuCtx);
			if (dialog.isReturnOk()) {
				SimuRunWorker worker = new SimuRunWorker("Aclf SimuRunWorker");
				worker.configRun(SimuRunType.Aclf, simuCtx, graph);
				worker.start();
				appSimuCtx.setLastRunType(SimuRunType.Aclf);
			}
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showMsgDialog("Error", "See log file for details\n" + e.toString());
		}
	}

	private static void menu_run_acsc(boolean graphView, JGraph graph, IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		IGFormContainer gFormContainer = null;
		if (graphView) {
			gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		simuCtx.setLoadflowAlgorithm(CoreSpringAppContext.getLoadflowAlgorithm());
		simuCtx.setSimpleFaultAlgorithm(CoreSpringAppContext.getSimpleFaultAlgorithm());
 
		try {
			ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_Acsc);
			dialog.init(gFormContainer, appSimuCtx);
			if (dialog.isReturnOk()) {
				SimuRunWorker worker = new SimuRunWorker("Acsc SimuRunWorker");
				worker.configRun(SimuRunType.Acsc, simuCtx, graph);
				worker.start();
				appSimuCtx.setLastRunType(SimuRunType.Acsc);
			}
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getIpssMsgHub().sendErrorMsg("See log file for details\n" + e.toString());
		}
	}

	private static void menu_run_dstab(boolean graphView, JGraph graph, IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		IGFormContainer gFormContainer = null;
		if (graphView) {
			gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		simuCtx.setLoadflowAlgorithm(CoreSpringAppContext.getLoadflowAlgorithm());
		simuCtx.setDynSimuAlgorithm(DStabSpringAppContext.getDynamicSimuAlgorithm());

		ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_DStab);
    	IpssTextFile file = ProjectScriptFileUtil.getProjectScriptFile(doc, ProjectScriptFileUtil.DStabOutputScriptFilename);
    	dialog.setDStabOutputScriptFilename(file.getFilePathName());
		dialog.init(gFormContainer, appSimuCtx);
    	if (dialog.isReturnOk()) {
			SimuRunWorker worker = new SimuRunWorker("DStab SimuRunWorker");
			worker.configRun(SimuRunType.DStab, simuCtx);
			worker.start();
			appSimuCtx.setLastRunType(SimuRunType.DStab);
		}	
	}
	
	private static void menu_run_scripting(boolean graphView, JGraph graph, IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		IGFormContainer gFormContainer = null;
		if (graphView) {
			gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
			IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
			if (!mapper.mapping(gFormContainer, simuCtx, GFormContainer.class)) 
				return;
			appSimuCtx.setSimuNetDataDirty(false);
		}
		
		IpssLogger.getLogger().info("Run Scripts");
		ICaseInfoDialog dialog = SimuAppSpringAppCtxUtil.getCaseInfoDialog(CaseData.CaseType_Scripts);
		dialog.init(gFormContainer, appSimuCtx);
    	if (dialog.isReturnOk()) {
			SimuRunWorker worker = new SimuRunWorker("Scripting SimuRunWorker");
			IpssDBCase caseData = appSimuCtx.getCaseData(appSimuCtx.getProjData().getScriptsCaseName(), CaseData.CaseType_Scripts);
			worker.configRun(SimuRunType.Scripts, simuCtx, caseData.getScripts(), caseData.getScriptLanguageType());
			worker.start();
			appSimuCtx.setLastRunType(SimuRunType.DStab);
		}	
	}

	public static void menu_report_current(IpssEditorDocument doc) {
		String type = IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
		if (doc instanceof GPDocument) {
			IGNetForm form = ((GPDocument) doc).getGFormContainer()
					.getGNetForm();
			type = ReportUtil.getDefaultReportType(form, doc
					.getSimuAppContext().getLastRunType(), doc
					.getSimuAppContext().isNonSymmetricFault());
		}
		doc.getGraphpad().expendTree2Object(doc);

		displayReport(doc, type);
	}

	public static void menu_report_aclfSummary(IpssEditorDocument doc) {
		displayReport(doc, IpssReportFactory.RPT_TYPE_ACLFSUMMARY);
	}

	public static void menu_report_aclfIeeeBusStype(IpssEditorDocument doc) {
		displayReport(doc, IpssReportFactory.RPT_TYPE_ACLFBUSSTYLE);
	}

	public static void menu_report_acscSymmetric(IpssEditorDocument doc) {
		displayReport(doc, IpssReportFactory.RPT_TYPE_ACSC3PFAULT);
	}

	public static void menu_report_acscNonSymmetric(IpssEditorDocument doc) {
		displayReport(doc, IpssReportFactory.RPT_TYPE_ACSCNSFAULT);
	}

	public static void menu_report_dstabRun(IpssEditorDocument doc) {
	}
	
	public static void menu_output_dstabcurve(IpssEditorDocument doc) {
		DStabPlotSelectionDialog dialog = new DStabPlotSelectionDialog(GraphSpringAppContext.getIpssGraphicEditor().getFrame(), true);
    	IpssTextFile file = ProjectScriptFileUtil.getProjectScriptFile(doc, ProjectScriptFileUtil.DStabPlotScriptFilename);
    	dialog.init((SimuContext)doc.getSimuAppContext().getSimuCtx(), doc.getSimuAppContext().getDbSimuCaseId(), 
				    	file==null?null:file.getFilePathName());
	}
	public static void menu_report_save(IpssEditorDocument doc) {
	}

	public static void menu_report_saveAs(IpssEditorDocument doc) {
		if (doc instanceof IpssReportDocument) {
			IpssReportDocument rptDoc = (IpssReportDocument) doc;
			rptDoc.getMainViewer().saveActionPerformed();
		} else {
			IpssLogger.getLogger().severe(
					"Programming error, doc is not a IpssReportDocument");
		}
	}

	public static void menu_report_export(IpssEditorDocument doc) {
		if (doc instanceof IpssReportDocument) {
			IpssReportDocument rptDoc = (IpssReportDocument) doc;
			rptDoc.getMainViewer().exportActionPerformed();
		} else {
			IpssLogger.getLogger().severe(
					"Programming error, doc is not a IpssReportDocument");
		}
	}

	private static void displayReport(IpssEditorDocument doc, String type) {
		IpssProjectItem item = doc.getGraphpad().getCurrentProjectItem();
		String name = item.getProject().getProjectPath()
		+ System.getProperty("file.separator") +ReportUtil.getReportName(type, item.getFileNameNoExt());
		IpssProjectItem rptItem = doc.getGraphpad().newReportDocument(name,
				item, type, true);

		String filename = rptItem.getName();

		Utilities.delFile(filename);

		((IpssReportDocument) rptItem.getDocument()).getMainViewer().save(
				new File(filename));
	}
}
