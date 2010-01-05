/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopologyPackage.java,v 1.4 2007/03/07 05:14:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology;

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
 * An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.topology.TopologyFactory
 * @generated
 */
public interface TopologyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "topology";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim.cim.iec61970.topology";

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
	TopologyPackage eINSTANCE = org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl <em>Connectivity Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl
	 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getConnectivityNode()
	 * @generated
	 */
	int CONNECTIVITY_NODE = 0;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Topological Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__TOPOLOGICAL_NODE = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__TERMINALS = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Equipment Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE__EQUIPMENT_CONTAINER = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connectivity Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTIVITY_NODE_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.topology.impl.TopologicalIslandImpl <em>Topological Island</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.topology.impl.TopologicalIslandImpl
	 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getTopologicalIsland()
	 * @generated
	 */
	int TOPOLOGICAL_ISLAND = 1;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Simu Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__SIMU_MODEL = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Topological Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Topological Island</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_ISLAND_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl <em>Topological Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl
	 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getTopologicalNode()
	 * @generated
	 */
	int TOPOLOGICAL_NODE = 2;

	/**
	 * The feature id for the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__ALIAS_NAME = CorePackage.NAMING__ALIAS_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__DESCRIPTION = CorePackage.NAMING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__NAME = CorePackage.NAMING__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__PATH_NAME = CorePackage.NAMING__PATH_NAME;

	/**
	 * The feature id for the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__MRID = CorePackage.NAMING__MRID;

	/**
	 * The feature id for the '<em><b>Energized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__ENERGIZED = CorePackage.NAMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Load Carrying</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__LOAD_CARRYING = CorePackage.NAMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Net Injection MVar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__NET_INJECTION_MVAR = CorePackage.NAMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Net Injection MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__NET_INJECTION_MW = CorePackage.NAMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Observability Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__OBSERVABILITY_FLAG = CorePackage.NAMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Phase Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__PHASE_ANGLE = CorePackage.NAMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__VOLTAGE = CorePackage.NAMING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Connectivity Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__CONNECTIVITY_NODES = CorePackage.NAMING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Topological Island</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND = CorePackage.NAMING_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Topological Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGICAL_NODE_FEATURE_COUNT = CorePackage.NAMING_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.topology.impl.TopologyVersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.topology.impl.TopologyVersionImpl
	 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getTopologyVersion()
	 * @generated
	 */
	int TOPOLOGY_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_VERSION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.topology.ConnectivityNode <em>Connectivity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connectivity Node</em>'.
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode
	 * @generated
	 */
	EClass getConnectivityNode();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTopologicalNode <em>Topological Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Topological Node</em>'.
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode#getTopologicalNode()
	 * @see #getConnectivityNode()
	 * @generated
	 */
	EReference getConnectivityNode_TopologicalNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTerminals <em>Terminals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terminals</em>'.
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode#getTerminals()
	 * @see #getConnectivityNode()
	 * @generated
	 */
	EReference getConnectivityNode_Terminals();

	/**
	 * Returns the meta object for the reference '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getEquipmentContainer <em>Equipment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equipment Container</em>'.
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode#getEquipmentContainer()
	 * @see #getConnectivityNode()
	 * @generated
	 */
	EReference getConnectivityNode_EquipmentContainer();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.topology.TopologicalIsland <em>Topological Island</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topological Island</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalIsland
	 * @generated
	 */
	EClass getTopologicalIsland();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getSimuModel <em>Simu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simu Model</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalIsland#getSimuModel()
	 * @see #getTopologicalIsland()
	 * @generated
	 */
	EReference getTopologicalIsland_SimuModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getTopologicalNodes <em>Topological Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Topological Nodes</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalIsland#getTopologicalNodes()
	 * @see #getTopologicalIsland()
	 * @generated
	 */
	EReference getTopologicalIsland_TopologicalNodes();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.topology.TopologicalNode <em>Topological Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topological Node</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode
	 * @generated
	 */
	EClass getTopologicalNode();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getEnergized <em>Energized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energized</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getEnergized()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_Energized();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getLoadCarrying <em>Load Carrying</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Carrying</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getLoadCarrying()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_LoadCarrying();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMVar <em>Net Injection MVar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Injection MVar</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMVar()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_NetInjectionMVar();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMW <em>Net Injection MW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Injection MW</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMW()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_NetInjectionMW();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getObservabilityFlag <em>Observability Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Observability Flag</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getObservabilityFlag()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_ObservabilityFlag();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getPhaseAngle <em>Phase Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase Angle</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getPhaseAngle()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_PhaseAngle();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getVoltage <em>Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voltage</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getVoltage()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EAttribute getTopologicalNode_Voltage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getConnectivityNodes <em>Connectivity Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectivity Nodes</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getConnectivityNodes()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EReference getTopologicalNode_ConnectivityNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getTopologicalIsland <em>Topological Island</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Topological Island</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getTopologicalIsland()
	 * @see #getTopologicalNode()
	 * @generated
	 */
	EReference getTopologicalNode_TopologicalIsland();

	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.topology.TopologyVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologyVersion
	 * @generated
	 */
	EClass getTopologyVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologyVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologyVersion#getVersion()
	 * @see #getTopologyVersion()
	 * @generated
	 */
	EAttribute getTopologyVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.topology.TopologyVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.topology.TopologyVersion#getDate()
	 * @see #getTopologyVersion()
	 * @generated
	 */
	EAttribute getTopologyVersion_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TopologyFactory getTopologyFactory();

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
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl <em>Connectivity Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl
		 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getConnectivityNode()
		 * @generated
		 */
		EClass CONNECTIVITY_NODE = eINSTANCE.getConnectivityNode();

		/**
		 * The meta object literal for the '<em><b>Topological Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTIVITY_NODE__TOPOLOGICAL_NODE = eINSTANCE.getConnectivityNode_TopologicalNode();

		/**
		 * The meta object literal for the '<em><b>Terminals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTIVITY_NODE__TERMINALS = eINSTANCE.getConnectivityNode_Terminals();

		/**
		 * The meta object literal for the '<em><b>Equipment Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTIVITY_NODE__EQUIPMENT_CONTAINER = eINSTANCE.getConnectivityNode_EquipmentContainer();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.topology.impl.TopologicalIslandImpl <em>Topological Island</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.topology.impl.TopologicalIslandImpl
		 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getTopologicalIsland()
		 * @generated
		 */
		EClass TOPOLOGICAL_ISLAND = eINSTANCE.getTopologicalIsland();

		/**
		 * The meta object literal for the '<em><b>Simu Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGICAL_ISLAND__SIMU_MODEL = eINSTANCE.getTopologicalIsland_SimuModel();

		/**
		 * The meta object literal for the '<em><b>Topological Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES = eINSTANCE.getTopologicalIsland_TopologicalNodes();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl <em>Topological Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl
		 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getTopologicalNode()
		 * @generated
		 */
		EClass TOPOLOGICAL_NODE = eINSTANCE.getTopologicalNode();

		/**
		 * The meta object literal for the '<em><b>Energized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__ENERGIZED = eINSTANCE.getTopologicalNode_Energized();

		/**
		 * The meta object literal for the '<em><b>Load Carrying</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__LOAD_CARRYING = eINSTANCE.getTopologicalNode_LoadCarrying();

		/**
		 * The meta object literal for the '<em><b>Net Injection MVar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__NET_INJECTION_MVAR = eINSTANCE.getTopologicalNode_NetInjectionMVar();

		/**
		 * The meta object literal for the '<em><b>Net Injection MW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__NET_INJECTION_MW = eINSTANCE.getTopologicalNode_NetInjectionMW();

		/**
		 * The meta object literal for the '<em><b>Observability Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__OBSERVABILITY_FLAG = eINSTANCE.getTopologicalNode_ObservabilityFlag();

		/**
		 * The meta object literal for the '<em><b>Phase Angle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__PHASE_ANGLE = eINSTANCE.getTopologicalNode_PhaseAngle();

		/**
		 * The meta object literal for the '<em><b>Voltage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGICAL_NODE__VOLTAGE = eINSTANCE.getTopologicalNode_Voltage();

		/**
		 * The meta object literal for the '<em><b>Connectivity Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGICAL_NODE__CONNECTIVITY_NODES = eINSTANCE.getTopologicalNode_ConnectivityNodes();

		/**
		 * The meta object literal for the '<em><b>Topological Island</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND = eINSTANCE.getTopologicalNode_TopologicalIsland();

		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.topology.impl.TopologyVersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.topology.impl.TopologyVersionImpl
		 * @see org.opencim.cim.iec61970.topology.impl.TopologyPackageImpl#getTopologyVersion()
		 * @generated
		 */
		EClass TOPOLOGY_VERSION = eINSTANCE.getTopologyVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_VERSION__VERSION = eINSTANCE.getTopologyVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_VERSION__DATE = eINSTANCE.getTopologyVersion_Date();

	}

} //TopologyPackage
