/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmissionType.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Emission Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The type of emission
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getEmissionType()
 * @generated
 */
public final class EmissionType extends AbstractEnumerator {
	/**
	 * The '<em><b>Sulfur Dioxide</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sulfur Dioxide</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SULFUR_DIOXIDE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int SULFUR_DIOXIDE = 0;

	/**
	 * The '<em><b>Carbon Dioxide</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Carbon Dioxide</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CARBON_DIOXIDE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CARBON_DIOXIDE = 1;

	/**
	 * The '<em><b>Nitrogen Oxide</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nitrogen Oxide</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NITROGEN_OXIDE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int NITROGEN_OXIDE = 2;

	/**
	 * The '<em><b>Hydrogen Sulfide</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hydrogen Sulfide</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYDROGEN_SULFIDE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int HYDROGEN_SULFIDE = 3;

	/**
	 * The '<em><b>Chlorine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Chlorine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHLORINE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CHLORINE = 4;

	/**
	 * The '<em><b>Carbon Disulfide</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Carbon Disulfide</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CARBON_DISULFIDE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CARBON_DISULFIDE = 5;

	/**
	 * The '<em><b>Sulfur Dioxide</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SULFUR_DIOXIDE
	 * @generated
	 * @ordered
	 */
	public static final EmissionType SULFUR_DIOXIDE_LITERAL = new EmissionType(SULFUR_DIOXIDE, "sulfurDioxide", "sulfurDioxide");

	/**
	 * The '<em><b>Carbon Dioxide</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARBON_DIOXIDE
	 * @generated
	 * @ordered
	 */
	public static final EmissionType CARBON_DIOXIDE_LITERAL = new EmissionType(CARBON_DIOXIDE, "carbonDioxide", "carbonDioxide");

	/**
	 * The '<em><b>Nitrogen Oxide</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NITROGEN_OXIDE
	 * @generated
	 * @ordered
	 */
	public static final EmissionType NITROGEN_OXIDE_LITERAL = new EmissionType(NITROGEN_OXIDE, "nitrogenOxide", "nitrogenOxide");

	/**
	 * The '<em><b>Hydrogen Sulfide</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDROGEN_SULFIDE
	 * @generated
	 * @ordered
	 */
	public static final EmissionType HYDROGEN_SULFIDE_LITERAL = new EmissionType(HYDROGEN_SULFIDE, "hydrogenSulfide", "hydrogenSulfide");

	/**
	 * The '<em><b>Chlorine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHLORINE
	 * @generated
	 * @ordered
	 */
	public static final EmissionType CHLORINE_LITERAL = new EmissionType(CHLORINE, "chlorine", "chlorine");

	/**
	 * The '<em><b>Carbon Disulfide</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARBON_DISULFIDE
	 * @generated
	 * @ordered
	 */
	public static final EmissionType CARBON_DISULFIDE_LITERAL = new EmissionType(CARBON_DISULFIDE, "carbonDisulfide", "carbonDisulfide");

	/**
	 * An array of all the '<em><b>Emission Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EmissionType[] VALUES_ARRAY =
		new EmissionType[] {
			SULFUR_DIOXIDE_LITERAL,
			CARBON_DIOXIDE_LITERAL,
			NITROGEN_OXIDE_LITERAL,
			HYDROGEN_SULFIDE_LITERAL,
			CHLORINE_LITERAL,
			CARBON_DISULFIDE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Emission Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Emission Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmissionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmissionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Emission Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmissionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmissionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Emission Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmissionType get(int value) {
		switch (value) {
			case SULFUR_DIOXIDE: return SULFUR_DIOXIDE_LITERAL;
			case CARBON_DIOXIDE: return CARBON_DIOXIDE_LITERAL;
			case NITROGEN_OXIDE: return NITROGEN_OXIDE_LITERAL;
			case HYDROGEN_SULFIDE: return HYDROGEN_SULFIDE_LITERAL;
			case CHLORINE: return CHLORINE_LITERAL;
			case CARBON_DISULFIDE: return CARBON_DISULFIDE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EmissionType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //EmissionType
