/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssProject#getProjDbId <em>Proj Db Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssProject()
 * @model
 * @generated
 */
public interface IpssProject extends IpssWsItemContainer {

	/**
	 * Returns the value of the '<em><b>Proj Db Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proj Db Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proj Db Id</em>' attribute.
	 * @see #setProjDbId(int)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssProject_ProjDbId()
	 * @model
	 * @generated
	 */
	int getProjDbId();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssProject#getProjDbId <em>Proj Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proj Db Id</em>' attribute.
	 * @see #getProjDbId()
	 * @generated
	 */
	void setProjDbId(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	IpssProjectFolder getParanetFolder();
} // IpssProject
