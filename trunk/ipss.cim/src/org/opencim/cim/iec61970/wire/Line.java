/**
 * <copyright>
 * </copyright>
 *
 * $Id: Line.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A component part of a system extending between adjacent substations or from a substation to an adjacent interconnection point.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.Line#getACLineSegments <em>AC Line Segments</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Line#getDCLineSegments <em>DC Line Segments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getLine()
 * @model
 * @generated
 */
public interface Line extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>AC Line Segments</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.ACLineSegment}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.ACLineSegment#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A line may be made up of AC line segments
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>AC Line Segments</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getLine_ACLineSegments()
	 * @see org.opencim.cim.iec61970.wire.ACLineSegment#getLine
	 * @model type="org.opencim.cim.iec61970.wire.ACLineSegment" opposite="Line" containment="true"
	 * @generated
	 */
	EList getACLineSegments();

	/**
	 * Returns the value of the '<em><b>DC Line Segments</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.DCLineSegment}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A line may be made up of DC line segments
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>DC Line Segments</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getLine_DCLineSegments()
	 * @see org.opencim.cim.iec61970.wire.DCLineSegment#getLine
	 * @model type="org.opencim.cim.iec61970.wire.DCLineSegment" opposite="Line" containment="true"
	 * @generated
	 */
	EList getDCLineSegments();

} // Line