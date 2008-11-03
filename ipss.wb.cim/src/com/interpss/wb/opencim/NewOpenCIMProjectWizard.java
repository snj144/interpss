package com.interpss.wb.opencim;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.undo.CreateFolderOperation;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.StatusUtil;
import org.eclipse.ui.internal.wizards.newresource.ResourceMessages;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class NewOpenCIMProjectWizard extends Wizard implements INewWizard {
	private IWorkbench workbench;

	private IProject newProject;
	
	private WizardNewProjectCreationPage projectPage;
	private WizardNewFileCreationPage filePage;

	public NewOpenCIMProjectWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	// public boolean performFinish() {
	//
	// String filePath = null;
	// // if (page.useDefaults()) {
	// // filePath = page.getLocationPath().toString() + "/" +
	// // page.getProjectName() + "/";
	// // } else {
	// // filePath = page.getLocationPath().toString() + "/";
	// // }
	// System.out.println(page.getLocationPath().toString() + "/" +
	// page.getProjectName() + "/");
	// new File(page.getLocationPath().toString() + "/" + page.getProjectName()
	// + "/").mkdirs();
	//
	// return true;
	// }
	public boolean performFinish() {
		createNewProject();

		if (newProject == null) {
			return false;
		}

		// IWorkingSet[] workingSets = mainPage.getSelectedWorkingSets();
		// getWorkbench().getWorkingSetManager().addToWorkingSets(newProject,
		// workingSets);

		// updatePerspective();
		BasicNewResourceWizard.selectAndReveal(newProject, workbench.getActiveWorkbenchWindow());
		return true;
	}

	// public boolean performFinish() {
	// try {
	// WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
	// protected void execute(IProgressMonitor monitor) {
	// createProject(monitor != null ? monitor : new NullProgressMonitor());
	// }
	// };
	// getContainer().run(false, true, op);
	// } catch (InvocationTargetException x) {
	// reportError(x);
	// return false;
	// } catch (InterruptedException x) {
	// reportError(x);
	// return false;
	// }
	// return true;
	// }

	private IProject createNewProject() {
		if (newProject != null) {
			return newProject;
		}

		// get a project handle
		final IProject newProjectHandle = projectPage.getProjectHandle();

		// get a project descriptor
		URI location = null;
		if (!projectPage.useDefaults()) {
			location = projectPage.getLocationURI();
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);

		// create the new project operation
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				CreateProjectOperation op = new CreateProjectOperation(description, MessageUtil.getString("opencim.newprojectwizard.WindowTitle"));
				try {
					PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute(op, monitor,
							WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (ExecutionException e) {
					throw new InvocationTargetException(e);
				}
			}
		};

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			if (t instanceof ExecutionException && t.getCause() instanceof CoreException) {
				CoreException cause = (CoreException) t.getCause();
				StatusAdapter status;
				if (cause.getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
					status = new StatusAdapter(StatusUtil.newStatus(IStatus.WARNING, NLS.bind(ResourceMessages.NewProject_caseVariantExistsError,
							newProjectHandle.getName()), cause));
				} else {
					status = new StatusAdapter(StatusUtil.newStatus(cause.getStatus().getSeverity(), ResourceMessages.NewProject_errorMessage, cause));
				}
				status.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, ResourceMessages.NewProject_errorMessage);
				StatusManager.getManager().handle(status, StatusManager.BLOCK);
			} else {
				StatusAdapter status = new StatusAdapter(new Status(IStatus.WARNING, IDEWorkbenchPlugin.IDE_WORKBENCH, 0, NLS.bind(
						ResourceMessages.NewProject_internalError, t.getMessage()), t));
				status.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, ResourceMessages.NewProject_errorMessage);
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
			}
			return null;
		}

		newProject = newProjectHandle;
		
		final IPath projPath = newProject.getFullPath();
		
		IPath newFolderPath = projPath.append("data");
		final IFolder newFolderHandle = ResourcesPlugin.getWorkspace().getRoot().getFolder(newFolderPath);
		
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				CreateFolderOperation op = new CreateFolderOperation(newFolderHandle, null, "???");
				try {
					PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute(op, monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (final ExecutionException e) {
					getContainer().getShell().getDisplay().syncExec(new Runnable() {
						public void run() {
							if (e.getCause() instanceof CoreException) {
								//ErrorDialog.openError(getContainer().getShell(), Messages.NewFolderWizard_folderCreationErrorDialog_title, null, ((CoreException) e.getCause()).getStatus());
							} else {
								//log(getClass(), "createNewFolder()", e.getCause()); //$NON-NLS-1$
								//MessageDialog.openError(getContainer().getShell(), Messages.NewFolderWizard_folderCreationErrorDialog_title, e.getCause().getMessage());
							}
						}
					});
				}
			}
		};
		try {
			getContainer().run(true, true, runnable);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			// Execution Exceptions are handled above but we may still get
			// unexpected runtime errors.
			//log(getClass(), "createNewFolder()", e.getTargetException()); //$NON-NLS-1$
			//MessageDialog.openError(getContainer().getShell(), Messages.NewFolderWizard_folderCreationErrorDialog_title, e.getTargetException().getMessage());
			return null;
		}

		

		return newProject;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		setNeedsProgressMonitor(true);
		setWindowTitle(MessageUtil.getString("opencim.newprojectwizard.WindowTitle"));
	}

	@Override
	public void addPages() {
		//super.addPages();
		projectPage = new WizardNewProjectCreationPage(MessageUtil.getString("opencim.newprojectwizard.WindowTitle")) {
			@Override
			protected boolean validatePage() {
				if( !super.validatePage())
					return false;
				//selectFile.setProject(newProject.getProjectHandle());
				return true;
			}
			@Override
			public IWizardPage getNextPage() {
				return filePage;
			}
			/*
			@Override
			public boolean canFlipToNextPage() {
				return validatePage();
			}
			@Override
			public boolean isPageComplete() {
				return false;
			}
			*/	
		};
		projectPage.setTitle(MessageUtil.getString("opencim.newprojectwizard.PageTitle"));
		projectPage.setDescription(MessageUtil.getString("opencim.newprojectwizard.PageDescription"));
		this.addPage(projectPage);

		filePage = new WizardNewFileCreationPage("newFile", null) {
			@Override
			protected boolean validatePage() {
				if( !super.validatePage())
					return false;
				//selectFile.setProject(newProject.getProjectHandle());
				return true;
			}
			@Override
			public IWizardPage getPreviousPage() {
				return projectPage;
			}			
		};
		filePage.setTitle(MessageUtil.getString("opencim.newprojectwizard.PageTitle"));
		filePage.setDescription(MessageUtil.getString("opencim.newprojectwizard.PageDescription"));
		//this.addPage(filePage);
	}
}
