/**
 * <copyright>
 * </copyright>
 *
 * $Id: Switch.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import java.util.Date;

import org.opencim.cim.iec61970.core.ConductingEquipment;

import org.opencim.datatype.integer.Counter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generic device  designed to close, or open, or both, one or more electric circuits. The typeName attribute may be used to indicate that the database switch does not represent a corresponding real device but has been introduced for modeling purposes only.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.Switch#getNormalOpen <em>Normal Open</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Switch#getSwitchOnCount <em>Switch On Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Switch#getSwitchOnDate <em>Switch On Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.Switch#getCompositeSwitch <em>Composite Switch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getSwitch()
 * @model
 * @generated
 */
public interface Switch extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>Normal Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute is used in cases when no Measurement for the status value is present. If the Switch has a status measurment the Measurement.normalValue is expected to match with the Switch.normalOpen.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal Open</em>' attribute.
	 * @see #setNormalOpen(Boolean)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSwitch_NormalOpen()
	 * @model
	 * @generated
	 */
	Boolean getNormalOpen();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Switch#getNormalOpen <em>Normal Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal Open</em>' attribute.
	 * @see #getNormalOpen()
	 * @generated
	 */
	void setNormalOpen(Boolean value);

	/**
	 * Returns the value of the '<em><b>Switch On Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The switch on count since the switch was last reset or initialized.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Switch On Count</em>' attribute.
	 * @see #setSwitchOnCount(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSwitch_SwitchOnCount()
	 * @model dataType="org.opencim.cim.iec61970.domain.Counter"
	 * @generated
	 */
	Counter getSwitchOnCount();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Switch#getSwitchOnCount <em>Switch On Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch On Count</em>' attribute.
	 * @see #getSwitchOnCount()
	 * @generated
	 */
	void setSwitchOnCount(Counter value);

	/**
	 * Returns the value of the '<em><b>Switch On Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date and time when the switch was last switched on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Switch On Date</em>' attribute.
	 * @see #setSwitchOnDate(Date)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSwitch_SwitchOnDate()
	 * @model dataType="org.opencim.cim.iec61970.domain.AbsoluteDateTime"
	 * @generated
	 */
	Date getSwitchOnDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Switch#getSwitchOnDate <em>Switch On Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch On Date</em>' attribute.
	 * @see #getSwitchOnDate()
	 * @generated
	 */
	void setSwitchOnDate(Date value);

	/**
	 * Returns the value of the '<em><b>Composite Switch</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.CompositeSwitch#getSwitches <em>Switches</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Switch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Switch</em>' reference.
	 * @see #setCompositeSwitch(CompositeSwitch)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getSwitch_CompositeSwitch()
	 * @see org.opencim.cim.iec61970.wire.CompositeSwitch#getSwitches
	 * @model opposite="Switches"
	 * @generated
	 */
	CompositeSwitch getCompositeSwitch();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.Switch#getCompositeSwitch <em>Composite Switch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Switch</em>' reference.
	 * @see #getCompositeSwitch()
	 * @generated
	 */
	void setCompositeSwitch(CompositeSwitch value);

} // Switch