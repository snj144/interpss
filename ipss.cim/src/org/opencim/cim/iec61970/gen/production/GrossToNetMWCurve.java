/**
 * <copyright>
 * </copyright>
 *
 * $Id: GrossToNetMWCurve.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gross To Net MW Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between the generating unit's gross MW output on the X-axis (measured at the terminals of the machine(s)) and the generating unit's net MW output on the Y-axis (based on utility-defined measurements at the power station). Station service loads, when modeled, should be treated as non-conforming bus loads. There may be more than one curve, depending on the auxiliary equipment that is in service.
 * <!-- end-model-doc -->
 *
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGrossToNetMWCurve()
 * @model
 * @generated
 */
public interface GrossToNetMWCurve extends CurveSchedule {
} // GrossToNetMWCurve