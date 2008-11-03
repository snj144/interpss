package com.interpss.wb.opencim;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import au.com.langdale.cimtoole.project.Task;
import au.com.langdale.cimtoole.wizards.OptionalSchemaWizardPage;
import au.com.langdale.ui.builder.FurnishedWizard;

public class NewProjectWizard extends FurnishedWizard implements INewWizard {

	public NewProjectWizard() {
		setNeedsProgressMonitor(true);
	}

	private WizardNewProjectCreationPage projectPage = new WizardNewProjectCreationPage("projectPage") {
		
		@Override
		protected boolean validatePage() {
			if( !super.validatePage())
				return false;
			
			schema.setProject(projectPage.getProjectHandle());
			return true;
		}
	};
	
	private WizardNewFileCreationPage filePage = new WizardNewFileCreationPage("filePage", null) {
		
		@Override
		protected boolean validatePage() {
			if( !super.validatePage())
				return false;
			
			schema.setProject(projectPage.getProjectHandle());
			return true;
		}
	};
	
	private OptionalSchemaWizardPage schema = new OptionalSchemaWizardPage(); 

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		projectPage.setTitle("New CIMTool Project");
		projectPage.setDescription("Create a new CIMTool project and import a copy of the CIM.");

		schema.setTitle("Import Initial Schema");
		schema.setDescription("Import an XMI or OWL base schema.");

		filePage.setTitle("Import Initial Schema");
		filePage.setDescription("Import an XMI or OWL base schema.");
	}

	@Override
	public void addPages() {
		addPage(projectPage);
		//addPage(filePage);
		addPage(schema);
	}

	@Override
	public boolean performFinish() {
		IWorkspaceRunnable job =  Task.createProject(projectPage.getProjectHandle(), projectPage.useDefaults()? null: projectPage.getLocationURI());

		IFile schemaFile = schema.getFile();
		if( schemaFile != null )
			job = Task.chain( job, Task.importSchema(schemaFile, schema.getPathname(), schema.getNamespace()));

		return run( job, ResourcesPlugin.getWorkspace().getRoot());
	}
}
