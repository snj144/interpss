/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompensatorType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Compensator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getCompensatorType()
 * @model
 * @generated
 */
public final class CompensatorType extends AbstractEnumerator {
	/**
	 * The '<em><b>Shunt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Shunt</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHUNT_LITERAL
	 * @model name="shunt"
	 * @generated
	 * @ordered
	 */
	public static final int SHUNT = 0;

	/**
	 * The '<em><b>Series</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Series</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERIES_LITERAL
	 * @model name="series"
	 * @generated
	 * @ordered
	 */
	public static final int SERIES = 1;

	/**
	 * The '<em><b>Shunt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHUNT
	 * @generated
	 * @ordered
	 */
	public static final CompensatorType SHUNT_LITERAL = new CompensatorType(SHUNT, "shunt", "shunt");

	/**
	 * The '<em><b>Series</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERIES
	 * @generated
	 * @ordered
	 */
	public static final CompensatorType SERIES_LITERAL = new CompensatorType(SERIES, "series", "series");

	/**
	 * An array of all the '<em><b>Compensator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompensatorType[] VALUES_ARRAY =
		new CompensatorType[] {
			SHUNT_LITERAL,
			SERIES_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Compensator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Compensator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompensatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompensatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compensator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompensatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompensatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compensator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompensatorType get(int value) {
		switch (value) {
			case SHUNT: return SHUNT_LITERAL;
			case SERIES: return SERIES_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CompensatorType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CompensatorType
