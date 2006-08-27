package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.ui.SimuActionAdapter;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.editor.util.DocumentUtilFunc;

public class ToolsDebugProjectData extends IpssAbstractActionDefault {
    
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
