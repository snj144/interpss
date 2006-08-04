package com.interpss.editor.ui;

import java.io.File;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.coreframework.IpssReportDocument;
import com.interpss.editor.doc.IpssProjectItem;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.report.ReportUtil;
import com.interpss.report.IpssReportFactory;


public class EditorActionAdapter {
	public static void menu_report_current(IpssEditorDocument doc) {
		String type = IpssReportFactory.RPT_TYPE_ACLFSUMMARY;
		if (doc instanceof GPDocument) {
			IGNetForm form = ((GPDocument)doc).getGFormContainer().getGNetForm();		
			type = ReportUtil.getDefaultReportType(form);
		}
		IpssProjectItem item = doc.getGraphpad().getCurrentProjectItem();
		String name = ReportUtil.getDefaultReportName(type, item.getFileNameNoExt());
		// first create the report file 
		IpssReportDocument rptDoc = doc.getGraphpad().newReportDocument(name, item, type, true);
		// then save the report file
		rptDoc.getMainViewer().save(new File(rptDoc.getFileName()));
	}

	public static void menu_report_aclfSummary(IpssEditorDocument doc) {
		IpssProjectItem item = doc.getGraphpad().getCurrentProjectItem();
		String name = ReportUtil.getReportName(IpssReportFactory.RPT_TYPE_ACLFSUMMARY, item.getFileNameNoExt());
		doc.getGraphpad().newReportDocument(name, item,	IpssReportFactory.RPT_TYPE_ACLFSUMMARY, false);
	}

	public static void menu_report_aclfIeeeBusStype(IpssEditorDocument doc) {
		IpssProjectItem item = doc.getGraphpad().getCurrentProjectItem();
		String name = ReportUtil.getReportName(IpssReportFactory.RPT_TYPE_ACLFSUMMARY, item.getFileNameNoExt());
		doc.getGraphpad().newReportDocument(name, item,	IpssReportFactory.RPT_TYPE_ACLFBUSSTYLE, false);
	}

	public static void menu_report_acscSymmetric(IpssEditorDocument doc) {
	}

	public static void menu_report_acscNonSymmetric(IpssEditorDocument doc) {
	}

	public static void menu_report_dstabRun(IpssEditorDocument doc) {
	}

	public static void menu_report_save(IpssEditorDocument doc) {
	}

	public static void menu_report_saveAs(IpssEditorDocument doc) {
		if (doc instanceof IpssReportDocument) {
			IpssReportDocument rptDoc = (IpssReportDocument)doc;
			rptDoc.getMainViewer().saveActionPerformed();
		} else {
			IpssLogger.getLogger().severe("Programming error, doc is not a IpssReportDocument");
		}
	}

	public static void menu_report_export(IpssEditorDocument doc) {
		if (doc instanceof IpssReportDocument) {
			IpssReportDocument rptDoc = (IpssReportDocument)doc;
			rptDoc.getMainViewer().exportActionPerformed();
		} else {
			IpssLogger.getLogger().severe("Programming error, doc is not a IpssReportDocument");
		}
	}
}
