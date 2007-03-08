/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConductorType.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Naming;

import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conductor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Wire or cable conductor (per IEEE specs). A specific type of wire or combination of wires not insulated from one another, suitable for carrying electric current. It may be bare or insulated.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.ConductorType#getSheathResistance <em>Sheath Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.ConductorType#getSheathReactance <em>Sheath Reactance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.ConductorType#getConductors <em>Conductors</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.ConductorType#getWireArrangements <em>Wire Arrangements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductorType()
 * @model
 * @generated
 */
public interface ConductorType extends Naming {
	/**
	 * Returns the value of the '<em><b>Sheath Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resistance of the sheath for cable conductors.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sheath Resistance</em>' attribute.
	 * @see #setSheathResistance(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductorType_SheathResistance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getSheathResistance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.ConductorType#getSheathResistance <em>Sheath Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sheath Resistance</em>' attribute.
	 * @see #getSheathResistance()
	 * @generated
	 */
	void setSheathResistance(Resistance value);

	/**
	 * Returns the value of the '<em><b>Sheath Reactance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reactance of the sheath for cable conductors.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sheath Reactance</em>' attribute.
	 * @see #setSheathReactance(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductorType_SheathReactance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getSheathReactance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.ConductorType#getSheathReactance <em>Sheath Reactance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sheath Reactance</em>' attribute.
	 * @see #getSheathReactance()
	 * @generated
	 */
	void setSheathReactance(Reactance value);

	/**
	 * Returns the value of the '<em><b>Conductors</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.Conductor}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.Conductor#getConductorType <em>Conductor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sections of conductor are physically described by a conductor type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conductors</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductorType_Conductors()
	 * @see org.opencim.cim.iec61970.wire.Conductor#getConductorType
	 * @model type="org.opencim.cim.iec61970.wire.Conductor" opposite="ConductorType"
	 * @generated
	 */
	EList getConductors();

	/**
	 * Returns the value of the '<em><b>Wire Arrangements</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.WireArrangement}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.WireArrangement#getConductorType <em>Conductor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ConductorType is made up of wires that can be configured in several ways.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wire Arrangements</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductorType_WireArrangements()
	 * @see org.opencim.cim.iec61970.wire.WireArrangement#getConductorType
	 * @model type="org.opencim.cim.iec61970.wire.WireArrangement" opposite="ConductorType"
	 * @generated
	 */
	EList getWireArrangements();

} // ConductorType