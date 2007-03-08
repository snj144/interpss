/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquivalentSource.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.ConductingEquipment;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.AngleRadians;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equivalent Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generic equivalent for an energy supplier on a transmission or distribution voltage level.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getXn <em>Xn</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getRn <em>Rn</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getNominalVoltage <em>Nominal Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageAngle <em>Voltage Angle</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageMagnitude <em>Voltage Magnitude</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EquivalentSource#getActivePower <em>Active Power</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource()
 * @model
 * @generated
 */
public interface EquivalentSource extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>Xn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Negative sequence Thevenin reactance in Ohms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Xn</em>' attribute.
	 * @see #setXn(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_Xn()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXn();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getXn <em>Xn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xn</em>' attribute.
	 * @see #getXn()
	 * @generated
	 */
	void setXn(Reactance value);

	/**
	 * Returns the value of the '<em><b>Rn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Negative sequence Thevenin resistance in Ohms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rn</em>' attribute.
	 * @see #setRn(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_Rn()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getRn();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getRn <em>Rn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rn</em>' attribute.
	 * @see #getRn()
	 * @generated
	 */
	void setRn(Resistance value);

	/**
	 * Returns the value of the '<em><b>Nominal Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Phase-to-phase nominal voltage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominal Voltage</em>' attribute.
	 * @see #setNominalVoltage(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_NominalVoltage()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getNominalVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getNominalVoltage <em>Nominal Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Voltage</em>' attribute.
	 * @see #getNominalVoltage()
	 * @generated
	 */
	void setNominalVoltage(Voltage value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence Thevenin reactance in Ohms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_X()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Reactance value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence Thevenin resistance in Ohms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_R()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(Resistance value);

	/**
	 * Returns the value of the '<em><b>Voltage Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Phase angle of a-phase open circuit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Angle</em>' attribute.
	 * @see #setVoltageAngle(AngleRadians)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_VoltageAngle()
	 * @model dataType="org.opencim.cim.iec61970.domain.AngleRadians"
	 * @generated
	 */
	AngleRadians getVoltageAngle();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageAngle <em>Voltage Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage Angle</em>' attribute.
	 * @see #getVoltageAngle()
	 * @generated
	 */
	void setVoltageAngle(AngleRadians value);

	/**
	 * Returns the value of the '<em><b>Voltage Magnitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Phase-to-phase open circuit voltage magnitude.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Magnitude</em>' attribute.
	 * @see #setVoltageMagnitude(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_VoltageMagnitude()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getVoltageMagnitude();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageMagnitude <em>Voltage Magnitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage Magnitude</em>' attribute.
	 * @see #getVoltageMagnitude()
	 * @generated
	 */
	void setVoltageMagnitude(Voltage value);

	/**
	 * Returns the value of the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence Thevenin reactance in Ohms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X0</em>' attribute.
	 * @see #setX0(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_X0()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getX0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getX0 <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X0</em>' attribute.
	 * @see #getX0()
	 * @generated
	 */
	void setX0(Reactance value);

	/**
	 * Returns the value of the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence Thevenin resistance in Ohms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R0</em>' attribute.
	 * @see #setR0(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_R0()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getR0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getR0 <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R0</em>' attribute.
	 * @see #getR0()
	 * @generated
	 */
	void setR0(Resistance value);

	/**
	 * Returns the value of the '<em><b>Active Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * High voltage source load
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Active Power</em>' attribute.
	 * @see #setActivePower(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEquivalentSource_ActivePower()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getActivePower();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getActivePower <em>Active Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Power</em>' attribute.
	 * @see #getActivePower()
	 * @generated
	 */
	void setActivePower(ActivePower value);

} // EquivalentSource