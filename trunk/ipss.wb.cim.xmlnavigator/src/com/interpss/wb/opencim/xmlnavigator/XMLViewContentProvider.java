package com.interpss.wb.opencim.xmlnavigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.wst.sse.ui.internal.editor.EditorModelUtil;
import org.eclipse.wst.xml.core.internal.document.DocumentImpl;
import org.eclipse.wst.xml.core.internal.document.ElementImpl;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.eclipse.wst.xml.ui.internal.contentoutline.JFaceNodeContentProvider;

public class XMLViewContentProvider extends JFaceNodeContentProvider implements IResourceChangeListener, IResourceDeltaVisitor {
	private static StructuredViewer viewer;

	private static final Object[] NO_CHILDREN = new Object[0];

	public XMLViewContentProvider() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IDOMModel model = Helper.getModelForResource((IFile) parentElement);
			EditorModelUtil.addFactoriesTo(model);
			DocumentImpl ss = (DocumentImpl) model.getDocument();
			// ignore the first element
			Object firstElement = getElementImplFromObjectArray(getChildren(ss))[0];
			model.releaseFromRead();

			if (firstElement != null) {
				return getElementImplFromObjectArray(super.getChildren(firstElement));
			}

		}
		return getElementImplFromObjectArray(super.getChildren(parentElement));
	}

	public Object getParent(Object element) {
		if (element instanceof IFile)
			return ((IResource) element).getParent();
		return super.getParent(element);
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IFile) {
			IDOMModel model = Helper.getModelForResource((IFile) element);
			EditorModelUtil.addFactoriesTo(model);
			DocumentImpl ss = (DocumentImpl) model.getDocument();
			model.releaseFromRead();
			return super.hasChildren(ss);
		}
		return super.hasChildren(element);
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
		super.dispose();
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

	public void inputChanged(Viewer aViewer, Object oldInput, Object newInput) {
		viewer = (StructuredViewer) aViewer;
	}

	public void resourceChanged(IResourceChangeEvent event) {
		try {
			IResourceDelta delta = event.getDelta();
			delta.accept(this);
		} catch (CoreException e) {
			System.out.println("Resource Changed Fail - " + e.toString());
		}
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource changedResource = delta.getResource();
		if (changedResource.getType() == IResource.FILE && changedResource.getFileExtension().equals("xml")) {
			final IFile file = (IFile) changedResource;

			CommonViewer viewer = Helper.getProjectExplorerView();
			if (null != viewer) {
				Helper.refreshXML((CommonViewer) viewer);
			}
			return false;
		}
		return true;
	}

	public Object[] getElementImplFromObjectArray(Object[] objs) {
		List list = new ArrayList();
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] instanceof ElementImpl) {
				list.add(objs[i]);
			}
		}
		return list.toArray();
	}
}
