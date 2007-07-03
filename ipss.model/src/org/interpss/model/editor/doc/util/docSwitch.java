/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.interpss.model.editor.doc.*;

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
 * @see org.interpss.model.editor.doc.docPackage
 * @generated
 */
public class docSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static docPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public docSwitch() {
		if (modelPackage == null) {
			modelPackage = docPackage.eINSTANCE;
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
			case docPackage.IPSS_DOCUMENT: {
				IpssDocument ipssDocument = (IpssDocument)theEObject;
				T result = caseIpssDocument(ipssDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_EDITOR_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssEditorDocument<?> ipssEditorDocument = (IpssEditorDocument<?>)theEObject;
				T result = caseIpssEditorDocument(ipssEditorDocument);
				if (result == null) result = caseIpssDocument(ipssEditorDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_EDITABLE_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssEditableDocument<?, ?> ipssEditableDocument = (IpssEditableDocument<?, ?>)theEObject;
				T result = caseIpssEditableDocument(ipssEditableDocument);
				if (result == null) result = caseIpssEditorDocument(ipssEditableDocument);
				if (result == null) result = caseIpssDocument(ipssEditableDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_REPORT_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssReportDocument<?> ipssReportDocument = (IpssReportDocument<?>)theEObject;
				T result = caseIpssReportDocument(ipssReportDocument);
				if (result == null) result = caseIpssEditorDocument(ipssReportDocument);
				if (result == null) result = caseIpssDocument(ipssReportDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_DB_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssDBDocument<?> ipssDBDocument = (IpssDBDocument<?>)theEObject;
				T result = caseIpssDBDocument(ipssDBDocument);
				if (result == null) result = caseIpssEditorDocument(ipssDBDocument);
				if (result == null) result = caseIpssDocument(ipssDBDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_TEXT_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssTextDocument<?, ?> ipssTextDocument = (IpssTextDocument<?, ?>)theEObject;
				T result = caseIpssTextDocument(ipssTextDocument);
				if (result == null) result = caseIpssEditableDocument(ipssTextDocument);
				if (result == null) result = caseIpssEditorDocument(ipssTextDocument);
				if (result == null) result = caseIpssDocument(ipssTextDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_SIMU_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssSimuDocument<?, ?, ?> ipssSimuDocument = (IpssSimuDocument<?, ?, ?>)theEObject;
				T result = caseIpssSimuDocument(ipssSimuDocument);
				if (result == null) result = caseIpssEditableDocument(ipssSimuDocument);
				if (result == null) result = caseIpssEditorDocument(ipssSimuDocument);
				if (result == null) result = caseIpssDocument(ipssSimuDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_JGRAPH_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssJGraphDocument<?, ?, ?> ipssJGraphDocument = (IpssJGraphDocument<?, ?, ?>)theEObject;
				T result = caseIpssJGraphDocument(ipssJGraphDocument);
				if (result == null) result = caseIpssSimuDocument(ipssJGraphDocument);
				if (result == null) result = caseIpssEditableDocument(ipssJGraphDocument);
				if (result == null) result = caseIpssEditorDocument(ipssJGraphDocument);
				if (result == null) result = caseIpssDocument(ipssJGraphDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case docPackage.IPSS_CUSTOM_DOCUMENT: {
				@SuppressWarnings("unchecked") IpssCustomDocument<?, ?, ?> ipssCustomDocument = (IpssCustomDocument<?, ?, ?>)theEObject;
				T result = caseIpssCustomDocument(ipssCustomDocument);
				if (result == null) result = caseIpssSimuDocument(ipssCustomDocument);
				if (result == null) result = caseIpssEditableDocument(ipssCustomDocument);
				if (result == null) result = caseIpssEditorDocument(ipssCustomDocument);
				if (result == null) result = caseIpssDocument(ipssCustomDocument);
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
	public <TViewer> T caseIpssEditorDocument(IpssEditorDocument<TViewer> object) {
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
	public <TEditor, TViewer> T caseIpssEditableDocument(IpssEditableDocument<TEditor, TViewer> object) {
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
	public <TViewer> T caseIpssReportDocument(IpssReportDocument<TViewer> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss DB Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss DB Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <TViewer> T caseIpssDBDocument(IpssDBDocument<TViewer> object) {
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
	public <TEditor, TViewer> T caseIpssTextDocument(IpssTextDocument<TEditor, TViewer> object) {
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
	public <TSimuCtx, TEditor, TViewer> T caseIpssSimuDocument(IpssSimuDocument<TSimuCtx, TEditor, TViewer> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss JGraph Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss JGraph Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <TAppSimuCtx, TEditor, TViewer> T caseIpssJGraphDocument(IpssJGraphDocument<TAppSimuCtx, TEditor, TViewer> object) {
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
	public <TAppSimuCtx, TEditor, TViewer> T caseIpssCustomDocument(IpssCustomDocument<TAppSimuCtx, TEditor, TViewer> object) {
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

} //docSwitch
