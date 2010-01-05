/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireArrangementImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.wire.ConductorType;
import org.opencim.cim.iec61970.wire.WireArrangement;
import org.opencim.cim.iec61970.wire.WirePackage;
import org.opencim.cim.iec61970.wire.WireType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arrangement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireArrangementImpl#getMountingPointX <em>Mounting Point X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireArrangementImpl#getMountingPointY <em>Mounting Point Y</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireArrangementImpl#getConductorType <em>Conductor Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireArrangementImpl#getWireType <em>Wire Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WireArrangementImpl extends NamingImpl implements WireArrangement {
	/**
	 * The default value of the '{@link #getMountingPointX() <em>Mounting Point X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountingPointX()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MOUNTING_POINT_X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMountingPointX() <em>Mounting Point X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountingPointX()
	 * @generated
	 * @ordered
	 */
	protected Integer mountingPointX = MOUNTING_POINT_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getMountingPointY() <em>Mounting Point Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountingPointY()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MOUNTING_POINT_Y_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMountingPointY() <em>Mounting Point Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountingPointY()
	 * @generated
	 * @ordered
	 */
	protected Integer mountingPointY = MOUNTING_POINT_Y_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConductorType() <em>Conductor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConductorType()
	 * @generated
	 * @ordered
	 */
	protected ConductorType conductorType;

	/**
	 * The cached value of the '{@link #getWireType() <em>Wire Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWireType()
	 * @generated
	 * @ordered
	 */
	protected WireType wireType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WireArrangementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.WIRE_ARRANGEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMountingPointX() {
		return mountingPointX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMountingPointX(Integer newMountingPointX) {
		Integer oldMountingPointX = mountingPointX;
		mountingPointX = newMountingPointX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_X, oldMountingPointX, mountingPointX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMountingPointY() {
		return mountingPointY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMountingPointY(Integer newMountingPointY) {
		Integer oldMountingPointY = mountingPointY;
		mountingPointY = newMountingPointY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_Y, oldMountingPointY, mountingPointY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConductorType getConductorType() {
		if (conductorType != null && conductorType.eIsProxy()) {
			InternalEObject oldConductorType = (InternalEObject)conductorType;
			conductorType = (ConductorType)eResolveProxy(oldConductorType);
			if (conductorType != oldConductorType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE, oldConductorType, conductorType));
			}
		}
		return conductorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConductorType basicGetConductorType() {
		return conductorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConductorType(ConductorType newConductorType, NotificationChain msgs) {
		ConductorType oldConductorType = conductorType;
		conductorType = newConductorType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE, oldConductorType, newConductorType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConductorType(ConductorType newConductorType) {
		if (newConductorType != conductorType) {
			NotificationChain msgs = null;
			if (conductorType != null)
				msgs = ((InternalEObject)conductorType).eInverseRemove(this, WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS, ConductorType.class, msgs);
			if (newConductorType != null)
				msgs = ((InternalEObject)newConductorType).eInverseAdd(this, WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS, ConductorType.class, msgs);
			msgs = basicSetConductorType(newConductorType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE, newConductorType, newConductorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireType getWireType() {
		if (wireType != null && wireType.eIsProxy()) {
			InternalEObject oldWireType = (InternalEObject)wireType;
			wireType = (WireType)eResolveProxy(oldWireType);
			if (wireType != oldWireType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE, oldWireType, wireType));
			}
		}
		return wireType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireType basicGetWireType() {
		return wireType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWireType(WireType newWireType, NotificationChain msgs) {
		WireType oldWireType = wireType;
		wireType = newWireType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE, oldWireType, newWireType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWireType(WireType newWireType) {
		if (newWireType != wireType) {
			NotificationChain msgs = null;
			if (wireType != null)
				msgs = ((InternalEObject)wireType).eInverseRemove(this, WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS, WireType.class, msgs);
			if (newWireType != null)
				msgs = ((InternalEObject)newWireType).eInverseAdd(this, WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS, WireType.class, msgs);
			msgs = basicSetWireType(newWireType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE, newWireType, newWireType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE:
				if (conductorType != null)
					msgs = ((InternalEObject)conductorType).eInverseRemove(this, WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS, ConductorType.class, msgs);
				return basicSetConductorType((ConductorType)otherEnd, msgs);
			case WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE:
				if (wireType != null)
					msgs = ((InternalEObject)wireType).eInverseRemove(this, WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS, WireType.class, msgs);
				return basicSetWireType((WireType)otherEnd, msgs);
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
			case WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE:
				return basicSetConductorType(null, msgs);
			case WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE:
				return basicSetWireType(null, msgs);
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
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_X:
				return getMountingPointX();
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_Y:
				return getMountingPointY();
			case WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE:
				if (resolve) return getConductorType();
				return basicGetConductorType();
			case WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE:
				if (resolve) return getWireType();
				return basicGetWireType();
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
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_X:
				setMountingPointX((Integer)newValue);
				return;
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_Y:
				setMountingPointY((Integer)newValue);
				return;
			case WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE:
				setConductorType((ConductorType)newValue);
				return;
			case WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE:
				setWireType((WireType)newValue);
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
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_X:
				setMountingPointX(MOUNTING_POINT_X_EDEFAULT);
				return;
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_Y:
				setMountingPointY(MOUNTING_POINT_Y_EDEFAULT);
				return;
			case WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE:
				setConductorType((ConductorType)null);
				return;
			case WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE:
				setWireType((WireType)null);
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
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_X:
				return MOUNTING_POINT_X_EDEFAULT == null ? mountingPointX != null : !MOUNTING_POINT_X_EDEFAULT.equals(mountingPointX);
			case WirePackage.WIRE_ARRANGEMENT__MOUNTING_POINT_Y:
				return MOUNTING_POINT_Y_EDEFAULT == null ? mountingPointY != null : !MOUNTING_POINT_Y_EDEFAULT.equals(mountingPointY);
			case WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE:
				return conductorType != null;
			case WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE:
				return wireType != null;
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
		result.append(" (mountingPointX: ");
		result.append(mountingPointX);
		result.append(", mountingPointY: ");
		result.append(mountingPointY);
		result.append(')');
		return result.toString();
	}

} //WireArrangementImpl