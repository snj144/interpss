/**
 * <copyright>
 * </copyright>
 *
 * $Id: Company.java,v 1.2 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.SimulationModel;

import org.opencim.cim.iec61970.domain.CompanyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A company is a legal entity that owns and operates power system resources and is a party to interchange and transmission contracts.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.Company#getSimuModel <em>Simu Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Company#getCompanyType <em>Company Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Company#getPSRs <em>PS Rs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends Naming {
	/**
	 * Returns the value of the '<em><b>Simu Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.SimulationModel#getCompanies <em>Companies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simu Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simu Model</em>' container reference.
	 * @see #setSimuModel(SimulationModel)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCompany_SimuModel()
	 * @see org.opencim.cim.SimulationModel#getCompanies
	 * @model opposite="companies" required="true"
	 * @generated
	 */
	SimulationModel getSimuModel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Company#getSimuModel <em>Simu Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simu Model</em>' container reference.
	 * @see #getSimuModel()
	 * @generated
	 */
	void setSimuModel(SimulationModel value);

	/**
	 * Returns the value of the '<em><b>Company Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.CompanyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of company, e.g.: pool, municipal, private
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Company Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CompanyType
	 * @see #setCompanyType(CompanyType)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCompany_CompanyType()
	 * @model
	 * @generated
	 */
	CompanyType getCompanyType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Company#getCompanyType <em>Company Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.CompanyType
	 * @see #getCompanyType()
	 * @generated
	 */
	void setCompanyType(CompanyType value);

	/**
	 * Returns the value of the '<em><b>PS Rs</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.PowerSystemResource}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getCompanies <em>Companies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A power system resource may be part of one or more companies
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>PS Rs</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getCompany_PSRs()
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource#getCompanies
	 * @model type="org.opencim.cim.iec61970.core.PowerSystemResource" opposite="Companies"
	 * @generated
	 */
	EList getPSRs();

} // Company