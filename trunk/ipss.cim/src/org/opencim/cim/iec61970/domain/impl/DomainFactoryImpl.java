/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomainFactoryImpl.java,v 1.4 2007/03/07 05:14:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain.impl;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.domain.*;

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
import org.opencim.datatype.real.PU;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainFactoryImpl extends EFactoryImpl implements DomainFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DomainFactory init() {
		try {
			DomainFactory theDomainFactory = (DomainFactory)EPackage.Registry.INSTANCE.getEFactory("org.opencim.cim.iec61970.domain"); 
			if (theDomainFactory != null) {
				return theDomainFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomainFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DomainPackage.DOMAIN_VERSION: return createDomainVersion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DomainPackage.BOILER_CONTROL_MODE:
				return createBoilerControlModeFromString(eDataType, initialValue);
			case DomainPackage.SWITCH_STATE:
				return createSwitchStateFromString(eDataType, initialValue);
			case DomainPackage.TEMPERATURE_UNITS:
				return createTemperatureUnitsFromString(eDataType, initialValue);
			case DomainPackage.WINDING_TYPE:
				return createWindingTypeFromString(eDataType, initialValue);
			case DomainPackage.WINDING_CONNECTION:
				return createWindingConnectionFromString(eDataType, initialValue);
			case DomainPackage.SEASON_NAME:
				return createSeasonNameFromString(eDataType, initialValue);
			case DomainPackage.DAY_TYPE_NAME:
				return createDayTypeNameFromString(eDataType, initialValue);
			case DomainPackage.BREAKER_CONFIGURATION:
				return createBreakerConfigurationFromString(eDataType, initialValue);
			case DomainPackage.BUSBAR_CONFIGURATION:
				return createBusbarConfigurationFromString(eDataType, initialValue);
			case DomainPackage.COMPANY_TYPE:
				return createCompanyTypeFromString(eDataType, initialValue);
			case DomainPackage.COOLANT_TYPE:
				return createCoolantTypeFromString(eDataType, initialValue);
			case DomainPackage.CURVE_STYLE:
				return createCurveStyleFromString(eDataType, initialValue);
			case DomainPackage.EMISSION_TYPE:
				return createEmissionTypeFromString(eDataType, initialValue);
			case DomainPackage.EMISSION_VALUE_SOURCE:
				return createEmissionValueSourceFromString(eDataType, initialValue);
			case DomainPackage.FUEL_TYPE:
				return createFuelTypeFromString(eDataType, initialValue);
			case DomainPackage.PENSTOCK_TYPE:
				return createPenstockTypeFromString(eDataType, initialValue);
			case DomainPackage.RAMP_METHOD:
				return createRampMethodFromString(eDataType, initialValue);
			case DomainPackage.RAMP_START_METHOD:
				return createRampStartMethodFromString(eDataType, initialValue);
			case DomainPackage.RAMP_UNITS:
				return createRampUnitsFromString(eDataType, initialValue);
			case DomainPackage.SPILLWAY_GATE_TYPE:
				return createSpillwayGateTypeFromString(eDataType, initialValue);
			case DomainPackage.SURGE_TANK_CODE:
				return createSurgeTankCodeFromString(eDataType, initialValue);
			case DomainPackage.TRANSFORMER_COOLING_TYPE:
				return createTransformerCoolingTypeFromString(eDataType, initialValue);
			case DomainPackage.TURBINE_TYPE:
				return createTurbineTypeFromString(eDataType, initialValue);
			case DomainPackage.YAXIS_TYPE:
				return createYAxisTypeFromString(eDataType, initialValue);
			case DomainPackage.AXIS_QUANTITY:
				return createAxisQuantityFromString(eDataType, initialValue);
			case DomainPackage.HYDRO_PLANT_TYPE:
				return createHydroPlantTypeFromString(eDataType, initialValue);
			case DomainPackage.NUMERIC_TYPE:
				return createNumericTypeFromString(eDataType, initialValue);
			case DomainPackage.TRANSFORMER_TYPE:
				return createTransformerTypeFromString(eDataType, initialValue);
			case DomainPackage.COMPENSATOR_TYPE:
				return createCompensatorTypeFromString(eDataType, initialValue);
			case DomainPackage.VALIDITY:
				return createValidityFromString(eDataType, initialValue);
			case DomainPackage.SOURCE:
				return createSourceFromString(eDataType, initialValue);
			case DomainPackage.REMOTE_UNIT_TYPE:
				return createRemoteUnitTypeFromString(eDataType, initialValue);
			case DomainPackage.SYNCHRONOUS_MACHINE_OPERATING_MODE:
				return createSynchronousMachineOperatingModeFromString(eDataType, initialValue);
			case DomainPackage.SYNCHRONOUS_MACHINE_TYPE:
				return createSynchronousMachineTypeFromString(eDataType, initialValue);
			case DomainPackage.TRANSFORMER_CONTROL_MODE:
				return createTransformerControlModeFromString(eDataType, initialValue);
			case DomainPackage.GENERATOR_OPERATING_MODE:
				return createGeneratorOperatingModeFromString(eDataType, initialValue);
			case DomainPackage.GENERATOR_CONTROL_MODE:
				return createGeneratorControlModeFromString(eDataType, initialValue);
			case DomainPackage.GENERATOR_CONTROL_SOURCE:
				return createGeneratorControlSourceFromString(eDataType, initialValue);
			case DomainPackage.AREA_CONTROL_MODE:
				return createAreaControlModeFromString(eDataType, initialValue);
			case DomainPackage.CONTROL_HOUSE_EQUIPMENT_TYPE:
				return createControlHouseEquipmentTypeFromString(eDataType, initialValue);
			case DomainPackage.ACTIVE_POWER:
				return createActivePowerFromString(eDataType, initialValue);
			case DomainPackage.APPARENT_POWER:
				return createApparentPowerFromString(eDataType, initialValue);
			case DomainPackage.CLASSIFICATION:
				return createClassificationFromString(eDataType, initialValue);
			case DomainPackage.CONTROL_MODE:
				return createControlModeFromString(eDataType, initialValue);
			case DomainPackage.COST_PER_ENERGY_UNIT:
				return createCostPerEnergyUnitFromString(eDataType, initialValue);
			case DomainPackage.COST_PER_HEAT_UNIT:
				return createCostPerHeatUnitFromString(eDataType, initialValue);
			case DomainPackage.COST_PER_HOUR:
				return createCostPerHourFromString(eDataType, initialValue);
			case DomainPackage.COUNTER:
				return createCounterFromString(eDataType, initialValue);
			case DomainPackage.CURRENT_FLOW:
				return createCurrentFlowFromString(eDataType, initialValue);
			case DomainPackage.DAMPING:
				return createDampingFromString(eDataType, initialValue);
			case DomainPackage.ANGLE_DEGREES:
				return createAngleDegreesFromString(eDataType, initialValue);
			case DomainPackage.EMISSION:
				return createEmissionFromString(eDataType, initialValue);
			case DomainPackage.ENERGY_AS_MWH:
				return createEnergyAsMWhFromString(eDataType, initialValue);
			case DomainPackage.EXCITING_CURRENT:
				return createExcitingCurrentFromString(eDataType, initialValue);
			case DomainPackage.EXPONENT:
				return createExponentFromString(eDataType, initialValue);
			case DomainPackage.FRACTION:
				return createFractionFromString(eDataType, initialValue);
			case DomainPackage.FREQ_BIAS_FACTOR:
				return createFreqBiasFactorFromString(eDataType, initialValue);
			case DomainPackage.FREQUENCY:
				return createFrequencyFromString(eDataType, initialValue);
			case DomainPackage.HEAT_PER_HOUR:
				return createHeatPerHourFromString(eDataType, initialValue);
			case DomainPackage.HOURS:
				return createHoursFromString(eDataType, initialValue);
			case DomainPackage.INDUCTANCE:
				return createInductanceFromString(eDataType, initialValue);
			case DomainPackage.INERTIA:
				return createInertiaFromString(eDataType, initialValue);
			case DomainPackage.LOAD:
				return createLoadFromString(eDataType, initialValue);
			case DomainPackage.LOAD_LOSS:
				return createLoadLossFromString(eDataType, initialValue);
			case DomainPackage.LONG_LENGTH:
				return createLongLengthFromString(eDataType, initialValue);
			case DomainPackage.MONEY:
				return createMoneyFromString(eDataType, initialValue);
			case DomainPackage.NO_LOAD_LOSS:
				return createNoLoadLossFromString(eDataType, initialValue);
			case DomainPackage.OPERATING_MODE:
				return createOperatingModeFromString(eDataType, initialValue);
			case DomainPackage.PARTICIPATION_FACTOR:
				return createParticipationFactorFromString(eDataType, initialValue);
			case DomainPackage.PENALTY_FACTOR:
				return createPenaltyFactorFromString(eDataType, initialValue);
			case DomainPackage.PER_CENT:
				return createPerCentFromString(eDataType, initialValue);
			case DomainPackage.ANGLE_RADIANS:
				return createAngleRadiansFromString(eDataType, initialValue);
			case DomainPackage.POWER_FACTOR:
				return createPowerFactorFromString(eDataType, initialValue);
			case DomainPackage.POWER_ROC_PER_MIN:
				return createPowerROCPerMinFromString(eDataType, initialValue);
			case DomainPackage.POWER_ROC_PER_SEC:
				return createPowerROCPerSecFromString(eDataType, initialValue);
			case DomainPackage.POWER_VERSUS_FREQUENCY:
				return createPowerVersusFrequencyFromString(eDataType, initialValue);
			case DomainPackage.POWER_VERSUS_VOLTAGE:
				return createPowerVersusVoltageFromString(eDataType, initialValue);
			case DomainPackage.PRESSURE:
				return createPressureFromString(eDataType, initialValue);
			case DomainPackage.PRIORITY:
				return createPriorityFromString(eDataType, initialValue);
			case DomainPackage.PU:
				return createPUFromString(eDataType, initialValue);
			case DomainPackage.PUK_VPER_MV_AR:
				return createPUkVPerMVArFromString(eDataType, initialValue);
			case DomainPackage.RATE_OF_CHANGE:
				return createRateOfChangeFromString(eDataType, initialValue);
			case DomainPackage.RATIO:
				return createRatioFromString(eDataType, initialValue);
			case DomainPackage.REACTANCE:
				return createReactanceFromString(eDataType, initialValue);
			case DomainPackage.REACTIVE_POWER:
				return createReactivePowerFromString(eDataType, initialValue);
			case DomainPackage.REFERENCE:
				return createReferenceFromString(eDataType, initialValue);
			case DomainPackage.RESISTANCE:
				return createResistanceFromString(eDataType, initialValue);
			case DomainPackage.SECONDS:
				return createSecondsFromString(eDataType, initialValue);
			case DomainPackage.SHORT_LENGTH:
				return createShortLengthFromString(eDataType, initialValue);
			case DomainPackage.TAP_STEP:
				return createTapStepFromString(eDataType, initialValue);
			case DomainPackage.TEMPERATURE:
				return createTemperatureFromString(eDataType, initialValue);
			case DomainPackage.TERMINAL_COUNT:
				return createTerminalCountFromString(eDataType, initialValue);
			case DomainPackage.TERMINAL_TYPE:
				return createTerminalTypeFromString(eDataType, initialValue);
			case DomainPackage.VOLTAGE:
				return createVoltageFromString(eDataType, initialValue);
			case DomainPackage.VOLUME:
				return createVolumeFromString(eDataType, initialValue);
			case DomainPackage.WATER_LEVEL:
				return createWaterLevelFromString(eDataType, initialValue);
			case DomainPackage.PHASE_CODE:
				return createPhaseCodeFromString(eDataType, initialValue);
			case DomainPackage.ADMITTANCE:
				return createAdmittanceFromString(eDataType, initialValue);
			case DomainPackage.IMPEDANCE:
				return createImpedanceFromString(eDataType, initialValue);
			case DomainPackage.CONDUCTANCE:
				return createConductanceFromString(eDataType, initialValue);
			case DomainPackage.SUSCEPTANCE:
				return createSusceptanceFromString(eDataType, initialValue);
			case DomainPackage.COMPOSITE_SWITCH_TYPE:
				return createCompositeSwitchTypeFromString(eDataType, initialValue);
			case DomainPackage.TIME_STAMP:
				return createTimeStampFromString(eDataType, initialValue);
			case DomainPackage.VOLTAGE_PER_REACTIVE_POWER:
				return createVoltagePerReactivePowerFromString(eDataType, initialValue);
			case DomainPackage.DATE:
				return createDateFromString(eDataType, initialValue);
			case DomainPackage.ABSOLUTE_DATE_TIME:
				return createAbsoluteDateTimeFromString(eDataType, initialValue);
			case DomainPackage.NUMERIC:
				return createNumericFromString(eDataType, initialValue);
			case DomainPackage.JAVA_CLASS:
				return createJavaClassFromString(eDataType, initialValue);
			case DomainPackage.JAVA_OBJECT:
				return createJavaObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DomainPackage.BOILER_CONTROL_MODE:
				return convertBoilerControlModeToString(eDataType, instanceValue);
			case DomainPackage.SWITCH_STATE:
				return convertSwitchStateToString(eDataType, instanceValue);
			case DomainPackage.TEMPERATURE_UNITS:
				return convertTemperatureUnitsToString(eDataType, instanceValue);
			case DomainPackage.WINDING_TYPE:
				return convertWindingTypeToString(eDataType, instanceValue);
			case DomainPackage.WINDING_CONNECTION:
				return convertWindingConnectionToString(eDataType, instanceValue);
			case DomainPackage.SEASON_NAME:
				return convertSeasonNameToString(eDataType, instanceValue);
			case DomainPackage.DAY_TYPE_NAME:
				return convertDayTypeNameToString(eDataType, instanceValue);
			case DomainPackage.BREAKER_CONFIGURATION:
				return convertBreakerConfigurationToString(eDataType, instanceValue);
			case DomainPackage.BUSBAR_CONFIGURATION:
				return convertBusbarConfigurationToString(eDataType, instanceValue);
			case DomainPackage.COMPANY_TYPE:
				return convertCompanyTypeToString(eDataType, instanceValue);
			case DomainPackage.COOLANT_TYPE:
				return convertCoolantTypeToString(eDataType, instanceValue);
			case DomainPackage.CURVE_STYLE:
				return convertCurveStyleToString(eDataType, instanceValue);
			case DomainPackage.EMISSION_TYPE:
				return convertEmissionTypeToString(eDataType, instanceValue);
			case DomainPackage.EMISSION_VALUE_SOURCE:
				return convertEmissionValueSourceToString(eDataType, instanceValue);
			case DomainPackage.FUEL_TYPE:
				return convertFuelTypeToString(eDataType, instanceValue);
			case DomainPackage.PENSTOCK_TYPE:
				return convertPenstockTypeToString(eDataType, instanceValue);
			case DomainPackage.RAMP_METHOD:
				return convertRampMethodToString(eDataType, instanceValue);
			case DomainPackage.RAMP_START_METHOD:
				return convertRampStartMethodToString(eDataType, instanceValue);
			case DomainPackage.RAMP_UNITS:
				return convertRampUnitsToString(eDataType, instanceValue);
			case DomainPackage.SPILLWAY_GATE_TYPE:
				return convertSpillwayGateTypeToString(eDataType, instanceValue);
			case DomainPackage.SURGE_TANK_CODE:
				return convertSurgeTankCodeToString(eDataType, instanceValue);
			case DomainPackage.TRANSFORMER_COOLING_TYPE:
				return convertTransformerCoolingTypeToString(eDataType, instanceValue);
			case DomainPackage.TURBINE_TYPE:
				return convertTurbineTypeToString(eDataType, instanceValue);
			case DomainPackage.YAXIS_TYPE:
				return convertYAxisTypeToString(eDataType, instanceValue);
			case DomainPackage.AXIS_QUANTITY:
				return convertAxisQuantityToString(eDataType, instanceValue);
			case DomainPackage.HYDRO_PLANT_TYPE:
				return convertHydroPlantTypeToString(eDataType, instanceValue);
			case DomainPackage.NUMERIC_TYPE:
				return convertNumericTypeToString(eDataType, instanceValue);
			case DomainPackage.TRANSFORMER_TYPE:
				return convertTransformerTypeToString(eDataType, instanceValue);
			case DomainPackage.COMPENSATOR_TYPE:
				return convertCompensatorTypeToString(eDataType, instanceValue);
			case DomainPackage.VALIDITY:
				return convertValidityToString(eDataType, instanceValue);
			case DomainPackage.SOURCE:
				return convertSourceToString(eDataType, instanceValue);
			case DomainPackage.REMOTE_UNIT_TYPE:
				return convertRemoteUnitTypeToString(eDataType, instanceValue);
			case DomainPackage.SYNCHRONOUS_MACHINE_OPERATING_MODE:
				return convertSynchronousMachineOperatingModeToString(eDataType, instanceValue);
			case DomainPackage.SYNCHRONOUS_MACHINE_TYPE:
				return convertSynchronousMachineTypeToString(eDataType, instanceValue);
			case DomainPackage.TRANSFORMER_CONTROL_MODE:
				return convertTransformerControlModeToString(eDataType, instanceValue);
			case DomainPackage.GENERATOR_OPERATING_MODE:
				return convertGeneratorOperatingModeToString(eDataType, instanceValue);
			case DomainPackage.GENERATOR_CONTROL_MODE:
				return convertGeneratorControlModeToString(eDataType, instanceValue);
			case DomainPackage.GENERATOR_CONTROL_SOURCE:
				return convertGeneratorControlSourceToString(eDataType, instanceValue);
			case DomainPackage.AREA_CONTROL_MODE:
				return convertAreaControlModeToString(eDataType, instanceValue);
			case DomainPackage.CONTROL_HOUSE_EQUIPMENT_TYPE:
				return convertControlHouseEquipmentTypeToString(eDataType, instanceValue);
			case DomainPackage.ACTIVE_POWER:
				return convertActivePowerToString(eDataType, instanceValue);
			case DomainPackage.APPARENT_POWER:
				return convertApparentPowerToString(eDataType, instanceValue);
			case DomainPackage.CLASSIFICATION:
				return convertClassificationToString(eDataType, instanceValue);
			case DomainPackage.CONTROL_MODE:
				return convertControlModeToString(eDataType, instanceValue);
			case DomainPackage.COST_PER_ENERGY_UNIT:
				return convertCostPerEnergyUnitToString(eDataType, instanceValue);
			case DomainPackage.COST_PER_HEAT_UNIT:
				return convertCostPerHeatUnitToString(eDataType, instanceValue);
			case DomainPackage.COST_PER_HOUR:
				return convertCostPerHourToString(eDataType, instanceValue);
			case DomainPackage.COUNTER:
				return convertCounterToString(eDataType, instanceValue);
			case DomainPackage.CURRENT_FLOW:
				return convertCurrentFlowToString(eDataType, instanceValue);
			case DomainPackage.DAMPING:
				return convertDampingToString(eDataType, instanceValue);
			case DomainPackage.ANGLE_DEGREES:
				return convertAngleDegreesToString(eDataType, instanceValue);
			case DomainPackage.EMISSION:
				return convertEmissionToString(eDataType, instanceValue);
			case DomainPackage.ENERGY_AS_MWH:
				return convertEnergyAsMWhToString(eDataType, instanceValue);
			case DomainPackage.EXCITING_CURRENT:
				return convertExcitingCurrentToString(eDataType, instanceValue);
			case DomainPackage.EXPONENT:
				return convertExponentToString(eDataType, instanceValue);
			case DomainPackage.FRACTION:
				return convertFractionToString(eDataType, instanceValue);
			case DomainPackage.FREQ_BIAS_FACTOR:
				return convertFreqBiasFactorToString(eDataType, instanceValue);
			case DomainPackage.FREQUENCY:
				return convertFrequencyToString(eDataType, instanceValue);
			case DomainPackage.HEAT_PER_HOUR:
				return convertHeatPerHourToString(eDataType, instanceValue);
			case DomainPackage.HOURS:
				return convertHoursToString(eDataType, instanceValue);
			case DomainPackage.INDUCTANCE:
				return convertInductanceToString(eDataType, instanceValue);
			case DomainPackage.INERTIA:
				return convertInertiaToString(eDataType, instanceValue);
			case DomainPackage.LOAD:
				return convertLoadToString(eDataType, instanceValue);
			case DomainPackage.LOAD_LOSS:
				return convertLoadLossToString(eDataType, instanceValue);
			case DomainPackage.LONG_LENGTH:
				return convertLongLengthToString(eDataType, instanceValue);
			case DomainPackage.MONEY:
				return convertMoneyToString(eDataType, instanceValue);
			case DomainPackage.NO_LOAD_LOSS:
				return convertNoLoadLossToString(eDataType, instanceValue);
			case DomainPackage.OPERATING_MODE:
				return convertOperatingModeToString(eDataType, instanceValue);
			case DomainPackage.PARTICIPATION_FACTOR:
				return convertParticipationFactorToString(eDataType, instanceValue);
			case DomainPackage.PENALTY_FACTOR:
				return convertPenaltyFactorToString(eDataType, instanceValue);
			case DomainPackage.PER_CENT:
				return convertPerCentToString(eDataType, instanceValue);
			case DomainPackage.ANGLE_RADIANS:
				return convertAngleRadiansToString(eDataType, instanceValue);
			case DomainPackage.POWER_FACTOR:
				return convertPowerFactorToString(eDataType, instanceValue);
			case DomainPackage.POWER_ROC_PER_MIN:
				return convertPowerROCPerMinToString(eDataType, instanceValue);
			case DomainPackage.POWER_ROC_PER_SEC:
				return convertPowerROCPerSecToString(eDataType, instanceValue);
			case DomainPackage.POWER_VERSUS_FREQUENCY:
				return convertPowerVersusFrequencyToString(eDataType, instanceValue);
			case DomainPackage.POWER_VERSUS_VOLTAGE:
				return convertPowerVersusVoltageToString(eDataType, instanceValue);
			case DomainPackage.PRESSURE:
				return convertPressureToString(eDataType, instanceValue);
			case DomainPackage.PRIORITY:
				return convertPriorityToString(eDataType, instanceValue);
			case DomainPackage.PU:
				return convertPUToString(eDataType, instanceValue);
			case DomainPackage.PUK_VPER_MV_AR:
				return convertPUkVPerMVArToString(eDataType, instanceValue);
			case DomainPackage.RATE_OF_CHANGE:
				return convertRateOfChangeToString(eDataType, instanceValue);
			case DomainPackage.RATIO:
				return convertRatioToString(eDataType, instanceValue);
			case DomainPackage.REACTANCE:
				return convertReactanceToString(eDataType, instanceValue);
			case DomainPackage.REACTIVE_POWER:
				return convertReactivePowerToString(eDataType, instanceValue);
			case DomainPackage.REFERENCE:
				return convertReferenceToString(eDataType, instanceValue);
			case DomainPackage.RESISTANCE:
				return convertResistanceToString(eDataType, instanceValue);
			case DomainPackage.SECONDS:
				return convertSecondsToString(eDataType, instanceValue);
			case DomainPackage.SHORT_LENGTH:
				return convertShortLengthToString(eDataType, instanceValue);
			case DomainPackage.TAP_STEP:
				return convertTapStepToString(eDataType, instanceValue);
			case DomainPackage.TEMPERATURE:
				return convertTemperatureToString(eDataType, instanceValue);
			case DomainPackage.TERMINAL_COUNT:
				return convertTerminalCountToString(eDataType, instanceValue);
			case DomainPackage.TERMINAL_TYPE:
				return convertTerminalTypeToString(eDataType, instanceValue);
			case DomainPackage.VOLTAGE:
				return convertVoltageToString(eDataType, instanceValue);
			case DomainPackage.VOLUME:
				return convertVolumeToString(eDataType, instanceValue);
			case DomainPackage.WATER_LEVEL:
				return convertWaterLevelToString(eDataType, instanceValue);
			case DomainPackage.PHASE_CODE:
				return convertPhaseCodeToString(eDataType, instanceValue);
			case DomainPackage.ADMITTANCE:
				return convertAdmittanceToString(eDataType, instanceValue);
			case DomainPackage.IMPEDANCE:
				return convertImpedanceToString(eDataType, instanceValue);
			case DomainPackage.CONDUCTANCE:
				return convertConductanceToString(eDataType, instanceValue);
			case DomainPackage.SUSCEPTANCE:
				return convertSusceptanceToString(eDataType, instanceValue);
			case DomainPackage.COMPOSITE_SWITCH_TYPE:
				return convertCompositeSwitchTypeToString(eDataType, instanceValue);
			case DomainPackage.TIME_STAMP:
				return convertTimeStampToString(eDataType, instanceValue);
			case DomainPackage.VOLTAGE_PER_REACTIVE_POWER:
				return convertVoltagePerReactivePowerToString(eDataType, instanceValue);
			case DomainPackage.DATE:
				return convertDateToString(eDataType, instanceValue);
			case DomainPackage.ABSOLUTE_DATE_TIME:
				return convertAbsoluteDateTimeToString(eDataType, instanceValue);
			case DomainPackage.NUMERIC:
				return convertNumericToString(eDataType, instanceValue);
			case DomainPackage.JAVA_CLASS:
				return convertJavaClassToString(eDataType, instanceValue);
			case DomainPackage.JAVA_OBJECT:
				return convertJavaObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainVersion createDomainVersion() {
		DomainVersionImpl domainVersion = new DomainVersionImpl();
		return domainVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoilerControlMode createBoilerControlModeFromString(EDataType eDataType, String initialValue) {
		BoilerControlMode result = BoilerControlMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBoilerControlModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchState createSwitchStateFromString(EDataType eDataType, String initialValue) {
		SwitchState result = SwitchState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSwitchStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemperatureUnits createTemperatureUnitsFromString(EDataType eDataType, String initialValue) {
		TemperatureUnits result = TemperatureUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemperatureUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingType createWindingTypeFromString(EDataType eDataType, String initialValue) {
		WindingType result = WindingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingConnection createWindingConnectionFromString(EDataType eDataType, String initialValue) {
		WindingConnection result = WindingConnection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindingConnectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeasonName createSeasonNameFromString(EDataType eDataType, String initialValue) {
		SeasonName result = SeasonName.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSeasonNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DayTypeName createDayTypeNameFromString(EDataType eDataType, String initialValue) {
		DayTypeName result = DayTypeName.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDayTypeNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakerConfiguration createBreakerConfigurationFromString(EDataType eDataType, String initialValue) {
		BreakerConfiguration result = BreakerConfiguration.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBreakerConfigurationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusbarConfiguration createBusbarConfigurationFromString(EDataType eDataType, String initialValue) {
		BusbarConfiguration result = BusbarConfiguration.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBusbarConfigurationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanyType createCompanyTypeFromString(EDataType eDataType, String initialValue) {
		CompanyType result = CompanyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompanyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoolantType createCoolantTypeFromString(EDataType eDataType, String initialValue) {
		CoolantType result = CoolantType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoolantTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveStyle createCurveStyleFromString(EDataType eDataType, String initialValue) {
		CurveStyle result = CurveStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCurveStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionType createEmissionTypeFromString(EDataType eDataType, String initialValue) {
		EmissionType result = EmissionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmissionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionValueSource createEmissionValueSourceFromString(EDataType eDataType, String initialValue) {
		EmissionValueSource result = EmissionValueSource.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmissionValueSourceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuelType createFuelTypeFromString(EDataType eDataType, String initialValue) {
		FuelType result = FuelType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFuelTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PenstockType createPenstockTypeFromString(EDataType eDataType, String initialValue) {
		PenstockType result = PenstockType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPenstockTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampMethod createRampMethodFromString(EDataType eDataType, String initialValue) {
		RampMethod result = RampMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRampMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampStartMethod createRampStartMethodFromString(EDataType eDataType, String initialValue) {
		RampStartMethod result = RampStartMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRampStartMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampUnits createRampUnitsFromString(EDataType eDataType, String initialValue) {
		RampUnits result = RampUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRampUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpillwayGateType createSpillwayGateTypeFromString(EDataType eDataType, String initialValue) {
		SpillwayGateType result = SpillwayGateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpillwayGateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SurgeTankCode createSurgeTankCodeFromString(EDataType eDataType, String initialValue) {
		SurgeTankCode result = SurgeTankCode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSurgeTankCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerCoolingType createTransformerCoolingTypeFromString(EDataType eDataType, String initialValue) {
		TransformerCoolingType result = TransformerCoolingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransformerCoolingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TurbineType createTurbineTypeFromString(EDataType eDataType, String initialValue) {
		TurbineType result = TurbineType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTurbineTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YAxisType createYAxisTypeFromString(EDataType eDataType, String initialValue) {
		YAxisType result = YAxisType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertYAxisTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisQuantity createAxisQuantityFromString(EDataType eDataType, String initialValue) {
		AxisQuantity result = AxisQuantity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAxisQuantityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPlantType createHydroPlantTypeFromString(EDataType eDataType, String initialValue) {
		HydroPlantType result = HydroPlantType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHydroPlantTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericType createNumericTypeFromString(EDataType eDataType, String initialValue) {
		NumericType result = NumericType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumericTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerType createTransformerTypeFromString(EDataType eDataType, String initialValue) {
		TransformerType result = TransformerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransformerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompensatorType createCompensatorTypeFromString(EDataType eDataType, String initialValue) {
		CompensatorType result = CompensatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompensatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Validity createValidityFromString(EDataType eDataType, String initialValue) {
		Validity result = Validity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValidityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Source createSourceFromString(EDataType eDataType, String initialValue) {
		Source result = Source.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSourceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteUnitType createRemoteUnitTypeFromString(EDataType eDataType, String initialValue) {
		RemoteUnitType result = RemoteUnitType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRemoteUnitTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachineOperatingMode createSynchronousMachineOperatingModeFromString(EDataType eDataType, String initialValue) {
		SynchronousMachineOperatingMode result = SynchronousMachineOperatingMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSynchronousMachineOperatingModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachineType createSynchronousMachineTypeFromString(EDataType eDataType, String initialValue) {
		SynchronousMachineType result = SynchronousMachineType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSynchronousMachineTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerControlMode createTransformerControlModeFromString(EDataType eDataType, String initialValue) {
		TransformerControlMode result = TransformerControlMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransformerControlModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorOperatingMode createGeneratorOperatingModeFromString(EDataType eDataType, String initialValue) {
		GeneratorOperatingMode result = GeneratorOperatingMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGeneratorOperatingModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorControlMode createGeneratorControlModeFromString(EDataType eDataType, String initialValue) {
		GeneratorControlMode result = GeneratorControlMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGeneratorControlModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorControlSource createGeneratorControlSourceFromString(EDataType eDataType, String initialValue) {
		GeneratorControlSource result = GeneratorControlSource.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGeneratorControlSourceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaControlMode createAreaControlModeFromString(EDataType eDataType, String initialValue) {
		AreaControlMode result = AreaControlMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAreaControlModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlHouseEquipmentType createControlHouseEquipmentTypeFromString(EDataType eDataType, String initialValue) {
		ControlHouseEquipmentType result = ControlHouseEquipmentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertControlHouseEquipmentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower createActivePowerFromString(EDataType eDataType, String initialValue) {
		return (ActivePower)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivePowerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApparentPower createApparentPowerFromString(EDataType eDataType, String initialValue) {
		return (ApparentPower)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertApparentPowerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classification createClassificationFromString(EDataType eDataType, String initialValue) {
		return (Classification)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassificationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlMode createControlModeFromString(EDataType eDataType, String initialValue) {
		return (ControlMode)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertControlModeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerEnergyUnit createCostPerEnergyUnitFromString(EDataType eDataType, String initialValue) {
		return (CostPerEnergyUnit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCostPerEnergyUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHeatUnit createCostPerHeatUnitFromString(EDataType eDataType, String initialValue) {
		return (CostPerHeatUnit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCostPerHeatUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostPerHour createCostPerHourFromString(EDataType eDataType, String initialValue) {
		return (CostPerHour)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCostPerHourToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter createCounterFromString(EDataType eDataType, String initialValue) {
		return (Counter)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCounterToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrentFlow createCurrentFlowFromString(EDataType eDataType, String initialValue) {
		return (CurrentFlow)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCurrentFlowToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Damping createDampingFromString(EDataType eDataType, String initialValue) {
		return (Damping)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDampingToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngleDegrees createAngleDegreesFromString(EDataType eDataType, String initialValue) {
		return (AngleDegrees)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAngleDegreesToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Emission createEmissionFromString(EDataType eDataType, String initialValue) {
		return (Emission)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmissionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyAsMWh createEnergyAsMWhFromString(EDataType eDataType, String initialValue) {
		return (EnergyAsMWh)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnergyAsMWhToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcitingCurrent createExcitingCurrentFromString(EDataType eDataType, String initialValue) {
		return (ExcitingCurrent)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExcitingCurrentToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exponent createExponentFromString(EDataType eDataType, String initialValue) {
		return (Exponent)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExponentToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction createFractionFromString(EDataType eDataType, String initialValue) {
		return (Fraction)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFractionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreqBiasFactor createFreqBiasFactorFromString(EDataType eDataType, String initialValue) {
		return (FreqBiasFactor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFreqBiasFactorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Frequency createFrequencyFromString(EDataType eDataType, String initialValue) {
		return (Frequency)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFrequencyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatPerHour createHeatPerHourFromString(EDataType eDataType, String initialValue) {
		return (HeatPerHour)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHeatPerHourToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hours createHoursFromString(EDataType eDataType, String initialValue) {
		return (Hours)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHoursToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inductance createInductanceFromString(EDataType eDataType, String initialValue) {
		return (Inductance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInductanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inertia createInertiaFromString(EDataType eDataType, String initialValue) {
		return (Inertia)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInertiaToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Load createLoadFromString(EDataType eDataType, String initialValue) {
		return (Load)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadLoss createLoadLossFromString(EDataType eDataType, String initialValue) {
		return (LoadLoss)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadLossToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongLength createLongLengthFromString(EDataType eDataType, String initialValue) {
		return (LongLength)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLongLengthToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Money createMoneyFromString(EDataType eDataType, String initialValue) {
		return (Money)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMoneyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoLoadLoss createNoLoadLossFromString(EDataType eDataType, String initialValue) {
		return (NoLoadLoss)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNoLoadLossToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingMode createOperatingModeFromString(EDataType eDataType, String initialValue) {
		return (OperatingMode)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatingModeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationFactor createParticipationFactorFromString(EDataType eDataType, String initialValue) {
		return (ParticipationFactor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParticipationFactorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PenaltyFactor createPenaltyFactorFromString(EDataType eDataType, String initialValue) {
		return (PenaltyFactor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPenaltyFactorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent createPerCentFromString(EDataType eDataType, String initialValue) {
		return (PerCent)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPerCentToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngleRadians createAngleRadiansFromString(EDataType eDataType, String initialValue) {
		return (AngleRadians)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAngleRadiansToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerFactor createPowerFactorFromString(EDataType eDataType, String initialValue) {
		return (PowerFactor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerFactorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerMin createPowerROCPerMinFromString(EDataType eDataType, String initialValue) {
		return (PowerROCPerMin)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerROCPerMinToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerSec createPowerROCPerSecFromString(EDataType eDataType, String initialValue) {
		return (PowerROCPerSec)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerROCPerSecToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusFrequency createPowerVersusFrequencyFromString(EDataType eDataType, String initialValue) {
		return (PowerVersusFrequency)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerVersusFrequencyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusVoltage createPowerVersusVoltageFromString(EDataType eDataType, String initialValue) {
		return (PowerVersusVoltage)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerVersusVoltageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pressure createPressureFromString(EDataType eDataType, String initialValue) {
		return (Pressure)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPressureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriorityFromString(EDataType eDataType, String initialValue) {
		return (Priority)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU createPUFromString(EDataType eDataType, String initialValue) {
		return (PU)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPUToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PUkVPerMVAr createPUkVPerMVArFromString(EDataType eDataType, String initialValue) {
		return (PUkVPerMVAr)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPUkVPerMVArToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RateOfChange createRateOfChangeFromString(EDataType eDataType, String initialValue) {
		return (RateOfChange)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRateOfChangeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ratio createRatioFromString(EDataType eDataType, String initialValue) {
		return (Ratio)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRatioToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance createReactanceFromString(EDataType eDataType, String initialValue) {
		return (Reactance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReactanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower createReactivePowerFromString(EDataType eDataType, String initialValue) {
		return (ReactivePower)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReactivePowerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReferenceFromString(EDataType eDataType, String initialValue) {
		return (Reference)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReferenceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance createResistanceFromString(EDataType eDataType, String initialValue) {
		return (Resistance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResistanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds createSecondsFromString(EDataType eDataType, String initialValue) {
		return (Seconds)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSecondsToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortLength createShortLengthFromString(EDataType eDataType, String initialValue) {
		return (ShortLength)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShortLengthToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep createTapStepFromString(EDataType eDataType, String initialValue) {
		return (TapStep)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTapStepToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Temperature createTemperatureFromString(EDataType eDataType, String initialValue) {
		return (Temperature)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemperatureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalCount createTerminalCountFromString(EDataType eDataType, String initialValue) {
		return (TerminalCount)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTerminalCountToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalType createTerminalTypeFromString(EDataType eDataType, String initialValue) {
		return (TerminalType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTerminalTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage createVoltageFromString(EDataType eDataType, String initialValue) {
		return (Voltage)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVoltageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Volume createVolumeFromString(EDataType eDataType, String initialValue) {
		return (Volume)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVolumeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterLevel createWaterLevelFromString(EDataType eDataType, String initialValue) {
		return (WaterLevel)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWaterLevelToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhaseCode createPhaseCodeFromString(EDataType eDataType, String initialValue) {
		return (PhaseCode)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhaseCodeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Admittance createAdmittanceFromString(EDataType eDataType, String initialValue) {
		return (Admittance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdmittanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Impedance createImpedanceFromString(EDataType eDataType, String initialValue) {
		return (Impedance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImpedanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conductance createConductanceFromString(EDataType eDataType, String initialValue) {
		return (Conductance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConductanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Susceptance createSusceptanceFromString(EDataType eDataType, String initialValue) {
		return (Susceptance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSusceptanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSwitchType createCompositeSwitchTypeFromString(EDataType eDataType, String initialValue) {
		return (CompositeSwitchType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompositeSwitchTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeStamp createTimeStampFromString(EDataType eDataType, String initialValue) {
		return (TimeStamp)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeStampToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoltagePerReactivePower createVoltagePerReactivePowerFromString(EDataType eDataType, String initialValue) {
		return (VoltagePerReactivePower)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVoltagePerReactivePowerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createDateFromString(EDataType eDataType, String initialValue) {
		return (Date)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createAbsoluteDateTimeFromString(EDataType eDataType, String initialValue) {
		return (Date)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAbsoluteDateTimeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createNumericFromString(EDataType eDataType, String initialValue) {
		return (Object)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumericToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class createJavaClassFromString(EDataType eDataType, String initialValue) {
		return (Class)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaClassToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return (Object)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPackage getDomainPackage() {
		return (DomainPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static DomainPackage getPackage() {
		return DomainPackage.eINSTANCE;
	}

} //DomainFactoryImpl
