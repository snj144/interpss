/**
 * <copyright>
 * </copyright>
 *
 * $Id: NonConformLoadSchedule.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.wire.EnergyConsumer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Conform Load Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MW (Y1-axis) and MVAr (Y2-axis) schedule (curves) versus time (X-axis) for non-conforming loads, e.g., large industrial load or power station service (where modeled)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.NonConformLoadSchedule#getEnergyConsumer <em>Energy Consumer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getNonConformLoadSchedule()
 * @generated
 */
public interface NonConformLoadSchedule extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Energy Consumer</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getNonConformLoadSchedules <em>Non Conform Load Schedules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An energy consumer may have a non-conforming load schedule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energy Consumer</em>' container reference.
	 * @see #setEnergyConsumer(EnergyConsumer)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getNonConformLoadSchedule_EnergyConsumer()
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getNonConformLoadSchedules
	 * @generated
	 */
	EnergyConsumer getEnergyConsumer();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.NonConformLoadSchedule#getEnergyConsumer <em>Energy Consumer</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Consumer</em>' container reference.
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	void setEnergyConsumer(EnergyConsumer value);

} // NonConformLoadSchedule