/**
 * <copyright>
 * </copyright>
 *
 * $Id: PWRSteamSupply.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.opencim.datatype.real.PU;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PWR Steam Supply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Pressurized water reactor used as a steam supply to a steam turbine
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFBLagTC <em>Cold Leg FB Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFBLeadTC1 <em>Cold Leg FB Lead TC1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFBLeadTC2 <em>Cold Leg FB Lead TC2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFG1 <em>Cold Leg FG1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFG2 <em>Cold Leg FG2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegLagTC <em>Cold Leg Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreHTLagTC1 <em>Core HT Lag TC1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreHTLagTC2 <em>Core HT Lag TC2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreNeutronicsEffTC <em>Core Neutronics Eff TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreNeutronicsHT <em>Core Neutronics HT</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getFeedbackFactor <em>Feedback Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getHotLegLagTC <em>Hot Leg Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getHotLegSteamGain <em>Hot Leg Steam Gain</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getHotLegToColdLegGain <em>Hot Leg To Cold Leg Gain</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getPressureCG <em>Pressure CG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getSteamFlowFG <em>Steam Flow FG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getSteamPressureDropLagTC <em>Steam Pressure Drop Lag TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getSteamPressureFG <em>Steam Pressure FG</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getThrottlePressureFactor <em>Throttle Pressure Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getThrottlePressureSP <em>Throttle Pressure SP</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply()
 * @generated
 */
public interface PWRSteamSupply extends SteamSupply {
	/**
	 * Returns the value of the '<em><b>Cold Leg FB Lag TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cold Leg Feedback Lag Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cold Leg FB Lag TC</em>' attribute.
	 * @see #setColdLegFBLagTC(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ColdLegFBLagTC()
	 * @generated
	 */
	PU getColdLegFBLagTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFBLagTC <em>Cold Leg FB Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cold Leg FB Lag TC</em>' attribute.
	 * @see #getColdLegFBLagTC()
	 * @generated
	 */
	void setColdLegFBLagTC(PU value);

	/**
	 * Returns the value of the '<em><b>Cold Leg FB Lead TC1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cold Leg Feedback Lead Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cold Leg FB Lead TC1</em>' attribute.
	 * @see #setColdLegFBLeadTC1(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ColdLegFBLeadTC1()
	 * @generated
	 */
	PU getColdLegFBLeadTC1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFBLeadTC1 <em>Cold Leg FB Lead TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cold Leg FB Lead TC1</em>' attribute.
	 * @see #getColdLegFBLeadTC1()
	 * @generated
	 */
	void setColdLegFBLeadTC1(PU value);

	/**
	 * Returns the value of the '<em><b>Cold Leg FB Lead TC2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cold Leg Feedback Lead Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cold Leg FB Lead TC2</em>' attribute.
	 * @see #setColdLegFBLeadTC2(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ColdLegFBLeadTC2()
	 * @generated
	 */
	PU getColdLegFBLeadTC2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFBLeadTC2 <em>Cold Leg FB Lead TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cold Leg FB Lead TC2</em>' attribute.
	 * @see #getColdLegFBLeadTC2()
	 * @generated
	 */
	void setColdLegFBLeadTC2(PU value);

	/**
	 * Returns the value of the '<em><b>Cold Leg FG1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cold Leg Feedback Gain 1
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cold Leg FG1</em>' attribute.
	 * @see #setColdLegFG1(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ColdLegFG1()
	 * @generated
	 */
	PU getColdLegFG1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFG1 <em>Cold Leg FG1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cold Leg FG1</em>' attribute.
	 * @see #getColdLegFG1()
	 * @generated
	 */
	void setColdLegFG1(PU value);

	/**
	 * Returns the value of the '<em><b>Cold Leg FG2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cold Leg Feedback Gain 2
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cold Leg FG2</em>' attribute.
	 * @see #setColdLegFG2(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ColdLegFG2()
	 * @generated
	 */
	PU getColdLegFG2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegFG2 <em>Cold Leg FG2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cold Leg FG2</em>' attribute.
	 * @see #getColdLegFG2()
	 * @generated
	 */
	void setColdLegFG2(PU value);

	/**
	 * Returns the value of the '<em><b>Cold Leg Lag TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cold Leg Lag Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cold Leg Lag TC</em>' attribute.
	 * @see #setColdLegLagTC(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ColdLegLagTC()
	 * @generated
	 */
	PU getColdLegLagTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getColdLegLagTC <em>Cold Leg Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cold Leg Lag TC</em>' attribute.
	 * @see #getColdLegLagTC()
	 * @generated
	 */
	void setColdLegLagTC(PU value);

	/**
	 * Returns the value of the '<em><b>Core HT Lag TC1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Core Heat Transfer Lag Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Core HT Lag TC1</em>' attribute.
	 * @see #setCoreHTLagTC1(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_CoreHTLagTC1()
	 * @generated
	 */
	PU getCoreHTLagTC1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreHTLagTC1 <em>Core HT Lag TC1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core HT Lag TC1</em>' attribute.
	 * @see #getCoreHTLagTC1()
	 * @generated
	 */
	void setCoreHTLagTC1(PU value);

	/**
	 * Returns the value of the '<em><b>Core HT Lag TC2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Core Heat Transfer Lag Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Core HT Lag TC2</em>' attribute.
	 * @see #setCoreHTLagTC2(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_CoreHTLagTC2()
	 * @generated
	 */
	PU getCoreHTLagTC2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreHTLagTC2 <em>Core HT Lag TC2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core HT Lag TC2</em>' attribute.
	 * @see #getCoreHTLagTC2()
	 * @generated
	 */
	void setCoreHTLagTC2(PU value);

	/**
	 * Returns the value of the '<em><b>Core Neutronics Eff TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Core Neutronics Effective Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Core Neutronics Eff TC</em>' attribute.
	 * @see #setCoreNeutronicsEffTC(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_CoreNeutronicsEffTC()
	 * @generated
	 */
	PU getCoreNeutronicsEffTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreNeutronicsEffTC <em>Core Neutronics Eff TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Neutronics Eff TC</em>' attribute.
	 * @see #getCoreNeutronicsEffTC()
	 * @generated
	 */
	void setCoreNeutronicsEffTC(PU value);

	/**
	 * Returns the value of the '<em><b>Core Neutronics HT</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Core Neutronics And Heat Transfer
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Core Neutronics HT</em>' attribute.
	 * @see #setCoreNeutronicsHT(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_CoreNeutronicsHT()
	 * @generated
	 */
	PU getCoreNeutronicsHT();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getCoreNeutronicsHT <em>Core Neutronics HT</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Neutronics HT</em>' attribute.
	 * @see #getCoreNeutronicsHT()
	 * @generated
	 */
	void setCoreNeutronicsHT(PU value);

	/**
	 * Returns the value of the '<em><b>Feedback Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Feedback Factor
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feedback Factor</em>' attribute.
	 * @see #setFeedbackFactor(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_FeedbackFactor()
	 * @generated
	 */
	PU getFeedbackFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getFeedbackFactor <em>Feedback Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feedback Factor</em>' attribute.
	 * @see #getFeedbackFactor()
	 * @generated
	 */
	void setFeedbackFactor(PU value);

	/**
	 * Returns the value of the '<em><b>Hot Leg Lag TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Hot Leg Lag Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hot Leg Lag TC</em>' attribute.
	 * @see #setHotLegLagTC(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_HotLegLagTC()
	 * @generated
	 */
	PU getHotLegLagTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getHotLegLagTC <em>Hot Leg Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hot Leg Lag TC</em>' attribute.
	 * @see #getHotLegLagTC()
	 * @generated
	 */
	void setHotLegLagTC(PU value);

	/**
	 * Returns the value of the '<em><b>Hot Leg Steam Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Hot Leg Steam Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hot Leg Steam Gain</em>' attribute.
	 * @see #setHotLegSteamGain(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_HotLegSteamGain()
	 * @generated
	 */
	PU getHotLegSteamGain();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getHotLegSteamGain <em>Hot Leg Steam Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hot Leg Steam Gain</em>' attribute.
	 * @see #getHotLegSteamGain()
	 * @generated
	 */
	void setHotLegSteamGain(PU value);

	/**
	 * Returns the value of the '<em><b>Hot Leg To Cold Leg Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Hot Leg To Cold Leg Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hot Leg To Cold Leg Gain</em>' attribute.
	 * @see #setHotLegToColdLegGain(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_HotLegToColdLegGain()
	 * @generated
	 */
	PU getHotLegToColdLegGain();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getHotLegToColdLegGain <em>Hot Leg To Cold Leg Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hot Leg To Cold Leg Gain</em>' attribute.
	 * @see #getHotLegToColdLegGain()
	 * @generated
	 */
	void setHotLegToColdLegGain(PU value);

	/**
	 * Returns the value of the '<em><b>Pressure CG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pressure Control Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pressure CG</em>' attribute.
	 * @see #setPressureCG(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_PressureCG()
	 * @generated
	 */
	PU getPressureCG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getPressureCG <em>Pressure CG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure CG</em>' attribute.
	 * @see #getPressureCG()
	 * @generated
	 */
	void setPressureCG(PU value);

	/**
	 * Returns the value of the '<em><b>Steam Flow FG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Steam Flow Feedback Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Flow FG</em>' attribute.
	 * @see #setSteamFlowFG(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_SteamFlowFG()
	 * @generated
	 */
	PU getSteamFlowFG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getSteamFlowFG <em>Steam Flow FG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Flow FG</em>' attribute.
	 * @see #getSteamFlowFG()
	 * @generated
	 */
	void setSteamFlowFG(PU value);

	/**
	 * Returns the value of the '<em><b>Steam Pressure Drop Lag TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Steam Pressure Drop Lag Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Pressure Drop Lag TC</em>' attribute.
	 * @see #setSteamPressureDropLagTC(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_SteamPressureDropLagTC()
	 * @generated
	 */
	PU getSteamPressureDropLagTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getSteamPressureDropLagTC <em>Steam Pressure Drop Lag TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Pressure Drop Lag TC</em>' attribute.
	 * @see #getSteamPressureDropLagTC()
	 * @generated
	 */
	void setSteamPressureDropLagTC(PU value);

	/**
	 * Returns the value of the '<em><b>Steam Pressure FG</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Steam Pressure Feedback Gain
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Pressure FG</em>' attribute.
	 * @see #setSteamPressureFG(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_SteamPressureFG()
	 * @generated
	 */
	PU getSteamPressureFG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getSteamPressureFG <em>Steam Pressure FG</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Pressure FG</em>' attribute.
	 * @see #getSteamPressureFG()
	 * @generated
	 */
	void setSteamPressureFG(PU value);

	/**
	 * Returns the value of the '<em><b>Throttle Pressure Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Throttle Pressure Factor
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Throttle Pressure Factor</em>' attribute.
	 * @see #setThrottlePressureFactor(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ThrottlePressureFactor()
	 * @generated
	 */
	PU getThrottlePressureFactor();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getThrottlePressureFactor <em>Throttle Pressure Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Pressure Factor</em>' attribute.
	 * @see #getThrottlePressureFactor()
	 * @generated
	 */
	void setThrottlePressureFactor(PU value);

	/**
	 * Returns the value of the '<em><b>Throttle Pressure SP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Throttle Pressure Setpoint
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Throttle Pressure SP</em>' attribute.
	 * @see #setThrottlePressureSP(PU)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getPWRSteamSupply_ThrottlePressureSP()
	 * @generated
	 */
	PU getThrottlePressureSP();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply#getThrottlePressureSP <em>Throttle Pressure SP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Pressure SP</em>' attribute.
	 * @see #getThrottlePressureSP()
	 * @generated
	 */
	void setThrottlePressureSP(PU value);

} // PWRSteamSupply