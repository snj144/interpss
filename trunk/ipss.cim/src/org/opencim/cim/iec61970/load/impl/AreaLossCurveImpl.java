/**
 * <copyright>
 * </copyright>
 *
 * $Id: AreaLossCurveImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.load.AreaLossCurve;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.LoadPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area Loss Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.AreaLossCurveImpl#getLoadArea <em>Load Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AreaLossCurveImpl extends CurveScheduleImpl implements AreaLossCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaLossCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.AREA_LOSS_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea getLoadArea() {
		if (eContainerFeatureID != LoadPackage.AREA_LOSS_CURVE__LOAD_AREA) return null;
		return (LoadArea)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoadArea(LoadArea newLoadArea, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLoadArea, LoadPackage.AREA_LOSS_CURVE__LOAD_AREA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadArea(LoadArea newLoadArea) {
		if (newLoadArea != eInternalContainer() || (eContainerFeatureID != LoadPackage.AREA_LOSS_CURVE__LOAD_AREA && newLoadArea != null)) {
			if (EcoreUtil.isAncestor(this, newLoadArea))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLoadArea != null)
				msgs = ((InternalEObject)newLoadArea).eInverseAdd(this, LoadPackage.LOAD_AREA__AREA_LOSS_CURVES, LoadArea.class, msgs);
			msgs = basicSetLoadArea(newLoadArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.AREA_LOSS_CURVE__LOAD_AREA, newLoadArea, newLoadArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLoadArea((LoadArea)otherEnd, msgs);
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
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				return basicSetLoadArea(null, msgs);
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
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				return eInternalContainer().eInverseRemove(this, LoadPackage.LOAD_AREA__AREA_LOSS_CURVES, LoadArea.class, msgs);
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
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				return getLoadArea();
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
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				setLoadArea((LoadArea)newValue);
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
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				setLoadArea((LoadArea)null);
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
			case LoadPackage.AREA_LOSS_CURVE__LOAD_AREA:
				return getLoadArea() != null;
		}
		return super.eIsSet(featureID);
	}

} //AreaLossCurveImpl