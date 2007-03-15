/**
 * <copyright>
 * </copyright>
 *
 * $Id: ControlHouseEquipmentType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Control House Equipment Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of control house equipment.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getControlHouseEquipmentType()
 * @generated
 */
public final class ControlHouseEquipmentType extends AbstractEnumerator {
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
	 * The '<em><b>Control</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Control</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CONTROL = 2;

	/**
	 * The '<em><b>House</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>House</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOUSE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int HOUSE = 3;

	/**
	 * The '<em><b>Equipment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Equipment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUIPMENT_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int EQUIPMENT = 4;

	/**
	 * The '<em><b>Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE
	 * @generated
	 * @ordered
	 */
	public static final ControlHouseEquipmentType TYPE_LITERAL = new ControlHouseEquipmentType(TYPE, "Type", "Type");

	/**
	 * The '<em><b>Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OF
	 * @generated
	 * @ordered
	 */
	public static final ControlHouseEquipmentType OF_LITERAL = new ControlHouseEquipmentType(OF, "of", "of");

	/**
	 * The '<em><b>Control</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL
	 * @generated
	 * @ordered
	 */
	public static final ControlHouseEquipmentType CONTROL_LITERAL = new ControlHouseEquipmentType(CONTROL, "control", "control");

	/**
	 * The '<em><b>House</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOUSE
	 * @generated
	 * @ordered
	 */
	public static final ControlHouseEquipmentType HOUSE_LITERAL = new ControlHouseEquipmentType(HOUSE, "house", "house");

	/**
	 * The '<em><b>Equipment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUIPMENT
	 * @generated
	 * @ordered
	 */
	public static final ControlHouseEquipmentType EQUIPMENT_LITERAL = new ControlHouseEquipmentType(EQUIPMENT, "equipment", "equipment");

	/**
	 * An array of all the '<em><b>Control House Equipment Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ControlHouseEquipmentType[] VALUES_ARRAY =
		new ControlHouseEquipmentType[] {
			TYPE_LITERAL,
			OF_LITERAL,
			CONTROL_LITERAL,
			HOUSE_LITERAL,
			EQUIPMENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Control House Equipment Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Control House Equipment Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ControlHouseEquipmentType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ControlHouseEquipmentType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Control House Equipment Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ControlHouseEquipmentType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ControlHouseEquipmentType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Control House Equipment Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ControlHouseEquipmentType get(int value) {
		switch (value) {
			case TYPE: return TYPE_LITERAL;
			case OF: return OF_LITERAL;
			case CONTROL: return CONTROL_LITERAL;
			case HOUSE: return HOUSE_LITERAL;
			case EQUIPMENT: return EQUIPMENT_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ControlHouseEquipmentType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ControlHouseEquipmentType
