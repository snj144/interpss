/**
 * <copyright>
 * </copyright>
 *
 * $Id: SteamSupply.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Steam supply for steam turbine
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply#getSteamSupplyRating <em>Steam Supply Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply#getSteamTurbines <em>Steam Turbines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamSupply()
 * @generated
 */
public interface SteamSupply extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Steam Supply Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rating of steam supply
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Supply Rating</em>' attribute.
	 * @see #setSteamSupplyRating(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamSupply_SteamSupplyRating()
	 * @generated
	 */
	Float getSteamSupplyRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply#getSteamSupplyRating <em>Steam Supply Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Supply Rating</em>' attribute.
	 * @see #getSteamSupplyRating()
	 * @generated
	 */
	void setSteamSupplyRating(Float value);

	/**
	 * Returns the value of the '<em><b>Steam Turbines</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getSteamSupplys <em>Steam Supplys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Steam turbines may have steam supplied by a steam supply
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Turbines</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamSupply_SteamTurbines()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getSteamSupplys
	 * @generated
	 */
	EList getSteamTurbines();

} // SteamSupply