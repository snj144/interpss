/**
 * <copyright>
 * </copyright>
 *
 * $Id: FossilFuelImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.domain.FuelType;

import org.opencim.cim.iec61970.gen.production.FossilFuel;
import org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.CostPerHeatUnit;
import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.PerCent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fossil Fuel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFossilFuelType <em>Fossil Fuel Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelCost <em>Fuel Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelDispatchCost <em>Fuel Dispatch Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelEffFactor <em>Fuel Eff Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelHandlingCost <em>Fuel Handling Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelHeatContent <em>Fuel Heat Content</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelMixture <em>Fuel Mixture</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelSulfur <em>Fuel Sulfur</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getHighMWBreakpoint <em>High MW Breakpoint</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getLowMWBreakpoint <em>Low MW Breakpoint</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getFuelAllocationSchedule <em>Fuel Allocation Schedule</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl#getThermalGeneratingUnit <em>Thermal Generating Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FossilFuelImpl extends NamingImpl implements FossilFuel {
	/**
	 * The default value of the '{@link #getFossilFuelType() <em>Fossil Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFossilFuelType()
	 * @generated
	 * @ordered
	 */
	protected static final FuelType FOSSIL_FUEL_TYPE_EDEFAULT = FuelType.COAL_LITERAL;

	/**
	 * The cached value of the '{@link #getFossilFuelType() <em>Fossil Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFossilFuelType()
	 * @generated
	 * @ordered
	 */
	protected FuelType fossilFuelType = FOSSIL_FUEL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelCost() <em>Fuel Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelCost()
	 * @generated
	 * @ordered
	 */
	protected static final CostPerHeatUnit FUEL_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelCost() <em>Fuel Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelCost()
	 * @generated
	 * @ordered
	 */
	protected CostPerHeatUnit fuelCost = FUEL_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelDispatchCost() <em>Fuel Dispatch Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelDispatchCost()
	 * @generated
	 * @ordered
	 */
	protected static final CostPerHeatUnit FUEL_DISPATCH_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelDispatchCost() <em>Fuel Dispatch Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelDispatchCost()
	 * @generated
	 * @ordered
	 */
	protected CostPerHeatUnit fuelDispatchCost = FUEL_DISPATCH_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelEffFactor() <em>Fuel Eff Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelEffFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PU FUEL_EFF_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelEffFactor() <em>Fuel Eff Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelEffFactor()
	 * @generated
	 * @ordered
	 */
	protected PU fuelEffFactor = FUEL_EFF_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelHandlingCost() <em>Fuel Handling Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelHandlingCost()
	 * @generated
	 * @ordered
	 */
	protected static final CostPerHeatUnit FUEL_HANDLING_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelHandlingCost() <em>Fuel Handling Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelHandlingCost()
	 * @generated
	 * @ordered
	 */
	protected CostPerHeatUnit fuelHandlingCost = FUEL_HANDLING_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelHeatContent() <em>Fuel Heat Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelHeatContent()
	 * @generated
	 * @ordered
	 */
	protected static final Float FUEL_HEAT_CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelHeatContent() <em>Fuel Heat Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelHeatContent()
	 * @generated
	 * @ordered
	 */
	protected Float fuelHeatContent = FUEL_HEAT_CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelMixture() <em>Fuel Mixture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelMixture()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent FUEL_MIXTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelMixture() <em>Fuel Mixture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelMixture()
	 * @generated
	 * @ordered
	 */
	protected PerCent fuelMixture = FUEL_MIXTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelSulfur() <em>Fuel Sulfur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelSulfur()
	 * @generated
	 * @ordered
	 */
	protected static final PU FUEL_SULFUR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelSulfur() <em>Fuel Sulfur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelSulfur()
	 * @generated
	 * @ordered
	 */
	protected PU fuelSulfur = FUEL_SULFUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getHighMWBreakpoint() <em>High MW Breakpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighMWBreakpoint()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower HIGH_MW_BREAKPOINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHighMWBreakpoint() <em>High MW Breakpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighMWBreakpoint()
	 * @generated
	 * @ordered
	 */
	protected ActivePower highMWBreakpoint = HIGH_MW_BREAKPOINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowMWBreakpoint() <em>Low MW Breakpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowMWBreakpoint()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower LOW_MW_BREAKPOINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowMWBreakpoint() <em>Low MW Breakpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowMWBreakpoint()
	 * @generated
	 * @ordered
	 */
	protected ActivePower lowMWBreakpoint = LOW_MW_BREAKPOINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFuelAllocationSchedule() <em>Fuel Allocation Schedule</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 * @ordered
	 */
	protected EList fuelAllocationSchedule;

	/**
	 * The cached value of the '{@link #getThermalGeneratingUnit() <em>Thermal Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 * @ordered
	 */
	protected ThermalGeneratingUnit thermalGeneratingUnit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FossilFuelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.FOSSIL_FUEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuelType getFossilFuelType() {
		return fossilFuelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFossilFuelType(FuelType newFossilFuelType) {
		FuelType oldFossilFuelType = fossilFuelType;
		fossilFuelType = newFossilFuelType == null ? FOSSIL_FUEL_TYPE_EDEFAULT : newFossilFuelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FOSSIL_FUEL_TYPE, oldFossilFuelType, fossilFuelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHeatUnit getFuelCost() {
		return fuelCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelCost(CostPerHeatUnit newFuelCost) {
		CostPerHeatUnit oldFuelCost = fuelCost;
		fuelCost = newFuelCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_COST, oldFuelCost, fuelCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHeatUnit getFuelDispatchCost() {
		return fuelDispatchCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelDispatchCost(CostPerHeatUnit newFuelDispatchCost) {
		CostPerHeatUnit oldFuelDispatchCost = fuelDispatchCost;
		fuelDispatchCost = newFuelDispatchCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_DISPATCH_COST, oldFuelDispatchCost, fuelDispatchCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getFuelEffFactor() {
		return fuelEffFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelEffFactor(PU newFuelEffFactor) {
		PU oldFuelEffFactor = fuelEffFactor;
		fuelEffFactor = newFuelEffFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_EFF_FACTOR, oldFuelEffFactor, fuelEffFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHeatUnit getFuelHandlingCost() {
		return fuelHandlingCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelHandlingCost(CostPerHeatUnit newFuelHandlingCost) {
		CostPerHeatUnit oldFuelHandlingCost = fuelHandlingCost;
		fuelHandlingCost = newFuelHandlingCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_HANDLING_COST, oldFuelHandlingCost, fuelHandlingCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getFuelHeatContent() {
		return fuelHeatContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelHeatContent(Float newFuelHeatContent) {
		Float oldFuelHeatContent = fuelHeatContent;
		fuelHeatContent = newFuelHeatContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_HEAT_CONTENT, oldFuelHeatContent, fuelHeatContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getFuelMixture() {
		return fuelMixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelMixture(PerCent newFuelMixture) {
		PerCent oldFuelMixture = fuelMixture;
		fuelMixture = newFuelMixture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_MIXTURE, oldFuelMixture, fuelMixture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getFuelSulfur() {
		return fuelSulfur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelSulfur(PU newFuelSulfur) {
		PU oldFuelSulfur = fuelSulfur;
		fuelSulfur = newFuelSulfur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__FUEL_SULFUR, oldFuelSulfur, fuelSulfur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getHighMWBreakpoint() {
		return highMWBreakpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighMWBreakpoint(ActivePower newHighMWBreakpoint) {
		ActivePower oldHighMWBreakpoint = highMWBreakpoint;
		highMWBreakpoint = newHighMWBreakpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__HIGH_MW_BREAKPOINT, oldHighMWBreakpoint, highMWBreakpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getLowMWBreakpoint() {
		return lowMWBreakpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowMWBreakpoint(ActivePower newLowMWBreakpoint) {
		ActivePower oldLowMWBreakpoint = lowMWBreakpoint;
		lowMWBreakpoint = newLowMWBreakpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__LOW_MW_BREAKPOINT, oldLowMWBreakpoint, lowMWBreakpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFuelAllocationSchedule() {
		if (fuelAllocationSchedule == null) {
			fuelAllocationSchedule = new EObjectWithInverseResolvingEList(FuelAllocationSchedule.class, this, ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL);
		}
		return fuelAllocationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThermalGeneratingUnit getThermalGeneratingUnit() {
		if (thermalGeneratingUnit != null && thermalGeneratingUnit.eIsProxy()) {
			InternalEObject oldThermalGeneratingUnit = (InternalEObject)thermalGeneratingUnit;
			thermalGeneratingUnit = (ThermalGeneratingUnit)eResolveProxy(oldThermalGeneratingUnit);
			if (thermalGeneratingUnit != oldThermalGeneratingUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT, oldThermalGeneratingUnit, thermalGeneratingUnit));
			}
		}
		return thermalGeneratingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThermalGeneratingUnit basicGetThermalGeneratingUnit() {
		return thermalGeneratingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThermalGeneratingUnit(ThermalGeneratingUnit newThermalGeneratingUnit, NotificationChain msgs) {
		ThermalGeneratingUnit oldThermalGeneratingUnit = thermalGeneratingUnit;
		thermalGeneratingUnit = newThermalGeneratingUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT, oldThermalGeneratingUnit, newThermalGeneratingUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalGeneratingUnit(ThermalGeneratingUnit newThermalGeneratingUnit) {
		if (newThermalGeneratingUnit != thermalGeneratingUnit) {
			NotificationChain msgs = null;
			if (thermalGeneratingUnit != null)
				msgs = ((InternalEObject)thermalGeneratingUnit).eInverseRemove(this, ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS, ThermalGeneratingUnit.class, msgs);
			if (newThermalGeneratingUnit != null)
				msgs = ((InternalEObject)newThermalGeneratingUnit).eInverseAdd(this, ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS, ThermalGeneratingUnit.class, msgs);
			msgs = basicSetThermalGeneratingUnit(newThermalGeneratingUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT, newThermalGeneratingUnit, newThermalGeneratingUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE:
				return ((InternalEList)getFuelAllocationSchedule()).basicAdd(otherEnd, msgs);
			case ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT:
				if (thermalGeneratingUnit != null)
					msgs = ((InternalEObject)thermalGeneratingUnit).eInverseRemove(this, ProductionPackage.THERMAL_GENERATING_UNIT__FOSSIL_FUELS, ThermalGeneratingUnit.class, msgs);
				return basicSetThermalGeneratingUnit((ThermalGeneratingUnit)otherEnd, msgs);
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
			case ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE:
				return ((InternalEList)getFuelAllocationSchedule()).basicRemove(otherEnd, msgs);
			case ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT:
				return basicSetThermalGeneratingUnit(null, msgs);
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
			case ProductionPackage.FOSSIL_FUEL__FOSSIL_FUEL_TYPE:
				return getFossilFuelType();
			case ProductionPackage.FOSSIL_FUEL__FUEL_COST:
				return getFuelCost();
			case ProductionPackage.FOSSIL_FUEL__FUEL_DISPATCH_COST:
				return getFuelDispatchCost();
			case ProductionPackage.FOSSIL_FUEL__FUEL_EFF_FACTOR:
				return getFuelEffFactor();
			case ProductionPackage.FOSSIL_FUEL__FUEL_HANDLING_COST:
				return getFuelHandlingCost();
			case ProductionPackage.FOSSIL_FUEL__FUEL_HEAT_CONTENT:
				return getFuelHeatContent();
			case ProductionPackage.FOSSIL_FUEL__FUEL_MIXTURE:
				return getFuelMixture();
			case ProductionPackage.FOSSIL_FUEL__FUEL_SULFUR:
				return getFuelSulfur();
			case ProductionPackage.FOSSIL_FUEL__HIGH_MW_BREAKPOINT:
				return getHighMWBreakpoint();
			case ProductionPackage.FOSSIL_FUEL__LOW_MW_BREAKPOINT:
				return getLowMWBreakpoint();
			case ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE:
				return getFuelAllocationSchedule();
			case ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT:
				if (resolve) return getThermalGeneratingUnit();
				return basicGetThermalGeneratingUnit();
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
			case ProductionPackage.FOSSIL_FUEL__FOSSIL_FUEL_TYPE:
				setFossilFuelType((FuelType)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_COST:
				setFuelCost((CostPerHeatUnit)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_DISPATCH_COST:
				setFuelDispatchCost((CostPerHeatUnit)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_EFF_FACTOR:
				setFuelEffFactor((PU)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_HANDLING_COST:
				setFuelHandlingCost((CostPerHeatUnit)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_HEAT_CONTENT:
				setFuelHeatContent((Float)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_MIXTURE:
				setFuelMixture((PerCent)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_SULFUR:
				setFuelSulfur((PU)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__HIGH_MW_BREAKPOINT:
				setHighMWBreakpoint((ActivePower)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__LOW_MW_BREAKPOINT:
				setLowMWBreakpoint((ActivePower)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE:
				getFuelAllocationSchedule().clear();
				getFuelAllocationSchedule().addAll((Collection)newValue);
				return;
			case ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT:
				setThermalGeneratingUnit((ThermalGeneratingUnit)newValue);
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
			case ProductionPackage.FOSSIL_FUEL__FOSSIL_FUEL_TYPE:
				setFossilFuelType(FOSSIL_FUEL_TYPE_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_COST:
				setFuelCost(FUEL_COST_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_DISPATCH_COST:
				setFuelDispatchCost(FUEL_DISPATCH_COST_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_EFF_FACTOR:
				setFuelEffFactor(FUEL_EFF_FACTOR_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_HANDLING_COST:
				setFuelHandlingCost(FUEL_HANDLING_COST_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_HEAT_CONTENT:
				setFuelHeatContent(FUEL_HEAT_CONTENT_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_MIXTURE:
				setFuelMixture(FUEL_MIXTURE_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_SULFUR:
				setFuelSulfur(FUEL_SULFUR_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__HIGH_MW_BREAKPOINT:
				setHighMWBreakpoint(HIGH_MW_BREAKPOINT_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__LOW_MW_BREAKPOINT:
				setLowMWBreakpoint(LOW_MW_BREAKPOINT_EDEFAULT);
				return;
			case ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE:
				getFuelAllocationSchedule().clear();
				return;
			case ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT:
				setThermalGeneratingUnit((ThermalGeneratingUnit)null);
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
			case ProductionPackage.FOSSIL_FUEL__FOSSIL_FUEL_TYPE:
				return fossilFuelType != FOSSIL_FUEL_TYPE_EDEFAULT;
			case ProductionPackage.FOSSIL_FUEL__FUEL_COST:
				return FUEL_COST_EDEFAULT == null ? fuelCost != null : !FUEL_COST_EDEFAULT.equals(fuelCost);
			case ProductionPackage.FOSSIL_FUEL__FUEL_DISPATCH_COST:
				return FUEL_DISPATCH_COST_EDEFAULT == null ? fuelDispatchCost != null : !FUEL_DISPATCH_COST_EDEFAULT.equals(fuelDispatchCost);
			case ProductionPackage.FOSSIL_FUEL__FUEL_EFF_FACTOR:
				return FUEL_EFF_FACTOR_EDEFAULT == null ? fuelEffFactor != null : !FUEL_EFF_FACTOR_EDEFAULT.equals(fuelEffFactor);
			case ProductionPackage.FOSSIL_FUEL__FUEL_HANDLING_COST:
				return FUEL_HANDLING_COST_EDEFAULT == null ? fuelHandlingCost != null : !FUEL_HANDLING_COST_EDEFAULT.equals(fuelHandlingCost);
			case ProductionPackage.FOSSIL_FUEL__FUEL_HEAT_CONTENT:
				return FUEL_HEAT_CONTENT_EDEFAULT == null ? fuelHeatContent != null : !FUEL_HEAT_CONTENT_EDEFAULT.equals(fuelHeatContent);
			case ProductionPackage.FOSSIL_FUEL__FUEL_MIXTURE:
				return FUEL_MIXTURE_EDEFAULT == null ? fuelMixture != null : !FUEL_MIXTURE_EDEFAULT.equals(fuelMixture);
			case ProductionPackage.FOSSIL_FUEL__FUEL_SULFUR:
				return FUEL_SULFUR_EDEFAULT == null ? fuelSulfur != null : !FUEL_SULFUR_EDEFAULT.equals(fuelSulfur);
			case ProductionPackage.FOSSIL_FUEL__HIGH_MW_BREAKPOINT:
				return HIGH_MW_BREAKPOINT_EDEFAULT == null ? highMWBreakpoint != null : !HIGH_MW_BREAKPOINT_EDEFAULT.equals(highMWBreakpoint);
			case ProductionPackage.FOSSIL_FUEL__LOW_MW_BREAKPOINT:
				return LOW_MW_BREAKPOINT_EDEFAULT == null ? lowMWBreakpoint != null : !LOW_MW_BREAKPOINT_EDEFAULT.equals(lowMWBreakpoint);
			case ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE:
				return fuelAllocationSchedule != null && !fuelAllocationSchedule.isEmpty();
			case ProductionPackage.FOSSIL_FUEL__THERMAL_GENERATING_UNIT:
				return thermalGeneratingUnit != null;
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
		result.append(" (fossilFuelType: ");
		result.append(fossilFuelType);
		result.append(", fuelCost: ");
		result.append(fuelCost);
		result.append(", fuelDispatchCost: ");
		result.append(fuelDispatchCost);
		result.append(", fuelEffFactor: ");
		result.append(fuelEffFactor);
		result.append(", fuelHandlingCost: ");
		result.append(fuelHandlingCost);
		result.append(", fuelHeatContent: ");
		result.append(fuelHeatContent);
		result.append(", fuelMixture: ");
		result.append(fuelMixture);
		result.append(", fuelSulfur: ");
		result.append(fuelSulfur);
		result.append(", highMWBreakpoint: ");
		result.append(highMWBreakpoint);
		result.append(", lowMWBreakpoint: ");
		result.append(lowMWBreakpoint);
		result.append(')');
		return result.toString();
	}

} //FossilFuelImpl