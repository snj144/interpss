/**
 * <copyright>
 * </copyright>
 *
 * $Id: SynchronousMachine.java,v 1.4 2007/03/07 16:03:48 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.domain.CoolantType;
import org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode;
import org.opencim.cim.iec61970.domain.SynchronousMachineType;

import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.gen.production.HydroPump;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Damping;
import org.opencim.datatype.real.Inertia;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synchronous Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An electromechanical device that operates synchronously with the network. It is a single machine operating either as a generator or synchronous condenser or pump.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLag <em>AVR To Manual Lag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLead <em>AVR To Manual Lead</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getBaseMVAr <em>Base MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantCondition <em>Coolant Condition</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantType <em>Coolant Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getDamping <em>Damping</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getInertia <em>Inertia</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getManualToAVR <em>Manual To AVR</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumKV <em>Maximum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumMVAr <em>Maximum MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumKV <em>Minimum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumMVAr <em>Minimum MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getRatedMVA <em>Rated MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSubtrans <em>XDirect Subtrans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSync <em>XDirect Sync</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectTrans <em>XDirect Trans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSubtrans <em>XQuad Subtrans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSync <em>XQuad Sync</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadTrans <em>XQuad Trans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getOperatingMode <em>Operating Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getType <em>Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCondenserMW <em>Condenser MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMVArCapabilityCurves <em>MV Ar Capability Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getDrives_HydroPump <em>Drives Hydro Pump</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getGeneratingUnit <em>Generating Unit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getPrimeMover <em>Prime Mover</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine()
 * @model
 * @generated
 */
public interface SynchronousMachine extends RegulatingCondEq {
	/**
	 * Returns the value of the '<em><b>AVR To Manual Lag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time delay, in seconds, required when switching from AVR to manual for a lagging MVAr violation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>AVR To Manual Lag</em>' attribute.
	 * @see #setAVRToManualLag(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_AVRToManualLag()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getAVRToManualLag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLag <em>AVR To Manual Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AVR To Manual Lag</em>' attribute.
	 * @see #getAVRToManualLag()
	 * @generated
	 */
	void setAVRToManualLag(Seconds value);

	/**
	 * Returns the value of the '<em><b>AVR To Manual Lead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time delay, in seconds, required when switching from Automatic Voltage Regulation to Manual for a leading MVAr violation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>AVR To Manual Lead</em>' attribute.
	 * @see #setAVRToManualLead(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_AVRToManualLead()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getAVRToManualLead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLead <em>AVR To Manual Lead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AVR To Manual Lead</em>' attribute.
	 * @see #getAVRToManualLead()
	 * @generated
	 */
	void setAVRToManualLead(Seconds value);

	/**
	 * Returns the value of the '<em><b>Base MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default base MVAr value. This value represents the initial MVAr that can be used by any application function.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base MV Ar</em>' attribute.
	 * @see #setBaseMVAr(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_BaseMVAr()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getBaseMVAr();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getBaseMVAr <em>Base MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base MV Ar</em>' attribute.
	 * @see #getBaseMVAr()
	 * @generated
	 */
	void setBaseMVAr(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Coolant Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Temperature or pressure of coolant medium
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Coolant Condition</em>' attribute.
	 * @see #setCoolantCondition(Float)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_CoolantCondition()
	 * @model
	 * @generated
	 */
	Float getCoolantCondition();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantCondition <em>Coolant Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coolant Condition</em>' attribute.
	 * @see #getCoolantCondition()
	 * @generated
	 */
	void setCoolantCondition(Float value);

	/**
	 * Returns the value of the '<em><b>Coolant Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.CoolantType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Method of cooling the machine, e.g., air, hydrogen gas, water
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Coolant Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CoolantType
	 * @see #setCoolantType(CoolantType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_CoolantType()
	 * @model
	 * @generated
	 */
	CoolantType getCoolantType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantType <em>Coolant Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coolant Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CoolantType
	 * @see #getCoolantType()
	 * @generated
	 */
	void setCoolantType(CoolantType value);

	/**
	 * Returns the value of the '<em><b>Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Damping torque coefficient, a proportionality constant that, when multiplied by the angular velocity of the rotor poles with respect to the magnetic field (frequency), results in the damping torque.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Damping</em>' attribute.
	 * @see #setDamping(Damping)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_Damping()
	 * @model dataType="org.opencim.cim.iec61970.domain.Damping"
	 * @generated
	 */
	Damping getDamping();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getDamping <em>Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Damping</em>' attribute.
	 * @see #getDamping()
	 * @generated
	 */
	void setDamping(Damping value);

	/**
	 * Returns the value of the '<em><b>Inertia</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The energy stored in the rotor when operating at rated speed. This value is used in the accelerating power reference frame for  operator training simulator solutions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inertia</em>' attribute.
	 * @see #setInertia(Inertia)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_Inertia()
	 * @model dataType="org.opencim.cim.iec61970.domain.Inertia"
	 * @generated
	 */
	Inertia getInertia();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getInertia <em>Inertia</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inertia</em>' attribute.
	 * @see #getInertia()
	 * @generated
	 */
	void setInertia(Inertia value);

	/**
	 * Returns the value of the '<em><b>Manual To AVR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time delay, in seconds, required when switching from Manual to Automatic Voltage Regulation. This value is used in the accelerating power reference frame for powerflow solutions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manual To AVR</em>' attribute.
	 * @see #setManualToAVR(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_ManualToAVR()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getManualToAVR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getManualToAVR <em>Manual To AVR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manual To AVR</em>' attribute.
	 * @see #getManualToAVR()
	 * @generated
	 */
	void setManualToAVR(Seconds value);

	/**
	 * Returns the value of the '<em><b>Maximum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum kV limit for the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum KV</em>' attribute.
	 * @see #setMaximumKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_MaximumKV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMaximumKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumKV <em>Maximum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum KV</em>' attribute.
	 * @see #getMaximumKV()
	 * @generated
	 */
	void setMaximumKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Maximum MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum MVAr limit. This is the maximum (nameplate) limit for the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum MV Ar</em>' attribute.
	 * @see #setMaximumMVAr(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_MaximumMVAr()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getMaximumMVAr();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumMVAr <em>Maximum MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum MV Ar</em>' attribute.
	 * @see #getMaximumMVAr()
	 * @generated
	 */
	void setMaximumMVAr(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Minimum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Minimum kV  limit for the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum KV</em>' attribute.
	 * @see #setMinimumKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_MinimumKV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMinimumKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumKV <em>Minimum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum KV</em>' attribute.
	 * @see #getMinimumKV()
	 * @generated
	 */
	void setMinimumKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Minimum MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Minimum MVAr limit for the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum MV Ar</em>' attribute.
	 * @see #setMinimumMVAr(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_MinimumMVAr()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getMinimumMVAr();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumMVAr <em>Minimum MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum MV Ar</em>' attribute.
	 * @see #getMinimumMVAr()
	 * @generated
	 */
	void setMinimumMVAr(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence resistance of the synchronous machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_R()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(Resistance value);

	/**
	 * Returns the value of the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence resistance of the synchronous machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R0</em>' attribute.
	 * @see #setR0(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_R0()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getR0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getR0 <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R0</em>' attribute.
	 * @see #getR0()
	 * @generated
	 */
	void setR0(Resistance value);

	/**
	 * Returns the value of the '<em><b>Rated MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nameplate MVA rating for the unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated MVA</em>' attribute.
	 * @see #setRatedMVA(ApparentPower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_RatedMVA()
	 * @model dataType="org.opencim.cim.iec61970.domain.ApparentPower"
	 * @generated
	 */
	ApparentPower getRatedMVA();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getRatedMVA <em>Rated MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated MVA</em>' attribute.
	 * @see #getRatedMVA()
	 * @generated
	 */
	void setRatedMVA(ApparentPower value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence reactance of the synchronous machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_X()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Reactance value);

	/**
	 * Returns the value of the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence reactance of the synchronous machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X0</em>' attribute.
	 * @see #setX0(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_X0()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getX0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getX0 <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X0</em>' attribute.
	 * @see #getX0()
	 * @generated
	 */
	void setX0(Reactance value);

	/**
	 * Returns the value of the '<em><b>XDirect Subtrans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Direct-axis subtransient reactance, also known as X"d.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XDirect Subtrans</em>' attribute.
	 * @see #setXDirectSubtrans(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_XDirectSubtrans()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXDirectSubtrans();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSubtrans <em>XDirect Subtrans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDirect Subtrans</em>' attribute.
	 * @see #getXDirectSubtrans()
	 * @generated
	 */
	void setXDirectSubtrans(Reactance value);

	/**
	 * Returns the value of the '<em><b>XDirect Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Direct-axis synchronous reactance. The quotient of a sustained value of that AC component of armature voltage that is produced by the total direct-axis flux due to direct-axis armature current and the value of the AC component of this current, the machine running at rated speed. (Xd)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XDirect Sync</em>' attribute.
	 * @see #setXDirectSync(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_XDirectSync()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXDirectSync();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSync <em>XDirect Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDirect Sync</em>' attribute.
	 * @see #getXDirectSync()
	 * @generated
	 */
	void setXDirectSync(Reactance value);

	/**
	 * Returns the value of the '<em><b>XDirect Trans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Direct-axis transient reactance, also known as X'd.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XDirect Trans</em>' attribute.
	 * @see #setXDirectTrans(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_XDirectTrans()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXDirectTrans();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectTrans <em>XDirect Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDirect Trans</em>' attribute.
	 * @see #getXDirectTrans()
	 * @generated
	 */
	void setXDirectTrans(Reactance value);

	/**
	 * Returns the value of the '<em><b>XQuad Subtrans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Quadrature-axis subtransient reactance, also known as X"q.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XQuad Subtrans</em>' attribute.
	 * @see #setXQuadSubtrans(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_XQuadSubtrans()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXQuadSubtrans();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSubtrans <em>XQuad Subtrans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XQuad Subtrans</em>' attribute.
	 * @see #getXQuadSubtrans()
	 * @generated
	 */
	void setXQuadSubtrans(Reactance value);

	/**
	 * Returns the value of the '<em><b>XQuad Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Quadrature-axis synchronous reactance (Xq) , the ratio of the component of reactive armature voltage, due to the quadrature-axis component of armature current, to this component of current, under steady state conditions and at rated frequency.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XQuad Sync</em>' attribute.
	 * @see #setXQuadSync(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_XQuadSync()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXQuadSync();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSync <em>XQuad Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XQuad Sync</em>' attribute.
	 * @see #getXQuadSync()
	 * @generated
	 */
	void setXQuadSync(Reactance value);

	/**
	 * Returns the value of the '<em><b>XQuad Trans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Quadrature-axis transient reactance, also known as X'q.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XQuad Trans</em>' attribute.
	 * @see #setXQuadTrans(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_XQuadTrans()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getXQuadTrans();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadTrans <em>XQuad Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XQuad Trans</em>' attribute.
	 * @see #getXQuadTrans()
	 * @generated
	 */
	void setXQuadTrans(Reactance value);

	/**
	 * Returns the value of the '<em><b>Operating Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Current mode of operation, i.e., generator or condenser
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operating Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode
	 * @see #setOperatingMode(SynchronousMachineOperatingMode)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_OperatingMode()
	 * @model
	 * @generated
	 */
	SynchronousMachineOperatingMode getOperatingMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getOperatingMode <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode
	 * @see #getOperatingMode()
	 * @generated
	 */
	void setOperatingMode(SynchronousMachineOperatingMode value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.SynchronousMachineType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Modes that this synchronous machine can operate in, i.e., as a generator, condenser, or both
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineType
	 * @see #setType(SynchronousMachineType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_Type()
	 * @model
	 * @generated
	 */
	SynchronousMachineType getType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineType
	 * @see #getType()
	 * @generated
	 */
	void setType(SynchronousMachineType value);

	/**
	 * Returns the value of the '<em><b>Condenser MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condenser MW</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condenser MW</em>' attribute.
	 * @see #setCondenserMW(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_CondenserMW()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getCondenserMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCondenserMW <em>Condenser MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condenser MW</em>' attribute.
	 * @see #getCondenserMW()
	 * @generated
	 */
	void setCondenserMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>MV Ar Capability Curves</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getSynchronousMachines <em>Synchronous Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MV Ar Capability Curves</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MV Ar Capability Curves</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_MVArCapabilityCurves()
	 * @see org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getSynchronousMachines
	 * @model type="org.opencim.cim.iec61970.wire.MVArCapabilityCurve" opposite="SynchronousMachines"
	 * @generated
	 */
	EList getMVArCapabilityCurves();

	/**
	 * Returns the value of the '<em><b>Drives Hydro Pump</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The synchronous machine drives the turbine which moves the water from a low elevation to a higher elevation. The direction of machine rotation for pumping may or may not be the same as for generating.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Drives Hydro Pump</em>' reference.
	 * @see #setDrives_HydroPump(HydroPump)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_Drives_HydroPump()
	 * @model
	 * @generated
	 */
	HydroPump getDrives_HydroPump();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getDrives_HydroPump <em>Drives Hydro Pump</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drives Hydro Pump</em>' reference.
	 * @see #getDrives_HydroPump()
	 * @generated
	 */
	void setDrives_HydroPump(HydroPump value);

	/**
	 * Returns the value of the '<em><b>Generating Unit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSynchronousMachines <em>Synchronous Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A synchronous machine may operate as a generator and as such becomes a member of a generating unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generating Unit</em>' reference.
	 * @see #setGeneratingUnit(GeneratingUnit)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_GeneratingUnit()
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSynchronousMachines
	 * @model opposite="SynchronousMachines" required="true"
	 * @generated
	 */
	GeneratingUnit getGeneratingUnit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getGeneratingUnit <em>Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generating Unit</em>' reference.
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	void setGeneratingUnit(GeneratingUnit value);

	/**
	 * Returns the value of the '<em><b>Prime Mover</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover#getSynchronousMachines <em>Synchronous Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prime Mover</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prime Mover</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSynchronousMachine_PrimeMover()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover#getSynchronousMachines
	 * @model type="org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover" opposite="SynchronousMachines"
	 * @generated
	 */
	EList getPrimeMover();

} // SynchronousMachine