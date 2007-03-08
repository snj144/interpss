/**
 * <copyright>
 * </copyright>
 *
 * $Id: BayImpl.java,v 1.3 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Equipment;

import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;

import org.opencim.cim.iec61970.domain.BreakerConfiguration;
import org.opencim.cim.iec61970.domain.BusbarConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bay</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BayImpl#getBayEnergyMeasFlag <em>Bay Energy Meas Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BayImpl#getBayPowerMeasFlag <em>Bay Power Meas Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BayImpl#getBreakerConfiguration <em>Breaker Configuration</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BayImpl#getBusBarConfiguration <em>Bus Bar Configuration</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BayImpl#getVoltageLevel <em>Voltage Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.BayImpl#getSubstation <em>Substation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BayImpl extends EquipmentContainerImpl implements Bay {
	/**
	 * The default value of the '{@link #getBayEnergyMeasFlag() <em>Bay Energy Meas Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBayEnergyMeasFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean BAY_ENERGY_MEAS_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBayEnergyMeasFlag() <em>Bay Energy Meas Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBayEnergyMeasFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean bayEnergyMeasFlag = BAY_ENERGY_MEAS_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getBayPowerMeasFlag() <em>Bay Power Meas Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBayPowerMeasFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean BAY_POWER_MEAS_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBayPowerMeasFlag() <em>Bay Power Meas Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBayPowerMeasFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean bayPowerMeasFlag = BAY_POWER_MEAS_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getBreakerConfiguration() <em>Breaker Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakerConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final BreakerConfiguration BREAKER_CONFIGURATION_EDEFAULT = BreakerConfiguration.SINGLE_BREAKER_LITERAL;

	/**
	 * The cached value of the '{@link #getBreakerConfiguration() <em>Breaker Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakerConfiguration()
	 * @generated
	 * @ordered
	 */
	protected BreakerConfiguration breakerConfiguration = BREAKER_CONFIGURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBusBarConfiguration() <em>Bus Bar Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusBarConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final BusbarConfiguration BUS_BAR_CONFIGURATION_EDEFAULT = BusbarConfiguration.SINGLE_BUS_LITERAL;

	/**
	 * The cached value of the '{@link #getBusBarConfiguration() <em>Bus Bar Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusBarConfiguration()
	 * @generated
	 * @ordered
	 */
	protected BusbarConfiguration busBarConfiguration = BUS_BAR_CONFIGURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.BAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getBayEnergyMeasFlag() {
		return bayEnergyMeasFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBayEnergyMeasFlag(Boolean newBayEnergyMeasFlag) {
		Boolean oldBayEnergyMeasFlag = bayEnergyMeasFlag;
		bayEnergyMeasFlag = newBayEnergyMeasFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BAY__BAY_ENERGY_MEAS_FLAG, oldBayEnergyMeasFlag, bayEnergyMeasFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getBayPowerMeasFlag() {
		return bayPowerMeasFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBayPowerMeasFlag(Boolean newBayPowerMeasFlag) {
		Boolean oldBayPowerMeasFlag = bayPowerMeasFlag;
		bayPowerMeasFlag = newBayPowerMeasFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BAY__BAY_POWER_MEAS_FLAG, oldBayPowerMeasFlag, bayPowerMeasFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakerConfiguration getBreakerConfiguration() {
		return breakerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakerConfiguration(BreakerConfiguration newBreakerConfiguration) {
		BreakerConfiguration oldBreakerConfiguration = breakerConfiguration;
		breakerConfiguration = newBreakerConfiguration == null ? BREAKER_CONFIGURATION_EDEFAULT : newBreakerConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BAY__BREAKER_CONFIGURATION, oldBreakerConfiguration, breakerConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusbarConfiguration getBusBarConfiguration() {
		return busBarConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusBarConfiguration(BusbarConfiguration newBusBarConfiguration) {
		BusbarConfiguration oldBusBarConfiguration = busBarConfiguration;
		busBarConfiguration = newBusBarConfiguration == null ? BUS_BAR_CONFIGURATION_EDEFAULT : newBusBarConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BAY__BUS_BAR_CONFIGURATION, oldBusBarConfiguration, busBarConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoltageLevel getVoltageLevel() {
		if (eContainerFeatureID != CorePackage.BAY__VOLTAGE_LEVEL) return null;
		return (VoltageLevel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVoltageLevel(VoltageLevel newVoltageLevel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVoltageLevel, CorePackage.BAY__VOLTAGE_LEVEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoltageLevel(VoltageLevel newVoltageLevel) {
		if (newVoltageLevel != eInternalContainer() || (eContainerFeatureID != CorePackage.BAY__VOLTAGE_LEVEL && newVoltageLevel != null)) {
			if (EcoreUtil.isAncestor(this, newVoltageLevel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVoltageLevel != null)
				msgs = ((InternalEObject)newVoltageLevel).eInverseAdd(this, CorePackage.VOLTAGE_LEVEL__BAYS, VoltageLevel.class, msgs);
			msgs = basicSetVoltageLevel(newVoltageLevel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BAY__VOLTAGE_LEVEL, newVoltageLevel, newVoltageLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Substation getSubstation() {
		if (eContainerFeatureID != CorePackage.BAY__SUBSTATION) return null;
		return (Substation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubstation(Substation newSubstation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSubstation, CorePackage.BAY__SUBSTATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstation(Substation newSubstation) {
		if (newSubstation != eInternalContainer() || (eContainerFeatureID != CorePackage.BAY__SUBSTATION && newSubstation != null)) {
			if (EcoreUtil.isAncestor(this, newSubstation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSubstation != null)
				msgs = ((InternalEObject)newSubstation).eInverseAdd(this, CorePackage.SUBSTATION__BAYS, Substation.class, msgs);
			msgs = basicSetSubstation(newSubstation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BAY__SUBSTATION, newSubstation, newSubstation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.BAY__VOLTAGE_LEVEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVoltageLevel((VoltageLevel)otherEnd, msgs);
			case CorePackage.BAY__SUBSTATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSubstation((Substation)otherEnd, msgs);
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
			case CorePackage.BAY__VOLTAGE_LEVEL:
				return basicSetVoltageLevel(null, msgs);
			case CorePackage.BAY__SUBSTATION:
				return basicSetSubstation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case CorePackage.BAY__VOLTAGE_LEVEL:
				return eInternalContainer().eInverseRemove(this, CorePackage.VOLTAGE_LEVEL__BAYS, VoltageLevel.class, msgs);
			case CorePackage.BAY__SUBSTATION:
				return eInternalContainer().eInverseRemove(this, CorePackage.SUBSTATION__BAYS, Substation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.BAY__BAY_ENERGY_MEAS_FLAG:
				return getBayEnergyMeasFlag();
			case CorePackage.BAY__BAY_POWER_MEAS_FLAG:
				return getBayPowerMeasFlag();
			case CorePackage.BAY__BREAKER_CONFIGURATION:
				return getBreakerConfiguration();
			case CorePackage.BAY__BUS_BAR_CONFIGURATION:
				return getBusBarConfiguration();
			case CorePackage.BAY__VOLTAGE_LEVEL:
				return getVoltageLevel();
			case CorePackage.BAY__SUBSTATION:
				return getSubstation();
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
			case CorePackage.BAY__BAY_ENERGY_MEAS_FLAG:
				setBayEnergyMeasFlag((Boolean)newValue);
				return;
			case CorePackage.BAY__BAY_POWER_MEAS_FLAG:
				setBayPowerMeasFlag((Boolean)newValue);
				return;
			case CorePackage.BAY__BREAKER_CONFIGURATION:
				setBreakerConfiguration((BreakerConfiguration)newValue);
				return;
			case CorePackage.BAY__BUS_BAR_CONFIGURATION:
				setBusBarConfiguration((BusbarConfiguration)newValue);
				return;
			case CorePackage.BAY__VOLTAGE_LEVEL:
				setVoltageLevel((VoltageLevel)newValue);
				return;
			case CorePackage.BAY__SUBSTATION:
				setSubstation((Substation)newValue);
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
			case CorePackage.BAY__BAY_ENERGY_MEAS_FLAG:
				setBayEnergyMeasFlag(BAY_ENERGY_MEAS_FLAG_EDEFAULT);
				return;
			case CorePackage.BAY__BAY_POWER_MEAS_FLAG:
				setBayPowerMeasFlag(BAY_POWER_MEAS_FLAG_EDEFAULT);
				return;
			case CorePackage.BAY__BREAKER_CONFIGURATION:
				setBreakerConfiguration(BREAKER_CONFIGURATION_EDEFAULT);
				return;
			case CorePackage.BAY__BUS_BAR_CONFIGURATION:
				setBusBarConfiguration(BUS_BAR_CONFIGURATION_EDEFAULT);
				return;
			case CorePackage.BAY__VOLTAGE_LEVEL:
				setVoltageLevel((VoltageLevel)null);
				return;
			case CorePackage.BAY__SUBSTATION:
				setSubstation((Substation)null);
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
			case CorePackage.BAY__BAY_ENERGY_MEAS_FLAG:
				return BAY_ENERGY_MEAS_FLAG_EDEFAULT == null ? bayEnergyMeasFlag != null : !BAY_ENERGY_MEAS_FLAG_EDEFAULT.equals(bayEnergyMeasFlag);
			case CorePackage.BAY__BAY_POWER_MEAS_FLAG:
				return BAY_POWER_MEAS_FLAG_EDEFAULT == null ? bayPowerMeasFlag != null : !BAY_POWER_MEAS_FLAG_EDEFAULT.equals(bayPowerMeasFlag);
			case CorePackage.BAY__BREAKER_CONFIGURATION:
				return breakerConfiguration != BREAKER_CONFIGURATION_EDEFAULT;
			case CorePackage.BAY__BUS_BAR_CONFIGURATION:
				return busBarConfiguration != BUS_BAR_CONFIGURATION_EDEFAULT;
			case CorePackage.BAY__VOLTAGE_LEVEL:
				return getVoltageLevel() != null;
			case CorePackage.BAY__SUBSTATION:
				return getSubstation() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("Bay: " + super.toString() + "\n");
		result.append(" (bayEnergyMeasFlag: ");
		result.append(bayEnergyMeasFlag);
		result.append(", bayPowerMeasFlag: ");
		result.append(bayPowerMeasFlag);
		result.append(", breakerConfiguration: ");
		result.append(breakerConfiguration);
		result.append(", busBarConfiguration: ");
		result.append(busBarConfiguration);
		result.append(')' + "\n");
		
		for (Object obj : this.getEquipments()) {
			result.append("     Connected Equipment: " + ((Equipment)obj).getMRID() + "\n");
		}
		return result.toString();
	}

} //BayImpl