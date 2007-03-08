/**
 * <copyright>
 * </copyright>
 *
 * $Id: AreaControlMode.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Area Control Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getAreaControlMode()
 * @model
 * @generated
 */
public final class AreaControlMode extends AbstractEnumerator {
	/**
	 * The '<em><b>CF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Constant frequency
	 * <!-- end-model-doc -->
	 * @see #CF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CF = 0;

	/**
	 * The '<em><b>CTL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Constant tie-line
	 * <!-- end-model-doc -->
	 * @see #CTL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CTL = 1;

	/**
	 * The '<em><b>TLB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tie-line bias
	 * <!-- end-model-doc -->
	 * @see #TLB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TLB = 2;

	/**
	 * The '<em><b>OFF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Off control
	 * <!-- end-model-doc -->
	 * @see #OFF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OFF = 3;

	/**
	 * The '<em><b>CF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CF
	 * @generated
	 * @ordered
	 */
	public static final AreaControlMode CF_LITERAL = new AreaControlMode(CF, "CF", "CF");

	/**
	 * The '<em><b>CTL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CTL
	 * @generated
	 * @ordered
	 */
	public static final AreaControlMode CTL_LITERAL = new AreaControlMode(CTL, "CTL", "CTL");

	/**
	 * The '<em><b>TLB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TLB
	 * @generated
	 * @ordered
	 */
	public static final AreaControlMode TLB_LITERAL = new AreaControlMode(TLB, "TLB", "TLB");

	/**
	 * The '<em><b>OFF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFF
	 * @generated
	 * @ordered
	 */
	public static final AreaControlMode OFF_LITERAL = new AreaControlMode(OFF, "OFF", "OFF");

	/**
	 * An array of all the '<em><b>Area Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AreaControlMode[] VALUES_ARRAY =
		new AreaControlMode[] {
			CF_LITERAL,
			CTL_LITERAL,
			TLB_LITERAL,
			OFF_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Area Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Area Control Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AreaControlMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AreaControlMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Area Control Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AreaControlMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AreaControlMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Area Control Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AreaControlMode get(int value) {
		switch (value) {
			case CF: return CF_LITERAL;
			case CTL: return CTL_LITERAL;
			case TLB: return TLB_LITERAL;
			case OFF: return OFF_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AreaControlMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AreaControlMode
