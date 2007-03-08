/**
 * <copyright>
 * </copyright>
 *
 * $Id: PowerSystemResourceImpl.java,v 1.3 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.SimulationModel;
import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.PSRType;
import org.opencim.cim.iec61970.core.PowerSystemResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power System Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl#getSimuModel <em>Simu Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl#getCompanies <em>Companies</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl#getPSRType <em>PSR Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerSystemResourceImpl extends NamingImpl implements PowerSystemResource {
	/**
	 * The cached value of the '{@link #getCompanies() <em>Companies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanies()
	 * @generated
	 * @ordered
	 */
	protected EList companies = null;

	/**
	 * The cached value of the '{@link #getPSRType() <em>PSR Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPSRType()
	 * @generated
	 * @ordered
	 */
	protected PSRType psrType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerSystemResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.POWER_SYSTEM_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel getSimuModel() {
		if (eContainerFeatureID != CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL) return null;
		return (SimulationModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimuModel(SimulationModel newSimuModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimuModel, CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimuModel(SimulationModel newSimuModel) {
		if (newSimuModel != eInternalContainer() || (eContainerFeatureID != CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL && newSimuModel != null)) {
			if (EcoreUtil.isAncestor(this, newSimuModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimuModel != null)
				msgs = ((InternalEObject)newSimuModel).eInverseAdd(this, cimPackage.SIMULATION_MODEL__PS_RESOURCES, SimulationModel.class, msgs);
			msgs = basicSetSimuModel(newSimuModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL, newSimuModel, newSimuModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompanies() {
		if (companies == null) {
			companies = new EObjectWithInverseResolvingEList.ManyInverse(Company.class, this, CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES, CorePackage.COMPANY__PS_RS);
		}
		return companies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSRType getPSRType() {
		if (psrType != null && psrType.eIsProxy()) {
			InternalEObject oldPSRType = (InternalEObject)psrType;
			psrType = (PSRType)eResolveProxy(oldPSRType);
			if (psrType != oldPSRType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE, oldPSRType, psrType));
			}
		}
		return psrType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSRType basicGetPSRType() {
		return psrType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPSRType(PSRType newPSRType, NotificationChain msgs) {
		PSRType oldPSRType = psrType;
		psrType = newPSRType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE, oldPSRType, newPSRType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPSRType(PSRType newPSRType) {
		if (newPSRType != psrType) {
			NotificationChain msgs = null;
			if (psrType != null)
				msgs = ((InternalEObject)psrType).eInverseRemove(this, CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE, PSRType.class, msgs);
			if (newPSRType != null)
				msgs = ((InternalEObject)newPSRType).eInverseAdd(this, CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE, PSRType.class, msgs);
			msgs = basicSetPSRType(newPSRType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE, newPSRType, newPSRType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimuModel((SimulationModel)otherEnd, msgs);
			case CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES:
				return ((InternalEList)getCompanies()).basicAdd(otherEnd, msgs);
			case CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE:
				if (psrType != null)
					msgs = ((InternalEObject)psrType).eInverseRemove(this, CorePackage.PSR_TYPE__POWER_SYSTEM_RESOURCE, PSRType.class, msgs);
				return basicSetPSRType((PSRType)otherEnd, msgs);
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
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				return basicSetSimuModel(null, msgs);
			case CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES:
				return ((InternalEList)getCompanies()).basicRemove(otherEnd, msgs);
			case CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE:
				return basicSetPSRType(null, msgs);
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
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				return eInternalContainer().eInverseRemove(this, cimPackage.SIMULATION_MODEL__PS_RESOURCES, SimulationModel.class, msgs);
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
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				return getSimuModel();
			case CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES:
				return getCompanies();
			case CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE:
				if (resolve) return getPSRType();
				return basicGetPSRType();
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
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				setSimuModel((SimulationModel)newValue);
				return;
			case CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES:
				getCompanies().clear();
				getCompanies().addAll((Collection)newValue);
				return;
			case CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE:
				setPSRType((PSRType)newValue);
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
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				setSimuModel((SimulationModel)null);
				return;
			case CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES:
				getCompanies().clear();
				return;
			case CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE:
				setPSRType((PSRType)null);
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
			case CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL:
				return getSimuModel() != null;
			case CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES:
				return companies != null && !companies.isEmpty();
			case CorePackage.POWER_SYSTEM_RESOURCE__PSR_TYPE:
				return psrType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(super.toString());
		if (getCompanies().size() > 0) {
			result.append("\nCompanies: \n");
			for (Object obj : getCompanies())
				result.append("   Company MRID: " + ((Company)obj).getMRID() + "\n");
		}
		return result.toString();
	}	
} //PowerSystemResourceImpl