/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartRampCurveImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.StartRampCurve;

import org.opencim.datatype.real.PowerROCPerMin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Ramp Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartRampCurveImpl#getHotStandbyRamp <em>Hot Standby Ramp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartRampCurveImpl extends CurveScheduleImpl implements StartRampCurve {
	/**
	 * The default value of the '{@link #getHotStandbyRamp() <em>Hot Standby Ramp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotStandbyRamp()
	 * @generated
	 * @ordered
	 */
	protected static final PowerROCPerMin HOT_STANDBY_RAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHotStandbyRamp() <em>Hot Standby Ramp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotStandbyRamp()
	 * @generated
	 * @ordered
	 */
	protected PowerROCPerMin hotStandbyRamp = HOT_STANDBY_RAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartRampCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.START_RAMP_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerMin getHotStandbyRamp() {
		return hotStandbyRamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHotStandbyRamp(PowerROCPerMin newHotStandbyRamp) {
		PowerROCPerMin oldHotStandbyRamp = hotStandbyRamp;
		hotStandbyRamp = newHotStandbyRamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.START_RAMP_CURVE__HOT_STANDBY_RAMP, oldHotStandbyRamp, hotStandbyRamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.START_RAMP_CURVE__HOT_STANDBY_RAMP:
				return getHotStandbyRamp();
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
			case ProductionPackage.START_RAMP_CURVE__HOT_STANDBY_RAMP:
				setHotStandbyRamp((PowerROCPerMin)newValue);
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
			case ProductionPackage.START_RAMP_CURVE__HOT_STANDBY_RAMP:
				setHotStandbyRamp(HOT_STANDBY_RAMP_EDEFAULT);
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
			case ProductionPackage.START_RAMP_CURVE__HOT_STANDBY_RAMP:
				return HOT_STANDBY_RAMP_EDEFAULT == null ? hotStandbyRamp != null : !HOT_STANDBY_RAMP_EDEFAULT.equals(hotStandbyRamp);
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
		result.append(" (hotStandbyRamp: ");
		result.append(hotStandbyRamp);
		result.append(')');
		return result.toString();
	}

} //StartRampCurveImpl