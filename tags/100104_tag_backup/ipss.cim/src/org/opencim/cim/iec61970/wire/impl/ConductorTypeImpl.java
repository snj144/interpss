/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConductorTypeImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
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

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.wire.Conductor;
import org.opencim.cim.iec61970.wire.ConductorType;
import org.opencim.cim.iec61970.wire.WireArrangement;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conductor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl#getSheathResistance <em>Sheath Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl#getSheathReactance <em>Sheath Reactance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl#getConductors <em>Conductors</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl#getWireArrangements <em>Wire Arrangements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConductorTypeImpl extends NamingImpl implements ConductorType {
	/**
	 * The default value of the '{@link #getSheathResistance() <em>Sheath Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheathResistance()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance SHEATH_RESISTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSheathResistance() <em>Sheath Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheathResistance()
	 * @generated
	 * @ordered
	 */
	protected Resistance sheathResistance = SHEATH_RESISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSheathReactance() <em>Sheath Reactance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheathReactance()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance SHEATH_REACTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSheathReactance() <em>Sheath Reactance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheathReactance()
	 * @generated
	 * @ordered
	 */
	protected Reactance sheathReactance = SHEATH_REACTANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConductors() <em>Conductors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConductors()
	 * @generated
	 * @ordered
	 */
	protected EList conductors;

	/**
	 * The cached value of the '{@link #getWireArrangements() <em>Wire Arrangements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWireArrangements()
	 * @generated
	 * @ordered
	 */
	protected EList wireArrangements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConductorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.CONDUCTOR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getSheathResistance() {
		return sheathResistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSheathResistance(Resistance newSheathResistance) {
		Resistance oldSheathResistance = sheathResistance;
		sheathResistance = newSheathResistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR_TYPE__SHEATH_RESISTANCE, oldSheathResistance, sheathResistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getSheathReactance() {
		return sheathReactance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSheathReactance(Reactance newSheathReactance) {
		Reactance oldSheathReactance = sheathReactance;
		sheathReactance = newSheathReactance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR_TYPE__SHEATH_REACTANCE, oldSheathReactance, sheathReactance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConductors() {
		if (conductors == null) {
			conductors = new EObjectWithInverseResolvingEList(Conductor.class, this, WirePackage.CONDUCTOR_TYPE__CONDUCTORS, WirePackage.CONDUCTOR__CONDUCTOR_TYPE);
		}
		return conductors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWireArrangements() {
		if (wireArrangements == null) {
			wireArrangements = new EObjectWithInverseResolvingEList(WireArrangement.class, this, WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS, WirePackage.WIRE_ARRANGEMENT__CONDUCTOR_TYPE);
		}
		return wireArrangements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.CONDUCTOR_TYPE__CONDUCTORS:
				return ((InternalEList)getConductors()).basicAdd(otherEnd, msgs);
			case WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS:
				return ((InternalEList)getWireArrangements()).basicAdd(otherEnd, msgs);
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
			case WirePackage.CONDUCTOR_TYPE__CONDUCTORS:
				return ((InternalEList)getConductors()).basicRemove(otherEnd, msgs);
			case WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS:
				return ((InternalEList)getWireArrangements()).basicRemove(otherEnd, msgs);
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
			case WirePackage.CONDUCTOR_TYPE__SHEATH_RESISTANCE:
				return getSheathResistance();
			case WirePackage.CONDUCTOR_TYPE__SHEATH_REACTANCE:
				return getSheathReactance();
			case WirePackage.CONDUCTOR_TYPE__CONDUCTORS:
				return getConductors();
			case WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS:
				return getWireArrangements();
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
			case WirePackage.CONDUCTOR_TYPE__SHEATH_RESISTANCE:
				setSheathResistance((Resistance)newValue);
				return;
			case WirePackage.CONDUCTOR_TYPE__SHEATH_REACTANCE:
				setSheathReactance((Reactance)newValue);
				return;
			case WirePackage.CONDUCTOR_TYPE__CONDUCTORS:
				getConductors().clear();
				getConductors().addAll((Collection)newValue);
				return;
			case WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS:
				getWireArrangements().clear();
				getWireArrangements().addAll((Collection)newValue);
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
			case WirePackage.CONDUCTOR_TYPE__SHEATH_RESISTANCE:
				setSheathResistance(SHEATH_RESISTANCE_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR_TYPE__SHEATH_REACTANCE:
				setSheathReactance(SHEATH_REACTANCE_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR_TYPE__CONDUCTORS:
				getConductors().clear();
				return;
			case WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS:
				getWireArrangements().clear();
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
			case WirePackage.CONDUCTOR_TYPE__SHEATH_RESISTANCE:
				return SHEATH_RESISTANCE_EDEFAULT == null ? sheathResistance != null : !SHEATH_RESISTANCE_EDEFAULT.equals(sheathResistance);
			case WirePackage.CONDUCTOR_TYPE__SHEATH_REACTANCE:
				return SHEATH_REACTANCE_EDEFAULT == null ? sheathReactance != null : !SHEATH_REACTANCE_EDEFAULT.equals(sheathReactance);
			case WirePackage.CONDUCTOR_TYPE__CONDUCTORS:
				return conductors != null && !conductors.isEmpty();
			case WirePackage.CONDUCTOR_TYPE__WIRE_ARRANGEMENTS:
				return wireArrangements != null && !wireArrangements.isEmpty();
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
		result.append(" (sheathResistance: ");
		result.append(sheathResistance);
		result.append(", sheathReactance: ");
		result.append(sheathReactance);
		result.append(')');
		return result.toString();
	}

} //ConductorTypeImpl