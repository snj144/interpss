/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadBreakSwitch.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.datatype.real.CurrentFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Break Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A mechanical switching device capable of making, carrying, and breaking currents under normal operating conditions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.LoadBreakSwitch#getAmpRating <em>Amp Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getLoadBreakSwitch()
 * @model
 * @generated
 */
public interface LoadBreakSwitch extends Switch {
	/**
	 * Returns the value of the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Current carrying capacity, expressed in amperes, of a wire or cable under stated thermal conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Amp Rating</em>' attribute.
	 * @see #setAmpRating(CurrentFlow)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getLoadBreakSwitch_AmpRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.CurrentFlow"
	 * @generated
	 */
	CurrentFlow getAmpRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.LoadBreakSwitch#getAmpRating <em>Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amp Rating</em>' attribute.
	 * @see #getAmpRating()
	 * @generated
	 */
	void setAmpRating(CurrentFlow value);

} // LoadBreakSwitch