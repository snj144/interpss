/**
 * <copyright>
 * </copyright>
 *
 * $Id: Source.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Source</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Source gives information related to the origin of a value. The value may be acquired from the process, defaulted or substituted.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getSource()
 * @generated
 */
public final class Source extends AbstractEnumerator {
	/**
	 * The '<em><b>PROCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value is provided by input from the process I/O or being calculated from some function.
	 * <!-- end-model-doc -->
	 * @see #PROCESS_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PROCESS = 0;

	/**
	 * The '<em><b>DEFAULTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value contains a default value.
	 * <!-- end-model-doc -->
	 * @see #DEFAULTED_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULTED = 1;

	/**
	 * The '<em><b>SUBSTITUTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value is provided by input of an operator or by an automatic source.
	 * <!-- end-model-doc -->
	 * @see #SUBSTITUTED_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTITUTED = 2;

	/**
	 * The '<em><b>PROCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESS
	 * @generated
	 * @ordered
	 */
	public static final Source PROCESS_LITERAL = new Source(PROCESS, "PROCESS", "PROCESS");

	/**
	 * The '<em><b>DEFAULTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULTED
	 * @generated
	 * @ordered
	 */
	public static final Source DEFAULTED_LITERAL = new Source(DEFAULTED, "DEFAULTED", "DEFAULTED");

	/**
	 * The '<em><b>SUBSTITUTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTITUTED
	 * @generated
	 * @ordered
	 */
	public static final Source SUBSTITUTED_LITERAL = new Source(SUBSTITUTED, "SUBSTITUTED", "SUBSTITUTED");

	/**
	 * An array of all the '<em><b>Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Source[] VALUES_ARRAY =
		new Source[] {
			PROCESS_LITERAL,
			DEFAULTED_LITERAL,
			SUBSTITUTED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Source</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Source get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Source result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Source</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Source getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Source result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Source</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Source get(int value) {
		switch (value) {
			case PROCESS: return PROCESS_LITERAL;
			case DEFAULTED: return DEFAULTED_LITERAL;
			case SUBSTITUTED: return SUBSTITUTED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Source(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Source
