package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.ui.SimuActionAdapter;

import com.interpss.editor.coreframework.IpssAbstractGraphAction;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.util.DocumentUtilFunc;

public class AnnotateAcscZero extends IpssAbstractGraphAction {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		SimuActionAdapter.menu_annotate_acscZero(getCurrentGraph());
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAcscDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
	
}
