/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimeMoverImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover;

import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prime Mover</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PrimeMoverImpl#getPrimeMoverRating <em>Prime Mover Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PrimeMoverImpl#getSynchronousMachines <em>Synchronous Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimeMoverImpl extends PowerSystemResourceImpl implements PrimeMover {
	/**
	 * The default value of the '{@link #getPrimeMoverRating() <em>Prime Mover Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimeMoverRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float PRIME_MOVER_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimeMoverRating() <em>Prime Mover Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimeMoverRating()
	 * @generated
	 * @ordered
	 */
	protected Float primeMoverRating = PRIME_MOVER_RATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSynchronousMachines() <em>Synchronous Machines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronousMachines()
	 * @generated
	 * @ordered
	 */
	protected SynchronousMachine synchronousMachines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimeMoverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.PRIME_MOVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPrimeMoverRating() {
		return primeMoverRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimeMoverRating(Float newPrimeMoverRating) {
		Float oldPrimeMoverRating = primeMoverRating;
		primeMoverRating = newPrimeMoverRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PRIME_MOVER__PRIME_MOVER_RATING, oldPrimeMoverRating, primeMoverRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachine getSynchronousMachines() {
		if (synchronousMachines != null && synchronousMachines.eIsProxy()) {
			InternalEObject oldSynchronousMachines = (InternalEObject)synchronousMachines;
			synchronousMachines = (SynchronousMachine)eResolveProxy(oldSynchronousMachines);
			if (synchronousMachines != oldSynchronousMachines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES, oldSynchronousMachines, synchronousMachines));
			}
		}
		return synchronousMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachine basicGetSynchronousMachines() {
		return synchronousMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSynchronousMachines(SynchronousMachine newSynchronousMachines, NotificationChain msgs) {
		SynchronousMachine oldSynchronousMachines = synchronousMachines;
		synchronousMachines = newSynchronousMachines;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES, oldSynchronousMachines, newSynchronousMachines);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronousMachines(SynchronousMachine newSynchronousMachines) {
		if (newSynchronousMachines != synchronousMachines) {
			NotificationChain msgs = null;
			if (synchronousMachines != null)
				msgs = ((InternalEObject)synchronousMachines).eInverseRemove(this, WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER, SynchronousMachine.class, msgs);
			if (newSynchronousMachines != null)
				msgs = ((InternalEObject)newSynchronousMachines).eInverseAdd(this, WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER, SynchronousMachine.class, msgs);
			msgs = basicSetSynchronousMachines(newSynchronousMachines, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES, newSynchronousMachines, newSynchronousMachines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES:
				if (synchronousMachines != null)
					msgs = ((InternalEObject)synchronousMachines).eInverseRemove(this, WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER, SynchronousMachine.class, msgs);
				return basicSetSynchronousMachines((SynchronousMachine)otherEnd, msgs);
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
			case GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES:
				return basicSetSynchronousMachines(null, msgs);
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
			case GenerationdynamicsPackage.PRIME_MOVER__PRIME_MOVER_RATING:
				return getPrimeMoverRating();
			case GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES:
				if (resolve) return getSynchronousMachines();
				return basicGetSynchronousMachines();
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
			case GenerationdynamicsPackage.PRIME_MOVER__PRIME_MOVER_RATING:
				setPrimeMoverRating((Float)newValue);
				return;
			case GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES:
				setSynchronousMachines((SynchronousMachine)newValue);
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
			case GenerationdynamicsPackage.PRIME_MOVER__PRIME_MOVER_RATING:
				setPrimeMoverRating(PRIME_MOVER_RATING_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES:
				setSynchronousMachines((SynchronousMachine)null);
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
			case GenerationdynamicsPackage.PRIME_MOVER__PRIME_MOVER_RATING:
				return PRIME_MOVER_RATING_EDEFAULT == null ? primeMoverRating != null : !PRIME_MOVER_RATING_EDEFAULT.equals(primeMoverRating);
			case GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES:
				return synchronousMachines != null;
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
		result.append(" (primeMoverRating: ");
		result.append(primeMoverRating);
		result.append(')');
		return result.toString();
	}

} //PrimeMoverImpl