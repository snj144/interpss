/**
 * <copyright>
 * </copyright>
 *
 * $Id: DCLineSegment.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.datatype.real.Inductance;
import org.opencim.datatype.real.Resistance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DC Line Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wire or combination of wires not insulated from one another, with consistent electrical characteristics, used to carry direct current between points in the DC region of the power system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentInductance <em>Dc Segment Inductance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentResistance <em>Dc Segment Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.DCLineSegment#getLine <em>Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getDCLineSegment()
 * @model
 * @generated
 */
public interface DCLineSegment extends Conductor {
	/**
	 * Returns the value of the '<em><b>Dc Segment Inductance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Inductance of the DC line segment, in millihenries
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dc Segment Inductance</em>' attribute.
	 * @see #setDcSegmentInductance(Inductance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getDCLineSegment_DcSegmentInductance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Inductance"
	 * @generated
	 */
	Inductance getDcSegmentInductance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentInductance <em>Dc Segment Inductance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dc Segment Inductance</em>' attribute.
	 * @see #getDcSegmentInductance()
	 * @generated
	 */
	void setDcSegmentInductance(Inductance value);

	/**
	 * Returns the value of the '<em><b>Dc Segment Resistance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resistance of the DC line segment, in ohms
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dc Segment Resistance</em>' attribute.
	 * @see #setDcSegmentResistance(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getDCLineSegment_DcSegmentResistance()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getDcSegmentResistance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getDcSegmentResistance <em>Dc Segment Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dc Segment Resistance</em>' attribute.
	 * @see #getDcSegmentResistance()
	 * @generated
	 */
	void setDcSegmentResistance(Resistance value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.Line#getDCLineSegments <em>DC Line Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A line may be made up of DC line segments
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line</em>' container reference.
	 * @see #setLine(Line)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getDCLineSegment_Line()
	 * @see org.opencim.cim.iec61970.wire.Line#getDCLineSegments
	 * @model opposite="DCLineSegments" required="true"
	 * @generated
	 */
	Line getLine();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.DCLineSegment#getLine <em>Line</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' container reference.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(Line value);

} // DCLineSegment