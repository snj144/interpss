/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquivalentSourceImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl;

import org.opencim.cim.iec61970.wire.EquivalentSource;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.AngleRadians;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equivalent Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getXn <em>Xn</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getRn <em>Rn</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getNominalVoltage <em>Nominal Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getVoltageAngle <em>Voltage Angle</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getVoltageMagnitude <em>Voltage Magnitude</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl#getActivePower <em>Active Power</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquivalentSourceImpl extends ConductingEquipmentImpl implements EquivalentSource {
	/**
	 * The default value of the '{@link #getXn() <em>Xn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXn()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXn() <em>Xn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXn()
	 * @generated
	 * @ordered
	 */
	protected Reactance xn = XN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRn() <em>Rn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRn()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance RN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRn() <em>Rn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRn()
	 * @generated
	 * @ordered
	 */
	protected Resistance rn = RN_EDEFAULT;

	/**
	 * The default value of the '{@link #getNominalVoltage() <em>Nominal Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage NOMINAL_VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNominalVoltage() <em>Nominal Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalVoltage()
	 * @generated
	 * @ordered
	 */
	protected Voltage nominalVoltage = NOMINAL_VOLTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected Reactance x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance R_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected Resistance r = R_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoltageAngle() <em>Voltage Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageAngle()
	 * @generated
	 * @ordered
	 */
	protected static final AngleRadians VOLTAGE_ANGLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoltageAngle() <em>Voltage Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageAngle()
	 * @generated
	 * @ordered
	 */
	protected AngleRadians voltageAngle = VOLTAGE_ANGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoltageMagnitude() <em>Voltage Magnitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageMagnitude()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage VOLTAGE_MAGNITUDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoltageMagnitude() <em>Voltage Magnitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageMagnitude()
	 * @generated
	 * @ordered
	 */
	protected Voltage voltageMagnitude = VOLTAGE_MAGNITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getX0() <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX0()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance X0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX0() <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX0()
	 * @generated
	 * @ordered
	 */
	protected Reactance x0 = X0_EDEFAULT;

	/**
	 * The default value of the '{@link #getR0() <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR0()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance R0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR0() <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR0()
	 * @generated
	 * @ordered
	 */
	protected Resistance r0 = R0_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivePower() <em>Active Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivePower()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower ACTIVE_POWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivePower() <em>Active Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivePower()
	 * @generated
	 * @ordered
	 */
	protected ActivePower activePower = ACTIVE_POWER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquivalentSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.EQUIVALENT_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXn() {
		return xn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXn(Reactance newXn) {
		Reactance oldXn = xn;
		xn = newXn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__XN, oldXn, xn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getRn() {
		return rn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRn(Resistance newRn) {
		Resistance oldRn = rn;
		rn = newRn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__RN, oldRn, rn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getNominalVoltage() {
		return nominalVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalVoltage(Voltage newNominalVoltage) {
		Voltage oldNominalVoltage = nominalVoltage;
		nominalVoltage = newNominalVoltage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__NOMINAL_VOLTAGE, oldNominalVoltage, nominalVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(Reactance newX) {
		Reactance oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getR() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR(Resistance newR) {
		Resistance oldR = r;
		r = newR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__R, oldR, r));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngleRadians getVoltageAngle() {
		return voltageAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoltageAngle(AngleRadians newVoltageAngle) {
		AngleRadians oldVoltageAngle = voltageAngle;
		voltageAngle = newVoltageAngle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__VOLTAGE_ANGLE, oldVoltageAngle, voltageAngle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getVoltageMagnitude() {
		return voltageMagnitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoltageMagnitude(Voltage newVoltageMagnitude) {
		Voltage oldVoltageMagnitude = voltageMagnitude;
		voltageMagnitude = newVoltageMagnitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE, oldVoltageMagnitude, voltageMagnitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getX0() {
		return x0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX0(Reactance newX0) {
		Reactance oldX0 = x0;
		x0 = newX0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__X0, oldX0, x0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getR0() {
		return r0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR0(Resistance newR0) {
		Resistance oldR0 = r0;
		r0 = newR0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__R0, oldR0, r0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getActivePower() {
		return activePower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivePower(ActivePower newActivePower) {
		ActivePower oldActivePower = activePower;
		activePower = newActivePower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.EQUIVALENT_SOURCE__ACTIVE_POWER, oldActivePower, activePower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.EQUIVALENT_SOURCE__XN:
				return getXn();
			case WirePackage.EQUIVALENT_SOURCE__RN:
				return getRn();
			case WirePackage.EQUIVALENT_SOURCE__NOMINAL_VOLTAGE:
				return getNominalVoltage();
			case WirePackage.EQUIVALENT_SOURCE__X:
				return getX();
			case WirePackage.EQUIVALENT_SOURCE__R:
				return getR();
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_ANGLE:
				return getVoltageAngle();
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE:
				return getVoltageMagnitude();
			case WirePackage.EQUIVALENT_SOURCE__X0:
				return getX0();
			case WirePackage.EQUIVALENT_SOURCE__R0:
				return getR0();
			case WirePackage.EQUIVALENT_SOURCE__ACTIVE_POWER:
				return getActivePower();
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
			case WirePackage.EQUIVALENT_SOURCE__XN:
				setXn((Reactance)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__RN:
				setRn((Resistance)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__NOMINAL_VOLTAGE:
				setNominalVoltage((Voltage)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__X:
				setX((Reactance)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__R:
				setR((Resistance)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_ANGLE:
				setVoltageAngle((AngleRadians)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE:
				setVoltageMagnitude((Voltage)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__X0:
				setX0((Reactance)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__R0:
				setR0((Resistance)newValue);
				return;
			case WirePackage.EQUIVALENT_SOURCE__ACTIVE_POWER:
				setActivePower((ActivePower)newValue);
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
			case WirePackage.EQUIVALENT_SOURCE__XN:
				setXn(XN_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__RN:
				setRn(RN_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__NOMINAL_VOLTAGE:
				setNominalVoltage(NOMINAL_VOLTAGE_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__X:
				setX(X_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__R:
				setR(R_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_ANGLE:
				setVoltageAngle(VOLTAGE_ANGLE_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE:
				setVoltageMagnitude(VOLTAGE_MAGNITUDE_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__X0:
				setX0(X0_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__R0:
				setR0(R0_EDEFAULT);
				return;
			case WirePackage.EQUIVALENT_SOURCE__ACTIVE_POWER:
				setActivePower(ACTIVE_POWER_EDEFAULT);
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
			case WirePackage.EQUIVALENT_SOURCE__XN:
				return XN_EDEFAULT == null ? xn != null : !XN_EDEFAULT.equals(xn);
			case WirePackage.EQUIVALENT_SOURCE__RN:
				return RN_EDEFAULT == null ? rn != null : !RN_EDEFAULT.equals(rn);
			case WirePackage.EQUIVALENT_SOURCE__NOMINAL_VOLTAGE:
				return NOMINAL_VOLTAGE_EDEFAULT == null ? nominalVoltage != null : !NOMINAL_VOLTAGE_EDEFAULT.equals(nominalVoltage);
			case WirePackage.EQUIVALENT_SOURCE__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case WirePackage.EQUIVALENT_SOURCE__R:
				return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_ANGLE:
				return VOLTAGE_ANGLE_EDEFAULT == null ? voltageAngle != null : !VOLTAGE_ANGLE_EDEFAULT.equals(voltageAngle);
			case WirePackage.EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE:
				return VOLTAGE_MAGNITUDE_EDEFAULT == null ? voltageMagnitude != null : !VOLTAGE_MAGNITUDE_EDEFAULT.equals(voltageMagnitude);
			case WirePackage.EQUIVALENT_SOURCE__X0:
				return X0_EDEFAULT == null ? x0 != null : !X0_EDEFAULT.equals(x0);
			case WirePackage.EQUIVALENT_SOURCE__R0:
				return R0_EDEFAULT == null ? r0 != null : !R0_EDEFAULT.equals(r0);
			case WirePackage.EQUIVALENT_SOURCE__ACTIVE_POWER:
				return ACTIVE_POWER_EDEFAULT == null ? activePower != null : !ACTIVE_POWER_EDEFAULT.equals(activePower);
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
		result.append(" (xn: ");
		result.append(xn);
		result.append(", rn: ");
		result.append(rn);
		result.append(", nominalVoltage: ");
		result.append(nominalVoltage);
		result.append(", x: ");
		result.append(x);
		result.append(", r: ");
		result.append(r);
		result.append(", voltageAngle: ");
		result.append(voltageAngle);
		result.append(", voltageMagnitude: ");
		result.append(voltageMagnitude);
		result.append(", x0: ");
		result.append(x0);
		result.append(", r0: ");
		result.append(r0);
		result.append(", activePower: ");
		result.append(activePower);
		result.append(')');
		return result.toString();
	}

} //EquivalentSourceImpl