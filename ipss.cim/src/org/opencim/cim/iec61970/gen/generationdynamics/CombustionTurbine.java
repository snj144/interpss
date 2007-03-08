/**
 * <copyright>
 * </copyright>
 *
 * $Id: CombustionTurbine.java,v 1.2 2007/03/04 17:58:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.opencim.cim.iec61970.gen.production.AirCompressor;

import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.PowerVersusFrequency;
import org.opencim.datatype.real.PowerVersusVoltage;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Temperature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combustion Turbine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A prime mover that is typically fueled by gas or light oil
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAmbientTemp <em>Ambient Temp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAuxPowerVersusFrequency <em>Aux Power Versus Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAuxPowerVersusVoltage <em>Aux Power Versus Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getCapabilityVersusFrequency <em>Capability Versus Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getHeatRecoveryFlag <em>Heat Recovery Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getPowerVariationByTemp <em>Power Variation By Temp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getReferenceTemp <em>Reference Temp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getTimeConstant <em>Time Constant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getHeatRecoveryBoiler <em>Heat Recovery Boiler</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getCTTempMWCurve <em>CT Temp MW Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAirCompressor <em>Air Compressor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine()
 * @model
 * @generated
 */
public interface CombustionTurbine extends PrimeMover {
	/**
	 * Returns the value of the '<em><b>Ambient Temp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default ambient temperature to be used in modeling applications
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ambient Temp</em>' attribute.
	 * @see #setAmbientTemp(Temperature)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_AmbientTemp()
	 * @model dataType="org.opencim.cim.iec61970.domain.Temperature"
	 * @generated
	 */
	Temperature getAmbientTemp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAmbientTemp <em>Ambient Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ambient Temp</em>' attribute.
	 * @see #getAmbientTemp()
	 * @generated
	 */
	void setAmbientTemp(Temperature value);

	/**
	 * Returns the value of the '<em><b>Aux Power Versus Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Off-nominal frequency effect on turbine auxiliaries. Per unit reduction in auxiliary MW consumption versus per unit reduction in frequency (from rated frequency).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aux Power Versus Frequency</em>' attribute.
	 * @see #setAuxPowerVersusFrequency(PowerVersusFrequency)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_AuxPowerVersusFrequency()
	 * @model dataType="org.opencim.cim.iec61970.domain.PowerVersusFrequency"
	 * @generated
	 */
	PowerVersusFrequency getAuxPowerVersusFrequency();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAuxPowerVersusFrequency <em>Aux Power Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aux Power Versus Frequency</em>' attribute.
	 * @see #getAuxPowerVersusFrequency()
	 * @generated
	 */
	void setAuxPowerVersusFrequency(PowerVersusFrequency value);

	/**
	 * Returns the value of the '<em><b>Aux Power Versus Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Off-nominal voltage effect on turbine auxiliaries. Per unit reduction in auxiliary MW consumption versus per unit reduction in auxiliary bus voltage (from a specified voltage level).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aux Power Versus Voltage</em>' attribute.
	 * @see #setAuxPowerVersusVoltage(PowerVersusVoltage)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_AuxPowerVersusVoltage()
	 * @model dataType="org.opencim.cim.iec61970.domain.PowerVersusVoltage"
	 * @generated
	 */
	PowerVersusVoltage getAuxPowerVersusVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAuxPowerVersusVoltage <em>Aux Power Versus Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aux Power Versus Voltage</em>' attribute.
	 * @see #getAuxPowerVersusVoltage()
	 * @generated
	 */
	void setAuxPowerVersusVoltage(PowerVersusVoltage value);

	/**
	 * Returns the value of the '<em><b>Capability Versus Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Off-nominal frequency effect on turbine capability. Per unit reduction in unit MW capability versus per unit reduction in frequency (from rated frequency).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capability Versus Frequency</em>' attribute.
	 * @see #setCapabilityVersusFrequency(PowerVersusFrequency)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_CapabilityVersusFrequency()
	 * @model dataType="org.opencim.cim.iec61970.domain.PowerVersusFrequency"
	 * @generated
	 */
	PowerVersusFrequency getCapabilityVersusFrequency();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getCapabilityVersusFrequency <em>Capability Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Versus Frequency</em>' attribute.
	 * @see #getCapabilityVersusFrequency()
	 * @generated
	 */
	void setCapabilityVersusFrequency(PowerVersusFrequency value);

	/**
	 * Returns the value of the '<em><b>Heat Recovery Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag that is set to true if the combustion turbine is associated with a heat recovery boiler
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Recovery Flag</em>' attribute.
	 * @see #setHeatRecoveryFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_HeatRecoveryFlag()
	 * @model
	 * @generated
	 */
	Boolean getHeatRecoveryFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getHeatRecoveryFlag <em>Heat Recovery Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Recovery Flag</em>' attribute.
	 * @see #getHeatRecoveryFlag()
	 * @generated
	 */
	void setHeatRecoveryFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Power Variation By Temp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Per unit change in power per (versus) unit change in ambient temperature
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Power Variation By Temp</em>' attribute.
	 * @see #setPowerVariationByTemp(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_PowerVariationByTemp()
	 * @model dataType="org.opencim.cim.iec61970.domain.PU"
	 * @generated
	 */
	PU getPowerVariationByTemp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getPowerVariationByTemp <em>Power Variation By Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Variation By Temp</em>' attribute.
	 * @see #getPowerVariationByTemp()
	 * @generated
	 */
	void setPowerVariationByTemp(PU value);

	/**
	 * Returns the value of the '<em><b>Reference Temp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference temperature at which the output of the turbine was defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Temp</em>' attribute.
	 * @see #setReferenceTemp(Temperature)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_ReferenceTemp()
	 * @model dataType="org.opencim.cim.iec61970.domain.Temperature"
	 * @generated
	 */
	Temperature getReferenceTemp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getReferenceTemp <em>Reference Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Temp</em>' attribute.
	 * @see #getReferenceTemp()
	 * @generated
	 */
	void setReferenceTemp(Temperature value);

	/**
	 * Returns the value of the '<em><b>Time Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The time constant for the turbine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time Constant</em>' attribute.
	 * @see #setTimeConstant(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_TimeConstant()
	 * @model dataType="org.opencim.cim.iec61970.domain.Seconds"
	 * @generated
	 */
	Seconds getTimeConstant();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getTimeConstant <em>Time Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Constant</em>' attribute.
	 * @see #getTimeConstant()
	 * @generated
	 */
	void setTimeConstant(Seconds value);

	/**
	 * Returns the value of the '<em><b>Heat Recovery Boiler</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler#getCombustionTurbines <em>Combustion Turbines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A combustion turbine may have a heat recovery boiler for making steam
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Recovery Boiler</em>' reference.
	 * @see #setHeatRecoveryBoiler(HeatRecoveryBoiler)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_HeatRecoveryBoiler()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler#getCombustionTurbines
	 * @model opposite="CombustionTurbines" required="true"
	 * @generated
	 */
	HeatRecoveryBoiler getHeatRecoveryBoiler();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getHeatRecoveryBoiler <em>Heat Recovery Boiler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Recovery Boiler</em>' reference.
	 * @see #getHeatRecoveryBoiler()
	 * @generated
	 */
	void setHeatRecoveryBoiler(HeatRecoveryBoiler value);

	/**
	 * Returns the value of the '<em><b>CT Temp MW Curve</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve#getCombustionTurbine <em>Combustion Turbine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A combustion turbine may have a MW versus ambient temperature relationship
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>CT Temp MW Curve</em>' containment reference.
	 * @see #setCTTempMWCurve(CTTempMWCurve)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_CTTempMWCurve()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve#getCombustionTurbine
	 * @model opposite="CombustionTurbine" containment="true"
	 * @generated
	 */
	CTTempMWCurve getCTTempMWCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getCTTempMWCurve <em>CT Temp MW Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CT Temp MW Curve</em>' containment reference.
	 * @see #getCTTempMWCurve()
	 * @generated
	 */
	void setCTTempMWCurve(CTTempMWCurve value);

	/**
	 * Returns the value of the '<em><b>Air Compressor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getCombustionTurbine <em>Combustion Turbine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A CAES air compressor is driven by combustion turbine
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Air Compressor</em>' reference.
	 * @see #setAirCompressor(AirCompressor)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getCombustionTurbine_AirCompressor()
	 * @see org.opencim.cim.iec61970.gen.production.AirCompressor#getCombustionTurbine
	 * @model opposite="CombustionTurbine"
	 * @generated
	 */
	AirCompressor getAirCompressor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getAirCompressor <em>Air Compressor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Air Compressor</em>' reference.
	 * @see #getAirCompressor()
	 * @generated
	 */
	void setAirCompressor(AirCompressor value);

} // CombustionTurbine