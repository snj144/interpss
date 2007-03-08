/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomainPackageImpl.java,v 1.4 2007/03/07 05:14:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain.impl;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.Iec61970Package;

import org.opencim.cim.iec61970.core.CorePackage;

import org.opencim.cim.iec61970.core.impl.CorePackageImpl;

import org.opencim.cim.iec61970.domain.AreaControlMode;
import org.opencim.cim.iec61970.domain.AxisQuantity;
import org.opencim.cim.iec61970.domain.BoilerControlMode;
import org.opencim.cim.iec61970.domain.BreakerConfiguration;
import org.opencim.cim.iec61970.domain.BusbarConfiguration;
import org.opencim.cim.iec61970.domain.CompanyType;
import org.opencim.cim.iec61970.domain.CompensatorType;
import org.opencim.cim.iec61970.domain.ControlHouseEquipmentType;
import org.opencim.cim.iec61970.domain.CoolantType;
import org.opencim.cim.iec61970.domain.CurveStyle;
import org.opencim.cim.iec61970.domain.DayTypeName;
import org.opencim.cim.iec61970.domain.DomainFactory;
import org.opencim.cim.iec61970.domain.DomainPackage;
import org.opencim.cim.iec61970.domain.DomainVersion;
import org.opencim.cim.iec61970.domain.EmissionType;
import org.opencim.cim.iec61970.domain.EmissionValueSource;
import org.opencim.cim.iec61970.domain.FuelType;
import org.opencim.cim.iec61970.domain.GeneratorControlMode;
import org.opencim.cim.iec61970.domain.GeneratorControlSource;
import org.opencim.cim.iec61970.domain.GeneratorOperatingMode;
import org.opencim.cim.iec61970.domain.HydroPlantType;
import org.opencim.cim.iec61970.domain.NumericType;
import org.opencim.cim.iec61970.domain.PenstockType;
import org.opencim.cim.iec61970.domain.RampMethod;
import org.opencim.cim.iec61970.domain.RampStartMethod;
import org.opencim.cim.iec61970.domain.RampUnits;
import org.opencim.cim.iec61970.domain.RemoteUnitType;
import org.opencim.cim.iec61970.domain.SeasonName;
import org.opencim.cim.iec61970.domain.Source;
import org.opencim.cim.iec61970.domain.SpillwayGateType;
import org.opencim.cim.iec61970.domain.SurgeTankCode;
import org.opencim.cim.iec61970.domain.SwitchState;
import org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode;
import org.opencim.cim.iec61970.domain.SynchronousMachineType;
import org.opencim.cim.iec61970.domain.TemperatureUnits;
import org.opencim.cim.iec61970.domain.TransformerControlMode;
import org.opencim.cim.iec61970.domain.TransformerCoolingType;
import org.opencim.cim.iec61970.domain.TransformerType;
import org.opencim.cim.iec61970.domain.TurbineType;
import org.opencim.cim.iec61970.domain.Validity;
import org.opencim.cim.iec61970.domain.WindingConnection;
import org.opencim.cim.iec61970.domain.WindingType;
import org.opencim.cim.iec61970.domain.YAxisType;

import org.opencim.cim.iec61970.gen.GenPackage;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;

import org.opencim.cim.iec61970.gen.generationdynamics.impl.GenerationdynamicsPackageImpl;

import org.opencim.cim.iec61970.gen.impl.GenPackageImpl;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl;

import org.opencim.cim.iec61970.impl.Iec61970PackageImpl;

import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.topology.TopologyPackage;

import org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.impl.cimPackageImpl;

import org.opencim.datatype.integer.Classification;
import org.opencim.datatype.integer.Counter;
import org.opencim.datatype.integer.Priority;
import org.opencim.datatype.integer.TapStep;
import org.opencim.datatype.integer.TerminalCount;
import org.opencim.datatype.integer.TerminalType;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Admittance;
import org.opencim.datatype.real.AngleDegrees;
import org.opencim.datatype.real.AngleRadians;
import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Conductance;
import org.opencim.datatype.real.CostPerEnergyUnit;
import org.opencim.datatype.real.CostPerHeatUnit;
import org.opencim.datatype.real.CostPerHour;
import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.Damping;
import org.opencim.datatype.real.Emission;
import org.opencim.datatype.real.EnergyAsMWh;
import org.opencim.datatype.real.ExcitingCurrent;
import org.opencim.datatype.real.Exponent;
import org.opencim.datatype.real.Fraction;
import org.opencim.datatype.real.FreqBiasFactor;
import org.opencim.datatype.real.Frequency;
import org.opencim.datatype.real.HeatPerHour;
import org.opencim.datatype.real.Hours;
import org.opencim.datatype.real.Impedance;
import org.opencim.datatype.real.Inductance;
import org.opencim.datatype.real.Inertia;
import org.opencim.datatype.real.Load;
import org.opencim.datatype.real.LoadLoss;
import org.opencim.datatype.real.LongLength;
import org.opencim.datatype.real.Money;
import org.opencim.datatype.real.NoLoadLoss;
import org.opencim.datatype.real.PUkVPerMVAr;
import org.opencim.datatype.real.ParticipationFactor;
import org.opencim.datatype.real.PenaltyFactor;
import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.PowerFactor;
import org.opencim.datatype.real.PowerROCPerMin;
import org.opencim.datatype.real.PowerROCPerSec;
import org.opencim.datatype.real.PowerVersusFrequency;
import org.opencim.datatype.real.PowerVersusVoltage;
import org.opencim.datatype.real.Pressure;
import org.opencim.datatype.real.RateOfChange;
import org.opencim.datatype.real.Ratio;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.ShortLength;
import org.opencim.datatype.real.Susceptance;
import org.opencim.datatype.real.Temperature;
import org.opencim.datatype.real.Voltage;
import org.opencim.datatype.real.VoltagePerReactivePower;
import org.opencim.datatype.real.Volume;
import org.opencim.datatype.real.WaterLevel;

import org.opencim.datatype.string.CompositeSwitchType;
import org.opencim.datatype.string.ControlMode;
import org.opencim.datatype.string.OperatingMode;
import org.opencim.datatype.string.PhaseCode;
import org.opencim.datatype.string.Reference;
import org.opencim.datatype.string.TimeStamp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainPackageImpl extends EPackageImpl implements DomainPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum boilerControlModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum switchStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum temperatureUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windingConnectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum seasonNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dayTypeNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum breakerConfigurationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum busbarConfigurationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum companyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum coolantTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum curveStyleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum emissionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum emissionValueSourceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fuelTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum penstockTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rampMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rampStartMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rampUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum spillwayGateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum surgeTankCodeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transformerCoolingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum turbineTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum yAxisTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum axisQuantityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum hydroPlantTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numericTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transformerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compensatorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum validityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sourceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum remoteUnitTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum synchronousMachineOperatingModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum synchronousMachineTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transformerControlModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum generatorOperatingModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum generatorControlModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum generatorControlSourceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum areaControlModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum controlHouseEquipmentTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType activePowerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType apparentPowerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType classificationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType controlModeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType costPerEnergyUnitEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType costPerHeatUnitEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType costPerHourEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType counterEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType currentFlowEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dampingEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType angleDegreesEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType emissionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType energyAsMWhEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType excitingCurrentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType exponentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fractionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType freqBiasFactorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType frequencyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType heatPerHourEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hoursEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType inductanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType inertiaEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType loadEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType loadLossEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType longLengthEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType moneyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType noLoadLossEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType operatingModeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType participationFactorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType penaltyFactorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType perCentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType angleRadiansEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType powerFactorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType powerROCPerMinEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType powerROCPerSecEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType powerVersusFrequencyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType powerVersusVoltageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pressureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType priorityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType puEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pUkVPerMVArEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rateOfChangeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ratioEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType reactanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType reactivePowerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType referenceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resistanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType secondsEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType shortLengthEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tapStepEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType temperatureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType terminalCountEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType terminalTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType voltageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType volumeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType waterLevelEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType phaseCodeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType admittanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType impedanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType conductanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType susceptanceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType compositeSwitchTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType timeStampEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType voltagePerReactivePowerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dateEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType absoluteDateTimeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numericEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaClassEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.opencim.cim.iec61970.domain.DomainPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomainPackageImpl() {
		super(eNS_URI, DomainFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomainPackage init() {
		if (isInited) return (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);

		// Obtain or create and register package
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DomainPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) : cimPackage.eINSTANCE);
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) : Iec61970Package.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) : LoadPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) : WirePackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		theDomainPackage.createPackageContents();
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theCorePackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		theDomainPackage.initializePackageContents();
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theCorePackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomainPackage.freeze();

		return theDomainPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainVersion() {
		return domainVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainVersion_Version() {
		return (EAttribute)domainVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainVersion_Date() {
		return (EAttribute)domainVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBoilerControlMode() {
		return boilerControlModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSwitchState() {
		return switchStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTemperatureUnits() {
		return temperatureUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindingType() {
		return windingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindingConnection() {
		return windingConnectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSeasonName() {
		return seasonNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDayTypeName() {
		return dayTypeNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBreakerConfiguration() {
		return breakerConfigurationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBusbarConfiguration() {
		return busbarConfigurationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompanyType() {
		return companyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCoolantType() {
		return coolantTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCurveStyle() {
		return curveStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEmissionType() {
		return emissionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEmissionValueSource() {
		return emissionValueSourceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFuelType() {
		return fuelTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPenstockType() {
		return penstockTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRampMethod() {
		return rampMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRampStartMethod() {
		return rampStartMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRampUnits() {
		return rampUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSpillwayGateType() {
		return spillwayGateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSurgeTankCode() {
		return surgeTankCodeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransformerCoolingType() {
		return transformerCoolingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTurbineType() {
		return turbineTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getYAxisType() {
		return yAxisTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAxisQuantity() {
		return axisQuantityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHydroPlantType() {
		return hydroPlantTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumericType() {
		return numericTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransformerType() {
		return transformerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompensatorType() {
		return compensatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValidity() {
		return validityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSource() {
		return sourceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRemoteUnitType() {
		return remoteUnitTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSynchronousMachineOperatingMode() {
		return synchronousMachineOperatingModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSynchronousMachineType() {
		return synchronousMachineTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransformerControlMode() {
		return transformerControlModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGeneratorOperatingMode() {
		return generatorOperatingModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGeneratorControlMode() {
		return generatorControlModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGeneratorControlSource() {
		return generatorControlSourceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAreaControlMode() {
		return areaControlModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getControlHouseEquipmentType() {
		return controlHouseEquipmentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getActivePower() {
		return activePowerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getApparentPower() {
		return apparentPowerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClassification() {
		return classificationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getControlMode() {
		return controlModeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCostPerEnergyUnit() {
		return costPerEnergyUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCostPerHeatUnit() {
		return costPerHeatUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCostPerHour() {
		return costPerHourEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCounter() {
		return counterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCurrentFlow() {
		return currentFlowEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDamping() {
		return dampingEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAngleDegrees() {
		return angleDegreesEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEmission() {
		return emissionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEnergyAsMWh() {
		return energyAsMWhEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getExcitingCurrent() {
		return excitingCurrentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getExponent() {
		return exponentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFraction() {
		return fractionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFreqBiasFactor() {
		return freqBiasFactorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFrequency() {
		return frequencyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHeatPerHour() {
		return heatPerHourEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHours() {
		return hoursEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInductance() {
		return inductanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInertia() {
		return inertiaEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLoad() {
		return loadEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLoadLoss() {
		return loadLossEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLongLength() {
		return longLengthEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMoney() {
		return moneyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNoLoadLoss() {
		return noLoadLossEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOperatingMode() {
		return operatingModeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getParticipationFactor() {
		return participationFactorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPenaltyFactor() {
		return penaltyFactorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPerCent() {
		return perCentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAngleRadians() {
		return angleRadiansEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPowerFactor() {
		return powerFactorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPowerROCPerMin() {
		return powerROCPerMinEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPowerROCPerSec() {
		return powerROCPerSecEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPowerVersusFrequency() {
		return powerVersusFrequencyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPowerVersusVoltage() {
		return powerVersusVoltageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPressure() {
		return pressureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPriority() {
		return priorityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPU() {
		return puEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPUkVPerMVAr() {
		return pUkVPerMVArEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRateOfChange() {
		return rateOfChangeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRatio() {
		return ratioEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReactance() {
		return reactanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReactivePower() {
		return reactivePowerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReference() {
		return referenceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResistance() {
		return resistanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSeconds() {
		return secondsEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getShortLength() {
		return shortLengthEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTapStep() {
		return tapStepEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTemperature() {
		return temperatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTerminalCount() {
		return terminalCountEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTerminalType() {
		return terminalTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVoltage() {
		return voltageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVolume() {
		return volumeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWaterLevel() {
		return waterLevelEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPhaseCode() {
		return phaseCodeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAdmittance() {
		return admittanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImpedance() {
		return impedanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConductance() {
		return conductanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSusceptance() {
		return susceptanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCompositeSwitchType() {
		return compositeSwitchTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTimeStamp() {
		return timeStampEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVoltagePerReactivePower() {
		return voltagePerReactivePowerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDate() {
		return dateEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAbsoluteDateTime() {
		return absoluteDateTimeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumeric() {
		return numericEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaClass() {
		return javaClassEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaObject() {
		return javaObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainFactory getDomainFactory() {
		return (DomainFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		domainVersionEClass = createEClass(DOMAIN_VERSION);
		createEAttribute(domainVersionEClass, DOMAIN_VERSION__VERSION);
		createEAttribute(domainVersionEClass, DOMAIN_VERSION__DATE);

		// Create enums
		boilerControlModeEEnum = createEEnum(BOILER_CONTROL_MODE);
		switchStateEEnum = createEEnum(SWITCH_STATE);
		temperatureUnitsEEnum = createEEnum(TEMPERATURE_UNITS);
		windingTypeEEnum = createEEnum(WINDING_TYPE);
		windingConnectionEEnum = createEEnum(WINDING_CONNECTION);
		seasonNameEEnum = createEEnum(SEASON_NAME);
		dayTypeNameEEnum = createEEnum(DAY_TYPE_NAME);
		breakerConfigurationEEnum = createEEnum(BREAKER_CONFIGURATION);
		busbarConfigurationEEnum = createEEnum(BUSBAR_CONFIGURATION);
		companyTypeEEnum = createEEnum(COMPANY_TYPE);
		coolantTypeEEnum = createEEnum(COOLANT_TYPE);
		curveStyleEEnum = createEEnum(CURVE_STYLE);
		emissionTypeEEnum = createEEnum(EMISSION_TYPE);
		emissionValueSourceEEnum = createEEnum(EMISSION_VALUE_SOURCE);
		fuelTypeEEnum = createEEnum(FUEL_TYPE);
		penstockTypeEEnum = createEEnum(PENSTOCK_TYPE);
		rampMethodEEnum = createEEnum(RAMP_METHOD);
		rampStartMethodEEnum = createEEnum(RAMP_START_METHOD);
		rampUnitsEEnum = createEEnum(RAMP_UNITS);
		spillwayGateTypeEEnum = createEEnum(SPILLWAY_GATE_TYPE);
		surgeTankCodeEEnum = createEEnum(SURGE_TANK_CODE);
		transformerCoolingTypeEEnum = createEEnum(TRANSFORMER_COOLING_TYPE);
		turbineTypeEEnum = createEEnum(TURBINE_TYPE);
		yAxisTypeEEnum = createEEnum(YAXIS_TYPE);
		axisQuantityEEnum = createEEnum(AXIS_QUANTITY);
		hydroPlantTypeEEnum = createEEnum(HYDRO_PLANT_TYPE);
		numericTypeEEnum = createEEnum(NUMERIC_TYPE);
		transformerTypeEEnum = createEEnum(TRANSFORMER_TYPE);
		compensatorTypeEEnum = createEEnum(COMPENSATOR_TYPE);
		validityEEnum = createEEnum(VALIDITY);
		sourceEEnum = createEEnum(SOURCE);
		remoteUnitTypeEEnum = createEEnum(REMOTE_UNIT_TYPE);
		synchronousMachineOperatingModeEEnum = createEEnum(SYNCHRONOUS_MACHINE_OPERATING_MODE);
		synchronousMachineTypeEEnum = createEEnum(SYNCHRONOUS_MACHINE_TYPE);
		transformerControlModeEEnum = createEEnum(TRANSFORMER_CONTROL_MODE);
		generatorOperatingModeEEnum = createEEnum(GENERATOR_OPERATING_MODE);
		generatorControlModeEEnum = createEEnum(GENERATOR_CONTROL_MODE);
		generatorControlSourceEEnum = createEEnum(GENERATOR_CONTROL_SOURCE);
		areaControlModeEEnum = createEEnum(AREA_CONTROL_MODE);
		controlHouseEquipmentTypeEEnum = createEEnum(CONTROL_HOUSE_EQUIPMENT_TYPE);

		// Create data types
		activePowerEDataType = createEDataType(ACTIVE_POWER);
		apparentPowerEDataType = createEDataType(APPARENT_POWER);
		classificationEDataType = createEDataType(CLASSIFICATION);
		controlModeEDataType = createEDataType(CONTROL_MODE);
		costPerEnergyUnitEDataType = createEDataType(COST_PER_ENERGY_UNIT);
		costPerHeatUnitEDataType = createEDataType(COST_PER_HEAT_UNIT);
		costPerHourEDataType = createEDataType(COST_PER_HOUR);
		counterEDataType = createEDataType(COUNTER);
		currentFlowEDataType = createEDataType(CURRENT_FLOW);
		dampingEDataType = createEDataType(DAMPING);
		angleDegreesEDataType = createEDataType(ANGLE_DEGREES);
		emissionEDataType = createEDataType(EMISSION);
		energyAsMWhEDataType = createEDataType(ENERGY_AS_MWH);
		excitingCurrentEDataType = createEDataType(EXCITING_CURRENT);
		exponentEDataType = createEDataType(EXPONENT);
		fractionEDataType = createEDataType(FRACTION);
		freqBiasFactorEDataType = createEDataType(FREQ_BIAS_FACTOR);
		frequencyEDataType = createEDataType(FREQUENCY);
		heatPerHourEDataType = createEDataType(HEAT_PER_HOUR);
		hoursEDataType = createEDataType(HOURS);
		inductanceEDataType = createEDataType(INDUCTANCE);
		inertiaEDataType = createEDataType(INERTIA);
		loadEDataType = createEDataType(LOAD);
		loadLossEDataType = createEDataType(LOAD_LOSS);
		longLengthEDataType = createEDataType(LONG_LENGTH);
		moneyEDataType = createEDataType(MONEY);
		noLoadLossEDataType = createEDataType(NO_LOAD_LOSS);
		operatingModeEDataType = createEDataType(OPERATING_MODE);
		participationFactorEDataType = createEDataType(PARTICIPATION_FACTOR);
		penaltyFactorEDataType = createEDataType(PENALTY_FACTOR);
		perCentEDataType = createEDataType(PER_CENT);
		angleRadiansEDataType = createEDataType(ANGLE_RADIANS);
		powerFactorEDataType = createEDataType(POWER_FACTOR);
		powerROCPerMinEDataType = createEDataType(POWER_ROC_PER_MIN);
		powerROCPerSecEDataType = createEDataType(POWER_ROC_PER_SEC);
		powerVersusFrequencyEDataType = createEDataType(POWER_VERSUS_FREQUENCY);
		powerVersusVoltageEDataType = createEDataType(POWER_VERSUS_VOLTAGE);
		pressureEDataType = createEDataType(PRESSURE);
		priorityEDataType = createEDataType(PRIORITY);
		puEDataType = createEDataType(PU);
		pUkVPerMVArEDataType = createEDataType(PUK_VPER_MV_AR);
		rateOfChangeEDataType = createEDataType(RATE_OF_CHANGE);
		ratioEDataType = createEDataType(RATIO);
		reactanceEDataType = createEDataType(REACTANCE);
		reactivePowerEDataType = createEDataType(REACTIVE_POWER);
		referenceEDataType = createEDataType(REFERENCE);
		resistanceEDataType = createEDataType(RESISTANCE);
		secondsEDataType = createEDataType(SECONDS);
		shortLengthEDataType = createEDataType(SHORT_LENGTH);
		tapStepEDataType = createEDataType(TAP_STEP);
		temperatureEDataType = createEDataType(TEMPERATURE);
		terminalCountEDataType = createEDataType(TERMINAL_COUNT);
		terminalTypeEDataType = createEDataType(TERMINAL_TYPE);
		voltageEDataType = createEDataType(VOLTAGE);
		volumeEDataType = createEDataType(VOLUME);
		waterLevelEDataType = createEDataType(WATER_LEVEL);
		phaseCodeEDataType = createEDataType(PHASE_CODE);
		admittanceEDataType = createEDataType(ADMITTANCE);
		impedanceEDataType = createEDataType(IMPEDANCE);
		conductanceEDataType = createEDataType(CONDUCTANCE);
		susceptanceEDataType = createEDataType(SUSCEPTANCE);
		compositeSwitchTypeEDataType = createEDataType(COMPOSITE_SWITCH_TYPE);
		timeStampEDataType = createEDataType(TIME_STAMP);
		voltagePerReactivePowerEDataType = createEDataType(VOLTAGE_PER_REACTIVE_POWER);
		dateEDataType = createEDataType(DATE);
		absoluteDateTimeEDataType = createEDataType(ABSOLUTE_DATE_TIME);
		numericEDataType = createEDataType(NUMERIC);
		javaClassEDataType = createEDataType(JAVA_CLASS);
		javaObjectEDataType = createEDataType(JAVA_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(domainVersionEClass, DomainVersion.class, "DomainVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainVersion_Version(), ecorePackage.getEString(), "version", "Domain_v003", 0, 1, DomainVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainVersion_Date(), this.getDate(), "date", "2004-07-02", 0, 1, DomainVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(boilerControlModeEEnum, BoilerControlMode.class, "BoilerControlMode");
		addEEnumLiteral(boilerControlModeEEnum, BoilerControlMode.FOLLOWING_LITERAL);
		addEEnumLiteral(boilerControlModeEEnum, BoilerControlMode.COORDINATED_LITERAL);

		initEEnum(switchStateEEnum, SwitchState.class, "SwitchState");
		addEEnumLiteral(switchStateEEnum, SwitchState.OPEN_LITERAL);
		addEEnumLiteral(switchStateEEnum, SwitchState.CLOSE_LITERAL);

		initEEnum(temperatureUnitsEEnum, TemperatureUnits.class, "TemperatureUnits");
		addEEnumLiteral(temperatureUnitsEEnum, TemperatureUnits.CELSIUS_LITERAL);
		addEEnumLiteral(temperatureUnitsEEnum, TemperatureUnits.FAHRENHEIT_LITERAL);

		initEEnum(windingTypeEEnum, WindingType.class, "WindingType");
		addEEnumLiteral(windingTypeEEnum, WindingType.PRIMARY_LITERAL);
		addEEnumLiteral(windingTypeEEnum, WindingType.SECONDARY_LITERAL);
		addEEnumLiteral(windingTypeEEnum, WindingType.TERTIARY_LITERAL);
		addEEnumLiteral(windingTypeEEnum, WindingType.QUATERNARY_LITERAL);

		initEEnum(windingConnectionEEnum, WindingConnection.class, "WindingConnection");
		addEEnumLiteral(windingConnectionEEnum, WindingConnection.D_LITERAL);
		addEEnumLiteral(windingConnectionEEnum, WindingConnection.Y_LITERAL);
		addEEnumLiteral(windingConnectionEEnum, WindingConnection.Z_LITERAL);

		initEEnum(seasonNameEEnum, SeasonName.class, "SeasonName");
		addEEnumLiteral(seasonNameEEnum, SeasonName.WINTER_LITERAL);
		addEEnumLiteral(seasonNameEEnum, SeasonName.SPRING_LITERAL);
		addEEnumLiteral(seasonNameEEnum, SeasonName.SUMMER_LITERAL);
		addEEnumLiteral(seasonNameEEnum, SeasonName.FALL_LITERAL);

		initEEnum(dayTypeNameEEnum, DayTypeName.class, "DayTypeName");
		addEEnumLiteral(dayTypeNameEEnum, DayTypeName.WEEKDAY_LITERAL);
		addEEnumLiteral(dayTypeNameEEnum, DayTypeName.WEEKEND_LITERAL);
		addEEnumLiteral(dayTypeNameEEnum, DayTypeName.HOLIDAY_LITERAL);

		initEEnum(breakerConfigurationEEnum, BreakerConfiguration.class, "BreakerConfiguration");
		addEEnumLiteral(breakerConfigurationEEnum, BreakerConfiguration.SINGLE_BREAKER_LITERAL);
		addEEnumLiteral(breakerConfigurationEEnum, BreakerConfiguration.BREAKER_AND_AHALF_LITERAL);
		addEEnumLiteral(breakerConfigurationEEnum, BreakerConfiguration.DOUBLE_BREAKER_LITERAL);
		addEEnumLiteral(breakerConfigurationEEnum, BreakerConfiguration.NO_BREAKER_LITERAL);

		initEEnum(busbarConfigurationEEnum, BusbarConfiguration.class, "BusbarConfiguration");
		addEEnumLiteral(busbarConfigurationEEnum, BusbarConfiguration.SINGLE_BUS_LITERAL);
		addEEnumLiteral(busbarConfigurationEEnum, BusbarConfiguration.DOUBLE_BUS_LITERAL);
		addEEnumLiteral(busbarConfigurationEEnum, BusbarConfiguration.MAIN_WITH_TRANSFER_LITERAL);
		addEEnumLiteral(busbarConfigurationEEnum, BusbarConfiguration.RING_BUS_LITERAL);

		initEEnum(companyTypeEEnum, CompanyType.class, "CompanyType");
		addEEnumLiteral(companyTypeEEnum, CompanyType.POOL_LITERAL);
		addEEnumLiteral(companyTypeEEnum, CompanyType.MUNICIPAL_LITERAL);
		addEEnumLiteral(companyTypeEEnum, CompanyType.IS_PRIVATE_LITERAL);

		initEEnum(coolantTypeEEnum, CoolantType.class, "CoolantType");
		addEEnumLiteral(coolantTypeEEnum, CoolantType.AIR_LITERAL);
		addEEnumLiteral(coolantTypeEEnum, CoolantType.HYDROGEN_GAS_LITERAL);
		addEEnumLiteral(coolantTypeEEnum, CoolantType.WATER_LITERAL);

		initEEnum(curveStyleEEnum, CurveStyle.class, "CurveStyle");
		addEEnumLiteral(curveStyleEEnum, CurveStyle.CONSTANT_YVALUE_LITERAL);
		addEEnumLiteral(curveStyleEEnum, CurveStyle.STRAIGHT_LINE_YVALUES_LITERAL);
		addEEnumLiteral(curveStyleEEnum, CurveStyle.RAMP_YVALUE_LITERAL);
		addEEnumLiteral(curveStyleEEnum, CurveStyle.FORMULA_LITERAL);

		initEEnum(emissionTypeEEnum, EmissionType.class, "EmissionType");
		addEEnumLiteral(emissionTypeEEnum, EmissionType.SULFUR_DIOXIDE_LITERAL);
		addEEnumLiteral(emissionTypeEEnum, EmissionType.CARBON_DIOXIDE_LITERAL);
		addEEnumLiteral(emissionTypeEEnum, EmissionType.NITROGEN_OXIDE_LITERAL);
		addEEnumLiteral(emissionTypeEEnum, EmissionType.HYDROGEN_SULFIDE_LITERAL);
		addEEnumLiteral(emissionTypeEEnum, EmissionType.CHLORINE_LITERAL);
		addEEnumLiteral(emissionTypeEEnum, EmissionType.CARBON_DISULFIDE_LITERAL);

		initEEnum(emissionValueSourceEEnum, EmissionValueSource.class, "EmissionValueSource");
		addEEnumLiteral(emissionValueSourceEEnum, EmissionValueSource.MEASURED_LITERAL);
		addEEnumLiteral(emissionValueSourceEEnum, EmissionValueSource.CALCULATED_LITERAL);

		initEEnum(fuelTypeEEnum, FuelType.class, "FuelType");
		addEEnumLiteral(fuelTypeEEnum, FuelType.COAL_LITERAL);
		addEEnumLiteral(fuelTypeEEnum, FuelType.OIL_LITERAL);
		addEEnumLiteral(fuelTypeEEnum, FuelType.GAS_LITERAL);

		initEEnum(penstockTypeEEnum, PenstockType.class, "PenstockType");
		addEEnumLiteral(penstockTypeEEnum, PenstockType.TYPE_LITERAL);
		addEEnumLiteral(penstockTypeEEnum, PenstockType.OF_LITERAL);
		addEEnumLiteral(penstockTypeEEnum, PenstockType.HYDRO_LITERAL);
		addEEnumLiteral(penstockTypeEEnum, PenstockType.PLANT_LITERAL);
		addEEnumLiteral(penstockTypeEEnum, PenstockType.PENSTOCK_LITERAL);

		initEEnum(rampMethodEEnum, RampMethod.class, "RampMethod");
		addEEnumLiteral(rampMethodEEnum, RampMethod.YUNITS_PER_MINUTE_LITERAL);
		addEEnumLiteral(rampMethodEEnum, RampMethod.RAMP_COMPLETION_IN_MINUTES_LITERAL);

		initEEnum(rampStartMethodEEnum, RampStartMethod.class, "RampStartMethod");
		addEEnumLiteral(rampStartMethodEEnum, RampStartMethod.ZERO_LITERAL);
		addEEnumLiteral(rampStartMethodEEnum, RampStartMethod.FIFTY_PER_CENT_LITERAL);
		addEEnumLiteral(rampStartMethodEEnum, RampStartMethod.ONE_HUNDRED_PER_CENT_LITERAL);

		initEEnum(rampUnitsEEnum, RampUnits.class, "RampUnits");
		addEEnumLiteral(rampUnitsEEnum, RampUnits.MW_PER_MINUTE_LITERAL);
		addEEnumLiteral(rampUnitsEEnum, RampUnits.RAMP_COMPLETION_IN_MIN_LITERAL);

		initEEnum(spillwayGateTypeEEnum, SpillwayGateType.class, "SpillwayGateType");
		addEEnumLiteral(spillwayGateTypeEEnum, SpillwayGateType.TYPE_LITERAL);
		addEEnumLiteral(spillwayGateTypeEEnum, SpillwayGateType.OF_LITERAL);
		addEEnumLiteral(spillwayGateTypeEEnum, SpillwayGateType.SPILLWAY_LITERAL);
		addEEnumLiteral(spillwayGateTypeEEnum, SpillwayGateType.GATE_LITERAL);

		initEEnum(surgeTankCodeEEnum, SurgeTankCode.class, "SurgeTankCode");
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.TYPE_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode._OR_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.ABSENCE_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.OF_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.SURGE_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.TANK_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.THAT_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.IS_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.ASSOCIATED_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.WITH_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.THE_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.HYDRO_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.POWER_LITERAL);
		addEEnumLiteral(surgeTankCodeEEnum, SurgeTankCode.PLANT_LITERAL);

		initEEnum(transformerCoolingTypeEEnum, TransformerCoolingType.class, "TransformerCoolingType");
		addEEnumLiteral(transformerCoolingTypeEEnum, TransformerCoolingType.TYPE_LITERAL);
		addEEnumLiteral(transformerCoolingTypeEEnum, TransformerCoolingType.OF_LITERAL);
		addEEnumLiteral(transformerCoolingTypeEEnum, TransformerCoolingType.TRANSFORMER_LITERAL);
		addEEnumLiteral(transformerCoolingTypeEEnum, TransformerCoolingType.COOLING_LITERAL);

		initEEnum(turbineTypeEEnum, TurbineType.class, "TurbineType");
		addEEnumLiteral(turbineTypeEEnum, TurbineType.FRANCIS_LITERAL);
		addEEnumLiteral(turbineTypeEEnum, TurbineType.PELTON_LITERAL);
		addEEnumLiteral(turbineTypeEEnum, TurbineType.KAPLAN_LITERAL);

		initEEnum(yAxisTypeEEnum, YAxisType.class, "YAxisType");
		addEEnumLiteral(yAxisTypeEEnum, YAxisType.SINGLE_YVALUE_LITERAL);
		addEEnumLiteral(yAxisTypeEEnum, YAxisType.TWO_YVALUES_LITERAL);

		initEEnum(axisQuantityEEnum, AxisQuantity.class, "AxisQuantity");
		addEEnumLiteral(axisQuantityEEnum, AxisQuantity.NONE_LITERAL);
		addEEnumLiteral(axisQuantityEEnum, AxisQuantity.TIME_LITERAL);
		addEEnumLiteral(axisQuantityEEnum, AxisQuantity.ACTIVE_POWER_LITERAL);
		addEEnumLiteral(axisQuantityEEnum, AxisQuantity.REACTIVE_POWER_LITERAL);
		addEEnumLiteral(axisQuantityEEnum, AxisQuantity.CURRENCY_LITERAL);

		initEEnum(hydroPlantTypeEEnum, HydroPlantType.class, "HydroPlantType");
		addEEnumLiteral(hydroPlantTypeEEnum, HydroPlantType.RUN_OF_RIVER_LITERAL);
		addEEnumLiteral(hydroPlantTypeEEnum, HydroPlantType.PUMPED_STORAGE_LITERAL);
		addEEnumLiteral(hydroPlantTypeEEnum, HydroPlantType.MAJOR_STORAGE_LITERAL);
		addEEnumLiteral(hydroPlantTypeEEnum, HydroPlantType.MINOR_STORAGE_LITERAL);

		initEEnum(numericTypeEEnum, NumericType.class, "NumericType");
		addEEnumLiteral(numericTypeEEnum, NumericType.INT_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.OCTET_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.UNSIGNED_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.FLOAT_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.COMPLEX_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.DATE_TIME_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.ULONG_LONG_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.SHORT_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.LONG_LONG_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.LONG_DOUBLE_TYPE_LITERAL);
		addEEnumLiteral(numericTypeEEnum, NumericType.BOOLEAN_TYPE_LITERAL);

		initEEnum(transformerTypeEEnum, TransformerType.class, "TransformerType");
		addEEnumLiteral(transformerTypeEEnum, TransformerType.FIX_LITERAL);
		addEEnumLiteral(transformerTypeEEnum, TransformerType.VOLTAGE_CONTROL_LITERAL);
		addEEnumLiteral(transformerTypeEEnum, TransformerType.PHASE_CONTROL_LITERAL);
		addEEnumLiteral(transformerTypeEEnum, TransformerType.VOLTAGE_AND_PHASE_CONTROL_LITERAL);

		initEEnum(compensatorTypeEEnum, CompensatorType.class, "CompensatorType");
		addEEnumLiteral(compensatorTypeEEnum, CompensatorType.SHUNT_LITERAL);
		addEEnumLiteral(compensatorTypeEEnum, CompensatorType.SERIES_LITERAL);

		initEEnum(validityEEnum, Validity.class, "Validity");
		addEEnumLiteral(validityEEnum, Validity.GOOD_LITERAL);
		addEEnumLiteral(validityEEnum, Validity.QUESTIONABLE_LITERAL);
		addEEnumLiteral(validityEEnum, Validity.INVALID_LITERAL);

		initEEnum(sourceEEnum, Source.class, "Source");
		addEEnumLiteral(sourceEEnum, Source.PROCESS_LITERAL);
		addEEnumLiteral(sourceEEnum, Source.DEFAULTED_LITERAL);
		addEEnumLiteral(sourceEEnum, Source.SUBSTITUTED_LITERAL);

		initEEnum(remoteUnitTypeEEnum, RemoteUnitType.class, "RemoteUnitType");
		addEEnumLiteral(remoteUnitTypeEEnum, RemoteUnitType.RTU_LITERAL);
		addEEnumLiteral(remoteUnitTypeEEnum, RemoteUnitType.SUBSTATION_CONTROL_SYSTEM_LITERAL);
		addEEnumLiteral(remoteUnitTypeEEnum, RemoteUnitType.CONTROL_CENTER_LITERAL);
		addEEnumLiteral(remoteUnitTypeEEnum, RemoteUnitType.IED_LITERAL);

		initEEnum(synchronousMachineOperatingModeEEnum, SynchronousMachineOperatingMode.class, "SynchronousMachineOperatingMode");
		addEEnumLiteral(synchronousMachineOperatingModeEEnum, SynchronousMachineOperatingMode.GENERATOR_LITERAL);
		addEEnumLiteral(synchronousMachineOperatingModeEEnum, SynchronousMachineOperatingMode.CONDENSER_LITERAL);

		initEEnum(synchronousMachineTypeEEnum, SynchronousMachineType.class, "SynchronousMachineType");
		addEEnumLiteral(synchronousMachineTypeEEnum, SynchronousMachineType.GENERATOR_LITERAL);
		addEEnumLiteral(synchronousMachineTypeEEnum, SynchronousMachineType.CONDENSER_LITERAL);
		addEEnumLiteral(synchronousMachineTypeEEnum, SynchronousMachineType.GENERATOR_OR_CONDENSER_LITERAL);

		initEEnum(transformerControlModeEEnum, TransformerControlMode.class, "TransformerControlMode");
		addEEnumLiteral(transformerControlModeEEnum, TransformerControlMode.OFF_LITERAL);
		addEEnumLiteral(transformerControlModeEEnum, TransformerControlMode.LOCAL_LITERAL);
		addEEnumLiteral(transformerControlModeEEnum, TransformerControlMode.VOLT_LITERAL);
		addEEnumLiteral(transformerControlModeEEnum, TransformerControlMode.MW_LITERAL);
		addEEnumLiteral(transformerControlModeEEnum, TransformerControlMode.MV_AR_LITERAL);

		initEEnum(generatorOperatingModeEEnum, GeneratorOperatingMode.class, "GeneratorOperatingMode");
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.OFF_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.MANUAL_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.FIXED_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.LFC_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.AGC_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.EDC_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.MRN_LITERAL);
		addEEnumLiteral(generatorOperatingModeEEnum, GeneratorOperatingMode.REG_LITERAL);

		initEEnum(generatorControlModeEEnum, GeneratorControlMode.class, "GeneratorControlMode");
		addEEnumLiteral(generatorControlModeEEnum, GeneratorControlMode.SETPOINT_LITERAL);
		addEEnumLiteral(generatorControlModeEEnum, GeneratorControlMode.PULSE_LITERAL);

		initEEnum(generatorControlSourceEEnum, GeneratorControlSource.class, "GeneratorControlSource");
		addEEnumLiteral(generatorControlSourceEEnum, GeneratorControlSource.UNAVAILABLE_LITERAL);
		addEEnumLiteral(generatorControlSourceEEnum, GeneratorControlSource.OFF_AGC_LITERAL);
		addEEnumLiteral(generatorControlSourceEEnum, GeneratorControlSource.ON_AGC_LITERAL);
		addEEnumLiteral(generatorControlSourceEEnum, GeneratorControlSource.PLANT_CONTROL_LITERAL);

		initEEnum(areaControlModeEEnum, AreaControlMode.class, "AreaControlMode");
		addEEnumLiteral(areaControlModeEEnum, AreaControlMode.CF_LITERAL);
		addEEnumLiteral(areaControlModeEEnum, AreaControlMode.CTL_LITERAL);
		addEEnumLiteral(areaControlModeEEnum, AreaControlMode.TLB_LITERAL);
		addEEnumLiteral(areaControlModeEEnum, AreaControlMode.OFF_LITERAL);

		initEEnum(controlHouseEquipmentTypeEEnum, ControlHouseEquipmentType.class, "ControlHouseEquipmentType");
		addEEnumLiteral(controlHouseEquipmentTypeEEnum, ControlHouseEquipmentType.TYPE_LITERAL);
		addEEnumLiteral(controlHouseEquipmentTypeEEnum, ControlHouseEquipmentType.OF_LITERAL);
		addEEnumLiteral(controlHouseEquipmentTypeEEnum, ControlHouseEquipmentType.CONTROL_LITERAL);
		addEEnumLiteral(controlHouseEquipmentTypeEEnum, ControlHouseEquipmentType.HOUSE_LITERAL);
		addEEnumLiteral(controlHouseEquipmentTypeEEnum, ControlHouseEquipmentType.EQUIPMENT_LITERAL);

		// Initialize data types
		initEDataType(activePowerEDataType, ActivePower.class, "ActivePower", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(apparentPowerEDataType, ApparentPower.class, "ApparentPower", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(classificationEDataType, Classification.class, "Classification", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(controlModeEDataType, ControlMode.class, "ControlMode", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(costPerEnergyUnitEDataType, CostPerEnergyUnit.class, "CostPerEnergyUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(costPerHeatUnitEDataType, CostPerHeatUnit.class, "CostPerHeatUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(costPerHourEDataType, CostPerHour.class, "CostPerHour", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(counterEDataType, Counter.class, "Counter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(currentFlowEDataType, CurrentFlow.class, "CurrentFlow", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dampingEDataType, Damping.class, "Damping", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(angleDegreesEDataType, AngleDegrees.class, "AngleDegrees", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(emissionEDataType, Emission.class, "Emission", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(energyAsMWhEDataType, EnergyAsMWh.class, "EnergyAsMWh", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(excitingCurrentEDataType, ExcitingCurrent.class, "ExcitingCurrent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exponentEDataType, Exponent.class, "Exponent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fractionEDataType, Fraction.class, "Fraction", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(freqBiasFactorEDataType, FreqBiasFactor.class, "FreqBiasFactor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(frequencyEDataType, Frequency.class, "Frequency", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(heatPerHourEDataType, HeatPerHour.class, "HeatPerHour", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(hoursEDataType, Hours.class, "Hours", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(inductanceEDataType, Inductance.class, "Inductance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(inertiaEDataType, Inertia.class, "Inertia", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(loadEDataType, Load.class, "Load", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(loadLossEDataType, LoadLoss.class, "LoadLoss", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(longLengthEDataType, LongLength.class, "LongLength", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(moneyEDataType, Money.class, "Money", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(noLoadLossEDataType, NoLoadLoss.class, "NoLoadLoss", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(operatingModeEDataType, OperatingMode.class, "OperatingMode", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(participationFactorEDataType, ParticipationFactor.class, "ParticipationFactor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(penaltyFactorEDataType, PenaltyFactor.class, "PenaltyFactor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(perCentEDataType, PerCent.class, "PerCent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(angleRadiansEDataType, AngleRadians.class, "AngleRadians", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(powerFactorEDataType, PowerFactor.class, "PowerFactor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(powerROCPerMinEDataType, PowerROCPerMin.class, "PowerROCPerMin", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(powerROCPerSecEDataType, PowerROCPerSec.class, "PowerROCPerSec", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(powerVersusFrequencyEDataType, PowerVersusFrequency.class, "PowerVersusFrequency", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(powerVersusVoltageEDataType, PowerVersusVoltage.class, "PowerVersusVoltage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pressureEDataType, Pressure.class, "Pressure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(priorityEDataType, Priority.class, "Priority", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(puEDataType, org.opencim.datatype.real.PU.class, "PU", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pUkVPerMVArEDataType, PUkVPerMVAr.class, "PUkVPerMVAr", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rateOfChangeEDataType, RateOfChange.class, "RateOfChange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ratioEDataType, Ratio.class, "Ratio", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(reactanceEDataType, Reactance.class, "Reactance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(reactivePowerEDataType, ReactivePower.class, "ReactivePower", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(referenceEDataType, Reference.class, "Reference", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resistanceEDataType, Resistance.class, "Resistance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(secondsEDataType, Seconds.class, "Seconds", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(shortLengthEDataType, ShortLength.class, "ShortLength", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tapStepEDataType, TapStep.class, "TapStep", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(temperatureEDataType, Temperature.class, "Temperature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(terminalCountEDataType, TerminalCount.class, "TerminalCount", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(terminalTypeEDataType, TerminalType.class, "TerminalType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(voltageEDataType, Voltage.class, "Voltage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(volumeEDataType, Volume.class, "Volume", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(waterLevelEDataType, WaterLevel.class, "WaterLevel", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(phaseCodeEDataType, PhaseCode.class, "PhaseCode", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(admittanceEDataType, Admittance.class, "Admittance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(impedanceEDataType, Impedance.class, "Impedance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(conductanceEDataType, Conductance.class, "Conductance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(susceptanceEDataType, Susceptance.class, "Susceptance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(compositeSwitchTypeEDataType, CompositeSwitchType.class, "CompositeSwitchType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(timeStampEDataType, TimeStamp.class, "TimeStamp", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(voltagePerReactivePowerEDataType, VoltagePerReactivePower.class, "VoltagePerReactivePower", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dateEDataType, Date.class, "Date", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(absoluteDateTimeEDataType, Date.class, "AbsoluteDateTime", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numericEDataType, Object.class, "Numeric", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaClassEDataType, Class.class, "JavaClass", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaObjectEDataType, Object.class, "JavaObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //DomainPackageImpl
