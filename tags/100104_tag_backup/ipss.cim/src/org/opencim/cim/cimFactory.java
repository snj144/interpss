/**
 * <copyright>
 * </copyright>
 *
 * $Id: cimFactory.java,v 1.2 2007/03/03 02:50:00 mzhou Exp $
 */
package org.opencim.cim;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.cimPackage
 * @generated
 */
public interface cimFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	cimFactory eINSTANCE = org.opencim.cim.impl.cimFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Combined Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Combined Version</em>'.
	 * @generated
	 */
	CombinedVersion createCombinedVersion();

	/**
	 * Returns a new object of class '<em>Simulation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Model</em>'.
	 * @generated
	 */
	SimulationModel createSimulationModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	cimPackage getcimPackage();

} //cimFactory
