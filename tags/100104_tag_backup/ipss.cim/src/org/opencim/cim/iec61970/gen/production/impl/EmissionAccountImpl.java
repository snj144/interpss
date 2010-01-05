/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmissionAccountImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.domain.EmissionType;
import org.opencim.cim.iec61970.domain.EmissionValueSource;

import org.opencim.cim.iec61970.gen.production.EmissionAccount;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emission Account</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.EmissionAccountImpl#getEmissionType <em>Emission Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.EmissionAccountImpl#getEmissionValueSource <em>Emission Value Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmissionAccountImpl extends AccountBalanceImpl implements EmissionAccount {
	/**
	 * The default value of the '{@link #getEmissionType() <em>Emission Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionType()
	 * @generated
	 * @ordered
	 */
	protected static final EmissionType EMISSION_TYPE_EDEFAULT = EmissionType.SULFUR_DIOXIDE_LITERAL;

	/**
	 * The cached value of the '{@link #getEmissionType() <em>Emission Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionType()
	 * @generated
	 * @ordered
	 */
	protected EmissionType emissionType = EMISSION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmissionValueSource() <em>Emission Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionValueSource()
	 * @generated
	 * @ordered
	 */
	protected static final EmissionValueSource EMISSION_VALUE_SOURCE_EDEFAULT = EmissionValueSource.MEASURED_LITERAL;

	/**
	 * The cached value of the '{@link #getEmissionValueSource() <em>Emission Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionValueSource()
	 * @generated
	 * @ordered
	 */
	protected EmissionValueSource emissionValueSource = EMISSION_VALUE_SOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmissionAccountImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.EMISSION_ACCOUNT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionType getEmissionType() {
		return emissionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmissionType(EmissionType newEmissionType) {
		EmissionType oldEmissionType = emissionType;
		emissionType = newEmissionType == null ? EMISSION_TYPE_EDEFAULT : newEmissionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.EMISSION_ACCOUNT__EMISSION_TYPE, oldEmissionType, emissionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionValueSource getEmissionValueSource() {
		return emissionValueSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmissionValueSource(EmissionValueSource newEmissionValueSource) {
		EmissionValueSource oldEmissionValueSource = emissionValueSource;
		emissionValueSource = newEmissionValueSource == null ? EMISSION_VALUE_SOURCE_EDEFAULT : newEmissionValueSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE, oldEmissionValueSource, emissionValueSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_TYPE:
				return getEmissionType();
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE:
				return getEmissionValueSource();
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
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_TYPE:
				setEmissionType((EmissionType)newValue);
				return;
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE:
				setEmissionValueSource((EmissionValueSource)newValue);
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
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_TYPE:
				setEmissionType(EMISSION_TYPE_EDEFAULT);
				return;
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE:
				setEmissionValueSource(EMISSION_VALUE_SOURCE_EDEFAULT);
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
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_TYPE:
				return emissionType != EMISSION_TYPE_EDEFAULT;
			case ProductionPackage.EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE:
				return emissionValueSource != EMISSION_VALUE_SOURCE_EDEFAULT;
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
		result.append(" (emissionType: ");
		result.append(emissionType);
		result.append(", emissionValueSource: ");
		result.append(emissionValueSource);
		result.append(')');
		return result.toString();
	}

} //EmissionAccountImpl