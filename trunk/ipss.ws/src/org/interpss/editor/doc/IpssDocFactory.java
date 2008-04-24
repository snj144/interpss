/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.editor.doc.IpssDocPackage
 * @generated
 */
public interface IpssDocFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IpssDocFactory eINSTANCE = org.interpss.editor.doc.impl.IpssDocFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ipss Simu Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Simu Document</em>'.
	 * @generated
	 */
	IpssSimuDocument createIpssSimuDocument();

	/**
	 * Returns a new object of class '<em>Ipss Custom Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Custom Document</em>'.
	 * @generated
	 */
	IpssCustomDocument createIpssCustomDocument();

	/**
	 * Returns a new object of class '<em>Ipss Graphic Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Graphic Document</em>'.
	 * @generated
	 */
	IpssGraphicDocument createIpssGraphicDocument();

	/**
	 * Returns a new object of class '<em>Ipss Report Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Report Document</em>'.
	 * @generated
	 */
	IpssReportDocument createIpssReportDocument();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IpssDocPackage getIpssDocPackage();

} //IpssDocFactory
