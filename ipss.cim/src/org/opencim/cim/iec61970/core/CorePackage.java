/**
 * <copyright>
 * </copyright>
 *
 * $Id: CorePackage.java,v 1.5 2007/03/07 16:03:51 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim.cim.iec61970.core ";

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
	CorePackage eINSTANCE = org.opencim.cim.iec61970.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.NamingImpl <em>Naming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.NamingImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getNaming()
	 * @generated
	 */
	int NAMING = 13;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMING__ALIAS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMING__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMING__NAME = 2;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMING__PATH_NAME = 3;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMING__MRID = 4;

	/**
	 * The number of structural features of the '<em>Naming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMING_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl <em>Power System Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getPowerSystemResource()
	 * @generated
	 */
	int POWER_SYSTEM_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__SIMU_MODEL = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__COMPANIES = NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE__PSR_TYPE = NAMING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Power System Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SYSTEM_RESOURCE_FEATURE_COUNT = NAMING_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl <em>Equipment Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getEquipmentContainer()
	 * @generated
	 */
	int EQUIPMENT_CONTAINER = 16;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__ALIAS_NAME = POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__DESCRIPTION = POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__NAME = POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__PATH_NAME = POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__MRID = POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__SIMU_MODEL = POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__COMPANIES = POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__PSR_TYPE = POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Connectivity Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__CONNECTIVITY_NODES = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER__EQUIPMENTS = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Equipment Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_CONTAINER_FEATURE_COUNT = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.BayImpl <em>Bay</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.BayImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getBay()
	 * @generated
	 */
	int BAY = 0;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__ALIAS_NAME = EQUIPMENT_CONTAINER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__DESCRIPTION = EQUIPMENT_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__NAME = EQUIPMENT_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__PATH_NAME = EQUIPMENT_CONTAINER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__MRID = EQUIPMENT_CONTAINER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__SIMU_MODEL = EQUIPMENT_CONTAINER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__COMPANIES = EQUIPMENT_CONTAINER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__PSR_TYPE = EQUIPMENT_CONTAINER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Connectivity Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__CONNECTIVITY_NODES = EQUIPMENT_CONTAINER__CONNECTIVITY_NODES;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__EQUIPMENTS = EQUIPMENT_CONTAINER__EQUIPMENTS;

	/**
	 * The feature id for the '<em><b>Bay Energy Meas Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__BAY_ENERGY_MEAS_FLAG = EQUIPMENT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bay Power Meas Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__BAY_POWER_MEAS_FLAG = EQUIPMENT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Breaker Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__BREAKER_CONFIGURATION = EQUIPMENT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bus Bar Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__BUS_BAR_CONFIGURATION = EQUIPMENT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Voltage Level</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__VOLTAGE_LEVEL = EQUIPMENT_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Substation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY__SUBSTATION = EQUIPMENT_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Bay</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAY_FEATURE_COUNT = EQUIPMENT_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.CompanyImpl <em>Company</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.CompanyImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCompany()
	 * @generated
	 */
	int COMPANY = 19;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.EquipmentImpl <em>Equipment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.EquipmentImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getEquipment()
	 * @generated
	 */
	int EQUIPMENT = 14;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ALIAS_NAME = POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__DESCRIPTION = POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__NAME = POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PATH_NAME = POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__MRID = POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__SIMU_MODEL = POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__COMPANIES = POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PSR_TYPE = POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_CONTAINER = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Equipment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_FEATURE_COUNT = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl <em>Conducting Equipment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getConductingEquipment()
	 * @generated
	 */
	int CONDUCTING_EQUIPMENT = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__ALIAS_NAME = EQUIPMENT__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__DESCRIPTION = EQUIPMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__NAME = EQUIPMENT__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__PATH_NAME = EQUIPMENT__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__MRID = EQUIPMENT__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__SIMU_MODEL = EQUIPMENT__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__COMPANIES = EQUIPMENT__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__PSR_TYPE = EQUIPMENT__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__EQUIPMENT_CONTAINER = EQUIPMENT__EQUIPMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__PHASES = EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__TERMINALS = EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT__BASE_VOLTAGE = EQUIPMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conducting Equipment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDUCTING_EQUIPMENT_FEATURE_COUNT = EQUIPMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.ControlHouseEquipmentImpl <em>Control House Equipment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.ControlHouseEquipmentImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getControlHouseEquipment()
	 * @generated
	 */
	int CONTROL_HOUSE_EQUIPMENT = 2;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__ALIAS_NAME = POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__DESCRIPTION = POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__NAME = POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__PATH_NAME = POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__MRID = POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__SIMU_MODEL = POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__COMPANIES = POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__PSR_TYPE = POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Control House Equip Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control House Equipment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HOUSE_EQUIPMENT_FEATURE_COUNT = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.SubstationImpl <em>Substation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.SubstationImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getSubstation()
	 * @generated
	 */
	int SUBSTATION = 4;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__ALIAS_NAME = EQUIPMENT_CONTAINER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__DESCRIPTION = EQUIPMENT_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__NAME = EQUIPMENT_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__PATH_NAME = EQUIPMENT_CONTAINER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__MRID = EQUIPMENT_CONTAINER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__SIMU_MODEL = EQUIPMENT_CONTAINER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__COMPANIES = EQUIPMENT_CONTAINER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__PSR_TYPE = EQUIPMENT_CONTAINER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Connectivity Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__CONNECTIVITY_NODES = EQUIPMENT_CONTAINER__CONNECTIVITY_NODES;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__EQUIPMENTS = EQUIPMENT_CONTAINER__EQUIPMENTS;

	/**
	 * The feature id for the '<em><b>Sub Control Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__SUB_CONTROL_AREA = EQUIPMENT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Load Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__LOAD_AREA = EQUIPMENT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Voltage Levels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__VOLTAGE_LEVELS = EQUIPMENT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bays</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__BAYS = EQUIPMENT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contains Composite Switches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION__CONTAINS_COMPOSITE_SWITCHES = EQUIPMENT_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Substation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTATION_FEATURE_COUNT = EQUIPMENT_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.TerminalImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 5;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Conducting Equipment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__CONDUCTING_EQUIPMENT = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connectivity Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__CONNECTIVITY_NODE = NAMING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = NAMING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.SubControlAreaImpl <em>Sub Control Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.SubControlAreaImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getSubControlArea()
	 * @generated
	 */
	int SUB_CONTROL_AREA = 6;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__ALIAS_NAME = POWER_SYSTEM_RESOURCE__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__DESCRIPTION = POWER_SYSTEM_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__NAME = POWER_SYSTEM_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__PATH_NAME = POWER_SYSTEM_RESOURCE__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__MRID = POWER_SYSTEM_RESOURCE__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__SIMU_MODEL = POWER_SYSTEM_RESOURCE__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__COMPANIES = POWER_SYSTEM_RESOURCE__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__PSR_TYPE = POWER_SYSTEM_RESOURCE__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Substations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__SUBSTATIONS = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generating Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA__GENERATING_UNITS = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub Control Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTROL_AREA_FEATURE_COUNT = POWER_SYSTEM_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl <em>Curve Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.CurveScheduleImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCurveSchedule()
	 * @generated
	 */
	int CURVE_SCHEDULE = 7;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Curve Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__CURVE_STYLE = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ramp Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__RAMP_METHOD = NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ramp Start Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__RAMP_START_METHOD = NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ramp Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__RAMP_UNITS = NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>XAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__XAXIS_TYPE = NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>XAxis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__XAXIS_QUANTITY = NAMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__Y1_AXIS_QUANTITY = NAMING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__Y2_AXIS_QUANTITY = NAMING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>YAxis Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__YAXIS_TYPE = NAMING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS = NAMING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA = NAMING_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Curve Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHEDULE_FEATURE_COUNT = NAMING_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl <em>Curve Sched Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCurveSchedData()
	 * @generated
	 */
	int CURVE_SCHED_DATA = 8;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Ramp Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__RAMP_DATA = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ramp Data Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__RAMP_DATA_VALUE = NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>XAxis Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__XAXIS_DATA = NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Y1 Axis Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__Y1_AXIS_DATA = NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Y2 Axis Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__Y2_AXIS_DATA = NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Curve Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA__CURVE_SCHEDULE = NAMING_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Curve Sched Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_DATA_FEATURE_COUNT = NAMING_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl <em>Curve Sched Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCurveSchedFormula()
	 * @generated
	 */
	int CURVE_SCHED_FORMULA = 9;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>XLower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__XLOWER_BOUND = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>XUpper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__XUPPER_BOUND = NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>YFunction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__YFUNCTION = NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Curve Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA__CURVE_SCHEDULE = NAMING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Curve Sched Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURVE_SCHED_FORMULA_FEATURE_COUNT = NAMING_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.BaseVoltageImpl <em>Base Voltage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.BaseVoltageImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getBaseVoltage()
	 * @generated
	 */
	int BASE_VOLTAGE = 10;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Nominal Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__NOMINAL_VOLTAGE = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Power</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__BASE_POWER = NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conducting Equipment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__CONDUCTING_EQUIPMENT = NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Voltage Level</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE__VOLTAGE_LEVEL = NAMING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Base Voltage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VOLTAGE_FEATURE_COUNT = NAMING_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.BasePowerImpl <em>Base Power</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.BasePowerImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getBasePower()
	 * @generated
	 */
	int BASE_POWER = 11;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Base Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__BASE_POWER = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Voltages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER__BASE_VOLTAGES = NAMING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Base Power</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_POWER_FEATURE_COUNT = NAMING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl <em>Voltage Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.VoltageLevelImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getVoltageLevel()
	 * @generated
	 */
	int VOLTAGE_LEVEL = 12;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__ALIAS_NAME = EQUIPMENT_CONTAINER__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__DESCRIPTION = EQUIPMENT_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__NAME = EQUIPMENT_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__PATH_NAME = EQUIPMENT_CONTAINER__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__MRID = EQUIPMENT_CONTAINER__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__SIMU_MODEL = EQUIPMENT_CONTAINER__SIMU_MODEL;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__COMPANIES = EQUIPMENT_CONTAINER__COMPANIES;

	/**
	 * The feature id for the '<em><b>PSR Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__PSR_TYPE = EQUIPMENT_CONTAINER__PSR_TYPE;

	/**
	 * The feature id for the '<em><b>Connectivity Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__CONNECTIVITY_NODES = EQUIPMENT_CONTAINER__CONNECTIVITY_NODES;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__EQUIPMENTS = EQUIPMENT_CONTAINER__EQUIPMENTS;

	/**
	 * The feature id for the '<em><b>High Voltage Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT = EQUIPMENT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Low Voltage Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT = EQUIPMENT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Substation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__SUBSTATION = EQUIPMENT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bays</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__BAYS = EQUIPMENT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Voltage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL__BASE_VOLTAGE = EQUIPMENT_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Voltage Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLTAGE_LEVEL_FEATURE_COUNT = EQUIPMENT_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.UnitImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 15;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__MRID = NAMING__MRID;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = NAMING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.PSRTypeImpl <em>PSR Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.PSRTypeImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getPSRType()
	 * @generated
	 */
	int PSR_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Power System Resource</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE__POWER_SYSTEM_RESOURCE = NAMING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PSR Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSR_TYPE_FEATURE_COUNT = NAMING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.core.impl.CoreVersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.core.impl.CoreVersionImpl
	 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCoreVersion()
	 * @generated
	 */
	int CORE_VERSION = 18;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_VERSION_FEATURE_COUNT = 2;


	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__ALIAS_NAME = NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__DESCRIPTION = NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__NAME = NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__PATH_NAME = NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__MRID = NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__SIMU_MODEL = NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Company Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__COMPANY_TYPE = NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>PS Rs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__PS_RS = NAMING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_FEATURE_COUNT = NAMING_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Bay <em>Bay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bay</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay
	 * @generated
	 */
	EClass getBay();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Bay#getBayEnergyMeasFlag <em>Bay Energy Meas Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bay Energy Meas Flag</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay#getBayEnergyMeasFlag()
	 * @see #getBay()
	 * @generated
	 */
	EAttribute getBay_BayEnergyMeasFlag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Bay#getBayPowerMeasFlag <em>Bay Power Meas Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bay Power Meas Flag</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay#getBayPowerMeasFlag()
	 * @see #getBay()
	 * @generated
	 */
	EAttribute getBay_BayPowerMeasFlag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Bay#getBreakerConfiguration <em>Breaker Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breaker Configuration</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay#getBreakerConfiguration()
	 * @see #getBay()
	 * @generated
	 */
	EAttribute getBay_BreakerConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Bay#getBusBarConfiguration <em>Bus Bar Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bus Bar Configuration</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay#getBusBarConfiguration()
	 * @see #getBay()
	 * @generated
	 */
	EAttribute getBay_BusBarConfiguration();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.Bay#getVoltageLevel <em>Voltage Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Voltage Level</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay#getVoltageLevel()
	 * @see #getBay()
	 * @generated
	 */
	EReference getBay_VoltageLevel();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.Bay#getSubstation <em>Substation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Substation</em>'.
	 * @see org.opencim.cim.iec61970.core.Bay#getSubstation()
	 * @see #getBay()
	 * @generated
	 */
	EReference getBay_Substation();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Company</em>'.
	 * @see org.opencim.cim.iec61970.core.Company
	 * @generated
	 */
	EClass getCompany();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.Company#getSimuModel <em>Simu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simu Model</em>'.
	 * @see org.opencim.cim.iec61970.core.Company#getSimuModel()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_SimuModel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Company#getCompanyType <em>Company Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company Type</em>'.
	 * @see org.opencim.cim.iec61970.core.Company#getCompanyType()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_CompanyType();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.Company#getPSRs <em>PS Rs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>PS Rs</em>'.
	 * @see org.opencim.cim.iec61970.core.Company#getPSRs()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_PSRs();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.ConductingEquipment <em>Conducting Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conducting Equipment</em>'.
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment
	 * @generated
	 */
	EClass getConductingEquipment();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getPhases <em>Phases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phases</em>'.
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment#getPhases()
	 * @see #getConductingEquipment()
	 * @generated
	 */
	EAttribute getConductingEquipment_Phases();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getTerminals <em>Terminals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Terminals</em>'.
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment#getTerminals()
	 * @see #getConductingEquipment()
	 * @generated
	 */
	EReference getConductingEquipment_Terminals();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getBaseVoltage <em>Base Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Voltage</em>'.
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment#getBaseVoltage()
	 * @see #getConductingEquipment()
	 * @generated
	 */
	EReference getConductingEquipment_BaseVoltage();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.ControlHouseEquipment <em>Control House Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control House Equipment</em>'.
	 * @see org.opencim.cim.iec61970.core.ControlHouseEquipment
	 * @generated
	 */
	EClass getControlHouseEquipment();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.ControlHouseEquipment#getControlHouseEquipType <em>Control House Equip Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control House Equip Type</em>'.
	 * @see org.opencim.cim.iec61970.core.ControlHouseEquipment#getControlHouseEquipType()
	 * @see #getControlHouseEquipment()
	 * @generated
	 */
	EAttribute getControlHouseEquipment_ControlHouseEquipType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.PowerSystemResource <em>Power System Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power System Resource</em>'.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource
	 * @generated
	 */
	EClass getPowerSystemResource();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getSimuModel <em>Simu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simu Model</em>'.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource#getSimuModel()
	 * @see #getPowerSystemResource()
	 * @generated
	 */
	EReference getPowerSystemResource_SimuModel();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getCompanies <em>Companies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Companies</em>'.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource#getCompanies()
	 * @see #getPowerSystemResource()
	 * @generated
	 */
	EReference getPowerSystemResource_Companies();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getPSRType <em>PSR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>PSR Type</em>'.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource#getPSRType()
	 * @see #getPowerSystemResource()
	 * @generated
	 */
	EReference getPowerSystemResource_PSRType();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Substation <em>Substation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substation</em>'.
	 * @see org.opencim.cim.iec61970.core.Substation
	 * @generated
	 */
	EClass getSubstation();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.Substation#getSubControlArea <em>Sub Control Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Sub Control Area</em>'.
	 * @see org.opencim.cim.iec61970.core.Substation#getSubControlArea()
	 * @see #getSubstation()
	 * @generated
	 */
	EReference getSubstation_SubControlArea();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.core.Substation#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Load Area</em>'.
	 * @see org.opencim.cim.iec61970.core.Substation#getLoadArea()
	 * @see #getSubstation()
	 * @generated
	 */
	EReference getSubstation_LoadArea();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.Substation#getVoltageLevels <em>Voltage Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Voltage Levels</em>'.
	 * @see org.opencim.cim.iec61970.core.Substation#getVoltageLevels()
	 * @see #getSubstation()
	 * @generated
	 */
	EReference getSubstation_VoltageLevels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.Substation#getBays <em>Bays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bays</em>'.
	 * @see org.opencim.cim.iec61970.core.Substation#getBays()
	 * @see #getSubstation()
	 * @generated
	 */
	EReference getSubstation_Bays();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.Substation#getContains_CompositeSwitches <em>Contains Composite Switches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains Composite Switches</em>'.
	 * @see org.opencim.cim.iec61970.core.Substation#getContains_CompositeSwitches()
	 * @see #getSubstation()
	 * @generated
	 */
	EReference getSubstation_Contains_CompositeSwitches();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see org.opencim.cim.iec61970.core.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.core.Terminal#getConductingEquipment <em>Conducting Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conducting Equipment</em>'.
	 * @see org.opencim.cim.iec61970.core.Terminal#getConductingEquipment()
	 * @see #getTerminal()
	 * @generated
	 */
	EReference getTerminal_ConductingEquipment();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.Terminal#getConnectivityNode <em>Connectivity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Connectivity Node</em>'.
	 * @see org.opencim.cim.iec61970.core.Terminal#getConnectivityNode()
	 * @see #getTerminal()
	 * @generated
	 */
	EReference getTerminal_ConnectivityNode();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.SubControlArea <em>Sub Control Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Control Area</em>'.
	 * @see org.opencim.cim.iec61970.core.SubControlArea
	 * @generated
	 */
	EClass getSubControlArea();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.SubControlArea#getSubstations <em>Substations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Substations</em>'.
	 * @see org.opencim.cim.iec61970.core.SubControlArea#getSubstations()
	 * @see #getSubControlArea()
	 * @generated
	 */
	EReference getSubControlArea_Substations();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.SubControlArea#getGeneratingUnits <em>Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Generating Units</em>'.
	 * @see org.opencim.cim.iec61970.core.SubControlArea#getGeneratingUnits()
	 * @see #getSubControlArea()
	 * @generated
	 */
	EReference getSubControlArea_GeneratingUnits();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.CurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Curve Schedule</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule
	 * @generated
	 */
	EClass getCurveSchedule();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveStyle <em>Curve Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Curve Style</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getCurveStyle()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_CurveStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampMethod <em>Ramp Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ramp Method</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getRampMethod()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_RampMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampStartMethod <em>Ramp Start Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ramp Start Method</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getRampStartMethod()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_RampStartMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampUnits <em>Ramp Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ramp Units</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getRampUnits()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_RampUnits();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getXAxisType <em>XAxis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XAxis Type</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getXAxisType()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_XAxisType();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getXAxisQuantity <em>XAxis Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XAxis Quantity</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getXAxisQuantity()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_XAxisQuantity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getY1AxisQuantity <em>Y1 Axis Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y1 Axis Quantity</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getY1AxisQuantity()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_Y1AxisQuantity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getY2AxisQuantity <em>Y2 Axis Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y2 Axis Quantity</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getY2AxisQuantity()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_Y2AxisQuantity();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedule#getYAxisType <em>YAxis Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YAxis Type</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getYAxisType()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EAttribute getCurveSchedule_YAxisType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleDatas <em>Curve Schedule Datas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Curve Schedule Datas</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleDatas()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EReference getCurveSchedule_CurveScheduleDatas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleFormula <em>Curve Schedule Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Curve Schedule Formula</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleFormula()
	 * @see #getCurveSchedule()
	 * @generated
	 */
	EReference getCurveSchedule_CurveScheduleFormula();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.CurveSchedData <em>Curve Sched Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Curve Sched Data</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData
	 * @generated
	 */
	EClass getCurveSchedData();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedData#getRampData <em>Ramp Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ramp Data</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getRampData()
	 * @see #getCurveSchedData()
	 * @generated
	 */
	EAttribute getCurveSchedData_RampData();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedData#getRampDataValue <em>Ramp Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ramp Data Value</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getRampDataValue()
	 * @see #getCurveSchedData()
	 * @generated
	 */
	EAttribute getCurveSchedData_RampDataValue();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedData#getXAxisData <em>XAxis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XAxis Data</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getXAxisData()
	 * @see #getCurveSchedData()
	 * @generated
	 */
	EAttribute getCurveSchedData_XAxisData();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedData#getY1AxisData <em>Y1 Axis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y1 Axis Data</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getY1AxisData()
	 * @see #getCurveSchedData()
	 * @generated
	 */
	EAttribute getCurveSchedData_Y1AxisData();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedData#getY2AxisData <em>Y2 Axis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y2 Axis Data</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getY2AxisData()
	 * @see #getCurveSchedData()
	 * @generated
	 */
	EAttribute getCurveSchedData_Y2AxisData();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.CurveSchedData#getCurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Curve Schedule</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getCurveSchedule()
	 * @see #getCurveSchedData()
	 * @generated
	 */
	EReference getCurveSchedData_CurveSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.CurveSchedFormula <em>Curve Sched Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Curve Sched Formula</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula
	 * @generated
	 */
	EClass getCurveSchedFormula();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getXLowerBound <em>XLower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XLower Bound</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula#getXLowerBound()
	 * @see #getCurveSchedFormula()
	 * @generated
	 */
	EAttribute getCurveSchedFormula_XLowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getXUpperBound <em>XUpper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XUpper Bound</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula#getXUpperBound()
	 * @see #getCurveSchedFormula()
	 * @generated
	 */
	EAttribute getCurveSchedFormula_XUpperBound();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getYFunction <em>YFunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YFunction</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula#getYFunction()
	 * @see #getCurveSchedFormula()
	 * @generated
	 */
	EAttribute getCurveSchedFormula_YFunction();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getCurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Curve Schedule</em>'.
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula#getCurveSchedule()
	 * @see #getCurveSchedFormula()
	 * @generated
	 */
	EReference getCurveSchedFormula_CurveSchedule();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.BaseVoltage <em>Base Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Voltage</em>'.
	 * @see org.opencim.cim.iec61970.core.BaseVoltage
	 * @generated
	 */
	EClass getBaseVoltage();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.BaseVoltage#getNominalVoltage <em>Nominal Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nominal Voltage</em>'.
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getNominalVoltage()
	 * @see #getBaseVoltage()
	 * @generated
	 */
	EAttribute getBaseVoltage_NominalVoltage();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.BaseVoltage#getBasePower <em>Base Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Base Power</em>'.
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getBasePower()
	 * @see #getBaseVoltage()
	 * @generated
	 */
	EReference getBaseVoltage_BasePower();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.BaseVoltage#getConductingEquipment <em>Conducting Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conducting Equipment</em>'.
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getConductingEquipment()
	 * @see #getBaseVoltage()
	 * @generated
	 */
	EReference getBaseVoltage_ConductingEquipment();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.BaseVoltage#getVoltageLevel <em>Voltage Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Voltage Level</em>'.
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getVoltageLevel()
	 * @see #getBaseVoltage()
	 * @generated
	 */
	EReference getBaseVoltage_VoltageLevel();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.BasePower <em>Base Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Power</em>'.
	 * @see org.opencim.cim.iec61970.core.BasePower
	 * @generated
	 */
	EClass getBasePower();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.BasePower#getBasePower <em>Base Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Power</em>'.
	 * @see org.opencim.cim.iec61970.core.BasePower#getBasePower()
	 * @see #getBasePower()
	 * @generated
	 */
	EAttribute getBasePower_BasePower();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.BasePower#getBaseVoltages <em>Base Voltages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Base Voltages</em>'.
	 * @see org.opencim.cim.iec61970.core.BasePower#getBaseVoltages()
	 * @see #getBasePower()
	 * @generated
	 */
	EReference getBasePower_BaseVoltages();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.VoltageLevel <em>Voltage Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voltage Level</em>'.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel
	 * @generated
	 */
	EClass getVoltageLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.VoltageLevel#getHighVoltageLimit <em>High Voltage Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High Voltage Limit</em>'.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getHighVoltageLimit()
	 * @see #getVoltageLevel()
	 * @generated
	 */
	EAttribute getVoltageLevel_HighVoltageLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.VoltageLevel#getLowVoltageLimit <em>Low Voltage Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low Voltage Limit</em>'.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getLowVoltageLimit()
	 * @see #getVoltageLevel()
	 * @generated
	 */
	EAttribute getVoltageLevel_LowVoltageLimit();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.VoltageLevel#getSubstation <em>Substation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Substation</em>'.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getSubstation()
	 * @see #getVoltageLevel()
	 * @generated
	 */
	EReference getVoltageLevel_Substation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.VoltageLevel#getBays <em>Bays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bays</em>'.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getBays()
	 * @see #getVoltageLevel()
	 * @generated
	 */
	EReference getVoltageLevel_Bays();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.core.VoltageLevel#getBaseVoltage <em>Base Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Voltage</em>'.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getBaseVoltage()
	 * @see #getVoltageLevel()
	 * @generated
	 */
	EReference getVoltageLevel_BaseVoltage();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Naming <em>Naming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Naming</em>'.
	 * @see org.opencim.cim.iec61970.core.Naming
	 * @generated
	 */
	EClass getNaming();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Naming#getAliasName <em>Alias Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias Name</em>'.
	 * @see org.opencim.cim.iec61970.core.Naming#getAliasName()
	 * @see #getNaming()
	 * @generated
	 */
	EAttribute getNaming_AliasName();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Naming#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.opencim.cim.iec61970.core.Naming#getDescription()
	 * @see #getNaming()
	 * @generated
	 */
	EAttribute getNaming_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Naming#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.opencim.cim.iec61970.core.Naming#getName()
	 * @see #getNaming()
	 * @generated
	 */
	EAttribute getNaming_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Naming#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Name</em>'.
	 * @see org.opencim.cim.iec61970.core.Naming#getPathName()
	 * @see #getNaming()
	 * @generated
	 */
	EAttribute getNaming_PathName();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.Naming#getMRID <em>MRID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MRID</em>'.
	 * @see org.opencim.cim.iec61970.core.Naming#getMRID()
	 * @see #getNaming()
	 * @generated
	 */
	EAttribute getNaming_MRID();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Equipment <em>Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipment</em>'.
	 * @see org.opencim.cim.iec61970.core.Equipment
	 * @generated
	 */
	EClass getEquipment();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.core.Equipment#getEquipmentContainer <em>Equipment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Equipment Container</em>'.
	 * @see org.opencim.cim.iec61970.core.Equipment#getEquipmentContainer()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_EquipmentContainer();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.opencim.cim.iec61970.core.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.EquipmentContainer <em>Equipment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipment Container</em>'.
	 * @see org.opencim.cim.iec61970.core.EquipmentContainer
	 * @generated
	 */
	EClass getEquipmentContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.EquipmentContainer#getConnectivityNodes <em>Connectivity Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connectivity Nodes</em>'.
	 * @see org.opencim.cim.iec61970.core.EquipmentContainer#getConnectivityNodes()
	 * @see #getEquipmentContainer()
	 * @generated
	 */
	EReference getEquipmentContainer_ConnectivityNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.core.EquipmentContainer#getEquipments <em>Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipments</em>'.
	 * @see org.opencim.cim.iec61970.core.EquipmentContainer#getEquipments()
	 * @see #getEquipmentContainer()
	 * @generated
	 */
	EReference getEquipmentContainer_Equipments();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.PSRType <em>PSR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSR Type</em>'.
	 * @see org.opencim.cim.iec61970.core.PSRType
	 * @generated
	 */
	EClass getPSRType();

	/**
	 * Returns the meta object for the reference list '{@link org.opencim.cim.iec61970.core.PSRType#getPowerSystemResource <em>Power System Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Power System Resource</em>'.
	 * @see org.opencim.cim.iec61970.core.PSRType#getPowerSystemResource()
	 * @see #getPSRType()
	 * @generated
	 */
	EReference getPSRType_PowerSystemResource();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.core.CoreVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.core.CoreVersion
	 * @generated
	 */
	EClass getCoreVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CoreVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.core.CoreVersion#getVersion()
	 * @see #getCoreVersion()
	 * @generated
	 */
	EAttribute getCoreVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.core.CoreVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.core.CoreVersion#getDate()
	 * @see #getCoreVersion()
	 * @generated
	 */
	EAttribute getCoreVersion_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.BayImpl <em>Bay</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.BayImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getBay()
		 * @generated
		 */
		EClass BAY = eINSTANCE.getBay();

		/**
		 * The meta object literal for the '<em><b>Bay Energy Meas Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BAY__BAY_ENERGY_MEAS_FLAG = eINSTANCE.getBay_BayEnergyMeasFlag();

		/**
		 * The meta object literal for the '<em><b>Bay Power Meas Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BAY__BAY_POWER_MEAS_FLAG = eINSTANCE.getBay_BayPowerMeasFlag();

		/**
		 * The meta object literal for the '<em><b>Breaker Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BAY__BREAKER_CONFIGURATION = eINSTANCE.getBay_BreakerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Bus Bar Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BAY__BUS_BAR_CONFIGURATION = eINSTANCE.getBay_BusBarConfiguration();

		/**
		 * The meta object literal for the '<em><b>Voltage Level</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BAY__VOLTAGE_LEVEL = eINSTANCE.getBay_VoltageLevel();

		/**
		 * The meta object literal for the '<em><b>Substation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BAY__SUBSTATION = eINSTANCE.getBay_Substation();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.CompanyImpl <em>Company</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.CompanyImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCompany()
		 * @generated
		 */
		EClass COMPANY = eINSTANCE.getCompany();

		/**
		 * The meta object literal for the '<em><b>Simu Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__SIMU_MODEL = eINSTANCE.getCompany_SimuModel();

		/**
		 * The meta object literal for the '<em><b>Company Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__COMPANY_TYPE = eINSTANCE.getCompany_CompanyType();

		/**
		 * The meta object literal for the '<em><b>PS Rs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__PS_RS = eINSTANCE.getCompany_PSRs();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl <em>Conducting Equipment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getConductingEquipment()
		 * @generated
		 */
		EClass CONDUCTING_EQUIPMENT = eINSTANCE.getConductingEquipment();

		/**
		 * The meta object literal for the '<em><b>Phases</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDUCTING_EQUIPMENT__PHASES = eINSTANCE.getConductingEquipment_Phases();

		/**
		 * The meta object literal for the '<em><b>Terminals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDUCTING_EQUIPMENT__TERMINALS = eINSTANCE.getConductingEquipment_Terminals();

		/**
		 * The meta object literal for the '<em><b>Base Voltage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDUCTING_EQUIPMENT__BASE_VOLTAGE = eINSTANCE.getConductingEquipment_BaseVoltage();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.ControlHouseEquipmentImpl <em>Control House Equipment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.ControlHouseEquipmentImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getControlHouseEquipment()
		 * @generated
		 */
		EClass CONTROL_HOUSE_EQUIPMENT = eINSTANCE.getControlHouseEquipment();

		/**
		 * The meta object literal for the '<em><b>Control House Equip Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HOUSE_EQUIPMENT__CONTROL_HOUSE_EQUIP_TYPE = eINSTANCE.getControlHouseEquipment_ControlHouseEquipType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl <em>Power System Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getPowerSystemResource()
		 * @generated
		 */
		EClass POWER_SYSTEM_RESOURCE = eINSTANCE.getPowerSystemResource();

		/**
		 * The meta object literal for the '<em><b>Simu Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_SYSTEM_RESOURCE__SIMU_MODEL = eINSTANCE.getPowerSystemResource_SimuModel();

		/**
		 * The meta object literal for the '<em><b>Companies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_SYSTEM_RESOURCE__COMPANIES = eINSTANCE.getPowerSystemResource_Companies();

		/**
		 * The meta object literal for the '<em><b>PSR Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_SYSTEM_RESOURCE__PSR_TYPE = eINSTANCE.getPowerSystemResource_PSRType();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.SubstationImpl <em>Substation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.SubstationImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getSubstation()
		 * @generated
		 */
		EClass SUBSTATION = eINSTANCE.getSubstation();

		/**
		 * The meta object literal for the '<em><b>Sub Control Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTATION__SUB_CONTROL_AREA = eINSTANCE.getSubstation_SubControlArea();

		/**
		 * The meta object literal for the '<em><b>Load Area</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTATION__LOAD_AREA = eINSTANCE.getSubstation_LoadArea();

		/**
		 * The meta object literal for the '<em><b>Voltage Levels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTATION__VOLTAGE_LEVELS = eINSTANCE.getSubstation_VoltageLevels();

		/**
		 * The meta object literal for the '<em><b>Bays</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTATION__BAYS = eINSTANCE.getSubstation_Bays();

		/**
		 * The meta object literal for the '<em><b>Contains Composite Switches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTATION__CONTAINS_COMPOSITE_SWITCHES = eINSTANCE.getSubstation_Contains_CompositeSwitches();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.TerminalImpl <em>Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.TerminalImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '<em><b>Conducting Equipment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINAL__CONDUCTING_EQUIPMENT = eINSTANCE.getTerminal_ConductingEquipment();

		/**
		 * The meta object literal for the '<em><b>Connectivity Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINAL__CONNECTIVITY_NODE = eINSTANCE.getTerminal_ConnectivityNode();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.SubControlAreaImpl <em>Sub Control Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.SubControlAreaImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getSubControlArea()
		 * @generated
		 */
		EClass SUB_CONTROL_AREA = eINSTANCE.getSubControlArea();

		/**
		 * The meta object literal for the '<em><b>Substations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_CONTROL_AREA__SUBSTATIONS = eINSTANCE.getSubControlArea_Substations();

		/**
		 * The meta object literal for the '<em><b>Generating Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_CONTROL_AREA__GENERATING_UNITS = eINSTANCE.getSubControlArea_GeneratingUnits();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl <em>Curve Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.CurveScheduleImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCurveSchedule()
		 * @generated
		 */
		EClass CURVE_SCHEDULE = eINSTANCE.getCurveSchedule();

		/**
		 * The meta object literal for the '<em><b>Curve Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__CURVE_STYLE = eINSTANCE.getCurveSchedule_CurveStyle();

		/**
		 * The meta object literal for the '<em><b>Ramp Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__RAMP_METHOD = eINSTANCE.getCurveSchedule_RampMethod();

		/**
		 * The meta object literal for the '<em><b>Ramp Start Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__RAMP_START_METHOD = eINSTANCE.getCurveSchedule_RampStartMethod();

		/**
		 * The meta object literal for the '<em><b>Ramp Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__RAMP_UNITS = eINSTANCE.getCurveSchedule_RampUnits();

		/**
		 * The meta object literal for the '<em><b>XAxis Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__XAXIS_TYPE = eINSTANCE.getCurveSchedule_XAxisType();

		/**
		 * The meta object literal for the '<em><b>XAxis Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__XAXIS_QUANTITY = eINSTANCE.getCurveSchedule_XAxisQuantity();

		/**
		 * The meta object literal for the '<em><b>Y1 Axis Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__Y1_AXIS_QUANTITY = eINSTANCE.getCurveSchedule_Y1AxisQuantity();

		/**
		 * The meta object literal for the '<em><b>Y2 Axis Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__Y2_AXIS_QUANTITY = eINSTANCE.getCurveSchedule_Y2AxisQuantity();

		/**
		 * The meta object literal for the '<em><b>YAxis Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHEDULE__YAXIS_TYPE = eINSTANCE.getCurveSchedule_YAxisType();

		/**
		 * The meta object literal for the '<em><b>Curve Schedule Datas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS = eINSTANCE.getCurveSchedule_CurveScheduleDatas();

		/**
		 * The meta object literal for the '<em><b>Curve Schedule Formula</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA = eINSTANCE.getCurveSchedule_CurveScheduleFormula();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl <em>Curve Sched Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCurveSchedData()
		 * @generated
		 */
		EClass CURVE_SCHED_DATA = eINSTANCE.getCurveSchedData();

		/**
		 * The meta object literal for the '<em><b>Ramp Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_DATA__RAMP_DATA = eINSTANCE.getCurveSchedData_RampData();

		/**
		 * The meta object literal for the '<em><b>Ramp Data Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_DATA__RAMP_DATA_VALUE = eINSTANCE.getCurveSchedData_RampDataValue();

		/**
		 * The meta object literal for the '<em><b>XAxis Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_DATA__XAXIS_DATA = eINSTANCE.getCurveSchedData_XAxisData();

		/**
		 * The meta object literal for the '<em><b>Y1 Axis Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_DATA__Y1_AXIS_DATA = eINSTANCE.getCurveSchedData_Y1AxisData();

		/**
		 * The meta object literal for the '<em><b>Y2 Axis Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_DATA__Y2_AXIS_DATA = eINSTANCE.getCurveSchedData_Y2AxisData();

		/**
		 * The meta object literal for the '<em><b>Curve Schedule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURVE_SCHED_DATA__CURVE_SCHEDULE = eINSTANCE.getCurveSchedData_CurveSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl <em>Curve Sched Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCurveSchedFormula()
		 * @generated
		 */
		EClass CURVE_SCHED_FORMULA = eINSTANCE.getCurveSchedFormula();

		/**
		 * The meta object literal for the '<em><b>XLower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_FORMULA__XLOWER_BOUND = eINSTANCE.getCurveSchedFormula_XLowerBound();

		/**
		 * The meta object literal for the '<em><b>XUpper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_FORMULA__XUPPER_BOUND = eINSTANCE.getCurveSchedFormula_XUpperBound();

		/**
		 * The meta object literal for the '<em><b>YFunction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURVE_SCHED_FORMULA__YFUNCTION = eINSTANCE.getCurveSchedFormula_YFunction();

		/**
		 * The meta object literal for the '<em><b>Curve Schedule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURVE_SCHED_FORMULA__CURVE_SCHEDULE = eINSTANCE.getCurveSchedFormula_CurveSchedule();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.BaseVoltageImpl <em>Base Voltage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.BaseVoltageImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getBaseVoltage()
		 * @generated
		 */
		EClass BASE_VOLTAGE = eINSTANCE.getBaseVoltage();

		/**
		 * The meta object literal for the '<em><b>Nominal Voltage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_VOLTAGE__NOMINAL_VOLTAGE = eINSTANCE.getBaseVoltage_NominalVoltage();

		/**
		 * The meta object literal for the '<em><b>Base Power</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_VOLTAGE__BASE_POWER = eINSTANCE.getBaseVoltage_BasePower();

		/**
		 * The meta object literal for the '<em><b>Conducting Equipment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_VOLTAGE__CONDUCTING_EQUIPMENT = eINSTANCE.getBaseVoltage_ConductingEquipment();

		/**
		 * The meta object literal for the '<em><b>Voltage Level</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_VOLTAGE__VOLTAGE_LEVEL = eINSTANCE.getBaseVoltage_VoltageLevel();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.BasePowerImpl <em>Base Power</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.BasePowerImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getBasePower()
		 * @generated
		 */
		EClass BASE_POWER = eINSTANCE.getBasePower();

		/**
		 * The meta object literal for the '<em><b>Base Power</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_POWER__BASE_POWER = eINSTANCE.getBasePower_BasePower();

		/**
		 * The meta object literal for the '<em><b>Base Voltages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_POWER__BASE_VOLTAGES = eINSTANCE.getBasePower_BaseVoltages();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl <em>Voltage Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.VoltageLevelImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getVoltageLevel()
		 * @generated
		 */
		EClass VOLTAGE_LEVEL = eINSTANCE.getVoltageLevel();

		/**
		 * The meta object literal for the '<em><b>High Voltage Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT = eINSTANCE.getVoltageLevel_HighVoltageLimit();

		/**
		 * The meta object literal for the '<em><b>Low Voltage Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT = eINSTANCE.getVoltageLevel_LowVoltageLimit();

		/**
		 * The meta object literal for the '<em><b>Substation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLTAGE_LEVEL__SUBSTATION = eINSTANCE.getVoltageLevel_Substation();

		/**
		 * The meta object literal for the '<em><b>Bays</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLTAGE_LEVEL__BAYS = eINSTANCE.getVoltageLevel_Bays();

		/**
		 * The meta object literal for the '<em><b>Base Voltage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLTAGE_LEVEL__BASE_VOLTAGE = eINSTANCE.getVoltageLevel_BaseVoltage();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.NamingImpl <em>Naming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.NamingImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getNaming()
		 * @generated
		 */
		EClass NAMING = eINSTANCE.getNaming();

		/**
		 * The meta object literal for the '<em><b>Alias Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMING__ALIAS_NAME = eINSTANCE.getNaming_AliasName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMING__DESCRIPTION = eINSTANCE.getNaming_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMING__NAME = eINSTANCE.getNaming_Name();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMING__PATH_NAME = eINSTANCE.getNaming_PathName();

		/**
		 * The meta object literal for the '<em><b>MRID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMING__MRID = eINSTANCE.getNaming_MRID();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.EquipmentImpl <em>Equipment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.EquipmentImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getEquipment()
		 * @generated
		 */
		EClass EQUIPMENT = eINSTANCE.getEquipment();

		/**
		 * The meta object literal for the '<em><b>Equipment Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_CONTAINER = eINSTANCE.getEquipment_EquipmentContainer();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.UnitImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl <em>Equipment Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getEquipmentContainer()
		 * @generated
		 */
		EClass EQUIPMENT_CONTAINER = eINSTANCE.getEquipmentContainer();

		/**
		 * The meta object literal for the '<em><b>Connectivity Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_CONTAINER__CONNECTIVITY_NODES = eINSTANCE.getEquipmentContainer_ConnectivityNodes();

		/**
		 * The meta object literal for the '<em><b>Equipments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_CONTAINER__EQUIPMENTS = eINSTANCE.getEquipmentContainer_Equipments();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.PSRTypeImpl <em>PSR Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.PSRTypeImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getPSRType()
		 * @generated
		 */
		EClass PSR_TYPE = eINSTANCE.getPSRType();

		/**
		 * The meta object literal for the '<em><b>Power System Resource</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSR_TYPE__POWER_SYSTEM_RESOURCE = eINSTANCE.getPSRType_PowerSystemResource();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.core.impl.CoreVersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.core.impl.CoreVersionImpl
		 * @see org.opencim.cim.iec61970.core.impl.CorePackageImpl#getCoreVersion()
		 * @generated
		 */
		EClass CORE_VERSION = eINSTANCE.getCoreVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_VERSION__VERSION = eINSTANCE.getCoreVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_VERSION__DATE = eINSTANCE.getCoreVersion_Date();

	}

} //CorePackage
