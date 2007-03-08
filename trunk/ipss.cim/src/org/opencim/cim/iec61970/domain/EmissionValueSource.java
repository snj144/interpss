/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmissionValueSource.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Emission Value Source</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The source of the emission value.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getEmissionValueSource()
 * @model
 * @generated
 */
public final class EmissionValueSource extends AbstractEnumerator {
	/**
	 * The '<em><b>Measured</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Measured</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEASURED_LITERAL
	 * @model name="measured"
	 * @generated
	 * @ordered
	 */
	public static final int MEASURED = 0;

	/**
	 * The '<em><b>Calculated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Calculated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALCULATED_LITERAL
	 * @model name="calculated"
	 * @generated
	 * @ordered
	 */
	public static final int CALCULATED = 1;

	/**
	 * The '<em><b>Measured</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEASURED
	 * @generated
	 * @ordered
	 */
	public static final EmissionValueSource MEASURED_LITERAL = new EmissionValueSource(MEASURED, "measured", "measured");

	/**
	 * The '<em><b>Calculated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALCULATED
	 * @generated
	 * @ordered
	 */
	public static final EmissionValueSource CALCULATED_LITERAL = new EmissionValueSource(CALCULATED, "calculated", "calculated");

	/**
	 * An array of all the '<em><b>Emission Value Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EmissionValueSource[] VALUES_ARRAY =
		new EmissionValueSource[] {
			MEASURED_LITERAL,
			CALCULATED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Emission Value Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Emission Value Source</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmissionValueSource get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmissionValueSource result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Emission Value Source</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmissionValueSource getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmissionValueSource result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Emission Value Source</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmissionValueSource get(int value) {
		switch (value) {
			case MEASURED: return MEASURED_LITERAL;
			case CALCULATED: return CALCULATED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EmissionValueSource(int value, String name, String literal) {
		super(value, name, literal);
	}

} //EmissionValueSource
