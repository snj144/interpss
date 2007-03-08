/**
 * <copyright>
 * </copyright>
 *
 * $Id: WindingType.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Winding Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The winding type, i.e., Primary, Secondary, Tertiary, Quaternary.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getWindingType()
 * @model
 * @generated
 */
public final class WindingType extends AbstractEnumerator {
	/**
	 * The '<em><b>Primary</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Primary</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIMARY_LITERAL
	 * @model name="primary"
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY = 0;

	/**
	 * The '<em><b>Secondary</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Secondary</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECONDARY_LITERAL
	 * @model name="secondary"
	 * @generated
	 * @ordered
	 */
	public static final int SECONDARY = 1;

	/**
	 * The '<em><b>Tertiary</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tertiary</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERTIARY_LITERAL
	 * @model name="tertiary"
	 * @generated
	 * @ordered
	 */
	public static final int TERTIARY = 2;

	/**
	 * The '<em><b>Quaternary</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Quaternary</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUATERNARY_LITERAL
	 * @model name="quaternary"
	 * @generated
	 * @ordered
	 */
	public static final int QUATERNARY = 3;

	/**
	 * The '<em><b>Primary</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIMARY
	 * @generated
	 * @ordered
	 */
	public static final WindingType PRIMARY_LITERAL = new WindingType(PRIMARY, "primary", "primary");

	/**
	 * The '<em><b>Secondary</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECONDARY
	 * @generated
	 * @ordered
	 */
	public static final WindingType SECONDARY_LITERAL = new WindingType(SECONDARY, "secondary", "secondary");

	/**
	 * The '<em><b>Tertiary</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERTIARY
	 * @generated
	 * @ordered
	 */
	public static final WindingType TERTIARY_LITERAL = new WindingType(TERTIARY, "tertiary", "tertiary");

	/**
	 * The '<em><b>Quaternary</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUATERNARY
	 * @generated
	 * @ordered
	 */
	public static final WindingType QUATERNARY_LITERAL = new WindingType(QUATERNARY, "quaternary", "quaternary");

	/**
	 * An array of all the '<em><b>Winding Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WindingType[] VALUES_ARRAY =
		new WindingType[] {
			PRIMARY_LITERAL,
			SECONDARY_LITERAL,
			TERTIARY_LITERAL,
			QUATERNARY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Winding Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Winding Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WindingType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindingType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Winding Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WindingType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindingType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Winding Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WindingType get(int value) {
		switch (value) {
			case PRIMARY: return PRIMARY_LITERAL;
			case SECONDARY: return SECONDARY_LITERAL;
			case TERTIARY: return TERTIARY_LITERAL;
			case QUATERNARY: return QUATERNARY_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private WindingType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WindingType
