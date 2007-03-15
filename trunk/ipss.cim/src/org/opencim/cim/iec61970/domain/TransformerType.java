/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransformerType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transformer Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getTransformerType()
 * @generated
 */
public final class TransformerType extends AbstractEnumerator {
	/**
	 * The '<em><b>Fix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fix</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIX_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int FIX = 0;

	/**
	 * The '<em><b>Voltage Control</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Voltage Control</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLTAGE_CONTROL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int VOLTAGE_CONTROL = 1;

	/**
	 * The '<em><b>Phase Control</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Phase Control</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHASE_CONTROL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PHASE_CONTROL = 2;

	/**
	 * The '<em><b>Voltage And Phase Control</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Voltage And Phase Control</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLTAGE_AND_PHASE_CONTROL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int VOLTAGE_AND_PHASE_CONTROL = 3;

	/**
	 * The '<em><b>Fix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIX
	 * @generated
	 * @ordered
	 */
	public static final TransformerType FIX_LITERAL = new TransformerType(FIX, "fix", "fix");

	/**
	 * The '<em><b>Voltage Control</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLTAGE_CONTROL
	 * @generated
	 * @ordered
	 */
	public static final TransformerType VOLTAGE_CONTROL_LITERAL = new TransformerType(VOLTAGE_CONTROL, "voltageControl", "voltageControl");

	/**
	 * The '<em><b>Phase Control</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHASE_CONTROL
	 * @generated
	 * @ordered
	 */
	public static final TransformerType PHASE_CONTROL_LITERAL = new TransformerType(PHASE_CONTROL, "phaseControl", "phaseControl");

	/**
	 * The '<em><b>Voltage And Phase Control</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLTAGE_AND_PHASE_CONTROL
	 * @generated
	 * @ordered
	 */
	public static final TransformerType VOLTAGE_AND_PHASE_CONTROL_LITERAL = new TransformerType(VOLTAGE_AND_PHASE_CONTROL, "voltageAndPhaseControl", "voltageAndPhaseControl");

	/**
	 * An array of all the '<em><b>Transformer Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransformerType[] VALUES_ARRAY =
		new TransformerType[] {
			FIX_LITERAL,
			VOLTAGE_CONTROL_LITERAL,
			PHASE_CONTROL_LITERAL,
			VOLTAGE_AND_PHASE_CONTROL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Transformer Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transformer Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transformer Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transformer Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerType get(int value) {
		switch (value) {
			case FIX: return FIX_LITERAL;
			case VOLTAGE_CONTROL: return VOLTAGE_CONTROL_LITERAL;
			case PHASE_CONTROL: return PHASE_CONTROL_LITERAL;
			case VOLTAGE_AND_PHASE_CONTROL: return VOLTAGE_AND_PHASE_CONTROL_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransformerType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TransformerType
