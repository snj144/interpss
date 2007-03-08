/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartupModelImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve;
import org.opencim.cim.iec61970.gen.production.StartMainFuelCurve;
import org.opencim.cim.iec61970.gen.production.StartRampCurve;
import org.opencim.cim.iec61970.gen.production.StartupModel;

import org.opencim.datatype.integer.Priority;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.CostPerEnergyUnit;
import org.opencim.datatype.real.CostPerHour;
import org.opencim.datatype.real.HeatPerHour;
import org.opencim.datatype.real.Hours;
import org.opencim.datatype.real.Money;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Startup Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getFixedMaintCost <em>Fixed Maint Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getHotStandbyHeat <em>Hot Standby Heat</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getIncrementalMaintCost <em>Incremental Maint Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getMinimumDownTime <em>Minimum Down Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getMinimumRunTime <em>Minimum Run Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getRiskFactorCost <em>Risk Factor Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStartupCost <em>Startup Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStartupDate <em>Startup Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStartupPriority <em>Startup Priority</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStbyAuxPowerMW <em>Stby Aux Power MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStartIgnFuelCurve <em>Start Ign Fuel Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStartMainFuelCurve <em>Start Main Fuel Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl#getStartRampCurve <em>Start Ramp Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartupModelImpl extends NamingImpl implements StartupModel {
	/**
	 * The default value of the '{@link #getFixedMaintCost() <em>Fixed Maint Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedMaintCost()
	 * @generated
	 * @ordered
	 */
	protected static final CostPerHour FIXED_MAINT_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedMaintCost() <em>Fixed Maint Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedMaintCost()
	 * @generated
	 * @ordered
	 */
	protected CostPerHour fixedMaintCost = FIXED_MAINT_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getHotStandbyHeat() <em>Hot Standby Heat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotStandbyHeat()
	 * @generated
	 * @ordered
	 */
	protected static final HeatPerHour HOT_STANDBY_HEAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHotStandbyHeat() <em>Hot Standby Heat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotStandbyHeat()
	 * @generated
	 * @ordered
	 */
	protected HeatPerHour hotStandbyHeat = HOT_STANDBY_HEAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncrementalMaintCost() <em>Incremental Maint Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrementalMaintCost()
	 * @generated
	 * @ordered
	 */
	protected static final CostPerEnergyUnit INCREMENTAL_MAINT_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncrementalMaintCost() <em>Incremental Maint Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrementalMaintCost()
	 * @generated
	 * @ordered
	 */
	protected CostPerEnergyUnit incrementalMaintCost = INCREMENTAL_MAINT_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumDownTime() <em>Minimum Down Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumDownTime()
	 * @generated
	 * @ordered
	 */
	protected static final Hours MINIMUM_DOWN_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumDownTime() <em>Minimum Down Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumDownTime()
	 * @generated
	 * @ordered
	 */
	protected Hours minimumDownTime = MINIMUM_DOWN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumRunTime() <em>Minimum Run Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumRunTime()
	 * @generated
	 * @ordered
	 */
	protected static final Hours MINIMUM_RUN_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumRunTime() <em>Minimum Run Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumRunTime()
	 * @generated
	 * @ordered
	 */
	protected Hours minimumRunTime = MINIMUM_RUN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRiskFactorCost() <em>Risk Factor Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiskFactorCost()
	 * @generated
	 * @ordered
	 */
	protected static final Money RISK_FACTOR_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRiskFactorCost() <em>Risk Factor Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiskFactorCost()
	 * @generated
	 * @ordered
	 */
	protected Money riskFactorCost = RISK_FACTOR_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartupCost() <em>Startup Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupCost()
	 * @generated
	 * @ordered
	 */
	protected static final Money STARTUP_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartupCost() <em>Startup Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupCost()
	 * @generated
	 * @ordered
	 */
	protected Money startupCost = STARTUP_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartupDate() <em>Startup Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date STARTUP_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartupDate() <em>Startup Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupDate()
	 * @generated
	 * @ordered
	 */
	protected Date startupDate = STARTUP_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartupPriority() <em>Startup Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Priority STARTUP_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartupPriority() <em>Startup Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupPriority()
	 * @generated
	 * @ordered
	 */
	protected Priority startupPriority = STARTUP_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getStbyAuxPowerMW() <em>Stby Aux Power MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStbyAuxPowerMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower STBY_AUX_POWER_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStbyAuxPowerMW() <em>Stby Aux Power MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStbyAuxPowerMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower stbyAuxPowerMW = STBY_AUX_POWER_MW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStartIgnFuelCurve() <em>Start Ign Fuel Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIgnFuelCurve()
	 * @generated
	 * @ordered
	 */
	protected StartIgnFuelCurve startIgnFuelCurve = null;

	/**
	 * The cached value of the '{@link #getStartMainFuelCurve() <em>Start Main Fuel Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartMainFuelCurve()
	 * @generated
	 * @ordered
	 */
	protected StartMainFuelCurve startMainFuelCurve = null;

	/**
	 * The cached value of the '{@link #getStartRampCurve() <em>Start Ramp Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartRampCurve()
	 * @generated
	 * @ordered
	 */
	protected StartRampCurve startRampCurve = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartupModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.STARTUP_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHour getFixedMaintCost() {
		return fixedMaintCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedMaintCost(CostPerHour newFixedMaintCost) {
		CostPerHour oldFixedMaintCost = fixedMaintCost;
		fixedMaintCost = newFixedMaintCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__FIXED_MAINT_COST, oldFixedMaintCost, fixedMaintCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatPerHour getHotStandbyHeat() {
		return hotStandbyHeat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHotStandbyHeat(HeatPerHour newHotStandbyHeat) {
		HeatPerHour oldHotStandbyHeat = hotStandbyHeat;
		hotStandbyHeat = newHotStandbyHeat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__HOT_STANDBY_HEAT, oldHotStandbyHeat, hotStandbyHeat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerEnergyUnit getIncrementalMaintCost() {
		return incrementalMaintCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrementalMaintCost(CostPerEnergyUnit newIncrementalMaintCost) {
		CostPerEnergyUnit oldIncrementalMaintCost = incrementalMaintCost;
		incrementalMaintCost = newIncrementalMaintCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__INCREMENTAL_MAINT_COST, oldIncrementalMaintCost, incrementalMaintCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hours getMinimumDownTime() {
		return minimumDownTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumDownTime(Hours newMinimumDownTime) {
		Hours oldMinimumDownTime = minimumDownTime;
		minimumDownTime = newMinimumDownTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__MINIMUM_DOWN_TIME, oldMinimumDownTime, minimumDownTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hours getMinimumRunTime() {
		return minimumRunTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumRunTime(Hours newMinimumRunTime) {
		Hours oldMinimumRunTime = minimumRunTime;
		minimumRunTime = newMinimumRunTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__MINIMUM_RUN_TIME, oldMinimumRunTime, minimumRunTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Money getRiskFactorCost() {
		return riskFactorCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiskFactorCost(Money newRiskFactorCost) {
		Money oldRiskFactorCost = riskFactorCost;
		riskFactorCost = newRiskFactorCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__RISK_FACTOR_COST, oldRiskFactorCost, riskFactorCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Money getStartupCost() {
		return startupCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupCost(Money newStartupCost) {
		Money oldStartupCost = startupCost;
		startupCost = newStartupCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__STARTUP_COST, oldStartupCost, startupCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartupDate() {
		return startupDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupDate(Date newStartupDate) {
		Date oldStartupDate = startupDate;
		startupDate = newStartupDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__STARTUP_DATE, oldStartupDate, startupDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority getStartupPriority() {
		return startupPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupPriority(Priority newStartupPriority) {
		Priority oldStartupPriority = startupPriority;
		startupPriority = newStartupPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__STARTUP_PRIORITY, oldStartupPriority, startupPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getStbyAuxPowerMW() {
		return stbyAuxPowerMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStbyAuxPowerMW(ActivePower newStbyAuxPowerMW) {
		ActivePower oldStbyAuxPowerMW = stbyAuxPowerMW;
		stbyAuxPowerMW = newStbyAuxPowerMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__STBY_AUX_POWER_MW, oldStbyAuxPowerMW, stbyAuxPowerMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartIgnFuelCurve getStartIgnFuelCurve() {
		return startIgnFuelCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartIgnFuelCurve(StartIgnFuelCurve newStartIgnFuelCurve, NotificationChain msgs) {
		StartIgnFuelCurve oldStartIgnFuelCurve = startIgnFuelCurve;
		startIgnFuelCurve = newStartIgnFuelCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE, oldStartIgnFuelCurve, newStartIgnFuelCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIgnFuelCurve(StartIgnFuelCurve newStartIgnFuelCurve) {
		if (newStartIgnFuelCurve != startIgnFuelCurve) {
			NotificationChain msgs = null;
			if (startIgnFuelCurve != null)
				msgs = ((InternalEObject)startIgnFuelCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE, null, msgs);
			if (newStartIgnFuelCurve != null)
				msgs = ((InternalEObject)newStartIgnFuelCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE, null, msgs);
			msgs = basicSetStartIgnFuelCurve(newStartIgnFuelCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE, newStartIgnFuelCurve, newStartIgnFuelCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartMainFuelCurve getStartMainFuelCurve() {
		return startMainFuelCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartMainFuelCurve(StartMainFuelCurve newStartMainFuelCurve, NotificationChain msgs) {
		StartMainFuelCurve oldStartMainFuelCurve = startMainFuelCurve;
		startMainFuelCurve = newStartMainFuelCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE, oldStartMainFuelCurve, newStartMainFuelCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartMainFuelCurve(StartMainFuelCurve newStartMainFuelCurve) {
		if (newStartMainFuelCurve != startMainFuelCurve) {
			NotificationChain msgs = null;
			if (startMainFuelCurve != null)
				msgs = ((InternalEObject)startMainFuelCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE, null, msgs);
			if (newStartMainFuelCurve != null)
				msgs = ((InternalEObject)newStartMainFuelCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE, null, msgs);
			msgs = basicSetStartMainFuelCurve(newStartMainFuelCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE, newStartMainFuelCurve, newStartMainFuelCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartRampCurve getStartRampCurve() {
		return startRampCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartRampCurve(StartRampCurve newStartRampCurve, NotificationChain msgs) {
		StartRampCurve oldStartRampCurve = startRampCurve;
		startRampCurve = newStartRampCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE, oldStartRampCurve, newStartRampCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartRampCurve(StartRampCurve newStartRampCurve) {
		if (newStartRampCurve != startRampCurve) {
			NotificationChain msgs = null;
			if (startRampCurve != null)
				msgs = ((InternalEObject)startRampCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE, null, msgs);
			if (newStartRampCurve != null)
				msgs = ((InternalEObject)newStartRampCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE, null, msgs);
			msgs = basicSetStartRampCurve(newStartRampCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE, newStartRampCurve, newStartRampCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE:
				return basicSetStartIgnFuelCurve(null, msgs);
			case ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE:
				return basicSetStartMainFuelCurve(null, msgs);
			case ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE:
				return basicSetStartRampCurve(null, msgs);
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
			case ProductionPackage.STARTUP_MODEL__FIXED_MAINT_COST:
				return getFixedMaintCost();
			case ProductionPackage.STARTUP_MODEL__HOT_STANDBY_HEAT:
				return getHotStandbyHeat();
			case ProductionPackage.STARTUP_MODEL__INCREMENTAL_MAINT_COST:
				return getIncrementalMaintCost();
			case ProductionPackage.STARTUP_MODEL__MINIMUM_DOWN_TIME:
				return getMinimumDownTime();
			case ProductionPackage.STARTUP_MODEL__MINIMUM_RUN_TIME:
				return getMinimumRunTime();
			case ProductionPackage.STARTUP_MODEL__RISK_FACTOR_COST:
				return getRiskFactorCost();
			case ProductionPackage.STARTUP_MODEL__STARTUP_COST:
				return getStartupCost();
			case ProductionPackage.STARTUP_MODEL__STARTUP_DATE:
				return getStartupDate();
			case ProductionPackage.STARTUP_MODEL__STARTUP_PRIORITY:
				return getStartupPriority();
			case ProductionPackage.STARTUP_MODEL__STBY_AUX_POWER_MW:
				return getStbyAuxPowerMW();
			case ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE:
				return getStartIgnFuelCurve();
			case ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE:
				return getStartMainFuelCurve();
			case ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE:
				return getStartRampCurve();
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
			case ProductionPackage.STARTUP_MODEL__FIXED_MAINT_COST:
				setFixedMaintCost((CostPerHour)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__HOT_STANDBY_HEAT:
				setHotStandbyHeat((HeatPerHour)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__INCREMENTAL_MAINT_COST:
				setIncrementalMaintCost((CostPerEnergyUnit)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__MINIMUM_DOWN_TIME:
				setMinimumDownTime((Hours)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__MINIMUM_RUN_TIME:
				setMinimumRunTime((Hours)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__RISK_FACTOR_COST:
				setRiskFactorCost((Money)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__STARTUP_COST:
				setStartupCost((Money)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__STARTUP_DATE:
				setStartupDate((Date)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__STARTUP_PRIORITY:
				setStartupPriority((Priority)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__STBY_AUX_POWER_MW:
				setStbyAuxPowerMW((ActivePower)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE:
				setStartIgnFuelCurve((StartIgnFuelCurve)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE:
				setStartMainFuelCurve((StartMainFuelCurve)newValue);
				return;
			case ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE:
				setStartRampCurve((StartRampCurve)newValue);
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
			case ProductionPackage.STARTUP_MODEL__FIXED_MAINT_COST:
				setFixedMaintCost(FIXED_MAINT_COST_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__HOT_STANDBY_HEAT:
				setHotStandbyHeat(HOT_STANDBY_HEAT_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__INCREMENTAL_MAINT_COST:
				setIncrementalMaintCost(INCREMENTAL_MAINT_COST_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__MINIMUM_DOWN_TIME:
				setMinimumDownTime(MINIMUM_DOWN_TIME_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__MINIMUM_RUN_TIME:
				setMinimumRunTime(MINIMUM_RUN_TIME_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__RISK_FACTOR_COST:
				setRiskFactorCost(RISK_FACTOR_COST_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__STARTUP_COST:
				setStartupCost(STARTUP_COST_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__STARTUP_DATE:
				setStartupDate(STARTUP_DATE_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__STARTUP_PRIORITY:
				setStartupPriority(STARTUP_PRIORITY_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__STBY_AUX_POWER_MW:
				setStbyAuxPowerMW(STBY_AUX_POWER_MW_EDEFAULT);
				return;
			case ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE:
				setStartIgnFuelCurve((StartIgnFuelCurve)null);
				return;
			case ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE:
				setStartMainFuelCurve((StartMainFuelCurve)null);
				return;
			case ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE:
				setStartRampCurve((StartRampCurve)null);
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
			case ProductionPackage.STARTUP_MODEL__FIXED_MAINT_COST:
				return FIXED_MAINT_COST_EDEFAULT == null ? fixedMaintCost != null : !FIXED_MAINT_COST_EDEFAULT.equals(fixedMaintCost);
			case ProductionPackage.STARTUP_MODEL__HOT_STANDBY_HEAT:
				return HOT_STANDBY_HEAT_EDEFAULT == null ? hotStandbyHeat != null : !HOT_STANDBY_HEAT_EDEFAULT.equals(hotStandbyHeat);
			case ProductionPackage.STARTUP_MODEL__INCREMENTAL_MAINT_COST:
				return INCREMENTAL_MAINT_COST_EDEFAULT == null ? incrementalMaintCost != null : !INCREMENTAL_MAINT_COST_EDEFAULT.equals(incrementalMaintCost);
			case ProductionPackage.STARTUP_MODEL__MINIMUM_DOWN_TIME:
				return MINIMUM_DOWN_TIME_EDEFAULT == null ? minimumDownTime != null : !MINIMUM_DOWN_TIME_EDEFAULT.equals(minimumDownTime);
			case ProductionPackage.STARTUP_MODEL__MINIMUM_RUN_TIME:
				return MINIMUM_RUN_TIME_EDEFAULT == null ? minimumRunTime != null : !MINIMUM_RUN_TIME_EDEFAULT.equals(minimumRunTime);
			case ProductionPackage.STARTUP_MODEL__RISK_FACTOR_COST:
				return RISK_FACTOR_COST_EDEFAULT == null ? riskFactorCost != null : !RISK_FACTOR_COST_EDEFAULT.equals(riskFactorCost);
			case ProductionPackage.STARTUP_MODEL__STARTUP_COST:
				return STARTUP_COST_EDEFAULT == null ? startupCost != null : !STARTUP_COST_EDEFAULT.equals(startupCost);
			case ProductionPackage.STARTUP_MODEL__STARTUP_DATE:
				return STARTUP_DATE_EDEFAULT == null ? startupDate != null : !STARTUP_DATE_EDEFAULT.equals(startupDate);
			case ProductionPackage.STARTUP_MODEL__STARTUP_PRIORITY:
				return STARTUP_PRIORITY_EDEFAULT == null ? startupPriority != null : !STARTUP_PRIORITY_EDEFAULT.equals(startupPriority);
			case ProductionPackage.STARTUP_MODEL__STBY_AUX_POWER_MW:
				return STBY_AUX_POWER_MW_EDEFAULT == null ? stbyAuxPowerMW != null : !STBY_AUX_POWER_MW_EDEFAULT.equals(stbyAuxPowerMW);
			case ProductionPackage.STARTUP_MODEL__START_IGN_FUEL_CURVE:
				return startIgnFuelCurve != null;
			case ProductionPackage.STARTUP_MODEL__START_MAIN_FUEL_CURVE:
				return startMainFuelCurve != null;
			case ProductionPackage.STARTUP_MODEL__START_RAMP_CURVE:
				return startRampCurve != null;
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
		result.append(" (fixedMaintCost: ");
		result.append(fixedMaintCost);
		result.append(", hotStandbyHeat: ");
		result.append(hotStandbyHeat);
		result.append(", incrementalMaintCost: ");
		result.append(incrementalMaintCost);
		result.append(", minimumDownTime: ");
		result.append(minimumDownTime);
		result.append(", minimumRunTime: ");
		result.append(minimumRunTime);
		result.append(", riskFactorCost: ");
		result.append(riskFactorCost);
		result.append(", startupCost: ");
		result.append(startupCost);
		result.append(", startupDate: ");
		result.append(startupDate);
		result.append(", startupPriority: ");
		result.append(startupPriority);
		result.append(", stbyAuxPowerMW: ");
		result.append(stbyAuxPowerMW);
		result.append(')');
		return result.toString();
	}

} //StartupModelImpl