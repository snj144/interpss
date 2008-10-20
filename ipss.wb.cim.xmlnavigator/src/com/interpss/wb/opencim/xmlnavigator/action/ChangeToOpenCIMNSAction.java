package com.interpss.wb.opencim.xmlnavigator.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.internal.ObjectPluginAction;

import com.interpss.wb.opencim.xmlnavigator.Helper;


public class ChangeToOpenCIMNSAction extends ActionDelegate implements
		IObjectActionDelegate {

	public void run(IAction action) {
		if (action instanceof ObjectPluginAction) {
			ObjectPluginAction action1 = (ObjectPluginAction) action;
			ISelection selection = action1.getSelection();

			if (selection instanceof TreeSelection) {
				TreeSelection treeSel = (TreeSelection) selection;
				Object obj = treeSel.getFirstElement();
				Helper.enableOpenCIMNamespace((IFile) obj);
			}
		}
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

}
