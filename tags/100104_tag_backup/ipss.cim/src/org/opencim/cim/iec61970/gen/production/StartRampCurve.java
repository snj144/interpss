/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartRampCurve.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.datatype.real.PowerROCPerMin;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Ramp Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Rate in gross MW/minute (Y-axis) at which a unit can be loaded versus the number of hours (X-axis) the unit was off line
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartRampCurve#getHotStandbyRamp <em>Hot Standby Ramp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartRampCurve()
 * @generated
 */
public interface StartRampCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Hot Standby Ramp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The startup ramp rate in gross MW/minute for a unit that is on hot standby
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hot Standby Ramp</em>' attribute.
	 * @see #setHotStandbyRamp(PowerROCPerMin)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartRampCurve_HotStandbyRamp()
	 * @generated
	 */
	PowerROCPerMin getHotStandbyRamp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartRampCurve#getHotStandbyRamp <em>Hot Standby Ramp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hot Standby Ramp</em>' attribute.
	 * @see #getHotStandbyRamp()
	 * @generated
	 */
	void setHotStandbyRamp(PowerROCPerMin value);

} // StartRampCurve