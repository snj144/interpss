/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveSchedule.java,v 1.2 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.domain.AxisQuantity;
import org.opencim.cim.iec61970.domain.CurveStyle;
import org.opencim.cim.iec61970.domain.NumericType;
import org.opencim.cim.iec61970.domain.RampMethod;
import org.opencim.cim.iec61970.domain.RampStartMethod;
import org.opencim.cim.iec61970.domain.RampUnits;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Curve Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between an independent variable (X-axis) and one or two dependent variables (Y1-axis and Y2-axis). Curves can also serve as schedules.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveStyle <em>Curve Style</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampMethod <em>Ramp Method</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampStartMethod <em>Ramp Start Method</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampUnits <em>Ramp Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getXAxisType <em>XAxis Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getXAxisQuantity <em>XAxis Quantity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getY1AxisQuantity <em>Y1 Axis Quantity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getY2AxisQuantity <em>Y2 Axis Quantity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getYAxisType <em>YAxis Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleDatas <em>Curve Schedule Datas</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleFormula <em>Curve Schedule Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule()
 * @generated
 */
public interface CurveSchedule extends Naming {
	/**
	 * Returns the value of the '<em><b>Curve Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.CurveStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The style or shape of the curve.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Curve Style</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CurveStyle
	 * @see #setCurveStyle(CurveStyle)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_CurveStyle()
	 * @generated
	 */
	CurveStyle getCurveStyle();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveStyle <em>Curve Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Style</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CurveStyle
	 * @see #getCurveStyle()
	 * @generated
	 */
	void setCurveStyle(CurveStyle value);

	/**
	 * Returns the value of the '<em><b>Ramp Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.RampMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The deltaY versus deltaX units of measure.  Applies to all ramps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ramp Method</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.RampMethod
	 * @see #setRampMethod(RampMethod)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_RampMethod()
	 * @generated
	 */
	RampMethod getRampMethod();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampMethod <em>Ramp Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ramp Method</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.RampMethod
	 * @see #getRampMethod()
	 * @generated
	 */
	void setRampMethod(RampMethod value);

	/**
	 * Returns the value of the '<em><b>Ramp Start Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.RampStartMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The method of applying the ramp: 0 at start point,  50% at start point, 100% at start point. For methods 2 and 3, the ramp begins ahead of the start point on the X-axis. NOTE: For storage, all ramps are to be normalized to Method "1" (0 at start point).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ramp Start Method</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.RampStartMethod
	 * @see #setRampStartMethod(RampStartMethod)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_RampStartMethod()
	 * @generated
	 */
	RampStartMethod getRampStartMethod();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampStartMethod <em>Ramp Start Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ramp Start Method</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.RampStartMethod
	 * @see #getRampStartMethod()
	 * @generated
	 */
	void setRampStartMethod(RampStartMethod value);

	/**
	 * Returns the value of the '<em><b>Ramp Units</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.RampUnits}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The deltaY versus deltaX units of measure.  Same for "two" Y values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ramp Units</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.RampUnits
	 * @see #setRampUnits(RampUnits)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_RampUnits()
	 * @generated
	 */
	RampUnits getRampUnits();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getRampUnits <em>Ramp Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ramp Units</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.RampUnits
	 * @see #getRampUnits()
	 * @generated
	 */
	void setRampUnits(RampUnits value);

	/**
	 * Returns the value of the '<em><b>XAxis Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.NumericType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of independent variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XAxis Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.NumericType
	 * @see #setXAxisType(NumericType)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_XAxisType()
	 * @generated
	 */
	NumericType getXAxisType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getXAxisType <em>XAxis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.NumericType
	 * @see #getXAxisType()
	 * @generated
	 */
	void setXAxisType(NumericType value);

	/**
	 * Returns the value of the '<em><b>XAxis Quantity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.AxisQuantity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis Quantity</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see #setXAxisQuantity(AxisQuantity)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_XAxisQuantity()
	 * @generated
	 */
	AxisQuantity getXAxisQuantity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getXAxisQuantity <em>XAxis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Quantity</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see #getXAxisQuantity()
	 * @generated
	 */
	void setXAxisQuantity(AxisQuantity value);

	/**
	 * Returns the value of the '<em><b>Y1 Axis Quantity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.AxisQuantity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Y1-axis units of measure.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y1 Axis Quantity</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see #setY1AxisQuantity(AxisQuantity)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_Y1AxisQuantity()
	 * @generated
	 */
	AxisQuantity getY1AxisQuantity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getY1AxisQuantity <em>Y1 Axis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y1 Axis Quantity</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see #getY1AxisQuantity()
	 * @generated
	 */
	void setY1AxisQuantity(AxisQuantity value);

	/**
	 * Returns the value of the '<em><b>Y2 Axis Quantity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.AxisQuantity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Y2-axis units of measure.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y2 Axis Quantity</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see #setY2AxisQuantity(AxisQuantity)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_Y2AxisQuantity()
	 * @generated
	 */
	AxisQuantity getY2AxisQuantity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getY2AxisQuantity <em>Y2 Axis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y2 Axis Quantity</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.AxisQuantity
	 * @see #getY2AxisQuantity()
	 * @generated
	 */
	void setY2AxisQuantity(AxisQuantity value);

	/**
	 * Returns the value of the '<em><b>YAxis Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.NumericType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of dependent variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>YAxis Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.NumericType
	 * @see #setYAxisType(NumericType)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_YAxisType()
	 * @generated
	 */
	NumericType getYAxisType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedule#getYAxisType <em>YAxis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YAxis Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.NumericType
	 * @see #getYAxisType()
	 * @generated
	 */
	void setYAxisType(NumericType value);

	/**
	 * Returns the value of the '<em><b>Curve Schedule Datas</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.CurveSchedData}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.CurveSchedData#getCurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The point data values that define a curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Curve Schedule Datas</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_CurveScheduleDatas()
	 * @see org.opencim.cim.iec61970.core.CurveSchedData#getCurveSchedule
	 * @generated
	 */
	EList getCurveScheduleDatas();

	/**
	 * Returns the value of the '<em><b>Curve Schedule Formula</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.CurveSchedFormula}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getCurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formula for a curve segment
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Curve Schedule Formula</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedule_CurveScheduleFormula()
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula#getCurveSchedule
	 * @generated
	 */
	EList getCurveScheduleFormula();

} // CurveSchedule