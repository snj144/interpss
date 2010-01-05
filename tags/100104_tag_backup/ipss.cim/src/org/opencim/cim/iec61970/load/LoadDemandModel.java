/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadDemandModel.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.wire.EnergyConsumer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Demand Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A curve of load  versus time (X-axis) showing the values of MW (Y1-axis) and MVAr (Y2-axis) for each unit of the period covered. This curve represents a typical pattern of load over the time period for a given day type and season.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadDemandModel#getEnergyConsumer <em>Energy Consumer</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadDemandModel#getBasisFor <em>Basis For</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadDemandModel#getDayType <em>Day Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadDemandModel()
 * @generated
 */
public interface LoadDemandModel extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Energy Consumer</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadDemandModels <em>Load Demand Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An energy consumer may have one or more load demand models
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energy Consumer</em>' container reference.
	 * @see #setEnergyConsumer(EnergyConsumer)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadDemandModel_EnergyConsumer()
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadDemandModels
	 * @generated
	 */
	EnergyConsumer getEnergyConsumer();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getEnergyConsumer <em>Energy Consumer</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Consumer</em>' container reference.
	 * @see #getEnergyConsumer()
	 * @generated
	 */
	void setEnergyConsumer(EnergyConsumer value);

	/**
	 * Returns the value of the '<em><b>Basis For</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.Season#getLoadDemandModels <em>Load Demand Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Load demand models can be based on seasons
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Basis For</em>' reference.
	 * @see #setBasisFor(Season)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadDemandModel_BasisFor()
	 * @see org.opencim.cim.iec61970.load.Season#getLoadDemandModels
	 * @generated
	 */
	Season getBasisFor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getBasisFor <em>Basis For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis For</em>' reference.
	 * @see #getBasisFor()
	 * @generated
	 */
	void setBasisFor(Season value);

	/**
	 * Returns the value of the '<em><b>Day Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.DayType#getLoadDemandModels <em>Load Demand Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Load demand models can be based on day type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Day Type</em>' reference.
	 * @see #setDayType(DayType)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadDemandModel_DayType()
	 * @see org.opencim.cim.iec61970.load.DayType#getLoadDemandModels
	 * @generated
	 */
	DayType getDayType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getDayType <em>Day Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Type</em>' reference.
	 * @see #getDayType()
	 * @generated
	 */
	void setDayType(DayType value);

} // LoadDemandModel