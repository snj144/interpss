/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquipmentContainer.java,v 1.2 2007/03/04 17:58:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equipment Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A modeling construct to provide a root class for all Equipment classes
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.EquipmentContainer#getConnectivityNodes <em>Connectivity Nodes</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.EquipmentContainer#getEquipments <em>Equipments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getEquipmentContainer()
 * @generated
 */
public interface EquipmentContainer extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Connectivity Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.topology.ConnectivityNode}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.ConnectivityNode#getEquipmentContainer <em>Equipment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connectivity Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connectivity Nodes</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getEquipmentContainer_ConnectivityNodes()
	 * @see org.opencim.cim.iec61970.topology.ConnectivityNode#getEquipmentContainer
	 * @generated
	 */
	EList getConnectivityNodes();

	/**
	 * Returns the value of the '<em><b>Equipments</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Equipment}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Equipment#getEquipmentContainer <em>Equipment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equipments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equipments</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getEquipmentContainer_Equipments()
	 * @see org.opencim.cim.iec61970.core.Equipment#getEquipmentContainer
	 * @generated
	 */
	EList getEquipments();

} // EquipmentContainer