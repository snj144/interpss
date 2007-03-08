/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroPowerPlantImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.domain.HydroPlantType;
import org.opencim.cim.iec61970.domain.PenstockType;
import org.opencim.cim.iec61970.domain.SurgeTankCode;

import org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit;
import org.opencim.cim.iec61970.gen.production.HydroPowerPlant;
import org.opencim.cim.iec61970.gen.production.HydroPump;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.Reservoir;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.WaterLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hydro Power Plant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getDischargeTravelDelay <em>Discharge Travel Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getHydroPlantType <em>Hydro Plant Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getPenstockType <em>Penstock Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getPlantDischargeCapacity <em>Plant Discharge Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getPlantMWGenRating <em>Plant MW Gen Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getPlantMWPumpRating <em>Plant MW Pump Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getPlantRatedHead <em>Plant Rated Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getSurgeTankCode <em>Surge Tank Code</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getSurgeTankCrestLevel <em>Surge Tank Crest Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getContain_HydroGeneratingUnits <em>Contain Hydro Generating Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getContain_HydroPumps <em>Contain Hydro Pumps</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getReservoir <em>Reservoir</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl#getGenSourcePumpDischarge <em>Gen Source Pump Discharge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HydroPowerPlantImpl extends PowerSystemResourceImpl implements HydroPowerPlant {
	/**
	 * The default value of the '{@link #getDischargeTravelDelay() <em>Discharge Travel Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDischargeTravelDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds DISCHARGE_TRAVEL_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDischargeTravelDelay() <em>Discharge Travel Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDischargeTravelDelay()
	 * @generated
	 * @ordered
	 */
	protected Seconds dischargeTravelDelay = DISCHARGE_TRAVEL_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getHydroPlantType() <em>Hydro Plant Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroPlantType()
	 * @generated
	 * @ordered
	 */
	protected static final HydroPlantType HYDRO_PLANT_TYPE_EDEFAULT = HydroPlantType.RUN_OF_RIVER_LITERAL;

	/**
	 * The cached value of the '{@link #getHydroPlantType() <em>Hydro Plant Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroPlantType()
	 * @generated
	 * @ordered
	 */
	protected HydroPlantType hydroPlantType = HYDRO_PLANT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPenstockType() <em>Penstock Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenstockType()
	 * @generated
	 * @ordered
	 */
	protected static final PenstockType PENSTOCK_TYPE_EDEFAULT = PenstockType.TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getPenstockType() <em>Penstock Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenstockType()
	 * @generated
	 * @ordered
	 */
	protected PenstockType penstockType = PENSTOCK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlantDischargeCapacity() <em>Plant Discharge Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantDischargeCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final Float PLANT_DISCHARGE_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlantDischargeCapacity() <em>Plant Discharge Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantDischargeCapacity()
	 * @generated
	 * @ordered
	 */
	protected Float plantDischargeCapacity = PLANT_DISCHARGE_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlantMWGenRating() <em>Plant MW Gen Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantMWGenRating()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower PLANT_MW_GEN_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlantMWGenRating() <em>Plant MW Gen Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantMWGenRating()
	 * @generated
	 * @ordered
	 */
	protected ActivePower plantMWGenRating = PLANT_MW_GEN_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlantMWPumpRating() <em>Plant MW Pump Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantMWPumpRating()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower PLANT_MW_PUMP_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlantMWPumpRating() <em>Plant MW Pump Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantMWPumpRating()
	 * @generated
	 * @ordered
	 */
	protected ActivePower plantMWPumpRating = PLANT_MW_PUMP_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlantRatedHead() <em>Plant Rated Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantRatedHead()
	 * @generated
	 * @ordered
	 */
	protected static final Float PLANT_RATED_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlantRatedHead() <em>Plant Rated Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlantRatedHead()
	 * @generated
	 * @ordered
	 */
	protected Float plantRatedHead = PLANT_RATED_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSurgeTankCode() <em>Surge Tank Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurgeTankCode()
	 * @generated
	 * @ordered
	 */
	protected static final SurgeTankCode SURGE_TANK_CODE_EDEFAULT = SurgeTankCode.TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getSurgeTankCode() <em>Surge Tank Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurgeTankCode()
	 * @generated
	 * @ordered
	 */
	protected SurgeTankCode surgeTankCode = SURGE_TANK_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSurgeTankCrestLevel() <em>Surge Tank Crest Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurgeTankCrestLevel()
	 * @generated
	 * @ordered
	 */
	protected static final WaterLevel SURGE_TANK_CREST_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSurgeTankCrestLevel() <em>Surge Tank Crest Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurgeTankCrestLevel()
	 * @generated
	 * @ordered
	 */
	protected WaterLevel surgeTankCrestLevel = SURGE_TANK_CREST_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContain_HydroGeneratingUnits() <em>Contain Hydro Generating Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContain_HydroGeneratingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList contain_HydroGeneratingUnits = null;

	/**
	 * The cached value of the '{@link #getContain_HydroPumps() <em>Contain Hydro Pumps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContain_HydroPumps()
	 * @generated
	 * @ordered
	 */
	protected EList contain_HydroPumps = null;

	/**
	 * The cached value of the '{@link #getReservoir() <em>Reservoir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReservoir()
	 * @generated
	 * @ordered
	 */
	protected Reservoir reservoir = null;

	/**
	 * The cached value of the '{@link #getGenSourcePumpDischarge() <em>Gen Source Pump Discharge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenSourcePumpDischarge()
	 * @generated
	 * @ordered
	 */
	protected Reservoir genSourcePumpDischarge = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HydroPowerPlantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.HYDRO_POWER_PLANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getDischargeTravelDelay() {
		return dischargeTravelDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDischargeTravelDelay(Seconds newDischargeTravelDelay) {
		Seconds oldDischargeTravelDelay = dischargeTravelDelay;
		dischargeTravelDelay = newDischargeTravelDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY, oldDischargeTravelDelay, dischargeTravelDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPlantType getHydroPlantType() {
		return hydroPlantType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHydroPlantType(HydroPlantType newHydroPlantType) {
		HydroPlantType oldHydroPlantType = hydroPlantType;
		hydroPlantType = newHydroPlantType == null ? HYDRO_PLANT_TYPE_EDEFAULT : newHydroPlantType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE, oldHydroPlantType, hydroPlantType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PenstockType getPenstockType() {
		return penstockType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPenstockType(PenstockType newPenstockType) {
		PenstockType oldPenstockType = penstockType;
		penstockType = newPenstockType == null ? PENSTOCK_TYPE_EDEFAULT : newPenstockType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__PENSTOCK_TYPE, oldPenstockType, penstockType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPlantDischargeCapacity() {
		return plantDischargeCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlantDischargeCapacity(Float newPlantDischargeCapacity) {
		Float oldPlantDischargeCapacity = plantDischargeCapacity;
		plantDischargeCapacity = newPlantDischargeCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY, oldPlantDischargeCapacity, plantDischargeCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getPlantMWGenRating() {
		return plantMWGenRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlantMWGenRating(ActivePower newPlantMWGenRating) {
		ActivePower oldPlantMWGenRating = plantMWGenRating;
		plantMWGenRating = newPlantMWGenRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING, oldPlantMWGenRating, plantMWGenRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getPlantMWPumpRating() {
		return plantMWPumpRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlantMWPumpRating(ActivePower newPlantMWPumpRating) {
		ActivePower oldPlantMWPumpRating = plantMWPumpRating;
		plantMWPumpRating = newPlantMWPumpRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING, oldPlantMWPumpRating, plantMWPumpRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPlantRatedHead() {
		return plantRatedHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlantRatedHead(Float newPlantRatedHead) {
		Float oldPlantRatedHead = plantRatedHead;
		plantRatedHead = newPlantRatedHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__PLANT_RATED_HEAD, oldPlantRatedHead, plantRatedHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SurgeTankCode getSurgeTankCode() {
		return surgeTankCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurgeTankCode(SurgeTankCode newSurgeTankCode) {
		SurgeTankCode oldSurgeTankCode = surgeTankCode;
		surgeTankCode = newSurgeTankCode == null ? SURGE_TANK_CODE_EDEFAULT : newSurgeTankCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CODE, oldSurgeTankCode, surgeTankCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel getSurgeTankCrestLevel() {
		return surgeTankCrestLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurgeTankCrestLevel(WaterLevel newSurgeTankCrestLevel) {
		WaterLevel oldSurgeTankCrestLevel = surgeTankCrestLevel;
		surgeTankCrestLevel = newSurgeTankCrestLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL, oldSurgeTankCrestLevel, surgeTankCrestLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContain_HydroGeneratingUnits() {
		if (contain_HydroGeneratingUnits == null) {
			contain_HydroGeneratingUnits = new EObjectContainmentEList(HydroGeneratingUnit.class, this, ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS);
		}
		return contain_HydroGeneratingUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContain_HydroPumps() {
		if (contain_HydroPumps == null) {
			contain_HydroPumps = new EObjectContainmentEList(HydroPump.class, this, ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS);
		}
		return contain_HydroPumps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir getReservoir() {
		if (reservoir != null && reservoir.eIsProxy()) {
			InternalEObject oldReservoir = (InternalEObject)reservoir;
			reservoir = (Reservoir)eResolveProxy(oldReservoir);
			if (reservoir != oldReservoir) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR, oldReservoir, reservoir));
			}
		}
		return reservoir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir basicGetReservoir() {
		return reservoir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReservoir(Reservoir newReservoir, NotificationChain msgs) {
		Reservoir oldReservoir = reservoir;
		reservoir = newReservoir;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR, oldReservoir, newReservoir);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReservoir(Reservoir newReservoir) {
		if (newReservoir != reservoir) {
			NotificationChain msgs = null;
			if (reservoir != null)
				msgs = ((InternalEObject)reservoir).eInverseRemove(this, ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS, Reservoir.class, msgs);
			if (newReservoir != null)
				msgs = ((InternalEObject)newReservoir).eInverseAdd(this, ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS, Reservoir.class, msgs);
			msgs = basicSetReservoir(newReservoir, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR, newReservoir, newReservoir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir getGenSourcePumpDischarge() {
		if (genSourcePumpDischarge != null && genSourcePumpDischarge.eIsProxy()) {
			InternalEObject oldGenSourcePumpDischarge = (InternalEObject)genSourcePumpDischarge;
			genSourcePumpDischarge = (Reservoir)eResolveProxy(oldGenSourcePumpDischarge);
			if (genSourcePumpDischarge != oldGenSourcePumpDischarge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE, oldGenSourcePumpDischarge, genSourcePumpDischarge));
			}
		}
		return genSourcePumpDischarge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir basicGetGenSourcePumpDischarge() {
		return genSourcePumpDischarge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenSourcePumpDischarge(Reservoir newGenSourcePumpDischarge, NotificationChain msgs) {
		Reservoir oldGenSourcePumpDischarge = genSourcePumpDischarge;
		genSourcePumpDischarge = newGenSourcePumpDischarge;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE, oldGenSourcePumpDischarge, newGenSourcePumpDischarge);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenSourcePumpDischarge(Reservoir newGenSourcePumpDischarge) {
		if (newGenSourcePumpDischarge != genSourcePumpDischarge) {
			NotificationChain msgs = null;
			if (genSourcePumpDischarge != null)
				msgs = ((InternalEObject)genSourcePumpDischarge).eInverseRemove(this, ProductionPackage.RESERVOIR__UPSTREAM_FROM, Reservoir.class, msgs);
			if (newGenSourcePumpDischarge != null)
				msgs = ((InternalEObject)newGenSourcePumpDischarge).eInverseAdd(this, ProductionPackage.RESERVOIR__UPSTREAM_FROM, Reservoir.class, msgs);
			msgs = basicSetGenSourcePumpDischarge(newGenSourcePumpDischarge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE, newGenSourcePumpDischarge, newGenSourcePumpDischarge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR:
				if (reservoir != null)
					msgs = ((InternalEObject)reservoir).eInverseRemove(this, ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS, Reservoir.class, msgs);
				return basicSetReservoir((Reservoir)otherEnd, msgs);
			case ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE:
				if (genSourcePumpDischarge != null)
					msgs = ((InternalEObject)genSourcePumpDischarge).eInverseRemove(this, ProductionPackage.RESERVOIR__UPSTREAM_FROM, Reservoir.class, msgs);
				return basicSetGenSourcePumpDischarge((Reservoir)otherEnd, msgs);
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
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS:
				return ((InternalEList)getContain_HydroGeneratingUnits()).basicRemove(otherEnd, msgs);
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS:
				return ((InternalEList)getContain_HydroPumps()).basicRemove(otherEnd, msgs);
			case ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR:
				return basicSetReservoir(null, msgs);
			case ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE:
				return basicSetGenSourcePumpDischarge(null, msgs);
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
			case ProductionPackage.HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY:
				return getDischargeTravelDelay();
			case ProductionPackage.HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE:
				return getHydroPlantType();
			case ProductionPackage.HYDRO_POWER_PLANT__PENSTOCK_TYPE:
				return getPenstockType();
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY:
				return getPlantDischargeCapacity();
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING:
				return getPlantMWGenRating();
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING:
				return getPlantMWPumpRating();
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_RATED_HEAD:
				return getPlantRatedHead();
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CODE:
				return getSurgeTankCode();
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL:
				return getSurgeTankCrestLevel();
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS:
				return getContain_HydroGeneratingUnits();
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS:
				return getContain_HydroPumps();
			case ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR:
				if (resolve) return getReservoir();
				return basicGetReservoir();
			case ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE:
				if (resolve) return getGenSourcePumpDischarge();
				return basicGetGenSourcePumpDischarge();
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
			case ProductionPackage.HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY:
				setDischargeTravelDelay((Seconds)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE:
				setHydroPlantType((HydroPlantType)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PENSTOCK_TYPE:
				setPenstockType((PenstockType)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY:
				setPlantDischargeCapacity((Float)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING:
				setPlantMWGenRating((ActivePower)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING:
				setPlantMWPumpRating((ActivePower)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_RATED_HEAD:
				setPlantRatedHead((Float)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CODE:
				setSurgeTankCode((SurgeTankCode)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL:
				setSurgeTankCrestLevel((WaterLevel)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS:
				getContain_HydroGeneratingUnits().clear();
				getContain_HydroGeneratingUnits().addAll((Collection)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS:
				getContain_HydroPumps().clear();
				getContain_HydroPumps().addAll((Collection)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR:
				setReservoir((Reservoir)newValue);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE:
				setGenSourcePumpDischarge((Reservoir)newValue);
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
			case ProductionPackage.HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY:
				setDischargeTravelDelay(DISCHARGE_TRAVEL_DELAY_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE:
				setHydroPlantType(HYDRO_PLANT_TYPE_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PENSTOCK_TYPE:
				setPenstockType(PENSTOCK_TYPE_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY:
				setPlantDischargeCapacity(PLANT_DISCHARGE_CAPACITY_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING:
				setPlantMWGenRating(PLANT_MW_GEN_RATING_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING:
				setPlantMWPumpRating(PLANT_MW_PUMP_RATING_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_RATED_HEAD:
				setPlantRatedHead(PLANT_RATED_HEAD_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CODE:
				setSurgeTankCode(SURGE_TANK_CODE_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL:
				setSurgeTankCrestLevel(SURGE_TANK_CREST_LEVEL_EDEFAULT);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS:
				getContain_HydroGeneratingUnits().clear();
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS:
				getContain_HydroPumps().clear();
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR:
				setReservoir((Reservoir)null);
				return;
			case ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE:
				setGenSourcePumpDischarge((Reservoir)null);
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
			case ProductionPackage.HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY:
				return DISCHARGE_TRAVEL_DELAY_EDEFAULT == null ? dischargeTravelDelay != null : !DISCHARGE_TRAVEL_DELAY_EDEFAULT.equals(dischargeTravelDelay);
			case ProductionPackage.HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE:
				return hydroPlantType != HYDRO_PLANT_TYPE_EDEFAULT;
			case ProductionPackage.HYDRO_POWER_PLANT__PENSTOCK_TYPE:
				return penstockType != PENSTOCK_TYPE_EDEFAULT;
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY:
				return PLANT_DISCHARGE_CAPACITY_EDEFAULT == null ? plantDischargeCapacity != null : !PLANT_DISCHARGE_CAPACITY_EDEFAULT.equals(plantDischargeCapacity);
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING:
				return PLANT_MW_GEN_RATING_EDEFAULT == null ? plantMWGenRating != null : !PLANT_MW_GEN_RATING_EDEFAULT.equals(plantMWGenRating);
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING:
				return PLANT_MW_PUMP_RATING_EDEFAULT == null ? plantMWPumpRating != null : !PLANT_MW_PUMP_RATING_EDEFAULT.equals(plantMWPumpRating);
			case ProductionPackage.HYDRO_POWER_PLANT__PLANT_RATED_HEAD:
				return PLANT_RATED_HEAD_EDEFAULT == null ? plantRatedHead != null : !PLANT_RATED_HEAD_EDEFAULT.equals(plantRatedHead);
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CODE:
				return surgeTankCode != SURGE_TANK_CODE_EDEFAULT;
			case ProductionPackage.HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL:
				return SURGE_TANK_CREST_LEVEL_EDEFAULT == null ? surgeTankCrestLevel != null : !SURGE_TANK_CREST_LEVEL_EDEFAULT.equals(surgeTankCrestLevel);
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS:
				return contain_HydroGeneratingUnits != null && !contain_HydroGeneratingUnits.isEmpty();
			case ProductionPackage.HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS:
				return contain_HydroPumps != null && !contain_HydroPumps.isEmpty();
			case ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR:
				return reservoir != null;
			case ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE:
				return genSourcePumpDischarge != null;
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
		result.append(" (dischargeTravelDelay: ");
		result.append(dischargeTravelDelay);
		result.append(", hydroPlantType: ");
		result.append(hydroPlantType);
		result.append(", penstockType: ");
		result.append(penstockType);
		result.append(", plantDischargeCapacity: ");
		result.append(plantDischargeCapacity);
		result.append(", plantMWGenRating: ");
		result.append(plantMWGenRating);
		result.append(", plantMWPumpRating: ");
		result.append(plantMWPumpRating);
		result.append(", plantRatedHead: ");
		result.append(plantRatedHead);
		result.append(", surgeTankCode: ");
		result.append(surgeTankCode);
		result.append(", surgeTankCrestLevel: ");
		result.append(surgeTankCrestLevel);
		result.append(')');
		return result.toString();
	}

} //HydroPowerPlantImpl