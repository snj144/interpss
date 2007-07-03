/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.appSimu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Simu Run Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.interpss.model.editor.appSimu.appSimuPackage#getSimuRunType()
 * @model
 * @generated
 */
public enum SimuRunType implements Enumerator {
	/**
	 * The '<em><b>ACLF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACLF_VALUE
	 * @generated
	 * @ordered
	 */
	ACLF(0, "ACLF", ""),

	/**
	 * The '<em><b>ACSC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACSC_VALUE
	 * @generated
	 * @ordered
	 */
	ACSC(1, "ACSC", "ACSC"),

	/**
	 * The '<em><b>DStab</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DSTAB_VALUE
	 * @generated
	 * @ordered
	 */
	DSTAB(2, "DStab", "DStab");

	/**
	 * The '<em><b>ACLF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACLF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACLF
	 * @model literal=""
	 * @generated
	 * @ordered
	 */
	public static final int ACLF_VALUE = 0;

	/**
	 * The '<em><b>ACSC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACSC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACSC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACSC_VALUE = 1;

	/**
	 * The '<em><b>DStab</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DStab</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DSTAB
	 * @model name="DStab"
	 * @generated
	 * @ordered
	 */
	public static final int DSTAB_VALUE = 2;

	/**
	 * An array of all the '<em><b>Simu Run Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SimuRunType[] VALUES_ARRAY =
		new SimuRunType[] {
			ACLF,
			ACSC,
			DSTAB,
		};

	/**
	 * A public read-only list of all the '<em><b>Simu Run Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SimuRunType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Simu Run Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimuRunType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SimuRunType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Simu Run Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimuRunType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SimuRunType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Simu Run Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimuRunType get(int value) {
		switch (value) {
			case ACLF_VALUE: return ACLF;
			case ACSC_VALUE: return ACSC;
			case DSTAB_VALUE: return DSTAB;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SimuRunType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SimuRunType
