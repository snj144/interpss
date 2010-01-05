/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage
 * @generated
 */
public interface wkSpaceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	wkSpaceFactory eINSTANCE = org.interpss.model.editor.wkSpace.impl.wkSpaceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Workspace Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace Item</em>'.
	 * @generated
	 */
	WorkspaceItem createWorkspaceItem();

	/**
	 * Returns a new object of class '<em>Workspace Item Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace Item Container</em>'.
	 * @generated
	 */
	WorkspaceItemContainer createWorkspaceItemContainer();

	/**
	 * Returns a new object of class '<em>Ipss Project Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project Item</em>'.
	 * @generated
	 */
	IpssProjectItem createIpssProjectItem();

	/**
	 * Returns a new object of class '<em>Ipss Workspace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Workspace</em>'.
	 * @generated
	 */
	IpssWorkspace createIpssWorkspace();

	/**
	 * Returns a new object of class '<em>Ipss Project Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project Folder</em>'.
	 * @generated
	 */
	IpssProjectFolder createIpssProjectFolder();

	/**
	 * Returns a new object of class '<em>Ipss Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project</em>'.
	 * @generated
	 */
	IpssProject createIpssProject();

	/**
	 * Returns a new object of class '<em>Ipss Project Item Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project Item Group</em>'.
	 * @generated
	 */
	IpssProjectItemGroup createIpssProjectItemGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	wkSpacePackage getwkSpacePackage();

} //wkSpaceFactory
