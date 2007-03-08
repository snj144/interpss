/**
 * <copyright>
 * </copyright>
 *
 * $Id: FrequencyConverterImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.wire.FrequencyConverter;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Frequency;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.OperatingMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frequency Converter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl#getMaximumMW <em>Maximum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl#getMaximumKV <em>Maximum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl#getMinimumMW <em>Minimum MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl#getMinimumKV <em>Minimum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.FrequencyConverterImpl#getOperatingMode <em>Operating Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FrequencyConverterImpl extends RegulatingCondEqImpl implements FrequencyConverter {
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
	 * The default value of the '{@link #getMaximumKV() <em>Maximum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MAXIMUM_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumKV() <em>Maximum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage maximumKV = MAXIMUM_KV_EDEFAULT;

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
	protected FrequencyConverterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.FREQUENCY_CONVERTER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.FREQUENCY_CONVERTER__FREQUENCY, oldFrequency, frequency));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.FREQUENCY_CONVERTER__MAXIMUM_MW, oldMaximumMW, maximumMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMaximumKV() {
		return maximumKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumKV(Voltage newMaximumKV) {
		Voltage oldMaximumKV = maximumKV;
		maximumKV = newMaximumKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.FREQUENCY_CONVERTER__MAXIMUM_KV, oldMaximumKV, maximumKV));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.FREQUENCY_CONVERTER__MINIMUM_MW, oldMinimumMW, minimumMW));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.FREQUENCY_CONVERTER__MINIMUM_KV, oldMinimumKV, minimumKV));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.FREQUENCY_CONVERTER__OPERATING_MODE, oldOperatingMode, operatingMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.FREQUENCY_CONVERTER__FREQUENCY:
				return getFrequency();
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_MW:
				return getMaximumMW();
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_KV:
				return getMaximumKV();
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_MW:
				return getMinimumMW();
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_KV:
				return getMinimumKV();
			case WirePackage.FREQUENCY_CONVERTER__OPERATING_MODE:
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
			case WirePackage.FREQUENCY_CONVERTER__FREQUENCY:
				setFrequency((Frequency)newValue);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_MW:
				setMaximumMW((ActivePower)newValue);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_KV:
				setMaximumKV((Voltage)newValue);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_MW:
				setMinimumMW((ActivePower)newValue);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_KV:
				setMinimumKV((Voltage)newValue);
				return;
			case WirePackage.FREQUENCY_CONVERTER__OPERATING_MODE:
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
			case WirePackage.FREQUENCY_CONVERTER__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_MW:
				setMaximumMW(MAXIMUM_MW_EDEFAULT);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_KV:
				setMaximumKV(MAXIMUM_KV_EDEFAULT);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_MW:
				setMinimumMW(MINIMUM_MW_EDEFAULT);
				return;
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_KV:
				setMinimumKV(MINIMUM_KV_EDEFAULT);
				return;
			case WirePackage.FREQUENCY_CONVERTER__OPERATING_MODE:
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
			case WirePackage.FREQUENCY_CONVERTER__FREQUENCY:
				return FREQUENCY_EDEFAULT == null ? frequency != null : !FREQUENCY_EDEFAULT.equals(frequency);
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_MW:
				return MAXIMUM_MW_EDEFAULT == null ? maximumMW != null : !MAXIMUM_MW_EDEFAULT.equals(maximumMW);
			case WirePackage.FREQUENCY_CONVERTER__MAXIMUM_KV:
				return MAXIMUM_KV_EDEFAULT == null ? maximumKV != null : !MAXIMUM_KV_EDEFAULT.equals(maximumKV);
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_MW:
				return MINIMUM_MW_EDEFAULT == null ? minimumMW != null : !MINIMUM_MW_EDEFAULT.equals(minimumMW);
			case WirePackage.FREQUENCY_CONVERTER__MINIMUM_KV:
				return MINIMUM_KV_EDEFAULT == null ? minimumKV != null : !MINIMUM_KV_EDEFAULT.equals(minimumKV);
			case WirePackage.FREQUENCY_CONVERTER__OPERATING_MODE:
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
		result.append(" (frequency: ");
		result.append(frequency);
		result.append(", maximumMW: ");
		result.append(maximumMW);
		result.append(", maximumKV: ");
		result.append(maximumKV);
		result.append(", minimumMW: ");
		result.append(minimumMW);
		result.append(", minimumKV: ");
		result.append(minimumKV);
		result.append(", operatingMode: ");
		result.append(operatingMode);
		result.append(')');
		return result.toString();
	}

} //FrequencyConverterImpl