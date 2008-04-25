/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Work Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssWorkSpace#getRootDir <em>Root Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWorkSpace()
 * @model
 * @generated
 */
public interface IpssWorkSpace extends IpssWsItemContainer {

	/**
	 * Returns the value of the '<em><b>Root Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Dir</em>' attribute.
	 * @see #setRootDir(String)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWorkSpace_RootDir()
	 * @model
	 * @generated
	 */
	String getRootDir();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWorkSpace#getRootDir <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Dir</em>' attribute.
	 * @see #getRootDir()
	 * @generated
	 */
	void setRootDir(String value);
} // IpssWorkSpace
