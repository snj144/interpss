/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveSchedData.java,v 1.2 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Curve Sched Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Data point values for defining a curve or schedule
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedData#getRampData <em>Ramp Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedData#getRampDataValue <em>Ramp Data Value</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedData#getXAxisData <em>XAxis Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedData#getY1AxisData <em>Y1 Axis Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedData#getY2AxisData <em>Y2 Axis Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.CurveSchedData#getCurveSchedule <em>Curve Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData()
 * @model
 * @generated
 */
public interface CurveSchedData extends Naming {
	/**
	 * Returns the value of the '<em><b>Ramp Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The data value of the rate-of-change of the Y-axis variable with respect to the X-axis variable
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ramp Data</em>' attribute.
	 * @see #setRampData(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData_RampData()
	 * @model dataType="org.opencim.cim.iec61970.domain.Numeric"
	 * @generated
	 */
	Object getRampData();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedData#getRampData <em>Ramp Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ramp Data</em>' attribute.
	 * @see #getRampData()
	 * @generated
	 */
	void setRampData(Object value);

	/**
	 * Returns the value of the '<em><b>Ramp Data Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The data value of the rate-of-change of the Y-axis variable with respect to the X-axis variable ( 0 = instantaneous change)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ramp Data Value</em>' attribute.
	 * @see #setRampDataValue(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData_RampDataValue()
	 * @model dataType="org.opencim.cim.iec61970.domain.Numeric"
	 * @generated
	 */
	Object getRampDataValue();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedData#getRampDataValue <em>Ramp Data Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ramp Data Value</em>' attribute.
	 * @see #getRampDataValue()
	 * @generated
	 */
	void setRampDataValue(Object value);

	/**
	 * Returns the value of the '<em><b>XAxis Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The data value of the X-axis variable,  depending on the X-axis units
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>XAxis Data</em>' attribute.
	 * @see #setXAxisData(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData_XAxisData()
	 * @model dataType="org.opencim.cim.iec61970.domain.Numeric"
	 * @generated
	 */
	Object getXAxisData();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedData#getXAxisData <em>XAxis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Data</em>' attribute.
	 * @see #getXAxisData()
	 * @generated
	 */
	void setXAxisData(Object value);

	/**
	 * Returns the value of the '<em><b>Y1 Axis Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The data value of the  first Y-axis variable, depending on the Y-axis units
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y1 Axis Data</em>' attribute.
	 * @see #setY1AxisData(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData_Y1AxisData()
	 * @model dataType="org.opencim.cim.iec61970.domain.Numeric"
	 * @generated
	 */
	Object getY1AxisData();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedData#getY1AxisData <em>Y1 Axis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y1 Axis Data</em>' attribute.
	 * @see #getY1AxisData()
	 * @generated
	 */
	void setY1AxisData(Object value);

	/**
	 * Returns the value of the '<em><b>Y2 Axis Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The data value of the second Y-axis variable (if present), depending on the Y-axis units
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y2 Axis Data</em>' attribute.
	 * @see #setY2AxisData(Object)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData_Y2AxisData()
	 * @model dataType="org.opencim.cim.iec61970.domain.Numeric"
	 * @generated
	 */
	Object getY2AxisData();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedData#getY2AxisData <em>Y2 Axis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y2 Axis Data</em>' attribute.
	 * @see #getY2AxisData()
	 * @generated
	 */
	void setY2AxisData(Object value);

	/**
	 * Returns the value of the '<em><b>Curve Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleDatas <em>Curve Schedule Datas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The point data values that define a curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Curve Schedule</em>' container reference.
	 * @see #setCurveSchedule(CurveSchedule)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCurveSchedData_CurveSchedule()
	 * @see org.opencim.cim.iec61970.core.CurveSchedule#getCurveScheduleDatas
	 * @model opposite="CurveScheduleDatas" required="true"
	 * @generated
	 */
	CurveSchedule getCurveSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.CurveSchedData#getCurveSchedule <em>Curve Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Schedule</em>' container reference.
	 * @see #getCurveSchedule()
	 * @generated
	 */
	void setCurveSchedule(CurveSchedule value);

} // CurveSchedData