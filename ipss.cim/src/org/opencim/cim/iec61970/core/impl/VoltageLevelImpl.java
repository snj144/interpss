/**
 * <copyright>
 * </copyright>
 *
 * $Id: VoltageLevelImpl.java,v 1.3 2007/03/07 05:14:03 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;

import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Voltage Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl#getHighVoltageLimit <em>High Voltage Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl#getLowVoltageLimit <em>Low Voltage Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl#getSubstation <em>Substation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl#getBays <em>Bays</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.VoltageLevelImpl#getBaseVoltage <em>Base Voltage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VoltageLevelImpl extends EquipmentContainerImpl implements VoltageLevel {
	/**
	 * The default value of the '{@link #getHighVoltageLimit() <em>High Voltage Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighVoltageLimit()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage HIGH_VOLTAGE_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHighVoltageLimit() <em>High Voltage Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighVoltageLimit()
	 * @generated
	 * @ordered
	 */
	protected Voltage highVoltageLimit = HIGH_VOLTAGE_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowVoltageLimit() <em>Low Voltage Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowVoltageLimit()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage LOW_VOLTAGE_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowVoltageLimit() <em>Low Voltage Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowVoltageLimit()
	 * @generated
	 * @ordered
	 */
	protected Voltage lowVoltageLimit = LOW_VOLTAGE_LIMIT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBays() <em>Bays</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBays()
	 * @generated
	 * @ordered
	 */
	protected EList bays;

	/**
	 * The cached value of the '{@link #getBaseVoltage() <em>Base Voltage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVoltage()
	 * @generated
	 * @ordered
	 */
	protected BaseVoltage baseVoltage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoltageLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.VOLTAGE_LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getHighVoltageLimit() {
		return highVoltageLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighVoltageLimit(Voltage newHighVoltageLimit) {
		Voltage oldHighVoltageLimit = highVoltageLimit;
		highVoltageLimit = newHighVoltageLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT, oldHighVoltageLimit, highVoltageLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getLowVoltageLimit() {
		return lowVoltageLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowVoltageLimit(Voltage newLowVoltageLimit) {
		Voltage oldLowVoltageLimit = lowVoltageLimit;
		lowVoltageLimit = newLowVoltageLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT, oldLowVoltageLimit, lowVoltageLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Substation getSubstation() {
		if (eContainerFeatureID != CorePackage.VOLTAGE_LEVEL__SUBSTATION) return null;
		return (Substation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubstation(Substation newSubstation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSubstation, CorePackage.VOLTAGE_LEVEL__SUBSTATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstation(Substation newSubstation) {
		if (newSubstation != eInternalContainer() || (eContainerFeatureID != CorePackage.VOLTAGE_LEVEL__SUBSTATION && newSubstation != null)) {
			if (EcoreUtil.isAncestor(this, newSubstation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSubstation != null)
				msgs = ((InternalEObject)newSubstation).eInverseAdd(this, CorePackage.SUBSTATION__VOLTAGE_LEVELS, Substation.class, msgs);
			msgs = basicSetSubstation(newSubstation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VOLTAGE_LEVEL__SUBSTATION, newSubstation, newSubstation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBays() {
		if (bays == null) {
			bays = new EObjectContainmentWithInverseEList(Bay.class, this, CorePackage.VOLTAGE_LEVEL__BAYS, CorePackage.BAY__VOLTAGE_LEVEL);
		}
		return bays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseVoltage getBaseVoltage() {
		if (baseVoltage != null && baseVoltage.eIsProxy()) {
			InternalEObject oldBaseVoltage = (InternalEObject)baseVoltage;
			baseVoltage = (BaseVoltage)eResolveProxy(oldBaseVoltage);
			if (baseVoltage != oldBaseVoltage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE, oldBaseVoltage, baseVoltage));
			}
		}
		return baseVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseVoltage basicGetBaseVoltage() {
		return baseVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseVoltage(BaseVoltage newBaseVoltage, NotificationChain msgs) {
		BaseVoltage oldBaseVoltage = baseVoltage;
		baseVoltage = newBaseVoltage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE, oldBaseVoltage, newBaseVoltage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVoltage(BaseVoltage newBaseVoltage) {
		if (newBaseVoltage != baseVoltage) {
			NotificationChain msgs = null;
			if (baseVoltage != null)
				msgs = ((InternalEObject)baseVoltage).eInverseRemove(this, CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL, BaseVoltage.class, msgs);
			if (newBaseVoltage != null)
				msgs = ((InternalEObject)newBaseVoltage).eInverseAdd(this, CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL, BaseVoltage.class, msgs);
			msgs = basicSetBaseVoltage(newBaseVoltage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE, newBaseVoltage, newBaseVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSubstation((Substation)otherEnd, msgs);
			case CorePackage.VOLTAGE_LEVEL__BAYS:
				return ((InternalEList)getBays()).basicAdd(otherEnd, msgs);
			case CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE:
				if (baseVoltage != null)
					msgs = ((InternalEObject)baseVoltage).eInverseRemove(this, CorePackage.BASE_VOLTAGE__VOLTAGE_LEVEL, BaseVoltage.class, msgs);
				return basicSetBaseVoltage((BaseVoltage)otherEnd, msgs);
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
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				return basicSetSubstation(null, msgs);
			case CorePackage.VOLTAGE_LEVEL__BAYS:
				return ((InternalEList)getBays()).basicRemove(otherEnd, msgs);
			case CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE:
				return basicSetBaseVoltage(null, msgs);
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
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				return eInternalContainer().eInverseRemove(this, CorePackage.SUBSTATION__VOLTAGE_LEVELS, Substation.class, msgs);
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
			case CorePackage.VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT:
				return getHighVoltageLimit();
			case CorePackage.VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT:
				return getLowVoltageLimit();
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				return getSubstation();
			case CorePackage.VOLTAGE_LEVEL__BAYS:
				return getBays();
			case CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE:
				if (resolve) return getBaseVoltage();
				return basicGetBaseVoltage();
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
			case CorePackage.VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT:
				setHighVoltageLimit((Voltage)newValue);
				return;
			case CorePackage.VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT:
				setLowVoltageLimit((Voltage)newValue);
				return;
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				setSubstation((Substation)newValue);
				return;
			case CorePackage.VOLTAGE_LEVEL__BAYS:
				getBays().clear();
				getBays().addAll((Collection)newValue);
				return;
			case CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE:
				setBaseVoltage((BaseVoltage)newValue);
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
			case CorePackage.VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT:
				setHighVoltageLimit(HIGH_VOLTAGE_LIMIT_EDEFAULT);
				return;
			case CorePackage.VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT:
				setLowVoltageLimit(LOW_VOLTAGE_LIMIT_EDEFAULT);
				return;
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				setSubstation((Substation)null);
				return;
			case CorePackage.VOLTAGE_LEVEL__BAYS:
				getBays().clear();
				return;
			case CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE:
				setBaseVoltage((BaseVoltage)null);
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
			case CorePackage.VOLTAGE_LEVEL__HIGH_VOLTAGE_LIMIT:
				return HIGH_VOLTAGE_LIMIT_EDEFAULT == null ? highVoltageLimit != null : !HIGH_VOLTAGE_LIMIT_EDEFAULT.equals(highVoltageLimit);
			case CorePackage.VOLTAGE_LEVEL__LOW_VOLTAGE_LIMIT:
				return LOW_VOLTAGE_LIMIT_EDEFAULT == null ? lowVoltageLimit != null : !LOW_VOLTAGE_LIMIT_EDEFAULT.equals(lowVoltageLimit);
			case CorePackage.VOLTAGE_LEVEL__SUBSTATION:
				return getSubstation() != null;
			case CorePackage.VOLTAGE_LEVEL__BAYS:
				return bays != null && !bays.isEmpty();
			case CorePackage.VOLTAGE_LEVEL__BASE_VOLTAGE:
				return baseVoltage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer("\nVoltageLevel: \n" + super.toString() + "\n");
		result.append(" (highVoltageLimit: ");
		result.append(highVoltageLimit);
		result.append(", lowVoltageLimit: ");
		result.append(lowVoltageLimit);
		result.append(')' + "\n");
		result.append("     BaseVoltage: " + getBaseVoltage().getMRID() + "\n");
		
		if (getBays().size() > 0)
			result.append(getBays().toString() + "\n");
				
		return result.toString();
	}

} //VoltageLevelImpl