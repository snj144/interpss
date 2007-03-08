/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquivalentLoad.java,v 1.1 2007/03/02 14:01:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.opencim.cim.iec61970.wire.EnergyConsumer;

import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.PerCent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equivalent Load</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generic equivalent for an energy consumer on a transmission or distribution voltage level. It may be under load management and also has cold load pick up characteristics.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.EquivalentLoad#getFeederLoadMgtFactor <em>Feeder Load Mgt Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.EquivalentLoad#getMVArColdPickUpFactor <em>MV Ar Cold Pick Up Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.EquivalentLoad#getMWColdPickUpFactor <em>MW Cold Pick Up Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.EquivalentLoad#getPhaseAmpRating <em>Phase Amp Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.EquivalentLoad#getLoadAllocationFactor <em>Load Allocation Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getEquivalentLoad()
 * @model
 * @generated
 */
public interface EquivalentLoad extends EnergyConsumer {
	/**
	 * Returns the value of the '<em><b>Feeder Load Mgt Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The feeder's contribution to load management, in percent
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feeder Load Mgt Factor</em>' attribute.
	 * @see #setFeederLoadMgtFactor(PerCent)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getEquivalentLoad_FeederLoadMgtFactor()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getFeederLoadMgtFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getFeederLoadMgtFactor <em>Feeder Load Mgt Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feeder Load Mgt Factor</em>' attribute.
	 * @see #getFeederLoadMgtFactor()
	 * @generated
	 */
	void setFeederLoadMgtFactor(PerCent value);

	/**
	 * Returns the value of the '<em><b>MV Ar Cold Pick Up Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of nominal feeder MVAr that is picked up cold, in percent
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MV Ar Cold Pick Up Factor</em>' attribute.
	 * @see #setMVArColdPickUpFactor(PerCent)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getEquivalentLoad_MVArColdPickUpFactor()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getMVArColdPickUpFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getMVArColdPickUpFactor <em>MV Ar Cold Pick Up Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MV Ar Cold Pick Up Factor</em>' attribute.
	 * @see #getMVArColdPickUpFactor()
	 * @generated
	 */
	void setMVArColdPickUpFactor(PerCent value);

	/**
	 * Returns the value of the '<em><b>MW Cold Pick Up Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of nominal feeder MW that is picked up cold, in percent
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MW Cold Pick Up Factor</em>' attribute.
	 * @see #setMWColdPickUpFactor(PerCent)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getEquivalentLoad_MWColdPickUpFactor()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getMWColdPickUpFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getMWColdPickUpFactor <em>MW Cold Pick Up Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MW Cold Pick Up Factor</em>' attribute.
	 * @see #getMWColdPickUpFactor()
	 * @generated
	 */
	void setMWColdPickUpFactor(PerCent value);

	/**
	 * Returns the value of the '<em><b>Phase Amp Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rated individual phase amperes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phase Amp Rating</em>' attribute.
	 * @see #setPhaseAmpRating(CurrentFlow)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getEquivalentLoad_PhaseAmpRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.CurrentFlow"
	 * @generated
	 */
	CurrentFlow getPhaseAmpRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getPhaseAmpRating <em>Phase Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase Amp Rating</em>' attribute.
	 * @see #getPhaseAmpRating()
	 * @generated
	 */
	void setPhaseAmpRating(CurrentFlow value);

	/**
	 * Returns the value of the '<em><b>Load Allocation Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Permit assignment of loads on a participation factor basis. Given three equivalent loads with factors of 10, 25 and 15, a feeder load of 100 amps could be allocated on the feeder as 20, 50 and 30 amps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Allocation Factor</em>' attribute.
	 * @see #setLoadAllocationFactor(Float)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getEquivalentLoad_LoadAllocationFactor()
	 * @model
	 * @generated
	 */
	Float getLoadAllocationFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.EquivalentLoad#getLoadAllocationFactor <em>Load Allocation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Allocation Factor</em>' attribute.
	 * @see #getLoadAllocationFactor()
	 * @generated
	 */
	void setLoadAllocationFactor(Float value);

} // EquivalentLoad