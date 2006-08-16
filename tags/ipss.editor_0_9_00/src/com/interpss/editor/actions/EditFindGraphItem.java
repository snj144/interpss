package com.interpss.editor.actions;

import java.awt.event.ActionEvent;


import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractGraphAction;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.doc.IpssDocument;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.edit.IElemSearchDialog;
import com.interpss.editor.util.DocumentUtilFunc;

public class EditFindGraphItem extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {


		IpssDocument doc = graphpad.getCurrentDocument();

		if (doc instanceof GPDocument)
		{
			IElemSearchDialog dialog = GraphSpringAppContext.getSearchDialog(GraphSpringAppContext.EditorType_FindDistObject, ((GPDocument)doc).getGraph());
			if (dialog.getSelectedObj() != null) {
				IpssLogger.getLogger().info("Find a Bus/Branch object and launch Bus/BranchEditorDialog");
				GraphSpringAppContext.getEditorDialog(dialog.getSelectedObj(), ((GPDocument)doc).getGraph());
			}
		}
	}
	
	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isGraphicDocument(doc));
	}
	
}