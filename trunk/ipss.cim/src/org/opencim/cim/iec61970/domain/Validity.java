/**
 * <copyright>
 * </copyright>
 *
 * $Id: Validity.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Validity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getValidity()
 * @model
 * @generated
 */
public final class Validity extends AbstractEnumerator {
	/**
	 * The '<em><b>GOOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value is marked good if no abnormal condition of the acquisition function or the information source is detected.
	 * <!-- end-model-doc -->
	 * @see #GOOD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GOOD = 0;

	/**
	 * The '<em><b>QUESTIONABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value is marked questionable if a supervision function detects an abnormal behaviour, however the value could still be valid. The client is responsible for determining whether or not values marked "questionable" should be used.
	 * <!-- end-model-doc -->
	 * @see #QUESTIONABLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUESTIONABLE = 1;

	/**
	 * The '<em><b>INVALID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value is marked invalid when a supervision function recognises abnormal conditions of the acquisition function or the information source (missing or non-operating updating devices). The value is not defined under this condition. The mark invalid is used to indicate to the client that the value may be incorrect and shall not be used.
	 * <!-- end-model-doc -->
	 * @see #INVALID_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVALID = 2;

	/**
	 * The '<em><b>GOOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOOD
	 * @generated
	 * @ordered
	 */
	public static final Validity GOOD_LITERAL = new Validity(GOOD, "GOOD", "GOOD");

	/**
	 * The '<em><b>QUESTIONABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUESTIONABLE
	 * @generated
	 * @ordered
	 */
	public static final Validity QUESTIONABLE_LITERAL = new Validity(QUESTIONABLE, "QUESTIONABLE", "QUESTIONABLE");

	/**
	 * The '<em><b>INVALID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVALID
	 * @generated
	 * @ordered
	 */
	public static final Validity INVALID_LITERAL = new Validity(INVALID, "INVALID", "INVALID");

	/**
	 * An array of all the '<em><b>Validity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Validity[] VALUES_ARRAY =
		new Validity[] {
			GOOD_LITERAL,
			QUESTIONABLE_LITERAL,
			INVALID_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Validity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Validity</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Validity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Validity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Validity</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Validity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Validity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Validity</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Validity get(int value) {
		switch (value) {
			case GOOD: return GOOD_LITERAL;
			case QUESTIONABLE: return QUESTIONABLE_LITERAL;
			case INVALID: return INVALID_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Validity(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Validity
