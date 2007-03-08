/**
 * <copyright>
 * </copyright>
 *
 * $Id: PSRTypeImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.PSRType;
import org.opencim.cim.iec61970.core.PowerSystemResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PSR Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.PSRTypeImpl#getPowerSystemResource <em>Power System Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSRTypeImpl extends NamingImpl implements PSRType {
	/**
	 * The cached value of the '{@link #getPowerSystemResource() <em>Power System Resource</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerSystemResource()
	 * @generated
	 * @ordered
	 */
	protected EList powerSystemResource = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PSRTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.PSR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPowerSystemResource() {
		if (powerSystemResource == null) {
			powerSystemResource = new EObjectWithInverseResolvingEList(PowerSystemResource.class, this, CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE, CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE);
		}
		return powerSystemResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE:
				return ((InternalEList)getPowerSystemResource()).basicAdd(otherEnd, msgs);
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
			case CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE:
				return ((InternalEList)getPowerSystemResource()).basicRemove(otherEnd, msgs);
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
			case CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE:
				return getPowerSystemResource();
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
			case CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE:
				getPowerSystemResource().clear();
				getPowerSystemResource().addAll((Collection)newValue);
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
			case CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE:
				getPowerSystemResource().clear();
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
			case CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE:
				return powerSystemResource != null && !powerSystemResource.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PSRTypeImpl