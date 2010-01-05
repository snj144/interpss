/**
 * <copyright>
 * </copyright>
 *
 * $Id: CAESPlant.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.EnergyAsMWh;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CAES Plant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Compressed air energy storage plant
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getEnergyStorageCapacity <em>Energy Storage Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getRatedCapacityMW <em>Rated Capacity MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_AirCompressor <em>Contain Air Compressor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_ThermalGeneratingUnit <em>Contain Thermal Generating Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCAESPlant()
 * @generated
 */
public interface CAESPlant extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Energy Storage Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rated energy storage capacity in megawatt-hours
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energy Storage Capacity</em>' attribute.
	 * @see #setEnergyStorageCapacity(EnergyAsMWh)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCAESPlant_EnergyStorageCapacity()
	 * @generated
	 */
	EnergyAsMWh getEnergyStorageCapacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getEnergyStorageCapacity <em>Energy Storage Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Storage Capacity</em>' attribute.
	 * @see #getEnergyStorageCapacity()
	 * @generated
	 */
	void setEnergyStorageCapacity(EnergyAsMWh value);

	/**
	 * Returns the value of the '<em><b>Rated Capacity MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CAES plant's gross rated generating capacity in MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated Capacity MW</em>' attribute.
	 * @see #setRatedCapacityMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCAESPlant_RatedCapacityMW()
	 * @generated
	 */
	ActivePower getRatedCapacityMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getRatedCapacityMW <em>Rated Capacity MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated Capacity MW</em>' attribute.
	 * @see #getRatedCapacityMW()
	 * @generated
	 */
	void setRatedCapacityMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Contain Air Compressor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An air compressor may be a member of a compressed air energy storage plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contain Air Compressor</em>' containment reference.
	 * @see #setContain_AirCompressor(AirCompressor)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCAESPlant_Contain_AirCompressor()
	 * @generated
	 */
	AirCompressor getContain_AirCompressor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_AirCompressor <em>Contain Air Compressor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contain Air Compressor</em>' containment reference.
	 * @see #getContain_AirCompressor()
	 * @generated
	 */
	void setContain_AirCompressor(AirCompressor value);

	/**
	 * Returns the value of the '<em><b>Contain Thermal Generating Unit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CAESPlant <em>Member Of CAES Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may be a member of a compressed air energy storage plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contain Thermal Generating Unit</em>' reference.
	 * @see #setContain_ThermalGeneratingUnit(ThermalGeneratingUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCAESPlant_Contain_ThermalGeneratingUnit()
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CAESPlant
	 * @generated
	 */
	ThermalGeneratingUnit getContain_ThermalGeneratingUnit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_ThermalGeneratingUnit <em>Contain Thermal Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contain Thermal Generating Unit</em>' reference.
	 * @see #getContain_ThermalGeneratingUnit()
	 * @generated
	 */
	void setContain_ThermalGeneratingUnit(ThermalGeneratingUnit value);

} // CAESPlant