/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveSchedFormula.java,v 1.2 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Curve Sched Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mathematical formula for defining a curve or schedule segment
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getXLowerBound <em>XLower Bound</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getXUpperBound <em>XUpper Bound</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getYFunction <em>YFunction</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getCurveSchedule <em>Curve Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedFormula()
 * @generated
 */
public interface CurveSchedFormula extends Naming {
	/**
	 * Returns the value of the '<em><b>XLower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum value of the X-variable for the range of the function
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XLower Bound</em>' attribute.
	 * @see #setXLowerBound(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedFormula_XLowerBound()
	 * @generated
	 */
	Object getXLowerBound();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getXLowerBound <em>XLower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XLower Bound</em>' attribute.
	 * @see #getXLowerBound()
	 * @generated
	 */
	void setXLowerBound(Object value);

	/**
	 * Returns the value of the '<em><b>XUpper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum value of the X-variable for the range of the function
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XUpper Bound</em>' attribute.
	 * @see #setXUpperBound(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedFormula_XUpperBound()
	 * @generated
	 */
	Object getXUpperBound();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getXUpperBound <em>XUpper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XUpper Bound</em>' attribute.
	 * @see #getXUpperBound()
	 * @generated
	 */
	void setXUpperBound(Object value);

	/**
	 * Returns the value of the '<em><b>YFunction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mathematical formula for the  Y-axis variable with numerical constants
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>YFunction</em>' attribute.
	 * @see #setYFunction(String)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedFormula_YFunction()
	 * @generated
	 */
	String getYFunction();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getYFunction <em>YFunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YFunction</em>' attribute.
	 * @see #getYFunction()
	 * @generated
	 */
	void setYFunction(String value);

	/**
	 * Returns the value of the '<em><b>Curve Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleFormula <em>Curve Schedule Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formula for a curve segment
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Curve Schedule</em>' container reference.
	 * @see #setCurveSchedule(CurveSchedule)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedFormula_CurveSchedule()
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleFormula
	 * @generated
	 */
	CurveSchedule getCurveSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedFormula#getCurveSchedule <em>Curve Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Schedule</em>' container reference.
	 * @see #getCurveSchedule()
	 * @generated
	 */
	void setCurveSchedule(CurveSchedule value);

} // CurveSchedFormula