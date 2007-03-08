/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroPlantType.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Hydro Plant Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The type of hydro power plant, e.g.: Run-of-River, Pumped Storage, Major Storage, Minor Storage.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getHydroPlantType()
 * @model
 * @generated
 */
public final class HydroPlantType extends AbstractEnumerator {
	/**
	 * The '<em><b>Run Of River</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Run Of River</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUN_OF_RIVER_LITERAL
	 * @model name="runOfRiver"
	 * @generated
	 * @ordered
	 */
	public static final int RUN_OF_RIVER = 0;

	/**
	 * The '<em><b>Pumped Storage</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pumped Storage</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUMPED_STORAGE_LITERAL
	 * @model name="pumpedStorage"
	 * @generated
	 * @ordered
	 */
	public static final int PUMPED_STORAGE = 1;

	/**
	 * The '<em><b>Major Storage</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Major Storage</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAJOR_STORAGE_LITERAL
	 * @model name="majorStorage"
	 * @generated
	 * @ordered
	 */
	public static final int MAJOR_STORAGE = 2;

	/**
	 * The '<em><b>Minor Storage</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Minor Storage</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINOR_STORAGE_LITERAL
	 * @model name="minorStorage"
	 * @generated
	 * @ordered
	 */
	public static final int MINOR_STORAGE = 3;

	/**
	 * The '<em><b>Run Of River</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUN_OF_RIVER
	 * @generated
	 * @ordered
	 */
	public static final HydroPlantType RUN_OF_RIVER_LITERAL = new HydroPlantType(RUN_OF_RIVER, "runOfRiver", "runOfRiver");

	/**
	 * The '<em><b>Pumped Storage</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUMPED_STORAGE
	 * @generated
	 * @ordered
	 */
	public static final HydroPlantType PUMPED_STORAGE_LITERAL = new HydroPlantType(PUMPED_STORAGE, "pumpedStorage", "pumpedStorage");

	/**
	 * The '<em><b>Major Storage</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAJOR_STORAGE
	 * @generated
	 * @ordered
	 */
	public static final HydroPlantType MAJOR_STORAGE_LITERAL = new HydroPlantType(MAJOR_STORAGE, "majorStorage", "majorStorage");

	/**
	 * The '<em><b>Minor Storage</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINOR_STORAGE
	 * @generated
	 * @ordered
	 */
	public static final HydroPlantType MINOR_STORAGE_LITERAL = new HydroPlantType(MINOR_STORAGE, "minorStorage", "minorStorage");

	/**
	 * An array of all the '<em><b>Hydro Plant Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HydroPlantType[] VALUES_ARRAY =
		new HydroPlantType[] {
			RUN_OF_RIVER_LITERAL,
			PUMPED_STORAGE_LITERAL,
			MAJOR_STORAGE_LITERAL,
			MINOR_STORAGE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Hydro Plant Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Hydro Plant Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HydroPlantType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HydroPlantType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hydro Plant Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HydroPlantType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HydroPlantType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hydro Plant Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HydroPlantType get(int value) {
		switch (value) {
			case RUN_OF_RIVER: return RUN_OF_RIVER_LITERAL;
			case PUMPED_STORAGE: return PUMPED_STORAGE_LITERAL;
			case MAJOR_STORAGE: return MAJOR_STORAGE_LITERAL;
			case MINOR_STORAGE: return MINOR_STORAGE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private HydroPlantType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //HydroPlantType
