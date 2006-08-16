package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.editor.ui.SimuActionAdapter;
import com.interpss.editor.util.DocumentUtilFunc;

public class ToolsDebugFormData extends IpssAbstractActionDefault {
    
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
