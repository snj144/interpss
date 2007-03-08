/**
 * <copyright>
 * </copyright>
 *
 * $Id: AirCompressor.java,v 1.2 2007/03/04 17:58:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Air Compressor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Combustion turbine air compressor which is an integral part of a compressed air energy storage (CAES) plant
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getAirCompressorRating <em>Air Compressor Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getCombustionTurbine <em>Combustion Turbine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getAirCompressor()
 * @model
 * @generated
 */
public interface AirCompressor extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Air Compressor Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rating of the CAES air compressor
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Air Compressor Rating</em>' attribute.
	 * @see #setAirCompressorRating(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getAirCompressor_AirCompressorRating()
	 * @model
	 * @generated
	 */
	Float getAirCompressorRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getAirCompressorRating <em>Air Compressor Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Air Compressor Rating</em>' attribute.
	 * @see #getAirCompressorRating()
	 * @generated
	 */
	void setAirCompressorRating(Float value);

	/**
	 * Returns the value of the '<em><b>Combustion Turbine</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAirCompressor <em>Air Compressor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A CAES air compressor is driven by combustion turbine
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Combustion Turbine</em>' reference.
	 * @see #setCombustionTurbine(CombustionTurbine)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getAirCompressor_CombustionTurbine()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAirCompressor
	 * @model opposite="AirCompressor" required="true"
	 * @generated
	 */
	CombustionTurbine getCombustionTurbine();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getCombustionTurbine <em>Combustion Turbine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combustion Turbine</em>' reference.
	 * @see #getCombustionTurbine()
	 * @generated
	 */
	void setCombustionTurbine(CombustionTurbine value);

} // AirCompressor