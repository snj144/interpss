/**
 * <copyright>
 * </copyright>
 *
 * $Id: HeatInputCurve.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.HeatPerHour;
import org.opencim.datatype.real.PU;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Heat Input Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between unit heat input in MBtu per hour for main fuel (Y1-axis) and supplemental fuel (Y2-axis) versus unit output in MW (X-axis). The quantity of main fuel used to sustain generation at this output level is prorated for throttling between definition points. The quantity of supplemental fuel used at this output level is fixed and not prorated.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerOffset <em>Aux Power Offset</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerMult <em>Aux Power Mult</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputEff <em>Heat Input Eff</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputOffset <em>Heat Input Offset</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatInputCurve()
 * @model
 * @generated
 */
public interface HeatInputCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Aux Power Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Power output - auxiliary power offset adjustment factor in MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aux Power Offset</em>' attribute.
	 * @see #setAuxPowerOffset(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatInputCurve_AuxPowerOffset()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getAuxPowerOffset();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerOffset <em>Aux Power Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aux Power Offset</em>' attribute.
	 * @see #getAuxPowerOffset()
	 * @generated
	 */
	void setAuxPowerOffset(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Aux Power Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Power output - auxiliary power multiplier adjustment factor in per unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aux Power Mult</em>' attribute.
	 * @see #setAuxPowerMult(PU)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatInputCurve_AuxPowerMult()
	 * @model dataType="org.opencim.cim.iec61970.domain.PU"
	 * @generated
	 */
	PU getAuxPowerMult();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerMult <em>Aux Power Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aux Power Mult</em>' attribute.
	 * @see #getAuxPowerMult()
	 * @generated
	 */
	void setAuxPowerMult(PU value);

	/**
	 * Returns the value of the '<em><b>Heat Input Eff</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Heat input - efficiency multiplier adjustment factor in per unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Input Eff</em>' attribute.
	 * @see #setHeatInputEff(PU)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatInputCurve_HeatInputEff()
	 * @model dataType="org.opencim.cim.iec61970.domain.PU"
	 * @generated
	 */
	PU getHeatInputEff();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputEff <em>Heat Input Eff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Input Eff</em>' attribute.
	 * @see #getHeatInputEff()
	 * @generated
	 */
	void setHeatInputEff(PU value);

	/**
	 * Returns the value of the '<em><b>Heat Input Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Heat input - offset adjustment factor in MBtu/hr
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Input Offset</em>' attribute.
	 * @see #setHeatInputOffset(HeatPerHour)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatInputCurve_HeatInputOffset()
	 * @model dataType="org.opencim.cim.iec61970.domain.HeatPerHour"
	 * @generated
	 */
	HeatPerHour getHeatInputOffset();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputOffset <em>Heat Input Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Input Offset</em>' attribute.
	 * @see #getHeatInputOffset()
	 * @generated
	 */
	void setHeatInputOffset(HeatPerHour value);

	/**
	 * Returns the value of the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag is set to YES when output is expressed in net MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #setNetGrossMWFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatInputCurve_NetGrossMWFlag()
	 * @model
	 * @generated
	 */
	Boolean getNetGrossMWFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #getNetGrossMWFlag()
	 * @generated
	 */
	void setNetGrossMWFlag(Boolean value);

} // HeatInputCurve