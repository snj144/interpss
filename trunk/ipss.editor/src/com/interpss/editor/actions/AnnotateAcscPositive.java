package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.coreframework.IpssAbstractGraphAction;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.ui.SimuActionAdapter;
import com.interpss.editor.util.DocumentUtilFunc;

public class AnnotateAcscPositive extends IpssAbstractGraphAction {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		SimuActionAdapter.menu_annotate_acscPositive(getCurrentGraph());
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAcscDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
	
}
