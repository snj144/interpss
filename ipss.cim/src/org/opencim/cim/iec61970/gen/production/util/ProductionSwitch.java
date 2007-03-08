/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProductionSwitch.java,v 1.1 2007/03/02 14:01:19 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.gen.production.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage
 * @generated
 */
public class ProductionSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProductionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionSwitch() {
		if (modelPackage == null) {
			modelPackage = ProductionPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ProductionPackage.THERMAL_GENERATING_UNIT: {
				ThermalGeneratingUnit thermalGeneratingUnit = (ThermalGeneratingUnit)theEObject;
				Object result = caseThermalGeneratingUnit(thermalGeneratingUnit);
				if (result == null) result = caseGeneratingUnit(thermalGeneratingUnit);
				if (result == null) result = caseEquipment(thermalGeneratingUnit);
				if (result == null) result = casePowerSystemResource(thermalGeneratingUnit);
				if (result == null) result = caseNaming(thermalGeneratingUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.TARGET_LEVEL_SCHEDULE: {
				TargetLevelSchedule targetLevelSchedule = (TargetLevelSchedule)theEObject;
				Object result = caseTargetLevelSchedule(targetLevelSchedule);
				if (result == null) result = caseCurveSchedule(targetLevelSchedule);
				if (result == null) result = caseNaming(targetLevelSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.TAILBAY_LOSS_CURVE: {
				TailbayLossCurve tailbayLossCurve = (TailbayLossCurve)theEObject;
				Object result = caseTailbayLossCurve(tailbayLossCurve);
				if (result == null) result = caseCurveSchedule(tailbayLossCurve);
				if (result == null) result = caseNaming(tailbayLossCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.STEAM_SENDOUT_SCHEDULE: {
				SteamSendoutSchedule steamSendoutSchedule = (SteamSendoutSchedule)theEObject;
				Object result = caseSteamSendoutSchedule(steamSendoutSchedule);
				if (result == null) result = caseCurveSchedule(steamSendoutSchedule);
				if (result == null) result = caseNaming(steamSendoutSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.STARTUP_MODEL: {
				StartupModel startupModel = (StartupModel)theEObject;
				Object result = caseStartupModel(startupModel);
				if (result == null) result = caseNaming(startupModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.START_RAMP_CURVE: {
				StartRampCurve startRampCurve = (StartRampCurve)theEObject;
				Object result = caseStartRampCurve(startRampCurve);
				if (result == null) result = caseCurveSchedule(startRampCurve);
				if (result == null) result = caseNaming(startRampCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.START_MAIN_FUEL_CURVE: {
				StartMainFuelCurve startMainFuelCurve = (StartMainFuelCurve)theEObject;
				Object result = caseStartMainFuelCurve(startMainFuelCurve);
				if (result == null) result = caseCurveSchedule(startMainFuelCurve);
				if (result == null) result = caseNaming(startMainFuelCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.START_IGN_FUEL_CURVE: {
				StartIgnFuelCurve startIgnFuelCurve = (StartIgnFuelCurve)theEObject;
				Object result = caseStartIgnFuelCurve(startIgnFuelCurve);
				if (result == null) result = caseCurveSchedule(startIgnFuelCurve);
				if (result == null) result = caseNaming(startIgnFuelCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.SHUTDOWN_CURVE: {
				ShutdownCurve shutdownCurve = (ShutdownCurve)theEObject;
				Object result = caseShutdownCurve(shutdownCurve);
				if (result == null) result = caseCurveSchedule(shutdownCurve);
				if (result == null) result = caseNaming(shutdownCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.RESERVOIR: {
				Reservoir reservoir = (Reservoir)theEObject;
				Object result = caseReservoir(reservoir);
				if (result == null) result = casePowerSystemResource(reservoir);
				if (result == null) result = caseNaming(reservoir);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.PENSTOCK_LOSS_CURVE: {
				PenstockLossCurve penstockLossCurve = (PenstockLossCurve)theEObject;
				Object result = casePenstockLossCurve(penstockLossCurve);
				if (result == null) result = caseCurveSchedule(penstockLossCurve);
				if (result == null) result = caseNaming(penstockLossCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.LEVEL_VS_VOLUME_CURVE: {
				LevelVsVolumeCurve levelVsVolumeCurve = (LevelVsVolumeCurve)theEObject;
				Object result = caseLevelVsVolumeCurve(levelVsVolumeCurve);
				if (result == null) result = caseCurveSchedule(levelVsVolumeCurve);
				if (result == null) result = caseNaming(levelVsVolumeCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.INFLOW_FORECAST: {
				InflowForecast inflowForecast = (InflowForecast)theEObject;
				Object result = caseInflowForecast(inflowForecast);
				if (result == null) result = caseCurveSchedule(inflowForecast);
				if (result == null) result = caseNaming(inflowForecast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.INCREMENTAL_HEAT_RATE_CURVE: {
				IncrementalHeatRateCurve incrementalHeatRateCurve = (IncrementalHeatRateCurve)theEObject;
				Object result = caseIncrementalHeatRateCurve(incrementalHeatRateCurve);
				if (result == null) result = caseCurveSchedule(incrementalHeatRateCurve);
				if (result == null) result = caseNaming(incrementalHeatRateCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HYDRO_PUMP_OP_SCHEDULE: {
				HydroPumpOpSchedule hydroPumpOpSchedule = (HydroPumpOpSchedule)theEObject;
				Object result = caseHydroPumpOpSchedule(hydroPumpOpSchedule);
				if (result == null) result = caseCurveSchedule(hydroPumpOpSchedule);
				if (result == null) result = caseNaming(hydroPumpOpSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HYDRO_PUMP: {
				HydroPump hydroPump = (HydroPump)theEObject;
				Object result = caseHydroPump(hydroPump);
				if (result == null) result = casePowerSystemResource(hydroPump);
				if (result == null) result = caseNaming(hydroPump);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HYDRO_POWER_PLANT: {
				HydroPowerPlant hydroPowerPlant = (HydroPowerPlant)theEObject;
				Object result = caseHydroPowerPlant(hydroPowerPlant);
				if (result == null) result = casePowerSystemResource(hydroPowerPlant);
				if (result == null) result = caseNaming(hydroPowerPlant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HYDRO_GENERATING_UNIT: {
				HydroGeneratingUnit hydroGeneratingUnit = (HydroGeneratingUnit)theEObject;
				Object result = caseHydroGeneratingUnit(hydroGeneratingUnit);
				if (result == null) result = caseGeneratingUnit(hydroGeneratingUnit);
				if (result == null) result = caseEquipment(hydroGeneratingUnit);
				if (result == null) result = casePowerSystemResource(hydroGeneratingUnit);
				if (result == null) result = caseNaming(hydroGeneratingUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HYDRO_GENERATING_EFFICIENCY_CURVE: {
				HydroGeneratingEfficiencyCurve hydroGeneratingEfficiencyCurve = (HydroGeneratingEfficiencyCurve)theEObject;
				Object result = caseHydroGeneratingEfficiencyCurve(hydroGeneratingEfficiencyCurve);
				if (result == null) result = caseCurveSchedule(hydroGeneratingEfficiencyCurve);
				if (result == null) result = caseNaming(hydroGeneratingEfficiencyCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HEAT_RATE_CURVE: {
				HeatRateCurve heatRateCurve = (HeatRateCurve)theEObject;
				Object result = caseHeatRateCurve(heatRateCurve);
				if (result == null) result = caseCurveSchedule(heatRateCurve);
				if (result == null) result = caseNaming(heatRateCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.HEAT_INPUT_CURVE: {
				HeatInputCurve heatInputCurve = (HeatInputCurve)theEObject;
				Object result = caseHeatInputCurve(heatInputCurve);
				if (result == null) result = caseCurveSchedule(heatInputCurve);
				if (result == null) result = caseNaming(heatInputCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.GROSS_TO_NET_MW_CURVE: {
				GrossToNetMWCurve grossToNetMWCurve = (GrossToNetMWCurve)theEObject;
				Object result = caseGrossToNetMWCurve(grossToNetMWCurve);
				if (result == null) result = caseCurveSchedule(grossToNetMWCurve);
				if (result == null) result = caseNaming(grossToNetMWCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.GEN_UNIT_OP_SCHEDULE: {
				GenUnitOpSchedule genUnitOpSchedule = (GenUnitOpSchedule)theEObject;
				Object result = caseGenUnitOpSchedule(genUnitOpSchedule);
				if (result == null) result = caseCurveSchedule(genUnitOpSchedule);
				if (result == null) result = caseNaming(genUnitOpSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE: {
				GenUnitOpCostCurve genUnitOpCostCurve = (GenUnitOpCostCurve)theEObject;
				Object result = caseGenUnitOpCostCurve(genUnitOpCostCurve);
				if (result == null) result = caseCurveSchedule(genUnitOpCostCurve);
				if (result == null) result = caseNaming(genUnitOpCostCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.GENERATING_UNIT: {
				GeneratingUnit generatingUnit = (GeneratingUnit)theEObject;
				Object result = caseGeneratingUnit(generatingUnit);
				if (result == null) result = caseEquipment(generatingUnit);
				if (result == null) result = casePowerSystemResource(generatingUnit);
				if (result == null) result = caseNaming(generatingUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE: {
				FuelAllocationSchedule fuelAllocationSchedule = (FuelAllocationSchedule)theEObject;
				Object result = caseFuelAllocationSchedule(fuelAllocationSchedule);
				if (result == null) result = caseCurveSchedule(fuelAllocationSchedule);
				if (result == null) result = caseNaming(fuelAllocationSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.FOSSIL_FUEL: {
				FossilFuel fossilFuel = (FossilFuel)theEObject;
				Object result = caseFossilFuel(fossilFuel);
				if (result == null) result = caseNaming(fossilFuel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.EMISSION_CURVE: {
				EmissionCurve emissionCurve = (EmissionCurve)theEObject;
				Object result = caseEmissionCurve(emissionCurve);
				if (result == null) result = caseCurveSchedule(emissionCurve);
				if (result == null) result = caseNaming(emissionCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.COMBINED_CYCLE_PLANT: {
				CombinedCyclePlant combinedCyclePlant = (CombinedCyclePlant)theEObject;
				Object result = caseCombinedCyclePlant(combinedCyclePlant);
				if (result == null) result = casePowerSystemResource(combinedCyclePlant);
				if (result == null) result = caseNaming(combinedCyclePlant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.COGENERATION_PLANT: {
				CogenerationPlant cogenerationPlant = (CogenerationPlant)theEObject;
				Object result = caseCogenerationPlant(cogenerationPlant);
				if (result == null) result = casePowerSystemResource(cogenerationPlant);
				if (result == null) result = caseNaming(cogenerationPlant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.CAES_PLANT: {
				CAESPlant caesPlant = (CAESPlant)theEObject;
				Object result = caseCAESPlant(caesPlant);
				if (result == null) result = casePowerSystemResource(caesPlant);
				if (result == null) result = caseNaming(caesPlant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.AIR_COMPRESSOR: {
				AirCompressor airCompressor = (AirCompressor)theEObject;
				Object result = caseAirCompressor(airCompressor);
				if (result == null) result = casePowerSystemResource(airCompressor);
				if (result == null) result = caseNaming(airCompressor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.EMISSION_ACCOUNT: {
				EmissionAccount emissionAccount = (EmissionAccount)theEObject;
				Object result = caseEmissionAccount(emissionAccount);
				if (result == null) result = caseAccountBalance(emissionAccount);
				if (result == null) result = caseCurveSchedule(emissionAccount);
				if (result == null) result = caseNaming(emissionAccount);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProductionPackage.ACCOUNT_BALANCE: {
				AccountBalance accountBalance = (AccountBalance)theEObject;
				Object result = caseAccountBalance(accountBalance);
				if (result == null) result = caseCurveSchedule(accountBalance);
				if (result == null) result = caseNaming(accountBalance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Thermal Generating Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Thermal Generating Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseThermalGeneratingUnit(ThermalGeneratingUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Target Level Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Target Level Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTargetLevelSchedule(TargetLevelSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tailbay Loss Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tailbay Loss Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTailbayLossCurve(TailbayLossCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Steam Sendout Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Steam Sendout Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSteamSendoutSchedule(SteamSendoutSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Startup Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Startup Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStartupModel(StartupModel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Start Ramp Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Start Ramp Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStartRampCurve(StartRampCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Start Main Fuel Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Start Main Fuel Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStartMainFuelCurve(StartMainFuelCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Start Ign Fuel Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Start Ign Fuel Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStartIgnFuelCurve(StartIgnFuelCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Shutdown Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Shutdown Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseShutdownCurve(ShutdownCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Reservoir</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Reservoir</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReservoir(Reservoir object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Penstock Loss Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Penstock Loss Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePenstockLossCurve(PenstockLossCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Level Vs Volume Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Level Vs Volume Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLevelVsVolumeCurve(LevelVsVolumeCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Inflow Forecast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Inflow Forecast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInflowForecast(InflowForecast object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Incremental Heat Rate Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Incremental Heat Rate Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIncrementalHeatRateCurve(IncrementalHeatRateCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Hydro Pump Op Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Hydro Pump Op Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHydroPumpOpSchedule(HydroPumpOpSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Hydro Pump</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Hydro Pump</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHydroPump(HydroPump object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Hydro Power Plant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Hydro Power Plant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHydroPowerPlant(HydroPowerPlant object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Hydro Generating Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Hydro Generating Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHydroGeneratingUnit(HydroGeneratingUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Hydro Generating Efficiency Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Hydro Generating Efficiency Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHydroGeneratingEfficiencyCurve(HydroGeneratingEfficiencyCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Heat Rate Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Heat Rate Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHeatRateCurve(HeatRateCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Heat Input Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Heat Input Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHeatInputCurve(HeatInputCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gross To Net MW Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gross To Net MW Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGrossToNetMWCurve(GrossToNetMWCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Unit Op Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Unit Op Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenUnitOpSchedule(GenUnitOpSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Unit Op Cost Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Unit Op Cost Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenUnitOpCostCurve(GenUnitOpCostCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Generating Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Generating Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGeneratingUnit(GeneratingUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Fuel Allocation Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Fuel Allocation Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFuelAllocationSchedule(FuelAllocationSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Fossil Fuel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Fossil Fuel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFossilFuel(FossilFuel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Emission Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Emission Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEmissionCurve(EmissionCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Combined Cycle Plant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Combined Cycle Plant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCombinedCyclePlant(CombinedCyclePlant object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Cogeneration Plant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Cogeneration Plant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCogenerationPlant(CogenerationPlant object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CAES Plant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CAES Plant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCAESPlant(CAESPlant object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Air Compressor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Air Compressor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAirCompressor(AirCompressor object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Emission Account</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Emission Account</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEmissionAccount(EmissionAccount object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Account Balance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Account Balance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAccountBalance(AccountBalance object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Naming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Naming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNaming(Naming object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Power System Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Power System Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerSystemResource(PowerSystemResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquipment(Equipment object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Curve Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Curve Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCurveSchedule(CurveSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ProductionSwitch
