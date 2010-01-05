/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoolantType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Coolant Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Method of cooling a machine.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getCoolantType()
 * @generated
 */
public final class CoolantType extends AbstractEnumerator {
	/**
	 * The '<em><b>Air</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Air</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIR_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int AIR = 0;

	/**
	 * The '<em><b>Hydrogen Gas</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hydrogen Gas</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYDROGEN_GAS_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int HYDROGEN_GAS = 1;

	/**
	 * The '<em><b>Water</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Water</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int WATER = 2;

	/**
	 * The '<em><b>Air</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIR
	 * @generated
	 * @ordered
	 */
	public static final CoolantType AIR_LITERAL = new CoolantType(AIR, "air", "air");

	/**
	 * The '<em><b>Hydrogen Gas</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDROGEN_GAS
	 * @generated
	 * @ordered
	 */
	public static final CoolantType HYDROGEN_GAS_LITERAL = new CoolantType(HYDROGEN_GAS, "hydrogenGas", "hydrogenGas");

	/**
	 * The '<em><b>Water</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATER
	 * @generated
	 * @ordered
	 */
	public static final CoolantType WATER_LITERAL = new CoolantType(WATER, "water", "water");

	/**
	 * An array of all the '<em><b>Coolant Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CoolantType[] VALUES_ARRAY =
		new CoolantType[] {
			AIR_LITERAL,
			HYDROGEN_GAS_LITERAL,
			WATER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Coolant Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Coolant Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoolantType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CoolantType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Coolant Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoolantType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CoolantType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Coolant Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoolantType get(int value) {
		switch (value) {
			case AIR: return AIR_LITERAL;
			case HYDROGEN_GAS: return HYDROGEN_GAS_LITERAL;
			case WATER: return WATER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CoolantType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CoolantType
