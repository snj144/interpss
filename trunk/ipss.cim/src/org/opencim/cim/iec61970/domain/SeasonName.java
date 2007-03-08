/**
 * <copyright>
 * </copyright>
 *
 * $Id: SeasonName.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Season Name</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Name of season
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getSeasonName()
 * @model
 * @generated
 */
public final class SeasonName extends AbstractEnumerator {
	/**
	 * The '<em><b>Winter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Winter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WINTER_LITERAL
	 * @model name="winter"
	 * @generated
	 * @ordered
	 */
	public static final int WINTER = 0;

	/**
	 * The '<em><b>Spring</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Spring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPRING_LITERAL
	 * @model name="spring"
	 * @generated
	 * @ordered
	 */
	public static final int SPRING = 1;

	/**
	 * The '<em><b>Summer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Summer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUMMER_LITERAL
	 * @model name="summer"
	 * @generated
	 * @ordered
	 */
	public static final int SUMMER = 2;

	/**
	 * The '<em><b>Fall</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fall</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FALL_LITERAL
	 * @model name="fall"
	 * @generated
	 * @ordered
	 */
	public static final int FALL = 3;

	/**
	 * The '<em><b>Winter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WINTER
	 * @generated
	 * @ordered
	 */
	public static final SeasonName WINTER_LITERAL = new SeasonName(WINTER, "winter", "winter");

	/**
	 * The '<em><b>Spring</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPRING
	 * @generated
	 * @ordered
	 */
	public static final SeasonName SPRING_LITERAL = new SeasonName(SPRING, "spring", "spring");

	/**
	 * The '<em><b>Summer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUMMER
	 * @generated
	 * @ordered
	 */
	public static final SeasonName SUMMER_LITERAL = new SeasonName(SUMMER, "summer", "summer");

	/**
	 * The '<em><b>Fall</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FALL
	 * @generated
	 * @ordered
	 */
	public static final SeasonName FALL_LITERAL = new SeasonName(FALL, "fall", "fall");

	/**
	 * An array of all the '<em><b>Season Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SeasonName[] VALUES_ARRAY =
		new SeasonName[] {
			WINTER_LITERAL,
			SPRING_LITERAL,
			SUMMER_LITERAL,
			FALL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Season Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Season Name</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SeasonName get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SeasonName result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Season Name</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SeasonName getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SeasonName result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Season Name</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SeasonName get(int value) {
		switch (value) {
			case WINTER: return WINTER_LITERAL;
			case SPRING: return SPRING_LITERAL;
			case SUMMER: return SUMMER_LITERAL;
			case FALL: return FALL_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SeasonName(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SeasonName
