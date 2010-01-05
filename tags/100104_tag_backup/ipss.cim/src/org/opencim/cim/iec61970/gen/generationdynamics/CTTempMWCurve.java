/**
 * <copyright>
 * </copyright>
 *
 * $Id: CTTempMWCurve.java,v 1.2 2007/03/04 17:58:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.domain.TemperatureUnits;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CT Temp MW Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between the combustion turbine's power output rating in gross MW (X-axis) and the ambient air temperature in temperature units (Y-axis)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve#getTemperatureUnits <em>Temperature Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve#getCombustionTurbine <em>Combustion Turbine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCTTempMWCurve()
 * @generated
 */
public interface CTTempMWCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Temperature Units</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.TemperatureUnits}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The temperature units (C or F)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Temperature Units</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TemperatureUnits
	 * @see #setTemperatureUnits(TemperatureUnits)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCTTempMWCurve_TemperatureUnits()
	 * @generated
	 */
	TemperatureUnits getTemperatureUnits();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve#getTemperatureUnits <em>Temperature Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temperature Units</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TemperatureUnits
	 * @see #getTemperatureUnits()
	 * @generated
	 */
	void setTemperatureUnits(TemperatureUnits value);

	/**
	 * Returns the value of the '<em><b>Combustion Turbine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getCTTempMWCurve <em>CT Temp MW Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A combustion turbine may have a MW versus ambient temperature relationship
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Combustion Turbine</em>' container reference.
	 * @see #setCombustionTurbine(CombustionTurbine)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCTTempMWCurve_CombustionTurbine()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getCTTempMWCurve
	 * @generated
	 */
	CombustionTurbine getCombustionTurbine();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve#getCombustionTurbine <em>Combustion Turbine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combustion Turbine</em>' container reference.
	 * @see #getCombustionTurbine()
	 * @generated
	 */
	void setCombustionTurbine(CombustionTurbine value);

} // CTTempMWCurve