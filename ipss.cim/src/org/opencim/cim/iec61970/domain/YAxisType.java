/**
 * <copyright>
 * </copyright>
 *
 * $Id: YAxisType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>YAxis Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The type of dependent variable.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getYAxisType()
 * @model
 * @generated
 */
public final class YAxisType extends AbstractEnumerator {
	/**
	 * The '<em><b>Single YValue</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Single YValue</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_YVALUE_LITERAL
	 * @model name="singleYValue"
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_YVALUE = 0;

	/**
	 * The '<em><b>Two YValues</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Two YValues</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_YVALUES_LITERAL
	 * @model name="twoYValues"
	 * @generated
	 * @ordered
	 */
	public static final int TWO_YVALUES = 1;

	/**
	 * The '<em><b>Single YValue</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_YVALUE
	 * @generated
	 * @ordered
	 */
	public static final YAxisType SINGLE_YVALUE_LITERAL = new YAxisType(SINGLE_YVALUE, "singleYValue", "singleYValue");

	/**
	 * The '<em><b>Two YValues</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_YVALUES
	 * @generated
	 * @ordered
	 */
	public static final YAxisType TWO_YVALUES_LITERAL = new YAxisType(TWO_YVALUES, "twoYValues", "twoYValues");

	/**
	 * An array of all the '<em><b>YAxis Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final YAxisType[] VALUES_ARRAY =
		new YAxisType[] {
			SINGLE_YVALUE_LITERAL,
			TWO_YVALUES_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>YAxis Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>YAxis Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static YAxisType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			YAxisType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>YAxis Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static YAxisType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			YAxisType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>YAxis Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static YAxisType get(int value) {
		switch (value) {
			case SINGLE_YVALUE: return SINGLE_YVALUE_LITERAL;
			case TWO_YVALUES: return TWO_YVALUES_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private YAxisType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //YAxisType
