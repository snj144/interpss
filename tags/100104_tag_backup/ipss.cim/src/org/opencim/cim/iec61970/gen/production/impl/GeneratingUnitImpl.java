/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneratingUnitImpl.java,v 1.3 2007/03/07 16:03:49 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.SubControlArea;

import org.opencim.cim.iec61970.core.impl.CorePackageImpl;
import org.opencim.cim.iec61970.core.impl.EquipmentImpl;

import org.opencim.cim.iec61970.domain.GeneratorControlMode;
import org.opencim.cim.iec61970.domain.GeneratorControlSource;
import org.opencim.cim.iec61970.domain.GeneratorOperatingMode;

import org.opencim.cim.iec61970.gen.production.GenUnitOpCostCurve;
import org.opencim.cim.iec61970.gen.production.GenUnitOpSchedule;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.gen.production.GrossToNetMWCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

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
 * An implementation of the model object '<em><b>Generating Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getControlDeadband <em>Control Deadband</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getControlPulseHigh <em>Control Pulse High</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getControlPulseLow <em>Control Pulse Low</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getControlResponseRate <em>Control Response Rate</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getEfficiency <em>Efficiency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGenControlMode <em>Gen Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGenControlSource <em>Gen Control Source</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGovernorMPL <em>Governor MPL</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGovernorSCD <em>Governor SCD</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getHighControlLimit <em>High Control Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getInitialMW <em>Initial MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getLowControlLimit <em>Low Control Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getMaximumAllowableSpinningReserve <em>Maximum Allowable Spinning Reserve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getMaximumEconomicMW <em>Maximum Economic MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getMaximumOperatingMW <em>Maximum Operating MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getMinimumEconomicMW <em>Minimum Economic MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getMinimumOperatingMW <em>Minimum Operating MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getModelDetail <em>Model Detail</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getRatedGrossMaxMW <em>Rated Gross Max MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getRatedGrossMinMW <em>Rated Gross Min MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getRatedNetMaxMW <em>Rated Net Max MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getStartupTime <em>Startup Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getAutoCntrlMarginMW <em>Auto Cntrl Margin MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getAllocSpinResMW <em>Alloc Spin Res MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getBaseMW <em>Base MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getDispReserveFlag <em>Disp Reserve Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getEnergyMinMW <em>Energy Min MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getFastStartFlag <em>Fast Start Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getFuelPriority <em>Fuel Priority</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGenOperatingMode <em>Gen Operating Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getLongPF <em>Long PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getLowerRampRate <em>Lower Ramp Rate</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getNormalPF <em>Normal PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getPenaltyFactor <em>Penalty Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getRaiseRampRate <em>Raise Ramp Rate</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getShortPF <em>Short PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getSpinReserveRamp <em>Spin Reserve Ramp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getStepChange <em>Step Change</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getTieLinePF <em>Tie Line PF</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getMinimumOffTime <em>Minimum Off Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGenUnitOpCostCurves <em>Gen Unit Op Cost Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGenUnitOpSchedule <em>Gen Unit Op Schedule</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getGrossToNetMWCurves <em>Gross To Net MW Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getSubControlArea <em>Sub Control Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.GeneratingUnitImpl#getSynchronousMachines <em>Synchronous Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratingUnitImpl extends EquipmentImpl implements GeneratingUnit {
	/**
	 * The default value of the '{@link #getControlDeadband() <em>Control Deadband</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlDeadband()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower CONTROL_DEADBAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlDeadband() <em>Control Deadband</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlDeadband()
	 * @generated
	 * @ordered
	 */
	protected ActivePower controlDeadband = CONTROL_DEADBAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlPulseHigh() <em>Control Pulse High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPulseHigh()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds CONTROL_PULSE_HIGH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlPulseHigh() <em>Control Pulse High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPulseHigh()
	 * @generated
	 * @ordered
	 */
	protected Seconds controlPulseHigh = CONTROL_PULSE_HIGH_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlPulseLow() <em>Control Pulse Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPulseLow()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds CONTROL_PULSE_LOW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlPulseLow() <em>Control Pulse Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlPulseLow()
	 * @generated
	 * @ordered
	 */
	protected Seconds controlPulseLow = CONTROL_PULSE_LOW_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlResponseRate() <em>Control Response Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlResponseRate()
	 * @generated
	 * @ordered
	 */
	protected static final PowerROCPerSec CONTROL_RESPONSE_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlResponseRate() <em>Control Response Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlResponseRate()
	 * @generated
	 * @ordered
	 */
	protected PowerROCPerSec controlResponseRate = CONTROL_RESPONSE_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEfficiency() <em>Efficiency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEfficiency()
	 * @generated
	 * @ordered
	 */
	protected static final PU EFFICIENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEfficiency() <em>Efficiency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEfficiency()
	 * @generated
	 * @ordered
	 */
	protected PU efficiency = EFFICIENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenControlMode() <em>Gen Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenControlMode()
	 * @generated
	 * @ordered
	 */
	protected static final GeneratorControlMode GEN_CONTROL_MODE_EDEFAULT = GeneratorControlMode.SETPOINT_LITERAL;

	/**
	 * The cached value of the '{@link #getGenControlMode() <em>Gen Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenControlMode()
	 * @generated
	 * @ordered
	 */
	protected GeneratorControlMode genControlMode = GEN_CONTROL_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenControlSource() <em>Gen Control Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenControlSource()
	 * @generated
	 * @ordered
	 */
	protected static final GeneratorControlSource GEN_CONTROL_SOURCE_EDEFAULT = GeneratorControlSource.UNAVAILABLE_LITERAL;

	/**
	 * The cached value of the '{@link #getGenControlSource() <em>Gen Control Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenControlSource()
	 * @generated
	 * @ordered
	 */
	protected GeneratorControlSource genControlSource = GEN_CONTROL_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGovernorMPL() <em>Governor MPL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernorMPL()
	 * @generated
	 * @ordered
	 */
	protected static final PU GOVERNOR_MPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGovernorMPL() <em>Governor MPL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernorMPL()
	 * @generated
	 * @ordered
	 */
	protected PU governorMPL = GOVERNOR_MPL_EDEFAULT;

	/**
	 * The default value of the '{@link #getGovernorSCD() <em>Governor SCD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernorSCD()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent GOVERNOR_SCD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGovernorSCD() <em>Governor SCD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernorSCD()
	 * @generated
	 * @ordered
	 */
	protected PerCent governorSCD = GOVERNOR_SCD_EDEFAULT;

	/**
	 * The default value of the '{@link #getHighControlLimit() <em>High Control Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighControlLimit()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower HIGH_CONTROL_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHighControlLimit() <em>High Control Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighControlLimit()
	 * @generated
	 * @ordered
	 */
	protected ActivePower highControlLimit = HIGH_CONTROL_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialMW() <em>Initial MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower INITIAL_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialMW() <em>Initial MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower initialMW = INITIAL_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowControlLimit() <em>Low Control Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowControlLimit()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower LOW_CONTROL_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowControlLimit() <em>Low Control Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowControlLimit()
	 * @generated
	 * @ordered
	 */
	protected ActivePower lowControlLimit = LOW_CONTROL_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumAllowableSpinningReserve() <em>Maximum Allowable Spinning Reserve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumAllowableSpinningReserve()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MAXIMUM_ALLOWABLE_SPINNING_RESERVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumAllowableSpinningReserve() <em>Maximum Allowable Spinning Reserve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumAllowableSpinningReserve()
	 * @generated
	 * @ordered
	 */
	protected ActivePower maximumAllowableSpinningReserve = MAXIMUM_ALLOWABLE_SPINNING_RESERVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumEconomicMW() <em>Maximum Economic MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumEconomicMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MAXIMUM_ECONOMIC_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumEconomicMW() <em>Maximum Economic MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumEconomicMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower maximumEconomicMW = MAXIMUM_ECONOMIC_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumOperatingMW() <em>Maximum Operating MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumOperatingMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MAXIMUM_OPERATING_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumOperatingMW() <em>Maximum Operating MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumOperatingMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower maximumOperatingMW = MAXIMUM_OPERATING_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumEconomicMW() <em>Minimum Economic MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumEconomicMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MINIMUM_ECONOMIC_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumEconomicMW() <em>Minimum Economic MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumEconomicMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower minimumEconomicMW = MINIMUM_ECONOMIC_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumOperatingMW() <em>Minimum Operating MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumOperatingMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MINIMUM_OPERATING_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumOperatingMW() <em>Minimum Operating MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumOperatingMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower minimumOperatingMW = MINIMUM_OPERATING_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelDetail() <em>Model Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDetail()
	 * @generated
	 * @ordered
	 */
	protected static final Classification MODEL_DETAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelDetail() <em>Model Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDetail()
	 * @generated
	 * @ordered
	 */
	protected Classification modelDetail = MODEL_DETAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRatedGrossMaxMW() <em>Rated Gross Max MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedGrossMaxMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower RATED_GROSS_MAX_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedGrossMaxMW() <em>Rated Gross Max MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedGrossMaxMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower ratedGrossMaxMW = RATED_GROSS_MAX_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getRatedGrossMinMW() <em>Rated Gross Min MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedGrossMinMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower RATED_GROSS_MIN_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedGrossMinMW() <em>Rated Gross Min MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedGrossMinMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower ratedGrossMinMW = RATED_GROSS_MIN_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getRatedNetMaxMW() <em>Rated Net Max MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedNetMaxMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower RATED_NET_MAX_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedNetMaxMW() <em>Rated Net Max MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedNetMaxMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower ratedNetMaxMW = RATED_NET_MAX_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartupTime() <em>Startup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupTime()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds STARTUP_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartupTime() <em>Startup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartupTime()
	 * @generated
	 * @ordered
	 */
	protected Seconds startupTime = STARTUP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoCntrlMarginMW() <em>Auto Cntrl Margin MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoCntrlMarginMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower AUTO_CNTRL_MARGIN_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoCntrlMarginMW() <em>Auto Cntrl Margin MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoCntrlMarginMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower autoCntrlMarginMW = AUTO_CNTRL_MARGIN_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllocSpinResMW() <em>Alloc Spin Res MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocSpinResMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower ALLOC_SPIN_RES_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAllocSpinResMW() <em>Alloc Spin Res MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocSpinResMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower allocSpinResMW = ALLOC_SPIN_RES_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseMW() <em>Base MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower BASE_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseMW() <em>Base MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower baseMW = BASE_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getDispReserveFlag() <em>Disp Reserve Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispReserveFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean DISP_RESERVE_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDispReserveFlag() <em>Disp Reserve Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispReserveFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean dispReserveFlag = DISP_RESERVE_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnergyMinMW() <em>Energy Min MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyMinMW()
	 * @generated
	 * @ordered
	 */
	protected static final HeatPerHour ENERGY_MIN_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnergyMinMW() <em>Energy Min MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyMinMW()
	 * @generated
	 * @ordered
	 */
	protected HeatPerHour energyMinMW = ENERGY_MIN_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getFastStartFlag() <em>Fast Start Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFastStartFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean FAST_START_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFastStartFlag() <em>Fast Start Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFastStartFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean fastStartFlag = FAST_START_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelPriority() <em>Fuel Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Priority FUEL_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelPriority() <em>Fuel Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelPriority()
	 * @generated
	 * @ordered
	 */
	protected Priority fuelPriority = FUEL_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenOperatingMode() <em>Gen Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected static final GeneratorOperatingMode GEN_OPERATING_MODE_EDEFAULT = GeneratorOperatingMode.OFF_LITERAL;

	/**
	 * The cached value of the '{@link #getGenOperatingMode() <em>Gen Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected GeneratorOperatingMode genOperatingMode = GEN_OPERATING_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongPF() <em>Long PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongPF()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipationFactor LONG_PF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongPF() <em>Long PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongPF()
	 * @generated
	 * @ordered
	 */
	protected ParticipationFactor longPF = LONG_PF_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerRampRate() <em>Lower Ramp Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerRampRate()
	 * @generated
	 * @ordered
	 */
	protected static final PowerROCPerMin LOWER_RAMP_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowerRampRate() <em>Lower Ramp Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerRampRate()
	 * @generated
	 * @ordered
	 */
	protected PowerROCPerMin lowerRampRate = LOWER_RAMP_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalPF() <em>Normal PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalPF()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipationFactor NORMAL_PF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNormalPF() <em>Normal PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalPF()
	 * @generated
	 * @ordered
	 */
	protected ParticipationFactor normalPF = NORMAL_PF_EDEFAULT;

	/**
	 * The default value of the '{@link #getPenaltyFactor() <em>Penalty Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenaltyFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PenaltyFactor PENALTY_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPenaltyFactor() <em>Penalty Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenaltyFactor()
	 * @generated
	 * @ordered
	 */
	protected PenaltyFactor penaltyFactor = PENALTY_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getRaiseRampRate() <em>Raise Ramp Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaiseRampRate()
	 * @generated
	 * @ordered
	 */
	protected static final PowerROCPerMin RAISE_RAMP_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRaiseRampRate() <em>Raise Ramp Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaiseRampRate()
	 * @generated
	 * @ordered
	 */
	protected PowerROCPerMin raiseRampRate = RAISE_RAMP_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShortPF() <em>Short PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortPF()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipationFactor SHORT_PF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortPF() <em>Short PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortPF()
	 * @generated
	 * @ordered
	 */
	protected ParticipationFactor shortPF = SHORT_PF_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpinReserveRamp() <em>Spin Reserve Ramp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpinReserveRamp()
	 * @generated
	 * @ordered
	 */
	protected static final PowerROCPerMin SPIN_RESERVE_RAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpinReserveRamp() <em>Spin Reserve Ramp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpinReserveRamp()
	 * @generated
	 * @ordered
	 */
	protected PowerROCPerMin spinReserveRamp = SPIN_RESERVE_RAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepChange() <em>Step Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepChange()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower STEP_CHANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStepChange() <em>Step Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepChange()
	 * @generated
	 * @ordered
	 */
	protected ActivePower stepChange = STEP_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTieLinePF() <em>Tie Line PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTieLinePF()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipationFactor TIE_LINE_PF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTieLinePF() <em>Tie Line PF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTieLinePF()
	 * @generated
	 * @ordered
	 */
	protected ParticipationFactor tieLinePF = TIE_LINE_PF_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumOffTime() <em>Minimum Off Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumOffTime()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds MINIMUM_OFF_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumOffTime() <em>Minimum Off Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumOffTime()
	 * @generated
	 * @ordered
	 */
	protected Seconds minimumOffTime = MINIMUM_OFF_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenUnitOpCostCurves() <em>Gen Unit Op Cost Curves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenUnitOpCostCurves()
	 * @generated
	 * @ordered
	 */
	protected EList genUnitOpCostCurves;

	/**
	 * The cached value of the '{@link #getGenUnitOpSchedule() <em>Gen Unit Op Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenUnitOpSchedule()
	 * @generated
	 * @ordered
	 */
	protected GenUnitOpSchedule genUnitOpSchedule;

	/**
	 * The cached value of the '{@link #getGrossToNetMWCurves() <em>Gross To Net MW Curves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrossToNetMWCurves()
	 * @generated
	 * @ordered
	 */
	protected EList grossToNetMWCurves;

	/**
	 * The cached value of the '{@link #getSubControlArea() <em>Sub Control Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubControlArea()
	 * @generated
	 * @ordered
	 */
	protected SubControlArea subControlArea;

	/**
	 * The cached value of the '{@link #getSynchronousMachines() <em>Synchronous Machines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronousMachines()
	 * @generated
	 * @ordered
	 */
	protected EList synchronousMachines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratingUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.GENERATING_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getControlDeadband() {
		return controlDeadband;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlDeadband(ActivePower newControlDeadband) {
		ActivePower oldControlDeadband = controlDeadband;
		controlDeadband = newControlDeadband;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__CONTROL_DEADBAND, oldControlDeadband, controlDeadband));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getControlPulseHigh() {
		return controlPulseHigh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlPulseHigh(Seconds newControlPulseHigh) {
		Seconds oldControlPulseHigh = controlPulseHigh;
		controlPulseHigh = newControlPulseHigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_HIGH, oldControlPulseHigh, controlPulseHigh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getControlPulseLow() {
		return controlPulseLow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlPulseLow(Seconds newControlPulseLow) {
		Seconds oldControlPulseLow = controlPulseLow;
		controlPulseLow = newControlPulseLow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_LOW, oldControlPulseLow, controlPulseLow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerSec getControlResponseRate() {
		return controlResponseRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlResponseRate(PowerROCPerSec newControlResponseRate) {
		PowerROCPerSec oldControlResponseRate = controlResponseRate;
		controlResponseRate = newControlResponseRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__CONTROL_RESPONSE_RATE, oldControlResponseRate, controlResponseRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getEfficiency() {
		return efficiency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEfficiency(PU newEfficiency) {
		PU oldEfficiency = efficiency;
		efficiency = newEfficiency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__EFFICIENCY, oldEfficiency, efficiency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorControlMode getGenControlMode() {
		return genControlMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenControlMode(GeneratorControlMode newGenControlMode) {
		GeneratorControlMode oldGenControlMode = genControlMode;
		genControlMode = newGenControlMode == null ? GEN_CONTROL_MODE_EDEFAULT : newGenControlMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GEN_CONTROL_MODE, oldGenControlMode, genControlMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorControlSource getGenControlSource() {
		return genControlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenControlSource(GeneratorControlSource newGenControlSource) {
		GeneratorControlSource oldGenControlSource = genControlSource;
		genControlSource = newGenControlSource == null ? GEN_CONTROL_SOURCE_EDEFAULT : newGenControlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GEN_CONTROL_SOURCE, oldGenControlSource, genControlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getGovernorMPL() {
		return governorMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGovernorMPL(PU newGovernorMPL) {
		PU oldGovernorMPL = governorMPL;
		governorMPL = newGovernorMPL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GOVERNOR_MPL, oldGovernorMPL, governorMPL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getGovernorSCD() {
		return governorSCD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGovernorSCD(PerCent newGovernorSCD) {
		PerCent oldGovernorSCD = governorSCD;
		governorSCD = newGovernorSCD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GOVERNOR_SCD, oldGovernorSCD, governorSCD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getHighControlLimit() {
		return highControlLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighControlLimit(ActivePower newHighControlLimit) {
		ActivePower oldHighControlLimit = highControlLimit;
		highControlLimit = newHighControlLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__HIGH_CONTROL_LIMIT, oldHighControlLimit, highControlLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getInitialMW() {
		return initialMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialMW(ActivePower newInitialMW) {
		ActivePower oldInitialMW = initialMW;
		initialMW = newInitialMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__INITIAL_MW, oldInitialMW, initialMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getLowControlLimit() {
		return lowControlLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowControlLimit(ActivePower newLowControlLimit) {
		ActivePower oldLowControlLimit = lowControlLimit;
		lowControlLimit = newLowControlLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__LOW_CONTROL_LIMIT, oldLowControlLimit, lowControlLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMaximumAllowableSpinningReserve() {
		return maximumAllowableSpinningReserve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumAllowableSpinningReserve(ActivePower newMaximumAllowableSpinningReserve) {
		ActivePower oldMaximumAllowableSpinningReserve = maximumAllowableSpinningReserve;
		maximumAllowableSpinningReserve = newMaximumAllowableSpinningReserve;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE, oldMaximumAllowableSpinningReserve, maximumAllowableSpinningReserve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMaximumEconomicMW() {
		return maximumEconomicMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumEconomicMW(ActivePower newMaximumEconomicMW) {
		ActivePower oldMaximumEconomicMW = maximumEconomicMW;
		maximumEconomicMW = newMaximumEconomicMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MAXIMUM_ECONOMIC_MW, oldMaximumEconomicMW, maximumEconomicMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMaximumOperatingMW() {
		return maximumOperatingMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumOperatingMW(ActivePower newMaximumOperatingMW) {
		ActivePower oldMaximumOperatingMW = maximumOperatingMW;
		maximumOperatingMW = newMaximumOperatingMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MAXIMUM_OPERATING_MW, oldMaximumOperatingMW, maximumOperatingMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMinimumEconomicMW() {
		return minimumEconomicMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumEconomicMW(ActivePower newMinimumEconomicMW) {
		ActivePower oldMinimumEconomicMW = minimumEconomicMW;
		minimumEconomicMW = newMinimumEconomicMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MINIMUM_ECONOMIC_MW, oldMinimumEconomicMW, minimumEconomicMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMinimumOperatingMW() {
		return minimumOperatingMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumOperatingMW(ActivePower newMinimumOperatingMW) {
		ActivePower oldMinimumOperatingMW = minimumOperatingMW;
		minimumOperatingMW = newMinimumOperatingMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MINIMUM_OPERATING_MW, oldMinimumOperatingMW, minimumOperatingMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classification getModelDetail() {
		return modelDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelDetail(Classification newModelDetail) {
		Classification oldModelDetail = modelDetail;
		modelDetail = newModelDetail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MODEL_DETAIL, oldModelDetail, modelDetail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getRatedGrossMaxMW() {
		return ratedGrossMaxMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedGrossMaxMW(ActivePower newRatedGrossMaxMW) {
		ActivePower oldRatedGrossMaxMW = ratedGrossMaxMW;
		ratedGrossMaxMW = newRatedGrossMaxMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__RATED_GROSS_MAX_MW, oldRatedGrossMaxMW, ratedGrossMaxMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getRatedGrossMinMW() {
		return ratedGrossMinMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedGrossMinMW(ActivePower newRatedGrossMinMW) {
		ActivePower oldRatedGrossMinMW = ratedGrossMinMW;
		ratedGrossMinMW = newRatedGrossMinMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__RATED_GROSS_MIN_MW, oldRatedGrossMinMW, ratedGrossMinMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getRatedNetMaxMW() {
		return ratedNetMaxMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedNetMaxMW(ActivePower newRatedNetMaxMW) {
		ActivePower oldRatedNetMaxMW = ratedNetMaxMW;
		ratedNetMaxMW = newRatedNetMaxMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__RATED_NET_MAX_MW, oldRatedNetMaxMW, ratedNetMaxMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getStartupTime() {
		return startupTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupTime(Seconds newStartupTime) {
		Seconds oldStartupTime = startupTime;
		startupTime = newStartupTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__STARTUP_TIME, oldStartupTime, startupTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getAutoCntrlMarginMW() {
		return autoCntrlMarginMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoCntrlMarginMW(ActivePower newAutoCntrlMarginMW) {
		ActivePower oldAutoCntrlMarginMW = autoCntrlMarginMW;
		autoCntrlMarginMW = newAutoCntrlMarginMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW, oldAutoCntrlMarginMW, autoCntrlMarginMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getAllocSpinResMW() {
		return allocSpinResMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocSpinResMW(ActivePower newAllocSpinResMW) {
		ActivePower oldAllocSpinResMW = allocSpinResMW;
		allocSpinResMW = newAllocSpinResMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__ALLOC_SPIN_RES_MW, oldAllocSpinResMW, allocSpinResMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getBaseMW() {
		return baseMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseMW(ActivePower newBaseMW) {
		ActivePower oldBaseMW = baseMW;
		baseMW = newBaseMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__BASE_MW, oldBaseMW, baseMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getDispReserveFlag() {
		return dispReserveFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispReserveFlag(Boolean newDispReserveFlag) {
		Boolean oldDispReserveFlag = dispReserveFlag;
		dispReserveFlag = newDispReserveFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__DISP_RESERVE_FLAG, oldDispReserveFlag, dispReserveFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatPerHour getEnergyMinMW() {
		return energyMinMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyMinMW(HeatPerHour newEnergyMinMW) {
		HeatPerHour oldEnergyMinMW = energyMinMW;
		energyMinMW = newEnergyMinMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__ENERGY_MIN_MW, oldEnergyMinMW, energyMinMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getFastStartFlag() {
		return fastStartFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFastStartFlag(Boolean newFastStartFlag) {
		Boolean oldFastStartFlag = fastStartFlag;
		fastStartFlag = newFastStartFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__FAST_START_FLAG, oldFastStartFlag, fastStartFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority getFuelPriority() {
		return fuelPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelPriority(Priority newFuelPriority) {
		Priority oldFuelPriority = fuelPriority;
		fuelPriority = newFuelPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__FUEL_PRIORITY, oldFuelPriority, fuelPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorOperatingMode getGenOperatingMode() {
		return genOperatingMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenOperatingMode(GeneratorOperatingMode newGenOperatingMode) {
		GeneratorOperatingMode oldGenOperatingMode = genOperatingMode;
		genOperatingMode = newGenOperatingMode == null ? GEN_OPERATING_MODE_EDEFAULT : newGenOperatingMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GEN_OPERATING_MODE, oldGenOperatingMode, genOperatingMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationFactor getLongPF() {
		return longPF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongPF(ParticipationFactor newLongPF) {
		ParticipationFactor oldLongPF = longPF;
		longPF = newLongPF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__LONG_PF, oldLongPF, longPF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerMin getLowerRampRate() {
		return lowerRampRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerRampRate(PowerROCPerMin newLowerRampRate) {
		PowerROCPerMin oldLowerRampRate = lowerRampRate;
		lowerRampRate = newLowerRampRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__LOWER_RAMP_RATE, oldLowerRampRate, lowerRampRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationFactor getNormalPF() {
		return normalPF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalPF(ParticipationFactor newNormalPF) {
		ParticipationFactor oldNormalPF = normalPF;
		normalPF = newNormalPF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__NORMAL_PF, oldNormalPF, normalPF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PenaltyFactor getPenaltyFactor() {
		return penaltyFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPenaltyFactor(PenaltyFactor newPenaltyFactor) {
		PenaltyFactor oldPenaltyFactor = penaltyFactor;
		penaltyFactor = newPenaltyFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__PENALTY_FACTOR, oldPenaltyFactor, penaltyFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerMin getRaiseRampRate() {
		return raiseRampRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaiseRampRate(PowerROCPerMin newRaiseRampRate) {
		PowerROCPerMin oldRaiseRampRate = raiseRampRate;
		raiseRampRate = newRaiseRampRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__RAISE_RAMP_RATE, oldRaiseRampRate, raiseRampRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationFactor getShortPF() {
		return shortPF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortPF(ParticipationFactor newShortPF) {
		ParticipationFactor oldShortPF = shortPF;
		shortPF = newShortPF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__SHORT_PF, oldShortPF, shortPF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerROCPerMin getSpinReserveRamp() {
		return spinReserveRamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpinReserveRamp(PowerROCPerMin newSpinReserveRamp) {
		PowerROCPerMin oldSpinReserveRamp = spinReserveRamp;
		spinReserveRamp = newSpinReserveRamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__SPIN_RESERVE_RAMP, oldSpinReserveRamp, spinReserveRamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getStepChange() {
		return stepChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepChange(ActivePower newStepChange) {
		ActivePower oldStepChange = stepChange;
		stepChange = newStepChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__STEP_CHANGE, oldStepChange, stepChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationFactor getTieLinePF() {
		return tieLinePF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTieLinePF(ParticipationFactor newTieLinePF) {
		ParticipationFactor oldTieLinePF = tieLinePF;
		tieLinePF = newTieLinePF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__TIE_LINE_PF, oldTieLinePF, tieLinePF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getMinimumOffTime() {
		return minimumOffTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumOffTime(Seconds newMinimumOffTime) {
		Seconds oldMinimumOffTime = minimumOffTime;
		minimumOffTime = newMinimumOffTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__MINIMUM_OFF_TIME, oldMinimumOffTime, minimumOffTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGenUnitOpCostCurves() {
		if (genUnitOpCostCurves == null) {
			genUnitOpCostCurves = new EObjectContainmentEList(GenUnitOpCostCurve.class, this, ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES);
		}
		return genUnitOpCostCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenUnitOpSchedule getGenUnitOpSchedule() {
		return genUnitOpSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenUnitOpSchedule(GenUnitOpSchedule newGenUnitOpSchedule, NotificationChain msgs) {
		GenUnitOpSchedule oldGenUnitOpSchedule = genUnitOpSchedule;
		genUnitOpSchedule = newGenUnitOpSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE, oldGenUnitOpSchedule, newGenUnitOpSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenUnitOpSchedule(GenUnitOpSchedule newGenUnitOpSchedule) {
		if (newGenUnitOpSchedule != genUnitOpSchedule) {
			NotificationChain msgs = null;
			if (genUnitOpSchedule != null)
				msgs = ((InternalEObject)genUnitOpSchedule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE, null, msgs);
			if (newGenUnitOpSchedule != null)
				msgs = ((InternalEObject)newGenUnitOpSchedule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE, null, msgs);
			msgs = basicSetGenUnitOpSchedule(newGenUnitOpSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE, newGenUnitOpSchedule, newGenUnitOpSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGrossToNetMWCurves() {
		if (grossToNetMWCurves == null) {
			grossToNetMWCurves = new EObjectContainmentEList(GrossToNetMWCurve.class, this, ProductionPackage.GENERATING_UNIT__GROSS_TO_NET_MW_CURVES);
		}
		return grossToNetMWCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubControlArea getSubControlArea() {
		if (subControlArea != null && subControlArea.eIsProxy()) {
			InternalEObject oldSubControlArea = (InternalEObject)subControlArea;
			subControlArea = (SubControlArea)eResolveProxy(oldSubControlArea);
			if (subControlArea != oldSubControlArea) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA, oldSubControlArea, subControlArea));
			}
		}
		return subControlArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubControlArea basicGetSubControlArea() {
		return subControlArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubControlArea(SubControlArea newSubControlArea, NotificationChain msgs) {
		SubControlArea oldSubControlArea = subControlArea;
		subControlArea = newSubControlArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA, oldSubControlArea, newSubControlArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubControlArea(SubControlArea newSubControlArea) {
		if (newSubControlArea != subControlArea) {
			NotificationChain msgs = null;
			if (subControlArea != null)
				msgs = ((InternalEObject)subControlArea).eInverseRemove(this, CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS, SubControlArea.class, msgs);
			if (newSubControlArea != null)
				msgs = ((InternalEObject)newSubControlArea).eInverseAdd(this, CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS, SubControlArea.class, msgs);
			msgs = basicSetSubControlArea(newSubControlArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA, newSubControlArea, newSubControlArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSynchronousMachines() {
		if (synchronousMachines == null) {
			synchronousMachines = new EObjectWithInverseResolvingEList(SynchronousMachine.class, this, ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES, WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT);
		}
		return synchronousMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA:
				if (subControlArea != null)
					msgs = ((InternalEObject)subControlArea).eInverseRemove(this, CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS, SubControlArea.class, msgs);
				return basicSetSubControlArea((SubControlArea)otherEnd, msgs);
			case ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES:
				return ((InternalEList)getSynchronousMachines()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES:
				return ((InternalEList)getGenUnitOpCostCurves()).basicRemove(otherEnd, msgs);
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE:
				return basicSetGenUnitOpSchedule(null, msgs);
			case ProductionPackage.GENERATING_UNIT__GROSS_TO_NET_MW_CURVES:
				return ((InternalEList)getGrossToNetMWCurves()).basicRemove(otherEnd, msgs);
			case ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA:
				return basicSetSubControlArea(null, msgs);
			case ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES:
				return ((InternalEList)getSynchronousMachines()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.GENERATING_UNIT__CONTROL_DEADBAND:
				return getControlDeadband();
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_HIGH:
				return getControlPulseHigh();
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_LOW:
				return getControlPulseLow();
			case ProductionPackage.GENERATING_UNIT__CONTROL_RESPONSE_RATE:
				return getControlResponseRate();
			case ProductionPackage.GENERATING_UNIT__EFFICIENCY:
				return getEfficiency();
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_MODE:
				return getGenControlMode();
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_SOURCE:
				return getGenControlSource();
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_MPL:
				return getGovernorMPL();
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_SCD:
				return getGovernorSCD();
			case ProductionPackage.GENERATING_UNIT__HIGH_CONTROL_LIMIT:
				return getHighControlLimit();
			case ProductionPackage.GENERATING_UNIT__INITIAL_MW:
				return getInitialMW();
			case ProductionPackage.GENERATING_UNIT__LOW_CONTROL_LIMIT:
				return getLowControlLimit();
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE:
				return getMaximumAllowableSpinningReserve();
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ECONOMIC_MW:
				return getMaximumEconomicMW();
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_OPERATING_MW:
				return getMaximumOperatingMW();
			case ProductionPackage.GENERATING_UNIT__MINIMUM_ECONOMIC_MW:
				return getMinimumEconomicMW();
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OPERATING_MW:
				return getMinimumOperatingMW();
			case ProductionPackage.GENERATING_UNIT__MODEL_DETAIL:
				return getModelDetail();
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MAX_MW:
				return getRatedGrossMaxMW();
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MIN_MW:
				return getRatedGrossMinMW();
			case ProductionPackage.GENERATING_UNIT__RATED_NET_MAX_MW:
				return getRatedNetMaxMW();
			case ProductionPackage.GENERATING_UNIT__STARTUP_TIME:
				return getStartupTime();
			case ProductionPackage.GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW:
				return getAutoCntrlMarginMW();
			case ProductionPackage.GENERATING_UNIT__ALLOC_SPIN_RES_MW:
				return getAllocSpinResMW();
			case ProductionPackage.GENERATING_UNIT__BASE_MW:
				return getBaseMW();
			case ProductionPackage.GENERATING_UNIT__DISP_RESERVE_FLAG:
				return getDispReserveFlag();
			case ProductionPackage.GENERATING_UNIT__ENERGY_MIN_MW:
				return getEnergyMinMW();
			case ProductionPackage.GENERATING_UNIT__FAST_START_FLAG:
				return getFastStartFlag();
			case ProductionPackage.GENERATING_UNIT__FUEL_PRIORITY:
				return getFuelPriority();
			case ProductionPackage.GENERATING_UNIT__GEN_OPERATING_MODE:
				return getGenOperatingMode();
			case ProductionPackage.GENERATING_UNIT__LONG_PF:
				return getLongPF();
			case ProductionPackage.GENERATING_UNIT__LOWER_RAMP_RATE:
				return getLowerRampRate();
			case ProductionPackage.GENERATING_UNIT__NORMAL_PF:
				return getNormalPF();
			case ProductionPackage.GENERATING_UNIT__PENALTY_FACTOR:
				return getPenaltyFactor();
			case ProductionPackage.GENERATING_UNIT__RAISE_RAMP_RATE:
				return getRaiseRampRate();
			case ProductionPackage.GENERATING_UNIT__SHORT_PF:
				return getShortPF();
			case ProductionPackage.GENERATING_UNIT__SPIN_RESERVE_RAMP:
				return getSpinReserveRamp();
			case ProductionPackage.GENERATING_UNIT__STEP_CHANGE:
				return getStepChange();
			case ProductionPackage.GENERATING_UNIT__TIE_LINE_PF:
				return getTieLinePF();
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OFF_TIME:
				return getMinimumOffTime();
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES:
				return getGenUnitOpCostCurves();
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE:
				return getGenUnitOpSchedule();
			case ProductionPackage.GENERATING_UNIT__GROSS_TO_NET_MW_CURVES:
				return getGrossToNetMWCurves();
			case ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA:
				if (resolve) return getSubControlArea();
				return basicGetSubControlArea();
			case ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES:
				return getSynchronousMachines();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProductionPackage.GENERATING_UNIT__CONTROL_DEADBAND:
				setControlDeadband((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_HIGH:
				setControlPulseHigh((Seconds)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_LOW:
				setControlPulseLow((Seconds)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__CONTROL_RESPONSE_RATE:
				setControlResponseRate((PowerROCPerSec)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__EFFICIENCY:
				setEfficiency((PU)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_MODE:
				setGenControlMode((GeneratorControlMode)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_SOURCE:
				setGenControlSource((GeneratorControlSource)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_MPL:
				setGovernorMPL((PU)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_SCD:
				setGovernorSCD((PerCent)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__HIGH_CONTROL_LIMIT:
				setHighControlLimit((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__INITIAL_MW:
				setInitialMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__LOW_CONTROL_LIMIT:
				setLowControlLimit((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE:
				setMaximumAllowableSpinningReserve((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ECONOMIC_MW:
				setMaximumEconomicMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_OPERATING_MW:
				setMaximumOperatingMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MINIMUM_ECONOMIC_MW:
				setMinimumEconomicMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OPERATING_MW:
				setMinimumOperatingMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MODEL_DETAIL:
				setModelDetail((Classification)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MAX_MW:
				setRatedGrossMaxMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MIN_MW:
				setRatedGrossMinMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__RATED_NET_MAX_MW:
				setRatedNetMaxMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__STARTUP_TIME:
				setStartupTime((Seconds)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW:
				setAutoCntrlMarginMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__ALLOC_SPIN_RES_MW:
				setAllocSpinResMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__BASE_MW:
				setBaseMW((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__DISP_RESERVE_FLAG:
				setDispReserveFlag((Boolean)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__ENERGY_MIN_MW:
				setEnergyMinMW((HeatPerHour)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__FAST_START_FLAG:
				setFastStartFlag((Boolean)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__FUEL_PRIORITY:
				setFuelPriority((Priority)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_OPERATING_MODE:
				setGenOperatingMode((GeneratorOperatingMode)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__LONG_PF:
				setLongPF((ParticipationFactor)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__LOWER_RAMP_RATE:
				setLowerRampRate((PowerROCPerMin)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__NORMAL_PF:
				setNormalPF((ParticipationFactor)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__PENALTY_FACTOR:
				setPenaltyFactor((PenaltyFactor)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__RAISE_RAMP_RATE:
				setRaiseRampRate((PowerROCPerMin)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__SHORT_PF:
				setShortPF((ParticipationFactor)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__SPIN_RESERVE_RAMP:
				setSpinReserveRamp((PowerROCPerMin)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__STEP_CHANGE:
				setStepChange((ActivePower)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__TIE_LINE_PF:
				setTieLinePF((ParticipationFactor)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OFF_TIME:
				setMinimumOffTime((Seconds)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES:
				getGenUnitOpCostCurves().clear();
				getGenUnitOpCostCurves().addAll((Collection)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE:
				setGenUnitOpSchedule((GenUnitOpSchedule)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__GROSS_TO_NET_MW_CURVES:
				getGrossToNetMWCurves().clear();
				getGrossToNetMWCurves().addAll((Collection)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA:
				setSubControlArea((SubControlArea)newValue);
				return;
			case ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES:
				getSynchronousMachines().clear();
				getSynchronousMachines().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProductionPackage.GENERATING_UNIT__CONTROL_DEADBAND:
				setControlDeadband(CONTROL_DEADBAND_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_HIGH:
				setControlPulseHigh(CONTROL_PULSE_HIGH_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_LOW:
				setControlPulseLow(CONTROL_PULSE_LOW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__CONTROL_RESPONSE_RATE:
				setControlResponseRate(CONTROL_RESPONSE_RATE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__EFFICIENCY:
				setEfficiency(EFFICIENCY_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_MODE:
				setGenControlMode(GEN_CONTROL_MODE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_SOURCE:
				setGenControlSource(GEN_CONTROL_SOURCE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_MPL:
				setGovernorMPL(GOVERNOR_MPL_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_SCD:
				setGovernorSCD(GOVERNOR_SCD_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__HIGH_CONTROL_LIMIT:
				setHighControlLimit(HIGH_CONTROL_LIMIT_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__INITIAL_MW:
				setInitialMW(INITIAL_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__LOW_CONTROL_LIMIT:
				setLowControlLimit(LOW_CONTROL_LIMIT_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE:
				setMaximumAllowableSpinningReserve(MAXIMUM_ALLOWABLE_SPINNING_RESERVE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ECONOMIC_MW:
				setMaximumEconomicMW(MAXIMUM_ECONOMIC_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_OPERATING_MW:
				setMaximumOperatingMW(MAXIMUM_OPERATING_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MINIMUM_ECONOMIC_MW:
				setMinimumEconomicMW(MINIMUM_ECONOMIC_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OPERATING_MW:
				setMinimumOperatingMW(MINIMUM_OPERATING_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MODEL_DETAIL:
				setModelDetail(MODEL_DETAIL_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MAX_MW:
				setRatedGrossMaxMW(RATED_GROSS_MAX_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MIN_MW:
				setRatedGrossMinMW(RATED_GROSS_MIN_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__RATED_NET_MAX_MW:
				setRatedNetMaxMW(RATED_NET_MAX_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__STARTUP_TIME:
				setStartupTime(STARTUP_TIME_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW:
				setAutoCntrlMarginMW(AUTO_CNTRL_MARGIN_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__ALLOC_SPIN_RES_MW:
				setAllocSpinResMW(ALLOC_SPIN_RES_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__BASE_MW:
				setBaseMW(BASE_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__DISP_RESERVE_FLAG:
				setDispReserveFlag(DISP_RESERVE_FLAG_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__ENERGY_MIN_MW:
				setEnergyMinMW(ENERGY_MIN_MW_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__FAST_START_FLAG:
				setFastStartFlag(FAST_START_FLAG_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__FUEL_PRIORITY:
				setFuelPriority(FUEL_PRIORITY_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_OPERATING_MODE:
				setGenOperatingMode(GEN_OPERATING_MODE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__LONG_PF:
				setLongPF(LONG_PF_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__LOWER_RAMP_RATE:
				setLowerRampRate(LOWER_RAMP_RATE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__NORMAL_PF:
				setNormalPF(NORMAL_PF_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__PENALTY_FACTOR:
				setPenaltyFactor(PENALTY_FACTOR_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__RAISE_RAMP_RATE:
				setRaiseRampRate(RAISE_RAMP_RATE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__SHORT_PF:
				setShortPF(SHORT_PF_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__SPIN_RESERVE_RAMP:
				setSpinReserveRamp(SPIN_RESERVE_RAMP_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__STEP_CHANGE:
				setStepChange(STEP_CHANGE_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__TIE_LINE_PF:
				setTieLinePF(TIE_LINE_PF_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OFF_TIME:
				setMinimumOffTime(MINIMUM_OFF_TIME_EDEFAULT);
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES:
				getGenUnitOpCostCurves().clear();
				return;
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE:
				setGenUnitOpSchedule((GenUnitOpSchedule)null);
				return;
			case ProductionPackage.GENERATING_UNIT__GROSS_TO_NET_MW_CURVES:
				getGrossToNetMWCurves().clear();
				return;
			case ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA:
				setSubControlArea((SubControlArea)null);
				return;
			case ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES:
				getSynchronousMachines().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProductionPackage.GENERATING_UNIT__CONTROL_DEADBAND:
				return CONTROL_DEADBAND_EDEFAULT == null ? controlDeadband != null : !CONTROL_DEADBAND_EDEFAULT.equals(controlDeadband);
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_HIGH:
				return CONTROL_PULSE_HIGH_EDEFAULT == null ? controlPulseHigh != null : !CONTROL_PULSE_HIGH_EDEFAULT.equals(controlPulseHigh);
			case ProductionPackage.GENERATING_UNIT__CONTROL_PULSE_LOW:
				return CONTROL_PULSE_LOW_EDEFAULT == null ? controlPulseLow != null : !CONTROL_PULSE_LOW_EDEFAULT.equals(controlPulseLow);
			case ProductionPackage.GENERATING_UNIT__CONTROL_RESPONSE_RATE:
				return CONTROL_RESPONSE_RATE_EDEFAULT == null ? controlResponseRate != null : !CONTROL_RESPONSE_RATE_EDEFAULT.equals(controlResponseRate);
			case ProductionPackage.GENERATING_UNIT__EFFICIENCY:
				return EFFICIENCY_EDEFAULT == null ? efficiency != null : !EFFICIENCY_EDEFAULT.equals(efficiency);
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_MODE:
				return genControlMode != GEN_CONTROL_MODE_EDEFAULT;
			case ProductionPackage.GENERATING_UNIT__GEN_CONTROL_SOURCE:
				return genControlSource != GEN_CONTROL_SOURCE_EDEFAULT;
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_MPL:
				return GOVERNOR_MPL_EDEFAULT == null ? governorMPL != null : !GOVERNOR_MPL_EDEFAULT.equals(governorMPL);
			case ProductionPackage.GENERATING_UNIT__GOVERNOR_SCD:
				return GOVERNOR_SCD_EDEFAULT == null ? governorSCD != null : !GOVERNOR_SCD_EDEFAULT.equals(governorSCD);
			case ProductionPackage.GENERATING_UNIT__HIGH_CONTROL_LIMIT:
				return HIGH_CONTROL_LIMIT_EDEFAULT == null ? highControlLimit != null : !HIGH_CONTROL_LIMIT_EDEFAULT.equals(highControlLimit);
			case ProductionPackage.GENERATING_UNIT__INITIAL_MW:
				return INITIAL_MW_EDEFAULT == null ? initialMW != null : !INITIAL_MW_EDEFAULT.equals(initialMW);
			case ProductionPackage.GENERATING_UNIT__LOW_CONTROL_LIMIT:
				return LOW_CONTROL_LIMIT_EDEFAULT == null ? lowControlLimit != null : !LOW_CONTROL_LIMIT_EDEFAULT.equals(lowControlLimit);
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ALLOWABLE_SPINNING_RESERVE:
				return MAXIMUM_ALLOWABLE_SPINNING_RESERVE_EDEFAULT == null ? maximumAllowableSpinningReserve != null : !MAXIMUM_ALLOWABLE_SPINNING_RESERVE_EDEFAULT.equals(maximumAllowableSpinningReserve);
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_ECONOMIC_MW:
				return MAXIMUM_ECONOMIC_MW_EDEFAULT == null ? maximumEconomicMW != null : !MAXIMUM_ECONOMIC_MW_EDEFAULT.equals(maximumEconomicMW);
			case ProductionPackage.GENERATING_UNIT__MAXIMUM_OPERATING_MW:
				return MAXIMUM_OPERATING_MW_EDEFAULT == null ? maximumOperatingMW != null : !MAXIMUM_OPERATING_MW_EDEFAULT.equals(maximumOperatingMW);
			case ProductionPackage.GENERATING_UNIT__MINIMUM_ECONOMIC_MW:
				return MINIMUM_ECONOMIC_MW_EDEFAULT == null ? minimumEconomicMW != null : !MINIMUM_ECONOMIC_MW_EDEFAULT.equals(minimumEconomicMW);
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OPERATING_MW:
				return MINIMUM_OPERATING_MW_EDEFAULT == null ? minimumOperatingMW != null : !MINIMUM_OPERATING_MW_EDEFAULT.equals(minimumOperatingMW);
			case ProductionPackage.GENERATING_UNIT__MODEL_DETAIL:
				return MODEL_DETAIL_EDEFAULT == null ? modelDetail != null : !MODEL_DETAIL_EDEFAULT.equals(modelDetail);
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MAX_MW:
				return RATED_GROSS_MAX_MW_EDEFAULT == null ? ratedGrossMaxMW != null : !RATED_GROSS_MAX_MW_EDEFAULT.equals(ratedGrossMaxMW);
			case ProductionPackage.GENERATING_UNIT__RATED_GROSS_MIN_MW:
				return RATED_GROSS_MIN_MW_EDEFAULT == null ? ratedGrossMinMW != null : !RATED_GROSS_MIN_MW_EDEFAULT.equals(ratedGrossMinMW);
			case ProductionPackage.GENERATING_UNIT__RATED_NET_MAX_MW:
				return RATED_NET_MAX_MW_EDEFAULT == null ? ratedNetMaxMW != null : !RATED_NET_MAX_MW_EDEFAULT.equals(ratedNetMaxMW);
			case ProductionPackage.GENERATING_UNIT__STARTUP_TIME:
				return STARTUP_TIME_EDEFAULT == null ? startupTime != null : !STARTUP_TIME_EDEFAULT.equals(startupTime);
			case ProductionPackage.GENERATING_UNIT__AUTO_CNTRL_MARGIN_MW:
				return AUTO_CNTRL_MARGIN_MW_EDEFAULT == null ? autoCntrlMarginMW != null : !AUTO_CNTRL_MARGIN_MW_EDEFAULT.equals(autoCntrlMarginMW);
			case ProductionPackage.GENERATING_UNIT__ALLOC_SPIN_RES_MW:
				return ALLOC_SPIN_RES_MW_EDEFAULT == null ? allocSpinResMW != null : !ALLOC_SPIN_RES_MW_EDEFAULT.equals(allocSpinResMW);
			case ProductionPackage.GENERATING_UNIT__BASE_MW:
				return BASE_MW_EDEFAULT == null ? baseMW != null : !BASE_MW_EDEFAULT.equals(baseMW);
			case ProductionPackage.GENERATING_UNIT__DISP_RESERVE_FLAG:
				return DISP_RESERVE_FLAG_EDEFAULT == null ? dispReserveFlag != null : !DISP_RESERVE_FLAG_EDEFAULT.equals(dispReserveFlag);
			case ProductionPackage.GENERATING_UNIT__ENERGY_MIN_MW:
				return ENERGY_MIN_MW_EDEFAULT == null ? energyMinMW != null : !ENERGY_MIN_MW_EDEFAULT.equals(energyMinMW);
			case ProductionPackage.GENERATING_UNIT__FAST_START_FLAG:
				return FAST_START_FLAG_EDEFAULT == null ? fastStartFlag != null : !FAST_START_FLAG_EDEFAULT.equals(fastStartFlag);
			case ProductionPackage.GENERATING_UNIT__FUEL_PRIORITY:
				return FUEL_PRIORITY_EDEFAULT == null ? fuelPriority != null : !FUEL_PRIORITY_EDEFAULT.equals(fuelPriority);
			case ProductionPackage.GENERATING_UNIT__GEN_OPERATING_MODE:
				return genOperatingMode != GEN_OPERATING_MODE_EDEFAULT;
			case ProductionPackage.GENERATING_UNIT__LONG_PF:
				return LONG_PF_EDEFAULT == null ? longPF != null : !LONG_PF_EDEFAULT.equals(longPF);
			case ProductionPackage.GENERATING_UNIT__LOWER_RAMP_RATE:
				return LOWER_RAMP_RATE_EDEFAULT == null ? lowerRampRate != null : !LOWER_RAMP_RATE_EDEFAULT.equals(lowerRampRate);
			case ProductionPackage.GENERATING_UNIT__NORMAL_PF:
				return NORMAL_PF_EDEFAULT == null ? normalPF != null : !NORMAL_PF_EDEFAULT.equals(normalPF);
			case ProductionPackage.GENERATING_UNIT__PENALTY_FACTOR:
				return PENALTY_FACTOR_EDEFAULT == null ? penaltyFactor != null : !PENALTY_FACTOR_EDEFAULT.equals(penaltyFactor);
			case ProductionPackage.GENERATING_UNIT__RAISE_RAMP_RATE:
				return RAISE_RAMP_RATE_EDEFAULT == null ? raiseRampRate != null : !RAISE_RAMP_RATE_EDEFAULT.equals(raiseRampRate);
			case ProductionPackage.GENERATING_UNIT__SHORT_PF:
				return SHORT_PF_EDEFAULT == null ? shortPF != null : !SHORT_PF_EDEFAULT.equals(shortPF);
			case ProductionPackage.GENERATING_UNIT__SPIN_RESERVE_RAMP:
				return SPIN_RESERVE_RAMP_EDEFAULT == null ? spinReserveRamp != null : !SPIN_RESERVE_RAMP_EDEFAULT.equals(spinReserveRamp);
			case ProductionPackage.GENERATING_UNIT__STEP_CHANGE:
				return STEP_CHANGE_EDEFAULT == null ? stepChange != null : !STEP_CHANGE_EDEFAULT.equals(stepChange);
			case ProductionPackage.GENERATING_UNIT__TIE_LINE_PF:
				return TIE_LINE_PF_EDEFAULT == null ? tieLinePF != null : !TIE_LINE_PF_EDEFAULT.equals(tieLinePF);
			case ProductionPackage.GENERATING_UNIT__MINIMUM_OFF_TIME:
				return MINIMUM_OFF_TIME_EDEFAULT == null ? minimumOffTime != null : !MINIMUM_OFF_TIME_EDEFAULT.equals(minimumOffTime);
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES:
				return genUnitOpCostCurves != null && !genUnitOpCostCurves.isEmpty();
			case ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_SCHEDULE:
				return genUnitOpSchedule != null;
			case ProductionPackage.GENERATING_UNIT__GROSS_TO_NET_MW_CURVES:
				return grossToNetMWCurves != null && !grossToNetMWCurves.isEmpty();
			case ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA:
				return subControlArea != null;
			case ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES:
				return synchronousMachines != null && !synchronousMachines.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (controlDeadband: ");
		result.append(controlDeadband);
		result.append(", controlPulseHigh: ");
		result.append(controlPulseHigh);
		result.append(", controlPulseLow: ");
		result.append(controlPulseLow);
		result.append(", controlResponseRate: ");
		result.append(controlResponseRate);
		result.append(", efficiency: ");
		result.append(efficiency);
		result.append(", genControlMode: ");
		result.append(genControlMode);
		result.append(", genControlSource: ");
		result.append(genControlSource);
		result.append(", governorMPL: ");
		result.append(governorMPL);
		result.append(", governorSCD: ");
		result.append(governorSCD);
		result.append(", highControlLimit: ");
		result.append(highControlLimit);
		result.append(", initialMW: ");
		result.append(initialMW);
		result.append(", lowControlLimit: ");
		result.append(lowControlLimit);
		result.append(", maximumAllowableSpinningReserve: ");
		result.append(maximumAllowableSpinningReserve);
		result.append(", maximumEconomicMW: ");
		result.append(maximumEconomicMW);
		result.append(", maximumOperatingMW: ");
		result.append(maximumOperatingMW);
		result.append(", minimumEconomicMW: ");
		result.append(minimumEconomicMW);
		result.append(", minimumOperatingMW: ");
		result.append(minimumOperatingMW);
		result.append(", modelDetail: ");
		result.append(modelDetail);
		result.append(", ratedGrossMaxMW: ");
		result.append(ratedGrossMaxMW);
		result.append(", ratedGrossMinMW: ");
		result.append(ratedGrossMinMW);
		result.append(", ratedNetMaxMW: ");
		result.append(ratedNetMaxMW);
		result.append(", startupTime: ");
		result.append(startupTime);
		result.append(", autoCntrlMarginMW: ");
		result.append(autoCntrlMarginMW);
		result.append(", allocSpinResMW: ");
		result.append(allocSpinResMW);
		result.append(", baseMW: ");
		result.append(baseMW);
		result.append(", dispReserveFlag: ");
		result.append(dispReserveFlag);
		result.append(", energyMinMW: ");
		result.append(energyMinMW);
		result.append(", fastStartFlag: ");
		result.append(fastStartFlag);
		result.append(", fuelPriority: ");
		result.append(fuelPriority);
		result.append(", genOperatingMode: ");
		result.append(genOperatingMode);
		result.append(", longPF: ");
		result.append(longPF);
		result.append(", lowerRampRate: ");
		result.append(lowerRampRate);
		result.append(", normalPF: ");
		result.append(normalPF);
		result.append(", penaltyFactor: ");
		result.append(penaltyFactor);
		result.append(", raiseRampRate: ");
		result.append(raiseRampRate);
		result.append(", shortPF: ");
		result.append(shortPF);
		result.append(", spinReserveRamp: ");
		result.append(spinReserveRamp);
		result.append(", stepChange: ");
		result.append(stepChange);
		result.append(", tieLinePF: ");
		result.append(tieLinePF);
		result.append(", minimumOffTime: ");
		result.append(minimumOffTime);
		result.append(')');
		return result.toString();
	}

} //GeneratingUnitImpl