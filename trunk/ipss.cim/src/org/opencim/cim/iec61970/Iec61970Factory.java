/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iec61970Factory.java,v 1.1 2007/03/02 14:01:18 mzhou Exp $
 */
package org.opencim.cim.iec61970;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.Iec61970Package
 * @generated
 */
public interface Iec61970Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Iec61970Factory eINSTANCE = org.opencim.cim.iec61970.impl.Iec61970FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Iec61970Version createIec61970Version();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Iec61970Package getIec61970Package();

} //Iec61970Factory
