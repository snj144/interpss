package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.doc.IpssDocument;
import com.interpss.editor.doc.IpssProjectItem;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.util.DocumentUtilFunc;

public class EditProjectData extends IpssAbstractActionDefault {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssLogger.getLogger().info("Starting Editing Project Data and launch Dialog");
		IpssProjectItem item = graphpad.getCurrentProjectItem();
		if ((item == null) || (!item.isMain()) || (!item.isLoaded()))
			return;
		
		IpssDocument doc = item.getDocument();
		if (doc instanceof GPDocument)
		{
			GraphSpringAppContext.getEditorDialog(null, ((GPDocument)doc).getGraph());
			doc.getProjData().setDirty(true);
			doc.setModified(true);
		}
	}
	
	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isGraphicDocument(doc));
	}
}
