/**
 * <copyright>
 * </copyright>
 *
 * $Id: VoltageControlZoneImpl.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.wire.BusbarSection;
import org.opencim.cim.iec61970.wire.RegulationSchedule;
import org.opencim.cim.iec61970.wire.VoltageControlZone;
import org.opencim.cim.iec61970.wire.WirePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Voltage Control Zone</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.VoltageControlZoneImpl#getBusbarSection <em>Busbar Section</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.VoltageControlZoneImpl#getRegulationSchedule <em>Regulation Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VoltageControlZoneImpl extends PowerSystemResourceImpl implements VoltageControlZone {
	/**
	 * The cached value of the '{@link #getBusbarSection() <em>Busbar Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusbarSection()
	 * @generated
	 * @ordered
	 */
	protected BusbarSection busbarSection;

	/**
	 * The cached value of the '{@link #getRegulationSchedule() <em>Regulation Schedule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulationSchedule()
	 * @generated
	 * @ordered
	 */
	protected RegulationSchedule regulationSchedule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoltageControlZoneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.VOLTAGE_CONTROL_ZONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusbarSection getBusbarSection() {
		if (busbarSection != null && busbarSection.eIsProxy()) {
			InternalEObject oldBusbarSection = (InternalEObject)busbarSection;
			busbarSection = (BusbarSection)eResolveProxy(oldBusbarSection);
			if (busbarSection != oldBusbarSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION, oldBusbarSection, busbarSection));
			}
		}
		return busbarSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusbarSection basicGetBusbarSection() {
		return busbarSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBusbarSection(BusbarSection newBusbarSection, NotificationChain msgs) {
		BusbarSection oldBusbarSection = busbarSection;
		busbarSection = newBusbarSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION, oldBusbarSection, newBusbarSection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusbarSection(BusbarSection newBusbarSection) {
		if (newBusbarSection != busbarSection) {
			NotificationChain msgs = null;
			if (busbarSection != null)
				msgs = ((InternalEObject)busbarSection).eInverseRemove(this, WirePackage.BUSBAR_SECTION__VOLTAGE_CONTROL_ZONE, BusbarSection.class, msgs);
			if (newBusbarSection != null)
				msgs = ((InternalEObject)newBusbarSection).eInverseAdd(this, WirePackage.BUSBAR_SECTION__VOLTAGE_CONTROL_ZONE, BusbarSection.class, msgs);
			msgs = basicSetBusbarSection(newBusbarSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION, newBusbarSection, newBusbarSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegulationSchedule getRegulationSchedule() {
		if (regulationSchedule != null && regulationSchedule.eIsProxy()) {
			InternalEObject oldRegulationSchedule = (InternalEObject)regulationSchedule;
			regulationSchedule = (RegulationSchedule)eResolveProxy(oldRegulationSchedule);
			if (regulationSchedule != oldRegulationSchedule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE, oldRegulationSchedule, regulationSchedule));
			}
		}
		return regulationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegulationSchedule basicGetRegulationSchedule() {
		return regulationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegulationSchedule(RegulationSchedule newRegulationSchedule, NotificationChain msgs) {
		RegulationSchedule oldRegulationSchedule = regulationSchedule;
		regulationSchedule = newRegulationSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE, oldRegulationSchedule, newRegulationSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegulationSchedule(RegulationSchedule newRegulationSchedule) {
		if (newRegulationSchedule != regulationSchedule) {
			NotificationChain msgs = null;
			if (regulationSchedule != null)
				msgs = ((InternalEObject)regulationSchedule).eInverseRemove(this, WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES, RegulationSchedule.class, msgs);
			if (newRegulationSchedule != null)
				msgs = ((InternalEObject)newRegulationSchedule).eInverseAdd(this, WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES, RegulationSchedule.class, msgs);
			msgs = basicSetRegulationSchedule(newRegulationSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE, newRegulationSchedule, newRegulationSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION:
				if (busbarSection != null)
					msgs = ((InternalEObject)busbarSection).eInverseRemove(this, WirePackage.BUSBAR_SECTION__VOLTAGE_CONTROL_ZONE, BusbarSection.class, msgs);
				return basicSetBusbarSection((BusbarSection)otherEnd, msgs);
			case WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE:
				if (regulationSchedule != null)
					msgs = ((InternalEObject)regulationSchedule).eInverseRemove(this, WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES, RegulationSchedule.class, msgs);
				return basicSetRegulationSchedule((RegulationSchedule)otherEnd, msgs);
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
			case WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION:
				return basicSetBusbarSection(null, msgs);
			case WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE:
				return basicSetRegulationSchedule(null, msgs);
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
			case WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION:
				if (resolve) return getBusbarSection();
				return basicGetBusbarSection();
			case WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE:
				if (resolve) return getRegulationSchedule();
				return basicGetRegulationSchedule();
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
			case WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION:
				setBusbarSection((BusbarSection)newValue);
				return;
			case WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE:
				setRegulationSchedule((RegulationSchedule)newValue);
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
			case WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION:
				setBusbarSection((BusbarSection)null);
				return;
			case WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE:
				setRegulationSchedule((RegulationSchedule)null);
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
			case WirePackage.VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION:
				return busbarSection != null;
			case WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE:
				return regulationSchedule != null;
		}
		return super.eIsSet(featureID);
	}

} //VoltageControlZoneImpl