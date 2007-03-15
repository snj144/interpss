/**
 * <copyright>
 * </copyright>
 *
 * $Id: HeatRateCurve.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Heat Rate Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between unit heat rate in MBtu/hour per MW (Y-axis) and  unit output in MW (X-axis). The heat input is from all fuels.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HeatRateCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatRateCurve()
 * @generated
 */
public interface HeatRateCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag is set to YES when output is expressed in net MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #setNetGrossMWFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHeatRateCurve_NetGrossMWFlag()
	 * @generated
	 */
	Boolean getNetGrossMWFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HeatRateCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #getNetGrossMWFlag()
	 * @generated
	 */
	void setNetGrossMWFlag(Boolean value);

} // HeatRateCurve