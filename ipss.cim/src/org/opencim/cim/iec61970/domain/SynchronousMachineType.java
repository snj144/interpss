/**
 * <copyright>
 * </copyright>
 *
 * $Id: SynchronousMachineType.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Synchronous Machine Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getSynchronousMachineType()
 * @generated
 */
public final class SynchronousMachineType extends AbstractEnumerator {
	/**
	 * The '<em><b>Generator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Generator</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERATOR_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int GENERATOR = 0;

	/**
	 * The '<em><b>Condenser</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Condenser</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONDENSER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CONDENSER = 1;

	/**
	 * The '<em><b>Generator or condenser</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Generator or condenser</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERATOR_OR_CONDENSER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int GENERATOR_OR_CONDENSER = 2;

	/**
	 * The '<em><b>Generator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATOR
	 * @generated
	 * @ordered
	 */
	public static final SynchronousMachineType GENERATOR_LITERAL = new SynchronousMachineType(GENERATOR, "generator", "generator");

	/**
	 * The '<em><b>Condenser</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONDENSER
	 * @generated
	 * @ordered
	 */
	public static final SynchronousMachineType CONDENSER_LITERAL = new SynchronousMachineType(CONDENSER, "condenser", "condenser");

	/**
	 * The '<em><b>Generator or condenser</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATOR_OR_CONDENSER
	 * @generated
	 * @ordered
	 */
	public static final SynchronousMachineType GENERATOR_OR_CONDENSER_LITERAL = new SynchronousMachineType(GENERATOR_OR_CONDENSER, "generator_or_condenser", "generator_or_condenser");

	/**
	 * An array of all the '<em><b>Synchronous Machine Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SynchronousMachineType[] VALUES_ARRAY =
		new SynchronousMachineType[] {
			GENERATOR_LITERAL,
			CONDENSER_LITERAL,
			GENERATOR_OR_CONDENSER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Synchronous Machine Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Synchronous Machine Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronousMachineType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronousMachineType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronous Machine Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronousMachineType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronousMachineType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronous Machine Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronousMachineType get(int value) {
		switch (value) {
			case GENERATOR: return GENERATOR_LITERAL;
			case CONDENSER: return CONDENSER_LITERAL;
			case GENERATOR_OR_CONDENSER: return GENERATOR_OR_CONDENSER_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SynchronousMachineType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SynchronousMachineType
