package com.interpss.wb.opencim.xmlnavigator.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.wst.xml.core.internal.document.ElementImpl;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart;

import com.interpss.wb.opencim.xmlnavigator.Helper;

public class OpenElementAction extends Action {
	private IWorkbenchPage page;

	private ElementImpl data;

	private ISelectionProvider provider;

	/**
	 * Construct the OpenPropertyAction with the given page.
	 * 
	 * @param p
	 *            The page to use as context to open the editor.
	 * @param selectionProvider
	 *            The selection provider
	 */
	public OpenElementAction(IWorkbenchPage p, ISelectionProvider selectionProvider) {
		setText("Open Element"); //$NON-NLS-1$
		page = p;
		provider = selectionProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	public boolean isEnabled() {
		ISelection selection = provider.getSelection();
		if (!selection.isEmpty()) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			if (sSelection.size() == 1 && sSelection.getFirstElement() instanceof ElementImpl) {
				data = ((ElementImpl) sSelection.getFirstElement());
				return true;
			}
		}
		return false;
	}

	public void run() {
		try {
			if (isEnabled()) {

				IDOMModel domModel = data.getModel();
				String uri = domModel.getBaseLocation();

				IFile file = Helper.getFile(uri);

				IEditorPart editor = IDE.openEditor(page, file);

				XMLMultiPageEditorPart xmlEditor = (XMLMultiPageEditorPart) editor;
				TextEditor textEditor = (TextEditor) xmlEditor.getAdapter(TextEditor.class);

				int start = data.getStartOffset();
				int length = data.getLength();
				textEditor.selectAndReveal(data.getStartOffset(), data.getLength());
				textEditor.setHighlightRange(start, length, true);
			}
		} catch (PartInitException e) {

			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Opening Property", //$NON-NLS-1$
					"Could not open property!"); //$NON-NLS-1$
		}
	}
}
