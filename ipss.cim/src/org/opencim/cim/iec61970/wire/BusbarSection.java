/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusbarSection.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Busbar Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation. 
 * Voltage measurements are typically obtained from VoltageTransformers that are connected to busbar sections. A bus bar section may have many physical terminals but for analysis is modelled with exactly one logical terminal. The typeName attribute indicates the type of bus bar section, e.g.: Main, Transfer.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.BusbarSection#getVoltageControlZone <em>Voltage Control Zone</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getBusbarSection()
 * @model
 * @generated
 */
public interface BusbarSection extends Connector {
	/**
	 * Returns the value of the '<em><b>Voltage Control Zone</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.VoltageControlZone#getBusbarSection <em>Busbar Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A VoltageControlZone is controlled by a designated BusbarSection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Control Zone</em>' reference.
	 * @see #setVoltageControlZone(VoltageControlZone)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getBusbarSection_VoltageControlZone()
	 * @see org.opencim.cim.iec61970.wire.VoltageControlZone#getBusbarSection
	 * @model opposite="BusbarSection"
	 * @generated
	 */
	VoltageControlZone getVoltageControlZone();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.BusbarSection#getVoltageControlZone <em>Voltage Control Zone</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage Control Zone</em>' reference.
	 * @see #getVoltageControlZone()
	 * @generated
	 */
	void setVoltageControlZone(VoltageControlZone value);

} // BusbarSection