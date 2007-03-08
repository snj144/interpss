/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoreFactoryImpl.java,v 1.2 2007/03/07 16:03:48 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.core.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreFactoryImpl extends EFactoryImpl implements CoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoreFactory init() {
		try {
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory("org.opencim.cim.iec61970.core "); 
			if (theCoreFactory != null) {
				return theCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CorePackage.BAY: return createBay();
			case CorePackage.CONDUCTING_EQUIPMENT: return createConductingEquipment();
			case CorePackage.CONTROL_HOUSE_EQUIPMENT: return createControlHouseEquipment();
			case CorePackage.POWER_SYSTEM_RESOURCE: return createPowerSystemResource();
			case CorePackage.SUBSTATION: return createSubstation();
			case CorePackage.TERMINAL: return createTerminal();
			case CorePackage.SUB_CONTROL_AREA: return createSubControlArea();
			case CorePackage.CURVE_SCHEDULE: return createCurveSchedule();
			case CorePackage.CURVE_SCHED_DATA: return createCurveSchedData();
			case CorePackage.CURVE_SCHED_FORMULA: return createCurveSchedFormula();
			case CorePackage.BASE_VOLTAGE: return createBaseVoltage();
			case CorePackage.BASE_POWER: return createBasePower();
			case CorePackage.VOLTAGE_LEVEL: return createVoltageLevel();
			case CorePackage.NAMING: return createNaming();
			case CorePackage.EQUIPMENT: return createEquipment();
			case CorePackage.UNIT: return createUnit();
			case CorePackage.EQUIPMENT_CONTAINER: return createEquipmentContainer();
			case CorePackage.PSR_TYPE: return createPSRType();
			case CorePackage.CORE_VERSION: return createCoreVersion();
			case CorePackage.COMPANY: return createCompany();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bay createBay() {
		BayImpl bay = new BayImpl();
		return bay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Company createCompany() {
		CompanyImpl company = new CompanyImpl();
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConductingEquipment createConductingEquipment() {
		ConductingEquipmentImpl conductingEquipment = new ConductingEquipmentImpl();
		return conductingEquipment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlHouseEquipment createControlHouseEquipment() {
		ControlHouseEquipmentImpl controlHouseEquipment = new ControlHouseEquipmentImpl();
		return controlHouseEquipment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerSystemResource createPowerSystemResource() {
		PowerSystemResourceImpl powerSystemResource = new PowerSystemResourceImpl();
		return powerSystemResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Substation createSubstation() {
		SubstationImpl substation = new SubstationImpl();
		return substation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Terminal createTerminal() {
		TerminalImpl terminal = new TerminalImpl();
		return terminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubControlArea createSubControlArea() {
		SubControlAreaImpl subControlArea = new SubControlAreaImpl();
		return subControlArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveSchedule createCurveSchedule() {
		CurveScheduleImpl curveSchedule = new CurveScheduleImpl();
		return curveSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveSchedData createCurveSchedData() {
		CurveSchedDataImpl curveSchedData = new CurveSchedDataImpl();
		return curveSchedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveSchedFormula createCurveSchedFormula() {
		CurveSchedFormulaImpl curveSchedFormula = new CurveSchedFormulaImpl();
		return curveSchedFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseVoltage createBaseVoltage() {
		BaseVoltageImpl baseVoltage = new BaseVoltageImpl();
		return baseVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasePower createBasePower() {
		BasePowerImpl basePower = new BasePowerImpl();
		return basePower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoltageLevel createVoltageLevel() {
		VoltageLevelImpl voltageLevel = new VoltageLevelImpl();
		return voltageLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Naming createNaming() {
		NamingImpl naming = new NamingImpl();
		return naming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment createEquipment() {
		EquipmentImpl equipment = new EquipmentImpl();
		return equipment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentContainer createEquipmentContainer() {
		EquipmentContainerImpl equipmentContainer = new EquipmentContainerImpl();
		return equipmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSRType createPSRType() {
		PSRTypeImpl psrType = new PSRTypeImpl();
		return psrType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreVersion createCoreVersion() {
		CoreVersionImpl coreVersion = new CoreVersionImpl();
		return coreVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorePackage getCorePackage() {
		return (CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static CorePackage getPackage() {
		return CorePackage.eINSTANCE;
	}

} //CoreFactoryImpl
