/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopologyFactory.java,v 1.1 2007/03/02 14:01:16 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.topology.TopologyPackage
 * @generated
 */
public interface TopologyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TopologyFactory eINSTANCE = org.opencim.cim.iec61970.topology.impl.TopologyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Connectivity Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connectivity Node</em>'.
	 * @generated
	 */
	ConnectivityNode createConnectivityNode();

	/**
	 * Returns a new object of class '<em>Topological Island</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Topological Island</em>'.
	 * @generated
	 */
	TopologicalIsland createTopologicalIsland();

	/**
	 * Returns a new object of class '<em>Topological Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Topological Node</em>'.
	 * @generated
	 */
	TopologicalNode createTopologicalNode();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	TopologyVersion createTopologyVersion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TopologyPackage getTopologyPackage();

} //TopologyFactory
