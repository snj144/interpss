/**
 * <copyright>
 * </copyright>
 *
 * $Id: StaticVarCompensator.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Voltage;
import org.opencim.datatype.real.VoltagePerReactivePower;

import org.opencim.datatype.string.ControlMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Var Compensator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A facility for providing variable and controllable shunt reactive power. The SVC typically consists of a stepdown transformer, filter, thyristor-controlled reactor, and thyristor-switched capacitor arms.
 * 
 * The SVC may operate in fixed MVar output mode or in voltage control mode.  When in voltage control mode, the output of the SVC will be proportional to the deviation of voltage at the controlled bus from the voltage setpoint.  The SVC characteristic slope defines the proportion.  If the voltage at the controlled bus is equal to the voltage setpoint, the SVC MVar output is zero.
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getCapacitiveRating <em>Capacitive Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getInductiveRating <em>Inductive Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getSVCControlMode <em>SVC Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getSlope <em>Slope</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getVoltageSetPoint <em>Voltage Set Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getStaticVarCompensator()
 * @model
 * @generated
 */
public interface StaticVarCompensator extends RegulatingCondEq {
	/**
	 * Returns the value of the '<em><b>Capacitive Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum available capacitive reactive power
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capacitive Rating</em>' attribute.
	 * @see #setCapacitiveRating(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getStaticVarCompensator_CapacitiveRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getCapacitiveRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getCapacitiveRating <em>Capacitive Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacitive Rating</em>' attribute.
	 * @see #getCapacitiveRating()
	 * @generated
	 */
	void setCapacitiveRating(Reactance value);

	/**
	 * Returns the value of the '<em><b>Inductive Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum available inductive reactive power
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inductive Rating</em>' attribute.
	 * @see #setInductiveRating(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getStaticVarCompensator_InductiveRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getInductiveRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getInductiveRating <em>Inductive Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inductive Rating</em>' attribute.
	 * @see #getInductiveRating()
	 * @generated
	 */
	void setInductiveRating(Reactance value);

	/**
	 * Returns the value of the '<em><b>SVC Control Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SVC control mode: MVAr, Voltage
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>SVC Control Mode</em>' attribute.
	 * @see #setSVCControlMode(ControlMode)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getStaticVarCompensator_SVCControlMode()
	 * @model dataType="org.opencim.cim.iec61970.domain.ControlMode"
	 * @generated
	 */
	ControlMode getSVCControlMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getSVCControlMode <em>SVC Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SVC Control Mode</em>' attribute.
	 * @see #getSVCControlMode()
	 * @generated
	 */
	void setSVCControlMode(ControlMode value);

	/**
	 * Returns the value of the '<em><b>Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The characteristics slope of an SVC defines how the reactive power output changes in proportion to the difference between the regulated bus voltage and the voltage setpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slope</em>' attribute.
	 * @see #setSlope(VoltagePerReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getStaticVarCompensator_Slope()
	 * @model dataType="org.opencim.cim.iec61970.domain.VoltagePerReactivePower"
	 * @generated
	 */
	VoltagePerReactivePower getSlope();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getSlope <em>Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slope</em>' attribute.
	 * @see #getSlope()
	 * @generated
	 */
	void setSlope(VoltagePerReactivePower value);

	/**
	 * Returns the value of the '<em><b>Voltage Set Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reactive power output of the SVC is proportional to the difference between the voltage at the regulated bus and the voltage setpoint.  When the regulated bus voltage is equal to the voltage setpoint, the reactive power output is zero.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Set Point</em>' attribute.
	 * @see #setVoltageSetPoint(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getStaticVarCompensator_VoltageSetPoint()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getVoltageSetPoint();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getVoltageSetPoint <em>Voltage Set Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage Set Point</em>' attribute.
	 * @see #getVoltageSetPoint()
	 * @generated
	 */
	void setVoltageSetPoint(Voltage value);

} // StaticVarCompensator