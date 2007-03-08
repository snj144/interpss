/**
 * <copyright>
 * </copyright>
 *
 * $Id: PWRSteamSupplyImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply;

import org.opencim.datatype.real.PU;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PWR Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getColdLegFBLagTC <em>Cold Leg FB Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getColdLegFBLeadTC1 <em>Cold Leg FB Lead TC1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getColdLegFBLeadTC2 <em>Cold Leg FB Lead TC2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getColdLegFG1 <em>Cold Leg FG1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getColdLegFG2 <em>Cold Leg FG2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getColdLegLagTC <em>Cold Leg Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getCoreHTLagTC1 <em>Core HT Lag TC1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getCoreHTLagTC2 <em>Core HT Lag TC2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getCoreNeutronicsEffTC <em>Core Neutronics Eff TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getCoreNeutronicsHT <em>Core Neutronics HT</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getFeedbackFactor <em>Feedback Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getHotLegLagTC <em>Hot Leg Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getHotLegSteamGain <em>Hot Leg Steam Gain</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getHotLegToColdLegGain <em>Hot Leg To Cold Leg Gain</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getPressureCG <em>Pressure CG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getSteamFlowFG <em>Steam Flow FG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getSteamPressureDropLagTC <em>Steam Pressure Drop Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getSteamPressureFG <em>Steam Pressure FG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getThrottlePressureFactor <em>Throttle Pressure Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.PWRSteamSupplyImpl#getThrottlePressureSP <em>Throttle Pressure SP</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PWRSteamSupplyImpl extends SteamSupplyImpl implements PWRSteamSupply {
	/**
	 * The default value of the '{@link #getColdLegFBLagTC() <em>Cold Leg FB Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFBLagTC()
	 * @generated
	 * @ordered
	 */
	protected static final PU COLD_LEG_FB_LAG_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColdLegFBLagTC() <em>Cold Leg FB Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFBLagTC()
	 * @generated
	 * @ordered
	 */
	protected PU coldLegFBLagTC = COLD_LEG_FB_LAG_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getColdLegFBLeadTC1() <em>Cold Leg FB Lead TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFBLeadTC1()
	 * @generated
	 * @ordered
	 */
	protected static final PU COLD_LEG_FB_LEAD_TC1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColdLegFBLeadTC1() <em>Cold Leg FB Lead TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFBLeadTC1()
	 * @generated
	 * @ordered
	 */
	protected PU coldLegFBLeadTC1 = COLD_LEG_FB_LEAD_TC1_EDEFAULT;

	/**
	 * The default value of the '{@link #getColdLegFBLeadTC2() <em>Cold Leg FB Lead TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFBLeadTC2()
	 * @generated
	 * @ordered
	 */
	protected static final PU COLD_LEG_FB_LEAD_TC2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColdLegFBLeadTC2() <em>Cold Leg FB Lead TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFBLeadTC2()
	 * @generated
	 * @ordered
	 */
	protected PU coldLegFBLeadTC2 = COLD_LEG_FB_LEAD_TC2_EDEFAULT;

	/**
	 * The default value of the '{@link #getColdLegFG1() <em>Cold Leg FG1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFG1()
	 * @generated
	 * @ordered
	 */
	protected static final PU COLD_LEG_FG1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColdLegFG1() <em>Cold Leg FG1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFG1()
	 * @generated
	 * @ordered
	 */
	protected PU coldLegFG1 = COLD_LEG_FG1_EDEFAULT;

	/**
	 * The default value of the '{@link #getColdLegFG2() <em>Cold Leg FG2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFG2()
	 * @generated
	 * @ordered
	 */
	protected static final PU COLD_LEG_FG2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColdLegFG2() <em>Cold Leg FG2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegFG2()
	 * @generated
	 * @ordered
	 */
	protected PU coldLegFG2 = COLD_LEG_FG2_EDEFAULT;

	/**
	 * The default value of the '{@link #getColdLegLagTC() <em>Cold Leg Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegLagTC()
	 * @generated
	 * @ordered
	 */
	protected static final PU COLD_LEG_LAG_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColdLegLagTC() <em>Cold Leg Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColdLegLagTC()
	 * @generated
	 * @ordered
	 */
	protected PU coldLegLagTC = COLD_LEG_LAG_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoreHTLagTC1() <em>Core HT Lag TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreHTLagTC1()
	 * @generated
	 * @ordered
	 */
	protected static final PU CORE_HT_LAG_TC1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoreHTLagTC1() <em>Core HT Lag TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreHTLagTC1()
	 * @generated
	 * @ordered
	 */
	protected PU coreHTLagTC1 = CORE_HT_LAG_TC1_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoreHTLagTC2() <em>Core HT Lag TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreHTLagTC2()
	 * @generated
	 * @ordered
	 */
	protected static final PU CORE_HT_LAG_TC2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoreHTLagTC2() <em>Core HT Lag TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreHTLagTC2()
	 * @generated
	 * @ordered
	 */
	protected PU coreHTLagTC2 = CORE_HT_LAG_TC2_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoreNeutronicsEffTC() <em>Core Neutronics Eff TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreNeutronicsEffTC()
	 * @generated
	 * @ordered
	 */
	protected static final PU CORE_NEUTRONICS_EFF_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoreNeutronicsEffTC() <em>Core Neutronics Eff TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreNeutronicsEffTC()
	 * @generated
	 * @ordered
	 */
	protected PU coreNeutronicsEffTC = CORE_NEUTRONICS_EFF_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoreNeutronicsHT() <em>Core Neutronics HT</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreNeutronicsHT()
	 * @generated
	 * @ordered
	 */
	protected static final PU CORE_NEUTRONICS_HT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoreNeutronicsHT() <em>Core Neutronics HT</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreNeutronicsHT()
	 * @generated
	 * @ordered
	 */
	protected PU coreNeutronicsHT = CORE_NEUTRONICS_HT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedbackFactor() <em>Feedback Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedbackFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PU FEEDBACK_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedbackFactor() <em>Feedback Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedbackFactor()
	 * @generated
	 * @ordered
	 */
	protected PU feedbackFactor = FEEDBACK_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getHotLegLagTC() <em>Hot Leg Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotLegLagTC()
	 * @generated
	 * @ordered
	 */
	protected static final PU HOT_LEG_LAG_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHotLegLagTC() <em>Hot Leg Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotLegLagTC()
	 * @generated
	 * @ordered
	 */
	protected PU hotLegLagTC = HOT_LEG_LAG_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getHotLegSteamGain() <em>Hot Leg Steam Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotLegSteamGain()
	 * @generated
	 * @ordered
	 */
	protected static final PU HOT_LEG_STEAM_GAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHotLegSteamGain() <em>Hot Leg Steam Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotLegSteamGain()
	 * @generated
	 * @ordered
	 */
	protected PU hotLegSteamGain = HOT_LEG_STEAM_GAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getHotLegToColdLegGain() <em>Hot Leg To Cold Leg Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotLegToColdLegGain()
	 * @generated
	 * @ordered
	 */
	protected static final PU HOT_LEG_TO_COLD_LEG_GAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHotLegToColdLegGain() <em>Hot Leg To Cold Leg Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHotLegToColdLegGain()
	 * @generated
	 * @ordered
	 */
	protected PU hotLegToColdLegGain = HOT_LEG_TO_COLD_LEG_GAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPressureCG() <em>Pressure CG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCG()
	 * @generated
	 * @ordered
	 */
	protected static final PU PRESSURE_CG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPressureCG() <em>Pressure CG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPressureCG()
	 * @generated
	 * @ordered
	 */
	protected PU pressureCG = PRESSURE_CG_EDEFAULT;

	/**
	 * The default value of the '{@link #getSteamFlowFG() <em>Steam Flow FG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamFlowFG()
	 * @generated
	 * @ordered
	 */
	protected static final PU STEAM_FLOW_FG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSteamFlowFG() <em>Steam Flow FG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamFlowFG()
	 * @generated
	 * @ordered
	 */
	protected PU steamFlowFG = STEAM_FLOW_FG_EDEFAULT;

	/**
	 * The default value of the '{@link #getSteamPressureDropLagTC() <em>Steam Pressure Drop Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamPressureDropLagTC()
	 * @generated
	 * @ordered
	 */
	protected static final PU STEAM_PRESSURE_DROP_LAG_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSteamPressureDropLagTC() <em>Steam Pressure Drop Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamPressureDropLagTC()
	 * @generated
	 * @ordered
	 */
	protected PU steamPressureDropLagTC = STEAM_PRESSURE_DROP_LAG_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getSteamPressureFG() <em>Steam Pressure FG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamPressureFG()
	 * @generated
	 * @ordered
	 */
	protected static final PU STEAM_PRESSURE_FG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSteamPressureFG() <em>Steam Pressure FG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamPressureFG()
	 * @generated
	 * @ordered
	 */
	protected PU steamPressureFG = STEAM_PRESSURE_FG_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrottlePressureFactor() <em>Throttle Pressure Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottlePressureFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PU THROTTLE_PRESSURE_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThrottlePressureFactor() <em>Throttle Pressure Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottlePressureFactor()
	 * @generated
	 * @ordered
	 */
	protected PU throttlePressureFactor = THROTTLE_PRESSURE_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrottlePressureSP() <em>Throttle Pressure SP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottlePressureSP()
	 * @generated
	 * @ordered
	 */
	protected static final PU THROTTLE_PRESSURE_SP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThrottlePressureSP() <em>Throttle Pressure SP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottlePressureSP()
	 * @generated
	 * @ordered
	 */
	protected PU throttlePressureSP = THROTTLE_PRESSURE_SP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PWRSteamSupplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.PWR_STEAM_SUPPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getColdLegFBLagTC() {
		return coldLegFBLagTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColdLegFBLagTC(PU newColdLegFBLagTC) {
		PU oldColdLegFBLagTC = coldLegFBLagTC;
		coldLegFBLagTC = newColdLegFBLagTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LAG_TC, oldColdLegFBLagTC, coldLegFBLagTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getColdLegFBLeadTC1() {
		return coldLegFBLeadTC1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColdLegFBLeadTC1(PU newColdLegFBLeadTC1) {
		PU oldColdLegFBLeadTC1 = coldLegFBLeadTC1;
		coldLegFBLeadTC1 = newColdLegFBLeadTC1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC1, oldColdLegFBLeadTC1, coldLegFBLeadTC1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getColdLegFBLeadTC2() {
		return coldLegFBLeadTC2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColdLegFBLeadTC2(PU newColdLegFBLeadTC2) {
		PU oldColdLegFBLeadTC2 = coldLegFBLeadTC2;
		coldLegFBLeadTC2 = newColdLegFBLeadTC2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC2, oldColdLegFBLeadTC2, coldLegFBLeadTC2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getColdLegFG1() {
		return coldLegFG1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColdLegFG1(PU newColdLegFG1) {
		PU oldColdLegFG1 = coldLegFG1;
		coldLegFG1 = newColdLegFG1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG1, oldColdLegFG1, coldLegFG1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getColdLegFG2() {
		return coldLegFG2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColdLegFG2(PU newColdLegFG2) {
		PU oldColdLegFG2 = coldLegFG2;
		coldLegFG2 = newColdLegFG2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG2, oldColdLegFG2, coldLegFG2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getColdLegLagTC() {
		return coldLegLagTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColdLegLagTC(PU newColdLegLagTC) {
		PU oldColdLegLagTC = coldLegLagTC;
		coldLegLagTC = newColdLegLagTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_LAG_TC, oldColdLegLagTC, coldLegLagTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getCoreHTLagTC1() {
		return coreHTLagTC1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreHTLagTC1(PU newCoreHTLagTC1) {
		PU oldCoreHTLagTC1 = coreHTLagTC1;
		coreHTLagTC1 = newCoreHTLagTC1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC1, oldCoreHTLagTC1, coreHTLagTC1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getCoreHTLagTC2() {
		return coreHTLagTC2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreHTLagTC2(PU newCoreHTLagTC2) {
		PU oldCoreHTLagTC2 = coreHTLagTC2;
		coreHTLagTC2 = newCoreHTLagTC2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC2, oldCoreHTLagTC2, coreHTLagTC2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getCoreNeutronicsEffTC() {
		return coreNeutronicsEffTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreNeutronicsEffTC(PU newCoreNeutronicsEffTC) {
		PU oldCoreNeutronicsEffTC = coreNeutronicsEffTC;
		coreNeutronicsEffTC = newCoreNeutronicsEffTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_EFF_TC, oldCoreNeutronicsEffTC, coreNeutronicsEffTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getCoreNeutronicsHT() {
		return coreNeutronicsHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreNeutronicsHT(PU newCoreNeutronicsHT) {
		PU oldCoreNeutronicsHT = coreNeutronicsHT;
		coreNeutronicsHT = newCoreNeutronicsHT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_HT, oldCoreNeutronicsHT, coreNeutronicsHT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getFeedbackFactor() {
		return feedbackFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedbackFactor(PU newFeedbackFactor) {
		PU oldFeedbackFactor = feedbackFactor;
		feedbackFactor = newFeedbackFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__FEEDBACK_FACTOR, oldFeedbackFactor, feedbackFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getHotLegLagTC() {
		return hotLegLagTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHotLegLagTC(PU newHotLegLagTC) {
		PU oldHotLegLagTC = hotLegLagTC;
		hotLegLagTC = newHotLegLagTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_LAG_TC, oldHotLegLagTC, hotLegLagTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getHotLegSteamGain() {
		return hotLegSteamGain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHotLegSteamGain(PU newHotLegSteamGain) {
		PU oldHotLegSteamGain = hotLegSteamGain;
		hotLegSteamGain = newHotLegSteamGain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_STEAM_GAIN, oldHotLegSteamGain, hotLegSteamGain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getHotLegToColdLegGain() {
		return hotLegToColdLegGain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHotLegToColdLegGain(PU newHotLegToColdLegGain) {
		PU oldHotLegToColdLegGain = hotLegToColdLegGain;
		hotLegToColdLegGain = newHotLegToColdLegGain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_TO_COLD_LEG_GAIN, oldHotLegToColdLegGain, hotLegToColdLegGain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getPressureCG() {
		return pressureCG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureCG(PU newPressureCG) {
		PU oldPressureCG = pressureCG;
		pressureCG = newPressureCG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__PRESSURE_CG, oldPressureCG, pressureCG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getSteamFlowFG() {
		return steamFlowFG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamFlowFG(PU newSteamFlowFG) {
		PU oldSteamFlowFG = steamFlowFG;
		steamFlowFG = newSteamFlowFG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_FLOW_FG, oldSteamFlowFG, steamFlowFG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getSteamPressureDropLagTC() {
		return steamPressureDropLagTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamPressureDropLagTC(PU newSteamPressureDropLagTC) {
		PU oldSteamPressureDropLagTC = steamPressureDropLagTC;
		steamPressureDropLagTC = newSteamPressureDropLagTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_DROP_LAG_TC, oldSteamPressureDropLagTC, steamPressureDropLagTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getSteamPressureFG() {
		return steamPressureFG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamPressureFG(PU newSteamPressureFG) {
		PU oldSteamPressureFG = steamPressureFG;
		steamPressureFG = newSteamPressureFG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_FG, oldSteamPressureFG, steamPressureFG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getThrottlePressureFactor() {
		return throttlePressureFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottlePressureFactor(PU newThrottlePressureFactor) {
		PU oldThrottlePressureFactor = throttlePressureFactor;
		throttlePressureFactor = newThrottlePressureFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_FACTOR, oldThrottlePressureFactor, throttlePressureFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getThrottlePressureSP() {
		return throttlePressureSP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottlePressureSP(PU newThrottlePressureSP) {
		PU oldThrottlePressureSP = throttlePressureSP;
		throttlePressureSP = newThrottlePressureSP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_SP, oldThrottlePressureSP, throttlePressureSP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LAG_TC:
				return getColdLegFBLagTC();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC1:
				return getColdLegFBLeadTC1();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC2:
				return getColdLegFBLeadTC2();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG1:
				return getColdLegFG1();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG2:
				return getColdLegFG2();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_LAG_TC:
				return getColdLegLagTC();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC1:
				return getCoreHTLagTC1();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC2:
				return getCoreHTLagTC2();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_EFF_TC:
				return getCoreNeutronicsEffTC();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_HT:
				return getCoreNeutronicsHT();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__FEEDBACK_FACTOR:
				return getFeedbackFactor();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_LAG_TC:
				return getHotLegLagTC();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_STEAM_GAIN:
				return getHotLegSteamGain();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_TO_COLD_LEG_GAIN:
				return getHotLegToColdLegGain();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__PRESSURE_CG:
				return getPressureCG();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_FLOW_FG:
				return getSteamFlowFG();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_DROP_LAG_TC:
				return getSteamPressureDropLagTC();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_FG:
				return getSteamPressureFG();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_FACTOR:
				return getThrottlePressureFactor();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				return getThrottlePressureSP();
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
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LAG_TC:
				setColdLegFBLagTC((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC1:
				setColdLegFBLeadTC1((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC2:
				setColdLegFBLeadTC2((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG1:
				setColdLegFG1((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG2:
				setColdLegFG2((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_LAG_TC:
				setColdLegLagTC((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC1:
				setCoreHTLagTC1((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC2:
				setCoreHTLagTC2((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_EFF_TC:
				setCoreNeutronicsEffTC((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_HT:
				setCoreNeutronicsHT((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__FEEDBACK_FACTOR:
				setFeedbackFactor((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_LAG_TC:
				setHotLegLagTC((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_STEAM_GAIN:
				setHotLegSteamGain((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_TO_COLD_LEG_GAIN:
				setHotLegToColdLegGain((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__PRESSURE_CG:
				setPressureCG((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_FLOW_FG:
				setSteamFlowFG((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_DROP_LAG_TC:
				setSteamPressureDropLagTC((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_FG:
				setSteamPressureFG((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_FACTOR:
				setThrottlePressureFactor((PU)newValue);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				setThrottlePressureSP((PU)newValue);
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
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LAG_TC:
				setColdLegFBLagTC(COLD_LEG_FB_LAG_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC1:
				setColdLegFBLeadTC1(COLD_LEG_FB_LEAD_TC1_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC2:
				setColdLegFBLeadTC2(COLD_LEG_FB_LEAD_TC2_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG1:
				setColdLegFG1(COLD_LEG_FG1_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG2:
				setColdLegFG2(COLD_LEG_FG2_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_LAG_TC:
				setColdLegLagTC(COLD_LEG_LAG_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC1:
				setCoreHTLagTC1(CORE_HT_LAG_TC1_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC2:
				setCoreHTLagTC2(CORE_HT_LAG_TC2_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_EFF_TC:
				setCoreNeutronicsEffTC(CORE_NEUTRONICS_EFF_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_HT:
				setCoreNeutronicsHT(CORE_NEUTRONICS_HT_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__FEEDBACK_FACTOR:
				setFeedbackFactor(FEEDBACK_FACTOR_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_LAG_TC:
				setHotLegLagTC(HOT_LEG_LAG_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_STEAM_GAIN:
				setHotLegSteamGain(HOT_LEG_STEAM_GAIN_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_TO_COLD_LEG_GAIN:
				setHotLegToColdLegGain(HOT_LEG_TO_COLD_LEG_GAIN_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__PRESSURE_CG:
				setPressureCG(PRESSURE_CG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_FLOW_FG:
				setSteamFlowFG(STEAM_FLOW_FG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_DROP_LAG_TC:
				setSteamPressureDropLagTC(STEAM_PRESSURE_DROP_LAG_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_FG:
				setSteamPressureFG(STEAM_PRESSURE_FG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_FACTOR:
				setThrottlePressureFactor(THROTTLE_PRESSURE_FACTOR_EDEFAULT);
				return;
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				setThrottlePressureSP(THROTTLE_PRESSURE_SP_EDEFAULT);
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
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LAG_TC:
				return COLD_LEG_FB_LAG_TC_EDEFAULT == null ? coldLegFBLagTC != null : !COLD_LEG_FB_LAG_TC_EDEFAULT.equals(coldLegFBLagTC);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC1:
				return COLD_LEG_FB_LEAD_TC1_EDEFAULT == null ? coldLegFBLeadTC1 != null : !COLD_LEG_FB_LEAD_TC1_EDEFAULT.equals(coldLegFBLeadTC1);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FB_LEAD_TC2:
				return COLD_LEG_FB_LEAD_TC2_EDEFAULT == null ? coldLegFBLeadTC2 != null : !COLD_LEG_FB_LEAD_TC2_EDEFAULT.equals(coldLegFBLeadTC2);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG1:
				return COLD_LEG_FG1_EDEFAULT == null ? coldLegFG1 != null : !COLD_LEG_FG1_EDEFAULT.equals(coldLegFG1);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_FG2:
				return COLD_LEG_FG2_EDEFAULT == null ? coldLegFG2 != null : !COLD_LEG_FG2_EDEFAULT.equals(coldLegFG2);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__COLD_LEG_LAG_TC:
				return COLD_LEG_LAG_TC_EDEFAULT == null ? coldLegLagTC != null : !COLD_LEG_LAG_TC_EDEFAULT.equals(coldLegLagTC);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC1:
				return CORE_HT_LAG_TC1_EDEFAULT == null ? coreHTLagTC1 != null : !CORE_HT_LAG_TC1_EDEFAULT.equals(coreHTLagTC1);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_HT_LAG_TC2:
				return CORE_HT_LAG_TC2_EDEFAULT == null ? coreHTLagTC2 != null : !CORE_HT_LAG_TC2_EDEFAULT.equals(coreHTLagTC2);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_EFF_TC:
				return CORE_NEUTRONICS_EFF_TC_EDEFAULT == null ? coreNeutronicsEffTC != null : !CORE_NEUTRONICS_EFF_TC_EDEFAULT.equals(coreNeutronicsEffTC);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__CORE_NEUTRONICS_HT:
				return CORE_NEUTRONICS_HT_EDEFAULT == null ? coreNeutronicsHT != null : !CORE_NEUTRONICS_HT_EDEFAULT.equals(coreNeutronicsHT);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__FEEDBACK_FACTOR:
				return FEEDBACK_FACTOR_EDEFAULT == null ? feedbackFactor != null : !FEEDBACK_FACTOR_EDEFAULT.equals(feedbackFactor);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_LAG_TC:
				return HOT_LEG_LAG_TC_EDEFAULT == null ? hotLegLagTC != null : !HOT_LEG_LAG_TC_EDEFAULT.equals(hotLegLagTC);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_STEAM_GAIN:
				return HOT_LEG_STEAM_GAIN_EDEFAULT == null ? hotLegSteamGain != null : !HOT_LEG_STEAM_GAIN_EDEFAULT.equals(hotLegSteamGain);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__HOT_LEG_TO_COLD_LEG_GAIN:
				return HOT_LEG_TO_COLD_LEG_GAIN_EDEFAULT == null ? hotLegToColdLegGain != null : !HOT_LEG_TO_COLD_LEG_GAIN_EDEFAULT.equals(hotLegToColdLegGain);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__PRESSURE_CG:
				return PRESSURE_CG_EDEFAULT == null ? pressureCG != null : !PRESSURE_CG_EDEFAULT.equals(pressureCG);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_FLOW_FG:
				return STEAM_FLOW_FG_EDEFAULT == null ? steamFlowFG != null : !STEAM_FLOW_FG_EDEFAULT.equals(steamFlowFG);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_DROP_LAG_TC:
				return STEAM_PRESSURE_DROP_LAG_TC_EDEFAULT == null ? steamPressureDropLagTC != null : !STEAM_PRESSURE_DROP_LAG_TC_EDEFAULT.equals(steamPressureDropLagTC);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__STEAM_PRESSURE_FG:
				return STEAM_PRESSURE_FG_EDEFAULT == null ? steamPressureFG != null : !STEAM_PRESSURE_FG_EDEFAULT.equals(steamPressureFG);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_FACTOR:
				return THROTTLE_PRESSURE_FACTOR_EDEFAULT == null ? throttlePressureFactor != null : !THROTTLE_PRESSURE_FACTOR_EDEFAULT.equals(throttlePressureFactor);
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY__THROTTLE_PRESSURE_SP:
				return THROTTLE_PRESSURE_SP_EDEFAULT == null ? throttlePressureSP != null : !THROTTLE_PRESSURE_SP_EDEFAULT.equals(throttlePressureSP);
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
		result.append(" (coldLegFBLagTC: ");
		result.append(coldLegFBLagTC);
		result.append(", coldLegFBLeadTC1: ");
		result.append(coldLegFBLeadTC1);
		result.append(", coldLegFBLeadTC2: ");
		result.append(coldLegFBLeadTC2);
		result.append(", coldLegFG1: ");
		result.append(coldLegFG1);
		result.append(", coldLegFG2: ");
		result.append(coldLegFG2);
		result.append(", coldLegLagTC: ");
		result.append(coldLegLagTC);
		result.append(", coreHTLagTC1: ");
		result.append(coreHTLagTC1);
		result.append(", coreHTLagTC2: ");
		result.append(coreHTLagTC2);
		result.append(", coreNeutronicsEffTC: ");
		result.append(coreNeutronicsEffTC);
		result.append(", coreNeutronicsHT: ");
		result.append(coreNeutronicsHT);
		result.append(", feedbackFactor: ");
		result.append(feedbackFactor);
		result.append(", hotLegLagTC: ");
		result.append(hotLegLagTC);
		result.append(", hotLegSteamGain: ");
		result.append(hotLegSteamGain);
		result.append(", hotLegToColdLegGain: ");
		result.append(hotLegToColdLegGain);
		result.append(", pressureCG: ");
		result.append(pressureCG);
		result.append(", steamFlowFG: ");
		result.append(steamFlowFG);
		result.append(", steamPressureDropLagTC: ");
		result.append(steamPressureDropLagTC);
		result.append(", steamPressureFG: ");
		result.append(steamPressureFG);
		result.append(", throttlePressureFactor: ");
		result.append(throttlePressureFactor);
		result.append(", throttlePressureSP: ");
		result.append(throttlePressureSP);
		result.append(')');
		return result.toString();
	}

} //PWRSteamSupplyImpl