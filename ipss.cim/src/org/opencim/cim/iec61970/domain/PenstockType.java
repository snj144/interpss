/**
 * <copyright>
 * </copyright>
 *
 * $Id: PenstockType.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Penstock Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of hydro plant penstock.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getPenstockType()
 * @generated
 */
public final class PenstockType extends AbstractEnumerator {
	/**
	 * The '<em><b>Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TYPE_LITERAL
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
	 * @generated
	 * @ordered
	 */
	public static final int OF = 1;

	/**
	 * The '<em><b>Hydro</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hydro</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYDRO_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int HYDRO = 2;

	/**
	 * The '<em><b>Plant</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Plant</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANT_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PLANT = 3;

	/**
	 * The '<em><b>Penstock</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Penstock</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PENSTOCK_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int PENSTOCK = 4;

	/**
	 * The '<em><b>Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE
	 * @generated
	 * @ordered
	 */
	public static final PenstockType TYPE_LITERAL = new PenstockType(TYPE, "Type", "Type");

	/**
	 * The '<em><b>Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OF
	 * @generated
	 * @ordered
	 */
	public static final PenstockType OF_LITERAL = new PenstockType(OF, "of", "of");

	/**
	 * The '<em><b>Hydro</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDRO
	 * @generated
	 * @ordered
	 */
	public static final PenstockType HYDRO_LITERAL = new PenstockType(HYDRO, "hydro", "hydro");

	/**
	 * The '<em><b>Plant</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANT
	 * @generated
	 * @ordered
	 */
	public static final PenstockType PLANT_LITERAL = new PenstockType(PLANT, "plant", "plant");

	/**
	 * The '<em><b>Penstock</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PENSTOCK
	 * @generated
	 * @ordered
	 */
	public static final PenstockType PENSTOCK_LITERAL = new PenstockType(PENSTOCK, "penstock", "penstock");

	/**
	 * An array of all the '<em><b>Penstock Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PenstockType[] VALUES_ARRAY =
		new PenstockType[] {
			TYPE_LITERAL,
			OF_LITERAL,
			HYDRO_LITERAL,
			PLANT_LITERAL,
			PENSTOCK_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Penstock Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Penstock Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PenstockType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PenstockType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Penstock Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PenstockType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PenstockType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Penstock Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PenstockType get(int value) {
		switch (value) {
			case TYPE: return TYPE_LITERAL;
			case OF: return OF_LITERAL;
			case HYDRO: return HYDRO_LITERAL;
			case PLANT: return PLANT_LITERAL;
			case PENSTOCK: return PENSTOCK_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PenstockType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PenstockType
