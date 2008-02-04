/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeSwitchImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

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

import org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl;

import org.opencim.cim.iec61970.wire.CompositeSwitch;
import org.opencim.cim.iec61970.wire.Switch;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.string.CompositeSwitchType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Switch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompositeSwitchImpl#getCompositeSwitchType <em>Composite Switch Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompositeSwitchImpl#getSwitches <em>Switches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeSwitchImpl extends EquipmentContainerImpl implements CompositeSwitch {
	/**
	 * The default value of the '{@link #getCompositeSwitchType() <em>Composite Switch Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeSwitchType()
	 * @generated
	 * @ordered
	 */
	protected static final CompositeSwitchType COMPOSITE_SWITCH_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompositeSwitchType() <em>Composite Switch Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeSwitchType()
	 * @generated
	 * @ordered
	 */
	protected CompositeSwitchType compositeSwitchType = COMPOSITE_SWITCH_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSwitches() <em>Switches</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitches()
	 * @generated
	 * @ordered
	 */
	protected EList switches;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeSwitchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.COMPOSITE_SWITCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSwitchType getCompositeSwitchType() {
		return compositeSwitchType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeSwitchType(CompositeSwitchType newCompositeSwitchType) {
		CompositeSwitchType oldCompositeSwitchType = compositeSwitchType;
		compositeSwitchType = newCompositeSwitchType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE, oldCompositeSwitchType, compositeSwitchType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSwitches() {
		if (switches == null) {
			switches = new EObjectWithInverseResolvingEList(Switch.class, this, WirePackage.COMPOSITE_SWITCH__SWITCHES, WirePackage.SWITCH__COMPOSITE_SWITCH);
		}
		return switches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.COMPOSITE_SWITCH__SWITCHES:
				return ((InternalEList)getSwitches()).basicAdd(otherEnd, msgs);
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
			case WirePackage.COMPOSITE_SWITCH__SWITCHES:
				return ((InternalEList)getSwitches()).basicRemove(otherEnd, msgs);
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
			case WirePackage.COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE:
				return getCompositeSwitchType();
			case WirePackage.COMPOSITE_SWITCH__SWITCHES:
				return getSwitches();
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
			case WirePackage.COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE:
				setCompositeSwitchType((CompositeSwitchType)newValue);
				return;
			case WirePackage.COMPOSITE_SWITCH__SWITCHES:
				getSwitches().clear();
				getSwitches().addAll((Collection)newValue);
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
			case WirePackage.COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE:
				setCompositeSwitchType(COMPOSITE_SWITCH_TYPE_EDEFAULT);
				return;
			case WirePackage.COMPOSITE_SWITCH__SWITCHES:
				getSwitches().clear();
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
			case WirePackage.COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE:
				return COMPOSITE_SWITCH_TYPE_EDEFAULT == null ? compositeSwitchType != null : !COMPOSITE_SWITCH_TYPE_EDEFAULT.equals(compositeSwitchType);
			case WirePackage.COMPOSITE_SWITCH__SWITCHES:
				return switches != null && !switches.isEmpty();
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
		result.append(" (compositeSwitchType: ");
		result.append(compositeSwitchType);
		result.append(')');
		return result.toString();
	}

} //CompositeSwitchImpl