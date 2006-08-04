package com.interpss.editor.report;

import com.interpss.common.datatype.Constants;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.app.IAppStatus;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.resources.Translator;
import com.interpss.report.IpssReportFactory;

public class ReportUtil {
	public static void displayReport(String rptType) {
		// Mike 12/25/05
		/*
		 * start the busy indicator
		 */
		IAppStatus appStatus = GraphSpringAppContext.getIpssGraphicEditor().getAppStatus();
		appStatus.busyStart(Constants.StatusBusyIndicatorPeriod, "Editor is displaying report ...", "");

		//GraphSpringAppContext.getIpssGraphicEditor().setEditPanel(IAppSimuContext.VIEW_TYPE_REPORT);
		/*
		 * This needs to be changed for multiple reports

		    IpssRptViewer viewer = new IpssRptViewer();
		    viewer.loadReport(IpssReportFactory.createReport(rptType, 
				GraphSpringAppContext.getIpssGraphicEditor().getVersion()));
		    then add the viewer(JPanel) to the main screen		
		    also the viewer should be part of your report document
		 *   
		 */
		IpssRptViewer.getDefault().loadReport(IpssReportFactory.createReport(rptType, 
				GraphSpringAppContext.getIpssGraphicEditor().getVersion()));

		/*
		 * stop the busy indicator
		 */
		appStatus.busyStop("Report displayed");
	}

	public static void displayExistingReport(String filename) {
		//GraphSpringAppContext.getIpssGraphicEditor().setEditPanel(IAppSimuContext.VIEW_TYPE_REPORT);
		IpssRptViewer.getDefault().loadReport(filename);
	}
	
	public static void closeReportView() {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		//GraphSpringAppContext.getIpssGraphicEditor().setEditPanel(project.getViewType());
	}
	
	public static String getDefaultReportType(IGNetForm form) {
		if (form.getAppType().equals(IGNetForm.AppType_Distribution)) {
			return IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
		} else {
			if (form.getNetType().equals(IGNetForm.NetType_AclfNetwork)
					|| form.getNetType().equals(
							IGNetForm.NetType_AclfAdjNetwork)) {
				return IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
			} else if (form.getNetType().equals(IGNetForm.NetType_AcscNetwork)) {
				return IpssReportFactory.RPT_TYPE_ACSCFAULT;
			}
		}
		return IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
	}

	public static String getDefaultReportName(String type, String projectName) {
		String name = "unknown";
		if (type.equals(IpssReportFactory.RPT_TYPE_ACLFSUMMARY)) {
			name = Translator.getString("Report.DefaultName.Aclf");
		} 
		else if (type.equals(IpssReportFactory.RPT_TYPE_ACSCFAULT)) {
			name = Translator.getString("Report.DefaultName.Acsc");
		} 
		return name+"_"+projectName+Translator.getString("ReportFileExtension");
		
	}

	public static String getReportName(String type, String projectName) {
		String name = "unknown";
		if (type.equals(IpssReportFactory.RPT_TYPE_ACLFSUMMARY)) {
			name = Translator.getString("Report.Name.AclfSummary");
		} 
		else if (type.equals(IpssReportFactory.RPT_TYPE_ACLFBUSSTYLE)) {
			name = Translator.getString("Report.Name.AclfIeeeBusStyle");
		} 
		return name+"_"+projectName+Translator.getString("ReportFileExtension");
	}
}
