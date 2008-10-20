package com.interpss.wb.opencim.xmlnavigator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMDocument;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;

public class Helper {

	public static IFile getFile(String delta) {
		IResource res = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(delta));

		return res instanceof IFile ? (IFile) res : null;
	}

	/**
	 * 
	 * @param file
	 *            the file to get the model for
	 * @return the file's XMLModel
	 */
	public static IDOMModel getModelForResource(IFile file) {
		IStructuredModel model = null;
		IModelManager manager = StructuredModelManager.getModelManager();

		try {
			model = manager.getModelForRead(file);
			// TODO.. HTML validator tries again to get a model a 2nd way
		} catch (Exception e) {
			e.printStackTrace();
		}

		IDOMModel result = model instanceof IDOMModel ? (IDOMModel) model : null;

		return result;
	}

	public static boolean containOpenCIMNamespace(IFile resource) {
		IDOMModel xmlModel = getModelForResource(resource);

		if (xmlModel != null) {
			IDOMDocument document = xmlModel.getDocument();

			if (document != null) {
				String uri = document.getDocumentElement().getNamespaceURI();
				xmlModel.releaseFromRead();
				if (uri != null && uri.equals(Constants.OPENCIM_NAMESPACE)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void enableOpenCIMNamespace(IFile resource) {
		IDOMModel xmlModel = getModelForResource(resource);

		if (xmlModel != null) {
			IDOMDocument document = xmlModel.getDocument();

			if (document != null) {
				document.getDocumentElement().setAttribute("xmlns", Constants.OPENCIM_NAMESPACE);
				try {
					xmlModel.save();
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
				xmlModel.releaseFromRead();
			}
		}

	}

	public static void refreshXML(CommonViewer commonViewer) {
		IStructuredSelection ssel = null;

		INavigatorContentService contentService;

		contentService = commonViewer.getNavigatorContentService();

		commonViewer.getControl().setRedraw(false);

		ISelection selection = commonViewer.getSelection();
		if (selection instanceof IStructuredSelection)
			ssel = (IStructuredSelection) selection;

		// get active ids
		String[] ids = contentService.getVisibleExtensionIds();
		List checkedExtensions = new ArrayList();
		for (int i = 0; i < ids.length; i++) {

			boolean enabled = contentService.getActivationService().isNavigatorExtensionActive(ids[i]);
			if (enabled) {
				checkedExtensions.add(ids[i]);
			}
		}
		if (checkedExtensions.size() != 0) {
			ids = (String[]) checkedExtensions.toArray(new String[checkedExtensions.size()]);
		}
		// end

		contentService.getActivationService().activateExtensions(ids, true);
		contentService.getActivationService().persistExtensionActivations();

		Object[] expandedElements = commonViewer.getExpandedElements();

		contentService.update();

		commonViewer.getControl().setRedraw(true);
		commonViewer.refresh();

		Object[] originalObjects = ssel.toArray();

		commonViewer.setExpandedElements(expandedElements);

		IStructuredSelection newSelection = new StructuredSelection(originalObjects);
		commonViewer.setSelection(newSelection, true);

	}

	public static CommonViewer getProjectExplorerView() {
		CommonNavigator navigator = getProjectExplorerNavigator();
		if (navigator != null) {
			return navigator.getCommonViewer();
		}
		return null;
	}

	public static CommonNavigator getProjectExplorerNavigator() {
		IViewPart part = null;
		try {
			part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(Constants.PROJECT_EXPLOER_VIEW_ID, null,
					IWorkbenchPage.VIEW_VISIBLE);

			if (part != null && part instanceof CommonNavigator) {
				CommonNavigator navigator = (CommonNavigator) part;
				return navigator;
			} else {
				return null;

			}
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
