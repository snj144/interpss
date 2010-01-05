/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectivityNode.java,v 1.3 2007/03/07 05:14:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.Naming;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connectivity Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Connectivity nodes are points where terminals of conducting equipment are connected together with zero impedance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTopologicalNode <em>Topological Node</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTerminals <em>Terminals</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getEquipmentContainer <em>Equipment Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getConnectivityNode()
 * @generated
 */
public interface ConnectivityNode extends Naming {
	/**
	 * Returns the value of the '<em><b>Topological Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getConnectivityNodes <em>Connectivity Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Several ConnectivityNode(s) may combine together to form a single TopologicalNode, depending on the current state of the network.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Topological Node</em>' container reference.
	 * @see #setTopologicalNode(TopologicalNode)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getConnectivityNode_TopologicalNode()
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getConnectivityNodes
	 * @generated
	 */
	TopologicalNode getTopologicalNode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTopologicalNode <em>Topological Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topological Node</em>' container reference.
	 * @see #getTopologicalNode()
	 * @generated
	 */
	void setTopologicalNode(TopologicalNode value);

	/**
	 * Returns the value of the '<em><b>Terminals</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Terminal}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Terminal#getConnectivityNode <em>Connectivity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Terminals interconnect with zero impedance at a node.  Measurements on a node apply to all of its terminals.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Terminals</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getConnectivityNode_Terminals()
	 * @see org.opencim.cim.iec61970.core.Terminal#getConnectivityNode
	 * @generated
	 */
	EList getTerminals();

	/**
	 * Returns the value of the '<em><b>Equipment Container</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.EquipmentContainer#getConnectivityNodes <em>Connectivity Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equipment Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equipment Container</em>' reference.
	 * @see #setEquipmentContainer(EquipmentContainer)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getConnectivityNode_EquipmentContainer()
	 * @see org.opencim.cim.iec61970.core.EquipmentContainer#getConnectivityNodes
	 * @generated
	 */
	EquipmentContainer getEquipmentContainer();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getEquipmentContainer <em>Equipment Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment Container</em>' reference.
	 * @see #getEquipmentContainer()
	 * @generated
	 */
	void setEquipmentContainer(EquipmentContainer value);

} // ConnectivityNode