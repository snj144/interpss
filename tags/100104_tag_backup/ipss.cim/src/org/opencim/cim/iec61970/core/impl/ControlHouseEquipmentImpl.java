/**
 * <copyright>
 * </copyright>
 *
 * $Id: ControlHouseEquipmentImpl.java,v 1.1 2007/03/02 14:01:15 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.ControlHouseEquipment;
import org.opencim.cim.iec61970.core.CorePackage;

import org.opencim.cim.iec61970.domain.ControlHouseEquipmentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control House Equipment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.ControlHouseEquipmentImpl#getControlHouseEquipType <em>Control House Equip Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlHouseEquipmentImpl extends PowerSystemResourceImpl implements ControlHouseEquipment {
	/**
	 * The default value of the '{@link #getControlHouseEquipType() <em>Control House Equip Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlHouseEquipType()
	 * @generated
	 * @ordered
	 */
	protected static final ControlHouseEquipmentType CONTROL_HOUSE_EQUIP_TYPE_EDEFAULT = ControlHouseEquipmentType.TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getControlHouseEquipType() <em>Control House Equip Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlHouseEquipType()
	 * @generated
	 * @ordered
	 */
	protected ControlHouseEquipmentType controlHouseEquipType = CONTROL_HOUSE_EQUIP_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlHouseEquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONTROL_HOUSE_EQUIPMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlHouseEquipmentType getControlHouseEquipType() {
		return controlHouseEquipType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlHouseEquipType(ControlHouseEquipmentType newControlHouseEquipType) {
		ControlHouseEquipmentType oldControlHouseEquipType = controlHouseEquipType;
		controlHouseEquipType = newControlHouseEquipType == null ? CONTROL_HOUSE_EQUIP_TYPE_EDEFAULT : newControlHouseEquipType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE, oldControlHouseEquipType, controlHouseEquipType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE:
				return getControlHouseEquipType();
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
			case CorePackage.CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE:
				setControlHouseEquipType((ControlHouseEquipmentType)newValue);
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
			case CorePackage.CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE:
				setControlHouseEquipType(CONTROL_HOUSE_EQUIP_TYPE_EDEFAULT);
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
			case CorePackage.CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE:
				return controlHouseEquipType != CONTROL_HOUSE_EQUIP_TYPE_EDEFAULT;
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
		result.append(" (controlHouseEquipType: ");
		result.append(controlHouseEquipType);
		result.append(')');
		return result.toString();
	}

} //ControlHouseEquipmentImpl