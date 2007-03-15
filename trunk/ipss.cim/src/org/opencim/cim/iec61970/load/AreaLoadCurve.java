/**
 * <copyright>
 * </copyright>
 *
 * $Id: AreaLoadCurve.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area Load Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A curve relating  power versus time. showing the values of a specific load for each unit of the period covered. The  curve can be based on "absolute" time or on "normalized' time. An instance of this curve could represent the absolute area load forecast. An other instance could represent a normalized daily load curve for a particular day type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getLoadArea <em>Load Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getDayType <em>Day Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getSeason <em>Season</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getAreaLoadCurve()
 * @generated
 */
public interface AreaLoadCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Load Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadArea#getAreaLoadCurves <em>Area Load Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A load area can have one or more area load curves
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Area</em>' container reference.
	 * @see #setLoadArea(LoadArea)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getAreaLoadCurve_LoadArea()
	 * @see org.opencim.cim.iec61970.load.LoadArea#getAreaLoadCurves
	 * @generated
	 */
	LoadArea getLoadArea();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getLoadArea <em>Load Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Area</em>' container reference.
	 * @see #getLoadArea()
	 * @generated
	 */
	void setLoadArea(LoadArea value);

	/**
	 * Returns the value of the '<em><b>Day Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.DayType#getAreaLoadCurves <em>Area Load Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A load model may be classified by the day type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Day Type</em>' reference.
	 * @see #setDayType(DayType)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getAreaLoadCurve_DayType()
	 * @see org.opencim.cim.iec61970.load.DayType#getAreaLoadCurves
	 * @generated
	 */
	DayType getDayType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getDayType <em>Day Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Type</em>' reference.
	 * @see #getDayType()
	 * @generated
	 */
	void setDayType(DayType value);

	/**
	 * Returns the value of the '<em><b>Season</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.Season#getAreaLoadCurves <em>Area Load Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A system load model may be classified as seasonal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Season</em>' reference.
	 * @see #setSeason(Season)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getAreaLoadCurve_Season()
	 * @see org.opencim.cim.iec61970.load.Season#getAreaLoadCurves
	 * @generated
	 */
	Season getSeason();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getSeason <em>Season</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Season</em>' reference.
	 * @see #getSeason()
	 * @generated
	 */
	void setSeason(Season value);

} // AreaLoadCurve