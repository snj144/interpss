/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveStyle.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Curve Style</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Style or shape of curve.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getCurveStyle()
 * @generated
 */
public final class CurveStyle extends AbstractEnumerator {
	/**
	 * The '<em><b>Constant YValue</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Constant YValue</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_YVALUE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_YVALUE = 0;

	/**
	 * The '<em><b>Straight Line YValues</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Straight Line YValues</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_LINE_YVALUES_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int STRAIGHT_LINE_YVALUES = 1;

	/**
	 * The '<em><b>Ramp YValue</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ramp YValue</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAMP_YVALUE_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int RAMP_YVALUE = 2;

	/**
	 * The '<em><b>Formula</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Formula</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORMULA_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int FORMULA = 3;

	/**
	 * The '<em><b>Constant YValue</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_YVALUE
	 * @generated
	 * @ordered
	 */
	public static final CurveStyle CONSTANT_YVALUE_LITERAL = new CurveStyle(CONSTANT_YVALUE, "constantYValue", "constantYValue");

	/**
	 * The '<em><b>Straight Line YValues</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_LINE_YVALUES
	 * @generated
	 * @ordered
	 */
	public static final CurveStyle STRAIGHT_LINE_YVALUES_LITERAL = new CurveStyle(STRAIGHT_LINE_YVALUES, "straightLineYValues", "straightLineYValues");

	/**
	 * The '<em><b>Ramp YValue</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAMP_YVALUE
	 * @generated
	 * @ordered
	 */
	public static final CurveStyle RAMP_YVALUE_LITERAL = new CurveStyle(RAMP_YVALUE, "rampYValue", "rampYValue");

	/**
	 * The '<em><b>Formula</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORMULA
	 * @generated
	 * @ordered
	 */
	public static final CurveStyle FORMULA_LITERAL = new CurveStyle(FORMULA, "formula", "formula");

	/**
	 * An array of all the '<em><b>Curve Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CurveStyle[] VALUES_ARRAY =
		new CurveStyle[] {
			CONSTANT_YVALUE_LITERAL,
			STRAIGHT_LINE_YVALUES_LITERAL,
			RAMP_YVALUE_LITERAL,
			FORMULA_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Curve Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Curve Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CurveStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CurveStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Curve Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CurveStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CurveStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Curve Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CurveStyle get(int value) {
		switch (value) {
			case CONSTANT_YVALUE: return CONSTANT_YVALUE_LITERAL;
			case STRAIGHT_LINE_YVALUES: return STRAIGHT_LINE_YVALUES_LITERAL;
			case RAMP_YVALUE: return RAMP_YVALUE_LITERAL;
			case FORMULA: return FORMULA_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CurveStyle(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CurveStyle
