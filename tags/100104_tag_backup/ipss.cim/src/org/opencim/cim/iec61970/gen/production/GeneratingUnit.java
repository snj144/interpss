/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratingUnit.java,v 1.3 2007/03/07 16:03:48 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.SubControlArea;

import org.opencim.cim.iec61970.domain.GeneratorControlMode;
import org.opencim.cim.iec61970.domain.GeneratorControlSource;
import org.opencim.cim.iec61970.domain.GeneratorOperatingMode;

import org.opencim.datatype.integer.Classification;
import org.opencim.datatype.integer.Priority;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.HeatPerHour;
import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.ParticipationFactor;
import org.opencim.datatype.real.PenaltyFactor;
import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.PowerROCPerMin;
import org.opencim.datatype.real.PowerROCPerSec;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generating Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A single or set of synchronous machines for converting mechanical power into alternating-current power. For example, individual machines within a set may be defined for scheduling purposes while a single control signal is derived for the set. In this case there would be a GeneratingUnit for each member of the set and an additional GeneratingUnit corresponding to the set.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlDeadband <em>Control Deadband</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseHigh <em>Control Pulse High</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseLow <em>Control Pulse Low</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlResponseRate <em>Control Response Rate</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEfficiency <em>Efficiency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlMode <em>Gen Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlSource <em>Gen Control Source</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorMPL <em>Governor MPL</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorSCD <em>Governor SCD</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getHighControlLimit <em>High Control Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getInitialMW <em>Initial MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowControlLimit <em>Low Control Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumAllowableSpinningReserve <em>Maximum Allowable Spinning Reserve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumEconomicMW <em>Maximum Economic MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumOperatingMW <em>Maximum Operating MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumEconomicMW <em>Minimum Economic MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOperatingMW <em>Minimum Operating MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getModelDetail <em>Model Detail</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMaxMW <em>Rated Gross Max MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMinMW <em>Rated Gross Min MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedNetMaxMW <em>Rated Net Max MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStartupTime <em>Startup Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAutoCntrlMarginMW <em>Auto Cntrl Margin MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAllocSpinResMW <em>Alloc Spin Res MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getBaseMW <em>Base MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getDispReserveFlag <em>Disp Reserve Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEnergyMinMW <em>Energy Min MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFastStartFlag <em>Fast Start Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFuelPriority <em>Fuel Priority</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenOperatingMode <em>Gen Operating Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLongPF <em>Long PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowerRampRate <em>Lower Ramp Rate</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getNormalPF <em>Normal PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getPenaltyFactor <em>Penalty Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRaiseRampRate <em>Raise Ramp Rate</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getShortPF <em>Short PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSpinReserveRamp <em>Spin Reserve Ramp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStepChange <em>Step Change</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getTieLinePF <em>Tie Line PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOffTime <em>Minimum Off Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpCostCurves <em>Gen Unit Op Cost Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpSchedule <em>Gen Unit Op Schedule</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGrossToNetMWCurves <em>Gross To Net MW Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSubControlArea <em>Sub Control Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSynchronousMachines <em>Synchronous Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit()
 * @generated
 */
public interface GeneratingUnit extends Equipment {
	/**
	 * Returns the value of the '<em><b>Control Deadband</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unit control error deadband. When a unit's desired MW change is less than this deadband, then no control pulses will be sent to the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control Deadband</em>' attribute.
	 * @see #setControlDeadband(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_ControlDeadband()
	 * @generated
	 */
	ActivePower getControlDeadband();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlDeadband <em>Control Deadband</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Deadband</em>' attribute.
	 * @see #getControlDeadband()
	 * @generated
	 */
	void setControlDeadband(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Control Pulse High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pulse high limit which is the largest control pulse that the unit can respond to
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control Pulse High</em>' attribute.
	 * @see #setControlPulseHigh(Seconds)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_ControlPulseHigh()
	 * @generated
	 */
	Seconds getControlPulseHigh();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseHigh <em>Control Pulse High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Pulse High</em>' attribute.
	 * @see #getControlPulseHigh()
	 * @generated
	 */
	void setControlPulseHigh(Seconds value);

	/**
	 * Returns the value of the '<em><b>Control Pulse Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pulse low limit which is the smallest control pulse that the unit can respond to
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control Pulse Low</em>' attribute.
	 * @see #setControlPulseLow(Seconds)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_ControlPulseLow()
	 * @generated
	 */
	Seconds getControlPulseLow();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlPulseLow <em>Control Pulse Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Pulse Low</em>' attribute.
	 * @see #getControlPulseLow()
	 * @generated
	 */
	void setControlPulseLow(Seconds value);

	/**
	 * Returns the value of the '<em><b>Control Response Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unit response rate which specifies the MW change for a control pulse of one second in the most responsive loading level of the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Control Response Rate</em>' attribute.
	 * @see #setControlResponseRate(PowerROCPerSec)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_ControlResponseRate()
	 * @generated
	 */
	PowerROCPerSec getControlResponseRate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getControlResponseRate <em>Control Response Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Response Rate</em>' attribute.
	 * @see #getControlResponseRate()
	 * @generated
	 */
	void setControlResponseRate(PowerROCPerSec value);

	/**
	 * Returns the value of the '<em><b>Efficiency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The efficiency of the unit in converting mechanical energy, from the prime mover, into electrical energy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Efficiency</em>' attribute.
	 * @see #setEfficiency(PU)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_Efficiency()
	 * @generated
	 */
	PU getEfficiency();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEfficiency <em>Efficiency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Efficiency</em>' attribute.
	 * @see #getEfficiency()
	 * @generated
	 */
	void setEfficiency(PU value);

	/**
	 * Returns the value of the '<em><b>Gen Control Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.GeneratorControlMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Select the unit control mode as Setpoint  (S) or Pulse (P).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gen Control Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlMode
	 * @see #setGenControlMode(GeneratorControlMode)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GenControlMode()
	 * @generated
	 */
	GeneratorControlMode getGenControlMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlMode <em>Gen Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Control Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlMode
	 * @see #getGenControlMode()
	 * @generated
	 */
	void setGenControlMode(GeneratorControlMode value);

	/**
	 * Returns the value of the '<em><b>Gen Control Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.GeneratorControlSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source of controls for a generating unit, i.e., Unavailable, Off-AGC, On-AGC, Plant Control
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gen Control Source</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlSource
	 * @see #setGenControlSource(GeneratorControlSource)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GenControlSource()
	 * @generated
	 */
	GeneratorControlSource getGenControlSource();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenControlSource <em>Gen Control Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Control Source</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.GeneratorControlSource
	 * @see #getGenControlSource()
	 * @generated
	 */
	void setGenControlSource(GeneratorControlSource value);

	/**
	 * Returns the value of the '<em><b>Governor MPL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Governor Motor Position Limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Governor MPL</em>' attribute.
	 * @see #setGovernorMPL(PU)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GovernorMPL()
	 * @generated
	 */
	PU getGovernorMPL();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorMPL <em>Governor MPL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Governor MPL</em>' attribute.
	 * @see #getGovernorMPL()
	 * @generated
	 */
	void setGovernorMPL(PU value);

	/**
	 * Returns the value of the '<em><b>Governor SCD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Governor Speed Changer Droop
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Governor SCD</em>' attribute.
	 * @see #setGovernorSCD(PerCent)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GovernorSCD()
	 * @generated
	 */
	PerCent getGovernorSCD();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGovernorSCD <em>Governor SCD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Governor SCD</em>' attribute.
	 * @see #getGovernorSCD()
	 * @generated
	 */
	void setGovernorSCD(PerCent value);

	/**
	 * Returns the value of the '<em><b>High Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * High limit for secondary (AGC) control
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>High Control Limit</em>' attribute.
	 * @see #setHighControlLimit(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_HighControlLimit()
	 * @generated
	 */
	ActivePower getHighControlLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getHighControlLimit <em>High Control Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Control Limit</em>' attribute.
	 * @see #getHighControlLimit()
	 * @generated
	 */
	void setHighControlLimit(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Initial MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default Initial MW  which is used to store a powerflow result for the initial MW for this unit in this network configuration
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initial MW</em>' attribute.
	 * @see #setInitialMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_InitialMW()
	 * @generated
	 */
	ActivePower getInitialMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getInitialMW <em>Initial MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial MW</em>' attribute.
	 * @see #getInitialMW()
	 * @generated
	 */
	void setInitialMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Low Control Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Low limit for secondary (AGC) control
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Low Control Limit</em>' attribute.
	 * @see #setLowControlLimit(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_LowControlLimit()
	 * @generated
	 */
	ActivePower getLowControlLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowControlLimit <em>Low Control Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low Control Limit</em>' attribute.
	 * @see #getLowControlLimit()
	 * @generated
	 */
	void setLowControlLimit(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Maximum Allowable Spinning Reserve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum allowable spinning reserve. Spinning reserve will never be considered greater than this value regardless of the current operating point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum Allowable Spinning Reserve</em>' attribute.
	 * @see #setMaximumAllowableSpinningReserve(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_MaximumAllowableSpinningReserve()
	 * @generated
	 */
	ActivePower getMaximumAllowableSpinningReserve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumAllowableSpinningReserve <em>Maximum Allowable Spinning Reserve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Allowable Spinning Reserve</em>' attribute.
	 * @see #getMaximumAllowableSpinningReserve()
	 * @generated
	 */
	void setMaximumAllowableSpinningReserve(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Maximum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum high economic MW limit, that should not exceed the maximum operating MW limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum Economic MW</em>' attribute.
	 * @see #setMaximumEconomicMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_MaximumEconomicMW()
	 * @generated
	 */
	ActivePower getMaximumEconomicMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumEconomicMW <em>Maximum Economic MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Economic MW</em>' attribute.
	 * @see #getMaximumEconomicMW()
	 * @generated
	 */
	void setMaximumEconomicMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Maximum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the maximum operating MW limit the dispatcher can enter for this unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum Operating MW</em>' attribute.
	 * @see #setMaximumOperatingMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_MaximumOperatingMW()
	 * @generated
	 */
	ActivePower getMaximumOperatingMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMaximumOperatingMW <em>Maximum Operating MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Operating MW</em>' attribute.
	 * @see #getMaximumOperatingMW()
	 * @generated
	 */
	void setMaximumOperatingMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Minimum Economic MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Low economic MW limit that must be greater than or equal to the minimum operating MW limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Economic MW</em>' attribute.
	 * @see #setMinimumEconomicMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_MinimumEconomicMW()
	 * @generated
	 */
	ActivePower getMinimumEconomicMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumEconomicMW <em>Minimum Economic MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Economic MW</em>' attribute.
	 * @see #getMinimumEconomicMW()
	 * @generated
	 */
	void setMinimumEconomicMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Minimum Operating MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the minimum operating MW limit the dispatcher can enter for this unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Operating MW</em>' attribute.
	 * @see #setMinimumOperatingMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_MinimumOperatingMW()
	 * @generated
	 */
	ActivePower getMinimumOperatingMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOperatingMW <em>Minimum Operating MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Operating MW</em>' attribute.
	 * @see #getMinimumOperatingMW()
	 * @generated
	 */
	void setMinimumOperatingMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Model Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Detail level of the generator model data
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Detail</em>' attribute.
	 * @see #setModelDetail(Classification)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_ModelDetail()
	 * @generated
	 */
	Classification getModelDetail();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getModelDetail <em>Model Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Detail</em>' attribute.
	 * @see #getModelDetail()
	 * @generated
	 */
	void setModelDetail(Classification value);

	/**
	 * Returns the value of the '<em><b>Rated Gross Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit's gross rated maximum capacity (Book Value).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated Gross Max MW</em>' attribute.
	 * @see #setRatedGrossMaxMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_RatedGrossMaxMW()
	 * @generated
	 */
	ActivePower getRatedGrossMaxMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMaxMW <em>Rated Gross Max MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated Gross Max MW</em>' attribute.
	 * @see #getRatedGrossMaxMW()
	 * @generated
	 */
	void setRatedGrossMaxMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Rated Gross Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The gross rated minimum generation level which the unit can safely operate at while delivering power to the transmission grid
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated Gross Min MW</em>' attribute.
	 * @see #setRatedGrossMinMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_RatedGrossMinMW()
	 * @generated
	 */
	ActivePower getRatedGrossMinMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedGrossMinMW <em>Rated Gross Min MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated Gross Min MW</em>' attribute.
	 * @see #getRatedGrossMinMW()
	 * @generated
	 */
	void setRatedGrossMinMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Rated Net Max MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The net rated maximum capacity determined by subtracting the auxiliary power used to operate the internal plant machinery from the rated gross maximum capacity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated Net Max MW</em>' attribute.
	 * @see #setRatedNetMaxMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_RatedNetMaxMW()
	 * @generated
	 */
	ActivePower getRatedNetMaxMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRatedNetMaxMW <em>Rated Net Max MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated Net Max MW</em>' attribute.
	 * @see #getRatedNetMaxMW()
	 * @generated
	 */
	void setRatedNetMaxMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Startup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time it takes to get the unit on-line, from the time that the prime mover mechanical power is applied
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Startup Time</em>' attribute.
	 * @see #setStartupTime(Seconds)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_StartupTime()
	 * @generated
	 */
	Seconds getStartupTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStartupTime <em>Startup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Time</em>' attribute.
	 * @see #getStartupTime()
	 * @generated
	 */
	void setStartupTime(Seconds value);

	/**
	 * Returns the value of the '<em><b>Auto Cntrl Margin MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The planned unused capacity which can be used to support automatic control overruns, in MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Auto Cntrl Margin MW</em>' attribute.
	 * @see #setAutoCntrlMarginMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_AutoCntrlMarginMW()
	 * @generated
	 */
	ActivePower getAutoCntrlMarginMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAutoCntrlMarginMW <em>Auto Cntrl Margin MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Cntrl Margin MW</em>' attribute.
	 * @see #getAutoCntrlMarginMW()
	 * @generated
	 */
	void setAutoCntrlMarginMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Alloc Spin Res MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The planned unused capacity (spinning reserve) which can be used to support emergency load
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alloc Spin Res MW</em>' attribute.
	 * @see #setAllocSpinResMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_AllocSpinResMW()
	 * @generated
	 */
	ActivePower getAllocSpinResMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getAllocSpinResMW <em>Alloc Spin Res MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alloc Spin Res MW</em>' attribute.
	 * @see #getAllocSpinResMW()
	 * @generated
	 */
	void setAllocSpinResMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Base MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For dispatchable units, this value represents the economic MW basepoint, for units that are not dispatchable, this value represents the fixed generation value. The value must be between the operating low and high limits.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base MW</em>' attribute.
	 * @see #setBaseMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_BaseMW()
	 * @generated
	 */
	ActivePower getBaseMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getBaseMW <em>Base MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base MW</em>' attribute.
	 * @see #getBaseMW()
	 * @generated
	 */
	void setBaseMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Disp Reserve Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disp Reserve Flag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disp Reserve Flag</em>' attribute.
	 * @see #setDispReserveFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_DispReserveFlag()
	 * @generated
	 */
	Boolean getDispReserveFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getDispReserveFlag <em>Disp Reserve Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disp Reserve Flag</em>' attribute.
	 * @see #getDispReserveFlag()
	 * @generated
	 */
	void setDispReserveFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Energy Min MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Energy Min MW</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Energy Min MW</em>' attribute.
	 * @see #setEnergyMinMW(HeatPerHour)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_EnergyMinMW()
	 * @generated
	 */
	HeatPerHour getEnergyMinMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getEnergyMinMW <em>Energy Min MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Min MW</em>' attribute.
	 * @see #getEnergyMinMW()
	 * @generated
	 */
	void setEnergyMinMW(HeatPerHour value);

	/**
	 * Returns the value of the '<em><b>Fast Start Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fast Start Flag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fast Start Flag</em>' attribute.
	 * @see #setFastStartFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_FastStartFlag()
	 * @generated
	 */
	Boolean getFastStartFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFastStartFlag <em>Fast Start Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fast Start Flag</em>' attribute.
	 * @see #getFastStartFlag()
	 * @generated
	 */
	void setFastStartFlag(Boolean value);

	/**
	 * Returns the value of the '<em><b>Fuel Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fuel Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuel Priority</em>' attribute.
	 * @see #setFuelPriority(Priority)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_FuelPriority()
	 * @generated
	 */
	Priority getFuelPriority();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getFuelPriority <em>Fuel Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuel Priority</em>' attribute.
	 * @see #getFuelPriority()
	 * @generated
	 */
	void setFuelPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Gen Operating Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.GeneratorOperatingMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operating mode for secondary control, e.g.: Off, Manual, Fixed, LFC, AGC, EDC, RPN, MRN, or REG
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gen Operating Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.GeneratorOperatingMode
	 * @see #setGenOperatingMode(GeneratorOperatingMode)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GenOperatingMode()
	 * @generated
	 */
	GeneratorOperatingMode getGenOperatingMode();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenOperatingMode <em>Gen Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Operating Mode</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.GeneratorOperatingMode
	 * @see #getGenOperatingMode()
	 * @generated
	 */
	void setGenOperatingMode(GeneratorOperatingMode value);

	/**
	 * Returns the value of the '<em><b>Long PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long PF</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long PF</em>' attribute.
	 * @see #setLongPF(ParticipationFactor)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_LongPF()
	 * @generated
	 */
	ParticipationFactor getLongPF();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLongPF <em>Long PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long PF</em>' attribute.
	 * @see #getLongPF()
	 * @generated
	 */
	void setLongPF(ParticipationFactor value);

	/**
	 * Returns the value of the '<em><b>Lower Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Ramp Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Ramp Rate</em>' attribute.
	 * @see #setLowerRampRate(PowerROCPerMin)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_LowerRampRate()
	 * @generated
	 */
	PowerROCPerMin getLowerRampRate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getLowerRampRate <em>Lower Ramp Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Ramp Rate</em>' attribute.
	 * @see #getLowerRampRate()
	 * @generated
	 */
	void setLowerRampRate(PowerROCPerMin value);

	/**
	 * Returns the value of the '<em><b>Normal PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normal PF</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normal PF</em>' attribute.
	 * @see #setNormalPF(ParticipationFactor)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_NormalPF()
	 * @generated
	 */
	ParticipationFactor getNormalPF();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getNormalPF <em>Normal PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal PF</em>' attribute.
	 * @see #getNormalPF()
	 * @generated
	 */
	void setNormalPF(ParticipationFactor value);

	/**
	 * Returns the value of the '<em><b>Penalty Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Penalty Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Penalty Factor</em>' attribute.
	 * @see #setPenaltyFactor(PenaltyFactor)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_PenaltyFactor()
	 * @generated
	 */
	PenaltyFactor getPenaltyFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getPenaltyFactor <em>Penalty Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penalty Factor</em>' attribute.
	 * @see #getPenaltyFactor()
	 * @generated
	 */
	void setPenaltyFactor(PenaltyFactor value);

	/**
	 * Returns the value of the '<em><b>Raise Ramp Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raise Ramp Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raise Ramp Rate</em>' attribute.
	 * @see #setRaiseRampRate(PowerROCPerMin)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_RaiseRampRate()
	 * @generated
	 */
	PowerROCPerMin getRaiseRampRate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getRaiseRampRate <em>Raise Ramp Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raise Ramp Rate</em>' attribute.
	 * @see #getRaiseRampRate()
	 * @generated
	 */
	void setRaiseRampRate(PowerROCPerMin value);

	/**
	 * Returns the value of the '<em><b>Short PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short PF</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short PF</em>' attribute.
	 * @see #setShortPF(ParticipationFactor)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_ShortPF()
	 * @generated
	 */
	ParticipationFactor getShortPF();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getShortPF <em>Short PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short PF</em>' attribute.
	 * @see #getShortPF()
	 * @generated
	 */
	void setShortPF(ParticipationFactor value);

	/**
	 * Returns the value of the '<em><b>Spin Reserve Ramp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spin Reserve Ramp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spin Reserve Ramp</em>' attribute.
	 * @see #setSpinReserveRamp(PowerROCPerMin)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_SpinReserveRamp()
	 * @generated
	 */
	PowerROCPerMin getSpinReserveRamp();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSpinReserveRamp <em>Spin Reserve Ramp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spin Reserve Ramp</em>' attribute.
	 * @see #getSpinReserveRamp()
	 * @generated
	 */
	void setSpinReserveRamp(PowerROCPerMin value);

	/**
	 * Returns the value of the '<em><b>Step Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Change</em>' attribute.
	 * @see #setStepChange(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_StepChange()
	 * @generated
	 */
	ActivePower getStepChange();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getStepChange <em>Step Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Change</em>' attribute.
	 * @see #getStepChange()
	 * @generated
	 */
	void setStepChange(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Tie Line PF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tie Line PF</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tie Line PF</em>' attribute.
	 * @see #setTieLinePF(ParticipationFactor)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_TieLinePF()
	 * @generated
	 */
	ParticipationFactor getTieLinePF();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getTieLinePF <em>Tie Line PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tie Line PF</em>' attribute.
	 * @see #getTieLinePF()
	 * @generated
	 */
	void setTieLinePF(ParticipationFactor value);

	/**
	 * Returns the value of the '<em><b>Minimum Off Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Minimum time interval between unit shutdown and startup
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Off Time</em>' attribute.
	 * @see #setMinimumOffTime(Seconds)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_MinimumOffTime()
	 * @generated
	 */
	Seconds getMinimumOffTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getMinimumOffTime <em>Minimum Off Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Off Time</em>' attribute.
	 * @see #getMinimumOffTime()
	 * @generated
	 */
	void setMinimumOffTime(Seconds value);

	/**
	 * Returns the value of the '<em><b>Gen Unit Op Cost Curves</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A generating unit may have one or more cost curves, depending upon fuel mixture and fuel cost.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gen Unit Op Cost Curves</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GenUnitOpCostCurves()
	 * @generated
	 */
	EList getGenUnitOpCostCurves();

	/**
	 * Returns the value of the '<em><b>Gen Unit Op Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A generating unit may have an operating schedule, indicating the planned operation of the unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gen Unit Op Schedule</em>' containment reference.
	 * @see #setGenUnitOpSchedule(GenUnitOpSchedule)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GenUnitOpSchedule()
	 * @generated
	 */
	GenUnitOpSchedule getGenUnitOpSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getGenUnitOpSchedule <em>Gen Unit Op Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Unit Op Schedule</em>' containment reference.
	 * @see #getGenUnitOpSchedule()
	 * @generated
	 */
	void setGenUnitOpSchedule(GenUnitOpSchedule value);

	/**
	 * Returns the value of the '<em><b>Gross To Net MW Curves</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A generating unit may have a gross MW to net MW curve, describing the losses and auxiliary power requirements of the unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gross To Net MW Curves</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_GrossToNetMWCurves()
	 * @generated
	 */
	EList getGrossToNetMWCurves();

	/**
	 * Returns the value of the '<em><b>Sub Control Area</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.SubControlArea#getGeneratingUnits <em>Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A GeneratingUnit injects energy into a SubControlArea.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Control Area</em>' reference.
	 * @see #setSubControlArea(SubControlArea)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_SubControlArea()
	 * @see org.opencim.cim.iec61970.core.SubControlArea#getGeneratingUnits
	 * @generated
	 */
	SubControlArea getSubControlArea();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSubControlArea <em>Sub Control Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Control Area</em>' reference.
	 * @see #getSubControlArea()
	 * @generated
	 */
	void setSubControlArea(SubControlArea value);

	/**
	 * Returns the value of the '<em><b>Synchronous Machines</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.SynchronousMachine}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getGeneratingUnit <em>Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A synchronous machine may operate as a generator and as such becomes a member of a generating unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Synchronous Machines</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getGeneratingUnit_SynchronousMachines()
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getGeneratingUnit
	 * @generated
	 */
	EList getSynchronousMachines();

} // GeneratingUnit