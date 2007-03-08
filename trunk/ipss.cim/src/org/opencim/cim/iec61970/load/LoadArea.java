/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadArea.java,v 1.3 2007/03/07 05:14:05 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Group of loads (i.e., energy consumers)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadArea#getEnergyConsumers <em>Energy Consumers</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadArea#getAreaLossCurves <em>Area Loss Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadArea#getAreaLoadCurves <em>Area Load Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadArea#getSubstations <em>Substations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadArea()
 * @model
 * @generated
 */
public interface LoadArea extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Energy Consumers</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.EnergyConsumer}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Consumers may be assigned to a load area.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energy Consumers</em>' reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadArea_EnergyConsumers()
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadArea
	 * @model type="org.opencim.cim.iec61970.wire.EnergyConsumer" opposite="LoadArea"
	 * @generated
	 */
	EList getEnergyConsumers();

	/**
	 * Returns the value of the '<em><b>Area Loss Curves</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.AreaLossCurve}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.AreaLossCurve#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A load area can have one or more area loss curves
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Area Loss Curves</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadArea_AreaLossCurves()
	 * @see org.opencim.cim.iec61970.load.AreaLossCurve#getLoadArea
	 * @model type="org.opencim.cim.iec61970.load.AreaLossCurve" opposite="LoadArea" containment="true"
	 * @generated
	 */
	EList getAreaLossCurves();

	/**
	 * Returns the value of the '<em><b>Area Load Curves</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.AreaLoadCurve}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A load area can have one or more area load curves
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Area Load Curves</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadArea_AreaLoadCurves()
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve#getLoadArea
	 * @model type="org.opencim.cim.iec61970.load.AreaLoadCurve" opposite="LoadArea" containment="true"
	 * @generated
	 */
	EList getAreaLoadCurves();

	/**
	 * Returns the value of the '<em><b>Substations</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Substation}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Substation#getLoadArea <em>Load Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substations</em>' reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadArea_Substations()
	 * @see org.opencim.cim.iec61970.core.Substation#getLoadArea
	 * @model type="org.opencim.cim.iec61970.core.Substation" opposite="LoadArea"
	 * @generated
	 */
	EList getSubstations();

} // LoadArea