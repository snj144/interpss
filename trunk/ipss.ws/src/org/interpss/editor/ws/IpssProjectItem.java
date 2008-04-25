/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Project Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssProjectItem#getIntStatus <em>Int Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssProjectItem()
 * @model
 * @generated
 */
public interface IpssProjectItem extends IpssWsItem {

	/**
	 * Returns the value of the '<em><b>Int Status</b></em>' attribute.
	 * The default value is <code>"Close"</code>.
	 * The literals are from the enumeration {@link org.interpss.editor.ws.WsItemInitStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Int Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Int Status</em>' attribute.
	 * @see org.interpss.editor.ws.WsItemInitStatus
	 * @see #setIntStatus(WsItemInitStatus)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssProjectItem_IntStatus()
	 * @model default="Close"
	 * @generated
	 */
	WsItemInitStatus getIntStatus();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssProjectItem#getIntStatus <em>Int Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int Status</em>' attribute.
	 * @see org.interpss.editor.ws.WsItemInitStatus
	 * @see #getIntStatus()
	 * @generated
	 */
	void setIntStatus(WsItemInitStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	IpssProject getParentProject();
} // IpssProjectItem
