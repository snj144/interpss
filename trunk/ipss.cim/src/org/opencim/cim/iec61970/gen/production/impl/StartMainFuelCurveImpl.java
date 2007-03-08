/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartMainFuelCurveImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.domain.FuelType;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.StartMainFuelCurve;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Main Fuel Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartMainFuelCurveImpl#getMainFuelType <em>Main Fuel Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartMainFuelCurveImpl extends CurveScheduleImpl implements StartMainFuelCurve {
	/**
	 * The default value of the '{@link #getMainFuelType() <em>Main Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainFuelType()
	 * @generated
	 * @ordered
	 */
	protected static final FuelType MAIN_FUEL_TYPE_EDEFAULT = FuelType.COAL_LITERAL;

	/**
	 * The cached value of the '{@link #getMainFuelType() <em>Main Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainFuelType()
	 * @generated
	 * @ordered
	 */
	protected FuelType mainFuelType = MAIN_FUEL_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartMainFuelCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.START_MAIN_FUEL_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuelType getMainFuelType() {
		return mainFuelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainFuelType(FuelType newMainFuelType) {
		FuelType oldMainFuelType = mainFuelType;
		mainFuelType = newMainFuelType == null ? MAIN_FUEL_TYPE_EDEFAULT : newMainFuelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE, oldMainFuelType, mainFuelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE:
				return getMainFuelType();
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
			case ProductionPackage.START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE:
				setMainFuelType((FuelType)newValue);
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
			case ProductionPackage.START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE:
				setMainFuelType(MAIN_FUEL_TYPE_EDEFAULT);
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
			case ProductionPackage.START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE:
				return mainFuelType != MAIN_FUEL_TYPE_EDEFAULT;
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
		result.append(" (mainFuelType: ");
		result.append(mainFuelType);
		result.append(')');
		return result.toString();
	}

} //StartMainFuelCurveImpl