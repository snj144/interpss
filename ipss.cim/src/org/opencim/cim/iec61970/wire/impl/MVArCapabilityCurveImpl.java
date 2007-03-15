/**
 * <copyright>
 * </copyright>
 *
 * $Id: MVArCapabilityCurveImpl.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
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

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.wire.MVArCapabilityCurve;
import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.Pressure;
import org.opencim.datatype.real.Temperature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MV Ar Capability Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl#getCoolantTemperature <em>Coolant Temperature</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl#getHydrogenPressure <em>Hydrogen Pressure</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl#getSynchronousMachines <em>Synchronous Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MVArCapabilityCurveImpl extends CurveScheduleImpl implements MVArCapabilityCurve {
	/**
	 * The default value of the '{@link #getCoolantTemperature() <em>Coolant Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolantTemperature()
	 * @generated
	 * @ordered
	 */
	protected static final Temperature COOLANT_TEMPERATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoolantTemperature() <em>Coolant Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolantTemperature()
	 * @generated
	 * @ordered
	 */
	protected Temperature coolantTemperature = COOLANT_TEMPERATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHydrogenPressure() <em>Hydrogen Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydrogenPressure()
	 * @generated
	 * @ordered
	 */
	protected static final Pressure HYDROGEN_PRESSURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHydrogenPressure() <em>Hydrogen Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydrogenPressure()
	 * @generated
	 * @ordered
	 */
	protected Pressure hydrogenPressure = HYDROGEN_PRESSURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSynchronousMachines() <em>Synchronous Machines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronousMachines()
	 * @generated
	 * @ordered
	 */
	protected EList synchronousMachines = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MVArCapabilityCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.MV_AR_CAPABILITY_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Temperature getCoolantTemperature() {
		return coolantTemperature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoolantTemperature(Temperature newCoolantTemperature) {
		Temperature oldCoolantTemperature = coolantTemperature;
		coolantTemperature = newCoolantTemperature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE, oldCoolantTemperature, coolantTemperature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pressure getHydrogenPressure() {
		return hydrogenPressure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHydrogenPressure(Pressure newHydrogenPressure) {
		Pressure oldHydrogenPressure = hydrogenPressure;
		hydrogenPressure = newHydrogenPressure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE, oldHydrogenPressure, hydrogenPressure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSynchronousMachines() {
		if (synchronousMachines == null) {
			synchronousMachines = new EObjectWithInverseResolvingEList.ManyInverse(SynchronousMachine.class, this, WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES, WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES);
		}
		return synchronousMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES:
				return ((InternalEList)getSynchronousMachines()).basicAdd(otherEnd, msgs);
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
			case WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES:
				return ((InternalEList)getSynchronousMachines()).basicRemove(otherEnd, msgs);
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
			case WirePackage.MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE:
				return getCoolantTemperature();
			case WirePackage.MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE:
				return getHydrogenPressure();
			case WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES:
				return getSynchronousMachines();
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
			case WirePackage.MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE:
				setCoolantTemperature((Temperature)newValue);
				return;
			case WirePackage.MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE:
				setHydrogenPressure((Pressure)newValue);
				return;
			case WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES:
				getSynchronousMachines().clear();
				getSynchronousMachines().addAll((Collection)newValue);
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
			case WirePackage.MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE:
				setCoolantTemperature(COOLANT_TEMPERATURE_EDEFAULT);
				return;
			case WirePackage.MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE:
				setHydrogenPressure(HYDROGEN_PRESSURE_EDEFAULT);
				return;
			case WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES:
				getSynchronousMachines().clear();
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
			case WirePackage.MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE:
				return COOLANT_TEMPERATURE_EDEFAULT == null ? coolantTemperature != null : !COOLANT_TEMPERATURE_EDEFAULT.equals(coolantTemperature);
			case WirePackage.MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE:
				return HYDROGEN_PRESSURE_EDEFAULT == null ? hydrogenPressure != null : !HYDROGEN_PRESSURE_EDEFAULT.equals(hydrogenPressure);
			case WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES:
				return synchronousMachines != null && !synchronousMachines.isEmpty();
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
		result.append(" (coolantTemperature: ");
		result.append(coolantTemperature);
		result.append(", hydrogenPressure: ");
		result.append(hydrogenPressure);
		result.append(')');
		return result.toString();
	}

} //MVArCapabilityCurveImpl