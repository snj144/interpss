/**
 * <copyright>
 * </copyright>
 *
 * $Id: CorePackageImpl.java,v 1.5 2007/03/07 16:03:48 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.Iec61970Package;

import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.ControlHouseEquipment;
import org.opencim.cim.iec61970.core.CoreFactory;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.CoreVersion;
import org.opencim.cim.iec61970.core.CurveSchedData;
import org.opencim.cim.iec61970.core.CurveSchedFormula;
import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PSRType;
import org.opencim.cim.iec61970.core.PowerSystemResource;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.core.Unit;
import org.opencim.cim.iec61970.core.VoltageLevel;

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

import org.opencim.cim.impl.cimPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass companyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conductingEquipmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlHouseEquipmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerSystemResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subControlAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass curveScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass curveSchedDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass curveSchedFormulaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseVoltageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basePowerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voltageLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipmentContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass psrTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreVersionEClass = null;

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
	 * @see org.opencim.cim.iec61970.core.CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorePackageImpl() {
		super(eNS_URI, CoreFactory.eINSTANCE);
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
	public static CorePackage init() {
		if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Obtain or create and register package
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CorePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		cimPackageImpl thecimPackage = (cimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) instanceof cimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI) : cimPackage.eINSTANCE);
		Iec61970PackageImpl theIec61970Package = (Iec61970PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) instanceof Iec61970PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Iec61970Package.eNS_URI) : Iec61970Package.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		LoadPackageImpl theLoadPackage = (LoadPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) instanceof LoadPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI) : LoadPackage.eINSTANCE);
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);
		WirePackageImpl theWirePackage = (WirePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) instanceof WirePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI) : WirePackage.eINSTANCE);
		GenPackageImpl theGenPackage = (GenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) instanceof GenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenPackage.eNS_URI) : GenPackage.eINSTANCE);
		ProductionPackageImpl theProductionPackage = (ProductionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) instanceof ProductionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI) : ProductionPackage.eINSTANCE);
		GenerationdynamicsPackageImpl theGenerationdynamicsPackage = (GenerationdynamicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) instanceof GenerationdynamicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenerationdynamicsPackage.eNS_URI) : GenerationdynamicsPackage.eINSTANCE);

		// Create package meta-data objects
		theCorePackage.createPackageContents();
		thecimPackage.createPackageContents();
		theIec61970Package.createPackageContents();
		theDomainPackage.createPackageContents();
		theLoadPackage.createPackageContents();
		theTopologyPackage.createPackageContents();
		theWirePackage.createPackageContents();
		theGenPackage.createPackageContents();
		theProductionPackage.createPackageContents();
		theGenerationdynamicsPackage.createPackageContents();

		// Initialize created meta-data
		theCorePackage.initializePackageContents();
		thecimPackage.initializePackageContents();
		theIec61970Package.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theLoadPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();
		theWirePackage.initializePackageContents();
		theGenPackage.initializePackageContents();
		theProductionPackage.initializePackageContents();
		theGenerationdynamicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorePackage.freeze();

		return theCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBay() {
		return bayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBay_BayEnergyMeasFlag() {
		return (EAttribute)bayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBay_BayPowerMeasFlag() {
		return (EAttribute)bayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBay_BreakerConfiguration() {
		return (EAttribute)bayEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBay_BusBarConfiguration() {
		return (EAttribute)bayEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBay_VoltageLevel() {
		return (EReference)bayEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBay_Substation() {
		return (EReference)bayEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompany() {
		return companyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompany_SimuModel() {
		return (EReference)companyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_CompanyType() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompany_PSRs() {
		return (EReference)companyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConductingEquipment() {
		return conductingEquipmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConductingEquipment_Phases() {
		return (EAttribute)conductingEquipmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConductingEquipment_Terminals() {
		return (EReference)conductingEquipmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConductingEquipment_BaseVoltage() {
		return (EReference)conductingEquipmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlHouseEquipment() {
		return controlHouseEquipmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControlHouseEquipment_ControlHouseEquipType() {
		return (EAttribute)controlHouseEquipmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPowerSystemResource() {
		return powerSystemResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerSystemResource_SimuModel() {
		return (EReference)powerSystemResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerSystemResource_Companies() {
		return (EReference)powerSystemResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerSystemResource_PSRType() {
		return (EReference)powerSystemResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstation() {
		return substationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubstation_SubControlArea() {
		return (EReference)substationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubstation_LoadArea() {
		return (EReference)substationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubstation_VoltageLevels() {
		return (EReference)substationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubstation_Bays() {
		return (EReference)substationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubstation_Contains_CompositeSwitches() {
		return (EReference)substationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminal() {
		return terminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminal_ConductingEquipment() {
		return (EReference)terminalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminal_ConnectivityNode() {
		return (EReference)terminalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubControlArea() {
		return subControlAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubControlArea_Substations() {
		return (EReference)subControlAreaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubControlArea_GeneratingUnits() {
		return (EReference)subControlAreaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurveSchedule() {
		return curveScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_CurveStyle() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_RampMethod() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_RampStartMethod() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_RampUnits() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_XAxisType() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_XAxisQuantity() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_Y1AxisQuantity() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_Y2AxisQuantity() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedule_YAxisType() {
		return (EAttribute)curveScheduleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurveSchedule_CurveScheduleDatas() {
		return (EReference)curveScheduleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurveSchedule_CurveScheduleFormula() {
		return (EReference)curveScheduleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurveSchedData() {
		return curveSchedDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedData_RampData() {
		return (EAttribute)curveSchedDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedData_RampDataValue() {
		return (EAttribute)curveSchedDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedData_XAxisData() {
		return (EAttribute)curveSchedDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedData_Y1AxisData() {
		return (EAttribute)curveSchedDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedData_Y2AxisData() {
		return (EAttribute)curveSchedDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurveSchedData_CurveSchedule() {
		return (EReference)curveSchedDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurveSchedFormula() {
		return curveSchedFormulaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedFormula_XLowerBound() {
		return (EAttribute)curveSchedFormulaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedFormula_XUpperBound() {
		return (EAttribute)curveSchedFormulaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurveSchedFormula_YFunction() {
		return (EAttribute)curveSchedFormulaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurveSchedFormula_CurveSchedule() {
		return (EReference)curveSchedFormulaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseVoltage() {
		return baseVoltageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseVoltage_NominalVoltage() {
		return (EAttribute)baseVoltageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseVoltage_BasePower() {
		return (EReference)baseVoltageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseVoltage_ConductingEquipment() {
		return (EReference)baseVoltageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseVoltage_VoltageLevel() {
		return (EReference)baseVoltageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasePower() {
		return basePowerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasePower_BasePower() {
		return (EAttribute)basePowerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasePower_BaseVoltages() {
		return (EReference)basePowerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoltageLevel() {
		return voltageLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVoltageLevel_HighVoltageLimit() {
		return (EAttribute)voltageLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVoltageLevel_LowVoltageLimit() {
		return (EAttribute)voltageLevelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVoltageLevel_Substation() {
		return (EReference)voltageLevelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVoltageLevel_Bays() {
		return (EReference)voltageLevelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVoltageLevel_BaseVoltage() {
		return (EReference)voltageLevelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNaming() {
		return namingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNaming_AliasName() {
		return (EAttribute)namingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNaming_Description() {
		return (EAttribute)namingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNaming_Name() {
		return (EAttribute)namingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNaming_PathName() {
		return (EAttribute)namingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNaming_MRID() {
		return (EAttribute)namingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquipment() {
		return equipmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipment_EquipmentContainer() {
		return (EReference)equipmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnit() {
		return unitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquipmentContainer() {
		return equipmentContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentContainer_ConnectivityNodes() {
		return (EReference)equipmentContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentContainer_Equipments() {
		return (EReference)equipmentContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPSRType() {
		return psrTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPSRType_PowerSystemResource() {
		return (EReference)psrTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreVersion() {
		return coreVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreVersion_Version() {
		return (EAttribute)coreVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreVersion_Date() {
		return (EAttribute)coreVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactory getCoreFactory() {
		return (CoreFactory)getEFactoryInstance();
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
		bayEClass = createEClass(BAY);
		createEAttribute(bayEClass, BAY__BAY_ENERGY_MEAS_FLAG);
		createEAttribute(bayEClass, BAY__BAY_POWER_MEAS_FLAG);
		createEAttribute(bayEClass, BAY__BREAKER_CONFIGURATION);
		createEAttribute(bayEClass, BAY__BUS_BAR_CONFIGURATION);
		createEReference(bayEClass, BAY__VOLTAGE_LEVEL);
		createEReference(bayEClass, BAY__SUBSTATION);

		conductingEquipmentEClass = createEClass(CONDUCTING_EQUIPMENT);
		createEAttribute(conductingEquipmentEClass, CONDUCTING_EQUIPMENT__PHASES);
		createEReference(conductingEquipmentEClass, CONDUCTING_EQUIPMENT__TERMINALS);
		createEReference(conductingEquipmentEClass, CONDUCTING_EQUIPMENT__BASE_VOLTAGE);

		controlHouseEquipmentEClass = createEClass(CONTROL_HOUSE_EQUIPMENT);
		createEAttribute(controlHouseEquipmentEClass, CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE);

		powerSystemResourceEClass = createEClass(POWER_SYSTEM_RESOURCE);
		createEReference(powerSystemResourceEClass, POWER_SYSTEM_RESOURCE__SIMU_MODEL);
		createEReference(powerSystemResourceEClass, POWER_SYSTEM_RESOURCE__COMPANIES);
		createEReference(powerSystemResourceEClass, POWER_SYSTEM_RESOURCE__PSR_TYPE);

		substationEClass = createEClass(SUBSTATION);
		createEReference(substationEClass, SUBSTATION__SUB_CONTROL_AREA);
		createEReference(substationEClass, SUBSTATION__LOAD_AREA);
		createEReference(substationEClass, SUBSTATION__VOLTAGE_LEVELS);
		createEReference(substationEClass, SUBSTATION__BAYS);
		createEReference(substationEClass, SUBSTATION__CONTAINS_COMPOSITE_SWITCHES);

		terminalEClass = createEClass(TERMINAL);
		createEReference(terminalEClass, TERMINAL__CONDUCTING_EQUIPMENT);
		createEReference(terminalEClass, TERMINAL__CONNECTIVITY_NODE);

		subControlAreaEClass = createEClass(SUB_CONTROL_AREA);
		createEReference(subControlAreaEClass, SUB_CONTROL_AREA__SUBSTATIONS);
		createEReference(subControlAreaEClass, SUB_CONTROL_AREA__GENERATING_UNITS);

		curveScheduleEClass = createEClass(CURVE_SCHEDULE);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__CURVE_STYLE);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__RAMP_METHOD);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__RAMP_START_METHOD);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__RAMP_UNITS);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__XAXIS_TYPE);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__XAXIS_QUANTITY);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__Y1_AXIS_QUANTITY);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__Y2_AXIS_QUANTITY);
		createEAttribute(curveScheduleEClass, CURVE_SCHEDULE__YAXIS_TYPE);
		createEReference(curveScheduleEClass, CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS);
		createEReference(curveScheduleEClass, CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA);

		curveSchedDataEClass = createEClass(CURVE_SCHED_DATA);
		createEAttribute(curveSchedDataEClass, CURVE_SCHED_DATA__RAMP_DATA);
		createEAttribute(curveSchedDataEClass, CURVE_SCHED_DATA__RAMP_DATA_VALUE);
		createEAttribute(curveSchedDataEClass, CURVE_SCHED_DATA__XAXIS_DATA);
		createEAttribute(curveSchedDataEClass, CURVE_SCHED_DATA__Y1_AXIS_DATA);
		createEAttribute(curveSchedDataEClass, CURVE_SCHED_DATA__Y2_AXIS_DATA);
		createEReference(curveSchedDataEClass, CURVE_SCHED_DATA__CURVE_SCHEDULE);

		curveSchedFormulaEClass = createEClass(CURVE_SCHED_FORMULA);
		createEAttribute(curveSchedFormulaEClass, CURVE_SCHED_FORMULA__XLOWER_BOUND);
		createEAttribute(curveSchedFormulaEClass, CURVE_SCHED_FORMULA__XUPPER_BOUND);
		createEAttribute(curveSchedFormulaEClass, CURVE_SCHED_FORMULA__YFUNCTION);
		createEReference(curveSchedFormulaEClass, CURVE_SCHED_FORMULA__CURVE_SCHEDULE);

		baseVoltageEClass = createEClass(BASE_VOLTAGE);
		createEAttribute(baseVoltageEClass, BASE_VOLTAGE__NOMINAL_VOLTAGE);
		createEReference(baseVoltageEClass, BASE_VOLTAGE__BASE_POWER);
		createEReference(baseVoltageEClass, BASE_VOLTAGE__CONDUCTING_EQUIPMENT);
		createEReference(baseVoltageEClass, BASE_VOLTAGE__VOLTAGE_LEVEL);

		basePowerEClass = createEClass(BASE_POWER);
		createEAttribute(basePowerEClass, BASE_POWER__BASE_POWER);
		createEReference(basePowerEClass, BASE_POWER__BASE_VOLTAGES);

		voltageLevelEClass = createEClass(VOLTAGE_LEVEL);
		createEAttribute(voltageLevelEClass, VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT);
		createEAttribute(voltageLevelEClass, VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT);
		createEReference(voltageLevelEClass, VOLTAGE_LEVEL__SUBSTATION);
		createEReference(voltageLevelEClass, VOLTAGE_LEVEL__BAYS);
		createEReference(voltageLevelEClass, VOLTAGE_LEVEL__BASE_VOLTAGE);

		namingEClass = createEClass(NAMING);
		createEAttribute(namingEClass, NAMING__ALIAS_NAME);
		createEAttribute(namingEClass, NAMING__DESCRIPTION);
		createEAttribute(namingEClass, NAMING__NAME);
		createEAttribute(namingEClass, NAMING__PATH_NAME);
		createEAttribute(namingEClass, NAMING__MRID);

		equipmentEClass = createEClass(EQUIPMENT);
		createEReference(equipmentEClass, EQUIPMENT__EQUIPMENT_CONTAINER);

		unitEClass = createEClass(UNIT);

		equipmentContainerEClass = createEClass(EQUIPMENT_CONTAINER);
		createEReference(equipmentContainerEClass, EQUIPMENT_CONTAINER__CONNECTIVITY_NODES);
		createEReference(equipmentContainerEClass, EQUIPMENT_CONTAINER__EQUIPMENTS);

		psrTypeEClass = createEClass(PSR_TYPE);
		createEReference(psrTypeEClass, PSR_TYPE__POWER_SYSTEM_RESOURCE);

		coreVersionEClass = createEClass(CORE_VERSION);
		createEAttribute(coreVersionEClass, CORE_VERSION__VERSION);
		createEAttribute(coreVersionEClass, CORE_VERSION__DATE);

		companyEClass = createEClass(COMPANY);
		createEReference(companyEClass, COMPANY__SIMU_MODEL);
		createEAttribute(companyEClass, COMPANY__COMPANY_TYPE);
		createEReference(companyEClass, COMPANY__PS_RS);
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
		cimPackage thecimPackage = (cimPackage)EPackage.Registry.INSTANCE.getEPackage(cimPackage.eNS_URI);
		LoadPackage theLoadPackage = (LoadPackage)EPackage.Registry.INSTANCE.getEPackage(LoadPackage.eNS_URI);
		WirePackage theWirePackage = (WirePackage)EPackage.Registry.INSTANCE.getEPackage(WirePackage.eNS_URI);
		TopologyPackage theTopologyPackage = (TopologyPackage)EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI);
		ProductionPackage theProductionPackage = (ProductionPackage)EPackage.Registry.INSTANCE.getEPackage(ProductionPackage.eNS_URI);

		// Add supertypes to classes
		bayEClass.getESuperTypes().add(this.getEquipmentContainer());
		conductingEquipmentEClass.getESuperTypes().add(this.getEquipment());
		controlHouseEquipmentEClass.getESuperTypes().add(this.getPowerSystemResource());
		powerSystemResourceEClass.getESuperTypes().add(this.getNaming());
		substationEClass.getESuperTypes().add(this.getEquipmentContainer());
		terminalEClass.getESuperTypes().add(this.getNaming());
		subControlAreaEClass.getESuperTypes().add(this.getPowerSystemResource());
		curveScheduleEClass.getESuperTypes().add(this.getNaming());
		curveSchedDataEClass.getESuperTypes().add(this.getNaming());
		curveSchedFormulaEClass.getESuperTypes().add(this.getNaming());
		baseVoltageEClass.getESuperTypes().add(this.getNaming());
		basePowerEClass.getESuperTypes().add(this.getNaming());
		voltageLevelEClass.getESuperTypes().add(this.getEquipmentContainer());
		equipmentEClass.getESuperTypes().add(this.getPowerSystemResource());
		unitEClass.getESuperTypes().add(this.getNaming());
		equipmentContainerEClass.getESuperTypes().add(this.getPowerSystemResource());
		psrTypeEClass.getESuperTypes().add(this.getNaming());
		companyEClass.getESuperTypes().add(this.getNaming());

		// Initialize classes and features; add operations and parameters
		initEClass(bayEClass, Bay.class, "Bay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBay_BayEnergyMeasFlag(), ecorePackage.getEBooleanObject(), "bayEnergyMeasFlag", null, 0, 1, Bay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBay_BayPowerMeasFlag(), ecorePackage.getEBooleanObject(), "bayPowerMeasFlag", null, 0, 1, Bay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBay_BreakerConfiguration(), theDomainPackage.getBreakerConfiguration(), "breakerConfiguration", null, 0, 1, Bay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBay_BusBarConfiguration(), theDomainPackage.getBusbarConfiguration(), "busBarConfiguration", null, 0, 1, Bay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBay_VoltageLevel(), this.getVoltageLevel(), this.getVoltageLevel_Bays(), "VoltageLevel", null, 1, 1, Bay.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBay_Substation(), this.getSubstation(), this.getSubstation_Bays(), "Substation", null, 1, 1, Bay.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conductingEquipmentEClass, ConductingEquipment.class, "ConductingEquipment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConductingEquipment_Phases(), theDomainPackage.getPhaseCode(), "phases", null, 0, 1, ConductingEquipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConductingEquipment_Terminals(), this.getTerminal(), this.getTerminal_ConductingEquipment(), "Terminals", null, 0, -1, ConductingEquipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConductingEquipment_BaseVoltage(), this.getBaseVoltage(), this.getBaseVoltage_ConductingEquipment(), "BaseVoltage", null, 1, 1, ConductingEquipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlHouseEquipmentEClass, ControlHouseEquipment.class, "ControlHouseEquipment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getControlHouseEquipment_ControlHouseEquipType(), theDomainPackage.getControlHouseEquipmentType(), "controlHouseEquipType", null, 0, 1, ControlHouseEquipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerSystemResourceEClass, PowerSystemResource.class, "PowerSystemResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerSystemResource_SimuModel(), thecimPackage.getSimulationModel(), thecimPackage.getSimulationModel_PsResources(), "simuModel", null, 1, 1, PowerSystemResource.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerSystemResource_Companies(), this.getCompany(), this.getCompany_PSRs(), "Companies", null, 0, -1, PowerSystemResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerSystemResource_PSRType(), this.getPSRType(), this.getPSRType_PowerSystemResource(), "PSRType", null, 0, 1, PowerSystemResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(substationEClass, Substation.class, "Substation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubstation_SubControlArea(), this.getSubControlArea(), this.getSubControlArea_Substations(), "SubControlArea", null, 1, 1, Substation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubstation_LoadArea(), theLoadPackage.getLoadArea(), theLoadPackage.getLoadArea_Substations(), "LoadArea", null, 1, 1, Substation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubstation_VoltageLevels(), this.getVoltageLevel(), this.getVoltageLevel_Substation(), "VoltageLevels", null, 0, -1, Substation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubstation_Bays(), this.getBay(), this.getBay_Substation(), "Bays", null, 0, -1, Substation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubstation_Contains_CompositeSwitches(), theWirePackage.getCompositeSwitch(), null, "Contains_CompositeSwitches", null, 0, -1, Substation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminalEClass, Terminal.class, "Terminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminal_ConductingEquipment(), this.getConductingEquipment(), this.getConductingEquipment_Terminals(), "ConductingEquipment", null, 1, 1, Terminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminal_ConnectivityNode(), theTopologyPackage.getConnectivityNode(), theTopologyPackage.getConnectivityNode_Terminals(), "ConnectivityNode", null, 1, 1, Terminal.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subControlAreaEClass, SubControlArea.class, "SubControlArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubControlArea_Substations(), this.getSubstation(), this.getSubstation_SubControlArea(), "Substations", null, 1, -1, SubControlArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubControlArea_GeneratingUnits(), theProductionPackage.getGeneratingUnit(), theProductionPackage.getGeneratingUnit_SubControlArea(), "GeneratingUnits", null, 0, -1, SubControlArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(curveScheduleEClass, CurveSchedule.class, "CurveSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCurveSchedule_CurveStyle(), theDomainPackage.getCurveStyle(), "curveStyle", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_RampMethod(), theDomainPackage.getRampMethod(), "rampMethod", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_RampStartMethod(), theDomainPackage.getRampStartMethod(), "rampStartMethod", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_RampUnits(), theDomainPackage.getRampUnits(), "rampUnits", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_XAxisType(), theDomainPackage.getNumericType(), "xAxisType", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_XAxisQuantity(), theDomainPackage.getAxisQuantity(), "xAxisQuantity", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_Y1AxisQuantity(), theDomainPackage.getAxisQuantity(), "y1AxisQuantity", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_Y2AxisQuantity(), theDomainPackage.getAxisQuantity(), "y2AxisQuantity", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedule_YAxisType(), theDomainPackage.getNumericType(), "yAxisType", null, 0, 1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCurveSchedule_CurveScheduleDatas(), this.getCurveSchedData(), this.getCurveSchedData_CurveSchedule(), "CurveScheduleDatas", null, 0, -1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCurveSchedule_CurveScheduleFormula(), this.getCurveSchedFormula(), this.getCurveSchedFormula_CurveSchedule(), "CurveScheduleFormula", null, 0, -1, CurveSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(curveSchedDataEClass, CurveSchedData.class, "CurveSchedData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCurveSchedData_RampData(), theDomainPackage.getNumeric(), "rampData", null, 0, 1, CurveSchedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedData_RampDataValue(), theDomainPackage.getNumeric(), "rampDataValue", null, 0, 1, CurveSchedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedData_XAxisData(), theDomainPackage.getNumeric(), "xAxisData", null, 0, 1, CurveSchedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedData_Y1AxisData(), theDomainPackage.getNumeric(), "y1AxisData", null, 0, 1, CurveSchedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedData_Y2AxisData(), theDomainPackage.getNumeric(), "y2AxisData", null, 0, 1, CurveSchedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCurveSchedData_CurveSchedule(), this.getCurveSchedule(), this.getCurveSchedule_CurveScheduleDatas(), "CurveSchedule", null, 1, 1, CurveSchedData.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(curveSchedFormulaEClass, CurveSchedFormula.class, "CurveSchedFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCurveSchedFormula_XLowerBound(), theDomainPackage.getNumeric(), "xLowerBound", null, 0, 1, CurveSchedFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedFormula_XUpperBound(), theDomainPackage.getNumeric(), "xUpperBound", null, 0, 1, CurveSchedFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCurveSchedFormula_YFunction(), ecorePackage.getEString(), "yFunction", null, 0, 1, CurveSchedFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCurveSchedFormula_CurveSchedule(), this.getCurveSchedule(), this.getCurveSchedule_CurveScheduleFormula(), "CurveSchedule", null, 1, 1, CurveSchedFormula.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(baseVoltageEClass, BaseVoltage.class, "BaseVoltage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseVoltage_NominalVoltage(), theDomainPackage.getVoltage(), "nominalVoltage", null, 0, 1, BaseVoltage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseVoltage_BasePower(), this.getBasePower(), this.getBasePower_BaseVoltages(), "BasePower", null, 1, 1, BaseVoltage.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseVoltage_ConductingEquipment(), this.getConductingEquipment(), this.getConductingEquipment_BaseVoltage(), "ConductingEquipment", null, 0, -1, BaseVoltage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseVoltage_VoltageLevel(), this.getVoltageLevel(), this.getVoltageLevel_BaseVoltage(), "VoltageLevel", null, 0, -1, BaseVoltage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basePowerEClass, BasePower.class, "BasePower", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasePower_BasePower(), theDomainPackage.getApparentPower(), "basePower", null, 0, 1, BasePower.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasePower_BaseVoltages(), this.getBaseVoltage(), this.getBaseVoltage_BasePower(), "BaseVoltages", null, 0, -1, BasePower.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(voltageLevelEClass, VoltageLevel.class, "VoltageLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVoltageLevel_HighVoltageLimit(), theDomainPackage.getVoltage(), "highVoltageLimit", null, 0, 1, VoltageLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVoltageLevel_LowVoltageLimit(), theDomainPackage.getVoltage(), "lowVoltageLimit", null, 0, 1, VoltageLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVoltageLevel_Substation(), this.getSubstation(), this.getSubstation_VoltageLevels(), "Substation", null, 1, 1, VoltageLevel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVoltageLevel_Bays(), this.getBay(), this.getBay_VoltageLevel(), "Bays", null, 0, -1, VoltageLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVoltageLevel_BaseVoltage(), this.getBaseVoltage(), this.getBaseVoltage_VoltageLevel(), "BaseVoltage", null, 1, 1, VoltageLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namingEClass, Naming.class, "Naming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNaming_AliasName(), ecorePackage.getEString(), "aliasName", null, 0, 1, Naming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNaming_Description(), ecorePackage.getEString(), "description", null, 0, 1, Naming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNaming_Name(), ecorePackage.getEString(), "name", null, 0, 1, Naming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNaming_PathName(), ecorePackage.getEString(), "pathName", null, 0, 1, Naming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNaming_MRID(), ecorePackage.getEString(), "mRID", null, 0, 1, Naming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equipmentEClass, Equipment.class, "Equipment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquipment_EquipmentContainer(), this.getEquipmentContainer(), this.getEquipmentContainer_Equipments(), "EquipmentContainer", null, 1, 1, Equipment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equipmentContainerEClass, EquipmentContainer.class, "EquipmentContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquipmentContainer_ConnectivityNodes(), theTopologyPackage.getConnectivityNode(), theTopologyPackage.getConnectivityNode_EquipmentContainer(), "ConnectivityNodes", null, 0, -1, EquipmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentContainer_Equipments(), this.getEquipment(), this.getEquipment_EquipmentContainer(), "Equipments", null, 0, -1, EquipmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(psrTypeEClass, PSRType.class, "PSRType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPSRType_PowerSystemResource(), this.getPowerSystemResource(), this.getPowerSystemResource_PSRType(), "PowerSystemResource", null, 0, -1, PSRType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreVersionEClass, CoreVersion.class, "CoreVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoreVersion_Version(), ecorePackage.getEString(), "version", "Core_v003", 0, 1, CoreVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreVersion_Date(), theDomainPackage.getDate(), "date", "2004-07-02", 0, 1, CoreVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(companyEClass, Company.class, "Company", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompany_SimuModel(), thecimPackage.getSimulationModel(), thecimPackage.getSimulationModel_Companies(), "simuModel", null, 1, 1, Company.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_CompanyType(), theDomainPackage.getCompanyType(), "companyType", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompany_PSRs(), this.getPowerSystemResource(), this.getPowerSystemResource_Companies(), "PSRs", null, 0, -1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CorePackageImpl
