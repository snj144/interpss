/**
 * <copyright>
 * </copyright>
 *
 * $Id: CAESPlantImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.gen.production.AirCompressor;
import org.opencim.cim.iec61970.gen.production.CAESPlant;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.EnergyAsMWh;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CAES Plant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl#getEnergyStorageCapacity <em>Energy Storage Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl#getRatedCapacityMW <em>Rated Capacity MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl#getContain_AirCompressor <em>Contain Air Compressor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl#getContain_ThermalGeneratingUnit <em>Contain Thermal Generating Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CAESPlantImpl extends PowerSystemResourceImpl implements CAESPlant {
	/**
	 * The default value of the '{@link #getEnergyStorageCapacity() <em>Energy Storage Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyStorageCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final EnergyAsMWh ENERGY_STORAGE_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnergyStorageCapacity() <em>Energy Storage Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyStorageCapacity()
	 * @generated
	 * @ordered
	 */
	protected EnergyAsMWh energyStorageCapacity = ENERGY_STORAGE_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRatedCapacityMW() <em>Rated Capacity MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedCapacityMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower RATED_CAPACITY_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedCapacityMW() <em>Rated Capacity MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedCapacityMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower ratedCapacityMW = RATED_CAPACITY_MW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContain_AirCompressor() <em>Contain Air Compressor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContain_AirCompressor()
	 * @generated
	 * @ordered
	 */
	protected AirCompressor contain_AirCompressor;

	/**
	 * The cached value of the '{@link #getContain_ThermalGeneratingUnit() <em>Contain Thermal Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContain_ThermalGeneratingUnit()
	 * @generated
	 * @ordered
	 */
	protected ThermalGeneratingUnit contain_ThermalGeneratingUnit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CAESPlantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.CAES_PLANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyAsMWh getEnergyStorageCapacity() {
		return energyStorageCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyStorageCapacity(EnergyAsMWh newEnergyStorageCapacity) {
		EnergyAsMWh oldEnergyStorageCapacity = energyStorageCapacity;
		energyStorageCapacity = newEnergyStorageCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.CAES_PLANT__ENERGY_STORAGE_CAPACITY, oldEnergyStorageCapacity, energyStorageCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getRatedCapacityMW() {
		return ratedCapacityMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedCapacityMW(ActivePower newRatedCapacityMW) {
		ActivePower oldRatedCapacityMW = ratedCapacityMW;
		ratedCapacityMW = newRatedCapacityMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.CAES_PLANT__RATED_CAPACITY_MW, oldRatedCapacityMW, ratedCapacityMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AirCompressor getContain_AirCompressor() {
		return contain_AirCompressor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContain_AirCompressor(AirCompressor newContain_AirCompressor, NotificationChain msgs) {
		AirCompressor oldContain_AirCompressor = contain_AirCompressor;
		contain_AirCompressor = newContain_AirCompressor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR, oldContain_AirCompressor, newContain_AirCompressor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContain_AirCompressor(AirCompressor newContain_AirCompressor) {
		if (newContain_AirCompressor != contain_AirCompressor) {
			NotificationChain msgs = null;
			if (contain_AirCompressor != null)
				msgs = ((InternalEObject)contain_AirCompressor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR, null, msgs);
			if (newContain_AirCompressor != null)
				msgs = ((InternalEObject)newContain_AirCompressor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR, null, msgs);
			msgs = basicSetContain_AirCompressor(newContain_AirCompressor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR, newContain_AirCompressor, newContain_AirCompressor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThermalGeneratingUnit getContain_ThermalGeneratingUnit() {
		if (contain_ThermalGeneratingUnit != null && contain_ThermalGeneratingUnit.eIsProxy()) {
			InternalEObject oldContain_ThermalGeneratingUnit = (InternalEObject)contain_ThermalGeneratingUnit;
			contain_ThermalGeneratingUnit = (ThermalGeneratingUnit)eResolveProxy(oldContain_ThermalGeneratingUnit);
			if (contain_ThermalGeneratingUnit != oldContain_ThermalGeneratingUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT, oldContain_ThermalGeneratingUnit, contain_ThermalGeneratingUnit));
			}
		}
		return contain_ThermalGeneratingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThermalGeneratingUnit basicGetContain_ThermalGeneratingUnit() {
		return contain_ThermalGeneratingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContain_ThermalGeneratingUnit(ThermalGeneratingUnit newContain_ThermalGeneratingUnit, NotificationChain msgs) {
		ThermalGeneratingUnit oldContain_ThermalGeneratingUnit = contain_ThermalGeneratingUnit;
		contain_ThermalGeneratingUnit = newContain_ThermalGeneratingUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT, oldContain_ThermalGeneratingUnit, newContain_ThermalGeneratingUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContain_ThermalGeneratingUnit(ThermalGeneratingUnit newContain_ThermalGeneratingUnit) {
		if (newContain_ThermalGeneratingUnit != contain_ThermalGeneratingUnit) {
			NotificationChain msgs = null;
			if (contain_ThermalGeneratingUnit != null)
				msgs = ((InternalEObject)contain_ThermalGeneratingUnit).eInverseRemove(this, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT, ThermalGeneratingUnit.class, msgs);
			if (newContain_ThermalGeneratingUnit != null)
				msgs = ((InternalEObject)newContain_ThermalGeneratingUnit).eInverseAdd(this, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT, ThermalGeneratingUnit.class, msgs);
			msgs = basicSetContain_ThermalGeneratingUnit(newContain_ThermalGeneratingUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT, newContain_ThermalGeneratingUnit, newContain_ThermalGeneratingUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT:
				if (contain_ThermalGeneratingUnit != null)
					msgs = ((InternalEObject)contain_ThermalGeneratingUnit).eInverseRemove(this, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT, ThermalGeneratingUnit.class, msgs);
				return basicSetContain_ThermalGeneratingUnit((ThermalGeneratingUnit)otherEnd, msgs);
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
			case ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR:
				return basicSetContain_AirCompressor(null, msgs);
			case ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT:
				return basicSetContain_ThermalGeneratingUnit(null, msgs);
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
			case ProductionPackage.CAES_PLANT__ENERGY_STORAGE_CAPACITY:
				return getEnergyStorageCapacity();
			case ProductionPackage.CAES_PLANT__RATED_CAPACITY_MW:
				return getRatedCapacityMW();
			case ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR:
				return getContain_AirCompressor();
			case ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT:
				if (resolve) return getContain_ThermalGeneratingUnit();
				return basicGetContain_ThermalGeneratingUnit();
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
			case ProductionPackage.CAES_PLANT__ENERGY_STORAGE_CAPACITY:
				setEnergyStorageCapacity((EnergyAsMWh)newValue);
				return;
			case ProductionPackage.CAES_PLANT__RATED_CAPACITY_MW:
				setRatedCapacityMW((ActivePower)newValue);
				return;
			case ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR:
				setContain_AirCompressor((AirCompressor)newValue);
				return;
			case ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT:
				setContain_ThermalGeneratingUnit((ThermalGeneratingUnit)newValue);
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
			case ProductionPackage.CAES_PLANT__ENERGY_STORAGE_CAPACITY:
				setEnergyStorageCapacity(ENERGY_STORAGE_CAPACITY_EDEFAULT);
				return;
			case ProductionPackage.CAES_PLANT__RATED_CAPACITY_MW:
				setRatedCapacityMW(RATED_CAPACITY_MW_EDEFAULT);
				return;
			case ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR:
				setContain_AirCompressor((AirCompressor)null);
				return;
			case ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT:
				setContain_ThermalGeneratingUnit((ThermalGeneratingUnit)null);
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
			case ProductionPackage.CAES_PLANT__ENERGY_STORAGE_CAPACITY:
				return ENERGY_STORAGE_CAPACITY_EDEFAULT == null ? energyStorageCapacity != null : !ENERGY_STORAGE_CAPACITY_EDEFAULT.equals(energyStorageCapacity);
			case ProductionPackage.CAES_PLANT__RATED_CAPACITY_MW:
				return RATED_CAPACITY_MW_EDEFAULT == null ? ratedCapacityMW != null : !RATED_CAPACITY_MW_EDEFAULT.equals(ratedCapacityMW);
			case ProductionPackage.CAES_PLANT__CONTAIN_AIR_COMPRESSOR:
				return contain_AirCompressor != null;
			case ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT:
				return contain_ThermalGeneratingUnit != null;
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
		result.append(" (energyStorageCapacity: ");
		result.append(energyStorageCapacity);
		result.append(", ratedCapacityMW: ");
		result.append(ratedCapacityMW);
		result.append(')');
		return result.toString();
	}

} //CAESPlantImpl