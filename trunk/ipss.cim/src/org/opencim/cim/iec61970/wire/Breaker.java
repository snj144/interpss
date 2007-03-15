/**
 * <copyright>
 * </copyright>
 *
 * $Id: Breaker.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Breaker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A mechanical switching device capable of making, carrying, and breaking currents under normal circuit conditions and also making, carrying for a specified time, and breaking currents under specified abnormal circuit conditions e.g.  those of short circuit. The typeName is the type of breaker, e.g., oil, air blast, vacuum, SF6.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.Breaker#getAmpRating <em>Amp Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Breaker#getInTransitTime <em>In Transit Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getBreaker()
 * @generated
 */
public interface Breaker extends Switch {
	/**
	 * Returns the value of the '<em><b>Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fault interrupting rating in amperes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Amp Rating</em>' attribute.
	 * @see #setAmpRating(CurrentFlow)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getBreaker_AmpRating()
	 * @generated
	 */
	CurrentFlow getAmpRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Breaker#getAmpRating <em>Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amp Rating</em>' attribute.
	 * @see #getAmpRating()
	 * @generated
	 */
	void setAmpRating(CurrentFlow value);

	/**
	 * Returns the value of the '<em><b>In Transit Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The transition time from open to close, in seconds
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In Transit Time</em>' attribute.
	 * @see #setInTransitTime(Seconds)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getBreaker_InTransitTime()
	 * @generated
	 */
	Seconds getInTransitTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Breaker#getInTransitTime <em>In Transit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Transit Time</em>' attribute.
	 * @see #getInTransitTime()
	 * @generated
	 */
	void setInTransitTime(Seconds value);

} // Breaker