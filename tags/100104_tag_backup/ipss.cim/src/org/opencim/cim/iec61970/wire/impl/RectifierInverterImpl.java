/**
 * <copyright>
 * </copyright>
 *
 * $Id: RectifierInverterImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl;

import org.opencim.cim.iec61970.wire.RectifierInverter;
import org.opencim.cim.iec61970.wire.VoltageControlZone;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Frequency;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.OperatingMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rectifier Inverter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getRatedKV <em>Rated KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getBridges <em>Bridges</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getCommutatingReactance <em>Commutating Reactance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getCommutatingResistance <em>Commutating Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getCompoundResistance <em>Compound Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getMinCompoundVoltage <em>Min Compound Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getMaximumMW <em>Maximum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getMinimumMW <em>Minimum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getMaximumKV <em>Maximum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getMinimumKV <em>Minimum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RectifierInverterImpl#getOperatingMode <em>Operating Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RectifierInverterImpl extends ConductingEquipmentImpl implements RectifierInverter {
	/**
	 * The default value of the '{@link #getRatedKV() <em>Rated KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage RATED_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedKV() <em>Rated KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage ratedKV = RATED_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getBridges() <em>Bridges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBridges()
	 * @generated
	 * @ordered
	 */
	protected static final Counter BRIDGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBridges() <em>Bridges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBridges()
	 * @generated
	 * @ordered
	 */
	protected Counter bridges = BRIDGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommutatingReactance() <em>Commutating Reactance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommutatingReactance()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance COMMUTATING_REACTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommutatingReactance() <em>Commutating Reactance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommutatingReactance()
	 * @generated
	 * @ordered
	 */
	protected Reactance commutatingReactance = COMMUTATING_REACTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommutatingResistance() <em>Commutating Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommutatingResistance()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance COMMUTATING_RESISTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommutatingResistance() <em>Commutating Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommutatingResistance()
	 * @generated
	 * @ordered
	 */
	protected Resistance commutatingResistance = COMMUTATING_RESISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompoundResistance() <em>Compound Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompoundResistance()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance COMPOUND_RESISTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompoundResistance() <em>Compound Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompoundResistance()
	 * @generated
	 * @ordered
	 */
	protected Resistance compoundResistance = COMPOUND_RESISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinCompoundVoltage() <em>Min Compound Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCompoundVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MIN_COMPOUND_VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinCompoundVoltage() <em>Min Compound Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCompoundVoltage()
	 * @generated
	 * @ordered
	 */
	protected Voltage minCompoundVoltage = MIN_COMPOUND_VOLTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final Frequency FREQUENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected Frequency frequency = FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumMW() <em>Maximum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MAXIMUM_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumMW() <em>Maximum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower maximumMW = MAXIMUM_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumMW() <em>Minimum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower MINIMUM_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumMW() <em>Minimum MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower minimumMW = MINIMUM_MW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMaximumKV() <em>Maximum KV</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumKV()
	 * @generated
	 * @ordered
	 */
	protected VoltageControlZone maximumKV;

	/**
	 * The default value of the '{@link #getMinimumKV() <em>Minimum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MINIMUM_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumKV() <em>Minimum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage minimumKV = MINIMUM_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatingMode() <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected static final OperatingMode OPERATING_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperatingMode() <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected OperatingMode operatingMode = OPERATING_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RectifierInverterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.RECTIFIER_INVERTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getRatedKV() {
		return ratedKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedKV(Voltage newRatedKV) {
		Voltage oldRatedKV = ratedKV;
		ratedKV = newRatedKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__RATED_KV, oldRatedKV, ratedKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getBridges() {
		return bridges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBridges(Counter newBridges) {
		Counter oldBridges = bridges;
		bridges = newBridges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__BRIDGES, oldBridges, bridges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getCommutatingReactance() {
		return commutatingReactance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommutatingReactance(Reactance newCommutatingReactance) {
		Reactance oldCommutatingReactance = commutatingReactance;
		commutatingReactance = newCommutatingReactance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__COMMUTATING_REACTANCE, oldCommutatingReactance, commutatingReactance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getCommutatingResistance() {
		return commutatingResistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommutatingResistance(Resistance newCommutatingResistance) {
		Resistance oldCommutatingResistance = commutatingResistance;
		commutatingResistance = newCommutatingResistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__COMMUTATING_RESISTANCE, oldCommutatingResistance, commutatingResistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getCompoundResistance() {
		return compoundResistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompoundResistance(Resistance newCompoundResistance) {
		Resistance oldCompoundResistance = compoundResistance;
		compoundResistance = newCompoundResistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__COMPOUND_RESISTANCE, oldCompoundResistance, compoundResistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMinCompoundVoltage() {
		return minCompoundVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCompoundVoltage(Voltage newMinCompoundVoltage) {
		Voltage oldMinCompoundVoltage = minCompoundVoltage;
		minCompoundVoltage = newMinCompoundVoltage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE, oldMinCompoundVoltage, minCompoundVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Frequency getFrequency() {
		return frequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequency(Frequency newFrequency) {
		Frequency oldFrequency = frequency;
		frequency = newFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__FREQUENCY, oldFrequency, frequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMaximumMW() {
		return maximumMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumMW(ActivePower newMaximumMW) {
		ActivePower oldMaximumMW = maximumMW;
		maximumMW = newMaximumMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__MAXIMUM_MW, oldMaximumMW, maximumMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getMinimumMW() {
		return minimumMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumMW(ActivePower newMinimumMW) {
		ActivePower oldMinimumMW = minimumMW;
		minimumMW = newMinimumMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__MINIMUM_MW, oldMinimumMW, minimumMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoltageControlZone getMaximumKV() {
		return maximumKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaximumKV(VoltageControlZone newMaximumKV, NotificationChain msgs) {
		VoltageControlZone oldMaximumKV = maximumKV;
		maximumKV = newMaximumKV;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV, oldMaximumKV, newMaximumKV);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumKV(VoltageControlZone newMaximumKV) {
		if (newMaximumKV != maximumKV) {
			NotificationChain msgs = null;
			if (maximumKV != null)
				msgs = ((InternalEObject)maximumKV).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV, null, msgs);
			if (newMaximumKV != null)
				msgs = ((InternalEObject)newMaximumKV).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV, null, msgs);
			msgs = basicSetMaximumKV(newMaximumKV, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV, newMaximumKV, newMaximumKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMinimumKV() {
		return minimumKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumKV(Voltage newMinimumKV) {
		Voltage oldMinimumKV = minimumKV;
		minimumKV = newMinimumKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__MINIMUM_KV, oldMinimumKV, minimumKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingMode getOperatingMode() {
		return operatingMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatingMode(OperatingMode newOperatingMode) {
		OperatingMode oldOperatingMode = operatingMode;
		operatingMode = newOperatingMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.RECTIFIER_INVERTER__OPERATING_MODE, oldOperatingMode, operatingMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV:
				return basicSetMaximumKV(null, msgs);
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
			case WirePackage.RECTIFIER_INVERTER__RATED_KV:
				return getRatedKV();
			case WirePackage.RECTIFIER_INVERTER__BRIDGES:
				return getBridges();
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_REACTANCE:
				return getCommutatingReactance();
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_RESISTANCE:
				return getCommutatingResistance();
			case WirePackage.RECTIFIER_INVERTER__COMPOUND_RESISTANCE:
				return getCompoundResistance();
			case WirePackage.RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE:
				return getMinCompoundVoltage();
			case WirePackage.RECTIFIER_INVERTER__FREQUENCY:
				return getFrequency();
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_MW:
				return getMaximumMW();
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_MW:
				return getMinimumMW();
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV:
				return getMaximumKV();
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_KV:
				return getMinimumKV();
			case WirePackage.RECTIFIER_INVERTER__OPERATING_MODE:
				return getOperatingMode();
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
			case WirePackage.RECTIFIER_INVERTER__RATED_KV:
				setRatedKV((Voltage)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__BRIDGES:
				setBridges((Counter)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_REACTANCE:
				setCommutatingReactance((Reactance)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_RESISTANCE:
				setCommutatingResistance((Resistance)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__COMPOUND_RESISTANCE:
				setCompoundResistance((Resistance)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE:
				setMinCompoundVoltage((Voltage)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__FREQUENCY:
				setFrequency((Frequency)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_MW:
				setMaximumMW((ActivePower)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_MW:
				setMinimumMW((ActivePower)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV:
				setMaximumKV((VoltageControlZone)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_KV:
				setMinimumKV((Voltage)newValue);
				return;
			case WirePackage.RECTIFIER_INVERTER__OPERATING_MODE:
				setOperatingMode((OperatingMode)newValue);
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
			case WirePackage.RECTIFIER_INVERTER__RATED_KV:
				setRatedKV(RATED_KV_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__BRIDGES:
				setBridges(BRIDGES_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_REACTANCE:
				setCommutatingReactance(COMMUTATING_REACTANCE_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_RESISTANCE:
				setCommutatingResistance(COMMUTATING_RESISTANCE_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__COMPOUND_RESISTANCE:
				setCompoundResistance(COMPOUND_RESISTANCE_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE:
				setMinCompoundVoltage(MIN_COMPOUND_VOLTAGE_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_MW:
				setMaximumMW(MAXIMUM_MW_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_MW:
				setMinimumMW(MINIMUM_MW_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV:
				setMaximumKV((VoltageControlZone)null);
				return;
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_KV:
				setMinimumKV(MINIMUM_KV_EDEFAULT);
				return;
			case WirePackage.RECTIFIER_INVERTER__OPERATING_MODE:
				setOperatingMode(OPERATING_MODE_EDEFAULT);
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
			case WirePackage.RECTIFIER_INVERTER__RATED_KV:
				return RATED_KV_EDEFAULT == null ? ratedKV != null : !RATED_KV_EDEFAULT.equals(ratedKV);
			case WirePackage.RECTIFIER_INVERTER__BRIDGES:
				return BRIDGES_EDEFAULT == null ? bridges != null : !BRIDGES_EDEFAULT.equals(bridges);
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_REACTANCE:
				return COMMUTATING_REACTANCE_EDEFAULT == null ? commutatingReactance != null : !COMMUTATING_REACTANCE_EDEFAULT.equals(commutatingReactance);
			case WirePackage.RECTIFIER_INVERTER__COMMUTATING_RESISTANCE:
				return COMMUTATING_RESISTANCE_EDEFAULT == null ? commutatingResistance != null : !COMMUTATING_RESISTANCE_EDEFAULT.equals(commutatingResistance);
			case WirePackage.RECTIFIER_INVERTER__COMPOUND_RESISTANCE:
				return COMPOUND_RESISTANCE_EDEFAULT == null ? compoundResistance != null : !COMPOUND_RESISTANCE_EDEFAULT.equals(compoundResistance);
			case WirePackage.RECTIFIER_INVERTER__MIN_COMPOUND_VOLTAGE:
				return MIN_COMPOUND_VOLTAGE_EDEFAULT == null ? minCompoundVoltage != null : !MIN_COMPOUND_VOLTAGE_EDEFAULT.equals(minCompoundVoltage);
			case WirePackage.RECTIFIER_INVERTER__FREQUENCY:
				return FREQUENCY_EDEFAULT == null ? frequency != null : !FREQUENCY_EDEFAULT.equals(frequency);
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_MW:
				return MAXIMUM_MW_EDEFAULT == null ? maximumMW != null : !MAXIMUM_MW_EDEFAULT.equals(maximumMW);
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_MW:
				return MINIMUM_MW_EDEFAULT == null ? minimumMW != null : !MINIMUM_MW_EDEFAULT.equals(minimumMW);
			case WirePackage.RECTIFIER_INVERTER__MAXIMUM_KV:
				return maximumKV != null;
			case WirePackage.RECTIFIER_INVERTER__MINIMUM_KV:
				return MINIMUM_KV_EDEFAULT == null ? minimumKV != null : !MINIMUM_KV_EDEFAULT.equals(minimumKV);
			case WirePackage.RECTIFIER_INVERTER__OPERATING_MODE:
				return OPERATING_MODE_EDEFAULT == null ? operatingMode != null : !OPERATING_MODE_EDEFAULT.equals(operatingMode);
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
		result.append(" (ratedKV: ");
		result.append(ratedKV);
		result.append(", bridges: ");
		result.append(bridges);
		result.append(", commutatingReactance: ");
		result.append(commutatingReactance);
		result.append(", commutatingResistance: ");
		result.append(commutatingResistance);
		result.append(", compoundResistance: ");
		result.append(compoundResistance);
		result.append(", minCompoundVoltage: ");
		result.append(minCompoundVoltage);
		result.append(", frequency: ");
		result.append(frequency);
		result.append(", maximumMW: ");
		result.append(maximumMW);
		result.append(", minimumMW: ");
		result.append(minimumMW);
		result.append(", minimumKV: ");
		result.append(minimumKV);
		result.append(", operatingMode: ");
		result.append(operatingMode);
		result.append(')');
		return result.toString();
	}

} //RectifierInverterImpl