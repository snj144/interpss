/**
 * <copyright>
 * </copyright>
 *
 * $Id: WirePackageImpl.java,v 1.5 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
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

import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.topology.TopologyPackage;

import org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl;

import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.Breaker;
import org.opencim.cim.iec61970.wire.BusbarSection;
import org.opencim.cim.iec61970.wire.Compensator;
import org.opencim.cim.iec61970.wire.CompositeSwitch;
import org.opencim.cim.iec61970.wire.Conductor;
import org.opencim.cim.iec61970.wire.ConductorType;
import org.opencim.cim.iec61970.wire.Connector;
import org.opencim.cim.iec61970.wire.DCLineSegment;
import org.opencim.cim.iec61970.wire.Disconnector;
import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.EquivalentSource;
import org.opencim.cim.iec61970.wire.FrequencyConverter;
import org.opencim.cim.iec61970.wire.Fuse;
import org.opencim.cim.iec61970.wire.Ground;
import org.opencim.cim.iec61970.wire.GroundDisconnector;
import org.opencim.cim.iec61970.wire.HeatExchanger;
import org.opencim.cim.iec61970.wire.Jumper;
import org.opencim.cim.iec61970.wire.Junction;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.LoadBreakSwitch;
import org.opencim.cim.iec61970.wire.MVArCapabilityCurve;
import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.RectifierInverter;
import org.opencim.cim.iec61970.wire.RegulatingCondEq;
import org.opencim.cim.iec61970.wire.RegulationSchedule;
import org.opencim.cim.iec61970.wire.StaticVarCompensator;
import org.opencim.cim.iec61970.wire.Switch;
import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.TapChanger;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.cim.iec61970.wire.VoltageControlZone;
import org.opencim.cim.iec61970.wire.WindingTest;
import org.opencim.cim.iec61970.wire.WireArrangement;
import org.opencim.cim.iec61970.wire.WireFactory;
import org.opencim.cim.iec61970.wire.WirePackage;
import org.opencim.cim.iec61970.wire.WireType;
import org.opencim.cim.iec61970.wire.WiresVersion;

import org.opencim.cim.impl.cimPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WirePackageImpl extends EPackageImpl implements WirePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acLineSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busbarSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compensatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conductorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conductorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dcLineSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disconnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass heatExchangerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jumperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectifierInverterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regulationScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticVarCompensatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tapChangerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerTransformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformerWindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voltageControlZoneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windingTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synchronousMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mvArCapabilityCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalentSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wireTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wireArrangementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadBreakSwitchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass junctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass energyConsumerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regulatingCondEqEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groundDisconnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeSwitchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wiresVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass frequencyConverterEClass = null;

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
	 * @see org.opencim.cim.iec61970.wire.WirePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WirePackageImpl() {
		super(eNS_URI, WireFactory.eINSTANCE);
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
	public static WirePackage init() {
		if (isInited) return (WirePackage)EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI);

		// Obtain or create and register package
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WirePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) : cimPackage.eINSTANCE);
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) : Iec61970Package.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) : LoadPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		theWirePackage.createPackageContents();
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theCorePackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		theWirePackage.initializePackageContents();
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWirePackage.freeze();

		return theWirePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getACLineSegment() {
		return acLineSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getACLineSegment_Line() {
		return (EReference)acLineSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreaker() {
		return breakerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreaker_AmpRating() {
		return (EAttribute)breakerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreaker_InTransitTime() {
		return (EAttribute)breakerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusbarSection() {
		return busbarSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusbarSection_VoltageControlZone() {
		return (EReference)busbarSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompensator() {
		return compensatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_AVRDelay() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_Impedance() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_MaximumkV() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_MaximumSections() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_MinimumkV() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_MVArPerSection() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_NominalkV() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_NominalMVAr() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_NormalSections() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_R() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_SwitchOnCount() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_SwitchOnDate() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_VoltSensitivity() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_X() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_YPerSection() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensator_CompensatorType() {
		return (EAttribute)compensatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConductor() {
		return conductorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_B0ch() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_Bch() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_G0ch() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_Gch() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_Length() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_R() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_R0() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_X() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductor_X0() {
		return (EAttribute)conductorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConductor_ConductorType() {
		return (EReference)conductorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConductorType() {
		return conductorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductorType_SheathResistance() {
		return (EAttribute)conductorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductorType_SheathReactance() {
		return (EAttribute)conductorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConductorType_Conductors() {
		return (EReference)conductorTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConductorType_WireArrangements() {
		return (EReference)conductorTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDCLineSegment() {
		return dcLineSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDCLineSegment_DcSegmentInductance() {
		return (EAttribute)dcLineSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDCLineSegment_DcSegmentResistance() {
		return (EAttribute)dcLineSegmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDCLineSegment_Line() {
		return (EReference)dcLineSegmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisconnector() {
		return disconnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuse() {
		return fuseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuse_AmpRating() {
		return (EAttribute)fuseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGround() {
		return groundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeatExchanger() {
		return heatExchangerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJumper() {
		return jumperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectifierInverter() {
		return rectifierInverterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_RatedKV() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_Bridges() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_CommutatingReactance() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_CommutatingResistance() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_CompoundResistance() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_MinCompoundVoltage() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_Frequency() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_MaximumMW() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_MinimumMW() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectifierInverter_MaximumKV() {
		return (EReference)rectifierInverterEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_MinimumKV() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectifierInverter_OperatingMode() {
		return (EAttribute)rectifierInverterEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegulationSchedule() {
		return regulationScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegulationSchedule_LineDropCompensation() {
		return (EAttribute)regulationScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegulationSchedule_LineDropR() {
		return (EAttribute)regulationScheduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegulationSchedule_LineDropX() {
		return (EAttribute)regulationScheduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegulationSchedule_VoltageControlZones() {
		return (EReference)regulationScheduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegulationSchedule_RegulatingCondEqs() {
		return (EReference)regulationScheduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegulationSchedule_TapChangers() {
		return (EReference)regulationScheduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticVarCompensator() {
		return staticVarCompensatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticVarCompensator_CapacitiveRating() {
		return (EAttribute)staticVarCompensatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticVarCompensator_InductiveRating() {
		return (EAttribute)staticVarCompensatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticVarCompensator_SVCControlMode() {
		return (EAttribute)staticVarCompensatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticVarCompensator_Slope() {
		return (EAttribute)staticVarCompensatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticVarCompensator_VoltageSetPoint() {
		return (EAttribute)staticVarCompensatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitch() {
		return switchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitch_NormalOpen() {
		return (EAttribute)switchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitch_SwitchOnCount() {
		return (EAttribute)switchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitch_SwitchOnDate() {
		return (EAttribute)switchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitch_CompositeSwitch() {
		return (EReference)switchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTapChanger() {
		return tapChangerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_HighStep() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_InitialDelay() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_LowStep() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_NeutralKV() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_NeutralStep() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_NormalStep() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_StepPhaseShiftIncrement() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_StepVoltageIncrement() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_SubsequentDelay() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapChanger_TculControlMode() {
		return (EAttribute)tapChangerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTapChanger_RegulationSchedule() {
		return (EReference)tapChangerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPowerTransformer() {
		return powerTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerTransformer_BmagSat() {
		return (EAttribute)powerTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerTransformer_MagBaseKV() {
		return (EAttribute)powerTransformerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerTransformer_MagSatFlux() {
		return (EAttribute)powerTransformerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerTransformer_Phases() {
		return (EAttribute)powerTransformerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerTransformer_TransfCoolingType() {
		return (EAttribute)powerTransformerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerTransformer_TransformerType() {
		return (EAttribute)powerTransformerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerTransformer_HeatExchanger() {
		return (EReference)powerTransformerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerTransformer_TransformerWindings() {
		return (EReference)powerTransformerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformerWinding() {
		return transformerWindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_B() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_InsulationKV() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_ConnectionType() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_EmergencyMVA() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_G() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_Grounded() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_R() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_R0() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_RatedKV() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_RatedMVA() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_Rground() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_ShortTermMVA() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_WindingType() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_X() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_X0() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformerWinding_Xground() {
		return (EAttribute)transformerWindingEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformerWinding_PowerTransformer() {
		return (EReference)transformerWindingEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformerWinding_TapChangers() {
		return (EReference)transformerWindingEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformerWinding_From_WindingTests() {
		return (EReference)transformerWindingEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformerWinding_To_WindingTest() {
		return (EReference)transformerWindingEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLine() {
		return lineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLine_ACLineSegments() {
		return (EReference)lineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLine_DCLineSegments() {
		return (EReference)lineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoltageControlZone() {
		return voltageControlZoneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVoltageControlZone_BusbarSection() {
		return (EReference)voltageControlZoneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVoltageControlZone_RegulationSchedule() {
		return (EReference)voltageControlZoneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindingTest() {
		return windingTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_ExcitingCurrent() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_FromTapStep() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_LeakageImpedance() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_LoadLoss() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_NoLoadLoss() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_PhaseShift() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_ToTapStep() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindingTest_Voltage() {
		return (EAttribute)windingTestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindingTest_From_TransformerWinding() {
		return (EReference)windingTestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindingTest_To_TransformeWindings() {
		return (EReference)windingTestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynchronousMachine() {
		return synchronousMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_AVRToManualLag() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_AVRToManualLead() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_BaseMVAr() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_CoolantCondition() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_CoolantType() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_Damping() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_Inertia() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_ManualToAVR() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_MaximumKV() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_MaximumMVAr() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_MinimumKV() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_MinimumMVAr() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_R() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_R0() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_RatedMVA() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_X() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_X0() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_XDirectSubtrans() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_XDirectSync() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_XDirectTrans() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_XQuadSubtrans() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_XQuadSync() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_XQuadTrans() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_OperatingMode() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_Type() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronousMachine_CondenserMW() {
		return (EAttribute)synchronousMachineEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronousMachine_MVArCapabilityCurves() {
		return (EReference)synchronousMachineEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronousMachine_Drives_HydroPump() {
		return (EReference)synchronousMachineEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronousMachine_GeneratingUnit() {
		return (EReference)synchronousMachineEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronousMachine_PrimeMover() {
		return (EReference)synchronousMachineEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMVArCapabilityCurve() {
		return mvArCapabilityCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMVArCapabilityCurve_CoolantTemperature() {
		return (EAttribute)mvArCapabilityCurveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMVArCapabilityCurve_HydrogenPressure() {
		return (EAttribute)mvArCapabilityCurveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMVArCapabilityCurve_SynchronousMachines() {
		return (EReference)mvArCapabilityCurveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalentSource() {
		return equivalentSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_Xn() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_Rn() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_NominalVoltage() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_X() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_R() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_VoltageAngle() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_VoltageMagnitude() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_X0() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_R0() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentSource_ActivePower() {
		return (EAttribute)equivalentSourceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWireType() {
		return wireTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireType_PhaseConductorCount() {
		return (EAttribute)wireTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireType_PhaseConductorSpacing() {
		return (EAttribute)wireTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireType_AmpRating() {
		return (EAttribute)wireTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireType_GMR() {
		return (EAttribute)wireTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireType_Radius() {
		return (EAttribute)wireTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireType_Resistance() {
		return (EAttribute)wireTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWireType_WireArrangements() {
		return (EReference)wireTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWireArrangement() {
		return wireArrangementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireArrangement_MountingPointX() {
		return (EAttribute)wireArrangementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWireArrangement_MountingPointY() {
		return (EAttribute)wireArrangementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWireArrangement_ConductorType() {
		return (EReference)wireArrangementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWireArrangement_WireType() {
		return (EReference)wireArrangementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadBreakSwitch() {
		return loadBreakSwitchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBreakSwitch_AmpRating() {
		return (EAttribute)loadBreakSwitchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJunction() {
		return junctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnergyConsumer() {
		return energyConsumerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnergyConsumer_LoadDemandModels() {
		return (EReference)energyConsumerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnergyConsumer_NonConformLoadSchedules() {
		return (EReference)energyConsumerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnergyConsumer_LoadArea() {
		return (EReference)energyConsumerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnergyConsumer_PowerCutZone() {
		return (EReference)energyConsumerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_ConformingLoadFlag() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_CustomerCount() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_PFexp() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_Pfixed() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_PfixedPct() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_Pnom() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_PnomPct() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_PowerFactor() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_PVexp() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_QFexp() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_Qfixed() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_QfixedPct() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_Qnom() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_QnomPct() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnergyConsumer_QVexp() {
		return (EAttribute)energyConsumerEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnector() {
		return connectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegulatingCondEq() {
		return regulatingCondEqEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegulatingCondEq_RegulationSchedule() {
		return (EReference)regulatingCondEqEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroundDisconnector() {
		return groundDisconnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeSwitch() {
		return compositeSwitchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeSwitch_CompositeSwitchType() {
		return (EAttribute)compositeSwitchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeSwitch_Switches() {
		return (EReference)compositeSwitchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWiresVersion() {
		return wiresVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWiresVersion_Version() {
		return (EAttribute)wiresVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWiresVersion_Date() {
		return (EAttribute)wiresVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFrequencyConverter() {
		return frequencyConverterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrequencyConverter_Frequency() {
		return (EAttribute)frequencyConverterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrequencyConverter_MaximumMW() {
		return (EAttribute)frequencyConverterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrequencyConverter_MaximumKV() {
		return (EAttribute)frequencyConverterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrequencyConverter_MinimumMW() {
		return (EAttribute)frequencyConverterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrequencyConverter_MinimumKV() {
		return (EAttribute)frequencyConverterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrequencyConverter_OperatingMode() {
		return (EAttribute)frequencyConverterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireFactory getWireFactory() {
		return (WireFactory)getEFactoryInstance();
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
		acLineSegmentEClass = createEClass(AC_LINE_SEGMENT);
		createEReference(acLineSegmentEClass, AC_LINE_SEGMENT__LINE);

		breakerEClass = createEClass(BREAKER);
		createEAttribute(breakerEClass, BREAKER__AMP_RATING);
		createEAttribute(breakerEClass, BREAKER__IN_TRANSIT_TIME);

		busbarSectionEClass = createEClass(BUSBAR_SECTION);
		createEReference(busbarSectionEClass, BUSBAR_SECTION__VOLTAGE_CONTROL_ZONE);

		compensatorEClass = createEClass(COMPENSATOR);
		createEAttribute(compensatorEClass, COMPENSATOR__AVR_DELAY);
		createEAttribute(compensatorEClass, COMPENSATOR__IMPEDANCE);
		createEAttribute(compensatorEClass, COMPENSATOR__MAXIMUMK_V);
		createEAttribute(compensatorEClass, COMPENSATOR__MAXIMUM_SECTIONS);
		createEAttribute(compensatorEClass, COMPENSATOR__MINIMUMK_V);
		createEAttribute(compensatorEClass, COMPENSATOR__MV_AR_PER_SECTION);
		createEAttribute(compensatorEClass, COMPENSATOR__NOMINALK_V);
		createEAttribute(compensatorEClass, COMPENSATOR__NOMINAL_MV_AR);
		createEAttribute(compensatorEClass, COMPENSATOR__NORMAL_SECTIONS);
		createEAttribute(compensatorEClass, COMPENSATOR__R);
		createEAttribute(compensatorEClass, COMPENSATOR__SWITCH_ON_COUNT);
		createEAttribute(compensatorEClass, COMPENSATOR__SWITCH_ON_DATE);
		createEAttribute(compensatorEClass, COMPENSATOR__VOLT_SENSITIVITY);
		createEAttribute(compensatorEClass, COMPENSATOR__X);
		createEAttribute(compensatorEClass, COMPENSATOR__YPER_SECTION);
		createEAttribute(compensatorEClass, COMPENSATOR__COMPENSATOR_TYPE);

		conductorEClass = createEClass(CONDUCTOR);
		createEAttribute(conductorEClass, CONDUCTOR__B0CH);
		createEAttribute(conductorEClass, CONDUCTOR__BCH);
		createEAttribute(conductorEClass, CONDUCTOR__G0CH);
		createEAttribute(conductorEClass, CONDUCTOR__GCH);
		createEAttribute(conductorEClass, CONDUCTOR__LENGTH);
		createEAttribute(conductorEClass, CONDUCTOR__R);
		createEAttribute(conductorEClass, CONDUCTOR__R0);
		createEAttribute(conductorEClass, CONDUCTOR__X);
		createEAttribute(conductorEClass, CONDUCTOR__X0);
		createEReference(conductorEClass, CONDUCTOR__CONDUCTOR_TYPE);

		conductorTypeEClass = createEClass(CONDUCTOR_TYPE);
		createEAttribute(conductorTypeEClass, CONDUCTOR_TYPE__SHEATH_RESISTANCE);
		createEAttribute(conductorTypeEClass, CONDUCTOR_TYPE__SHEATH_REACTANCE);
		createEReference(conductorTypeEClass, CONDUCTOR_TYPE__CONDUCTORS);
		createEReference(conductorTypeEClass, CONDUCTOR_TYPE__WIRE_ARRANGEMENTS);

		dcLineSegmentEClass = createEClass(DC_LINE_SEGMENT);
		createEAttribute(dcLineSegmentEClass, DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE);
		createEAttribute(dcLineSegmentEClass, DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE);
		createEReference(dcLineSegmentEClass, DC_LINE_SEGMENT__LINE);

		disconnectorEClass = createEClass(DISCONNECTOR);

		fuseEClass = createEClass(FUSE);
		createEAttribute(fuseEClass, FUSE__AMP_RATING);

		groundEClass = createEClass(GROUND);

		heatExchangerEClass = createEClass(HEAT_EXCHANGER);

		jumperEClass = createEClass(JUMPER);

		rectifierInverterEClass = createEClass(RECTIFIER_INVERTER);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__RATED_KV);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__BRIDGES);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__COMMUTATING_REACTANCE);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__COMMUTATING_RESISTANCE);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__COMPOUND_RESISTANCE);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__FREQUENCY);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__MAXIMUM_MW);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__MINIMUM_MW);
		createEReference(rectifierInverterEClass, RECTIFIER_INVERTER__MAXIMUM_KV);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__MINIMUM_KV);
		createEAttribute(rectifierInverterEClass, RECTIFIER_INVERTER__OPERATING_MODE);

		regulationScheduleEClass = createEClass(REGULATION_SCHEDULE);
		createEAttribute(regulationScheduleEClass, REGULATION_SCHEDULE__LINE_DROP_COMPENSATION);
		createEAttribute(regulationScheduleEClass, REGULATION_SCHEDULE__LINE_DROP_R);
		createEAttribute(regulationScheduleEClass, REGULATION_SCHEDULE__LINE_DROP_X);
		createEReference(regulationScheduleEClass, REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES);
		createEReference(regulationScheduleEClass, REGULATION_SCHEDULE__REGULATING_COND_EQS);
		createEReference(regulationScheduleEClass, REGULATION_SCHEDULE__TAP_CHANGERS);

		staticVarCompensatorEClass = createEClass(STATIC_VAR_COMPENSATOR);
		createEAttribute(staticVarCompensatorEClass, STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING);
		createEAttribute(staticVarCompensatorEClass, STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING);
		createEAttribute(staticVarCompensatorEClass, STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE);
		createEAttribute(staticVarCompensatorEClass, STATIC_VAR_COMPENSATOR__SLOPE);
		createEAttribute(staticVarCompensatorEClass, STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT);

		switchEClass = createEClass(SWITCH);
		createEAttribute(switchEClass, SWITCH__NORMAL_OPEN);
		createEAttribute(switchEClass, SWITCH__SWITCH_ON_COUNT);
		createEAttribute(switchEClass, SWITCH__SWITCH_ON_DATE);
		createEReference(switchEClass, SWITCH__COMPOSITE_SWITCH);

		tapChangerEClass = createEClass(TAP_CHANGER);
		createEAttribute(tapChangerEClass, TAP_CHANGER__HIGH_STEP);
		createEAttribute(tapChangerEClass, TAP_CHANGER__INITIAL_DELAY);
		createEAttribute(tapChangerEClass, TAP_CHANGER__LOW_STEP);
		createEAttribute(tapChangerEClass, TAP_CHANGER__NEUTRAL_KV);
		createEAttribute(tapChangerEClass, TAP_CHANGER__NEUTRAL_STEP);
		createEAttribute(tapChangerEClass, TAP_CHANGER__NORMAL_STEP);
		createEAttribute(tapChangerEClass, TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT);
		createEAttribute(tapChangerEClass, TAP_CHANGER__STEP_VOLTAGE_INCREMENT);
		createEAttribute(tapChangerEClass, TAP_CHANGER__SUBSEQUENT_DELAY);
		createEAttribute(tapChangerEClass, TAP_CHANGER__TCUL_CONTROL_MODE);
		createEReference(tapChangerEClass, TAP_CHANGER__REGULATION_SCHEDULE);

		powerTransformerEClass = createEClass(POWER_TRANSFORMER);
		createEAttribute(powerTransformerEClass, POWER_TRANSFORMER__BMAG_SAT);
		createEAttribute(powerTransformerEClass, POWER_TRANSFORMER__MAG_BASE_KV);
		createEAttribute(powerTransformerEClass, POWER_TRANSFORMER__MAG_SAT_FLUX);
		createEAttribute(powerTransformerEClass, POWER_TRANSFORMER__PHASES);
		createEAttribute(powerTransformerEClass, POWER_TRANSFORMER__TRANSF_COOLING_TYPE);
		createEAttribute(powerTransformerEClass, POWER_TRANSFORMER__TRANSFORMER_TYPE);
		createEReference(powerTransformerEClass, POWER_TRANSFORMER__HEAT_EXCHANGER);
		createEReference(powerTransformerEClass, POWER_TRANSFORMER__TRANSFORMER_WINDINGS);

		transformerWindingEClass = createEClass(TRANSFORMER_WINDING);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__B);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__INSULATION_KV);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__CONNECTION_TYPE);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__EMERGENCY_MVA);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__G);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__GROUNDED);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__R);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__R0);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__RATED_KV);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__RATED_MVA);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__RGROUND);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__SHORT_TERM_MVA);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__WINDING_TYPE);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__X);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__X0);
		createEAttribute(transformerWindingEClass, TRANSFORMER_WINDING__XGROUND);
		createEReference(transformerWindingEClass, TRANSFORMER_WINDING__POWER_TRANSFORMER);
		createEReference(transformerWindingEClass, TRANSFORMER_WINDING__TAP_CHANGERS);
		createEReference(transformerWindingEClass, TRANSFORMER_WINDING__FROM_WINDING_TESTS);
		createEReference(transformerWindingEClass, TRANSFORMER_WINDING__TO_WINDING_TEST);

		lineEClass = createEClass(LINE);
		createEReference(lineEClass, LINE__AC_LINE_SEGMENTS);
		createEReference(lineEClass, LINE__DC_LINE_SEGMENTS);

		voltageControlZoneEClass = createEClass(VOLTAGE_CONTROL_ZONE);
		createEReference(voltageControlZoneEClass, VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION);
		createEReference(voltageControlZoneEClass, VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE);

		windingTestEClass = createEClass(WINDING_TEST);
		createEAttribute(windingTestEClass, WINDING_TEST__EXCITING_CURRENT);
		createEAttribute(windingTestEClass, WINDING_TEST__FROM_TAP_STEP);
		createEAttribute(windingTestEClass, WINDING_TEST__LEAKAGE_IMPEDANCE);
		createEAttribute(windingTestEClass, WINDING_TEST__LOAD_LOSS);
		createEAttribute(windingTestEClass, WINDING_TEST__NO_LOAD_LOSS);
		createEAttribute(windingTestEClass, WINDING_TEST__PHASE_SHIFT);
		createEAttribute(windingTestEClass, WINDING_TEST__TO_TAP_STEP);
		createEAttribute(windingTestEClass, WINDING_TEST__VOLTAGE);
		createEReference(windingTestEClass, WINDING_TEST__FROM_TRANSFORMER_WINDING);
		createEReference(windingTestEClass, WINDING_TEST__TO_TRANSFORME_WINDINGS);

		synchronousMachineEClass = createEClass(SYNCHRONOUS_MACHINE);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__BASE_MV_AR);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__COOLANT_CONDITION);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__COOLANT_TYPE);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__DAMPING);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__INERTIA);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__MANUAL_TO_AVR);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__MAXIMUM_KV);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__MINIMUM_KV);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__MINIMUM_MV_AR);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__R);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__R0);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__RATED_MVA);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__X);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__X0);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__XDIRECT_SYNC);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__XDIRECT_TRANS);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__XQUAD_SYNC);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__XQUAD_TRANS);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__OPERATING_MODE);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__TYPE);
		createEAttribute(synchronousMachineEClass, SYNCHRONOUS_MACHINE__CONDENSER_MW);
		createEReference(synchronousMachineEClass, SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES);
		createEReference(synchronousMachineEClass, SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP);
		createEReference(synchronousMachineEClass, SYNCHRONOUS_MACHINE__GENERATING_UNIT);
		createEReference(synchronousMachineEClass, SYNCHRONOUS_MACHINE__PRIME_MOVER);

		mvArCapabilityCurveEClass = createEClass(MV_AR_CAPABILITY_CURVE);
		createEAttribute(mvArCapabilityCurveEClass, MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE);
		createEAttribute(mvArCapabilityCurveEClass, MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE);
		createEReference(mvArCapabilityCurveEClass, MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES);

		equivalentSourceEClass = createEClass(EQUIVALENT_SOURCE);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__XN);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__RN);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__NOMINAL_VOLTAGE);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__X);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__R);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__VOLTAGE_ANGLE);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__X0);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__R0);
		createEAttribute(equivalentSourceEClass, EQUIVALENT_SOURCE__ACTIVE_POWER);

		wireTypeEClass = createEClass(WIRE_TYPE);
		createEAttribute(wireTypeEClass, WIRE_TYPE__PHASE_CONDUCTOR_COUNT);
		createEAttribute(wireTypeEClass, WIRE_TYPE__PHASE_CONDUCTOR_SPACING);
		createEAttribute(wireTypeEClass, WIRE_TYPE__AMP_RATING);
		createEAttribute(wireTypeEClass, WIRE_TYPE__GMR);
		createEAttribute(wireTypeEClass, WIRE_TYPE__RADIUS);
		createEAttribute(wireTypeEClass, WIRE_TYPE__RESISTANCE);
		createEReference(wireTypeEClass, WIRE_TYPE__WIRE_ARRANGEMENTS);

		wireArrangementEClass = createEClass(WIRE_ARRANGEMENT);
		createEAttribute(wireArrangementEClass, WIRE_ARRANGEMENT__MOUNTING_POINT_X);
		createEAttribute(wireArrangementEClass, WIRE_ARRANGEMENT__MOUNTING_POINT_Y);
		createEReference(wireArrangementEClass, WIRE_ARRANGEMENT__CONDUCTOR_TYPE);
		createEReference(wireArrangementEClass, WIRE_ARRANGEMENT__WIRE_TYPE);

		loadBreakSwitchEClass = createEClass(LOAD_BREAK_SWITCH);
		createEAttribute(loadBreakSwitchEClass, LOAD_BREAK_SWITCH__AMP_RATING);

		junctionEClass = createEClass(JUNCTION);

		energyConsumerEClass = createEClass(ENERGY_CONSUMER);
		createEReference(energyConsumerEClass, ENERGY_CONSUMER__LOAD_DEMAND_MODELS);
		createEReference(energyConsumerEClass, ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES);
		createEReference(energyConsumerEClass, ENERGY_CONSUMER__LOAD_AREA);
		createEReference(energyConsumerEClass, ENERGY_CONSUMER__POWER_CUT_ZONE);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__CONFORMING_LOAD_FLAG);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__CUSTOMER_COUNT);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__PFEXP);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__PFIXED);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__PFIXED_PCT);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__PNOM);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__PNOM_PCT);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__POWER_FACTOR);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__PVEXP);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__QFEXP);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__QFIXED);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__QFIXED_PCT);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__QNOM);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__QNOM_PCT);
		createEAttribute(energyConsumerEClass, ENERGY_CONSUMER__QVEXP);

		connectorEClass = createEClass(CONNECTOR);

		regulatingCondEqEClass = createEClass(REGULATING_COND_EQ);
		createEReference(regulatingCondEqEClass, REGULATING_COND_EQ__REGULATION_SCHEDULE);

		groundDisconnectorEClass = createEClass(GROUND_DISCONNECTOR);

		compositeSwitchEClass = createEClass(COMPOSITE_SWITCH);
		createEAttribute(compositeSwitchEClass, COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE);
		createEReference(compositeSwitchEClass, COMPOSITE_SWITCH__SWITCHES);

		wiresVersionEClass = createEClass(WIRES_VERSION);
		createEAttribute(wiresVersionEClass, WIRES_VERSION__VERSION);
		createEAttribute(wiresVersionEClass, WIRES_VERSION__DATE);

		frequencyConverterEClass = createEClass(FREQUENCY_CONVERTER);
		createEAttribute(frequencyConverterEClass, FREQUENCY_CONVERTER__FREQUENCY);
		createEAttribute(frequencyConverterEClass, FREQUENCY_CONVERTER__MAXIMUM_MW);
		createEAttribute(frequencyConverterEClass, FREQUENCY_CONVERTER__MAXIMUM_KV);
		createEAttribute(frequencyConverterEClass, FREQUENCY_CONVERTER__MINIMUM_MW);
		createEAttribute(frequencyConverterEClass, FREQUENCY_CONVERTER__MINIMUM_KV);
		createEAttribute(frequencyConverterEClass, FREQUENCY_CONVERTER__OPERATING_MODE);
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
		ProductionPackage theProductionPackage = (ProductionPackage)EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI);
		GenerationdynamicsPackage theGenerationdynamicsPackage = (GenerationdynamicsPackage)EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI);
		LoadPackage theLoadPackage = (LoadPackage)EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI);

		// Add supertypes to classes
		acLineSegmentEClass.getESuperTypes().add(this.getConductor());
		breakerEClass.getESuperTypes().add(this.getSwitch());
		busbarSectionEClass.getESuperTypes().add(this.getConnector());
		compensatorEClass.getESuperTypes().add(this.getRegulatingCondEq());
		conductorEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		conductorTypeEClass.getESuperTypes().add(theCorePackage.getNaming());
		dcLineSegmentEClass.getESuperTypes().add(this.getConductor());
		disconnectorEClass.getESuperTypes().add(this.getSwitch());
		fuseEClass.getESuperTypes().add(this.getSwitch());
		groundEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		heatExchangerEClass.getESuperTypes().add(theCorePackage.getEquipment());
		jumperEClass.getESuperTypes().add(this.getSwitch());
		rectifierInverterEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		regulationScheduleEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		staticVarCompensatorEClass.getESuperTypes().add(this.getRegulatingCondEq());
		switchEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		tapChangerEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		powerTransformerEClass.getESuperTypes().add(theCorePackage.getEquipment());
		transformerWindingEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		lineEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		voltageControlZoneEClass.getESuperTypes().add(theCorePackage.getPowerSystemResource());
		windingTestEClass.getESuperTypes().add(theCorePackage.getNaming());
		synchronousMachineEClass.getESuperTypes().add(this.getRegulatingCondEq());
		mvArCapabilityCurveEClass.getESuperTypes().add(theCorePackage.getCurveSchedule());
		equivalentSourceEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		wireTypeEClass.getESuperTypes().add(theCorePackage.getNaming());
		wireArrangementEClass.getESuperTypes().add(theCorePackage.getNaming());
		loadBreakSwitchEClass.getESuperTypes().add(this.getSwitch());
		junctionEClass.getESuperTypes().add(this.getConnector());
		energyConsumerEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		connectorEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		regulatingCondEqEClass.getESuperTypes().add(theCorePackage.getConductingEquipment());
		groundDisconnectorEClass.getESuperTypes().add(this.getSwitch());
		compositeSwitchEClass.getESuperTypes().add(theCorePackage.getEquipmentContainer());
		frequencyConverterEClass.getESuperTypes().add(this.getRegulatingCondEq());

		// Initialize classes and features; add operations and parameters
		initEClass(acLineSegmentEClass, ACLineSegment.class, "ACLineSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getACLineSegment_Line(), this.getLine(), this.getLine_ACLineSegments(), "Line", null, 1, 1, ACLineSegment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(breakerEClass, Breaker.class, "Breaker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBreaker_AmpRating(), theDomainPackage.getCurrentFlow(), "ampRating", null, 0, 1, Breaker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBreaker_InTransitTime(), theDomainPackage.getSeconds(), "inTransitTime", null, 0, 1, Breaker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(busbarSectionEClass, BusbarSection.class, "BusbarSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusbarSection_VoltageControlZone(), this.getVoltageControlZone(), this.getVoltageControlZone_BusbarSection(), "VoltageControlZone", null, 0, 1, BusbarSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compensatorEClass, Compensator.class, "Compensator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompensator_AVRDelay(), theDomainPackage.getSeconds(), "aVRDelay", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_Impedance(), theDomainPackage.getImpedance(), "impedance", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_MaximumkV(), theDomainPackage.getVoltage(), "maximumkV", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_MaximumSections(), theDomainPackage.getCounter(), "maximumSections", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_MinimumkV(), theDomainPackage.getVoltage(), "minimumkV", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_MVArPerSection(), theDomainPackage.getReactivePower(), "mVArPerSection", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_NominalkV(), theDomainPackage.getVoltage(), "nominalkV", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_NominalMVAr(), theDomainPackage.getReactivePower(), "nominalMVAr", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_NormalSections(), theDomainPackage.getCounter(), "normalSections", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_R(), theDomainPackage.getResistance(), "r", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_SwitchOnCount(), theDomainPackage.getCounter(), "switchOnCount", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_SwitchOnDate(), theDomainPackage.getAbsoluteDateTime(), "switchOnDate", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_VoltSensitivity(), theDomainPackage.getPUkVPerMVAr(), "voltSensitivity", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_X(), theDomainPackage.getReactance(), "x", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_YPerSection(), theDomainPackage.getAdmittance(), "yPerSection", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompensator_CompensatorType(), theDomainPackage.getCompensatorType(), "compensatorType", null, 0, 1, Compensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conductorEClass, Conductor.class, "Conductor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConductor_B0ch(), theDomainPackage.getSusceptance(), "b0ch", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_Bch(), theDomainPackage.getSusceptance(), "bch", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_G0ch(), theDomainPackage.getConductance(), "g0ch", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_Gch(), theDomainPackage.getConductance(), "gch", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_Length(), theDomainPackage.getLongLength(), "length", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_R(), theDomainPackage.getResistance(), "r", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_R0(), theDomainPackage.getResistance(), "r0", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_X(), theDomainPackage.getReactance(), "x", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductor_X0(), theDomainPackage.getReactance(), "x0", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConductor_ConductorType(), this.getConductorType(), this.getConductorType_Conductors(), "ConductorType", null, 0, 1, Conductor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conductorTypeEClass, ConductorType.class, "ConductorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConductorType_SheathResistance(), theDomainPackage.getResistance(), "sheathResistance", null, 0, 1, ConductorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConductorType_SheathReactance(), theDomainPackage.getReactance(), "sheathReactance", null, 0, 1, ConductorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConductorType_Conductors(), this.getConductor(), this.getConductor_ConductorType(), "Conductors", null, 0, -1, ConductorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConductorType_WireArrangements(), this.getWireArrangement(), this.getWireArrangement_ConductorType(), "WireArrangements", null, 0, -1, ConductorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dcLineSegmentEClass, DCLineSegment.class, "DCLineSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDCLineSegment_DcSegmentInductance(), theDomainPackage.getInductance(), "dcSegmentInductance", null, 0, 1, DCLineSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDCLineSegment_DcSegmentResistance(), theDomainPackage.getResistance(), "dcSegmentResistance", null, 0, 1, DCLineSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDCLineSegment_Line(), this.getLine(), this.getLine_DCLineSegments(), "Line", null, 1, 1, DCLineSegment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(disconnectorEClass, Disconnector.class, "Disconnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fuseEClass, Fuse.class, "Fuse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFuse_AmpRating(), theDomainPackage.getCurrentFlow(), "ampRating", null, 0, 1, Fuse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groundEClass, Ground.class, "Ground", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(heatExchangerEClass, HeatExchanger.class, "HeatExchanger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jumperEClass, Jumper.class, "Jumper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rectifierInverterEClass, RectifierInverter.class, "RectifierInverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRectifierInverter_RatedKV(), theDomainPackage.getVoltage(), "ratedKV", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_Bridges(), theDomainPackage.getCounter(), "bridges", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_CommutatingReactance(), theDomainPackage.getReactance(), "commutatingReactance", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_CommutatingResistance(), theDomainPackage.getResistance(), "commutatingResistance", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_CompoundResistance(), theDomainPackage.getResistance(), "compoundResistance", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_MinCompoundVoltage(), theDomainPackage.getVoltage(), "minCompoundVoltage", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_Frequency(), theDomainPackage.getFrequency(), "frequency", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_MaximumMW(), theDomainPackage.getActivePower(), "maximumMW", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_MinimumMW(), theDomainPackage.getActivePower(), "minimumMW", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRectifierInverter_MaximumKV(), this.getVoltageControlZone(), null, "maximumKV", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_MinimumKV(), theDomainPackage.getVoltage(), "minimumKV", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectifierInverter_OperatingMode(), theDomainPackage.getOperatingMode(), "operatingMode", null, 0, 1, RectifierInverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regulationScheduleEClass, RegulationSchedule.class, "RegulationSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegulationSchedule_LineDropCompensation(), ecorePackage.getEBooleanObject(), "lineDropCompensation", null, 0, 1, RegulationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegulationSchedule_LineDropR(), theDomainPackage.getResistance(), "lineDropR", null, 0, 1, RegulationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegulationSchedule_LineDropX(), theDomainPackage.getReactance(), "lineDropX", null, 0, 1, RegulationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegulationSchedule_VoltageControlZones(), this.getVoltageControlZone(), this.getVoltageControlZone_RegulationSchedule(), "VoltageControlZones", null, 0, -1, RegulationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegulationSchedule_RegulatingCondEqs(), this.getRegulatingCondEq(), this.getRegulatingCondEq_RegulationSchedule(), "RegulatingCondEqs", null, 0, -1, RegulationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegulationSchedule_TapChangers(), this.getTapChanger(), this.getTapChanger_RegulationSchedule(), "TapChangers", null, 0, -1, RegulationSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticVarCompensatorEClass, StaticVarCompensator.class, "StaticVarCompensator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticVarCompensator_CapacitiveRating(), theDomainPackage.getReactance(), "capacitiveRating", null, 0, 1, StaticVarCompensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticVarCompensator_InductiveRating(), theDomainPackage.getReactance(), "inductiveRating", null, 0, 1, StaticVarCompensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticVarCompensator_SVCControlMode(), theDomainPackage.getControlMode(), "sVCControlMode", null, 0, 1, StaticVarCompensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticVarCompensator_Slope(), theDomainPackage.getVoltagePerReactivePower(), "slope", null, 0, 1, StaticVarCompensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticVarCompensator_VoltageSetPoint(), theDomainPackage.getVoltage(), "voltageSetPoint", null, 0, 1, StaticVarCompensator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchEClass, Switch.class, "Switch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwitch_NormalOpen(), ecorePackage.getEBooleanObject(), "normalOpen", null, 0, 1, Switch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwitch_SwitchOnCount(), theDomainPackage.getCounter(), "switchOnCount", null, 0, 1, Switch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwitch_SwitchOnDate(), theDomainPackage.getAbsoluteDateTime(), "switchOnDate", null, 0, 1, Switch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitch_CompositeSwitch(), this.getCompositeSwitch(), this.getCompositeSwitch_Switches(), "CompositeSwitch", null, 0, 1, Switch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tapChangerEClass, TapChanger.class, "TapChanger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTapChanger_HighStep(), theDomainPackage.getTapStep(), "highStep", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_InitialDelay(), theDomainPackage.getSeconds(), "initialDelay", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_LowStep(), theDomainPackage.getTapStep(), "lowStep", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_NeutralKV(), theDomainPackage.getVoltage(), "neutralKV", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_NeutralStep(), theDomainPackage.getTapStep(), "neutralStep", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_NormalStep(), theDomainPackage.getTapStep(), "normalStep", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_StepPhaseShiftIncrement(), theDomainPackage.getAngleDegrees(), "stepPhaseShiftIncrement", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_StepVoltageIncrement(), theDomainPackage.getPerCent(), "stepVoltageIncrement", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_SubsequentDelay(), theDomainPackage.getSeconds(), "subsequentDelay", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapChanger_TculControlMode(), theDomainPackage.getTransformerControlMode(), "tculControlMode", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTapChanger_RegulationSchedule(), this.getRegulationSchedule(), this.getRegulationSchedule_TapChangers(), "RegulationSchedule", null, 0, 1, TapChanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerTransformerEClass, PowerTransformer.class, "PowerTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPowerTransformer_BmagSat(), theDomainPackage.getPerCent(), "bmagSat", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerTransformer_MagBaseKV(), theDomainPackage.getVoltage(), "magBaseKV", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerTransformer_MagSatFlux(), theDomainPackage.getPerCent(), "magSatFlux", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerTransformer_Phases(), theDomainPackage.getPhaseCode(), "phases", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerTransformer_TransfCoolingType(), theDomainPackage.getTransformerCoolingType(), "transfCoolingType", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerTransformer_TransformerType(), theDomainPackage.getTransformerType(), "transformerType", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerTransformer_HeatExchanger(), this.getHeatExchanger(), null, "HeatExchanger", null, 0, 1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerTransformer_TransformerWindings(), this.getTransformerWinding(), this.getTransformerWinding_PowerTransformer(), "TransformerWindings", null, 1, -1, PowerTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformerWindingEClass, TransformerWinding.class, "TransformerWinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransformerWinding_B(), theDomainPackage.getSusceptance(), "b", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_InsulationKV(), theDomainPackage.getVoltage(), "insulationKV", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_ConnectionType(), theDomainPackage.getWindingConnection(), "connectionType", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_EmergencyMVA(), theDomainPackage.getApparentPower(), "emergencyMVA", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_G(), theDomainPackage.getConductance(), "g", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_Grounded(), ecorePackage.getEBooleanObject(), "grounded", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_R(), theDomainPackage.getResistance(), "r", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_R0(), theDomainPackage.getResistance(), "r0", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_RatedKV(), theDomainPackage.getVoltage(), "ratedKV", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_RatedMVA(), theDomainPackage.getApparentPower(), "ratedMVA", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_Rground(), theDomainPackage.getResistance(), "rground", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_ShortTermMVA(), theDomainPackage.getApparentPower(), "shortTermMVA", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_WindingType(), theDomainPackage.getWindingType(), "windingType", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_X(), theDomainPackage.getReactance(), "x", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_X0(), theDomainPackage.getReactance(), "x0", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformerWinding_Xground(), theDomainPackage.getReactance(), "xground", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformerWinding_PowerTransformer(), this.getPowerTransformer(), this.getPowerTransformer_TransformerWindings(), "PowerTransformer", null, 1, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformerWinding_TapChangers(), this.getTapChanger(), null, "TapChangers", null, 0, -1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformerWinding_From_WindingTests(), this.getWindingTest(), this.getWindingTest_From_TransformerWinding(), "From_WindingTests", null, 0, -1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformerWinding_To_WindingTest(), this.getWindingTest(), this.getWindingTest_To_TransformeWindings(), "To_WindingTest", null, 0, 1, TransformerWinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLine_ACLineSegments(), this.getACLineSegment(), this.getACLineSegment_Line(), "ACLineSegments", null, 0, -1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLine_DCLineSegments(), this.getDCLineSegment(), this.getDCLineSegment_Line(), "DCLineSegments", null, 0, -1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(voltageControlZoneEClass, VoltageControlZone.class, "VoltageControlZone", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVoltageControlZone_BusbarSection(), this.getBusbarSection(), this.getBusbarSection_VoltageControlZone(), "BusbarSection", null, 1, 1, VoltageControlZone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVoltageControlZone_RegulationSchedule(), this.getRegulationSchedule(), this.getRegulationSchedule_VoltageControlZones(), "RegulationSchedule", null, 0, 1, VoltageControlZone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(windingTestEClass, WindingTest.class, "WindingTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWindingTest_ExcitingCurrent(), theDomainPackage.getExcitingCurrent(), "excitingCurrent", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_FromTapStep(), theDomainPackage.getTapStep(), "fromTapStep", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_LeakageImpedance(), theDomainPackage.getImpedance(), "leakageImpedance", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_LoadLoss(), theDomainPackage.getLoadLoss(), "loadLoss", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_NoLoadLoss(), theDomainPackage.getNoLoadLoss(), "noLoadLoss", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_PhaseShift(), theDomainPackage.getAngleDegrees(), "phaseShift", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_ToTapStep(), theDomainPackage.getTapStep(), "toTapStep", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindingTest_Voltage(), theDomainPackage.getVoltage(), "voltage", null, 0, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWindingTest_From_TransformerWinding(), this.getTransformerWinding(), this.getTransformerWinding_From_WindingTests(), "From_TransformerWinding", null, 1, 1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWindingTest_To_TransformeWindings(), this.getTransformerWinding(), this.getTransformerWinding_To_WindingTest(), "To_TransformeWindings", null, 0, -1, WindingTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synchronousMachineEClass, SynchronousMachine.class, "SynchronousMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSynchronousMachine_AVRToManualLag(), theDomainPackage.getSeconds(), "aVRToManualLag", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_AVRToManualLead(), theDomainPackage.getSeconds(), "aVRToManualLead", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_BaseMVAr(), theDomainPackage.getReactivePower(), "baseMVAr", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_CoolantCondition(), ecorePackage.getEFloatObject(), "coolantCondition", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_CoolantType(), theDomainPackage.getCoolantType(), "coolantType", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_Damping(), theDomainPackage.getDamping(), "damping", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_Inertia(), theDomainPackage.getInertia(), "inertia", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_ManualToAVR(), theDomainPackage.getSeconds(), "manualToAVR", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_MaximumKV(), theDomainPackage.getVoltage(), "maximumKV", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_MaximumMVAr(), theDomainPackage.getReactivePower(), "maximumMVAr", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_MinimumKV(), theDomainPackage.getVoltage(), "minimumKV", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_MinimumMVAr(), theDomainPackage.getReactivePower(), "minimumMVAr", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_R(), theDomainPackage.getResistance(), "r", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_R0(), theDomainPackage.getResistance(), "r0", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_RatedMVA(), theDomainPackage.getApparentPower(), "ratedMVA", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_X(), theDomainPackage.getReactance(), "x", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_X0(), theDomainPackage.getReactance(), "x0", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_XDirectSubtrans(), theDomainPackage.getReactance(), "xDirectSubtrans", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_XDirectSync(), theDomainPackage.getReactance(), "xDirectSync", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_XDirectTrans(), theDomainPackage.getReactance(), "xDirectTrans", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_XQuadSubtrans(), theDomainPackage.getReactance(), "xQuadSubtrans", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_XQuadSync(), theDomainPackage.getReactance(), "xQuadSync", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_XQuadTrans(), theDomainPackage.getReactance(), "xQuadTrans", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_OperatingMode(), theDomainPackage.getSynchronousMachineOperatingMode(), "operatingMode", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_Type(), theDomainPackage.getSynchronousMachineType(), "type", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronousMachine_CondenserMW(), theDomainPackage.getActivePower(), "condenserMW", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynchronousMachine_MVArCapabilityCurves(), this.getMVArCapabilityCurve(), this.getMVArCapabilityCurve_SynchronousMachines(), "MVArCapabilityCurves", null, 0, -1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynchronousMachine_Drives_HydroPump(), theProductionPackage.getHydroPump(), null, "Drives_HydroPump", null, 0, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynchronousMachine_GeneratingUnit(), theProductionPackage.getGeneratingUnit(), theProductionPackage.getGeneratingUnit_SynchronousMachines(), "GeneratingUnit", null, 1, 1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynchronousMachine_PrimeMover(), theGenerationdynamicsPackage.getPrimeMover(), theGenerationdynamicsPackage.getPrimeMover_SynchronousMachines(), "PrimeMover", null, 0, -1, SynchronousMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mvArCapabilityCurveEClass, MVArCapabilityCurve.class, "MVArCapabilityCurve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMVArCapabilityCurve_CoolantTemperature(), theDomainPackage.getTemperature(), "coolantTemperature", null, 0, 1, MVArCapabilityCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMVArCapabilityCurve_HydrogenPressure(), theDomainPackage.getPressure(), "hydrogenPressure", null, 0, 1, MVArCapabilityCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMVArCapabilityCurve_SynchronousMachines(), this.getSynchronousMachine(), this.getSynchronousMachine_MVArCapabilityCurves(), "SynchronousMachines", null, 1, -1, MVArCapabilityCurve.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equivalentSourceEClass, EquivalentSource.class, "EquivalentSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquivalentSource_Xn(), theDomainPackage.getReactance(), "xn", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_Rn(), theDomainPackage.getResistance(), "rn", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_NominalVoltage(), theDomainPackage.getVoltage(), "nominalVoltage", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_X(), theDomainPackage.getReactance(), "x", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_R(), theDomainPackage.getResistance(), "r", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_VoltageAngle(), theDomainPackage.getAngleRadians(), "voltageAngle", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_VoltageMagnitude(), theDomainPackage.getVoltage(), "voltageMagnitude", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_X0(), theDomainPackage.getReactance(), "x0", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_R0(), theDomainPackage.getResistance(), "r0", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentSource_ActivePower(), theDomainPackage.getActivePower(), "activePower", null, 0, 1, EquivalentSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wireTypeEClass, WireType.class, "WireType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWireType_PhaseConductorCount(), theDomainPackage.getCounter(), "phaseConductorCount", null, 0, 1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWireType_PhaseConductorSpacing(), theDomainPackage.getShortLength(), "phaseConductorSpacing", null, 0, 1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWireType_AmpRating(), theDomainPackage.getCurrentFlow(), "ampRating", null, 0, 1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWireType_GMR(), theDomainPackage.getShortLength(), "gMR", null, 0, 1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWireType_Radius(), theDomainPackage.getShortLength(), "radius", null, 0, 1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWireType_Resistance(), theDomainPackage.getResistance(), "resistance", null, 0, 1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWireType_WireArrangements(), this.getWireArrangement(), this.getWireArrangement_WireType(), "WireArrangements", null, 0, -1, WireType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wireArrangementEClass, WireArrangement.class, "WireArrangement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWireArrangement_MountingPointX(), ecorePackage.getEIntegerObject(), "mountingPointX", null, 0, 1, WireArrangement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWireArrangement_MountingPointY(), ecorePackage.getEIntegerObject(), "mountingPointY", null, 0, 1, WireArrangement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWireArrangement_ConductorType(), this.getConductorType(), this.getConductorType_WireArrangements(), "ConductorType", null, 0, 1, WireArrangement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWireArrangement_WireType(), this.getWireType(), this.getWireType_WireArrangements(), "WireType", null, 0, 1, WireArrangement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadBreakSwitchEClass, LoadBreakSwitch.class, "LoadBreakSwitch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadBreakSwitch_AmpRating(), theDomainPackage.getCurrentFlow(), "ampRating", null, 0, 1, LoadBreakSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(junctionEClass, Junction.class, "Junction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(energyConsumerEClass, EnergyConsumer.class, "EnergyConsumer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnergyConsumer_LoadDemandModels(), theLoadPackage.getLoadDemandModel(), theLoadPackage.getLoadDemandModel_EnergyConsumer(), "LoadDemandModels", null, 0, -1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnergyConsumer_NonConformLoadSchedules(), theLoadPackage.getNonConformLoadSchedule(), theLoadPackage.getNonConformLoadSchedule_EnergyConsumer(), "NonConformLoadSchedules", null, 0, -1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnergyConsumer_LoadArea(), theLoadPackage.getLoadArea(), theLoadPackage.getLoadArea_EnergyConsumers(), "LoadArea", null, 1, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnergyConsumer_PowerCutZone(), theLoadPackage.getPowerCutZone(), theLoadPackage.getPowerCutZone_EnergyConsumers(), "PowerCutZone", null, 1, 1, EnergyConsumer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_ConformingLoadFlag(), ecorePackage.getEBooleanObject(), "conformingLoadFlag", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_CustomerCount(), theDomainPackage.getCounter(), "customerCount", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_PFexp(), theDomainPackage.getExponent(), "pFexp", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_Pfixed(), theDomainPackage.getActivePower(), "pfixed", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_PfixedPct(), theDomainPackage.getPerCent(), "pfixedPct", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_Pnom(), theDomainPackage.getActivePower(), "pnom", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_PnomPct(), theDomainPackage.getPerCent(), "pnomPct", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_PowerFactor(), theDomainPackage.getPowerFactor(), "powerFactor", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_PVexp(), theDomainPackage.getExponent(), "pVexp", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_QFexp(), theDomainPackage.getExponent(), "qFexp", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_Qfixed(), theDomainPackage.getReactivePower(), "qfixed", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_QfixedPct(), theDomainPackage.getPerCent(), "qfixedPct", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_Qnom(), theDomainPackage.getReactivePower(), "qnom", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_QnomPct(), theDomainPackage.getPerCent(), "qnomPct", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnergyConsumer_QVexp(), theDomainPackage.getExponent(), "qVexp", null, 0, 1, EnergyConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorEClass, Connector.class, "Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regulatingCondEqEClass, RegulatingCondEq.class, "RegulatingCondEq", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegulatingCondEq_RegulationSchedule(), this.getRegulationSchedule(), this.getRegulationSchedule_RegulatingCondEqs(), "RegulationSchedule", null, 0, 1, RegulatingCondEq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groundDisconnectorEClass, GroundDisconnector.class, "GroundDisconnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeSwitchEClass, CompositeSwitch.class, "CompositeSwitch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeSwitch_CompositeSwitchType(), theDomainPackage.getCompositeSwitchType(), "compositeSwitchType", null, 0, 1, CompositeSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeSwitch_Switches(), this.getSwitch(), this.getSwitch_CompositeSwitch(), "Switches", null, 0, -1, CompositeSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wiresVersionEClass, WiresVersion.class, "WiresVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWiresVersion_Version(), ecorePackage.getEString(), "version", "Wires_v003", 0, 1, WiresVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWiresVersion_Date(), theDomainPackage.getDate(), "date", "2004-07-02", 0, 1, WiresVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(frequencyConverterEClass, FrequencyConverter.class, "FrequencyConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFrequencyConverter_Frequency(), theDomainPackage.getFrequency(), "frequency", null, 0, 1, FrequencyConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrequencyConverter_MaximumMW(), theDomainPackage.getActivePower(), "maximumMW", null, 0, 1, FrequencyConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrequencyConverter_MaximumKV(), theDomainPackage.getVoltage(), "maximumKV", null, 0, 1, FrequencyConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrequencyConverter_MinimumMW(), theDomainPackage.getActivePower(), "minimumMW", null, 0, 1, FrequencyConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrequencyConverter_MinimumKV(), theDomainPackage.getVoltage(), "minimumKV", null, 0, 1, FrequencyConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrequencyConverter_OperatingMode(), theDomainPackage.getOperatingMode(), "operatingMode", null, 0, 1, FrequencyConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //WirePackageImpl
