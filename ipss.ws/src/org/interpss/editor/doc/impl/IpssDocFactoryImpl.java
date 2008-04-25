/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.impl;

import javax.swing.JComponent;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.interpss.editor.doc.*;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;

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
			case IpssDocPackage.IPSS_SIMU_DOCUMENT: return createIpssSimuDocument();
			case IpssDocPackage.IPSS_CUSTOM_DOCUMENT: return createIpssCustomDocument();
			case IpssDocPackage.IPSS_GRAPHIC_DOCUMENT: return createIpssGraphicDocument();
			case IpssDocPackage.IPSS_REPORT_DOCUMENT: return createIpssReportDocument();
			case IpssDocPackage.IPSS_TEXT_DOCUMENT: return createIpssTextDocument();
			case IpssDocPackage.IPSS_XML_DOCUMENT: return createIpssXmlDocument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case IpssDocPackage.APP_SIMU_CONTEXT:
				return createAppSimuContextFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case IpssDocPackage.APP_SIMU_CONTEXT:
				return convertAppSimuContextToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public IpssTextDocument createIpssTextDocument() {
		IpssTextDocumentImpl ipssTextDocument = new IpssTextDocumentImpl();
		return ipssTextDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssXmlDocument createIpssXmlDocument() {
		IpssXmlDocumentImpl ipssXmlDocument = new IpssXmlDocumentImpl();
		return ipssXmlDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAppSimuContext createAppSimuContextFromString(EDataType eDataType, String initialValue) {
		return (IAppSimuContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAppSimuContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
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
