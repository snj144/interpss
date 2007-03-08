/**
 * <copyright>
 * </copyright>
 *
 * $Id: AreaLossCurve.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area Loss Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The relationship between total area MW losses (Y-axis) and total area MW load (X-axis)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.AreaLossCurve#getLoadArea <em>Load Area</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getAreaLossCurve()
 * @model
 * @generated
 */
public interface AreaLossCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Load Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadArea#getAreaLossCurves <em>Area Loss Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A load area can have one or more area loss curves
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Area</em>' container reference.
	 * @see #setLoadArea(LoadArea)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getAreaLossCurve_LoadArea()
	 * @see org.opencim.cim.iec61970.load.LoadArea#getAreaLossCurves
	 * @model opposite="AreaLossCurves" required="true"
	 * @generated
	 */
	LoadArea getLoadArea();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.AreaLossCurve#getLoadArea <em>Load Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Area</em>' container reference.
	 * @see #getLoadArea()
	 * @generated
	 */
	void setLoadArea(LoadArea value);

} // AreaLossCurve