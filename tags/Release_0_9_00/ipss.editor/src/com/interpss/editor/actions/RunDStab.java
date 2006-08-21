package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.common.SpringAppContext;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractGraphAction;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.ui.SimuActionAdapter;
import com.interpss.editor.util.DocumentUtilFunc;

public class RunDStab extends IpssAbstractGraphAction {
    
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
			SimuActionAdapter.menu_run_dstab(true, graphpad.getCurrentGraph());
		}

		// After a run, some menuitems may need to be enabled
		graphpad.update();
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isDStabDocument(doc));
	}
	
}
