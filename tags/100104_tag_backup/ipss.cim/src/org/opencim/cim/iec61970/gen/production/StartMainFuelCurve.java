/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartMainFuelCurve.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.domain.FuelType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Main Fuel Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The quantity of main fuel (Y-axis) used to restart and repay the auxiliary power consumed versus the number of hours (X-axis) the unit was off line
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartMainFuelCurve#getMainFuelType <em>Main Fuel Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartMainFuelCurve()
 * @generated
 */
public interface StartMainFuelCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Main Fuel Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.FuelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of main fuel
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Main Fuel Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see #setMainFuelType(FuelType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartMainFuelCurve_MainFuelType()
	 * @generated
	 */
	FuelType getMainFuelType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartMainFuelCurve#getMainFuelType <em>Main Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Fuel Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see #getMainFuelType()
	 * @generated
	 */
	void setMainFuelType(FuelType value);

} // StartMainFuelCurve