/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopologicalIsland.java,v 1.3 2007/03/05 04:50:41 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.SimulationModel;

import org.opencim.cim.iec61970.core.Naming;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topological Island</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An electrically connected subset of the network. Topological islands can change as the current network state changes (i.e., disconnect switches, breakers, etc. change state).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getSimuModel <em>Simu Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getTopologicalNodes <em>Topological Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalIsland()
 * @generated
 */
public interface TopologicalIsland extends Naming {
	/**
	 * Returns the value of the '<em><b>Simu Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.SimulationModel#getTopologicalIslands <em>Topological Islands</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simu Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simu Model</em>' container reference.
	 * @see #setSimuModel(SimulationModel)
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalIsland_SimuModel()
	 * @see org.opencim.cim.SimulationModel#getTopologicalIslands
	 * @generated
	 */
	SimulationModel getSimuModel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getSimuModel <em>Simu Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simu Model</em>' container reference.
	 * @see #getSimuModel()
	 * @generated
	 */
	void setSimuModel(SimulationModel value);

	/**
	 * Returns the value of the '<em><b>Topological Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.topology.TopologicalNode}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.TopologicalNode#getTopologicalIsland <em>Topological Island</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A topological node belongs to a topological island
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Topological Nodes</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.topology.TopologyPackage#getTopologicalIsland_TopologicalNodes()
	 * @see org.opencim.cim.iec61970.topology.TopologicalNode#getTopologicalIsland
	 * @generated
	 */
	EList getTopologicalNodes();

} // TopologicalIsland