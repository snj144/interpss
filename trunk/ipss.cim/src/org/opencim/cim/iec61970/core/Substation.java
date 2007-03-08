/**
 * <copyright>
 * </copyright>
 *
 * $Id: Substation.java,v 1.3 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.load.LoadArea;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A collection of equipment for purposes other than generation or utilization, through which electric energy in bulk is passed for the purposes of switching or modifying its characteristics. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.Substation#getSubControlArea <em>Sub Control Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Substation#getLoadArea <em>Load Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Substation#getVoltageLevels <em>Voltage Levels</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Substation#getBays <em>Bays</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Substation#getContains_CompositeSwitches <em>Contains Composite Switches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getSubstation()
 * @model
 * @generated
 */
public interface Substation extends EquipmentContainer {
	/**
	 * Returns the value of the '<em><b>Sub Control Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.SubControlArea#getSubstations <em>Substations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A SubControlArea may contain one or more Substations.
	 * The association is used in the naming hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Control Area</em>' container reference.
	 * @see #setSubControlArea(SubControlArea)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubstation_SubControlArea()
	 * @see org.opencim.cim.iec61970.core.SubControlArea#getSubstations
	 * @model opposite="Substations" required="true"
	 * @generated
	 */
	SubControlArea getSubControlArea();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Substation#getSubControlArea <em>Sub Control Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Control Area</em>' container reference.
	 * @see #getSubControlArea()
	 * @generated
	 */
	void setSubControlArea(SubControlArea value);

	/**
	 * Returns the value of the '<em><b>Load Area</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadArea#getSubstations <em>Substations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Area</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Area</em>' reference.
	 * @see #setLoadArea(LoadArea)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubstation_LoadArea()
	 * @see org.opencim.cim.iec61970.load.LoadArea#getSubstations
	 * @model opposite="Substations" required="true"
	 * @generated
	 */
	LoadArea getLoadArea();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Substation#getLoadArea <em>Load Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Area</em>' reference.
	 * @see #getLoadArea()
	 * @generated
	 */
	void setLoadArea(LoadArea value);

	/**
	 * Returns the value of the '<em><b>Voltage Levels</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.VoltageLevel}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.VoltageLevel#getSubstation <em>Substation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The association is used in the naming hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Levels</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubstation_VoltageLevels()
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getSubstation
	 * @model type="org.opencim.cim.iec61970.core.VoltageLevel" opposite="Substation" containment="true"
	 * @generated
	 */
	EList getVoltageLevels();

	/**
	 * Returns the value of the '<em><b>Bays</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Bay}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Bay#getSubstation <em>Substation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bays</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bays</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubstation_Bays()
	 * @see org.opencim.cim.iec61970.core.Bay#getSubstation
	 * @model type="org.opencim.cim.iec61970.core.Bay" opposite="Substation" containment="true"
	 * @generated
	 */
	EList getBays();

	/**
	 * Returns the value of the '<em><b>Contains Composite Switches</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.CompositeSwitch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains Composite Switches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains Composite Switches</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubstation_Contains_CompositeSwitches()
	 * @model type="org.opencim.cim.iec61970.wire.CompositeSwitch" containment="true"
	 * @generated
	 */
	EList getContains_CompositeSwitches();

} // Substation