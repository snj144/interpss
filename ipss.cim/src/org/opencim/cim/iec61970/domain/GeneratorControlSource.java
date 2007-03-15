/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratorControlSource.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Generator Control Source</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The source of controls for a generating unit, i.e., Unavailable, Off-AGC, On-AGC, Plant Control
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getGeneratorControlSource()
 * @generated
 */
public final class GeneratorControlSource extends AbstractEnumerator {
	/**
	 * The '<em><b>Unavailable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unavailable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNAVAILABLE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int UNAVAILABLE = 0;

	/**
	 * The '<em><b>Off AGC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Off AGC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OFF_AGC_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int OFF_AGC = 1;

	/**
	 * The '<em><b>On AGC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On AGC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_AGC_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int ON_AGC = 2;

	/**
	 * The '<em><b>Plant Control</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Plant Control</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANT_CONTROL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PLANT_CONTROL = 3;

	/**
	 * The '<em><b>Unavailable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNAVAILABLE
	 * @generated
	 * @ordered
	 */
	public static final GeneratorControlSource UNAVAILABLE_LITERAL = new GeneratorControlSource(UNAVAILABLE, "Unavailable", "Unavailable");

	/**
	 * The '<em><b>Off AGC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFF_AGC
	 * @generated
	 * @ordered
	 */
	public static final GeneratorControlSource OFF_AGC_LITERAL = new GeneratorControlSource(OFF_AGC, "offAGC", "offAGC");

	/**
	 * The '<em><b>On AGC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_AGC
	 * @generated
	 * @ordered
	 */
	public static final GeneratorControlSource ON_AGC_LITERAL = new GeneratorControlSource(ON_AGC, "onAGC", "onAGC");

	/**
	 * The '<em><b>Plant Control</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANT_CONTROL
	 * @generated
	 * @ordered
	 */
	public static final GeneratorControlSource PLANT_CONTROL_LITERAL = new GeneratorControlSource(PLANT_CONTROL, "PlantControl", "PlantControl");

	/**
	 * An array of all the '<em><b>Generator Control Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GeneratorControlSource[] VALUES_ARRAY =
		new GeneratorControlSource[] {
			UNAVAILABLE_LITERAL,
			OFF_AGC_LITERAL,
			ON_AGC_LITERAL,
			PLANT_CONTROL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Generator Control Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Generator Control Source</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorControlSource get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratorControlSource result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generator Control Source</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorControlSource getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratorControlSource result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generator Control Source</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorControlSource get(int value) {
		switch (value) {
			case UNAVAILABLE: return UNAVAILABLE_LITERAL;
			case OFF_AGC: return OFF_AGC_LITERAL;
			case ON_AGC: return ON_AGC_LITERAL;
			case PLANT_CONTROL: return PLANT_CONTROL_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GeneratorControlSource(int value, String name, String literal) {
		super(value, name, literal);
	}

} //GeneratorControlSource
