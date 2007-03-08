/**
 * <copyright>
 * </copyright>
 *
 * $Id: RampStartMethod.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ramp Start Method</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The method of applying the ramp.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getRampStartMethod()
 * @model
 * @generated
 */
public final class RampStartMethod extends AbstractEnumerator {
	/**
	 * The '<em><b>Zero</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zero</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZERO_LITERAL
	 * @model name="zero"
	 * @generated
	 * @ordered
	 */
	public static final int ZERO = 0;

	/**
	 * The '<em><b>Fifty Per Cent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fifty Per Cent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIFTY_PER_CENT_LITERAL
	 * @model name="fiftyPerCent"
	 * @generated
	 * @ordered
	 */
	public static final int FIFTY_PER_CENT = 1;

	/**
	 * The '<em><b>One Hundred Per Cent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>One Hundred Per Cent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_HUNDRED_PER_CENT_LITERAL
	 * @model name="oneHundredPerCent"
	 * @generated
	 * @ordered
	 */
	public static final int ONE_HUNDRED_PER_CENT = 2;

	/**
	 * The '<em><b>Zero</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZERO
	 * @generated
	 * @ordered
	 */
	public static final RampStartMethod ZERO_LITERAL = new RampStartMethod(ZERO, "zero", "zero");

	/**
	 * The '<em><b>Fifty Per Cent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIFTY_PER_CENT
	 * @generated
	 * @ordered
	 */
	public static final RampStartMethod FIFTY_PER_CENT_LITERAL = new RampStartMethod(FIFTY_PER_CENT, "fiftyPerCent", "fiftyPerCent");

	/**
	 * The '<em><b>One Hundred Per Cent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_HUNDRED_PER_CENT
	 * @generated
	 * @ordered
	 */
	public static final RampStartMethod ONE_HUNDRED_PER_CENT_LITERAL = new RampStartMethod(ONE_HUNDRED_PER_CENT, "oneHundredPerCent", "oneHundredPerCent");

	/**
	 * An array of all the '<em><b>Ramp Start Method</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RampStartMethod[] VALUES_ARRAY =
		new RampStartMethod[] {
			ZERO_LITERAL,
			FIFTY_PER_CENT_LITERAL,
			ONE_HUNDRED_PER_CENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ramp Start Method</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ramp Start Method</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RampStartMethod get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RampStartMethod result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ramp Start Method</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RampStartMethod getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RampStartMethod result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ramp Start Method</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RampStartMethod get(int value) {
		switch (value) {
			case ZERO: return ZERO_LITERAL;
			case FIFTY_PER_CENT: return FIFTY_PER_CENT_LITERAL;
			case ONE_HUNDRED_PER_CENT: return ONE_HUNDRED_PER_CENT_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RampStartMethod(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RampStartMethod
