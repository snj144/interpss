package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;


import com.interpss.editor.coreframework.IpssAbstractGraphAction;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class FileProjectRemoveItem extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		IpssProject project = graphpad.getCurrentProjectItem().getProject();

		int r = JOptionPane.showConfirmDialog(graphpad.getFrame(), Translator
				.getString("ItemDeleteDialog")
				+ "'" + graphpad.getCurrentProjectItem().getFileName() + "' ?",
				Translator.getString("Title"), JOptionPane.YES_NO_OPTION);

		if (r == JOptionPane.NO_OPTION) {
			return;
		} else if (r == JOptionPane.YES_OPTION) {
			graphpad.getCommand("FileProjectCloseItem").actionPerformed(e);

			String filename = graphpad.getCurrentProjectItem().getName();
			Utilities.delFile(filename);
			graphpad.getProjectPanel().removeProjectItem(
					graphpad.getCurrentProjectItem());
			graphpad.saveProject(project);
			graphpad.update();
		}
	}

	public void update() {
		if (graphpad.getCurrentProjectItem() == null)
			setEnabled(false);
		else
			setEnabled(true);
	}

}