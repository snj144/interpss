/**
 * <copyright>
 * </copyright>
 *
 * $Id: Naming.java,v 1.1 2007/03/02 14:01:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Naming</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a root class to provide common naming attributes for all classes needing naming attributes
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.Naming#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Naming#getDescription <em>Description</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Naming#getName <em>Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Naming#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.Naming#getMRID <em>MRID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getNaming()
 * @model
 * @generated
 */
public interface Naming extends EObject {
	/**
	 * Returns the value of the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free text name of the object or instance. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alias Name</em>' attribute.
	 * @see #setAliasName(String)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getNaming_AliasName()
	 * @model
	 * @generated
	 */
	String getAliasName();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Naming#getAliasName <em>Alias Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias Name</em>' attribute.
	 * @see #getAliasName()
	 * @generated
	 */
	void setAliasName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description of the object or instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getNaming_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Naming#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unique name among objects owned by the same parent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getNaming_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Naming#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * pathName is a concatenation of all names from each container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path Name</em>' attribute.
	 * @see #setPathName(String)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getNaming_PathName()
	 * @model
	 * @generated
	 */
	String getPathName();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Naming#getPathName <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' attribute.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(String value);

	/**
	 * Returns the value of the '<em><b>MRID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Master Resource ID is used to uniquely identify an object instance throughout a system.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MRID</em>' attribute.
	 * @see #setMRID(String)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getNaming_MRID()
	 * @model
	 * @generated
	 */
	String getMRID();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.Naming#getMRID <em>MRID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MRID</em>' attribute.
	 * @see #getMRID()
	 * @generated
	 */
	void setMRID(String value);

} // Naming