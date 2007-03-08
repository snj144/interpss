/**
 * <copyright>
 * </copyright>
 *
 * $Id: PowerSystemResource.java,v 1.2 2007/03/05 04:50:39 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.SimulationModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power System Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A power system resource can be an item of equipment such as a Switch, an EquipmentContainer containing many individual items of equipment such as a 
 * Substation, or an organisational entity such as Company or SubControlArea.  This provides for the nesting of collections of PowerSystemResources within other PowerSystemResources. For example, a Switch could be a member of a Substation and a Substation could be a member of a division of a Company.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.PowerSystemResource#getSimuModel <em>Simu Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.PowerSystemResource#getCompanies <em>Companies</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.PowerSystemResource#getPSRType <em>PSR Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getPowerSystemResource()
 * @model
 * @generated
 */
public interface PowerSystemResource extends Naming {
	/**
	 * Returns the value of the '<em><b>Simu Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.SimulationModel#getPsResources <em>Ps Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simu Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simu Model</em>' container reference.
	 * @see #setSimuModel(SimulationModel)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getPowerSystemResource_SimuModel()
	 * @see org.opencim.cim.SimulationModel#getPsResources
	 * @model opposite="psResources" required="true"
	 * @generated
	 */
	SimulationModel getSimuModel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getSimuModel <em>Simu Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simu Model</em>' container reference.
	 * @see #getSimuModel()
	 * @generated
	 */
	void setSimuModel(SimulationModel value);

	/**
	 * Returns the value of the '<em><b>Companies</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Company}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Company#getPSRs <em>PS Rs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A power system resource may be part of one or more companies
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Companies</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getPowerSystemResource_Companies()
	 * @see org.opencim.cim.iec61970.core.Company#getPSRs
	 * @model type="org.opencim.cim.iec61970.core.Company" opposite="PSRs"
	 * @generated
	 */
	EList getCompanies();

	/**
	 * Returns the value of the '<em><b>PSR Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.PSRType#getPowerSystemResource <em>Power System Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PSR Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PSR Type</em>' reference.
	 * @see #setPSRType(PSRType)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getPowerSystemResource_PSRType()
	 * @see org.opencim.cim.iec61970.core.PSRType#getPowerSystemResource
	 * @model opposite="PowerSystemResource"
	 * @generated
	 */
	PSRType getPSRType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getPSRType <em>PSR Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PSR Type</em>' reference.
	 * @see #getPSRType()
	 * @generated
	 */
	void setPSRType(PSRType value);

} // PowerSystemResource