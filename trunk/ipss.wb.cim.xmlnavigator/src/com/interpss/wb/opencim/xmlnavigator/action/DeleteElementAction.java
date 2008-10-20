package com.interpss.wb.opencim.xmlnavigator.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.wst.sse.core.internal.provisional.IndexedRegion;
import org.eclipse.wst.xml.core.internal.document.ElementImpl;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.w3c.dom.Node;

import com.interpss.wb.opencim.xmlnavigator.Helper;

public class DeleteElementAction extends ActionDelegate {
	private IWorkbenchPage page;

	private ElementImpl data;

	private ISelectionProvider provider;

	private IStructuredSelection selection = StructuredSelection.EMPTY;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionDelegate#selectionChanged(org.eclipse.jface
	 * .action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection sel) {
		if (sel instanceof IStructuredSelection) {
			selection = (IStructuredSelection) sel;
			if (!selection.isEmpty()) {
				IStructuredSelection sSelection = (IStructuredSelection) selection;
				if (sSelection.size() == 1 && sSelection.getFirstElement() instanceof ElementImpl) {
					data = ((ElementImpl) sSelection.getFirstElement());
				}
			}
		} else
			selection = StructuredSelection.EMPTY;
	}

	public void run(IAction action) {
		try {

			IDOMModel domModel = data.getModel();
			String uri = domModel.getBaseLocation();
			IFile file = Helper.getFile(uri);
			IDOMModel model = Helper.getModelForResource(file);

			int offset = data.getStartOffset();
			IndexedRegion region = model.getIndexedRegion(offset);

			if (region instanceof Node) {
				Node node = (Node) region;
				node.getParentNode().removeChild(node);
				model.save();
			}

			model.releaseFromRead();
			domModel.releaseFromRead();

		} catch (PartInitException e) {

			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Opening Property", //$NON-NLS-1$
					"Could not open property!"); //$NON-NLS-1$
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
