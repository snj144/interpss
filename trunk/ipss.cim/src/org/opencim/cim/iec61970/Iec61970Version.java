/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iec61970Version.java,v 1.1 2007/03/02 14:01:18 mzhou Exp $
 */
package org.opencim.cim.iec61970;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is the CIM version number assigned to this UML model file.
 * 
 * cim61970_v002 was created from cim10_v000_WG13cimIssues_61968_Rev6_22Feb2005 that is the merged wg13 and wg14 models. The content has a number of wg13 issue resolutions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.Iec61970Version#getVersion <em>Version</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.Iec61970Version#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.Iec61970Package#getIec61970Version()
 * @model
 * @generated
 */
public interface Iec61970Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"cim61970_v002"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.opencim.cim.iec61970.Iec61970Package#getIec61970Version_Version()
	 * @model default="cim61970_v002"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.Iec61970Version#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * The default value is <code>"2005-04-28"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.opencim.cim.iec61970.Iec61970Package#getIec61970Version_Date()
	 * @model default="2005-04-28" dataType="org.opencim.cim.iec61970.domain.Date"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.Iec61970Version#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // Iec61970Version