/**
 * <copyright>
 * </copyright>
 *
 * $Id: BasePowerImpl.java,v 1.3 2007/03/04 17:58:12 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.CorePackage;

import org.opencim.datatype.real.ApparentPower;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Power</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BasePowerImpl#getBasePower <em>Base Power</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BasePowerImpl#getBaseVoltages <em>Base Voltages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasePowerImpl extends NamingImpl implements BasePower {
	/**
	 * The default value of the '{@link #getBasePower() <em>Base Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePower()
	 * @generated
	 * @ordered
	 */
	protected static final ApparentPower BASE_POWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasePower() <em>Base Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePower()
	 * @generated
	 * @ordered
	 */
	protected ApparentPower basePower = BASE_POWER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVoltages() <em>Base Voltages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVoltages()
	 * @generated
	 * @ordered
	 */
	protected EList baseVoltages = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasePowerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.BASE_POWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApparentPower getBasePower() {
		return basePower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePower(ApparentPower newBasePower) {
		ApparentPower oldBasePower = basePower;
		basePower = newBasePower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BASE_POWER__BASE_POWER, oldBasePower, basePower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBaseVoltages() {
		if (baseVoltages == null) {
			baseVoltages = new EObjectContainmentWithInverseEList(BaseVoltage.class, this, CorePackage.BASE_POWER__BASE_VOLTAGES, CorePackage.BASE_VOLTAGE__BASE_POWER);
		}
		return baseVoltages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.BASE_POWER__BASE_VOLTAGES:
				return ((InternalEList)getBaseVoltages()).basicAdd(otherEnd, msgs);
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
			case CorePackage.BASE_POWER__BASE_VOLTAGES:
				return ((InternalEList)getBaseVoltages()).basicRemove(otherEnd, msgs);
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
			case CorePackage.BASE_POWER__BASE_POWER:
				return getBasePower();
			case CorePackage.BASE_POWER__BASE_VOLTAGES:
				return getBaseVoltages();
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
			case CorePackage.BASE_POWER__BASE_POWER:
				setBasePower((ApparentPower)newValue);
				return;
			case CorePackage.BASE_POWER__BASE_VOLTAGES:
				getBaseVoltages().clear();
				getBaseVoltages().addAll((Collection)newValue);
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
			case CorePackage.BASE_POWER__BASE_POWER:
				setBasePower(BASE_POWER_EDEFAULT);
				return;
			case CorePackage.BASE_POWER__BASE_VOLTAGES:
				getBaseVoltages().clear();
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
			case CorePackage.BASE_POWER__BASE_POWER:
				return BASE_POWER_EDEFAULT == null ? basePower != null : !BASE_POWER_EDEFAULT.equals(basePower);
			case CorePackage.BASE_POWER__BASE_VOLTAGES:
				return baseVoltages != null && !baseVoltages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("BasePower: \n" + super.toString()+ "\n");
		result.append(" (basePower: ");
		result.append(basePower);
		result.append(')' + "\n");
		
		result.append(getBaseVoltages().toString() + "\n\n");
		
		return result.toString();
	}

} //BasePowerImpl