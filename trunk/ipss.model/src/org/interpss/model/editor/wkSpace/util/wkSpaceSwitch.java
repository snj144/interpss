/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.interpss.model.editor.wkSpace.*;

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
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage
 * @generated
 */
public class wkSpaceSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static wkSpacePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public wkSpaceSwitch() {
		if (modelPackage == null) {
			modelPackage = wkSpacePackage.eINSTANCE;
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
			case wkSpacePackage.WORKSPACE_ITEM: {
				WorkspaceItem workspaceItem = (WorkspaceItem)theEObject;
				T result = caseWorkspaceItem(workspaceItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER: {
				WorkspaceItemContainer workspaceItemContainer = (WorkspaceItemContainer)theEObject;
				T result = caseWorkspaceItemContainer(workspaceItemContainer);
				if (result == null) result = caseWorkspaceItem(workspaceItemContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case wkSpacePackage.IPSS_PROJECT_ITEM: {
				IpssProjectItem ipssProjectItem = (IpssProjectItem)theEObject;
				T result = caseIpssProjectItem(ipssProjectItem);
				if (result == null) result = caseWorkspaceItem(ipssProjectItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case wkSpacePackage.IPSS_WORKSPACE: {
				IpssWorkspace ipssWorkspace = (IpssWorkspace)theEObject;
				T result = caseIpssWorkspace(ipssWorkspace);
				if (result == null) result = caseWorkspaceItemContainer(ipssWorkspace);
				if (result == null) result = caseWorkspaceItem(ipssWorkspace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case wkSpacePackage.IPSS_PROJECT_FOLDER: {
				IpssProjectFolder ipssProjectFolder = (IpssProjectFolder)theEObject;
				T result = caseIpssProjectFolder(ipssProjectFolder);
				if (result == null) result = caseWorkspaceItemContainer(ipssProjectFolder);
				if (result == null) result = caseWorkspaceItem(ipssProjectFolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case wkSpacePackage.IPSS_PROJECT: {
				IpssProject ipssProject = (IpssProject)theEObject;
				T result = caseIpssProject(ipssProject);
				if (result == null) result = caseWorkspaceItemContainer(ipssProject);
				if (result == null) result = caseWorkspaceItem(ipssProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case wkSpacePackage.IPSS_PROJECT_ITEM_GROUP: {
				IpssProjectItemGroup ipssProjectItemGroup = (IpssProjectItemGroup)theEObject;
				T result = caseIpssProjectItemGroup(ipssProjectItemGroup);
				if (result == null) result = caseWorkspaceItemContainer(ipssProjectItemGroup);
				if (result == null) result = caseWorkspaceItem(ipssProjectItemGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workspace Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workspace Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkspaceItem(WorkspaceItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workspace Item Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workspace Item Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkspaceItemContainer(WorkspaceItemContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProjectItem(IpssProjectItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Workspace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Workspace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssWorkspace(IpssWorkspace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProjectFolder(IpssProjectFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProject(IpssProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project Item Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project Item Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProjectItemGroup(IpssProjectItemGroup object) {
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

} //wkSpaceSwitch
