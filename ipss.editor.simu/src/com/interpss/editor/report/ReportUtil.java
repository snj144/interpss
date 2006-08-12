package com.interpss.editor.report;

import com.interpss.common.datatype.Constants;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppStatus;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.runAct.SimuRunWorker;
import com.interpss.report.IpssReportFactory;

public class ReportUtil {
	public static void displayReport(String rptType) {
		/*
		 * start the busy indicator
		 */
		IAppStatus appStatus = GraphSpringAppContext.getIpssGraphicEditor().getAppStatus();
		appStatus.busyStart(Constants.StatusBusyIndicatorPeriod, "Editor is displaying report ...", "");

		IpssRptViewer.getDefault().loadReport(IpssReportFactory.createReport(rptType, 
				GraphSpringAppContext.getIpssGraphicEditor().getVersion()));

		/*
		 * stop the busy indicator
		 */
		appStatus.busyStop("Report displayed");
	}

	public static String getDefaultReportType(IGNetForm form, int lastRunType) {
		if (form.getAppType().equals(IGNetForm.AppType_Distribution)) {
			if (lastRunType == SimuRunWorker.RUN_TYPE_ACSC)
				return IpssReportFactory.RPT_TYPE_ACSC3PFAULT;
			else if (lastRunType == SimuRunWorker.RUN_TYPE_ACLF)
				return IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
		} else {
			if (form.getNetType().equals(IGNetForm.NetType_AclfNetwork)
					|| form.getNetType().equals(
							IGNetForm.NetType_AclfAdjNetwork)) {
				return IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
			} else if (form.getNetType().equals(IGNetForm.NetType_AcscNetwork)) {
				return IpssReportFactory.RPT_TYPE_ACSC3PFAULT;
			}
		}
		return IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
	}

	public static String getReportName(String type, String projectName) {
		String name = "unknown";
		if (type.equals(IpssReportFactory.RPT_TYPE_ACLFSUMMARY)) {
			name = Translator.getString("Report.Name.AclfSummary");
		} 
		else if (type.equals(IpssReportFactory.RPT_TYPE_ACLFBUSSTYLE)) {
			name = Translator.getString("Report.Name.AclfIeeeBusStyle");
		} 
		else if (type.equals(IpssReportFactory.RPT_TYPE_ACSC3PFAULT)) {
			name = Translator.getString("Report.Name.Acsc3PFault");
		} 
		else if (type.equals(IpssReportFactory.RPT_TYPE_ACSCNSFAULT)) {
			name = Translator.getString("Report.Name.AcscNSFault");
		} 
		return name+"_"+projectName+Translator.getString("ReportFileExtension");
	}
}
