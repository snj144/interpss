/**
 * <copyright>
 * </copyright>
 *
 * $Id: CogenerationPlant.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.datatype.real.ActivePower;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cogeneration Plant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A set of thermal generating units for the production of electrical energy and process steam (usually from the output of the steam turbines). The steam sendout is typically used for industrial purposes or for municipal heating and cooling.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSendoutRating <em>Cogen HP Sendout Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSteamRating <em>Cogen HP Steam Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSendoutRating <em>Cogen LP Sendout Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSteamRating <em>Cogen LP Steam Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenPlantMWRating <em>Cogen Plant MW Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getSteamSendoutSchedule <em>Steam Sendout Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant()
 * @generated
 */
public interface CogenerationPlant extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Cogen HP Sendout Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The high pressure steam sendout, in klb/hour
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cogen HP Sendout Rating</em>' attribute.
	 * @see #setCogenHPSendoutRating(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_CogenHPSendoutRating()
	 * @generated
	 */
	Float getCogenHPSendoutRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSendoutRating <em>Cogen HP Sendout Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cogen HP Sendout Rating</em>' attribute.
	 * @see #getCogenHPSendoutRating()
	 * @generated
	 */
	void setCogenHPSendoutRating(Float value);

	/**
	 * Returns the value of the '<em><b>Cogen HP Steam Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The high pressure steam rating, in psi
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cogen HP Steam Rating</em>' attribute.
	 * @see #setCogenHPSteamRating(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_CogenHPSteamRating()
	 * @generated
	 */
	Float getCogenHPSteamRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenHPSteamRating <em>Cogen HP Steam Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cogen HP Steam Rating</em>' attribute.
	 * @see #getCogenHPSteamRating()
	 * @generated
	 */
	void setCogenHPSteamRating(Float value);

	/**
	 * Returns the value of the '<em><b>Cogen LP Sendout Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The low pressure steam sendout, in klb/hour
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cogen LP Sendout Rating</em>' attribute.
	 * @see #setCogenLPSendoutRating(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_CogenLPSendoutRating()
	 * @generated
	 */
	Float getCogenLPSendoutRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSendoutRating <em>Cogen LP Sendout Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cogen LP Sendout Rating</em>' attribute.
	 * @see #getCogenLPSendoutRating()
	 * @generated
	 */
	void setCogenLPSendoutRating(Float value);

	/**
	 * Returns the value of the '<em><b>Cogen LP Steam Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The low pressure steam rating, in psi
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cogen LP Steam Rating</em>' attribute.
	 * @see #setCogenLPSteamRating(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_CogenLPSteamRating()
	 * @generated
	 */
	Float getCogenLPSteamRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenLPSteamRating <em>Cogen LP Steam Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cogen LP Steam Rating</em>' attribute.
	 * @see #getCogenLPSteamRating()
	 * @generated
	 */
	void setCogenLPSteamRating(Float value);

	/**
	 * Returns the value of the '<em><b>Cogen Plant MW Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rated output MW of the cogeneration plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cogen Plant MW Rating</em>' attribute.
	 * @see #setCogenPlantMWRating(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_CogenPlantMWRating()
	 * @generated
	 */
	ActivePower getCogenPlantMWRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getCogenPlantMWRating <em>Cogen Plant MW Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cogen Plant MW Rating</em>' attribute.
	 * @see #getCogenPlantMWRating()
	 * @generated
	 */
	void setCogenPlantMWRating(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Contain Thermal Generating Units</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMembmerOf_CogenerationPlant <em>Membmer Of Cogeneration Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may be a member of a cogeneration plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contain Thermal Generating Units</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_Contain_ThermalGeneratingUnits()
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMembmerOf_CogenerationPlant
	 * @generated
	 */
	EList getContain_ThermalGeneratingUnits();

	/**
	 * Returns the value of the '<em><b>Steam Sendout Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A cogeneration plant has a steam sendout schedule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Sendout Schedule</em>' containment reference.
	 * @see #setSteamSendoutSchedule(SteamSendoutSchedule)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCogenerationPlant_SteamSendoutSchedule()
	 * @generated
	 */
	SteamSendoutSchedule getSteamSendoutSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getSteamSendoutSchedule <em>Steam Sendout Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Sendout Schedule</em>' containment reference.
	 * @see #getSteamSendoutSchedule()
	 * @generated
	 */
	void setSteamSendoutSchedule(SteamSendoutSchedule value);

} // CogenerationPlant