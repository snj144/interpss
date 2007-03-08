/**
 * <copyright>
 * </copyright>
 *
 * $Id: SpillwayGateType.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Spillway Gate Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of spillway gate.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getSpillwayGateType()
 * @model
 * @generated
 */
public final class SpillwayGateType extends AbstractEnumerator {
	/**
	 * The '<em><b>Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TYPE_LITERAL
	 * @model name="Type"
	 * @generated
	 * @ordered
	 */
	public static final int TYPE = 0;

	/**
	 * The '<em><b>Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OF_LITERAL
	 * @model name="of"
	 * @generated
	 * @ordered
	 */
	public static final int OF = 1;

	/**
	 * The '<em><b>Spillway</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Spillway</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPILLWAY_LITERAL
	 * @model name="spillway"
	 * @generated
	 * @ordered
	 */
	public static final int SPILLWAY = 2;

	/**
	 * The '<em><b>Gate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Gate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GATE_LITERAL
	 * @model name="gate"
	 * @generated
	 * @ordered
	 */
	public static final int GATE = 3;

	/**
	 * The '<em><b>Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE
	 * @generated
	 * @ordered
	 */
	public static final SpillwayGateType TYPE_LITERAL = new SpillwayGateType(TYPE, "Type", "Type");

	/**
	 * The '<em><b>Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OF
	 * @generated
	 * @ordered
	 */
	public static final SpillwayGateType OF_LITERAL = new SpillwayGateType(OF, "of", "of");

	/**
	 * The '<em><b>Spillway</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPILLWAY
	 * @generated
	 * @ordered
	 */
	public static final SpillwayGateType SPILLWAY_LITERAL = new SpillwayGateType(SPILLWAY, "spillway", "spillway");

	/**
	 * The '<em><b>Gate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATE
	 * @generated
	 * @ordered
	 */
	public static final SpillwayGateType GATE_LITERAL = new SpillwayGateType(GATE, "gate", "gate");

	/**
	 * An array of all the '<em><b>Spillway Gate Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SpillwayGateType[] VALUES_ARRAY =
		new SpillwayGateType[] {
			TYPE_LITERAL,
			OF_LITERAL,
			SPILLWAY_LITERAL,
			GATE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Spillway Gate Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Spillway Gate Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpillwayGateType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpillwayGateType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Spillway Gate Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpillwayGateType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpillwayGateType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Spillway Gate Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpillwayGateType get(int value) {
		switch (value) {
			case TYPE: return TYPE_LITERAL;
			case OF: return OF_LITERAL;
			case SPILLWAY: return SPILLWAY_LITERAL;
			case GATE: return GATE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SpillwayGateType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SpillwayGateType
