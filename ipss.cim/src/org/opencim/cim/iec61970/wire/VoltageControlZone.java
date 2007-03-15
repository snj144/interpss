/**
 * <copyright>
 * </copyright>
 *
 * $Id: VoltageControlZone.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.PowerSystemResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Voltage Control Zone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An area of the power system network which is defined for secondary voltage control purposes. A voltage control zone consists of a collection of substations with a designated bus bar section whose voltage will be controlled.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getBusbarSection <em>Busbar Section</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getRegulationSchedule <em>Regulation Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getVoltageControlZone()
 * @generated
 */
public interface VoltageControlZone extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Busbar Section</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.BusbarSection#getVoltageControlZone <em>Voltage Control Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A VoltageControlZone is controlled by a designated BusbarSection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Busbar Section</em>' reference.
	 * @see #setBusbarSection(BusbarSection)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getVoltageControlZone_BusbarSection()
	 * @see org.opencim.cim.iec61970.wire.BusbarSection#getVoltageControlZone
	 * @generated
	 */
	BusbarSection getBusbarSection();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getBusbarSection <em>Busbar Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Busbar Section</em>' reference.
	 * @see #getBusbarSection()
	 * @generated
	 */
	void setBusbarSection(BusbarSection value);

	/**
	 * Returns the value of the '<em><b>Regulation Schedule</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getVoltageControlZones <em>Voltage Control Zones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A VoltageControlZone may have a  voltage regulation schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regulation Schedule</em>' reference.
	 * @see #setRegulationSchedule(RegulationSchedule)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getVoltageControlZone_RegulationSchedule()
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getVoltageControlZones
	 * @generated
	 */
	RegulationSchedule getRegulationSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getRegulationSchedule <em>Regulation Schedule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regulation Schedule</em>' reference.
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	void setRegulationSchedule(RegulationSchedule value);

} // VoltageControlZone