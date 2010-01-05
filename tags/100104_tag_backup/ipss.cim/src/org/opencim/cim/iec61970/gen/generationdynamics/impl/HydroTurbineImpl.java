/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroTurbineImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.domain.TurbineType;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.RateOfChange;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hydro Turbine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getGateRateLimit <em>Gate Rate Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getGateUpperLimit <em>Gate Upper Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getMaxEffMWatMinHead <em>Max Eff MWat Min Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getMaxEffMWatMaxHead <em>Max Eff MWat Max Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getSpeedRating <em>Speed Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getSpeedRegulation <em>Speed Regulation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getTransientDroopTime <em>Transient Droop Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getTransientRegulation <em>Transient Regulation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getTurbineRating <em>Turbine Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getTurbineType <em>Turbine Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.HydroTurbineImpl#getWaterStartingTime <em>Water Starting Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HydroTurbineImpl extends PrimeMoverImpl implements HydroTurbine {
	/**
	 * The default value of the '{@link #getGateRateLimit() <em>Gate Rate Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateRateLimit()
	 * @generated
	 * @ordered
	 */
	protected static final RateOfChange GATE_RATE_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGateRateLimit() <em>Gate Rate Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateRateLimit()
	 * @generated
	 * @ordered
	 */
	protected RateOfChange gateRateLimit = GATE_RATE_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getGateUpperLimit() <em>Gate Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateUpperLimit()
	 * @generated
	 * @ordered
	 */
	protected static final PU GATE_UPPER_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGateUpperLimit() <em>Gate Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateUpperLimit()
	 * @generated
	 * @ordered
	 */
	protected PU gateUpperLimit = GATE_UPPER_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxEffMWatMinHead() <em>Max Eff MWat Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEffMWatMinHead()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MAX_EFF_MWAT_MIN_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxEffMWatMinHead() <em>Max Eff MWat Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEffMWatMinHead()
	 * @generated
	 * @ordered
	 */
	protected ActivePower maxEffMWatMinHead = MAX_EFF_MWAT_MIN_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxEffMWatMaxHead() <em>Max Eff MWat Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEffMWatMaxHead()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MAX_EFF_MWAT_MAX_HEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxEffMWatMaxHead() <em>Max Eff MWat Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEffMWatMaxHead()
	 * @generated
	 * @ordered
	 */
	protected ActivePower maxEffMWatMaxHead = MAX_EFF_MWAT_MAX_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeedRating() <em>Speed Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedRating()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SPEED_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpeedRating() <em>Speed Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedRating()
	 * @generated
	 * @ordered
	 */
	protected Integer speedRating = SPEED_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeedRegulation() <em>Speed Regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedRegulation()
	 * @generated
	 * @ordered
	 */
	protected static final PU SPEED_REGULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpeedRegulation() <em>Speed Regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedRegulation()
	 * @generated
	 * @ordered
	 */
	protected PU speedRegulation = SPEED_REGULATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransientDroopTime() <em>Transient Droop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientDroopTime()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds TRANSIENT_DROOP_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransientDroopTime() <em>Transient Droop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientDroopTime()
	 * @generated
	 * @ordered
	 */
	protected Seconds transientDroopTime = TRANSIENT_DROOP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransientRegulation() <em>Transient Regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientRegulation()
	 * @generated
	 * @ordered
	 */
	protected static final PU TRANSIENT_REGULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransientRegulation() <em>Transient Regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientRegulation()
	 * @generated
	 * @ordered
	 */
	protected PU transientRegulation = TRANSIENT_REGULATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTurbineRating() <em>Turbine Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTurbineRating()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower TURBINE_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTurbineRating() <em>Turbine Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTurbineRating()
	 * @generated
	 * @ordered
	 */
	protected ActivePower turbineRating = TURBINE_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTurbineType() <em>Turbine Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTurbineType()
	 * @generated
	 * @ordered
	 */
	protected static final TurbineType TURBINE_TYPE_EDEFAULT = TurbineType.FRANCIS_LITERAL;

	/**
	 * The cached value of the '{@link #getTurbineType() <em>Turbine Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTurbineType()
	 * @generated
	 * @ordered
	 */
	protected TurbineType turbineType = TURBINE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWaterStartingTime() <em>Water Starting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaterStartingTime()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds WATER_STARTING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWaterStartingTime() <em>Water Starting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaterStartingTime()
	 * @generated
	 * @ordered
	 */
	protected Seconds waterStartingTime = WATER_STARTING_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HydroTurbineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.HYDRO_TURBINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RateOfChange getGateRateLimit() {
		return gateRateLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGateRateLimit(RateOfChange newGateRateLimit) {
		RateOfChange oldGateRateLimit = gateRateLimit;
		gateRateLimit = newGateRateLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__GATE_RATE_LIMIT, oldGateRateLimit, gateRateLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getGateUpperLimit() {
		return gateUpperLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGateUpperLimit(PU newGateUpperLimit) {
		PU oldGateUpperLimit = gateUpperLimit;
		gateUpperLimit = newGateUpperLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__GATE_UPPER_LIMIT, oldGateUpperLimit, gateUpperLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMaxEffMWatMinHead() {
		return maxEffMWatMinHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxEffMWatMinHead(ActivePower newMaxEffMWatMinHead) {
		ActivePower oldMaxEffMWatMinHead = maxEffMWatMinHead;
		maxEffMWatMinHead = newMaxEffMWatMinHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MIN_HEAD, oldMaxEffMWatMinHead, maxEffMWatMinHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMaxEffMWatMaxHead() {
		return maxEffMWatMaxHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxEffMWatMaxHead(ActivePower newMaxEffMWatMaxHead) {
		ActivePower oldMaxEffMWatMaxHead = maxEffMWatMaxHead;
		maxEffMWatMaxHead = newMaxEffMWatMaxHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MAX_HEAD, oldMaxEffMWatMaxHead, maxEffMWatMaxHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSpeedRating() {
		return speedRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeedRating(Integer newSpeedRating) {
		Integer oldSpeedRating = speedRating;
		speedRating = newSpeedRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_RATING, oldSpeedRating, speedRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getSpeedRegulation() {
		return speedRegulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeedRegulation(PU newSpeedRegulation) {
		PU oldSpeedRegulation = speedRegulation;
		speedRegulation = newSpeedRegulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_REGULATION, oldSpeedRegulation, speedRegulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getTransientDroopTime() {
		return transientDroopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransientDroopTime(Seconds newTransientDroopTime) {
		Seconds oldTransientDroopTime = transientDroopTime;
		transientDroopTime = newTransientDroopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_DROOP_TIME, oldTransientDroopTime, transientDroopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getTransientRegulation() {
		return transientRegulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransientRegulation(PU newTransientRegulation) {
		PU oldTransientRegulation = transientRegulation;
		transientRegulation = newTransientRegulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_REGULATION, oldTransientRegulation, transientRegulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getTurbineRating() {
		return turbineRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTurbineRating(ActivePower newTurbineRating) {
		ActivePower oldTurbineRating = turbineRating;
		turbineRating = newTurbineRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_RATING, oldTurbineRating, turbineRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TurbineType getTurbineType() {
		return turbineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTurbineType(TurbineType newTurbineType) {
		TurbineType oldTurbineType = turbineType;
		turbineType = newTurbineType == null ? TURBINE_TYPE_EDEFAULT : newTurbineType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_TYPE, oldTurbineType, turbineType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getWaterStartingTime() {
		return waterStartingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaterStartingTime(Seconds newWaterStartingTime) {
		Seconds oldWaterStartingTime = waterStartingTime;
		waterStartingTime = newWaterStartingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.HYDRO_TURBINE__WATER_STARTING_TIME, oldWaterStartingTime, waterStartingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_RATE_LIMIT:
				return getGateRateLimit();
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_UPPER_LIMIT:
				return getGateUpperLimit();
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MIN_HEAD:
				return getMaxEffMWatMinHead();
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MAX_HEAD:
				return getMaxEffMWatMaxHead();
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_RATING:
				return getSpeedRating();
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_REGULATION:
				return getSpeedRegulation();
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_DROOP_TIME:
				return getTransientDroopTime();
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_REGULATION:
				return getTransientRegulation();
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_RATING:
				return getTurbineRating();
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_TYPE:
				return getTurbineType();
			case GenerationdynamicsPackage.HYDRO_TURBINE__WATER_STARTING_TIME:
				return getWaterStartingTime();
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
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_RATE_LIMIT:
				setGateRateLimit((RateOfChange)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_UPPER_LIMIT:
				setGateUpperLimit((PU)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MIN_HEAD:
				setMaxEffMWatMinHead((ActivePower)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MAX_HEAD:
				setMaxEffMWatMaxHead((ActivePower)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_RATING:
				setSpeedRating((Integer)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_REGULATION:
				setSpeedRegulation((PU)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_DROOP_TIME:
				setTransientDroopTime((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_REGULATION:
				setTransientRegulation((PU)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_RATING:
				setTurbineRating((ActivePower)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_TYPE:
				setTurbineType((TurbineType)newValue);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__WATER_STARTING_TIME:
				setWaterStartingTime((Seconds)newValue);
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
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_RATE_LIMIT:
				setGateRateLimit(GATE_RATE_LIMIT_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_UPPER_LIMIT:
				setGateUpperLimit(GATE_UPPER_LIMIT_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MIN_HEAD:
				setMaxEffMWatMinHead(MAX_EFF_MWAT_MIN_HEAD_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MAX_HEAD:
				setMaxEffMWatMaxHead(MAX_EFF_MWAT_MAX_HEAD_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_RATING:
				setSpeedRating(SPEED_RATING_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_REGULATION:
				setSpeedRegulation(SPEED_REGULATION_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_DROOP_TIME:
				setTransientDroopTime(TRANSIENT_DROOP_TIME_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_REGULATION:
				setTransientRegulation(TRANSIENT_REGULATION_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_RATING:
				setTurbineRating(TURBINE_RATING_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_TYPE:
				setTurbineType(TURBINE_TYPE_EDEFAULT);
				return;
			case GenerationdynamicsPackage.HYDRO_TURBINE__WATER_STARTING_TIME:
				setWaterStartingTime(WATER_STARTING_TIME_EDEFAULT);
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
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_RATE_LIMIT:
				return GATE_RATE_LIMIT_EDEFAULT == null ? gateRateLimit != null : !GATE_RATE_LIMIT_EDEFAULT.equals(gateRateLimit);
			case GenerationdynamicsPackage.HYDRO_TURBINE__GATE_UPPER_LIMIT:
				return GATE_UPPER_LIMIT_EDEFAULT == null ? gateUpperLimit != null : !GATE_UPPER_LIMIT_EDEFAULT.equals(gateUpperLimit);
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MIN_HEAD:
				return MAX_EFF_MWAT_MIN_HEAD_EDEFAULT == null ? maxEffMWatMinHead != null : !MAX_EFF_MWAT_MIN_HEAD_EDEFAULT.equals(maxEffMWatMinHead);
			case GenerationdynamicsPackage.HYDRO_TURBINE__MAX_EFF_MWAT_MAX_HEAD:
				return MAX_EFF_MWAT_MAX_HEAD_EDEFAULT == null ? maxEffMWatMaxHead != null : !MAX_EFF_MWAT_MAX_HEAD_EDEFAULT.equals(maxEffMWatMaxHead);
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_RATING:
				return SPEED_RATING_EDEFAULT == null ? speedRating != null : !SPEED_RATING_EDEFAULT.equals(speedRating);
			case GenerationdynamicsPackage.HYDRO_TURBINE__SPEED_REGULATION:
				return SPEED_REGULATION_EDEFAULT == null ? speedRegulation != null : !SPEED_REGULATION_EDEFAULT.equals(speedRegulation);
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_DROOP_TIME:
				return TRANSIENT_DROOP_TIME_EDEFAULT == null ? transientDroopTime != null : !TRANSIENT_DROOP_TIME_EDEFAULT.equals(transientDroopTime);
			case GenerationdynamicsPackage.HYDRO_TURBINE__TRANSIENT_REGULATION:
				return TRANSIENT_REGULATION_EDEFAULT == null ? transientRegulation != null : !TRANSIENT_REGULATION_EDEFAULT.equals(transientRegulation);
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_RATING:
				return TURBINE_RATING_EDEFAULT == null ? turbineRating != null : !TURBINE_RATING_EDEFAULT.equals(turbineRating);
			case GenerationdynamicsPackage.HYDRO_TURBINE__TURBINE_TYPE:
				return turbineType != TURBINE_TYPE_EDEFAULT;
			case GenerationdynamicsPackage.HYDRO_TURBINE__WATER_STARTING_TIME:
				return WATER_STARTING_TIME_EDEFAULT == null ? waterStartingTime != null : !WATER_STARTING_TIME_EDEFAULT.equals(waterStartingTime);
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
		result.append(" (gateRateLimit: ");
		result.append(gateRateLimit);
		result.append(", gateUpperLimit: ");
		result.append(gateUpperLimit);
		result.append(", maxEffMWatMinHead: ");
		result.append(maxEffMWatMinHead);
		result.append(", maxEffMWatMaxHead: ");
		result.append(maxEffMWatMaxHead);
		result.append(", speedRating: ");
		result.append(speedRating);
		result.append(", speedRegulation: ");
		result.append(speedRegulation);
		result.append(", transientDroopTime: ");
		result.append(transientDroopTime);
		result.append(", transientRegulation: ");
		result.append(transientRegulation);
		result.append(", turbineRating: ");
		result.append(turbineRating);
		result.append(", turbineType: ");
		result.append(turbineType);
		result.append(", waterStartingTime: ");
		result.append(waterStartingTime);
		result.append(')');
		return result.toString();
	}

} //HydroTurbineImpl