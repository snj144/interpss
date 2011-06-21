package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.ui.SimuActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;

import com.interpss.common.SpringAppContext;

public class RunAcsc extends IpssAbstractActionDefault {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (graphpad.isBGProcessingBusy()) {
    		SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Simulation Thread Busy", 
			"The run-simulation thread is busy. Please wait for its finishing before starting another one.");
			return;
		}	

		IpssEditorDocument doc = getCurrentDocument();
		if (doc instanceof GPDocument) {
			SimuActionAdapter.menu_run_acsc(true, graphpad.getCurrentGraph());
		}

		// After a run, some menuitems may need to be enabled
		graphpad.update();
	}

	@Override
	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAcscDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
}