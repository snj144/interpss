package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.interpss.editor.doc.IpssProject;
import org.interpss.editor.doc.IpssProjectItem;
import org.interpss.editor.resources.Translator;
import org.interpss.editor.util.Utilities;



public class FileProjectRemoveItem extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		IpssProjectItem currentProjectItem = graphpad.getCurrentProjectItem();
		IpssProject project = currentProjectItem.getProject();

		int r = JOptionPane.showConfirmDialog(graphpad.getFrame(), Translator
				.getString("ItemDeleteDialog")
				+ "'" + currentProjectItem.getFileName() + "' ?",
				Translator.getString("Title"), JOptionPane.YES_NO_OPTION);

		if (r == JOptionPane.NO_OPTION) {
			return;
		} else if (r == JOptionPane.YES_OPTION) {
			graphpad.getCommand("FileProjectCloseItem").actionPerformed(e);

			String filename = currentProjectItem.getName();
			Utilities.delFile(filename);
			graphpad.getProjectPanel().removeProjectItem(
					currentProjectItem);
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