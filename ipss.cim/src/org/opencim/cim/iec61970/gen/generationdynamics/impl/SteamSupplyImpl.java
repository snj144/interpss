/**
 * <copyright>
 * </copyright>
 *
 * $Id: SteamSupplyImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
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

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamSupplyImpl#getSteamSupplyRating <em>Steam Supply Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamSupplyImpl#getSteamTurbines <em>Steam Turbines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SteamSupplyImpl extends PowerSystemResourceImpl implements SteamSupply {
	/**
	 * The default value of the '{@link #getSteamSupplyRating() <em>Steam Supply Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamSupplyRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float STEAM_SUPPLY_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSteamSupplyRating() <em>Steam Supply Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamSupplyRating()
	 * @generated
	 * @ordered
	 */
	protected Float steamSupplyRating = STEAM_SUPPLY_RATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSteamTurbines() <em>Steam Turbines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamTurbines()
	 * @generated
	 * @ordered
	 */
	protected EList steamTurbines = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SteamSupplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.STEAM_SUPPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSteamSupplyRating() {
		return steamSupplyRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamSupplyRating(Float newSteamSupplyRating) {
		Float oldSteamSupplyRating = steamSupplyRating;
		steamSupplyRating = newSteamSupplyRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_SUPPLY_RATING, oldSteamSupplyRating, steamSupplyRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSteamTurbines() {
		if (steamTurbines == null) {
			steamTurbines = new EObjectWithInverseResolvingEList.ManyInverse(SteamTurbine.class, this, GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES, GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS);
		}
		return steamTurbines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES:
				return ((InternalEList)getSteamTurbines()).basicAdd(otherEnd, msgs);
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
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES:
				return ((InternalEList)getSteamTurbines()).basicRemove(otherEnd, msgs);
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
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_SUPPLY_RATING:
				return getSteamSupplyRating();
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES:
				return getSteamTurbines();
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
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_SUPPLY_RATING:
				setSteamSupplyRating((Float)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES:
				getSteamTurbines().clear();
				getSteamTurbines().addAll((Collection)newValue);
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
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_SUPPLY_RATING:
				setSteamSupplyRating(STEAM_SUPPLY_RATING_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES:
				getSteamTurbines().clear();
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
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_SUPPLY_RATING:
				return STEAM_SUPPLY_RATING_EDEFAULT == null ? steamSupplyRating != null : !STEAM_SUPPLY_RATING_EDEFAULT.equals(steamSupplyRating);
			case GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES:
				return steamTurbines != null && !steamTurbines.isEmpty();
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
		result.append(" (steamSupplyRating: ");
		result.append(steamSupplyRating);
		result.append(')');
		return result.toString();
	}

} //SteamSupplyImpl