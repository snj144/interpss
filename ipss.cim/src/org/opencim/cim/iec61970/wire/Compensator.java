/**
 * <copyright>
 * </copyright>
 *
 * $Id: Compensator.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import java.util.Date;

import org.opencim.cim.iec61970.domain.CompensatorType;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.Admittance;
import org.opencim.datatype.real.Impedance;
import org.opencim.datatype.real.PUkVPerMVAr;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compensator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A shunt or series capacitor or switchable bank of shunt or series capacitors. The shunt or series application of a capacitor bank is determined by its connectivity in the network. A shunt compensator has only one terminal (ground implied) and series compensator has two terminals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getAVRDelay <em>AVR Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getImpedance <em>Impedance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getMaximumkV <em>Maximumk V</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getMaximumSections <em>Maximum Sections</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getMinimumkV <em>Minimumk V</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getMVArPerSection <em>MV Ar Per Section</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getNominalkV <em>Nominalk V</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getNominalMVAr <em>Nominal MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getNormalSections <em>Normal Sections</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getSwitchOnCount <em>Switch On Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getSwitchOnDate <em>Switch On Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getVoltSensitivity <em>Volt Sensitivity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getYPerSection <em>YPer Section</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Compensator#getCompensatorType <em>Compensator Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator()
 * @model
 * @generated
 */
public interface Compensator extends RegulatingCondEq {
	/**
	 * Returns the value of the '<em><b>AVR Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time delay in seconds required for the device to be connected or disconnected by automatic voltage regulation (AVR).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>AVR Delay</em>' attribute.
	 * @see #setAVRDelay(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_AVRDelay()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getAVRDelay();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getAVRDelay <em>AVR Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AVR Delay</em>' attribute.
	 * @see #getAVRDelay()
	 * @generated
	 */
	void setAVRDelay(Seconds value);

	/**
	 * Returns the value of the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The positive sequence impedance of the capacitor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Impedance</em>' attribute.
	 * @see #setImpedance(Impedance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_Impedance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Impedance"
	 * @generated
	 */
	Impedance getImpedance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getImpedance <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impedance</em>' attribute.
	 * @see #getImpedance()
	 * @generated
	 */
	void setImpedance(Impedance value);

	/**
	 * Returns the value of the '<em><b>Maximumk V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum voltage at which the capacitor bank should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximumk V</em>' attribute.
	 * @see #setMaximumkV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_MaximumkV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMaximumkV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getMaximumkV <em>Maximumk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximumk V</em>' attribute.
	 * @see #getMaximumkV()
	 * @generated
	 */
	void setMaximumkV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Maximum Sections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a capacitor bank, the maximum number of sections that may be switched in.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum Sections</em>' attribute.
	 * @see #setMaximumSections(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_MaximumSections()
	 * @model dataType="org.opencim.cim.iec61970.domain.Counter"
	 * @generated
	 */
	Counter getMaximumSections();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getMaximumSections <em>Maximum Sections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Sections</em>' attribute.
	 * @see #getMaximumSections()
	 * @generated
	 */
	void setMaximumSections(Counter value);

	/**
	 * Returns the value of the '<em><b>Minimumk V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum voltage at which the capacitor bank should operate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimumk V</em>' attribute.
	 * @see #setMinimumkV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_MinimumkV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMinimumkV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getMinimumkV <em>Minimumk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimumk V</em>' attribute.
	 * @see #getMinimumkV()
	 * @generated
	 */
	void setMinimumkV(Voltage value);

	/**
	 * Returns the value of the '<em><b>MV Ar Per Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a capacitor bank, the size in MVAr of each switchable section at the Nominal kV.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MV Ar Per Section</em>' attribute.
	 * @see #setMVArPerSection(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_MVArPerSection()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getMVArPerSection();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getMVArPerSection <em>MV Ar Per Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MV Ar Per Section</em>' attribute.
	 * @see #getMVArPerSection()
	 * @generated
	 */
	void setMVArPerSection(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Nominalk V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The nominal voltage at which the nominal MVAr was measured. This should normally be within 10% of the voltage at which the capacitor is connected to the network.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominalk V</em>' attribute.
	 * @see #setNominalkV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_NominalkV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getNominalkV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getNominalkV <em>Nominalk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominalk V</em>' attribute.
	 * @see #getNominalkV()
	 * @generated
	 */
	void setNominalkV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Nominal MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nominal MVAr output of the capacitor bank at the nominal kV. This number should be positive.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominal MV Ar</em>' attribute.
	 * @see #setNominalMVAr(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_NominalMVAr()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getNominalMVAr();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getNominalMVAr <em>Nominal MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal MV Ar</em>' attribute.
	 * @see #getNominalMVAr()
	 * @generated
	 */
	void setNominalMVAr(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Normal Sections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a capacitor bank, the normal number of sections switched in. This number should correspond to the Nominal MVAr.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal Sections</em>' attribute.
	 * @see #setNormalSections(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_NormalSections()
	 * @model dataType="org.opencim.cim.iec61970.domain.Counter"
	 * @generated
	 */
	Counter getNormalSections();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getNormalSections <em>Normal Sections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal Sections</em>' attribute.
	 * @see #getNormalSections()
	 * @generated
	 */
	void setNormalSections(Counter value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence resistance of the capacitor bank.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_R()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(Resistance value);

	/**
	 * Returns the value of the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The switch on count since the capacitor count was last reset or initialized.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Switch On Count</em>' attribute.
	 * @see #setSwitchOnCount(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_SwitchOnCount()
	 * @model dataType="org.opencim.cim.iec61970.domain.Counter"
	 * @generated
	 */
	Counter getSwitchOnCount();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getSwitchOnCount <em>Switch On Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch On Count</em>' attribute.
	 * @see #getSwitchOnCount()
	 * @generated
	 */
	void setSwitchOnCount(Counter value);

	/**
	 * Returns the value of the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date and time when the capacitor bank was last switched on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Switch On Date</em>' attribute.
	 * @see #setSwitchOnDate(Date)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_SwitchOnDate()
	 * @model dataType="org.opencim.cim.iec61970.domain.AbsoluteDateTime"
	 * @generated
	 */
	Date getSwitchOnDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getSwitchOnDate <em>Switch On Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch On Date</em>' attribute.
	 * @see #getSwitchOnDate()
	 * @generated
	 */
	void setSwitchOnDate(Date value);

	/**
	 * Returns the value of the '<em><b>Volt Sensitivity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Voltage sensitivity required for the device to regulate the bus voltage, in per unit voltage/MVAr.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Volt Sensitivity</em>' attribute.
	 * @see #setVoltSensitivity(PUkVPerMVAr)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_VoltSensitivity()
	 * @model dataType="org.opencim.cim.iec61970.domain.PUkVPerMVAr"
	 * @generated
	 */
	PUkVPerMVAr getVoltSensitivity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getVoltSensitivity <em>Volt Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volt Sensitivity</em>' attribute.
	 * @see #getVoltSensitivity()
	 * @generated
	 */
	void setVoltSensitivity(PUkVPerMVAr value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence reactance of the capacitor bank.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_X()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Reactance value);

	/**
	 * Returns the value of the '<em><b>YPer Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a capacitor bank, the admittance of each switchable section. Calculated using the MVAr per section and corrected for network voltage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>YPer Section</em>' attribute.
	 * @see #setYPerSection(Admittance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_YPerSection()
	 * @model dataType="org.opencim.cim.iec61970.domain.Admittance"
	 * @generated
	 */
	Admittance getYPerSection();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getYPerSection <em>YPer Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YPer Section</em>' attribute.
	 * @see #getYPerSection()
	 * @generated
	 */
	void setYPerSection(Admittance value);

	/**
	 * Returns the value of the '<em><b>Compensator Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.CompensatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to indicate how many terminals compensator has. A shunt compensator has only one terminal (ground implied), while a series compensator has two terminals.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Compensator Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CompensatorType
	 * @see #setCompensatorType(CompensatorType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompensator_CompensatorType()
	 * @model
	 * @generated
	 */
	CompensatorType getCompensatorType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Compensator#getCompensatorType <em>Compensator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compensator Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CompensatorType
	 * @see #getCompensatorType()
	 * @generated
	 */
	void setCompensatorType(CompensatorType value);

} // Compensator