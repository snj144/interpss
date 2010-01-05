/**
 * <copyright>
 * </copyright>
 *
 * $Id: SeasonImpl.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.domain.SeasonName;

import org.opencim.cim.iec61970.load.AreaLoadCurve;
import org.opencim.cim.iec61970.load.LoadDemandModel;
import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.Season;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Season</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.SeasonImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.SeasonImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.SeasonImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.SeasonImpl#getAreaLoadCurves <em>Area Load Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.SeasonImpl#getLoadDemandModels <em>Load Demand Models</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeasonImpl extends EObjectImpl implements Season {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final SeasonName NAME_EDEFAULT = SeasonName.WINTER_LITERAL;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected SeasonName name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

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
	protected SeasonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.SEASON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeasonName getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(SeasonName newName) {
		SeasonName oldName = name;
		name = newName == null ? NAME_EDEFAULT : newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.SEASON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.SEASON__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.SEASON__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAreaLoadCurves() {
		if (areaLoadCurves == null) {
			areaLoadCurves = new EObjectWithInverseResolvingEList(AreaLoadCurve.class, this, LoadPackage.SEASON__AREA_LOAD_CURVES, LoadPackage.AREA_LOAD_CURVE__SEASON);
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
			loadDemandModels = new EObjectWithInverseResolvingEList(LoadDemandModel.class, this, LoadPackage.SEASON__LOAD_DEMAND_MODELS, LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR);
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
			case LoadPackage.SEASON__AREA_LOAD_CURVES:
				return ((InternalEList)getAreaLoadCurves()).basicAdd(otherEnd, msgs);
			case LoadPackage.SEASON__LOAD_DEMAND_MODELS:
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
			case LoadPackage.SEASON__AREA_LOAD_CURVES:
				return ((InternalEList)getAreaLoadCurves()).basicRemove(otherEnd, msgs);
			case LoadPackage.SEASON__LOAD_DEMAND_MODELS:
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
			case LoadPackage.SEASON__NAME:
				return getName();
			case LoadPackage.SEASON__END_DATE:
				return getEndDate();
			case LoadPackage.SEASON__START_DATE:
				return getStartDate();
			case LoadPackage.SEASON__AREA_LOAD_CURVES:
				return getAreaLoadCurves();
			case LoadPackage.SEASON__LOAD_DEMAND_MODELS:
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
			case LoadPackage.SEASON__NAME:
				setName((SeasonName)newValue);
				return;
			case LoadPackage.SEASON__END_DATE:
				setEndDate((Date)newValue);
				return;
			case LoadPackage.SEASON__START_DATE:
				setStartDate((Date)newValue);
				return;
			case LoadPackage.SEASON__AREA_LOAD_CURVES:
				getAreaLoadCurves().clear();
				getAreaLoadCurves().addAll((Collection)newValue);
				return;
			case LoadPackage.SEASON__LOAD_DEMAND_MODELS:
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
			case LoadPackage.SEASON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LoadPackage.SEASON__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case LoadPackage.SEASON__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case LoadPackage.SEASON__AREA_LOAD_CURVES:
				getAreaLoadCurves().clear();
				return;
			case LoadPackage.SEASON__LOAD_DEMAND_MODELS:
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
			case LoadPackage.SEASON__NAME:
				return name != NAME_EDEFAULT;
			case LoadPackage.SEASON__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case LoadPackage.SEASON__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case LoadPackage.SEASON__AREA_LOAD_CURVES:
				return areaLoadCurves != null && !areaLoadCurves.isEmpty();
			case LoadPackage.SEASON__LOAD_DEMAND_MODELS:
				return loadDemandModels != null && !loadDemandModels.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(')');
		return result.toString();
	}

} //SeasonImpl