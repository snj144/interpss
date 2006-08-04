package com.interpss.editor.actions;

import java.awt.event.ActionEvent;


import com.interpss.editor.coreframework.IpssAbstractProjectAction;
import com.interpss.editor.coreframework.IpssCustomFile;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.project.IpssNewCustomDialog;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class FileAddCustom extends IpssAbstractProjectAction {
	public void actionPerformed(ActionEvent e) {

		String defaultname = Translator.getString("NewCustomData");
		
		IpssProject project = graphpad.getCurrentProject();
		
		IpssNewCustomDialog editor = new IpssNewCustomDialog(graphpad, project.getProjectName()+" - "+defaultname);
		editor.init(project,defaultname);
		
		if (editor.isCancelExit()) return;
		
		
		String fileName = editor.getSrcFileName();
		
		if (fileName==null){
			graphpad.error("Target Data file is error.");
			return;	
		}
		
		String dstfile= editor.getFileName();
		if (!Utilities.copy(editor.getSrcFileName(),dstfile)) 
		{
			graphpad.error("Can't create Data file.");
			return;
		}
		
		
		IpssCustomFile file;
		try {
			file = com.interpss.editor.util.Utilities.OpenCustomFile(graphpad,dstfile);
			graphpad.addCustomDocument(dstfile,project, file);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		graphpad.saveProject(project);
		graphpad.update();
	}
	public void update() {
		if (graphpad.getCurrentProject() == null)
			setEnabled(false);
		else if (graphpad.getProjectPanel().isProjectSelected())
			setEnabled(true);
		else
			setEnabled(false);
	}
}
