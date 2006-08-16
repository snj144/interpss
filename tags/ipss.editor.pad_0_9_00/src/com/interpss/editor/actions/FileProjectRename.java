package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;


import com.interpss.editor.coreframework.IpssAbstractProjectAction;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class FileProjectRename extends IpssAbstractProjectAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		IpssProject curproj = graphpad.getCurrentProject();
		String newname = JOptionPane.showInputDialog(Translator
				.getString("ProjectName"), curproj.getProjectName());

		if (newname == null)
			return;

		if (!newname.equals(curproj.getProjectName())) {
			if (!Utilities.renameFile(curproj.getProjectPath(), curproj
					.getParentPath()
					+ System.getProperty("file.separator") + newname)){
		        JOptionPane.showMessageDialog(this.getGraphpad().getFrame(),
			            "Project already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
		        return;
			}
		}
		curproj.setProjectName(newname);

	}

}
