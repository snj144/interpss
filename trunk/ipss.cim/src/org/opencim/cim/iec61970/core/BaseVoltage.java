/**
 * <copyright>
 * </copyright>
 *
 * $Id: BaseVoltage.java,v 1.2 2007/03/04 17:58:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Voltage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Collection of BaseVoltages which is used to verify that the BusbarSection.BaseVoltage and other voltage attributes in the CIM are given a value existing in the collection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.BaseVoltage#getNominalVoltage <em>Nominal Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.BaseVoltage#getBasePower <em>Base Power</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.BaseVoltage#getConductingEquipment <em>Conducting Equipment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.BaseVoltage#getVoltageLevel <em>Voltage Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getBaseVoltage()
 * @model
 * @generated
 */
public interface BaseVoltage extends Naming {
	/**
	 * Returns the value of the '<em><b>Nominal Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PowerSystemResource's base voltage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominal Voltage</em>' attribute.
	 * @see #setNominalVoltage(Voltage)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBaseVoltage_NominalVoltage()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getNominalVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.BaseVoltage#getNominalVoltage <em>Nominal Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Voltage</em>' attribute.
	 * @see #getNominalVoltage()
	 * @generated
	 */
	void setNominalVoltage(Voltage value);

	/**
	 * Returns the value of the '<em><b>Base Power</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.BasePower#getBaseVoltages <em>Base Voltages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to specify that voltages in the CIM are given a value existing in the collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Power</em>' container reference.
	 * @see #setBasePower(BasePower)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBaseVoltage_BasePower()
	 * @see org.opencim.cim.iec61970.core.BasePower#getBaseVoltages
	 * @model opposite="BaseVoltages" required="true"
	 * @generated
	 */
	BasePower getBasePower();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.BaseVoltage#getBasePower <em>Base Power</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Power</em>' container reference.
	 * @see #getBasePower()
	 * @generated
	 */
	void setBasePower(BasePower value);

	/**
	 * Returns the value of the '<em><b>Conducting Equipment</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.ConductingEquipment}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.ConductingEquipment#getBaseVoltage <em>Base Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conducting Equipment</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conducting Equipment</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBaseVoltage_ConductingEquipment()
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment#getBaseVoltage
	 * @model type="org.opencim.cim.iec61970.core.ConductingEquipment" opposite="BaseVoltage"
	 * @generated
	 */
	EList getConductingEquipment();

	/**
	 * Returns the value of the '<em><b>Voltage Level</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.VoltageLevel}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.VoltageLevel#getBaseVoltage <em>Base Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voltage Level</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Voltage Level</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBaseVoltage_VoltageLevel()
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getBaseVoltage
	 * @model type="org.opencim.cim.iec61970.core.VoltageLevel" opposite="BaseVoltage"
	 * @generated
	 */
	EList getVoltageLevel();

} // BaseVoltage