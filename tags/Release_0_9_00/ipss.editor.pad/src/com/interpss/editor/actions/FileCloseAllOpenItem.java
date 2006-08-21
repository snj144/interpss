package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssEditorDocument;

public class FileCloseAllOpenItem extends IpssAbstractActionDefault {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		IpssEditorDocument[] docs = graphpad.getAllDocuments();
		if ((docs != null))
			for (int i = 0; i < docs.length; i++) {
				graphpad.closeDocument(docs[i]);
			}
		graphpad.update();
	}

	public void update() {
		if (graphpad.getAllDocuments() == null)
			setEnabled(false);
		else
			setEnabled(true);
	}
	
}