/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartIgnFuelCurveImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.domain.FuelType;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Ign Fuel Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartIgnFuelCurveImpl#getIgnitionFuelType <em>Ignition Fuel Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartIgnFuelCurveImpl extends CurveScheduleImpl implements StartIgnFuelCurve {
	/**
	 * The default value of the '{@link #getIgnitionFuelType() <em>Ignition Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnitionFuelType()
	 * @generated
	 * @ordered
	 */
	protected static final FuelType IGNITION_FUEL_TYPE_EDEFAULT = FuelType.COAL_LITERAL;

	/**
	 * The cached value of the '{@link #getIgnitionFuelType() <em>Ignition Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnitionFuelType()
	 * @generated
	 * @ordered
	 */
	protected FuelType ignitionFuelType = IGNITION_FUEL_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartIgnFuelCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.START_IGN_FUEL_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuelType getIgnitionFuelType() {
		return ignitionFuelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnitionFuelType(FuelType newIgnitionFuelType) {
		FuelType oldIgnitionFuelType = ignitionFuelType;
		ignitionFuelType = newIgnitionFuelType == null ? IGNITION_FUEL_TYPE_EDEFAULT : newIgnitionFuelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE, oldIgnitionFuelType, ignitionFuelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE:
				return getIgnitionFuelType();
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
			case ProductionPackage.START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE:
				setIgnitionFuelType((FuelType)newValue);
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
			case ProductionPackage.START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE:
				setIgnitionFuelType(IGNITION_FUEL_TYPE_EDEFAULT);
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
			case ProductionPackage.START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE:
				return ignitionFuelType != IGNITION_FUEL_TYPE_EDEFAULT;
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
		result.append(" (ignitionFuelType: ");
		result.append(ignitionFuelType);
		result.append(')');
		return result.toString();
	}

} //StartIgnFuelCurveImpl