/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.editor.ws.IpssWsPackage
 * @generated
 */
public interface IpssWsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IpssWsFactory eINSTANCE = org.interpss.editor.ws.impl.IpssWsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
	IpssWsItem createIpssWsItem();

	/**
	 * Returns a new object of class '<em>Item Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item Container</em>'.
	 * @generated
	 */
	IpssWsItemContainer createIpssWsItemContainer();

	/**
	 * Returns a new object of class '<em>Ipss Project Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project Item</em>'.
	 * @generated
	 */
	IpssProjectItem createIpssProjectItem();

	/**
	 * Returns a new object of class '<em>Ipss Work Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Work Space</em>'.
	 * @generated
	 */
	IpssWorkSpace createIpssWorkSpace();

	/**
	 * Returns a new object of class '<em>Ipss Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project</em>'.
	 * @generated
	 */
	IpssProject createIpssProject();

	/**
	 * Returns a new object of class '<em>Ipss Project Forlder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Project Forlder</em>'.
	 * @generated
	 */
	IpssProjectForlder createIpssProjectForlder();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IpssWsPackage getIpssWsPackage();

} //IpssWsFactory
