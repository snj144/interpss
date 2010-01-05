/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenFactory.java,v 1.1 2007/03/02 14:01:12 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.gen.GenPackage
 * @generated
 */
public interface GenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenFactory eINSTANCE = org.opencim.cim.iec61970.gen.impl.GenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generation Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generation Version</em>'.
	 * @generated
	 */
	GenerationVersion createGenerationVersion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenPackage getGenPackage();

} //GenFactory
