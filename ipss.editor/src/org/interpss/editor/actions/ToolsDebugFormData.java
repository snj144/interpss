package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.editor.ui.SimuActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;


public class ToolsDebugFormData extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssEditorDocument doc = getCurrentDocument();
		IGFormContainer gFormContainer = ((GPDocument) doc).getGFormContainer();
		SimuActionAdapter.menu_tools_debug_netDataInfo(gFormContainer);
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isSimuDocument(doc));
	}
}
