/**
 * <copyright>
 * </copyright>
 *
 * $Id: DrumBoiler.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Drum Boiler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Drum boiler
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.DrumBoiler#getDrumBoilerRating <em>Drum Boiler Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getDrumBoiler()
 * @model
 * @generated
 */
public interface DrumBoiler extends FossilSteamSupply {
	/**
	 * Returns the value of the '<em><b>Drum Boiler Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rating of drum boiler in steam units
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Drum Boiler Rating</em>' attribute.
	 * @see #setDrumBoilerRating(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getDrumBoiler_DrumBoilerRating()
	 * @model
	 * @generated
	 */
	Float getDrumBoilerRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.DrumBoiler#getDrumBoilerRating <em>Drum Boiler Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drum Boiler Rating</em>' attribute.
	 * @see #getDrumBoilerRating()
	 * @generated
	 */
	void setDrumBoilerRating(Float value);

} // DrumBoiler