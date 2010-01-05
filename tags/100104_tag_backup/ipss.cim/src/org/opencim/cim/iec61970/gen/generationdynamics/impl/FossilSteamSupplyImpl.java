/**
 * <copyright>
 * </copyright>
 *
 * $Id: FossilSteamSupplyImpl.java,v 1.1 2007/03/02 14:01:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.domain.BoilerControlMode;

import org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;

import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.PowerVersusFrequency;
import org.opencim.datatype.real.PowerVersusVoltage;
import org.opencim.datatype.real.RateOfChange;
import org.opencim.datatype.real.Ratio;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fossil Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getAuxPowerVersusFrequency <em>Aux Power Versus Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getAuxPowerversusVoltage <em>Aux Powerversus Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getControlIC <em>Control IC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getBoilerControlMode <em>Boiler Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getControlMWEB <em>Control MWEB</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getControlPC <em>Control PC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getControlPEB <em>Control PEB</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getControlPED <em>Control PED</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getControlTC <em>Control TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getFeedWaterIG <em>Feed Water IG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getFeedWaterPG <em>Feed Water PG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getFeedWaterTC <em>Feed Water TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getFuelDemandLimit <em>Fuel Demand Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getFuelSupplyDelay <em>Fuel Supply Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getMechPowerSensorLag <em>Mech Power Sensor Lag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getFuelSupplyTC <em>Fuel Supply TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getMWMaximumER <em>MW Maximum ER</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getMWMinimumER <em>MW Minimum ER</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getPressureCtrlDG <em>Pressure Ctrl DG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getPressureCtrlIG <em>Pressure Ctrl IG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getPressureCtrlPG <em>Pressure Ctrl PG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getPressureFeedback <em>Pressure Feedback</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getSuperHeater1Capacity <em>Super Heater1 Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getSuperHeater2Capacity <em>Super Heater2 Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getSuperHeaterPipePD <em>Super Heater Pipe PD</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.FossilSteamSupplyImpl#getThrottlePressureSP <em>Throttle Pressure SP</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FossilSteamSupplyImpl extends SteamSupplyImpl implements FossilSteamSupply {
	/**
	 * The default value of the '{@link #getAuxPowerVersusFrequency() <em>Aux Power Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerVersusFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final PowerVersusFrequency AUX_POWER_VERSUS_FREQUENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuxPowerVersusFrequency() <em>Aux Power Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerVersusFrequency()
	 * @generated
	 * @ordered
	 */
	protected PowerVersusFrequency auxPowerVersusFrequency = AUX_POWER_VERSUS_FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuxPowerversusVoltage() <em>Aux Powerversus Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerversusVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final PowerVersusVoltage AUX_POWERVERSUS_VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuxPowerversusVoltage() <em>Aux Powerversus Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerversusVoltage()
	 * @generated
	 * @ordered
	 */
	protected PowerVersusVoltage auxPowerversusVoltage = AUX_POWERVERSUS_VOLTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlIC() <em>Control IC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlIC()
	 * @generated
	 * @ordered
	 */
	protected static final Float CONTROL_IC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlIC() <em>Control IC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlIC()
	 * @generated
	 * @ordered
	 */
	protected Float controlIC = CONTROL_IC_EDEFAULT;

	/**
	 * The default value of the '{@link #getBoilerControlMode() <em>Boiler Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoilerControlMode()
	 * @generated
	 * @ordered
	 */
	protected static final BoilerControlMode BOILER_CONTROL_MODE_EDEFAULT = BoilerControlMode.FOLLOWING_LITERAL;

	/**
	 * The cached value of the '{@link #getBoilerControlMode() <em>Boiler Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoilerControlMode()
	 * @generated
	 * @ordered
	 */
	protected BoilerControlMode boilerControlMode = BOILER_CONTROL_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlMWEB() <em>Control MWEB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlMWEB()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio CONTROL_MWEB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlMWEB() <em>Control MWEB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlMWEB()
	 * @generated
	 * @ordered
	 */
	protected Ratio controlMWEB = CONTROL_MWEB_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlPC() <em>Control PC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPC()
	 * @generated
	 * @ordered
	 */
	protected static final Float CONTROL_PC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlPC() <em>Control PC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPC()
	 * @generated
	 * @ordered
	 */
	protected Float controlPC = CONTROL_PC_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlPEB() <em>Control PEB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPEB()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio CONTROL_PEB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlPEB() <em>Control PEB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPEB()
	 * @generated
	 * @ordered
	 */
	protected Ratio controlPEB = CONTROL_PEB_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlPED() <em>Control PED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPED()
	 * @generated
	 * @ordered
	 */
	protected static final PU CONTROL_PED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlPED() <em>Control PED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPED()
	 * @generated
	 * @ordered
	 */
	protected PU controlPED = CONTROL_PED_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlTC() <em>Control TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlTC()
	 * @generated
	 * @ordered
	 */
	protected static final Float CONTROL_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlTC() <em>Control TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlTC()
	 * @generated
	 * @ordered
	 */
	protected Float controlTC = CONTROL_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedWaterIG() <em>Feed Water IG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedWaterIG()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio FEED_WATER_IG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedWaterIG() <em>Feed Water IG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedWaterIG()
	 * @generated
	 * @ordered
	 */
	protected Ratio feedWaterIG = FEED_WATER_IG_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedWaterPG() <em>Feed Water PG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedWaterPG()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio FEED_WATER_PG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedWaterPG() <em>Feed Water PG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedWaterPG()
	 * @generated
	 * @ordered
	 */
	protected Ratio feedWaterPG = FEED_WATER_PG_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedWaterTC() <em>Feed Water TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedWaterTC()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds FEED_WATER_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedWaterTC() <em>Feed Water TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedWaterTC()
	 * @generated
	 * @ordered
	 */
	protected Seconds feedWaterTC = FEED_WATER_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelDemandLimit() <em>Fuel Demand Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelDemandLimit()
	 * @generated
	 * @ordered
	 */
	protected static final PU FUEL_DEMAND_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelDemandLimit() <em>Fuel Demand Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelDemandLimit()
	 * @generated
	 * @ordered
	 */
	protected PU fuelDemandLimit = FUEL_DEMAND_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelSupplyDelay() <em>Fuel Supply Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelSupplyDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds FUEL_SUPPLY_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelSupplyDelay() <em>Fuel Supply Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelSupplyDelay()
	 * @generated
	 * @ordered
	 */
	protected Seconds fuelSupplyDelay = FUEL_SUPPLY_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMechPowerSensorLag() <em>Mech Power Sensor Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechPowerSensorLag()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds MECH_POWER_SENSOR_LAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMechPowerSensorLag() <em>Mech Power Sensor Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechPowerSensorLag()
	 * @generated
	 * @ordered
	 */
	protected Seconds mechPowerSensorLag = MECH_POWER_SENSOR_LAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelSupplyTC() <em>Fuel Supply TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelSupplyTC()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds FUEL_SUPPLY_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelSupplyTC() <em>Fuel Supply TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelSupplyTC()
	 * @generated
	 * @ordered
	 */
	protected Seconds fuelSupplyTC = FUEL_SUPPLY_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getMWMaximumER() <em>MW Maximum ER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMWMaximumER()
	 * @generated
	 * @ordered
	 */
	protected static final RateOfChange MW_MAXIMUM_ER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMWMaximumER() <em>MW Maximum ER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMWMaximumER()
	 * @generated
	 * @ordered
	 */
	protected RateOfChange mWMaximumER = MW_MAXIMUM_ER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMWMinimumER() <em>MW Minimum ER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMWMinimumER()
	 * @generated
	 * @ordered
	 */
	protected static final RateOfChange MW_MINIMUM_ER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMWMinimumER() <em>MW Minimum ER</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMWMinimumER()
	 * @generated
	 * @ordered
	 */
	protected RateOfChange mWMinimumER = MW_MINIMUM_ER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPressureCtrlDG() <em>Pressure Ctrl DG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCtrlDG()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio PRESSURE_CTRL_DG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPressureCtrlDG() <em>Pressure Ctrl DG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCtrlDG()
	 * @generated
	 * @ordered
	 */
	protected Ratio pressureCtrlDG = PRESSURE_CTRL_DG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPressureCtrlIG() <em>Pressure Ctrl IG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCtrlIG()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio PRESSURE_CTRL_IG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPressureCtrlIG() <em>Pressure Ctrl IG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCtrlIG()
	 * @generated
	 * @ordered
	 */
	protected Ratio pressureCtrlIG = PRESSURE_CTRL_IG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPressureCtrlPG() <em>Pressure Ctrl PG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCtrlPG()
	 * @generated
	 * @ordered
	 */
	protected static final Ratio PRESSURE_CTRL_PG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPressureCtrlPG() <em>Pressure Ctrl PG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCtrlPG()
	 * @generated
	 * @ordered
	 */
	protected Ratio pressureCtrlPG = PRESSURE_CTRL_PG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPressureFeedback() <em>Pressure Feedback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureFeedback()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PRESSURE_FEEDBACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPressureFeedback() <em>Pressure Feedback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureFeedback()
	 * @generated
	 * @ordered
	 */
	protected Integer pressureFeedback = PRESSURE_FEEDBACK_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperHeater1Capacity() <em>Super Heater1 Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperHeater1Capacity()
	 * @generated
	 * @ordered
	 */
	protected static final Float SUPER_HEATER1_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperHeater1Capacity() <em>Super Heater1 Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperHeater1Capacity()
	 * @generated
	 * @ordered
	 */
	protected Float superHeater1Capacity = SUPER_HEATER1_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperHeater2Capacity() <em>Super Heater2 Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperHeater2Capacity()
	 * @generated
	 * @ordered
	 */
	protected static final Float SUPER_HEATER2_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperHeater2Capacity() <em>Super Heater2 Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperHeater2Capacity()
	 * @generated
	 * @ordered
	 */
	protected Float superHeater2Capacity = SUPER_HEATER2_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperHeaterPipePD() <em>Super Heater Pipe PD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperHeaterPipePD()
	 * @generated
	 * @ordered
	 */
	protected static final Float SUPER_HEATER_PIPE_PD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperHeaterPipePD() <em>Super Heater Pipe PD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperHeaterPipePD()
	 * @generated
	 * @ordered
	 */
	protected Float superHeaterPipePD = SUPER_HEATER_PIPE_PD_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrottlePressureSP() <em>Throttle Pressure SP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottlePressureSP()
	 * @generated
	 * @ordered
	 */
	protected static final PU THROTTLE_PRESSURE_SP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThrottlePressureSP() <em>Throttle Pressure SP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottlePressureSP()
	 * @generated
	 * @ordered
	 */
	protected PU throttlePressureSP = THROTTLE_PRESSURE_SP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FossilSteamSupplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.FOSSIL_STEAM_SUPPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusFrequency getAuxPowerVersusFrequency() {
		return auxPowerVersusFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuxPowerVersusFrequency(PowerVersusFrequency newAuxPowerVersusFrequency) {
		PowerVersusFrequency oldAuxPowerVersusFrequency = auxPowerVersusFrequency;
		auxPowerVersusFrequency = newAuxPowerVersusFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWER_VERSUS_FREQUENCY, oldAuxPowerVersusFrequency, auxPowerVersusFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusVoltage getAuxPowerversusVoltage() {
		return auxPowerversusVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuxPowerversusVoltage(PowerVersusVoltage newAuxPowerversusVoltage) {
		PowerVersusVoltage oldAuxPowerversusVoltage = auxPowerversusVoltage;
		auxPowerversusVoltage = newAuxPowerversusVoltage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWERVERSUS_VOLTAGE, oldAuxPowerversusVoltage, auxPowerversusVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getControlIC() {
		return controlIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlIC(Float newControlIC) {
		Float oldControlIC = controlIC;
		controlIC = newControlIC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_IC, oldControlIC, controlIC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoilerControlMode getBoilerControlMode() {
		return boilerControlMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoilerControlMode(BoilerControlMode newBoilerControlMode) {
		BoilerControlMode oldBoilerControlMode = boilerControlMode;
		boilerControlMode = newBoilerControlMode == null ? BOILER_CONTROL_MODE_EDEFAULT : newBoilerControlMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__BOILER_CONTROL_MODE, oldBoilerControlMode, boilerControlMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getControlMWEB() {
		return controlMWEB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlMWEB(Ratio newControlMWEB) {
		Ratio oldControlMWEB = controlMWEB;
		controlMWEB = newControlMWEB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_MWEB, oldControlMWEB, controlMWEB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getControlPC() {
		return controlPC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlPC(Float newControlPC) {
		Float oldControlPC = controlPC;
		controlPC = newControlPC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PC, oldControlPC, controlPC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getControlPEB() {
		return controlPEB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlPEB(Ratio newControlPEB) {
		Ratio oldControlPEB = controlPEB;
		controlPEB = newControlPEB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PEB, oldControlPEB, controlPEB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getControlPED() {
		return controlPED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlPED(PU newControlPED) {
		PU oldControlPED = controlPED;
		controlPED = newControlPED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PED, oldControlPED, controlPED));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getControlTC() {
		return controlTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlTC(Float newControlTC) {
		Float oldControlTC = controlTC;
		controlTC = newControlTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_TC, oldControlTC, controlTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getFeedWaterIG() {
		return feedWaterIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedWaterIG(Ratio newFeedWaterIG) {
		Ratio oldFeedWaterIG = feedWaterIG;
		feedWaterIG = newFeedWaterIG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_IG, oldFeedWaterIG, feedWaterIG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getFeedWaterPG() {
		return feedWaterPG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedWaterPG(Ratio newFeedWaterPG) {
		Ratio oldFeedWaterPG = feedWaterPG;
		feedWaterPG = newFeedWaterPG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_PG, oldFeedWaterPG, feedWaterPG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getFeedWaterTC() {
		return feedWaterTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedWaterTC(Seconds newFeedWaterTC) {
		Seconds oldFeedWaterTC = feedWaterTC;
		feedWaterTC = newFeedWaterTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_TC, oldFeedWaterTC, feedWaterTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getFuelDemandLimit() {
		return fuelDemandLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelDemandLimit(PU newFuelDemandLimit) {
		PU oldFuelDemandLimit = fuelDemandLimit;
		fuelDemandLimit = newFuelDemandLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_DEMAND_LIMIT, oldFuelDemandLimit, fuelDemandLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getFuelSupplyDelay() {
		return fuelSupplyDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelSupplyDelay(Seconds newFuelSupplyDelay) {
		Seconds oldFuelSupplyDelay = fuelSupplyDelay;
		fuelSupplyDelay = newFuelSupplyDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_DELAY, oldFuelSupplyDelay, fuelSupplyDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getMechPowerSensorLag() {
		return mechPowerSensorLag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMechPowerSensorLag(Seconds newMechPowerSensorLag) {
		Seconds oldMechPowerSensorLag = mechPowerSensorLag;
		mechPowerSensorLag = newMechPowerSensorLag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MECH_POWER_SENSOR_LAG, oldMechPowerSensorLag, mechPowerSensorLag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getFuelSupplyTC() {
		return fuelSupplyTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelSupplyTC(Seconds newFuelSupplyTC) {
		Seconds oldFuelSupplyTC = fuelSupplyTC;
		fuelSupplyTC = newFuelSupplyTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_TC, oldFuelSupplyTC, fuelSupplyTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RateOfChange getMWMaximumER() {
		return mWMaximumER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMWMaximumER(RateOfChange newMWMaximumER) {
		RateOfChange oldMWMaximumER = mWMaximumER;
		mWMaximumER = newMWMaximumER;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MAXIMUM_ER, oldMWMaximumER, mWMaximumER));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RateOfChange getMWMinimumER() {
		return mWMinimumER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMWMinimumER(RateOfChange newMWMinimumER) {
		RateOfChange oldMWMinimumER = mWMinimumER;
		mWMinimumER = newMWMinimumER;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MINIMUM_ER, oldMWMinimumER, mWMinimumER));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getPressureCtrlDG() {
		return pressureCtrlDG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureCtrlDG(Ratio newPressureCtrlDG) {
		Ratio oldPressureCtrlDG = pressureCtrlDG;
		pressureCtrlDG = newPressureCtrlDG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_DG, oldPressureCtrlDG, pressureCtrlDG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getPressureCtrlIG() {
		return pressureCtrlIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureCtrlIG(Ratio newPressureCtrlIG) {
		Ratio oldPressureCtrlIG = pressureCtrlIG;
		pressureCtrlIG = newPressureCtrlIG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_IG, oldPressureCtrlIG, pressureCtrlIG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio getPressureCtrlPG() {
		return pressureCtrlPG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureCtrlPG(Ratio newPressureCtrlPG) {
		Ratio oldPressureCtrlPG = pressureCtrlPG;
		pressureCtrlPG = newPressureCtrlPG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_PG, oldPressureCtrlPG, pressureCtrlPG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPressureFeedback() {
		return pressureFeedback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureFeedback(Integer newPressureFeedback) {
		Integer oldPressureFeedback = pressureFeedback;
		pressureFeedback = newPressureFeedback;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_FEEDBACK, oldPressureFeedback, pressureFeedback));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSuperHeater1Capacity() {
		return superHeater1Capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperHeater1Capacity(Float newSuperHeater1Capacity) {
		Float oldSuperHeater1Capacity = superHeater1Capacity;
		superHeater1Capacity = newSuperHeater1Capacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER1_CAPACITY, oldSuperHeater1Capacity, superHeater1Capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSuperHeater2Capacity() {
		return superHeater2Capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperHeater2Capacity(Float newSuperHeater2Capacity) {
		Float oldSuperHeater2Capacity = superHeater2Capacity;
		superHeater2Capacity = newSuperHeater2Capacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER2_CAPACITY, oldSuperHeater2Capacity, superHeater2Capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSuperHeaterPipePD() {
		return superHeaterPipePD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperHeaterPipePD(Float newSuperHeaterPipePD) {
		Float oldSuperHeaterPipePD = superHeaterPipePD;
		superHeaterPipePD = newSuperHeaterPipePD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER_PIPE_PD, oldSuperHeaterPipePD, superHeaterPipePD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getThrottlePressureSP() {
		return throttlePressureSP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottlePressureSP(PU newThrottlePressureSP) {
		PU oldThrottlePressureSP = throttlePressureSP;
		throttlePressureSP = newThrottlePressureSP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__THROTTLE_PRESSURE_SP, oldThrottlePressureSP, throttlePressureSP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWER_VERSUS_FREQUENCY:
				return getAuxPowerVersusFrequency();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWERVERSUS_VOLTAGE:
				return getAuxPowerversusVoltage();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_IC:
				return getControlIC();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__BOILER_CONTROL_MODE:
				return getBoilerControlMode();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_MWEB:
				return getControlMWEB();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PC:
				return getControlPC();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PEB:
				return getControlPEB();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PED:
				return getControlPED();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_TC:
				return getControlTC();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_IG:
				return getFeedWaterIG();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_PG:
				return getFeedWaterPG();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_TC:
				return getFeedWaterTC();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_DEMAND_LIMIT:
				return getFuelDemandLimit();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_DELAY:
				return getFuelSupplyDelay();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MECH_POWER_SENSOR_LAG:
				return getMechPowerSensorLag();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_TC:
				return getFuelSupplyTC();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MAXIMUM_ER:
				return getMWMaximumER();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MINIMUM_ER:
				return getMWMinimumER();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_DG:
				return getPressureCtrlDG();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_IG:
				return getPressureCtrlIG();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_PG:
				return getPressureCtrlPG();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_FEEDBACK:
				return getPressureFeedback();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER1_CAPACITY:
				return getSuperHeater1Capacity();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER2_CAPACITY:
				return getSuperHeater2Capacity();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER_PIPE_PD:
				return getSuperHeaterPipePD();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				return getThrottlePressureSP();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWER_VERSUS_FREQUENCY:
				setAuxPowerVersusFrequency((PowerVersusFrequency)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWERVERSUS_VOLTAGE:
				setAuxPowerversusVoltage((PowerVersusVoltage)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_IC:
				setControlIC((Float)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__BOILER_CONTROL_MODE:
				setBoilerControlMode((BoilerControlMode)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_MWEB:
				setControlMWEB((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PC:
				setControlPC((Float)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PEB:
				setControlPEB((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PED:
				setControlPED((PU)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_TC:
				setControlTC((Float)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_IG:
				setFeedWaterIG((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_PG:
				setFeedWaterPG((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_TC:
				setFeedWaterTC((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_DEMAND_LIMIT:
				setFuelDemandLimit((PU)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_DELAY:
				setFuelSupplyDelay((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MECH_POWER_SENSOR_LAG:
				setMechPowerSensorLag((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_TC:
				setFuelSupplyTC((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MAXIMUM_ER:
				setMWMaximumER((RateOfChange)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MINIMUM_ER:
				setMWMinimumER((RateOfChange)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_DG:
				setPressureCtrlDG((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_IG:
				setPressureCtrlIG((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_PG:
				setPressureCtrlPG((Ratio)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_FEEDBACK:
				setPressureFeedback((Integer)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER1_CAPACITY:
				setSuperHeater1Capacity((Float)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER2_CAPACITY:
				setSuperHeater2Capacity((Float)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER_PIPE_PD:
				setSuperHeaterPipePD((Float)newValue);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				setThrottlePressureSP((PU)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWER_VERSUS_FREQUENCY:
				setAuxPowerVersusFrequency(AUX_POWER_VERSUS_FREQUENCY_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWERVERSUS_VOLTAGE:
				setAuxPowerversusVoltage(AUX_POWERVERSUS_VOLTAGE_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_IC:
				setControlIC(CONTROL_IC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__BOILER_CONTROL_MODE:
				setBoilerControlMode(BOILER_CONTROL_MODE_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_MWEB:
				setControlMWEB(CONTROL_MWEB_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PC:
				setControlPC(CONTROL_PC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PEB:
				setControlPEB(CONTROL_PEB_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PED:
				setControlPED(CONTROL_PED_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_TC:
				setControlTC(CONTROL_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_IG:
				setFeedWaterIG(FEED_WATER_IG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_PG:
				setFeedWaterPG(FEED_WATER_PG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_TC:
				setFeedWaterTC(FEED_WATER_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_DEMAND_LIMIT:
				setFuelDemandLimit(FUEL_DEMAND_LIMIT_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_DELAY:
				setFuelSupplyDelay(FUEL_SUPPLY_DELAY_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MECH_POWER_SENSOR_LAG:
				setMechPowerSensorLag(MECH_POWER_SENSOR_LAG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_TC:
				setFuelSupplyTC(FUEL_SUPPLY_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MAXIMUM_ER:
				setMWMaximumER(MW_MAXIMUM_ER_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MINIMUM_ER:
				setMWMinimumER(MW_MINIMUM_ER_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_DG:
				setPressureCtrlDG(PRESSURE_CTRL_DG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_IG:
				setPressureCtrlIG(PRESSURE_CTRL_IG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_PG:
				setPressureCtrlPG(PRESSURE_CTRL_PG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_FEEDBACK:
				setPressureFeedback(PRESSURE_FEEDBACK_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER1_CAPACITY:
				setSuperHeater1Capacity(SUPER_HEATER1_CAPACITY_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER2_CAPACITY:
				setSuperHeater2Capacity(SUPER_HEATER2_CAPACITY_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER_PIPE_PD:
				setSuperHeaterPipePD(SUPER_HEATER_PIPE_PD_EDEFAULT);
				return;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				setThrottlePressureSP(THROTTLE_PRESSURE_SP_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWER_VERSUS_FREQUENCY:
				return AUX_POWER_VERSUS_FREQUENCY_EDEFAULT == null ? auxPowerVersusFrequency != null : !AUX_POWER_VERSUS_FREQUENCY_EDEFAULT.equals(auxPowerVersusFrequency);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__AUX_POWERVERSUS_VOLTAGE:
				return AUX_POWERVERSUS_VOLTAGE_EDEFAULT == null ? auxPowerversusVoltage != null : !AUX_POWERVERSUS_VOLTAGE_EDEFAULT.equals(auxPowerversusVoltage);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_IC:
				return CONTROL_IC_EDEFAULT == null ? controlIC != null : !CONTROL_IC_EDEFAULT.equals(controlIC);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__BOILER_CONTROL_MODE:
				return boilerControlMode != BOILER_CONTROL_MODE_EDEFAULT;
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_MWEB:
				return CONTROL_MWEB_EDEFAULT == null ? controlMWEB != null : !CONTROL_MWEB_EDEFAULT.equals(controlMWEB);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PC:
				return CONTROL_PC_EDEFAULT == null ? controlPC != null : !CONTROL_PC_EDEFAULT.equals(controlPC);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PEB:
				return CONTROL_PEB_EDEFAULT == null ? controlPEB != null : !CONTROL_PEB_EDEFAULT.equals(controlPEB);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_PED:
				return CONTROL_PED_EDEFAULT == null ? controlPED != null : !CONTROL_PED_EDEFAULT.equals(controlPED);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__CONTROL_TC:
				return CONTROL_TC_EDEFAULT == null ? controlTC != null : !CONTROL_TC_EDEFAULT.equals(controlTC);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_IG:
				return FEED_WATER_IG_EDEFAULT == null ? feedWaterIG != null : !FEED_WATER_IG_EDEFAULT.equals(feedWaterIG);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_PG:
				return FEED_WATER_PG_EDEFAULT == null ? feedWaterPG != null : !FEED_WATER_PG_EDEFAULT.equals(feedWaterPG);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FEED_WATER_TC:
				return FEED_WATER_TC_EDEFAULT == null ? feedWaterTC != null : !FEED_WATER_TC_EDEFAULT.equals(feedWaterTC);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_DEMAND_LIMIT:
				return FUEL_DEMAND_LIMIT_EDEFAULT == null ? fuelDemandLimit != null : !FUEL_DEMAND_LIMIT_EDEFAULT.equals(fuelDemandLimit);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_DELAY:
				return FUEL_SUPPLY_DELAY_EDEFAULT == null ? fuelSupplyDelay != null : !FUEL_SUPPLY_DELAY_EDEFAULT.equals(fuelSupplyDelay);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MECH_POWER_SENSOR_LAG:
				return MECH_POWER_SENSOR_LAG_EDEFAULT == null ? mechPowerSensorLag != null : !MECH_POWER_SENSOR_LAG_EDEFAULT.equals(mechPowerSensorLag);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_TC:
				return FUEL_SUPPLY_TC_EDEFAULT == null ? fuelSupplyTC != null : !FUEL_SUPPLY_TC_EDEFAULT.equals(fuelSupplyTC);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MAXIMUM_ER:
				return MW_MAXIMUM_ER_EDEFAULT == null ? mWMaximumER != null : !MW_MAXIMUM_ER_EDEFAULT.equals(mWMaximumER);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__MW_MINIMUM_ER:
				return MW_MINIMUM_ER_EDEFAULT == null ? mWMinimumER != null : !MW_MINIMUM_ER_EDEFAULT.equals(mWMinimumER);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_DG:
				return PRESSURE_CTRL_DG_EDEFAULT == null ? pressureCtrlDG != null : !PRESSURE_CTRL_DG_EDEFAULT.equals(pressureCtrlDG);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_IG:
				return PRESSURE_CTRL_IG_EDEFAULT == null ? pressureCtrlIG != null : !PRESSURE_CTRL_IG_EDEFAULT.equals(pressureCtrlIG);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_PG:
				return PRESSURE_CTRL_PG_EDEFAULT == null ? pressureCtrlPG != null : !PRESSURE_CTRL_PG_EDEFAULT.equals(pressureCtrlPG);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__PRESSURE_FEEDBACK:
				return PRESSURE_FEEDBACK_EDEFAULT == null ? pressureFeedback != null : !PRESSURE_FEEDBACK_EDEFAULT.equals(pressureFeedback);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER1_CAPACITY:
				return SUPER_HEATER1_CAPACITY_EDEFAULT == null ? superHeater1Capacity != null : !SUPER_HEATER1_CAPACITY_EDEFAULT.equals(superHeater1Capacity);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER2_CAPACITY:
				return SUPER_HEATER2_CAPACITY_EDEFAULT == null ? superHeater2Capacity != null : !SUPER_HEATER2_CAPACITY_EDEFAULT.equals(superHeater2Capacity);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__SUPER_HEATER_PIPE_PD:
				return SUPER_HEATER_PIPE_PD_EDEFAULT == null ? superHeaterPipePD != null : !SUPER_HEATER_PIPE_PD_EDEFAULT.equals(superHeaterPipePD);
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				return THROTTLE_PRESSURE_SP_EDEFAULT == null ? throttlePressureSP != null : !THROTTLE_PRESSURE_SP_EDEFAULT.equals(throttlePressureSP);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (auxPowerVersusFrequency: ");
		result.append(auxPowerVersusFrequency);
		result.append(", auxPowerversusVoltage: ");
		result.append(auxPowerversusVoltage);
		result.append(", controlIC: ");
		result.append(controlIC);
		result.append(", boilerControlMode: ");
		result.append(boilerControlMode);
		result.append(", controlMWEB: ");
		result.append(controlMWEB);
		result.append(", controlPC: ");
		result.append(controlPC);
		result.append(", controlPEB: ");
		result.append(controlPEB);
		result.append(", controlPED: ");
		result.append(controlPED);
		result.append(", controlTC: ");
		result.append(controlTC);
		result.append(", feedWaterIG: ");
		result.append(feedWaterIG);
		result.append(", feedWaterPG: ");
		result.append(feedWaterPG);
		result.append(", feedWaterTC: ");
		result.append(feedWaterTC);
		result.append(", fuelDemandLimit: ");
		result.append(fuelDemandLimit);
		result.append(", fuelSupplyDelay: ");
		result.append(fuelSupplyDelay);
		result.append(", mechPowerSensorLag: ");
		result.append(mechPowerSensorLag);
		result.append(", fuelSupplyTC: ");
		result.append(fuelSupplyTC);
		result.append(", mWMaximumER: ");
		result.append(mWMaximumER);
		result.append(", mWMinimumER: ");
		result.append(mWMinimumER);
		result.append(", pressureCtrlDG: ");
		result.append(pressureCtrlDG);
		result.append(", pressureCtrlIG: ");
		result.append(pressureCtrlIG);
		result.append(", pressureCtrlPG: ");
		result.append(pressureCtrlPG);
		result.append(", pressureFeedback: ");
		result.append(pressureFeedback);
		result.append(", superHeater1Capacity: ");
		result.append(superHeater1Capacity);
		result.append(", superHeater2Capacity: ");
		result.append(superHeater2Capacity);
		result.append(", superHeaterPipePD: ");
		result.append(superHeaterPipePD);
		result.append(", throttlePressureSP: ");
		result.append(throttlePressureSP);
		result.append(')');
		return result.toString();
	}

} //FossilSteamSupplyImpl