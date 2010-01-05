/**
 * <copyright>
 * </copyright>
 *
 * $Id: RampUnits.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ramp Units</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The deltaY versus deltaX units of measure.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getRampUnits()
 * @generated
 */
public final class RampUnits extends AbstractEnumerator {
	/**
	 * The '<em><b>MW Per Minute</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MW Per Minute</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MW_PER_MINUTE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int MW_PER_MINUTE = 0;

	/**
	 * The '<em><b>Ramp Completion In Min</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ramp Completion In Min</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAMP_COMPLETION_IN_MIN_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int RAMP_COMPLETION_IN_MIN = 1;

	/**
	 * The '<em><b>MW Per Minute</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MW_PER_MINUTE
	 * @generated
	 * @ordered
	 */
	public static final RampUnits MW_PER_MINUTE_LITERAL = new RampUnits(MW_PER_MINUTE, "MWPerMinute", "MWPerMinute");

	/**
	 * The '<em><b>Ramp Completion In Min</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAMP_COMPLETION_IN_MIN
	 * @generated
	 * @ordered
	 */
	public static final RampUnits RAMP_COMPLETION_IN_MIN_LITERAL = new RampUnits(RAMP_COMPLETION_IN_MIN, "rampCompletionInMin", "rampCompletionInMin");

	/**
	 * An array of all the '<em><b>Ramp Units</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RampUnits[] VALUES_ARRAY =
		new RampUnits[] {
			MW_PER_MINUTE_LITERAL,
			RAMP_COMPLETION_IN_MIN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ramp Units</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ramp Units</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RampUnits get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RampUnits result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ramp Units</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RampUnits getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RampUnits result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ramp Units</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RampUnits get(int value) {
		switch (value) {
			case MW_PER_MINUTE: return MW_PER_MINUTE_LITERAL;
			case RAMP_COMPLETION_IN_MIN: return RAMP_COMPLETION_IN_MIN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RampUnits(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RampUnits
