/**
 * <copyright>
 * </copyright>
 *
 * $Id: TargetLevelScheduleImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.TargetLevelSchedule;

import org.opencim.datatype.real.WaterLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Level Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.TargetLevelScheduleImpl#getHighLevelLimit <em>High Level Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.TargetLevelScheduleImpl#getLowLevelLimit <em>Low Level Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetLevelScheduleImpl extends CurveScheduleImpl implements TargetLevelSchedule {
	/**
	 * The default value of the '{@link #getHighLevelLimit() <em>High Level Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighLevelLimit()
	 * @generated
	 * @ordered
	 */
	protected static final WaterLevel HIGH_LEVEL_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHighLevelLimit() <em>High Level Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighLevelLimit()
	 * @generated
	 * @ordered
	 */
	protected WaterLevel highLevelLimit = HIGH_LEVEL_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowLevelLimit() <em>Low Level Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowLevelLimit()
	 * @generated
	 * @ordered
	 */
	protected static final WaterLevel LOW_LEVEL_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowLevelLimit() <em>Low Level Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowLevelLimit()
	 * @generated
	 * @ordered
	 */
	protected WaterLevel lowLevelLimit = LOW_LEVEL_LIMIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetLevelScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.TARGET_LEVEL_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel getHighLevelLimit() {
		return highLevelLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighLevelLimit(WaterLevel newHighLevelLimit) {
		WaterLevel oldHighLevelLimit = highLevelLimit;
		highLevelLimit = newHighLevelLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT, oldHighLevelLimit, highLevelLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel getLowLevelLimit() {
		return lowLevelLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowLevelLimit(WaterLevel newLowLevelLimit) {
		WaterLevel oldLowLevelLimit = lowLevelLimit;
		lowLevelLimit = newLowLevelLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT, oldLowLevelLimit, lowLevelLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT:
				return getHighLevelLimit();
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT:
				return getLowLevelLimit();
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
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT:
				setHighLevelLimit((WaterLevel)newValue);
				return;
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT:
				setLowLevelLimit((WaterLevel)newValue);
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
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT:
				setHighLevelLimit(HIGH_LEVEL_LIMIT_EDEFAULT);
				return;
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT:
				setLowLevelLimit(LOW_LEVEL_LIMIT_EDEFAULT);
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
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT:
				return HIGH_LEVEL_LIMIT_EDEFAULT == null ? highLevelLimit != null : !HIGH_LEVEL_LIMIT_EDEFAULT.equals(highLevelLimit);
			case ProductionPackage.TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT:
				return LOW_LEVEL_LIMIT_EDEFAULT == null ? lowLevelLimit != null : !LOW_LEVEL_LIMIT_EDEFAULT.equals(lowLevelLimit);
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
		result.append(" (highLevelLimit: ");
		result.append(highLevelLimit);
		result.append(", lowLevelLimit: ");
		result.append(lowLevelLimit);
		result.append(')');
		return result.toString();
	}

} //TargetLevelScheduleImpl