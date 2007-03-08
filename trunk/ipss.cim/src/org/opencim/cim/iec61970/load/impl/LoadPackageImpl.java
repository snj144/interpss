/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadPackageImpl.java,v 1.3 2007/03/07 05:14:05 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

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

import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl;

import org.opencim.cim.iec61970.impl.Iec61970PackageImpl;

import org.opencim.cim.iec61970.load.AreaLoadCurve;
import org.opencim.cim.iec61970.load.AreaLossCurve;
import org.opencim.cim.iec61970.load.CustomerMeter;
import org.opencim.cim.iec61970.load.DayType;
import org.opencim.cim.iec61970.load.EquivalentLoad;
import org.opencim.cim.iec61970.load.InductionMotorLoad;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.LoadDemandModel;
import org.opencim.cim.iec61970.load.LoadFactory;
import org.opencim.cim.iec61970.load.LoadModelVersion;
import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.NonConformLoadSchedule;
import org.opencim.cim.iec61970.load.PowerCutZone;
import org.opencim.cim.iec61970.load.Season;
import org.opencim.cim.iec61970.load.StationSupply;

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
public class LoadPackageImpl extends EPackageImpl implements LoadPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass areaLoadCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass areaLossCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerMeterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalentLoadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inductionMotorLoadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadDemandModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonConformLoadScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seasonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stationSupplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerCutZoneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadModelVersionEClass = null;

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
	 * @see org.opencim.cim.iec61970.load.LoadPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LoadPackageImpl() {
		super(eNS_URI, LoadFactory.eINSTANCE);
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
	public static LoadPackage init() {
		if (isInited) return (LoadPackage)EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI);

		// Obtain or create and register package
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new LoadPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) : cimPackage.eINSTANCE);
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) : Iec61970Package.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) : WirePackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		theLoadPackage.createPackageContents();
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		theLoadPackage.initializePackageContents();
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLoadPackage.freeze();

		return theLoadPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAreaLoadCurve() {
		return areaLoadCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAreaLoadCurve_LoadArea() {
		return (EReference)areaLoadCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAreaLoadCurve_DayType() {
		return (EReference)areaLoadCurveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAreaLoadCurve_Season() {
		return (EReference)areaLoadCurveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAreaLossCurve() {
		return areaLossCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAreaLossCurve_LoadArea() {
		return (EReference)areaLossCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomerMeter() {
		return customerMeterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDayType() {
		return dayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDayType_AreaLoadCurves() {
		return (EReference)dayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDayType_LoadDemandModels() {
		return (EReference)dayTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalentLoad() {
		return equivalentLoadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentLoad_FeederLoadMgtFactor() {
		return (EAttribute)equivalentLoadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentLoad_MVArColdPickUpFactor() {
		return (EAttribute)equivalentLoadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentLoad_MWColdPickUpFactor() {
		return (EAttribute)equivalentLoadEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentLoad_PhaseAmpRating() {
		return (EAttribute)equivalentLoadEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentLoad_LoadAllocationFactor() {
		return (EAttribute)equivalentLoadEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInductionMotorLoad() {
		return inductionMotorLoadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadArea() {
		return loadAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadArea_EnergyConsumers() {
		return (EReference)loadAreaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadArea_AreaLossCurves() {
		return (EReference)loadAreaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadArea_AreaLoadCurves() {
		return (EReference)loadAreaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadArea_Substations() {
		return (EReference)loadAreaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadDemandModel() {
		return loadDemandModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadDemandModel_EnergyConsumer() {
		return (EReference)loadDemandModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadDemandModel_BasisFor() {
		return (EReference)loadDemandModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadDemandModel_DayType() {
		return (EReference)loadDemandModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonConformLoadSchedule() {
		return nonConformLoadScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonConformLoadSchedule_EnergyConsumer() {
		return (EReference)nonConformLoadScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeason() {
		return seasonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_Name() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_EndDate() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_StartDate() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeason_AreaLoadCurves() {
		return (EReference)seasonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeason_LoadDemandModels() {
		return (EReference)seasonEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStationSupply() {
		return stationSupplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPowerCutZone() {
		return powerCutZoneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerCutZone_CutLevel1() {
		return (EAttribute)powerCutZoneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerCutZone_CutLevel2() {
		return (EAttribute)powerCutZoneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerCutZone_EnergyConsumers() {
		return (EReference)powerCutZoneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadModelVersion() {
		return loadModelVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadModelVersion_Version() {
		return (EAttribute)loadModelVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadModelVersion_Date() {
		return (EAttribute)loadModelVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadFactory getLoadFactory() {
		return (LoadFactory)getEFactoryInstance();
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
		areaLoadCurveEClass = createEClass(AREA_LOAD_CURVE);
		createEReference(areaLoadCurveEClass, AREA_LOAD_CURVE__LOAD_AREA);
		createEReference(areaLoadCurveEClass, AREA_LOAD_CURVE__DAY_TYPE);
		createEReference(areaLoadCurveEClass, AREA_LOAD_CURVE__SEASON);

		areaLossCurveEClass = createEClass(AREA_LOSS_CURVE);
		createEReference(areaLossCurveEClass, AREA_LOSS_CURVE__LOAD_AREA);

		customerMeterEClass = createEClass(CUSTOMER_METER);

		dayTypeEClass = createEClass(DAY_TYPE);
		createEReference(dayTypeEClass, DAY_TYPE__AREA_LOAD_CURVES);
		createEReference(dayTypeEClass, DAY_TYPE__LOAD_DEMAND_MODELS);

		equivalentLoadEClass = createEClass(EQUIVALENT_LOAD);
		createEAttribute(equivalentLoadEClass, EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR);
		createEAttribute(equivalentLoadEClass, EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR);
		createEAttribute(equivalentLoadEClass, EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR);
		createEAttribute(equivalentLoadEClass, EQUIVALENT_LOAD__PHASE_AMP_RATING);
		createEAttribute(equivalentLoadEClass, EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR);

		inductionMotorLoadEClass = createEClass(INDUCTION_MOTOR_LOAD);

		loadAreaEClass = createEClass(LOAD_AREA);
		createEReference(loadAreaEClass, LOAD_AREA__ENERGY_CONSUMERS);
		createEReference(loadAreaEClass, LOAD_AREA__AREA_LOSS_CURVES);
		createEReference(loadAreaEClass, LOAD_AREA__AREA_LOAD_CURVES);
		createEReference(loadAreaEClass, LOAD_AREA__SUBSTATIONS);

		loadDemandModelEClass = createEClass(LOAD_DEMAND_MODEL);
		createEReference(loadDemandModelEClass, LOAD_DEMAND_MODEL__ENERGY_CONSUMER);
		createEReference(loadDemandModelEClass, LOAD_DEMAND_MODEL__BASIS_FOR);
		createEReference(loadDemandModelEClass, LOAD_DEMAND_MODEL__DAY_TYPE);

		nonConformLoadScheduleEClass = createEClass(NON_CONFORM_LOAD_SCHEDULE);
		createEReference(nonConformLoadScheduleEClass, NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER);

		seasonEClass = createEClass(SEASON);
		createEAttribute(seasonEClass, SEASON__NAME);
		createEAttribute(seasonEClass, SEASON__END_DATE);
		createEAttribute(seasonEClass, SEASON__START_DATE);
		createEReference(seasonEClass, SEASON__AREA_LOAD_CURVES);
		createEReference(seasonEClass, SEASON__LOAD_DEMAND_MODELS);

		stationSupplyEClass = createEClass(STATION_SUPPLY);

		powerCutZoneEClass = createEClass(POWER_CUT_ZONE);
		createEAttribute(powerCutZoneEClass, POWER_CUT_ZONE__CUT_LEVEL1);
		createEAttribute(powerCutZoneEClass, POWER_CUT_ZONE__CUT_LEVEL2);
		createEReference(powerCutZoneEClass, POWER_CUT_ZONE__ENERGY_CONSUMERS);

		loadModelVersionEClass = createEClass(LOAD_MODEL_VERSION);
		createEAttribute(loadModelVersionEClass, LOAD_MODEL_VERSION__VERSION);
		createEAttribute(loadModelVersionEClass, LOAD_MODEL_VERSION__DATE);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		WirePackage theWirePackage = (WirePackage)EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI);
		DomainPackage theDomainPackage = (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);

		// Add supertypes to classes
		areaLoadCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		areaLossCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		customerMeterEClass.getESuperTypes().add(theWirePackage.getEnergyConsumer());
		dayTypeEClass.getESuperTypes().add(theCorePackage.getNaming());
		equivalentLoadEClass.getESuperTypes().add(theWirePackage.getEnergyConsumer());
		inductionMotorLoadEClass.getESuperTypes().add(theWirePackage.getEnergyConsumer());
		loadAreaEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		loadDemandModelEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		nonConformLoadScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		stationSupplyEClass.getESuperTypes().add(theWirePackage.getEnergyConsumer());
		powerCutZoneEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());

		// Initialize classes and features; add operations and parameters
		initEClass(areaLoadCurveEClass, AreaLoadCurve.class, "AreaLoadCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAreaLoadCurve_LoadArea(), this.getLoadArea(), this.getLoadArea_AreaLoadCurves(), "LoadArea", null, 1, 1, AreaLoadCurve.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAreaLoadCurve_DayType(), this.getDayType(), this.getDayType_AreaLoadCurves(), "DayType", null, 0, 1, AreaLoadCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAreaLoadCurve_Season(), this.getSeason(), this.getSeason_AreaLoadCurves(), "Season", null, 1, 1, AreaLoadCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(areaLossCurveEClass, AreaLossCurve.class, "AreaLossCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAreaLossCurve_LoadArea(), this.getLoadArea(), this.getLoadArea_AreaLossCurves(), "LoadArea", null, 1, 1, AreaLossCurve.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerMeterEClass, CustomerMeter.class, "CustomerMeter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dayTypeEClass, DayType.class, "DayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDayType_AreaLoadCurves(), this.getAreaLoadCurve(), this.getAreaLoadCurve_DayType(), "AreaLoadCurves", null, 0, -1, DayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDayType_LoadDemandModels(), this.getLoadDemandModel(), this.getLoadDemandModel_DayType(), "LoadDemandModels", null, 0, -1, DayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equivalentLoadEClass, EquivalentLoad.class, "EquivalentLoad", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquivalentLoad_FeederLoadMgtFactor(), theDomainPackage.getPerCent(), "feederLoadMgtFactor", null, 0, 1, EquivalentLoad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentLoad_MVArColdPickUpFactor(), theDomainPackage.getPerCent(), "mVArColdPickUpFactor", null, 0, 1, EquivalentLoad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentLoad_MWColdPickUpFactor(), theDomainPackage.getPerCent(), "mWColdPickUpFactor", null, 0, 1, EquivalentLoad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentLoad_PhaseAmpRating(), theDomainPackage.getCurrentFlow(), "phaseAmpRating", null, 0, 1, EquivalentLoad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentLoad_LoadAllocationFactor(), ecorePackage.getEFloatObject(), "loadAllocationFactor", null, 0, 1, EquivalentLoad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inductionMotorLoadEClass, InductionMotorLoad.class, "InductionMotorLoad", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadAreaEClass, LoadArea.class, "LoadArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoadArea_EnergyConsumers(), theWirePackage.getEnergyConsumer(), theWirePackage.getEnergyConsumer_LoadArea(), "EnergyConsumers", null, 0, -1, LoadArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadArea_AreaLossCurves(), this.getAreaLossCurve(), this.getAreaLossCurve_LoadArea(), "AreaLossCurves", null, 0, -1, LoadArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadArea_AreaLoadCurves(), this.getAreaLoadCurve(), this.getAreaLoadCurve_LoadArea(), "AreaLoadCurves", null, 0, -1, LoadArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadArea_Substations(), theCorePackage.getSubstation(), theCorePackage.getSubstation_LoadArea(), "Substations", null, 0, -1, LoadArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadDemandModelEClass, LoadDemandModel.class, "LoadDemandModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoadDemandModel_EnergyConsumer(), theWirePackage.getEnergyConsumer(), theWirePackage.getEnergyConsumer_LoadDemandModels(), "EnergyConsumer", null, 1, 1, LoadDemandModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadDemandModel_BasisFor(), this.getSeason(), this.getSeason_LoadDemandModels(), "BasisFor", null, 1, 1, LoadDemandModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadDemandModel_DayType(), this.getDayType(), this.getDayType_LoadDemandModels(), "DayType", null, 1, 1, LoadDemandModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nonConformLoadScheduleEClass, NonConformLoadSchedule.class, "NonConformLoadSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonConformLoadSchedule_EnergyConsumer(), theWirePackage.getEnergyConsumer(), theWirePackage.getEnergyConsumer_NonConformLoadSchedules(), "EnergyConsumer", null, 1, 1, NonConformLoadSchedule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seasonEClass, Season.class, "Season", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeason_Name(), theDomainPackage.getSeasonName(), "name", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_EndDate(), theDomainPackage.getAbsoluteDateTime(), "endDate", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_StartDate(), theDomainPackage.getDate(), "startDate", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeason_AreaLoadCurves(), this.getAreaLoadCurve(), this.getAreaLoadCurve_Season(), "AreaLoadCurves", null, 0, -1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeason_LoadDemandModels(), this.getLoadDemandModel(), this.getLoadDemandModel_BasisFor(), "LoadDemandModels", null, 0, -1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stationSupplyEClass, StationSupply.class, "StationSupply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(powerCutZoneEClass, PowerCutZone.class, "PowerCutZone", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPowerCutZone_CutLevel1(), theDomainPackage.getPerCent(), "cutLevel1", null, 0, 1, PowerCutZone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerCutZone_CutLevel2(), theDomainPackage.getPerCent(), "cutLevel2", null, 0, 1, PowerCutZone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerCutZone_EnergyConsumers(), theWirePackage.getEnergyConsumer(), theWirePackage.getEnergyConsumer_PowerCutZone(), "EnergyConsumers", null, 1, -1, PowerCutZone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadModelVersionEClass, LoadModelVersion.class, "LoadModelVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadModelVersion_Version(), ecorePackage.getEString(), "version", "LoadModel_v001", 0, 1, LoadModelVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadModelVersion_Date(), theDomainPackage.getDate(), "date", "2004-06-30", 0, 1, LoadModelVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //LoadPackageImpl
