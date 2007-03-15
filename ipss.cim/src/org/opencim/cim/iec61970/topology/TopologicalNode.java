/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopologicalNode.java,v 1.2 2007/03/04 17:58:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Naming;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.AngleRadians;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topological Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A set of connectivity nodes that, in the current network state, are connected together through closed switches. Topological nodes can change as the current network state changes (i.e., switches, breakers, etc. change state).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getEnergized <em>Energized</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getLoadCarrying <em>Load Carrying</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMVar <em>Net Injection MVar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMW <em>Net Injection MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getObservabilityFlag <em>Observability Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getPhaseAngle <em>Phase Angle</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getVoltage <em>Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getConnectivityNodes <em>Connectivity Nodes</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalNode#getTopologicalIsland <em>Topological Island</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode()
 * @generated
 */
public interface TopologicalNode extends Naming {
	/**
	 * Returns the value of the '<em><b>Energized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if node energized
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energized</em>' attribute.
	 * @see #setEnergized(Boolean)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_Energized()
	 * @generated
	 */
	Boolean getEnergized();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getEnergized <em>Energized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energized</em>' attribute.
	 * @see #getEnergized()
	 * @generated
	 */
	void setEnergized(Boolean value);

	/**
	 * Returns the value of the '<em><b>Load Carrying</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if node is load carrying
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Carrying</em>' attribute.
	 * @see #setLoadCarrying(Boolean)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_LoadCarrying()
	 * @generated
	 */
	Boolean getLoadCarrying();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getLoadCarrying <em>Load Carrying</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Carrying</em>' attribute.
	 * @see #getLoadCarrying()
	 * @generated
	 */
	void setLoadCarrying(Boolean value);

	/**
	 * Returns the value of the '<em><b>Net Injection MVar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Net injection MVAr
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Net Injection MVar</em>' attribute.
	 * @see #setNetInjectionMVar(ReactivePower)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_NetInjectionMVar()
	 * @generated
	 */
	ReactivePower getNetInjectionMVar();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMVar <em>Net Injection MVar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Injection MVar</em>' attribute.
	 * @see #getNetInjectionMVar()
	 * @generated
	 */
	void setNetInjectionMVar(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Net Injection MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Net injection MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Net Injection MW</em>' attribute.
	 * @see #setNetInjectionMW(ActivePower)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_NetInjectionMW()
	 * @generated
	 */
	ActivePower getNetInjectionMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getNetInjectionMW <em>Net Injection MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Injection MW</em>' attribute.
	 * @see #getNetInjectionMW()
	 * @generated
	 */
	void setNetInjectionMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Observability Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The observability status of the node.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Observability Flag</em>' attribute.
	 * @see #setObservabilityFlag(Boolean)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_ObservabilityFlag()
	 * @generated
	 */
	Boolean getObservabilityFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getObservabilityFlag <em>Observability Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observability Flag</em>' attribute.
	 * @see #getObservabilityFlag()
	 * @generated
	 */
	void setObservabilityFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Phase Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Phase angle of node
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phase Angle</em>' attribute.
	 * @see #setPhaseAngle(AngleRadians)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_PhaseAngle()
	 * @generated
	 */
	AngleRadians getPhaseAngle();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getPhaseAngle <em>Phase Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase Angle</em>' attribute.
	 * @see #getPhaseAngle()
	 * @generated
	 */
	void setPhaseAngle(AngleRadians value);

	/**
	 * Returns the value of the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Voltage of node
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage</em>' attribute.
	 * @see #setVoltage(Voltage)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_Voltage()
	 * @generated
	 */
	Voltage getVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getVoltage <em>Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage</em>' attribute.
	 * @see #getVoltage()
	 * @generated
	 */
	void setVoltage(Voltage value);

	/**
	 * Returns the value of the '<em><b>Connectivity Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.topology.ConnectivityNode}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTopologicalNode <em>Topological Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Several ConnectivityNode(s) may combine together to form a single TopologicalNode, depending on the current state of the network.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connectivity Nodes</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_ConnectivityNodes()
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode#getTopologicalNode
	 * @generated
	 */
	EList getConnectivityNodes();

	/**
	 * Returns the value of the '<em><b>Topological Island</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getTopologicalNodes <em>Topological Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A topological node belongs to a topological island
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Topological Island</em>' container reference.
	 * @see #setTopologicalIsland(TopologicalIsland)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalNode_TopologicalIsland()
	 * @see org.opencim.cim.iec61970.topology.TopologicalIsland#getTopologicalNodes
	 * @generated
	 */
	TopologicalIsland getTopologicalIsland();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getTopologicalIsland <em>Topological Island</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topological Island</em>' container reference.
	 * @see #getTopologicalIsland()
	 * @generated
	 */
	void setTopologicalIsland(TopologicalIsland value);

} // TopologicalNode