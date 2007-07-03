/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.interpss.model.editor.doc.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class docFactoryImpl extends EFactoryImpl implements docFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static docFactory init() {
		try {
			docFactory thedocFactory = (docFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.interpss.org/editor/document"); 
			if (thedocFactory != null) {
				return thedocFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new docFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public docFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case docPackage.IPSS_DOCUMENT: return createIpssDocument();
			case docPackage.IPSS_EDITOR_DOCUMENT: return createIpssEditorDocument();
			case docPackage.IPSS_EDITABLE_DOCUMENT: return createIpssEditableDocument();
			case docPackage.IPSS_REPORT_DOCUMENT: return createIpssReportDocument();
			case docPackage.IPSS_DB_DOCUMENT: return createIpssDBDocument();
			case docPackage.IPSS_TEXT_DOCUMENT: return createIpssTextDocument();
			case docPackage.IPSS_SIMU_DOCUMENT: return createIpssSimuDocument();
			case docPackage.IPSS_JGRAPH_DOCUMENT: return createIpssJGraphDocument();
			case docPackage.IPSS_CUSTOM_DOCUMENT: return createIpssCustomDocument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocument createIpssDocument() {
		IpssDocumentImpl ipssDocument = new IpssDocumentImpl();
		return ipssDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TViewer> IpssEditorDocument<TViewer> createIpssEditorDocument() {
		IpssEditorDocumentImpl<TViewer> ipssEditorDocument = new IpssEditorDocumentImpl<TViewer>();
		return ipssEditorDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TEditor, TViewer> IpssEditableDocument<TEditor, TViewer> createIpssEditableDocument() {
		IpssEditableDocumentImpl<TEditor, TViewer> ipssEditableDocument = new IpssEditableDocumentImpl<TEditor, TViewer>();
		return ipssEditableDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TViewer> IpssReportDocument<TViewer> createIpssReportDocument() {
		IpssReportDocumentImpl<TViewer> ipssReportDocument = new IpssReportDocumentImpl<TViewer>();
		return ipssReportDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TViewer> IpssDBDocument<TViewer> createIpssDBDocument() {
		IpssDBDocumentImpl<TViewer> ipssDBDocument = new IpssDBDocumentImpl<TViewer>();
		return ipssDBDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TEditor, TViewer> IpssTextDocument<TEditor, TViewer> createIpssTextDocument() {
		IpssTextDocumentImpl<TEditor, TViewer> ipssTextDocument = new IpssTextDocumentImpl<TEditor, TViewer>();
		return ipssTextDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TSimuCtx, TEditor, TViewer> IpssSimuDocument<TSimuCtx, TEditor, TViewer> createIpssSimuDocument() {
		IpssSimuDocumentImpl<TSimuCtx, TEditor, TViewer> ipssSimuDocument = new IpssSimuDocumentImpl<TSimuCtx, TEditor, TViewer>();
		return ipssSimuDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TAppSimuCtx, TEditor, TViewer> IpssJGraphDocument<TAppSimuCtx, TEditor, TViewer> createIpssJGraphDocument() {
		IpssJGraphDocumentImpl<TAppSimuCtx, TEditor, TViewer> ipssJGraphDocument = new IpssJGraphDocumentImpl<TAppSimuCtx, TEditor, TViewer>();
		return ipssJGraphDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TAppSimuCtx, TEditor, TViewer> IpssCustomDocument<TAppSimuCtx, TEditor, TViewer> createIpssCustomDocument() {
		IpssCustomDocumentImpl<TAppSimuCtx, TEditor, TViewer> ipssCustomDocument = new IpssCustomDocumentImpl<TAppSimuCtx, TEditor, TViewer>();
		return ipssCustomDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public docPackage getdocPackage() {
		return (docPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static docPackage getPackage() {
		return docPackage.eINSTANCE;
	}

} //docFactoryImpl
