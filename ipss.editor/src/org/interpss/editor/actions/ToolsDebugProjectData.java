package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ui.SimuActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;

public class ToolsDebugProjectData extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IAppSimuContext appSimuContext = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		SimuActionAdapter.menu_tools_debug_projDataInfo(appSimuContext);
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isSimuDocument(doc));
	}
}
