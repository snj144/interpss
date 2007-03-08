/**
 * <copyright>
 * </copyright>
 *
 * $Id: cimPackageImpl.java,v 1.6 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.opencim.cim.CombinedVersion;
import org.opencim.cim.SimulationModel;
import org.opencim.cim.cimFactory;
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

import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.topology.TopologyPackage;

import org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class cimPackageImpl extends EPackageImpl implements cimPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinedVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulationModelEClass = null;

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
	 * @see org.opencim.cim.cimPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private cimPackageImpl() {
		super(eNS_URI, cimFactory.eINSTANCE);
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
	public static cimPackage init() {
		if (isInited) return (cimPackage)EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI);

		// Obtain or create and register package
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new cimPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) : Iec61970Package.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) : LoadPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) : WirePackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thecimPackage.freeze();

		return thecimPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombinedVersion() {
		return combinedVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedVersion_Version() {
		return (EAttribute)combinedVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedVersion_Date() {
		return (EAttribute)combinedVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulationModel() {
		return simulationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_BasePower() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_Companies() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_TopologicalIslands() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_PsResources() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cimFactory getcimFactory() {
		return (cimFactory)getEFactoryInstance();
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
		combinedVersionEClass = createEClass(COMBINED_VERSION);
		createEAttribute(combinedVersionEClass, COMBINED_VERSION__VERSION);
		createEAttribute(combinedVersionEClass, COMBINED_VERSION__DATE);

		simulationModelEClass = createEClass(SIMULATION_MODEL);
		createEReference(simulationModelEClass, SIMULATION_MODEL__BASE_POWER);
		createEReference(simulationModelEClass, SIMULATION_MODEL__COMPANIES);
		createEReference(simulationModelEClass, SIMULATION_MODEL__TOPOLOGICAL_ISLANDS);
		createEReference(simulationModelEClass, SIMULATION_MODEL__PS_RESOURCES);
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
		Iec61970Package theIec61970Package = (Iec61970Package)EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI);
		DomainPackage theDomainPackage = (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		TopologyPackage theTopologyPackage = (TopologyPackage)EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theIec61970Package);

		// Add supertypes to classes
		simulationModelEClass.getESuperTypes().add(theCorePackage.getNaming());

		// Initialize classes and features; add operations and parameters
		initEClass(combinedVersionEClass, CombinedVersion.class, "CombinedVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCombinedVersion_Version(), ecorePackage.getEString(), "version", "cimCombined_v003", 0, 1, CombinedVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombinedVersion_Date(), theDomainPackage.getDate(), "date", "2005-12-19", 0, 1, CombinedVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simulationModelEClass, SimulationModel.class, "SimulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimulationModel_BasePower(), theCorePackage.getBasePower(), null, "basePower", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_Companies(), theCorePackage.getCompany(), theCorePackage.getCompany_SimuModel(), "companies", null, 0, -1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_TopologicalIslands(), theTopologyPackage.getTopologicalIsland(), theTopologyPackage.getTopologicalIsland_SimuModel(), "topologicalIslands", null, 0, -1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_PsResources(), theCorePackage.getPowerSystemResource(), theCorePackage.getPowerSystemResource_SimuModel(), "psResources", null, 0, -1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(simulationModelEClass, theCorePackage.getBaseVoltage(), "getBaseVoltage", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "mRID", 0, 1);

		op = addEOperation(simulationModelEClass, theCorePackage.getCompany(), "getCompany", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "mRID", 0, 1);

		op = addEOperation(simulationModelEClass, theCorePackage.getNaming(), "getTopologicalObject", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "mRID", 0, 1);
		addEParameter(op, theDomainPackage.getJavaClass(), "klass", 0, 1);

		op = addEOperation(simulationModelEClass, theCorePackage.getNaming(), "getTopologicalObject", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "mRID", 0, 1);
		addEParameter(op, theDomainPackage.getJavaClass(), "klass", 0, 1);
		addEParameter(op, theDomainPackage.getJavaObject(), "parent", 0, 1);

		op = addEOperation(simulationModelEClass, theCorePackage.getPowerSystemResource(), "getPsResource", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "mRID", 0, 1);
		addEParameter(op, theDomainPackage.getJavaClass(), "klass", 0, 1);

		op = addEOperation(simulationModelEClass, theCorePackage.getPowerSystemResource(), "getPsResource", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "mRID", 0, 1);
		addEParameter(op, theDomainPackage.getJavaClass(), "klass", 0, 1);
		addEParameter(op, theDomainPackage.getJavaObject(), "parent", 0, 1);

		// Create resource
		createResource(eNS_URI);
	}

} //cimPackageImpl
