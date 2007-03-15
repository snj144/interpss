/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransformerControlMode.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transformer Control Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Control modes for a transformer, i.e., Off, Local, Volt, MVAr
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getTransformerControlMode()
 * @generated
 */
public final class TransformerControlMode extends AbstractEnumerator {
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
	 * The '<em><b>Local</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL = 1;

	/**
	 * The '<em><b>Volt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Volt</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLT_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int VOLT = 2;

	/**
	 * The '<em><b>MW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MW_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int MW = 3;

	/**
	 * The '<em><b>MV Ar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MV Ar</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MV_AR_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int MV_AR = 4;

	/**
	 * The '<em><b>Off</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFF
	 * @generated
	 * @ordered
	 */
	public static final TransformerControlMode OFF_LITERAL = new TransformerControlMode(OFF, "off", "off");

	/**
	 * The '<em><b>Local</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL
	 * @generated
	 * @ordered
	 */
	public static final TransformerControlMode LOCAL_LITERAL = new TransformerControlMode(LOCAL, "local", "local");

	/**
	 * The '<em><b>Volt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLT
	 * @generated
	 * @ordered
	 */
	public static final TransformerControlMode VOLT_LITERAL = new TransformerControlMode(VOLT, "volt", "volt");

	/**
	 * The '<em><b>MW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MW
	 * @generated
	 * @ordered
	 */
	public static final TransformerControlMode MW_LITERAL = new TransformerControlMode(MW, "MW", "MW");

	/**
	 * The '<em><b>MV Ar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MV_AR
	 * @generated
	 * @ordered
	 */
	public static final TransformerControlMode MV_AR_LITERAL = new TransformerControlMode(MV_AR, "mVAr", "mVAr");

	/**
	 * An array of all the '<em><b>Transformer Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransformerControlMode[] VALUES_ARRAY =
		new TransformerControlMode[] {
			OFF_LITERAL,
			LOCAL_LITERAL,
			VOLT_LITERAL,
			MW_LITERAL,
			MV_AR_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Transformer Control Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transformer Control Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerControlMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformerControlMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transformer Control Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerControlMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformerControlMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transformer Control Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformerControlMode get(int value) {
		switch (value) {
			case OFF: return OFF_LITERAL;
			case LOCAL: return LOCAL_LITERAL;
			case VOLT: return VOLT_LITERAL;
			case MW: return MW_LITERAL;
			case MV_AR: return MV_AR_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransformerControlMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TransformerControlMode
