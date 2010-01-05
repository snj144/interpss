/**
 * <copyright>
 * </copyright>
 *
 * $Id: FossilSteamSupply.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.opencim.cim.iec61970.domain.BoilerControlMode;

import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.PowerVersusFrequency;
import org.opencim.datatype.real.PowerVersusVoltage;
import org.opencim.datatype.real.RateOfChange;
import org.opencim.datatype.real.Ratio;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fossil Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Fossil fueled boiler (e.g., coal, oil, gas)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getAuxPowerVersusFrequency <em>Aux Power Versus Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getAuxPowerversusVoltage <em>Aux Powerversus Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlIC <em>Control IC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getBoilerControlMode <em>Boiler Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlMWEB <em>Control MWEB</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlPC <em>Control PC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlPEB <em>Control PEB</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlPED <em>Control PED</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlTC <em>Control TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFeedWaterIG <em>Feed Water IG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFeedWaterPG <em>Feed Water PG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFeedWaterTC <em>Feed Water TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFuelDemandLimit <em>Fuel Demand Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFuelSupplyDelay <em>Fuel Supply Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getMechPowerSensorLag <em>Mech Power Sensor Lag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFuelSupplyTC <em>Fuel Supply TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getMWMaximumER <em>MW Maximum ER</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getMWMinimumER <em>MW Minimum ER</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureCtrlDG <em>Pressure Ctrl DG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureCtrlIG <em>Pressure Ctrl IG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureCtrlPG <em>Pressure Ctrl PG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureFeedback <em>Pressure Feedback</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getSuperHeater1Capacity <em>Super Heater1 Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getSuperHeater2Capacity <em>Super Heater2 Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getSuperHeaterPipePD <em>Super Heater Pipe PD</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getThrottlePressureSP <em>Throttle Pressure SP</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply()
 * @generated
 */
public interface FossilSteamSupply extends SteamSupply {
	/**
	 * Returns the value of the '<em><b>Aux Power Versus Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Off nominal frequency effect on auxiliary real power. Per unit MW variation versus per unit frequency variation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aux Power Versus Frequency</em>' attribute.
	 * @see #setAuxPowerVersusFrequency(PowerVersusFrequency)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_AuxPowerVersusFrequency()
	 * @generated
	 */
	PowerVersusFrequency getAuxPowerVersusFrequency();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getAuxPowerVersusFrequency <em>Aux Power Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aux Power Versus Frequency</em>' attribute.
	 * @see #getAuxPowerVersusFrequency()
	 * @generated
	 */
	void setAuxPowerVersusFrequency(PowerVersusFrequency value);

	/**
	 * Returns the value of the '<em><b>Aux Powerversus Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Off nominal voltage effect on auxiliary real power. Per unit MW variation versus per unit  kV variation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aux Powerversus Voltage</em>' attribute.
	 * @see #setAuxPowerversusVoltage(PowerVersusVoltage)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_AuxPowerversusVoltage()
	 * @generated
	 */
	PowerVersusVoltage getAuxPowerversusVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getAuxPowerversusVoltage <em>Aux Powerversus Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aux Powerversus Voltage</em>' attribute.
	 * @see #getAuxPowerversusVoltage()
	 * @generated
	 */
	void setAuxPowerversusVoltage(PowerVersusVoltage value);

	/**
	 * Returns the value of the '<em><b>Control IC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Integral Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control IC</em>' attribute.
	 * @see #setControlIC(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ControlIC()
	 * @generated
	 */
	Float getControlIC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlIC <em>Control IC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control IC</em>' attribute.
	 * @see #getControlIC()
	 * @generated
	 */
	void setControlIC(Float value);

	/**
	 * Returns the value of the '<em><b>Boiler Control Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.BoilerControlMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The control mode of the boiler
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Boiler Control Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.BoilerControlMode
	 * @see #setBoilerControlMode(BoilerControlMode)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_BoilerControlMode()
	 * @generated
	 */
	BoilerControlMode getBoilerControlMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getBoilerControlMode <em>Boiler Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boiler Control Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.BoilerControlMode
	 * @see #getBoilerControlMode()
	 * @generated
	 */
	void setBoilerControlMode(BoilerControlMode value);

	/**
	 * Returns the value of the '<em><b>Control MWEB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MW Error Bias
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control MWEB</em>' attribute.
	 * @see #setControlMWEB(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ControlMWEB()
	 * @generated
	 */
	Ratio getControlMWEB();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlMWEB <em>Control MWEB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control MWEB</em>' attribute.
	 * @see #getControlMWEB()
	 * @generated
	 */
	void setControlMWEB(Ratio value);

	/**
	 * Returns the value of the '<em><b>Control PC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Proportional Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control PC</em>' attribute.
	 * @see #setControlPC(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ControlPC()
	 * @generated
	 */
	Float getControlPC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlPC <em>Control PC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control PC</em>' attribute.
	 * @see #getControlPC()
	 * @generated
	 */
	void setControlPC(Float value);

	/**
	 * Returns the value of the '<em><b>Control PEB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Error Bias
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control PEB</em>' attribute.
	 * @see #setControlPEB(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ControlPEB()
	 * @generated
	 */
	Ratio getControlPEB();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlPEB <em>Control PEB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control PEB</em>' attribute.
	 * @see #getControlPEB()
	 * @generated
	 */
	void setControlPEB(Ratio value);

	/**
	 * Returns the value of the '<em><b>Control PED</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Error Deadband
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control PED</em>' attribute.
	 * @see #setControlPED(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ControlPED()
	 * @generated
	 */
	PU getControlPED();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlPED <em>Control PED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control PED</em>' attribute.
	 * @see #getControlPED()
	 * @generated
	 */
	void setControlPED(PU value);

	/**
	 * Returns the value of the '<em><b>Control TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control TC</em>' attribute.
	 * @see #setControlTC(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ControlTC()
	 * @generated
	 */
	Float getControlTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getControlTC <em>Control TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control TC</em>' attribute.
	 * @see #getControlTC()
	 * @generated
	 */
	void setControlTC(Float value);

	/**
	 * Returns the value of the '<em><b>Feed Water IG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Feedwater Integral Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feed Water IG</em>' attribute.
	 * @see #setFeedWaterIG(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_FeedWaterIG()
	 * @generated
	 */
	Ratio getFeedWaterIG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFeedWaterIG <em>Feed Water IG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feed Water IG</em>' attribute.
	 * @see #getFeedWaterIG()
	 * @generated
	 */
	void setFeedWaterIG(Ratio value);

	/**
	 * Returns the value of the '<em><b>Feed Water PG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Feedwater Proportional Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feed Water PG</em>' attribute.
	 * @see #setFeedWaterPG(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_FeedWaterPG()
	 * @generated
	 */
	Ratio getFeedWaterPG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFeedWaterPG <em>Feed Water PG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feed Water PG</em>' attribute.
	 * @see #getFeedWaterPG()
	 * @generated
	 */
	void setFeedWaterPG(Ratio value);

	/**
	 * Returns the value of the '<em><b>Feed Water TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Feedwater Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feed Water TC</em>' attribute.
	 * @see #setFeedWaterTC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_FeedWaterTC()
	 * @generated
	 */
	Seconds getFeedWaterTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFeedWaterTC <em>Feed Water TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feed Water TC</em>' attribute.
	 * @see #getFeedWaterTC()
	 * @generated
	 */
	void setFeedWaterTC(Seconds value);

	/**
	 * Returns the value of the '<em><b>Fuel Demand Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fuel Demand Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Demand Limit</em>' attribute.
	 * @see #setFuelDemandLimit(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_FuelDemandLimit()
	 * @generated
	 */
	PU getFuelDemandLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFuelDemandLimit <em>Fuel Demand Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Demand Limit</em>' attribute.
	 * @see #getFuelDemandLimit()
	 * @generated
	 */
	void setFuelDemandLimit(PU value);

	/**
	 * Returns the value of the '<em><b>Fuel Supply Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fuel Delay
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Supply Delay</em>' attribute.
	 * @see #setFuelSupplyDelay(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_FuelSupplyDelay()
	 * @generated
	 */
	Seconds getFuelSupplyDelay();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFuelSupplyDelay <em>Fuel Supply Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Supply Delay</em>' attribute.
	 * @see #getFuelSupplyDelay()
	 * @generated
	 */
	void setFuelSupplyDelay(Seconds value);

	/**
	 * Returns the value of the '<em><b>Mech Power Sensor Lag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mechanical Power Sensor Lag
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mech Power Sensor Lag</em>' attribute.
	 * @see #setMechPowerSensorLag(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_MechPowerSensorLag()
	 * @generated
	 */
	Seconds getMechPowerSensorLag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getMechPowerSensorLag <em>Mech Power Sensor Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mech Power Sensor Lag</em>' attribute.
	 * @see #getMechPowerSensorLag()
	 * @generated
	 */
	void setMechPowerSensorLag(Seconds value);

	/**
	 * Returns the value of the '<em><b>Fuel Supply TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fuel Supply Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Supply TC</em>' attribute.
	 * @see #setFuelSupplyTC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_FuelSupplyTC()
	 * @generated
	 */
	Seconds getFuelSupplyTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getFuelSupplyTC <em>Fuel Supply TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Supply TC</em>' attribute.
	 * @see #getFuelSupplyTC()
	 * @generated
	 */
	void setFuelSupplyTC(Seconds value);

	/**
	 * Returns the value of the '<em><b>MW Maximum ER</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MW Maximum Error Rate Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MW Maximum ER</em>' attribute.
	 * @see #setMWMaximumER(RateOfChange)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_MWMaximumER()
	 * @generated
	 */
	RateOfChange getMWMaximumER();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getMWMaximumER <em>MW Maximum ER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MW Maximum ER</em>' attribute.
	 * @see #getMWMaximumER()
	 * @generated
	 */
	void setMWMaximumER(RateOfChange value);

	/**
	 * Returns the value of the '<em><b>MW Minimum ER</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MW Minimum Error Rate Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MW Minimum ER</em>' attribute.
	 * @see #setMWMinimumER(RateOfChange)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_MWMinimumER()
	 * @generated
	 */
	RateOfChange getMWMinimumER();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getMWMinimumER <em>MW Minimum ER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MW Minimum ER</em>' attribute.
	 * @see #getMWMinimumER()
	 * @generated
	 */
	void setMWMinimumER(RateOfChange value);

	/**
	 * Returns the value of the '<em><b>Pressure Ctrl DG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Control Derivative Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Ctrl DG</em>' attribute.
	 * @see #setPressureCtrlDG(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_PressureCtrlDG()
	 * @generated
	 */
	Ratio getPressureCtrlDG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureCtrlDG <em>Pressure Ctrl DG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Ctrl DG</em>' attribute.
	 * @see #getPressureCtrlDG()
	 * @generated
	 */
	void setPressureCtrlDG(Ratio value);

	/**
	 * Returns the value of the '<em><b>Pressure Ctrl IG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Control Integral Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Ctrl IG</em>' attribute.
	 * @see #setPressureCtrlIG(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_PressureCtrlIG()
	 * @generated
	 */
	Ratio getPressureCtrlIG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureCtrlIG <em>Pressure Ctrl IG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Ctrl IG</em>' attribute.
	 * @see #getPressureCtrlIG()
	 * @generated
	 */
	void setPressureCtrlIG(Ratio value);

	/**
	 * Returns the value of the '<em><b>Pressure Ctrl PG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Control Proportional Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Ctrl PG</em>' attribute.
	 * @see #setPressureCtrlPG(Ratio)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_PressureCtrlPG()
	 * @generated
	 */
	Ratio getPressureCtrlPG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureCtrlPG <em>Pressure Ctrl PG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Ctrl PG</em>' attribute.
	 * @see #getPressureCtrlPG()
	 * @generated
	 */
	void setPressureCtrlPG(Ratio value);

	/**
	 * Returns the value of the '<em><b>Pressure Feedback</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Feedback Indicator
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure Feedback</em>' attribute.
	 * @see #setPressureFeedback(Integer)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_PressureFeedback()
	 * @generated
	 */
	Integer getPressureFeedback();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getPressureFeedback <em>Pressure Feedback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure Feedback</em>' attribute.
	 * @see #getPressureFeedback()
	 * @generated
	 */
	void setPressureFeedback(Integer value);

	/**
	 * Returns the value of the '<em><b>Super Heater1 Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Drum/Primary Superheater Capacity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Heater1 Capacity</em>' attribute.
	 * @see #setSuperHeater1Capacity(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_SuperHeater1Capacity()
	 * @generated
	 */
	Float getSuperHeater1Capacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getSuperHeater1Capacity <em>Super Heater1 Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Heater1 Capacity</em>' attribute.
	 * @see #getSuperHeater1Capacity()
	 * @generated
	 */
	void setSuperHeater1Capacity(Float value);

	/**
	 * Returns the value of the '<em><b>Super Heater2 Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Secondary Superheater Capacity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Heater2 Capacity</em>' attribute.
	 * @see #setSuperHeater2Capacity(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_SuperHeater2Capacity()
	 * @generated
	 */
	Float getSuperHeater2Capacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getSuperHeater2Capacity <em>Super Heater2 Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Heater2 Capacity</em>' attribute.
	 * @see #getSuperHeater2Capacity()
	 * @generated
	 */
	void setSuperHeater2Capacity(Float value);

	/**
	 * Returns the value of the '<em><b>Super Heater Pipe PD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Superheater Pipe Pressure Drop Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Heater Pipe PD</em>' attribute.
	 * @see #setSuperHeaterPipePD(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_SuperHeaterPipePD()
	 * @generated
	 */
	Float getSuperHeaterPipePD();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getSuperHeaterPipePD <em>Super Heater Pipe PD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Heater Pipe PD</em>' attribute.
	 * @see #getSuperHeaterPipePD()
	 * @generated
	 */
	void setSuperHeaterPipePD(Float value);

	/**
	 * Returns the value of the '<em><b>Throttle Pressure SP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Throttle Pressure Setpoint
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Throttle Pressure SP</em>' attribute.
	 * @see #setThrottlePressureSP(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getFossilSteamSupply_ThrottlePressureSP()
	 * @generated
	 */
	PU getThrottlePressureSP();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply#getThrottlePressureSP <em>Throttle Pressure SP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Pressure SP</em>' attribute.
	 * @see #getThrottlePressureSP()
	 * @generated
	 */
	void setThrottlePressureSP(PU value);

} // FossilSteamSupply