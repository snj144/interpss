package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.SimuRunEnum;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.util.DocumentUtilFunc;
import org.interpss.editor.util.RunUtilFunc;

public class RunDStab extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		RunUtilFunc.performRunAction(getCurrentDocument(), SimuRunEnum.DStab, graphpad);
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isDStabDocument(doc));
	}
	
}
