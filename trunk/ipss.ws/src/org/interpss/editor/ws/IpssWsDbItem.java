/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Db Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssWsDbItem#getDbId <em>Db Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsDbItem()
 * @model
 * @generated
 */
public interface IpssWsDbItem extends IpssWsItem {
	/**
	 * Returns the value of the '<em><b>Db Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Id</em>' attribute.
	 * @see #setDbId(int)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsDbItem_DbId()
	 * @model
	 * @generated
	 */
	int getDbId();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWsDbItem#getDbId <em>Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Id</em>' attribute.
	 * @see #getDbId()
	 * @generated
	 */
	void setDbId(int value);

} // IpssWsDbItem
