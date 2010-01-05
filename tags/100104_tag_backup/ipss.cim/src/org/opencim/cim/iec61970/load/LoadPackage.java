/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadPackage.java,v 1.4 2007/03/07 05:14:05 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.opencim.cim.iec61970.core.CorePackage;

import org.opencim.cim.iec61970.wire.WirePackage;

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
 * This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.
 * 
 * This information is used by Load Forecasting and Load Management.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.load.LoadFactory
 * @generated
 */
public interface LoadPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "load";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.interpss.cim.iec61976.load";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoadPackage eINSTANCE = org.opencim.cim.iec61970.load.impl.LoadPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl <em>Area Load Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getAreaLoadCurve()
	 * @generated
	 */
	int AREA_LOAD_CURVE = 0;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__LOAD_AREA = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Day Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__DAY_TYPE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Season</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE__SEASON = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Area Load Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOAD_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.AreaLossCurveImpl <em>Area Loss Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.AreaLossCurveImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getAreaLossCurve()
	 * @generated
	 */
	int AREA_LOSS_CURVE = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE__LOAD_AREA = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Area Loss Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOSS_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.CustomerMeterImpl <em>Customer Meter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.CustomerMeterImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getCustomerMeter()
	 * @generated
	 */
	int CUSTOMER_METER = 2;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__ALIAS_NAME = WirePackage.ENERGY_CONSUMER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__DESCRIPTION = WirePackage.ENERGY_CONSUMER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__NAME = WirePackage.ENERGY_CONSUMER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PATH_NAME = WirePackage.ENERGY_CONSUMER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__MRID = WirePackage.ENERGY_CONSUMER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__SIMU_MODEL = WirePackage.ENERGY_CONSUMER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__COMPANIES = WirePackage.ENERGY_CONSUMER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PSR_TYPE = WirePackage.ENERGY_CONSUMER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__EQUIPMENT_CONTAINER = WirePackage.ENERGY_CONSUMER__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PHASES = WirePackage.ENERGY_CONSUMER__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__TERMINALS = WirePackage.ENERGY_CONSUMER__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__BASE_VOLTAGE = WirePackage.ENERGY_CONSUMER__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__LOAD_DEMAND_MODELS = WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS;

	/**
	 * The feature id for the '<em><b>Non Conform Load Schedules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__NON_CONFORM_LOAD_SCHEDULES = WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__LOAD_AREA = WirePackage.ENERGY_CONSUMER__LOAD_AREA;

	/**
	 * The feature id for the '<em><b>Power Cut Zone</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__POWER_CUT_ZONE = WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE;

	/**
	 * The feature id for the '<em><b>Conforming Load Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__CONFORMING_LOAD_FLAG = WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG;

	/**
	 * The feature id for the '<em><b>Customer Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__CUSTOMER_COUNT = WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT;

	/**
	 * The feature id for the '<em><b>PFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PFEXP = WirePackage.ENERGY_CONSUMER__PFEXP;

	/**
	 * The feature id for the '<em><b>Pfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PFIXED = WirePackage.ENERGY_CONSUMER__PFIXED;

	/**
	 * The feature id for the '<em><b>Pfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PFIXED_PCT = WirePackage.ENERGY_CONSUMER__PFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Pnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PNOM = WirePackage.ENERGY_CONSUMER__PNOM;

	/**
	 * The feature id for the '<em><b>Pnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PNOM_PCT = WirePackage.ENERGY_CONSUMER__PNOM_PCT;

	/**
	 * The feature id for the '<em><b>Power Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__POWER_FACTOR = WirePackage.ENERGY_CONSUMER__POWER_FACTOR;

	/**
	 * The feature id for the '<em><b>PVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__PVEXP = WirePackage.ENERGY_CONSUMER__PVEXP;

	/**
	 * The feature id for the '<em><b>QFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__QFEXP = WirePackage.ENERGY_CONSUMER__QFEXP;

	/**
	 * The feature id for the '<em><b>Qfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__QFIXED = WirePackage.ENERGY_CONSUMER__QFIXED;

	/**
	 * The feature id for the '<em><b>Qfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__QFIXED_PCT = WirePackage.ENERGY_CONSUMER__QFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Qnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__QNOM = WirePackage.ENERGY_CONSUMER__QNOM;

	/**
	 * The feature id for the '<em><b>Qnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__QNOM_PCT = WirePackage.ENERGY_CONSUMER__QNOM_PCT;

	/**
	 * The feature id for the '<em><b>QVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER__QVEXP = WirePackage.ENERGY_CONSUMER__QVEXP;

	/**
	 * The number of structural features of the '<em>Customer Meter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_METER_FEATURE_COUNT = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.DayTypeImpl <em>Day Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.DayTypeImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getDayType()
	 * @generated
	 */
	int DAY_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Area Load Curves</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__AREA_LOAD_CURVES = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE__LOAD_DEMAND_MODELS = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Day Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_TYPE_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl <em>Equivalent Load</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getEquivalentLoad()
	 * @generated
	 */
	int EQUIVALENT_LOAD = 4;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__ALIAS_NAME = WirePackage.ENERGY_CONSUMER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__DESCRIPTION = WirePackage.ENERGY_CONSUMER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__NAME = WirePackage.ENERGY_CONSUMER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PATH_NAME = WirePackage.ENERGY_CONSUMER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__MRID = WirePackage.ENERGY_CONSUMER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__SIMU_MODEL = WirePackage.ENERGY_CONSUMER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__COMPANIES = WirePackage.ENERGY_CONSUMER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PSR_TYPE = WirePackage.ENERGY_CONSUMER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__EQUIPMENT_CONTAINER = WirePackage.ENERGY_CONSUMER__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PHASES = WirePackage.ENERGY_CONSUMER__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__TERMINALS = WirePackage.ENERGY_CONSUMER__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__BASE_VOLTAGE = WirePackage.ENERGY_CONSUMER__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__LOAD_DEMAND_MODELS = WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS;

	/**
	 * The feature id for the '<em><b>Non Conform Load Schedules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__NON_CONFORM_LOAD_SCHEDULES = WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__LOAD_AREA = WirePackage.ENERGY_CONSUMER__LOAD_AREA;

	/**
	 * The feature id for the '<em><b>Power Cut Zone</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__POWER_CUT_ZONE = WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE;

	/**
	 * The feature id for the '<em><b>Conforming Load Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__CONFORMING_LOAD_FLAG = WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG;

	/**
	 * The feature id for the '<em><b>Customer Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__CUSTOMER_COUNT = WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT;

	/**
	 * The feature id for the '<em><b>PFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PFEXP = WirePackage.ENERGY_CONSUMER__PFEXP;

	/**
	 * The feature id for the '<em><b>Pfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PFIXED = WirePackage.ENERGY_CONSUMER__PFIXED;

	/**
	 * The feature id for the '<em><b>Pfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PFIXED_PCT = WirePackage.ENERGY_CONSUMER__PFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Pnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PNOM = WirePackage.ENERGY_CONSUMER__PNOM;

	/**
	 * The feature id for the '<em><b>Pnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PNOM_PCT = WirePackage.ENERGY_CONSUMER__PNOM_PCT;

	/**
	 * The feature id for the '<em><b>Power Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__POWER_FACTOR = WirePackage.ENERGY_CONSUMER__POWER_FACTOR;

	/**
	 * The feature id for the '<em><b>PVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PVEXP = WirePackage.ENERGY_CONSUMER__PVEXP;

	/**
	 * The feature id for the '<em><b>QFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__QFEXP = WirePackage.ENERGY_CONSUMER__QFEXP;

	/**
	 * The feature id for the '<em><b>Qfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__QFIXED = WirePackage.ENERGY_CONSUMER__QFIXED;

	/**
	 * The feature id for the '<em><b>Qfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__QFIXED_PCT = WirePackage.ENERGY_CONSUMER__QFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Qnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__QNOM = WirePackage.ENERGY_CONSUMER__QNOM;

	/**
	 * The feature id for the '<em><b>Qnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__QNOM_PCT = WirePackage.ENERGY_CONSUMER__QNOM_PCT;

	/**
	 * The feature id for the '<em><b>QVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__QVEXP = WirePackage.ENERGY_CONSUMER__QVEXP;

	/**
	 * The feature id for the '<em><b>Feeder Load Mgt Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>MV Ar Cold Pick Up Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>MW Cold Pick Up Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Phase Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__PHASE_AMP_RATING = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Load Allocation Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Equivalent Load</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_LOAD_FEATURE_COUNT = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.InductionMotorLoadImpl <em>Induction Motor Load</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.InductionMotorLoadImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getInductionMotorLoad()
	 * @generated
	 */
	int INDUCTION_MOTOR_LOAD = 5;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__ALIAS_NAME = WirePackage.ENERGY_CONSUMER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__DESCRIPTION = WirePackage.ENERGY_CONSUMER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__NAME = WirePackage.ENERGY_CONSUMER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PATH_NAME = WirePackage.ENERGY_CONSUMER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__MRID = WirePackage.ENERGY_CONSUMER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__SIMU_MODEL = WirePackage.ENERGY_CONSUMER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__COMPANIES = WirePackage.ENERGY_CONSUMER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PSR_TYPE = WirePackage.ENERGY_CONSUMER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__EQUIPMENT_CONTAINER = WirePackage.ENERGY_CONSUMER__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PHASES = WirePackage.ENERGY_CONSUMER__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__TERMINALS = WirePackage.ENERGY_CONSUMER__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__BASE_VOLTAGE = WirePackage.ENERGY_CONSUMER__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__LOAD_DEMAND_MODELS = WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS;

	/**
	 * The feature id for the '<em><b>Non Conform Load Schedules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__NON_CONFORM_LOAD_SCHEDULES = WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__LOAD_AREA = WirePackage.ENERGY_CONSUMER__LOAD_AREA;

	/**
	 * The feature id for the '<em><b>Power Cut Zone</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__POWER_CUT_ZONE = WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE;

	/**
	 * The feature id for the '<em><b>Conforming Load Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__CONFORMING_LOAD_FLAG = WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG;

	/**
	 * The feature id for the '<em><b>Customer Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__CUSTOMER_COUNT = WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT;

	/**
	 * The feature id for the '<em><b>PFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PFEXP = WirePackage.ENERGY_CONSUMER__PFEXP;

	/**
	 * The feature id for the '<em><b>Pfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PFIXED = WirePackage.ENERGY_CONSUMER__PFIXED;

	/**
	 * The feature id for the '<em><b>Pfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PFIXED_PCT = WirePackage.ENERGY_CONSUMER__PFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Pnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PNOM = WirePackage.ENERGY_CONSUMER__PNOM;

	/**
	 * The feature id for the '<em><b>Pnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PNOM_PCT = WirePackage.ENERGY_CONSUMER__PNOM_PCT;

	/**
	 * The feature id for the '<em><b>Power Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__POWER_FACTOR = WirePackage.ENERGY_CONSUMER__POWER_FACTOR;

	/**
	 * The feature id for the '<em><b>PVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__PVEXP = WirePackage.ENERGY_CONSUMER__PVEXP;

	/**
	 * The feature id for the '<em><b>QFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__QFEXP = WirePackage.ENERGY_CONSUMER__QFEXP;

	/**
	 * The feature id for the '<em><b>Qfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__QFIXED = WirePackage.ENERGY_CONSUMER__QFIXED;

	/**
	 * The feature id for the '<em><b>Qfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__QFIXED_PCT = WirePackage.ENERGY_CONSUMER__QFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Qnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__QNOM = WirePackage.ENERGY_CONSUMER__QNOM;

	/**
	 * The feature id for the '<em><b>Qnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__QNOM_PCT = WirePackage.ENERGY_CONSUMER__QNOM_PCT;

	/**
	 * The feature id for the '<em><b>QVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD__QVEXP = WirePackage.ENERGY_CONSUMER__QVEXP;

	/**
	 * The number of structural features of the '<em>Induction Motor Load</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTION_MOTOR_LOAD_FEATURE_COUNT = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.LoadAreaImpl <em>Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.LoadAreaImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getLoadArea()
	 * @generated
	 */
	int LOAD_AREA = 6;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Energy Consumers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__ENERGY_CONSUMERS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Area Loss Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__AREA_LOSS_CURVES = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Area Load Curves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__AREA_LOAD_CURVES = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Substations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA__SUBSTATIONS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_AREA_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl <em>Demand Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getLoadDemandModel()
	 * @generated
	 */
	int LOAD_DEMAND_MODEL = 7;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Energy Consumer</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__ENERGY_CONSUMER = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Basis For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__BASIS_FOR = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Day Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL__DAY_TYPE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Demand Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_DEMAND_MODEL_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.NonConformLoadScheduleImpl <em>Non Conform Load Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.NonConformLoadScheduleImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getNonConformLoadSchedule()
	 * @generated
	 */
	int NON_CONFORM_LOAD_SCHEDULE = 8;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Energy Consumer</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Non Conform Load Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONFORM_LOAD_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.SeasonImpl <em>Season</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.SeasonImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getSeason()
	 * @generated
	 */
	int SEASON = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__NAME = 0;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__END_DATE = 1;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__START_DATE = 2;

	/**
	 * The feature id for the '<em><b>Area Load Curves</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__AREA_LOAD_CURVES = 3;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__LOAD_DEMAND_MODELS = 4;

	/**
	 * The number of structural features of the '<em>Season</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.StationSupplyImpl <em>Station Supply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.StationSupplyImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getStationSupply()
	 * @generated
	 */
	int STATION_SUPPLY = 10;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__ALIAS_NAME = WirePackage.ENERGY_CONSUMER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__DESCRIPTION = WirePackage.ENERGY_CONSUMER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__NAME = WirePackage.ENERGY_CONSUMER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PATH_NAME = WirePackage.ENERGY_CONSUMER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__MRID = WirePackage.ENERGY_CONSUMER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__SIMU_MODEL = WirePackage.ENERGY_CONSUMER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__COMPANIES = WirePackage.ENERGY_CONSUMER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PSR_TYPE = WirePackage.ENERGY_CONSUMER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__EQUIPMENT_CONTAINER = WirePackage.ENERGY_CONSUMER__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PHASES = WirePackage.ENERGY_CONSUMER__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__TERMINALS = WirePackage.ENERGY_CONSUMER__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__BASE_VOLTAGE = WirePackage.ENERGY_CONSUMER__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__LOAD_DEMAND_MODELS = WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS;

	/**
	 * The feature id for the '<em><b>Non Conform Load Schedules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__NON_CONFORM_LOAD_SCHEDULES = WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__LOAD_AREA = WirePackage.ENERGY_CONSUMER__LOAD_AREA;

	/**
	 * The feature id for the '<em><b>Power Cut Zone</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__POWER_CUT_ZONE = WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE;

	/**
	 * The feature id for the '<em><b>Conforming Load Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__CONFORMING_LOAD_FLAG = WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG;

	/**
	 * The feature id for the '<em><b>Customer Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__CUSTOMER_COUNT = WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT;

	/**
	 * The feature id for the '<em><b>PFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PFEXP = WirePackage.ENERGY_CONSUMER__PFEXP;

	/**
	 * The feature id for the '<em><b>Pfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PFIXED = WirePackage.ENERGY_CONSUMER__PFIXED;

	/**
	 * The feature id for the '<em><b>Pfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PFIXED_PCT = WirePackage.ENERGY_CONSUMER__PFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Pnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PNOM = WirePackage.ENERGY_CONSUMER__PNOM;

	/**
	 * The feature id for the '<em><b>Pnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PNOM_PCT = WirePackage.ENERGY_CONSUMER__PNOM_PCT;

	/**
	 * The feature id for the '<em><b>Power Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__POWER_FACTOR = WirePackage.ENERGY_CONSUMER__POWER_FACTOR;

	/**
	 * The feature id for the '<em><b>PVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__PVEXP = WirePackage.ENERGY_CONSUMER__PVEXP;

	/**
	 * The feature id for the '<em><b>QFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__QFEXP = WirePackage.ENERGY_CONSUMER__QFEXP;

	/**
	 * The feature id for the '<em><b>Qfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__QFIXED = WirePackage.ENERGY_CONSUMER__QFIXED;

	/**
	 * The feature id for the '<em><b>Qfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__QFIXED_PCT = WirePackage.ENERGY_CONSUMER__QFIXED_PCT;

	/**
	 * The feature id for the '<em><b>Qnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__QNOM = WirePackage.ENERGY_CONSUMER__QNOM;

	/**
	 * The feature id for the '<em><b>Qnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__QNOM_PCT = WirePackage.ENERGY_CONSUMER__QNOM_PCT;

	/**
	 * The feature id for the '<em><b>QVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY__QVEXP = WirePackage.ENERGY_CONSUMER__QVEXP;

	/**
	 * The number of structural features of the '<em>Station Supply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_SUPPLY_FEATURE_COUNT = WirePackage.ENERGY_CONSUMER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl <em>Power Cut Zone</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getPowerCutZone()
	 * @generated
	 */
	int POWER_CUT_ZONE = 11;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Cut Level1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__CUT_LEVEL1 = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cut Level2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__CUT_LEVEL2 = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Energy Consumers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE__ENERGY_CONSUMERS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Power Cut Zone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CUT_ZONE_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.load.impl.LoadModelVersionImpl <em>Model Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.load.impl.LoadModelVersionImpl
	 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getLoadModelVersion()
	 * @generated
	 */
	int LOAD_MODEL_VERSION = 12;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_MODEL_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_MODEL_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Model Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_MODEL_VERSION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.AreaLoadCurve <em>Area Load Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area Load Curve</em>'.
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve
	 * @generated
	 */
	EClass getAreaLoadCurve();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Load Area</em>'.
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve#getLoadArea()
	 * @see #getAreaLoadCurve()
	 * @generated
	 */
	EReference getAreaLoadCurve_LoadArea();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getDayType <em>Day Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Day Type</em>'.
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve#getDayType()
	 * @see #getAreaLoadCurve()
	 * @generated
	 */
	EReference getAreaLoadCurve_DayType();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getSeason <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Season</em>'.
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve#getSeason()
	 * @see #getAreaLoadCurve()
	 * @generated
	 */
	EReference getAreaLoadCurve_Season();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.AreaLossCurve <em>Area Loss Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area Loss Curve</em>'.
	 * @see org.opencim.cim.iec61970.load.AreaLossCurve
	 * @generated
	 */
	EClass getAreaLossCurve();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.load.AreaLossCurve#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Load Area</em>'.
	 * @see org.opencim.cim.iec61970.load.AreaLossCurve#getLoadArea()
	 * @see #getAreaLossCurve()
	 * @generated
	 */
	EReference getAreaLossCurve_LoadArea();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.CustomerMeter <em>Customer Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer Meter</em>'.
	 * @see org.opencim.cim.iec61970.load.CustomerMeter
	 * @generated
	 */
	EClass getCustomerMeter();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.DayType <em>Day Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Day Type</em>'.
	 * @see org.opencim.cim.iec61970.load.DayType
	 * @generated
	 */
	EClass getDayType();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.load.DayType#getAreaLoadCurves <em>Area Load Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Area Load Curves</em>'.
	 * @see org.opencim.cim.iec61970.load.DayType#getAreaLoadCurves()
	 * @see #getDayType()
	 * @generated
	 */
	EReference getDayType_AreaLoadCurves();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.load.DayType#getLoadDemandModels <em>Load Demand Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Load Demand Models</em>'.
	 * @see org.opencim.cim.iec61970.load.DayType#getLoadDemandModels()
	 * @see #getDayType()
	 * @generated
	 */
	EReference getDayType_LoadDemandModels();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.EquivalentLoad <em>Equivalent Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalent Load</em>'.
	 * @see org.opencim.cim.iec61970.load.EquivalentLoad
	 * @generated
	 */
	EClass getEquivalentLoad();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getFeederLoadMgtFactor <em>Feeder Load Mgt Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feeder Load Mgt Factor</em>'.
	 * @see org.opencim.cim.iec61970.load.EquivalentLoad#getFeederLoadMgtFactor()
	 * @see #getEquivalentLoad()
	 * @generated
	 */
	EAttribute getEquivalentLoad_FeederLoadMgtFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getMVArColdPickUpFactor <em>MV Ar Cold Pick Up Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MV Ar Cold Pick Up Factor</em>'.
	 * @see org.opencim.cim.iec61970.load.EquivalentLoad#getMVArColdPickUpFactor()
	 * @see #getEquivalentLoad()
	 * @generated
	 */
	EAttribute getEquivalentLoad_MVArColdPickUpFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getMWColdPickUpFactor <em>MW Cold Pick Up Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MW Cold Pick Up Factor</em>'.
	 * @see org.opencim.cim.iec61970.load.EquivalentLoad#getMWColdPickUpFactor()
	 * @see #getEquivalentLoad()
	 * @generated
	 */
	EAttribute getEquivalentLoad_MWColdPickUpFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getPhaseAmpRating <em>Phase Amp Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase Amp Rating</em>'.
	 * @see org.opencim.cim.iec61970.load.EquivalentLoad#getPhaseAmpRating()
	 * @see #getEquivalentLoad()
	 * @generated
	 */
	EAttribute getEquivalentLoad_PhaseAmpRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getLoadAllocationFactor <em>Load Allocation Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Allocation Factor</em>'.
	 * @see org.opencim.cim.iec61970.load.EquivalentLoad#getLoadAllocationFactor()
	 * @see #getEquivalentLoad()
	 * @generated
	 */
	EAttribute getEquivalentLoad_LoadAllocationFactor();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.InductionMotorLoad <em>Induction Motor Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Induction Motor Load</em>'.
	 * @see org.opencim.cim.iec61970.load.InductionMotorLoad
	 * @generated
	 */
	EClass getInductionMotorLoad();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.LoadArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadArea
	 * @generated
	 */
	EClass getLoadArea();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.load.LoadArea#getEnergyConsumers <em>Energy Consumers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Energy Consumers</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadArea#getEnergyConsumers()
	 * @see #getLoadArea()
	 * @generated
	 */
	EReference getLoadArea_EnergyConsumers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.load.LoadArea#getAreaLossCurves <em>Area Loss Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Area Loss Curves</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadArea#getAreaLossCurves()
	 * @see #getLoadArea()
	 * @generated
	 */
	EReference getLoadArea_AreaLossCurves();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.load.LoadArea#getAreaLoadCurves <em>Area Load Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Area Load Curves</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadArea#getAreaLoadCurves()
	 * @see #getLoadArea()
	 * @generated
	 */
	EReference getLoadArea_AreaLoadCurves();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.load.LoadArea#getSubstations <em>Substations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Substations</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadArea#getSubstations()
	 * @see #getLoadArea()
	 * @generated
	 */
	EReference getLoadArea_Substations();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.LoadDemandModel <em>Demand Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demand Model</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel
	 * @generated
	 */
	EClass getLoadDemandModel();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getEnergyConsumer <em>Energy Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Energy Consumer</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel#getEnergyConsumer()
	 * @see #getLoadDemandModel()
	 * @generated
	 */
	EReference getLoadDemandModel_EnergyConsumer();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getBasisFor <em>Basis For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Basis For</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel#getBasisFor()
	 * @see #getLoadDemandModel()
	 * @generated
	 */
	EReference getLoadDemandModel_BasisFor();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getDayType <em>Day Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Day Type</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel#getDayType()
	 * @see #getLoadDemandModel()
	 * @generated
	 */
	EReference getLoadDemandModel_DayType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.NonConformLoadSchedule <em>Non Conform Load Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Conform Load Schedule</em>'.
	 * @see org.opencim.cim.iec61970.load.NonConformLoadSchedule
	 * @generated
	 */
	EClass getNonConformLoadSchedule();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.load.NonConformLoadSchedule#getEnergyConsumer <em>Energy Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Energy Consumer</em>'.
	 * @see org.opencim.cim.iec61970.load.NonConformLoadSchedule#getEnergyConsumer()
	 * @see #getNonConformLoadSchedule()
	 * @generated
	 */
	EReference getNonConformLoadSchedule_EnergyConsumer();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.Season <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Season</em>'.
	 * @see org.opencim.cim.iec61970.load.Season
	 * @generated
	 */
	EClass getSeason();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.Season#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.opencim.cim.iec61970.load.Season#getName()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.Season#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see org.opencim.cim.iec61970.load.Season#getEndDate()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_EndDate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.Season#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see org.opencim.cim.iec61970.load.Season#getStartDate()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_StartDate();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.load.Season#getAreaLoadCurves <em>Area Load Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Area Load Curves</em>'.
	 * @see org.opencim.cim.iec61970.load.Season#getAreaLoadCurves()
	 * @see #getSeason()
	 * @generated
	 */
	EReference getSeason_AreaLoadCurves();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.load.Season#getLoadDemandModels <em>Load Demand Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Load Demand Models</em>'.
	 * @see org.opencim.cim.iec61970.load.Season#getLoadDemandModels()
	 * @see #getSeason()
	 * @generated
	 */
	EReference getSeason_LoadDemandModels();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.StationSupply <em>Station Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Station Supply</em>'.
	 * @see org.opencim.cim.iec61970.load.StationSupply
	 * @generated
	 */
	EClass getStationSupply();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.PowerCutZone <em>Power Cut Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Cut Zone</em>'.
	 * @see org.opencim.cim.iec61970.load.PowerCutZone
	 * @generated
	 */
	EClass getPowerCutZone();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel1 <em>Cut Level1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cut Level1</em>'.
	 * @see org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel1()
	 * @see #getPowerCutZone()
	 * @generated
	 */
	EAttribute getPowerCutZone_CutLevel1();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel2 <em>Cut Level2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cut Level2</em>'.
	 * @see org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel2()
	 * @see #getPowerCutZone()
	 * @generated
	 */
	EAttribute getPowerCutZone_CutLevel2();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.load.PowerCutZone#getEnergyConsumers <em>Energy Consumers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Energy Consumers</em>'.
	 * @see org.opencim.cim.iec61970.load.PowerCutZone#getEnergyConsumers()
	 * @see #getPowerCutZone()
	 * @generated
	 */
	EReference getPowerCutZone_EnergyConsumers();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.load.LoadModelVersion <em>Model Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Version</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadModelVersion
	 * @generated
	 */
	EClass getLoadModelVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.LoadModelVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadModelVersion#getVersion()
	 * @see #getLoadModelVersion()
	 * @generated
	 */
	EAttribute getLoadModelVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.load.LoadModelVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.load.LoadModelVersion#getDate()
	 * @see #getLoadModelVersion()
	 * @generated
	 */
	EAttribute getLoadModelVersion_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LoadFactory getLoadFactory();

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
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl <em>Area Load Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.AreaLoadCurveImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getAreaLoadCurve()
		 * @generated
		 */
		EClass AREA_LOAD_CURVE = eINSTANCE.getAreaLoadCurve();

		/**
		 * The meta object literal for the '<em><b>Load Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_LOAD_CURVE__LOAD_AREA = eINSTANCE.getAreaLoadCurve_LoadArea();

		/**
		 * The meta object literal for the '<em><b>Day Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_LOAD_CURVE__DAY_TYPE = eINSTANCE.getAreaLoadCurve_DayType();

		/**
		 * The meta object literal for the '<em><b>Season</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_LOAD_CURVE__SEASON = eINSTANCE.getAreaLoadCurve_Season();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.AreaLossCurveImpl <em>Area Loss Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.AreaLossCurveImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getAreaLossCurve()
		 * @generated
		 */
		EClass AREA_LOSS_CURVE = eINSTANCE.getAreaLossCurve();

		/**
		 * The meta object literal for the '<em><b>Load Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_LOSS_CURVE__LOAD_AREA = eINSTANCE.getAreaLossCurve_LoadArea();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.CustomerMeterImpl <em>Customer Meter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.CustomerMeterImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getCustomerMeter()
		 * @generated
		 */
		EClass CUSTOMER_METER = eINSTANCE.getCustomerMeter();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.DayTypeImpl <em>Day Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.DayTypeImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getDayType()
		 * @generated
		 */
		EClass DAY_TYPE = eINSTANCE.getDayType();

		/**
		 * The meta object literal for the '<em><b>Area Load Curves</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAY_TYPE__AREA_LOAD_CURVES = eINSTANCE.getDayType_AreaLoadCurves();

		/**
		 * The meta object literal for the '<em><b>Load Demand Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAY_TYPE__LOAD_DEMAND_MODELS = eINSTANCE.getDayType_LoadDemandModels();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl <em>Equivalent Load</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getEquivalentLoad()
		 * @generated
		 */
		EClass EQUIVALENT_LOAD = eINSTANCE.getEquivalentLoad();

		/**
		 * The meta object literal for the '<em><b>Feeder Load Mgt Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR = eINSTANCE.getEquivalentLoad_FeederLoadMgtFactor();

		/**
		 * The meta object literal for the '<em><b>MV Ar Cold Pick Up Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR = eINSTANCE.getEquivalentLoad_MVArColdPickUpFactor();

		/**
		 * The meta object literal for the '<em><b>MW Cold Pick Up Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR = eINSTANCE.getEquivalentLoad_MWColdPickUpFactor();

		/**
		 * The meta object literal for the '<em><b>Phase Amp Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_LOAD__PHASE_AMP_RATING = eINSTANCE.getEquivalentLoad_PhaseAmpRating();

		/**
		 * The meta object literal for the '<em><b>Load Allocation Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR = eINSTANCE.getEquivalentLoad_LoadAllocationFactor();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.InductionMotorLoadImpl <em>Induction Motor Load</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.InductionMotorLoadImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getInductionMotorLoad()
		 * @generated
		 */
		EClass INDUCTION_MOTOR_LOAD = eINSTANCE.getInductionMotorLoad();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.LoadAreaImpl <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.LoadAreaImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getLoadArea()
		 * @generated
		 */
		EClass LOAD_AREA = eINSTANCE.getLoadArea();

		/**
		 * The meta object literal for the '<em><b>Energy Consumers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_AREA__ENERGY_CONSUMERS = eINSTANCE.getLoadArea_EnergyConsumers();

		/**
		 * The meta object literal for the '<em><b>Area Loss Curves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_AREA__AREA_LOSS_CURVES = eINSTANCE.getLoadArea_AreaLossCurves();

		/**
		 * The meta object literal for the '<em><b>Area Load Curves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_AREA__AREA_LOAD_CURVES = eINSTANCE.getLoadArea_AreaLoadCurves();

		/**
		 * The meta object literal for the '<em><b>Substations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_AREA__SUBSTATIONS = eINSTANCE.getLoadArea_Substations();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl <em>Demand Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.LoadDemandModelImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getLoadDemandModel()
		 * @generated
		 */
		EClass LOAD_DEMAND_MODEL = eINSTANCE.getLoadDemandModel();

		/**
		 * The meta object literal for the '<em><b>Energy Consumer</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_DEMAND_MODEL__ENERGY_CONSUMER = eINSTANCE.getLoadDemandModel_EnergyConsumer();

		/**
		 * The meta object literal for the '<em><b>Basis For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_DEMAND_MODEL__BASIS_FOR = eINSTANCE.getLoadDemandModel_BasisFor();

		/**
		 * The meta object literal for the '<em><b>Day Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_DEMAND_MODEL__DAY_TYPE = eINSTANCE.getLoadDemandModel_DayType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.NonConformLoadScheduleImpl <em>Non Conform Load Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.NonConformLoadScheduleImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getNonConformLoadSchedule()
		 * @generated
		 */
		EClass NON_CONFORM_LOAD_SCHEDULE = eINSTANCE.getNonConformLoadSchedule();

		/**
		 * The meta object literal for the '<em><b>Energy Consumer</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER = eINSTANCE.getNonConformLoadSchedule_EnergyConsumer();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.SeasonImpl <em>Season</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.SeasonImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getSeason()
		 * @generated
		 */
		EClass SEASON = eINSTANCE.getSeason();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__NAME = eINSTANCE.getSeason_Name();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__END_DATE = eINSTANCE.getSeason_EndDate();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__START_DATE = eINSTANCE.getSeason_StartDate();

		/**
		 * The meta object literal for the '<em><b>Area Load Curves</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEASON__AREA_LOAD_CURVES = eINSTANCE.getSeason_AreaLoadCurves();

		/**
		 * The meta object literal for the '<em><b>Load Demand Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEASON__LOAD_DEMAND_MODELS = eINSTANCE.getSeason_LoadDemandModels();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.StationSupplyImpl <em>Station Supply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.StationSupplyImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getStationSupply()
		 * @generated
		 */
		EClass STATION_SUPPLY = eINSTANCE.getStationSupply();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl <em>Power Cut Zone</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.PowerCutZoneImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getPowerCutZone()
		 * @generated
		 */
		EClass POWER_CUT_ZONE = eINSTANCE.getPowerCutZone();

		/**
		 * The meta object literal for the '<em><b>Cut Level1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_CUT_ZONE__CUT_LEVEL1 = eINSTANCE.getPowerCutZone_CutLevel1();

		/**
		 * The meta object literal for the '<em><b>Cut Level2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_CUT_ZONE__CUT_LEVEL2 = eINSTANCE.getPowerCutZone_CutLevel2();

		/**
		 * The meta object literal for the '<em><b>Energy Consumers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_CUT_ZONE__ENERGY_CONSUMERS = eINSTANCE.getPowerCutZone_EnergyConsumers();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.load.impl.LoadModelVersionImpl <em>Model Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.load.impl.LoadModelVersionImpl
		 * @see org.opencim.cim.iec61970.load.impl.LoadPackageImpl#getLoadModelVersion()
		 * @generated
		 */
		EClass LOAD_MODEL_VERSION = eINSTANCE.getLoadModelVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_MODEL_VERSION__VERSION = eINSTANCE.getLoadModelVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_MODEL_VERSION__DATE = eINSTANCE.getLoadModelVersion_Date();

	}

} //LoadPackage
