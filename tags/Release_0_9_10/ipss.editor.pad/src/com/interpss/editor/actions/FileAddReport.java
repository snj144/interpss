package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.GPGraphpadFile;
import com.interpss.editor.coreframework.IpssAbstractProjectAction;
import com.interpss.editor.coreframework.IpssCustomFile;
import com.interpss.editor.coreframework.IpssReportFile;
import com.interpss.editor.coreframework.IpssTextFile;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.project.IpssNewCustomDialog;
import com.interpss.editor.project.IpssNewReportDialog;
import com.interpss.editor.project.IpssNewTextDialog;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class FileAddReport extends IpssAbstractProjectAction {

	public void actionPerformed(ActionEvent e) {
		// Richard, this part needs re-implmented, see my notes in Notes.txt
/*
		String defaultname = Translator.getString("NewReport");
		
		IpssProject project = graphpad.getCurrentProject();
		
		IpssNewReportDialog editor = new IpssNewReportDialog(graphpad, project.getProjectName()+" - "+defaultname);
		editor.init(project,defaultname);
		
		if (editor.isCancelExit()) return;
		
		if (editor.isNewFile()){
			if (graphpad.getProjectPanel().isProjectSelected())
				graphpad.newReportDocument(editor.getFileName(), project);
			else
				graphpad.newReportDocument(editor.getFileName(), graphpad.getCurrentProjectItem());
			graphpad.getCommand("FileSave").actionPerformed(e);
		}
		else
		{
			IpssReportFile file = editor.getFile();
			if (file==null){
				graphpad.error("Target Report is error.");
				return;	
			}
			
			String dstfile= editor.getFileName();
			if (!Utilities.copy(editor.getSrcFileName(),dstfile)) 
			{
				graphpad.error("Can't create report.");
				return;
			}

			if (graphpad.getProjectPanel().isProjectSelected())
				graphpad.loadReportDocument(dstfile, project, file);
			else
				graphpad.loadReportDocument(dstfile, graphpad.getCurrentProjectItem(), file);
			
		}
		graphpad.saveProject(project);
		graphpad.update();
		*/
	}
	
	public void update() {
		if (graphpad.getCurrentProject() == null)
			setEnabled(false);
		else if (graphpad.getProjectPanel().isReportAddable())
			setEnabled(true);
		else
			setEnabled(false);
	}
	
}
