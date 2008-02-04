/**
 * <copyright>
 * </copyright>
 *
 * $Id: ThermalGeneratingUnitImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
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

import org.opencim.cim.iec61970.gen.production.CAESPlant;
import org.opencim.cim.iec61970.gen.production.CogenerationPlant;
import org.opencim.cim.iec61970.gen.production.CombinedCyclePlant;
import org.opencim.cim.iec61970.gen.production.EmissionAccount;
import org.opencim.cim.iec61970.gen.production.EmissionCurve;
import org.opencim.cim.iec61970.gen.production.FossilFuel;
import org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule;
import org.opencim.cim.iec61970.gen.production.HeatInputCurve;
import org.opencim.cim.iec61970.gen.production.HeatRateCurve;
import org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.ShutdownCurve;
import org.opencim.cim.iec61970.gen.production.StartupModel;
import org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit;

import org.opencim.datatype.real.CostPerHeatUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thermal Generating Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getOMCost <em>OM Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getEmmissionAccounts <em>Emmission Accounts</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getEmissionCurves <em>Emission Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getFossilFuels <em>Fossil Fuels</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getFuelAllocationSchedules <em>Fuel Allocation Schedules</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getHeatInputCurve <em>Heat Input Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getHeatRateCurve <em>Heat Rate Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getIncrementalHeatRateCurve <em>Incremental Heat Rate Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getShutdownCurve <em>Shutdown Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getStartupModel <em>Startup Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getMemberOf_CAESPlant <em>Member Of CAES Plant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getMembmerOf_CogenerationPlant <em>Membmer Of Cogeneration Plant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl#getMemberOf_CombinedCyclePlant <em>Member Of Combined Cycle Plant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThermalGeneratingUnitImpl extends GeneratingUnitImpl implements ThermalGeneratingUnit {
	/**
	 * The default value of the '{@link #getOMCost() <em>OM Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOMCost()
	 * @generated
	 * @ordered
	 */
	protected static final CostPerHeatUnit OM_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOMCost() <em>OM Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOMCost()
	 * @generated
	 * @ordered
	 */
	protected CostPerHeatUnit oMCost = OM_COST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEmmissionAccounts() <em>Emmission Accounts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmmissionAccounts()
	 * @generated
	 * @ordered
	 */
	protected EList emmissionAccounts;

	/**
	 * The cached value of the '{@link #getEmissionCurves() <em>Emission Curves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionCurves()
	 * @generated
	 * @ordered
	 */
	protected EList emissionCurves;

	/**
	 * The cached value of the '{@link #getFossilFuels() <em>Fossil Fuels</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFossilFuels()
	 * @generated
	 * @ordered
	 */
	protected EList fossilFuels;

	/**
	 * The cached value of the '{@link #getFuelAllocationSchedules() <em>Fuel Allocation Schedules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelAllocationSchedules()
	 * @generated
	 * @ordered
	 */
	protected EList fuelAllocationSchedules;

	/**
	 * The cached value of the '{@link #getHeatInputCurve() <em>Heat Input Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatInputCurve()
	 * @generated
	 * @ordered
	 */
	protected HeatInputCurve heatInputCurve;

	/**
	 * The cached value of the '{@link #getHeatRateCurve() <em>Heat Rate Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatRateCurve()
	 * @generated
	 * @ordered
	 */
	protected HeatRateCurve heatRateCurve;

	/**
	 * The cached value of the '{@link #getIncrementalHeatRateCurve() <em>Incremental Heat Rate Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrementalHeatRateCurve()
	 * @generated
	 * @ordered
	 */
	protected IncrementalHeatRateCurve incrementalHeatRateCurve;

	/**
	 * The cached value of the '{@link #getShutdownCurve() <em>Shutdown Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShutdownCurve()
	 * @generated
	 * @ordered
	 */
	protected ShutdownCurve shutdownCurve;

	/**
	 * The cached value of the '{@link #getStartupModel() <em>Startup Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupModel()
	 * @generated
	 * @ordered
	 */
	protected StartupModel startupModel;

	/**
	 * The cached value of the '{@link #getMemberOf_CAESPlant() <em>Member Of CAES Plant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberOf_CAESPlant()
	 * @generated
	 * @ordered
	 */
	protected CAESPlant memberOf_CAESPlant;

	/**
	 * The cached value of the '{@link #getMembmerOf_CogenerationPlant() <em>Membmer Of Cogeneration Plant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembmerOf_CogenerationPlant()
	 * @generated
	 * @ordered
	 */
	protected CogenerationPlant membmerOf_CogenerationPlant;

	/**
	 * The cached value of the '{@link #getMemberOf_CombinedCyclePlant() <em>Member Of Combined Cycle Plant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberOf_CombinedCyclePlant()
	 * @generated
	 * @ordered
	 */
	protected CombinedCyclePlant memberOf_CombinedCyclePlant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThermalGeneratingUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.THERMAL_GENERATING_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHeatUnit getOMCost() {
		return oMCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOMCost(CostPerHeatUnit newOMCost) {
		CostPerHeatUnit oldOMCost = oMCost;
		oMCost = newOMCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__OM_COST, oldOMCost, oMCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEmmissionAccounts() {
		if (emmissionAccounts == null) {
			emmissionAccounts = new EObjectContainmentEList(EmissionAccount.class, this, ProductionPackage.THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS);
		}
		return emmissionAccounts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEmissionCurves() {
		if (emissionCurves == null) {
			emissionCurves = new EObjectContainmentEList(EmissionCurve.class, this, ProductionPackage.THERMAL_GENERATING_UNIT__EMISSION_CURVES);
		}
		return emissionCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFossilFuels() {
		if (fossilFuels == null) {
			fossilFuels = new EObjectWithInverseResolvingEList(FossilFuel.class, this, ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS, ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT);
		}
		return fossilFuels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFuelAllocationSchedules() {
		if (fuelAllocationSchedules == null) {
			fuelAllocationSchedules = new EObjectContainmentEList(FuelAllocationSchedule.class, this, ProductionPackage.THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES);
		}
		return fuelAllocationSchedules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatInputCurve getHeatInputCurve() {
		return heatInputCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeatInputCurve(HeatInputCurve newHeatInputCurve, NotificationChain msgs) {
		HeatInputCurve oldHeatInputCurve = heatInputCurve;
		heatInputCurve = newHeatInputCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE, oldHeatInputCurve, newHeatInputCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatInputCurve(HeatInputCurve newHeatInputCurve) {
		if (newHeatInputCurve != heatInputCurve) {
			NotificationChain msgs = null;
			if (heatInputCurve != null)
				msgs = ((InternalEObject)heatInputCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE, null, msgs);
			if (newHeatInputCurve != null)
				msgs = ((InternalEObject)newHeatInputCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE, null, msgs);
			msgs = basicSetHeatInputCurve(newHeatInputCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE, newHeatInputCurve, newHeatInputCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatRateCurve getHeatRateCurve() {
		return heatRateCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeatRateCurve(HeatRateCurve newHeatRateCurve, NotificationChain msgs) {
		HeatRateCurve oldHeatRateCurve = heatRateCurve;
		heatRateCurve = newHeatRateCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE, oldHeatRateCurve, newHeatRateCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatRateCurve(HeatRateCurve newHeatRateCurve) {
		if (newHeatRateCurve != heatRateCurve) {
			NotificationChain msgs = null;
			if (heatRateCurve != null)
				msgs = ((InternalEObject)heatRateCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE, null, msgs);
			if (newHeatRateCurve != null)
				msgs = ((InternalEObject)newHeatRateCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE, null, msgs);
			msgs = basicSetHeatRateCurve(newHeatRateCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE, newHeatRateCurve, newHeatRateCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementalHeatRateCurve getIncrementalHeatRateCurve() {
		return incrementalHeatRateCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncrementalHeatRateCurve(IncrementalHeatRateCurve newIncrementalHeatRateCurve, NotificationChain msgs) {
		IncrementalHeatRateCurve oldIncrementalHeatRateCurve = incrementalHeatRateCurve;
		incrementalHeatRateCurve = newIncrementalHeatRateCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE, oldIncrementalHeatRateCurve, newIncrementalHeatRateCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrementalHeatRateCurve(IncrementalHeatRateCurve newIncrementalHeatRateCurve) {
		if (newIncrementalHeatRateCurve != incrementalHeatRateCurve) {
			NotificationChain msgs = null;
			if (incrementalHeatRateCurve != null)
				msgs = ((InternalEObject)incrementalHeatRateCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE, null, msgs);
			if (newIncrementalHeatRateCurve != null)
				msgs = ((InternalEObject)newIncrementalHeatRateCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE, null, msgs);
			msgs = basicSetIncrementalHeatRateCurve(newIncrementalHeatRateCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE, newIncrementalHeatRateCurve, newIncrementalHeatRateCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShutdownCurve getShutdownCurve() {
		return shutdownCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShutdownCurve(ShutdownCurve newShutdownCurve, NotificationChain msgs) {
		ShutdownCurve oldShutdownCurve = shutdownCurve;
		shutdownCurve = newShutdownCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE, oldShutdownCurve, newShutdownCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShutdownCurve(ShutdownCurve newShutdownCurve) {
		if (newShutdownCurve != shutdownCurve) {
			NotificationChain msgs = null;
			if (shutdownCurve != null)
				msgs = ((InternalEObject)shutdownCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE, null, msgs);
			if (newShutdownCurve != null)
				msgs = ((InternalEObject)newShutdownCurve).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE, null, msgs);
			msgs = basicSetShutdownCurve(newShutdownCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE, newShutdownCurve, newShutdownCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartupModel getStartupModel() {
		return startupModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartupModel(StartupModel newStartupModel, NotificationChain msgs) {
		StartupModel oldStartupModel = startupModel;
		startupModel = newStartupModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL, oldStartupModel, newStartupModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupModel(StartupModel newStartupModel) {
		if (newStartupModel != startupModel) {
			NotificationChain msgs = null;
			if (startupModel != null)
				msgs = ((InternalEObject)startupModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL, null, msgs);
			if (newStartupModel != null)
				msgs = ((InternalEObject)newStartupModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL, null, msgs);
			msgs = basicSetStartupModel(newStartupModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL, newStartupModel, newStartupModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAESPlant getMemberOf_CAESPlant() {
		if (memberOf_CAESPlant != null && memberOf_CAESPlant.eIsProxy()) {
			InternalEObject oldMemberOf_CAESPlant = (InternalEObject)memberOf_CAESPlant;
			memberOf_CAESPlant = (CAESPlant)eResolveProxy(oldMemberOf_CAESPlant);
			if (memberOf_CAESPlant != oldMemberOf_CAESPlant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT, oldMemberOf_CAESPlant, memberOf_CAESPlant));
			}
		}
		return memberOf_CAESPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAESPlant basicGetMemberOf_CAESPlant() {
		return memberOf_CAESPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemberOf_CAESPlant(CAESPlant newMemberOf_CAESPlant, NotificationChain msgs) {
		CAESPlant oldMemberOf_CAESPlant = memberOf_CAESPlant;
		memberOf_CAESPlant = newMemberOf_CAESPlant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT, oldMemberOf_CAESPlant, newMemberOf_CAESPlant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberOf_CAESPlant(CAESPlant newMemberOf_CAESPlant) {
		if (newMemberOf_CAESPlant != memberOf_CAESPlant) {
			NotificationChain msgs = null;
			if (memberOf_CAESPlant != null)
				msgs = ((InternalEObject)memberOf_CAESPlant).eInverseRemove(this, ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT, CAESPlant.class, msgs);
			if (newMemberOf_CAESPlant != null)
				msgs = ((InternalEObject)newMemberOf_CAESPlant).eInverseAdd(this, ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT, CAESPlant.class, msgs);
			msgs = basicSetMemberOf_CAESPlant(newMemberOf_CAESPlant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT, newMemberOf_CAESPlant, newMemberOf_CAESPlant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CogenerationPlant getMembmerOf_CogenerationPlant() {
		if (membmerOf_CogenerationPlant != null && membmerOf_CogenerationPlant.eIsProxy()) {
			InternalEObject oldMembmerOf_CogenerationPlant = (InternalEObject)membmerOf_CogenerationPlant;
			membmerOf_CogenerationPlant = (CogenerationPlant)eResolveProxy(oldMembmerOf_CogenerationPlant);
			if (membmerOf_CogenerationPlant != oldMembmerOf_CogenerationPlant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT, oldMembmerOf_CogenerationPlant, membmerOf_CogenerationPlant));
			}
		}
		return membmerOf_CogenerationPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CogenerationPlant basicGetMembmerOf_CogenerationPlant() {
		return membmerOf_CogenerationPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMembmerOf_CogenerationPlant(CogenerationPlant newMembmerOf_CogenerationPlant, NotificationChain msgs) {
		CogenerationPlant oldMembmerOf_CogenerationPlant = membmerOf_CogenerationPlant;
		membmerOf_CogenerationPlant = newMembmerOf_CogenerationPlant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT, oldMembmerOf_CogenerationPlant, newMembmerOf_CogenerationPlant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMembmerOf_CogenerationPlant(CogenerationPlant newMembmerOf_CogenerationPlant) {
		if (newMembmerOf_CogenerationPlant != membmerOf_CogenerationPlant) {
			NotificationChain msgs = null;
			if (membmerOf_CogenerationPlant != null)
				msgs = ((InternalEObject)membmerOf_CogenerationPlant).eInverseRemove(this, ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, CogenerationPlant.class, msgs);
			if (newMembmerOf_CogenerationPlant != null)
				msgs = ((InternalEObject)newMembmerOf_CogenerationPlant).eInverseAdd(this, ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, CogenerationPlant.class, msgs);
			msgs = basicSetMembmerOf_CogenerationPlant(newMembmerOf_CogenerationPlant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT, newMembmerOf_CogenerationPlant, newMembmerOf_CogenerationPlant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedCyclePlant getMemberOf_CombinedCyclePlant() {
		if (memberOf_CombinedCyclePlant != null && memberOf_CombinedCyclePlant.eIsProxy()) {
			InternalEObject oldMemberOf_CombinedCyclePlant = (InternalEObject)memberOf_CombinedCyclePlant;
			memberOf_CombinedCyclePlant = (CombinedCyclePlant)eResolveProxy(oldMemberOf_CombinedCyclePlant);
			if (memberOf_CombinedCyclePlant != oldMemberOf_CombinedCyclePlant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT, oldMemberOf_CombinedCyclePlant, memberOf_CombinedCyclePlant));
			}
		}
		return memberOf_CombinedCyclePlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedCyclePlant basicGetMemberOf_CombinedCyclePlant() {
		return memberOf_CombinedCyclePlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemberOf_CombinedCyclePlant(CombinedCyclePlant newMemberOf_CombinedCyclePlant, NotificationChain msgs) {
		CombinedCyclePlant oldMemberOf_CombinedCyclePlant = memberOf_CombinedCyclePlant;
		memberOf_CombinedCyclePlant = newMemberOf_CombinedCyclePlant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT, oldMemberOf_CombinedCyclePlant, newMemberOf_CombinedCyclePlant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberOf_CombinedCyclePlant(CombinedCyclePlant newMemberOf_CombinedCyclePlant) {
		if (newMemberOf_CombinedCyclePlant != memberOf_CombinedCyclePlant) {
			NotificationChain msgs = null;
			if (memberOf_CombinedCyclePlant != null)
				msgs = ((InternalEObject)memberOf_CombinedCyclePlant).eInverseRemove(this, ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, CombinedCyclePlant.class, msgs);
			if (newMemberOf_CombinedCyclePlant != null)
				msgs = ((InternalEObject)newMemberOf_CombinedCyclePlant).eInverseAdd(this, ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, CombinedCyclePlant.class, msgs);
			msgs = basicSetMemberOf_CombinedCyclePlant(newMemberOf_CombinedCyclePlant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT, newMemberOf_CombinedCyclePlant, newMemberOf_CombinedCyclePlant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS:
				return ((InternalEList)getFossilFuels()).basicAdd(otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT:
				if (memberOf_CAESPlant != null)
					msgs = ((InternalEObject)memberOf_CAESPlant).eInverseRemove(this, ProductionPackage.CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT, CAESPlant.class, msgs);
				return basicSetMemberOf_CAESPlant((CAESPlant)otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT:
				if (membmerOf_CogenerationPlant != null)
					msgs = ((InternalEObject)membmerOf_CogenerationPlant).eInverseRemove(this, ProductionPackage.COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, CogenerationPlant.class, msgs);
				return basicSetMembmerOf_CogenerationPlant((CogenerationPlant)otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT:
				if (memberOf_CombinedCyclePlant != null)
					msgs = ((InternalEObject)memberOf_CombinedCyclePlant).eInverseRemove(this, ProductionPackage.COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS, CombinedCyclePlant.class, msgs);
				return basicSetMemberOf_CombinedCyclePlant((CombinedCyclePlant)otherEnd, msgs);
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
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS:
				return ((InternalEList)getEmmissionAccounts()).basicRemove(otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMISSION_CURVES:
				return ((InternalEList)getEmissionCurves()).basicRemove(otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS:
				return ((InternalEList)getFossilFuels()).basicRemove(otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES:
				return ((InternalEList)getFuelAllocationSchedules()).basicRemove(otherEnd, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE:
				return basicSetHeatInputCurve(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE:
				return basicSetHeatRateCurve(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE:
				return basicSetIncrementalHeatRateCurve(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE:
				return basicSetShutdownCurve(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL:
				return basicSetStartupModel(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT:
				return basicSetMemberOf_CAESPlant(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT:
				return basicSetMembmerOf_CogenerationPlant(null, msgs);
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT:
				return basicSetMemberOf_CombinedCyclePlant(null, msgs);
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
			case ProductionPackage.THERMAL_GENERATING_UNIT__OM_COST:
				return getOMCost();
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS:
				return getEmmissionAccounts();
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMISSION_CURVES:
				return getEmissionCurves();
			case ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS:
				return getFossilFuels();
			case ProductionPackage.THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES:
				return getFuelAllocationSchedules();
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE:
				return getHeatInputCurve();
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE:
				return getHeatRateCurve();
			case ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE:
				return getIncrementalHeatRateCurve();
			case ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE:
				return getShutdownCurve();
			case ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL:
				return getStartupModel();
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT:
				if (resolve) return getMemberOf_CAESPlant();
				return basicGetMemberOf_CAESPlant();
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT:
				if (resolve) return getMembmerOf_CogenerationPlant();
				return basicGetMembmerOf_CogenerationPlant();
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT:
				if (resolve) return getMemberOf_CombinedCyclePlant();
				return basicGetMemberOf_CombinedCyclePlant();
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
			case ProductionPackage.THERMAL_GENERATING_UNIT__OM_COST:
				setOMCost((CostPerHeatUnit)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS:
				getEmmissionAccounts().clear();
				getEmmissionAccounts().addAll((Collection)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMISSION_CURVES:
				getEmissionCurves().clear();
				getEmissionCurves().addAll((Collection)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS:
				getFossilFuels().clear();
				getFossilFuels().addAll((Collection)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES:
				getFuelAllocationSchedules().clear();
				getFuelAllocationSchedules().addAll((Collection)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE:
				setHeatInputCurve((HeatInputCurve)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE:
				setHeatRateCurve((HeatRateCurve)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE:
				setIncrementalHeatRateCurve((IncrementalHeatRateCurve)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE:
				setShutdownCurve((ShutdownCurve)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL:
				setStartupModel((StartupModel)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT:
				setMemberOf_CAESPlant((CAESPlant)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT:
				setMembmerOf_CogenerationPlant((CogenerationPlant)newValue);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT:
				setMemberOf_CombinedCyclePlant((CombinedCyclePlant)newValue);
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
			case ProductionPackage.THERMAL_GENERATING_UNIT__OM_COST:
				setOMCost(OM_COST_EDEFAULT);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS:
				getEmmissionAccounts().clear();
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMISSION_CURVES:
				getEmissionCurves().clear();
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS:
				getFossilFuels().clear();
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES:
				getFuelAllocationSchedules().clear();
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE:
				setHeatInputCurve((HeatInputCurve)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE:
				setHeatRateCurve((HeatRateCurve)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE:
				setIncrementalHeatRateCurve((IncrementalHeatRateCurve)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE:
				setShutdownCurve((ShutdownCurve)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL:
				setStartupModel((StartupModel)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT:
				setMemberOf_CAESPlant((CAESPlant)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT:
				setMembmerOf_CogenerationPlant((CogenerationPlant)null);
				return;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT:
				setMemberOf_CombinedCyclePlant((CombinedCyclePlant)null);
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
			case ProductionPackage.THERMAL_GENERATING_UNIT__OM_COST:
				return OM_COST_EDEFAULT == null ? oMCost != null : !OM_COST_EDEFAULT.equals(oMCost);
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS:
				return emmissionAccounts != null && !emmissionAccounts.isEmpty();
			case ProductionPackage.THERMAL_GENERATING_UNIT__EMISSION_CURVES:
				return emissionCurves != null && !emissionCurves.isEmpty();
			case ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS:
				return fossilFuels != null && !fossilFuels.isEmpty();
			case ProductionPackage.THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES:
				return fuelAllocationSchedules != null && !fuelAllocationSchedules.isEmpty();
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE:
				return heatInputCurve != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE:
				return heatRateCurve != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE:
				return incrementalHeatRateCurve != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE:
				return shutdownCurve != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__STARTUP_MODEL:
				return startupModel != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT:
				return memberOf_CAESPlant != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT:
				return membmerOf_CogenerationPlant != null;
			case ProductionPackage.THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT:
				return memberOf_CombinedCyclePlant != null;
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
		result.append(" (oMCost: ");
		result.append(oMCost);
		result.append(')');
		return result.toString();
	}

} //ThermalGeneratingUnitImpl