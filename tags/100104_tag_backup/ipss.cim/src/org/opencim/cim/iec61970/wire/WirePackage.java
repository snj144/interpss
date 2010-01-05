/**
 * <copyright>
 * </copyright>
 *
 * $Id: WirePackage.java,v 1.6 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

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
 * An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.  
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.wire.WireFactory
 * @generated
 */
public interface WirePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wire";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim.cim.iec61970.wire";

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
	WirePackage eINSTANCE = org.opencim.cim.iec61970.wire.impl.WirePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl <em>Conductor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.ConductorImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getConductor()
	 * @generated
	 */
	int CONDUCTOR = 4;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>B0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__B0CH = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__BCH = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>G0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__G0CH = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__GCH = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__LENGTH = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__R = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__R0 = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__X = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__X0 = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Conductor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR__CONDUCTOR_TYPE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Conductor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.ACLineSegmentImpl <em>AC Line Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.ACLineSegmentImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getACLineSegment()
	 * @generated
	 */
	int AC_LINE_SEGMENT = 0;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__ALIAS_NAME = CONDUCTOR__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__DESCRIPTION = CONDUCTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__NAME = CONDUCTOR__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__PATH_NAME = CONDUCTOR__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__MRID = CONDUCTOR__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__SIMU_MODEL = CONDUCTOR__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__COMPANIES = CONDUCTOR__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__PSR_TYPE = CONDUCTOR__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__EQUIPMENT_CONTAINER = CONDUCTOR__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__PHASES = CONDUCTOR__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__TERMINALS = CONDUCTOR__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__BASE_VOLTAGE = CONDUCTOR__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>B0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__B0CH = CONDUCTOR__B0CH;

	/**
	 * The feature id for the '<em><b>Bch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__BCH = CONDUCTOR__BCH;

	/**
	 * The feature id for the '<em><b>G0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__G0CH = CONDUCTOR__G0CH;

	/**
	 * The feature id for the '<em><b>Gch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__GCH = CONDUCTOR__GCH;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__LENGTH = CONDUCTOR__LENGTH;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__R = CONDUCTOR__R;

	/**
	 * The feature id for the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__R0 = CONDUCTOR__R0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__X = CONDUCTOR__X;

	/**
	 * The feature id for the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__X0 = CONDUCTOR__X0;

	/**
	 * The feature id for the '<em><b>Conductor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__CONDUCTOR_TYPE = CONDUCTOR__CONDUCTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT__LINE = CONDUCTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>AC Line Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_LINE_SEGMENT_FEATURE_COUNT = CONDUCTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.SwitchImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getSwitch()
	 * @generated
	 */
	int SWITCH = 15;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__NORMAL_OPEN = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__SWITCH_ON_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__SWITCH_ON_DATE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__COMPOSITE_SWITCH = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.BreakerImpl <em>Breaker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.BreakerImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getBreaker()
	 * @generated
	 */
	int BREAKER = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__ALIAS_NAME = SWITCH__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__DESCRIPTION = SWITCH__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__PATH_NAME = SWITCH__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__MRID = SWITCH__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__SIMU_MODEL = SWITCH__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__COMPANIES = SWITCH__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__PSR_TYPE = SWITCH__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__EQUIPMENT_CONTAINER = SWITCH__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__PHASES = SWITCH__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__TERMINALS = SWITCH__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__BASE_VOLTAGE = SWITCH__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__NORMAL_OPEN = SWITCH__NORMAL_OPEN;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__SWITCH_ON_COUNT = SWITCH__SWITCH_ON_COUNT;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__SWITCH_ON_DATE = SWITCH__SWITCH_ON_DATE;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__COMPOSITE_SWITCH = SWITCH__COMPOSITE_SWITCH;

	/**
	 * The feature id for the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__AMP_RATING = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Transit Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER__IN_TRANSIT_TIME = SWITCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Breaker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKER_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.ConnectorImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 30;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.BusbarSectionImpl <em>Busbar Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.BusbarSectionImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getBusbarSection()
	 * @generated
	 */
	int BUSBAR_SECTION = 2;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__ALIAS_NAME = CONNECTOR__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__DESCRIPTION = CONNECTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__NAME = CONNECTOR__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__PATH_NAME = CONNECTOR__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__MRID = CONNECTOR__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__SIMU_MODEL = CONNECTOR__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__COMPANIES = CONNECTOR__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__PSR_TYPE = CONNECTOR__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__EQUIPMENT_CONTAINER = CONNECTOR__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__PHASES = CONNECTOR__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__TERMINALS = CONNECTOR__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__BASE_VOLTAGE = CONNECTOR__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Voltage Control Zone</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION__VOLTAGE_CONTROL_ZONE = CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Busbar Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSBAR_SECTION_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.RegulatingCondEqImpl <em>Regulating Cond Eq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.RegulatingCondEqImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getRegulatingCondEq()
	 * @generated
	 */
	int REGULATING_COND_EQ = 31;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ__REGULATION_SCHEDULE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regulating Cond Eq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATING_COND_EQ_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl <em>Compensator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.CompensatorImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getCompensator()
	 * @generated
	 */
	int COMPENSATOR = 3;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__ALIAS_NAME = REGULATING_COND_EQ__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__DESCRIPTION = REGULATING_COND_EQ__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__NAME = REGULATING_COND_EQ__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__PATH_NAME = REGULATING_COND_EQ__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__MRID = REGULATING_COND_EQ__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__SIMU_MODEL = REGULATING_COND_EQ__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__COMPANIES = REGULATING_COND_EQ__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__PSR_TYPE = REGULATING_COND_EQ__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__EQUIPMENT_CONTAINER = REGULATING_COND_EQ__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__PHASES = REGULATING_COND_EQ__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__TERMINALS = REGULATING_COND_EQ__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__BASE_VOLTAGE = REGULATING_COND_EQ__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__REGULATION_SCHEDULE = REGULATING_COND_EQ__REGULATION_SCHEDULE;

	/**
	 * The feature id for the '<em><b>AVR Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__AVR_DELAY = REGULATING_COND_EQ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__IMPEDANCE = REGULATING_COND_EQ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Maximumk V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__MAXIMUMK_V = REGULATING_COND_EQ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Maximum Sections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__MAXIMUM_SECTIONS = REGULATING_COND_EQ_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Minimumk V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__MINIMUMK_V = REGULATING_COND_EQ_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>MV Ar Per Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__MV_AR_PER_SECTION = REGULATING_COND_EQ_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Nominalk V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__NOMINALK_V = REGULATING_COND_EQ_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Nominal MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__NOMINAL_MV_AR = REGULATING_COND_EQ_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Normal Sections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__NORMAL_SECTIONS = REGULATING_COND_EQ_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__R = REGULATING_COND_EQ_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__SWITCH_ON_COUNT = REGULATING_COND_EQ_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__SWITCH_ON_DATE = REGULATING_COND_EQ_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Volt Sensitivity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__VOLT_SENSITIVITY = REGULATING_COND_EQ_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__X = REGULATING_COND_EQ_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>YPer Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__YPER_SECTION = REGULATING_COND_EQ_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Compensator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR__COMPENSATOR_TYPE = REGULATING_COND_EQ_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Compensator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATOR_FEATURE_COUNT = REGULATING_COND_EQ_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl <em>Conductor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getConductorType()
	 * @generated
	 */
	int CONDUCTOR_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Sheath Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__SHEATH_RESISTANCE = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sheath Reactance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__SHEATH_REACTANCE = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conductors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__CONDUCTORS = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wire Arrangements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE__WIRE_ARRANGEMENTS = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Conductor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTOR_TYPE_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl <em>DC Line Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getDCLineSegment()
	 * @generated
	 */
	int DC_LINE_SEGMENT = 6;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__ALIAS_NAME = CONDUCTOR__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__DESCRIPTION = CONDUCTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__NAME = CONDUCTOR__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__PATH_NAME = CONDUCTOR__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__MRID = CONDUCTOR__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__SIMU_MODEL = CONDUCTOR__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__COMPANIES = CONDUCTOR__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__PSR_TYPE = CONDUCTOR__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__EQUIPMENT_CONTAINER = CONDUCTOR__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__PHASES = CONDUCTOR__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__TERMINALS = CONDUCTOR__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__BASE_VOLTAGE = CONDUCTOR__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>B0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__B0CH = CONDUCTOR__B0CH;

	/**
	 * The feature id for the '<em><b>Bch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__BCH = CONDUCTOR__BCH;

	/**
	 * The feature id for the '<em><b>G0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__G0CH = CONDUCTOR__G0CH;

	/**
	 * The feature id for the '<em><b>Gch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__GCH = CONDUCTOR__GCH;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__LENGTH = CONDUCTOR__LENGTH;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__R = CONDUCTOR__R;

	/**
	 * The feature id for the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__R0 = CONDUCTOR__R0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__X = CONDUCTOR__X;

	/**
	 * The feature id for the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__X0 = CONDUCTOR__X0;

	/**
	 * The feature id for the '<em><b>Conductor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__CONDUCTOR_TYPE = CONDUCTOR__CONDUCTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Dc Segment Inductance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE = CONDUCTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dc Segment Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE = CONDUCTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT__LINE = CONDUCTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DC Line Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_LINE_SEGMENT_FEATURE_COUNT = CONDUCTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.DisconnectorImpl <em>Disconnector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.DisconnectorImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getDisconnector()
	 * @generated
	 */
	int DISCONNECTOR = 7;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__ALIAS_NAME = SWITCH__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__DESCRIPTION = SWITCH__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__PATH_NAME = SWITCH__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__MRID = SWITCH__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__SIMU_MODEL = SWITCH__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__COMPANIES = SWITCH__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__PSR_TYPE = SWITCH__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__EQUIPMENT_CONTAINER = SWITCH__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__PHASES = SWITCH__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__TERMINALS = SWITCH__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__BASE_VOLTAGE = SWITCH__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__NORMAL_OPEN = SWITCH__NORMAL_OPEN;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__SWITCH_ON_COUNT = SWITCH__SWITCH_ON_COUNT;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__SWITCH_ON_DATE = SWITCH__SWITCH_ON_DATE;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR__COMPOSITE_SWITCH = SWITCH__COMPOSITE_SWITCH;

	/**
	 * The number of structural features of the '<em>Disconnector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTOR_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.FuseImpl <em>Fuse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.FuseImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getFuse()
	 * @generated
	 */
	int FUSE = 8;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__ALIAS_NAME = SWITCH__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__DESCRIPTION = SWITCH__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__PATH_NAME = SWITCH__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__MRID = SWITCH__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__SIMU_MODEL = SWITCH__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__COMPANIES = SWITCH__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__PSR_TYPE = SWITCH__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__EQUIPMENT_CONTAINER = SWITCH__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__PHASES = SWITCH__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__TERMINALS = SWITCH__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__BASE_VOLTAGE = SWITCH__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__NORMAL_OPEN = SWITCH__NORMAL_OPEN;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__SWITCH_ON_COUNT = SWITCH__SWITCH_ON_COUNT;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__SWITCH_ON_DATE = SWITCH__SWITCH_ON_DATE;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__COMPOSITE_SWITCH = SWITCH__COMPOSITE_SWITCH;

	/**
	 * The feature id for the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE__AMP_RATING = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fuse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSE_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.GroundImpl <em>Ground</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.GroundImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getGround()
	 * @generated
	 */
	int GROUND = 9;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The number of structural features of the '<em>Ground</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.HeatExchangerImpl <em>Heat Exchanger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.HeatExchangerImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getHeatExchanger()
	 * @generated
	 */
	int HEAT_EXCHANGER = 10;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__ALIAS_NAME = CorePackage.EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__DESCRIPTION = CorePackage.EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__NAME = CorePackage.EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__PATH_NAME = CorePackage.EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__MRID = CorePackage.EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__SIMU_MODEL = CorePackage.EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__COMPANIES = CorePackage.EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__PSR_TYPE = CorePackage.EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__EQUIPMENT_CONTAINER = CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The number of structural features of the '<em>Heat Exchanger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER_FEATURE_COUNT = CorePackage.EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.JumperImpl <em>Jumper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.JumperImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getJumper()
	 * @generated
	 */
	int JUMPER = 11;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__ALIAS_NAME = SWITCH__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__DESCRIPTION = SWITCH__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__PATH_NAME = SWITCH__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__MRID = SWITCH__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__SIMU_MODEL = SWITCH__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__COMPANIES = SWITCH__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__PSR_TYPE = SWITCH__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__EQUIPMENT_CONTAINER = SWITCH__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__PHASES = SWITCH__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__TERMINALS = SWITCH__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__BASE_VOLTAGE = SWITCH__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__NORMAL_OPEN = SWITCH__NORMAL_OPEN;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__SWITCH_ON_COUNT = SWITCH__SWITCH_ON_COUNT;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__SWITCH_ON_DATE = SWITCH__SWITCH_ON_DATE;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER__COMPOSITE_SWITCH = SWITCH__COMPOSITE_SWITCH;

	/**
	 * The number of structural features of the '<em>Jumper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUMPER_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl <em>Rectifier Inverter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getRectifierInverter()
	 * @generated
	 */
	int RECTIFIER_INVERTER = 12;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Rated KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__RATED_KV = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bridges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__BRIDGES = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Commutating Reactance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__COMMUTATING_REACTANCE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Commutating Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__COMMUTATING_RESISTANCE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Compound Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__COMPOUND_RESISTANCE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Min Compound Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__FREQUENCY = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Maximum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__MAXIMUM_MW = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Minimum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__MINIMUM_MW = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Maximum KV</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__MAXIMUM_KV = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Minimum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__MINIMUM_KV = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER__OPERATING_MODE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Rectifier Inverter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTIFIER_INVERTER_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl <em>Regulation Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getRegulationSchedule()
	 * @generated
	 */
	int REGULATION_SCHEDULE = 13;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Line Drop Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__LINE_DROP_COMPENSATION = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line Drop R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__LINE_DROP_R = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line Drop X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__LINE_DROP_X = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Voltage Control Zones</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Regulating Cond Eqs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__REGULATING_COND_EQS = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tap Changers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE__TAP_CHANGERS = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Regulation Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_SCHEDULE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl <em>Static Var Compensator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getStaticVarCompensator()
	 * @generated
	 */
	int STATIC_VAR_COMPENSATOR = 14;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__ALIAS_NAME = REGULATING_COND_EQ__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__DESCRIPTION = REGULATING_COND_EQ__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__NAME = REGULATING_COND_EQ__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__PATH_NAME = REGULATING_COND_EQ__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__MRID = REGULATING_COND_EQ__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__SIMU_MODEL = REGULATING_COND_EQ__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__COMPANIES = REGULATING_COND_EQ__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__PSR_TYPE = REGULATING_COND_EQ__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__EQUIPMENT_CONTAINER = REGULATING_COND_EQ__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__PHASES = REGULATING_COND_EQ__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__TERMINALS = REGULATING_COND_EQ__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__BASE_VOLTAGE = REGULATING_COND_EQ__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__REGULATION_SCHEDULE = REGULATING_COND_EQ__REGULATION_SCHEDULE;

	/**
	 * The feature id for the '<em><b>Capacitive Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING = REGULATING_COND_EQ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inductive Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING = REGULATING_COND_EQ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SVC Control Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE = REGULATING_COND_EQ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__SLOPE = REGULATING_COND_EQ_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Voltage Set Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT = REGULATING_COND_EQ_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Static Var Compensator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VAR_COMPENSATOR_FEATURE_COUNT = REGULATING_COND_EQ_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl <em>Tap Changer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.TapChangerImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getTapChanger()
	 * @generated
	 */
	int TAP_CHANGER = 16;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>High Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__HIGH_STEP = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__INITIAL_DELAY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Low Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__LOW_STEP = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Neutral KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__NEUTRAL_KV = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Neutral Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__NEUTRAL_STEP = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Normal Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__NORMAL_STEP = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Step Phase Shift Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Step Voltage Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__STEP_VOLTAGE_INCREMENT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Subsequent Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__SUBSEQUENT_DELAY = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Tcul Control Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__TCUL_CONTROL_MODE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER__REGULATION_SCHEDULE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Tap Changer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_CHANGER_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl <em>Power Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getPowerTransformer()
	 * @generated
	 */
	int POWER_TRANSFORMER = 17;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__ALIAS_NAME = CorePackage.EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__DESCRIPTION = CorePackage.EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__NAME = CorePackage.EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__PATH_NAME = CorePackage.EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__MRID = CorePackage.EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__SIMU_MODEL = CorePackage.EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__COMPANIES = CorePackage.EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__PSR_TYPE = CorePackage.EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__EQUIPMENT_CONTAINER = CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Bmag Sat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__BMAG_SAT = CorePackage.EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mag Base KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__MAG_BASE_KV = CorePackage.EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mag Sat Flux</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__MAG_SAT_FLUX = CorePackage.EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__PHASES = CorePackage.EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transf Cooling Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__TRANSF_COOLING_TYPE = CorePackage.EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Transformer Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__TRANSFORMER_TYPE = CorePackage.EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Heat Exchanger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__HEAT_EXCHANGER = CorePackage.EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Transformer Windings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER__TRANSFORMER_WINDINGS = CorePackage.EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Power Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSFORMER_FEATURE_COUNT = CorePackage.EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl <em>Transformer Winding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getTransformerWinding()
	 * @generated
	 */
	int TRANSFORMER_WINDING = 18;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__B = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Insulation KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__INSULATION_KV = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__CONNECTION_TYPE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Emergency MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__EMERGENCY_MVA = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__G = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Grounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__GROUNDED = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__R = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__R0 = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Rated KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__RATED_KV = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Rated MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__RATED_MVA = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Rground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__RGROUND = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Short Term MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__SHORT_TERM_MVA = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Winding Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__WINDING_TYPE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__X = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__X0 = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Xground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__XGROUND = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Power Transformer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__POWER_TRANSFORMER = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Tap Changers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__TAP_CHANGERS = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>From Winding Tests</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__FROM_WINDING_TESTS = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>To Winding Test</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING__TO_WINDING_TEST = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>Transformer Winding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMER_WINDING_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 20;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.LineImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getLine()
	 * @generated
	 */
	int LINE = 19;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>AC Line Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__AC_LINE_SEGMENTS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>DC Line Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__DC_LINE_SEGMENTS = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.VoltageControlZoneImpl <em>Voltage Control Zone</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.VoltageControlZoneImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getVoltageControlZone()
	 * @generated
	 */
	int VOLTAGE_CONTROL_ZONE = 20;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__ALIAS_NAME = CorePackage.POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__DESCRIPTION = CorePackage.POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__NAME = CorePackage.POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__PATH_NAME = CorePackage.POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__MRID = CorePackage.POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__SIMU_MODEL = CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__COMPANIES = CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__PSR_TYPE = CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Busbar Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Voltage Control Zone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_CONTROL_ZONE_FEATURE_COUNT = CorePackage.POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl <em>Winding Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.WindingTestImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWindingTest()
	 * @generated
	 */
	int WINDING_TEST = 21;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Exciting Current</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__EXCITING_CURRENT = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Tap Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__FROM_TAP_STEP = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Leakage Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__LEAKAGE_IMPEDANCE = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Load Loss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__LOAD_LOSS = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>No Load Loss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__NO_LOAD_LOSS = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Phase Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__PHASE_SHIFT = CorePackage.NAMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>To Tap Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__TO_TAP_STEP = CorePackage.NAMING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__VOLTAGE = CorePackage.NAMING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>From Transformer Winding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__FROM_TRANSFORMER_WINDING = CorePackage.NAMING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>To Transforme Windings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST__TO_TRANSFORME_WINDINGS = CorePackage.NAMING_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Winding Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDING_TEST_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl <em>Synchronous Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getSynchronousMachine()
	 * @generated
	 */
	int SYNCHRONOUS_MACHINE = 22;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__ALIAS_NAME = REGULATING_COND_EQ__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__DESCRIPTION = REGULATING_COND_EQ__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__NAME = REGULATING_COND_EQ__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__PATH_NAME = REGULATING_COND_EQ__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MRID = REGULATING_COND_EQ__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__SIMU_MODEL = REGULATING_COND_EQ__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__COMPANIES = REGULATING_COND_EQ__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__PSR_TYPE = REGULATING_COND_EQ__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__EQUIPMENT_CONTAINER = REGULATING_COND_EQ__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__PHASES = REGULATING_COND_EQ__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__TERMINALS = REGULATING_COND_EQ__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__BASE_VOLTAGE = REGULATING_COND_EQ__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__REGULATION_SCHEDULE = REGULATING_COND_EQ__REGULATION_SCHEDULE;

	/**
	 * The feature id for the '<em><b>AVR To Manual Lag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG = REGULATING_COND_EQ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>AVR To Manual Lead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD = REGULATING_COND_EQ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__BASE_MV_AR = REGULATING_COND_EQ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Coolant Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__COOLANT_CONDITION = REGULATING_COND_EQ_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Coolant Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__COOLANT_TYPE = REGULATING_COND_EQ_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__DAMPING = REGULATING_COND_EQ_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Inertia</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__INERTIA = REGULATING_COND_EQ_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Manual To AVR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MANUAL_TO_AVR = REGULATING_COND_EQ_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Maximum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MAXIMUM_KV = REGULATING_COND_EQ_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Maximum MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR = REGULATING_COND_EQ_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Minimum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MINIMUM_KV = REGULATING_COND_EQ_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Minimum MV Ar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MINIMUM_MV_AR = REGULATING_COND_EQ_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__R = REGULATING_COND_EQ_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__R0 = REGULATING_COND_EQ_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Rated MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__RATED_MVA = REGULATING_COND_EQ_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__X = REGULATING_COND_EQ_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__X0 = REGULATING_COND_EQ_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>XDirect Subtrans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS = REGULATING_COND_EQ_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>XDirect Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__XDIRECT_SYNC = REGULATING_COND_EQ_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>XDirect Trans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__XDIRECT_TRANS = REGULATING_COND_EQ_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>XQuad Subtrans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS = REGULATING_COND_EQ_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>XQuad Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__XQUAD_SYNC = REGULATING_COND_EQ_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>XQuad Trans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__XQUAD_TRANS = REGULATING_COND_EQ_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__OPERATING_MODE = REGULATING_COND_EQ_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__TYPE = REGULATING_COND_EQ_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Condenser MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__CONDENSER_MW = REGULATING_COND_EQ_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>MV Ar Capability Curves</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES = REGULATING_COND_EQ_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Drives Hydro Pump</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP = REGULATING_COND_EQ_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Generating Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__GENERATING_UNIT = REGULATING_COND_EQ_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Prime Mover</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE__PRIME_MOVER = REGULATING_COND_EQ_FEATURE_COUNT + 29;

	/**
	 * The number of structural features of the '<em>Synchronous Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_MACHINE_FEATURE_COUNT = REGULATING_COND_EQ_FEATURE_COUNT + 30;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl <em>MV Ar Capability Curve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getMVArCapabilityCurve()
	 * @generated
	 */
	int MV_AR_CAPABILITY_CURVE = 23;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__ALIAS_NAME = CorePackage.CURVE_SCHEDULE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__DESCRIPTION = CorePackage.CURVE_SCHEDULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__NAME = CorePackage.CURVE_SCHEDULE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__PATH_NAME = CorePackage.CURVE_SCHEDULE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__MRID = CorePackage.CURVE_SCHEDULE__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__CURVE_STYLE = CorePackage.CURVE_SCHEDULE__CURVE_STYLE;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__RAMP_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__RAMP_START_METHOD = CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__RAMP_UNITS = CorePackage.CURVE_SCHEDULE__RAMP_UNITS;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__XAXIS_TYPE = CorePackage.CURVE_SCHEDULE__XAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__XAXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__Y1_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__Y2_AXIS_QUANTITY = CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__YAXIS_TYPE = CorePackage.CURVE_SCHEDULE__YAXIS_TYPE;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__CURVE_SCHEDULE_DATAS = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__CURVE_SCHEDULE_FORMULA = CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA;

	/**
	 * The feature id for the '<em><b>Coolant Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hydrogen Pressure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Synchronous Machines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>MV Ar Capability Curve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MV_AR_CAPABILITY_CURVE_FEATURE_COUNT = CorePackage.CURVE_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl <em>Equivalent Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getEquivalentSource()
	 * @generated
	 */
	int EQUIVALENT_SOURCE = 24;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Xn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__XN = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__RN = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nominal Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__NOMINAL_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__X = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__R = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Voltage Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__VOLTAGE_ANGLE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Voltage Magnitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__X0 = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__R0 = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Active Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE__ACTIVE_POWER = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Equivalent Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_SOURCE_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.WireTypeImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWireType()
	 * @generated
	 */
	int WIRE_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Phase Conductor Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__PHASE_CONDUCTOR_COUNT = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Phase Conductor Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__PHASE_CONDUCTOR_SPACING = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__AMP_RATING = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>GMR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__GMR = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__RADIUS = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__RESISTANCE = CorePackage.NAMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wire Arrangements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE__WIRE_ARRANGEMENTS = CorePackage.NAMING_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TYPE_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.WireArrangementImpl <em>Arrangement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.WireArrangementImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWireArrangement()
	 * @generated
	 */
	int WIRE_ARRANGEMENT = 26;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Mounting Point X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__MOUNTING_POINT_X = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mounting Point Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__MOUNTING_POINT_Y = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conductor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__CONDUCTOR_TYPE = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wire Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT__WIRE_TYPE = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Arrangement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_ARRANGEMENT_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.LoadBreakSwitchImpl <em>Load Break Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.LoadBreakSwitchImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getLoadBreakSwitch()
	 * @generated
	 */
	int LOAD_BREAK_SWITCH = 27;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__ALIAS_NAME = SWITCH__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__DESCRIPTION = SWITCH__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__PATH_NAME = SWITCH__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__MRID = SWITCH__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__SIMU_MODEL = SWITCH__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__COMPANIES = SWITCH__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__PSR_TYPE = SWITCH__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__EQUIPMENT_CONTAINER = SWITCH__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__PHASES = SWITCH__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__TERMINALS = SWITCH__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__BASE_VOLTAGE = SWITCH__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__NORMAL_OPEN = SWITCH__NORMAL_OPEN;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__SWITCH_ON_COUNT = SWITCH__SWITCH_ON_COUNT;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__SWITCH_ON_DATE = SWITCH__SWITCH_ON_DATE;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__COMPOSITE_SWITCH = SWITCH__COMPOSITE_SWITCH;

	/**
	 * The feature id for the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH__AMP_RATING = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Load Break Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BREAK_SWITCH_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.JunctionImpl <em>Junction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.JunctionImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getJunction()
	 * @generated
	 */
	int JUNCTION = 28;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__ALIAS_NAME = CONNECTOR__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__DESCRIPTION = CONNECTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__NAME = CONNECTOR__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__PATH_NAME = CONNECTOR__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__MRID = CONNECTOR__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__SIMU_MODEL = CONNECTOR__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__COMPANIES = CONNECTOR__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__PSR_TYPE = CONNECTOR__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__EQUIPMENT_CONTAINER = CONNECTOR__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__PHASES = CONNECTOR__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__TERMINALS = CONNECTOR__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__BASE_VOLTAGE = CONNECTOR__BASE_VOLTAGE;

	/**
	 * The number of structural features of the '<em>Junction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl <em>Energy Consumer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getEnergyConsumer()
	 * @generated
	 */
	int ENERGY_CONSUMER = 29;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__ALIAS_NAME = CorePackage.CONDUCTING_EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__DESCRIPTION = CorePackage.CONDUCTING_EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__NAME = CorePackage.CONDUCTING_EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PATH_NAME = CorePackage.CONDUCTING_EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__MRID = CorePackage.CONDUCTING_EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__SIMU_MODEL = CorePackage.CONDUCTING_EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__COMPANIES = CorePackage.CONDUCTING_EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PSR_TYPE = CorePackage.CONDUCTING_EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__EQUIPMENT_CONTAINER = CorePackage.CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PHASES = CorePackage.CONDUCTING_EQUIPMENT__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__TERMINALS = CorePackage.CONDUCTING_EQUIPMENT__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__BASE_VOLTAGE = CorePackage.CONDUCTING_EQUIPMENT__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Load Demand Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__LOAD_DEMAND_MODELS = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Non Conform Load Schedules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__LOAD_AREA = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Power Cut Zone</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__POWER_CUT_ZONE = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Conforming Load Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__CONFORMING_LOAD_FLAG = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Customer Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__CUSTOMER_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>PFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PFEXP = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Pfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PFIXED = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Pfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PFIXED_PCT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Pnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PNOM = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Pnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PNOM_PCT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Power Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__POWER_FACTOR = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>PVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__PVEXP = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>QFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__QFEXP = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Qfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__QFIXED = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Qfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__QFIXED_PCT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Qnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__QNOM = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Qnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__QNOM_PCT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>QVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER__QVEXP = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>Energy Consumer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_CONSUMER_FEATURE_COUNT = CorePackage.CONDUCTING_EQUIPMENT_FEATURE_COUNT + 19;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.GroundDisconnectorImpl <em>Ground Disconnector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.GroundDisconnectorImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getGroundDisconnector()
	 * @generated
	 */
	int GROUND_DISCONNECTOR = 32;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__ALIAS_NAME = SWITCH__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__DESCRIPTION = SWITCH__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__PATH_NAME = SWITCH__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__MRID = SWITCH__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__SIMU_MODEL = SWITCH__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__COMPANIES = SWITCH__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__PSR_TYPE = SWITCH__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__EQUIPMENT_CONTAINER = SWITCH__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__PHASES = SWITCH__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__TERMINALS = SWITCH__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__BASE_VOLTAGE = SWITCH__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__NORMAL_OPEN = SWITCH__NORMAL_OPEN;

	/**
	 * The feature id for the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__SWITCH_ON_COUNT = SWITCH__SWITCH_ON_COUNT;

	/**
	 * The feature id for the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__SWITCH_ON_DATE = SWITCH__SWITCH_ON_DATE;

	/**
	 * The feature id for the '<em><b>Composite Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR__COMPOSITE_SWITCH = SWITCH__COMPOSITE_SWITCH;

	/**
	 * The number of structural features of the '<em>Ground Disconnector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_DISCONNECTOR_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.CompositeSwitchImpl <em>Composite Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.CompositeSwitchImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getCompositeSwitch()
	 * @generated
	 */
	int COMPOSITE_SWITCH = 33;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__ALIAS_NAME = CorePackage.EQUIPMENT_CONTAINER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__DESCRIPTION = CorePackage.EQUIPMENT_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__NAME = CorePackage.EQUIPMENT_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__PATH_NAME = CorePackage.EQUIPMENT_CONTAINER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__MRID = CorePackage.EQUIPMENT_CONTAINER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__SIMU_MODEL = CorePackage.EQUIPMENT_CONTAINER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__COMPANIES = CorePackage.EQUIPMENT_CONTAINER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__PSR_TYPE = CorePackage.EQUIPMENT_CONTAINER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Connectivity Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__CONNECTIVITY_NODES = CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__EQUIPMENTS = CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS;

	/**
	 * The feature id for the '<em><b>Composite Switch Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE = CorePackage.EQUIPMENT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Switches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH__SWITCHES = CorePackage.EQUIPMENT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SWITCH_FEATURE_COUNT = CorePackage.EQUIPMENT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.WiresVersionImpl <em>Wires Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.WiresVersionImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWiresVersion()
	 * @generated
	 */
	int WIRES_VERSION = 34;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRES_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRES_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Wires Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRES_VERSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl <em>Frequency Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl
	 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getFrequencyConverter()
	 * @generated
	 */
	int FREQUENCY_CONVERTER = 35;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__ALIAS_NAME = REGULATING_COND_EQ__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__DESCRIPTION = REGULATING_COND_EQ__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__NAME = REGULATING_COND_EQ__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__PATH_NAME = REGULATING_COND_EQ__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__MRID = REGULATING_COND_EQ__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__SIMU_MODEL = REGULATING_COND_EQ__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__COMPANIES = REGULATING_COND_EQ__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__PSR_TYPE = REGULATING_COND_EQ__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__EQUIPMENT_CONTAINER = REGULATING_COND_EQ__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__PHASES = REGULATING_COND_EQ__PHASES;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__TERMINALS = REGULATING_COND_EQ__TERMINALS;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__BASE_VOLTAGE = REGULATING_COND_EQ__BASE_VOLTAGE;

	/**
	 * The feature id for the '<em><b>Regulation Schedule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__REGULATION_SCHEDULE = REGULATING_COND_EQ__REGULATION_SCHEDULE;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__FREQUENCY = REGULATING_COND_EQ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__MAXIMUM_MW = REGULATING_COND_EQ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Maximum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__MAXIMUM_KV = REGULATING_COND_EQ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Minimum MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__MINIMUM_MW = REGULATING_COND_EQ_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Minimum KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__MINIMUM_KV = REGULATING_COND_EQ_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Operating Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER__OPERATING_MODE = REGULATING_COND_EQ_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Frequency Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_CONVERTER_FEATURE_COUNT = REGULATING_COND_EQ_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.ACLineSegment <em>AC Line Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AC Line Segment</em>'.
	 * @see org.opencim.cim.iec61970.wire.ACLineSegment
	 * @generated
	 */
	EClass getACLineSegment();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.wire.ACLineSegment#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Line</em>'.
	 * @see org.opencim.cim.iec61970.wire.ACLineSegment#getLine()
	 * @see #getACLineSegment()
	 * @generated
	 */
	EReference getACLineSegment_Line();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Breaker <em>Breaker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Breaker</em>'.
	 * @see org.opencim.cim.iec61970.wire.Breaker
	 * @generated
	 */
	EClass getBreaker();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Breaker#getAmpRating <em>Amp Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amp Rating</em>'.
	 * @see org.opencim.cim.iec61970.wire.Breaker#getAmpRating()
	 * @see #getBreaker()
	 * @generated
	 */
	EAttribute getBreaker_AmpRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Breaker#getInTransitTime <em>In Transit Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Transit Time</em>'.
	 * @see org.opencim.cim.iec61970.wire.Breaker#getInTransitTime()
	 * @see #getBreaker()
	 * @generated
	 */
	EAttribute getBreaker_InTransitTime();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.BusbarSection <em>Busbar Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Busbar Section</em>'.
	 * @see org.opencim.cim.iec61970.wire.BusbarSection
	 * @generated
	 */
	EClass getBusbarSection();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.BusbarSection#getVoltageControlZone <em>Voltage Control Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Voltage Control Zone</em>'.
	 * @see org.opencim.cim.iec61970.wire.BusbarSection#getVoltageControlZone()
	 * @see #getBusbarSection()
	 * @generated
	 */
	EReference getBusbarSection_VoltageControlZone();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Compensator <em>Compensator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compensator</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator
	 * @generated
	 */
	EClass getCompensator();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getAVRDelay <em>AVR Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>AVR Delay</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getAVRDelay()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_AVRDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getImpedance <em>Impedance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Impedance</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getImpedance()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_Impedance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getMaximumkV <em>Maximumk V</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximumk V</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getMaximumkV()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_MaximumkV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getMaximumSections <em>Maximum Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Sections</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getMaximumSections()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_MaximumSections();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getMinimumkV <em>Minimumk V</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimumk V</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getMinimumkV()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_MinimumkV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getMVArPerSection <em>MV Ar Per Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MV Ar Per Section</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getMVArPerSection()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_MVArPerSection();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getNominalkV <em>Nominalk V</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nominalk V</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getNominalkV()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_NominalkV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getNominalMVAr <em>Nominal MV Ar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nominal MV Ar</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getNominalMVAr()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_NominalMVAr();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getNormalSections <em>Normal Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normal Sections</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getNormalSections()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_NormalSections();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getR()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_R();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getSwitchOnCount <em>Switch On Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Switch On Count</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getSwitchOnCount()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_SwitchOnCount();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getSwitchOnDate <em>Switch On Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Switch On Date</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getSwitchOnDate()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_SwitchOnDate();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getVoltSensitivity <em>Volt Sensitivity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volt Sensitivity</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getVoltSensitivity()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_VoltSensitivity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getX()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_X();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getYPerSection <em>YPer Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YPer Section</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getYPerSection()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_YPerSection();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Compensator#getCompensatorType <em>Compensator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compensator Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.Compensator#getCompensatorType()
	 * @see #getCompensator()
	 * @generated
	 */
	EAttribute getCompensator_CompensatorType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Conductor <em>Conductor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conductor</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor
	 * @generated
	 */
	EClass getConductor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getB0ch <em>B0ch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B0ch</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getB0ch()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_B0ch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getBch <em>Bch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bch</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getBch()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_Bch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getG0ch <em>G0ch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>G0ch</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getG0ch()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_G0ch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getGch <em>Gch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gch</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getGch()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_Gch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getLength()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getR()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_R();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getR0 <em>R0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R0</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getR0()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_R0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getX()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_X();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Conductor#getX0 <em>X0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X0</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getX0()
	 * @see #getConductor()
	 * @generated
	 */
	EAttribute getConductor_X0();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.Conductor#getConductorType <em>Conductor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conductor Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.Conductor#getConductorType()
	 * @see #getConductor()
	 * @generated
	 */
	EReference getConductor_ConductorType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.ConductorType <em>Conductor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conductor Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.ConductorType
	 * @generated
	 */
	EClass getConductorType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.ConductorType#getSheathResistance <em>Sheath Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sheath Resistance</em>'.
	 * @see org.opencim.cim.iec61970.wire.ConductorType#getSheathResistance()
	 * @see #getConductorType()
	 * @generated
	 */
	EAttribute getConductorType_SheathResistance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.ConductorType#getSheathReactance <em>Sheath Reactance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sheath Reactance</em>'.
	 * @see org.opencim.cim.iec61970.wire.ConductorType#getSheathReactance()
	 * @see #getConductorType()
	 * @generated
	 */
	EAttribute getConductorType_SheathReactance();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.ConductorType#getConductors <em>Conductors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conductors</em>'.
	 * @see org.opencim.cim.iec61970.wire.ConductorType#getConductors()
	 * @see #getConductorType()
	 * @generated
	 */
	EReference getConductorType_Conductors();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.ConductorType#getWireArrangements <em>Wire Arrangements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wire Arrangements</em>'.
	 * @see org.opencim.cim.iec61970.wire.ConductorType#getWireArrangements()
	 * @see #getConductorType()
	 * @generated
	 */
	EReference getConductorType_WireArrangements();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.DCLineSegment <em>DC Line Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DC Line Segment</em>'.
	 * @see org.opencim.cim.iec61970.wire.DCLineSegment
	 * @generated
	 */
	EClass getDCLineSegment();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentInductance <em>Dc Segment Inductance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dc Segment Inductance</em>'.
	 * @see org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentInductance()
	 * @see #getDCLineSegment()
	 * @generated
	 */
	EAttribute getDCLineSegment_DcSegmentInductance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentResistance <em>Dc Segment Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dc Segment Resistance</em>'.
	 * @see org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentResistance()
	 * @see #getDCLineSegment()
	 * @generated
	 */
	EAttribute getDCLineSegment_DcSegmentResistance();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Line</em>'.
	 * @see org.opencim.cim.iec61970.wire.DCLineSegment#getLine()
	 * @see #getDCLineSegment()
	 * @generated
	 */
	EReference getDCLineSegment_Line();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Disconnector <em>Disconnector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disconnector</em>'.
	 * @see org.opencim.cim.iec61970.wire.Disconnector
	 * @generated
	 */
	EClass getDisconnector();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Fuse <em>Fuse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fuse</em>'.
	 * @see org.opencim.cim.iec61970.wire.Fuse
	 * @generated
	 */
	EClass getFuse();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Fuse#getAmpRating <em>Amp Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amp Rating</em>'.
	 * @see org.opencim.cim.iec61970.wire.Fuse#getAmpRating()
	 * @see #getFuse()
	 * @generated
	 */
	EAttribute getFuse_AmpRating();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Ground <em>Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ground</em>'.
	 * @see org.opencim.cim.iec61970.wire.Ground
	 * @generated
	 */
	EClass getGround();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.HeatExchanger <em>Heat Exchanger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Heat Exchanger</em>'.
	 * @see org.opencim.cim.iec61970.wire.HeatExchanger
	 * @generated
	 */
	EClass getHeatExchanger();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Jumper <em>Jumper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jumper</em>'.
	 * @see org.opencim.cim.iec61970.wire.Jumper
	 * @generated
	 */
	EClass getJumper();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.RectifierInverter <em>Rectifier Inverter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectifier Inverter</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter
	 * @generated
	 */
	EClass getRectifierInverter();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getRatedKV <em>Rated KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getRatedKV()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_RatedKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getBridges <em>Bridges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bridges</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getBridges()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_Bridges();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingReactance <em>Commutating Reactance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commutating Reactance</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingReactance()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_CommutatingReactance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingResistance <em>Commutating Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commutating Resistance</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getCommutatingResistance()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_CommutatingResistance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getCompoundResistance <em>Compound Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compound Resistance</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getCompoundResistance()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_CompoundResistance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinCompoundVoltage <em>Min Compound Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Compound Voltage</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getMinCompoundVoltage()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_MinCompoundVoltage();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getFrequency()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_Frequency();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumMW <em>Maximum MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum MW</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumMW()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_MaximumMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumMW <em>Minimum MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum MW</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumMW()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_MinimumMW();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumKV <em>Maximum KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Maximum KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getMaximumKV()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EReference getRectifierInverter_MaximumKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumKV <em>Minimum KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getMinimumKV()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_MinimumKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RectifierInverter#getOperatingMode <em>Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating Mode</em>'.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter#getOperatingMode()
	 * @see #getRectifierInverter()
	 * @generated
	 */
	EAttribute getRectifierInverter_OperatingMode();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.RegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regulation Schedule</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule
	 * @generated
	 */
	EClass getRegulationSchedule();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropCompensation <em>Line Drop Compensation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Drop Compensation</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropCompensation()
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	EAttribute getRegulationSchedule_LineDropCompensation();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropR <em>Line Drop R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Drop R</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropR()
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	EAttribute getRegulationSchedule_LineDropR();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropX <em>Line Drop X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Drop X</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropX()
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	EAttribute getRegulationSchedule_LineDropX();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getVoltageControlZones <em>Voltage Control Zones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Voltage Control Zones</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getVoltageControlZones()
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	EReference getRegulationSchedule_VoltageControlZones();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getRegulatingCondEqs <em>Regulating Cond Eqs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Regulating Cond Eqs</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getRegulatingCondEqs()
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	EReference getRegulationSchedule_RegulatingCondEqs();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getTapChangers <em>Tap Changers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tap Changers</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getTapChangers()
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	EReference getRegulationSchedule_TapChangers();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator <em>Static Var Compensator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Var Compensator</em>'.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator
	 * @generated
	 */
	EClass getStaticVarCompensator();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getCapacitiveRating <em>Capacitive Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacitive Rating</em>'.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator#getCapacitiveRating()
	 * @see #getStaticVarCompensator()
	 * @generated
	 */
	EAttribute getStaticVarCompensator_CapacitiveRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getInductiveRating <em>Inductive Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inductive Rating</em>'.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator#getInductiveRating()
	 * @see #getStaticVarCompensator()
	 * @generated
	 */
	EAttribute getStaticVarCompensator_InductiveRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getSVCControlMode <em>SVC Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SVC Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator#getSVCControlMode()
	 * @see #getStaticVarCompensator()
	 * @generated
	 */
	EAttribute getStaticVarCompensator_SVCControlMode();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getSlope <em>Slope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slope</em>'.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator#getSlope()
	 * @see #getStaticVarCompensator()
	 * @generated
	 */
	EAttribute getStaticVarCompensator_Slope();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator#getVoltageSetPoint <em>Voltage Set Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voltage Set Point</em>'.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator#getVoltageSetPoint()
	 * @see #getStaticVarCompensator()
	 * @generated
	 */
	EAttribute getStaticVarCompensator_VoltageSetPoint();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see org.opencim.cim.iec61970.wire.Switch
	 * @generated
	 */
	EClass getSwitch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Switch#getNormalOpen <em>Normal Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normal Open</em>'.
	 * @see org.opencim.cim.iec61970.wire.Switch#getNormalOpen()
	 * @see #getSwitch()
	 * @generated
	 */
	EAttribute getSwitch_NormalOpen();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Switch#getSwitchOnCount <em>Switch On Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Switch On Count</em>'.
	 * @see org.opencim.cim.iec61970.wire.Switch#getSwitchOnCount()
	 * @see #getSwitch()
	 * @generated
	 */
	EAttribute getSwitch_SwitchOnCount();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.Switch#getSwitchOnDate <em>Switch On Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Switch On Date</em>'.
	 * @see org.opencim.cim.iec61970.wire.Switch#getSwitchOnDate()
	 * @see #getSwitch()
	 * @generated
	 */
	EAttribute getSwitch_SwitchOnDate();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.Switch#getCompositeSwitch <em>Composite Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Switch</em>'.
	 * @see org.opencim.cim.iec61970.wire.Switch#getCompositeSwitch()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_CompositeSwitch();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.TapChanger <em>Tap Changer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tap Changer</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger
	 * @generated
	 */
	EClass getTapChanger();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getHighStep <em>High Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High Step</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getHighStep()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_HighStep();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getInitialDelay <em>Initial Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Delay</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getInitialDelay()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_InitialDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getLowStep <em>Low Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low Step</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getLowStep()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_LowStep();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getNeutralKV <em>Neutral KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Neutral KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getNeutralKV()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_NeutralKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getNeutralStep <em>Neutral Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Neutral Step</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getNeutralStep()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_NeutralStep();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getNormalStep <em>Normal Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normal Step</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getNormalStep()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_NormalStep();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getStepPhaseShiftIncrement <em>Step Phase Shift Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Phase Shift Increment</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getStepPhaseShiftIncrement()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_StepPhaseShiftIncrement();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getStepVoltageIncrement <em>Step Voltage Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Voltage Increment</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getStepVoltageIncrement()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_StepVoltageIncrement();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getSubsequentDelay <em>Subsequent Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subsequent Delay</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getSubsequentDelay()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_SubsequentDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TapChanger#getTculControlMode <em>Tcul Control Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tcul Control Mode</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getTculControlMode()
	 * @see #getTapChanger()
	 * @generated
	 */
	EAttribute getTapChanger_TculControlMode();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.TapChanger#getRegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Regulation Schedule</em>'.
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getRegulationSchedule()
	 * @see #getTapChanger()
	 * @generated
	 */
	EReference getTapChanger_RegulationSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.PowerTransformer <em>Power Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Transformer</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer
	 * @generated
	 */
	EClass getPowerTransformer();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getBmagSat <em>Bmag Sat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bmag Sat</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getBmagSat()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EAttribute getPowerTransformer_BmagSat();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getMagBaseKV <em>Mag Base KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mag Base KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getMagBaseKV()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EAttribute getPowerTransformer_MagBaseKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getMagSatFlux <em>Mag Sat Flux</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mag Sat Flux</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getMagSatFlux()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EAttribute getPowerTransformer_MagSatFlux();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getPhases <em>Phases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phases</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getPhases()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EAttribute getPowerTransformer_Phases();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransfCoolingType <em>Transf Cooling Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transf Cooling Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getTransfCoolingType()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EAttribute getPowerTransformer_TransfCoolingType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerType <em>Transformer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transformer Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerType()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EAttribute getPowerTransformer_TransformerType();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getHeatExchanger <em>Heat Exchanger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heat Exchanger</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getHeatExchanger()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EReference getPowerTransformer_HeatExchanger();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerWindings <em>Transformer Windings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transformer Windings</em>'.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerWindings()
	 * @see #getPowerTransformer()
	 * @generated
	 */
	EReference getPowerTransformer_TransformerWindings();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.TransformerWinding <em>Transformer Winding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformer Winding</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding
	 * @generated
	 */
	EClass getTransformerWinding();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getB()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_B();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getInsulationKV <em>Insulation KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insulation KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getInsulationKV()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_InsulationKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getConnectionType()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_ConnectionType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getEmergencyMVA <em>Emergency MVA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emergency MVA</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getEmergencyMVA()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_EmergencyMVA();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getG <em>G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>G</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getG()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_G();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getGrounded <em>Grounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grounded</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getGrounded()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_Grounded();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getR()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_R();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getR0 <em>R0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R0</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getR0()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_R0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRatedKV <em>Rated KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getRatedKV()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_RatedKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRatedMVA <em>Rated MVA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated MVA</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getRatedMVA()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_RatedMVA();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRground <em>Rground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rground</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getRground()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_Rground();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getShortTermMVA <em>Short Term MVA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Term MVA</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getShortTermMVA()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_ShortTermMVA();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getWindingType <em>Winding Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Winding Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getWindingType()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_WindingType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getX()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_X();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getX0 <em>X0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X0</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getX0()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_X0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getXground <em>Xground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xground</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getXground()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EAttribute getTransformerWinding_Xground();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getPowerTransformer <em>Power Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Power Transformer</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getPowerTransformer()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EReference getTransformerWinding_PowerTransformer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getTapChangers <em>Tap Changers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tap Changers</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getTapChangers()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EReference getTransformerWinding_TapChangers();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getFrom_WindingTests <em>From Winding Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Winding Tests</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getFrom_WindingTests()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EReference getTransformerWinding_From_WindingTests();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getTo_WindingTest <em>To Winding Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Winding Test</em>'.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getTo_WindingTest()
	 * @see #getTransformerWinding()
	 * @generated
	 */
	EReference getTransformerWinding_To_WindingTest();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see org.opencim.cim.iec61970.wire.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.wire.Line#getACLineSegments <em>AC Line Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>AC Line Segments</em>'.
	 * @see org.opencim.cim.iec61970.wire.Line#getACLineSegments()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_ACLineSegments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.wire.Line#getDCLineSegments <em>DC Line Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>DC Line Segments</em>'.
	 * @see org.opencim.cim.iec61970.wire.Line#getDCLineSegments()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_DCLineSegments();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.VoltageControlZone <em>Voltage Control Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voltage Control Zone</em>'.
	 * @see org.opencim.cim.iec61970.wire.VoltageControlZone
	 * @generated
	 */
	EClass getVoltageControlZone();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getBusbarSection <em>Busbar Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Busbar Section</em>'.
	 * @see org.opencim.cim.iec61970.wire.VoltageControlZone#getBusbarSection()
	 * @see #getVoltageControlZone()
	 * @generated
	 */
	EReference getVoltageControlZone_BusbarSection();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getRegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Regulation Schedule</em>'.
	 * @see org.opencim.cim.iec61970.wire.VoltageControlZone#getRegulationSchedule()
	 * @see #getVoltageControlZone()
	 * @generated
	 */
	EReference getVoltageControlZone_RegulationSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.WindingTest <em>Winding Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Winding Test</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest
	 * @generated
	 */
	EClass getWindingTest();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getExcitingCurrent <em>Exciting Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exciting Current</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getExcitingCurrent()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_ExcitingCurrent();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getFromTapStep <em>From Tap Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Tap Step</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getFromTapStep()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_FromTapStep();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getLeakageImpedance <em>Leakage Impedance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leakage Impedance</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getLeakageImpedance()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_LeakageImpedance();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getLoadLoss <em>Load Loss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Loss</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getLoadLoss()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_LoadLoss();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getNoLoadLoss <em>No Load Loss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Load Loss</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getNoLoadLoss()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_NoLoadLoss();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getPhaseShift <em>Phase Shift</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase Shift</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getPhaseShift()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_PhaseShift();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getToTapStep <em>To Tap Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Tap Step</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getToTapStep()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_ToTapStep();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WindingTest#getVoltage <em>Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voltage</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getVoltage()
	 * @see #getWindingTest()
	 * @generated
	 */
	EAttribute getWindingTest_Voltage();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.WindingTest#getFrom_TransformerWinding <em>From Transformer Winding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Transformer Winding</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getFrom_TransformerWinding()
	 * @see #getWindingTest()
	 * @generated
	 */
	EReference getWindingTest_From_TransformerWinding();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.WindingTest#getTo_TransformeWindings <em>To Transforme Windings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To Transforme Windings</em>'.
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getTo_TransformeWindings()
	 * @see #getWindingTest()
	 * @generated
	 */
	EReference getWindingTest_To_TransformeWindings();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.SynchronousMachine <em>Synchronous Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synchronous Machine</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine
	 * @generated
	 */
	EClass getSynchronousMachine();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLag <em>AVR To Manual Lag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>AVR To Manual Lag</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLag()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_AVRToManualLag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLead <em>AVR To Manual Lead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>AVR To Manual Lead</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getAVRToManualLead()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_AVRToManualLead();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getBaseMVAr <em>Base MV Ar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base MV Ar</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getBaseMVAr()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_BaseMVAr();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantCondition <em>Coolant Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coolant Condition</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantCondition()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_CoolantCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantType <em>Coolant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coolant Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getCoolantType()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_CoolantType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getDamping <em>Damping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damping</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getDamping()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_Damping();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getInertia <em>Inertia</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inertia</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getInertia()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_Inertia();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getManualToAVR <em>Manual To AVR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manual To AVR</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getManualToAVR()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_ManualToAVR();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumKV <em>Maximum KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumKV()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_MaximumKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumMVAr <em>Maximum MV Ar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum MV Ar</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getMaximumMVAr()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_MaximumMVAr();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumKV <em>Minimum KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumKV()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_MinimumKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumMVAr <em>Minimum MV Ar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum MV Ar</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getMinimumMVAr()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_MinimumMVAr();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getR()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_R();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getR0 <em>R0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R0</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getR0()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_R0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getRatedMVA <em>Rated MVA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rated MVA</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getRatedMVA()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_RatedMVA();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getX()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_X();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getX0 <em>X0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X0</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getX0()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_X0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSubtrans <em>XDirect Subtrans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XDirect Subtrans</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSubtrans()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_XDirectSubtrans();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSync <em>XDirect Sync</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XDirect Sync</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectSync()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_XDirectSync();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectTrans <em>XDirect Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XDirect Trans</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getXDirectTrans()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_XDirectTrans();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSubtrans <em>XQuad Subtrans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XQuad Subtrans</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSubtrans()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_XQuadSubtrans();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSync <em>XQuad Sync</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XQuad Sync</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadSync()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_XQuadSync();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadTrans <em>XQuad Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XQuad Trans</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getXQuadTrans()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_XQuadTrans();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getOperatingMode <em>Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating Mode</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getOperatingMode()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_OperatingMode();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getType()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getCondenserMW <em>Condenser MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condenser MW</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getCondenserMW()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EAttribute getSynchronousMachine_CondenserMW();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMVArCapabilityCurves <em>MV Ar Capability Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>MV Ar Capability Curves</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getMVArCapabilityCurves()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EReference getSynchronousMachine_MVArCapabilityCurves();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getDrives_HydroPump <em>Drives Hydro Pump</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Drives Hydro Pump</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getDrives_HydroPump()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EReference getSynchronousMachine_Drives_HydroPump();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getGeneratingUnit <em>Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generating Unit</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getGeneratingUnit()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EReference getSynchronousMachine_GeneratingUnit();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getPrimeMover <em>Prime Mover</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Prime Mover</em>'.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getPrimeMover()
	 * @see #getSynchronousMachine()
	 * @generated
	 */
	EReference getSynchronousMachine_PrimeMover();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve <em>MV Ar Capability Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MV Ar Capability Curve</em>'.
	 * @see org.opencim.cim.iec61970.wire.MVArCapabilityCurve
	 * @generated
	 */
	EClass getMVArCapabilityCurve();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getCoolantTemperature <em>Coolant Temperature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coolant Temperature</em>'.
	 * @see org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getCoolantTemperature()
	 * @see #getMVArCapabilityCurve()
	 * @generated
	 */
	EAttribute getMVArCapabilityCurve_CoolantTemperature();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getHydrogenPressure <em>Hydrogen Pressure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hydrogen Pressure</em>'.
	 * @see org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getHydrogenPressure()
	 * @see #getMVArCapabilityCurve()
	 * @generated
	 */
	EAttribute getMVArCapabilityCurve_HydrogenPressure();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getSynchronousMachines <em>Synchronous Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Synchronous Machines</em>'.
	 * @see org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getSynchronousMachines()
	 * @see #getMVArCapabilityCurve()
	 * @generated
	 */
	EReference getMVArCapabilityCurve_SynchronousMachines();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.EquivalentSource <em>Equivalent Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalent Source</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource
	 * @generated
	 */
	EClass getEquivalentSource();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getXn <em>Xn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xn</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getXn()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_Xn();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getRn <em>Rn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rn</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getRn()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_Rn();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getNominalVoltage <em>Nominal Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nominal Voltage</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getNominalVoltage()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_NominalVoltage();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getX()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_X();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getR()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_R();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageAngle <em>Voltage Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voltage Angle</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageAngle()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_VoltageAngle();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageMagnitude <em>Voltage Magnitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voltage Magnitude</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getVoltageMagnitude()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_VoltageMagnitude();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getX0 <em>X0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X0</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getX0()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_X0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getR0 <em>R0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R0</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getR0()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_R0();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EquivalentSource#getActivePower <em>Active Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active Power</em>'.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource#getActivePower()
	 * @see #getEquivalentSource()
	 * @generated
	 */
	EAttribute getEquivalentSource_ActivePower();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.WireType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType
	 * @generated
	 */
	EClass getWireType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireType#getPhaseConductorCount <em>Phase Conductor Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase Conductor Count</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getPhaseConductorCount()
	 * @see #getWireType()
	 * @generated
	 */
	EAttribute getWireType_PhaseConductorCount();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireType#getPhaseConductorSpacing <em>Phase Conductor Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase Conductor Spacing</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getPhaseConductorSpacing()
	 * @see #getWireType()
	 * @generated
	 */
	EAttribute getWireType_PhaseConductorSpacing();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireType#getAmpRating <em>Amp Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amp Rating</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getAmpRating()
	 * @see #getWireType()
	 * @generated
	 */
	EAttribute getWireType_AmpRating();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireType#getGMR <em>GMR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>GMR</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getGMR()
	 * @see #getWireType()
	 * @generated
	 */
	EAttribute getWireType_GMR();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireType#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getRadius()
	 * @see #getWireType()
	 * @generated
	 */
	EAttribute getWireType_Radius();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireType#getResistance <em>Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resistance</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getResistance()
	 * @see #getWireType()
	 * @generated
	 */
	EAttribute getWireType_Resistance();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.WireType#getWireArrangements <em>Wire Arrangements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wire Arrangements</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireType#getWireArrangements()
	 * @see #getWireType()
	 * @generated
	 */
	EReference getWireType_WireArrangements();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.WireArrangement <em>Arrangement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arrangement</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireArrangement
	 * @generated
	 */
	EClass getWireArrangement();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointX <em>Mounting Point X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mounting Point X</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointX()
	 * @see #getWireArrangement()
	 * @generated
	 */
	EAttribute getWireArrangement_MountingPointX();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointY <em>Mounting Point Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mounting Point Y</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointY()
	 * @see #getWireArrangement()
	 * @generated
	 */
	EAttribute getWireArrangement_MountingPointY();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.WireArrangement#getConductorType <em>Conductor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conductor Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireArrangement#getConductorType()
	 * @see #getWireArrangement()
	 * @generated
	 */
	EReference getWireArrangement_ConductorType();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.WireArrangement#getWireType <em>Wire Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wire Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.WireArrangement#getWireType()
	 * @see #getWireArrangement()
	 * @generated
	 */
	EReference getWireArrangement_WireType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.LoadBreakSwitch <em>Load Break Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load Break Switch</em>'.
	 * @see org.opencim.cim.iec61970.wire.LoadBreakSwitch
	 * @generated
	 */
	EClass getLoadBreakSwitch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.LoadBreakSwitch#getAmpRating <em>Amp Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amp Rating</em>'.
	 * @see org.opencim.cim.iec61970.wire.LoadBreakSwitch#getAmpRating()
	 * @see #getLoadBreakSwitch()
	 * @generated
	 */
	EAttribute getLoadBreakSwitch_AmpRating();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Junction <em>Junction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Junction</em>'.
	 * @see org.opencim.cim.iec61970.wire.Junction
	 * @generated
	 */
	EClass getJunction();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.EnergyConsumer <em>Energy Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Energy Consumer</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer
	 * @generated
	 */
	EClass getEnergyConsumer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadDemandModels <em>Load Demand Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Load Demand Models</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadDemandModels()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EReference getEnergyConsumer_LoadDemandModels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getNonConformLoadSchedules <em>Non Conform Load Schedules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Non Conform Load Schedules</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getNonConformLoadSchedules()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EReference getEnergyConsumer_NonConformLoadSchedules();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Load Area</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadArea()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EReference getEnergyConsumer_LoadArea();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerCutZone <em>Power Cut Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Power Cut Zone</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerCutZone()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EReference getEnergyConsumer_PowerCutZone();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getConformingLoadFlag <em>Conforming Load Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conforming Load Flag</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getConformingLoadFlag()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_ConformingLoadFlag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getCustomerCount <em>Customer Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Count</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getCustomerCount()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_CustomerCount();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPFexp <em>PFexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PFexp</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPFexp()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_PFexp();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixed <em>Pfixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pfixed</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixed()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_Pfixed();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixedPct <em>Pfixed Pct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pfixed Pct</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixedPct()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_PfixedPct();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPnom <em>Pnom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pnom</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPnom()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_Pnom();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPnomPct <em>Pnom Pct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pnom Pct</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPnomPct()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_PnomPct();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerFactor <em>Power Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Power Factor</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerFactor()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_PowerFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPVexp <em>PVexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PVexp</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPVexp()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_PVexp();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQFexp <em>QFexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>QFexp</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getQFexp()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_QFexp();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixed <em>Qfixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qfixed</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixed()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_Qfixed();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixedPct <em>Qfixed Pct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qfixed Pct</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixedPct()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_QfixedPct();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQnom <em>Qnom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qnom</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getQnom()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_Qnom();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQnomPct <em>Qnom Pct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qnom Pct</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getQnomPct()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_QnomPct();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQVexp <em>QVexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>QVexp</em>'.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getQVexp()
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	EAttribute getEnergyConsumer_QVexp();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see org.opencim.cim.iec61970.wire.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.RegulatingCondEq <em>Regulating Cond Eq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regulating Cond Eq</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulatingCondEq
	 * @generated
	 */
	EClass getRegulatingCondEq();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.wire.RegulatingCondEq#getRegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Regulation Schedule</em>'.
	 * @see org.opencim.cim.iec61970.wire.RegulatingCondEq#getRegulationSchedule()
	 * @see #getRegulatingCondEq()
	 * @generated
	 */
	EReference getRegulatingCondEq_RegulationSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.GroundDisconnector <em>Ground Disconnector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ground Disconnector</em>'.
	 * @see org.opencim.cim.iec61970.wire.GroundDisconnector
	 * @generated
	 */
	EClass getGroundDisconnector();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.CompositeSwitch <em>Composite Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Switch</em>'.
	 * @see org.opencim.cim.iec61970.wire.CompositeSwitch
	 * @generated
	 */
	EClass getCompositeSwitch();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.CompositeSwitch#getCompositeSwitchType <em>Composite Switch Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composite Switch Type</em>'.
	 * @see org.opencim.cim.iec61970.wire.CompositeSwitch#getCompositeSwitchType()
	 * @see #getCompositeSwitch()
	 * @generated
	 */
	EAttribute getCompositeSwitch_CompositeSwitchType();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.wire.CompositeSwitch#getSwitches <em>Switches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Switches</em>'.
	 * @see org.opencim.cim.iec61970.wire.CompositeSwitch#getSwitches()
	 * @see #getCompositeSwitch()
	 * @generated
	 */
	EReference getCompositeSwitch_Switches();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.WiresVersion <em>Wires Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wires Version</em>'.
	 * @see org.opencim.cim.iec61970.wire.WiresVersion
	 * @generated
	 */
	EClass getWiresVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WiresVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.wire.WiresVersion#getVersion()
	 * @see #getWiresVersion()
	 * @generated
	 */
	EAttribute getWiresVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.WiresVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.wire.WiresVersion#getDate()
	 * @see #getWiresVersion()
	 * @generated
	 */
	EAttribute getWiresVersion_Date();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.wire.FrequencyConverter <em>Frequency Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Frequency Converter</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter
	 * @generated
	 */
	EClass getFrequencyConverter();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter#getFrequency()
	 * @see #getFrequencyConverter()
	 * @generated
	 */
	EAttribute getFrequencyConverter_Frequency();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumMW <em>Maximum MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum MW</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumMW()
	 * @see #getFrequencyConverter()
	 * @generated
	 */
	EAttribute getFrequencyConverter_MaximumMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumKV <em>Maximum KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter#getMaximumKV()
	 * @see #getFrequencyConverter()
	 * @generated
	 */
	EAttribute getFrequencyConverter_MaximumKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumMW <em>Minimum MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum MW</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumMW()
	 * @see #getFrequencyConverter()
	 * @generated
	 */
	EAttribute getFrequencyConverter_MinimumMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumKV <em>Minimum KV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum KV</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter#getMinimumKV()
	 * @see #getFrequencyConverter()
	 * @generated
	 */
	EAttribute getFrequencyConverter_MinimumKV();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.wire.FrequencyConverter#getOperatingMode <em>Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating Mode</em>'.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter#getOperatingMode()
	 * @see #getFrequencyConverter()
	 * @generated
	 */
	EAttribute getFrequencyConverter_OperatingMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WireFactory getWireFactory();

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
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.ACLineSegmentImpl <em>AC Line Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.ACLineSegmentImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getACLineSegment()
		 * @generated
		 */
		EClass AC_LINE_SEGMENT = eINSTANCE.getACLineSegment();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC_LINE_SEGMENT__LINE = eINSTANCE.getACLineSegment_Line();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.BreakerImpl <em>Breaker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.BreakerImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getBreaker()
		 * @generated
		 */
		EClass BREAKER = eINSTANCE.getBreaker();

		/**
		 * The meta object literal for the '<em><b>Amp Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKER__AMP_RATING = eINSTANCE.getBreaker_AmpRating();

		/**
		 * The meta object literal for the '<em><b>In Transit Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKER__IN_TRANSIT_TIME = eINSTANCE.getBreaker_InTransitTime();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.BusbarSectionImpl <em>Busbar Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.BusbarSectionImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getBusbarSection()
		 * @generated
		 */
		EClass BUSBAR_SECTION = eINSTANCE.getBusbarSection();

		/**
		 * The meta object literal for the '<em><b>Voltage Control Zone</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSBAR_SECTION__VOLTAGE_CONTROL_ZONE = eINSTANCE.getBusbarSection_VoltageControlZone();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl <em>Compensator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.CompensatorImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getCompensator()
		 * @generated
		 */
		EClass COMPENSATOR = eINSTANCE.getCompensator();

		/**
		 * The meta object literal for the '<em><b>AVR Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__AVR_DELAY = eINSTANCE.getCompensator_AVRDelay();

		/**
		 * The meta object literal for the '<em><b>Impedance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__IMPEDANCE = eINSTANCE.getCompensator_Impedance();

		/**
		 * The meta object literal for the '<em><b>Maximumk V</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__MAXIMUMK_V = eINSTANCE.getCompensator_MaximumkV();

		/**
		 * The meta object literal for the '<em><b>Maximum Sections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__MAXIMUM_SECTIONS = eINSTANCE.getCompensator_MaximumSections();

		/**
		 * The meta object literal for the '<em><b>Minimumk V</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__MINIMUMK_V = eINSTANCE.getCompensator_MinimumkV();

		/**
		 * The meta object literal for the '<em><b>MV Ar Per Section</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__MV_AR_PER_SECTION = eINSTANCE.getCompensator_MVArPerSection();

		/**
		 * The meta object literal for the '<em><b>Nominalk V</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__NOMINALK_V = eINSTANCE.getCompensator_NominalkV();

		/**
		 * The meta object literal for the '<em><b>Nominal MV Ar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__NOMINAL_MV_AR = eINSTANCE.getCompensator_NominalMVAr();

		/**
		 * The meta object literal for the '<em><b>Normal Sections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__NORMAL_SECTIONS = eINSTANCE.getCompensator_NormalSections();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__R = eINSTANCE.getCompensator_R();

		/**
		 * The meta object literal for the '<em><b>Switch On Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__SWITCH_ON_COUNT = eINSTANCE.getCompensator_SwitchOnCount();

		/**
		 * The meta object literal for the '<em><b>Switch On Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__SWITCH_ON_DATE = eINSTANCE.getCompensator_SwitchOnDate();

		/**
		 * The meta object literal for the '<em><b>Volt Sensitivity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__VOLT_SENSITIVITY = eINSTANCE.getCompensator_VoltSensitivity();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__X = eINSTANCE.getCompensator_X();

		/**
		 * The meta object literal for the '<em><b>YPer Section</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__YPER_SECTION = eINSTANCE.getCompensator_YPerSection();

		/**
		 * The meta object literal for the '<em><b>Compensator Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPENSATOR__COMPENSATOR_TYPE = eINSTANCE.getCompensator_CompensatorType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl <em>Conductor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.ConductorImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getConductor()
		 * @generated
		 */
		EClass CONDUCTOR = eINSTANCE.getConductor();

		/**
		 * The meta object literal for the '<em><b>B0ch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__B0CH = eINSTANCE.getConductor_B0ch();

		/**
		 * The meta object literal for the '<em><b>Bch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__BCH = eINSTANCE.getConductor_Bch();

		/**
		 * The meta object literal for the '<em><b>G0ch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__G0CH = eINSTANCE.getConductor_G0ch();

		/**
		 * The meta object literal for the '<em><b>Gch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__GCH = eINSTANCE.getConductor_Gch();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__LENGTH = eINSTANCE.getConductor_Length();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__R = eINSTANCE.getConductor_R();

		/**
		 * The meta object literal for the '<em><b>R0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__R0 = eINSTANCE.getConductor_R0();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__X = eINSTANCE.getConductor_X();

		/**
		 * The meta object literal for the '<em><b>X0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR__X0 = eINSTANCE.getConductor_X0();

		/**
		 * The meta object literal for the '<em><b>Conductor Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDUCTOR__CONDUCTOR_TYPE = eINSTANCE.getConductor_ConductorType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl <em>Conductor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.ConductorTypeImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getConductorType()
		 * @generated
		 */
		EClass CONDUCTOR_TYPE = eINSTANCE.getConductorType();

		/**
		 * The meta object literal for the '<em><b>Sheath Resistance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR_TYPE__SHEATH_RESISTANCE = eINSTANCE.getConductorType_SheathResistance();

		/**
		 * The meta object literal for the '<em><b>Sheath Reactance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTOR_TYPE__SHEATH_REACTANCE = eINSTANCE.getConductorType_SheathReactance();

		/**
		 * The meta object literal for the '<em><b>Conductors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDUCTOR_TYPE__CONDUCTORS = eINSTANCE.getConductorType_Conductors();

		/**
		 * The meta object literal for the '<em><b>Wire Arrangements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDUCTOR_TYPE__WIRE_ARRANGEMENTS = eINSTANCE.getConductorType_WireArrangements();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl <em>DC Line Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getDCLineSegment()
		 * @generated
		 */
		EClass DC_LINE_SEGMENT = eINSTANCE.getDCLineSegment();

		/**
		 * The meta object literal for the '<em><b>Dc Segment Inductance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE = eINSTANCE.getDCLineSegment_DcSegmentInductance();

		/**
		 * The meta object literal for the '<em><b>Dc Segment Resistance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE = eINSTANCE.getDCLineSegment_DcSegmentResistance();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DC_LINE_SEGMENT__LINE = eINSTANCE.getDCLineSegment_Line();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.DisconnectorImpl <em>Disconnector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.DisconnectorImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getDisconnector()
		 * @generated
		 */
		EClass DISCONNECTOR = eINSTANCE.getDisconnector();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.FuseImpl <em>Fuse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.FuseImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getFuse()
		 * @generated
		 */
		EClass FUSE = eINSTANCE.getFuse();

		/**
		 * The meta object literal for the '<em><b>Amp Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUSE__AMP_RATING = eINSTANCE.getFuse_AmpRating();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.GroundImpl <em>Ground</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.GroundImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getGround()
		 * @generated
		 */
		EClass GROUND = eINSTANCE.getGround();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.HeatExchangerImpl <em>Heat Exchanger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.HeatExchangerImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getHeatExchanger()
		 * @generated
		 */
		EClass HEAT_EXCHANGER = eINSTANCE.getHeatExchanger();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.JumperImpl <em>Jumper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.JumperImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getJumper()
		 * @generated
		 */
		EClass JUMPER = eINSTANCE.getJumper();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl <em>Rectifier Inverter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getRectifierInverter()
		 * @generated
		 */
		EClass RECTIFIER_INVERTER = eINSTANCE.getRectifierInverter();

		/**
		 * The meta object literal for the '<em><b>Rated KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__RATED_KV = eINSTANCE.getRectifierInverter_RatedKV();

		/**
		 * The meta object literal for the '<em><b>Bridges</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__BRIDGES = eINSTANCE.getRectifierInverter_Bridges();

		/**
		 * The meta object literal for the '<em><b>Commutating Reactance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__COMMUTATING_REACTANCE = eINSTANCE.getRectifierInverter_CommutatingReactance();

		/**
		 * The meta object literal for the '<em><b>Commutating Resistance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__COMMUTATING_RESISTANCE = eINSTANCE.getRectifierInverter_CommutatingResistance();

		/**
		 * The meta object literal for the '<em><b>Compound Resistance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__COMPOUND_RESISTANCE = eINSTANCE.getRectifierInverter_CompoundResistance();

		/**
		 * The meta object literal for the '<em><b>Min Compound Voltage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE = eINSTANCE.getRectifierInverter_MinCompoundVoltage();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__FREQUENCY = eINSTANCE.getRectifierInverter_Frequency();

		/**
		 * The meta object literal for the '<em><b>Maximum MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__MAXIMUM_MW = eINSTANCE.getRectifierInverter_MaximumMW();

		/**
		 * The meta object literal for the '<em><b>Minimum MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__MINIMUM_MW = eINSTANCE.getRectifierInverter_MinimumMW();

		/**
		 * The meta object literal for the '<em><b>Maximum KV</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTIFIER_INVERTER__MAXIMUM_KV = eINSTANCE.getRectifierInverter_MaximumKV();

		/**
		 * The meta object literal for the '<em><b>Minimum KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__MINIMUM_KV = eINSTANCE.getRectifierInverter_MinimumKV();

		/**
		 * The meta object literal for the '<em><b>Operating Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTIFIER_INVERTER__OPERATING_MODE = eINSTANCE.getRectifierInverter_OperatingMode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl <em>Regulation Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getRegulationSchedule()
		 * @generated
		 */
		EClass REGULATION_SCHEDULE = eINSTANCE.getRegulationSchedule();

		/**
		 * The meta object literal for the '<em><b>Line Drop Compensation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGULATION_SCHEDULE__LINE_DROP_COMPENSATION = eINSTANCE.getRegulationSchedule_LineDropCompensation();

		/**
		 * The meta object literal for the '<em><b>Line Drop R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGULATION_SCHEDULE__LINE_DROP_R = eINSTANCE.getRegulationSchedule_LineDropR();

		/**
		 * The meta object literal for the '<em><b>Line Drop X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGULATION_SCHEDULE__LINE_DROP_X = eINSTANCE.getRegulationSchedule_LineDropX();

		/**
		 * The meta object literal for the '<em><b>Voltage Control Zones</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES = eINSTANCE.getRegulationSchedule_VoltageControlZones();

		/**
		 * The meta object literal for the '<em><b>Regulating Cond Eqs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGULATION_SCHEDULE__REGULATING_COND_EQS = eINSTANCE.getRegulationSchedule_RegulatingCondEqs();

		/**
		 * The meta object literal for the '<em><b>Tap Changers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGULATION_SCHEDULE__TAP_CHANGERS = eINSTANCE.getRegulationSchedule_TapChangers();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl <em>Static Var Compensator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.StaticVarCompensatorImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getStaticVarCompensator()
		 * @generated
		 */
		EClass STATIC_VAR_COMPENSATOR = eINSTANCE.getStaticVarCompensator();

		/**
		 * The meta object literal for the '<em><b>Capacitive Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_VAR_COMPENSATOR__CAPACITIVE_RATING = eINSTANCE.getStaticVarCompensator_CapacitiveRating();

		/**
		 * The meta object literal for the '<em><b>Inductive Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_VAR_COMPENSATOR__INDUCTIVE_RATING = eINSTANCE.getStaticVarCompensator_InductiveRating();

		/**
		 * The meta object literal for the '<em><b>SVC Control Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_VAR_COMPENSATOR__SVC_CONTROL_MODE = eINSTANCE.getStaticVarCompensator_SVCControlMode();

		/**
		 * The meta object literal for the '<em><b>Slope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_VAR_COMPENSATOR__SLOPE = eINSTANCE.getStaticVarCompensator_Slope();

		/**
		 * The meta object literal for the '<em><b>Voltage Set Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_VAR_COMPENSATOR__VOLTAGE_SET_POINT = eINSTANCE.getStaticVarCompensator_VoltageSetPoint();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.SwitchImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getSwitch()
		 * @generated
		 */
		EClass SWITCH = eINSTANCE.getSwitch();

		/**
		 * The meta object literal for the '<em><b>Normal Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH__NORMAL_OPEN = eINSTANCE.getSwitch_NormalOpen();

		/**
		 * The meta object literal for the '<em><b>Switch On Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH__SWITCH_ON_COUNT = eINSTANCE.getSwitch_SwitchOnCount();

		/**
		 * The meta object literal for the '<em><b>Switch On Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH__SWITCH_ON_DATE = eINSTANCE.getSwitch_SwitchOnDate();

		/**
		 * The meta object literal for the '<em><b>Composite Switch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__COMPOSITE_SWITCH = eINSTANCE.getSwitch_CompositeSwitch();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl <em>Tap Changer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.TapChangerImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getTapChanger()
		 * @generated
		 */
		EClass TAP_CHANGER = eINSTANCE.getTapChanger();

		/**
		 * The meta object literal for the '<em><b>High Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__HIGH_STEP = eINSTANCE.getTapChanger_HighStep();

		/**
		 * The meta object literal for the '<em><b>Initial Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__INITIAL_DELAY = eINSTANCE.getTapChanger_InitialDelay();

		/**
		 * The meta object literal for the '<em><b>Low Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__LOW_STEP = eINSTANCE.getTapChanger_LowStep();

		/**
		 * The meta object literal for the '<em><b>Neutral KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__NEUTRAL_KV = eINSTANCE.getTapChanger_NeutralKV();

		/**
		 * The meta object literal for the '<em><b>Neutral Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__NEUTRAL_STEP = eINSTANCE.getTapChanger_NeutralStep();

		/**
		 * The meta object literal for the '<em><b>Normal Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__NORMAL_STEP = eINSTANCE.getTapChanger_NormalStep();

		/**
		 * The meta object literal for the '<em><b>Step Phase Shift Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT = eINSTANCE.getTapChanger_StepPhaseShiftIncrement();

		/**
		 * The meta object literal for the '<em><b>Step Voltage Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__STEP_VOLTAGE_INCREMENT = eINSTANCE.getTapChanger_StepVoltageIncrement();

		/**
		 * The meta object literal for the '<em><b>Subsequent Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__SUBSEQUENT_DELAY = eINSTANCE.getTapChanger_SubsequentDelay();

		/**
		 * The meta object literal for the '<em><b>Tcul Control Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_CHANGER__TCUL_CONTROL_MODE = eINSTANCE.getTapChanger_TculControlMode();

		/**
		 * The meta object literal for the '<em><b>Regulation Schedule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAP_CHANGER__REGULATION_SCHEDULE = eINSTANCE.getTapChanger_RegulationSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl <em>Power Transformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.PowerTransformerImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getPowerTransformer()
		 * @generated
		 */
		EClass POWER_TRANSFORMER = eINSTANCE.getPowerTransformer();

		/**
		 * The meta object literal for the '<em><b>Bmag Sat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_TRANSFORMER__BMAG_SAT = eINSTANCE.getPowerTransformer_BmagSat();

		/**
		 * The meta object literal for the '<em><b>Mag Base KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_TRANSFORMER__MAG_BASE_KV = eINSTANCE.getPowerTransformer_MagBaseKV();

		/**
		 * The meta object literal for the '<em><b>Mag Sat Flux</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_TRANSFORMER__MAG_SAT_FLUX = eINSTANCE.getPowerTransformer_MagSatFlux();

		/**
		 * The meta object literal for the '<em><b>Phases</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_TRANSFORMER__PHASES = eINSTANCE.getPowerTransformer_Phases();

		/**
		 * The meta object literal for the '<em><b>Transf Cooling Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_TRANSFORMER__TRANSF_COOLING_TYPE = eINSTANCE.getPowerTransformer_TransfCoolingType();

		/**
		 * The meta object literal for the '<em><b>Transformer Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_TRANSFORMER__TRANSFORMER_TYPE = eINSTANCE.getPowerTransformer_TransformerType();

		/**
		 * The meta object literal for the '<em><b>Heat Exchanger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_TRANSFORMER__HEAT_EXCHANGER = eINSTANCE.getPowerTransformer_HeatExchanger();

		/**
		 * The meta object literal for the '<em><b>Transformer Windings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_TRANSFORMER__TRANSFORMER_WINDINGS = eINSTANCE.getPowerTransformer_TransformerWindings();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl <em>Transformer Winding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getTransformerWinding()
		 * @generated
		 */
		EClass TRANSFORMER_WINDING = eINSTANCE.getTransformerWinding();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__B = eINSTANCE.getTransformerWinding_B();

		/**
		 * The meta object literal for the '<em><b>Insulation KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__INSULATION_KV = eINSTANCE.getTransformerWinding_InsulationKV();

		/**
		 * The meta object literal for the '<em><b>Connection Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__CONNECTION_TYPE = eINSTANCE.getTransformerWinding_ConnectionType();

		/**
		 * The meta object literal for the '<em><b>Emergency MVA</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__EMERGENCY_MVA = eINSTANCE.getTransformerWinding_EmergencyMVA();

		/**
		 * The meta object literal for the '<em><b>G</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__G = eINSTANCE.getTransformerWinding_G();

		/**
		 * The meta object literal for the '<em><b>Grounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__GROUNDED = eINSTANCE.getTransformerWinding_Grounded();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__R = eINSTANCE.getTransformerWinding_R();

		/**
		 * The meta object literal for the '<em><b>R0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__R0 = eINSTANCE.getTransformerWinding_R0();

		/**
		 * The meta object literal for the '<em><b>Rated KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__RATED_KV = eINSTANCE.getTransformerWinding_RatedKV();

		/**
		 * The meta object literal for the '<em><b>Rated MVA</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__RATED_MVA = eINSTANCE.getTransformerWinding_RatedMVA();

		/**
		 * The meta object literal for the '<em><b>Rground</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__RGROUND = eINSTANCE.getTransformerWinding_Rground();

		/**
		 * The meta object literal for the '<em><b>Short Term MVA</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__SHORT_TERM_MVA = eINSTANCE.getTransformerWinding_ShortTermMVA();

		/**
		 * The meta object literal for the '<em><b>Winding Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__WINDING_TYPE = eINSTANCE.getTransformerWinding_WindingType();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__X = eINSTANCE.getTransformerWinding_X();

		/**
		 * The meta object literal for the '<em><b>X0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__X0 = eINSTANCE.getTransformerWinding_X0();

		/**
		 * The meta object literal for the '<em><b>Xground</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMER_WINDING__XGROUND = eINSTANCE.getTransformerWinding_Xground();

		/**
		 * The meta object literal for the '<em><b>Power Transformer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMER_WINDING__POWER_TRANSFORMER = eINSTANCE.getTransformerWinding_PowerTransformer();

		/**
		 * The meta object literal for the '<em><b>Tap Changers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMER_WINDING__TAP_CHANGERS = eINSTANCE.getTransformerWinding_TapChangers();

		/**
		 * The meta object literal for the '<em><b>From Winding Tests</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMER_WINDING__FROM_WINDING_TESTS = eINSTANCE.getTransformerWinding_From_WindingTests();

		/**
		 * The meta object literal for the '<em><b>To Winding Test</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMER_WINDING__TO_WINDING_TEST = eINSTANCE.getTransformerWinding_To_WindingTest();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.LineImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getLine()
		 * @generated
		 */
		EClass LINE = eINSTANCE.getLine();

		/**
		 * The meta object literal for the '<em><b>AC Line Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__AC_LINE_SEGMENTS = eINSTANCE.getLine_ACLineSegments();

		/**
		 * The meta object literal for the '<em><b>DC Line Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__DC_LINE_SEGMENTS = eINSTANCE.getLine_DCLineSegments();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.VoltageControlZoneImpl <em>Voltage Control Zone</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.VoltageControlZoneImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getVoltageControlZone()
		 * @generated
		 */
		EClass VOLTAGE_CONTROL_ZONE = eINSTANCE.getVoltageControlZone();

		/**
		 * The meta object literal for the '<em><b>Busbar Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLTAGE_CONTROL_ZONE__BUSBAR_SECTION = eINSTANCE.getVoltageControlZone_BusbarSection();

		/**
		 * The meta object literal for the '<em><b>Regulation Schedule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE = eINSTANCE.getVoltageControlZone_RegulationSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl <em>Winding Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.WindingTestImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWindingTest()
		 * @generated
		 */
		EClass WINDING_TEST = eINSTANCE.getWindingTest();

		/**
		 * The meta object literal for the '<em><b>Exciting Current</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__EXCITING_CURRENT = eINSTANCE.getWindingTest_ExcitingCurrent();

		/**
		 * The meta object literal for the '<em><b>From Tap Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__FROM_TAP_STEP = eINSTANCE.getWindingTest_FromTapStep();

		/**
		 * The meta object literal for the '<em><b>Leakage Impedance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__LEAKAGE_IMPEDANCE = eINSTANCE.getWindingTest_LeakageImpedance();

		/**
		 * The meta object literal for the '<em><b>Load Loss</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__LOAD_LOSS = eINSTANCE.getWindingTest_LoadLoss();

		/**
		 * The meta object literal for the '<em><b>No Load Loss</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__NO_LOAD_LOSS = eINSTANCE.getWindingTest_NoLoadLoss();

		/**
		 * The meta object literal for the '<em><b>Phase Shift</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__PHASE_SHIFT = eINSTANCE.getWindingTest_PhaseShift();

		/**
		 * The meta object literal for the '<em><b>To Tap Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__TO_TAP_STEP = eINSTANCE.getWindingTest_ToTapStep();

		/**
		 * The meta object literal for the '<em><b>Voltage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDING_TEST__VOLTAGE = eINSTANCE.getWindingTest_Voltage();

		/**
		 * The meta object literal for the '<em><b>From Transformer Winding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDING_TEST__FROM_TRANSFORMER_WINDING = eINSTANCE.getWindingTest_From_TransformerWinding();

		/**
		 * The meta object literal for the '<em><b>To Transforme Windings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDING_TEST__TO_TRANSFORME_WINDINGS = eINSTANCE.getWindingTest_To_TransformeWindings();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl <em>Synchronous Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getSynchronousMachine()
		 * @generated
		 */
		EClass SYNCHRONOUS_MACHINE = eINSTANCE.getSynchronousMachine();

		/**
		 * The meta object literal for the '<em><b>AVR To Manual Lag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG = eINSTANCE.getSynchronousMachine_AVRToManualLag();

		/**
		 * The meta object literal for the '<em><b>AVR To Manual Lead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD = eINSTANCE.getSynchronousMachine_AVRToManualLead();

		/**
		 * The meta object literal for the '<em><b>Base MV Ar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__BASE_MV_AR = eINSTANCE.getSynchronousMachine_BaseMVAr();

		/**
		 * The meta object literal for the '<em><b>Coolant Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__COOLANT_CONDITION = eINSTANCE.getSynchronousMachine_CoolantCondition();

		/**
		 * The meta object literal for the '<em><b>Coolant Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__COOLANT_TYPE = eINSTANCE.getSynchronousMachine_CoolantType();

		/**
		 * The meta object literal for the '<em><b>Damping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__DAMPING = eINSTANCE.getSynchronousMachine_Damping();

		/**
		 * The meta object literal for the '<em><b>Inertia</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__INERTIA = eINSTANCE.getSynchronousMachine_Inertia();

		/**
		 * The meta object literal for the '<em><b>Manual To AVR</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__MANUAL_TO_AVR = eINSTANCE.getSynchronousMachine_ManualToAVR();

		/**
		 * The meta object literal for the '<em><b>Maximum KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__MAXIMUM_KV = eINSTANCE.getSynchronousMachine_MaximumKV();

		/**
		 * The meta object literal for the '<em><b>Maximum MV Ar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR = eINSTANCE.getSynchronousMachine_MaximumMVAr();

		/**
		 * The meta object literal for the '<em><b>Minimum KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__MINIMUM_KV = eINSTANCE.getSynchronousMachine_MinimumKV();

		/**
		 * The meta object literal for the '<em><b>Minimum MV Ar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__MINIMUM_MV_AR = eINSTANCE.getSynchronousMachine_MinimumMVAr();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__R = eINSTANCE.getSynchronousMachine_R();

		/**
		 * The meta object literal for the '<em><b>R0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__R0 = eINSTANCE.getSynchronousMachine_R0();

		/**
		 * The meta object literal for the '<em><b>Rated MVA</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__RATED_MVA = eINSTANCE.getSynchronousMachine_RatedMVA();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__X = eINSTANCE.getSynchronousMachine_X();

		/**
		 * The meta object literal for the '<em><b>X0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__X0 = eINSTANCE.getSynchronousMachine_X0();

		/**
		 * The meta object literal for the '<em><b>XDirect Subtrans</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS = eINSTANCE.getSynchronousMachine_XDirectSubtrans();

		/**
		 * The meta object literal for the '<em><b>XDirect Sync</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__XDIRECT_SYNC = eINSTANCE.getSynchronousMachine_XDirectSync();

		/**
		 * The meta object literal for the '<em><b>XDirect Trans</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__XDIRECT_TRANS = eINSTANCE.getSynchronousMachine_XDirectTrans();

		/**
		 * The meta object literal for the '<em><b>XQuad Subtrans</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS = eINSTANCE.getSynchronousMachine_XQuadSubtrans();

		/**
		 * The meta object literal for the '<em><b>XQuad Sync</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__XQUAD_SYNC = eINSTANCE.getSynchronousMachine_XQuadSync();

		/**
		 * The meta object literal for the '<em><b>XQuad Trans</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__XQUAD_TRANS = eINSTANCE.getSynchronousMachine_XQuadTrans();

		/**
		 * The meta object literal for the '<em><b>Operating Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__OPERATING_MODE = eINSTANCE.getSynchronousMachine_OperatingMode();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__TYPE = eINSTANCE.getSynchronousMachine_Type();

		/**
		 * The meta object literal for the '<em><b>Condenser MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONOUS_MACHINE__CONDENSER_MW = eINSTANCE.getSynchronousMachine_CondenserMW();

		/**
		 * The meta object literal for the '<em><b>MV Ar Capability Curves</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES = eINSTANCE.getSynchronousMachine_MVArCapabilityCurves();

		/**
		 * The meta object literal for the '<em><b>Drives Hydro Pump</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP = eINSTANCE.getSynchronousMachine_Drives_HydroPump();

		/**
		 * The meta object literal for the '<em><b>Generating Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONOUS_MACHINE__GENERATING_UNIT = eINSTANCE.getSynchronousMachine_GeneratingUnit();

		/**
		 * The meta object literal for the '<em><b>Prime Mover</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONOUS_MACHINE__PRIME_MOVER = eINSTANCE.getSynchronousMachine_PrimeMover();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl <em>MV Ar Capability Curve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.MVArCapabilityCurveImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getMVArCapabilityCurve()
		 * @generated
		 */
		EClass MV_AR_CAPABILITY_CURVE = eINSTANCE.getMVArCapabilityCurve();

		/**
		 * The meta object literal for the '<em><b>Coolant Temperature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MV_AR_CAPABILITY_CURVE__COOLANT_TEMPERATURE = eINSTANCE.getMVArCapabilityCurve_CoolantTemperature();

		/**
		 * The meta object literal for the '<em><b>Hydrogen Pressure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MV_AR_CAPABILITY_CURVE__HYDROGEN_PRESSURE = eINSTANCE.getMVArCapabilityCurve_HydrogenPressure();

		/**
		 * The meta object literal for the '<em><b>Synchronous Machines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES = eINSTANCE.getMVArCapabilityCurve_SynchronousMachines();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl <em>Equivalent Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.EquivalentSourceImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getEquivalentSource()
		 * @generated
		 */
		EClass EQUIVALENT_SOURCE = eINSTANCE.getEquivalentSource();

		/**
		 * The meta object literal for the '<em><b>Xn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__XN = eINSTANCE.getEquivalentSource_Xn();

		/**
		 * The meta object literal for the '<em><b>Rn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__RN = eINSTANCE.getEquivalentSource_Rn();

		/**
		 * The meta object literal for the '<em><b>Nominal Voltage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__NOMINAL_VOLTAGE = eINSTANCE.getEquivalentSource_NominalVoltage();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__X = eINSTANCE.getEquivalentSource_X();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__R = eINSTANCE.getEquivalentSource_R();

		/**
		 * The meta object literal for the '<em><b>Voltage Angle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__VOLTAGE_ANGLE = eINSTANCE.getEquivalentSource_VoltageAngle();

		/**
		 * The meta object literal for the '<em><b>Voltage Magnitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__VOLTAGE_MAGNITUDE = eINSTANCE.getEquivalentSource_VoltageMagnitude();

		/**
		 * The meta object literal for the '<em><b>X0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__X0 = eINSTANCE.getEquivalentSource_X0();

		/**
		 * The meta object literal for the '<em><b>R0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__R0 = eINSTANCE.getEquivalentSource_R0();

		/**
		 * The meta object literal for the '<em><b>Active Power</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_SOURCE__ACTIVE_POWER = eINSTANCE.getEquivalentSource_ActivePower();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.WireTypeImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWireType()
		 * @generated
		 */
		EClass WIRE_TYPE = eINSTANCE.getWireType();

		/**
		 * The meta object literal for the '<em><b>Phase Conductor Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_TYPE__PHASE_CONDUCTOR_COUNT = eINSTANCE.getWireType_PhaseConductorCount();

		/**
		 * The meta object literal for the '<em><b>Phase Conductor Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_TYPE__PHASE_CONDUCTOR_SPACING = eINSTANCE.getWireType_PhaseConductorSpacing();

		/**
		 * The meta object literal for the '<em><b>Amp Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_TYPE__AMP_RATING = eINSTANCE.getWireType_AmpRating();

		/**
		 * The meta object literal for the '<em><b>GMR</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_TYPE__GMR = eINSTANCE.getWireType_GMR();

		/**
		 * The meta object literal for the '<em><b>Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_TYPE__RADIUS = eINSTANCE.getWireType_Radius();

		/**
		 * The meta object literal for the '<em><b>Resistance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_TYPE__RESISTANCE = eINSTANCE.getWireType_Resistance();

		/**
		 * The meta object literal for the '<em><b>Wire Arrangements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE_TYPE__WIRE_ARRANGEMENTS = eINSTANCE.getWireType_WireArrangements();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.WireArrangementImpl <em>Arrangement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.WireArrangementImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWireArrangement()
		 * @generated
		 */
		EClass WIRE_ARRANGEMENT = eINSTANCE.getWireArrangement();

		/**
		 * The meta object literal for the '<em><b>Mounting Point X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_ARRANGEMENT__MOUNTING_POINT_X = eINSTANCE.getWireArrangement_MountingPointX();

		/**
		 * The meta object literal for the '<em><b>Mounting Point Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE_ARRANGEMENT__MOUNTING_POINT_Y = eINSTANCE.getWireArrangement_MountingPointY();

		/**
		 * The meta object literal for the '<em><b>Conductor Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE_ARRANGEMENT__CONDUCTOR_TYPE = eINSTANCE.getWireArrangement_ConductorType();

		/**
		 * The meta object literal for the '<em><b>Wire Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE_ARRANGEMENT__WIRE_TYPE = eINSTANCE.getWireArrangement_WireType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.LoadBreakSwitchImpl <em>Load Break Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.LoadBreakSwitchImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getLoadBreakSwitch()
		 * @generated
		 */
		EClass LOAD_BREAK_SWITCH = eINSTANCE.getLoadBreakSwitch();

		/**
		 * The meta object literal for the '<em><b>Amp Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BREAK_SWITCH__AMP_RATING = eINSTANCE.getLoadBreakSwitch_AmpRating();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.JunctionImpl <em>Junction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.JunctionImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getJunction()
		 * @generated
		 */
		EClass JUNCTION = eINSTANCE.getJunction();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl <em>Energy Consumer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getEnergyConsumer()
		 * @generated
		 */
		EClass ENERGY_CONSUMER = eINSTANCE.getEnergyConsumer();

		/**
		 * The meta object literal for the '<em><b>Load Demand Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENERGY_CONSUMER__LOAD_DEMAND_MODELS = eINSTANCE.getEnergyConsumer_LoadDemandModels();

		/**
		 * The meta object literal for the '<em><b>Non Conform Load Schedules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES = eINSTANCE.getEnergyConsumer_NonConformLoadSchedules();

		/**
		 * The meta object literal for the '<em><b>Load Area</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENERGY_CONSUMER__LOAD_AREA = eINSTANCE.getEnergyConsumer_LoadArea();

		/**
		 * The meta object literal for the '<em><b>Power Cut Zone</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENERGY_CONSUMER__POWER_CUT_ZONE = eINSTANCE.getEnergyConsumer_PowerCutZone();

		/**
		 * The meta object literal for the '<em><b>Conforming Load Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__CONFORMING_LOAD_FLAG = eINSTANCE.getEnergyConsumer_ConformingLoadFlag();

		/**
		 * The meta object literal for the '<em><b>Customer Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__CUSTOMER_COUNT = eINSTANCE.getEnergyConsumer_CustomerCount();

		/**
		 * The meta object literal for the '<em><b>PFexp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__PFEXP = eINSTANCE.getEnergyConsumer_PFexp();

		/**
		 * The meta object literal for the '<em><b>Pfixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__PFIXED = eINSTANCE.getEnergyConsumer_Pfixed();

		/**
		 * The meta object literal for the '<em><b>Pfixed Pct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__PFIXED_PCT = eINSTANCE.getEnergyConsumer_PfixedPct();

		/**
		 * The meta object literal for the '<em><b>Pnom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__PNOM = eINSTANCE.getEnergyConsumer_Pnom();

		/**
		 * The meta object literal for the '<em><b>Pnom Pct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__PNOM_PCT = eINSTANCE.getEnergyConsumer_PnomPct();

		/**
		 * The meta object literal for the '<em><b>Power Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__POWER_FACTOR = eINSTANCE.getEnergyConsumer_PowerFactor();

		/**
		 * The meta object literal for the '<em><b>PVexp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__PVEXP = eINSTANCE.getEnergyConsumer_PVexp();

		/**
		 * The meta object literal for the '<em><b>QFexp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__QFEXP = eINSTANCE.getEnergyConsumer_QFexp();

		/**
		 * The meta object literal for the '<em><b>Qfixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__QFIXED = eINSTANCE.getEnergyConsumer_Qfixed();

		/**
		 * The meta object literal for the '<em><b>Qfixed Pct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__QFIXED_PCT = eINSTANCE.getEnergyConsumer_QfixedPct();

		/**
		 * The meta object literal for the '<em><b>Qnom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__QNOM = eINSTANCE.getEnergyConsumer_Qnom();

		/**
		 * The meta object literal for the '<em><b>Qnom Pct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__QNOM_PCT = eINSTANCE.getEnergyConsumer_QnomPct();

		/**
		 * The meta object literal for the '<em><b>QVexp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENERGY_CONSUMER__QVEXP = eINSTANCE.getEnergyConsumer_QVexp();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.ConnectorImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.RegulatingCondEqImpl <em>Regulating Cond Eq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.RegulatingCondEqImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getRegulatingCondEq()
		 * @generated
		 */
		EClass REGULATING_COND_EQ = eINSTANCE.getRegulatingCondEq();

		/**
		 * The meta object literal for the '<em><b>Regulation Schedule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGULATING_COND_EQ__REGULATION_SCHEDULE = eINSTANCE.getRegulatingCondEq_RegulationSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.GroundDisconnectorImpl <em>Ground Disconnector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.GroundDisconnectorImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getGroundDisconnector()
		 * @generated
		 */
		EClass GROUND_DISCONNECTOR = eINSTANCE.getGroundDisconnector();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.CompositeSwitchImpl <em>Composite Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.CompositeSwitchImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getCompositeSwitch()
		 * @generated
		 */
		EClass COMPOSITE_SWITCH = eINSTANCE.getCompositeSwitch();

		/**
		 * The meta object literal for the '<em><b>Composite Switch Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_SWITCH__COMPOSITE_SWITCH_TYPE = eINSTANCE.getCompositeSwitch_CompositeSwitchType();

		/**
		 * The meta object literal for the '<em><b>Switches</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SWITCH__SWITCHES = eINSTANCE.getCompositeSwitch_Switches();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.WiresVersionImpl <em>Wires Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.WiresVersionImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getWiresVersion()
		 * @generated
		 */
		EClass WIRES_VERSION = eINSTANCE.getWiresVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRES_VERSION__VERSION = eINSTANCE.getWiresVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRES_VERSION__DATE = eINSTANCE.getWiresVersion_Date();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl <em>Frequency Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl
		 * @see org.opencim.cim.iec61970.wire.impl.WirePackageImpl#getFrequencyConverter()
		 * @generated
		 */
		EClass FREQUENCY_CONVERTER = eINSTANCE.getFrequencyConverter();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY_CONVERTER__FREQUENCY = eINSTANCE.getFrequencyConverter_Frequency();

		/**
		 * The meta object literal for the '<em><b>Maximum MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY_CONVERTER__MAXIMUM_MW = eINSTANCE.getFrequencyConverter_MaximumMW();

		/**
		 * The meta object literal for the '<em><b>Maximum KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY_CONVERTER__MAXIMUM_KV = eINSTANCE.getFrequencyConverter_MaximumKV();

		/**
		 * The meta object literal for the '<em><b>Minimum MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY_CONVERTER__MINIMUM_MW = eINSTANCE.getFrequencyConverter_MinimumMW();

		/**
		 * The meta object literal for the '<em><b>Minimum KV</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY_CONVERTER__MINIMUM_KV = eINSTANCE.getFrequencyConverter_MinimumKV();

		/**
		 * The meta object literal for the '<em><b>Operating Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY_CONVERTER__OPERATING_MODE = eINSTANCE.getFrequencyConverter_OperatingMode();

	}

} //WirePackage
