/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireArrangement.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.Naming;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrangement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Identification, spacing and configuration of the wires of a ConductorType, with reference to their type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointX <em>Mounting Point X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointY <em>Mounting Point Y</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireArrangement#getConductorType <em>Conductor Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireArrangement#getWireType <em>Wire Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireArrangement()
 * @model
 * @generated
 */
public interface WireArrangement extends Naming {
	/**
	 * Returns the value of the '<em><b>Mounting Point X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mounting point where wire One is mounted.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mounting Point X</em>' attribute.
	 * @see #setMountingPointX(Integer)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireArrangement_MountingPointX()
	 * @model
	 * @generated
	 */
	Integer getMountingPointX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointX <em>Mounting Point X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mounting Point X</em>' attribute.
	 * @see #getMountingPointX()
	 * @generated
	 */
	void setMountingPointX(Integer value);

	/**
	 * Returns the value of the '<em><b>Mounting Point Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mounting point where wire One is mounted.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mounting Point Y</em>' attribute.
	 * @see #setMountingPointY(Integer)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireArrangement_MountingPointY()
	 * @model
	 * @generated
	 */
	Integer getMountingPointY();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireArrangement#getMountingPointY <em>Mounting Point Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mounting Point Y</em>' attribute.
	 * @see #getMountingPointY()
	 * @generated
	 */
	void setMountingPointY(Integer value);

	/**
	 * Returns the value of the '<em><b>Conductor Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.ConductorType#getWireArrangements <em>Wire Arrangements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ConductorType is made up of wires that can be configured in several ways.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conductor Type</em>' reference.
	 * @see #setConductorType(ConductorType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireArrangement_ConductorType()
	 * @see org.opencim.cim.iec61970.wire.ConductorType#getWireArrangements
	 * @model opposite="WireArrangements"
	 * @generated
	 */
	ConductorType getConductorType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireArrangement#getConductorType <em>Conductor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conductor Type</em>' reference.
	 * @see #getConductorType()
	 * @generated
	 */
	void setConductorType(ConductorType value);

	/**
	 * Returns the value of the '<em><b>Wire Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.WireType#getWireArrangements <em>Wire Arrangements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A WireType is mounted at a specified place in a WireArrangement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wire Type</em>' reference.
	 * @see #setWireType(WireType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireArrangement_WireType()
	 * @see org.opencim.cim.iec61970.wire.WireType#getWireArrangements
	 * @model opposite="WireArrangements"
	 * @generated
	 */
	WireType getWireType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireArrangement#getWireType <em>Wire Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wire Type</em>' reference.
	 * @see #getWireType()
	 * @generated
	 */
	void setWireType(WireType value);

} // WireArrangement