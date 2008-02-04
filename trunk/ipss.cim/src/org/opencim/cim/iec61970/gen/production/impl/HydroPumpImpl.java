/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroPumpImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.gen.production.HydroPump;
import org.opencim.cim.iec61970.gen.production.HydroPumpOpSchedule;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.datatype.real.ActivePower;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hydro Pump</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl#getPumpDischAtMaxHead <em>Pump Disch At Max Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl#getPumpDischAtMinHead <em>Pump Disch At Min Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl#getPumpPowerAtMaxHead <em>Pump Power At Max Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl#getPumpPowerAtMinHead <em>Pump Power At Min Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl#getHydroPumpOpSchedule <em>Hydro Pump Op Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HydroPumpImpl extends PowerSystemResourceImpl implements HydroPump {
	/**
	 * The default value of the '{@link #getPumpDischAtMaxHead() <em>Pump Disch At Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpDischAtMaxHead()
	 * @generated
	 * @ordered
	 */
	protected static final Float PUMP_DISCH_AT_MAX_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPumpDischAtMaxHead() <em>Pump Disch At Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpDischAtMaxHead()
	 * @generated
	 * @ordered
	 */
	protected Float pumpDischAtMaxHead = PUMP_DISCH_AT_MAX_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPumpDischAtMinHead() <em>Pump Disch At Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpDischAtMinHead()
	 * @generated
	 * @ordered
	 */
	protected static final Float PUMP_DISCH_AT_MIN_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPumpDischAtMinHead() <em>Pump Disch At Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpDischAtMinHead()
	 * @generated
	 * @ordered
	 */
	protected Float pumpDischAtMinHead = PUMP_DISCH_AT_MIN_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPumpPowerAtMaxHead() <em>Pump Power At Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpPowerAtMaxHead()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower PUMP_POWER_AT_MAX_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPumpPowerAtMaxHead() <em>Pump Power At Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpPowerAtMaxHead()
	 * @generated
	 * @ordered
	 */
	protected ActivePower pumpPowerAtMaxHead = PUMP_POWER_AT_MAX_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPumpPowerAtMinHead() <em>Pump Power At Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpPowerAtMinHead()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower PUMP_POWER_AT_MIN_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPumpPowerAtMinHead() <em>Pump Power At Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPumpPowerAtMinHead()
	 * @generated
	 * @ordered
	 */
	protected ActivePower pumpPowerAtMinHead = PUMP_POWER_AT_MIN_HEAD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHydroPumpOpSchedule() <em>Hydro Pump Op Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroPumpOpSchedule()
	 * @generated
	 * @ordered
	 */
	protected HydroPumpOpSchedule hydroPumpOpSchedule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HydroPumpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.HYDRO_PUMP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPumpDischAtMaxHead() {
		return pumpDischAtMaxHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPumpDischAtMaxHead(Float newPumpDischAtMaxHead) {
		Float oldPumpDischAtMaxHead = pumpDischAtMaxHead;
		pumpDischAtMaxHead = newPumpDischAtMaxHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD, oldPumpDischAtMaxHead, pumpDischAtMaxHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPumpDischAtMinHead() {
		return pumpDischAtMinHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPumpDischAtMinHead(Float newPumpDischAtMinHead) {
		Float oldPumpDischAtMinHead = pumpDischAtMinHead;
		pumpDischAtMinHead = newPumpDischAtMinHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD, oldPumpDischAtMinHead, pumpDischAtMinHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getPumpPowerAtMaxHead() {
		return pumpPowerAtMaxHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPumpPowerAtMaxHead(ActivePower newPumpPowerAtMaxHead) {
		ActivePower oldPumpPowerAtMaxHead = pumpPowerAtMaxHead;
		pumpPowerAtMaxHead = newPumpPowerAtMaxHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD, oldPumpPowerAtMaxHead, pumpPowerAtMaxHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getPumpPowerAtMinHead() {
		return pumpPowerAtMinHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPumpPowerAtMinHead(ActivePower newPumpPowerAtMinHead) {
		ActivePower oldPumpPowerAtMinHead = pumpPowerAtMinHead;
		pumpPowerAtMinHead = newPumpPowerAtMinHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD, oldPumpPowerAtMinHead, pumpPowerAtMinHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPumpOpSchedule getHydroPumpOpSchedule() {
		return hydroPumpOpSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHydroPumpOpSchedule(HydroPumpOpSchedule newHydroPumpOpSchedule, NotificationChain msgs) {
		HydroPumpOpSchedule oldHydroPumpOpSchedule = hydroPumpOpSchedule;
		hydroPumpOpSchedule = newHydroPumpOpSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE, oldHydroPumpOpSchedule, newHydroPumpOpSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHydroPumpOpSchedule(HydroPumpOpSchedule newHydroPumpOpSchedule) {
		if (newHydroPumpOpSchedule != hydroPumpOpSchedule) {
			NotificationChain msgs = null;
			if (hydroPumpOpSchedule != null)
				msgs = ((InternalEObject)hydroPumpOpSchedule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE, null, msgs);
			if (newHydroPumpOpSchedule != null)
				msgs = ((InternalEObject)newHydroPumpOpSchedule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE, null, msgs);
			msgs = basicSetHydroPumpOpSchedule(newHydroPumpOpSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE, newHydroPumpOpSchedule, newHydroPumpOpSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE:
				return basicSetHydroPumpOpSchedule(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD:
				return getPumpDischAtMaxHead();
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD:
				return getPumpDischAtMinHead();
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD:
				return getPumpPowerAtMaxHead();
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD:
				return getPumpPowerAtMinHead();
			case ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE:
				return getHydroPumpOpSchedule();
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
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD:
				setPumpDischAtMaxHead((Float)newValue);
				return;
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD:
				setPumpDischAtMinHead((Float)newValue);
				return;
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD:
				setPumpPowerAtMaxHead((ActivePower)newValue);
				return;
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD:
				setPumpPowerAtMinHead((ActivePower)newValue);
				return;
			case ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE:
				setHydroPumpOpSchedule((HydroPumpOpSchedule)newValue);
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
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD:
				setPumpDischAtMaxHead(PUMP_DISCH_AT_MAX_HEAD_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD:
				setPumpDischAtMinHead(PUMP_DISCH_AT_MIN_HEAD_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD:
				setPumpPowerAtMaxHead(PUMP_POWER_AT_MAX_HEAD_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD:
				setPumpPowerAtMinHead(PUMP_POWER_AT_MIN_HEAD_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE:
				setHydroPumpOpSchedule((HydroPumpOpSchedule)null);
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
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD:
				return PUMP_DISCH_AT_MAX_HEAD_EDEFAULT == null ? pumpDischAtMaxHead != null : !PUMP_DISCH_AT_MAX_HEAD_EDEFAULT.equals(pumpDischAtMaxHead);
			case ProductionPackage.HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD:
				return PUMP_DISCH_AT_MIN_HEAD_EDEFAULT == null ? pumpDischAtMinHead != null : !PUMP_DISCH_AT_MIN_HEAD_EDEFAULT.equals(pumpDischAtMinHead);
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD:
				return PUMP_POWER_AT_MAX_HEAD_EDEFAULT == null ? pumpPowerAtMaxHead != null : !PUMP_POWER_AT_MAX_HEAD_EDEFAULT.equals(pumpPowerAtMaxHead);
			case ProductionPackage.HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD:
				return PUMP_POWER_AT_MIN_HEAD_EDEFAULT == null ? pumpPowerAtMinHead != null : !PUMP_POWER_AT_MIN_HEAD_EDEFAULT.equals(pumpPowerAtMinHead);
			case ProductionPackage.HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE:
				return hydroPumpOpSchedule != null;
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
		result.append(" (pumpDischAtMaxHead: ");
		result.append(pumpDischAtMaxHead);
		result.append(", pumpDischAtMinHead: ");
		result.append(pumpDischAtMinHead);
		result.append(", pumpPowerAtMaxHead: ");
		result.append(pumpPowerAtMaxHead);
		result.append(", pumpPowerAtMinHead: ");
		result.append(pumpPowerAtMinHead);
		result.append(')');
		return result.toString();
	}

} //HydroPumpImpl