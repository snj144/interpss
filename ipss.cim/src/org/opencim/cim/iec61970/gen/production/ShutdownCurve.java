/**
 * <copyright>
 * </copyright>
 *
 * $Id: ShutdownCurve.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import java.util.Date;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.datatype.real.Money;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shutdown Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between the rate in gross MW/minute (Y-axis) at which a unit should be shutdown and its present gross MW output (X-axis)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownCost <em>Shutdown Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownDate <em>Shutdown Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getShutdownCurve()
 * @generated
 */
public interface ShutdownCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Shutdown Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fixed shutdown cost
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shutdown Cost</em>' attribute.
	 * @see #setShutdownCost(Money)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getShutdownCurve_ShutdownCost()
	 * @generated
	 */
	Money getShutdownCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownCost <em>Shutdown Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shutdown Cost</em>' attribute.
	 * @see #getShutdownCost()
	 * @generated
	 */
	void setShutdownCost(Money value);

	/**
	 * Returns the value of the '<em><b>Shutdown Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date and time of the most recent generating unit shutdown
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shutdown Date</em>' attribute.
	 * @see #setShutdownDate(Date)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getShutdownCurve_ShutdownDate()
	 * @generated
	 */
	Date getShutdownDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ShutdownCurve#getShutdownDate <em>Shutdown Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shutdown Date</em>' attribute.
	 * @see #getShutdownDate()
	 * @generated
	 */
	void setShutdownDate(Date value);

} // ShutdownCurve