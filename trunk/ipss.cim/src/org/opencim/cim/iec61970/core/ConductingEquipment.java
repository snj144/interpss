/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConductingEquipment.java,v 1.4 2007/03/07 05:14:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.datatype.string.PhaseCode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conducting Equipment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The parts of the power system that are designed to carry current or that are conductively connected therewith. ConductingEquipment is contained within an EquipmentContainer that may be a Substation, or a VoltageLevel or a Bay within a Substation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.ConductingEquipment#getPhases <em>Phases</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.ConductingEquipment#getTerminals <em>Terminals</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.ConductingEquipment#getBaseVoltage <em>Base Voltage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getConductingEquipment()
 * @model
 * @generated
 */
public interface ConductingEquipment extends Equipment {
	/**
	 * Returns the value of the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the phases carried by a conducting equipment. Possible values { ABCN , ABC, ABN, ACN, BCN, AB, AC, BC, AN, BN, CN, A, B, C, N }.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phases</em>' attribute.
	 * @see #setPhases(PhaseCode)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getConductingEquipment_Phases()
	 * @model dataType="org.opencim.cim.iec61970.domain.PhaseCode"
	 * @generated
	 */
	PhaseCode getPhases();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getPhases <em>Phases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phases</em>' attribute.
	 * @see #getPhases()
	 * @generated
	 */
	void setPhases(PhaseCode value);

	/**
	 * Returns the value of the '<em><b>Terminals</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Terminal}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Terminal#getConductingEquipment <em>Conducting Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ConductingEquipment has 1 or 2 terminals that may be connected to other ConductingEquipment terminals via ConnectivityNodes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Terminals</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getConductingEquipment_Terminals()
	 * @see org.opencim.cim.iec61970.core.Terminal#getConductingEquipment
	 * @model type="org.opencim.cim.iec61970.core.Terminal" opposite="ConductingEquipment"
	 * @generated
	 */
	EList getTerminals();

	/**
	 * Returns the value of the '<em><b>Base Voltage</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.BaseVoltage#getConductingEquipment <em>Conducting Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Voltage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Voltage</em>' reference.
	 * @see #setBaseVoltage(BaseVoltage)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getConductingEquipment_BaseVoltage()
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getConductingEquipment
	 * @model opposite="ConductingEquipment" required="true"
	 * @generated
	 */
	BaseVoltage getBaseVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getBaseVoltage <em>Base Voltage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Voltage</em>' reference.
	 * @see #getBaseVoltage()
	 * @generated
	 */
	void setBaseVoltage(BaseVoltage value);

} // ConductingEquipment