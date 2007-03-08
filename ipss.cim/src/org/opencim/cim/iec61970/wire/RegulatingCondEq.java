/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegulatingCondEq.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.ConductingEquipment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regulating Cond Eq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RegulatingCondEq is a type of ConductingEquipment that can regulate Measurements and have a RegulationSchedule.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulatingCondEq#getRegulationSchedule <em>Regulation Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulatingCondEq()
 * @model abstract="true"
 * @generated
 */
public interface RegulatingCondEq extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>Regulation Schedule</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getRegulatingCondEqs <em>Regulating Cond Eqs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A regulating class may have a voltage regulation schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regulation Schedule</em>' reference.
	 * @see #setRegulationSchedule(RegulationSchedule)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulatingCondEq_RegulationSchedule()
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule#getRegulatingCondEqs
	 * @model opposite="RegulatingCondEqs"
	 * @generated
	 */
	RegulationSchedule getRegulationSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RegulatingCondEq#getRegulationSchedule <em>Regulation Schedule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regulation Schedule</em>' reference.
	 * @see #getRegulationSchedule()
	 * @generated
	 */
	void setRegulationSchedule(RegulationSchedule value);

} // RegulatingCondEq