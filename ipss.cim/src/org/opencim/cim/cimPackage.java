/**
 * <copyright>
 * </copyright>
 *
 * $Id: cimPackage.java,v 1.4 2007/03/05 04:50:42 mzhou Exp $
 */
package org.opencim.cim;

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
 * @see org.opencim.cim.cimFactory
 * @generated
 */
public interface cimPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cim";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim";

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
	cimPackage eINSTANCE = org.opencim.cim.impl.cimPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.impl.CombinedVersionImpl <em>Combined Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.impl.CombinedVersionImpl
	 * @see org.opencim.cim.impl.cimPackageImpl#getCombinedVersion()
	 * @generated
	 */
	int COMBINED_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Combined Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_VERSION_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.opencim.cim.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.impl.SimulationModelImpl
	 * @see org.opencim.cim.impl.cimPackageImpl#getSimulationModel()
	 * @generated
	 */
	int SIMULATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Base Power</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__BASE_POWER = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__COMPANIES = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Topological Islands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__TOPOLOGICAL_ISLANDS = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ps Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__PS_RESOURCES = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.CombinedVersion <em>Combined Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combined Version</em>'.
	 * @see org.opencim.cim.CombinedVersion
	 * @generated
	 */
	EClass getCombinedVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.CombinedVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.CombinedVersion#getVersion()
	 * @see #getCombinedVersion()
	 * @generated
	 */
	EAttribute getCombinedVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.CombinedVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.CombinedVersion#getDate()
	 * @see #getCombinedVersion()
	 * @generated
	 */
	EAttribute getCombinedVersion_Date();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.SimulationModel <em>Simulation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Model</em>'.
	 * @see org.opencim.cim.SimulationModel
	 * @generated
	 */
	EClass getSimulationModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.opencim.cim.SimulationModel#getBasePower <em>Base Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Power</em>'.
	 * @see org.opencim.cim.SimulationModel#getBasePower()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_BasePower();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.SimulationModel#getCompanies <em>Companies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Companies</em>'.
	 * @see org.opencim.cim.SimulationModel#getCompanies()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Companies();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.SimulationModel#getTopologicalIslands <em>Topological Islands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Topological Islands</em>'.
	 * @see org.opencim.cim.SimulationModel#getTopologicalIslands()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_TopologicalIslands();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.SimulationModel#getPsResources <em>Ps Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ps Resources</em>'.
	 * @see org.opencim.cim.SimulationModel#getPsResources()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_PsResources();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	cimFactory getcimFactory();

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
		 * The meta object literal for the '{@link org.opencim.cim.impl.CombinedVersionImpl <em>Combined Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.impl.CombinedVersionImpl
		 * @see org.opencim.cim.impl.cimPackageImpl#getCombinedVersion()
		 * @generated
		 */
		EClass COMBINED_VERSION = eINSTANCE.getCombinedVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBINED_VERSION__VERSION = eINSTANCE.getCombinedVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBINED_VERSION__DATE = eINSTANCE.getCombinedVersion_Date();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.impl.SimulationModelImpl
		 * @see org.opencim.cim.impl.cimPackageImpl#getSimulationModel()
		 * @generated
		 */
		EClass SIMULATION_MODEL = eINSTANCE.getSimulationModel();

		/**
		 * The meta object literal for the '<em><b>Base Power</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__BASE_POWER = eINSTANCE.getSimulationModel_BasePower();

		/**
		 * The meta object literal for the '<em><b>Companies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__COMPANIES = eINSTANCE.getSimulationModel_Companies();

		/**
		 * The meta object literal for the '<em><b>Topological Islands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__TOPOLOGICAL_ISLANDS = eINSTANCE.getSimulationModel_TopologicalIslands();

		/**
		 * The meta object literal for the '<em><b>Ps Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__PS_RESOURCES = eINSTANCE.getSimulationModel_PsResources();

	}

} //cimPackage
