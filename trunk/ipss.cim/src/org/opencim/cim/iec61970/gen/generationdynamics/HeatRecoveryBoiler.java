/**
 * <copyright>
 * </copyright>
 *
 * $Id: HeatRecoveryBoiler.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Heat Recovery Boiler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The heat recovery system associated with combustion turbines in order to produce steam for combined cycle plants
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler#getSteamSupplyRating2 <em>Steam Supply Rating2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler#getCombustionTurbines <em>Combustion Turbines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHeatRecoveryBoiler()
 * @model
 * @generated
 */
public interface HeatRecoveryBoiler extends FossilSteamSupply {
	/**
	 * Returns the value of the '<em><b>Steam Supply Rating2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The steam supply rating in kilopounds per hour, if dual pressure boiler
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Supply Rating2</em>' attribute.
	 * @see #setSteamSupplyRating2(Float)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHeatRecoveryBoiler_SteamSupplyRating2()
	 * @model
	 * @generated
	 */
	Float getSteamSupplyRating2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler#getSteamSupplyRating2 <em>Steam Supply Rating2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Supply Rating2</em>' attribute.
	 * @see #getSteamSupplyRating2()
	 * @generated
	 */
	void setSteamSupplyRating2(Float value);

	/**
	 * Returns the value of the '<em><b>Combustion Turbines</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getHeatRecoveryBoiler <em>Heat Recovery Boiler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A combustion turbine may have a heat recovery boiler for making steam
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Combustion Turbines</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getHeatRecoveryBoiler_CombustionTurbines()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine#getHeatRecoveryBoiler
	 * @model type="org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine" opposite="HeatRecoveryBoiler"
	 * @generated
	 */
	EList getCombustionTurbines();

} // HeatRecoveryBoiler