/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegulationSchedule.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regulation Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A pre-established pattern over time for a controlled variable, e.g., busbar voltage.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropCompensation <em>Line Drop Compensation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropR <em>Line Drop R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropX <em>Line Drop X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getVoltageControlZones <em>Voltage Control Zones</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getRegulatingCondEqs <em>Regulating Cond Eqs</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getTapChangers <em>Tap Changers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule()
 * @model
 * @generated
 */
public interface RegulationSchedule extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Line Drop Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag to indicate that line drop compensation is to be applied
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line Drop Compensation</em>' attribute.
	 * @see #setLineDropCompensation(Boolean)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule_LineDropCompensation()
	 * @model
	 * @generated
	 */
	Boolean getLineDropCompensation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropCompensation <em>Line Drop Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Drop Compensation</em>' attribute.
	 * @see #getLineDropCompensation()
	 * @generated
	 */
	void setLineDropCompensation(Boolean value);

	/**
	 * Returns the value of the '<em><b>Line Drop R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Line drop resistance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line Drop R</em>' attribute.
	 * @see #setLineDropR(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule_LineDropR()
	 * @model dataType="org.opencim.cim.iec61970.domain.Resistance"
	 * @generated
	 */
	Resistance getLineDropR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropR <em>Line Drop R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Drop R</em>' attribute.
	 * @see #getLineDropR()
	 * @generated
	 */
	void setLineDropR(Resistance value);

	/**
	 * Returns the value of the '<em><b>Line Drop X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Line drop reactance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line Drop X</em>' attribute.
	 * @see #setLineDropX(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule_LineDropX()
	 * @model dataType="org.opencim.cim.iec61970.domain.Reactance"
	 * @generated
	 */
	Reactance getLineDropX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.RegulationSchedule#getLineDropX <em>Line Drop X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Drop X</em>' attribute.
	 * @see #getLineDropX()
	 * @generated
	 */
	void setLineDropX(Reactance value);

	/**
	 * Returns the value of the '<em><b>Voltage Control Zones</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.VoltageControlZone}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getRegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A VoltageControlZone may have a  voltage regulation schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Control Zones</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule_VoltageControlZones()
	 * @see org.opencim.cim.iec61970.wire.VoltageControlZone#getRegulationSchedule
	 * @model type="org.opencim.cim.iec61970.wire.VoltageControlZone" opposite="RegulationSchedule"
	 * @generated
	 */
	EList getVoltageControlZones();

	/**
	 * Returns the value of the '<em><b>Regulating Cond Eqs</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.RegulatingCondEq}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.RegulatingCondEq#getRegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A regulating class may have a voltage regulation schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regulating Cond Eqs</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule_RegulatingCondEqs()
	 * @see org.opencim.cim.iec61970.wire.RegulatingCondEq#getRegulationSchedule
	 * @model type="org.opencim.cim.iec61970.wire.RegulatingCondEq" opposite="RegulationSchedule"
	 * @generated
	 */
	EList getRegulatingCondEqs();

	/**
	 * Returns the value of the '<em><b>Tap Changers</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.TapChanger}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.TapChanger#getRegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An LTC may have a regulation schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tap Changers</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getRegulationSchedule_TapChangers()
	 * @see org.opencim.cim.iec61970.wire.TapChanger#getRegulationSchedule
	 * @model type="org.opencim.cim.iec61970.wire.TapChanger" opposite="RegulationSchedule"
	 * @generated
	 */
	EList getTapChangers();

} // RegulationSchedule