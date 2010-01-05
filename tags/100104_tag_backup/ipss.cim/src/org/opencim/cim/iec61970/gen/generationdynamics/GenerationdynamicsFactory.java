/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenerationdynamicsFactory.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage
 * @generated
 */
public interface GenerationdynamicsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenerationdynamicsFactory eINSTANCE = org.opencim.cim.iec61970.gen.generationdynamics.impl.GenerationdynamicsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Supercritical</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supercritical</em>'.
	 * @generated
	 */
	Supercritical createSupercritical();

	/**
	 * Returns a new object of class '<em>Subcritical</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subcritical</em>'.
	 * @generated
	 */
	Subcritical createSubcritical();

	/**
	 * Returns a new object of class '<em>Steam Turbine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Steam Turbine</em>'.
	 * @generated
	 */
	SteamTurbine createSteamTurbine();

	/**
	 * Returns a new object of class '<em>Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Steam Supply</em>'.
	 * @generated
	 */
	SteamSupply createSteamSupply();

	/**
	 * Returns a new object of class '<em>PWR Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PWR Steam Supply</em>'.
	 * @generated
	 */
	PWRSteamSupply createPWRSteamSupply();

	/**
	 * Returns a new object of class '<em>Prime Mover</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prime Mover</em>'.
	 * @generated
	 */
	PrimeMover createPrimeMover();

	/**
	 * Returns a new object of class '<em>Heat Recovery Boiler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Heat Recovery Boiler</em>'.
	 * @generated
	 */
	HeatRecoveryBoiler createHeatRecoveryBoiler();

	/**
	 * Returns a new object of class '<em>Hydro Turbine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hydro Turbine</em>'.
	 * @generated
	 */
	HydroTurbine createHydroTurbine();

	/**
	 * Returns a new object of class '<em>Fossil Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fossil Steam Supply</em>'.
	 * @generated
	 */
	FossilSteamSupply createFossilSteamSupply();

	/**
	 * Returns a new object of class '<em>Drum Boiler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drum Boiler</em>'.
	 * @generated
	 */
	DrumBoiler createDrumBoiler();

	/**
	 * Returns a new object of class '<em>Combustion Turbine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Combustion Turbine</em>'.
	 * @generated
	 */
	CombustionTurbine createCombustionTurbine();

	/**
	 * Returns a new object of class '<em>BWR Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BWR Steam Supply</em>'.
	 * @generated
	 */
	BWRSteamSupply createBWRSteamSupply();

	/**
	 * Returns a new object of class '<em>CT Temp MW Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CT Temp MW Curve</em>'.
	 * @generated
	 */
	CTTempMWCurve createCTTempMWCurve();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenerationdynamicsPackage getGenerationdynamicsPackage();

} //GenerationdynamicsFactory
