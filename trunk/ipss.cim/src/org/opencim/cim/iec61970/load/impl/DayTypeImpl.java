/**
 * <copyright>
 * </copyright>
 *
 * $Id: DayTypeImpl.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.load.AreaLoadCurve;
import org.opencim.cim.iec61970.load.DayType;
import org.opencim.cim.iec61970.load.LoadDemandModel;
import org.opencim.cim.iec61970.load.LoadPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Day Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.DayTypeImpl#getAreaLoadCurves <em>Area Load Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.DayTypeImpl#getLoadDemandModels <em>Load Demand Models</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DayTypeImpl extends NamingImpl implements DayType {
	/**
	 * The cached value of the '{@link #getAreaLoadCurves() <em>Area Load Curves</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaLoadCurves()
	 * @generated
	 * @ordered
	 */
	protected EList areaLoadCurves;

	/**
	 * The cached value of the '{@link #getLoadDemandModels() <em>Load Demand Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadDemandModels()
	 * @generated
	 * @ordered
	 */
	protected EList loadDemandModels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DayTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.DAY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAreaLoadCurves() {
		if (areaLoadCurves == null) {
			areaLoadCurves = new EObjectWithInverseResolvingEList(AreaLoadCurve.class, this, LoadPackage.DAY_TYPE__AREA_LOAD_CURVES, LoadPackage.AREA_LOAD_CURVE__DAY_TYPE);
		}
		return areaLoadCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLoadDemandModels() {
		if (loadDemandModels == null) {
			loadDemandModels = new EObjectWithInverseResolvingEList(LoadDemandModel.class, this, LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS, LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE);
		}
		return loadDemandModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.DAY_TYPE__AREA_LOAD_CURVES:
				return ((InternalEList)getAreaLoadCurves()).basicAdd(otherEnd, msgs);
			case LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS:
				return ((InternalEList)getLoadDemandModels()).basicAdd(otherEnd, msgs);
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
			case LoadPackage.DAY_TYPE__AREA_LOAD_CURVES:
				return ((InternalEList)getAreaLoadCurves()).basicRemove(otherEnd, msgs);
			case LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS:
				return ((InternalEList)getLoadDemandModels()).basicRemove(otherEnd, msgs);
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
			case LoadPackage.DAY_TYPE__AREA_LOAD_CURVES:
				return getAreaLoadCurves();
			case LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS:
				return getLoadDemandModels();
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
			case LoadPackage.DAY_TYPE__AREA_LOAD_CURVES:
				getAreaLoadCurves().clear();
				getAreaLoadCurves().addAll((Collection)newValue);
				return;
			case LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS:
				getLoadDemandModels().clear();
				getLoadDemandModels().addAll((Collection)newValue);
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
			case LoadPackage.DAY_TYPE__AREA_LOAD_CURVES:
				getAreaLoadCurves().clear();
				return;
			case LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS:
				getLoadDemandModels().clear();
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
			case LoadPackage.DAY_TYPE__AREA_LOAD_CURVES:
				return areaLoadCurves != null && !areaLoadCurves.isEmpty();
			case LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS:
				return loadDemandModels != null && !loadDemandModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DayTypeImpl