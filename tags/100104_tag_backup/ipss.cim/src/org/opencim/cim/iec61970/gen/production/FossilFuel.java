/**
 * <copyright>
 * </copyright>
 *
 * $Id: FossilFuel.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Naming;

import org.opencim.cim.iec61970.domain.FuelType;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.CostPerHeatUnit;
import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.PerCent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fossil Fuel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The fossil fuel consumed by the non-nuclear thermal generating units, e.g., coal, oil, gas
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFossilFuelType <em>Fossil Fuel Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelCost <em>Fuel Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelDispatchCost <em>Fuel Dispatch Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelEffFactor <em>Fuel Eff Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHandlingCost <em>Fuel Handling Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHeatContent <em>Fuel Heat Content</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelMixture <em>Fuel Mixture</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelSulfur <em>Fuel Sulfur</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getHighMWBreakpoint <em>High MW Breakpoint</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getLowMWBreakpoint <em>Low MW Breakpoint</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelAllocationSchedule <em>Fuel Allocation Schedule</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getThermalGeneratingUnit <em>Thermal Generating Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel()
 * @generated
 */
public interface FossilFuel extends Naming {
	/**
	 * Returns the value of the '<em><b>Fossil Fuel Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.FuelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of fossil fuel, such as coal, oil, or gas.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fossil Fuel Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see #setFossilFuelType(FuelType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FossilFuelType()
	 * @generated
	 */
	FuelType getFossilFuelType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFossilFuelType <em>Fossil Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fossil Fuel Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see #getFossilFuelType()
	 * @generated
	 */
	void setFossilFuelType(FuelType value);

	/**
	 * Returns the value of the '<em><b>Fuel Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The cost in terms of heat value for the given type of fuel
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Cost</em>' attribute.
	 * @see #setFuelCost(CostPerHeatUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelCost()
	 * @generated
	 */
	CostPerHeatUnit getFuelCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelCost <em>Fuel Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Cost</em>' attribute.
	 * @see #getFuelCost()
	 * @generated
	 */
	void setFuelCost(CostPerHeatUnit value);

	/**
	 * Returns the value of the '<em><b>Fuel Dispatch Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The cost of fuel used for economic dispatching which includes: fuel cost, transportation cost,  and incremental maintenance cost
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Dispatch Cost</em>' attribute.
	 * @see #setFuelDispatchCost(CostPerHeatUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelDispatchCost()
	 * @generated
	 */
	CostPerHeatUnit getFuelDispatchCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelDispatchCost <em>Fuel Dispatch Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Dispatch Cost</em>' attribute.
	 * @see #getFuelDispatchCost()
	 * @generated
	 */
	void setFuelDispatchCost(CostPerHeatUnit value);

	/**
	 * Returns the value of the '<em><b>Fuel Eff Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The efficiency factor for the fuel (per unit) in terms of the effective MBtu absorbed
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Eff Factor</em>' attribute.
	 * @see #setFuelEffFactor(PU)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelEffFactor()
	 * @generated
	 */
	PU getFuelEffFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelEffFactor <em>Fuel Eff Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Eff Factor</em>' attribute.
	 * @see #getFuelEffFactor()
	 * @generated
	 */
	void setFuelEffFactor(PU value);

	/**
	 * Returns the value of the '<em><b>Fuel Handling Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Handling and processing cost associated with this fuel
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Handling Cost</em>' attribute.
	 * @see #setFuelHandlingCost(CostPerHeatUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelHandlingCost()
	 * @generated
	 */
	CostPerHeatUnit getFuelHandlingCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHandlingCost <em>Fuel Handling Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Handling Cost</em>' attribute.
	 * @see #getFuelHandlingCost()
	 * @generated
	 */
	void setFuelHandlingCost(CostPerHeatUnit value);

	/**
	 * Returns the value of the '<em><b>Fuel Heat Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of heat (Btu) per weight (or volume) of the given type of fuel
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Heat Content</em>' attribute.
	 * @see #setFuelHeatContent(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelHeatContent()
	 * @generated
	 */
	Float getFuelHeatContent();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHeatContent <em>Fuel Heat Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Heat Content</em>' attribute.
	 * @see #getFuelHeatContent()
	 * @generated
	 */
	void setFuelHeatContent(Float value);

	/**
	 * Returns the value of the '<em><b>Fuel Mixture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount in percent of the given type of fuel , when multiple fuels are being consumed
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Mixture</em>' attribute.
	 * @see #setFuelMixture(PerCent)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelMixture()
	 * @generated
	 */
	PerCent getFuelMixture();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelMixture <em>Fuel Mixture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Mixture</em>' attribute.
	 * @see #getFuelMixture()
	 * @generated
	 */
	void setFuelMixture(PerCent value);

	/**
	 * Returns the value of the '<em><b>Fuel Sulfur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The fuel's fraction of pollution credit per unit of heat content (MBtu)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Sulfur</em>' attribute.
	 * @see #setFuelSulfur(PU)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelSulfur()
	 * @generated
	 */
	PU getFuelSulfur();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelSulfur <em>Fuel Sulfur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Sulfur</em>' attribute.
	 * @see #getFuelSulfur()
	 * @generated
	 */
	void setFuelSulfur(PU value);

	/**
	 * Returns the value of the '<em><b>High MW Breakpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MW output level of the unit at which the given type of fuel is switched on. This fuel (e.g., oil) is sometimes used to supplement the base fuel (e.g., coal) at high MW output levels.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>High MW Breakpoint</em>' attribute.
	 * @see #setHighMWBreakpoint(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_HighMWBreakpoint()
	 * @generated
	 */
	ActivePower getHighMWBreakpoint();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getHighMWBreakpoint <em>High MW Breakpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High MW Breakpoint</em>' attribute.
	 * @see #getHighMWBreakpoint()
	 * @generated
	 */
	void setHighMWBreakpoint(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Low MW Breakpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MW output level of the unit at which the given type of fuel is switched off. This fuel (e.g., oil) is sometimes used to stabilize the base fuel (e.g., coal) at low MW output levels.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Low MW Breakpoint</em>' attribute.
	 * @see #setLowMWBreakpoint(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_LowMWBreakpoint()
	 * @generated
	 */
	ActivePower getLowMWBreakpoint();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getLowMWBreakpoint <em>Low MW Breakpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low MW Breakpoint</em>' attribute.
	 * @see #getLowMWBreakpoint()
	 * @generated
	 */
	void setLowMWBreakpoint(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Fuel Allocation Schedule</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFossilFuel <em>Fossil Fuel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A fuel allocation schedule must have a fossil fuel
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Allocation Schedule</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_FuelAllocationSchedule()
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFossilFuel
	 * @generated
	 */
	EList getFuelAllocationSchedule();

	/**
	 * Returns the value of the '<em><b>Thermal Generating Unit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFossilFuels <em>Fossil Fuels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have one or more fossil fuels
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thermal Generating Unit</em>' reference.
	 * @see #setThermalGeneratingUnit(ThermalGeneratingUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFossilFuel_ThermalGeneratingUnit()
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFossilFuels
	 * @generated
	 */
	ThermalGeneratingUnit getThermalGeneratingUnit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getThermalGeneratingUnit <em>Thermal Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Generating Unit</em>' reference.
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	void setThermalGeneratingUnit(ThermalGeneratingUnit value);

} // FossilFuel