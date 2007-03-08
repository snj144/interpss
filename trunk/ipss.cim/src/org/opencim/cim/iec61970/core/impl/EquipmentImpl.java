/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquipmentImpl.java,v 1.2 2007/03/04 17:58:12 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Equipment;

import org.opencim.cim.iec61970.core.EquipmentContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.EquipmentImpl#getEquipmentContainer <em>Equipment Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquipmentImpl extends PowerSystemResourceImpl implements Equipment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.EQUIPMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentContainer getEquipmentContainer() {
		if (eContainerFeatureID != CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER) return null;
		return (EquipmentContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEquipmentContainer(EquipmentContainer newEquipmentContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEquipmentContainer, CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentContainer(EquipmentContainer newEquipmentContainer) {
		if (newEquipmentContainer != eInternalContainer() || (eContainerFeatureID != CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER && newEquipmentContainer != null)) {
			if (EcoreUtil.isAncestor(this, newEquipmentContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEquipmentContainer != null)
				msgs = ((InternalEObject)newEquipmentContainer).eInverseAdd(this, CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS, EquipmentContainer.class, msgs);
			msgs = basicSetEquipmentContainer(newEquipmentContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER, newEquipmentContainer, newEquipmentContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEquipmentContainer((EquipmentContainer)otherEnd, msgs);
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
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				return basicSetEquipmentContainer(null, msgs);
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
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				return eInternalContainer().eInverseRemove(this, CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS, EquipmentContainer.class, msgs);
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
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				return getEquipmentContainer();
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
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				setEquipmentContainer((EquipmentContainer)newValue);
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
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				setEquipmentContainer((EquipmentContainer)null);
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
			case CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER:
				return getEquipmentContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //EquipmentImpl