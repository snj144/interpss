package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.ui.EditorActionAdapter;
import com.interpss.editor.util.DocumentUtilFunc;

public class ReportAcscNonSymmetric extends IpssAbstractActionDefault {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		EditorActionAdapter.menu_report_acscNonSymmetric(getCurrentDocument());
		graphpad.saveProject(graphpad.getCurrentProject());
		graphpad.update();
	}

	public void update() {
		boolean update = DocumentUtilFunc.enableAcscReport(getCurrentDocument());
		setEnabled(update  && getCurrentDocument().getSimuAppContext().hasLastRun()
						   && getCurrentDocument().getSimuAppContext().isNonSymmetricFault());		
	}
	
}
