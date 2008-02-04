/**
 * <copyright>
 * </copyright>
 *
 * $Id: SwitchImpl.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl;

import org.opencim.cim.iec61970.wire.CompositeSwitch;
import org.opencim.cim.iec61970.wire.Switch;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.integer.Counter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SwitchImpl#getNormalOpen <em>Normal Open</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SwitchImpl#getSwitchOnCount <em>Switch On Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SwitchImpl#getSwitchOnDate <em>Switch On Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SwitchImpl#getCompositeSwitch <em>Composite Switch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchImpl extends ConductingEquipmentImpl implements Switch {
	/**
	 * The default value of the '{@link #getNormalOpen() <em>Normal Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalOpen()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean NORMAL_OPEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNormalOpen() <em>Normal Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalOpen()
	 * @generated
	 * @ordered
	 */
	protected Boolean normalOpen = NORMAL_OPEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSwitchOnCount() <em>Switch On Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnCount()
	 * @generated
	 * @ordered
	 */
	protected static final Counter SWITCH_ON_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSwitchOnCount() <em>Switch On Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnCount()
	 * @generated
	 * @ordered
	 */
	protected Counter switchOnCount = SWITCH_ON_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSwitchOnDate() <em>Switch On Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date SWITCH_ON_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSwitchOnDate() <em>Switch On Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnDate()
	 * @generated
	 * @ordered
	 */
	protected Date switchOnDate = SWITCH_ON_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompositeSwitch() <em>Composite Switch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeSwitch()
	 * @generated
	 * @ordered
	 */
	protected CompositeSwitch compositeSwitch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.SWITCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getNormalOpen() {
		return normalOpen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalOpen(Boolean newNormalOpen) {
		Boolean oldNormalOpen = normalOpen;
		normalOpen = newNormalOpen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SWITCH__NORMAL_OPEN, oldNormalOpen, normalOpen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getSwitchOnCount() {
		return switchOnCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchOnCount(Counter newSwitchOnCount) {
		Counter oldSwitchOnCount = switchOnCount;
		switchOnCount = newSwitchOnCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SWITCH__SWITCH_ON_COUNT, oldSwitchOnCount, switchOnCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getSwitchOnDate() {
		return switchOnDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchOnDate(Date newSwitchOnDate) {
		Date oldSwitchOnDate = switchOnDate;
		switchOnDate = newSwitchOnDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SWITCH__SWITCH_ON_DATE, oldSwitchOnDate, switchOnDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSwitch getCompositeSwitch() {
		if (compositeSwitch != null && compositeSwitch.eIsProxy()) {
			InternalEObject oldCompositeSwitch = (InternalEObject)compositeSwitch;
			compositeSwitch = (CompositeSwitch)eResolveProxy(oldCompositeSwitch);
			if (compositeSwitch != oldCompositeSwitch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.SWITCH__COMPOSITE_SWITCH, oldCompositeSwitch, compositeSwitch));
			}
		}
		return compositeSwitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSwitch basicGetCompositeSwitch() {
		return compositeSwitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompositeSwitch(CompositeSwitch newCompositeSwitch, NotificationChain msgs) {
		CompositeSwitch oldCompositeSwitch = compositeSwitch;
		compositeSwitch = newCompositeSwitch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.SWITCH__COMPOSITE_SWITCH, oldCompositeSwitch, newCompositeSwitch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeSwitch(CompositeSwitch newCompositeSwitch) {
		if (newCompositeSwitch != compositeSwitch) {
			NotificationChain msgs = null;
			if (compositeSwitch != null)
				msgs = ((InternalEObject)compositeSwitch).eInverseRemove(this, WirePackage.COMPOSITE_SWITCH__SWITCHES, CompositeSwitch.class, msgs);
			if (newCompositeSwitch != null)
				msgs = ((InternalEObject)newCompositeSwitch).eInverseAdd(this, WirePackage.COMPOSITE_SWITCH__SWITCHES, CompositeSwitch.class, msgs);
			msgs = basicSetCompositeSwitch(newCompositeSwitch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SWITCH__COMPOSITE_SWITCH, newCompositeSwitch, newCompositeSwitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.SWITCH__COMPOSITE_SWITCH:
				if (compositeSwitch != null)
					msgs = ((InternalEObject)compositeSwitch).eInverseRemove(this, WirePackage.COMPOSITE_SWITCH__SWITCHES, CompositeSwitch.class, msgs);
				return basicSetCompositeSwitch((CompositeSwitch)otherEnd, msgs);
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
			case WirePackage.SWITCH__COMPOSITE_SWITCH:
				return basicSetCompositeSwitch(null, msgs);
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
			case WirePackage.SWITCH__NORMAL_OPEN:
				return getNormalOpen();
			case WirePackage.SWITCH__SWITCH_ON_COUNT:
				return getSwitchOnCount();
			case WirePackage.SWITCH__SWITCH_ON_DATE:
				return getSwitchOnDate();
			case WirePackage.SWITCH__COMPOSITE_SWITCH:
				if (resolve) return getCompositeSwitch();
				return basicGetCompositeSwitch();
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
			case WirePackage.SWITCH__NORMAL_OPEN:
				setNormalOpen((Boolean)newValue);
				return;
			case WirePackage.SWITCH__SWITCH_ON_COUNT:
				setSwitchOnCount((Counter)newValue);
				return;
			case WirePackage.SWITCH__SWITCH_ON_DATE:
				setSwitchOnDate((Date)newValue);
				return;
			case WirePackage.SWITCH__COMPOSITE_SWITCH:
				setCompositeSwitch((CompositeSwitch)newValue);
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
			case WirePackage.SWITCH__NORMAL_OPEN:
				setNormalOpen(NORMAL_OPEN_EDEFAULT);
				return;
			case WirePackage.SWITCH__SWITCH_ON_COUNT:
				setSwitchOnCount(SWITCH_ON_COUNT_EDEFAULT);
				return;
			case WirePackage.SWITCH__SWITCH_ON_DATE:
				setSwitchOnDate(SWITCH_ON_DATE_EDEFAULT);
				return;
			case WirePackage.SWITCH__COMPOSITE_SWITCH:
				setCompositeSwitch((CompositeSwitch)null);
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
			case WirePackage.SWITCH__NORMAL_OPEN:
				return NORMAL_OPEN_EDEFAULT == null ? normalOpen != null : !NORMAL_OPEN_EDEFAULT.equals(normalOpen);
			case WirePackage.SWITCH__SWITCH_ON_COUNT:
				return SWITCH_ON_COUNT_EDEFAULT == null ? switchOnCount != null : !SWITCH_ON_COUNT_EDEFAULT.equals(switchOnCount);
			case WirePackage.SWITCH__SWITCH_ON_DATE:
				return SWITCH_ON_DATE_EDEFAULT == null ? switchOnDate != null : !SWITCH_ON_DATE_EDEFAULT.equals(switchOnDate);
			case WirePackage.SWITCH__COMPOSITE_SWITCH:
				return compositeSwitch != null;
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
		result.append(" (normalOpen: ");
		result.append(normalOpen);
		result.append(", switchOnCount: ");
		result.append(switchOnCount);
		result.append(", switchOnDate: ");
		result.append(switchOnDate);
		result.append(')');
		return result.toString();
	}

} //SwitchImpl