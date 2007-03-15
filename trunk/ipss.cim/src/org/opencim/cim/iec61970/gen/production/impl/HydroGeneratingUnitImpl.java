/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroGeneratingUnitImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve;
import org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit;
import org.opencim.cim.iec61970.gen.production.PenstockLossCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.TailbayLossCurve;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hydro Generating Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl#getHydroUnitWaterCost <em>Hydro Unit Water Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl#getHydroGeneratingEfficiencyCurves <em>Hydro Generating Efficiency Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl#getPenstockLossCurve <em>Penstock Loss Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl#getTailbayLossCurve <em>Tailbay Loss Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HydroGeneratingUnitImpl extends GeneratingUnitImpl implements HydroGeneratingUnit {
	/**
	 * The default value of the '{@link #getHydroUnitWaterCost() <em>Hydro Unit Water Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroUnitWaterCost()
	 * @generated
	 * @ordered
	 */
	protected static final Float HYDRO_UNIT_WATER_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHydroUnitWaterCost() <em>Hydro Unit Water Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroUnitWaterCost()
	 * @generated
	 * @ordered
	 */
	protected Float hydroUnitWaterCost = HYDRO_UNIT_WATER_COST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHydroGeneratingEfficiencyCurves() <em>Hydro Generating Efficiency Curves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroGeneratingEfficiencyCurves()
	 * @generated
	 * @ordered
	 */
	protected EList hydroGeneratingEfficiencyCurves = null;

	/**
	 * The cached value of the '{@link #getPenstockLossCurve() <em>Penstock Loss Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenstockLossCurve()
	 * @generated
	 * @ordered
	 */
	protected PenstockLossCurve penstockLossCurve = null;

	/**
	 * The cached value of the '{@link #getTailbayLossCurve() <em>Tailbay Loss Curve</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTailbayLossCurve()
	 * @generated
	 * @ordered
	 */
	protected EList tailbayLossCurve = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HydroGeneratingUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.HYDRO_GENERATING_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getHydroUnitWaterCost() {
		return hydroUnitWaterCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHydroUnitWaterCost(Float newHydroUnitWaterCost) {
		Float oldHydroUnitWaterCost = hydroUnitWaterCost;
		hydroUnitWaterCost = newHydroUnitWaterCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST, oldHydroUnitWaterCost, hydroUnitWaterCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getHydroGeneratingEfficiencyCurves() {
		if (hydroGeneratingEfficiencyCurves == null) {
			hydroGeneratingEfficiencyCurves = new EObjectContainmentEList(HydroGeneratingEfficiencyCurve.class, this, ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES);
		}
		return hydroGeneratingEfficiencyCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PenstockLossCurve getPenstockLossCurve() {
		return penstockLossCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPenstockLossCurve(PenstockLossCurve newPenstockLossCurve, NotificationChain msgs) {
		PenstockLossCurve oldPenstockLossCurve = penstockLossCurve;
		penstockLossCurve = newPenstockLossCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE, oldPenstockLossCurve, newPenstockLossCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPenstockLossCurve(PenstockLossCurve newPenstockLossCurve) {
		if (newPenstockLossCurve != penstockLossCurve) {
			NotificationChain msgs = null;
			if (penstockLossCurve != null)
				msgs = ((InternalEObject)penstockLossCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE, null, msgs);
			if (newPenstockLossCurve != null)
				msgs = ((InternalEObject)newPenstockLossCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE, null, msgs);
			msgs = basicSetPenstockLossCurve(newPenstockLossCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE, newPenstockLossCurve, newPenstockLossCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTailbayLossCurve() {
		if (tailbayLossCurve == null) {
			tailbayLossCurve = new EObjectContainmentEList(TailbayLossCurve.class, this, ProductionPackage.HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE);
		}
		return tailbayLossCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES:
				return ((InternalEList)getHydroGeneratingEfficiencyCurves()).basicRemove(otherEnd, msgs);
			case ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE:
				return basicSetPenstockLossCurve(null, msgs);
			case ProductionPackage.HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE:
				return ((InternalEList)getTailbayLossCurve()).basicRemove(otherEnd, msgs);
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
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST:
				return getHydroUnitWaterCost();
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES:
				return getHydroGeneratingEfficiencyCurves();
			case ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE:
				return getPenstockLossCurve();
			case ProductionPackage.HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE:
				return getTailbayLossCurve();
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
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST:
				setHydroUnitWaterCost((Float)newValue);
				return;
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES:
				getHydroGeneratingEfficiencyCurves().clear();
				getHydroGeneratingEfficiencyCurves().addAll((Collection)newValue);
				return;
			case ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE:
				setPenstockLossCurve((PenstockLossCurve)newValue);
				return;
			case ProductionPackage.HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE:
				getTailbayLossCurve().clear();
				getTailbayLossCurve().addAll((Collection)newValue);
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
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST:
				setHydroUnitWaterCost(HYDRO_UNIT_WATER_COST_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES:
				getHydroGeneratingEfficiencyCurves().clear();
				return;
			case ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE:
				setPenstockLossCurve((PenstockLossCurve)null);
				return;
			case ProductionPackage.HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE:
				getTailbayLossCurve().clear();
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
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST:
				return HYDRO_UNIT_WATER_COST_EDEFAULT == null ? hydroUnitWaterCost != null : !HYDRO_UNIT_WATER_COST_EDEFAULT.equals(hydroUnitWaterCost);
			case ProductionPackage.HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES:
				return hydroGeneratingEfficiencyCurves != null && !hydroGeneratingEfficiencyCurves.isEmpty();
			case ProductionPackage.HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE:
				return penstockLossCurve != null;
			case ProductionPackage.HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE:
				return tailbayLossCurve != null && !tailbayLossCurve.isEmpty();
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
		result.append(" (hydroUnitWaterCost: ");
		result.append(hydroUnitWaterCost);
		result.append(')');
		return result.toString();
	}

} //HydroGeneratingUnitImpl