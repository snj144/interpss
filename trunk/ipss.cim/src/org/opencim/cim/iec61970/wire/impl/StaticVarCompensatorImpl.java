/**
 * <copyright>
 * </copyright>
 *
 * $Id: StaticVarCompensatorImpl.java,v 1.1 2007/03/02 14:00:56 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.wire.StaticVarCompensator;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Voltage;
import org.opencim.datatype.real.VoltagePerReactivePower;

import org.opencim.datatype.string.ControlMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Var Compensator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl#getCapacitiveRating <em>Capacitive Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl#getInductiveRating <em>Inductive Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl#getSVCControlMode <em>SVC Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl#getSlope <em>Slope</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl#getVoltageSetPoint <em>Voltage Set Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticVarCompensatorImpl extends RegulatingCondEqImpl implements StaticVarCompensator {
	/**
	 * The default value of the '{@link #getCapacitiveRating() <em>Capacitive Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacitiveRating()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance CAPACITIVE_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapacitiveRating() <em>Capacitive Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacitiveRating()
	 * @generated
	 * @ordered
	 */
	protected Reactance capacitiveRating = CAPACITIVE_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getInductiveRating() <em>Inductive Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInductiveRating()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance INDUCTIVE_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInductiveRating() <em>Inductive Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInductiveRating()
	 * @generated
	 * @ordered
	 */
	protected Reactance inductiveRating = INDUCTIVE_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSVCControlMode() <em>SVC Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSVCControlMode()
	 * @generated
	 * @ordered
	 */
	protected static final ControlMode SVC_CONTROL_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSVCControlMode() <em>SVC Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSVCControlMode()
	 * @generated
	 * @ordered
	 */
	protected ControlMode sVCControlMode = SVC_CONTROL_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlope() <em>Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlope()
	 * @generated
	 * @ordered
	 */
	protected static final VoltagePerReactivePower SLOPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlope() <em>Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlope()
	 * @generated
	 * @ordered
	 */
	protected VoltagePerReactivePower slope = SLOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoltageSetPoint() <em>Voltage Set Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageSetPoint()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage VOLTAGE_SET_POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoltageSetPoint() <em>Voltage Set Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageSetPoint()
	 * @generated
	 * @ordered
	 */
	protected Voltage voltageSetPoint = VOLTAGE_SET_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticVarCompensatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.STATIC_VAR_COMPENSATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getCapacitiveRating() {
		return capacitiveRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacitiveRating(Reactance newCapacitiveRating) {
		Reactance oldCapacitiveRating = capacitiveRating;
		capacitiveRating = newCapacitiveRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING, oldCapacitiveRating, capacitiveRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getInductiveRating() {
		return inductiveRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInductiveRating(Reactance newInductiveRating) {
		Reactance oldInductiveRating = inductiveRating;
		inductiveRating = newInductiveRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING, oldInductiveRating, inductiveRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlMode getSVCControlMode() {
		return sVCControlMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSVCControlMode(ControlMode newSVCControlMode) {
		ControlMode oldSVCControlMode = sVCControlMode;
		sVCControlMode = newSVCControlMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE, oldSVCControlMode, sVCControlMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoltagePerReactivePower getSlope() {
		return slope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlope(VoltagePerReactivePower newSlope) {
		VoltagePerReactivePower oldSlope = slope;
		slope = newSlope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.STATIC_VAR_COMPENSATOR__SLOPE, oldSlope, slope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getVoltageSetPoint() {
		return voltageSetPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoltageSetPoint(Voltage newVoltageSetPoint) {
		Voltage oldVoltageSetPoint = voltageSetPoint;
		voltageSetPoint = newVoltageSetPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT, oldVoltageSetPoint, voltageSetPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING:
				return getCapacitiveRating();
			case WirePackage.STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING:
				return getInductiveRating();
			case WirePackage.STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE:
				return getSVCControlMode();
			case WirePackage.STATIC_VAR_COMPENSATOR__SLOPE:
				return getSlope();
			case WirePackage.STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT:
				return getVoltageSetPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WirePackage.STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING:
				setCapacitiveRating((Reactance)newValue);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING:
				setInductiveRating((Reactance)newValue);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE:
				setSVCControlMode((ControlMode)newValue);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__SLOPE:
				setSlope((VoltagePerReactivePower)newValue);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT:
				setVoltageSetPoint((Voltage)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WirePackage.STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING:
				setCapacitiveRating(CAPACITIVE_RATING_EDEFAULT);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING:
				setInductiveRating(INDUCTIVE_RATING_EDEFAULT);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE:
				setSVCControlMode(SVC_CONTROL_MODE_EDEFAULT);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__SLOPE:
				setSlope(SLOPE_EDEFAULT);
				return;
			case WirePackage.STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT:
				setVoltageSetPoint(VOLTAGE_SET_POINT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WirePackage.STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING:
				return CAPACITIVE_RATING_EDEFAULT == null ? capacitiveRating != null : !CAPACITIVE_RATING_EDEFAULT.equals(capacitiveRating);
			case WirePackage.STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING:
				return INDUCTIVE_RATING_EDEFAULT == null ? inductiveRating != null : !INDUCTIVE_RATING_EDEFAULT.equals(inductiveRating);
			case WirePackage.STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE:
				return SVC_CONTROL_MODE_EDEFAULT == null ? sVCControlMode != null : !SVC_CONTROL_MODE_EDEFAULT.equals(sVCControlMode);
			case WirePackage.STATIC_VAR_COMPENSATOR__SLOPE:
				return SLOPE_EDEFAULT == null ? slope != null : !SLOPE_EDEFAULT.equals(slope);
			case WirePackage.STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT:
				return VOLTAGE_SET_POINT_EDEFAULT == null ? voltageSetPoint != null : !VOLTAGE_SET_POINT_EDEFAULT.equals(voltageSetPoint);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (capacitiveRating: ");
		result.append(capacitiveRating);
		result.append(", inductiveRating: ");
		result.append(inductiveRating);
		result.append(", sVCControlMode: ");
		result.append(sVCControlMode);
		result.append(", slope: ");
		result.append(slope);
		result.append(", voltageSetPoint: ");
		result.append(voltageSetPoint);
		result.append(')');
		return result.toString();
	}

} //StaticVarCompensatorImpl