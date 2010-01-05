/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroTurbine.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.opencim.cim.iec61970.domain.TurbineType;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.RateOfChange;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hydro Turbine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A water driven prime mover. Typical turbine types are: Francis, Kaplan, and Pelton.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getGateRateLimit <em>Gate Rate Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getGateUpperLimit <em>Gate Upper Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getMaxEffMWatMinHead <em>Max Eff MWat Min Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getMaxEffMWatMaxHead <em>Max Eff MWat Max Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getSpeedRating <em>Speed Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getSpeedRegulation <em>Speed Regulation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTransientDroopTime <em>Transient Droop Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTransientRegulation <em>Transient Regulation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTurbineRating <em>Turbine Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTurbineType <em>Turbine Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getWaterStartingTime <em>Water Starting Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine()
 * @generated
 */
public interface HydroTurbine extends PrimeMover {
	/**
	 * Returns the value of the '<em><b>Gate Rate Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gate Rate Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gate Rate Limit</em>' attribute.
	 * @see #setGateRateLimit(RateOfChange)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_GateRateLimit()
	 * @generated
	 */
	RateOfChange getGateRateLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getGateRateLimit <em>Gate Rate Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gate Rate Limit</em>' attribute.
	 * @see #getGateRateLimit()
	 * @generated
	 */
	void setGateRateLimit(RateOfChange value);

	/**
	 * Returns the value of the '<em><b>Gate Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gate Upper Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gate Upper Limit</em>' attribute.
	 * @see #setGateUpperLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_GateUpperLimit()
	 * @generated
	 */
	PU getGateUpperLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getGateUpperLimit <em>Gate Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gate Upper Limit</em>' attribute.
	 * @see #getGateUpperLimit()
	 * @generated
	 */
	void setGateUpperLimit(PU value);

	/**
	 * Returns the value of the '<em><b>Max Eff MWat Min Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum efficiency MW at minimum head conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Eff MWat Min Head</em>' attribute.
	 * @see #setMaxEffMWatMinHead(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_MaxEffMWatMinHead()
	 * @generated
	 */
	ActivePower getMaxEffMWatMinHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getMaxEffMWatMinHead <em>Max Eff MWat Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Eff MWat Min Head</em>' attribute.
	 * @see #getMaxEffMWatMinHead()
	 * @generated
	 */
	void setMaxEffMWatMinHead(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Max Eff MWat Max Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum efficiency MW at maximum head conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Eff MWat Max Head</em>' attribute.
	 * @see #setMaxEffMWatMaxHead(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_MaxEffMWatMaxHead()
	 * @generated
	 */
	ActivePower getMaxEffMWatMaxHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getMaxEffMWatMaxHead <em>Max Eff MWat Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Eff MWat Max Head</em>' attribute.
	 * @see #getMaxEffMWatMaxHead()
	 * @generated
	 */
	void setMaxEffMWatMaxHead(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Speed Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rated speed in revolutions per minute
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Speed Rating</em>' attribute.
	 * @see #setSpeedRating(Integer)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_SpeedRating()
	 * @generated
	 */
	Integer getSpeedRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getSpeedRating <em>Speed Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Rating</em>' attribute.
	 * @see #getSpeedRating()
	 * @generated
	 */
	void setSpeedRating(Integer value);

	/**
	 * Returns the value of the '<em><b>Speed Regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Speed Regulation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Speed Regulation</em>' attribute.
	 * @see #setSpeedRegulation(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_SpeedRegulation()
	 * @generated
	 */
	PU getSpeedRegulation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getSpeedRegulation <em>Speed Regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Regulation</em>' attribute.
	 * @see #getSpeedRegulation()
	 * @generated
	 */
	void setSpeedRegulation(PU value);

	/**
	 * Returns the value of the '<em><b>Transient Droop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transient Droop Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transient Droop Time</em>' attribute.
	 * @see #setTransientDroopTime(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_TransientDroopTime()
	 * @generated
	 */
	Seconds getTransientDroopTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTransientDroopTime <em>Transient Droop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient Droop Time</em>' attribute.
	 * @see #getTransientDroopTime()
	 * @generated
	 */
	void setTransientDroopTime(Seconds value);

	/**
	 * Returns the value of the '<em><b>Transient Regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transient Regulation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transient Regulation</em>' attribute.
	 * @see #setTransientRegulation(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_TransientRegulation()
	 * @generated
	 */
	PU getTransientRegulation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTransientRegulation <em>Transient Regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient Regulation</em>' attribute.
	 * @see #getTransientRegulation()
	 * @generated
	 */
	void setTransientRegulation(PU value);

	/**
	 * Returns the value of the '<em><b>Turbine Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rated turbine power in MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Turbine Rating</em>' attribute.
	 * @see #setTurbineRating(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_TurbineRating()
	 * @generated
	 */
	ActivePower getTurbineRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTurbineRating <em>Turbine Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Turbine Rating</em>' attribute.
	 * @see #getTurbineRating()
	 * @generated
	 */
	void setTurbineRating(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Turbine Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.TurbineType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of turbine, e.g.: Francis, Pelton, Kaplan
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Turbine Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TurbineType
	 * @see #setTurbineType(TurbineType)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_TurbineType()
	 * @generated
	 */
	TurbineType getTurbineType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getTurbineType <em>Turbine Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Turbine Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TurbineType
	 * @see #getTurbineType()
	 * @generated
	 */
	void setTurbineType(TurbineType value);

	/**
	 * Returns the value of the '<em><b>Water Starting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Water Starting Time
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Water Starting Time</em>' attribute.
	 * @see #setWaterStartingTime(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHydroTurbine_WaterStartingTime()
	 * @generated
	 */
	Seconds getWaterStartingTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine#getWaterStartingTime <em>Water Starting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Water Starting Time</em>' attribute.
	 * @see #getWaterStartingTime()
	 * @generated
	 */
	void setWaterStartingTime(Seconds value);

} // HydroTurbine