/**
 * <copyright>
 * </copyright>
 *
 * $Id: Bay.java,v 1.3 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.opencim.cim.iec61970.domain.BreakerConfiguration;
import org.opencim.cim.iec61970.domain.BusbarConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bay</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A collection of power system resources (within a given substation) including conducting equipment, protection relays, measurements, and telemetry. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.Bay#getBayEnergyMeasFlag <em>Bay Energy Meas Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Bay#getBayPowerMeasFlag <em>Bay Power Meas Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Bay#getBreakerConfiguration <em>Breaker Configuration</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Bay#getBusBarConfiguration <em>Bus Bar Configuration</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Bay#getVoltageLevel <em>Voltage Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Bay#getSubstation <em>Substation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getBay()
 * @model
 * @generated
 */
public interface Bay extends EquipmentContainer {
	/**
	 * Returns the value of the '<em><b>Bay Energy Meas Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates the presence/absence of kWh/kvarh measurements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bay Energy Meas Flag</em>' attribute.
	 * @see #setBayEnergyMeasFlag(Boolean)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBay_BayEnergyMeasFlag()
	 * @model
	 * @generated
	 */
	Boolean getBayEnergyMeasFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Bay#getBayEnergyMeasFlag <em>Bay Energy Meas Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bay Energy Meas Flag</em>' attribute.
	 * @see #getBayEnergyMeasFlag()
	 * @generated
	 */
	void setBayEnergyMeasFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Bay Power Meas Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates the presence/absence of MW/MVAr measurements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bay Power Meas Flag</em>' attribute.
	 * @see #setBayPowerMeasFlag(Boolean)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBay_BayPowerMeasFlag()
	 * @model
	 * @generated
	 */
	Boolean getBayPowerMeasFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Bay#getBayPowerMeasFlag <em>Bay Power Meas Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bay Power Meas Flag</em>' attribute.
	 * @see #getBayPowerMeasFlag()
	 * @generated
	 */
	void setBayPowerMeasFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Breaker Configuration</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.BreakerConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Breaker configuration. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Breaker Configuration</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.BreakerConfiguration
	 * @see #setBreakerConfiguration(BreakerConfiguration)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBay_BreakerConfiguration()
	 * @model
	 * @generated
	 */
	BreakerConfiguration getBreakerConfiguration();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Bay#getBreakerConfiguration <em>Breaker Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Breaker Configuration</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.BreakerConfiguration
	 * @see #getBreakerConfiguration()
	 * @generated
	 */
	void setBreakerConfiguration(BreakerConfiguration value);

	/**
	 * Returns the value of the '<em><b>Bus Bar Configuration</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.BusbarConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bus bar configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bus Bar Configuration</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.BusbarConfiguration
	 * @see #setBusBarConfiguration(BusbarConfiguration)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBay_BusBarConfiguration()
	 * @model
	 * @generated
	 */
	BusbarConfiguration getBusBarConfiguration();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Bay#getBusBarConfiguration <em>Bus Bar Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Bar Configuration</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.BusbarConfiguration
	 * @see #getBusBarConfiguration()
	 * @generated
	 */
	void setBusBarConfiguration(BusbarConfiguration value);

	/**
	 * Returns the value of the '<em><b>Voltage Level</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.VoltageLevel#getBays <em>Bays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The association is used in the naming hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage Level</em>' container reference.
	 * @see #setVoltageLevel(VoltageLevel)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBay_VoltageLevel()
	 * @see org.opencim.cim.iec61970.core.VoltageLevel#getBays
	 * @model opposite="Bays" required="true"
	 * @generated
	 */
	VoltageLevel getVoltageLevel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Bay#getVoltageLevel <em>Voltage Level</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage Level</em>' container reference.
	 * @see #getVoltageLevel()
	 * @generated
	 */
	void setVoltageLevel(VoltageLevel value);

	/**
	 * Returns the value of the '<em><b>Substation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Substation#getBays <em>Bays</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substation</em>' container reference.
	 * @see #setSubstation(Substation)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getBay_Substation()
	 * @see org.opencim.cim.iec61970.core.Substation#getBays
	 * @model opposite="Bays" required="true"
	 * @generated
	 */
	Substation getSubstation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Bay#getSubstation <em>Substation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Substation</em>' container reference.
	 * @see #getSubstation()
	 * @generated
	 */
	void setSubstation(Substation value);

} // Bay