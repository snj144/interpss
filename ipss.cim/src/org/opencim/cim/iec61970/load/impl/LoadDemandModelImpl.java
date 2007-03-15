/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadDemandModelImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.load.DayType;
import org.opencim.cim.iec61970.load.LoadDemandModel;
import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.Season;

import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Demand Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl#getEnergyConsumer <em>Energy Consumer</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl#getBasisFor <em>Basis For</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl#getDayType <em>Day Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadDemandModelImpl extends CurveScheduleImpl implements LoadDemandModel {
	/**
	 * The cached value of the '{@link #getBasisFor() <em>Basis For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasisFor()
	 * @generated
	 * @ordered
	 */
	protected Season basisFor = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadDemandModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.LOAD_DEMAND_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyConsumer getEnergyConsumer() {
		if (eContainerFeatureID != LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER) return null;
		return (EnergyConsumer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnergyConsumer(EnergyConsumer newEnergyConsumer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEnergyConsumer, LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyConsumer(EnergyConsumer newEnergyConsumer) {
		if (newEnergyConsumer != eInternalContainer() || (eContainerFeatureID != LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER && newEnergyConsumer != null)) {
			if (EcoreUtil.isAncestor(this, newEnergyConsumer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEnergyConsumer != null)
				msgs = ((InternalEObject)newEnergyConsumer).eInverseAdd(this, WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS, EnergyConsumer.class, msgs);
			msgs = basicSetEnergyConsumer(newEnergyConsumer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER, newEnergyConsumer, newEnergyConsumer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season getBasisFor() {
		if (basisFor != null && basisFor.eIsProxy()) {
			InternalEObject oldBasisFor = (InternalEObject)basisFor;
			basisFor = (Season)eResolveProxy(oldBasisFor);
			if (basisFor != oldBasisFor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR, oldBasisFor, basisFor));
			}
		}
		return basisFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season basicGetBasisFor() {
		return basisFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasisFor(Season newBasisFor, NotificationChain msgs) {
		Season oldBasisFor = basisFor;
		basisFor = newBasisFor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR, oldBasisFor, newBasisFor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisFor(Season newBasisFor) {
		if (newBasisFor != basisFor) {
			NotificationChain msgs = null;
			if (basisFor != null)
				msgs = ((InternalEObject)basisFor).eInverseRemove(this, LoadPackage.SEASON__LOAD_DEMAND_MODELS, Season.class, msgs);
			if (newBasisFor != null)
				msgs = ((InternalEObject)newBasisFor).eInverseAdd(this, LoadPackage.SEASON__LOAD_DEMAND_MODELS, Season.class, msgs);
			msgs = basicSetBasisFor(newBasisFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR, newBasisFor, newBasisFor));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE, oldDayType, dayType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE, oldDayType, newDayType);
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
				msgs = ((InternalEObject)dayType).eInverseRemove(this, LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS, DayType.class, msgs);
			if (newDayType != null)
				msgs = ((InternalEObject)newDayType).eInverseAdd(this, LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS, DayType.class, msgs);
			msgs = basicSetDayType(newDayType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE, newDayType, newDayType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEnergyConsumer((EnergyConsumer)otherEnd, msgs);
			case LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR:
				if (basisFor != null)
					msgs = ((InternalEObject)basisFor).eInverseRemove(this, LoadPackage.SEASON__LOAD_DEMAND_MODELS, Season.class, msgs);
				return basicSetBasisFor((Season)otherEnd, msgs);
			case LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE:
				if (dayType != null)
					msgs = ((InternalEObject)dayType).eInverseRemove(this, LoadPackage.DAY_TYPE__LOAD_DEMAND_MODELS, DayType.class, msgs);
				return basicSetDayType((DayType)otherEnd, msgs);
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
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				return basicSetEnergyConsumer(null, msgs);
			case LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR:
				return basicSetBasisFor(null, msgs);
			case LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE:
				return basicSetDayType(null, msgs);
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
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				return eInternalContainer().eInverseRemove(this, WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS, EnergyConsumer.class, msgs);
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
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				return getEnergyConsumer();
			case LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR:
				if (resolve) return getBasisFor();
				return basicGetBasisFor();
			case LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE:
				if (resolve) return getDayType();
				return basicGetDayType();
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
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				setEnergyConsumer((EnergyConsumer)newValue);
				return;
			case LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR:
				setBasisFor((Season)newValue);
				return;
			case LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE:
				setDayType((DayType)newValue);
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
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				setEnergyConsumer((EnergyConsumer)null);
				return;
			case LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR:
				setBasisFor((Season)null);
				return;
			case LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE:
				setDayType((DayType)null);
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
			case LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER:
				return getEnergyConsumer() != null;
			case LoadPackage.LOAD_DEMAND_MODEL__BASIS_FOR:
				return basisFor != null;
			case LoadPackage.LOAD_DEMAND_MODEL__DAY_TYPE:
				return dayType != null;
		}
		return super.eIsSet(featureID);
	}

} //LoadDemandModelImpl