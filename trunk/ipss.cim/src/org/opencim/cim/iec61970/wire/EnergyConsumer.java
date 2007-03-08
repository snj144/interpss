/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnergyConsumer.java,v 1.3 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.ConductingEquipment;

import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.PowerCutZone;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Exponent;
import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.PowerFactor;
import org.opencim.datatype.real.ReactivePower;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Energy Consumer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Generic user of energy - a  point of consumption on the power system model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadDemandModels <em>Load Demand Models</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getNonConformLoadSchedules <em>Non Conform Load Schedules</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadArea <em>Load Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerCutZone <em>Power Cut Zone</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getConformingLoadFlag <em>Conforming Load Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getCustomerCount <em>Customer Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPFexp <em>PFexp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixed <em>Pfixed</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixedPct <em>Pfixed Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPnom <em>Pnom</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPnomPct <em>Pnom Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerFactor <em>Power Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPVexp <em>PVexp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQFexp <em>QFexp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixed <em>Qfixed</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixedPct <em>Qfixed Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQnom <em>Qnom</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQnomPct <em>Qnom Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQVexp <em>QVexp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer()
 * @model
 * @generated
 */
public interface EnergyConsumer extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>Load Demand Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.LoadDemandModel}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getEnergyConsumer <em>Energy Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An energy consumer may have one or more load demand models
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Demand Models</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_LoadDemandModels()
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel#getEnergyConsumer
	 * @model type="org.opencim.cim.iec61970.load.LoadDemandModel" opposite="EnergyConsumer" containment="true"
	 * @generated
	 */
	EList getLoadDemandModels();

	/**
	 * Returns the value of the '<em><b>Non Conform Load Schedules</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.NonConformLoadSchedule}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.NonConformLoadSchedule#getEnergyConsumer <em>Energy Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An energy consumer may have a non-conforming load schedule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Non Conform Load Schedules</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_NonConformLoadSchedules()
	 * @see org.opencim.cim.iec61970.load.NonConformLoadSchedule#getEnergyConsumer
	 * @model type="org.opencim.cim.iec61970.load.NonConformLoadSchedule" opposite="EnergyConsumer" containment="true"
	 * @generated
	 */
	EList getNonConformLoadSchedules();

	/**
	 * Returns the value of the '<em><b>Load Area</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadArea#getEnergyConsumers <em>Energy Consumers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Consumers may be assigned to a load area.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Area</em>' reference.
	 * @see #setLoadArea(LoadArea)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_LoadArea()
	 * @see org.opencim.cim.iec61970.load.LoadArea#getEnergyConsumers
	 * @model opposite="EnergyConsumers" required="true"
	 * @generated
	 */
	LoadArea getLoadArea();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getLoadArea <em>Load Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Area</em>' reference.
	 * @see #getLoadArea()
	 * @generated
	 */
	void setLoadArea(LoadArea value);

	/**
	 * Returns the value of the '<em><b>Power Cut Zone</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.PowerCutZone#getEnergyConsumers <em>Energy Consumers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An energy consumer is assigned to a power cut zone
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Power Cut Zone</em>' container reference.
	 * @see #setPowerCutZone(PowerCutZone)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_PowerCutZone()
	 * @see org.opencim.cim.iec61970.load.PowerCutZone#getEnergyConsumers
	 * @model opposite="EnergyConsumers" required="true"
	 * @generated
	 */
	PowerCutZone getPowerCutZone();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerCutZone <em>Power Cut Zone</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Cut Zone</em>' container reference.
	 * @see #getPowerCutZone()
	 * @generated
	 */
	void setPowerCutZone(PowerCutZone value);

	/**
	 * Returns the value of the '<em><b>Conforming Load Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag is set to YES if the load is conforming, i.e., tracks the area load to which the energy consumer belongs
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conforming Load Flag</em>' attribute.
	 * @see #setConformingLoadFlag(Boolean)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_ConformingLoadFlag()
	 * @model
	 * @generated
	 */
	Boolean getConformingLoadFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getConformingLoadFlag <em>Conforming Load Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conforming Load Flag</em>' attribute.
	 * @see #getConformingLoadFlag()
	 * @generated
	 */
	void setConformingLoadFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Customer Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Number of individual customers represented by this Demand
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Customer Count</em>' attribute.
	 * @see #setCustomerCount(Counter)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_CustomerCount()
	 * @model dataType="org.opencim.cim.iec61970.domain.Counter"
	 * @generated
	 */
	Counter getCustomerCount();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getCustomerCount <em>Customer Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Count</em>' attribute.
	 * @see #getCustomerCount()
	 * @generated
	 */
	void setCustomerCount(Counter value);

	/**
	 * Returns the value of the '<em><b>PFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of per unit frequency effecting real power.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>PFexp</em>' attribute.
	 * @see #setPFexp(Exponent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_PFexp()
	 * @model dataType="org.opencim.cim.iec61970.domain.Exponent"
	 * @generated
	 */
	Exponent getPFexp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPFexp <em>PFexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PFexp</em>' attribute.
	 * @see #getPFexp()
	 * @generated
	 */
	void setPFexp(Exponent value);

	/**
	 * Returns the value of the '<em><b>Pfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Real component of the load that is a fixed quantity,  MW.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pfixed</em>' attribute.
	 * @see #setPfixed(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_Pfixed()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getPfixed();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixed <em>Pfixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pfixed</em>' attribute.
	 * @see #getPfixed()
	 * @generated
	 */
	void setPfixed(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Pfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fixed MW as per cent of load group fixed MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pfixed Pct</em>' attribute.
	 * @see #setPfixedPct(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_PfixedPct()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getPfixedPct();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPfixedPct <em>Pfixed Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pfixed Pct</em>' attribute.
	 * @see #getPfixedPct()
	 * @generated
	 */
	void setPfixedPct(PerCent value);

	/**
	 * Returns the value of the '<em><b>Pnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nominal value for real power, MW. Nominal real power is adjusted according to the load profile selected for the consumer.  It equates to one per unit in the load profile.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pnom</em>' attribute.
	 * @see #setPnom(ActivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_Pnom()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getPnom();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPnom <em>Pnom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pnom</em>' attribute.
	 * @see #getPnom()
	 * @generated
	 */
	void setPnom(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Pnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nominal MW as per cent of load group nominal MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pnom Pct</em>' attribute.
	 * @see #setPnomPct(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_PnomPct()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getPnomPct();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPnomPct <em>Pnom Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pnom Pct</em>' attribute.
	 * @see #getPnomPct()
	 * @generated
	 */
	void setPnomPct(PerCent value);

	/**
	 * Returns the value of the '<em><b>Power Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Power factor for nominal portion of load. Defined as MW/MVA
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Power Factor</em>' attribute.
	 * @see #setPowerFactor(PowerFactor)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_PowerFactor()
	 * @model dataType="org.opencim.cim.iec61970.domain.PowerFactor"
	 * @generated
	 */
	PowerFactor getPowerFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPowerFactor <em>Power Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Factor</em>' attribute.
	 * @see #getPowerFactor()
	 * @generated
	 */
	void setPowerFactor(PowerFactor value);

	/**
	 * Returns the value of the '<em><b>PVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of per unit voltage effecting real power.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>PVexp</em>' attribute.
	 * @see #setPVexp(Exponent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_PVexp()
	 * @model dataType="org.opencim.cim.iec61970.domain.Exponent"
	 * @generated
	 */
	Exponent getPVexp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getPVexp <em>PVexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PVexp</em>' attribute.
	 * @see #getPVexp()
	 * @generated
	 */
	void setPVexp(Exponent value);

	/**
	 * Returns the value of the '<em><b>QFexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of per unit frequency effecting reactive power
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>QFexp</em>' attribute.
	 * @see #setQFexp(Exponent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_QFexp()
	 * @model dataType="org.opencim.cim.iec61970.domain.Exponent"
	 * @generated
	 */
	Exponent getQFexp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQFexp <em>QFexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>QFexp</em>' attribute.
	 * @see #getQFexp()
	 * @generated
	 */
	void setQFexp(Exponent value);

	/**
	 * Returns the value of the '<em><b>Qfixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reactive component of the load that is a fixed quantity, MVAr.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qfixed</em>' attribute.
	 * @see #setQfixed(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_Qfixed()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getQfixed();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixed <em>Qfixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qfixed</em>' attribute.
	 * @see #getQfixed()
	 * @generated
	 */
	void setQfixed(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Qfixed Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fixed MVAr as per cent of load group fixed MVAr
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qfixed Pct</em>' attribute.
	 * @see #setQfixedPct(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_QfixedPct()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getQfixedPct();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQfixedPct <em>Qfixed Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qfixed Pct</em>' attribute.
	 * @see #getQfixedPct()
	 * @generated
	 */
	void setQfixedPct(PerCent value);

	/**
	 * Returns the value of the '<em><b>Qnom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nominal value for reactive power, MVAr.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qnom</em>' attribute.
	 * @see #setQnom(ReactivePower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_Qnom()
	 * @model dataType="org.opencim.cim.iec61970.domain.ReactivePower"
	 * @generated
	 */
	ReactivePower getQnom();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQnom <em>Qnom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qnom</em>' attribute.
	 * @see #getQnom()
	 * @generated
	 */
	void setQnom(ReactivePower value);

	/**
	 * Returns the value of the '<em><b>Qnom Pct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nominal MVAr as per cent of load group nominal MVAr
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qnom Pct</em>' attribute.
	 * @see #setQnomPct(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_QnomPct()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getQnomPct();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQnomPct <em>Qnom Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qnom Pct</em>' attribute.
	 * @see #getQnomPct()
	 * @generated
	 */
	void setQnomPct(PerCent value);

	/**
	 * Returns the value of the '<em><b>QVexp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of per unit voltage effecting reactive power.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>QVexp</em>' attribute.
	 * @see #setQVexp(Exponent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getEnergyConsumer_QVexp()
	 * @model dataType="org.opencim.cim.iec61970.domain.Exponent"
	 * @generated
	 */
	Exponent getQVexp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.EnergyConsumer#getQVexp <em>QVexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>QVexp</em>' attribute.
	 * @see #getQVexp()
	 * @generated
	 */
	void setQVexp(Exponent value);

} // EnergyConsumer