/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeSwitch.java,v 1.1 2007/03/02 14:01:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.EquipmentContainer;

import org.opencim.datatype.string.CompositeSwitchType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model of a set of individual Switches normally enclosed within the same cabinet and possibly with interlocks that restrict the combination of switch positions. These are typically found in medium voltage distribution networks. 
 * A CompositeSwitch could represent a Ring-Main-Unit (RMU), or pad-mounted switchgear, with primitive internal devices such as an internal bus-bar plus 3 or 4 internal switches each of which may individually be open or closed. A CompositeSwitch and a set of contained Switches can also be used to represent a multi-position switch e.g. a switch that can connect a circuit to Ground, Open or Busbar.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.CompositeSwitch#getCompositeSwitchType <em>Composite Switch Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.CompositeSwitch#getSwitches <em>Switches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompositeSwitch()
 * @model
 * @generated
 */
public interface CompositeSwitch extends EquipmentContainer {
	/**
	 * Returns the value of the '<em><b>Composite Switch Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An alphanumeric code that can be used as a reference to extar information such as the description of the interlocking scheme if any
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Composite Switch Type</em>' attribute.
	 * @see #setCompositeSwitchType(CompositeSwitchType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompositeSwitch_CompositeSwitchType()
	 * @model dataType="org.opencim.cim.iec61970.domain.CompositeSwitchType"
	 * @generated
	 */
	CompositeSwitchType getCompositeSwitchType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.CompositeSwitch#getCompositeSwitchType <em>Composite Switch Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Switch Type</em>' attribute.
	 * @see #getCompositeSwitchType()
	 * @generated
	 */
	void setCompositeSwitchType(CompositeSwitchType value);

	/**
	 * Returns the value of the '<em><b>Switches</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.Switch}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.Switch#getCompositeSwitch <em>Composite Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switches</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switches</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getCompositeSwitch_Switches()
	 * @see org.opencim.cim.iec61970.wire.Switch#getCompositeSwitch
	 * @model type="org.opencim.cim.iec61970.wire.Switch" opposite="CompositeSwitch"
	 * @generated
	 */
	EList getSwitches();

} // CompositeSwitch