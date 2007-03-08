/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadFactory.java,v 1.1 2007/03/02 14:01:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.load.LoadPackage
 * @generated
 */
public interface LoadFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoadFactory eINSTANCE = org.opencim.cim.iec61970.load.impl.LoadFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Area Load Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Load Curve</em>'.
	 * @generated
	 */
	AreaLoadCurve createAreaLoadCurve();

	/**
	 * Returns a new object of class '<em>Area Loss Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Loss Curve</em>'.
	 * @generated
	 */
	AreaLossCurve createAreaLossCurve();

	/**
	 * Returns a new object of class '<em>Customer Meter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer Meter</em>'.
	 * @generated
	 */
	CustomerMeter createCustomerMeter();

	/**
	 * Returns a new object of class '<em>Day Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Day Type</em>'.
	 * @generated
	 */
	DayType createDayType();

	/**
	 * Returns a new object of class '<em>Equivalent Load</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equivalent Load</em>'.
	 * @generated
	 */
	EquivalentLoad createEquivalentLoad();

	/**
	 * Returns a new object of class '<em>Induction Motor Load</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Induction Motor Load</em>'.
	 * @generated
	 */
	InductionMotorLoad createInductionMotorLoad();

	/**
	 * Returns a new object of class '<em>Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area</em>'.
	 * @generated
	 */
	LoadArea createLoadArea();

	/**
	 * Returns a new object of class '<em>Demand Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Demand Model</em>'.
	 * @generated
	 */
	LoadDemandModel createLoadDemandModel();

	/**
	 * Returns a new object of class '<em>Non Conform Load Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Conform Load Schedule</em>'.
	 * @generated
	 */
	NonConformLoadSchedule createNonConformLoadSchedule();

	/**
	 * Returns a new object of class '<em>Season</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Season</em>'.
	 * @generated
	 */
	Season createSeason();

	/**
	 * Returns a new object of class '<em>Station Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Station Supply</em>'.
	 * @generated
	 */
	StationSupply createStationSupply();

	/**
	 * Returns a new object of class '<em>Power Cut Zone</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Cut Zone</em>'.
	 * @generated
	 */
	PowerCutZone createPowerCutZone();

	/**
	 * Returns a new object of class '<em>Model Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Version</em>'.
	 * @generated
	 */
	LoadModelVersion createLoadModelVersion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LoadPackage getLoadPackage();

} //LoadFactory
