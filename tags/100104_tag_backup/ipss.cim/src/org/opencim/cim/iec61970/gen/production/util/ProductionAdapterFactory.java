/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProductionAdapterFactory.java,v 1.1 2007/03/02 14:01:19 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.gen.production.*;

import org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage
 * @generated
 */
public class ProductionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProductionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProductionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductionSwitch modelSwitch =
		new ProductionSwitch() {
			public Object caseThermalGeneratingUnit(ThermalGeneratingUnit object) {
				return createThermalGeneratingUnitAdapter();
			}
			public Object caseTargetLevelSchedule(TargetLevelSchedule object) {
				return createTargetLevelScheduleAdapter();
			}
			public Object caseTailbayLossCurve(TailbayLossCurve object) {
				return createTailbayLossCurveAdapter();
			}
			public Object caseSteamSendoutSchedule(SteamSendoutSchedule object) {
				return createSteamSendoutScheduleAdapter();
			}
			public Object caseStartupModel(StartupModel object) {
				return createStartupModelAdapter();
			}
			public Object caseStartRampCurve(StartRampCurve object) {
				return createStartRampCurveAdapter();
			}
			public Object caseStartMainFuelCurve(StartMainFuelCurve object) {
				return createStartMainFuelCurveAdapter();
			}
			public Object caseStartIgnFuelCurve(StartIgnFuelCurve object) {
				return createStartIgnFuelCurveAdapter();
			}
			public Object caseShutdownCurve(ShutdownCurve object) {
				return createShutdownCurveAdapter();
			}
			public Object caseReservoir(Reservoir object) {
				return createReservoirAdapter();
			}
			public Object casePenstockLossCurve(PenstockLossCurve object) {
				return createPenstockLossCurveAdapter();
			}
			public Object caseLevelVsVolumeCurve(LevelVsVolumeCurve object) {
				return createLevelVsVolumeCurveAdapter();
			}
			public Object caseInflowForecast(InflowForecast object) {
				return createInflowForecastAdapter();
			}
			public Object caseIncrementalHeatRateCurve(IncrementalHeatRateCurve object) {
				return createIncrementalHeatRateCurveAdapter();
			}
			public Object caseHydroPumpOpSchedule(HydroPumpOpSchedule object) {
				return createHydroPumpOpScheduleAdapter();
			}
			public Object caseHydroPump(HydroPump object) {
				return createHydroPumpAdapter();
			}
			public Object caseHydroPowerPlant(HydroPowerPlant object) {
				return createHydroPowerPlantAdapter();
			}
			public Object caseHydroGeneratingUnit(HydroGeneratingUnit object) {
				return createHydroGeneratingUnitAdapter();
			}
			public Object caseHydroGeneratingEfficiencyCurve(HydroGeneratingEfficiencyCurve object) {
				return createHydroGeneratingEfficiencyCurveAdapter();
			}
			public Object caseHeatRateCurve(HeatRateCurve object) {
				return createHeatRateCurveAdapter();
			}
			public Object caseHeatInputCurve(HeatInputCurve object) {
				return createHeatInputCurveAdapter();
			}
			public Object caseGrossToNetMWCurve(GrossToNetMWCurve object) {
				return createGrossToNetMWCurveAdapter();
			}
			public Object caseGenUnitOpSchedule(GenUnitOpSchedule object) {
				return createGenUnitOpScheduleAdapter();
			}
			public Object caseGenUnitOpCostCurve(GenUnitOpCostCurve object) {
				return createGenUnitOpCostCurveAdapter();
			}
			public Object caseGeneratingUnit(GeneratingUnit object) {
				return createGeneratingUnitAdapter();
			}
			public Object caseFuelAllocationSchedule(FuelAllocationSchedule object) {
				return createFuelAllocationScheduleAdapter();
			}
			public Object caseFossilFuel(FossilFuel object) {
				return createFossilFuelAdapter();
			}
			public Object caseEmissionCurve(EmissionCurve object) {
				return createEmissionCurveAdapter();
			}
			public Object caseCombinedCyclePlant(CombinedCyclePlant object) {
				return createCombinedCyclePlantAdapter();
			}
			public Object caseCogenerationPlant(CogenerationPlant object) {
				return createCogenerationPlantAdapter();
			}
			public Object caseCAESPlant(CAESPlant object) {
				return createCAESPlantAdapter();
			}
			public Object caseAirCompressor(AirCompressor object) {
				return createAirCompressorAdapter();
			}
			public Object caseEmissionAccount(EmissionAccount object) {
				return createEmissionAccountAdapter();
			}
			public Object caseAccountBalance(AccountBalance object) {
				return createAccountBalanceAdapter();
			}
			public Object caseNaming(Naming object) {
				return createNamingAdapter();
			}
			public Object casePowerSystemResource(PowerSystemResource object) {
				return createPowerSystemResourceAdapter();
			}
			public Object caseEquipment(Equipment object) {
				return createEquipmentAdapter();
			}
			public Object caseCurveSchedule(CurveSchedule object) {
				return createCurveScheduleAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit <em>Thermal Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit
	 * @generated
	 */
	public Adapter createThermalGeneratingUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule <em>Target Level Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.TargetLevelSchedule
	 * @generated
	 */
	public Adapter createTargetLevelScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.TailbayLossCurve <em>Tailbay Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.TailbayLossCurve
	 * @generated
	 */
	public Adapter createTailbayLossCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.SteamSendoutSchedule <em>Steam Sendout Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.SteamSendoutSchedule
	 * @generated
	 */
	public Adapter createSteamSendoutScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.StartupModel <em>Startup Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel
	 * @generated
	 */
	public Adapter createStartupModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.StartRampCurve <em>Start Ramp Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.StartRampCurve
	 * @generated
	 */
	public Adapter createStartRampCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.StartMainFuelCurve <em>Start Main Fuel Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.StartMainFuelCurve
	 * @generated
	 */
	public Adapter createStartMainFuelCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve <em>Start Ign Fuel Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve
	 * @generated
	 */
	public Adapter createStartIgnFuelCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve <em>Shutdown Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.ShutdownCurve
	 * @generated
	 */
	public Adapter createShutdownCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.Reservoir <em>Reservoir</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir
	 * @generated
	 */
	public Adapter createReservoirAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.PenstockLossCurve <em>Penstock Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.PenstockLossCurve
	 * @generated
	 */
	public Adapter createPenstockLossCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve <em>Level Vs Volume Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve
	 * @generated
	 */
	public Adapter createLevelVsVolumeCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.InflowForecast <em>Inflow Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.InflowForecast
	 * @generated
	 */
	public Adapter createInflowForecastAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve <em>Incremental Heat Rate Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve
	 * @generated
	 */
	public Adapter createIncrementalHeatRateCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HydroPumpOpSchedule <em>Hydro Pump Op Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPumpOpSchedule
	 * @generated
	 */
	public Adapter createHydroPumpOpScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HydroPump <em>Hydro Pump</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump
	 * @generated
	 */
	public Adapter createHydroPumpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant <em>Hydro Power Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant
	 * @generated
	 */
	public Adapter createHydroPowerPlantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit <em>Hydro Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit
	 * @generated
	 */
	public Adapter createHydroGeneratingUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve <em>Hydro Generating Efficiency Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve
	 * @generated
	 */
	public Adapter createHydroGeneratingEfficiencyCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HeatRateCurve <em>Heat Rate Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HeatRateCurve
	 * @generated
	 */
	public Adapter createHeatRateCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve <em>Heat Input Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve
	 * @generated
	 */
	public Adapter createHeatInputCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve <em>Gross To Net MW Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve
	 * @generated
	 */
	public Adapter createGrossToNetMWCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.GenUnitOpSchedule <em>Gen Unit Op Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.GenUnitOpSchedule
	 * @generated
	 */
	public Adapter createGenUnitOpScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve <em>Gen Unit Op Cost Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve
	 * @generated
	 */
	public Adapter createGenUnitOpCostCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit <em>Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit
	 * @generated
	 */
	public Adapter createGeneratingUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule <em>Fuel Allocation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule
	 * @generated
	 */
	public Adapter createFuelAllocationScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.FossilFuel <em>Fossil Fuel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel
	 * @generated
	 */
	public Adapter createFossilFuelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve <em>Emission Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionCurve
	 * @generated
	 */
	public Adapter createEmissionCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant <em>Combined Cycle Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.CombinedCyclePlant
	 * @generated
	 */
	public Adapter createCombinedCyclePlantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant <em>Cogeneration Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant
	 * @generated
	 */
	public Adapter createCogenerationPlantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.CAESPlant <em>CAES Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant
	 * @generated
	 */
	public Adapter createCAESPlantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.AirCompressor <em>Air Compressor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.AirCompressor
	 * @generated
	 */
	public Adapter createAirCompressorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.EmissionAccount <em>Emission Account</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionAccount
	 * @generated
	 */
	public Adapter createEmissionAccountAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.production.AccountBalance <em>Account Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.production.AccountBalance
	 * @generated
	 */
	public Adapter createAccountBalanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Naming <em>Naming</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Naming
	 * @generated
	 */
	public Adapter createNamingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.PowerSystemResource <em>Power System Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource
	 * @generated
	 */
	public Adapter createPowerSystemResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Equipment <em>Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Equipment
	 * @generated
	 */
	public Adapter createEquipmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.CurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule
	 * @generated
	 */
	public Adapter createCurveScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ProductionAdapterFactory
