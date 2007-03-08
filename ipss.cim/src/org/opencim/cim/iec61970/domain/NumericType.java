/**
 * <copyright>
 * </copyright>
 *
 * $Id: NumericType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Numeric Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * NumericType is an enumeration of the defined Numeric value types.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getNumericType()
 * @model
 * @generated
 */
public final class NumericType extends AbstractEnumerator {
	/**
	 * The '<em><b>INT TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INT TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT_TYPE = 0;

	/**
	 * The '<em><b>OCTET TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OCTET TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OCTET_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OCTET_TYPE = 1;

	/**
	 * The '<em><b>UNSIGNED TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNSIGNED TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSIGNED_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNSIGNED_TYPE = 2;

	/**
	 * The '<em><b>FLOAT TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOAT TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOAT_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_TYPE = 3;

	/**
	 * The '<em><b>COMPLEX TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPLEX TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPLEX_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPLEX_TYPE = 4;

	/**
	 * The '<em><b>DATE TIME TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATE TIME TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATE_TIME_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATE_TIME_TYPE = 5;

	/**
	 * The '<em><b>ULONG LONG TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ULONG LONG TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ULONG_LONG_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ULONG_LONG_TYPE = 6;

	/**
	 * The '<em><b>SHORT TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHORT TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHORT_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHORT_TYPE = 7;

	/**
	 * The '<em><b>LONG LONG TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LONG LONG TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LONG_LONG_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LONG_LONG_TYPE = 8;

	/**
	 * The '<em><b>LONG DOUBLE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LONG DOUBLE TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LONG_DOUBLE_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LONG_DOUBLE_TYPE = 9;

	/**
	 * The '<em><b>BOOLEAN TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOOLEAN TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_TYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_TYPE = 10;

	/**
	 * The '<em><b>INT TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType INT_TYPE_LITERAL = new NumericType(INT_TYPE, "INT_TYPE", "INT_TYPE");

	/**
	 * The '<em><b>OCTET TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OCTET_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType OCTET_TYPE_LITERAL = new NumericType(OCTET_TYPE, "OCTET_TYPE", "OCTET_TYPE");

	/**
	 * The '<em><b>UNSIGNED TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSIGNED_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType UNSIGNED_TYPE_LITERAL = new NumericType(UNSIGNED_TYPE, "UNSIGNED_TYPE", "UNSIGNED_TYPE");

	/**
	 * The '<em><b>FLOAT TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType FLOAT_TYPE_LITERAL = new NumericType(FLOAT_TYPE, "FLOAT_TYPE", "FLOAT_TYPE");

	/**
	 * The '<em><b>COMPLEX TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPLEX_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType COMPLEX_TYPE_LITERAL = new NumericType(COMPLEX_TYPE, "COMPLEX_TYPE", "COMPLEX_TYPE");

	/**
	 * The '<em><b>DATE TIME TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_TIME_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType DATE_TIME_TYPE_LITERAL = new NumericType(DATE_TIME_TYPE, "DATE_TIME_TYPE", "DATE_TIME_TYPE");

	/**
	 * The '<em><b>ULONG LONG TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ULONG_LONG_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType ULONG_LONG_TYPE_LITERAL = new NumericType(ULONG_LONG_TYPE, "ULONG_LONG_TYPE", "ULONG_LONG_TYPE");

	/**
	 * The '<em><b>SHORT TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHORT_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType SHORT_TYPE_LITERAL = new NumericType(SHORT_TYPE, "SHORT_TYPE", "SHORT_TYPE");

	/**
	 * The '<em><b>LONG LONG TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LONG_LONG_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType LONG_LONG_TYPE_LITERAL = new NumericType(LONG_LONG_TYPE, "LONG_LONG_TYPE", "LONG_LONG_TYPE");

	/**
	 * The '<em><b>LONG DOUBLE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LONG_DOUBLE_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType LONG_DOUBLE_TYPE_LITERAL = new NumericType(LONG_DOUBLE_TYPE, "LONG_DOUBLE_TYPE", "LONG_DOUBLE_TYPE");

	/**
	 * The '<em><b>BOOLEAN TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_TYPE
	 * @generated
	 * @ordered
	 */
	public static final NumericType BOOLEAN_TYPE_LITERAL = new NumericType(BOOLEAN_TYPE, "BOOLEAN_TYPE", "BOOLEAN_TYPE");

	/**
	 * An array of all the '<em><b>Numeric Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NumericType[] VALUES_ARRAY =
		new NumericType[] {
			INT_TYPE_LITERAL,
			OCTET_TYPE_LITERAL,
			UNSIGNED_TYPE_LITERAL,
			FLOAT_TYPE_LITERAL,
			COMPLEX_TYPE_LITERAL,
			DATE_TIME_TYPE_LITERAL,
			ULONG_LONG_TYPE_LITERAL,
			SHORT_TYPE_LITERAL,
			LONG_LONG_TYPE_LITERAL,
			LONG_DOUBLE_TYPE_LITERAL,
			BOOLEAN_TYPE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Numeric Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Numeric Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NumericType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NumericType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Numeric Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NumericType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NumericType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Numeric Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NumericType get(int value) {
		switch (value) {
			case INT_TYPE: return INT_TYPE_LITERAL;
			case OCTET_TYPE: return OCTET_TYPE_LITERAL;
			case UNSIGNED_TYPE: return UNSIGNED_TYPE_LITERAL;
			case FLOAT_TYPE: return FLOAT_TYPE_LITERAL;
			case COMPLEX_TYPE: return COMPLEX_TYPE_LITERAL;
			case DATE_TIME_TYPE: return DATE_TIME_TYPE_LITERAL;
			case ULONG_LONG_TYPE: return ULONG_LONG_TYPE_LITERAL;
			case SHORT_TYPE: return SHORT_TYPE_LITERAL;
			case LONG_LONG_TYPE: return LONG_LONG_TYPE_LITERAL;
			case LONG_DOUBLE_TYPE: return LONG_DOUBLE_TYPE_LITERAL;
			case BOOLEAN_TYPE: return BOOLEAN_TYPE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private NumericType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //NumericType
