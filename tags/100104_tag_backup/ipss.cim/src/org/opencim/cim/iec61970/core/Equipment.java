/**
 * <copyright>
 * </copyright>
 *
 * $Id: Equipment.java,v 1.3 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equipment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The parts of a power system that are physical devices, electronic or mechanical
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.Equipment#getEquipmentContainer <em>Equipment Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getEquipment()
 * @generated
 */
public interface Equipment extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Equipment Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.EquipmentContainer#getEquipments <em>Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equipment Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equipment Container</em>' container reference.
	 * @see #setEquipmentContainer(EquipmentContainer)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getEquipment_EquipmentContainer()
	 * @see org.opencim.cim.iec61970.core.EquipmentContainer#getEquipments
	 * @generated
	 */
	EquipmentContainer getEquipmentContainer();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Equipment#getEquipmentContainer <em>Equipment Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipment Container</em>' container reference.
	 * @see #getEquipmentContainer()
	 * @generated
	 */
	void setEquipmentContainer(EquipmentContainer value);

} // Equipment