/**
 * <copyright>
 * </copyright>
 *
 * $Id: RemoteUnitType.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Remote Unit Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getRemoteUnitType()
 * @generated
 */
public final class RemoteUnitType extends AbstractEnumerator {
	/**
	 * The '<em><b>RTU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RTU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RTU_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int RTU = 0;

	/**
	 * The '<em><b>Substation Control System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Substation Control System</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBSTATION_CONTROL_SYSTEM_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTATION_CONTROL_SYSTEM = 1;

	/**
	 * The '<em><b>Control Center</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Control Center</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROL_CENTER_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CONTROL_CENTER = 2;

	/**
	 * The '<em><b>IED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IED_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int IED = 3;

	/**
	 * The '<em><b>RTU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RTU
	 * @generated
	 * @ordered
	 */
	public static final RemoteUnitType RTU_LITERAL = new RemoteUnitType(RTU, "RTU", "RTU");

	/**
	 * The '<em><b>Substation Control System</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTATION_CONTROL_SYSTEM
	 * @generated
	 * @ordered
	 */
	public static final RemoteUnitType SUBSTATION_CONTROL_SYSTEM_LITERAL = new RemoteUnitType(SUBSTATION_CONTROL_SYSTEM, "SubstationControlSystem", "SubstationControlSystem");

	/**
	 * The '<em><b>Control Center</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL_CENTER
	 * @generated
	 * @ordered
	 */
	public static final RemoteUnitType CONTROL_CENTER_LITERAL = new RemoteUnitType(CONTROL_CENTER, "ControlCenter", "ControlCenter");

	/**
	 * The '<em><b>IED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IED
	 * @generated
	 * @ordered
	 */
	public static final RemoteUnitType IED_LITERAL = new RemoteUnitType(IED, "IED", "IED");

	/**
	 * An array of all the '<em><b>Remote Unit Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RemoteUnitType[] VALUES_ARRAY =
		new RemoteUnitType[] {
			RTU_LITERAL,
			SUBSTATION_CONTROL_SYSTEM_LITERAL,
			CONTROL_CENTER_LITERAL,
			IED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Remote Unit Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Remote Unit Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RemoteUnitType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RemoteUnitType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Remote Unit Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RemoteUnitType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RemoteUnitType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Remote Unit Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RemoteUnitType get(int value) {
		switch (value) {
			case RTU: return RTU_LITERAL;
			case SUBSTATION_CONTROL_SYSTEM: return SUBSTATION_CONTROL_SYSTEM_LITERAL;
			case CONTROL_CENTER: return CONTROL_CENTER_LITERAL;
			case IED: return IED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RemoteUnitType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RemoteUnitType
