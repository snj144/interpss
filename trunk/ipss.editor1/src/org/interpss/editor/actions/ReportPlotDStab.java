package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.ui.EditorActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;


public class ReportPlotDStab extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
   
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		EditorActionAdapter.menu_output_dstabcurve(getCurrentDocument());
		graphpad.update();
	}

	public void update() {
		boolean update = DocumentUtilFunc.enableDStabReport(getCurrentDocument());
		setEnabled(update && getCurrentDocument().getSimuAppContext().hasLastRun()); 
	}
	
}
