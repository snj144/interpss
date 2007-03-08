/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadModelVersion.java,v 1.1 2007/03/02 14:01:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadModelVersion#getVersion <em>Version</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.LoadModelVersion#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadModelVersion()
 * @model
 * @generated
 */
public interface LoadModelVersion extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"LoadModel_v001"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadModelVersion_Version()
	 * @model default="LoadModel_v001"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.LoadModelVersion#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * The default value is <code>"2004-06-30"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getLoadModelVersion_Date()
	 * @model default="2004-06-30" dataType="org.opencim.cim.iec61970.domain.Date"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.LoadModelVersion#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // LoadModelVersion