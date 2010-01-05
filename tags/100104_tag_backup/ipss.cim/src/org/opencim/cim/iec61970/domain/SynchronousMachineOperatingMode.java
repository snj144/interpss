/**
 * <copyright>
 * </copyright>
 *
 * $Id: SynchronousMachineOperatingMode.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Synchronous Machine Operating Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getSynchronousMachineOperatingMode()
 * @generated
 */
public final class SynchronousMachineOperatingMode extends AbstractEnumerator {
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
	 * The '<em><b>Generator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATOR
	 * @generated
	 * @ordered
	 */
	public static final SynchronousMachineOperatingMode GENERATOR_LITERAL = new SynchronousMachineOperatingMode(GENERATOR, "generator", "generator");

	/**
	 * The '<em><b>Condenser</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONDENSER
	 * @generated
	 * @ordered
	 */
	public static final SynchronousMachineOperatingMode CONDENSER_LITERAL = new SynchronousMachineOperatingMode(CONDENSER, "condenser", "condenser");

	/**
	 * An array of all the '<em><b>Synchronous Machine Operating Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SynchronousMachineOperatingMode[] VALUES_ARRAY =
		new SynchronousMachineOperatingMode[] {
			GENERATOR_LITERAL,
			CONDENSER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Synchronous Machine Operating Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Synchronous Machine Operating Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronousMachineOperatingMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronousMachineOperatingMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronous Machine Operating Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronousMachineOperatingMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronousMachineOperatingMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronous Machine Operating Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronousMachineOperatingMode get(int value) {
		switch (value) {
			case GENERATOR: return GENERATOR_LITERAL;
			case CONDENSER: return CONDENSER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SynchronousMachineOperatingMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SynchronousMachineOperatingMode
