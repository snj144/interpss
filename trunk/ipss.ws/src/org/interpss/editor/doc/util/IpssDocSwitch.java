/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.util;

import java.util.List;

import javax.swing.JComponent;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.interpss.editor.doc.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.interpss.editor.doc.IpssDocPackage
 * @generated
 */
public class IpssDocSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IpssDocPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocSwitch() {
		if (modelPackage == null) {
			modelPackage = IpssDocPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IpssDocPackage.IPSS_DOCUMENT: {
				IpssDocument ipssDocument = (IpssDocument)theEObject;
				T result = caseIpssDocument(ipssDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_DOCUMENT_ITEM: {
				IpssDocumentItem ipssDocumentItem = (IpssDocumentItem)theEObject;
				T result = caseIpssDocumentItem(ipssDocumentItem);
				if (result == null) result = caseIpssDocument(ipssDocumentItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_EDITOR_DOCUMENT: {
				IpssEditorDocument ipssEditorDocument = (IpssEditorDocument)theEObject;
				T result = caseIpssEditorDocument(ipssEditorDocument);
				if (result == null) result = caseIpssDocumentItem(ipssEditorDocument);
				if (result == null) result = caseIpssDocument(ipssEditorDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_EDITABLE_DOCUMENT: {
				IpssEditableDocument ipssEditableDocument = (IpssEditableDocument)theEObject;
				T result = caseIpssEditableDocument(ipssEditableDocument);
				if (result == null) result = caseIpssEditorDocument(ipssEditableDocument);
				if (result == null) result = caseIpssDocumentItem(ipssEditableDocument);
				if (result == null) result = caseIpssDocument(ipssEditableDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_SIMU_DOCUMENT: {
				IpssSimuDocument ipssSimuDocument = (IpssSimuDocument)theEObject;
				T result = caseIpssSimuDocument(ipssSimuDocument);
				if (result == null) result = caseIpssEditableDocument(ipssSimuDocument);
				if (result == null) result = caseIpssEditorDocument(ipssSimuDocument);
				if (result == null) result = caseIpssDocumentItem(ipssSimuDocument);
				if (result == null) result = caseIpssDocument(ipssSimuDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_CUSTOM_DOCUMENT: {
				IpssCustomDocument ipssCustomDocument = (IpssCustomDocument)theEObject;
				T result = caseIpssCustomDocument(ipssCustomDocument);
				if (result == null) result = caseIpssSimuDocument(ipssCustomDocument);
				if (result == null) result = caseIpssEditableDocument(ipssCustomDocument);
				if (result == null) result = caseIpssEditorDocument(ipssCustomDocument);
				if (result == null) result = caseIpssDocumentItem(ipssCustomDocument);
				if (result == null) result = caseIpssDocument(ipssCustomDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_GRAPHIC_DOCUMENT: {
				IpssGraphicDocument ipssGraphicDocument = (IpssGraphicDocument)theEObject;
				T result = caseIpssGraphicDocument(ipssGraphicDocument);
				if (result == null) result = caseIpssSimuDocument(ipssGraphicDocument);
				if (result == null) result = caseIpssEditableDocument(ipssGraphicDocument);
				if (result == null) result = caseIpssEditorDocument(ipssGraphicDocument);
				if (result == null) result = caseIpssDocumentItem(ipssGraphicDocument);
				if (result == null) result = caseIpssDocument(ipssGraphicDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_REPORT_DOCUMENT: {
				IpssReportDocument ipssReportDocument = (IpssReportDocument)theEObject;
				T result = caseIpssReportDocument(ipssReportDocument);
				if (result == null) result = caseIpssEditorDocument(ipssReportDocument);
				if (result == null) result = caseIpssDocumentItem(ipssReportDocument);
				if (result == null) result = caseIpssDocument(ipssReportDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_TEXT_DOCUMENT: {
				IpssTextDocument ipssTextDocument = (IpssTextDocument)theEObject;
				T result = caseIpssTextDocument(ipssTextDocument);
				if (result == null) result = caseIpssEditableDocument(ipssTextDocument);
				if (result == null) result = caseIpssEditorDocument(ipssTextDocument);
				if (result == null) result = caseIpssDocumentItem(ipssTextDocument);
				if (result == null) result = caseIpssDocument(ipssTextDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssDocPackage.IPSS_XML_DOCUMENT: {
				IpssXmlDocument ipssXmlDocument = (IpssXmlDocument)theEObject;
				T result = caseIpssXmlDocument(ipssXmlDocument);
				if (result == null) result = caseIpssEditableDocument(ipssXmlDocument);
				if (result == null) result = caseIpssEditorDocument(ipssXmlDocument);
				if (result == null) result = caseIpssDocumentItem(ipssXmlDocument);
				if (result == null) result = caseIpssDocument(ipssXmlDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssDocument(IpssDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Document Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Document Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssDocumentItem(IpssDocumentItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Editor Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Editor Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssEditorDocument(IpssEditorDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Editable Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Editable Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssEditableDocument(IpssEditableDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Simu Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Simu Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssSimuDocument(IpssSimuDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Custom Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Custom Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssCustomDocument(IpssCustomDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Graphic Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Graphic Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssGraphicDocument(IpssGraphicDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Report Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Report Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssReportDocument(IpssReportDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Text Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Text Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssTextDocument(IpssTextDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Xml Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Xml Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssXmlDocument(IpssXmlDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //IpssDocSwitch
