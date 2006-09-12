package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.ui.EditorActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;


public class ReportCurrent extends IpssAbstractActionDefault {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		EditorActionAdapter.menu_report_current(getCurrentDocument());
		graphpad.saveProject(graphpad.getCurrentProject());
		graphpad.update();
	}

	public void update() {
		boolean update = DocumentUtilFunc.enableAclfReport(getCurrentDocument()) ||
					DocumentUtilFunc.enableAcscReport(getCurrentDocument()) ||
					DocumentUtilFunc.enableDStabReport(getCurrentDocument());
		setEnabled(update && getCurrentDocument().getSimuAppContext().hasLastRun()); 
	}
	
}
