/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProductionFactoryImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.gen.production.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductionFactoryImpl extends EFactoryImpl implements ProductionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProductionFactory init() {
		try {
			ProductionFactory theProductionFactory = (ProductionFactory)EPackage.Registry.INSTANCE.getEFactory("http:///cim/production.ecore"); 
			if (theProductionFactory != null) {
				return theProductionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProductionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProductionPackage.THERMAL_GENERATING_UNIT: return createThermalGeneratingUnit();
			case ProductionPackage.TARGET_LEVEL_SCHEDULE: return createTargetLevelSchedule();
			case ProductionPackage.TAILBAY_LOSS_CURVE: return createTailbayLossCurve();
			case ProductionPackage.STEAM_SENDOUT_SCHEDULE: return createSteamSendoutSchedule();
			case ProductionPackage.STARTUP_MODEL: return createStartupModel();
			case ProductionPackage.START_RAMP_CURVE: return createStartRampCurve();
			case ProductionPackage.START_MAIN_FUEL_CURVE: return createStartMainFuelCurve();
			case ProductionPackage.START_IGN_FUEL_CURVE: return createStartIgnFuelCurve();
			case ProductionPackage.SHUTDOWN_CURVE: return createShutdownCurve();
			case ProductionPackage.RESERVOIR: return createReservoir();
			case ProductionPackage.PENSTOCK_LOSS_CURVE: return createPenstockLossCurve();
			case ProductionPackage.LEVEL_VS_VOLUME_CURVE: return createLevelVsVolumeCurve();
			case ProductionPackage.INFLOW_FORECAST: return createInflowForecast();
			case ProductionPackage.INCREMENTAL_HEAT_RATE_CURVE: return createIncrementalHeatRateCurve();
			case ProductionPackage.HYDRO_PUMP_OP_SCHEDULE: return createHydroPumpOpSchedule();
			case ProductionPackage.HYDRO_PUMP: return createHydroPump();
			case ProductionPackage.HYDRO_POWER_PLANT: return createHydroPowerPlant();
			case ProductionPackage.HYDRO_GENERATING_UNIT: return createHydroGeneratingUnit();
			case ProductionPackage.HYDRO_GENERATING_EFFICIENCY_CURVE: return createHydroGeneratingEfficiencyCurve();
			case ProductionPackage.HEAT_RATE_CURVE: return createHeatRateCurve();
			case ProductionPackage.HEAT_INPUT_CURVE: return createHeatInputCurve();
			case ProductionPackage.GROSS_TO_NET_MW_CURVE: return createGrossToNetMWCurve();
			case ProductionPackage.GEN_UNIT_OP_SCHEDULE: return createGenUnitOpSchedule();
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE: return createGenUnitOpCostCurve();
			case ProductionPackage.GENERATING_UNIT: return createGeneratingUnit();
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE: return createFuelAllocationSchedule();
			case ProductionPackage.FOSSIL_FUEL: return createFossilFuel();
			case ProductionPackage.EMISSION_CURVE: return createEmissionCurve();
			case ProductionPackage.COMBINED_CYCLE_PLANT: return createCombinedCyclePlant();
			case ProductionPackage.COGENERATION_PLANT: return createCogenerationPlant();
			case ProductionPackage.CAES_PLANT: return createCAESPlant();
			case ProductionPackage.AIR_COMPRESSOR: return createAirCompressor();
			case ProductionPackage.EMISSION_ACCOUNT: return createEmissionAccount();
			case ProductionPackage.ACCOUNT_BALANCE: return createAccountBalance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThermalGeneratingUnit createThermalGeneratingUnit() {
		ThermalGeneratingUnitImpl thermalGeneratingUnit = new ThermalGeneratingUnitImpl();
		return thermalGeneratingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetLevelSchedule createTargetLevelSchedule() {
		TargetLevelScheduleImpl targetLevelSchedule = new TargetLevelScheduleImpl();
		return targetLevelSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TailbayLossCurve createTailbayLossCurve() {
		TailbayLossCurveImpl tailbayLossCurve = new TailbayLossCurveImpl();
		return tailbayLossCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteamSendoutSchedule createSteamSendoutSchedule() {
		SteamSendoutScheduleImpl steamSendoutSchedule = new SteamSendoutScheduleImpl();
		return steamSendoutSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartupModel createStartupModel() {
		StartupModelImpl startupModel = new StartupModelImpl();
		return startupModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartRampCurve createStartRampCurve() {
		StartRampCurveImpl startRampCurve = new StartRampCurveImpl();
		return startRampCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartMainFuelCurve createStartMainFuelCurve() {
		StartMainFuelCurveImpl startMainFuelCurve = new StartMainFuelCurveImpl();
		return startMainFuelCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartIgnFuelCurve createStartIgnFuelCurve() {
		StartIgnFuelCurveImpl startIgnFuelCurve = new StartIgnFuelCurveImpl();
		return startIgnFuelCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShutdownCurve createShutdownCurve() {
		ShutdownCurveImpl shutdownCurve = new ShutdownCurveImpl();
		return shutdownCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reservoir createReservoir() {
		ReservoirImpl reservoir = new ReservoirImpl();
		return reservoir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PenstockLossCurve createPenstockLossCurve() {
		PenstockLossCurveImpl penstockLossCurve = new PenstockLossCurveImpl();
		return penstockLossCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelVsVolumeCurve createLevelVsVolumeCurve() {
		LevelVsVolumeCurveImpl levelVsVolumeCurve = new LevelVsVolumeCurveImpl();
		return levelVsVolumeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InflowForecast createInflowForecast() {
		InflowForecastImpl inflowForecast = new InflowForecastImpl();
		return inflowForecast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementalHeatRateCurve createIncrementalHeatRateCurve() {
		IncrementalHeatRateCurveImpl incrementalHeatRateCurve = new IncrementalHeatRateCurveImpl();
		return incrementalHeatRateCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPumpOpSchedule createHydroPumpOpSchedule() {
		HydroPumpOpScheduleImpl hydroPumpOpSchedule = new HydroPumpOpScheduleImpl();
		return hydroPumpOpSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPump createHydroPump() {
		HydroPumpImpl hydroPump = new HydroPumpImpl();
		return hydroPump;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPowerPlant createHydroPowerPlant() {
		HydroPowerPlantImpl hydroPowerPlant = new HydroPowerPlantImpl();
		return hydroPowerPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroGeneratingUnit createHydroGeneratingUnit() {
		HydroGeneratingUnitImpl hydroGeneratingUnit = new HydroGeneratingUnitImpl();
		return hydroGeneratingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroGeneratingEfficiencyCurve createHydroGeneratingEfficiencyCurve() {
		HydroGeneratingEfficiencyCurveImpl hydroGeneratingEfficiencyCurve = new HydroGeneratingEfficiencyCurveImpl();
		return hydroGeneratingEfficiencyCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatRateCurve createHeatRateCurve() {
		HeatRateCurveImpl heatRateCurve = new HeatRateCurveImpl();
		return heatRateCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatInputCurve createHeatInputCurve() {
		HeatInputCurveImpl heatInputCurve = new HeatInputCurveImpl();
		return heatInputCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrossToNetMWCurve createGrossToNetMWCurve() {
		GrossToNetMWCurveImpl grossToNetMWCurve = new GrossToNetMWCurveImpl();
		return grossToNetMWCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenUnitOpSchedule createGenUnitOpSchedule() {
		GenUnitOpScheduleImpl genUnitOpSchedule = new GenUnitOpScheduleImpl();
		return genUnitOpSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenUnitOpCostCurve createGenUnitOpCostCurve() {
		GenUnitOpCostCurveImpl genUnitOpCostCurve = new GenUnitOpCostCurveImpl();
		return genUnitOpCostCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratingUnit createGeneratingUnit() {
		GeneratingUnitImpl generatingUnit = new GeneratingUnitImpl();
		return generatingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuelAllocationSchedule createFuelAllocationSchedule() {
		FuelAllocationScheduleImpl fuelAllocationSchedule = new FuelAllocationScheduleImpl();
		return fuelAllocationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FossilFuel createFossilFuel() {
		FossilFuelImpl fossilFuel = new FossilFuelImpl();
		return fossilFuel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionCurve createEmissionCurve() {
		EmissionCurveImpl emissionCurve = new EmissionCurveImpl();
		return emissionCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedCyclePlant createCombinedCyclePlant() {
		CombinedCyclePlantImpl combinedCyclePlant = new CombinedCyclePlantImpl();
		return combinedCyclePlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CogenerationPlant createCogenerationPlant() {
		CogenerationPlantImpl cogenerationPlant = new CogenerationPlantImpl();
		return cogenerationPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAESPlant createCAESPlant() {
		CAESPlantImpl caesPlant = new CAESPlantImpl();
		return caesPlant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AirCompressor createAirCompressor() {
		AirCompressorImpl airCompressor = new AirCompressorImpl();
		return airCompressor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionAccount createEmissionAccount() {
		EmissionAccountImpl emissionAccount = new EmissionAccountImpl();
		return emissionAccount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccountBalance createAccountBalance() {
		AccountBalanceImpl accountBalance = new AccountBalanceImpl();
		return accountBalance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionPackage getProductionPackage() {
		return (ProductionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ProductionPackage getPackage() {
		return ProductionPackage.eINSTANCE;
	}

} //ProductionFactoryImpl
