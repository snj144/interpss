/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProductionPackage.java,v 1.5 2007/03/07 16:03:48 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.opencim.cim.iec61970.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.gen.production.ProductionFactory
 * @generated
 */
public interface ProductionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "production";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///cim/production.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cim.production";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProductionPackage eINSTANCE = org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl <em>Generating Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGeneratingUnit()
	 * @generated
	 */
	int GENERATING_UNIT = 24;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__ALIAS_NAME = CorePackage.EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__DESCRIPTION = CorePackage.EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__NAME = CorePackage.EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__PATH_NAME = CorePackage.EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MRID = CorePackage.EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__SIMU_MODEL = CorePackage.EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__COMPANIES = CorePackage.EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__PSR_TYPE = CorePackage.EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__EQUIPMENT_CONTAINER = CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Control Deadband</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__CONTROL_DEADBAND = CorePackage.EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Control Pulse High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__CONTROL_PULSE_HIGH = CorePackage.EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Control Pulse Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__CONTROL_PULSE_LOW = CorePackage.EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Control Response Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__CONTROL_RESPONSE_RATE = CorePackage.EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Efficiency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__EFFICIENCY = CorePackage.EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Gen Control Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GEN_CONTROL_MODE = CorePackage.EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Gen Control Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GEN_CONTROL_SOURCE = CorePackage.EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Governor MPL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GOVERNOR_MPL = CorePackage.EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Governor SCD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GOVERNOR_SCD = CorePackage.EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>High Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__HIGH_CONTROL_LIMIT = CorePackage.EQUIPMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Initial MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__INITIAL_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Low Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__LOW_CONTROL_LIMIT = CorePackage.EQUIPMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Maximum Allowable Spinning Reserve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE = CorePackage.EQUIPMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Maximum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MAXIMUM_ECONOMIC_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Maximum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MAXIMUM_OPERATING_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Minimum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MINIMUM_ECONOMIC_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Minimum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MINIMUM_OPERATING_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Model Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MODEL_DETAIL = CorePackage.EQUIPMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Rated Gross Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__RATED_GROSS_MAX_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Rated Gross Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__RATED_GROSS_MIN_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Rated Net Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__RATED_NET_MAX_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Startup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__STARTUP_TIME = CorePackage.EQUIPMENT_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Auto Cntrl Margin MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Alloc Spin Res MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__ALLOC_SPIN_RES_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Base MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__BASE_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Disp Reserve Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__DISP_RESERVE_FLAG = CorePackage.EQUIPMENT_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Energy Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__ENERGY_MIN_MW = CorePackage.EQUIPMENT_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Fast Start Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__FAST_START_FLAG = CorePackage.EQUIPMENT_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Fuel Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__FUEL_PRIORITY = CorePackage.EQUIPMENT_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Gen Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GEN_OPERATING_MODE = CorePackage.EQUIPMENT_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Long PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__LONG_PF = CorePackage.EQUIPMENT_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Lower Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__LOWER_RAMP_RATE = CorePackage.EQUIPMENT_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Normal PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__NORMAL_PF = CorePackage.EQUIPMENT_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Penalty Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__PENALTY_FACTOR = CorePackage.EQUIPMENT_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Raise Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__RAISE_RAMP_RATE = CorePackage.EQUIPMENT_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Short PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__SHORT_PF = CorePackage.EQUIPMENT_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Spin Reserve Ramp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__SPIN_RESERVE_RAMP = CorePackage.EQUIPMENT_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Step Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__STEP_CHANGE = CorePackage.EQUIPMENT_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Tie Line PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__TIE_LINE_PF = CorePackage.EQUIPMENT_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Minimum Off Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__MINIMUM_OFF_TIME = CorePackage.EQUIPMENT_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Gen Unit Op Cost Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES = CorePackage.EQUIPMENT_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Gen Unit Op Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE = CorePackage.EQUIPMENT_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>Gross To Net MW Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__GROSS_TO_NET_MW_CURVES = CorePackage.EQUIPMENT_FEATURE_COUNT + 42;

	/**
	 * The feature id for the '<em><b>Sub Control Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__SUB_CONTROL_AREA = CorePackage.EQUIPMENT_FEATURE_COUNT + 43;

	/**
	 * The feature id for the '<em><b>Synchronous Machines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT__SYNCHRONOUS_MACHINES = CorePackage.EQUIPMENT_FEATURE_COUNT + 44;

	/**
	 * The number of structural features of the '<em>Generating Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATING_UNIT_FEATURE_COUNT = CorePackage.EQUIPMENT_FEATURE_COUNT + 45;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl <em>Thermal Generating Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getThermalGeneratingUnit()
	 * @generated
	 */
	int THERMAL_GENERATING_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__ALIAS_NAME = GENERATING_UNIT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__DESCRIPTION = GENERATING_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__NAME = GENERATING_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__PATH_NAME = GENERATING_UNIT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MRID = GENERATING_UNIT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__SIMU_MODEL = GENERATING_UNIT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__COMPANIES = GENERATING_UNIT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__PSR_TYPE = GENERATING_UNIT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__EQUIPMENT_CONTAINER = GENERATING_UNIT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Control Deadband</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__CONTROL_DEADBAND = GENERATING_UNIT__CONTROL_DEADBAND;

	/**
	 * The feature id for the '<em><b>Control Pulse High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__CONTROL_PULSE_HIGH = GENERATING_UNIT__CONTROL_PULSE_HIGH;

	/**
	 * The feature id for the '<em><b>Control Pulse Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__CONTROL_PULSE_LOW = GENERATING_UNIT__CONTROL_PULSE_LOW;

	/**
	 * The feature id for the '<em><b>Control Response Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__CONTROL_RESPONSE_RATE = GENERATING_UNIT__CONTROL_RESPONSE_RATE;

	/**
	 * The feature id for the '<em><b>Efficiency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__EFFICIENCY = GENERATING_UNIT__EFFICIENCY;

	/**
	 * The feature id for the '<em><b>Gen Control Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GEN_CONTROL_MODE = GENERATING_UNIT__GEN_CONTROL_MODE;

	/**
	 * The feature id for the '<em><b>Gen Control Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GEN_CONTROL_SOURCE = GENERATING_UNIT__GEN_CONTROL_SOURCE;

	/**
	 * The feature id for the '<em><b>Governor MPL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GOVERNOR_MPL = GENERATING_UNIT__GOVERNOR_MPL;

	/**
	 * The feature id for the '<em><b>Governor SCD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GOVERNOR_SCD = GENERATING_UNIT__GOVERNOR_SCD;

	/**
	 * The feature id for the '<em><b>High Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__HIGH_CONTROL_LIMIT = GENERATING_UNIT__HIGH_CONTROL_LIMIT;

	/**
	 * The feature id for the '<em><b>Initial MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__INITIAL_MW = GENERATING_UNIT__INITIAL_MW;

	/**
	 * The feature id for the '<em><b>Low Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__LOW_CONTROL_LIMIT = GENERATING_UNIT__LOW_CONTROL_LIMIT;

	/**
	 * The feature id for the '<em><b>Maximum Allowable Spinning Reserve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE = GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE;

	/**
	 * The feature id for the '<em><b>Maximum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MAXIMUM_ECONOMIC_MW = GENERATING_UNIT__MAXIMUM_ECONOMIC_MW;

	/**
	 * The feature id for the '<em><b>Maximum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MAXIMUM_OPERATING_MW = GENERATING_UNIT__MAXIMUM_OPERATING_MW;

	/**
	 * The feature id for the '<em><b>Minimum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MINIMUM_ECONOMIC_MW = GENERATING_UNIT__MINIMUM_ECONOMIC_MW;

	/**
	 * The feature id for the '<em><b>Minimum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MINIMUM_OPERATING_MW = GENERATING_UNIT__MINIMUM_OPERATING_MW;

	/**
	 * The feature id for the '<em><b>Model Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MODEL_DETAIL = GENERATING_UNIT__MODEL_DETAIL;

	/**
	 * The feature id for the '<em><b>Rated Gross Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__RATED_GROSS_MAX_MW = GENERATING_UNIT__RATED_GROSS_MAX_MW;

	/**
	 * The feature id for the '<em><b>Rated Gross Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__RATED_GROSS_MIN_MW = GENERATING_UNIT__RATED_GROSS_MIN_MW;

	/**
	 * The feature id for the '<em><b>Rated Net Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__RATED_NET_MAX_MW = GENERATING_UNIT__RATED_NET_MAX_MW;

	/**
	 * The feature id for the '<em><b>Startup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__STARTUP_TIME = GENERATING_UNIT__STARTUP_TIME;

	/**
	 * The feature id for the '<em><b>Auto Cntrl Margin MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW = GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW;

	/**
	 * The feature id for the '<em><b>Alloc Spin Res MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__ALLOC_SPIN_RES_MW = GENERATING_UNIT__ALLOC_SPIN_RES_MW;

	/**
	 * The feature id for the '<em><b>Base MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__BASE_MW = GENERATING_UNIT__BASE_MW;

	/**
	 * The feature id for the '<em><b>Disp Reserve Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__DISP_RESERVE_FLAG = GENERATING_UNIT__DISP_RESERVE_FLAG;

	/**
	 * The feature id for the '<em><b>Energy Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__ENERGY_MIN_MW = GENERATING_UNIT__ENERGY_MIN_MW;

	/**
	 * The feature id for the '<em><b>Fast Start Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__FAST_START_FLAG = GENERATING_UNIT__FAST_START_FLAG;

	/**
	 * The feature id for the '<em><b>Fuel Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__FUEL_PRIORITY = GENERATING_UNIT__FUEL_PRIORITY;

	/**
	 * The feature id for the '<em><b>Gen Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GEN_OPERATING_MODE = GENERATING_UNIT__GEN_OPERATING_MODE;

	/**
	 * The feature id for the '<em><b>Long PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__LONG_PF = GENERATING_UNIT__LONG_PF;

	/**
	 * The feature id for the '<em><b>Lower Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__LOWER_RAMP_RATE = GENERATING_UNIT__LOWER_RAMP_RATE;

	/**
	 * The feature id for the '<em><b>Normal PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__NORMAL_PF = GENERATING_UNIT__NORMAL_PF;

	/**
	 * The feature id for the '<em><b>Penalty Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__PENALTY_FACTOR = GENERATING_UNIT__PENALTY_FACTOR;

	/**
	 * The feature id for the '<em><b>Raise Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__RAISE_RAMP_RATE = GENERATING_UNIT__RAISE_RAMP_RATE;

	/**
	 * The feature id for the '<em><b>Short PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__SHORT_PF = GENERATING_UNIT__SHORT_PF;

	/**
	 * The feature id for the '<em><b>Spin Reserve Ramp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__SPIN_RESERVE_RAMP = GENERATING_UNIT__SPIN_RESERVE_RAMP;

	/**
	 * The feature id for the '<em><b>Step Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__STEP_CHANGE = GENERATING_UNIT__STEP_CHANGE;

	/**
	 * The feature id for the '<em><b>Tie Line PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__TIE_LINE_PF = GENERATING_UNIT__TIE_LINE_PF;

	/**
	 * The feature id for the '<em><b>Minimum Off Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MINIMUM_OFF_TIME = GENERATING_UNIT__MINIMUM_OFF_TIME;

	/**
	 * The feature id for the '<em><b>Gen Unit Op Cost Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES = GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES;

	/**
	 * The feature id for the '<em><b>Gen Unit Op Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE = GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE;

	/**
	 * The feature id for the '<em><b>Gross To Net MW Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__GROSS_TO_NET_MW_CURVES = GENERATING_UNIT__GROSS_TO_NET_MW_CURVES;

	/**
	 * The feature id for the '<em><b>Sub Control Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__SUB_CONTROL_AREA = GENERATING_UNIT__SUB_CONTROL_AREA;

	/**
	 * The feature id for the '<em><b>Synchronous Machines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__SYNCHRONOUS_MACHINES = GENERATING_UNIT__SYNCHRONOUS_MACHINES;

	/**
	 * The feature id for the '<em><b>OM Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__OM_COST = GENERATING_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Emmission Accounts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS = GENERATING_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Emission Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__EMISSION_CURVES = GENERATING_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fossil Fuels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__FOSSIL_FUELS = GENERATING_UNIT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fuel Allocation Schedules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES = GENERATING_UNIT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Heat Input Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE = GENERATING_UNIT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Heat Rate Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE = GENERATING_UNIT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Incremental Heat Rate Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE = GENERATING_UNIT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Shutdown Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE = GENERATING_UNIT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Startup Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__STARTUP_MODEL = GENERATING_UNIT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Member Of CAES Plant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT = GENERATING_UNIT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Membmer Of Cogeneration Plant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT = GENERATING_UNIT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Member Of Combined Cycle Plant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT = GENERATING_UNIT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Thermal Generating Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THERMAL_GENERATING_UNIT_FEATURE_COUNT = GENERATING_UNIT_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.TargetLevelScheduleImpl <em>Target Level Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.TargetLevelScheduleImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getTargetLevelSchedule()
	 * @generated
	 */
	int TARGET_LEVEL_SCHEDULE = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>High Level Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Low Level Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Target Level Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LEVEL_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.TailbayLossCurveImpl <em>Tailbay Loss Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.TailbayLossCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getTailbayLossCurve()
	 * @generated
	 */
	int TAILBAY_LOSS_CURVE = 2;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Tailbay Loss Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAILBAY_LOSS_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.SteamSendoutScheduleImpl <em>Steam Sendout Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.SteamSendoutScheduleImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getSteamSendoutSchedule()
	 * @generated
	 */
	int STEAM_SENDOUT_SCHEDULE = 3;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Steam Sendout Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEAM_SENDOUT_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl <em>Startup Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartupModel()
	 * @generated
	 */
	int STARTUP_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Fixed Maint Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__FIXED_MAINT_COST = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hot Standby Heat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__HOT_STANDBY_HEAT = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incremental Maint Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__INCREMENTAL_MAINT_COST = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Minimum Down Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__MINIMUM_DOWN_TIME = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Minimum Run Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__MINIMUM_RUN_TIME = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Risk Factor Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__RISK_FACTOR_COST = CorePackage.NAMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Startup Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__STARTUP_COST = CorePackage.NAMING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Startup Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__STARTUP_DATE = CorePackage.NAMING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Startup Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__STARTUP_PRIORITY = CorePackage.NAMING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Stby Aux Power MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__STBY_AUX_POWER_MW = CorePackage.NAMING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Start Ign Fuel Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__START_IGN_FUEL_CURVE = CorePackage.NAMING_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Start Main Fuel Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__START_MAIN_FUEL_CURVE = CorePackage.NAMING_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Start Ramp Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL__START_RAMP_CURVE = CorePackage.NAMING_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Startup Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTUP_MODEL_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartRampCurveImpl <em>Start Ramp Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.StartRampCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartRampCurve()
	 * @generated
	 */
	int START_RAMP_CURVE = 5;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Hot Standby Ramp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE__HOT_STANDBY_RAMP = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Ramp Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_RAMP_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartMainFuelCurveImpl <em>Start Main Fuel Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.StartMainFuelCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartMainFuelCurve()
	 * @generated
	 */
	int START_MAIN_FUEL_CURVE = 6;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Main Fuel Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Main Fuel Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_MAIN_FUEL_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartIgnFuelCurveImpl <em>Start Ign Fuel Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.StartIgnFuelCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartIgnFuelCurve()
	 * @generated
	 */
	int START_IGN_FUEL_CURVE = 7;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Ignition Fuel Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Ign Fuel Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_IGN_FUEL_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.ShutdownCurveImpl <em>Shutdown Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.ShutdownCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getShutdownCurve()
	 * @generated
	 */
	int SHUTDOWN_CURVE = 8;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Shutdown Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__SHUTDOWN_COST = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shutdown Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE__SHUTDOWN_DATE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Shutdown Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl <em>Reservoir</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getReservoir()
	 * @generated
	 */
	int RESERVOIR = 9;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Active Storage Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__ACTIVE_STORAGE_CAPACITY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Energy Storage Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__ENERGY_STORAGE_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Full Supply Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__FULL_SUPPLY_LEVEL = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gross Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__GROSS_CAPACITY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Normal Min Operate Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__NORMAL_MIN_OPERATE_LEVEL = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>River Outlet Works</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__RIVER_OUTLET_WORKS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Spill Travel Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILL_TRAVEL_DELAY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Spillway Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILLWAY_CAPACITY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Spillway Crest Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILLWAY_CREST_LENGTH = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Spillway Crest Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILLWAY_CREST_LEVEL = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Spill Way Gate Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILL_WAY_GATE_TYPE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Hydro Power Plants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__HYDRO_POWER_PLANTS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Upstream From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__UPSTREAM_FROM = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Level Vs Volume Curve</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__LEVEL_VS_VOLUME_CURVE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Target Level Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__TARGET_LEVEL_SCHEDULE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Inflow Forecast</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__INFLOW_FORECAST = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Spills Into</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILLS_INTO = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Spills From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR__SPILLS_FROM = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>Reservoir</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVOIR_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.PenstockLossCurveImpl <em>Penstock Loss Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.PenstockLossCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getPenstockLossCurve()
	 * @generated
	 */
	int PENSTOCK_LOSS_CURVE = 10;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Penstock Loss Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENSTOCK_LOSS_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.LevelVsVolumeCurveImpl <em>Level Vs Volume Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.LevelVsVolumeCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getLevelVsVolumeCurve()
	 * @generated
	 */
	int LEVEL_VS_VOLUME_CURVE = 11;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Level Vs Volume Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_VS_VOLUME_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.InflowForecastImpl <em>Inflow Forecast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.InflowForecastImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getInflowForecast()
	 * @generated
	 */
	int INFLOW_FORECAST = 12;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Inflow Forecast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLOW_FORECAST_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.IncrementalHeatRateCurveImpl <em>Incremental Heat Rate Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.IncrementalHeatRateCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getIncrementalHeatRateCurve()
	 * @generated
	 */
	int INCREMENTAL_HEAT_RATE_CURVE = 13;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE__NET_GROSS_MW_FLAG = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Incremental Heat Rate Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENTAL_HEAT_RATE_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpOpScheduleImpl <em>Hydro Pump Op Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HydroPumpOpScheduleImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroPumpOpSchedule()
	 * @generated
	 */
	int HYDRO_PUMP_OP_SCHEDULE = 14;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Hydro Pump Op Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_OP_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl <em>Hydro Pump</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroPump()
	 * @generated
	 */
	int HYDRO_PUMP = 15;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Pump Disch At Max Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pump Disch At Min Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pump Power At Max Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pump Power At Min Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hydro Pump Op Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Hydro Pump</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_PUMP_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl <em>Hydro Power Plant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroPowerPlant()
	 * @generated
	 */
	int HYDRO_POWER_PLANT = 16;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Discharge Travel Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hydro Plant Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Penstock Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PENSTOCK_TYPE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Plant Discharge Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Plant MW Gen Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Plant MW Pump Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Plant Rated Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__PLANT_RATED_HEAD = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Surge Tank Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__SURGE_TANK_CODE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Surge Tank Crest Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Contain Hydro Generating Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Contain Hydro Pumps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Reservoir</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__RESERVOIR = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Gen Source Pump Discharge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Hydro Power Plant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_POWER_PLANT_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl <em>Hydro Generating Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroGeneratingUnit()
	 * @generated
	 */
	int HYDRO_GENERATING_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__ALIAS_NAME = GENERATING_UNIT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__DESCRIPTION = GENERATING_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__NAME = GENERATING_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__PATH_NAME = GENERATING_UNIT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MRID = GENERATING_UNIT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__SIMU_MODEL = GENERATING_UNIT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__COMPANIES = GENERATING_UNIT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__PSR_TYPE = GENERATING_UNIT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__EQUIPMENT_CONTAINER = GENERATING_UNIT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Control Deadband</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__CONTROL_DEADBAND = GENERATING_UNIT__CONTROL_DEADBAND;

	/**
	 * The feature id for the '<em><b>Control Pulse High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__CONTROL_PULSE_HIGH = GENERATING_UNIT__CONTROL_PULSE_HIGH;

	/**
	 * The feature id for the '<em><b>Control Pulse Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__CONTROL_PULSE_LOW = GENERATING_UNIT__CONTROL_PULSE_LOW;

	/**
	 * The feature id for the '<em><b>Control Response Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__CONTROL_RESPONSE_RATE = GENERATING_UNIT__CONTROL_RESPONSE_RATE;

	/**
	 * The feature id for the '<em><b>Efficiency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__EFFICIENCY = GENERATING_UNIT__EFFICIENCY;

	/**
	 * The feature id for the '<em><b>Gen Control Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GEN_CONTROL_MODE = GENERATING_UNIT__GEN_CONTROL_MODE;

	/**
	 * The feature id for the '<em><b>Gen Control Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GEN_CONTROL_SOURCE = GENERATING_UNIT__GEN_CONTROL_SOURCE;

	/**
	 * The feature id for the '<em><b>Governor MPL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GOVERNOR_MPL = GENERATING_UNIT__GOVERNOR_MPL;

	/**
	 * The feature id for the '<em><b>Governor SCD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GOVERNOR_SCD = GENERATING_UNIT__GOVERNOR_SCD;

	/**
	 * The feature id for the '<em><b>High Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__HIGH_CONTROL_LIMIT = GENERATING_UNIT__HIGH_CONTROL_LIMIT;

	/**
	 * The feature id for the '<em><b>Initial MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__INITIAL_MW = GENERATING_UNIT__INITIAL_MW;

	/**
	 * The feature id for the '<em><b>Low Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__LOW_CONTROL_LIMIT = GENERATING_UNIT__LOW_CONTROL_LIMIT;

	/**
	 * The feature id for the '<em><b>Maximum Allowable Spinning Reserve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE = GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE;

	/**
	 * The feature id for the '<em><b>Maximum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MAXIMUM_ECONOMIC_MW = GENERATING_UNIT__MAXIMUM_ECONOMIC_MW;

	/**
	 * The feature id for the '<em><b>Maximum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MAXIMUM_OPERATING_MW = GENERATING_UNIT__MAXIMUM_OPERATING_MW;

	/**
	 * The feature id for the '<em><b>Minimum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MINIMUM_ECONOMIC_MW = GENERATING_UNIT__MINIMUM_ECONOMIC_MW;

	/**
	 * The feature id for the '<em><b>Minimum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MINIMUM_OPERATING_MW = GENERATING_UNIT__MINIMUM_OPERATING_MW;

	/**
	 * The feature id for the '<em><b>Model Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MODEL_DETAIL = GENERATING_UNIT__MODEL_DETAIL;

	/**
	 * The feature id for the '<em><b>Rated Gross Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__RATED_GROSS_MAX_MW = GENERATING_UNIT__RATED_GROSS_MAX_MW;

	/**
	 * The feature id for the '<em><b>Rated Gross Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__RATED_GROSS_MIN_MW = GENERATING_UNIT__RATED_GROSS_MIN_MW;

	/**
	 * The feature id for the '<em><b>Rated Net Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__RATED_NET_MAX_MW = GENERATING_UNIT__RATED_NET_MAX_MW;

	/**
	 * The feature id for the '<em><b>Startup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__STARTUP_TIME = GENERATING_UNIT__STARTUP_TIME;

	/**
	 * The feature id for the '<em><b>Auto Cntrl Margin MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW = GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW;

	/**
	 * The feature id for the '<em><b>Alloc Spin Res MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__ALLOC_SPIN_RES_MW = GENERATING_UNIT__ALLOC_SPIN_RES_MW;

	/**
	 * The feature id for the '<em><b>Base MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__BASE_MW = GENERATING_UNIT__BASE_MW;

	/**
	 * The feature id for the '<em><b>Disp Reserve Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__DISP_RESERVE_FLAG = GENERATING_UNIT__DISP_RESERVE_FLAG;

	/**
	 * The feature id for the '<em><b>Energy Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__ENERGY_MIN_MW = GENERATING_UNIT__ENERGY_MIN_MW;

	/**
	 * The feature id for the '<em><b>Fast Start Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__FAST_START_FLAG = GENERATING_UNIT__FAST_START_FLAG;

	/**
	 * The feature id for the '<em><b>Fuel Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__FUEL_PRIORITY = GENERATING_UNIT__FUEL_PRIORITY;

	/**
	 * The feature id for the '<em><b>Gen Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GEN_OPERATING_MODE = GENERATING_UNIT__GEN_OPERATING_MODE;

	/**
	 * The feature id for the '<em><b>Long PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__LONG_PF = GENERATING_UNIT__LONG_PF;

	/**
	 * The feature id for the '<em><b>Lower Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__LOWER_RAMP_RATE = GENERATING_UNIT__LOWER_RAMP_RATE;

	/**
	 * The feature id for the '<em><b>Normal PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__NORMAL_PF = GENERATING_UNIT__NORMAL_PF;

	/**
	 * The feature id for the '<em><b>Penalty Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__PENALTY_FACTOR = GENERATING_UNIT__PENALTY_FACTOR;

	/**
	 * The feature id for the '<em><b>Raise Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__RAISE_RAMP_RATE = GENERATING_UNIT__RAISE_RAMP_RATE;

	/**
	 * The feature id for the '<em><b>Short PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__SHORT_PF = GENERATING_UNIT__SHORT_PF;

	/**
	 * The feature id for the '<em><b>Spin Reserve Ramp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__SPIN_RESERVE_RAMP = GENERATING_UNIT__SPIN_RESERVE_RAMP;

	/**
	 * The feature id for the '<em><b>Step Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__STEP_CHANGE = GENERATING_UNIT__STEP_CHANGE;

	/**
	 * The feature id for the '<em><b>Tie Line PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__TIE_LINE_PF = GENERATING_UNIT__TIE_LINE_PF;

	/**
	 * The feature id for the '<em><b>Minimum Off Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__MINIMUM_OFF_TIME = GENERATING_UNIT__MINIMUM_OFF_TIME;

	/**
	 * The feature id for the '<em><b>Gen Unit Op Cost Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES = GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES;

	/**
	 * The feature id for the '<em><b>Gen Unit Op Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE = GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE;

	/**
	 * The feature id for the '<em><b>Gross To Net MW Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__GROSS_TO_NET_MW_CURVES = GENERATING_UNIT__GROSS_TO_NET_MW_CURVES;

	/**
	 * The feature id for the '<em><b>Sub Control Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__SUB_CONTROL_AREA = GENERATING_UNIT__SUB_CONTROL_AREA;

	/**
	 * The feature id for the '<em><b>Synchronous Machines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__SYNCHRONOUS_MACHINES = GENERATING_UNIT__SYNCHRONOUS_MACHINES;

	/**
	 * The feature id for the '<em><b>Hydro Unit Water Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST = GENERATING_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hydro Generating Efficiency Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES = GENERATING_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Penstock Loss Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE = GENERATING_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tailbay Loss Curve</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE = GENERATING_UNIT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Hydro Generating Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_UNIT_FEATURE_COUNT = GENERATING_UNIT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingEfficiencyCurveImpl <em>Hydro Generating Efficiency Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingEfficiencyCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroGeneratingEfficiencyCurve()
	 * @generated
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE = 18;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Hydro Generating Efficiency Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYDRO_GENERATING_EFFICIENCY_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HeatRateCurveImpl <em>Heat Rate Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HeatRateCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHeatRateCurve()
	 * @generated
	 */
	int HEAT_RATE_CURVE = 19;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE__NET_GROSS_MW_FLAG = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Heat Rate Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_RATE_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl <em>Heat Input Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHeatInputCurve()
	 * @generated
	 */
	int HEAT_INPUT_CURVE = 20;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Aux Power Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__AUX_POWER_OFFSET = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aux Power Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__AUX_POWER_MULT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Heat Input Eff</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__HEAT_INPUT_EFF = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Heat Input Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Heat Input Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_INPUT_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.GrossToNetMWCurveImpl <em>Gross To Net MW Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.GrossToNetMWCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGrossToNetMWCurve()
	 * @generated
	 */
	int GROSS_TO_NET_MW_CURVE = 21;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Gross To Net MW Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROSS_TO_NET_MW_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.GenUnitOpScheduleImpl <em>Gen Unit Op Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.GenUnitOpScheduleImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGenUnitOpSchedule()
	 * @generated
	 */
	int GEN_UNIT_OP_SCHEDULE = 22;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Gen Unit Op Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.GenUnitOpCostCurveImpl <em>Gen Unit Op Cost Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.GenUnitOpCostCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGenUnitOpCostCurve()
	 * @generated
	 */
	int GEN_UNIT_OP_COST_CURVE = 23;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE__NET_GROSS_MW_FLAG = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Unit Op Cost Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UNIT_OP_COST_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl <em>Fuel Allocation Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getFuelAllocationSchedule()
	 * @generated
	 */
	int FUEL_ALLOCATION_SCHEDULE = 25;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Fuel Allocation End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fuel Allocation Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fuel Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Fuel Allocation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Min Fuel Allocation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fossil Fuel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Fuel Allocation Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUEL_ALLOCATION_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl <em>Fossil Fuel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getFossilFuel()
	 * @generated
	 */
	int FOSSIL_FUEL = 26;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Fossil Fuel Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FOSSIL_FUEL_TYPE = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fuel Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_COST = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fuel Dispatch Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_DISPATCH_COST = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fuel Eff Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_EFF_FACTOR = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fuel Handling Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_HANDLING_COST = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fuel Heat Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_HEAT_CONTENT = CorePackage.NAMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fuel Mixture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_MIXTURE = CorePackage.NAMING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Fuel Sulfur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_SULFUR = CorePackage.NAMING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>High MW Breakpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__HIGH_MW_BREAKPOINT = CorePackage.NAMING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Low MW Breakpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__LOW_MW_BREAKPOINT = CorePackage.NAMING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Fuel Allocation Schedule</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE = CorePackage.NAMING_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Thermal Generating Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL__THERMAL_GENERATING_UNIT = CorePackage.NAMING_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Fossil Fuel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOSSIL_FUEL_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl <em>Emission Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getEmissionCurve()
	 * @generated
	 */
	int EMISSION_CURVE = 27;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Emission Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__EMISSION_CONTENT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Emission Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__EMISSION_TYPE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE__NET_GROSS_MW_FLAG = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Emission Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.CombinedCyclePlantImpl <em>Combined Cycle Plant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.CombinedCyclePlantImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getCombinedCyclePlant()
	 * @generated
	 */
	int COMBINED_CYCLE_PLANT = 28;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Comb Cycle Plant Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contain Thermal Generating Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Combined Cycle Plant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_CYCLE_PLANT_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl <em>Cogeneration Plant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getCogenerationPlant()
	 * @generated
	 */
	int COGENERATION_PLANT = 29;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Cogen HP Sendout Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cogen HP Steam Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__COGEN_HP_STEAM_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cogen LP Sendout Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cogen LP Steam Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__COGEN_LP_STEAM_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cogen Plant MW Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__COGEN_PLANT_MW_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Contain Thermal Generating Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Steam Sendout Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Cogeneration Plant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COGENERATION_PLANT_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl <em>CAES Plant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getCAESPlant()
	 * @generated
	 */
	int CAES_PLANT = 30;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Energy Storage Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__ENERGY_STORAGE_CAPACITY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rated Capacity MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__RATED_CAPACITY_MW = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contain Air Compressor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__CONTAIN_AIR_COMPRESSOR = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contain Thermal Generating Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CAES Plant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAES_PLANT_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.AirCompressorImpl <em>Air Compressor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.AirCompressorImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getAirCompressor()
	 * @generated
	 */
	int AIR_COMPRESSOR = 31;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Air Compressor Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__AIR_COMPRESSOR_RATING = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Combustion Turbine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR__COMBUSTION_TURBINE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Air Compressor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_COMPRESSOR_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.AccountBalanceImpl <em>Account Balance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.AccountBalanceImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getAccountBalance()
	 * @generated
	 */
	int ACCOUNT_BALANCE = 33;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The number of structural features of the '<em>Account Balance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_BALANCE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.production.impl.EmissionAccountImpl <em>Emission Account</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.production.impl.EmissionAccountImpl
	 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getEmissionAccount()
	 * @generated
	 */
	int EMISSION_ACCOUNT = 32;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__ALIAS_NAME = ACCOUNT_BALANCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__DESCRIPTION = ACCOUNT_BALANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__NAME = ACCOUNT_BALANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__PATH_NAME = ACCOUNT_BALANCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__MRID = ACCOUNT_BALANCE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__CURVE_STYLE = ACCOUNT_BALANCE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__RAMP_METHOD = ACCOUNT_BALANCE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__RAMP_START_METHOD = ACCOUNT_BALANCE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__RAMP_UNITS = ACCOUNT_BALANCE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__XAXIS_TYPE = ACCOUNT_BALANCE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__XAXIS_QUANTITY = ACCOUNT_BALANCE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__Y1_AXIS_QUANTITY = ACCOUNT_BALANCE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__Y2_AXIS_QUANTITY = ACCOUNT_BALANCE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__YAXIS_TYPE = ACCOUNT_BALANCE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__CURVE_SCHEDULE_DATAS = ACCOUNT_BALANCE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__CURVE_SCHEDULE_FORMULA = ACCOUNT_BALANCE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Emission Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__EMISSION_TYPE = ACCOUNT_BALANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Emission Value Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE = ACCOUNT_BALANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Emission Account</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_ACCOUNT_FEATURE_COUNT = ACCOUNT_BALANCE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit <em>Thermal Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thermal Generating Unit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit
	 * @generated
	 */
	EClass getThermalGeneratingUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getOMCost <em>OM Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>OM Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getOMCost()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EAttribute getThermalGeneratingUnit_OMCost();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getEmmissionAccounts <em>Emmission Accounts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Emmission Accounts</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getEmmissionAccounts()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_EmmissionAccounts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getEmissionCurves <em>Emission Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Emission Curves</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getEmissionCurves()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_EmissionCurves();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFossilFuels <em>Fossil Fuels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fossil Fuels</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFossilFuels()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_FossilFuels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFuelAllocationSchedules <em>Fuel Allocation Schedules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fuel Allocation Schedules</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFuelAllocationSchedules()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_FuelAllocationSchedules();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatInputCurve <em>Heat Input Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heat Input Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatInputCurve()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_HeatInputCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatRateCurve <em>Heat Rate Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heat Rate Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatRateCurve()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_HeatRateCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getIncrementalHeatRateCurve <em>Incremental Heat Rate Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Incremental Heat Rate Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getIncrementalHeatRateCurve()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_IncrementalHeatRateCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getShutdownCurve <em>Shutdown Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Shutdown Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getShutdownCurve()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_ShutdownCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getStartupModel <em>Startup Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Startup Model</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getStartupModel()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_StartupModel();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CAESPlant <em>Member Of CAES Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member Of CAES Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CAESPlant()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_MemberOf_CAESPlant();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMembmerOf_CogenerationPlant <em>Membmer Of Cogeneration Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Membmer Of Cogeneration Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMembmerOf_CogenerationPlant()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_MembmerOf_CogenerationPlant();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CombinedCyclePlant <em>Member Of Combined Cycle Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member Of Combined Cycle Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CombinedCyclePlant()
	 * @see #getThermalGeneratingUnit()
	 * @generated
	 */
	EReference getThermalGeneratingUnit_MemberOf_CombinedCyclePlant();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule <em>Target Level Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Level Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.TargetLevelSchedule
	 * @generated
	 */
	EClass getTargetLevelSchedule();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getHighLevelLimit <em>High Level Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High Level Limit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getHighLevelLimit()
	 * @see #getTargetLevelSchedule()
	 * @generated
	 */
	EAttribute getTargetLevelSchedule_HighLevelLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getLowLevelLimit <em>Low Level Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low Level Limit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getLowLevelLimit()
	 * @see #getTargetLevelSchedule()
	 * @generated
	 */
	EAttribute getTargetLevelSchedule_LowLevelLimit();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.TailbayLossCurve <em>Tailbay Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tailbay Loss Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.TailbayLossCurve
	 * @generated
	 */
	EClass getTailbayLossCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.SteamSendoutSchedule <em>Steam Sendout Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Steam Sendout Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.SteamSendoutSchedule
	 * @generated
	 */
	EClass getSteamSendoutSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.StartupModel <em>Startup Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Startup Model</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel
	 * @generated
	 */
	EClass getStartupModel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getFixedMaintCost <em>Fixed Maint Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Maint Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getFixedMaintCost()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_FixedMaintCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getHotStandbyHeat <em>Hot Standby Heat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hot Standby Heat</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getHotStandbyHeat()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_HotStandbyHeat();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getIncrementalMaintCost <em>Incremental Maint Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incremental Maint Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getIncrementalMaintCost()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_IncrementalMaintCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumDownTime <em>Minimum Down Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Down Time</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumDownTime()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_MinimumDownTime();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumRunTime <em>Minimum Run Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Run Time</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumRunTime()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_MinimumRunTime();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getRiskFactorCost <em>Risk Factor Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risk Factor Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getRiskFactorCost()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_RiskFactorCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupCost <em>Startup Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStartupCost()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_StartupCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupDate <em>Startup Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Date</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStartupDate()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_StartupDate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupPriority <em>Startup Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Priority</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStartupPriority()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_StartupPriority();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStbyAuxPowerMW <em>Stby Aux Power MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stby Aux Power MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStbyAuxPowerMW()
	 * @see #getStartupModel()
	 * @generated
	 */
	EAttribute getStartupModel_StbyAuxPowerMW();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartIgnFuelCurve <em>Start Ign Fuel Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Ign Fuel Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStartIgnFuelCurve()
	 * @see #getStartupModel()
	 * @generated
	 */
	EReference getStartupModel_StartIgnFuelCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartMainFuelCurve <em>Start Main Fuel Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Main Fuel Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStartMainFuelCurve()
	 * @see #getStartupModel()
	 * @generated
	 */
	EReference getStartupModel_StartMainFuelCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartRampCurve <em>Start Ramp Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Ramp Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartupModel#getStartRampCurve()
	 * @see #getStartupModel()
	 * @generated
	 */
	EReference getStartupModel_StartRampCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.StartRampCurve <em>Start Ramp Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Ramp Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartRampCurve
	 * @generated
	 */
	EClass getStartRampCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartRampCurve#getHotStandbyRamp <em>Hot Standby Ramp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hot Standby Ramp</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartRampCurve#getHotStandbyRamp()
	 * @see #getStartRampCurve()
	 * @generated
	 */
	EAttribute getStartRampCurve_HotStandbyRamp();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.StartMainFuelCurve <em>Start Main Fuel Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Main Fuel Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartMainFuelCurve
	 * @generated
	 */
	EClass getStartMainFuelCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartMainFuelCurve#getMainFuelType <em>Main Fuel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Fuel Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartMainFuelCurve#getMainFuelType()
	 * @see #getStartMainFuelCurve()
	 * @generated
	 */
	EAttribute getStartMainFuelCurve_MainFuelType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve <em>Start Ign Fuel Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Ign Fuel Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve
	 * @generated
	 */
	EClass getStartIgnFuelCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve#getIgnitionFuelType <em>Ignition Fuel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignition Fuel Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.StartIgnFuelCurve#getIgnitionFuelType()
	 * @see #getStartIgnFuelCurve()
	 * @generated
	 */
	EAttribute getStartIgnFuelCurve_IgnitionFuelType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve <em>Shutdown Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shutdown Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ShutdownCurve
	 * @generated
	 */
	EClass getShutdownCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownCost <em>Shutdown Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shutdown Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownCost()
	 * @see #getShutdownCurve()
	 * @generated
	 */
	EAttribute getShutdownCurve_ShutdownCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownDate <em>Shutdown Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shutdown Date</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownDate()
	 * @see #getShutdownCurve()
	 * @generated
	 */
	EAttribute getShutdownCurve_ShutdownDate();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.Reservoir <em>Reservoir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reservoir</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir
	 * @generated
	 */
	EClass getReservoir();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getActiveStorageCapacity <em>Active Storage Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active Storage Capacity</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getActiveStorageCapacity()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_ActiveStorageCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getEnergyStorageRating <em>Energy Storage Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy Storage Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getEnergyStorageRating()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_EnergyStorageRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getFullSupplyLevel <em>Full Supply Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Supply Level</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getFullSupplyLevel()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_FullSupplyLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getGrossCapacity <em>Gross Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gross Capacity</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getGrossCapacity()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_GrossCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getNormalMinOperateLevel <em>Normal Min Operate Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normal Min Operate Level</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getNormalMinOperateLevel()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_NormalMinOperateLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getRiverOutletWorks <em>River Outlet Works</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>River Outlet Works</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getRiverOutletWorks()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_RiverOutletWorks();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillTravelDelay <em>Spill Travel Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spill Travel Delay</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillTravelDelay()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_SpillTravelDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCapacity <em>Spillway Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spillway Capacity</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCapacity()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_SpillwayCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLength <em>Spillway Crest Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spillway Crest Length</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLength()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_SpillwayCrestLength();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLevel <em>Spillway Crest Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spillway Crest Level</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLevel()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_SpillwayCrestLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillWayGateType <em>Spill Way Gate Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spill Way Gate Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillWayGateType()
	 * @see #getReservoir()
	 * @generated
	 */
	EAttribute getReservoir_SpillWayGateType();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getHydroPowerPlants <em>Hydro Power Plants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hydro Power Plants</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getHydroPowerPlants()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_HydroPowerPlants();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getUpstreamFrom <em>Upstream From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Upstream From</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getUpstreamFrom()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_UpstreamFrom();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getLevelVsVolumeCurve <em>Level Vs Volume Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Level Vs Volume Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getLevelVsVolumeCurve()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_LevelVsVolumeCurve();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getTargetLevelSchedule <em>Target Level Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Level Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getTargetLevelSchedule()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_TargetLevelSchedule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getInflowForecast <em>Inflow Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inflow Forecast</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getInflowForecast()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_InflowForecast();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsInto <em>Spills Into</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Spills Into</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsInto()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_SpillsInto();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsFrom <em>Spills From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Spills From</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsFrom()
	 * @see #getReservoir()
	 * @generated
	 */
	EReference getReservoir_SpillsFrom();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.PenstockLossCurve <em>Penstock Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Penstock Loss Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.PenstockLossCurve
	 * @generated
	 */
	EClass getPenstockLossCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve <em>Level Vs Volume Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Level Vs Volume Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve
	 * @generated
	 */
	EClass getLevelVsVolumeCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.InflowForecast <em>Inflow Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inflow Forecast</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.InflowForecast
	 * @generated
	 */
	EClass getInflowForecast();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve <em>Incremental Heat Rate Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incremental Heat Rate Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve
	 * @generated
	 */
	EClass getIncrementalHeatRateCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Gross MW Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve#getNetGrossMWFlag()
	 * @see #getIncrementalHeatRateCurve()
	 * @generated
	 */
	EAttribute getIncrementalHeatRateCurve_NetGrossMWFlag();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HydroPumpOpSchedule <em>Hydro Pump Op Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hydro Pump Op Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPumpOpSchedule
	 * @generated
	 */
	EClass getHydroPumpOpSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HydroPump <em>Hydro Pump</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hydro Pump</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump
	 * @generated
	 */
	EClass getHydroPump();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMaxHead <em>Pump Disch At Max Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pump Disch At Max Head</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMaxHead()
	 * @see #getHydroPump()
	 * @generated
	 */
	EAttribute getHydroPump_PumpDischAtMaxHead();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMinHead <em>Pump Disch At Min Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pump Disch At Min Head</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMinHead()
	 * @see #getHydroPump()
	 * @generated
	 */
	EAttribute getHydroPump_PumpDischAtMinHead();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMaxHead <em>Pump Power At Max Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pump Power At Max Head</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMaxHead()
	 * @see #getHydroPump()
	 * @generated
	 */
	EAttribute getHydroPump_PumpPowerAtMaxHead();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMinHead <em>Pump Power At Min Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pump Power At Min Head</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMinHead()
	 * @see #getHydroPump()
	 * @generated
	 */
	EAttribute getHydroPump_PumpPowerAtMinHead();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getHydroPumpOpSchedule <em>Hydro Pump Op Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hydro Pump Op Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPump#getHydroPumpOpSchedule()
	 * @see #getHydroPump()
	 * @generated
	 */
	EReference getHydroPump_HydroPumpOpSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant <em>Hydro Power Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hydro Power Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant
	 * @generated
	 */
	EClass getHydroPowerPlant();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getDischargeTravelDelay <em>Discharge Travel Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discharge Travel Delay</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getDischargeTravelDelay()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_DischargeTravelDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getHydroPlantType <em>Hydro Plant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hydro Plant Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getHydroPlantType()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_HydroPlantType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPenstockType <em>Penstock Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Penstock Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPenstockType()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_PenstockType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantDischargeCapacity <em>Plant Discharge Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plant Discharge Capacity</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantDischargeCapacity()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_PlantDischargeCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWGenRating <em>Plant MW Gen Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plant MW Gen Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWGenRating()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_PlantMWGenRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWPumpRating <em>Plant MW Pump Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plant MW Pump Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantMWPumpRating()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_PlantMWPumpRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantRatedHead <em>Plant Rated Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plant Rated Head</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getPlantRatedHead()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_PlantRatedHead();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCode <em>Surge Tank Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Surge Tank Code</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCode()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_SurgeTankCode();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCrestLevel <em>Surge Tank Crest Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Surge Tank Crest Level</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getSurgeTankCrestLevel()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EAttribute getHydroPowerPlant_SurgeTankCrestLevel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getContain_HydroGeneratingUnits <em>Contain Hydro Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contain Hydro Generating Units</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getContain_HydroGeneratingUnits()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EReference getHydroPowerPlant_Contain_HydroGeneratingUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getContain_HydroPumps <em>Contain Hydro Pumps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contain Hydro Pumps</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getContain_HydroPumps()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EReference getHydroPowerPlant_Contain_HydroPumps();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getReservoir <em>Reservoir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reservoir</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getReservoir()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EReference getHydroPowerPlant_Reservoir();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getGenSourcePumpDischarge <em>Gen Source Pump Discharge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gen Source Pump Discharge</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getGenSourcePumpDischarge()
	 * @see #getHydroPowerPlant()
	 * @generated
	 */
	EReference getHydroPowerPlant_GenSourcePumpDischarge();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit <em>Hydro Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hydro Generating Unit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit
	 * @generated
	 */
	EClass getHydroGeneratingUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroUnitWaterCost <em>Hydro Unit Water Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hydro Unit Water Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroUnitWaterCost()
	 * @see #getHydroGeneratingUnit()
	 * @generated
	 */
	EAttribute getHydroGeneratingUnit_HydroUnitWaterCost();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroGeneratingEfficiencyCurves <em>Hydro Generating Efficiency Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hydro Generating Efficiency Curves</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroGeneratingEfficiencyCurves()
	 * @see #getHydroGeneratingUnit()
	 * @generated
	 */
	EReference getHydroGeneratingUnit_HydroGeneratingEfficiencyCurves();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getPenstockLossCurve <em>Penstock Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Penstock Loss Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getPenstockLossCurve()
	 * @see #getHydroGeneratingUnit()
	 * @generated
	 */
	EReference getHydroGeneratingUnit_PenstockLossCurve();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getTailbayLossCurve <em>Tailbay Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tailbay Loss Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getTailbayLossCurve()
	 * @see #getHydroGeneratingUnit()
	 * @generated
	 */
	EReference getHydroGeneratingUnit_TailbayLossCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve <em>Hydro Generating Efficiency Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hydro Generating Efficiency Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve
	 * @generated
	 */
	EClass getHydroGeneratingEfficiencyCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HeatRateCurve <em>Heat Rate Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Heat Rate Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatRateCurve
	 * @generated
	 */
	EClass getHeatRateCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HeatRateCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Gross MW Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatRateCurve#getNetGrossMWFlag()
	 * @see #getHeatRateCurve()
	 * @generated
	 */
	EAttribute getHeatRateCurve_NetGrossMWFlag();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve <em>Heat Input Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Heat Input Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve
	 * @generated
	 */
	EClass getHeatInputCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerOffset <em>Aux Power Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aux Power Offset</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerOffset()
	 * @see #getHeatInputCurve()
	 * @generated
	 */
	EAttribute getHeatInputCurve_AuxPowerOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerMult <em>Aux Power Mult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aux Power Mult</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve#getAuxPowerMult()
	 * @see #getHeatInputCurve()
	 * @generated
	 */
	EAttribute getHeatInputCurve_AuxPowerMult();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputEff <em>Heat Input Eff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heat Input Eff</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputEff()
	 * @see #getHeatInputCurve()
	 * @generated
	 */
	EAttribute getHeatInputCurve_HeatInputEff();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputOffset <em>Heat Input Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heat Input Offset</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve#getHeatInputOffset()
	 * @see #getHeatInputCurve()
	 * @generated
	 */
	EAttribute getHeatInputCurve_HeatInputOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.HeatInputCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Gross MW Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.HeatInputCurve#getNetGrossMWFlag()
	 * @see #getHeatInputCurve()
	 * @generated
	 */
	EAttribute getHeatInputCurve_NetGrossMWFlag();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve <em>Gross To Net MW Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gross To Net MW Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve
	 * @generated
	 */
	EClass getGrossToNetMWCurve();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.GenUnitOpSchedule <em>Gen Unit Op Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Unit Op Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GenUnitOpSchedule
	 * @generated
	 */
	EClass getGenUnitOpSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve <em>Gen Unit Op Cost Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Unit Op Cost Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve
	 * @generated
	 */
	EClass getGenUnitOpCostCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Gross MW Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve#getNetGrossMWFlag()
	 * @see #getGenUnitOpCostCurve()
	 * @generated
	 */
	EAttribute getGenUnitOpCostCurve_NetGrossMWFlag();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit <em>Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generating Unit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit
	 * @generated
	 */
	EClass getGeneratingUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlDeadband <em>Control Deadband</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Deadband</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlDeadband()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_ControlDeadband();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseHigh <em>Control Pulse High</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Pulse High</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseHigh()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_ControlPulseHigh();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseLow <em>Control Pulse Low</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Pulse Low</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseLow()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_ControlPulseLow();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlResponseRate <em>Control Response Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Response Rate</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlResponseRate()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_ControlResponseRate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEfficiency <em>Efficiency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Efficiency</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEfficiency()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_Efficiency();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlMode <em>Gen Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gen Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlMode()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_GenControlMode();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlSource <em>Gen Control Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gen Control Source</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlSource()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_GenControlSource();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorMPL <em>Governor MPL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Governor MPL</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorMPL()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_GovernorMPL();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorSCD <em>Governor SCD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Governor SCD</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorSCD()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_GovernorSCD();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getHighControlLimit <em>High Control Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High Control Limit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getHighControlLimit()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_HighControlLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getInitialMW <em>Initial MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getInitialMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_InitialMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowControlLimit <em>Low Control Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low Control Limit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowControlLimit()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_LowControlLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumAllowableSpinningReserve <em>Maximum Allowable Spinning Reserve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Allowable Spinning Reserve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumAllowableSpinningReserve()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_MaximumAllowableSpinningReserve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumEconomicMW <em>Maximum Economic MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Economic MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumEconomicMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_MaximumEconomicMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumOperatingMW <em>Maximum Operating MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Operating MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumOperatingMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_MaximumOperatingMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumEconomicMW <em>Minimum Economic MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Economic MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumEconomicMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_MinimumEconomicMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOperatingMW <em>Minimum Operating MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Operating MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOperatingMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_MinimumOperatingMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getModelDetail <em>Model Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Detail</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getModelDetail()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_ModelDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMaxMW <em>Rated Gross Max MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated Gross Max MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMaxMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_RatedGrossMaxMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMinMW <em>Rated Gross Min MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated Gross Min MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMinMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_RatedGrossMinMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedNetMaxMW <em>Rated Net Max MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated Net Max MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedNetMaxMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_RatedNetMaxMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStartupTime <em>Startup Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Time</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStartupTime()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_StartupTime();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAutoCntrlMarginMW <em>Auto Cntrl Margin MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Cntrl Margin MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAutoCntrlMarginMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_AutoCntrlMarginMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAllocSpinResMW <em>Alloc Spin Res MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alloc Spin Res MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAllocSpinResMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_AllocSpinResMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getBaseMW <em>Base MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getBaseMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_BaseMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getDispReserveFlag <em>Disp Reserve Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disp Reserve Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getDispReserveFlag()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_DispReserveFlag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEnergyMinMW <em>Energy Min MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy Min MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEnergyMinMW()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_EnergyMinMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFastStartFlag <em>Fast Start Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fast Start Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFastStartFlag()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_FastStartFlag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFuelPriority <em>Fuel Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Priority</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFuelPriority()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_FuelPriority();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenOperatingMode <em>Gen Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gen Operating Mode</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenOperatingMode()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_GenOperatingMode();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLongPF <em>Long PF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long PF</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLongPF()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_LongPF();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowerRampRate <em>Lower Ramp Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Ramp Rate</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowerRampRate()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_LowerRampRate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getNormalPF <em>Normal PF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normal PF</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getNormalPF()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_NormalPF();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getPenaltyFactor <em>Penalty Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Penalty Factor</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getPenaltyFactor()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_PenaltyFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRaiseRampRate <em>Raise Ramp Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raise Ramp Rate</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRaiseRampRate()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_RaiseRampRate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getShortPF <em>Short PF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short PF</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getShortPF()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_ShortPF();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSpinReserveRamp <em>Spin Reserve Ramp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spin Reserve Ramp</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSpinReserveRamp()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_SpinReserveRamp();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStepChange <em>Step Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Change</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStepChange()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_StepChange();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getTieLinePF <em>Tie Line PF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tie Line PF</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getTieLinePF()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_TieLinePF();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOffTime <em>Minimum Off Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Off Time</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOffTime()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EAttribute getGeneratingUnit_MinimumOffTime();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpCostCurves <em>Gen Unit Op Cost Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gen Unit Op Cost Curves</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpCostCurves()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EReference getGeneratingUnit_GenUnitOpCostCurves();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpSchedule <em>Gen Unit Op Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gen Unit Op Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpSchedule()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EReference getGeneratingUnit_GenUnitOpSchedule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGrossToNetMWCurves <em>Gross To Net MW Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gross To Net MW Curves</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGrossToNetMWCurves()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EReference getGeneratingUnit_GrossToNetMWCurves();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSubControlArea <em>Sub Control Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Control Area</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSubControlArea()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EReference getGeneratingUnit_SubControlArea();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSynchronousMachines <em>Synchronous Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Synchronous Machines</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSynchronousMachines()
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	EReference getGeneratingUnit_SynchronousMachines();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule <em>Fuel Allocation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fuel Allocation Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule
	 * @generated
	 */
	EClass getFuelAllocationSchedule();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationEndDate <em>Fuel Allocation End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Allocation End Date</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationEndDate()
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 */
	EAttribute getFuelAllocationSchedule_FuelAllocationEndDate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationStartDate <em>Fuel Allocation Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Allocation Start Date</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelAllocationStartDate()
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 */
	EAttribute getFuelAllocationSchedule_FuelAllocationStartDate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelType <em>Fuel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFuelType()
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 */
	EAttribute getFuelAllocationSchedule_FuelType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMaxFuelAllocation <em>Max Fuel Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Fuel Allocation</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMaxFuelAllocation()
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 */
	EAttribute getFuelAllocationSchedule_MaxFuelAllocation();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMinFuelAllocation <em>Min Fuel Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Fuel Allocation</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getMinFuelAllocation()
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 */
	EAttribute getFuelAllocationSchedule_MinFuelAllocation();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFossilFuel <em>Fossil Fuel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fossil Fuel</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule#getFossilFuel()
	 * @see #getFuelAllocationSchedule()
	 * @generated
	 */
	EReference getFuelAllocationSchedule_FossilFuel();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.FossilFuel <em>Fossil Fuel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fossil Fuel</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel
	 * @generated
	 */
	EClass getFossilFuel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFossilFuelType <em>Fossil Fuel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fossil Fuel Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFossilFuelType()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FossilFuelType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelCost <em>Fuel Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelCost()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelDispatchCost <em>Fuel Dispatch Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Dispatch Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelDispatchCost()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelDispatchCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelEffFactor <em>Fuel Eff Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Eff Factor</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelEffFactor()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelEffFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHandlingCost <em>Fuel Handling Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Handling Cost</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHandlingCost()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelHandlingCost();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHeatContent <em>Fuel Heat Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Heat Content</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelHeatContent()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelHeatContent();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelMixture <em>Fuel Mixture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Mixture</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelMixture()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelMixture();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelSulfur <em>Fuel Sulfur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuel Sulfur</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelSulfur()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_FuelSulfur();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getHighMWBreakpoint <em>High MW Breakpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High MW Breakpoint</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getHighMWBreakpoint()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_HighMWBreakpoint();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getLowMWBreakpoint <em>Low MW Breakpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low MW Breakpoint</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getLowMWBreakpoint()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EAttribute getFossilFuel_LowMWBreakpoint();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelAllocationSchedule <em>Fuel Allocation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fuel Allocation Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getFuelAllocationSchedule()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EReference getFossilFuel_FuelAllocationSchedule();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getThermalGeneratingUnit <em>Thermal Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Thermal Generating Unit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getThermalGeneratingUnit()
	 * @see #getFossilFuel()
	 * @generated
	 */
	EReference getFossilFuel_ThermalGeneratingUnit();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve <em>Emission Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emission Curve</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionCurve
	 * @generated
	 */
	EClass getEmissionCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionContent <em>Emission Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emission Content</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionContent()
	 * @see #getEmissionCurve()
	 * @generated
	 */
	EAttribute getEmissionCurve_EmissionContent();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionType <em>Emission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emission Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionType()
	 * @see #getEmissionCurve()
	 * @generated
	 */
	EAttribute getEmissionCurve_EmissionType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Gross MW Flag</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionCurve#getNetGrossMWFlag()
	 * @see #getEmissionCurve()
	 * @generated
	 */
	EAttribute getEmissionCurve_NetGrossMWFlag();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant <em>Combined Cycle Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combined Cycle Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CombinedCyclePlant
	 * @generated
	 */
	EClass getCombinedCyclePlant();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getCombCyclePlantRating <em>Comb Cycle Plant Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comb Cycle Plant Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getCombCyclePlantRating()
	 * @see #getCombinedCyclePlant()
	 * @generated
	 */
	EAttribute getCombinedCyclePlant_CombCyclePlantRating();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contain Thermal Generating Units</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getContain_ThermalGeneratingUnits()
	 * @see #getCombinedCyclePlant()
	 * @generated
	 */
	EReference getCombinedCyclePlant_Contain_ThermalGeneratingUnits();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant <em>Cogeneration Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cogeneration Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant
	 * @generated
	 */
	EClass getCogenerationPlant();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSendoutRating <em>Cogen HP Sendout Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cogen HP Sendout Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSendoutRating()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EAttribute getCogenerationPlant_CogenHPSendoutRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSteamRating <em>Cogen HP Steam Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cogen HP Steam Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSteamRating()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EAttribute getCogenerationPlant_CogenHPSteamRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSendoutRating <em>Cogen LP Sendout Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cogen LP Sendout Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSendoutRating()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EAttribute getCogenerationPlant_CogenLPSendoutRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSteamRating <em>Cogen LP Steam Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cogen LP Steam Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSteamRating()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EAttribute getCogenerationPlant_CogenLPSteamRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenPlantMWRating <em>Cogen Plant MW Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cogen Plant MW Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenPlantMWRating()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EAttribute getCogenerationPlant_CogenPlantMWRating();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contain Thermal Generating Units</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getContain_ThermalGeneratingUnits()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EReference getCogenerationPlant_Contain_ThermalGeneratingUnits();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getSteamSendoutSchedule <em>Steam Sendout Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Steam Sendout Schedule</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getSteamSendoutSchedule()
	 * @see #getCogenerationPlant()
	 * @generated
	 */
	EReference getCogenerationPlant_SteamSendoutSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.CAESPlant <em>CAES Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CAES Plant</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant
	 * @generated
	 */
	EClass getCAESPlant();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getEnergyStorageCapacity <em>Energy Storage Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy Storage Capacity</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant#getEnergyStorageCapacity()
	 * @see #getCAESPlant()
	 * @generated
	 */
	EAttribute getCAESPlant_EnergyStorageCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getRatedCapacityMW <em>Rated Capacity MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated Capacity MW</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant#getRatedCapacityMW()
	 * @see #getCAESPlant()
	 * @generated
	 */
	EAttribute getCAESPlant_RatedCapacityMW();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_AirCompressor <em>Contain Air Compressor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contain Air Compressor</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_AirCompressor()
	 * @see #getCAESPlant()
	 * @generated
	 */
	EReference getCAESPlant_Contain_AirCompressor();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_ThermalGeneratingUnit <em>Contain Thermal Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contain Thermal Generating Unit</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_ThermalGeneratingUnit()
	 * @see #getCAESPlant()
	 * @generated
	 */
	EReference getCAESPlant_Contain_ThermalGeneratingUnit();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.AirCompressor <em>Air Compressor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Air Compressor</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.AirCompressor
	 * @generated
	 */
	EClass getAirCompressor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getAirCompressorRating <em>Air Compressor Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Air Compressor Rating</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.AirCompressor#getAirCompressorRating()
	 * @see #getAirCompressor()
	 * @generated
	 */
	EAttribute getAirCompressor_AirCompressorRating();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.gen.production.AirCompressor#getCombustionTurbine <em>Combustion Turbine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Combustion Turbine</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.AirCompressor#getCombustionTurbine()
	 * @see #getAirCompressor()
	 * @generated
	 */
	EReference getAirCompressor_CombustionTurbine();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.EmissionAccount <em>Emission Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emission Account</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionAccount
	 * @generated
	 */
	EClass getEmissionAccount();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionType <em>Emission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emission Type</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionType()
	 * @see #getEmissionAccount()
	 * @generated
	 */
	EAttribute getEmissionAccount_EmissionType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionValueSource <em>Emission Value Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emission Value Source</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionValueSource()
	 * @see #getEmissionAccount()
	 * @generated
	 */
	EAttribute getEmissionAccount_EmissionValueSource();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.production.AccountBalance <em>Account Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Account Balance</em>'.
	 * @see org.opencim.cim.iec61970.gen.production.AccountBalance
	 * @generated
	 */
	EClass getAccountBalance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProductionFactory getProductionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl <em>Thermal Generating Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.ThermalGeneratingUnitImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getThermalGeneratingUnit()
		 * @generated
		 */
		EClass THERMAL_GENERATING_UNIT = eINSTANCE.getThermalGeneratingUnit();

		/**
		 * The meta object literal for the '<em><b>OM Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THERMAL_GENERATING_UNIT__OM_COST = eINSTANCE.getThermalGeneratingUnit_OMCost();

		/**
		 * The meta object literal for the '<em><b>Emmission Accounts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__EMMISSION_ACCOUNTS = eINSTANCE.getThermalGeneratingUnit_EmmissionAccounts();

		/**
		 * The meta object literal for the '<em><b>Emission Curves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__EMISSION_CURVES = eINSTANCE.getThermalGeneratingUnit_EmissionCurves();

		/**
		 * The meta object literal for the '<em><b>Fossil Fuels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__FOSSIL_FUELS = eINSTANCE.getThermalGeneratingUnit_FossilFuels();

		/**
		 * The meta object literal for the '<em><b>Fuel Allocation Schedules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__FUEL_ALLOCATION_SCHEDULES = eINSTANCE.getThermalGeneratingUnit_FuelAllocationSchedules();

		/**
		 * The meta object literal for the '<em><b>Heat Input Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__HEAT_INPUT_CURVE = eINSTANCE.getThermalGeneratingUnit_HeatInputCurve();

		/**
		 * The meta object literal for the '<em><b>Heat Rate Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__HEAT_RATE_CURVE = eINSTANCE.getThermalGeneratingUnit_HeatRateCurve();

		/**
		 * The meta object literal for the '<em><b>Incremental Heat Rate Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__INCREMENTAL_HEAT_RATE_CURVE = eINSTANCE.getThermalGeneratingUnit_IncrementalHeatRateCurve();

		/**
		 * The meta object literal for the '<em><b>Shutdown Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__SHUTDOWN_CURVE = eINSTANCE.getThermalGeneratingUnit_ShutdownCurve();

		/**
		 * The meta object literal for the '<em><b>Startup Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__STARTUP_MODEL = eINSTANCE.getThermalGeneratingUnit_StartupModel();

		/**
		 * The meta object literal for the '<em><b>Member Of CAES Plant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__MEMBER_OF_CAES_PLANT = eINSTANCE.getThermalGeneratingUnit_MemberOf_CAESPlant();

		/**
		 * The meta object literal for the '<em><b>Membmer Of Cogeneration Plant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__MEMBMER_OF_COGENERATION_PLANT = eINSTANCE.getThermalGeneratingUnit_MembmerOf_CogenerationPlant();

		/**
		 * The meta object literal for the '<em><b>Member Of Combined Cycle Plant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THERMAL_GENERATING_UNIT__MEMBER_OF_COMBINED_CYCLE_PLANT = eINSTANCE.getThermalGeneratingUnit_MemberOf_CombinedCyclePlant();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.TargetLevelScheduleImpl <em>Target Level Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.TargetLevelScheduleImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getTargetLevelSchedule()
		 * @generated
		 */
		EClass TARGET_LEVEL_SCHEDULE = eINSTANCE.getTargetLevelSchedule();

		/**
		 * The meta object literal for the '<em><b>High Level Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_LEVEL_SCHEDULE__HIGH_LEVEL_LIMIT = eINSTANCE.getTargetLevelSchedule_HighLevelLimit();

		/**
		 * The meta object literal for the '<em><b>Low Level Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_LEVEL_SCHEDULE__LOW_LEVEL_LIMIT = eINSTANCE.getTargetLevelSchedule_LowLevelLimit();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.TailbayLossCurveImpl <em>Tailbay Loss Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.TailbayLossCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getTailbayLossCurve()
		 * @generated
		 */
		EClass TAILBAY_LOSS_CURVE = eINSTANCE.getTailbayLossCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.SteamSendoutScheduleImpl <em>Steam Sendout Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.SteamSendoutScheduleImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getSteamSendoutSchedule()
		 * @generated
		 */
		EClass STEAM_SENDOUT_SCHEDULE = eINSTANCE.getSteamSendoutSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl <em>Startup Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.StartupModelImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartupModel()
		 * @generated
		 */
		EClass STARTUP_MODEL = eINSTANCE.getStartupModel();

		/**
		 * The meta object literal for the '<em><b>Fixed Maint Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__FIXED_MAINT_COST = eINSTANCE.getStartupModel_FixedMaintCost();

		/**
		 * The meta object literal for the '<em><b>Hot Standby Heat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__HOT_STANDBY_HEAT = eINSTANCE.getStartupModel_HotStandbyHeat();

		/**
		 * The meta object literal for the '<em><b>Incremental Maint Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__INCREMENTAL_MAINT_COST = eINSTANCE.getStartupModel_IncrementalMaintCost();

		/**
		 * The meta object literal for the '<em><b>Minimum Down Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__MINIMUM_DOWN_TIME = eINSTANCE.getStartupModel_MinimumDownTime();

		/**
		 * The meta object literal for the '<em><b>Minimum Run Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__MINIMUM_RUN_TIME = eINSTANCE.getStartupModel_MinimumRunTime();

		/**
		 * The meta object literal for the '<em><b>Risk Factor Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__RISK_FACTOR_COST = eINSTANCE.getStartupModel_RiskFactorCost();

		/**
		 * The meta object literal for the '<em><b>Startup Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__STARTUP_COST = eINSTANCE.getStartupModel_StartupCost();

		/**
		 * The meta object literal for the '<em><b>Startup Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__STARTUP_DATE = eINSTANCE.getStartupModel_StartupDate();

		/**
		 * The meta object literal for the '<em><b>Startup Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__STARTUP_PRIORITY = eINSTANCE.getStartupModel_StartupPriority();

		/**
		 * The meta object literal for the '<em><b>Stby Aux Power MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTUP_MODEL__STBY_AUX_POWER_MW = eINSTANCE.getStartupModel_StbyAuxPowerMW();

		/**
		 * The meta object literal for the '<em><b>Start Ign Fuel Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STARTUP_MODEL__START_IGN_FUEL_CURVE = eINSTANCE.getStartupModel_StartIgnFuelCurve();

		/**
		 * The meta object literal for the '<em><b>Start Main Fuel Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STARTUP_MODEL__START_MAIN_FUEL_CURVE = eINSTANCE.getStartupModel_StartMainFuelCurve();

		/**
		 * The meta object literal for the '<em><b>Start Ramp Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STARTUP_MODEL__START_RAMP_CURVE = eINSTANCE.getStartupModel_StartRampCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartRampCurveImpl <em>Start Ramp Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.StartRampCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartRampCurve()
		 * @generated
		 */
		EClass START_RAMP_CURVE = eINSTANCE.getStartRampCurve();

		/**
		 * The meta object literal for the '<em><b>Hot Standby Ramp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute START_RAMP_CURVE__HOT_STANDBY_RAMP = eINSTANCE.getStartRampCurve_HotStandbyRamp();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartMainFuelCurveImpl <em>Start Main Fuel Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.StartMainFuelCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartMainFuelCurve()
		 * @generated
		 */
		EClass START_MAIN_FUEL_CURVE = eINSTANCE.getStartMainFuelCurve();

		/**
		 * The meta object literal for the '<em><b>Main Fuel Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute START_MAIN_FUEL_CURVE__MAIN_FUEL_TYPE = eINSTANCE.getStartMainFuelCurve_MainFuelType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.StartIgnFuelCurveImpl <em>Start Ign Fuel Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.StartIgnFuelCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getStartIgnFuelCurve()
		 * @generated
		 */
		EClass START_IGN_FUEL_CURVE = eINSTANCE.getStartIgnFuelCurve();

		/**
		 * The meta object literal for the '<em><b>Ignition Fuel Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute START_IGN_FUEL_CURVE__IGNITION_FUEL_TYPE = eINSTANCE.getStartIgnFuelCurve_IgnitionFuelType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.ShutdownCurveImpl <em>Shutdown Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.ShutdownCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getShutdownCurve()
		 * @generated
		 */
		EClass SHUTDOWN_CURVE = eINSTANCE.getShutdownCurve();

		/**
		 * The meta object literal for the '<em><b>Shutdown Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHUTDOWN_CURVE__SHUTDOWN_COST = eINSTANCE.getShutdownCurve_ShutdownCost();

		/**
		 * The meta object literal for the '<em><b>Shutdown Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHUTDOWN_CURVE__SHUTDOWN_DATE = eINSTANCE.getShutdownCurve_ShutdownDate();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl <em>Reservoir</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.ReservoirImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getReservoir()
		 * @generated
		 */
		EClass RESERVOIR = eINSTANCE.getReservoir();

		/**
		 * The meta object literal for the '<em><b>Active Storage Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__ACTIVE_STORAGE_CAPACITY = eINSTANCE.getReservoir_ActiveStorageCapacity();

		/**
		 * The meta object literal for the '<em><b>Energy Storage Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__ENERGY_STORAGE_RATING = eINSTANCE.getReservoir_EnergyStorageRating();

		/**
		 * The meta object literal for the '<em><b>Full Supply Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__FULL_SUPPLY_LEVEL = eINSTANCE.getReservoir_FullSupplyLevel();

		/**
		 * The meta object literal for the '<em><b>Gross Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__GROSS_CAPACITY = eINSTANCE.getReservoir_GrossCapacity();

		/**
		 * The meta object literal for the '<em><b>Normal Min Operate Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__NORMAL_MIN_OPERATE_LEVEL = eINSTANCE.getReservoir_NormalMinOperateLevel();

		/**
		 * The meta object literal for the '<em><b>River Outlet Works</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__RIVER_OUTLET_WORKS = eINSTANCE.getReservoir_RiverOutletWorks();

		/**
		 * The meta object literal for the '<em><b>Spill Travel Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__SPILL_TRAVEL_DELAY = eINSTANCE.getReservoir_SpillTravelDelay();

		/**
		 * The meta object literal for the '<em><b>Spillway Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__SPILLWAY_CAPACITY = eINSTANCE.getReservoir_SpillwayCapacity();

		/**
		 * The meta object literal for the '<em><b>Spillway Crest Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__SPILLWAY_CREST_LENGTH = eINSTANCE.getReservoir_SpillwayCrestLength();

		/**
		 * The meta object literal for the '<em><b>Spillway Crest Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__SPILLWAY_CREST_LEVEL = eINSTANCE.getReservoir_SpillwayCrestLevel();

		/**
		 * The meta object literal for the '<em><b>Spill Way Gate Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVOIR__SPILL_WAY_GATE_TYPE = eINSTANCE.getReservoir_SpillWayGateType();

		/**
		 * The meta object literal for the '<em><b>Hydro Power Plants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__HYDRO_POWER_PLANTS = eINSTANCE.getReservoir_HydroPowerPlants();

		/**
		 * The meta object literal for the '<em><b>Upstream From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__UPSTREAM_FROM = eINSTANCE.getReservoir_UpstreamFrom();

		/**
		 * The meta object literal for the '<em><b>Level Vs Volume Curve</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__LEVEL_VS_VOLUME_CURVE = eINSTANCE.getReservoir_LevelVsVolumeCurve();

		/**
		 * The meta object literal for the '<em><b>Target Level Schedule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__TARGET_LEVEL_SCHEDULE = eINSTANCE.getReservoir_TargetLevelSchedule();

		/**
		 * The meta object literal for the '<em><b>Inflow Forecast</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__INFLOW_FORECAST = eINSTANCE.getReservoir_InflowForecast();

		/**
		 * The meta object literal for the '<em><b>Spills Into</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__SPILLS_INTO = eINSTANCE.getReservoir_SpillsInto();

		/**
		 * The meta object literal for the '<em><b>Spills From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVOIR__SPILLS_FROM = eINSTANCE.getReservoir_SpillsFrom();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.PenstockLossCurveImpl <em>Penstock Loss Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.PenstockLossCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getPenstockLossCurve()
		 * @generated
		 */
		EClass PENSTOCK_LOSS_CURVE = eINSTANCE.getPenstockLossCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.LevelVsVolumeCurveImpl <em>Level Vs Volume Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.LevelVsVolumeCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getLevelVsVolumeCurve()
		 * @generated
		 */
		EClass LEVEL_VS_VOLUME_CURVE = eINSTANCE.getLevelVsVolumeCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.InflowForecastImpl <em>Inflow Forecast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.InflowForecastImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getInflowForecast()
		 * @generated
		 */
		EClass INFLOW_FORECAST = eINSTANCE.getInflowForecast();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.IncrementalHeatRateCurveImpl <em>Incremental Heat Rate Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.IncrementalHeatRateCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getIncrementalHeatRateCurve()
		 * @generated
		 */
		EClass INCREMENTAL_HEAT_RATE_CURVE = eINSTANCE.getIncrementalHeatRateCurve();

		/**
		 * The meta object literal for the '<em><b>Net Gross MW Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCREMENTAL_HEAT_RATE_CURVE__NET_GROSS_MW_FLAG = eINSTANCE.getIncrementalHeatRateCurve_NetGrossMWFlag();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpOpScheduleImpl <em>Hydro Pump Op Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HydroPumpOpScheduleImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroPumpOpSchedule()
		 * @generated
		 */
		EClass HYDRO_PUMP_OP_SCHEDULE = eINSTANCE.getHydroPumpOpSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl <em>Hydro Pump</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HydroPumpImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroPump()
		 * @generated
		 */
		EClass HYDRO_PUMP = eINSTANCE.getHydroPump();

		/**
		 * The meta object literal for the '<em><b>Pump Disch At Max Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_PUMP__PUMP_DISCH_AT_MAX_HEAD = eINSTANCE.getHydroPump_PumpDischAtMaxHead();

		/**
		 * The meta object literal for the '<em><b>Pump Disch At Min Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_PUMP__PUMP_DISCH_AT_MIN_HEAD = eINSTANCE.getHydroPump_PumpDischAtMinHead();

		/**
		 * The meta object literal for the '<em><b>Pump Power At Max Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_PUMP__PUMP_POWER_AT_MAX_HEAD = eINSTANCE.getHydroPump_PumpPowerAtMaxHead();

		/**
		 * The meta object literal for the '<em><b>Pump Power At Min Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_PUMP__PUMP_POWER_AT_MIN_HEAD = eINSTANCE.getHydroPump_PumpPowerAtMinHead();

		/**
		 * The meta object literal for the '<em><b>Hydro Pump Op Schedule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_PUMP__HYDRO_PUMP_OP_SCHEDULE = eINSTANCE.getHydroPump_HydroPumpOpSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl <em>Hydro Power Plant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HydroPowerPlantImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroPowerPlant()
		 * @generated
		 */
		EClass HYDRO_POWER_PLANT = eINSTANCE.getHydroPowerPlant();

		/**
		 * The meta object literal for the '<em><b>Discharge Travel Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__DISCHARGE_TRAVEL_DELAY = eINSTANCE.getHydroPowerPlant_DischargeTravelDelay();

		/**
		 * The meta object literal for the '<em><b>Hydro Plant Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__HYDRO_PLANT_TYPE = eINSTANCE.getHydroPowerPlant_HydroPlantType();

		/**
		 * The meta object literal for the '<em><b>Penstock Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__PENSTOCK_TYPE = eINSTANCE.getHydroPowerPlant_PenstockType();

		/**
		 * The meta object literal for the '<em><b>Plant Discharge Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__PLANT_DISCHARGE_CAPACITY = eINSTANCE.getHydroPowerPlant_PlantDischargeCapacity();

		/**
		 * The meta object literal for the '<em><b>Plant MW Gen Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__PLANT_MW_GEN_RATING = eINSTANCE.getHydroPowerPlant_PlantMWGenRating();

		/**
		 * The meta object literal for the '<em><b>Plant MW Pump Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__PLANT_MW_PUMP_RATING = eINSTANCE.getHydroPowerPlant_PlantMWPumpRating();

		/**
		 * The meta object literal for the '<em><b>Plant Rated Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__PLANT_RATED_HEAD = eINSTANCE.getHydroPowerPlant_PlantRatedHead();

		/**
		 * The meta object literal for the '<em><b>Surge Tank Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__SURGE_TANK_CODE = eINSTANCE.getHydroPowerPlant_SurgeTankCode();

		/**
		 * The meta object literal for the '<em><b>Surge Tank Crest Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_POWER_PLANT__SURGE_TANK_CREST_LEVEL = eINSTANCE.getHydroPowerPlant_SurgeTankCrestLevel();

		/**
		 * The meta object literal for the '<em><b>Contain Hydro Generating Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_POWER_PLANT__CONTAIN_HYDRO_GENERATING_UNITS = eINSTANCE.getHydroPowerPlant_Contain_HydroGeneratingUnits();

		/**
		 * The meta object literal for the '<em><b>Contain Hydro Pumps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_POWER_PLANT__CONTAIN_HYDRO_PUMPS = eINSTANCE.getHydroPowerPlant_Contain_HydroPumps();

		/**
		 * The meta object literal for the '<em><b>Reservoir</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_POWER_PLANT__RESERVOIR = eINSTANCE.getHydroPowerPlant_Reservoir();

		/**
		 * The meta object literal for the '<em><b>Gen Source Pump Discharge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_POWER_PLANT__GEN_SOURCE_PUMP_DISCHARGE = eINSTANCE.getHydroPowerPlant_GenSourcePumpDischarge();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl <em>Hydro Generating Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingUnitImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroGeneratingUnit()
		 * @generated
		 */
		EClass HYDRO_GENERATING_UNIT = eINSTANCE.getHydroGeneratingUnit();

		/**
		 * The meta object literal for the '<em><b>Hydro Unit Water Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYDRO_GENERATING_UNIT__HYDRO_UNIT_WATER_COST = eINSTANCE.getHydroGeneratingUnit_HydroUnitWaterCost();

		/**
		 * The meta object literal for the '<em><b>Hydro Generating Efficiency Curves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_GENERATING_UNIT__HYDRO_GENERATING_EFFICIENCY_CURVES = eINSTANCE.getHydroGeneratingUnit_HydroGeneratingEfficiencyCurves();

		/**
		 * The meta object literal for the '<em><b>Penstock Loss Curve</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_GENERATING_UNIT__PENSTOCK_LOSS_CURVE = eINSTANCE.getHydroGeneratingUnit_PenstockLossCurve();

		/**
		 * The meta object literal for the '<em><b>Tailbay Loss Curve</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYDRO_GENERATING_UNIT__TAILBAY_LOSS_CURVE = eINSTANCE.getHydroGeneratingUnit_TailbayLossCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingEfficiencyCurveImpl <em>Hydro Generating Efficiency Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HydroGeneratingEfficiencyCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHydroGeneratingEfficiencyCurve()
		 * @generated
		 */
		EClass HYDRO_GENERATING_EFFICIENCY_CURVE = eINSTANCE.getHydroGeneratingEfficiencyCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HeatRateCurveImpl <em>Heat Rate Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HeatRateCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHeatRateCurve()
		 * @generated
		 */
		EClass HEAT_RATE_CURVE = eINSTANCE.getHeatRateCurve();

		/**
		 * The meta object literal for the '<em><b>Net Gross MW Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEAT_RATE_CURVE__NET_GROSS_MW_FLAG = eINSTANCE.getHeatRateCurve_NetGrossMWFlag();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl <em>Heat Input Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getHeatInputCurve()
		 * @generated
		 */
		EClass HEAT_INPUT_CURVE = eINSTANCE.getHeatInputCurve();

		/**
		 * The meta object literal for the '<em><b>Aux Power Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEAT_INPUT_CURVE__AUX_POWER_OFFSET = eINSTANCE.getHeatInputCurve_AuxPowerOffset();

		/**
		 * The meta object literal for the '<em><b>Aux Power Mult</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEAT_INPUT_CURVE__AUX_POWER_MULT = eINSTANCE.getHeatInputCurve_AuxPowerMult();

		/**
		 * The meta object literal for the '<em><b>Heat Input Eff</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEAT_INPUT_CURVE__HEAT_INPUT_EFF = eINSTANCE.getHeatInputCurve_HeatInputEff();

		/**
		 * The meta object literal for the '<em><b>Heat Input Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET = eINSTANCE.getHeatInputCurve_HeatInputOffset();

		/**
		 * The meta object literal for the '<em><b>Net Gross MW Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG = eINSTANCE.getHeatInputCurve_NetGrossMWFlag();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.GrossToNetMWCurveImpl <em>Gross To Net MW Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.GrossToNetMWCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGrossToNetMWCurve()
		 * @generated
		 */
		EClass GROSS_TO_NET_MW_CURVE = eINSTANCE.getGrossToNetMWCurve();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.GenUnitOpScheduleImpl <em>Gen Unit Op Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.GenUnitOpScheduleImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGenUnitOpSchedule()
		 * @generated
		 */
		EClass GEN_UNIT_OP_SCHEDULE = eINSTANCE.getGenUnitOpSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.GenUnitOpCostCurveImpl <em>Gen Unit Op Cost Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.GenUnitOpCostCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGenUnitOpCostCurve()
		 * @generated
		 */
		EClass GEN_UNIT_OP_COST_CURVE = eINSTANCE.getGenUnitOpCostCurve();

		/**
		 * The meta object literal for the '<em><b>Net Gross MW Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_UNIT_OP_COST_CURVE__NET_GROSS_MW_FLAG = eINSTANCE.getGenUnitOpCostCurve_NetGrossMWFlag();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl <em>Generating Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getGeneratingUnit()
		 * @generated
		 */
		EClass GENERATING_UNIT = eINSTANCE.getGeneratingUnit();

		/**
		 * The meta object literal for the '<em><b>Control Deadband</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__CONTROL_DEADBAND = eINSTANCE.getGeneratingUnit_ControlDeadband();

		/**
		 * The meta object literal for the '<em><b>Control Pulse High</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__CONTROL_PULSE_HIGH = eINSTANCE.getGeneratingUnit_ControlPulseHigh();

		/**
		 * The meta object literal for the '<em><b>Control Pulse Low</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__CONTROL_PULSE_LOW = eINSTANCE.getGeneratingUnit_ControlPulseLow();

		/**
		 * The meta object literal for the '<em><b>Control Response Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__CONTROL_RESPONSE_RATE = eINSTANCE.getGeneratingUnit_ControlResponseRate();

		/**
		 * The meta object literal for the '<em><b>Efficiency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__EFFICIENCY = eINSTANCE.getGeneratingUnit_Efficiency();

		/**
		 * The meta object literal for the '<em><b>Gen Control Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__GEN_CONTROL_MODE = eINSTANCE.getGeneratingUnit_GenControlMode();

		/**
		 * The meta object literal for the '<em><b>Gen Control Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__GEN_CONTROL_SOURCE = eINSTANCE.getGeneratingUnit_GenControlSource();

		/**
		 * The meta object literal for the '<em><b>Governor MPL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__GOVERNOR_MPL = eINSTANCE.getGeneratingUnit_GovernorMPL();

		/**
		 * The meta object literal for the '<em><b>Governor SCD</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__GOVERNOR_SCD = eINSTANCE.getGeneratingUnit_GovernorSCD();

		/**
		 * The meta object literal for the '<em><b>High Control Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__HIGH_CONTROL_LIMIT = eINSTANCE.getGeneratingUnit_HighControlLimit();

		/**
		 * The meta object literal for the '<em><b>Initial MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__INITIAL_MW = eINSTANCE.getGeneratingUnit_InitialMW();

		/**
		 * The meta object literal for the '<em><b>Low Control Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__LOW_CONTROL_LIMIT = eINSTANCE.getGeneratingUnit_LowControlLimit();

		/**
		 * The meta object literal for the '<em><b>Maximum Allowable Spinning Reserve</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE = eINSTANCE.getGeneratingUnit_MaximumAllowableSpinningReserve();

		/**
		 * The meta object literal for the '<em><b>Maximum Economic MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MAXIMUM_ECONOMIC_MW = eINSTANCE.getGeneratingUnit_MaximumEconomicMW();

		/**
		 * The meta object literal for the '<em><b>Maximum Operating MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MAXIMUM_OPERATING_MW = eINSTANCE.getGeneratingUnit_MaximumOperatingMW();

		/**
		 * The meta object literal for the '<em><b>Minimum Economic MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MINIMUM_ECONOMIC_MW = eINSTANCE.getGeneratingUnit_MinimumEconomicMW();

		/**
		 * The meta object literal for the '<em><b>Minimum Operating MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MINIMUM_OPERATING_MW = eINSTANCE.getGeneratingUnit_MinimumOperatingMW();

		/**
		 * The meta object literal for the '<em><b>Model Detail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MODEL_DETAIL = eINSTANCE.getGeneratingUnit_ModelDetail();

		/**
		 * The meta object literal for the '<em><b>Rated Gross Max MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__RATED_GROSS_MAX_MW = eINSTANCE.getGeneratingUnit_RatedGrossMaxMW();

		/**
		 * The meta object literal for the '<em><b>Rated Gross Min MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__RATED_GROSS_MIN_MW = eINSTANCE.getGeneratingUnit_RatedGrossMinMW();

		/**
		 * The meta object literal for the '<em><b>Rated Net Max MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__RATED_NET_MAX_MW = eINSTANCE.getGeneratingUnit_RatedNetMaxMW();

		/**
		 * The meta object literal for the '<em><b>Startup Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__STARTUP_TIME = eINSTANCE.getGeneratingUnit_StartupTime();

		/**
		 * The meta object literal for the '<em><b>Auto Cntrl Margin MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW = eINSTANCE.getGeneratingUnit_AutoCntrlMarginMW();

		/**
		 * The meta object literal for the '<em><b>Alloc Spin Res MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__ALLOC_SPIN_RES_MW = eINSTANCE.getGeneratingUnit_AllocSpinResMW();

		/**
		 * The meta object literal for the '<em><b>Base MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__BASE_MW = eINSTANCE.getGeneratingUnit_BaseMW();

		/**
		 * The meta object literal for the '<em><b>Disp Reserve Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__DISP_RESERVE_FLAG = eINSTANCE.getGeneratingUnit_DispReserveFlag();

		/**
		 * The meta object literal for the '<em><b>Energy Min MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__ENERGY_MIN_MW = eINSTANCE.getGeneratingUnit_EnergyMinMW();

		/**
		 * The meta object literal for the '<em><b>Fast Start Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__FAST_START_FLAG = eINSTANCE.getGeneratingUnit_FastStartFlag();

		/**
		 * The meta object literal for the '<em><b>Fuel Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__FUEL_PRIORITY = eINSTANCE.getGeneratingUnit_FuelPriority();

		/**
		 * The meta object literal for the '<em><b>Gen Operating Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__GEN_OPERATING_MODE = eINSTANCE.getGeneratingUnit_GenOperatingMode();

		/**
		 * The meta object literal for the '<em><b>Long PF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__LONG_PF = eINSTANCE.getGeneratingUnit_LongPF();

		/**
		 * The meta object literal for the '<em><b>Lower Ramp Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__LOWER_RAMP_RATE = eINSTANCE.getGeneratingUnit_LowerRampRate();

		/**
		 * The meta object literal for the '<em><b>Normal PF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__NORMAL_PF = eINSTANCE.getGeneratingUnit_NormalPF();

		/**
		 * The meta object literal for the '<em><b>Penalty Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__PENALTY_FACTOR = eINSTANCE.getGeneratingUnit_PenaltyFactor();

		/**
		 * The meta object literal for the '<em><b>Raise Ramp Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__RAISE_RAMP_RATE = eINSTANCE.getGeneratingUnit_RaiseRampRate();

		/**
		 * The meta object literal for the '<em><b>Short PF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__SHORT_PF = eINSTANCE.getGeneratingUnit_ShortPF();

		/**
		 * The meta object literal for the '<em><b>Spin Reserve Ramp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__SPIN_RESERVE_RAMP = eINSTANCE.getGeneratingUnit_SpinReserveRamp();

		/**
		 * The meta object literal for the '<em><b>Step Change</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__STEP_CHANGE = eINSTANCE.getGeneratingUnit_StepChange();

		/**
		 * The meta object literal for the '<em><b>Tie Line PF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__TIE_LINE_PF = eINSTANCE.getGeneratingUnit_TieLinePF();

		/**
		 * The meta object literal for the '<em><b>Minimum Off Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATING_UNIT__MINIMUM_OFF_TIME = eINSTANCE.getGeneratingUnit_MinimumOffTime();

		/**
		 * The meta object literal for the '<em><b>Gen Unit Op Cost Curves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES = eINSTANCE.getGeneratingUnit_GenUnitOpCostCurves();

		/**
		 * The meta object literal for the '<em><b>Gen Unit Op Schedule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE = eINSTANCE.getGeneratingUnit_GenUnitOpSchedule();

		/**
		 * The meta object literal for the '<em><b>Gross To Net MW Curves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATING_UNIT__GROSS_TO_NET_MW_CURVES = eINSTANCE.getGeneratingUnit_GrossToNetMWCurves();

		/**
		 * The meta object literal for the '<em><b>Sub Control Area</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATING_UNIT__SUB_CONTROL_AREA = eINSTANCE.getGeneratingUnit_SubControlArea();

		/**
		 * The meta object literal for the '<em><b>Synchronous Machines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATING_UNIT__SYNCHRONOUS_MACHINES = eINSTANCE.getGeneratingUnit_SynchronousMachines();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl <em>Fuel Allocation Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getFuelAllocationSchedule()
		 * @generated
		 */
		EClass FUEL_ALLOCATION_SCHEDULE = eINSTANCE.getFuelAllocationSchedule();

		/**
		 * The meta object literal for the '<em><b>Fuel Allocation End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE = eINSTANCE.getFuelAllocationSchedule_FuelAllocationEndDate();

		/**
		 * The meta object literal for the '<em><b>Fuel Allocation Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE = eINSTANCE.getFuelAllocationSchedule_FuelAllocationStartDate();

		/**
		 * The meta object literal for the '<em><b>Fuel Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE = eINSTANCE.getFuelAllocationSchedule_FuelType();

		/**
		 * The meta object literal for the '<em><b>Max Fuel Allocation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION = eINSTANCE.getFuelAllocationSchedule_MaxFuelAllocation();

		/**
		 * The meta object literal for the '<em><b>Min Fuel Allocation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION = eINSTANCE.getFuelAllocationSchedule_MinFuelAllocation();

		/**
		 * The meta object literal for the '<em><b>Fossil Fuel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL = eINSTANCE.getFuelAllocationSchedule_FossilFuel();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl <em>Fossil Fuel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.FossilFuelImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getFossilFuel()
		 * @generated
		 */
		EClass FOSSIL_FUEL = eINSTANCE.getFossilFuel();

		/**
		 * The meta object literal for the '<em><b>Fossil Fuel Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FOSSIL_FUEL_TYPE = eINSTANCE.getFossilFuel_FossilFuelType();

		/**
		 * The meta object literal for the '<em><b>Fuel Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_COST = eINSTANCE.getFossilFuel_FuelCost();

		/**
		 * The meta object literal for the '<em><b>Fuel Dispatch Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_DISPATCH_COST = eINSTANCE.getFossilFuel_FuelDispatchCost();

		/**
		 * The meta object literal for the '<em><b>Fuel Eff Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_EFF_FACTOR = eINSTANCE.getFossilFuel_FuelEffFactor();

		/**
		 * The meta object literal for the '<em><b>Fuel Handling Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_HANDLING_COST = eINSTANCE.getFossilFuel_FuelHandlingCost();

		/**
		 * The meta object literal for the '<em><b>Fuel Heat Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_HEAT_CONTENT = eINSTANCE.getFossilFuel_FuelHeatContent();

		/**
		 * The meta object literal for the '<em><b>Fuel Mixture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_MIXTURE = eINSTANCE.getFossilFuel_FuelMixture();

		/**
		 * The meta object literal for the '<em><b>Fuel Sulfur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__FUEL_SULFUR = eINSTANCE.getFossilFuel_FuelSulfur();

		/**
		 * The meta object literal for the '<em><b>High MW Breakpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__HIGH_MW_BREAKPOINT = eINSTANCE.getFossilFuel_HighMWBreakpoint();

		/**
		 * The meta object literal for the '<em><b>Low MW Breakpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOSSIL_FUEL__LOW_MW_BREAKPOINT = eINSTANCE.getFossilFuel_LowMWBreakpoint();

		/**
		 * The meta object literal for the '<em><b>Fuel Allocation Schedule</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE = eINSTANCE.getFossilFuel_FuelAllocationSchedule();

		/**
		 * The meta object literal for the '<em><b>Thermal Generating Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOSSIL_FUEL__THERMAL_GENERATING_UNIT = eINSTANCE.getFossilFuel_ThermalGeneratingUnit();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl <em>Emission Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getEmissionCurve()
		 * @generated
		 */
		EClass EMISSION_CURVE = eINSTANCE.getEmissionCurve();

		/**
		 * The meta object literal for the '<em><b>Emission Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMISSION_CURVE__EMISSION_CONTENT = eINSTANCE.getEmissionCurve_EmissionContent();

		/**
		 * The meta object literal for the '<em><b>Emission Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMISSION_CURVE__EMISSION_TYPE = eINSTANCE.getEmissionCurve_EmissionType();

		/**
		 * The meta object literal for the '<em><b>Net Gross MW Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMISSION_CURVE__NET_GROSS_MW_FLAG = eINSTANCE.getEmissionCurve_NetGrossMWFlag();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.CombinedCyclePlantImpl <em>Combined Cycle Plant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.CombinedCyclePlantImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getCombinedCyclePlant()
		 * @generated
		 */
		EClass COMBINED_CYCLE_PLANT = eINSTANCE.getCombinedCyclePlant();

		/**
		 * The meta object literal for the '<em><b>Comb Cycle Plant Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBINED_CYCLE_PLANT__COMB_CYCLE_PLANT_RATING = eINSTANCE.getCombinedCyclePlant_CombCyclePlantRating();

		/**
		 * The meta object literal for the '<em><b>Contain Thermal Generating Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMBINED_CYCLE_PLANT__CONTAIN_THERMAL_GENERATING_UNITS = eINSTANCE.getCombinedCyclePlant_Contain_ThermalGeneratingUnits();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl <em>Cogeneration Plant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.CogenerationPlantImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getCogenerationPlant()
		 * @generated
		 */
		EClass COGENERATION_PLANT = eINSTANCE.getCogenerationPlant();

		/**
		 * The meta object literal for the '<em><b>Cogen HP Sendout Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COGENERATION_PLANT__COGEN_HP_SENDOUT_RATING = eINSTANCE.getCogenerationPlant_CogenHPSendoutRating();

		/**
		 * The meta object literal for the '<em><b>Cogen HP Steam Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COGENERATION_PLANT__COGEN_HP_STEAM_RATING = eINSTANCE.getCogenerationPlant_CogenHPSteamRating();

		/**
		 * The meta object literal for the '<em><b>Cogen LP Sendout Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COGENERATION_PLANT__COGEN_LP_SENDOUT_RATING = eINSTANCE.getCogenerationPlant_CogenLPSendoutRating();

		/**
		 * The meta object literal for the '<em><b>Cogen LP Steam Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COGENERATION_PLANT__COGEN_LP_STEAM_RATING = eINSTANCE.getCogenerationPlant_CogenLPSteamRating();

		/**
		 * The meta object literal for the '<em><b>Cogen Plant MW Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COGENERATION_PLANT__COGEN_PLANT_MW_RATING = eINSTANCE.getCogenerationPlant_CogenPlantMWRating();

		/**
		 * The meta object literal for the '<em><b>Contain Thermal Generating Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COGENERATION_PLANT__CONTAIN_THERMAL_GENERATING_UNITS = eINSTANCE.getCogenerationPlant_Contain_ThermalGeneratingUnits();

		/**
		 * The meta object literal for the '<em><b>Steam Sendout Schedule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COGENERATION_PLANT__STEAM_SENDOUT_SCHEDULE = eINSTANCE.getCogenerationPlant_SteamSendoutSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl <em>CAES Plant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.CAESPlantImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getCAESPlant()
		 * @generated
		 */
		EClass CAES_PLANT = eINSTANCE.getCAESPlant();

		/**
		 * The meta object literal for the '<em><b>Energy Storage Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAES_PLANT__ENERGY_STORAGE_CAPACITY = eINSTANCE.getCAESPlant_EnergyStorageCapacity();

		/**
		 * The meta object literal for the '<em><b>Rated Capacity MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAES_PLANT__RATED_CAPACITY_MW = eINSTANCE.getCAESPlant_RatedCapacityMW();

		/**
		 * The meta object literal for the '<em><b>Contain Air Compressor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAES_PLANT__CONTAIN_AIR_COMPRESSOR = eINSTANCE.getCAESPlant_Contain_AirCompressor();

		/**
		 * The meta object literal for the '<em><b>Contain Thermal Generating Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAES_PLANT__CONTAIN_THERMAL_GENERATING_UNIT = eINSTANCE.getCAESPlant_Contain_ThermalGeneratingUnit();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.AirCompressorImpl <em>Air Compressor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.AirCompressorImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getAirCompressor()
		 * @generated
		 */
		EClass AIR_COMPRESSOR = eINSTANCE.getAirCompressor();

		/**
		 * The meta object literal for the '<em><b>Air Compressor Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_COMPRESSOR__AIR_COMPRESSOR_RATING = eINSTANCE.getAirCompressor_AirCompressorRating();

		/**
		 * The meta object literal for the '<em><b>Combustion Turbine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AIR_COMPRESSOR__COMBUSTION_TURBINE = eINSTANCE.getAirCompressor_CombustionTurbine();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.EmissionAccountImpl <em>Emission Account</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.EmissionAccountImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getEmissionAccount()
		 * @generated
		 */
		EClass EMISSION_ACCOUNT = eINSTANCE.getEmissionAccount();

		/**
		 * The meta object literal for the '<em><b>Emission Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMISSION_ACCOUNT__EMISSION_TYPE = eINSTANCE.getEmissionAccount_EmissionType();

		/**
		 * The meta object literal for the '<em><b>Emission Value Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMISSION_ACCOUNT__EMISSION_VALUE_SOURCE = eINSTANCE.getEmissionAccount_EmissionValueSource();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.production.impl.AccountBalanceImpl <em>Account Balance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.production.impl.AccountBalanceImpl
		 * @see org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl#getAccountBalance()
		 * @generated
		 */
		EClass ACCOUNT_BALANCE = eINSTANCE.getAccountBalance();

	}

} //ProductionPackage
