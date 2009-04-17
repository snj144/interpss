package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.doc.IpssProject;
import org.interpss.editor.project.IpssNewProjectDialog;
import org.interpss.editor.resources.Translator;



public class FileNewProject extends IpssAbstractActionDefault {


	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssProject project = new IpssProject(null,null);
		IpssNewProjectDialog editor = new IpssNewProjectDialog(graphpad.getFrame(), Translator.getString("NewProject"));
		editor.init(project);

		if (editor.isCancelExit()) return;
		
		graphpad.addProject(project);
		graphpad.saveProject(project);
		graphpad.update();
		
//		
//		graphpad.getProjectPanel().showOpenItems(0);
//		graphpad.update();
//
		
	}
	/**
	 * Empty implementation. This Action should be available each time.
	 */
	public void update() {
	};

}
