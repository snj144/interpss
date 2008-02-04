/**
 * <copyright>
 * </copyright>
 *
 * $Id: CombinedCyclePlantImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.gen.production.CombinedCyclePlant;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit;

import org.opencim.datatype.real.ActivePower;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combined Cycle Plant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CombinedCyclePlantImpl#getCombCyclePlantRating <em>Comb Cycle Plant Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CombinedCyclePlantImpl#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CombinedCyclePlantImpl extends PowerSystemResourceImpl implements CombinedCyclePlant {
	/**
	 * The default value of the '{@link #getCombCyclePlantRating() <em>Comb Cycle Plant Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombCyclePlantRating()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower COMB_CYCLE_PLANT_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCombCyclePlantRating() <em>Comb Cycle Plant Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombCyclePlantRating()
	 * @generated
	 * @ordered
	 */
	protected ActivePower combCyclePlantRating = COMB_CYCLE_PLANT_RATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContain_ThermalGeneratingUnits() <em>Contain Thermal Generating Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContain_ThermalGeneratingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList contain_ThermalGeneratingUnits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CombinedCyclePlantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.COMBINED_CYCLE_PLANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getCombCyclePlantRating() {
		return combCyclePlantRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombCyclePlantRating(ActivePower newCombCyclePlantRating) {
		ActivePower oldCombCyclePlantRating = combCyclePlantRating;
		combCyclePlantRating = newCombCyclePlantRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING, oldCombCyclePlantRating, combCyclePlantRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContain_ThermalGeneratingUnits() {
		if (contain_ThermalGeneratingUnits == null) {
			contain_ThermalGeneratingUnits = new EObjectWithInverseResolvingEList(ThermalGeneratingUnit.class, this, ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT);
		}
		return contain_ThermalGeneratingUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
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
			case ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return ((InternalEList)getContain_ThermalGeneratingUnits()).basicRemove(otherEnd, msgs);
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
			case ProductionPackage.COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING:
				return getCombCyclePlantRating();
			case ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return getContain_ThermalGeneratingUnits();
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
			case ProductionPackage.COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING:
				setCombCyclePlantRating((ActivePower)newValue);
				return;
			case ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				getContain_ThermalGeneratingUnits().clear();
				getContain_ThermalGeneratingUnits().addAll((Collection)newValue);
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
			case ProductionPackage.COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING:
				setCombCyclePlantRating(COMB_CYCLE_PLANT_RATING_EDEFAULT);
				return;
			case ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				getContain_ThermalGeneratingUnits().clear();
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
			case ProductionPackage.COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING:
				return COMB_CYCLE_PLANT_RATING_EDEFAULT == null ? combCyclePlantRating != null : !COMB_CYCLE_PLANT_RATING_EDEFAULT.equals(combCyclePlantRating);
			case ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS:
				return contain_ThermalGeneratingUnits != null && !contain_ThermalGeneratingUnits.isEmpty();
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
		result.append(" (combCyclePlantRating: ");
		result.append(combCyclePlantRating);
		result.append(')');
		return result.toString();
	}

} //CombinedCyclePlantImpl