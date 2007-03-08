/**
 * <copyright>
 * </copyright>
 *
 * $Id: Fuse.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.datatype.real.CurrentFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fuse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An overcurrent protective device with a circuit opening fusible part that is heated and severed by the passage of overcurrent through it. A fuse is considered a switching device because it breaks current.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.Fuse#getAmpRating <em>Amp Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getFuse()
 * @model
 * @generated
 */
public interface Fuse extends Switch {
	/**
	 * Returns the value of the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fault interrupting rating in amperes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Amp Rating</em>' attribute.
	 * @see #setAmpRating(CurrentFlow)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getFuse_AmpRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.CurrentFlow"
	 * @generated
	 */
	CurrentFlow getAmpRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Fuse#getAmpRating <em>Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amp Rating</em>' attribute.
	 * @see #getAmpRating()
	 * @generated
	 */
	void setAmpRating(CurrentFlow value);

} // Fuse