/**
 * <copyright>
 * </copyright>
 *
 * $Id: NonConformLoadScheduleImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.NonConformLoadSchedule;

import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Conform Load Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.NonConformLoadScheduleImpl#getEnergyConsumer <em>Energy Consumer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonConformLoadScheduleImpl extends CurveScheduleImpl implements NonConformLoadSchedule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonConformLoadScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.NON_CONFORM_LOAD_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyConsumer getEnergyConsumer() {
		if (eContainerFeatureID != LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER) return null;
		return (EnergyConsumer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnergyConsumer(EnergyConsumer newEnergyConsumer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEnergyConsumer, LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyConsumer(EnergyConsumer newEnergyConsumer) {
		if (newEnergyConsumer != eInternalContainer() || (eContainerFeatureID != LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER && newEnergyConsumer != null)) {
			if (EcoreUtil.isAncestor(this, newEnergyConsumer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEnergyConsumer != null)
				msgs = ((InternalEObject)newEnergyConsumer).eInverseAdd(this, WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES, EnergyConsumer.class, msgs);
			msgs = basicSetEnergyConsumer(newEnergyConsumer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER, newEnergyConsumer, newEnergyConsumer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEnergyConsumer((EnergyConsumer)otherEnd, msgs);
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
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				return basicSetEnergyConsumer(null, msgs);
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
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				return eInternalContainer().eInverseRemove(this, WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES, EnergyConsumer.class, msgs);
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
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				return getEnergyConsumer();
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
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				setEnergyConsumer((EnergyConsumer)newValue);
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
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				setEnergyConsumer((EnergyConsumer)null);
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
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER:
				return getEnergyConsumer() != null;
		}
		return super.eIsSet(featureID);
	}

} //NonConformLoadScheduleImpl