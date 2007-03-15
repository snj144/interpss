/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratorControlMode.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Generator Control Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Unit control modes, i.e., Setpoint  or Pulse
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getGeneratorControlMode()
 * @generated
 */
public final class GeneratorControlMode extends AbstractEnumerator {
	/**
	 * The '<em><b>Setpoint</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Setpoint</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SETPOINT_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int SETPOINT = 0;

	/**
	 * The '<em><b>Pulse</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pulse</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PULSE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PULSE = 1;

	/**
	 * The '<em><b>Setpoint</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SETPOINT
	 * @generated
	 * @ordered
	 */
	public static final GeneratorControlMode SETPOINT_LITERAL = new GeneratorControlMode(SETPOINT, "setpoint", "setpoint");

	/**
	 * The '<em><b>Pulse</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PULSE
	 * @generated
	 * @ordered
	 */
	public static final GeneratorControlMode PULSE_LITERAL = new GeneratorControlMode(PULSE, "pulse", "pulse");

	/**
	 * An array of all the '<em><b>Generator Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GeneratorControlMode[] VALUES_ARRAY =
		new GeneratorControlMode[] {
			SETPOINT_LITERAL,
			PULSE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Generator Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Generator Control Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorControlMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratorControlMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generator Control Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorControlMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratorControlMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generator Control Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorControlMode get(int value) {
		switch (value) {
			case SETPOINT: return SETPOINT_LITERAL;
			case PULSE: return PULSE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GeneratorControlMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //GeneratorControlMode
