package com.interpss.editor.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JOptionPane;


import com.interpss.editor.coreframework.IpssAbstractProjectAction;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class FileProjectRemove extends IpssAbstractProjectAction {
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssProject curproj = graphpad.getCurrentProject();
		
		
		int r = JOptionPane.showConfirmDialog(graphpad.getFrame(), 
				Translator.getString("ProjectDeleteDialog")+"'"
				+ curproj.getProjectName() + "' ?",
				Translator.getString("Title"),
				JOptionPane.YES_NO_OPTION);
		
		if (r == JOptionPane.NO_OPTION) {
			return ;
		}
		else if (r == JOptionPane.YES_OPTION) {
			graphpad.getCommand("FileProjectCloseAllOpenItem").actionPerformed(e);
			Utilities.deleteDir(new File(curproj.getProjectPath()));
			graphpad.getProjectPanel().removeProject(curproj);
			graphpad.update();
		}
		
		
	}

}
