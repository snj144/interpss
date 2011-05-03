package org.interpss.editor.ui;

import java.io.File;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.coreframework.IpssReportDocument;
import org.interpss.editor.doc.IpssProjectItem;
import org.interpss.editor.jgraph.ui.form.IGNetForm;
import org.interpss.editor.report.ReportUtil;
import org.interpss.editor.util.Utilities;
import org.interpss.report.IpssReportFactory;

import com.interpss.common.util.IpssLogger;

public class EditorActionAdapter {
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