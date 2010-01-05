/**
 * <copyright>
 * </copyright>
 *
 * $Id: FuelAllocationSchedule.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import java.util.Date;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.domain.FuelType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fuel Allocation Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The amount of fuel of a given type which is allocated for consumption over a specified period of time
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationEndDate <em>Fuel Allocation End Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationStartDate <em>Fuel Allocation Start Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelType <em>Fuel Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMaxFuelAllocation <em>Max Fuel Allocation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMinFuelAllocation <em>Min Fuel Allocation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFossilFuel <em>Fossil Fuel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule()
 * @generated
 */
public interface FuelAllocationSchedule extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Fuel Allocation End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The end time and date of the fuel allocation schedule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Allocation End Date</em>' attribute.
	 * @see #setFuelAllocationEndDate(Date)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule_FuelAllocationEndDate()
	 * @generated
	 */
	Date getFuelAllocationEndDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationEndDate <em>Fuel Allocation End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Allocation End Date</em>' attribute.
	 * @see #getFuelAllocationEndDate()
	 * @generated
	 */
	void setFuelAllocationEndDate(Date value);

	/**
	 * Returns the value of the '<em><b>Fuel Allocation Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The start time and date of the fuel allocation schedule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Allocation Start Date</em>' attribute.
	 * @see #setFuelAllocationStartDate(Date)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule_FuelAllocationStartDate()
	 * @generated
	 */
	Date getFuelAllocationStartDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationStartDate <em>Fuel Allocation Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Allocation Start Date</em>' attribute.
	 * @see #getFuelAllocationStartDate()
	 * @generated
	 */
	void setFuelAllocationStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>Fuel Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.FuelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of fuel, which also indicates the corresponding measurement unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see #setFuelType(FuelType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule_FuelType()
	 * @generated
	 */
	FuelType getFuelType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelType <em>Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see #getFuelType()
	 * @generated
	 */
	void setFuelType(FuelType value);

	/**
	 * Returns the value of the '<em><b>Max Fuel Allocation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum amount fuel that is allocated for consumption for the scheduled time period
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Fuel Allocation</em>' attribute.
	 * @see #setMaxFuelAllocation(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule_MaxFuelAllocation()
	 * @generated
	 */
	Float getMaxFuelAllocation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMaxFuelAllocation <em>Max Fuel Allocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Fuel Allocation</em>' attribute.
	 * @see #getMaxFuelAllocation()
	 * @generated
	 */
	void setMaxFuelAllocation(Float value);

	/**
	 * Returns the value of the '<em><b>Min Fuel Allocation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum amount fuel that is allocated for consumption for the scheduled time period, e.g., based on a "take-or-pay" contract
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Fuel Allocation</em>' attribute.
	 * @see #setMinFuelAllocation(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule_MinFuelAllocation()
	 * @generated
	 */
	Float getMinFuelAllocation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMinFuelAllocation <em>Min Fuel Allocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Fuel Allocation</em>' attribute.
	 * @see #getMinFuelAllocation()
	 * @generated
	 */
	void setMinFuelAllocation(Float value);

	/**
	 * Returns the value of the '<em><b>Fossil Fuel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelAllocationSchedule <em>Fuel Allocation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A fuel allocation schedule must have a fossil fuel
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fossil Fuel</em>' reference.
	 * @see #setFossilFuel(FossilFuel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getFuelAllocationSchedule_FossilFuel()
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelAllocationSchedule
	 * @generated
	 */
	FossilFuel getFossilFuel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFossilFuel <em>Fossil Fuel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fossil Fuel</em>' reference.
	 * @see #getFossilFuel()
	 * @generated
	 */
	void setFossilFuel(FossilFuel value);

} // FuelAllocationSchedule