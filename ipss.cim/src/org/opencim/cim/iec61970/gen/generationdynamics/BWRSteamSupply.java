/**
 * <copyright>
 * </copyright>
 *
 * $Id: BWRSteamSupply.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.RateOfChange;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BWR Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Boiling water reactor used as a steam supply to a steam turbine
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getHighPowerLimit <em>High Power Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getInCoreThermalTC <em>In Core Thermal TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getIntegralGain <em>Integral Gain</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getLowerLimit <em>Lower Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getLowPowerLimit <em>Low Power Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureLimit <em>Pressure Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureSetpointGA <em>Pressure Setpoint GA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureSetpointTC1 <em>Pressure Setpoint TC1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureSetpointTC2 <em>Pressure Setpoint TC2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getProportionalGain <em>Proportional Gain</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux1 <em>Rf Aux1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux2 <em>Rf Aux2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux3 <em>Rf Aux3</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux4 <em>Rf Aux4</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux5 <em>Rf Aux5</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux6 <em>Rf Aux6</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux7 <em>Rf Aux7</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux8 <em>Rf Aux8</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRodPattern <em>Rod Pattern</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRodPatternConstant <em>Rod Pattern Constant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getUpperLimit <em>Upper Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply()
 * @generated
 */
public interface BWRSteamSupply extends SteamSupply {
	/**
	 * Returns the value of the '<em><b>High Power Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * High Power Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>High Power Limit</em>' attribute.
	 * @see #setHighPowerLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_HighPowerLimit()
	 * @generated
	 */
	PU getHighPowerLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getHighPowerLimit <em>High Power Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Power Limit</em>' attribute.
	 * @see #getHighPowerLimit()
	 * @generated
	 */
	void setHighPowerLimit(PU value);

	/**
	 * Returns the value of the '<em><b>In Core Thermal TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In-Core Thermal Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In Core Thermal TC</em>' attribute.
	 * @see #setInCoreThermalTC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_InCoreThermalTC()
	 * @generated
	 */
	Seconds getInCoreThermalTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getInCoreThermalTC <em>In Core Thermal TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Core Thermal TC</em>' attribute.
	 * @see #getInCoreThermalTC()
	 * @generated
	 */
	void setInCoreThermalTC(Seconds value);

	/**
	 * Returns the value of the '<em><b>Integral Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Integral Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Integral Gain</em>' attribute.
	 * @see #setIntegralGain(RateOfChange)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_IntegralGain()
	 * @generated
	 */
	RateOfChange getIntegralGain();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getIntegralGain <em>Integral Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integral Gain</em>' attribute.
	 * @see #getIntegralGain()
	 * @generated
	 */
	void setIntegralGain(RateOfChange value);

	/**
	 * Returns the value of the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Initial Lower Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Limit</em>' attribute.
	 * @see #setLowerLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_LowerLimit()
	 * @generated
	 */
	PU getLowerLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getLowerLimit <em>Lower Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Limit</em>' attribute.
	 * @see #getLowerLimit()
	 * @generated
	 */
	void setLowerLimit(PU value);

	/**
	 * Returns the value of the '<em><b>Low Power Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Low Power Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Low Power Limit</em>' attribute.
	 * @see #setLowPowerLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_LowPowerLimit()
	 * @generated
	 */
	PU getLowPowerLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getLowPowerLimit <em>Low Power Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low Power Limit</em>' attribute.
	 * @see #getLowPowerLimit()
	 * @generated
	 */
	void setLowPowerLimit(PU value);

	/**
	 * Returns the value of the '<em><b>Pressure Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Limit</em>' attribute.
	 * @see #setPressureLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_PressureLimit()
	 * @generated
	 */
	PU getPressureLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureLimit <em>Pressure Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Limit</em>' attribute.
	 * @see #getPressureLimit()
	 * @generated
	 */
	void setPressureLimit(PU value);

	/**
	 * Returns the value of the '<em><b>Pressure Setpoint GA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Setpoint Gain Adjuster
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Setpoint GA</em>' attribute.
	 * @see #setPressureSetpointGA(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_PressureSetpointGA()
	 * @generated
	 */
	Float getPressureSetpointGA();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureSetpointGA <em>Pressure Setpoint GA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Setpoint GA</em>' attribute.
	 * @see #getPressureSetpointGA()
	 * @generated
	 */
	void setPressureSetpointGA(Float value);

	/**
	 * Returns the value of the '<em><b>Pressure Setpoint TC1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Setpoint Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Setpoint TC1</em>' attribute.
	 * @see #setPressureSetpointTC1(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_PressureSetpointTC1()
	 * @generated
	 */
	Seconds getPressureSetpointTC1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureSetpointTC1 <em>Pressure Setpoint TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Setpoint TC1</em>' attribute.
	 * @see #getPressureSetpointTC1()
	 * @generated
	 */
	void setPressureSetpointTC1(Seconds value);

	/**
	 * Returns the value of the '<em><b>Pressure Setpoint TC2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Setpoint Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Setpoint TC2</em>' attribute.
	 * @see #setPressureSetpointTC2(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_PressureSetpointTC2()
	 * @generated
	 */
	Seconds getPressureSetpointTC2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getPressureSetpointTC2 <em>Pressure Setpoint TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Setpoint TC2</em>' attribute.
	 * @see #getPressureSetpointTC2()
	 * @generated
	 */
	void setPressureSetpointTC2(Seconds value);

	/**
	 * Returns the value of the '<em><b>Proportional Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Proportional Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Proportional Gain</em>' attribute.
	 * @see #setProportionalGain(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_ProportionalGain()
	 * @generated
	 */
	Float getProportionalGain();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getProportionalGain <em>Proportional Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proportional Gain</em>' attribute.
	 * @see #getProportionalGain()
	 * @generated
	 */
	void setProportionalGain(Float value);

	/**
	 * Returns the value of the '<em><b>Rf Aux1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux1</em>' attribute.
	 * @see #setRfAux1(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux1()
	 * @generated
	 */
	PU getRfAux1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux1 <em>Rf Aux1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux1</em>' attribute.
	 * @see #getRfAux1()
	 * @generated
	 */
	void setRfAux1(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux2</em>' attribute.
	 * @see #setRfAux2(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux2()
	 * @generated
	 */
	PU getRfAux2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux2 <em>Rf Aux2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux2</em>' attribute.
	 * @see #getRfAux2()
	 * @generated
	 */
	void setRfAux2(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux3</em>' attribute.
	 * @see #setRfAux3(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux3()
	 * @generated
	 */
	PU getRfAux3();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux3 <em>Rf Aux3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux3</em>' attribute.
	 * @see #getRfAux3()
	 * @generated
	 */
	void setRfAux3(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux4</em>' attribute.
	 * @see #setRfAux4(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux4()
	 * @generated
	 */
	PU getRfAux4();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux4 <em>Rf Aux4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux4</em>' attribute.
	 * @see #getRfAux4()
	 * @generated
	 */
	void setRfAux4(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux5</em>' attribute.
	 * @see #setRfAux5(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux5()
	 * @generated
	 */
	PU getRfAux5();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux5 <em>Rf Aux5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux5</em>' attribute.
	 * @see #getRfAux5()
	 * @generated
	 */
	void setRfAux5(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux6</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux6</em>' attribute.
	 * @see #setRfAux6(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux6()
	 * @generated
	 */
	PU getRfAux6();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux6 <em>Rf Aux6</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux6</em>' attribute.
	 * @see #getRfAux6()
	 * @generated
	 */
	void setRfAux6(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux7</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux7</em>' attribute.
	 * @see #setRfAux7(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux7()
	 * @generated
	 */
	PU getRfAux7();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux7 <em>Rf Aux7</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux7</em>' attribute.
	 * @see #getRfAux7()
	 * @generated
	 */
	void setRfAux7(PU value);

	/**
	 * Returns the value of the '<em><b>Rf Aux8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rf Aux8</em>' attribute.
	 * @see #setRfAux8(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RfAux8()
	 * @generated
	 */
	PU getRfAux8();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRfAux8 <em>Rf Aux8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Aux8</em>' attribute.
	 * @see #getRfAux8()
	 * @generated
	 */
	void setRfAux8(PU value);

	/**
	 * Returns the value of the '<em><b>Rod Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rod Pattern
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rod Pattern</em>' attribute.
	 * @see #setRodPattern(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RodPattern()
	 * @generated
	 */
	PU getRodPattern();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRodPattern <em>Rod Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rod Pattern</em>' attribute.
	 * @see #getRodPattern()
	 * @generated
	 */
	void setRodPattern(PU value);

	/**
	 * Returns the value of the '<em><b>Rod Pattern Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Constant Associated With Rod Pattern
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rod Pattern Constant</em>' attribute.
	 * @see #setRodPatternConstant(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_RodPatternConstant()
	 * @generated
	 */
	Float getRodPatternConstant();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getRodPatternConstant <em>Rod Pattern Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rod Pattern Constant</em>' attribute.
	 * @see #getRodPatternConstant()
	 * @generated
	 */
	void setRodPatternConstant(Float value);

	/**
	 * Returns the value of the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Initial Upper Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Limit</em>' attribute.
	 * @see #setUpperLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getBWRSteamSupply_UpperLimit()
	 * @generated
	 */
	PU getUpperLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply#getUpperLimit <em>Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Limit</em>' attribute.
	 * @see #getUpperLimit()
	 * @generated
	 */
	void setUpperLimit(PU value);

} // BWRSteamSupply