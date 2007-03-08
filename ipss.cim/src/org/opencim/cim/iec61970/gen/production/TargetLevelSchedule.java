/**
 * <copyright>
 * </copyright>
 *
 * $Id: TargetLevelSchedule.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.datatype.real.WaterLevel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Level Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Reservoir water level targets from advanced studies or "rule curves". Typically in one hour increments for up to 10 days
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getHighLevelLimit <em>High Level Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getLowLevelLimit <em>Low Level Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getTargetLevelSchedule()
 * @model
 * @generated
 */
public interface TargetLevelSchedule extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>High Level Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * High target level limit, above which the reservoir operation will be penalized
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>High Level Limit</em>' attribute.
	 * @see #setHighLevelLimit(WaterLevel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getTargetLevelSchedule_HighLevelLimit()
	 * @model dataType="org.opencim.cim.iec61970.domain.WaterLevel"
	 * @generated
	 */
	WaterLevel getHighLevelLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getHighLevelLimit <em>High Level Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Level Limit</em>' attribute.
	 * @see #getHighLevelLimit()
	 * @generated
	 */
	void setHighLevelLimit(WaterLevel value);

	/**
	 * Returns the value of the '<em><b>Low Level Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Low target level limit, below which the reservoir operation will be penalized
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Low Level Limit</em>' attribute.
	 * @see #setLowLevelLimit(WaterLevel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getTargetLevelSchedule_LowLevelLimit()
	 * @model dataType="org.opencim.cim.iec61970.domain.WaterLevel"
	 * @generated
	 */
	WaterLevel getLowLevelLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.TargetLevelSchedule#getLowLevelLimit <em>Low Level Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low Level Limit</em>' attribute.
	 * @see #getLowLevelLimit()
	 * @generated
	 */
	void setLowLevelLimit(WaterLevel value);

} // TargetLevelSchedule