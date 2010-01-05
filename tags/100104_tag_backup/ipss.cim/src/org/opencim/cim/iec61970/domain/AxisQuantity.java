/**
 * <copyright>
 * </copyright>
 *
 * $Id: AxisQuantity.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Axis Quantity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The quantities that can be used at the CurveSchedule axes.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getAxisQuantity()
 * @generated
 */
public final class AxisQuantity extends AbstractEnumerator {
	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Time</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int TIME = 1;

	/**
	 * The '<em><b>Active Power</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Power</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_POWER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_POWER = 2;

	/**
	 * The '<em><b>Reactive Power</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reactive Power</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REACTIVE_POWER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int REACTIVE_POWER = 3;

	/**
	 * The '<em><b>Currency</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Currency</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CURRENCY_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CURRENCY = 4;

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final AxisQuantity NONE_LITERAL = new AxisQuantity(NONE, "none", "none");

	/**
	 * The '<em><b>Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME
	 * @generated
	 * @ordered
	 */
	public static final AxisQuantity TIME_LITERAL = new AxisQuantity(TIME, "time", "time");

	/**
	 * The '<em><b>Active Power</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_POWER
	 * @generated
	 * @ordered
	 */
	public static final AxisQuantity ACTIVE_POWER_LITERAL = new AxisQuantity(ACTIVE_POWER, "activePower", "activePower");

	/**
	 * The '<em><b>Reactive Power</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REACTIVE_POWER
	 * @generated
	 * @ordered
	 */
	public static final AxisQuantity REACTIVE_POWER_LITERAL = new AxisQuantity(REACTIVE_POWER, "reactivePower", "reactivePower");

	/**
	 * The '<em><b>Currency</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURRENCY
	 * @generated
	 * @ordered
	 */
	public static final AxisQuantity CURRENCY_LITERAL = new AxisQuantity(CURRENCY, "currency", "currency");

	/**
	 * An array of all the '<em><b>Axis Quantity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AxisQuantity[] VALUES_ARRAY =
		new AxisQuantity[] {
			NONE_LITERAL,
			TIME_LITERAL,
			ACTIVE_POWER_LITERAL,
			REACTIVE_POWER_LITERAL,
			CURRENCY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Axis Quantity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Axis Quantity</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AxisQuantity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AxisQuantity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Axis Quantity</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AxisQuantity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AxisQuantity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Axis Quantity</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AxisQuantity get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case TIME: return TIME_LITERAL;
			case ACTIVE_POWER: return ACTIVE_POWER_LITERAL;
			case REACTIVE_POWER: return REACTIVE_POWER_LITERAL;
			case CURRENCY: return CURRENCY_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AxisQuantity(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AxisQuantity
