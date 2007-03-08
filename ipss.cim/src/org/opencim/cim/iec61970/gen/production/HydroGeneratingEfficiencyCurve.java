/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroGeneratingEfficiencyCurve.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hydro Generating Efficiency Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between unit efficiency in percent and unit output in MW for a given net head in meters. The relationship between efficiency, discharge, head, and power output is expressed as follows:   E =KP/HQ
 * Where:  (E=%)  (P=MW)  (H=m)  (Q=m3/s)  (K=constant)
 * For example, a curve instance for a given net head could relate efficiency (Y-axis) versus MW output (X-axis) or versus discharge on the X-axis.
 * <!-- end-model-doc -->
 *
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroGeneratingEfficiencyCurve()
 * @model
 * @generated
 */
public interface HydroGeneratingEfficiencyCurve extends CurveSchedule {
} // HydroGeneratingEfficiencyCurve