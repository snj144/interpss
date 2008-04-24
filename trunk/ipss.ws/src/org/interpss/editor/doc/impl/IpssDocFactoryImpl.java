/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.interpss.editor.doc.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IpssDocFactoryImpl extends EFactoryImpl implements IpssDocFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IpssDocFactory init() {
		try {
			IpssDocFactory theIpssDocFactory = (IpssDocFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/interpss/editor/doc"); 
			if (theIpssDocFactory != null) {
				return theIpssDocFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IpssDocFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocFactoryImpl() {
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
			case IpssDocPackage.IPSS_DOCUMENT: return createIpssDocument();
			case IpssDocPackage.IPSS_DOCUMENT_ITEM: return createIpssDocumentItem();
			case IpssDocPackage.IPSS_EDITOR_DOCUMENT: return createIpssEditorDocument();
			case IpssDocPackage.IPSS_EDITABLE_DOCUMENT: return createIpssEditableDocument();
			case IpssDocPackage.IPSS_SIMU_DOCUMENT: return createIpssSimuDocument();
			case IpssDocPackage.IPSS_CUSTOM_DOCUMENT: return createIpssCustomDocument();
			case IpssDocPackage.IPSS_GRAPHIC_DOCUMENT: return createIpssGraphicDocument();
			case IpssDocPackage.IPSS_REPORT_DOCUMENT: return createIpssReportDocument();
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
	public IpssDocumentItem createIpssDocumentItem() {
		IpssDocumentItemImpl ipssDocumentItem = new IpssDocumentItemImpl();
		return ipssDocumentItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssEditorDocument createIpssEditorDocument() {
		IpssEditorDocumentImpl ipssEditorDocument = new IpssEditorDocumentImpl();
		return ipssEditorDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssEditableDocument createIpssEditableDocument() {
		IpssEditableDocumentImpl ipssEditableDocument = new IpssEditableDocumentImpl();
		return ipssEditableDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssSimuDocument createIpssSimuDocument() {
		IpssSimuDocumentImpl ipssSimuDocument = new IpssSimuDocumentImpl();
		return ipssSimuDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssCustomDocument createIpssCustomDocument() {
		IpssCustomDocumentImpl ipssCustomDocument = new IpssCustomDocumentImpl();
		return ipssCustomDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssGraphicDocument createIpssGraphicDocument() {
		IpssGraphicDocumentImpl ipssGraphicDocument = new IpssGraphicDocumentImpl();
		return ipssGraphicDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssReportDocument createIpssReportDocument() {
		IpssReportDocumentImpl ipssReportDocument = new IpssReportDocumentImpl();
		return ipssReportDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocPackage getIpssDocPackage() {
		return (IpssDocPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IpssDocPackage getPackage() {
		return IpssDocPackage.eINSTANCE;
	}

} //IpssDocFactoryImpl
