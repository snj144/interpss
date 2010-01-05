/**
 * <copyright>
 * </copyright>
 *
 * $Id: CTTempMWCurveImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.domain.TemperatureUnits;

import org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve;
import org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CT Temp MW Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CTTempMWCurveImpl#getTemperatureUnits <em>Temperature Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CTTempMWCurveImpl#getCombustionTurbine <em>Combustion Turbine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CTTempMWCurveImpl extends CurveScheduleImpl implements CTTempMWCurve {
	/**
	 * The default value of the '{@link #getTemperatureUnits() <em>Temperature Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemperatureUnits()
	 * @generated
	 * @ordered
	 */
	protected static final TemperatureUnits TEMPERATURE_UNITS_EDEFAULT = TemperatureUnits.CELSIUS_LITERAL;

	/**
	 * The cached value of the '{@link #getTemperatureUnits() <em>Temperature Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemperatureUnits()
	 * @generated
	 * @ordered
	 */
	protected TemperatureUnits temperatureUnits = TEMPERATURE_UNITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CTTempMWCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.CT_TEMP_MW_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemperatureUnits getTemperatureUnits() {
		return temperatureUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureUnits(TemperatureUnits newTemperatureUnits) {
		TemperatureUnits oldTemperatureUnits = temperatureUnits;
		temperatureUnits = newTemperatureUnits == null ? TEMPERATURE_UNITS_EDEFAULT : newTemperatureUnits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.CT_TEMP_MW_CURVE__TEMPERATURE_UNITS, oldTemperatureUnits, temperatureUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombustionTurbine getCombustionTurbine() {
		if (eContainerFeatureID != GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE) return null;
		return (CombustionTurbine)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCombustionTurbine(CombustionTurbine newCombustionTurbine, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCombustionTurbine, GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombustionTurbine(CombustionTurbine newCombustionTurbine) {
		if (newCombustionTurbine != eInternalContainer() || (eContainerFeatureID != GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE && newCombustionTurbine != null)) {
			if (EcoreUtil.isAncestor(this, newCombustionTurbine))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCombustionTurbine != null)
				msgs = ((InternalEObject)newCombustionTurbine).eInverseAdd(this, GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE, CombustionTurbine.class, msgs);
			msgs = basicSetCombustionTurbine(newCombustionTurbine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE, newCombustionTurbine, newCombustionTurbine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCombustionTurbine((CombustionTurbine)otherEnd, msgs);
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
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				return basicSetCombustionTurbine(null, msgs);
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
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				return eInternalContainer().eInverseRemove(this, GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE, CombustionTurbine.class, msgs);
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
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__TEMPERATURE_UNITS:
				return getTemperatureUnits();
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				return getCombustionTurbine();
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
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__TEMPERATURE_UNITS:
				setTemperatureUnits((TemperatureUnits)newValue);
				return;
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				setCombustionTurbine((CombustionTurbine)newValue);
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
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__TEMPERATURE_UNITS:
				setTemperatureUnits(TEMPERATURE_UNITS_EDEFAULT);
				return;
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				setCombustionTurbine((CombustionTurbine)null);
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
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__TEMPERATURE_UNITS:
				return temperatureUnits != TEMPERATURE_UNITS_EDEFAULT;
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE:
				return getCombustionTurbine() != null;
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
		result.append(" (temperatureUnits: ");
		result.append(temperatureUnits);
		result.append(')');
		return result.toString();
	}

} //CTTempMWCurveImpl