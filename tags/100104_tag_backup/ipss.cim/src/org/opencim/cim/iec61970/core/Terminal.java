/**
 * <copyright>
 * </copyright>
 *
 * $Id: Terminal.java,v 1.4 2007/03/07 05:14:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.opencim.cim.iec61970.topology.ConnectivityNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An electrical connection point to a piece of conducting equipment. Terminals are connected at physical connection points called "connectivity nodes". 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.Terminal#getConductingEquipment <em>Conducting Equipment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Terminal#getConnectivityNode <em>Connectivity Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getTerminal()
 * @generated
 */
public interface Terminal extends Naming {
	/**
	 * Returns the value of the '<em><b>Conducting Equipment</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getTerminals <em>Terminals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ConductingEquipment has 1 or 2 terminals that may be connected to other ConductingEquipment terminals via ConnectivityNodes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conducting Equipment</em>' reference.
	 * @see #setConductingEquipment(ConductingEquipment)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getTerminal_ConductingEquipment()
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment#getTerminals
	 * @generated
	 */
	ConductingEquipment getConductingEquipment();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Terminal#getConductingEquipment <em>Conducting Equipment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conducting Equipment</em>' reference.
	 * @see #getConductingEquipment()
	 * @generated
	 */
	void setConductingEquipment(ConductingEquipment value);

	/**
	 * Returns the value of the '<em><b>Connectivity Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getTerminals <em>Terminals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Terminals interconnect with zero impedance at a node.  Measurements on a node apply to all of its terminals.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connectivity Node</em>' container reference.
	 * @see #setConnectivityNode(ConnectivityNode)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getTerminal_ConnectivityNode()
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode#getTerminals
	 * @generated
	 */
	ConnectivityNode getConnectivityNode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Terminal#getConnectivityNode <em>Connectivity Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connectivity Node</em>' container reference.
	 * @see #getConnectivityNode()
	 * @generated
	 */
	void setConnectivityNode(ConnectivityNode value);

} // Terminal