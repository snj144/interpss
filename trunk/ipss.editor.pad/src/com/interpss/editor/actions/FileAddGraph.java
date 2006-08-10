package com.interpss.editor.actions;

import java.awt.event.ActionEvent;


import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.GPGraphpadFile;
import com.interpss.editor.coreframework.IpssAbstractProjectAction;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.project.IpssNewGraphDialog;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class FileAddGraph extends IpssAbstractProjectAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		String defaultname = Translator.getString("NewGraph");
		
		IpssProject project = graphpad.getCurrentProject();
		
		IpssNewGraphDialog editor = new IpssNewGraphDialog(graphpad, project.getProjectName()+" - "+defaultname);
		editor.init(project,defaultname);
		
		if (editor.isCancelExit()) return;
		
		if (editor.isNewFile()){
			graphpad.addGraphDocument(editor.getFileName(), project);
			((GPDocument)getCurrentDocument()).getProjData().setFilepath(editor.getFileName());
			GraphSpringAppContext.getEditorDialog(null, ((GPDocument)getCurrentDocument()).getGraph());
			getCurrentDocument().getProjData().setDirty(true);
			graphpad.getCommand("FileSave").actionPerformed(e);
		}
		else
		{
			GPGraphpadFile file = editor.getFile();
			if (file==null){
				graphpad.error("Target graphic document is error.");
				return;	
			}
			
			String dstfile= editor.getFileName();
			if (!Utilities.copy(editor.getSrcFileName(),dstfile)) 
			{
				graphpad.error("Can't create graphic document.");
				return;
			}
			graphpad.addGraphDocument(dstfile,project, file);
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
