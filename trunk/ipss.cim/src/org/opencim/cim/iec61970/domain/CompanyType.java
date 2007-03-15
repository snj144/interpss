/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompanyType.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Company Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of company.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getCompanyType()
 * @generated
 */
public final class CompanyType extends AbstractEnumerator {
	/**
	 * The '<em><b>Pool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POOL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int POOL = 0;

	/**
	 * The '<em><b>Municipal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Municipal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUNICIPAL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int MUNICIPAL = 1;

	/**
	 * The '<em><b>Is Private</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Is Private</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IS_PRIVATE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int IS_PRIVATE = 2;

	/**
	 * The '<em><b>Pool</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POOL
	 * @generated
	 * @ordered
	 */
	public static final CompanyType POOL_LITERAL = new CompanyType(POOL, "pool", "pool");

	/**
	 * The '<em><b>Municipal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUNICIPAL
	 * @generated
	 * @ordered
	 */
	public static final CompanyType MUNICIPAL_LITERAL = new CompanyType(MUNICIPAL, "municipal", "municipal");

	/**
	 * The '<em><b>Is Private</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IS_PRIVATE
	 * @generated
	 * @ordered
	 */
	public static final CompanyType IS_PRIVATE_LITERAL = new CompanyType(IS_PRIVATE, "isPrivate", "isPrivate");

	/**
	 * An array of all the '<em><b>Company Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompanyType[] VALUES_ARRAY =
		new CompanyType[] {
			POOL_LITERAL,
			MUNICIPAL_LITERAL,
			IS_PRIVATE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Company Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Company Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompanyType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompanyType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Company Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompanyType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompanyType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Company Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompanyType get(int value) {
		switch (value) {
			case POOL: return POOL_LITERAL;
			case MUNICIPAL: return MUNICIPAL_LITERAL;
			case IS_PRIVATE: return IS_PRIVATE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CompanyType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CompanyType
