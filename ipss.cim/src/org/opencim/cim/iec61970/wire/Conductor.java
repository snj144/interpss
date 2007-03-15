/**
 * <copyright>
 * </copyright>
 *
 * $Id: Conductor.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.ConductingEquipment;

import org.opencim.datatype.real.Conductance;
import org.opencim.datatype.real.LongLength;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Susceptance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conductor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Combination of conducting material with consistent electrical characteristics, building a single electrical system, used to carry current between points in the power system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getB0ch <em>B0ch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getBch <em>Bch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getG0ch <em>G0ch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getGch <em>Gch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getLength <em>Length</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Conductor#getConductorType <em>Conductor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor()
 * @generated
 */
public interface Conductor extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>B0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>B0ch</em>' attribute.
	 * @see #setB0ch(Susceptance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_B0ch()
	 * @generated
	 */
	Susceptance getB0ch();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getB0ch <em>B0ch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B0ch</em>' attribute.
	 * @see #getB0ch()
	 * @generated
	 */
	void setB0ch(Susceptance value);

	/**
	 * Returns the value of the '<em><b>Bch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bch</em>' attribute.
	 * @see #setBch(Susceptance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_Bch()
	 * @generated
	 */
	Susceptance getBch();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getBch <em>Bch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bch</em>' attribute.
	 * @see #getBch()
	 * @generated
	 */
	void setBch(Susceptance value);

	/**
	 * Returns the value of the '<em><b>G0ch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>G0ch</em>' attribute.
	 * @see #setG0ch(Conductance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_G0ch()
	 * @generated
	 */
	Conductance getG0ch();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getG0ch <em>G0ch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>G0ch</em>' attribute.
	 * @see #getG0ch()
	 * @generated
	 */
	void setG0ch(Conductance value);

	/**
	 * Returns the value of the '<em><b>Gch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gch</em>' attribute.
	 * @see #setGch(Conductance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_Gch()
	 * @generated
	 */
	Conductance getGch();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getGch <em>Gch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gch</em>' attribute.
	 * @see #getGch()
	 * @generated
	 */
	void setGch(Conductance value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Segment length for calculating line section capabilities (long length units)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(LongLength)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_Length()
	 * @generated
	 */
	LongLength getLength();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(LongLength value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence series resistance of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_R()
	 * @generated
	 */
	Resistance getR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(Resistance value);

	/**
	 * Returns the value of the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence series resistance of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R0</em>' attribute.
	 * @see #setR0(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_R0()
	 * @generated
	 */
	Resistance getR0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getR0 <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R0</em>' attribute.
	 * @see #getR0()
	 * @generated
	 */
	void setR0(Resistance value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence series reactance of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_X()
	 * @generated
	 */
	Reactance getX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Reactance value);

	/**
	 * Returns the value of the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence series reactance of the entire line section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X0</em>' attribute.
	 * @see #setX0(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_X0()
	 * @generated
	 */
	Reactance getX0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getX0 <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X0</em>' attribute.
	 * @see #getX0()
	 * @generated
	 */
	void setX0(Reactance value);

	/**
	 * Returns the value of the '<em><b>Conductor Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.ConductorType#getConductors <em>Conductors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sections of conductor are physically described by a conductor type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conductor Type</em>' reference.
	 * @see #setConductorType(ConductorType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getConductor_ConductorType()
	 * @see org.opencim.cim.iec61970.wire.ConductorType#getConductors
	 * @generated
	 */
	ConductorType getConductorType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Conductor#getConductorType <em>Conductor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conductor Type</em>' reference.
	 * @see #getConductorType()
	 * @generated
	 */
	void setConductorType(ConductorType value);

} // Conductor