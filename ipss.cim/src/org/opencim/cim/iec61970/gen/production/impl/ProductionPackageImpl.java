/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProductionPackageImpl.java,v 1.4 2007/03/07 16:03:49 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.Iec61970Package;

import org.opencim.cim.iec61970.core.CorePackage;

import org.opencim.cim.iec61970.core.impl.CorePackageImpl;

import org.opencim.cim.iec61970.domain.DomainPackage;

import org.opencim.cim.iec61970.domain.impl.DomainPackageImpl;

import org.opencim.cim.iec61970.gen.GenPackage;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;

import org.opencim.cim.iec61970.gen.generationdynamics.impl.GenerationdynamicsPackageImpl;

import org.opencim.cim.iec61970.gen.impl.GenPackageImpl;

import org.opencim.cim.iec61970.gen.production.AccountBalance;
import org.opencim.cim.iec61970.gen.production.AirCompressor;
import org.opencim.cim.iec61970.gen.production.CAESPlant;
import org.opencim.cim.iec61970.gen.production.CogenerationPlant;
import org.opencim.cim.iec61970.gen.production.CombinedCyclePlant;
import org.opencim.cim.iec61970.gen.production.EmissionAccount;
import org.opencim.cim.iec61970.gen.production.EmissionCurve;
import org.opencim.cim.iec61970.gen.production.FossilFuel;
import org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule;
import org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve;
import org.opencim.cim.iec61970.gen.production.GenUnitOpSchedule;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve;
import org.opencim.cim.iec61970.gen.production.HeatInputCurve;
import org.opencim.cim.iec61970.gen.production.HeatRateCurve;
import org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve;
import org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit;
import org.opencim.cim.iec61970.gen.production.HydroPowerPlant;
import org.opencim.cim.iec61970.gen.production.HydroPump;
import org.opencim.cim.iec61970.gen.production.HydroPumpOpSchedule;
import org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve;
import org.opencim.cim.iec61970.gen.production.InflowForecast;
import org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve;
import org.opencim.cim.iec61970.gen.production.PenstockLossCurve;
import org.opencim.cim.iec61970.gen.production.ProductionFactory;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.Reservoir;
import org.opencim.cim.iec61970.gen.production.ShutdownCurve;
import org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve;
import org.opencim.cim.iec61970.gen.production.StartMainFuelCurve;
import org.opencim.cim.iec61970.gen.production.StartRampCurve;
import org.opencim.cim.iec61970.gen.production.StartupModel;
import org.opencim.cim.iec61970.gen.production.SteamSendoutSchedule;
import org.opencim.cim.iec61970.gen.production.TailbayLossCurve;
import org.opencim.cim.iec61970.gen.production.TargetLevelSchedule;
import org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit;

import org.opencim.cim.iec61970.impl.Iec61970PackageImpl;

import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.topology.TopologyPackage;

import org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.impl.cimPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductionPackageImpl extends EPackageImpl implements ProductionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thermalGeneratingUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetLevelScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tailbayLossCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass steamSendoutScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startupModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startRampCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startMainFuelCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startIgnFuelCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shutdownCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reservoirEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass penstockLossCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass levelVsVolumeCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inflowForecastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementalHeatRateCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hydroPumpOpScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hydroPumpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hydroPowerPlantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hydroGeneratingUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hydroGeneratingEfficiencyCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass heatRateCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass heatInputCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass grossToNetMWCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genUnitOpScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genUnitOpCostCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatingUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuelAllocationScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fossilFuelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emissionCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinedCyclePlantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cogenerationPlantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caesPlantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass airCompressorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emissionAccountEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accountBalanceEClass = null;

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
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProductionPackageImpl() {
		super(eNS_URI, ProductionFactory.eINSTANCE);
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
	public static ProductionPackage init() {
		if (isInited) return (ProductionPackage)EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI);

		// Obtain or create and register package
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ProductionPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) : cimPackage.eINSTANCE);
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) : Iec61970Package.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) : LoadPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) : WirePackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		theProductionPackage.createPackageContents();
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		theProductionPackage.initializePackageContents();
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProductionPackage.freeze();

		return theProductionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThermalGeneratingUnit() {
		return thermalGeneratingUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThermalGeneratingUnit_OMCost() {
		return (EAttribute)thermalGeneratingUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_EmmissionAccounts() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_EmissionCurves() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_FossilFuels() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_FuelAllocationSchedules() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_HeatInputCurve() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_HeatRateCurve() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_IncrementalHeatRateCurve() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_ShutdownCurve() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_StartupModel() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_MemberOf_CAESPlant() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_MembmerOf_CogenerationPlant() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThermalGeneratingUnit_MemberOf_CombinedCyclePlant() {
		return (EReference)thermalGeneratingUnitEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetLevelSchedule() {
		return targetLevelScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetLevelSchedule_HighLevelLimit() {
		return (EAttribute)targetLevelScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetLevelSchedule_LowLevelLimit() {
		return (EAttribute)targetLevelScheduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTailbayLossCurve() {
		return tailbayLossCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSteamSendoutSchedule() {
		return steamSendoutScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartupModel() {
		return startupModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_FixedMaintCost() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_HotStandbyHeat() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_IncrementalMaintCost() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_MinimumDownTime() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_MinimumRunTime() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_RiskFactorCost() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_StartupCost() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_StartupDate() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_StartupPriority() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartupModel_StbyAuxPowerMW() {
		return (EAttribute)startupModelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartupModel_StartIgnFuelCurve() {
		return (EReference)startupModelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartupModel_StartMainFuelCurve() {
		return (EReference)startupModelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartupModel_StartRampCurve() {
		return (EReference)startupModelEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartRampCurve() {
		return startRampCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartRampCurve_HotStandbyRamp() {
		return (EAttribute)startRampCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartMainFuelCurve() {
		return startMainFuelCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartMainFuelCurve_MainFuelType() {
		return (EAttribute)startMainFuelCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartIgnFuelCurve() {
		return startIgnFuelCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartIgnFuelCurve_IgnitionFuelType() {
		return (EAttribute)startIgnFuelCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShutdownCurve() {
		return shutdownCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShutdownCurve_ShutdownCost() {
		return (EAttribute)shutdownCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShutdownCurve_ShutdownDate() {
		return (EAttribute)shutdownCurveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReservoir() {
		return reservoirEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_ActiveStorageCapacity() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_EnergyStorageRating() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_FullSupplyLevel() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_GrossCapacity() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_NormalMinOperateLevel() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_RiverOutletWorks() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_SpillTravelDelay() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_SpillwayCapacity() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_SpillwayCrestLength() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_SpillwayCrestLevel() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReservoir_SpillWayGateType() {
		return (EAttribute)reservoirEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_HydroPowerPlants() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_UpstreamFrom() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_LevelVsVolumeCurve() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_TargetLevelSchedule() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_InflowForecast() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_SpillsInto() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservoir_SpillsFrom() {
		return (EReference)reservoirEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPenstockLossCurve() {
		return penstockLossCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLevelVsVolumeCurve() {
		return levelVsVolumeCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInflowForecast() {
		return inflowForecastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncrementalHeatRateCurve() {
		return incrementalHeatRateCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementalHeatRateCurve_NetGrossMWFlag() {
		return (EAttribute)incrementalHeatRateCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHydroPumpOpSchedule() {
		return hydroPumpOpScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHydroPump() {
		return hydroPumpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPump_PumpDischAtMaxHead() {
		return (EAttribute)hydroPumpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPump_PumpDischAtMinHead() {
		return (EAttribute)hydroPumpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPump_PumpPowerAtMaxHead() {
		return (EAttribute)hydroPumpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPump_PumpPowerAtMinHead() {
		return (EAttribute)hydroPumpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroPump_HydroPumpOpSchedule() {
		return (EReference)hydroPumpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHydroPowerPlant() {
		return hydroPowerPlantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_DischargeTravelDelay() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_HydroPlantType() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_PenstockType() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_PlantDischargeCapacity() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_PlantMWGenRating() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_PlantMWPumpRating() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_PlantRatedHead() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_SurgeTankCode() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroPowerPlant_SurgeTankCrestLevel() {
		return (EAttribute)hydroPowerPlantEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroPowerPlant_Contain_HydroGeneratingUnits() {
		return (EReference)hydroPowerPlantEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroPowerPlant_Contain_HydroPumps() {
		return (EReference)hydroPowerPlantEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroPowerPlant_Reservoir() {
		return (EReference)hydroPowerPlantEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroPowerPlant_GenSourcePumpDischarge() {
		return (EReference)hydroPowerPlantEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHydroGeneratingUnit() {
		return hydroGeneratingUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroGeneratingUnit_HydroUnitWaterCost() {
		return (EAttribute)hydroGeneratingUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroGeneratingUnit_HydroGeneratingEfficiencyCurves() {
		return (EReference)hydroGeneratingUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroGeneratingUnit_PenstockLossCurve() {
		return (EReference)hydroGeneratingUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHydroGeneratingUnit_TailbayLossCurve() {
		return (EReference)hydroGeneratingUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHydroGeneratingEfficiencyCurve() {
		return hydroGeneratingEfficiencyCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeatRateCurve() {
		return heatRateCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatRateCurve_NetGrossMWFlag() {
		return (EAttribute)heatRateCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeatInputCurve() {
		return heatInputCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatInputCurve_AuxPowerOffset() {
		return (EAttribute)heatInputCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatInputCurve_AuxPowerMult() {
		return (EAttribute)heatInputCurveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatInputCurve_HeatInputEff() {
		return (EAttribute)heatInputCurveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatInputCurve_HeatInputOffset() {
		return (EAttribute)heatInputCurveEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatInputCurve_NetGrossMWFlag() {
		return (EAttribute)heatInputCurveEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGrossToNetMWCurve() {
		return grossToNetMWCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenUnitOpSchedule() {
		return genUnitOpScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenUnitOpCostCurve() {
		return genUnitOpCostCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenUnitOpCostCurve_NetGrossMWFlag() {
		return (EAttribute)genUnitOpCostCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratingUnit() {
		return generatingUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_ControlDeadband() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_ControlPulseHigh() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_ControlPulseLow() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_ControlResponseRate() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_Efficiency() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_GenControlMode() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_GenControlSource() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_GovernorMPL() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_GovernorSCD() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_HighControlLimit() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_InitialMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_LowControlLimit() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_MaximumAllowableSpinningReserve() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_MaximumEconomicMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_MaximumOperatingMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_MinimumEconomicMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_MinimumOperatingMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_ModelDetail() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_RatedGrossMaxMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_RatedGrossMinMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_RatedNetMaxMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_StartupTime() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_AutoCntrlMarginMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_AllocSpinResMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_BaseMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_DispReserveFlag() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_EnergyMinMW() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_FastStartFlag() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_FuelPriority() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_GenOperatingMode() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_LongPF() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_LowerRampRate() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_NormalPF() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_PenaltyFactor() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_RaiseRampRate() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_ShortPF() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_SpinReserveRamp() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_StepChange() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_TieLinePF() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratingUnit_MinimumOffTime() {
		return (EAttribute)generatingUnitEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratingUnit_GenUnitOpCostCurves() {
		return (EReference)generatingUnitEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratingUnit_GenUnitOpSchedule() {
		return (EReference)generatingUnitEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratingUnit_GrossToNetMWCurves() {
		return (EReference)generatingUnitEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratingUnit_SubControlArea() {
		return (EReference)generatingUnitEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratingUnit_SynchronousMachines() {
		return (EReference)generatingUnitEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuelAllocationSchedule() {
		return fuelAllocationScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuelAllocationSchedule_FuelAllocationEndDate() {
		return (EAttribute)fuelAllocationScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuelAllocationSchedule_FuelAllocationStartDate() {
		return (EAttribute)fuelAllocationScheduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuelAllocationSchedule_FuelType() {
		return (EAttribute)fuelAllocationScheduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuelAllocationSchedule_MaxFuelAllocation() {
		return (EAttribute)fuelAllocationScheduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuelAllocationSchedule_MinFuelAllocation() {
		return (EAttribute)fuelAllocationScheduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuelAllocationSchedule_FossilFuel() {
		return (EReference)fuelAllocationScheduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFossilFuel() {
		return fossilFuelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FossilFuelType() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelCost() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelDispatchCost() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelEffFactor() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelHandlingCost() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelHeatContent() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelMixture() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_FuelSulfur() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_HighMWBreakpoint() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilFuel_LowMWBreakpoint() {
		return (EAttribute)fossilFuelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFossilFuel_FuelAllocationSchedule() {
		return (EReference)fossilFuelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFossilFuel_ThermalGeneratingUnit() {
		return (EReference)fossilFuelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmissionCurve() {
		return emissionCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmissionCurve_EmissionContent() {
		return (EAttribute)emissionCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmissionCurve_EmissionType() {
		return (EAttribute)emissionCurveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmissionCurve_NetGrossMWFlag() {
		return (EAttribute)emissionCurveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombinedCyclePlant() {
		return combinedCyclePlantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedCyclePlant_CombCyclePlantRating() {
		return (EAttribute)combinedCyclePlantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedCyclePlant_Contain_ThermalGeneratingUnits() {
		return (EReference)combinedCyclePlantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCogenerationPlant() {
		return cogenerationPlantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCogenerationPlant_CogenHPSendoutRating() {
		return (EAttribute)cogenerationPlantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCogenerationPlant_CogenHPSteamRating() {
		return (EAttribute)cogenerationPlantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCogenerationPlant_CogenLPSendoutRating() {
		return (EAttribute)cogenerationPlantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCogenerationPlant_CogenLPSteamRating() {
		return (EAttribute)cogenerationPlantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCogenerationPlant_CogenPlantMWRating() {
		return (EAttribute)cogenerationPlantEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCogenerationPlant_Contain_ThermalGeneratingUnits() {
		return (EReference)cogenerationPlantEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCogenerationPlant_SteamSendoutSchedule() {
		return (EReference)cogenerationPlantEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCAESPlant() {
		return caesPlantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAESPlant_EnergyStorageCapacity() {
		return (EAttribute)caesPlantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAESPlant_RatedCapacityMW() {
		return (EAttribute)caesPlantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAESPlant_Contain_AirCompressor() {
		return (EReference)caesPlantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAESPlant_Contain_ThermalGeneratingUnit() {
		return (EReference)caesPlantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAirCompressor() {
		return airCompressorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAirCompressor_AirCompressorRating() {
		return (EAttribute)airCompressorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAirCompressor_CombustionTurbine() {
		return (EReference)airCompressorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmissionAccount() {
		return emissionAccountEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmissionAccount_EmissionType() {
		return (EAttribute)emissionAccountEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmissionAccount_EmissionValueSource() {
		return (EAttribute)emissionAccountEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccountBalance() {
		return accountBalanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionFactory getProductionFactory() {
		return (ProductionFactory)getEFactoryInstance();
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
		thermalGeneratingUnitEClass = createEClass(THERMAL_GENERATING_UNIT);
		createEAttribute(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__OM_COST);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__EMISSION_CURVES);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__FOSSIL_FUELS);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__STARTUP_MODEL);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT);
		createEReference(thermalGeneratingUnitEClass, THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT);

		targetLevelScheduleEClass = createEClass(TARGET_LEVEL_SCHEDULE);
		createEAttribute(targetLevelScheduleEClass, TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT);
		createEAttribute(targetLevelScheduleEClass, TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT);

		tailbayLossCurveEClass = createEClass(TAILBAY_LOSS_CURVE);

		steamSendoutScheduleEClass = createEClass(STEAM_SENDOUT_SCHEDULE);

		startupModelEClass = createEClass(STARTUP_MODEL);
		createEAttribute(startupModelEClass, STARTUP_MODEL__FIXED_MAINT_COST);
		createEAttribute(startupModelEClass, STARTUP_MODEL__HOT_STANDBY_HEAT);
		createEAttribute(startupModelEClass, STARTUP_MODEL__INCREMENTAL_MAINT_COST);
		createEAttribute(startupModelEClass, STARTUP_MODEL__MINIMUM_DOWN_TIME);
		createEAttribute(startupModelEClass, STARTUP_MODEL__MINIMUM_RUN_TIME);
		createEAttribute(startupModelEClass, STARTUP_MODEL__RISK_FACTOR_COST);
		createEAttribute(startupModelEClass, STARTUP_MODEL__STARTUP_COST);
		createEAttribute(startupModelEClass, STARTUP_MODEL__STARTUP_DATE);
		createEAttribute(startupModelEClass, STARTUP_MODEL__STARTUP_PRIORITY);
		createEAttribute(startupModelEClass, STARTUP_MODEL__STBY_AUX_POWER_MW);
		createEReference(startupModelEClass, STARTUP_MODEL__START_IGN_FUEL_CURVE);
		createEReference(startupModelEClass, STARTUP_MODEL__START_MAIN_FUEL_CURVE);
		createEReference(startupModelEClass, STARTUP_MODEL__START_RAMP_CURVE);

		startRampCurveEClass = createEClass(START_RAMP_CURVE);
		createEAttribute(startRampCurveEClass, START_RAMP_CURVE__HOT_STANDBY_RAMP);

		startMainFuelCurveEClass = createEClass(START_MAIN_FUEL_CURVE);
		createEAttribute(startMainFuelCurveEClass, START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE);

		startIgnFuelCurveEClass = createEClass(START_IGN_FUEL_CURVE);
		createEAttribute(startIgnFuelCurveEClass, START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE);

		shutdownCurveEClass = createEClass(SHUTDOWN_CURVE);
		createEAttribute(shutdownCurveEClass, SHUTDOWN_CURVE__SHUTDOWN_COST);
		createEAttribute(shutdownCurveEClass, SHUTDOWN_CURVE__SHUTDOWN_DATE);

		reservoirEClass = createEClass(RESERVOIR);
		createEAttribute(reservoirEClass, RESERVOIR__ACTIVE_STORAGE_CAPACITY);
		createEAttribute(reservoirEClass, RESERVOIR__ENERGY_STORAGE_RATING);
		createEAttribute(reservoirEClass, RESERVOIR__FULL_SUPPLY_LEVEL);
		createEAttribute(reservoirEClass, RESERVOIR__GROSS_CAPACITY);
		createEAttribute(reservoirEClass, RESERVOIR__NORMAL_MIN_OPERATE_LEVEL);
		createEAttribute(reservoirEClass, RESERVOIR__RIVER_OUTLET_WORKS);
		createEAttribute(reservoirEClass, RESERVOIR__SPILL_TRAVEL_DELAY);
		createEAttribute(reservoirEClass, RESERVOIR__SPILLWAY_CAPACITY);
		createEAttribute(reservoirEClass, RESERVOIR__SPILLWAY_CREST_LENGTH);
		createEAttribute(reservoirEClass, RESERVOIR__SPILLWAY_CREST_LEVEL);
		createEAttribute(reservoirEClass, RESERVOIR__SPILL_WAY_GATE_TYPE);
		createEReference(reservoirEClass, RESERVOIR__HYDRO_POWER_PLANTS);
		createEReference(reservoirEClass, RESERVOIR__UPSTREAM_FROM);
		createEReference(reservoirEClass, RESERVOIR__LEVEL_VS_VOLUME_CURVE);
		createEReference(reservoirEClass, RESERVOIR__TARGET_LEVEL_SCHEDULE);
		createEReference(reservoirEClass, RESERVOIR__INFLOW_FORECAST);
		createEReference(reservoirEClass, RESERVOIR__SPILLS_INTO);
		createEReference(reservoirEClass, RESERVOIR__SPILLS_FROM);

		penstockLossCurveEClass = createEClass(PENSTOCK_LOSS_CURVE);

		levelVsVolumeCurveEClass = createEClass(LEVEL_VS_VOLUME_CURVE);

		inflowForecastEClass = createEClass(INFLOW_FORECAST);

		incrementalHeatRateCurveEClass = createEClass(INCREMENTAL_HEAT_RATE_CURVE);
		createEAttribute(incrementalHeatRateCurveEClass, INCREMENTAL_HEAT_RATE_CURVE__NET_GROSS_MW_FLAG);

		hydroPumpOpScheduleEClass = createEClass(HYDRO_PUMP_OP_SCHEDULE);

		hydroPumpEClass = createEClass(HYDRO_PUMP);
		createEAttribute(hydroPumpEClass, HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD);
		createEAttribute(hydroPumpEClass, HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD);
		createEAttribute(hydroPumpEClass, HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD);
		createEAttribute(hydroPumpEClass, HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD);
		createEReference(hydroPumpEClass, HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE);

		hydroPowerPlantEClass = createEClass(HYDRO_POWER_PLANT);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__PENSTOCK_TYPE);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__PLANT_RATED_HEAD);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__SURGE_TANK_CODE);
		createEAttribute(hydroPowerPlantEClass, HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL);
		createEReference(hydroPowerPlantEClass, HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS);
		createEReference(hydroPowerPlantEClass, HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS);
		createEReference(hydroPowerPlantEClass, HYDRO_POWER_PLANT__RESERVOIR);
		createEReference(hydroPowerPlantEClass, HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE);

		hydroGeneratingUnitEClass = createEClass(HYDRO_GENERATING_UNIT);
		createEAttribute(hydroGeneratingUnitEClass, HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST);
		createEReference(hydroGeneratingUnitEClass, HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES);
		createEReference(hydroGeneratingUnitEClass, HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE);
		createEReference(hydroGeneratingUnitEClass, HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE);

		hydroGeneratingEfficiencyCurveEClass = createEClass(HYDRO_GENERATING_EFFICIENCY_CURVE);

		heatRateCurveEClass = createEClass(HEAT_RATE_CURVE);
		createEAttribute(heatRateCurveEClass, HEAT_RATE_CURVE__NET_GROSS_MW_FLAG);

		heatInputCurveEClass = createEClass(HEAT_INPUT_CURVE);
		createEAttribute(heatInputCurveEClass, HEAT_INPUT_CURVE__AUX_POWER_OFFSET);
		createEAttribute(heatInputCurveEClass, HEAT_INPUT_CURVE__AUX_POWER_MULT);
		createEAttribute(heatInputCurveEClass, HEAT_INPUT_CURVE__HEAT_INPUT_EFF);
		createEAttribute(heatInputCurveEClass, HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET);
		createEAttribute(heatInputCurveEClass, HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG);

		grossToNetMWCurveEClass = createEClass(GROSS_TO_NET_MW_CURVE);

		genUnitOpScheduleEClass = createEClass(GEN_UNIT_OP_SCHEDULE);

		genUnitOpCostCurveEClass = createEClass(GEN_UNIT_OP_COST_CURVE);
		createEAttribute(genUnitOpCostCurveEClass, GEN_UNIT_OP_COST_CURVE__NET_GROSS_MW_FLAG);

		generatingUnitEClass = createEClass(GENERATING_UNIT);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__CONTROL_DEADBAND);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__CONTROL_PULSE_HIGH);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__CONTROL_PULSE_LOW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__CONTROL_RESPONSE_RATE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__EFFICIENCY);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__GEN_CONTROL_MODE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__GEN_CONTROL_SOURCE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__GOVERNOR_MPL);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__GOVERNOR_SCD);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__HIGH_CONTROL_LIMIT);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__INITIAL_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__LOW_CONTROL_LIMIT);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MAXIMUM_ECONOMIC_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MAXIMUM_OPERATING_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MINIMUM_ECONOMIC_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MINIMUM_OPERATING_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MODEL_DETAIL);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__RATED_GROSS_MAX_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__RATED_GROSS_MIN_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__RATED_NET_MAX_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__STARTUP_TIME);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__ALLOC_SPIN_RES_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__BASE_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__DISP_RESERVE_FLAG);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__ENERGY_MIN_MW);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__FAST_START_FLAG);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__FUEL_PRIORITY);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__GEN_OPERATING_MODE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__LONG_PF);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__LOWER_RAMP_RATE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__NORMAL_PF);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__PENALTY_FACTOR);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__RAISE_RAMP_RATE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__SHORT_PF);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__SPIN_RESERVE_RAMP);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__STEP_CHANGE);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__TIE_LINE_PF);
		createEAttribute(generatingUnitEClass, GENERATING_UNIT__MINIMUM_OFF_TIME);
		createEReference(generatingUnitEClass, GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES);
		createEReference(generatingUnitEClass, GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE);
		createEReference(generatingUnitEClass, GENERATING_UNIT__GROSS_TO_NET_MW_CURVES);
		createEReference(generatingUnitEClass, GENERATING_UNIT__SUB_CONTROL_AREA);
		createEReference(generatingUnitEClass, GENERATING_UNIT__SYNCHRONOUS_MACHINES);

		fuelAllocationScheduleEClass = createEClass(FUEL_ALLOCATION_SCHEDULE);
		createEAttribute(fuelAllocationScheduleEClass, FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE);
		createEAttribute(fuelAllocationScheduleEClass, FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE);
		createEAttribute(fuelAllocationScheduleEClass, FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE);
		createEAttribute(fuelAllocationScheduleEClass, FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION);
		createEAttribute(fuelAllocationScheduleEClass, FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION);
		createEReference(fuelAllocationScheduleEClass, FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL);

		fossilFuelEClass = createEClass(FOSSIL_FUEL);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FOSSIL_FUEL_TYPE);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_COST);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_DISPATCH_COST);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_EFF_FACTOR);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_HANDLING_COST);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_HEAT_CONTENT);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_MIXTURE);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__FUEL_SULFUR);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__HIGH_MW_BREAKPOINT);
		createEAttribute(fossilFuelEClass, FOSSIL_FUEL__LOW_MW_BREAKPOINT);
		createEReference(fossilFuelEClass, FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE);
		createEReference(fossilFuelEClass, FOSSIL_FUEL__THERMAL_GENERATING_UNIT);

		emissionCurveEClass = createEClass(EMISSION_CURVE);
		createEAttribute(emissionCurveEClass, EMISSION_CURVE__EMISSION_CONTENT);
		createEAttribute(emissionCurveEClass, EMISSION_CURVE__EMISSION_TYPE);
		createEAttribute(emissionCurveEClass, EMISSION_CURVE__NET_GROSS_MW_FLAG);

		combinedCyclePlantEClass = createEClass(COMBINED_CYCLE_PLANT);
		createEAttribute(combinedCyclePlantEClass, COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING);
		createEReference(combinedCyclePlantEClass, COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS);

		cogenerationPlantEClass = createEClass(COGENERATION_PLANT);
		createEAttribute(cogenerationPlantEClass, COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING);
		createEAttribute(cogenerationPlantEClass, COGENERATION_PLANT__COGEN_HP_STEAM_RATING);
		createEAttribute(cogenerationPlantEClass, COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING);
		createEAttribute(cogenerationPlantEClass, COGENERATION_PLANT__COGEN_LP_STEAM_RATING);
		createEAttribute(cogenerationPlantEClass, COGENERATION_PLANT__COGEN_PLANT_MW_RATING);
		createEReference(cogenerationPlantEClass, COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS);
		createEReference(cogenerationPlantEClass, COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE);

		caesPlantEClass = createEClass(CAES_PLANT);
		createEAttribute(caesPlantEClass, CAES_PLANT__ENERGY_STORAGE_CAPACITY);
		createEAttribute(caesPlantEClass, CAES_PLANT__RATED_CAPACITY_MW);
		createEReference(caesPlantEClass, CAES_PLANT__CONTAIN_AIR_COMPRESSOR);
		createEReference(caesPlantEClass, CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT);

		airCompressorEClass = createEClass(AIR_COMPRESSOR);
		createEAttribute(airCompressorEClass, AIR_COMPRESSOR__AIR_COMPRESSOR_RATING);
		createEReference(airCompressorEClass, AIR_COMPRESSOR__COMBUSTION_TURBINE);

		emissionAccountEClass = createEClass(EMISSION_ACCOUNT);
		createEAttribute(emissionAccountEClass, EMISSION_ACCOUNT__EMISSION_TYPE);
		createEAttribute(emissionAccountEClass, EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE);

		accountBalanceEClass = createEClass(ACCOUNT_BALANCE);
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

		// Obtain other dependent packages
		DomainPackage theDomainPackage = (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		WirePackage theWirePackage = (WirePackage)EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI);
		GenerationdynamicsPackage theGenerationdynamicsPackage = (GenerationdynamicsPackage)EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI);

		// Add supertypes to classes
		thermalGeneratingUnitEClass.getESuperTypes().add(this.getGeneratingUnit());
		targetLevelScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		tailbayLossCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		steamSendoutScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		startupModelEClass.getESuperTypes().add(theCorePackage.getNaming());
		startRampCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		startMainFuelCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		startIgnFuelCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		shutdownCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		reservoirEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		penstockLossCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		levelVsVolumeCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		inflowForecastEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		incrementalHeatRateCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		hydroPumpOpScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		hydroPumpEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		hydroPowerPlantEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		hydroGeneratingUnitEClass.getESuperTypes().add(this.getGeneratingUnit());
		hydroGeneratingEfficiencyCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		heatRateCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		heatInputCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		grossToNetMWCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		genUnitOpScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		genUnitOpCostCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		generatingUnitEClass.getESuperTypes().add(theCorePackage.getEquipment());
		fuelAllocationScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		fossilFuelEClass.getESuperTypes().add(theCorePackage.getNaming());
		emissionCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		combinedCyclePlantEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		cogenerationPlantEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		caesPlantEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		airCompressorEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		emissionAccountEClass.getESuperTypes().add(this.getAccountBalance());
		accountBalanceEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());

		// Initialize classes and features; add operations and parameters
		initEClass(thermalGeneratingUnitEClass, ThermalGeneratingUnit.class, "ThermalGeneratingUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThermalGeneratingUnit_OMCost(), theDomainPackage.getCostPerHeatUnit(), "oMCost", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_EmmissionAccounts(), this.getEmissionAccount(), null, "EmmissionAccounts", null, 0, -1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_EmissionCurves(), this.getEmissionCurve(), null, "EmissionCurves", null, 0, -1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_FossilFuels(), this.getFossilFuel(), this.getFossilFuel_ThermalGeneratingUnit(), "FossilFuels", null, 0, -1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_FuelAllocationSchedules(), this.getFuelAllocationSchedule(), null, "FuelAllocationSchedules", null, 0, -1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_HeatInputCurve(), this.getHeatInputCurve(), null, "HeatInputCurve", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_HeatRateCurve(), this.getHeatRateCurve(), null, "HeatRateCurve", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_IncrementalHeatRateCurve(), this.getIncrementalHeatRateCurve(), null, "IncrementalHeatRateCurve", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_ShutdownCurve(), this.getShutdownCurve(), null, "ShutdownCurve", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_StartupModel(), this.getStartupModel(), null, "StartupModel", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_MemberOf_CAESPlant(), this.getCAESPlant(), this.getCAESPlant_Contain_ThermalGeneratingUnit(), "MemberOf_CAESPlant", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_MembmerOf_CogenerationPlant(), this.getCogenerationPlant(), this.getCogenerationPlant_Contain_ThermalGeneratingUnits(), "MembmerOf_CogenerationPlant", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThermalGeneratingUnit_MemberOf_CombinedCyclePlant(), this.getCombinedCyclePlant(), this.getCombinedCyclePlant_Contain_ThermalGeneratingUnits(), "MemberOf_CombinedCyclePlant", null, 0, 1, ThermalGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetLevelScheduleEClass, TargetLevelSchedule.class, "TargetLevelSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetLevelSchedule_HighLevelLimit(), theDomainPackage.getWaterLevel(), "highLevelLimit", null, 0, 1, TargetLevelSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTargetLevelSchedule_LowLevelLimit(), theDomainPackage.getWaterLevel(), "lowLevelLimit", null, 0, 1, TargetLevelSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tailbayLossCurveEClass, TailbayLossCurve.class, "TailbayLossCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(steamSendoutScheduleEClass, SteamSendoutSchedule.class, "SteamSendoutSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startupModelEClass, StartupModel.class, "StartupModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartupModel_FixedMaintCost(), theDomainPackage.getCostPerHour(), "fixedMaintCost", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_HotStandbyHeat(), theDomainPackage.getHeatPerHour(), "hotStandbyHeat", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_IncrementalMaintCost(), theDomainPackage.getCostPerEnergyUnit(), "incrementalMaintCost", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_MinimumDownTime(), theDomainPackage.getHours(), "minimumDownTime", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_MinimumRunTime(), theDomainPackage.getHours(), "minimumRunTime", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_RiskFactorCost(), theDomainPackage.getMoney(), "riskFactorCost", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_StartupCost(), theDomainPackage.getMoney(), "startupCost", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_StartupDate(), theDomainPackage.getDate(), "startupDate", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_StartupPriority(), theDomainPackage.getPriority(), "startupPriority", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartupModel_StbyAuxPowerMW(), theDomainPackage.getActivePower(), "stbyAuxPowerMW", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartupModel_StartIgnFuelCurve(), this.getStartIgnFuelCurve(), null, "StartIgnFuelCurve", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartupModel_StartMainFuelCurve(), this.getStartMainFuelCurve(), null, "StartMainFuelCurve", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartupModel_StartRampCurve(), this.getStartRampCurve(), null, "StartRampCurve", null, 0, 1, StartupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startRampCurveEClass, StartRampCurve.class, "StartRampCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartRampCurve_HotStandbyRamp(), theDomainPackage.getPowerROCPerMin(), "hotStandbyRamp", null, 0, 1, StartRampCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startMainFuelCurveEClass, StartMainFuelCurve.class, "StartMainFuelCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartMainFuelCurve_MainFuelType(), theDomainPackage.getFuelType(), "mainFuelType", null, 0, 1, StartMainFuelCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startIgnFuelCurveEClass, StartIgnFuelCurve.class, "StartIgnFuelCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartIgnFuelCurve_IgnitionFuelType(), theDomainPackage.getFuelType(), "ignitionFuelType", null, 0, 1, StartIgnFuelCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shutdownCurveEClass, ShutdownCurve.class, "ShutdownCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShutdownCurve_ShutdownCost(), theDomainPackage.getMoney(), "shutdownCost", null, 0, 1, ShutdownCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShutdownCurve_ShutdownDate(), theDomainPackage.getDate(), "shutdownDate", null, 0, 1, ShutdownCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reservoirEClass, Reservoir.class, "Reservoir", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReservoir_ActiveStorageCapacity(), theDomainPackage.getVolume(), "activeStorageCapacity", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_EnergyStorageRating(), ecorePackage.getEFloatObject(), "energyStorageRating", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_FullSupplyLevel(), theDomainPackage.getWaterLevel(), "fullSupplyLevel", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_GrossCapacity(), theDomainPackage.getVolume(), "grossCapacity", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_NormalMinOperateLevel(), theDomainPackage.getWaterLevel(), "normalMinOperateLevel", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_RiverOutletWorks(), ecorePackage.getEString(), "riverOutletWorks", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_SpillTravelDelay(), theDomainPackage.getSeconds(), "spillTravelDelay", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_SpillwayCapacity(), ecorePackage.getEFloatObject(), "spillwayCapacity", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_SpillwayCrestLength(), ecorePackage.getEFloatObject(), "spillwayCrestLength", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_SpillwayCrestLevel(), theDomainPackage.getWaterLevel(), "spillwayCrestLevel", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReservoir_SpillWayGateType(), theDomainPackage.getSpillwayGateType(), "spillWayGateType", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_HydroPowerPlants(), this.getHydroPowerPlant(), this.getHydroPowerPlant_Reservoir(), "HydroPowerPlants", null, 0, -1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_UpstreamFrom(), this.getHydroPowerPlant(), this.getHydroPowerPlant_GenSourcePumpDischarge(), "UpstreamFrom", null, 0, -1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_LevelVsVolumeCurve(), this.getLevelVsVolumeCurve(), null, "LevelVsVolumeCurve", null, 0, -1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_TargetLevelSchedule(), this.getTargetLevelSchedule(), null, "TargetLevelSchedule", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_InflowForecast(), this.getInflowForecast(), null, "InflowForecast", null, 0, -1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_SpillsInto(), this.getReservoir(), this.getReservoir_SpillsFrom(), "SpillsInto", null, 0, -1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReservoir_SpillsFrom(), this.getReservoir(), this.getReservoir_SpillsInto(), "SpillsFrom", null, 0, 1, Reservoir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(penstockLossCurveEClass, PenstockLossCurve.class, "PenstockLossCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(levelVsVolumeCurveEClass, LevelVsVolumeCurve.class, "LevelVsVolumeCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inflowForecastEClass, InflowForecast.class, "InflowForecast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(incrementalHeatRateCurveEClass, IncrementalHeatRateCurve.class, "IncrementalHeatRateCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIncrementalHeatRateCurve_NetGrossMWFlag(), ecorePackage.getEBooleanObject(), "netGrossMWFlag", null, 0, 1, IncrementalHeatRateCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hydroPumpOpScheduleEClass, HydroPumpOpSchedule.class, "HydroPumpOpSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hydroPumpEClass, HydroPump.class, "HydroPump", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHydroPump_PumpDischAtMaxHead(), ecorePackage.getEFloatObject(), "pumpDischAtMaxHead", null, 0, 1, HydroPump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPump_PumpDischAtMinHead(), ecorePackage.getEFloatObject(), "pumpDischAtMinHead", null, 0, 1, HydroPump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPump_PumpPowerAtMaxHead(), theDomainPackage.getActivePower(), "pumpPowerAtMaxHead", null, 0, 1, HydroPump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPump_PumpPowerAtMinHead(), theDomainPackage.getActivePower(), "pumpPowerAtMinHead", null, 0, 1, HydroPump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroPump_HydroPumpOpSchedule(), this.getHydroPumpOpSchedule(), null, "HydroPumpOpSchedule", null, 0, 1, HydroPump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hydroPowerPlantEClass, HydroPowerPlant.class, "HydroPowerPlant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHydroPowerPlant_DischargeTravelDelay(), theDomainPackage.getSeconds(), "dischargeTravelDelay", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_HydroPlantType(), theDomainPackage.getHydroPlantType(), "hydroPlantType", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_PenstockType(), theDomainPackage.getPenstockType(), "penstockType", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_PlantDischargeCapacity(), ecorePackage.getEFloatObject(), "plantDischargeCapacity", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_PlantMWGenRating(), theDomainPackage.getActivePower(), "plantMWGenRating", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_PlantMWPumpRating(), theDomainPackage.getActivePower(), "plantMWPumpRating", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_PlantRatedHead(), ecorePackage.getEFloatObject(), "plantRatedHead", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_SurgeTankCode(), theDomainPackage.getSurgeTankCode(), "surgeTankCode", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroPowerPlant_SurgeTankCrestLevel(), theDomainPackage.getWaterLevel(), "surgeTankCrestLevel", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroPowerPlant_Contain_HydroGeneratingUnits(), this.getHydroGeneratingUnit(), null, "Contain_HydroGeneratingUnits", null, 1, -1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroPowerPlant_Contain_HydroPumps(), this.getHydroPump(), null, "Contain_HydroPumps", null, 1, -1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroPowerPlant_Reservoir(), this.getReservoir(), this.getReservoir_HydroPowerPlants(), "Reservoir", null, 0, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroPowerPlant_GenSourcePumpDischarge(), this.getReservoir(), this.getReservoir_UpstreamFrom(), "GenSourcePumpDischarge", null, 1, 1, HydroPowerPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hydroGeneratingUnitEClass, HydroGeneratingUnit.class, "HydroGeneratingUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHydroGeneratingUnit_HydroUnitWaterCost(), ecorePackage.getEFloatObject(), "hydroUnitWaterCost", null, 0, 1, HydroGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroGeneratingUnit_HydroGeneratingEfficiencyCurves(), this.getHydroGeneratingEfficiencyCurve(), null, "HydroGeneratingEfficiencyCurves", null, 0, -1, HydroGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroGeneratingUnit_PenstockLossCurve(), this.getPenstockLossCurve(), null, "PenstockLossCurve", null, 0, 1, HydroGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHydroGeneratingUnit_TailbayLossCurve(), this.getTailbayLossCurve(), null, "TailbayLossCurve", null, 0, -1, HydroGeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hydroGeneratingEfficiencyCurveEClass, HydroGeneratingEfficiencyCurve.class, "HydroGeneratingEfficiencyCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(heatRateCurveEClass, HeatRateCurve.class, "HeatRateCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeatRateCurve_NetGrossMWFlag(), ecorePackage.getEBooleanObject(), "netGrossMWFlag", null, 0, 1, HeatRateCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(heatInputCurveEClass, HeatInputCurve.class, "HeatInputCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeatInputCurve_AuxPowerOffset(), theDomainPackage.getActivePower(), "auxPowerOffset", null, 0, 1, HeatInputCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeatInputCurve_AuxPowerMult(), theDomainPackage.getPU(), "auxPowerMult", null, 0, 1, HeatInputCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeatInputCurve_HeatInputEff(), theDomainPackage.getPU(), "heatInputEff", null, 0, 1, HeatInputCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeatInputCurve_HeatInputOffset(), theDomainPackage.getHeatPerHour(), "heatInputOffset", null, 0, 1, HeatInputCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeatInputCurve_NetGrossMWFlag(), ecorePackage.getEBooleanObject(), "netGrossMWFlag", null, 0, 1, HeatInputCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(grossToNetMWCurveEClass, GrossToNetMWCurve.class, "GrossToNetMWCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(genUnitOpScheduleEClass, GenUnitOpSchedule.class, "GenUnitOpSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(genUnitOpCostCurveEClass, GenUnitOpCostCurve.class, "GenUnitOpCostCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenUnitOpCostCurve_NetGrossMWFlag(), ecorePackage.getEBooleanObject(), "netGrossMWFlag", null, 0, 1, GenUnitOpCostCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generatingUnitEClass, GeneratingUnit.class, "GeneratingUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneratingUnit_ControlDeadband(), theDomainPackage.getActivePower(), "controlDeadband", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_ControlPulseHigh(), theDomainPackage.getSeconds(), "controlPulseHigh", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_ControlPulseLow(), theDomainPackage.getSeconds(), "controlPulseLow", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_ControlResponseRate(), theDomainPackage.getPowerROCPerSec(), "controlResponseRate", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_Efficiency(), theDomainPackage.getPU(), "efficiency", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_GenControlMode(), theDomainPackage.getGeneratorControlMode(), "genControlMode", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_GenControlSource(), theDomainPackage.getGeneratorControlSource(), "genControlSource", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_GovernorMPL(), theDomainPackage.getPU(), "governorMPL", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_GovernorSCD(), theDomainPackage.getPerCent(), "governorSCD", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_HighControlLimit(), theDomainPackage.getActivePower(), "highControlLimit", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_InitialMW(), theDomainPackage.getActivePower(), "initialMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_LowControlLimit(), theDomainPackage.getActivePower(), "lowControlLimit", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_MaximumAllowableSpinningReserve(), theDomainPackage.getActivePower(), "maximumAllowableSpinningReserve", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_MaximumEconomicMW(), theDomainPackage.getActivePower(), "maximumEconomicMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_MaximumOperatingMW(), theDomainPackage.getActivePower(), "maximumOperatingMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_MinimumEconomicMW(), theDomainPackage.getActivePower(), "minimumEconomicMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_MinimumOperatingMW(), theDomainPackage.getActivePower(), "minimumOperatingMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_ModelDetail(), theDomainPackage.getClassification(), "modelDetail", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_RatedGrossMaxMW(), theDomainPackage.getActivePower(), "ratedGrossMaxMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_RatedGrossMinMW(), theDomainPackage.getActivePower(), "ratedGrossMinMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_RatedNetMaxMW(), theDomainPackage.getActivePower(), "ratedNetMaxMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_StartupTime(), theDomainPackage.getSeconds(), "startupTime", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_AutoCntrlMarginMW(), theDomainPackage.getActivePower(), "autoCntrlMarginMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_AllocSpinResMW(), theDomainPackage.getActivePower(), "allocSpinResMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_BaseMW(), theDomainPackage.getActivePower(), "baseMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_DispReserveFlag(), ecorePackage.getEBooleanObject(), "dispReserveFlag", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_EnergyMinMW(), theDomainPackage.getHeatPerHour(), "energyMinMW", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_FastStartFlag(), ecorePackage.getEBooleanObject(), "fastStartFlag", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_FuelPriority(), theDomainPackage.getPriority(), "fuelPriority", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_GenOperatingMode(), theDomainPackage.getGeneratorOperatingMode(), "genOperatingMode", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_LongPF(), theDomainPackage.getParticipationFactor(), "longPF", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_LowerRampRate(), theDomainPackage.getPowerROCPerMin(), "lowerRampRate", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_NormalPF(), theDomainPackage.getParticipationFactor(), "normalPF", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_PenaltyFactor(), theDomainPackage.getPenaltyFactor(), "penaltyFactor", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_RaiseRampRate(), theDomainPackage.getPowerROCPerMin(), "raiseRampRate", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_ShortPF(), theDomainPackage.getParticipationFactor(), "shortPF", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_SpinReserveRamp(), theDomainPackage.getPowerROCPerMin(), "spinReserveRamp", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_StepChange(), theDomainPackage.getActivePower(), "stepChange", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_TieLinePF(), theDomainPackage.getParticipationFactor(), "tieLinePF", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratingUnit_MinimumOffTime(), theDomainPackage.getSeconds(), "minimumOffTime", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratingUnit_GenUnitOpCostCurves(), this.getGenUnitOpCostCurve(), null, "GenUnitOpCostCurves", null, 0, -1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratingUnit_GenUnitOpSchedule(), this.getGenUnitOpSchedule(), null, "GenUnitOpSchedule", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratingUnit_GrossToNetMWCurves(), this.getGrossToNetMWCurve(), null, "GrossToNetMWCurves", null, 0, -1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratingUnit_SubControlArea(), theCorePackage.getSubControlArea(), theCorePackage.getSubControlArea_GeneratingUnits(), "SubControlArea", null, 0, 1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratingUnit_SynchronousMachines(), theWirePackage.getSynchronousMachine(), theWirePackage.getSynchronousMachine_GeneratingUnit(), "SynchronousMachines", null, 1, -1, GeneratingUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fuelAllocationScheduleEClass, FuelAllocationSchedule.class, "FuelAllocationSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFuelAllocationSchedule_FuelAllocationEndDate(), theDomainPackage.getDate(), "fuelAllocationEndDate", null, 0, 1, FuelAllocationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuelAllocationSchedule_FuelAllocationStartDate(), theDomainPackage.getDate(), "fuelAllocationStartDate", null, 0, 1, FuelAllocationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuelAllocationSchedule_FuelType(), theDomainPackage.getFuelType(), "fuelType", null, 0, 1, FuelAllocationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuelAllocationSchedule_MaxFuelAllocation(), ecorePackage.getEFloatObject(), "maxFuelAllocation", null, 0, 1, FuelAllocationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuelAllocationSchedule_MinFuelAllocation(), ecorePackage.getEFloatObject(), "minFuelAllocation", null, 0, 1, FuelAllocationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuelAllocationSchedule_FossilFuel(), this.getFossilFuel(), this.getFossilFuel_FuelAllocationSchedule(), "FossilFuel", null, 1, 1, FuelAllocationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fossilFuelEClass, FossilFuel.class, "FossilFuel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFossilFuel_FossilFuelType(), theDomainPackage.getFuelType(), "fossilFuelType", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelCost(), theDomainPackage.getCostPerHeatUnit(), "fuelCost", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelDispatchCost(), theDomainPackage.getCostPerHeatUnit(), "fuelDispatchCost", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelEffFactor(), theDomainPackage.getPU(), "fuelEffFactor", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelHandlingCost(), theDomainPackage.getCostPerHeatUnit(), "fuelHandlingCost", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelHeatContent(), ecorePackage.getEFloatObject(), "fuelHeatContent", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelMixture(), theDomainPackage.getPerCent(), "fuelMixture", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_FuelSulfur(), theDomainPackage.getPU(), "fuelSulfur", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_HighMWBreakpoint(), theDomainPackage.getActivePower(), "highMWBreakpoint", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilFuel_LowMWBreakpoint(), theDomainPackage.getActivePower(), "lowMWBreakpoint", null, 0, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFossilFuel_FuelAllocationSchedule(), this.getFuelAllocationSchedule(), this.getFuelAllocationSchedule_FossilFuel(), "FuelAllocationSchedule", null, 0, -1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFossilFuel_ThermalGeneratingUnit(), this.getThermalGeneratingUnit(), this.getThermalGeneratingUnit_FossilFuels(), "ThermalGeneratingUnit", null, 1, 1, FossilFuel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emissionCurveEClass, EmissionCurve.class, "EmissionCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmissionCurve_EmissionContent(), theDomainPackage.getEmission(), "emissionContent", null, 0, 1, EmissionCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmissionCurve_EmissionType(), theDomainPackage.getEmissionType(), "emissionType", null, 0, 1, EmissionCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmissionCurve_NetGrossMWFlag(), ecorePackage.getEBooleanObject(), "netGrossMWFlag", null, 0, 1, EmissionCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(combinedCyclePlantEClass, CombinedCyclePlant.class, "CombinedCyclePlant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCombinedCyclePlant_CombCyclePlantRating(), theDomainPackage.getActivePower(), "combCyclePlantRating", null, 0, 1, CombinedCyclePlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombinedCyclePlant_Contain_ThermalGeneratingUnits(), this.getThermalGeneratingUnit(), this.getThermalGeneratingUnit_MemberOf_CombinedCyclePlant(), "Contain_ThermalGeneratingUnits", null, 0, -1, CombinedCyclePlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cogenerationPlantEClass, CogenerationPlant.class, "CogenerationPlant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCogenerationPlant_CogenHPSendoutRating(), ecorePackage.getEFloatObject(), "cogenHPSendoutRating", null, 0, 1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCogenerationPlant_CogenHPSteamRating(), ecorePackage.getEFloatObject(), "cogenHPSteamRating", null, 0, 1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCogenerationPlant_CogenLPSendoutRating(), ecorePackage.getEFloatObject(), "cogenLPSendoutRating", null, 0, 1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCogenerationPlant_CogenLPSteamRating(), ecorePackage.getEFloatObject(), "cogenLPSteamRating", null, 0, 1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCogenerationPlant_CogenPlantMWRating(), theDomainPackage.getActivePower(), "cogenPlantMWRating", null, 0, 1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCogenerationPlant_Contain_ThermalGeneratingUnits(), this.getThermalGeneratingUnit(), this.getThermalGeneratingUnit_MembmerOf_CogenerationPlant(), "Contain_ThermalGeneratingUnits", null, 0, -1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCogenerationPlant_SteamSendoutSchedule(), this.getSteamSendoutSchedule(), null, "SteamSendoutSchedule", null, 1, 1, CogenerationPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caesPlantEClass, CAESPlant.class, "CAESPlant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCAESPlant_EnergyStorageCapacity(), theDomainPackage.getEnergyAsMWh(), "energyStorageCapacity", null, 0, 1, CAESPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAESPlant_RatedCapacityMW(), theDomainPackage.getActivePower(), "ratedCapacityMW", null, 0, 1, CAESPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAESPlant_Contain_AirCompressor(), this.getAirCompressor(), null, "Contain_AirCompressor", null, 1, 1, CAESPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAESPlant_Contain_ThermalGeneratingUnit(), this.getThermalGeneratingUnit(), this.getThermalGeneratingUnit_MemberOf_CAESPlant(), "Contain_ThermalGeneratingUnit", null, 0, 1, CAESPlant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(airCompressorEClass, AirCompressor.class, "AirCompressor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAirCompressor_AirCompressorRating(), ecorePackage.getEFloatObject(), "airCompressorRating", null, 0, 1, AirCompressor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAirCompressor_CombustionTurbine(), theGenerationdynamicsPackage.getCombustionTurbine(), theGenerationdynamicsPackage.getCombustionTurbine_AirCompressor(), "CombustionTurbine", null, 1, 1, AirCompressor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emissionAccountEClass, EmissionAccount.class, "EmissionAccount", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmissionAccount_EmissionType(), theDomainPackage.getEmissionType(), "emissionType", null, 0, 1, EmissionAccount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmissionAccount_EmissionValueSource(), theDomainPackage.getEmissionValueSource(), "emissionValueSource", null, 0, 1, EmissionAccount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accountBalanceEClass, AccountBalance.class, "AccountBalance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //ProductionPackageImpl
