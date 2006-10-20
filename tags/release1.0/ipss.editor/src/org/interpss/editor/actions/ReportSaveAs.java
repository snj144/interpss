package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.ui.EditorActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;


public class ReportSaveAs extends IpssAbstractActionDefault {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		EditorActionAdapter.menu_report_saveAs(getCurrentDocument());
	}

	public void update() {
		boolean update = DocumentUtilFunc.isReportDocument(getCurrentDocument());
		setEnabled(update);
	}
}
