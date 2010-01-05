/**
 * <copyright>
 * </copyright>
 *
 * $Id: ACLineSegment.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AC Line Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wire or combination of wires, with consistent electrical characteristics, building a single electrical system, used to carry alternating current between points in the power system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.ACLineSegment#getLine <em>Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getACLineSegment()
 * @generated
 */
public interface ACLineSegment extends Conductor {
	/**
	 * Returns the value of the '<em><b>Line</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.Line#getACLineSegments <em>AC Line Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A line may be made up of AC line segments
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line</em>' container reference.
	 * @see #setLine(Line)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getACLineSegment_Line()
	 * @see org.opencim.cim.iec61970.wire.Line#getACLineSegments
	 * @generated
	 */
	Line getLine();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.ACLineSegment#getLine <em>Line</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' container reference.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(Line value);

} // ACLineSegment