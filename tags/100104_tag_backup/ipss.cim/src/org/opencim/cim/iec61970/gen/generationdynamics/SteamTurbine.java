/**
 * <copyright>
 * </copyright>
 *
 * $Id: SteamTurbine.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics;

import org.eclipse.emf.common.util.EList;

import org.opencim.datatype.real.Fraction;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Steam Turbine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Steam turbine
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getCrossoverTC <em>Crossover TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getReheater1TC <em>Reheater1 TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getReheater2TC <em>Reheater2 TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerHP <em>Shaft1 Power HP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerIP <em>Shaft1 Power IP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerLP1 <em>Shaft1 Power LP1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerLP2 <em>Shaft1 Power LP2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerHP <em>Shaft2 Power HP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerIP <em>Shaft2 Power IP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerLP1 <em>Shaft2 Power LP1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerLP2 <em>Shaft2 Power LP2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getSteamChestTC <em>Steam Chest TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getSteamSupplys <em>Steam Supplys</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine()
 * @generated
 */
public interface SteamTurbine extends PrimeMover {
	/**
	 * Returns the value of the '<em><b>Crossover TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Crossover Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Crossover TC</em>' attribute.
	 * @see #setCrossoverTC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_CrossoverTC()
	 * @generated
	 */
	Seconds getCrossoverTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getCrossoverTC <em>Crossover TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Crossover TC</em>' attribute.
	 * @see #getCrossoverTC()
	 * @generated
	 */
	void setCrossoverTC(Seconds value);

	/**
	 * Returns the value of the '<em><b>Reheater1 TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * First Reheater Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reheater1 TC</em>' attribute.
	 * @see #setReheater1TC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Reheater1TC()
	 * @generated
	 */
	Seconds getReheater1TC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getReheater1TC <em>Reheater1 TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reheater1 TC</em>' attribute.
	 * @see #getReheater1TC()
	 * @generated
	 */
	void setReheater1TC(Seconds value);

	/**
	 * Returns the value of the '<em><b>Reheater2 TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Second Reheater Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reheater2 TC</em>' attribute.
	 * @see #setReheater2TC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Reheater2TC()
	 * @generated
	 */
	Seconds getReheater2TC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getReheater2TC <em>Reheater2 TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reheater2 TC</em>' attribute.
	 * @see #getReheater2TC()
	 * @generated
	 */
	void setReheater2TC(Seconds value);

	/**
	 * Returns the value of the '<em><b>Shaft1 Power HP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 1 High Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft1 Power HP</em>' attribute.
	 * @see #setShaft1PowerHP(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft1PowerHP()
	 * @generated
	 */
	Fraction getShaft1PowerHP();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerHP <em>Shaft1 Power HP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft1 Power HP</em>' attribute.
	 * @see #getShaft1PowerHP()
	 * @generated
	 */
	void setShaft1PowerHP(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft1 Power IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 1 Intermediate Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft1 Power IP</em>' attribute.
	 * @see #setShaft1PowerIP(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft1PowerIP()
	 * @generated
	 */
	Fraction getShaft1PowerIP();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerIP <em>Shaft1 Power IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft1 Power IP</em>' attribute.
	 * @see #getShaft1PowerIP()
	 * @generated
	 */
	void setShaft1PowerIP(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft1 Power LP1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 1 First Low Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft1 Power LP1</em>' attribute.
	 * @see #setShaft1PowerLP1(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft1PowerLP1()
	 * @generated
	 */
	Fraction getShaft1PowerLP1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerLP1 <em>Shaft1 Power LP1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft1 Power LP1</em>' attribute.
	 * @see #getShaft1PowerLP1()
	 * @generated
	 */
	void setShaft1PowerLP1(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft1 Power LP2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 1 Second Low Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft1 Power LP2</em>' attribute.
	 * @see #setShaft1PowerLP2(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft1PowerLP2()
	 * @generated
	 */
	Fraction getShaft1PowerLP2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft1PowerLP2 <em>Shaft1 Power LP2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft1 Power LP2</em>' attribute.
	 * @see #getShaft1PowerLP2()
	 * @generated
	 */
	void setShaft1PowerLP2(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft2 Power HP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 2 High Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft2 Power HP</em>' attribute.
	 * @see #setShaft2PowerHP(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft2PowerHP()
	 * @generated
	 */
	Fraction getShaft2PowerHP();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerHP <em>Shaft2 Power HP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft2 Power HP</em>' attribute.
	 * @see #getShaft2PowerHP()
	 * @generated
	 */
	void setShaft2PowerHP(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft2 Power IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 2 Intermediate Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft2 Power IP</em>' attribute.
	 * @see #setShaft2PowerIP(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft2PowerIP()
	 * @generated
	 */
	Fraction getShaft2PowerIP();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerIP <em>Shaft2 Power IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft2 Power IP</em>' attribute.
	 * @see #getShaft2PowerIP()
	 * @generated
	 */
	void setShaft2PowerIP(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft2 Power LP1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 2 First Low Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft2 Power LP1</em>' attribute.
	 * @see #setShaft2PowerLP1(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft2PowerLP1()
	 * @generated
	 */
	Fraction getShaft2PowerLP1();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerLP1 <em>Shaft2 Power LP1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft2 Power LP1</em>' attribute.
	 * @see #getShaft2PowerLP1()
	 * @generated
	 */
	void setShaft2PowerLP1(Fraction value);

	/**
	 * Returns the value of the '<em><b>Shaft2 Power LP2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fraction Of Power From Shaft 2 Second Low Pressure Turbine output
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shaft2 Power LP2</em>' attribute.
	 * @see #setShaft2PowerLP2(Fraction)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_Shaft2PowerLP2()
	 * @generated
	 */
	Fraction getShaft2PowerLP2();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getShaft2PowerLP2 <em>Shaft2 Power LP2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shaft2 Power LP2</em>' attribute.
	 * @see #getShaft2PowerLP2()
	 * @generated
	 */
	void setShaft2PowerLP2(Fraction value);

	/**
	 * Returns the value of the '<em><b>Steam Chest TC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Steam Chest Time Constant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Chest TC</em>' attribute.
	 * @see #setSteamChestTC(Seconds)
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_SteamChestTC()
	 * @generated
	 */
	Seconds getSteamChestTC();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine#getSteamChestTC <em>Steam Chest TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steam Chest TC</em>' attribute.
	 * @see #getSteamChestTC()
	 * @generated
	 */
	void setSteamChestTC(Seconds value);

	/**
	 * Returns the value of the '<em><b>Steam Supplys</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply#getSteamTurbines <em>Steam Turbines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Steam turbines may have steam supplied by a steam supply
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steam Supplys</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage#getSteamTurbine_SteamSupplys()
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply#getSteamTurbines
	 * @generated
	 */
	EList getSteamSupplys();

} // SteamTurbine