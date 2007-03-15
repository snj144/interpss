/**
 * <copyright>
 * </copyright>
 *
 * $Id: FrequencyConverter.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Frequency;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.OperatingMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frequency Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A device to convert from one frequency to another (e.g., frequency F1 to F2) comprises a pair of FrequencyConverter instances. One converts from F1 to DC, the other converts the DC to F2.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumMW <em>Maximum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumKV <em>Maximum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumMW <em>Minimum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumKV <em>Minimum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getOperatingMode <em>Operating Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter()
 * @generated
 */
public interface FrequencyConverter extends RegulatingCondEq {
	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Frequency on the AC side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(Frequency)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter_Frequency()
	 * @generated
	 */
	Frequency getFrequency();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getFrequency <em>Frequency</em>}' attribute.
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
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter_MaximumMW()
	 * @generated
	 */
	ActivePower getMaximumMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumMW <em>Maximum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum MW</em>' attribute.
	 * @see #getMaximumMW()
	 * @generated
	 */
	void setMaximumMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Maximum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum voltage on the DC side at which the frequency converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum KV</em>' attribute.
	 * @see #setMaximumKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter_MaximumKV()
	 * @generated
	 */
	Voltage getMaximumKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumKV <em>Maximum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum KV</em>' attribute.
	 * @see #getMaximumKV()
	 * @generated
	 */
	void setMaximumKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Minimum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum power on the DC side at which the frequence converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum MW</em>' attribute.
	 * @see #setMinimumMW(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter_MinimumMW()
	 * @generated
	 */
	ActivePower getMinimumMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumMW <em>Minimum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum MW</em>' attribute.
	 * @see #getMinimumMW()
	 * @generated
	 */
	void setMinimumMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Minimum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum voltage on the DC side at which the frequency converter should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum KV</em>' attribute.
	 * @see #setMinimumKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter_MinimumKV()
	 * @generated
	 */
	Voltage getMinimumKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumKV <em>Minimum KV</em>}' attribute.
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
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFrequencyConverter_OperatingMode()
	 * @generated
	 */
	OperatingMode getOperatingMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getOperatingMode <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating Mode</em>' attribute.
	 * @see #getOperatingMode()
	 * @generated
	 */
	void setOperatingMode(OperatingMode value);

} // FrequencyConverter