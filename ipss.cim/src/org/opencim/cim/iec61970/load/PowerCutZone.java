/**
 * <copyright>
 * </copyright>
 *
 * $Id: PowerCutZone.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.datatype.real.PerCent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Cut Zone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An area or zone of the power system which is used for load shedding purposes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel1 <em>Cut Level1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel2 <em>Cut Level2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.PowerCutZone#getEnergyConsumers <em>Energy Consumers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getPowerCutZone()
 * @generated
 */
public interface PowerCutZone extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Cut Level1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * First level (amount) of load to cut as a percentage of total zone load
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cut Level1</em>' attribute.
	 * @see #setCutLevel1(PerCent)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getPowerCutZone_CutLevel1()
	 * @generated
	 */
	PerCent getCutLevel1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel1 <em>Cut Level1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cut Level1</em>' attribute.
	 * @see #getCutLevel1()
	 * @generated
	 */
	void setCutLevel1(PerCent value);

	/**
	 * Returns the value of the '<em><b>Cut Level2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Second level (amount) of load to cut as a percentage of total zone load
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cut Level2</em>' attribute.
	 * @see #setCutLevel2(PerCent)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getPowerCutZone_CutLevel2()
	 * @generated
	 */
	PerCent getCutLevel2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.PowerCutZone#getCutLevel2 <em>Cut Level2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cut Level2</em>' attribute.
	 * @see #getCutLevel2()
	 * @generated
	 */
	void setCutLevel2(PerCent value);

	/**
	 * Returns the value of the '<em><b>Energy Consumers</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.EnergyConsumer}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerCutZone <em>Power Cut Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An energy consumer is assigned to a power cut zone
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energy Consumers</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getPowerCutZone_EnergyConsumers()
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerCutZone
	 * @generated
	 */
	EList getEnergyConsumers();

} // PowerCutZone