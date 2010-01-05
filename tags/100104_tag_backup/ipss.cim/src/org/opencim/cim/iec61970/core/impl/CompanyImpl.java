/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompanyImpl.java,v 1.3 2007/03/07 05:14:04 mzhou Exp $
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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.SimulationModel;
import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.domain.CompanyType;

import org.opencim.cim.impl.cimPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CompanyImpl#getSimuModel <em>Simu Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CompanyImpl#getCompanyType <em>Company Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CompanyImpl#getPSRs <em>PS Rs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyImpl extends NamingImpl implements Company {
	/**
	 * The default value of the '{@link #getCompanyType() <em>Company Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanyType()
	 * @generated
	 * @ordered
	 */
	protected static final CompanyType COMPANY_TYPE_EDEFAULT = CompanyType.POOL_LITERAL;

	/**
	 * The cached value of the '{@link #getCompanyType() <em>Company Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanyType()
	 * @generated
	 * @ordered
	 */
	protected CompanyType companyType = COMPANY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPSRs() <em>PS Rs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPSRs()
	 * @generated
	 * @ordered
	 */
	protected EList psRs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompanyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMPANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel getSimuModel() {
		if (eContainerFeatureID != CorePackage.COMPANY__SIMU_MODEL) return null;
		return (SimulationModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimuModel(SimulationModel newSimuModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimuModel, CorePackage.COMPANY__SIMU_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimuModel(SimulationModel newSimuModel) {
		if (newSimuModel != eInternalContainer() || (eContainerFeatureID != CorePackage.COMPANY__SIMU_MODEL && newSimuModel != null)) {
			if (EcoreUtil.isAncestor(this, newSimuModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimuModel != null)
				msgs = ((InternalEObject)newSimuModel).eInverseAdd(this, cimPackage.SIMULATION_MODEL__COMPANIES, SimulationModel.class, msgs);
			msgs = basicSetSimuModel(newSimuModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPANY__SIMU_MODEL, newSimuModel, newSimuModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanyType getCompanyType() {
		return companyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompanyType(CompanyType newCompanyType) {
		CompanyType oldCompanyType = companyType;
		companyType = newCompanyType == null ? COMPANY_TYPE_EDEFAULT : newCompanyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMPANY__COMPANY_TYPE, oldCompanyType, companyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPSRs() {
		if (psRs == null) {
			psRs = new EObjectWithInverseResolvingEList.ManyInverse(PowerSystemResource.class, this, CorePackage.COMPANY__PS_RS, CorePackage.POWER_SYSTEM_RESOURCE__COMPANIES);
		}
		return psRs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.COMPANY__SIMU_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimuModel((SimulationModel)otherEnd, msgs);
			case CorePackage.COMPANY__PS_RS:
				return ((InternalEList)getPSRs()).basicAdd(otherEnd, msgs);
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
			case CorePackage.COMPANY__SIMU_MODEL:
				return basicSetSimuModel(null, msgs);
			case CorePackage.COMPANY__PS_RS:
				return ((InternalEList)getPSRs()).basicRemove(otherEnd, msgs);
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
			case CorePackage.COMPANY__SIMU_MODEL:
				return eInternalContainer().eInverseRemove(this, cimPackage.SIMULATION_MODEL__COMPANIES, SimulationModel.class, msgs);
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
			case CorePackage.COMPANY__SIMU_MODEL:
				return getSimuModel();
			case CorePackage.COMPANY__COMPANY_TYPE:
				return getCompanyType();
			case CorePackage.COMPANY__PS_RS:
				return getPSRs();
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
			case CorePackage.COMPANY__SIMU_MODEL:
				setSimuModel((SimulationModel)newValue);
				return;
			case CorePackage.COMPANY__COMPANY_TYPE:
				setCompanyType((CompanyType)newValue);
				return;
			case CorePackage.COMPANY__PS_RS:
				getPSRs().clear();
				getPSRs().addAll((Collection)newValue);
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
			case CorePackage.COMPANY__SIMU_MODEL:
				setSimuModel((SimulationModel)null);
				return;
			case CorePackage.COMPANY__COMPANY_TYPE:
				setCompanyType(COMPANY_TYPE_EDEFAULT);
				return;
			case CorePackage.COMPANY__PS_RS:
				getPSRs().clear();
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
			case CorePackage.COMPANY__SIMU_MODEL:
				return getSimuModel() != null;
			case CorePackage.COMPANY__COMPANY_TYPE:
				return companyType != COMPANY_TYPE_EDEFAULT;
			case CorePackage.COMPANY__PS_RS:
				return psRs != null && !psRs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("Company: \n" + super.toString());
		result.append(" (companyType: ");
		result.append(companyType);
		result.append(')' + "\n");
		return result.toString();
	}

} //CompanyImpl