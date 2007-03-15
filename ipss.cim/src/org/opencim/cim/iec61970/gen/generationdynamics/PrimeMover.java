/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimeMover.java,v 1.2 2007/03/04 17:58:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.wire.SynchronousMachine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prime Mover</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The machine used to develop mechanical energy used to drive a generator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover#getPrimeMoverRating <em>Prime Mover Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover#getSynchronousMachines <em>Synchronous Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPrimeMover()
 * @generated
 */
public interface PrimeMover extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Prime Mover Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rating of prime mover
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prime Mover Rating</em>' attribute.
	 * @see #setPrimeMoverRating(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPrimeMover_PrimeMoverRating()
	 * @generated
	 */
	Float getPrimeMoverRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover#getPrimeMoverRating <em>Prime Mover Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prime Mover Rating</em>' attribute.
	 * @see #getPrimeMoverRating()
	 * @generated
	 */
	void setPrimeMoverRating(Float value);

	/**
	 * Returns the value of the '<em><b>Synchronous Machines</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getPrimeMover <em>Prime Mover</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronous Machines</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronous Machines</em>' reference.
	 * @see #setSynchronousMachines(SynchronousMachine)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPrimeMover_SynchronousMachines()
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getPrimeMover
	 * @generated
	 */
	SynchronousMachine getSynchronousMachines();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover#getSynchronousMachines <em>Synchronous Machines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronous Machines</em>' reference.
	 * @see #getSynchronousMachines()
	 * @generated
	 */
	void setSynchronousMachines(SynchronousMachine value);

} // PrimeMover