/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoreFactory.java,v 1.1 2007/03/02 14:01:08 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreFactory eINSTANCE = org.opencim.cim.iec61970.core.impl.CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bay</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bay</em>'.
	 * @generated
	 */
	Bay createBay();

	/**
	 * Returns a new object of class '<em>Company</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Company</em>'.
	 * @generated
	 */
	Company createCompany();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CorePackage getCorePackage();

	/**
	 * Returns a new object of class '<em>Conducting Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conducting Equipment</em>'.
	 * @generated
	 */
	ConductingEquipment createConductingEquipment();

	/**
	 * Returns a new object of class '<em>Control House Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control House Equipment</em>'.
	 * @generated
	 */
	ControlHouseEquipment createControlHouseEquipment();

	/**
	 * Returns a new object of class '<em>Power System Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power System Resource</em>'.
	 * @generated
	 */
	PowerSystemResource createPowerSystemResource();

	/**
	 * Returns a new object of class '<em>Substation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substation</em>'.
	 * @generated
	 */
	Substation createSubstation();

	/**
	 * Returns a new object of class '<em>Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminal</em>'.
	 * @generated
	 */
	Terminal createTerminal();

	/**
	 * Returns a new object of class '<em>Sub Control Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Control Area</em>'.
	 * @generated
	 */
	SubControlArea createSubControlArea();

	/**
	 * Returns a new object of class '<em>Curve Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Curve Schedule</em>'.
	 * @generated
	 */
	CurveSchedule createCurveSchedule();

	/**
	 * Returns a new object of class '<em>Curve Sched Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Curve Sched Data</em>'.
	 * @generated
	 */
	CurveSchedData createCurveSchedData();

	/**
	 * Returns a new object of class '<em>Curve Sched Formula</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Curve Sched Formula</em>'.
	 * @generated
	 */
	CurveSchedFormula createCurveSchedFormula();

	/**
	 * Returns a new object of class '<em>Base Voltage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Voltage</em>'.
	 * @generated
	 */
	BaseVoltage createBaseVoltage();

	/**
	 * Returns a new object of class '<em>Base Power</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Power</em>'.
	 * @generated
	 */
	BasePower createBasePower();

	/**
	 * Returns a new object of class '<em>Voltage Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Voltage Level</em>'.
	 * @generated
	 */
	VoltageLevel createVoltageLevel();

	/**
	 * Returns a new object of class '<em>Naming</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Naming</em>'.
	 * @generated
	 */
	Naming createNaming();

	/**
	 * Returns a new object of class '<em>Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equipment</em>'.
	 * @generated
	 */
	Equipment createEquipment();

	/**
	 * Returns a new object of class '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit</em>'.
	 * @generated
	 */
	Unit createUnit();

	/**
	 * Returns a new object of class '<em>Equipment Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equipment Container</em>'.
	 * @generated
	 */
	EquipmentContainer createEquipmentContainer();

	/**
	 * Returns a new object of class '<em>PSR Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSR Type</em>'.
	 * @generated
	 */
	PSRType createPSRType();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	CoreVersion createCoreVersion();

} //CoreFactory
