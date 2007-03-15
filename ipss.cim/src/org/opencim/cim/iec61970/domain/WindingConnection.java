/**
 * <copyright>
 * </copyright>
 *
 * $Id: WindingConnection.java,v 1.1 2007/03/02 14:00:59 mzhou Exp $
 */
package org.opencim.cim.iec61970.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Winding Connection</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * D | Y | Z for Delta | Wye | ZigZag winding connections
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.domain.DomainPackage#getWindingConnection()
 * @generated
 */
public final class WindingConnection extends AbstractEnumerator {
	/**
	 * The '<em><b>D</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Delta
	 * <!-- end-model-doc -->
	 * @see #D_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int D = 0;

	/**
	 * The '<em><b>Y</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Wye
	 * <!-- end-model-doc -->
	 * @see #Y_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int Y = 1;

	/**
	 * The '<em><b>Z</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ZigZag
	 * <!-- end-model-doc -->
	 * @see #Z_LITERAL
	 * @generated
	 * @ordered
	 */
	public static final int Z = 2;

	/**
	 * The '<em><b>D</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D
	 * @generated
	 * @ordered
	 */
	public static final WindingConnection D_LITERAL = new WindingConnection(D, "D", "D");

	/**
	 * The '<em><b>Y</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Y
	 * @generated
	 * @ordered
	 */
	public static final WindingConnection Y_LITERAL = new WindingConnection(Y, "Y", "Y");

	/**
	 * The '<em><b>Z</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Z
	 * @generated
	 * @ordered
	 */
	public static final WindingConnection Z_LITERAL = new WindingConnection(Z, "Z", "Z");

	/**
	 * An array of all the '<em><b>Winding Connection</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WindingConnection[] VALUES_ARRAY =
		new WindingConnection[] {
			D_LITERAL,
			Y_LITERAL,
			Z_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Winding Connection</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Winding Connection</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WindingConnection get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindingConnection result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Winding Connection</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WindingConnection getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindingConnection result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Winding Connection</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WindingConnection get(int value) {
		switch (value) {
			case D: return D_LITERAL;
			case Y: return Y_LITERAL;
			case Z: return Z_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private WindingConnection(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WindingConnection
