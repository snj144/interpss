/**
 * <copyright>
 * </copyright>
 *
 * $Id: BasePower.java,v 1.2 2007/03/04 17:58:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.datatype.real.ApparentPower;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Power</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The BasePower class defines the base power and base voltages that are used in the per unit calculations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.BasePower#getBasePower <em>Base Power</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.BasePower#getBaseVoltages <em>Base Voltages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getBasePower()
 * @model
 * @generated
 */
public interface BasePower extends Naming {
	/**
	 * Returns the value of the '<em><b>Base Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Definition of base power.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Power</em>' attribute.
	 * @see #setBasePower(ApparentPower)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBasePower_BasePower()
	 * @model dataType="org.opencim.cim.iec61970.domain.ApparentPower"
	 * @generated
	 */
	ApparentPower getBasePower();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.BasePower#getBasePower <em>Base Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Power</em>' attribute.
	 * @see #getBasePower()
	 * @generated
	 */
	void setBasePower(ApparentPower value);

	/**
	 * Returns the value of the '<em><b>Base Voltages</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.BaseVoltage}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.BaseVoltage#getBasePower <em>Base Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to specify that voltages in the CIM are given a value existing in the collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Voltages</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBasePower_BaseVoltages()
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getBasePower
	 * @model type="org.opencim.cim.iec61970.core.BaseVoltage" opposite="BasePower" containment="true"
	 * @generated
	 */
	EList getBaseVoltages();

} // BasePower