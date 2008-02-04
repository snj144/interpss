/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReservoirImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.domain.SpillwayGateType;

import org.opencim.cim.iec61970.gen.production.HydroPowerPlant;
import org.opencim.cim.iec61970.gen.production.InflowForecast;
import org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.Reservoir;
import org.opencim.cim.iec61970.gen.production.TargetLevelSchedule;

import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Volume;
import org.opencim.datatype.real.WaterLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reservoir</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getActiveStorageCapacity <em>Active Storage Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getEnergyStorageRating <em>Energy Storage Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getFullSupplyLevel <em>Full Supply Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getGrossCapacity <em>Gross Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getNormalMinOperateLevel <em>Normal Min Operate Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getRiverOutletWorks <em>River Outlet Works</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillTravelDelay <em>Spill Travel Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillwayCapacity <em>Spillway Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillwayCrestLength <em>Spillway Crest Length</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillwayCrestLevel <em>Spillway Crest Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillWayGateType <em>Spill Way Gate Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getHydroPowerPlants <em>Hydro Power Plants</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getUpstreamFrom <em>Upstream From</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getLevelVsVolumeCurve <em>Level Vs Volume Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getTargetLevelSchedule <em>Target Level Schedule</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getInflowForecast <em>Inflow Forecast</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillsInto <em>Spills Into</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl#getSpillsFrom <em>Spills From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReservoirImpl extends PowerSystemResourceImpl implements Reservoir {
	/**
	 * The default value of the '{@link #getActiveStorageCapacity() <em>Active Storage Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveStorageCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final Volume ACTIVE_STORAGE_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActiveStorageCapacity() <em>Active Storage Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveStorageCapacity()
	 * @generated
	 * @ordered
	 */
	protected Volume activeStorageCapacity = ACTIVE_STORAGE_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnergyStorageRating() <em>Energy Storage Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyStorageRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float ENERGY_STORAGE_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnergyStorageRating() <em>Energy Storage Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyStorageRating()
	 * @generated
	 * @ordered
	 */
	protected Float energyStorageRating = ENERGY_STORAGE_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getFullSupplyLevel() <em>Full Supply Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullSupplyLevel()
	 * @generated
	 * @ordered
	 */
	protected static final WaterLevel FULL_SUPPLY_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullSupplyLevel() <em>Full Supply Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullSupplyLevel()
	 * @generated
	 * @ordered
	 */
	protected WaterLevel fullSupplyLevel = FULL_SUPPLY_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrossCapacity() <em>Gross Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrossCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final Volume GROSS_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGrossCapacity() <em>Gross Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrossCapacity()
	 * @generated
	 * @ordered
	 */
	protected Volume grossCapacity = GROSS_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalMinOperateLevel() <em>Normal Min Operate Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalMinOperateLevel()
	 * @generated
	 * @ordered
	 */
	protected static final WaterLevel NORMAL_MIN_OPERATE_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNormalMinOperateLevel() <em>Normal Min Operate Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalMinOperateLevel()
	 * @generated
	 * @ordered
	 */
	protected WaterLevel normalMinOperateLevel = NORMAL_MIN_OPERATE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRiverOutletWorks() <em>River Outlet Works</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiverOutletWorks()
	 * @generated
	 * @ordered
	 */
	protected static final String RIVER_OUTLET_WORKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRiverOutletWorks() <em>River Outlet Works</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiverOutletWorks()
	 * @generated
	 * @ordered
	 */
	protected String riverOutletWorks = RIVER_OUTLET_WORKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpillTravelDelay() <em>Spill Travel Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillTravelDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds SPILL_TRAVEL_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpillTravelDelay() <em>Spill Travel Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillTravelDelay()
	 * @generated
	 * @ordered
	 */
	protected Seconds spillTravelDelay = SPILL_TRAVEL_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpillwayCapacity() <em>Spillway Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillwayCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final Float SPILLWAY_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpillwayCapacity() <em>Spillway Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillwayCapacity()
	 * @generated
	 * @ordered
	 */
	protected Float spillwayCapacity = SPILLWAY_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpillwayCrestLength() <em>Spillway Crest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillwayCrestLength()
	 * @generated
	 * @ordered
	 */
	protected static final Float SPILLWAY_CREST_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpillwayCrestLength() <em>Spillway Crest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillwayCrestLength()
	 * @generated
	 * @ordered
	 */
	protected Float spillwayCrestLength = SPILLWAY_CREST_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpillwayCrestLevel() <em>Spillway Crest Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillwayCrestLevel()
	 * @generated
	 * @ordered
	 */
	protected static final WaterLevel SPILLWAY_CREST_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpillwayCrestLevel() <em>Spillway Crest Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillwayCrestLevel()
	 * @generated
	 * @ordered
	 */
	protected WaterLevel spillwayCrestLevel = SPILLWAY_CREST_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpillWayGateType() <em>Spill Way Gate Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillWayGateType()
	 * @generated
	 * @ordered
	 */
	protected static final SpillwayGateType SPILL_WAY_GATE_TYPE_EDEFAULT = SpillwayGateType.TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getSpillWayGateType() <em>Spill Way Gate Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillWayGateType()
	 * @generated
	 * @ordered
	 */
	protected SpillwayGateType spillWayGateType = SPILL_WAY_GATE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHydroPowerPlants() <em>Hydro Power Plants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHydroPowerPlants()
	 * @generated
	 * @ordered
	 */
	protected EList hydroPowerPlants;

	/**
	 * The cached value of the '{@link #getUpstreamFrom() <em>Upstream From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpstreamFrom()
	 * @generated
	 * @ordered
	 */
	protected EList upstreamFrom;

	/**
	 * The cached value of the '{@link #getLevelVsVolumeCurve() <em>Level Vs Volume Curve</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevelVsVolumeCurve()
	 * @generated
	 * @ordered
	 */
	protected EList levelVsVolumeCurve;

	/**
	 * The cached value of the '{@link #getTargetLevelSchedule() <em>Target Level Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLevelSchedule()
	 * @generated
	 * @ordered
	 */
	protected TargetLevelSchedule targetLevelSchedule;

	/**
	 * The cached value of the '{@link #getInflowForecast() <em>Inflow Forecast</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInflowForecast()
	 * @generated
	 * @ordered
	 */
	protected EList inflowForecast;

	/**
	 * The cached value of the '{@link #getSpillsInto() <em>Spills Into</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillsInto()
	 * @generated
	 * @ordered
	 */
	protected EList spillsInto;

	/**
	 * The cached value of the '{@link #getSpillsFrom() <em>Spills From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpillsFrom()
	 * @generated
	 * @ordered
	 */
	protected Reservoir spillsFrom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReservoirImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.RESERVOIR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Volume getActiveStorageCapacity() {
		return activeStorageCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveStorageCapacity(Volume newActiveStorageCapacity) {
		Volume oldActiveStorageCapacity = activeStorageCapacity;
		activeStorageCapacity = newActiveStorageCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__ACTIVE_STORAGE_CAPACITY, oldActiveStorageCapacity, activeStorageCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getEnergyStorageRating() {
		return energyStorageRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyStorageRating(Float newEnergyStorageRating) {
		Float oldEnergyStorageRating = energyStorageRating;
		energyStorageRating = newEnergyStorageRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__ENERGY_STORAGE_RATING, oldEnergyStorageRating, energyStorageRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel getFullSupplyLevel() {
		return fullSupplyLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullSupplyLevel(WaterLevel newFullSupplyLevel) {
		WaterLevel oldFullSupplyLevel = fullSupplyLevel;
		fullSupplyLevel = newFullSupplyLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__FULL_SUPPLY_LEVEL, oldFullSupplyLevel, fullSupplyLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Volume getGrossCapacity() {
		return grossCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrossCapacity(Volume newGrossCapacity) {
		Volume oldGrossCapacity = grossCapacity;
		grossCapacity = newGrossCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__GROSS_CAPACITY, oldGrossCapacity, grossCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel getNormalMinOperateLevel() {
		return normalMinOperateLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalMinOperateLevel(WaterLevel newNormalMinOperateLevel) {
		WaterLevel oldNormalMinOperateLevel = normalMinOperateLevel;
		normalMinOperateLevel = newNormalMinOperateLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__NORMAL_MIN_OPERATE_LEVEL, oldNormalMinOperateLevel, normalMinOperateLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRiverOutletWorks() {
		return riverOutletWorks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiverOutletWorks(String newRiverOutletWorks) {
		String oldRiverOutletWorks = riverOutletWorks;
		riverOutletWorks = newRiverOutletWorks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__RIVER_OUTLET_WORKS, oldRiverOutletWorks, riverOutletWorks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getSpillTravelDelay() {
		return spillTravelDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpillTravelDelay(Seconds newSpillTravelDelay) {
		Seconds oldSpillTravelDelay = spillTravelDelay;
		spillTravelDelay = newSpillTravelDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILL_TRAVEL_DELAY, oldSpillTravelDelay, spillTravelDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSpillwayCapacity() {
		return spillwayCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpillwayCapacity(Float newSpillwayCapacity) {
		Float oldSpillwayCapacity = spillwayCapacity;
		spillwayCapacity = newSpillwayCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILLWAY_CAPACITY, oldSpillwayCapacity, spillwayCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSpillwayCrestLength() {
		return spillwayCrestLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpillwayCrestLength(Float newSpillwayCrestLength) {
		Float oldSpillwayCrestLength = spillwayCrestLength;
		spillwayCrestLength = newSpillwayCrestLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILLWAY_CREST_LENGTH, oldSpillwayCrestLength, spillwayCrestLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel getSpillwayCrestLevel() {
		return spillwayCrestLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpillwayCrestLevel(WaterLevel newSpillwayCrestLevel) {
		WaterLevel oldSpillwayCrestLevel = spillwayCrestLevel;
		spillwayCrestLevel = newSpillwayCrestLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILLWAY_CREST_LEVEL, oldSpillwayCrestLevel, spillwayCrestLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpillwayGateType getSpillWayGateType() {
		return spillWayGateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpillWayGateType(SpillwayGateType newSpillWayGateType) {
		SpillwayGateType oldSpillWayGateType = spillWayGateType;
		spillWayGateType = newSpillWayGateType == null ? SPILL_WAY_GATE_TYPE_EDEFAULT : newSpillWayGateType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILL_WAY_GATE_TYPE, oldSpillWayGateType, spillWayGateType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getHydroPowerPlants() {
		if (hydroPowerPlants == null) {
			hydroPowerPlants = new EObjectWithInverseResolvingEList(HydroPowerPlant.class, this, ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS, ProductionPackage.HYDRO_POWER_PLANT__RESERVOIR);
		}
		return hydroPowerPlants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUpstreamFrom() {
		if (upstreamFrom == null) {
			upstreamFrom = new EObjectWithInverseResolvingEList(HydroPowerPlant.class, this, ProductionPackage.RESERVOIR__UPSTREAM_FROM, ProductionPackage.HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE);
		}
		return upstreamFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLevelVsVolumeCurve() {
		if (levelVsVolumeCurve == null) {
			levelVsVolumeCurve = new EObjectContainmentEList(LevelVsVolumeCurve.class, this, ProductionPackage.RESERVOIR__LEVEL_VS_VOLUME_CURVE);
		}
		return levelVsVolumeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetLevelSchedule getTargetLevelSchedule() {
		return targetLevelSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetLevelSchedule(TargetLevelSchedule newTargetLevelSchedule, NotificationChain msgs) {
		TargetLevelSchedule oldTargetLevelSchedule = targetLevelSchedule;
		targetLevelSchedule = newTargetLevelSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE, oldTargetLevelSchedule, newTargetLevelSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLevelSchedule(TargetLevelSchedule newTargetLevelSchedule) {
		if (newTargetLevelSchedule != targetLevelSchedule) {
			NotificationChain msgs = null;
			if (targetLevelSchedule != null)
				msgs = ((InternalEObject)targetLevelSchedule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE, null, msgs);
			if (newTargetLevelSchedule != null)
				msgs = ((InternalEObject)newTargetLevelSchedule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE, null, msgs);
			msgs = basicSetTargetLevelSchedule(newTargetLevelSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE, newTargetLevelSchedule, newTargetLevelSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInflowForecast() {
		if (inflowForecast == null) {
			inflowForecast = new EObjectContainmentEList(InflowForecast.class, this, ProductionPackage.RESERVOIR__INFLOW_FORECAST);
		}
		return inflowForecast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSpillsInto() {
		if (spillsInto == null) {
			spillsInto = new EObjectWithInverseResolvingEList(Reservoir.class, this, ProductionPackage.RESERVOIR__SPILLS_INTO, ProductionPackage.RESERVOIR__SPILLS_FROM);
		}
		return spillsInto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir getSpillsFrom() {
		if (spillsFrom != null && spillsFrom.eIsProxy()) {
			InternalEObject oldSpillsFrom = (InternalEObject)spillsFrom;
			spillsFrom = (Reservoir)eResolveProxy(oldSpillsFrom);
			if (spillsFrom != oldSpillsFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.RESERVOIR__SPILLS_FROM, oldSpillsFrom, spillsFrom));
			}
		}
		return spillsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir basicGetSpillsFrom() {
		return spillsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpillsFrom(Reservoir newSpillsFrom, NotificationChain msgs) {
		Reservoir oldSpillsFrom = spillsFrom;
		spillsFrom = newSpillsFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILLS_FROM, oldSpillsFrom, newSpillsFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpillsFrom(Reservoir newSpillsFrom) {
		if (newSpillsFrom != spillsFrom) {
			NotificationChain msgs = null;
			if (spillsFrom != null)
				msgs = ((InternalEObject)spillsFrom).eInverseRemove(this, ProductionPackage.RESERVOIR__SPILLS_INTO, Reservoir.class, msgs);
			if (newSpillsFrom != null)
				msgs = ((InternalEObject)newSpillsFrom).eInverseAdd(this, ProductionPackage.RESERVOIR__SPILLS_INTO, Reservoir.class, msgs);
			msgs = basicSetSpillsFrom(newSpillsFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.RESERVOIR__SPILLS_FROM, newSpillsFrom, newSpillsFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS:
				return ((InternalEList)getHydroPowerPlants()).basicAdd(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__UPSTREAM_FROM:
				return ((InternalEList)getUpstreamFrom()).basicAdd(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__SPILLS_INTO:
				return ((InternalEList)getSpillsInto()).basicAdd(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__SPILLS_FROM:
				if (spillsFrom != null)
					msgs = ((InternalEObject)spillsFrom).eInverseRemove(this, ProductionPackage.RESERVOIR__SPILLS_INTO, Reservoir.class, msgs);
				return basicSetSpillsFrom((Reservoir)otherEnd, msgs);
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
			case ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS:
				return ((InternalEList)getHydroPowerPlants()).basicRemove(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__UPSTREAM_FROM:
				return ((InternalEList)getUpstreamFrom()).basicRemove(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__LEVEL_VS_VOLUME_CURVE:
				return ((InternalEList)getLevelVsVolumeCurve()).basicRemove(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE:
				return basicSetTargetLevelSchedule(null, msgs);
			case ProductionPackage.RESERVOIR__INFLOW_FORECAST:
				return ((InternalEList)getInflowForecast()).basicRemove(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__SPILLS_INTO:
				return ((InternalEList)getSpillsInto()).basicRemove(otherEnd, msgs);
			case ProductionPackage.RESERVOIR__SPILLS_FROM:
				return basicSetSpillsFrom(null, msgs);
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
			case ProductionPackage.RESERVOIR__ACTIVE_STORAGE_CAPACITY:
				return getActiveStorageCapacity();
			case ProductionPackage.RESERVOIR__ENERGY_STORAGE_RATING:
				return getEnergyStorageRating();
			case ProductionPackage.RESERVOIR__FULL_SUPPLY_LEVEL:
				return getFullSupplyLevel();
			case ProductionPackage.RESERVOIR__GROSS_CAPACITY:
				return getGrossCapacity();
			case ProductionPackage.RESERVOIR__NORMAL_MIN_OPERATE_LEVEL:
				return getNormalMinOperateLevel();
			case ProductionPackage.RESERVOIR__RIVER_OUTLET_WORKS:
				return getRiverOutletWorks();
			case ProductionPackage.RESERVOIR__SPILL_TRAVEL_DELAY:
				return getSpillTravelDelay();
			case ProductionPackage.RESERVOIR__SPILLWAY_CAPACITY:
				return getSpillwayCapacity();
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LENGTH:
				return getSpillwayCrestLength();
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LEVEL:
				return getSpillwayCrestLevel();
			case ProductionPackage.RESERVOIR__SPILL_WAY_GATE_TYPE:
				return getSpillWayGateType();
			case ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS:
				return getHydroPowerPlants();
			case ProductionPackage.RESERVOIR__UPSTREAM_FROM:
				return getUpstreamFrom();
			case ProductionPackage.RESERVOIR__LEVEL_VS_VOLUME_CURVE:
				return getLevelVsVolumeCurve();
			case ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE:
				return getTargetLevelSchedule();
			case ProductionPackage.RESERVOIR__INFLOW_FORECAST:
				return getInflowForecast();
			case ProductionPackage.RESERVOIR__SPILLS_INTO:
				return getSpillsInto();
			case ProductionPackage.RESERVOIR__SPILLS_FROM:
				if (resolve) return getSpillsFrom();
				return basicGetSpillsFrom();
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
			case ProductionPackage.RESERVOIR__ACTIVE_STORAGE_CAPACITY:
				setActiveStorageCapacity((Volume)newValue);
				return;
			case ProductionPackage.RESERVOIR__ENERGY_STORAGE_RATING:
				setEnergyStorageRating((Float)newValue);
				return;
			case ProductionPackage.RESERVOIR__FULL_SUPPLY_LEVEL:
				setFullSupplyLevel((WaterLevel)newValue);
				return;
			case ProductionPackage.RESERVOIR__GROSS_CAPACITY:
				setGrossCapacity((Volume)newValue);
				return;
			case ProductionPackage.RESERVOIR__NORMAL_MIN_OPERATE_LEVEL:
				setNormalMinOperateLevel((WaterLevel)newValue);
				return;
			case ProductionPackage.RESERVOIR__RIVER_OUTLET_WORKS:
				setRiverOutletWorks((String)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILL_TRAVEL_DELAY:
				setSpillTravelDelay((Seconds)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILLWAY_CAPACITY:
				setSpillwayCapacity((Float)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LENGTH:
				setSpillwayCrestLength((Float)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LEVEL:
				setSpillwayCrestLevel((WaterLevel)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILL_WAY_GATE_TYPE:
				setSpillWayGateType((SpillwayGateType)newValue);
				return;
			case ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS:
				getHydroPowerPlants().clear();
				getHydroPowerPlants().addAll((Collection)newValue);
				return;
			case ProductionPackage.RESERVOIR__UPSTREAM_FROM:
				getUpstreamFrom().clear();
				getUpstreamFrom().addAll((Collection)newValue);
				return;
			case ProductionPackage.RESERVOIR__LEVEL_VS_VOLUME_CURVE:
				getLevelVsVolumeCurve().clear();
				getLevelVsVolumeCurve().addAll((Collection)newValue);
				return;
			case ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE:
				setTargetLevelSchedule((TargetLevelSchedule)newValue);
				return;
			case ProductionPackage.RESERVOIR__INFLOW_FORECAST:
				getInflowForecast().clear();
				getInflowForecast().addAll((Collection)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILLS_INTO:
				getSpillsInto().clear();
				getSpillsInto().addAll((Collection)newValue);
				return;
			case ProductionPackage.RESERVOIR__SPILLS_FROM:
				setSpillsFrom((Reservoir)newValue);
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
			case ProductionPackage.RESERVOIR__ACTIVE_STORAGE_CAPACITY:
				setActiveStorageCapacity(ACTIVE_STORAGE_CAPACITY_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__ENERGY_STORAGE_RATING:
				setEnergyStorageRating(ENERGY_STORAGE_RATING_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__FULL_SUPPLY_LEVEL:
				setFullSupplyLevel(FULL_SUPPLY_LEVEL_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__GROSS_CAPACITY:
				setGrossCapacity(GROSS_CAPACITY_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__NORMAL_MIN_OPERATE_LEVEL:
				setNormalMinOperateLevel(NORMAL_MIN_OPERATE_LEVEL_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__RIVER_OUTLET_WORKS:
				setRiverOutletWorks(RIVER_OUTLET_WORKS_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__SPILL_TRAVEL_DELAY:
				setSpillTravelDelay(SPILL_TRAVEL_DELAY_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__SPILLWAY_CAPACITY:
				setSpillwayCapacity(SPILLWAY_CAPACITY_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LENGTH:
				setSpillwayCrestLength(SPILLWAY_CREST_LENGTH_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LEVEL:
				setSpillwayCrestLevel(SPILLWAY_CREST_LEVEL_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__SPILL_WAY_GATE_TYPE:
				setSpillWayGateType(SPILL_WAY_GATE_TYPE_EDEFAULT);
				return;
			case ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS:
				getHydroPowerPlants().clear();
				return;
			case ProductionPackage.RESERVOIR__UPSTREAM_FROM:
				getUpstreamFrom().clear();
				return;
			case ProductionPackage.RESERVOIR__LEVEL_VS_VOLUME_CURVE:
				getLevelVsVolumeCurve().clear();
				return;
			case ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE:
				setTargetLevelSchedule((TargetLevelSchedule)null);
				return;
			case ProductionPackage.RESERVOIR__INFLOW_FORECAST:
				getInflowForecast().clear();
				return;
			case ProductionPackage.RESERVOIR__SPILLS_INTO:
				getSpillsInto().clear();
				return;
			case ProductionPackage.RESERVOIR__SPILLS_FROM:
				setSpillsFrom((Reservoir)null);
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
			case ProductionPackage.RESERVOIR__ACTIVE_STORAGE_CAPACITY:
				return ACTIVE_STORAGE_CAPACITY_EDEFAULT == null ? activeStorageCapacity != null : !ACTIVE_STORAGE_CAPACITY_EDEFAULT.equals(activeStorageCapacity);
			case ProductionPackage.RESERVOIR__ENERGY_STORAGE_RATING:
				return ENERGY_STORAGE_RATING_EDEFAULT == null ? energyStorageRating != null : !ENERGY_STORAGE_RATING_EDEFAULT.equals(energyStorageRating);
			case ProductionPackage.RESERVOIR__FULL_SUPPLY_LEVEL:
				return FULL_SUPPLY_LEVEL_EDEFAULT == null ? fullSupplyLevel != null : !FULL_SUPPLY_LEVEL_EDEFAULT.equals(fullSupplyLevel);
			case ProductionPackage.RESERVOIR__GROSS_CAPACITY:
				return GROSS_CAPACITY_EDEFAULT == null ? grossCapacity != null : !GROSS_CAPACITY_EDEFAULT.equals(grossCapacity);
			case ProductionPackage.RESERVOIR__NORMAL_MIN_OPERATE_LEVEL:
				return NORMAL_MIN_OPERATE_LEVEL_EDEFAULT == null ? normalMinOperateLevel != null : !NORMAL_MIN_OPERATE_LEVEL_EDEFAULT.equals(normalMinOperateLevel);
			case ProductionPackage.RESERVOIR__RIVER_OUTLET_WORKS:
				return RIVER_OUTLET_WORKS_EDEFAULT == null ? riverOutletWorks != null : !RIVER_OUTLET_WORKS_EDEFAULT.equals(riverOutletWorks);
			case ProductionPackage.RESERVOIR__SPILL_TRAVEL_DELAY:
				return SPILL_TRAVEL_DELAY_EDEFAULT == null ? spillTravelDelay != null : !SPILL_TRAVEL_DELAY_EDEFAULT.equals(spillTravelDelay);
			case ProductionPackage.RESERVOIR__SPILLWAY_CAPACITY:
				return SPILLWAY_CAPACITY_EDEFAULT == null ? spillwayCapacity != null : !SPILLWAY_CAPACITY_EDEFAULT.equals(spillwayCapacity);
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LENGTH:
				return SPILLWAY_CREST_LENGTH_EDEFAULT == null ? spillwayCrestLength != null : !SPILLWAY_CREST_LENGTH_EDEFAULT.equals(spillwayCrestLength);
			case ProductionPackage.RESERVOIR__SPILLWAY_CREST_LEVEL:
				return SPILLWAY_CREST_LEVEL_EDEFAULT == null ? spillwayCrestLevel != null : !SPILLWAY_CREST_LEVEL_EDEFAULT.equals(spillwayCrestLevel);
			case ProductionPackage.RESERVOIR__SPILL_WAY_GATE_TYPE:
				return spillWayGateType != SPILL_WAY_GATE_TYPE_EDEFAULT;
			case ProductionPackage.RESERVOIR__HYDRO_POWER_PLANTS:
				return hydroPowerPlants != null && !hydroPowerPlants.isEmpty();
			case ProductionPackage.RESERVOIR__UPSTREAM_FROM:
				return upstreamFrom != null && !upstreamFrom.isEmpty();
			case ProductionPackage.RESERVOIR__LEVEL_VS_VOLUME_CURVE:
				return levelVsVolumeCurve != null && !levelVsVolumeCurve.isEmpty();
			case ProductionPackage.RESERVOIR__TARGET_LEVEL_SCHEDULE:
				return targetLevelSchedule != null;
			case ProductionPackage.RESERVOIR__INFLOW_FORECAST:
				return inflowForecast != null && !inflowForecast.isEmpty();
			case ProductionPackage.RESERVOIR__SPILLS_INTO:
				return spillsInto != null && !spillsInto.isEmpty();
			case ProductionPackage.RESERVOIR__SPILLS_FROM:
				return spillsFrom != null;
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
		result.append(" (activeStorageCapacity: ");
		result.append(activeStorageCapacity);
		result.append(", energyStorageRating: ");
		result.append(energyStorageRating);
		result.append(", fullSupplyLevel: ");
		result.append(fullSupplyLevel);
		result.append(", grossCapacity: ");
		result.append(grossCapacity);
		result.append(", normalMinOperateLevel: ");
		result.append(normalMinOperateLevel);
		result.append(", riverOutletWorks: ");
		result.append(riverOutletWorks);
		result.append(", spillTravelDelay: ");
		result.append(spillTravelDelay);
		result.append(", spillwayCapacity: ");
		result.append(spillwayCapacity);
		result.append(", spillwayCrestLength: ");
		result.append(spillwayCrestLength);
		result.append(", spillwayCrestLevel: ");
		result.append(spillwayCrestLevel);
		result.append(", spillWayGateType: ");
		result.append(spillWayGateType);
		result.append(')');
		return result.toString();
	}

} //ReservoirImpl