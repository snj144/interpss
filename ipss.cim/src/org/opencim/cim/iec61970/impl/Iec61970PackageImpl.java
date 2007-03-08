/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iec61970PackageImpl.java,v 1.1 2007/03/02 14:01:17 mzhou Exp $
 */
package org.opencim.cim.iec61970.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.Iec61970Factory;
import org.opencim.cim.iec61970.Iec61970Package;
import org.opencim.cim.iec61970.Iec61970Version;

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
public class Iec61970PackageImpl extends EPackageImpl implements Iec61970Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iec61970VersionEClass = null;

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
	 * @see org.opencim.cim.iec61970.Iec61970Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Iec61970PackageImpl() {
		super(eNS_URI, Iec61970Factory.eINSTANCE);
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
	public static Iec61970Package init() {
		if (isInited) return (Iec61970Package)EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI);

		// Obtain or create and register package
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Iec61970PackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) : cimPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) : LoadPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) : WirePackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		theIec61970Package.createPackageContents();
		thecimPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		theIec61970Package.initializePackageContents();
		thecimPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIec61970Package.freeze();

		return theIec61970Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIec61970Version() {
		return iec61970VersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIec61970Version_Version() {
		return (EAttribute)iec61970VersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIec61970Version_Date() {
		return (EAttribute)iec61970VersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iec61970Factory getIec61970Factory() {
		return (Iec61970Factory)getEFactoryInstance();
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
		iec61970VersionEClass = createEClass(IEC61970_VERSION);
		createEAttribute(iec61970VersionEClass, IEC61970_VERSION__VERSION);
		createEAttribute(iec61970VersionEClass, IEC61970_VERSION__DATE);
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
		DomainPackage theDomainPackage = (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);
		LoadPackage theLoadPackage = (LoadPackage)EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI);
		TopologyPackage theTopologyPackage = (TopologyPackage)EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI);
		WirePackage theWirePackage = (WirePackage)EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI);
		GenPackage theGenPackage = (GenPackage)EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCorePackage);
		getESubpackages().add(theDomainPackage);
		getESubpackages().add(theLoadPackage);
		getESubpackages().add(theTopologyPackage);
		getESubpackages().add(theWirePackage);
		getESubpackages().add(theGenPackage);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(iec61970VersionEClass, Iec61970Version.class, "Iec61970Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIec61970Version_Version(), ecorePackage.getEString(), "version", "cim61970_v002", 0, 1, Iec61970Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIec61970Version_Date(), theDomainPackage.getDate(), "date", "2005-04-28", 0, 1, Iec61970Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //Iec61970PackageImpl
