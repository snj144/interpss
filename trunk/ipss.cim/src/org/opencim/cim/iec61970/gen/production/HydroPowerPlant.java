/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroPowerPlant.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.domain.HydroPlantType;
import org.opencim.cim.iec61970.domain.PenstockType;
import org.opencim.cim.iec61970.domain.SurgeTankCode;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.WaterLevel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hydro Power Plant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A hydro power station which can generate or pump. When generating, the generator turbines receive there water from an upper reservoir. When pumping, the pumps receive their water from a lower reservoir.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getDischargeTravelDelay <em>Discharge Travel Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getHydroPlantType <em>Hydro Plant Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPenstockType <em>Penstock Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantDischargeCapacity <em>Plant Discharge Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWGenRating <em>Plant MW Gen Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWPumpRating <em>Plant MW Pump Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantRatedHead <em>Plant Rated Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCode <em>Surge Tank Code</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCrestLevel <em>Surge Tank Crest Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getContain_HydroGeneratingUnits <em>Contain Hydro Generating Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getContain_HydroPumps <em>Contain Hydro Pumps</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getReservoir <em>Reservoir</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getGenSourcePumpDischarge <em>Gen Source Pump Discharge</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant()
 * @model
 * @generated
 */
public interface HydroPowerPlant extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Discharge Travel Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Water travel delay from tailbay to next downstream hydro power station
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Discharge Travel Delay</em>' attribute.
	 * @see #setDischargeTravelDelay(Seconds)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_DischargeTravelDelay()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getDischargeTravelDelay();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getDischargeTravelDelay <em>Discharge Travel Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discharge Travel Delay</em>' attribute.
	 * @see #getDischargeTravelDelay()
	 * @generated
	 */
	void setDischargeTravelDelay(Seconds value);

	/**
	 * Returns the value of the '<em><b>Hydro Plant Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.HydroPlantType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of hydro power plant, e.g.: Run-of-River, Pumped Storage, Major Storage, Minor Storage
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hydro Plant Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.HydroPlantType
	 * @see #setHydroPlantType(HydroPlantType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_HydroPlantType()
	 * @model
	 * @generated
	 */
	HydroPlantType getHydroPlantType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getHydroPlantType <em>Hydro Plant Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hydro Plant Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.HydroPlantType
	 * @see #getHydroPlantType()
	 * @generated
	 */
	void setHydroPlantType(HydroPlantType value);

	/**
	 * Returns the value of the '<em><b>Penstock Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.PenstockType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type and configuration of hydro plant penstock(s)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Penstock Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.PenstockType
	 * @see #setPenstockType(PenstockType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_PenstockType()
	 * @model
	 * @generated
	 */
	PenstockType getPenstockType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPenstockType <em>Penstock Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penstock Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.PenstockType
	 * @see #getPenstockType()
	 * @generated
	 */
	void setPenstockType(PenstockType value);

	/**
	 * Returns the value of the '<em><b>Plant Discharge Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Total plant discharge capacity in cubic meters per second
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plant Discharge Capacity</em>' attribute.
	 * @see #setPlantDischargeCapacity(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_PlantDischargeCapacity()
	 * @model
	 * @generated
	 */
	Float getPlantDischargeCapacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantDischargeCapacity <em>Plant Discharge Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plant Discharge Capacity</em>' attribute.
	 * @see #getPlantDischargeCapacity()
	 * @generated
	 */
	void setPlantDischargeCapacity(Float value);

	/**
	 * Returns the value of the '<em><b>Plant MW Gen Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hydro plant's generating rating in MW for rated head conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plant MW Gen Rating</em>' attribute.
	 * @see #setPlantMWGenRating(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_PlantMWGenRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getPlantMWGenRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWGenRating <em>Plant MW Gen Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plant MW Gen Rating</em>' attribute.
	 * @see #getPlantMWGenRating()
	 * @generated
	 */
	void setPlantMWGenRating(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Plant MW Pump Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hydro plant's pumping rating in MW for rated head conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plant MW Pump Rating</em>' attribute.
	 * @see #setPlantMWPumpRating(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_PlantMWPumpRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getPlantMWPumpRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWPumpRating <em>Plant MW Pump Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plant MW Pump Rating</em>' attribute.
	 * @see #getPlantMWPumpRating()
	 * @generated
	 */
	void setPlantMWPumpRating(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Plant Rated Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The plant's rated gross head in meters
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plant Rated Head</em>' attribute.
	 * @see #setPlantRatedHead(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_PlantRatedHead()
	 * @model
	 * @generated
	 */
	Float getPlantRatedHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantRatedHead <em>Plant Rated Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plant Rated Head</em>' attribute.
	 * @see #getPlantRatedHead()
	 * @generated
	 */
	void setPlantRatedHead(Float value);

	/**
	 * Returns the value of the '<em><b>Surge Tank Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.SurgeTankCode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A code describing the type (or absence) of surge tank that is associated with the hydro power plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Surge Tank Code</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SurgeTankCode
	 * @see #setSurgeTankCode(SurgeTankCode)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_SurgeTankCode()
	 * @model
	 * @generated
	 */
	SurgeTankCode getSurgeTankCode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCode <em>Surge Tank Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surge Tank Code</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SurgeTankCode
	 * @see #getSurgeTankCode()
	 * @generated
	 */
	void setSurgeTankCode(SurgeTankCode value);

	/**
	 * Returns the value of the '<em><b>Surge Tank Crest Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The level at which the surge tank spills
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Surge Tank Crest Level</em>' attribute.
	 * @see #setSurgeTankCrestLevel(WaterLevel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_SurgeTankCrestLevel()
	 * @model dataType="org.opencim.cim.iec61970.domain.WaterLevel"
	 * @generated
	 */
	WaterLevel getSurgeTankCrestLevel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCrestLevel <em>Surge Tank Crest Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surge Tank Crest Level</em>' attribute.
	 * @see #getSurgeTankCrestLevel()
	 * @generated
	 */
	void setSurgeTankCrestLevel(WaterLevel value);

	/**
	 * Returns the value of the '<em><b>Contain Hydro Generating Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hydro generating unit belongs to a hydro power plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contain Hydro Generating Units</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_Contain_HydroGeneratingUnits()
	 * @model type="org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit" containment="true" required="true"
	 * @generated
	 */
	EList getContain_HydroGeneratingUnits();

	/**
	 * Returns the value of the '<em><b>Contain Hydro Pumps</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.HydroPump}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hydro pump may be a member of a pumped storage plant or a pump for distributing water
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contain Hydro Pumps</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_Contain_HydroPumps()
	 * @model type="org.opencim.cim.iec61970.gen.production.HydroPump" containment="true" required="true"
	 * @generated
	 */
	EList getContain_HydroPumps();

	/**
	 * Returns the value of the '<em><b>Reservoir</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getHydroPowerPlants <em>Hydro Power Plants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generators discharge water to or pumps are supplied water from a downstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reservoir</em>' reference.
	 * @see #setReservoir(Reservoir)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_Reservoir()
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getHydroPowerPlants
	 * @model opposite="HydroPowerPlants"
	 * @generated
	 */
	Reservoir getReservoir();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getReservoir <em>Reservoir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reservoir</em>' reference.
	 * @see #getReservoir()
	 * @generated
	 */
	void setReservoir(Reservoir value);

	/**
	 * Returns the value of the '<em><b>Gen Source Pump Discharge</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getUpstreamFrom <em>Upstream From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generators are supplied water from or pumps discharge water to an upstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gen Source Pump Discharge</em>' reference.
	 * @see #setGenSourcePumpDischarge(Reservoir)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPowerPlant_GenSourcePumpDischarge()
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getUpstreamFrom
	 * @model opposite="UpstreamFrom" required="true"
	 * @generated
	 */
	Reservoir getGenSourcePumpDischarge();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getGenSourcePumpDischarge <em>Gen Source Pump Discharge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Source Pump Discharge</em>' reference.
	 * @see #getGenSourcePumpDischarge()
	 * @generated
	 */
	void setGenSourcePumpDischarge(Reservoir value);

} // HydroPowerPlant