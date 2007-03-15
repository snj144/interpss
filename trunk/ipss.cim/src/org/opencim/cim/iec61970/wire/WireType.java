/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireType.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Naming;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.ShortLength;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Wire conductor (per IEEE specs). A specific type of wire or combination of wires, not insulated from each other, suitable for carrying electrical current.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getPhaseConductorCount <em>Phase Conductor Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getPhaseConductorSpacing <em>Phase Conductor Spacing</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getAmpRating <em>Amp Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getGMR <em>GMR</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getResistance <em>Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WireType#getWireArrangements <em>Wire Arrangements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType()
 * @generated
 */
public interface WireType extends Naming {
	/**
	 * Returns the value of the '<em><b>Phase Conductor Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Number of conductor strands in the (symmetrical) bundle (1-12)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phase Conductor Count</em>' attribute.
	 * @see #setPhaseConductorCount(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_PhaseConductorCount()
	 * @generated
	 */
	Counter getPhaseConductorCount();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireType#getPhaseConductorCount <em>Phase Conductor Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase Conductor Count</em>' attribute.
	 * @see #getPhaseConductorCount()
	 * @generated
	 */
	void setPhaseConductorCount(Counter value);

	/**
	 * Returns the value of the '<em><b>Phase Conductor Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Distance between conductor strands in a (symmetrical) bundle (short length units)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phase Conductor Spacing</em>' attribute.
	 * @see #setPhaseConductorSpacing(ShortLength)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_PhaseConductorSpacing()
	 * @generated
	 */
	ShortLength getPhaseConductorSpacing();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireType#getPhaseConductorSpacing <em>Phase Conductor Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase Conductor Spacing</em>' attribute.
	 * @see #getPhaseConductorSpacing()
	 * @generated
	 */
	void setPhaseConductorSpacing(ShortLength value);

	/**
	 * Returns the value of the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Current carrying capacity, expressed in amperes, of a wire or cable under stated thermal conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Amp Rating</em>' attribute.
	 * @see #setAmpRating(CurrentFlow)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_AmpRating()
	 * @generated
	 */
	CurrentFlow getAmpRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireType#getAmpRating <em>Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amp Rating</em>' attribute.
	 * @see #getAmpRating()
	 * @generated
	 */
	void setAmpRating(CurrentFlow value);

	/**
	 * Returns the value of the '<em><b>GMR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Geometric Mean Radius. If we replace the conductor by a thin walled tube of radius GMR, then its reactance is identical to the reactance of the actual conductor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>GMR</em>' attribute.
	 * @see #setGMR(ShortLength)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_GMR()
	 * @generated
	 */
	ShortLength getGMR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireType#getGMR <em>GMR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>GMR</em>' attribute.
	 * @see #getGMR()
	 * @generated
	 */
	void setGMR(ShortLength value);

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The radius of the conductor
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(ShortLength)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_Radius()
	 * @generated
	 */
	ShortLength getRadius();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireType#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(ShortLength value);

	/**
	 * Returns the value of the '<em><b>Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The resistance per unit length of the conductor
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resistance</em>' attribute.
	 * @see #setResistance(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_Resistance()
	 * @generated
	 */
	Resistance getResistance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WireType#getResistance <em>Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resistance</em>' attribute.
	 * @see #getResistance()
	 * @generated
	 */
	void setResistance(Resistance value);

	/**
	 * Returns the value of the '<em><b>Wire Arrangements</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.WireArrangement}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.WireArrangement#getWireType <em>Wire Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A WireType is mounted at a specified place in a WireArrangement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wire Arrangements</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWireType_WireArrangements()
	 * @see org.opencim.cim.iec61970.wire.WireArrangement#getWireType
	 * @generated
	 */
	EList getWireArrangements();

} // WireType