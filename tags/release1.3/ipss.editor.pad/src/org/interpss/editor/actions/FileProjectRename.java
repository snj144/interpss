package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.interpss.editor.coreframework.IpssAbstractProjectAction;
import org.interpss.editor.doc.IpssProject;
import org.interpss.editor.resources.Translator;
import org.interpss.editor.util.Utilities;



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
