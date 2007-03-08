/**
 * <copyright>
 * </copyright>
 *
 * $Id: TapChanger.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.domain.TransformerControlMode;

import org.opencim.datatype.integer.TapStep;

import org.opencim.datatype.real.AngleDegrees;
import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tap Changer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mechanism for changing transformer winding tap positions. The typeName attribute indicates type of changer, designated as "Fixed" or "LTC."
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getHighStep <em>High Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getInitialDelay <em>Initial Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getLowStep <em>Low Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getNeutralKV <em>Neutral KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getNeutralStep <em>Neutral Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getNormalStep <em>Normal Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getStepPhaseShiftIncrement <em>Step Phase Shift Increment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getStepVoltageIncrement <em>Step Voltage Increment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getSubsequentDelay <em>Subsequent Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getTculControlMode <em>Tcul Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TapChanger#getRegulationSchedule <em>Regulation Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger()
 * @model
 * @generated
 */
public interface TapChanger extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>High Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Highest possible tap step position, advance from neutral
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>High Step</em>' attribute.
	 * @see #setHighStep(TapStep)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_HighStep()
	 * @model dataType="org.opencim.cim.iec61970.domain.TapStep"
	 * @generated
	 */
	TapStep getHighStep();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getHighStep <em>High Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Step</em>' attribute.
	 * @see #getHighStep()
	 * @generated
	 */
	void setHighStep(TapStep value);

	/**
	 * Returns the value of the '<em><b>Initial Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For an LTC, the delay for initial tap changer operation (first step change)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initial Delay</em>' attribute.
	 * @see #setInitialDelay(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_InitialDelay()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getInitialDelay();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getInitialDelay <em>Initial Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Delay</em>' attribute.
	 * @see #getInitialDelay()
	 * @generated
	 */
	void setInitialDelay(Seconds value);

	/**
	 * Returns the value of the '<em><b>Low Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lowest possible tap step position, retard from neutral
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Low Step</em>' attribute.
	 * @see #setLowStep(TapStep)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_LowStep()
	 * @model dataType="org.opencim.cim.iec61970.domain.TapStep"
	 * @generated
	 */
	TapStep getLowStep();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getLowStep <em>Low Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low Step</em>' attribute.
	 * @see #getLowStep()
	 * @generated
	 */
	void setLowStep(TapStep value);

	/**
	 * Returns the value of the '<em><b>Neutral KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Voltage at which the winding operates at the neutral tap setting.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Neutral KV</em>' attribute.
	 * @see #setNeutralKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_NeutralKV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getNeutralKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getNeutralKV <em>Neutral KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Neutral KV</em>' attribute.
	 * @see #getNeutralKV()
	 * @generated
	 */
	void setNeutralKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Neutral Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The neutral tap step position for this winding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Neutral Step</em>' attribute.
	 * @see #setNeutralStep(TapStep)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_NeutralStep()
	 * @model dataType="org.opencim.cim.iec61970.domain.TapStep"
	 * @generated
	 */
	TapStep getNeutralStep();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getNeutralStep <em>Neutral Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Neutral Step</em>' attribute.
	 * @see #getNeutralStep()
	 * @generated
	 */
	void setNeutralStep(TapStep value);

	/**
	 * Returns the value of the '<em><b>Normal Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tap step position used in "normal" network operation for this winding. For a "Fixed" tap changer indicates the current physical tap setting.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal Step</em>' attribute.
	 * @see #setNormalStep(TapStep)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_NormalStep()
	 * @model dataType="org.opencim.cim.iec61970.domain.TapStep"
	 * @generated
	 */
	TapStep getNormalStep();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getNormalStep <em>Normal Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal Step</em>' attribute.
	 * @see #getNormalStep()
	 * @generated
	 */
	void setNormalStep(TapStep value);

	/**
	 * Returns the value of the '<em><b>Step Phase Shift Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Phase shift, in degrees, per step position. A positive value indicates a positive phase shift from the winding where the tap is located to the other winding (for a two-winding transformer), or to the 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Step Phase Shift Increment</em>' attribute.
	 * @see #setStepPhaseShiftIncrement(AngleDegrees)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_StepPhaseShiftIncrement()
	 * @model dataType="org.opencim.cim.iec61970.domain.AngleDegrees"
	 * @generated
	 */
	AngleDegrees getStepPhaseShiftIncrement();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getStepPhaseShiftIncrement <em>Step Phase Shift Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Phase Shift Increment</em>' attribute.
	 * @see #getStepPhaseShiftIncrement()
	 * @generated
	 */
	void setStepPhaseShiftIncrement(AngleDegrees value);

	/**
	 * Returns the value of the '<em><b>Step Voltage Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tap step increment, in per cent of nominal voltage, per step position.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Step Voltage Increment</em>' attribute.
	 * @see #setStepVoltageIncrement(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_StepVoltageIncrement()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getStepVoltageIncrement();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getStepVoltageIncrement <em>Step Voltage Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Voltage Increment</em>' attribute.
	 * @see #getStepVoltageIncrement()
	 * @generated
	 */
	void setStepVoltageIncrement(PerCent value);

	/**
	 * Returns the value of the '<em><b>Subsequent Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For an LTC, the delay for subsequent tap changer operation (second and later step changes)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subsequent Delay</em>' attribute.
	 * @see #setSubsequentDelay(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_SubsequentDelay()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getSubsequentDelay();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getSubsequentDelay <em>Subsequent Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subsequent Delay</em>' attribute.
	 * @see #getSubsequentDelay()
	 * @generated
	 */
	void setSubsequentDelay(Seconds value);

	/**
	 * Returns the value of the '<em><b>Tcul Control Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.TransformerControlMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For an LTC, the tap changer control mode, e.g.: Off, Local, Volt, MVAr
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tcul Control Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TransformerControlMode
	 * @see #setTculControlMode(TransformerControlMode)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_TculControlMode()
	 * @model
	 * @generated
	 */
	TransformerControlMode getTculControlMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getTculControlMode <em>Tcul Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tcul Control Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TransformerControlMode
	 * @see #getTculControlMode()
	 * @generated
	 */
	void setTculControlMode(TransformerControlMode value);

	/**
	 * Returns the value of the '<em><b>Regulation Schedule</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getTapChangers <em>Tap Changers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An LTC may have a regulation schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regulation Schedule</em>' reference.
	 * @see #setRegulationSchedule(RegulationSchedule)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTapChanger_RegulationSchedule()
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getTapChangers
	 * @model opposite="TapChangers"
	 * @generated
	 */
	RegulationSchedule getRegulationSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TapChanger#getRegulationSchedule <em>Regulation Schedule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regulation Schedule</em>' reference.
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	void setRegulationSchedule(RegulationSchedule value);

} // TapChanger