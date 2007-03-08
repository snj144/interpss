/**
 * <copyright>
 * </copyright>
 *
 * $Id: AreaLoadCurveImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.load.AreaLoadCurve;
import org.opencim.cim.iec61970.load.DayType;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.Season;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area Load Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl#getLoadArea <em>Load Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl#getDayType <em>Day Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl#getSeason <em>Season</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AreaLoadCurveImpl extends CurveScheduleImpl implements AreaLoadCurve {
	/**
	 * The cached value of the '{@link #getDayType() <em>Day Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDayType()
	 * @generated
	 * @ordered
	 */
	protected DayType dayType = null;

	/**
	 * The cached value of the '{@link #getSeason() <em>Season</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeason()
	 * @generated
	 * @ordered
	 */
	protected Season season = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaLoadCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.AREA_LOAD_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea getLoadArea() {
		if (eContainerFeatureID != LoadPackage.AREA_LOAD_CURVE__LOAD_AREA) return null;
		return (LoadArea)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoadArea(LoadArea newLoadArea, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLoadArea, LoadPackage.AREA_LOAD_CURVE__LOAD_AREA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadArea(LoadArea newLoadArea) {
		if (newLoadArea != eInternalContainer() || (eContainerFeatureID != LoadPackage.AREA_LOAD_CURVE__LOAD_AREA && newLoadArea != null)) {
			if (EcoreUtil.isAncestor(this, newLoadArea))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLoadArea != null)
				msgs = ((InternalEObject)newLoadArea).eInverseAdd(this, LoadPackage.LOAD_AREA__AREA_LOAD_CURVES, LoadArea.class, msgs);
			msgs = basicSetLoadArea(newLoadArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.AREA_LOAD_CURVE__LOAD_AREA, newLoadArea, newLoadArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DayType getDayType() {
		if (dayType != null && dayType.eIsProxy()) {
			InternalEObject oldDayType = (InternalEObject)dayType;
			dayType = (DayType)eResolveProxy(oldDayType);
			if (dayType != oldDayType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoadPackage.AREA_LOAD_CURVE__DAY_TYPE, oldDayType, dayType));
			}
		}
		return dayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DayType basicGetDayType() {
		return dayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDayType(DayType newDayType, NotificationChain msgs) {
		DayType oldDayType = dayType;
		dayType = newDayType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LoadPackage.AREA_LOAD_CURVE__DAY_TYPE, oldDayType, newDayType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDayType(DayType newDayType) {
		if (newDayType != dayType) {
			NotificationChain msgs = null;
			if (dayType != null)
				msgs = ((InternalEObject)dayType).eInverseRemove(this, LoadPackage.DAY_TYPE__AREA_LOAD_CURVES, DayType.class, msgs);
			if (newDayType != null)
				msgs = ((InternalEObject)newDayType).eInverseAdd(this, LoadPackage.DAY_TYPE__AREA_LOAD_CURVES, DayType.class, msgs);
			msgs = basicSetDayType(newDayType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.AREA_LOAD_CURVE__DAY_TYPE, newDayType, newDayType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season getSeason() {
		if (season != null && season.eIsProxy()) {
			InternalEObject oldSeason = (InternalEObject)season;
			season = (Season)eResolveProxy(oldSeason);
			if (season != oldSeason) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoadPackage.AREA_LOAD_CURVE__SEASON, oldSeason, season));
			}
		}
		return season;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season basicGetSeason() {
		return season;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeason(Season newSeason, NotificationChain msgs) {
		Season oldSeason = season;
		season = newSeason;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LoadPackage.AREA_LOAD_CURVE__SEASON, oldSeason, newSeason);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeason(Season newSeason) {
		if (newSeason != season) {
			NotificationChain msgs = null;
			if (season != null)
				msgs = ((InternalEObject)season).eInverseRemove(this, LoadPackage.SEASON__AREA_LOAD_CURVES, Season.class, msgs);
			if (newSeason != null)
				msgs = ((InternalEObject)newSeason).eInverseAdd(this, LoadPackage.SEASON__AREA_LOAD_CURVES, Season.class, msgs);
			msgs = basicSetSeason(newSeason, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.AREA_LOAD_CURVE__SEASON, newSeason, newSeason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLoadArea((LoadArea)otherEnd, msgs);
			case LoadPackage.AREA_LOAD_CURVE__DAY_TYPE:
				if (dayType != null)
					msgs = ((InternalEObject)dayType).eInverseRemove(this, LoadPackage.DAY_TYPE__AREA_LOAD_CURVES, DayType.class, msgs);
				return basicSetDayType((DayType)otherEnd, msgs);
			case LoadPackage.AREA_LOAD_CURVE__SEASON:
				if (season != null)
					msgs = ((InternalEObject)season).eInverseRemove(this, LoadPackage.SEASON__AREA_LOAD_CURVES, Season.class, msgs);
				return basicSetSeason((Season)otherEnd, msgs);
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
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				return basicSetLoadArea(null, msgs);
			case LoadPackage.AREA_LOAD_CURVE__DAY_TYPE:
				return basicSetDayType(null, msgs);
			case LoadPackage.AREA_LOAD_CURVE__SEASON:
				return basicSetSeason(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				return eInternalContainer().eInverseRemove(this, LoadPackage.LOAD_AREA__AREA_LOAD_CURVES, LoadArea.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				return getLoadArea();
			case LoadPackage.AREA_LOAD_CURVE__DAY_TYPE:
				if (resolve) return getDayType();
				return basicGetDayType();
			case LoadPackage.AREA_LOAD_CURVE__SEASON:
				if (resolve) return getSeason();
				return basicGetSeason();
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
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				setLoadArea((LoadArea)newValue);
				return;
			case LoadPackage.AREA_LOAD_CURVE__DAY_TYPE:
				setDayType((DayType)newValue);
				return;
			case LoadPackage.AREA_LOAD_CURVE__SEASON:
				setSeason((Season)newValue);
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
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				setLoadArea((LoadArea)null);
				return;
			case LoadPackage.AREA_LOAD_CURVE__DAY_TYPE:
				setDayType((DayType)null);
				return;
			case LoadPackage.AREA_LOAD_CURVE__SEASON:
				setSeason((Season)null);
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
			case LoadPackage.AREA_LOAD_CURVE__LOAD_AREA:
				return getLoadArea() != null;
			case LoadPackage.AREA_LOAD_CURVE__DAY_TYPE:
				return dayType != null;
			case LoadPackage.AREA_LOAD_CURVE__SEASON:
				return season != null;
		}
		return super.eIsSet(featureID);
	}

} //AreaLoadCurveImpl