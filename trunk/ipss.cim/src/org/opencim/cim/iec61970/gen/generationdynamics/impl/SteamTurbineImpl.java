/**
 * <copyright>
 * </copyright>
 *
 * $Id: SteamTurbineImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply;
import org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine;

import org.opencim.datatype.real.Fraction;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Steam Turbine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getCrossoverTC <em>Crossover TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getReheater1TC <em>Reheater1 TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getReheater2TC <em>Reheater2 TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft1PowerHP <em>Shaft1 Power HP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft1PowerIP <em>Shaft1 Power IP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft1PowerLP1 <em>Shaft1 Power LP1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft1PowerLP2 <em>Shaft1 Power LP2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft2PowerHP <em>Shaft2 Power HP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft2PowerIP <em>Shaft2 Power IP</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft2PowerLP1 <em>Shaft2 Power LP1</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getShaft2PowerLP2 <em>Shaft2 Power LP2</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getSteamChestTC <em>Steam Chest TC</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.SteamTurbineImpl#getSteamSupplys <em>Steam Supplys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SteamTurbineImpl extends PrimeMoverImpl implements SteamTurbine {
	/**
	 * The default value of the '{@link #getCrossoverTC() <em>Crossover TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossoverTC()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds CROSSOVER_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCrossoverTC() <em>Crossover TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossoverTC()
	 * @generated
	 * @ordered
	 */
	protected Seconds crossoverTC = CROSSOVER_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getReheater1TC() <em>Reheater1 TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReheater1TC()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds REHEATER1_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReheater1TC() <em>Reheater1 TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReheater1TC()
	 * @generated
	 * @ordered
	 */
	protected Seconds reheater1TC = REHEATER1_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getReheater2TC() <em>Reheater2 TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReheater2TC()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds REHEATER2_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReheater2TC() <em>Reheater2 TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReheater2TC()
	 * @generated
	 * @ordered
	 */
	protected Seconds reheater2TC = REHEATER2_TC_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft1PowerHP() <em>Shaft1 Power HP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerHP()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT1_POWER_HP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft1PowerHP() <em>Shaft1 Power HP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerHP()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft1PowerHP = SHAFT1_POWER_HP_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft1PowerIP() <em>Shaft1 Power IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerIP()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT1_POWER_IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft1PowerIP() <em>Shaft1 Power IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerIP()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft1PowerIP = SHAFT1_POWER_IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft1PowerLP1() <em>Shaft1 Power LP1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerLP1()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT1_POWER_LP1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft1PowerLP1() <em>Shaft1 Power LP1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerLP1()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft1PowerLP1 = SHAFT1_POWER_LP1_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft1PowerLP2() <em>Shaft1 Power LP2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerLP2()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT1_POWER_LP2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft1PowerLP2() <em>Shaft1 Power LP2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft1PowerLP2()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft1PowerLP2 = SHAFT1_POWER_LP2_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft2PowerHP() <em>Shaft2 Power HP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerHP()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT2_POWER_HP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft2PowerHP() <em>Shaft2 Power HP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerHP()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft2PowerHP = SHAFT2_POWER_HP_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft2PowerIP() <em>Shaft2 Power IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerIP()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT2_POWER_IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft2PowerIP() <em>Shaft2 Power IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerIP()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft2PowerIP = SHAFT2_POWER_IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft2PowerLP1() <em>Shaft2 Power LP1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerLP1()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT2_POWER_LP1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft2PowerLP1() <em>Shaft2 Power LP1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerLP1()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft2PowerLP1 = SHAFT2_POWER_LP1_EDEFAULT;

	/**
	 * The default value of the '{@link #getShaft2PowerLP2() <em>Shaft2 Power LP2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerLP2()
	 * @generated
	 * @ordered
	 */
	protected static final Fraction SHAFT2_POWER_LP2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShaft2PowerLP2() <em>Shaft2 Power LP2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaft2PowerLP2()
	 * @generated
	 * @ordered
	 */
	protected Fraction shaft2PowerLP2 = SHAFT2_POWER_LP2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSteamChestTC() <em>Steam Chest TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamChestTC()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds STEAM_CHEST_TC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSteamChestTC() <em>Steam Chest TC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamChestTC()
	 * @generated
	 * @ordered
	 */
	protected Seconds steamChestTC = STEAM_CHEST_TC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSteamSupplys() <em>Steam Supplys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteamSupplys()
	 * @generated
	 * @ordered
	 */
	protected EList steamSupplys = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SteamTurbineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.STEAM_TURBINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getCrossoverTC() {
		return crossoverTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossoverTC(Seconds newCrossoverTC) {
		Seconds oldCrossoverTC = crossoverTC;
		crossoverTC = newCrossoverTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__CROSSOVER_TC, oldCrossoverTC, crossoverTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getReheater1TC() {
		return reheater1TC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReheater1TC(Seconds newReheater1TC) {
		Seconds oldReheater1TC = reheater1TC;
		reheater1TC = newReheater1TC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__REHEATER1_TC, oldReheater1TC, reheater1TC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getReheater2TC() {
		return reheater2TC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReheater2TC(Seconds newReheater2TC) {
		Seconds oldReheater2TC = reheater2TC;
		reheater2TC = newReheater2TC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__REHEATER2_TC, oldReheater2TC, reheater2TC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft1PowerHP() {
		return shaft1PowerHP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft1PowerHP(Fraction newShaft1PowerHP) {
		Fraction oldShaft1PowerHP = shaft1PowerHP;
		shaft1PowerHP = newShaft1PowerHP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_HP, oldShaft1PowerHP, shaft1PowerHP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft1PowerIP() {
		return shaft1PowerIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft1PowerIP(Fraction newShaft1PowerIP) {
		Fraction oldShaft1PowerIP = shaft1PowerIP;
		shaft1PowerIP = newShaft1PowerIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_IP, oldShaft1PowerIP, shaft1PowerIP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft1PowerLP1() {
		return shaft1PowerLP1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft1PowerLP1(Fraction newShaft1PowerLP1) {
		Fraction oldShaft1PowerLP1 = shaft1PowerLP1;
		shaft1PowerLP1 = newShaft1PowerLP1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP1, oldShaft1PowerLP1, shaft1PowerLP1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft1PowerLP2() {
		return shaft1PowerLP2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft1PowerLP2(Fraction newShaft1PowerLP2) {
		Fraction oldShaft1PowerLP2 = shaft1PowerLP2;
		shaft1PowerLP2 = newShaft1PowerLP2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP2, oldShaft1PowerLP2, shaft1PowerLP2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft2PowerHP() {
		return shaft2PowerHP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft2PowerHP(Fraction newShaft2PowerHP) {
		Fraction oldShaft2PowerHP = shaft2PowerHP;
		shaft2PowerHP = newShaft2PowerHP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_HP, oldShaft2PowerHP, shaft2PowerHP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft2PowerIP() {
		return shaft2PowerIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft2PowerIP(Fraction newShaft2PowerIP) {
		Fraction oldShaft2PowerIP = shaft2PowerIP;
		shaft2PowerIP = newShaft2PowerIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_IP, oldShaft2PowerIP, shaft2PowerIP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft2PowerLP1() {
		return shaft2PowerLP1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft2PowerLP1(Fraction newShaft2PowerLP1) {
		Fraction oldShaft2PowerLP1 = shaft2PowerLP1;
		shaft2PowerLP1 = newShaft2PowerLP1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP1, oldShaft2PowerLP1, shaft2PowerLP1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fraction getShaft2PowerLP2() {
		return shaft2PowerLP2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShaft2PowerLP2(Fraction newShaft2PowerLP2) {
		Fraction oldShaft2PowerLP2 = shaft2PowerLP2;
		shaft2PowerLP2 = newShaft2PowerLP2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP2, oldShaft2PowerLP2, shaft2PowerLP2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getSteamChestTC() {
		return steamChestTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteamChestTC(Seconds newSteamChestTC) {
		Seconds oldSteamChestTC = steamChestTC;
		steamChestTC = newSteamChestTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.STEAM_TURBINE__STEAM_CHEST_TC, oldSteamChestTC, steamChestTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSteamSupplys() {
		if (steamSupplys == null) {
			steamSupplys = new EObjectWithInverseResolvingEList.ManyInverse(SteamSupply.class, this, GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS, GenerationdynamicsPackage.STEAM_SUPPLY__STEAM_TURBINES);
		}
		return steamSupplys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS:
				return ((InternalEList)getSteamSupplys()).basicAdd(otherEnd, msgs);
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
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS:
				return ((InternalEList)getSteamSupplys()).basicRemove(otherEnd, msgs);
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
			case GenerationdynamicsPackage.STEAM_TURBINE__CROSSOVER_TC:
				return getCrossoverTC();
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER1_TC:
				return getReheater1TC();
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER2_TC:
				return getReheater2TC();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_HP:
				return getShaft1PowerHP();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_IP:
				return getShaft1PowerIP();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP1:
				return getShaft1PowerLP1();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP2:
				return getShaft1PowerLP2();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_HP:
				return getShaft2PowerHP();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_IP:
				return getShaft2PowerIP();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP1:
				return getShaft2PowerLP1();
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP2:
				return getShaft2PowerLP2();
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_CHEST_TC:
				return getSteamChestTC();
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS:
				return getSteamSupplys();
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
			case GenerationdynamicsPackage.STEAM_TURBINE__CROSSOVER_TC:
				setCrossoverTC((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER1_TC:
				setReheater1TC((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER2_TC:
				setReheater2TC((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_HP:
				setShaft1PowerHP((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_IP:
				setShaft1PowerIP((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP1:
				setShaft1PowerLP1((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP2:
				setShaft1PowerLP2((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_HP:
				setShaft2PowerHP((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_IP:
				setShaft2PowerIP((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP1:
				setShaft2PowerLP1((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP2:
				setShaft2PowerLP2((Fraction)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_CHEST_TC:
				setSteamChestTC((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS:
				getSteamSupplys().clear();
				getSteamSupplys().addAll((Collection)newValue);
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
			case GenerationdynamicsPackage.STEAM_TURBINE__CROSSOVER_TC:
				setCrossoverTC(CROSSOVER_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER1_TC:
				setReheater1TC(REHEATER1_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER2_TC:
				setReheater2TC(REHEATER2_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_HP:
				setShaft1PowerHP(SHAFT1_POWER_HP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_IP:
				setShaft1PowerIP(SHAFT1_POWER_IP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP1:
				setShaft1PowerLP1(SHAFT1_POWER_LP1_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP2:
				setShaft1PowerLP2(SHAFT1_POWER_LP2_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_HP:
				setShaft2PowerHP(SHAFT2_POWER_HP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_IP:
				setShaft2PowerIP(SHAFT2_POWER_IP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP1:
				setShaft2PowerLP1(SHAFT2_POWER_LP1_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP2:
				setShaft2PowerLP2(SHAFT2_POWER_LP2_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_CHEST_TC:
				setSteamChestTC(STEAM_CHEST_TC_EDEFAULT);
				return;
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS:
				getSteamSupplys().clear();
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
			case GenerationdynamicsPackage.STEAM_TURBINE__CROSSOVER_TC:
				return CROSSOVER_TC_EDEFAULT == null ? crossoverTC != null : !CROSSOVER_TC_EDEFAULT.equals(crossoverTC);
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER1_TC:
				return REHEATER1_TC_EDEFAULT == null ? reheater1TC != null : !REHEATER1_TC_EDEFAULT.equals(reheater1TC);
			case GenerationdynamicsPackage.STEAM_TURBINE__REHEATER2_TC:
				return REHEATER2_TC_EDEFAULT == null ? reheater2TC != null : !REHEATER2_TC_EDEFAULT.equals(reheater2TC);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_HP:
				return SHAFT1_POWER_HP_EDEFAULT == null ? shaft1PowerHP != null : !SHAFT1_POWER_HP_EDEFAULT.equals(shaft1PowerHP);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_IP:
				return SHAFT1_POWER_IP_EDEFAULT == null ? shaft1PowerIP != null : !SHAFT1_POWER_IP_EDEFAULT.equals(shaft1PowerIP);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP1:
				return SHAFT1_POWER_LP1_EDEFAULT == null ? shaft1PowerLP1 != null : !SHAFT1_POWER_LP1_EDEFAULT.equals(shaft1PowerLP1);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT1_POWER_LP2:
				return SHAFT1_POWER_LP2_EDEFAULT == null ? shaft1PowerLP2 != null : !SHAFT1_POWER_LP2_EDEFAULT.equals(shaft1PowerLP2);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_HP:
				return SHAFT2_POWER_HP_EDEFAULT == null ? shaft2PowerHP != null : !SHAFT2_POWER_HP_EDEFAULT.equals(shaft2PowerHP);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_IP:
				return SHAFT2_POWER_IP_EDEFAULT == null ? shaft2PowerIP != null : !SHAFT2_POWER_IP_EDEFAULT.equals(shaft2PowerIP);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP1:
				return SHAFT2_POWER_LP1_EDEFAULT == null ? shaft2PowerLP1 != null : !SHAFT2_POWER_LP1_EDEFAULT.equals(shaft2PowerLP1);
			case GenerationdynamicsPackage.STEAM_TURBINE__SHAFT2_POWER_LP2:
				return SHAFT2_POWER_LP2_EDEFAULT == null ? shaft2PowerLP2 != null : !SHAFT2_POWER_LP2_EDEFAULT.equals(shaft2PowerLP2);
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_CHEST_TC:
				return STEAM_CHEST_TC_EDEFAULT == null ? steamChestTC != null : !STEAM_CHEST_TC_EDEFAULT.equals(steamChestTC);
			case GenerationdynamicsPackage.STEAM_TURBINE__STEAM_SUPPLYS:
				return steamSupplys != null && !steamSupplys.isEmpty();
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
		result.append(" (crossoverTC: ");
		result.append(crossoverTC);
		result.append(", reheater1TC: ");
		result.append(reheater1TC);
		result.append(", reheater2TC: ");
		result.append(reheater2TC);
		result.append(", shaft1PowerHP: ");
		result.append(shaft1PowerHP);
		result.append(", shaft1PowerIP: ");
		result.append(shaft1PowerIP);
		result.append(", shaft1PowerLP1: ");
		result.append(shaft1PowerLP1);
		result.append(", shaft1PowerLP2: ");
		result.append(shaft1PowerLP2);
		result.append(", shaft2PowerHP: ");
		result.append(shaft2PowerHP);
		result.append(", shaft2PowerIP: ");
		result.append(shaft2PowerIP);
		result.append(", shaft2PowerLP1: ");
		result.append(shaft2PowerLP1);
		result.append(", shaft2PowerLP2: ");
		result.append(shaft2PowerLP2);
		result.append(", steamChestTC: ");
		result.append(steamChestTC);
		result.append(')');
		return result.toString();
	}

} //SteamTurbineImpl