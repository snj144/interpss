/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.interpss.model.editor.doc.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.model.editor.doc.docPackage
 * @generated
 */
public class docAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static docPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public docAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = docPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected docSwitch<Adapter> modelSwitch =
		new docSwitch<Adapter>() {
			@Override
			public Adapter caseIpssDocument(IpssDocument object) {
				return createIpssDocumentAdapter();
			}
			@Override
			public <TViewer> Adapter caseIpssEditorDocument(IpssEditorDocument<TViewer> object) {
				return createIpssEditorDocumentAdapter();
			}
			@Override
			public <TEditor, TViewer> Adapter caseIpssEditableDocument(IpssEditableDocument<TEditor, TViewer> object) {
				return createIpssEditableDocumentAdapter();
			}
			@Override
			public <TViewer> Adapter caseIpssReportDocument(IpssReportDocument<TViewer> object) {
				return createIpssReportDocumentAdapter();
			}
			@Override
			public <TViewer> Adapter caseIpssDBDocument(IpssDBDocument<TViewer> object) {
				return createIpssDBDocumentAdapter();
			}
			@Override
			public <TEditor, TViewer> Adapter caseIpssTextDocument(IpssTextDocument<TEditor, TViewer> object) {
				return createIpssTextDocumentAdapter();
			}
			@Override
			public <TSimuCtx, TEditor, TViewer> Adapter caseIpssSimuDocument(IpssSimuDocument<TSimuCtx, TEditor, TViewer> object) {
				return createIpssSimuDocumentAdapter();
			}
			@Override
			public <TAppSimuCtx, TEditor, TViewer> Adapter caseIpssJGraphDocument(IpssJGraphDocument<TAppSimuCtx, TEditor, TViewer> object) {
				return createIpssJGraphDocumentAdapter();
			}
			@Override
			public <TAppSimuCtx, TEditor, TViewer> Adapter caseIpssCustomDocument(IpssCustomDocument<TAppSimuCtx, TEditor, TViewer> object) {
				return createIpssCustomDocumentAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssDocument <em>Ipss Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssDocument
	 * @generated
	 */
	public Adapter createIpssDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssEditorDocument <em>Ipss Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssEditorDocument
	 * @generated
	 */
	public Adapter createIpssEditorDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssEditableDocument <em>Ipss Editable Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssEditableDocument
	 * @generated
	 */
	public Adapter createIpssEditableDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssReportDocument <em>Ipss Report Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssReportDocument
	 * @generated
	 */
	public Adapter createIpssReportDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssDBDocument <em>Ipss DB Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssDBDocument
	 * @generated
	 */
	public Adapter createIpssDBDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssTextDocument <em>Ipss Text Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssTextDocument
	 * @generated
	 */
	public Adapter createIpssTextDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssSimuDocument <em>Ipss Simu Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssSimuDocument
	 * @generated
	 */
	public Adapter createIpssSimuDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssJGraphDocument <em>Ipss JGraph Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssJGraphDocument
	 * @generated
	 */
	public Adapter createIpssJGraphDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.model.editor.doc.IpssCustomDocument <em>Ipss Custom Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.model.editor.doc.IpssCustomDocument
	 * @generated
	 */
	public Adapter createIpssCustomDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //docAdapterFactory
