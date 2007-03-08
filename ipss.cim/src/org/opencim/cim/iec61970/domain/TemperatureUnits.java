/**
 * <copyright>
 * </copyright>
 *
 * $Id: TemperatureUnits.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Temperature Units</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Units for temperature measurement {celsius , fahrenheit}
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getTemperatureUnits()
 * @model
 * @generated
 */
public final class TemperatureUnits extends AbstractEnumerator {
	/**
	 * The '<em><b>Celsius</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Celsius</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CELSIUS_LITERAL
	 * @model name="celsius"
	 * @generated
	 * @ordered
	 */
	public static final int CELSIUS = 0;

	/**
	 * The '<em><b>Fahrenheit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fahrenheit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAHRENHEIT_LITERAL
	 * @model name="fahrenheit"
	 * @generated
	 * @ordered
	 */
	public static final int FAHRENHEIT = 1;

	/**
	 * The '<em><b>Celsius</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CELSIUS
	 * @generated
	 * @ordered
	 */
	public static final TemperatureUnits CELSIUS_LITERAL = new TemperatureUnits(CELSIUS, "celsius", "celsius");

	/**
	 * The '<em><b>Fahrenheit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAHRENHEIT
	 * @generated
	 * @ordered
	 */
	public static final TemperatureUnits FAHRENHEIT_LITERAL = new TemperatureUnits(FAHRENHEIT, "fahrenheit", "fahrenheit");

	/**
	 * An array of all the '<em><b>Temperature Units</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TemperatureUnits[] VALUES_ARRAY =
		new TemperatureUnits[] {
			CELSIUS_LITERAL,
			FAHRENHEIT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Temperature Units</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Temperature Units</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemperatureUnits get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TemperatureUnits result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temperature Units</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemperatureUnits getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TemperatureUnits result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temperature Units</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemperatureUnits get(int value) {
		switch (value) {
			case CELSIUS: return CELSIUS_LITERAL;
			case FAHRENHEIT: return FAHRENHEIT_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TemperatureUnits(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TemperatureUnits
