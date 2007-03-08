/**
 * <copyright>
 * </copyright>
 *
 * $Id: HeatRecoveryBoilerImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Heat Recovery Boiler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HeatRecoveryBoilerImpl#getSteamSupplyRating2 <em>Steam Supply Rating2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HeatRecoveryBoilerImpl#getCombustionTurbines <em>Combustion Turbines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HeatRecoveryBoilerImpl extends FossilSteamSupplyImpl implements HeatRecoveryBoiler {
	/**
	 * The default value of the '{@link #getSteamSupplyRating2() <em>Steam Supply Rating2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamSupplyRating2()
	 * @generated
	 * @ordered
	 */
	protected static final Float STEAM_SUPPLY_RATING2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSteamSupplyRating2() <em>Steam Supply Rating2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamSupplyRating2()
	 * @generated
	 * @ordered
	 */
	protected Float steamSupplyRating2 = STEAM_SUPPLY_RATING2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCombustionTurbines() <em>Combustion Turbines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombustionTurbines()
	 * @generated
	 * @ordered
	 */
	protected EList combustionTurbines = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeatRecoveryBoilerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.HEAT_RECOVERY_BOILER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSteamSupplyRating2() {
		return steamSupplyRating2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamSupplyRating2(Float newSteamSupplyRating2) {
		Float oldSteamSupplyRating2 = steamSupplyRating2;
		steamSupplyRating2 = newSteamSupplyRating2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__STEAM_SUPPLY_RATING2, oldSteamSupplyRating2, steamSupplyRating2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCombustionTurbines() {
		if (combustionTurbines == null) {
			combustionTurbines = new EObjectWithInverseResolvingEList(CombustionTurbine.class, this, GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES, GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER);
		}
		return combustionTurbines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES:
				return ((InternalEList)getCombustionTurbines()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES:
				return ((InternalEList)getCombustionTurbines()).basicRemove(otherEnd, msgs);
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
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__STEAM_SUPPLY_RATING2:
				return getSteamSupplyRating2();
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES:
				return getCombustionTurbines();
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
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__STEAM_SUPPLY_RATING2:
				setSteamSupplyRating2((Float)newValue);
				return;
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES:
				getCombustionTurbines().clear();
				getCombustionTurbines().addAll((Collection)newValue);
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
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__STEAM_SUPPLY_RATING2:
				setSteamSupplyRating2(STEAM_SUPPLY_RATING2_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES:
				getCombustionTurbines().clear();
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
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__STEAM_SUPPLY_RATING2:
				return STEAM_SUPPLY_RATING2_EDEFAULT == null ? steamSupplyRating2 != null : !STEAM_SUPPLY_RATING2_EDEFAULT.equals(steamSupplyRating2);
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES:
				return combustionTurbines != null && !combustionTurbines.isEmpty();
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
		result.append(" (steamSupplyRating2: ");
		result.append(steamSupplyRating2);
		result.append(')');
		return result.toString();
	}

} //HeatRecoveryBoilerImpl