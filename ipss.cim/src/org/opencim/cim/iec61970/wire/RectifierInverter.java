/**
 * <copyright>
 * </copyright>
 *
 * $Id: RectifierInverter.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.ConductingEquipment;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Frequency;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.OperatingMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rectifier Inverter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Bi-directional AC-DC conversion equipment that can be used to control DC current, DC voltage, DC power flow, or firing angle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getRatedKV <em>Rated KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getBridges <em>Bridges</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingReactance <em>Commutating Reactance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingResistance <em>Commutating Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCompoundResistance <em>Compound Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinCompoundVoltage <em>Min Compound Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumMW <em>Maximum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumMW <em>Minimum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumKV <em>Maximum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumKV <em>Minimum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RectifierInverter#getOperatingMode <em>Operating Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter()
 * @model
 * @generated
 */
public interface RectifierInverter extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>Rated KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rectifier/inverter primary base voltage
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated KV</em>' attribute.
	 * @see #setRatedKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_RatedKV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getRatedKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getRatedKV <em>Rated KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated KV</em>' attribute.
	 * @see #getRatedKV()
	 * @generated
	 */
	void setRatedKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Bridges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Number of bridges
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bridges</em>' attribute.
	 * @see #setBridges(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_Bridges()
	 * @model dataType="org.opencim.cim.iec61970.domain.Counter"
	 * @generated
	 */
	Counter getBridges();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getBridges <em>Bridges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bridges</em>' attribute.
	 * @see #getBridges()
	 * @generated
	 */
	void setBridges(Counter value);

	/**
	 * Returns the value of the '<em><b>Commutating Reactance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Commutating reactance in ohms at AC bus frequency
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Commutating Reactance</em>' attribute.
	 * @see #setCommutatingReactance(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_CommutatingReactance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getCommutatingReactance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingReactance <em>Commutating Reactance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commutating Reactance</em>' attribute.
	 * @see #getCommutatingReactance()
	 * @generated
	 */
	void setCommutatingReactance(Reactance value);

	/**
	 * Returns the value of the '<em><b>Commutating Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Commutating resistance in ohms
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Commutating Resistance</em>' attribute.
	 * @see #setCommutatingResistance(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_CommutatingResistance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getCommutatingResistance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingResistance <em>Commutating Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commutating Resistance</em>' attribute.
	 * @see #getCommutatingResistance()
	 * @generated
	 */
	void setCommutatingResistance(Resistance value);

	/**
	 * Returns the value of the '<em><b>Compound Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compounding resistance in ohms
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Compound Resistance</em>' attribute.
	 * @see #setCompoundResistance(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_CompoundResistance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getCompoundResistance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCompoundResistance <em>Compound Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compound Resistance</em>' attribute.
	 * @see #getCompoundResistance()
	 * @generated
	 */
	void setCompoundResistance(Resistance value);

	/**
	 * Returns the value of the '<em><b>Min Compound Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Minimum compounded DC voltage
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Compound Voltage</em>' attribute.
	 * @see #setMinCompoundVoltage(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_MinCompoundVoltage()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMinCompoundVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinCompoundVoltage <em>Min Compound Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Compound Voltage</em>' attribute.
	 * @see #getMinCompoundVoltage()
	 * @generated
	 */
	void setMinCompoundVoltage(Voltage value);

	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Frequency on the AC side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(Frequency)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_Frequency()
	 * @model dataType="org.opencim.cim.iec61970.domain.Frequency"
	 * @generated
	 */
	Frequency getFrequency();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' attribute.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(Frequency value);

	/**
	 * Returns the value of the '<em><b>Maximum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum power on the DC side at which the frequence converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum MW</em>' attribute.
	 * @see #setMaximumMW(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_MaximumMW()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getMaximumMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumMW <em>Maximum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum MW</em>' attribute.
	 * @see #getMaximumMW()
	 * @generated
	 */
	void setMaximumMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Minimum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum power on the DC side at which the frequence converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum MW</em>' attribute.
	 * @see #setMinimumMW(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_MinimumMW()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getMinimumMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumMW <em>Minimum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum MW</em>' attribute.
	 * @see #getMinimumMW()
	 * @generated
	 */
	void setMinimumMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Maximum KV</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum voltage on the DC side at which the frequency converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum KV</em>' containment reference.
	 * @see #setMaximumKV(VoltageControlZone)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_MaximumKV()
	 * @model containment="true"
	 * @generated
	 */
	VoltageControlZone getMaximumKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumKV <em>Maximum KV</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum KV</em>' containment reference.
	 * @see #getMaximumKV()
	 * @generated
	 */
	void setMaximumKV(VoltageControlZone value);

	/**
	 * Returns the value of the '<em><b>Minimum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum voltage on the DC side at which the frequency converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum KV</em>' attribute.
	 * @see #setMinimumKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_MinimumKV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMinimumKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumKV <em>Minimum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum KV</em>' attribute.
	 * @see #getMinimumKV()
	 * @generated
	 */
	void setMinimumKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operating mode for the frequency converter
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operating Mode</em>' attribute.
	 * @see #setOperatingMode(OperatingMode)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRectifierInverter_OperatingMode()
	 * @model dataType="org.opencim.cim.iec61970.domain.OperatingMode"
	 * @generated
	 */
	OperatingMode getOperatingMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getOperatingMode <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating Mode</em>' attribute.
	 * @see #getOperatingMode()
	 * @generated
	 */
	void setOperatingMode(OperatingMode value);

} // RectifierInverter