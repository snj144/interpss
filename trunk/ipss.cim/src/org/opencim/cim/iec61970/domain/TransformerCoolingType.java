/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransformerCoolingType.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transformer Cooling Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of transformer cooling.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getTransformerCoolingType()
 * @model
 * @generated
 */
public final class TransformerCoolingType extends AbstractEnumerator {
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
	 * The '<em><b>Transformer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Transformer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSFORMER_LITERAL
	 * @model name="transformer"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFORMER = 2;

	/**
	 * The '<em><b>Cooling</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cooling</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COOLING_LITERAL
	 * @model name="cooling"
	 * @generated
	 * @ordered
	 */
	public static final int COOLING = 3;

	/**
	 * The '<em><b>Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE
	 * @generated
	 * @ordered
	 */
	public static final TransformerCoolingType TYPE_LITERAL = new TransformerCoolingType(TYPE, "Type", "Type");

	/**
	 * The '<em><b>Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OF
	 * @generated
	 * @ordered
	 */
	public static final TransformerCoolingType OF_LITERAL = new TransformerCoolingType(OF, "of", "of");

	/**
	 * The '<em><b>Transformer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFORMER
	 * @generated
	 * @ordered
	 */
	public static final TransformerCoolingType TRANSFORMER_LITERAL = new TransformerCoolingType(TRANSFORMER, "transformer", "transformer");

	/**
	 * The '<em><b>Cooling</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COOLING
	 * @generated
	 * @ordered
	 */
	public static final TransformerCoolingType COOLING_LITERAL = new TransformerCoolingType(COOLING, "cooling", "cooling");

	/**
	 * An array of all the '<em><b>Transformer Cooling Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransformerCoolingType[] VALUES_ARRAY =
		new TransformerCoolingType[] {
			TYPE_LITERAL,
			OF_LITERAL,
			TRANSFORMER_LITERAL,
			COOLING_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Transformer Cooling Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transformer Cooling Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerCoolingType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformerCoolingType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transformer Cooling Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerCoolingType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformerCoolingType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transformer Cooling Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerCoolingType get(int value) {
		switch (value) {
			case TYPE: return TYPE_LITERAL;
			case OF: return OF_LITERAL;
			case TRANSFORMER: return TRANSFORMER_LITERAL;
			case COOLING: return COOLING_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransformerCoolingType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TransformerCoolingType
