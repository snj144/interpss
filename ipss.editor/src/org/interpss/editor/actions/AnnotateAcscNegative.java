package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.ui.SimuActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;


public class AnnotateAcscNegative extends IpssAbstractGraphAction {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		SimuActionAdapter.menu_annotate_acscNegative(getCurrentGraph());
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAcscDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
	
}
