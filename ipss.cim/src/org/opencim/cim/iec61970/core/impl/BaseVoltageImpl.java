/**
 * <copyright>
 * </copyright>
 *
 * $Id: BaseVoltageImpl.java,v 1.3 2007/03/04 17:58:13 mzhou Exp $
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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.VoltageLevel;

import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Voltage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BaseVoltageImpl#getNominalVoltage <em>Nominal Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BaseVoltageImpl#getBasePower <em>Base Power</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BaseVoltageImpl#getConductingEquipment <em>Conducting Equipment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BaseVoltageImpl#getVoltageLevel <em>Voltage Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseVoltageImpl extends NamingImpl implements BaseVoltage {
	/**
	 * The default value of the '{@link #getNominalVoltage() <em>Nominal Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage NOMINAL_VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNominalVoltage() <em>Nominal Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalVoltage()
	 * @generated
	 * @ordered
	 */
	protected Voltage nominalVoltage = NOMINAL_VOLTAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConductingEquipment() <em>Conducting Equipment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConductingEquipment()
	 * @generated
	 * @ordered
	 */
	protected EList conductingEquipment;

	/**
	 * The cached value of the '{@link #getVoltageLevel() <em>Voltage Level</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageLevel()
	 * @generated
	 * @ordered
	 */
	protected EList voltageLevel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseVoltageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.BASE_VOLTAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getNominalVoltage() {
		return nominalVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalVoltage(Voltage newNominalVoltage) {
		Voltage oldNominalVoltage = nominalVoltage;
		nominalVoltage = newNominalVoltage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BASE_VOLTAGE__NOMINAL_VOLTAGE, oldNominalVoltage, nominalVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasePower getBasePower() {
		if (eContainerFeatureID != CorePackage.BASE_VOLTAGE__BASE_POWER) return null;
		return (BasePower)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasePower(BasePower newBasePower, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBasePower, CorePackage.BASE_VOLTAGE__BASE_POWER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePower(BasePower newBasePower) {
		if (newBasePower != eInternalContainer() || (eContainerFeatureID != CorePackage.BASE_VOLTAGE__BASE_POWER && newBasePower != null)) {
			if (EcoreUtil.isAncestor(this, newBasePower))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBasePower != null)
				msgs = ((InternalEObject)newBasePower).eInverseAdd(this, CorePackage.BASE_POWER__BASE_VOLTAGES, BasePower.class, msgs);
			msgs = basicSetBasePower(newBasePower, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BASE_VOLTAGE__BASE_POWER, newBasePower, newBasePower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConductingEquipment() {
		if (conductingEquipment == null) {
			conductingEquipment = new EObjectWithInverseResolvingEList(ConductingEquipment.class, this, CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT, CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE);
		}
		return conductingEquipment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVoltageLevel() {
		if (voltageLevel == null) {
			voltageLevel = new EObjectWithInverseResolvingEList(VoltageLevel.class, this, CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL, CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE);
		}
		return voltageLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBasePower((BasePower)otherEnd, msgs);
			case CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT:
				return ((InternalEList)getConductingEquipment()).basicAdd(otherEnd, msgs);
			case CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL:
				return ((InternalEList)getVoltageLevel()).basicAdd(otherEnd, msgs);
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
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				return basicSetBasePower(null, msgs);
			case CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT:
				return ((InternalEList)getConductingEquipment()).basicRemove(otherEnd, msgs);
			case CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL:
				return ((InternalEList)getVoltageLevel()).basicRemove(otherEnd, msgs);
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
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				return eInternalContainer().eInverseRemove(this, CorePackage.BASE_POWER__BASE_VOLTAGES, BasePower.class, msgs);
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
			case CorePackage.BASE_VOLTAGE__NOMINAL_VOLTAGE:
				return getNominalVoltage();
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				return getBasePower();
			case CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT:
				return getConductingEquipment();
			case CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL:
				return getVoltageLevel();
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
			case CorePackage.BASE_VOLTAGE__NOMINAL_VOLTAGE:
				setNominalVoltage((Voltage)newValue);
				return;
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				setBasePower((BasePower)newValue);
				return;
			case CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT:
				getConductingEquipment().clear();
				getConductingEquipment().addAll((Collection)newValue);
				return;
			case CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL:
				getVoltageLevel().clear();
				getVoltageLevel().addAll((Collection)newValue);
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
			case CorePackage.BASE_VOLTAGE__NOMINAL_VOLTAGE:
				setNominalVoltage(NOMINAL_VOLTAGE_EDEFAULT);
				return;
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				setBasePower((BasePower)null);
				return;
			case CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT:
				getConductingEquipment().clear();
				return;
			case CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL:
				getVoltageLevel().clear();
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
			case CorePackage.BASE_VOLTAGE__NOMINAL_VOLTAGE:
				return NOMINAL_VOLTAGE_EDEFAULT == null ? nominalVoltage != null : !NOMINAL_VOLTAGE_EDEFAULT.equals(nominalVoltage);
			case CorePackage.BASE_VOLTAGE__BASE_POWER:
				return getBasePower() != null;
			case CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT:
				return conductingEquipment != null && !conductingEquipment.isEmpty();
			case CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL:
				return voltageLevel != null && !voltageLevel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("BaseVoltage: \n" + super.toString() + "\n");
		result.append(" (nominalVoltage: ");
		result.append(nominalVoltage);
		result.append(')' + "\n");
		return result.toString();
	}

} //BaseVoltageImpl