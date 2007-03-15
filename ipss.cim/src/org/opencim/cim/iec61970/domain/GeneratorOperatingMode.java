/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratorOperatingMode.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Generator Operating Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Operating mode for secondary generator control, e.g.: Unavailable, Manual, Fixed, Load Frequency Control, AGC, EDC, RPN, MRN, or REG
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getGeneratorOperatingMode()
 * @generated
 */
public final class GeneratorOperatingMode extends AbstractEnumerator {
	/**
	 * The '<em><b>Off</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Off</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OFF_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int OFF = 0;

	/**
	 * The '<em><b>Manual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Manual</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANUAL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int MANUAL = 1;

	/**
	 * The '<em><b>Fixed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fixed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXED_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int FIXED = 2;

	/**
	 * The '<em><b>LFC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LFC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LFC_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int LFC = 3;

	/**
	 * The '<em><b>AGC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AGC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGC_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int AGC = 4;

	/**
	 * The '<em><b>EDC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EDC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EDC_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int EDC = 5;

	/**
	 * The '<em><b>MRN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MRN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MRN_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int MRN = 6;

	/**
	 * The '<em><b>REG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REG_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int REG = 7;

	/**
	 * The '<em><b>Off</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFF
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode OFF_LITERAL = new GeneratorOperatingMode(OFF, "Off", "Off");

	/**
	 * The '<em><b>Manual</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUAL
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode MANUAL_LITERAL = new GeneratorOperatingMode(MANUAL, "Manual", "Manual");

	/**
	 * The '<em><b>Fixed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXED
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode FIXED_LITERAL = new GeneratorOperatingMode(FIXED, "Fixed", "Fixed");

	/**
	 * The '<em><b>LFC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LFC
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode LFC_LITERAL = new GeneratorOperatingMode(LFC, "LFC", "LFC");

	/**
	 * The '<em><b>AGC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGC
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode AGC_LITERAL = new GeneratorOperatingMode(AGC, "AGC", "AGC");

	/**
	 * The '<em><b>EDC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EDC
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode EDC_LITERAL = new GeneratorOperatingMode(EDC, "EDC", "EDC");

	/**
	 * The '<em><b>MRN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MRN
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode MRN_LITERAL = new GeneratorOperatingMode(MRN, "MRN", "MRN");

	/**
	 * The '<em><b>REG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REG
	 * @generated
	 * @ordered
	 */
	public static final GeneratorOperatingMode REG_LITERAL = new GeneratorOperatingMode(REG, "REG", "REG");

	/**
	 * An array of all the '<em><b>Generator Operating Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GeneratorOperatingMode[] VALUES_ARRAY =
		new GeneratorOperatingMode[] {
			OFF_LITERAL,
			MANUAL_LITERAL,
			FIXED_LITERAL,
			LFC_LITERAL,
			AGC_LITERAL,
			EDC_LITERAL,
			MRN_LITERAL,
			REG_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Generator Operating Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Generator Operating Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorOperatingMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratorOperatingMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generator Operating Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorOperatingMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratorOperatingMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generator Operating Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorOperatingMode get(int value) {
		switch (value) {
			case OFF: return OFF_LITERAL;
			case MANUAL: return MANUAL_LITERAL;
			case FIXED: return FIXED_LITERAL;
			case LFC: return LFC_LITERAL;
			case AGC: return AGC_LITERAL;
			case EDC: return EDC_LITERAL;
			case MRN: return MRN_LITERAL;
			case REG: return REG_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GeneratorOperatingMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //GeneratorOperatingMode
