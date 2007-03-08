/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomainPackage.java,v 1.4 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The domain package is a data dictionary of quantities and units that define datatypes for attributes (properties) that may be used by any class in any other package.
 * 
 * This package contains the definition of primitive datatypes, including units of measure and permissible values. Each datatype contains a value attribute and an optional unit of measure, which is specified as a static variable initialized to the textual description of the unit of measure. The value of the "units" string may be country or customer specific. Typical values are given. Permissible values for enumerations are listed in the documentation for the attribute using UML constraint syntax inside curly braces. Lengths of variable strings are listed in the descriptive text where required.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainFactory
 * @model kind="package"
 * @generated
 */
public interface DomainPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domain";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim.cim.iec61970.domain";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainPackage eINSTANCE = org.opencim.cim.iec61970.domain.impl.DomainPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.impl.DomainVersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.impl.DomainVersionImpl
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDomainVersion()
	 * @generated
	 */
	int DOMAIN_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VERSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.BoilerControlMode <em>Boiler Control Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.BoilerControlMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getBoilerControlMode()
	 * @generated
	 */
	int BOILER_CONTROL_MODE = 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.SwitchState <em>Switch State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.SwitchState
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSwitchState()
	 * @generated
	 */
	int SWITCH_STATE = 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.TemperatureUnits <em>Temperature Units</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.TemperatureUnits
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTemperatureUnits()
	 * @generated
	 */
	int TEMPERATURE_UNITS = 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.WindingType <em>Winding Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.WindingType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getWindingType()
	 * @generated
	 */
	int WINDING_TYPE = 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.WindingConnection <em>Winding Connection</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.WindingConnection
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getWindingConnection()
	 * @generated
	 */
	int WINDING_CONNECTION = 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.SeasonName <em>Season Name</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.SeasonName
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSeasonName()
	 * @generated
	 */
	int SEASON_NAME = 6;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.DayTypeName <em>Day Type Name</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.DayTypeName
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDayTypeName()
	 * @generated
	 */
	int DAY_TYPE_NAME = 7;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.BreakerConfiguration <em>Breaker Configuration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.BreakerConfiguration
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getBreakerConfiguration()
	 * @generated
	 */
	int BREAKER_CONFIGURATION = 8;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.BusbarConfiguration <em>Busbar Configuration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.BusbarConfiguration
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getBusbarConfiguration()
	 * @generated
	 */
	int BUSBAR_CONFIGURATION = 9;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.CompanyType <em>Company Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.CompanyType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCompanyType()
	 * @generated
	 */
	int COMPANY_TYPE = 10;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.CoolantType <em>Coolant Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.CoolantType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCoolantType()
	 * @generated
	 */
	int COOLANT_TYPE = 11;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.CurveStyle <em>Curve Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.CurveStyle
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCurveStyle()
	 * @generated
	 */
	int CURVE_STYLE = 12;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.EmissionType <em>Emission Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.EmissionType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEmissionType()
	 * @generated
	 */
	int EMISSION_TYPE = 13;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.EmissionValueSource <em>Emission Value Source</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.EmissionValueSource
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEmissionValueSource()
	 * @generated
	 */
	int EMISSION_VALUE_SOURCE = 14;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.FuelType <em>Fuel Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFuelType()
	 * @generated
	 */
	int FUEL_TYPE = 15;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.PenstockType <em>Penstock Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.PenstockType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPenstockType()
	 * @generated
	 */
	int PENSTOCK_TYPE = 16;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.RampMethod <em>Ramp Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.RampMethod
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRampMethod()
	 * @generated
	 */
	int RAMP_METHOD = 17;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.RampStartMethod <em>Ramp Start Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.RampStartMethod
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRampStartMethod()
	 * @generated
	 */
	int RAMP_START_METHOD = 18;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.RampUnits <em>Ramp Units</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.RampUnits
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRampUnits()
	 * @generated
	 */
	int RAMP_UNITS = 19;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.SpillwayGateType <em>Spillway Gate Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.SpillwayGateType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSpillwayGateType()
	 * @generated
	 */
	int SPILLWAY_GATE_TYPE = 20;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.SurgeTankCode <em>Surge Tank Code</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.SurgeTankCode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSurgeTankCode()
	 * @generated
	 */
	int SURGE_TANK_CODE = 21;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.TransformerCoolingType <em>Transformer Cooling Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.TransformerCoolingType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTransformerCoolingType()
	 * @generated
	 */
	int TRANSFORMER_COOLING_TYPE = 22;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.TurbineType <em>Turbine Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.TurbineType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTurbineType()
	 * @generated
	 */
	int TURBINE_TYPE = 23;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.YAxisType <em>YAxis Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.YAxisType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getYAxisType()
	 * @generated
	 */
	int YAXIS_TYPE = 24;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.AxisQuantity <em>Axis Quantity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAxisQuantity()
	 * @generated
	 */
	int AXIS_QUANTITY = 25;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.HydroPlantType <em>Hydro Plant Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.HydroPlantType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getHydroPlantType()
	 * @generated
	 */
	int HYDRO_PLANT_TYPE = 26;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.NumericType <em>Numeric Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.NumericType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getNumericType()
	 * @generated
	 */
	int NUMERIC_TYPE = 27;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.TransformerType <em>Transformer Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.TransformerType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTransformerType()
	 * @generated
	 */
	int TRANSFORMER_TYPE = 28;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.CompensatorType <em>Compensator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.CompensatorType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCompensatorType()
	 * @generated
	 */
	int COMPENSATOR_TYPE = 29;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.Validity <em>Validity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.Validity
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getValidity()
	 * @generated
	 */
	int VALIDITY = 30;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.Source <em>Source</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.Source
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSource()
	 * @generated
	 */
	int SOURCE = 31;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.RemoteUnitType <em>Remote Unit Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.RemoteUnitType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRemoteUnitType()
	 * @generated
	 */
	int REMOTE_UNIT_TYPE = 32;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode <em>Synchronous Machine Operating Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSynchronousMachineOperatingMode()
	 * @generated
	 */
	int SYNCHRONOUS_MACHINE_OPERATING_MODE = 33;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.SynchronousMachineType <em>Synchronous Machine Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSynchronousMachineType()
	 * @generated
	 */
	int SYNCHRONOUS_MACHINE_TYPE = 34;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.TransformerControlMode <em>Transformer Control Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.TransformerControlMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTransformerControlMode()
	 * @generated
	 */
	int TRANSFORMER_CONTROL_MODE = 35;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.GeneratorOperatingMode <em>Generator Operating Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.GeneratorOperatingMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getGeneratorOperatingMode()
	 * @generated
	 */
	int GENERATOR_OPERATING_MODE = 36;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.GeneratorControlMode <em>Generator Control Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getGeneratorControlMode()
	 * @generated
	 */
	int GENERATOR_CONTROL_MODE = 37;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.GeneratorControlSource <em>Generator Control Source</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlSource
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getGeneratorControlSource()
	 * @generated
	 */
	int GENERATOR_CONTROL_SOURCE = 38;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.AreaControlMode <em>Area Control Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.AreaControlMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAreaControlMode()
	 * @generated
	 */
	int AREA_CONTROL_MODE = 39;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.domain.ControlHouseEquipmentType <em>Control House Equipment Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.domain.ControlHouseEquipmentType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getControlHouseEquipmentType()
	 * @generated
	 */
	int CONTROL_HOUSE_EQUIPMENT_TYPE = 40;

	/**
	 * The meta object id for the '<em>Active Power</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.ActivePower
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getActivePower()
	 * @generated
	 */
	int ACTIVE_POWER = 41;

	/**
	 * The meta object id for the '<em>Apparent Power</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.ApparentPower
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getApparentPower()
	 * @generated
	 */
	int APPARENT_POWER = 42;

	/**
	 * The meta object id for the '<em>Classification</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.integer.Classification
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getClassification()
	 * @generated
	 */
	int CLASSIFICATION = 43;

	/**
	 * The meta object id for the '<em>Control Mode</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.string.ControlMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getControlMode()
	 * @generated
	 */
	int CONTROL_MODE = 44;

	/**
	 * The meta object id for the '<em>Cost Per Energy Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.CostPerEnergyUnit
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCostPerEnergyUnit()
	 * @generated
	 */
	int COST_PER_ENERGY_UNIT = 45;

	/**
	 * The meta object id for the '<em>Cost Per Heat Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.CostPerHeatUnit
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCostPerHeatUnit()
	 * @generated
	 */
	int COST_PER_HEAT_UNIT = 46;

	/**
	 * The meta object id for the '<em>Cost Per Hour</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.CostPerHour
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCostPerHour()
	 * @generated
	 */
	int COST_PER_HOUR = 47;

	/**
	 * The meta object id for the '<em>Counter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.integer.Counter
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCounter()
	 * @generated
	 */
	int COUNTER = 48;

	/**
	 * The meta object id for the '<em>Current Flow</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.CurrentFlow
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCurrentFlow()
	 * @generated
	 */
	int CURRENT_FLOW = 49;

	/**
	 * The meta object id for the '<em>Damping</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Damping
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDamping()
	 * @generated
	 */
	int DAMPING = 50;

	/**
	 * The meta object id for the '<em>Angle Degrees</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.AngleDegrees
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAngleDegrees()
	 * @generated
	 */
	int ANGLE_DEGREES = 51;

	/**
	 * The meta object id for the '<em>Emission</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Emission
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEmission()
	 * @generated
	 */
	int EMISSION = 52;

	/**
	 * The meta object id for the '<em>Energy As MWh</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.EnergyAsMWh
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEnergyAsMWh()
	 * @generated
	 */
	int ENERGY_AS_MWH = 53;

	/**
	 * The meta object id for the '<em>Exciting Current</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.ExcitingCurrent
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getExcitingCurrent()
	 * @generated
	 */
	int EXCITING_CURRENT = 54;

	/**
	 * The meta object id for the '<em>Exponent</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Exponent
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getExponent()
	 * @generated
	 */
	int EXPONENT = 55;

	/**
	 * The meta object id for the '<em>Fraction</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Fraction
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFraction()
	 * @generated
	 */
	int FRACTION = 56;

	/**
	 * The meta object id for the '<em>Freq Bias Factor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.FreqBiasFactor
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFreqBiasFactor()
	 * @generated
	 */
	int FREQ_BIAS_FACTOR = 57;

	/**
	 * The meta object id for the '<em>Frequency</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Frequency
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFrequency()
	 * @generated
	 */
	int FREQUENCY = 58;

	/**
	 * The meta object id for the '<em>Heat Per Hour</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.HeatPerHour
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getHeatPerHour()
	 * @generated
	 */
	int HEAT_PER_HOUR = 59;

	/**
	 * The meta object id for the '<em>Hours</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Hours
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getHours()
	 * @generated
	 */
	int HOURS = 60;

	/**
	 * The meta object id for the '<em>Inductance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Inductance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getInductance()
	 * @generated
	 */
	int INDUCTANCE = 61;

	/**
	 * The meta object id for the '<em>Inertia</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Inertia
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getInertia()
	 * @generated
	 */
	int INERTIA = 62;

	/**
	 * The meta object id for the '<em>Load</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Load
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getLoad()
	 * @generated
	 */
	int LOAD = 63;

	/**
	 * The meta object id for the '<em>Load Loss</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.LoadLoss
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getLoadLoss()
	 * @generated
	 */
	int LOAD_LOSS = 64;

	/**
	 * The meta object id for the '<em>Long Length</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.LongLength
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getLongLength()
	 * @generated
	 */
	int LONG_LENGTH = 65;

	/**
	 * The meta object id for the '<em>Money</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Money
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getMoney()
	 * @generated
	 */
	int MONEY = 66;

	/**
	 * The meta object id for the '<em>No Load Loss</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.NoLoadLoss
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getNoLoadLoss()
	 * @generated
	 */
	int NO_LOAD_LOSS = 67;

	/**
	 * The meta object id for the '<em>Operating Mode</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.string.OperatingMode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getOperatingMode()
	 * @generated
	 */
	int OPERATING_MODE = 68;

	/**
	 * The meta object id for the '<em>Participation Factor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.ParticipationFactor
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getParticipationFactor()
	 * @generated
	 */
	int PARTICIPATION_FACTOR = 69;

	/**
	 * The meta object id for the '<em>Penalty Factor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PenaltyFactor
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPenaltyFactor()
	 * @generated
	 */
	int PENALTY_FACTOR = 70;

	/**
	 * The meta object id for the '<em>Per Cent</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PerCent
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPerCent()
	 * @generated
	 */
	int PER_CENT = 71;

	/**
	 * The meta object id for the '<em>Angle Radians</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.AngleRadians
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAngleRadians()
	 * @generated
	 */
	int ANGLE_RADIANS = 72;

	/**
	 * The meta object id for the '<em>Power Factor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PowerFactor
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerFactor()
	 * @generated
	 */
	int POWER_FACTOR = 73;

	/**
	 * The meta object id for the '<em>Power ROC Per Min</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PowerROCPerMin
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerROCPerMin()
	 * @generated
	 */
	int POWER_ROC_PER_MIN = 74;

	/**
	 * The meta object id for the '<em>Power ROC Per Sec</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PowerROCPerSec
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerROCPerSec()
	 * @generated
	 */
	int POWER_ROC_PER_SEC = 75;

	/**
	 * The meta object id for the '<em>Power Versus Frequency</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PowerVersusFrequency
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerVersusFrequency()
	 * @generated
	 */
	int POWER_VERSUS_FREQUENCY = 76;

	/**
	 * The meta object id for the '<em>Power Versus Voltage</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PowerVersusVoltage
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerVersusVoltage()
	 * @generated
	 */
	int POWER_VERSUS_VOLTAGE = 77;

	/**
	 * The meta object id for the '<em>Pressure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Pressure
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPressure()
	 * @generated
	 */
	int PRESSURE = 78;

	/**
	 * The meta object id for the '<em>Priority</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.integer.Priority
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 79;

	/**
	 * The meta object id for the '<em>PU</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PU
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPU()
	 * @generated
	 */
	int PU = 80;

	/**
	 * The meta object id for the '<em>PUk VPer MV Ar</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.PUkVPerMVAr
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPUkVPerMVAr()
	 * @generated
	 */
	int PUK_VPER_MV_AR = 81;

	/**
	 * The meta object id for the '<em>Rate Of Change</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.RateOfChange
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRateOfChange()
	 * @generated
	 */
	int RATE_OF_CHANGE = 82;

	/**
	 * The meta object id for the '<em>Ratio</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Ratio
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRatio()
	 * @generated
	 */
	int RATIO = 83;

	/**
	 * The meta object id for the '<em>Reactance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Reactance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getReactance()
	 * @generated
	 */
	int REACTANCE = 84;

	/**
	 * The meta object id for the '<em>Reactive Power</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.ReactivePower
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getReactivePower()
	 * @generated
	 */
	int REACTIVE_POWER = 85;

	/**
	 * The meta object id for the '<em>Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.string.Reference
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 86;

	/**
	 * The meta object id for the '<em>Resistance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Resistance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getResistance()
	 * @generated
	 */
	int RESISTANCE = 87;

	/**
	 * The meta object id for the '<em>Seconds</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Seconds
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSeconds()
	 * @generated
	 */
	int SECONDS = 88;

	/**
	 * The meta object id for the '<em>Short Length</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.ShortLength
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getShortLength()
	 * @generated
	 */
	int SHORT_LENGTH = 89;

	/**
	 * The meta object id for the '<em>Tap Step</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.integer.TapStep
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTapStep()
	 * @generated
	 */
	int TAP_STEP = 90;

	/**
	 * The meta object id for the '<em>Temperature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Temperature
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTemperature()
	 * @generated
	 */
	int TEMPERATURE = 91;

	/**
	 * The meta object id for the '<em>Terminal Count</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.integer.TerminalCount
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTerminalCount()
	 * @generated
	 */
	int TERMINAL_COUNT = 92;

	/**
	 * The meta object id for the '<em>Terminal Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.integer.TerminalType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTerminalType()
	 * @generated
	 */
	int TERMINAL_TYPE = 93;

	/**
	 * The meta object id for the '<em>Voltage</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Voltage
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getVoltage()
	 * @generated
	 */
	int VOLTAGE = 94;

	/**
	 * The meta object id for the '<em>Volume</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Volume
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getVolume()
	 * @generated
	 */
	int VOLUME = 95;

	/**
	 * The meta object id for the '<em>Water Level</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.WaterLevel
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getWaterLevel()
	 * @generated
	 */
	int WATER_LEVEL = 96;

	/**
	 * The meta object id for the '<em>Phase Code</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.string.PhaseCode
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPhaseCode()
	 * @generated
	 */
	int PHASE_CODE = 97;

	/**
	 * The meta object id for the '<em>Admittance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Admittance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAdmittance()
	 * @generated
	 */
	int ADMITTANCE = 98;

	/**
	 * The meta object id for the '<em>Impedance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Impedance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getImpedance()
	 * @generated
	 */
	int IMPEDANCE = 99;

	/**
	 * The meta object id for the '<em>Conductance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Conductance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getConductance()
	 * @generated
	 */
	int CONDUCTANCE = 100;

	/**
	 * The meta object id for the '<em>Susceptance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.Susceptance
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSusceptance()
	 * @generated
	 */
	int SUSCEPTANCE = 101;

	/**
	 * The meta object id for the '<em>Composite Switch Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.string.CompositeSwitchType
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCompositeSwitchType()
	 * @generated
	 */
	int COMPOSITE_SWITCH_TYPE = 102;

	/**
	 * The meta object id for the '<em>Time Stamp</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.string.TimeStamp
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTimeStamp()
	 * @generated
	 */
	int TIME_STAMP = 103;

	/**
	 * The meta object id for the '<em>Voltage Per Reactive Power</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.datatype.real.VoltagePerReactivePower
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getVoltagePerReactivePower()
	 * @generated
	 */
	int VOLTAGE_PER_REACTIVE_POWER = 104;

	/**
	 * The meta object id for the '<em>Date</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Date
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 105;

	/**
	 * The meta object id for the '<em>Absolute Date Time</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Date
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAbsoluteDateTime()
	 * @generated
	 */
	int ABSOLUTE_DATE_TIME = 106;

	/**
	 * The meta object id for the '<em>Numeric</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getNumeric()
	 * @generated
	 */
	int NUMERIC = 107;


	/**
	 * The meta object id for the '<em>Java Class</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Class
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getJavaClass()
	 * @generated
	 */
	int JAVA_CLASS = 108;

	/**
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 109;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.domain.DomainVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.domain.DomainVersion
	 * @generated
	 */
	EClass getDomainVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.domain.DomainVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.domain.DomainVersion#getVersion()
	 * @see #getDomainVersion()
	 * @generated
	 */
	EAttribute getDomainVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.domain.DomainVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.domain.DomainVersion#getDate()
	 * @see #getDomainVersion()
	 * @generated
	 */
	EAttribute getDomainVersion_Date();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.BoilerControlMode <em>Boiler Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Boiler Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.domain.BoilerControlMode
	 * @generated
	 */
	EEnum getBoilerControlMode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.SwitchState <em>Switch State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Switch State</em>'.
	 * @see org.opencim.cim.iec61970.domain.SwitchState
	 * @generated
	 */
	EEnum getSwitchState();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.TemperatureUnits <em>Temperature Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Temperature Units</em>'.
	 * @see org.opencim.cim.iec61970.domain.TemperatureUnits
	 * @generated
	 */
	EEnum getTemperatureUnits();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.WindingType <em>Winding Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Winding Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.WindingType
	 * @generated
	 */
	EEnum getWindingType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.WindingConnection <em>Winding Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Winding Connection</em>'.
	 * @see org.opencim.cim.iec61970.domain.WindingConnection
	 * @generated
	 */
	EEnum getWindingConnection();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.SeasonName <em>Season Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Season Name</em>'.
	 * @see org.opencim.cim.iec61970.domain.SeasonName
	 * @generated
	 */
	EEnum getSeasonName();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.DayTypeName <em>Day Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Day Type Name</em>'.
	 * @see org.opencim.cim.iec61970.domain.DayTypeName
	 * @generated
	 */
	EEnum getDayTypeName();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.BreakerConfiguration <em>Breaker Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Breaker Configuration</em>'.
	 * @see org.opencim.cim.iec61970.domain.BreakerConfiguration
	 * @generated
	 */
	EEnum getBreakerConfiguration();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.BusbarConfiguration <em>Busbar Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Busbar Configuration</em>'.
	 * @see org.opencim.cim.iec61970.domain.BusbarConfiguration
	 * @generated
	 */
	EEnum getBusbarConfiguration();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.CompanyType <em>Company Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Company Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.CompanyType
	 * @generated
	 */
	EEnum getCompanyType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.CoolantType <em>Coolant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Coolant Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.CoolantType
	 * @generated
	 */
	EEnum getCoolantType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.CurveStyle <em>Curve Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Curve Style</em>'.
	 * @see org.opencim.cim.iec61970.domain.CurveStyle
	 * @generated
	 */
	EEnum getCurveStyle();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.EmissionType <em>Emission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Emission Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.EmissionType
	 * @generated
	 */
	EEnum getEmissionType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.EmissionValueSource <em>Emission Value Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Emission Value Source</em>'.
	 * @see org.opencim.cim.iec61970.domain.EmissionValueSource
	 * @generated
	 */
	EEnum getEmissionValueSource();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.FuelType <em>Fuel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fuel Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.FuelType
	 * @generated
	 */
	EEnum getFuelType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.PenstockType <em>Penstock Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Penstock Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.PenstockType
	 * @generated
	 */
	EEnum getPenstockType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.RampMethod <em>Ramp Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ramp Method</em>'.
	 * @see org.opencim.cim.iec61970.domain.RampMethod
	 * @generated
	 */
	EEnum getRampMethod();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.RampStartMethod <em>Ramp Start Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ramp Start Method</em>'.
	 * @see org.opencim.cim.iec61970.domain.RampStartMethod
	 * @generated
	 */
	EEnum getRampStartMethod();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.RampUnits <em>Ramp Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ramp Units</em>'.
	 * @see org.opencim.cim.iec61970.domain.RampUnits
	 * @generated
	 */
	EEnum getRampUnits();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.SpillwayGateType <em>Spillway Gate Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Spillway Gate Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.SpillwayGateType
	 * @generated
	 */
	EEnum getSpillwayGateType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.SurgeTankCode <em>Surge Tank Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Surge Tank Code</em>'.
	 * @see org.opencim.cim.iec61970.domain.SurgeTankCode
	 * @generated
	 */
	EEnum getSurgeTankCode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.TransformerCoolingType <em>Transformer Cooling Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transformer Cooling Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.TransformerCoolingType
	 * @generated
	 */
	EEnum getTransformerCoolingType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.TurbineType <em>Turbine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Turbine Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.TurbineType
	 * @generated
	 */
	EEnum getTurbineType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.YAxisType <em>YAxis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>YAxis Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.YAxisType
	 * @generated
	 */
	EEnum getYAxisType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.AxisQuantity <em>Axis Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Axis Quantity</em>'.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @generated
	 */
	EEnum getAxisQuantity();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.HydroPlantType <em>Hydro Plant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Hydro Plant Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.HydroPlantType
	 * @generated
	 */
	EEnum getHydroPlantType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Numeric Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.NumericType
	 * @generated
	 */
	EEnum getNumericType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.TransformerType <em>Transformer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transformer Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.TransformerType
	 * @generated
	 */
	EEnum getTransformerType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.CompensatorType <em>Compensator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compensator Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.CompensatorType
	 * @generated
	 */
	EEnum getCompensatorType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.Validity <em>Validity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validity</em>'.
	 * @see org.opencim.cim.iec61970.domain.Validity
	 * @generated
	 */
	EEnum getValidity();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.Source <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Source</em>'.
	 * @see org.opencim.cim.iec61970.domain.Source
	 * @generated
	 */
	EEnum getSource();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.RemoteUnitType <em>Remote Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Remote Unit Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.RemoteUnitType
	 * @generated
	 */
	EEnum getRemoteUnitType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode <em>Synchronous Machine Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronous Machine Operating Mode</em>'.
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode
	 * @generated
	 */
	EEnum getSynchronousMachineOperatingMode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.SynchronousMachineType <em>Synchronous Machine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronous Machine Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.SynchronousMachineType
	 * @generated
	 */
	EEnum getSynchronousMachineType();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.TransformerControlMode <em>Transformer Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transformer Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.domain.TransformerControlMode
	 * @generated
	 */
	EEnum getTransformerControlMode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.GeneratorOperatingMode <em>Generator Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Generator Operating Mode</em>'.
	 * @see org.opencim.cim.iec61970.domain.GeneratorOperatingMode
	 * @generated
	 */
	EEnum getGeneratorOperatingMode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.GeneratorControlMode <em>Generator Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Generator Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlMode
	 * @generated
	 */
	EEnum getGeneratorControlMode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.GeneratorControlSource <em>Generator Control Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Generator Control Source</em>'.
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlSource
	 * @generated
	 */
	EEnum getGeneratorControlSource();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.AreaControlMode <em>Area Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Area Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.domain.AreaControlMode
	 * @generated
	 */
	EEnum getAreaControlMode();

	/**
	 * Returns the meta object for enum '{@link org.opencim.cim.iec61970.domain.ControlHouseEquipmentType <em>Control House Equipment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Control House Equipment Type</em>'.
	 * @see org.opencim.cim.iec61970.domain.ControlHouseEquipmentType
	 * @generated
	 */
	EEnum getControlHouseEquipmentType();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.ActivePower <em>Active Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Active Power</em>'.
	 * @see org.opencim.datatype.real.ActivePower
	 * @model instanceClass="org.opencim.datatype.real.ActivePower"
	 * @generated
	 */
	EDataType getActivePower();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.ApparentPower <em>Apparent Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Apparent Power</em>'.
	 * @see org.opencim.datatype.real.ApparentPower
	 * @model instanceClass="org.opencim.datatype.real.ApparentPower"
	 * @generated
	 */
	EDataType getApparentPower();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.integer.Classification <em>Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Classification</em>'.
	 * @see org.opencim.datatype.integer.Classification
	 * @model instanceClass="org.opencim.datatype.integer.Classification"
	 * @generated
	 */
	EDataType getClassification();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.string.ControlMode <em>Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Control Mode</em>'.
	 * @see org.opencim.datatype.string.ControlMode
	 * @model instanceClass="org.opencim.datatype.string.ControlMode"
	 * @generated
	 */
	EDataType getControlMode();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.CostPerEnergyUnit <em>Cost Per Energy Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Cost Per Energy Unit</em>'.
	 * @see org.opencim.datatype.real.CostPerEnergyUnit
	 * @model instanceClass="org.opencim.datatype.real.CostPerEnergyUnit"
	 * @generated
	 */
	EDataType getCostPerEnergyUnit();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.CostPerHeatUnit <em>Cost Per Heat Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Cost Per Heat Unit</em>'.
	 * @see org.opencim.datatype.real.CostPerHeatUnit
	 * @model instanceClass="org.opencim.datatype.real.CostPerHeatUnit"
	 * @generated
	 */
	EDataType getCostPerHeatUnit();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.CostPerHour <em>Cost Per Hour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Cost Per Hour</em>'.
	 * @see org.opencim.datatype.real.CostPerHour
	 * @model instanceClass="org.opencim.datatype.real.CostPerHour"
	 * @generated
	 */
	EDataType getCostPerHour();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.integer.Counter <em>Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Counter</em>'.
	 * @see org.opencim.datatype.integer.Counter
	 * @model instanceClass="org.opencim.datatype.integer.Counter"
	 * @generated
	 */
	EDataType getCounter();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.CurrentFlow <em>Current Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Current Flow</em>'.
	 * @see org.opencim.datatype.real.CurrentFlow
	 * @model instanceClass="org.opencim.datatype.real.CurrentFlow"
	 * @generated
	 */
	EDataType getCurrentFlow();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Damping <em>Damping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Damping</em>'.
	 * @see org.opencim.datatype.real.Damping
	 * @model instanceClass="org.opencim.datatype.real.Damping"
	 * @generated
	 */
	EDataType getDamping();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.AngleDegrees <em>Angle Degrees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Angle Degrees</em>'.
	 * @see org.opencim.datatype.real.AngleDegrees
	 * @model instanceClass="org.opencim.datatype.real.AngleDegrees"
	 * @generated
	 */
	EDataType getAngleDegrees();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Emission <em>Emission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Emission</em>'.
	 * @see org.opencim.datatype.real.Emission
	 * @model instanceClass="org.opencim.datatype.real.Emission"
	 * @generated
	 */
	EDataType getEmission();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.EnergyAsMWh <em>Energy As MWh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Energy As MWh</em>'.
	 * @see org.opencim.datatype.real.EnergyAsMWh
	 * @model instanceClass="org.opencim.datatype.real.EnergyAsMWh"
	 * @generated
	 */
	EDataType getEnergyAsMWh();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.ExcitingCurrent <em>Exciting Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exciting Current</em>'.
	 * @see org.opencim.datatype.real.ExcitingCurrent
	 * @model instanceClass="org.opencim.datatype.real.ExcitingCurrent"
	 * @generated
	 */
	EDataType getExcitingCurrent();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Exponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exponent</em>'.
	 * @see org.opencim.datatype.real.Exponent
	 * @model instanceClass="org.opencim.datatype.real.Exponent"
	 * @generated
	 */
	EDataType getExponent();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Fraction <em>Fraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Fraction</em>'.
	 * @see org.opencim.datatype.real.Fraction
	 * @model instanceClass="org.opencim.datatype.real.Fraction"
	 * @generated
	 */
	EDataType getFraction();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.FreqBiasFactor <em>Freq Bias Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Freq Bias Factor</em>'.
	 * @see org.opencim.datatype.real.FreqBiasFactor
	 * @model instanceClass="org.opencim.datatype.real.FreqBiasFactor"
	 * @generated
	 */
	EDataType getFreqBiasFactor();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Frequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Frequency</em>'.
	 * @see org.opencim.datatype.real.Frequency
	 * @model instanceClass="org.opencim.datatype.real.Frequency"
	 * @generated
	 */
	EDataType getFrequency();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.HeatPerHour <em>Heat Per Hour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Heat Per Hour</em>'.
	 * @see org.opencim.datatype.real.HeatPerHour
	 * @model instanceClass="org.opencim.datatype.real.HeatPerHour"
	 * @generated
	 */
	EDataType getHeatPerHour();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Hours <em>Hours</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Hours</em>'.
	 * @see org.opencim.datatype.real.Hours
	 * @model instanceClass="org.opencim.datatype.real.Hours"
	 * @generated
	 */
	EDataType getHours();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Inductance <em>Inductance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Inductance</em>'.
	 * @see org.opencim.datatype.real.Inductance
	 * @model instanceClass="org.opencim.datatype.real.Inductance"
	 * @generated
	 */
	EDataType getInductance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Inertia <em>Inertia</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Inertia</em>'.
	 * @see org.opencim.datatype.real.Inertia
	 * @model instanceClass="org.opencim.datatype.real.Inertia"
	 * @generated
	 */
	EDataType getInertia();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Load <em>Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Load</em>'.
	 * @see org.opencim.datatype.real.Load
	 * @model instanceClass="org.opencim.datatype.real.Load"
	 * @generated
	 */
	EDataType getLoad();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.LoadLoss <em>Load Loss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Load Loss</em>'.
	 * @see org.opencim.datatype.real.LoadLoss
	 * @model instanceClass="org.opencim.datatype.real.LoadLoss"
	 * @generated
	 */
	EDataType getLoadLoss();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.LongLength <em>Long Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Long Length</em>'.
	 * @see org.opencim.datatype.real.LongLength
	 * @model instanceClass="org.opencim.datatype.real.LongLength"
	 * @generated
	 */
	EDataType getLongLength();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Money <em>Money</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Money</em>'.
	 * @see org.opencim.datatype.real.Money
	 * @model instanceClass="org.opencim.datatype.real.Money"
	 * @generated
	 */
	EDataType getMoney();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.NoLoadLoss <em>No Load Loss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>No Load Loss</em>'.
	 * @see org.opencim.datatype.real.NoLoadLoss
	 * @model instanceClass="org.opencim.datatype.real.NoLoadLoss"
	 * @generated
	 */
	EDataType getNoLoadLoss();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.string.OperatingMode <em>Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Operating Mode</em>'.
	 * @see org.opencim.datatype.string.OperatingMode
	 * @model instanceClass="org.opencim.datatype.string.OperatingMode"
	 * @generated
	 */
	EDataType getOperatingMode();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.ParticipationFactor <em>Participation Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Participation Factor</em>'.
	 * @see org.opencim.datatype.real.ParticipationFactor
	 * @model instanceClass="org.opencim.datatype.real.ParticipationFactor"
	 * @generated
	 */
	EDataType getParticipationFactor();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PenaltyFactor <em>Penalty Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Penalty Factor</em>'.
	 * @see org.opencim.datatype.real.PenaltyFactor
	 * @model instanceClass="org.opencim.datatype.real.PenaltyFactor"
	 * @generated
	 */
	EDataType getPenaltyFactor();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PerCent <em>Per Cent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Per Cent</em>'.
	 * @see org.opencim.datatype.real.PerCent
	 * @model instanceClass="org.opencim.datatype.real.PerCent"
	 * @generated
	 */
	EDataType getPerCent();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.AngleRadians <em>Angle Radians</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Angle Radians</em>'.
	 * @see org.opencim.datatype.real.AngleRadians
	 * @model instanceClass="org.opencim.datatype.real.AngleRadians"
	 * @generated
	 */
	EDataType getAngleRadians();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PowerFactor <em>Power Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Power Factor</em>'.
	 * @see org.opencim.datatype.real.PowerFactor
	 * @model instanceClass="org.opencim.datatype.real.PowerFactor"
	 * @generated
	 */
	EDataType getPowerFactor();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PowerROCPerMin <em>Power ROC Per Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Power ROC Per Min</em>'.
	 * @see org.opencim.datatype.real.PowerROCPerMin
	 * @model instanceClass="org.opencim.datatype.real.PowerROCPerMin"
	 * @generated
	 */
	EDataType getPowerROCPerMin();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PowerROCPerSec <em>Power ROC Per Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Power ROC Per Sec</em>'.
	 * @see org.opencim.datatype.real.PowerROCPerSec
	 * @model instanceClass="org.opencim.datatype.real.PowerROCPerSec"
	 * @generated
	 */
	EDataType getPowerROCPerSec();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PowerVersusFrequency <em>Power Versus Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Power Versus Frequency</em>'.
	 * @see org.opencim.datatype.real.PowerVersusFrequency
	 * @model instanceClass="org.opencim.datatype.real.PowerVersusFrequency"
	 * @generated
	 */
	EDataType getPowerVersusFrequency();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PowerVersusVoltage <em>Power Versus Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Power Versus Voltage</em>'.
	 * @see org.opencim.datatype.real.PowerVersusVoltage
	 * @model instanceClass="org.opencim.datatype.real.PowerVersusVoltage"
	 * @generated
	 */
	EDataType getPowerVersusVoltage();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Pressure <em>Pressure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pressure</em>'.
	 * @see org.opencim.datatype.real.Pressure
	 * @model instanceClass="org.opencim.datatype.real.Pressure"
	 * @generated
	 */
	EDataType getPressure();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.integer.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Priority</em>'.
	 * @see org.opencim.datatype.integer.Priority
	 * @model instanceClass="org.opencim.datatype.integer.Priority"
	 * @generated
	 */
	EDataType getPriority();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PU <em>PU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>PU</em>'.
	 * @see org.opencim.datatype.real.PU
	 * @model instanceClass="org.opencim.datatype.real.PU"
	 * @generated
	 */
	EDataType getPU();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.PUkVPerMVAr <em>PUk VPer MV Ar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>PUk VPer MV Ar</em>'.
	 * @see org.opencim.datatype.real.PUkVPerMVAr
	 * @model instanceClass="org.opencim.datatype.real.PUkVPerMVAr"
	 * @generated
	 */
	EDataType getPUkVPerMVAr();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.RateOfChange <em>Rate Of Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rate Of Change</em>'.
	 * @see org.opencim.datatype.real.RateOfChange
	 * @model instanceClass="org.opencim.datatype.real.RateOfChange"
	 * @generated
	 */
	EDataType getRateOfChange();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Ratio <em>Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ratio</em>'.
	 * @see org.opencim.datatype.real.Ratio
	 * @model instanceClass="org.opencim.datatype.real.Ratio"
	 * @generated
	 */
	EDataType getRatio();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Reactance <em>Reactance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reactance</em>'.
	 * @see org.opencim.datatype.real.Reactance
	 * @model instanceClass="org.opencim.datatype.real.Reactance"
	 * @generated
	 */
	EDataType getReactance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.ReactivePower <em>Reactive Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reactive Power</em>'.
	 * @see org.opencim.datatype.real.ReactivePower
	 * @model instanceClass="org.opencim.datatype.real.ReactivePower"
	 * @generated
	 */
	EDataType getReactivePower();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.string.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reference</em>'.
	 * @see org.opencim.datatype.string.Reference
	 * @model instanceClass="org.opencim.datatype.string.Reference"
	 * @generated
	 */
	EDataType getReference();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Resistance <em>Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resistance</em>'.
	 * @see org.opencim.datatype.real.Resistance
	 * @model instanceClass="org.opencim.datatype.real.Resistance"
	 * @generated
	 */
	EDataType getResistance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Seconds <em>Seconds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Seconds</em>'.
	 * @see org.opencim.datatype.real.Seconds
	 * @model instanceClass="org.opencim.datatype.real.Seconds"
	 * @generated
	 */
	EDataType getSeconds();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.ShortLength <em>Short Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Short Length</em>'.
	 * @see org.opencim.datatype.real.ShortLength
	 * @model instanceClass="org.opencim.datatype.real.ShortLength"
	 * @generated
	 */
	EDataType getShortLength();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.integer.TapStep <em>Tap Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Tap Step</em>'.
	 * @see org.opencim.datatype.integer.TapStep
	 * @model instanceClass="org.opencim.datatype.integer.TapStep"
	 * @generated
	 */
	EDataType getTapStep();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Temperature <em>Temperature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Temperature</em>'.
	 * @see org.opencim.datatype.real.Temperature
	 * @model instanceClass="org.opencim.datatype.real.Temperature"
	 * @generated
	 */
	EDataType getTemperature();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.integer.TerminalCount <em>Terminal Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Terminal Count</em>'.
	 * @see org.opencim.datatype.integer.TerminalCount
	 * @model instanceClass="org.opencim.datatype.integer.TerminalCount"
	 * @generated
	 */
	EDataType getTerminalCount();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.integer.TerminalType <em>Terminal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Terminal Type</em>'.
	 * @see org.opencim.datatype.integer.TerminalType
	 * @model instanceClass="org.opencim.datatype.integer.TerminalType"
	 * @generated
	 */
	EDataType getTerminalType();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Voltage <em>Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Voltage</em>'.
	 * @see org.opencim.datatype.real.Voltage
	 * @model instanceClass="org.opencim.datatype.real.Voltage"
	 * @generated
	 */
	EDataType getVoltage();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Volume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Volume</em>'.
	 * @see org.opencim.datatype.real.Volume
	 * @model instanceClass="org.opencim.datatype.real.Volume"
	 * @generated
	 */
	EDataType getVolume();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.WaterLevel <em>Water Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Water Level</em>'.
	 * @see org.opencim.datatype.real.WaterLevel
	 * @model instanceClass="org.opencim.datatype.real.WaterLevel"
	 * @generated
	 */
	EDataType getWaterLevel();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.string.PhaseCode <em>Phase Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Phase Code</em>'.
	 * @see org.opencim.datatype.string.PhaseCode
	 * @model instanceClass="org.opencim.datatype.string.PhaseCode"
	 * @generated
	 */
	EDataType getPhaseCode();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Admittance <em>Admittance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Admittance</em>'.
	 * @see org.opencim.datatype.real.Admittance
	 * @model instanceClass="org.opencim.datatype.real.Admittance"
	 * @generated
	 */
	EDataType getAdmittance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Impedance <em>Impedance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Impedance</em>'.
	 * @see org.opencim.datatype.real.Impedance
	 * @model instanceClass="org.opencim.datatype.real.Impedance"
	 * @generated
	 */
	EDataType getImpedance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Conductance <em>Conductance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Conductance</em>'.
	 * @see org.opencim.datatype.real.Conductance
	 * @model instanceClass="org.opencim.datatype.real.Conductance"
	 * @generated
	 */
	EDataType getConductance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.Susceptance <em>Susceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Susceptance</em>'.
	 * @see org.opencim.datatype.real.Susceptance
	 * @model instanceClass="org.opencim.datatype.real.Susceptance"
	 * @generated
	 */
	EDataType getSusceptance();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.string.CompositeSwitchType <em>Composite Switch Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Composite Switch Type</em>'.
	 * @see org.opencim.datatype.string.CompositeSwitchType
	 * @model instanceClass="org.opencim.datatype.string.CompositeSwitchType"
	 * @generated
	 */
	EDataType getCompositeSwitchType();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.string.TimeStamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Time Stamp</em>'.
	 * @see org.opencim.datatype.string.TimeStamp
	 * @model instanceClass="org.opencim.datatype.string.TimeStamp"
	 * @generated
	 */
	EDataType getTimeStamp();

	/**
	 * Returns the meta object for data type '{@link org.opencim.datatype.real.VoltagePerReactivePower <em>Voltage Per Reactive Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Voltage Per Reactive Power</em>'.
	 * @see org.opencim.datatype.real.VoltagePerReactivePower
	 * @model instanceClass="org.opencim.datatype.real.VoltagePerReactivePower"
	 * @generated
	 */
	EDataType getVoltagePerReactivePower();

	/**
	 * Returns the meta object for data type '{@link java.util.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date</em>'.
	 * @see java.util.Date
	 * @model instanceClass="java.util.Date"
	 * @generated
	 */
	EDataType getDate();

	/**
	 * Returns the meta object for data type '{@link java.util.Date <em>Absolute Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Absolute Date Time</em>'.
	 * @see java.util.Date
	 * @model instanceClass="java.util.Date"
	 * @generated
	 */
	EDataType getAbsoluteDateTime();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Numeric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Numeric</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getNumeric();

	/**
	 * Returns the meta object for data type '{@link java.lang.Class <em>Java Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Class</em>'.
	 * @see java.lang.Class
	 * @model instanceClass="java.lang.Class"
	 * @generated
	 */
	EDataType getJavaClass();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Java Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJavaObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainFactory getDomainFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.impl.DomainVersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.impl.DomainVersionImpl
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDomainVersion()
		 * @generated
		 */
		EClass DOMAIN_VERSION = eINSTANCE.getDomainVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_VERSION__VERSION = eINSTANCE.getDomainVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_VERSION__DATE = eINSTANCE.getDomainVersion_Date();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.BoilerControlMode <em>Boiler Control Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.BoilerControlMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getBoilerControlMode()
		 * @generated
		 */
		EEnum BOILER_CONTROL_MODE = eINSTANCE.getBoilerControlMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.SwitchState <em>Switch State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.SwitchState
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSwitchState()
		 * @generated
		 */
		EEnum SWITCH_STATE = eINSTANCE.getSwitchState();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.TemperatureUnits <em>Temperature Units</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.TemperatureUnits
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTemperatureUnits()
		 * @generated
		 */
		EEnum TEMPERATURE_UNITS = eINSTANCE.getTemperatureUnits();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.WindingType <em>Winding Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.WindingType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getWindingType()
		 * @generated
		 */
		EEnum WINDING_TYPE = eINSTANCE.getWindingType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.WindingConnection <em>Winding Connection</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.WindingConnection
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getWindingConnection()
		 * @generated
		 */
		EEnum WINDING_CONNECTION = eINSTANCE.getWindingConnection();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.SeasonName <em>Season Name</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.SeasonName
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSeasonName()
		 * @generated
		 */
		EEnum SEASON_NAME = eINSTANCE.getSeasonName();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.DayTypeName <em>Day Type Name</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.DayTypeName
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDayTypeName()
		 * @generated
		 */
		EEnum DAY_TYPE_NAME = eINSTANCE.getDayTypeName();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.BreakerConfiguration <em>Breaker Configuration</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.BreakerConfiguration
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getBreakerConfiguration()
		 * @generated
		 */
		EEnum BREAKER_CONFIGURATION = eINSTANCE.getBreakerConfiguration();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.BusbarConfiguration <em>Busbar Configuration</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.BusbarConfiguration
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getBusbarConfiguration()
		 * @generated
		 */
		EEnum BUSBAR_CONFIGURATION = eINSTANCE.getBusbarConfiguration();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.CompanyType <em>Company Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.CompanyType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCompanyType()
		 * @generated
		 */
		EEnum COMPANY_TYPE = eINSTANCE.getCompanyType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.CoolantType <em>Coolant Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.CoolantType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCoolantType()
		 * @generated
		 */
		EEnum COOLANT_TYPE = eINSTANCE.getCoolantType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.CurveStyle <em>Curve Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.CurveStyle
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCurveStyle()
		 * @generated
		 */
		EEnum CURVE_STYLE = eINSTANCE.getCurveStyle();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.EmissionType <em>Emission Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.EmissionType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEmissionType()
		 * @generated
		 */
		EEnum EMISSION_TYPE = eINSTANCE.getEmissionType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.EmissionValueSource <em>Emission Value Source</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.EmissionValueSource
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEmissionValueSource()
		 * @generated
		 */
		EEnum EMISSION_VALUE_SOURCE = eINSTANCE.getEmissionValueSource();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.FuelType <em>Fuel Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.FuelType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFuelType()
		 * @generated
		 */
		EEnum FUEL_TYPE = eINSTANCE.getFuelType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.PenstockType <em>Penstock Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.PenstockType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPenstockType()
		 * @generated
		 */
		EEnum PENSTOCK_TYPE = eINSTANCE.getPenstockType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.RampMethod <em>Ramp Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.RampMethod
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRampMethod()
		 * @generated
		 */
		EEnum RAMP_METHOD = eINSTANCE.getRampMethod();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.RampStartMethod <em>Ramp Start Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.RampStartMethod
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRampStartMethod()
		 * @generated
		 */
		EEnum RAMP_START_METHOD = eINSTANCE.getRampStartMethod();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.RampUnits <em>Ramp Units</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.RampUnits
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRampUnits()
		 * @generated
		 */
		EEnum RAMP_UNITS = eINSTANCE.getRampUnits();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.SpillwayGateType <em>Spillway Gate Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.SpillwayGateType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSpillwayGateType()
		 * @generated
		 */
		EEnum SPILLWAY_GATE_TYPE = eINSTANCE.getSpillwayGateType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.SurgeTankCode <em>Surge Tank Code</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.SurgeTankCode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSurgeTankCode()
		 * @generated
		 */
		EEnum SURGE_TANK_CODE = eINSTANCE.getSurgeTankCode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.TransformerCoolingType <em>Transformer Cooling Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.TransformerCoolingType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTransformerCoolingType()
		 * @generated
		 */
		EEnum TRANSFORMER_COOLING_TYPE = eINSTANCE.getTransformerCoolingType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.TurbineType <em>Turbine Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.TurbineType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTurbineType()
		 * @generated
		 */
		EEnum TURBINE_TYPE = eINSTANCE.getTurbineType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.YAxisType <em>YAxis Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.YAxisType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getYAxisType()
		 * @generated
		 */
		EEnum YAXIS_TYPE = eINSTANCE.getYAxisType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.AxisQuantity <em>Axis Quantity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.AxisQuantity
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAxisQuantity()
		 * @generated
		 */
		EEnum AXIS_QUANTITY = eINSTANCE.getAxisQuantity();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.HydroPlantType <em>Hydro Plant Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.HydroPlantType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getHydroPlantType()
		 * @generated
		 */
		EEnum HYDRO_PLANT_TYPE = eINSTANCE.getHydroPlantType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.NumericType <em>Numeric Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.NumericType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getNumericType()
		 * @generated
		 */
		EEnum NUMERIC_TYPE = eINSTANCE.getNumericType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.TransformerType <em>Transformer Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.TransformerType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTransformerType()
		 * @generated
		 */
		EEnum TRANSFORMER_TYPE = eINSTANCE.getTransformerType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.CompensatorType <em>Compensator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.CompensatorType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCompensatorType()
		 * @generated
		 */
		EEnum COMPENSATOR_TYPE = eINSTANCE.getCompensatorType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.Validity <em>Validity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.Validity
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getValidity()
		 * @generated
		 */
		EEnum VALIDITY = eINSTANCE.getValidity();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.Source <em>Source</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.Source
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSource()
		 * @generated
		 */
		EEnum SOURCE = eINSTANCE.getSource();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.RemoteUnitType <em>Remote Unit Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.RemoteUnitType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRemoteUnitType()
		 * @generated
		 */
		EEnum REMOTE_UNIT_TYPE = eINSTANCE.getRemoteUnitType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode <em>Synchronous Machine Operating Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSynchronousMachineOperatingMode()
		 * @generated
		 */
		EEnum SYNCHRONOUS_MACHINE_OPERATING_MODE = eINSTANCE.getSynchronousMachineOperatingMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.SynchronousMachineType <em>Synchronous Machine Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.SynchronousMachineType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSynchronousMachineType()
		 * @generated
		 */
		EEnum SYNCHRONOUS_MACHINE_TYPE = eINSTANCE.getSynchronousMachineType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.TransformerControlMode <em>Transformer Control Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.TransformerControlMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTransformerControlMode()
		 * @generated
		 */
		EEnum TRANSFORMER_CONTROL_MODE = eINSTANCE.getTransformerControlMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.GeneratorOperatingMode <em>Generator Operating Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.GeneratorOperatingMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getGeneratorOperatingMode()
		 * @generated
		 */
		EEnum GENERATOR_OPERATING_MODE = eINSTANCE.getGeneratorOperatingMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.GeneratorControlMode <em>Generator Control Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.GeneratorControlMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getGeneratorControlMode()
		 * @generated
		 */
		EEnum GENERATOR_CONTROL_MODE = eINSTANCE.getGeneratorControlMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.GeneratorControlSource <em>Generator Control Source</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.GeneratorControlSource
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getGeneratorControlSource()
		 * @generated
		 */
		EEnum GENERATOR_CONTROL_SOURCE = eINSTANCE.getGeneratorControlSource();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.AreaControlMode <em>Area Control Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.AreaControlMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAreaControlMode()
		 * @generated
		 */
		EEnum AREA_CONTROL_MODE = eINSTANCE.getAreaControlMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.domain.ControlHouseEquipmentType <em>Control House Equipment Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.domain.ControlHouseEquipmentType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getControlHouseEquipmentType()
		 * @generated
		 */
		EEnum CONTROL_HOUSE_EQUIPMENT_TYPE = eINSTANCE.getControlHouseEquipmentType();

		/**
		 * The meta object literal for the '<em>Active Power</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.ActivePower
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getActivePower()
		 * @generated
		 */
		EDataType ACTIVE_POWER = eINSTANCE.getActivePower();

		/**
		 * The meta object literal for the '<em>Apparent Power</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.ApparentPower
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getApparentPower()
		 * @generated
		 */
		EDataType APPARENT_POWER = eINSTANCE.getApparentPower();

		/**
		 * The meta object literal for the '<em>Classification</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.integer.Classification
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getClassification()
		 * @generated
		 */
		EDataType CLASSIFICATION = eINSTANCE.getClassification();

		/**
		 * The meta object literal for the '<em>Control Mode</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.string.ControlMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getControlMode()
		 * @generated
		 */
		EDataType CONTROL_MODE = eINSTANCE.getControlMode();

		/**
		 * The meta object literal for the '<em>Cost Per Energy Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.CostPerEnergyUnit
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCostPerEnergyUnit()
		 * @generated
		 */
		EDataType COST_PER_ENERGY_UNIT = eINSTANCE.getCostPerEnergyUnit();

		/**
		 * The meta object literal for the '<em>Cost Per Heat Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.CostPerHeatUnit
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCostPerHeatUnit()
		 * @generated
		 */
		EDataType COST_PER_HEAT_UNIT = eINSTANCE.getCostPerHeatUnit();

		/**
		 * The meta object literal for the '<em>Cost Per Hour</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.CostPerHour
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCostPerHour()
		 * @generated
		 */
		EDataType COST_PER_HOUR = eINSTANCE.getCostPerHour();

		/**
		 * The meta object literal for the '<em>Counter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.integer.Counter
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCounter()
		 * @generated
		 */
		EDataType COUNTER = eINSTANCE.getCounter();

		/**
		 * The meta object literal for the '<em>Current Flow</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.CurrentFlow
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCurrentFlow()
		 * @generated
		 */
		EDataType CURRENT_FLOW = eINSTANCE.getCurrentFlow();

		/**
		 * The meta object literal for the '<em>Damping</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Damping
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDamping()
		 * @generated
		 */
		EDataType DAMPING = eINSTANCE.getDamping();

		/**
		 * The meta object literal for the '<em>Angle Degrees</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.AngleDegrees
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAngleDegrees()
		 * @generated
		 */
		EDataType ANGLE_DEGREES = eINSTANCE.getAngleDegrees();

		/**
		 * The meta object literal for the '<em>Emission</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Emission
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEmission()
		 * @generated
		 */
		EDataType EMISSION = eINSTANCE.getEmission();

		/**
		 * The meta object literal for the '<em>Energy As MWh</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.EnergyAsMWh
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getEnergyAsMWh()
		 * @generated
		 */
		EDataType ENERGY_AS_MWH = eINSTANCE.getEnergyAsMWh();

		/**
		 * The meta object literal for the '<em>Exciting Current</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.ExcitingCurrent
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getExcitingCurrent()
		 * @generated
		 */
		EDataType EXCITING_CURRENT = eINSTANCE.getExcitingCurrent();

		/**
		 * The meta object literal for the '<em>Exponent</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Exponent
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getExponent()
		 * @generated
		 */
		EDataType EXPONENT = eINSTANCE.getExponent();

		/**
		 * The meta object literal for the '<em>Fraction</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Fraction
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFraction()
		 * @generated
		 */
		EDataType FRACTION = eINSTANCE.getFraction();

		/**
		 * The meta object literal for the '<em>Freq Bias Factor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.FreqBiasFactor
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFreqBiasFactor()
		 * @generated
		 */
		EDataType FREQ_BIAS_FACTOR = eINSTANCE.getFreqBiasFactor();

		/**
		 * The meta object literal for the '<em>Frequency</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Frequency
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getFrequency()
		 * @generated
		 */
		EDataType FREQUENCY = eINSTANCE.getFrequency();

		/**
		 * The meta object literal for the '<em>Heat Per Hour</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.HeatPerHour
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getHeatPerHour()
		 * @generated
		 */
		EDataType HEAT_PER_HOUR = eINSTANCE.getHeatPerHour();

		/**
		 * The meta object literal for the '<em>Hours</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Hours
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getHours()
		 * @generated
		 */
		EDataType HOURS = eINSTANCE.getHours();

		/**
		 * The meta object literal for the '<em>Inductance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Inductance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getInductance()
		 * @generated
		 */
		EDataType INDUCTANCE = eINSTANCE.getInductance();

		/**
		 * The meta object literal for the '<em>Inertia</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Inertia
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getInertia()
		 * @generated
		 */
		EDataType INERTIA = eINSTANCE.getInertia();

		/**
		 * The meta object literal for the '<em>Load</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Load
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getLoad()
		 * @generated
		 */
		EDataType LOAD = eINSTANCE.getLoad();

		/**
		 * The meta object literal for the '<em>Load Loss</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.LoadLoss
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getLoadLoss()
		 * @generated
		 */
		EDataType LOAD_LOSS = eINSTANCE.getLoadLoss();

		/**
		 * The meta object literal for the '<em>Long Length</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.LongLength
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getLongLength()
		 * @generated
		 */
		EDataType LONG_LENGTH = eINSTANCE.getLongLength();

		/**
		 * The meta object literal for the '<em>Money</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Money
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getMoney()
		 * @generated
		 */
		EDataType MONEY = eINSTANCE.getMoney();

		/**
		 * The meta object literal for the '<em>No Load Loss</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.NoLoadLoss
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getNoLoadLoss()
		 * @generated
		 */
		EDataType NO_LOAD_LOSS = eINSTANCE.getNoLoadLoss();

		/**
		 * The meta object literal for the '<em>Operating Mode</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.string.OperatingMode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getOperatingMode()
		 * @generated
		 */
		EDataType OPERATING_MODE = eINSTANCE.getOperatingMode();

		/**
		 * The meta object literal for the '<em>Participation Factor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.ParticipationFactor
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getParticipationFactor()
		 * @generated
		 */
		EDataType PARTICIPATION_FACTOR = eINSTANCE.getParticipationFactor();

		/**
		 * The meta object literal for the '<em>Penalty Factor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PenaltyFactor
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPenaltyFactor()
		 * @generated
		 */
		EDataType PENALTY_FACTOR = eINSTANCE.getPenaltyFactor();

		/**
		 * The meta object literal for the '<em>Per Cent</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PerCent
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPerCent()
		 * @generated
		 */
		EDataType PER_CENT = eINSTANCE.getPerCent();

		/**
		 * The meta object literal for the '<em>Angle Radians</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.AngleRadians
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAngleRadians()
		 * @generated
		 */
		EDataType ANGLE_RADIANS = eINSTANCE.getAngleRadians();

		/**
		 * The meta object literal for the '<em>Power Factor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PowerFactor
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerFactor()
		 * @generated
		 */
		EDataType POWER_FACTOR = eINSTANCE.getPowerFactor();

		/**
		 * The meta object literal for the '<em>Power ROC Per Min</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PowerROCPerMin
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerROCPerMin()
		 * @generated
		 */
		EDataType POWER_ROC_PER_MIN = eINSTANCE.getPowerROCPerMin();

		/**
		 * The meta object literal for the '<em>Power ROC Per Sec</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PowerROCPerSec
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerROCPerSec()
		 * @generated
		 */
		EDataType POWER_ROC_PER_SEC = eINSTANCE.getPowerROCPerSec();

		/**
		 * The meta object literal for the '<em>Power Versus Frequency</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PowerVersusFrequency
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerVersusFrequency()
		 * @generated
		 */
		EDataType POWER_VERSUS_FREQUENCY = eINSTANCE.getPowerVersusFrequency();

		/**
		 * The meta object literal for the '<em>Power Versus Voltage</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PowerVersusVoltage
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPowerVersusVoltage()
		 * @generated
		 */
		EDataType POWER_VERSUS_VOLTAGE = eINSTANCE.getPowerVersusVoltage();

		/**
		 * The meta object literal for the '<em>Pressure</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Pressure
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPressure()
		 * @generated
		 */
		EDataType PRESSURE = eINSTANCE.getPressure();

		/**
		 * The meta object literal for the '<em>Priority</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.integer.Priority
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPriority()
		 * @generated
		 */
		EDataType PRIORITY = eINSTANCE.getPriority();

		/**
		 * The meta object literal for the '<em>PU</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PU
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPU()
		 * @generated
		 */
		EDataType PU = eINSTANCE.getPU();

		/**
		 * The meta object literal for the '<em>PUk VPer MV Ar</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.PUkVPerMVAr
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPUkVPerMVAr()
		 * @generated
		 */
		EDataType PUK_VPER_MV_AR = eINSTANCE.getPUkVPerMVAr();

		/**
		 * The meta object literal for the '<em>Rate Of Change</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.RateOfChange
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRateOfChange()
		 * @generated
		 */
		EDataType RATE_OF_CHANGE = eINSTANCE.getRateOfChange();

		/**
		 * The meta object literal for the '<em>Ratio</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Ratio
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getRatio()
		 * @generated
		 */
		EDataType RATIO = eINSTANCE.getRatio();

		/**
		 * The meta object literal for the '<em>Reactance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Reactance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getReactance()
		 * @generated
		 */
		EDataType REACTANCE = eINSTANCE.getReactance();

		/**
		 * The meta object literal for the '<em>Reactive Power</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.ReactivePower
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getReactivePower()
		 * @generated
		 */
		EDataType REACTIVE_POWER = eINSTANCE.getReactivePower();

		/**
		 * The meta object literal for the '<em>Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.string.Reference
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getReference()
		 * @generated
		 */
		EDataType REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em>Resistance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Resistance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getResistance()
		 * @generated
		 */
		EDataType RESISTANCE = eINSTANCE.getResistance();

		/**
		 * The meta object literal for the '<em>Seconds</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Seconds
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSeconds()
		 * @generated
		 */
		EDataType SECONDS = eINSTANCE.getSeconds();

		/**
		 * The meta object literal for the '<em>Short Length</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.ShortLength
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getShortLength()
		 * @generated
		 */
		EDataType SHORT_LENGTH = eINSTANCE.getShortLength();

		/**
		 * The meta object literal for the '<em>Tap Step</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.integer.TapStep
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTapStep()
		 * @generated
		 */
		EDataType TAP_STEP = eINSTANCE.getTapStep();

		/**
		 * The meta object literal for the '<em>Temperature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Temperature
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTemperature()
		 * @generated
		 */
		EDataType TEMPERATURE = eINSTANCE.getTemperature();

		/**
		 * The meta object literal for the '<em>Terminal Count</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.integer.TerminalCount
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTerminalCount()
		 * @generated
		 */
		EDataType TERMINAL_COUNT = eINSTANCE.getTerminalCount();

		/**
		 * The meta object literal for the '<em>Terminal Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.integer.TerminalType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTerminalType()
		 * @generated
		 */
		EDataType TERMINAL_TYPE = eINSTANCE.getTerminalType();

		/**
		 * The meta object literal for the '<em>Voltage</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Voltage
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getVoltage()
		 * @generated
		 */
		EDataType VOLTAGE = eINSTANCE.getVoltage();

		/**
		 * The meta object literal for the '<em>Volume</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Volume
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getVolume()
		 * @generated
		 */
		EDataType VOLUME = eINSTANCE.getVolume();

		/**
		 * The meta object literal for the '<em>Water Level</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.WaterLevel
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getWaterLevel()
		 * @generated
		 */
		EDataType WATER_LEVEL = eINSTANCE.getWaterLevel();

		/**
		 * The meta object literal for the '<em>Phase Code</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.string.PhaseCode
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getPhaseCode()
		 * @generated
		 */
		EDataType PHASE_CODE = eINSTANCE.getPhaseCode();

		/**
		 * The meta object literal for the '<em>Admittance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Admittance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAdmittance()
		 * @generated
		 */
		EDataType ADMITTANCE = eINSTANCE.getAdmittance();

		/**
		 * The meta object literal for the '<em>Impedance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Impedance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getImpedance()
		 * @generated
		 */
		EDataType IMPEDANCE = eINSTANCE.getImpedance();

		/**
		 * The meta object literal for the '<em>Conductance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Conductance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getConductance()
		 * @generated
		 */
		EDataType CONDUCTANCE = eINSTANCE.getConductance();

		/**
		 * The meta object literal for the '<em>Susceptance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.Susceptance
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getSusceptance()
		 * @generated
		 */
		EDataType SUSCEPTANCE = eINSTANCE.getSusceptance();

		/**
		 * The meta object literal for the '<em>Composite Switch Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.string.CompositeSwitchType
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getCompositeSwitchType()
		 * @generated
		 */
		EDataType COMPOSITE_SWITCH_TYPE = eINSTANCE.getCompositeSwitchType();

		/**
		 * The meta object literal for the '<em>Time Stamp</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.string.TimeStamp
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getTimeStamp()
		 * @generated
		 */
		EDataType TIME_STAMP = eINSTANCE.getTimeStamp();

		/**
		 * The meta object literal for the '<em>Voltage Per Reactive Power</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.datatype.real.VoltagePerReactivePower
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getVoltagePerReactivePower()
		 * @generated
		 */
		EDataType VOLTAGE_PER_REACTIVE_POWER = eINSTANCE.getVoltagePerReactivePower();

		/**
		 * The meta object literal for the '<em>Date</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Date
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getDate()
		 * @generated
		 */
		EDataType DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '<em>Absolute Date Time</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Date
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getAbsoluteDateTime()
		 * @generated
		 */
		EDataType ABSOLUTE_DATE_TIME = eINSTANCE.getAbsoluteDateTime();

		/**
		 * The meta object literal for the '<em>Numeric</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getNumeric()
		 * @generated
		 */
		EDataType NUMERIC = eINSTANCE.getNumeric();

		/**
		 * The meta object literal for the '<em>Java Class</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Class
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getJavaClass()
		 * @generated
		 */
		EDataType JAVA_CLASS = eINSTANCE.getJavaClass();

		/**
		 * The meta object literal for the '<em>Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.opencim.cim.iec61970.domain.impl.DomainPackageImpl#getJavaObject()
		 * @generated
		 */
		EDataType JAVA_OBJECT = eINSTANCE.getJavaObject();

	}

} //DomainPackage
