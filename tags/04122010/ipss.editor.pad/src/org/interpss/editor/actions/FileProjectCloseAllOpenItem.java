package org.interpss.editor.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.interpss.editor.coreframework.IpssAbstractProjectAction;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.doc.IpssDocument;
import org.interpss.editor.doc.IpssProject;



public class FileProjectCloseAllOpenItem extends IpssAbstractProjectAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		IpssProject curproj = graphpad.getCurrentProject();

		ArrayList<IpssDocument> projdocs = curproj.getAllOpenedDocuments();

		IpssEditorDocument[] docs = graphpad.getAllDocuments();
		if ((docs != null) && (projdocs.size() > 0))
			for (int i = 0; i < docs.length; i++) {
				if (projdocs.contains(docs[i])) {
					graphpad.closeDocument(docs[i]);
				}

			}
		graphpad.update();
	}

}