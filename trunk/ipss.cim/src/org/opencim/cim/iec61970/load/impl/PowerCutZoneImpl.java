/**
 * <copyright>
 * </copyright>
 *
 * $Id: PowerCutZoneImpl.java,v 1.2 2007/03/04 17:58:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

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

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.PowerCutZone;

import org.opencim.cim.iec61970.wire.EnergyConsumer;

import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.PerCent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Cut Zone</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl#getCutLevel1 <em>Cut Level1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl#getCutLevel2 <em>Cut Level2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl#getEnergyConsumers <em>Energy Consumers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerCutZoneImpl extends PowerSystemResourceImpl implements PowerCutZone {
	/**
	 * The default value of the '{@link #getCutLevel1() <em>Cut Level1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCutLevel1()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent CUT_LEVEL1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCutLevel1() <em>Cut Level1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCutLevel1()
	 * @generated
	 * @ordered
	 */
	protected PerCent cutLevel1 = CUT_LEVEL1_EDEFAULT;

	/**
	 * The default value of the '{@link #getCutLevel2() <em>Cut Level2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCutLevel2()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent CUT_LEVEL2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCutLevel2() <em>Cut Level2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCutLevel2()
	 * @generated
	 * @ordered
	 */
	protected PerCent cutLevel2 = CUT_LEVEL2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnergyConsumers() <em>Energy Consumers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyConsumers()
	 * @generated
	 * @ordered
	 */
	protected EList energyConsumers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerCutZoneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.POWER_CUT_ZONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getCutLevel1() {
		return cutLevel1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCutLevel1(PerCent newCutLevel1) {
		PerCent oldCutLevel1 = cutLevel1;
		cutLevel1 = newCutLevel1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.POWER_CUT_ZONE__CUT_LEVEL1, oldCutLevel1, cutLevel1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getCutLevel2() {
		return cutLevel2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCutLevel2(PerCent newCutLevel2) {
		PerCent oldCutLevel2 = cutLevel2;
		cutLevel2 = newCutLevel2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.POWER_CUT_ZONE__CUT_LEVEL2, oldCutLevel2, cutLevel2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnergyConsumers() {
		if (energyConsumers == null) {
			energyConsumers = new EObjectContainmentWithInverseEList(EnergyConsumer.class, this, LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS, WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE);
		}
		return energyConsumers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS:
				return ((InternalEList)getEnergyConsumers()).basicAdd(otherEnd, msgs);
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
			case LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS:
				return ((InternalEList)getEnergyConsumers()).basicRemove(otherEnd, msgs);
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
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL1:
				return getCutLevel1();
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL2:
				return getCutLevel2();
			case LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS:
				return getEnergyConsumers();
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
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL1:
				setCutLevel1((PerCent)newValue);
				return;
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL2:
				setCutLevel2((PerCent)newValue);
				return;
			case LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS:
				getEnergyConsumers().clear();
				getEnergyConsumers().addAll((Collection)newValue);
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
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL1:
				setCutLevel1(CUT_LEVEL1_EDEFAULT);
				return;
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL2:
				setCutLevel2(CUT_LEVEL2_EDEFAULT);
				return;
			case LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS:
				getEnergyConsumers().clear();
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
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL1:
				return CUT_LEVEL1_EDEFAULT == null ? cutLevel1 != null : !CUT_LEVEL1_EDEFAULT.equals(cutLevel1);
			case LoadPackage.POWER_CUT_ZONE__CUT_LEVEL2:
				return CUT_LEVEL2_EDEFAULT == null ? cutLevel2 != null : !CUT_LEVEL2_EDEFAULT.equals(cutLevel2);
			case LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS:
				return energyConsumers != null && !energyConsumers.isEmpty();
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
		result.append(" (cutLevel1: ");
		result.append(cutLevel1);
		result.append(", cutLevel2: ");
		result.append(cutLevel2);
		result.append(')');
		return result.toString();
	}

} //PowerCutZoneImpl