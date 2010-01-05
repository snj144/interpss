/**
 * <copyright>
 * </copyright>
 *
 * $Id: ControlHouseEquipment.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.opencim.cim.iec61970.domain.ControlHouseEquipmentType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control House Equipment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Equipment in a substation control house. Covers things such as fire alarms, ambient temperature, door alarms, and spares.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.ControlHouseEquipment#getControlHouseEquipType <em>Control House Equip Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getControlHouseEquipment()
 * @generated
 */
public interface ControlHouseEquipment extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Control House Equip Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.ControlHouseEquipmentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of control house equipment
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control House Equip Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.ControlHouseEquipmentType
	 * @see #setControlHouseEquipType(ControlHouseEquipmentType)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getControlHouseEquipment_ControlHouseEquipType()
	 * @generated
	 */
	ControlHouseEquipmentType getControlHouseEquipType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.ControlHouseEquipment#getControlHouseEquipType <em>Control House Equip Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control House Equip Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.ControlHouseEquipmentType
	 * @see #getControlHouseEquipType()
	 * @generated
	 */
	void setControlHouseEquipType(ControlHouseEquipmentType value);

} // ControlHouseEquipment