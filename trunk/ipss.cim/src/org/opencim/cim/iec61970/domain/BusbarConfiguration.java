/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusbarConfiguration.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Busbar Configuration</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Busbar layout for Bay.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getBusbarConfiguration()
 * @model
 * @generated
 */
public final class BusbarConfiguration extends AbstractEnumerator {
	/**
	 * The '<em><b>Single Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Single Bus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_BUS_LITERAL
	 * @model name="singleBus"
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_BUS = 0;

	/**
	 * The '<em><b>Double Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Double Bus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_BUS_LITERAL
	 * @model name="doubleBus"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_BUS = 1;

	/**
	 * The '<em><b>Main With Transfer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Main With Transfer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAIN_WITH_TRANSFER_LITERAL
	 * @model name="mainWithTransfer"
	 * @generated
	 * @ordered
	 */
	public static final int MAIN_WITH_TRANSFER = 2;

	/**
	 * The '<em><b>Ring Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ring Bus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RING_BUS_LITERAL
	 * @model name="ringBus"
	 * @generated
	 * @ordered
	 */
	public static final int RING_BUS = 3;

	/**
	 * The '<em><b>Single Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_BUS
	 * @generated
	 * @ordered
	 */
	public static final BusbarConfiguration SINGLE_BUS_LITERAL = new BusbarConfiguration(SINGLE_BUS, "singleBus", "singleBus");

	/**
	 * The '<em><b>Double Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_BUS
	 * @generated
	 * @ordered
	 */
	public static final BusbarConfiguration DOUBLE_BUS_LITERAL = new BusbarConfiguration(DOUBLE_BUS, "doubleBus", "doubleBus");

	/**
	 * The '<em><b>Main With Transfer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAIN_WITH_TRANSFER
	 * @generated
	 * @ordered
	 */
	public static final BusbarConfiguration MAIN_WITH_TRANSFER_LITERAL = new BusbarConfiguration(MAIN_WITH_TRANSFER, "mainWithTransfer", "mainWithTransfer");

	/**
	 * The '<em><b>Ring Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RING_BUS
	 * @generated
	 * @ordered
	 */
	public static final BusbarConfiguration RING_BUS_LITERAL = new BusbarConfiguration(RING_BUS, "ringBus", "ringBus");

	/**
	 * An array of all the '<em><b>Busbar Configuration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BusbarConfiguration[] VALUES_ARRAY =
		new BusbarConfiguration[] {
			SINGLE_BUS_LITERAL,
			DOUBLE_BUS_LITERAL,
			MAIN_WITH_TRANSFER_LITERAL,
			RING_BUS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Busbar Configuration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Busbar Configuration</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BusbarConfiguration get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BusbarConfiguration result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Busbar Configuration</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BusbarConfiguration getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BusbarConfiguration result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Busbar Configuration</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BusbarConfiguration get(int value) {
		switch (value) {
			case SINGLE_BUS: return SINGLE_BUS_LITERAL;
			case DOUBLE_BUS: return DOUBLE_BUS_LITERAL;
			case MAIN_WITH_TRANSFER: return MAIN_WITH_TRANSFER_LITERAL;
			case RING_BUS: return RING_BUS_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BusbarConfiguration(int value, String name, String literal) {
		super(value, name, literal);
	}

} //BusbarConfiguration
