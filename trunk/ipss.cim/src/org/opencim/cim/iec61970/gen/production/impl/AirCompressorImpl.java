/**
 * <copyright>
 * </copyright>
 *
 * $Id: AirCompressorImpl.java,v 1.2 2007/03/04 17:58:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;

import org.opencim.cim.iec61970.gen.production.AirCompressor;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Air Compressor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.AirCompressorImpl#getAirCompressorRating <em>Air Compressor Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.AirCompressorImpl#getCombustionTurbine <em>Combustion Turbine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AirCompressorImpl extends PowerSystemResourceImpl implements AirCompressor {
	/**
	 * The default value of the '{@link #getAirCompressorRating() <em>Air Compressor Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAirCompressorRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float AIR_COMPRESSOR_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAirCompressorRating() <em>Air Compressor Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAirCompressorRating()
	 * @generated
	 * @ordered
	 */
	protected Float airCompressorRating = AIR_COMPRESSOR_RATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCombustionTurbine() <em>Combustion Turbine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombustionTurbine()
	 * @generated
	 * @ordered
	 */
	protected CombustionTurbine combustionTurbine = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AirCompressorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.AIR_COMPRESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getAirCompressorRating() {
		return airCompressorRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAirCompressorRating(Float newAirCompressorRating) {
		Float oldAirCompressorRating = airCompressorRating;
		airCompressorRating = newAirCompressorRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.AIR_COMPRESSOR__AIR_COMPRESSOR_RATING, oldAirCompressorRating, airCompressorRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombustionTurbine getCombustionTurbine() {
		if (combustionTurbine != null && combustionTurbine.eIsProxy()) {
			InternalEObject oldCombustionTurbine = (InternalEObject)combustionTurbine;
			combustionTurbine = (CombustionTurbine)eResolveProxy(oldCombustionTurbine);
			if (combustionTurbine != oldCombustionTurbine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE, oldCombustionTurbine, combustionTurbine));
			}
		}
		return combustionTurbine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombustionTurbine basicGetCombustionTurbine() {
		return combustionTurbine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCombustionTurbine(CombustionTurbine newCombustionTurbine, NotificationChain msgs) {
		CombustionTurbine oldCombustionTurbine = combustionTurbine;
		combustionTurbine = newCombustionTurbine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE, oldCombustionTurbine, newCombustionTurbine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombustionTurbine(CombustionTurbine newCombustionTurbine) {
		if (newCombustionTurbine != combustionTurbine) {
			NotificationChain msgs = null;
			if (combustionTurbine != null)
				msgs = ((InternalEObject)combustionTurbine).eInverseRemove(this, GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR, CombustionTurbine.class, msgs);
			if (newCombustionTurbine != null)
				msgs = ((InternalEObject)newCombustionTurbine).eInverseAdd(this, GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR, CombustionTurbine.class, msgs);
			msgs = basicSetCombustionTurbine(newCombustionTurbine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE, newCombustionTurbine, newCombustionTurbine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE:
				if (combustionTurbine != null)
					msgs = ((InternalEObject)combustionTurbine).eInverseRemove(this, GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR, CombustionTurbine.class, msgs);
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
			case ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE:
				return basicSetCombustionTurbine(null, msgs);
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
			case ProductionPackage.AIR_COMPRESSOR__AIR_COMPRESSOR_RATING:
				return getAirCompressorRating();
			case ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE:
				if (resolve) return getCombustionTurbine();
				return basicGetCombustionTurbine();
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
			case ProductionPackage.AIR_COMPRESSOR__AIR_COMPRESSOR_RATING:
				setAirCompressorRating((Float)newValue);
				return;
			case ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE:
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
			case ProductionPackage.AIR_COMPRESSOR__AIR_COMPRESSOR_RATING:
				setAirCompressorRating(AIR_COMPRESSOR_RATING_EDEFAULT);
				return;
			case ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE:
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
			case ProductionPackage.AIR_COMPRESSOR__AIR_COMPRESSOR_RATING:
				return AIR_COMPRESSOR_RATING_EDEFAULT == null ? airCompressorRating != null : !AIR_COMPRESSOR_RATING_EDEFAULT.equals(airCompressorRating);
			case ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE:
				return combustionTurbine != null;
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
		result.append(" (airCompressorRating: ");
		result.append(airCompressorRating);
		result.append(')');
		return result.toString();
	}

} //AirCompressorImpl