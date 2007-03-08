/**
 * <copyright>
 * </copyright>
 *
 * $Id: BoilerControlMode.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Boiler Control Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Boiler { Following, Coordinated}
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getBoilerControlMode()
 * @model
 * @generated
 */
public final class BoilerControlMode extends AbstractEnumerator {
	/**
	 * The '<em><b>Following</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Following</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLLOWING_LITERAL
	 * @model name="following"
	 * @generated
	 * @ordered
	 */
	public static final int FOLLOWING = 0;

	/**
	 * The '<em><b>Coordinated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Coordinated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COORDINATED_LITERAL
	 * @model name="coordinated"
	 * @generated
	 * @ordered
	 */
	public static final int COORDINATED = 1;

	/**
	 * The '<em><b>Following</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLLOWING
	 * @generated
	 * @ordered
	 */
	public static final BoilerControlMode FOLLOWING_LITERAL = new BoilerControlMode(FOLLOWING, "following", "following");

	/**
	 * The '<em><b>Coordinated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COORDINATED
	 * @generated
	 * @ordered
	 */
	public static final BoilerControlMode COORDINATED_LITERAL = new BoilerControlMode(COORDINATED, "coordinated", "coordinated");

	/**
	 * An array of all the '<em><b>Boiler Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BoilerControlMode[] VALUES_ARRAY =
		new BoilerControlMode[] {
			FOLLOWING_LITERAL,
			COORDINATED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Boiler Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Boiler Control Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BoilerControlMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BoilerControlMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Boiler Control Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BoilerControlMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BoilerControlMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Boiler Control Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BoilerControlMode get(int value) {
		switch (value) {
			case FOLLOWING: return FOLLOWING_LITERAL;
			case COORDINATED: return COORDINATED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BoilerControlMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //BoilerControlMode
