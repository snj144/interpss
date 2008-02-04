/**
 * <copyright>
 * </copyright>
 *
 * $Id: TurbineType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Turbine Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of turbine.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getTurbineType()
 * @generated
 */
public final class TurbineType extends AbstractEnumerator {
	/**
	 * The '<em><b>Francis</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Francis</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRANCIS_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int FRANCIS = 0;

	/**
	 * The '<em><b>Pelton</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pelton</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PELTON_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PELTON = 1;

	/**
	 * The '<em><b>Kaplan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kaplan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KAPLAN_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int KAPLAN = 2;

	/**
	 * The '<em><b>Francis</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRANCIS
	 * @generated
	 * @ordered
	 */
	public static final TurbineType FRANCIS_LITERAL = new TurbineType(FRANCIS, "francis", "francis");

	/**
	 * The '<em><b>Pelton</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PELTON
	 * @generated
	 * @ordered
	 */
	public static final TurbineType PELTON_LITERAL = new TurbineType(PELTON, "pelton", "pelton");

	/**
	 * The '<em><b>Kaplan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KAPLAN
	 * @generated
	 * @ordered
	 */
	public static final TurbineType KAPLAN_LITERAL = new TurbineType(KAPLAN, "kaplan", "kaplan");

	/**
	 * An array of all the '<em><b>Turbine Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TurbineType[] VALUES_ARRAY =
		new TurbineType[] {
			FRANCIS_LITERAL,
			PELTON_LITERAL,
			KAPLAN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Turbine Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Turbine Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TurbineType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TurbineType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Turbine Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TurbineType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TurbineType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Turbine Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TurbineType get(int value) {
		switch (value) {
			case FRANCIS: return FRANCIS_LITERAL;
			case PELTON: return PELTON_LITERAL;
			case KAPLAN: return KAPLAN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TurbineType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TurbineType
