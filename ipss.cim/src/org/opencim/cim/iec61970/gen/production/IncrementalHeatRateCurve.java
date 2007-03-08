/**
 * <copyright>
 * </copyright>
 *
 * $Id: IncrementalHeatRateCurve.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Incremental Heat Rate Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between unit incremental heat rate in (delta MBtu/hour) per (delta MW )and unit output in MW. The IHR curve represents the slope of the HeatInputCurve. Note that the "incremental heat rate" and the "heat rate" have the same engineering units, i.e., MBtu/MWh.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getIncrementalHeatRateCurve()
 * @model
 * @generated
 */
public interface IncrementalHeatRateCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag is set to YES when output is expressed in net MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #setNetGrossMWFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getIncrementalHeatRateCurve_NetGrossMWFlag()
	 * @model
	 * @generated
	 */
	Boolean getNetGrossMWFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.IncrementalHeatRateCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #getNetGrossMWFlag()
	 * @generated
	 */
	void setNetGrossMWFlag(Boolean value);

} // IncrementalHeatRateCurve