/**
 * <copyright>
 * </copyright>
 *
 * $Id: CogenerationPlantImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

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

import org.opencim.cim.iec61970.gen.production.CogenerationPlant;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.SteamSendoutSchedule;
import org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit;

import org.opencim.datatype.real.ActivePower;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cogeneration Plant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getCogenHPSendoutRating <em>Cogen HP Sendout Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getCogenHPSteamRating <em>Cogen HP Steam Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getCogenLPSendoutRating <em>Cogen LP Sendout Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getCogenLPSteamRating <em>Cogen LP Steam Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getCogenPlantMWRating <em>Cogen Plant MW Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl#getSteamSendoutSchedule <em>Steam Sendout Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CogenerationPlantImpl extends PowerSystemResourceImpl implements CogenerationPlant {
	/**
	 * The default value of the '{@link #getCogenHPSendoutRating() <em>Cogen HP Sendout Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenHPSendoutRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float COGEN_HP_SENDOUT_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCogenHPSendoutRating() <em>Cogen HP Sendout Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenHPSendoutRating()
	 * @generated
	 * @ordered
	 */
	protected Float cogenHPSendoutRating = COGEN_HP_SENDOUT_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getCogenHPSteamRating() <em>Cogen HP Steam Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenHPSteamRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float COGEN_HP_STEAM_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCogenHPSteamRating() <em>Cogen HP Steam Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenHPSteamRating()
	 * @generated
	 * @ordered
	 */
	protected Float cogenHPSteamRating = COGEN_HP_STEAM_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getCogenLPSendoutRating() <em>Cogen LP Sendout Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenLPSendoutRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float COGEN_LP_SENDOUT_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCogenLPSendoutRating() <em>Cogen LP Sendout Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenLPSendoutRating()
	 * @generated
	 * @ordered
	 */
	protected Float cogenLPSendoutRating = COGEN_LP_SENDOUT_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getCogenLPSteamRating() <em>Cogen LP Steam Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenLPSteamRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float COGEN_LP_STEAM_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCogenLPSteamRating() <em>Cogen LP Steam Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenLPSteamRating()
	 * @generated
	 * @ordered
	 */
	protected Float cogenLPSteamRating = COGEN_LP_STEAM_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getCogenPlantMWRating() <em>Cogen Plant MW Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenPlantMWRating()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower COGEN_PLANT_MW_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCogenPlantMWRating() <em>Cogen Plant MW Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCogenPlantMWRating()
	 * @generated
	 * @ordered
	 */
	protected ActivePower cogenPlantMWRating = COGEN_PLANT_MW_RATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContain_ThermalGeneratingUnits() <em>Contain Thermal Generating Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContain_ThermalGeneratingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList contain_ThermalGeneratingUnits = null;

	/**
	 * The cached value of the '{@link #getSteamSendoutSchedule() <em>Steam Sendout Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamSendoutSchedule()
	 * @generated
	 * @ordered
	 */
	protected SteamSendoutSchedule steamSendoutSchedule = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CogenerationPlantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.COGENERATION_PLANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getCogenHPSendoutRating() {
		return cogenHPSendoutRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCogenHPSendoutRating(Float newCogenHPSendoutRating) {
		Float oldCogenHPSendoutRating = cogenHPSendoutRating;
		cogenHPSendoutRating = newCogenHPSendoutRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING, oldCogenHPSendoutRating, cogenHPSendoutRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getCogenHPSteamRating() {
		return cogenHPSteamRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCogenHPSteamRating(Float newCogenHPSteamRating) {
		Float oldCogenHPSteamRating = cogenHPSteamRating;
		cogenHPSteamRating = newCogenHPSteamRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__COGEN_HP_STEAM_RATING, oldCogenHPSteamRating, cogenHPSteamRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getCogenLPSendoutRating() {
		return cogenLPSendoutRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCogenLPSendoutRating(Float newCogenLPSendoutRating) {
		Float oldCogenLPSendoutRating = cogenLPSendoutRating;
		cogenLPSendoutRating = newCogenLPSendoutRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING, oldCogenLPSendoutRating, cogenLPSendoutRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getCogenLPSteamRating() {
		return cogenLPSteamRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCogenLPSteamRating(Float newCogenLPSteamRating) {
		Float oldCogenLPSteamRating = cogenLPSteamRating;
		cogenLPSteamRating = newCogenLPSteamRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__COGEN_LP_STEAM_RATING, oldCogenLPSteamRating, cogenLPSteamRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getCogenPlantMWRating() {
		return cogenPlantMWRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCogenPlantMWRating(ActivePower newCogenPlantMWRating) {
		ActivePower oldCogenPlantMWRating = cogenPlantMWRating;
		cogenPlantMWRating = newCogenPlantMWRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__COGEN_PLANT_MW_RATING, oldCogenPlantMWRating, cogenPlantMWRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContain_ThermalGeneratingUnits() {
		if (contain_ThermalGeneratingUnits == null) {
			contain_ThermalGeneratingUnits = new EObjectWithInverseResolvingEList(ThermalGeneratingUnit.class, this, ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT);
		}
		return contain_ThermalGeneratingUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteamSendoutSchedule getSteamSendoutSchedule() {
		return steamSendoutSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSteamSendoutSchedule(SteamSendoutSchedule newSteamSendoutSchedule, NotificationChain msgs) {
		SteamSendoutSchedule oldSteamSendoutSchedule = steamSendoutSchedule;
		steamSendoutSchedule = newSteamSendoutSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE, oldSteamSendoutSchedule, newSteamSendoutSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamSendoutSchedule(SteamSendoutSchedule newSteamSendoutSchedule) {
		if (newSteamSendoutSchedule != steamSendoutSchedule) {
			NotificationChain msgs = null;
			if (steamSendoutSchedule != null)
				msgs = ((InternalEObject)steamSendoutSchedule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE, null, msgs);
			if (newSteamSendoutSchedule != null)
				msgs = ((InternalEObject)newSteamSendoutSchedule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE, null, msgs);
			msgs = basicSetSteamSendoutSchedule(newSteamSendoutSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE, newSteamSendoutSchedule, newSteamSendoutSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return ((InternalEList)getContain_ThermalGeneratingUnits()).basicAdd(otherEnd, msgs);
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
			case ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return ((InternalEList)getContain_ThermalGeneratingUnits()).basicRemove(otherEnd, msgs);
			case ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE:
				return basicSetSteamSendoutSchedule(null, msgs);
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
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING:
				return getCogenHPSendoutRating();
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_STEAM_RATING:
				return getCogenHPSteamRating();
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING:
				return getCogenLPSendoutRating();
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_STEAM_RATING:
				return getCogenLPSteamRating();
			case ProductionPackage.COGENERATION_PLANT__COGEN_PLANT_MW_RATING:
				return getCogenPlantMWRating();
			case ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return getContain_ThermalGeneratingUnits();
			case ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE:
				return getSteamSendoutSchedule();
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
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING:
				setCogenHPSendoutRating((Float)newValue);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_STEAM_RATING:
				setCogenHPSteamRating((Float)newValue);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING:
				setCogenLPSendoutRating((Float)newValue);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_STEAM_RATING:
				setCogenLPSteamRating((Float)newValue);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_PLANT_MW_RATING:
				setCogenPlantMWRating((ActivePower)newValue);
				return;
			case ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				getContain_ThermalGeneratingUnits().clear();
				getContain_ThermalGeneratingUnits().addAll((Collection)newValue);
				return;
			case ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE:
				setSteamSendoutSchedule((SteamSendoutSchedule)newValue);
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
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING:
				setCogenHPSendoutRating(COGEN_HP_SENDOUT_RATING_EDEFAULT);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_STEAM_RATING:
				setCogenHPSteamRating(COGEN_HP_STEAM_RATING_EDEFAULT);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING:
				setCogenLPSendoutRating(COGEN_LP_SENDOUT_RATING_EDEFAULT);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_STEAM_RATING:
				setCogenLPSteamRating(COGEN_LP_STEAM_RATING_EDEFAULT);
				return;
			case ProductionPackage.COGENERATION_PLANT__COGEN_PLANT_MW_RATING:
				setCogenPlantMWRating(COGEN_PLANT_MW_RATING_EDEFAULT);
				return;
			case ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				getContain_ThermalGeneratingUnits().clear();
				return;
			case ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE:
				setSteamSendoutSchedule((SteamSendoutSchedule)null);
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
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING:
				return COGEN_HP_SENDOUT_RATING_EDEFAULT == null ? cogenHPSendoutRating != null : !COGEN_HP_SENDOUT_RATING_EDEFAULT.equals(cogenHPSendoutRating);
			case ProductionPackage.COGENERATION_PLANT__COGEN_HP_STEAM_RATING:
				return COGEN_HP_STEAM_RATING_EDEFAULT == null ? cogenHPSteamRating != null : !COGEN_HP_STEAM_RATING_EDEFAULT.equals(cogenHPSteamRating);
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING:
				return COGEN_LP_SENDOUT_RATING_EDEFAULT == null ? cogenLPSendoutRating != null : !COGEN_LP_SENDOUT_RATING_EDEFAULT.equals(cogenLPSendoutRating);
			case ProductionPackage.COGENERATION_PLANT__COGEN_LP_STEAM_RATING:
				return COGEN_LP_STEAM_RATING_EDEFAULT == null ? cogenLPSteamRating != null : !COGEN_LP_STEAM_RATING_EDEFAULT.equals(cogenLPSteamRating);
			case ProductionPackage.COGENERATION_PLANT__COGEN_PLANT_MW_RATING:
				return COGEN_PLANT_MW_RATING_EDEFAULT == null ? cogenPlantMWRating != null : !COGEN_PLANT_MW_RATING_EDEFAULT.equals(cogenPlantMWRating);
			case ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return contain_ThermalGeneratingUnits != null && !contain_ThermalGeneratingUnits.isEmpty();
			case ProductionPackage.COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE:
				return steamSendoutSchedule != null;
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
		result.append(" (cogenHPSendoutRating: ");
		result.append(cogenHPSendoutRating);
		result.append(", cogenHPSteamRating: ");
		result.append(cogenHPSteamRating);
		result.append(", cogenLPSendoutRating: ");
		result.append(cogenLPSendoutRating);
		result.append(", cogenLPSteamRating: ");
		result.append(cogenLPSteamRating);
		result.append(", cogenPlantMWRating: ");
		result.append(cogenPlantMWRating);
		result.append(')');
		return result.toString();
	}

} //CogenerationPlantImpl