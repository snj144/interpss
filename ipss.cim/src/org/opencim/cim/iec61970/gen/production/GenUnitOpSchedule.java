/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenUnitOpSchedule.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Unit Op Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The generating unit's Operator-approved current operating schedule (or plan), typically produced with the aid of unit commitment type analyses. The X-axis represents absolute time. The Y1-axis represents the status (0=off-line and unavailable: 1=available: 2=must run: 3=must run at fixed MW value: etc.). The Y2-axis represents the must run fixed MW value where required.
 * <!-- end-model-doc -->
 *
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGenUnitOpSchedule()
 * @model
 * @generated
 */
public interface GenUnitOpSchedule extends CurveSchedule {
} // GenUnitOpSchedule