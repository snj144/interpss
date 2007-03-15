/**
 * <copyright>
 * </copyright>
 *
 * $Id: DayTypeName.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Day Type Name</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Name of day type.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getDayTypeName()
 * @generated
 */
public final class DayTypeName extends AbstractEnumerator {
	/**
	 * The '<em><b>Weekday</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Weekday</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEEKDAY_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int WEEKDAY = 0;

	/**
	 * The '<em><b>Weekend</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Weekend</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEEKEND_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int WEEKEND = 1;

	/**
	 * The '<em><b>Holiday</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Holiday</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOLIDAY_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int HOLIDAY = 2;

	/**
	 * The '<em><b>Weekday</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEEKDAY
	 * @generated
	 * @ordered
	 */
	public static final DayTypeName WEEKDAY_LITERAL = new DayTypeName(WEEKDAY, "weekday", "weekday");

	/**
	 * The '<em><b>Weekend</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEEKEND
	 * @generated
	 * @ordered
	 */
	public static final DayTypeName WEEKEND_LITERAL = new DayTypeName(WEEKEND, "weekend", "weekend");

	/**
	 * The '<em><b>Holiday</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOLIDAY
	 * @generated
	 * @ordered
	 */
	public static final DayTypeName HOLIDAY_LITERAL = new DayTypeName(HOLIDAY, "holiday", "holiday");

	/**
	 * An array of all the '<em><b>Day Type Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DayTypeName[] VALUES_ARRAY =
		new DayTypeName[] {
			WEEKDAY_LITERAL,
			WEEKEND_LITERAL,
			HOLIDAY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Day Type Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Day Type Name</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DayTypeName get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DayTypeName result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Day Type Name</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DayTypeName getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DayTypeName result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Day Type Name</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DayTypeName get(int value) {
		switch (value) {
			case WEEKDAY: return WEEKDAY_LITERAL;
			case WEEKEND: return WEEKEND_LITERAL;
			case HOLIDAY: return HOLIDAY_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DayTypeName(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DayTypeName
