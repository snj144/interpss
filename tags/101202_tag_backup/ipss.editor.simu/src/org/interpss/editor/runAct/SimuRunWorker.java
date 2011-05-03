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

import org.interpss.display.DclfOutFunc;
import org.interpss.editor.EditorSimuSpringCtx;
import org.interpss.editor.graph.GraphSimuUtilFunc;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.app.IAppStatus;
import org.interpss.editor.runAct.ui.DStabRunForm;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.editor.ui.util.CoreScriptUtilFunc;
import org.interpss.editor.ui.util.ScriptJavacUtilFunc;
import org.jgraph.JGraph;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.ScriptLanguageType;
import com.interpss.common.datatype.SimuRunType;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.MemoryJavaCompiler;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;

public class SimuRunWorker extends Thread {
	private SimuRunType runType = SimuRunType.Aclf;
	private SimuContext simuCtx = null;
	private JGraph graph = null;
	private String scripts = null;
	private ScriptLanguageType scriptLanguage = ScriptLanguageType.Java;
	private String pluginName = "";

	public SimuRunWorker(String str) {
		super(str);
	}

	public void configRun(SimuRunType aRunType, SimuContext aCtx) {
		this.runType = aRunType;
		this.simuCtx = aCtx;
	}

	public void configRun(SimuRunType aRunType, SimuContext aCtx, JGraph aGraph) {
		this.runType = aRunType;
		this.simuCtx = aCtx;
		this.graph = aGraph;
	}

	public void configRun(SimuRunType aRunType, SimuContext aCtx,
			String scripts, ScriptLanguageType lanType, String pluginName) {
		this.runType = aRunType;
		this.simuCtx = aCtx;
		this.scripts = scripts;
		this.scriptLanguage = lanType;
		this.pluginName = pluginName;
	}

	public void run() {
		IAppStatus appStatus = GraphSpringAppContext.getIpssGraphicEditor().getAppStatus();
		IAppSimuContext appSimuCtx = null;
		try {
			appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		} catch (Exception ex) {
			IpssLogger.logErr(ex);
			return;
		}
		
		if (this.runType == SimuRunType.Aclf) {
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run AC Loadflow Analysis ...", "Run Aclf");
			IpssLogger.getLogger().info("SimuRunWorker starts Run AC Loadflow");

			boolean converge = EditorSimuSpringCtx.getAclfRunForm()
					.runCase(simuCtx, simuCtx.getMsgHub());
			appSimuCtx.setLfConverged(converge);

			appStatus.busyStop("Run AC Loadflow Analysis finished");

			if (graph != null) {
				GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph,
						GraphSimuUtilFunc.LABEL_ACT_ACLF);
			}
		} else if (this.runType == SimuRunType.Acsc) {
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run AC Short Circuit Analysis ...", "Run Acsc");
			IpssLogger.getLogger().info(
					"SimuRunWorker starts Run AC Short Circuit");

			EditorSimuSpringCtx.getAcscRunForm().runCase(simuCtx,
					simuCtx.getMsgHub());

			appStatus.busyStop("Run AC Short Circuit Analysis finished");

			EditorSimuSpringCtx.getAcscRunForm().displaySummaryResult(
					simuCtx);
			if (graph != null) {
				GraphSimuUtilFunc.refreshCellLabel(simuCtx, graph,
						GraphSimuUtilFunc.LABEL_ACT_ACSC_POSITIVE);
			}
		} else if (this.runType == SimuRunType.DStab) {
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run Transient Stability Simulation ...", "Run DStab");
			IpssLogger.getLogger().info("SimuRunWorker starts Run Transient Stability");

			DStabRunForm runForm = EditorSimuSpringCtx.getDStabRunForm();
			if (runForm.getXmlGridData() != null && runForm.getXmlGridData().getEnableGridRun())
				runForm.runGridCase(simuCtx, simuCtx.getMsgHub());
			else
				runForm.runCase(simuCtx, simuCtx.getMsgHub());

			appStatus.busyStop("Run Transient Stability Simulation finished");
		} else if (this.runType == SimuRunType.Scripts) {
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run Scripts ...", "Run Scripts");
			IpssLogger.getLogger().info("SimuRunWorker starts Run Scripts");

			// System.out.println("Run Scripts: " + this.scripts);
			// compile the source code
			if (this.scriptLanguage == ScriptLanguageType.Java) {
				String classname = ScriptJavacUtilFunc
						.createScriptingClassname(CoreScriptUtilFunc.RunScriptsClass);
				String javacode = CoreScriptUtilFunc.parseRunCaseJavaCode(
						this.scripts, classname);
				try {
					ISimuCaseRunner runner = (ISimuCaseRunner) MemoryJavaCompiler
							.javac(CoreScriptUtilFunc.RunCaseScriptingPackageName
											+ "/" + classname, javacode);
					// run the custom scripts
					if (runner.runCase(simuCtx, simuCtx.getMsgHub()))
						runner.displaySummaryResult(simuCtx);
				} catch (Exception e) {
					IpssLogger.logErr(e);
				}
			} 
			else if (this.scriptLanguage == ScriptLanguageType.Xml) {
				XmlScriptRunWorker.runCase(this.scripts, simuCtx);
			}
			else if (this.scriptLanguage == ScriptLanguageType.Custom) {
				CustomScriptRunWorker.runCase(this.scripts, this.pluginName, simuCtx);
			}
			appStatus.busyStop("Run Scripts finished");
		}
		else if (this.runType == SimuRunType.Dclf) {
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run DC Loadflow Analysis ...", "Run Dclf");
			IpssLogger.getLogger().info("SimuRunWorker starts Run DC Loadflow");

			AclfNetwork net = simuCtx.getAclfNet();
			// create DCLoadflow Algorithm object
			DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(net, simuCtx.getMsgHub());
			// run DCLoadflow to calculate bus voltage angle
			if (!algo.checkCondition())
				return;
			algo.calculateDclf();

			IOutputTextDialog dialog = UISpringAppContext
					.getOutputTextDialog("DC Loadflow Analysis Info");
			dialog.display(DclfOutFunc.dclfResults(algo));

			appStatus.busyStop("Run DC Loadflow Analysis finished");
		}
		else if (this.runType == SimuRunType.SenAnalysis) {
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run Sensitivity Analysis ...", "Run SenAnalysis");
			IpssLogger.getLogger().info("SimuRunWorker starts Run Sensitivity Analysis");

			EditorSimuSpringCtx.getDclfRunForm().runCase(simuCtx, simuCtx.getMsgHub());

			appStatus.busyStop("Run AC Loadflow Analysis finished");
		}
	}
}