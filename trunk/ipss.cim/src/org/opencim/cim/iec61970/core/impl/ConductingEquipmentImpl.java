/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConductingEquipmentImpl.java,v 1.4 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Terminal;

import org.opencim.datatype.string.PhaseCode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conducting Equipment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl#getPhases <em>Phases</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl#getTerminals <em>Terminals</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl#getBaseVoltage <em>Base Voltage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConductingEquipmentImpl extends EquipmentImpl implements ConductingEquipment {
	/**
	 * The default value of the '{@link #getPhases() <em>Phases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhases()
	 * @generated
	 * @ordered
	 */
	protected static final PhaseCode PHASES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhases() <em>Phases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhases()
	 * @generated
	 * @ordered
	 */
	protected PhaseCode phases = PHASES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTerminals() <em>Terminals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminals()
	 * @generated
	 * @ordered
	 */
	protected EList terminals = null;

	/**
	 * The cached value of the '{@link #getBaseVoltage() <em>Base Voltage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVoltage()
	 * @generated
	 * @ordered
	 */
	protected BaseVoltage baseVoltage = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConductingEquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONDUCTING_EQUIPMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhaseCode getPhases() {
		return phases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhases(PhaseCode newPhases) {
		PhaseCode oldPhases = phases;
		phases = newPhases;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONDUCTING_EQUIPMENT__PHASES, oldPhases, phases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTerminals() {
		if (terminals == null) {
			terminals = new EObjectWithInverseResolvingEList(Terminal.class, this, CorePackage.CONDUCTING_EQUIPMENT__TERMINALS, CorePackage.TERMINAL__CONDUCTING_EQUIPMENT);
		}
		return terminals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseVoltage getBaseVoltage() {
		if (baseVoltage != null && baseVoltage.eIsProxy()) {
			InternalEObject oldBaseVoltage = (InternalEObject)baseVoltage;
			baseVoltage = (BaseVoltage)eResolveProxy(oldBaseVoltage);
			if (baseVoltage != oldBaseVoltage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE, oldBaseVoltage, baseVoltage));
			}
		}
		return baseVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseVoltage basicGetBaseVoltage() {
		return baseVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseVoltage(BaseVoltage newBaseVoltage, NotificationChain msgs) {
		BaseVoltage oldBaseVoltage = baseVoltage;
		baseVoltage = newBaseVoltage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE, oldBaseVoltage, newBaseVoltage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVoltage(BaseVoltage newBaseVoltage) {
		if (newBaseVoltage != baseVoltage) {
			NotificationChain msgs = null;
			if (baseVoltage != null)
				msgs = ((InternalEObject)baseVoltage).eInverseRemove(this, CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT, BaseVoltage.class, msgs);
			if (newBaseVoltage != null)
				msgs = ((InternalEObject)newBaseVoltage).eInverseAdd(this, CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT, BaseVoltage.class, msgs);
			msgs = basicSetBaseVoltage(newBaseVoltage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE, newBaseVoltage, newBaseVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CONDUCTING_EQUIPMENT__TERMINALS:
				return ((InternalEList)getTerminals()).basicAdd(otherEnd, msgs);
			case CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE:
				if (baseVoltage != null)
					msgs = ((InternalEObject)baseVoltage).eInverseRemove(this, CorePackage.BASE_VOLTAGE__CONDUCTING_EQUIPMENT, BaseVoltage.class, msgs);
				return basicSetBaseVoltage((BaseVoltage)otherEnd, msgs);
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
			case CorePackage.CONDUCTING_EQUIPMENT__TERMINALS:
				return ((InternalEList)getTerminals()).basicRemove(otherEnd, msgs);
			case CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE:
				return basicSetBaseVoltage(null, msgs);
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
			case CorePackage.CONDUCTING_EQUIPMENT__PHASES:
				return getPhases();
			case CorePackage.CONDUCTING_EQUIPMENT__TERMINALS:
				return getTerminals();
			case CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE:
				if (resolve) return getBaseVoltage();
				return basicGetBaseVoltage();
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
			case CorePackage.CONDUCTING_EQUIPMENT__PHASES:
				setPhases((PhaseCode)newValue);
				return;
			case CorePackage.CONDUCTING_EQUIPMENT__TERMINALS:
				getTerminals().clear();
				getTerminals().addAll((Collection)newValue);
				return;
			case CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE:
				setBaseVoltage((BaseVoltage)newValue);
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
			case CorePackage.CONDUCTING_EQUIPMENT__PHASES:
				setPhases(PHASES_EDEFAULT);
				return;
			case CorePackage.CONDUCTING_EQUIPMENT__TERMINALS:
				getTerminals().clear();
				return;
			case CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE:
				setBaseVoltage((BaseVoltage)null);
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
			case CorePackage.CONDUCTING_EQUIPMENT__PHASES:
				return PHASES_EDEFAULT == null ? phases != null : !PHASES_EDEFAULT.equals(phases);
			case CorePackage.CONDUCTING_EQUIPMENT__TERMINALS:
				return terminals != null && !terminals.isEmpty();
			case CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE:
				return baseVoltage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("\nConductingEquipment: \n" + super.toString());
		result.append(" (phases: ");
		result.append(phases);
		result.append(')' + "\n");
		
		if (this.getTerminals().size() > 0)
			for (Object obj : this.getTerminals())
				result.append("     Connected Terminal MRID: " + ((Terminal)obj).getMRID() + "\n");
			
		return result.toString();
	}

} //ConductingEquipmentImpl