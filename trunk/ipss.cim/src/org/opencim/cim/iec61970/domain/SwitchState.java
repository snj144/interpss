/**
 * <copyright>
 * </copyright>
 *
 * $Id: SwitchState.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Switch State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Possible states for a switch.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getSwitchState()
 * @model
 * @generated
 */
public final class SwitchState extends AbstractEnumerator {
	/**
	 * The '<em><b>Open</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Open</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPEN_LITERAL
	 * @model name="open"
	 * @generated
	 * @ordered
	 */
	public static final int OPEN = 0;

	/**
	 * The '<em><b>Close</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Close</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLOSE_LITERAL
	 * @model name="close"
	 * @generated
	 * @ordered
	 */
	public static final int CLOSE = 1;

	/**
	 * The '<em><b>Open</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPEN
	 * @generated
	 * @ordered
	 */
	public static final SwitchState OPEN_LITERAL = new SwitchState(OPEN, "open", "open");

	/**
	 * The '<em><b>Close</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLOSE
	 * @generated
	 * @ordered
	 */
	public static final SwitchState CLOSE_LITERAL = new SwitchState(CLOSE, "close", "close");

	/**
	 * An array of all the '<em><b>Switch State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SwitchState[] VALUES_ARRAY =
		new SwitchState[] {
			OPEN_LITERAL,
			CLOSE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Switch State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Switch State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SwitchState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SwitchState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Switch State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SwitchState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SwitchState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Switch State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SwitchState get(int value) {
		switch (value) {
			case OPEN: return OPEN_LITERAL;
			case CLOSE: return CLOSE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SwitchState(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SwitchState
