package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.interpss.editor.doc.IpssProjectItem;
import org.interpss.editor.resources.Translator;
import org.interpss.editor.util.Utilities;



public class FileProjectItemRename extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		IpssProjectItem item = graphpad.getCurrentProjectItem();
		String newname = JOptionPane.showInputDialog(Translator
				.getString("ItemName"), item.getFileNameNoExt());

		if (newname == null)
			return;

		String fileext = item.getFileExt();
		String newFilePathName = item.getProject().getProjectPath()
				+ System.getProperty("file.separator") + newname + "."
				+ fileext;
		if (!newname.equals(item.getFileNameNoExt())) {
			if (!Utilities.renameFile(item.getName(), newFilePathName)){
		        JOptionPane.showMessageDialog(this.getGraphpad().getFrame(),
			            "File already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
		        return;
			}
		}

		graphpad.renameTabbedFrames(item, newFilePathName);

		item.setName(newFilePathName);
		graphpad.saveProject(item.getProject());
	}

	public void update() {
		if (graphpad.getCurrentProjectItem() == null)
			setEnabled(false);
		else
			setEnabled(true);
	}
}
