/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenerationdynamicsPackageImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

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

import org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve;
import org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.DrumBoiler;
import org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsFactory;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler;
import org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover;
import org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.Subcritical;
import org.opencim.cim.iec61970.gen.generationdynamics.Supercritical;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenerationdynamicsPackageImpl extends EPackageImpl implements GenerationdynamicsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supercriticalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subcriticalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass steamTurbineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass steamSupplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pwrSteamSupplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primeMoverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass heatRecoveryBoilerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hydroTurbineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fossilSteamSupplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass drumBoilerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combustionTurbineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bwrSteamSupplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ctTempMWCurveEClass = null;

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
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GenerationdynamicsPackageImpl() {
		super(eNS_URI, GenerationdynamicsFactory.eINSTANCE);
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
	public static GenerationdynamicsPackage init() {
		if (isInited) return (GenerationdynamicsPackage)EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI);

		// Obtain or create and register package
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new GenerationdynamicsPackageImpl());

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
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);

		// Create package meta-data objects
		theGenerationdynamicsPackage.createPackageContents();
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();

		// Initialize created meta-data
		theGenerationdynamicsPackage.initializePackageContents();
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGenerationdynamicsPackage.freeze();

		return theGenerationdynamicsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupercritical() {
		return supercriticalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubcritical() {
		return subcriticalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSteamTurbine() {
		return steamTurbineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_CrossoverTC() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Reheater1TC() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Reheater2TC() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft1PowerHP() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft1PowerIP() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft1PowerLP1() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft1PowerLP2() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft2PowerHP() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft2PowerIP() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft2PowerLP1() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_Shaft2PowerLP2() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamTurbine_SteamChestTC() {
		return (EAttribute)steamTurbineEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSteamTurbine_SteamSupplys() {
		return (EReference)steamTurbineEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSteamSupply() {
		return steamSupplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSteamSupply_SteamSupplyRating() {
		return (EAttribute)steamSupplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSteamSupply_SteamTurbines() {
		return (EReference)steamSupplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPWRSteamSupply() {
		return pwrSteamSupplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ColdLegFBLagTC() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ColdLegFBLeadTC1() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ColdLegFBLeadTC2() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ColdLegFG1() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ColdLegFG2() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ColdLegLagTC() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_CoreHTLagTC1() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_CoreHTLagTC2() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_CoreNeutronicsEffTC() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_CoreNeutronicsHT() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_FeedbackFactor() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_HotLegLagTC() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_HotLegSteamGain() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_HotLegToColdLegGain() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_PressureCG() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_SteamFlowFG() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_SteamPressureDropLagTC() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_SteamPressureFG() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ThrottlePressureFactor() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPWRSteamSupply_ThrottlePressureSP() {
		return (EAttribute)pwrSteamSupplyEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimeMover() {
		return primeMoverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimeMover_PrimeMoverRating() {
		return (EAttribute)primeMoverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimeMover_SynchronousMachines() {
		return (EReference)primeMoverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeatRecoveryBoiler() {
		return heatRecoveryBoilerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeatRecoveryBoiler_SteamSupplyRating2() {
		return (EAttribute)heatRecoveryBoilerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeatRecoveryBoiler_CombustionTurbines() {
		return (EReference)heatRecoveryBoilerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHydroTurbine() {
		return hydroTurbineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_GateRateLimit() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_GateUpperLimit() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_MaxEffMWatMinHead() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_MaxEffMWatMaxHead() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_SpeedRating() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_SpeedRegulation() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_TransientDroopTime() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_TransientRegulation() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_TurbineRating() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_TurbineType() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHydroTurbine_WaterStartingTime() {
		return (EAttribute)hydroTurbineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFossilSteamSupply() {
		return fossilSteamSupplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_AuxPowerVersusFrequency() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_AuxPowerversusVoltage() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ControlIC() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_BoilerControlMode() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ControlMWEB() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ControlPC() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ControlPEB() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ControlPED() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ControlTC() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_FeedWaterIG() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_FeedWaterPG() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_FeedWaterTC() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_FuelDemandLimit() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_FuelSupplyDelay() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_MechPowerSensorLag() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_FuelSupplyTC() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_MWMaximumER() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_MWMinimumER() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_PressureCtrlDG() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_PressureCtrlIG() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_PressureCtrlPG() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_PressureFeedback() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_SuperHeater1Capacity() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_SuperHeater2Capacity() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_SuperHeaterPipePD() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFossilSteamSupply_ThrottlePressureSP() {
		return (EAttribute)fossilSteamSupplyEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDrumBoiler() {
		return drumBoilerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDrumBoiler_DrumBoilerRating() {
		return (EAttribute)drumBoilerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombustionTurbine() {
		return combustionTurbineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_AmbientTemp() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_AuxPowerVersusFrequency() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_AuxPowerVersusVoltage() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_CapabilityVersusFrequency() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_HeatRecoveryFlag() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_PowerVariationByTemp() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_ReferenceTemp() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombustionTurbine_TimeConstant() {
		return (EAttribute)combustionTurbineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombustionTurbine_HeatRecoveryBoiler() {
		return (EReference)combustionTurbineEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombustionTurbine_CTTempMWCurve() {
		return (EReference)combustionTurbineEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombustionTurbine_AirCompressor() {
		return (EReference)combustionTurbineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBWRSteamSupply() {
		return bwrSteamSupplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_HighPowerLimit() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_InCoreThermalTC() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_IntegralGain() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_LowerLimit() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_LowPowerLimit() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_PressureLimit() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_PressureSetpointGA() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_PressureSetpointTC1() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_PressureSetpointTC2() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_ProportionalGain() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux1() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux2() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux3() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux4() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux5() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux6() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux7() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RfAux8() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RodPattern() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_RodPatternConstant() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWRSteamSupply_UpperLimit() {
		return (EAttribute)bwrSteamSupplyEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCTTempMWCurve() {
		return ctTempMWCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCTTempMWCurve_TemperatureUnits() {
		return (EAttribute)ctTempMWCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCTTempMWCurve_CombustionTurbine() {
		return (EReference)ctTempMWCurveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerationdynamicsFactory getGenerationdynamicsFactory() {
		return (GenerationdynamicsFactory)getEFactoryInstance();
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
		supercriticalEClass = createEClass(SUPERCRITICAL);

		subcriticalEClass = createEClass(SUBCRITICAL);

		steamTurbineEClass = createEClass(STEAM_TURBINE);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__CROSSOVER_TC);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__REHEATER1_TC);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__REHEATER2_TC);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT1_POWER_HP);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT1_POWER_IP);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT1_POWER_LP1);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT1_POWER_LP2);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT2_POWER_HP);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT2_POWER_IP);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT2_POWER_LP1);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__SHAFT2_POWER_LP2);
		createEAttribute(steamTurbineEClass, STEAM_TURBINE__STEAM_CHEST_TC);
		createEReference(steamTurbineEClass, STEAM_TURBINE__STEAM_SUPPLYS);

		steamSupplyEClass = createEClass(STEAM_SUPPLY);
		createEAttribute(steamSupplyEClass, STEAM_SUPPLY__STEAM_SUPPLY_RATING);
		createEReference(steamSupplyEClass, STEAM_SUPPLY__STEAM_TURBINES);

		pwrSteamSupplyEClass = createEClass(PWR_STEAM_SUPPLY);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__COLD_LEG_FB_LAG_TC);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC1);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC2);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__COLD_LEG_FG1);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__COLD_LEG_FG2);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__COLD_LEG_LAG_TC);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__CORE_HT_LAG_TC1);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__CORE_HT_LAG_TC2);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__CORE_NEUTRONICS_EFF_TC);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__CORE_NEUTRONICS_HT);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__FEEDBACK_FACTOR);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__HOT_LEG_LAG_TC);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__HOT_LEG_STEAM_GAIN);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__HOT_LEG_TO_COLD_LEG_GAIN);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__PRESSURE_CG);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__STEAM_FLOW_FG);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__STEAM_PRESSURE_DROP_LAG_TC);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__STEAM_PRESSURE_FG);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_FACTOR);
		createEAttribute(pwrSteamSupplyEClass, PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_SP);

		primeMoverEClass = createEClass(PRIME_MOVER);
		createEAttribute(primeMoverEClass, PRIME_MOVER__PRIME_MOVER_RATING);
		createEReference(primeMoverEClass, PRIME_MOVER__SYNCHRONOUS_MACHINES);

		heatRecoveryBoilerEClass = createEClass(HEAT_RECOVERY_BOILER);
		createEAttribute(heatRecoveryBoilerEClass, HEAT_RECOVERY_BOILER__STEAM_SUPPLY_RATING2);
		createEReference(heatRecoveryBoilerEClass, HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES);

		hydroTurbineEClass = createEClass(HYDRO_TURBINE);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__GATE_RATE_LIMIT);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__GATE_UPPER_LIMIT);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__MAX_EFF_MWAT_MIN_HEAD);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__MAX_EFF_MWAT_MAX_HEAD);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__SPEED_RATING);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__SPEED_REGULATION);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__TRANSIENT_DROOP_TIME);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__TRANSIENT_REGULATION);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__TURBINE_RATING);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__TURBINE_TYPE);
		createEAttribute(hydroTurbineEClass, HYDRO_TURBINE__WATER_STARTING_TIME);

		fossilSteamSupplyEClass = createEClass(FOSSIL_STEAM_SUPPLY);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__AUX_POWER_VERSUS_FREQUENCY);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__AUX_POWERVERSUS_VOLTAGE);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__CONTROL_IC);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__BOILER_CONTROL_MODE);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__CONTROL_MWEB);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__CONTROL_PC);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__CONTROL_PEB);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__CONTROL_PED);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__CONTROL_TC);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__FEED_WATER_IG);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__FEED_WATER_PG);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__FEED_WATER_TC);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__FUEL_DEMAND_LIMIT);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_DELAY);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__MECH_POWER_SENSOR_LAG);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__FUEL_SUPPLY_TC);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__MW_MAXIMUM_ER);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__MW_MINIMUM_ER);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_DG);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_IG);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__PRESSURE_CTRL_PG);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__PRESSURE_FEEDBACK);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__SUPER_HEATER1_CAPACITY);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__SUPER_HEATER2_CAPACITY);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__SUPER_HEATER_PIPE_PD);
		createEAttribute(fossilSteamSupplyEClass, FOSSIL_STEAM_SUPPLY__THROTTLE_PRESSURE_SP);

		drumBoilerEClass = createEClass(DRUM_BOILER);
		createEAttribute(drumBoilerEClass, DRUM_BOILER__DRUM_BOILER_RATING);

		combustionTurbineEClass = createEClass(COMBUSTION_TURBINE);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__AMBIENT_TEMP);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__AUX_POWER_VERSUS_FREQUENCY);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__AUX_POWER_VERSUS_VOLTAGE);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__CAPABILITY_VERSUS_FREQUENCY);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__HEAT_RECOVERY_FLAG);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__POWER_VARIATION_BY_TEMP);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__REFERENCE_TEMP);
		createEAttribute(combustionTurbineEClass, COMBUSTION_TURBINE__TIME_CONSTANT);
		createEReference(combustionTurbineEClass, COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER);
		createEReference(combustionTurbineEClass, COMBUSTION_TURBINE__CT_TEMP_MW_CURVE);
		createEReference(combustionTurbineEClass, COMBUSTION_TURBINE__AIR_COMPRESSOR);

		bwrSteamSupplyEClass = createEClass(BWR_STEAM_SUPPLY);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__HIGH_POWER_LIMIT);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__IN_CORE_THERMAL_TC);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__INTEGRAL_GAIN);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__LOWER_LIMIT);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__LOW_POWER_LIMIT);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__PRESSURE_LIMIT);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__PRESSURE_SETPOINT_GA);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__PRESSURE_SETPOINT_TC1);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__PRESSURE_SETPOINT_TC2);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__PROPORTIONAL_GAIN);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX1);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX2);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX3);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX4);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX5);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX6);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX7);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__RF_AUX8);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__ROD_PATTERN);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__ROD_PATTERN_CONSTANT);
		createEAttribute(bwrSteamSupplyEClass, BWR_STEAM_SUPPLY__UPPER_LIMIT);

		ctTempMWCurveEClass = createEClass(CT_TEMP_MW_CURVE);
		createEAttribute(ctTempMWCurveEClass, CT_TEMP_MW_CURVE__TEMPERATURE_UNITS);
		createEReference(ctTempMWCurveEClass, CT_TEMP_MW_CURVE__COMBUSTION_TURBINE);
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
		ProductionPackage theProductionPackage = (ProductionPackage)EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI);

		// Add supertypes to classes
		supercriticalEClass.getESuperTypes().add(this.getFossilSteamSupply());
		subcriticalEClass.getESuperTypes().add(this.getFossilSteamSupply());
		steamTurbineEClass.getESuperTypes().add(this.getPrimeMover());
		steamSupplyEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		pwrSteamSupplyEClass.getESuperTypes().add(this.getSteamSupply());
		primeMoverEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		heatRecoveryBoilerEClass.getESuperTypes().add(this.getFossilSteamSupply());
		hydroTurbineEClass.getESuperTypes().add(this.getPrimeMover());
		fossilSteamSupplyEClass.getESuperTypes().add(this.getSteamSupply());
		drumBoilerEClass.getESuperTypes().add(this.getFossilSteamSupply());
		combustionTurbineEClass.getESuperTypes().add(this.getPrimeMover());
		bwrSteamSupplyEClass.getESuperTypes().add(this.getSteamSupply());
		ctTempMWCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());

		// Initialize classes and features; add operations and parameters
		initEClass(supercriticalEClass, Supercritical.class, "Supercritical", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subcriticalEClass, Subcritical.class, "Subcritical", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(steamTurbineEClass, SteamTurbine.class, "SteamTurbine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSteamTurbine_CrossoverTC(), theDomainPackage.getSeconds(), "crossoverTC", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Reheater1TC(), theDomainPackage.getSeconds(), "reheater1TC", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Reheater2TC(), theDomainPackage.getSeconds(), "reheater2TC", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft1PowerHP(), theDomainPackage.getFraction(), "shaft1PowerHP", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft1PowerIP(), theDomainPackage.getFraction(), "shaft1PowerIP", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft1PowerLP1(), theDomainPackage.getFraction(), "shaft1PowerLP1", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft1PowerLP2(), theDomainPackage.getFraction(), "shaft1PowerLP2", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft2PowerHP(), theDomainPackage.getFraction(), "shaft2PowerHP", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft2PowerIP(), theDomainPackage.getFraction(), "shaft2PowerIP", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft2PowerLP1(), theDomainPackage.getFraction(), "shaft2PowerLP1", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_Shaft2PowerLP2(), theDomainPackage.getFraction(), "shaft2PowerLP2", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSteamTurbine_SteamChestTC(), theDomainPackage.getSeconds(), "steamChestTC", null, 0, 1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSteamTurbine_SteamSupplys(), this.getSteamSupply(), this.getSteamSupply_SteamTurbines(), "SteamSupplys", null, 0, -1, SteamTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(steamSupplyEClass, SteamSupply.class, "SteamSupply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSteamSupply_SteamSupplyRating(), ecorePackage.getEFloatObject(), "steamSupplyRating", null, 0, 1, SteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSteamSupply_SteamTurbines(), this.getSteamTurbine(), this.getSteamTurbine_SteamSupplys(), "SteamTurbines", null, 0, -1, SteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pwrSteamSupplyEClass, PWRSteamSupply.class, "PWRSteamSupply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPWRSteamSupply_ColdLegFBLagTC(), theDomainPackage.getPU(), "coldLegFBLagTC", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ColdLegFBLeadTC1(), theDomainPackage.getPU(), "coldLegFBLeadTC1", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ColdLegFBLeadTC2(), theDomainPackage.getPU(), "coldLegFBLeadTC2", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ColdLegFG1(), theDomainPackage.getPU(), "coldLegFG1", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ColdLegFG2(), theDomainPackage.getPU(), "coldLegFG2", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ColdLegLagTC(), theDomainPackage.getPU(), "coldLegLagTC", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_CoreHTLagTC1(), theDomainPackage.getPU(), "coreHTLagTC1", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_CoreHTLagTC2(), theDomainPackage.getPU(), "coreHTLagTC2", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_CoreNeutronicsEffTC(), theDomainPackage.getPU(), "coreNeutronicsEffTC", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_CoreNeutronicsHT(), theDomainPackage.getPU(), "coreNeutronicsHT", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_FeedbackFactor(), theDomainPackage.getPU(), "feedbackFactor", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_HotLegLagTC(), theDomainPackage.getPU(), "hotLegLagTC", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_HotLegSteamGain(), theDomainPackage.getPU(), "hotLegSteamGain", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_HotLegToColdLegGain(), theDomainPackage.getPU(), "hotLegToColdLegGain", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_PressureCG(), theDomainPackage.getPU(), "pressureCG", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_SteamFlowFG(), theDomainPackage.getPU(), "steamFlowFG", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_SteamPressureDropLagTC(), theDomainPackage.getPU(), "steamPressureDropLagTC", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_SteamPressureFG(), theDomainPackage.getPU(), "steamPressureFG", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ThrottlePressureFactor(), theDomainPackage.getPU(), "throttlePressureFactor", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPWRSteamSupply_ThrottlePressureSP(), theDomainPackage.getPU(), "throttlePressureSP", null, 0, 1, PWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primeMoverEClass, PrimeMover.class, "PrimeMover", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimeMover_PrimeMoverRating(), ecorePackage.getEFloatObject(), "primeMoverRating", null, 0, 1, PrimeMover.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimeMover_SynchronousMachines(), theWirePackage.getSynchronousMachine(), theWirePackage.getSynchronousMachine_PrimeMover(), "SynchronousMachines", null, 1, 1, PrimeMover.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(heatRecoveryBoilerEClass, HeatRecoveryBoiler.class, "HeatRecoveryBoiler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeatRecoveryBoiler_SteamSupplyRating2(), ecorePackage.getEFloatObject(), "steamSupplyRating2", null, 0, 1, HeatRecoveryBoiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeatRecoveryBoiler_CombustionTurbines(), this.getCombustionTurbine(), this.getCombustionTurbine_HeatRecoveryBoiler(), "CombustionTurbines", null, 0, -1, HeatRecoveryBoiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hydroTurbineEClass, HydroTurbine.class, "HydroTurbine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHydroTurbine_GateRateLimit(), theDomainPackage.getRateOfChange(), "gateRateLimit", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_GateUpperLimit(), theDomainPackage.getPU(), "gateUpperLimit", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_MaxEffMWatMinHead(), theDomainPackage.getActivePower(), "maxEffMWatMinHead", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_MaxEffMWatMaxHead(), theDomainPackage.getActivePower(), "maxEffMWatMaxHead", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_SpeedRating(), ecorePackage.getEIntegerObject(), "speedRating", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_SpeedRegulation(), theDomainPackage.getPU(), "speedRegulation", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_TransientDroopTime(), theDomainPackage.getSeconds(), "transientDroopTime", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_TransientRegulation(), theDomainPackage.getPU(), "transientRegulation", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_TurbineRating(), theDomainPackage.getActivePower(), "turbineRating", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_TurbineType(), theDomainPackage.getTurbineType(), "turbineType", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHydroTurbine_WaterStartingTime(), theDomainPackage.getSeconds(), "waterStartingTime", null, 0, 1, HydroTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fossilSteamSupplyEClass, FossilSteamSupply.class, "FossilSteamSupply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFossilSteamSupply_AuxPowerVersusFrequency(), theDomainPackage.getPowerVersusFrequency(), "auxPowerVersusFrequency", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_AuxPowerversusVoltage(), theDomainPackage.getPowerVersusVoltage(), "auxPowerversusVoltage", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ControlIC(), ecorePackage.getEFloatObject(), "controlIC", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_BoilerControlMode(), theDomainPackage.getBoilerControlMode(), "boilerControlMode", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ControlMWEB(), theDomainPackage.getRatio(), "controlMWEB", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ControlPC(), ecorePackage.getEFloatObject(), "controlPC", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ControlPEB(), theDomainPackage.getRatio(), "controlPEB", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ControlPED(), theDomainPackage.getPU(), "controlPED", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ControlTC(), ecorePackage.getEFloatObject(), "controlTC", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_FeedWaterIG(), theDomainPackage.getRatio(), "feedWaterIG", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_FeedWaterPG(), theDomainPackage.getRatio(), "feedWaterPG", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_FeedWaterTC(), theDomainPackage.getSeconds(), "feedWaterTC", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_FuelDemandLimit(), theDomainPackage.getPU(), "fuelDemandLimit", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_FuelSupplyDelay(), theDomainPackage.getSeconds(), "fuelSupplyDelay", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_MechPowerSensorLag(), theDomainPackage.getSeconds(), "mechPowerSensorLag", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_FuelSupplyTC(), theDomainPackage.getSeconds(), "fuelSupplyTC", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_MWMaximumER(), theDomainPackage.getRateOfChange(), "mWMaximumER", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_MWMinimumER(), theDomainPackage.getRateOfChange(), "mWMinimumER", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_PressureCtrlDG(), theDomainPackage.getRatio(), "pressureCtrlDG", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_PressureCtrlIG(), theDomainPackage.getRatio(), "pressureCtrlIG", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_PressureCtrlPG(), theDomainPackage.getRatio(), "pressureCtrlPG", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_PressureFeedback(), ecorePackage.getEIntegerObject(), "pressureFeedback", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_SuperHeater1Capacity(), ecorePackage.getEFloatObject(), "superHeater1Capacity", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_SuperHeater2Capacity(), ecorePackage.getEFloatObject(), "superHeater2Capacity", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_SuperHeaterPipePD(), ecorePackage.getEFloatObject(), "superHeaterPipePD", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFossilSteamSupply_ThrottlePressureSP(), theDomainPackage.getPU(), "throttlePressureSP", null, 0, 1, FossilSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(drumBoilerEClass, DrumBoiler.class, "DrumBoiler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDrumBoiler_DrumBoilerRating(), ecorePackage.getEFloatObject(), "drumBoilerRating", null, 0, 1, DrumBoiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(combustionTurbineEClass, CombustionTurbine.class, "CombustionTurbine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCombustionTurbine_AmbientTemp(), theDomainPackage.getTemperature(), "ambientTemp", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_AuxPowerVersusFrequency(), theDomainPackage.getPowerVersusFrequency(), "auxPowerVersusFrequency", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_AuxPowerVersusVoltage(), theDomainPackage.getPowerVersusVoltage(), "auxPowerVersusVoltage", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_CapabilityVersusFrequency(), theDomainPackage.getPowerVersusFrequency(), "capabilityVersusFrequency", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_HeatRecoveryFlag(), ecorePackage.getEBooleanObject(), "heatRecoveryFlag", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_PowerVariationByTemp(), theDomainPackage.getPU(), "powerVariationByTemp", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_ReferenceTemp(), theDomainPackage.getTemperature(), "referenceTemp", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombustionTurbine_TimeConstant(), theDomainPackage.getSeconds(), "timeConstant", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombustionTurbine_HeatRecoveryBoiler(), this.getHeatRecoveryBoiler(), this.getHeatRecoveryBoiler_CombustionTurbines(), "HeatRecoveryBoiler", null, 1, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombustionTurbine_CTTempMWCurve(), this.getCTTempMWCurve(), this.getCTTempMWCurve_CombustionTurbine(), "CTTempMWCurve", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombustionTurbine_AirCompressor(), theProductionPackage.getAirCompressor(), theProductionPackage.getAirCompressor_CombustionTurbine(), "AirCompressor", null, 0, 1, CombustionTurbine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bwrSteamSupplyEClass, BWRSteamSupply.class, "BWRSteamSupply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBWRSteamSupply_HighPowerLimit(), theDomainPackage.getPU(), "highPowerLimit", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_InCoreThermalTC(), theDomainPackage.getSeconds(), "inCoreThermalTC", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_IntegralGain(), theDomainPackage.getRateOfChange(), "integralGain", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_LowerLimit(), theDomainPackage.getPU(), "lowerLimit", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_LowPowerLimit(), theDomainPackage.getPU(), "lowPowerLimit", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_PressureLimit(), theDomainPackage.getPU(), "pressureLimit", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_PressureSetpointGA(), ecorePackage.getEFloatObject(), "pressureSetpointGA", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_PressureSetpointTC1(), theDomainPackage.getSeconds(), "pressureSetpointTC1", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_PressureSetpointTC2(), theDomainPackage.getSeconds(), "pressureSetpointTC2", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_ProportionalGain(), ecorePackage.getEFloatObject(), "proportionalGain", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux1(), theDomainPackage.getPU(), "rfAux1", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux2(), theDomainPackage.getPU(), "rfAux2", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux3(), theDomainPackage.getPU(), "rfAux3", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux4(), theDomainPackage.getPU(), "rfAux4", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux5(), theDomainPackage.getPU(), "rfAux5", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux6(), theDomainPackage.getPU(), "rfAux6", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux7(), theDomainPackage.getPU(), "rfAux7", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RfAux8(), theDomainPackage.getPU(), "rfAux8", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RodPattern(), theDomainPackage.getPU(), "rodPattern", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_RodPatternConstant(), ecorePackage.getEFloatObject(), "rodPatternConstant", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWRSteamSupply_UpperLimit(), theDomainPackage.getPU(), "upperLimit", null, 0, 1, BWRSteamSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ctTempMWCurveEClass, CTTempMWCurve.class, "CTTempMWCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCTTempMWCurve_TemperatureUnits(), theDomainPackage.getTemperatureUnits(), "temperatureUnits", null, 0, 1, CTTempMWCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCTTempMWCurve_CombustionTurbine(), this.getCombustionTurbine(), this.getCombustionTurbine_CTTempMWCurve(), "CombustionTurbine", null, 1, 1, CTTempMWCurve.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //GenerationdynamicsPackageImpl
