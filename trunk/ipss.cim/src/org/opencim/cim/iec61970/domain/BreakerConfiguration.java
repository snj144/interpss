/**
 * <copyright>
 * </copyright>
 *
 * $Id: BreakerConfiguration.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Breaker Configuration</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Switching arrangement for Bay. 
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getBreakerConfiguration()
 * @generated
 */
public final class BreakerConfiguration extends AbstractEnumerator {
	/**
	 * The '<em><b>Single Breaker</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Single Breaker</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_BREAKER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_BREAKER = 0;

	/**
	 * The '<em><b>Breaker And AHalf</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Breaker And AHalf</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREAKER_AND_AHALF_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int BREAKER_AND_AHALF = 1;

	/**
	 * The '<em><b>Double Breaker</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Double Breaker</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_BREAKER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_BREAKER = 2;

	/**
	 * The '<em><b>No Breaker</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No Breaker</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_BREAKER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int NO_BREAKER = 3;

	/**
	 * The '<em><b>Single Breaker</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_BREAKER
	 * @generated
	 * @ordered
	 */
	public static final BreakerConfiguration SINGLE_BREAKER_LITERAL = new BreakerConfiguration(SINGLE_BREAKER, "singleBreaker", "singleBreaker");

	/**
	 * The '<em><b>Breaker And AHalf</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAKER_AND_AHALF
	 * @generated
	 * @ordered
	 */
	public static final BreakerConfiguration BREAKER_AND_AHALF_LITERAL = new BreakerConfiguration(BREAKER_AND_AHALF, "breakerAndAHalf", "breakerAndAHalf");

	/**
	 * The '<em><b>Double Breaker</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_BREAKER
	 * @generated
	 * @ordered
	 */
	public static final BreakerConfiguration DOUBLE_BREAKER_LITERAL = new BreakerConfiguration(DOUBLE_BREAKER, "doubleBreaker", "doubleBreaker");

	/**
	 * The '<em><b>No Breaker</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_BREAKER
	 * @generated
	 * @ordered
	 */
	public static final BreakerConfiguration NO_BREAKER_LITERAL = new BreakerConfiguration(NO_BREAKER, "noBreaker", "noBreaker");

	/**
	 * An array of all the '<em><b>Breaker Configuration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BreakerConfiguration[] VALUES_ARRAY =
		new BreakerConfiguration[] {
			SINGLE_BREAKER_LITERAL,
			BREAKER_AND_AHALF_LITERAL,
			DOUBLE_BREAKER_LITERAL,
			NO_BREAKER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Breaker Configuration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Breaker Configuration</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BreakerConfiguration get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BreakerConfiguration result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Breaker Configuration</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BreakerConfiguration getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BreakerConfiguration result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Breaker Configuration</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BreakerConfiguration get(int value) {
		switch (value) {
			case SINGLE_BREAKER: return SINGLE_BREAKER_LITERAL;
			case BREAKER_AND_AHALF: return BREAKER_AND_AHALF_LITERAL;
			case DOUBLE_BREAKER: return DOUBLE_BREAKER_LITERAL;
			case NO_BREAKER: return NO_BREAKER_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BreakerConfiguration(int value, String name, String literal) {
		super(value, name, literal);
	}

} //BreakerConfiguration
