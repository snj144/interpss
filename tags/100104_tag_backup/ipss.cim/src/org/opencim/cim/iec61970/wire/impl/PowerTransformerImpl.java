/**
 * <copyright>
 * </copyright>
 *
 * $Id: PowerTransformerImpl.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.EquipmentImpl;

import org.opencim.cim.iec61970.domain.TransformerCoolingType;
import org.opencim.cim.iec61970.domain.TransformerType;

import org.opencim.cim.iec61970.wire.HeatExchanger;
import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.PhaseCode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getBmagSat <em>Bmag Sat</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getMagBaseKV <em>Mag Base KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getMagSatFlux <em>Mag Sat Flux</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getPhases <em>Phases</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getTransfCoolingType <em>Transf Cooling Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getTransformerType <em>Transformer Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getHeatExchanger <em>Heat Exchanger</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl#getTransformerWindings <em>Transformer Windings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerTransformerImpl extends EquipmentImpl implements PowerTransformer {
	/**
	 * The default value of the '{@link #getBmagSat() <em>Bmag Sat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBmagSat()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent BMAG_SAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBmagSat() <em>Bmag Sat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBmagSat()
	 * @generated
	 * @ordered
	 */
	protected PerCent bmagSat = BMAG_SAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMagBaseKV() <em>Mag Base KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMagBaseKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MAG_BASE_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMagBaseKV() <em>Mag Base KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMagBaseKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage magBaseKV = MAG_BASE_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getMagSatFlux() <em>Mag Sat Flux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMagSatFlux()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent MAG_SAT_FLUX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMagSatFlux() <em>Mag Sat Flux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMagSatFlux()
	 * @generated
	 * @ordered
	 */
	protected PerCent magSatFlux = MAG_SAT_FLUX_EDEFAULT;

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
	 * The default value of the '{@link #getTransfCoolingType() <em>Transf Cooling Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfCoolingType()
	 * @generated
	 * @ordered
	 */
	protected static final TransformerCoolingType TRANSF_COOLING_TYPE_EDEFAULT = TransformerCoolingType.TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getTransfCoolingType() <em>Transf Cooling Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfCoolingType()
	 * @generated
	 * @ordered
	 */
	protected TransformerCoolingType transfCoolingType = TRANSF_COOLING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransformerType() <em>Transformer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformerType()
	 * @generated
	 * @ordered
	 */
	protected static final TransformerType TRANSFORMER_TYPE_EDEFAULT = TransformerType.FIX_LITERAL;

	/**
	 * The cached value of the '{@link #getTransformerType() <em>Transformer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformerType()
	 * @generated
	 * @ordered
	 */
	protected TransformerType transformerType = TRANSFORMER_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHeatExchanger() <em>Heat Exchanger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatExchanger()
	 * @generated
	 * @ordered
	 */
	protected HeatExchanger heatExchanger;

	/**
	 * The cached value of the '{@link #getTransformerWindings() <em>Transformer Windings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformerWindings()
	 * @generated
	 * @ordered
	 */
	protected EList transformerWindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerTransformerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.POWER_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getBmagSat() {
		return bmagSat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBmagSat(PerCent newBmagSat) {
		PerCent oldBmagSat = bmagSat;
		bmagSat = newBmagSat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__BMAG_SAT, oldBmagSat, bmagSat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMagBaseKV() {
		return magBaseKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMagBaseKV(Voltage newMagBaseKV) {
		Voltage oldMagBaseKV = magBaseKV;
		magBaseKV = newMagBaseKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__MAG_BASE_KV, oldMagBaseKV, magBaseKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getMagSatFlux() {
		return magSatFlux;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMagSatFlux(PerCent newMagSatFlux) {
		PerCent oldMagSatFlux = magSatFlux;
		magSatFlux = newMagSatFlux;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__MAG_SAT_FLUX, oldMagSatFlux, magSatFlux));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__PHASES, oldPhases, phases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerCoolingType getTransfCoolingType() {
		return transfCoolingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransfCoolingType(TransformerCoolingType newTransfCoolingType) {
		TransformerCoolingType oldTransfCoolingType = transfCoolingType;
		transfCoolingType = newTransfCoolingType == null ? TRANSF_COOLING_TYPE_EDEFAULT : newTransfCoolingType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__TRANSF_COOLING_TYPE, oldTransfCoolingType, transfCoolingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerType getTransformerType() {
		return transformerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformerType(TransformerType newTransformerType) {
		TransformerType oldTransformerType = transformerType;
		transformerType = newTransformerType == null ? TRANSFORMER_TYPE_EDEFAULT : newTransformerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__TRANSFORMER_TYPE, oldTransformerType, transformerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatExchanger getHeatExchanger() {
		return heatExchanger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeatExchanger(HeatExchanger newHeatExchanger, NotificationChain msgs) {
		HeatExchanger oldHeatExchanger = heatExchanger;
		heatExchanger = newHeatExchanger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER, oldHeatExchanger, newHeatExchanger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatExchanger(HeatExchanger newHeatExchanger) {
		if (newHeatExchanger != heatExchanger) {
			NotificationChain msgs = null;
			if (heatExchanger != null)
				msgs = ((InternalEObject)heatExchanger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER, null, msgs);
			if (newHeatExchanger != null)
				msgs = ((InternalEObject)newHeatExchanger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER, null, msgs);
			msgs = basicSetHeatExchanger(newHeatExchanger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER, newHeatExchanger, newHeatExchanger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTransformerWindings() {
		if (transformerWindings == null) {
			transformerWindings = new EObjectWithInverseResolvingEList(TransformerWinding.class, this, WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS, WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER);
		}
		return transformerWindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS:
				return ((InternalEList)getTransformerWindings()).basicAdd(otherEnd, msgs);
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
			case WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER:
				return basicSetHeatExchanger(null, msgs);
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS:
				return ((InternalEList)getTransformerWindings()).basicRemove(otherEnd, msgs);
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
			case WirePackage.POWER_TRANSFORMER__BMAG_SAT:
				return getBmagSat();
			case WirePackage.POWER_TRANSFORMER__MAG_BASE_KV:
				return getMagBaseKV();
			case WirePackage.POWER_TRANSFORMER__MAG_SAT_FLUX:
				return getMagSatFlux();
			case WirePackage.POWER_TRANSFORMER__PHASES:
				return getPhases();
			case WirePackage.POWER_TRANSFORMER__TRANSF_COOLING_TYPE:
				return getTransfCoolingType();
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_TYPE:
				return getTransformerType();
			case WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER:
				return getHeatExchanger();
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS:
				return getTransformerWindings();
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
			case WirePackage.POWER_TRANSFORMER__BMAG_SAT:
				setBmagSat((PerCent)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__MAG_BASE_KV:
				setMagBaseKV((Voltage)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__MAG_SAT_FLUX:
				setMagSatFlux((PerCent)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__PHASES:
				setPhases((PhaseCode)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__TRANSF_COOLING_TYPE:
				setTransfCoolingType((TransformerCoolingType)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_TYPE:
				setTransformerType((TransformerType)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER:
				setHeatExchanger((HeatExchanger)newValue);
				return;
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS:
				getTransformerWindings().clear();
				getTransformerWindings().addAll((Collection)newValue);
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
			case WirePackage.POWER_TRANSFORMER__BMAG_SAT:
				setBmagSat(BMAG_SAT_EDEFAULT);
				return;
			case WirePackage.POWER_TRANSFORMER__MAG_BASE_KV:
				setMagBaseKV(MAG_BASE_KV_EDEFAULT);
				return;
			case WirePackage.POWER_TRANSFORMER__MAG_SAT_FLUX:
				setMagSatFlux(MAG_SAT_FLUX_EDEFAULT);
				return;
			case WirePackage.POWER_TRANSFORMER__PHASES:
				setPhases(PHASES_EDEFAULT);
				return;
			case WirePackage.POWER_TRANSFORMER__TRANSF_COOLING_TYPE:
				setTransfCoolingType(TRANSF_COOLING_TYPE_EDEFAULT);
				return;
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_TYPE:
				setTransformerType(TRANSFORMER_TYPE_EDEFAULT);
				return;
			case WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER:
				setHeatExchanger((HeatExchanger)null);
				return;
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS:
				getTransformerWindings().clear();
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
			case WirePackage.POWER_TRANSFORMER__BMAG_SAT:
				return BMAG_SAT_EDEFAULT == null ? bmagSat != null : !BMAG_SAT_EDEFAULT.equals(bmagSat);
			case WirePackage.POWER_TRANSFORMER__MAG_BASE_KV:
				return MAG_BASE_KV_EDEFAULT == null ? magBaseKV != null : !MAG_BASE_KV_EDEFAULT.equals(magBaseKV);
			case WirePackage.POWER_TRANSFORMER__MAG_SAT_FLUX:
				return MAG_SAT_FLUX_EDEFAULT == null ? magSatFlux != null : !MAG_SAT_FLUX_EDEFAULT.equals(magSatFlux);
			case WirePackage.POWER_TRANSFORMER__PHASES:
				return PHASES_EDEFAULT == null ? phases != null : !PHASES_EDEFAULT.equals(phases);
			case WirePackage.POWER_TRANSFORMER__TRANSF_COOLING_TYPE:
				return transfCoolingType != TRANSF_COOLING_TYPE_EDEFAULT;
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_TYPE:
				return transformerType != TRANSFORMER_TYPE_EDEFAULT;
			case WirePackage.POWER_TRANSFORMER__HEAT_EXCHANGER:
				return heatExchanger != null;
			case WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS:
				return transformerWindings != null && !transformerWindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("PowerTrasformer: \n" + super.toString() + "\n");
		result.append(" (bmagSat: ");
		result.append(bmagSat);
		result.append(", magBaseKV: ");
		result.append(magBaseKV);
		result.append(", magSatFlux: ");
		result.append(magSatFlux);
		result.append(", phases: ");
		result.append(phases);
		result.append(", transfCoolingType: ");
		result.append(transfCoolingType);
		result.append(", transformerType: ");
		result.append(transformerType);
		result.append(')');
		return result.toString();
	}

} //PowerTransformerImpl