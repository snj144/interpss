/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubstationImpl.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;

import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.wire.CompositeSwitch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubstationImpl#getSubControlArea <em>Sub Control Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubstationImpl#getLoadArea <em>Load Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubstationImpl#getVoltageLevels <em>Voltage Levels</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubstationImpl#getBays <em>Bays</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubstationImpl#getContains_CompositeSwitches <em>Contains Composite Switches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubstationImpl extends EquipmentContainerImpl implements Substation {
	/**
	 * The cached value of the '{@link #getLoadArea() <em>Load Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadArea()
	 * @generated
	 * @ordered
	 */
	protected LoadArea loadArea = null;

	/**
	 * The cached value of the '{@link #getVoltageLevels() <em>Voltage Levels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageLevels()
	 * @generated
	 * @ordered
	 */
	protected EList voltageLevels = null;

	/**
	 * The cached value of the '{@link #getBays() <em>Bays</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBays()
	 * @generated
	 * @ordered
	 */
	protected EList bays = null;

	/**
	 * The cached value of the '{@link #getContains_CompositeSwitches() <em>Contains Composite Switches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContains_CompositeSwitches()
	 * @generated
	 * @ordered
	 */
	protected EList contains_CompositeSwitches = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.SUBSTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubControlArea getSubControlArea() {
		if (eContainerFeatureID != CorePackage.SUBSTATION__SUB_CONTROL_AREA) return null;
		return (SubControlArea)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubControlArea(SubControlArea newSubControlArea, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSubControlArea, CorePackage.SUBSTATION__SUB_CONTROL_AREA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubControlArea(SubControlArea newSubControlArea) {
		if (newSubControlArea != eInternalContainer() || (eContainerFeatureID != CorePackage.SUBSTATION__SUB_CONTROL_AREA && newSubControlArea != null)) {
			if (EcoreUtil.isAncestor(this, newSubControlArea))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSubControlArea != null)
				msgs = ((InternalEObject)newSubControlArea).eInverseAdd(this, CorePackage.SUB_CONTROL_AREA__SUBSTATIONS, SubControlArea.class, msgs);
			msgs = basicSetSubControlArea(newSubControlArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SUBSTATION__SUB_CONTROL_AREA, newSubControlArea, newSubControlArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea getLoadArea() {
		if (loadArea != null && loadArea.eIsProxy()) {
			InternalEObject oldLoadArea = (InternalEObject)loadArea;
			loadArea = (LoadArea)eResolveProxy(oldLoadArea);
			if (loadArea != oldLoadArea) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.SUBSTATION__LOAD_AREA, oldLoadArea, loadArea));
			}
		}
		return loadArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea basicGetLoadArea() {
		return loadArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoadArea(LoadArea newLoadArea, NotificationChain msgs) {
		LoadArea oldLoadArea = loadArea;
		loadArea = newLoadArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.SUBSTATION__LOAD_AREA, oldLoadArea, newLoadArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadArea(LoadArea newLoadArea) {
		if (newLoadArea != loadArea) {
			NotificationChain msgs = null;
			if (loadArea != null)
				msgs = ((InternalEObject)loadArea).eInverseRemove(this, LoadPackage.LOAD_AREA__SUBSTATIONS, LoadArea.class, msgs);
			if (newLoadArea != null)
				msgs = ((InternalEObject)newLoadArea).eInverseAdd(this, LoadPackage.LOAD_AREA__SUBSTATIONS, LoadArea.class, msgs);
			msgs = basicSetLoadArea(newLoadArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SUBSTATION__LOAD_AREA, newLoadArea, newLoadArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVoltageLevels() {
		if (voltageLevels == null) {
			voltageLevels = new EObjectContainmentWithInverseEList(VoltageLevel.class, this, CorePackage.SUBSTATION__VOLTAGE_LEVELS, CorePackage.VOLTAGE_LEVEL__SUBSTATION);
		}
		return voltageLevels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBays() {
		if (bays == null) {
			bays = new EObjectContainmentWithInverseEList(Bay.class, this, CorePackage.SUBSTATION__BAYS, CorePackage.BAY__SUBSTATION);
		}
		return bays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContains_CompositeSwitches() {
		if (contains_CompositeSwitches == null) {
			contains_CompositeSwitches = new EObjectContainmentEList(CompositeSwitch.class, this, CorePackage.SUBSTATION__CONTAINS_COMPOSITE_SWITCHES);
		}
		return contains_CompositeSwitches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSubControlArea((SubControlArea)otherEnd, msgs);
			case CorePackage.SUBSTATION__LOAD_AREA:
				if (loadArea != null)
					msgs = ((InternalEObject)loadArea).eInverseRemove(this, LoadPackage.LOAD_AREA__SUBSTATIONS, LoadArea.class, msgs);
				return basicSetLoadArea((LoadArea)otherEnd, msgs);
			case CorePackage.SUBSTATION__VOLTAGE_LEVELS:
				return ((InternalEList)getVoltageLevels()).basicAdd(otherEnd, msgs);
			case CorePackage.SUBSTATION__BAYS:
				return ((InternalEList)getBays()).basicAdd(otherEnd, msgs);
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
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				return basicSetSubControlArea(null, msgs);
			case CorePackage.SUBSTATION__LOAD_AREA:
				return basicSetLoadArea(null, msgs);
			case CorePackage.SUBSTATION__VOLTAGE_LEVELS:
				return ((InternalEList)getVoltageLevels()).basicRemove(otherEnd, msgs);
			case CorePackage.SUBSTATION__BAYS:
				return ((InternalEList)getBays()).basicRemove(otherEnd, msgs);
			case CorePackage.SUBSTATION__CONTAINS_COMPOSITE_SWITCHES:
				return ((InternalEList)getContains_CompositeSwitches()).basicRemove(otherEnd, msgs);
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
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				return eInternalContainer().eInverseRemove(this, CorePackage.SUB_CONTROL_AREA__SUBSTATIONS, SubControlArea.class, msgs);
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
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				return getSubControlArea();
			case CorePackage.SUBSTATION__LOAD_AREA:
				if (resolve) return getLoadArea();
				return basicGetLoadArea();
			case CorePackage.SUBSTATION__VOLTAGE_LEVELS:
				return getVoltageLevels();
			case CorePackage.SUBSTATION__BAYS:
				return getBays();
			case CorePackage.SUBSTATION__CONTAINS_COMPOSITE_SWITCHES:
				return getContains_CompositeSwitches();
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
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				setSubControlArea((SubControlArea)newValue);
				return;
			case CorePackage.SUBSTATION__LOAD_AREA:
				setLoadArea((LoadArea)newValue);
				return;
			case CorePackage.SUBSTATION__VOLTAGE_LEVELS:
				getVoltageLevels().clear();
				getVoltageLevels().addAll((Collection)newValue);
				return;
			case CorePackage.SUBSTATION__BAYS:
				getBays().clear();
				getBays().addAll((Collection)newValue);
				return;
			case CorePackage.SUBSTATION__CONTAINS_COMPOSITE_SWITCHES:
				getContains_CompositeSwitches().clear();
				getContains_CompositeSwitches().addAll((Collection)newValue);
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
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				setSubControlArea((SubControlArea)null);
				return;
			case CorePackage.SUBSTATION__LOAD_AREA:
				setLoadArea((LoadArea)null);
				return;
			case CorePackage.SUBSTATION__VOLTAGE_LEVELS:
				getVoltageLevels().clear();
				return;
			case CorePackage.SUBSTATION__BAYS:
				getBays().clear();
				return;
			case CorePackage.SUBSTATION__CONTAINS_COMPOSITE_SWITCHES:
				getContains_CompositeSwitches().clear();
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
			case CorePackage.SUBSTATION__SUB_CONTROL_AREA:
				return getSubControlArea() != null;
			case CorePackage.SUBSTATION__LOAD_AREA:
				return loadArea != null;
			case CorePackage.SUBSTATION__VOLTAGE_LEVELS:
				return voltageLevels != null && !voltageLevels.isEmpty();
			case CorePackage.SUBSTATION__BAYS:
				return bays != null && !bays.isEmpty();
			case CorePackage.SUBSTATION__CONTAINS_COMPOSITE_SWITCHES:
				return contains_CompositeSwitches != null && !contains_CompositeSwitches.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("Substation: \n" + super.toString() + "\n");

		if (getVoltageLevels().size() > 0)
			result.append(getVoltageLevels().toString() + "\n");

		if (getBays().size() > 0)
			result.append(getBays().toString() + "\n");
		
		if (this.getEquipments().size() > 0)
			result.append(this.getEquipments().toString() + "\n");

		return result.toString();
	}
	
} //SubstationImpl