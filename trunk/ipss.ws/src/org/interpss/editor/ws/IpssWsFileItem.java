/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssWsFileItem#getInitStatus <em>Init Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsFileItem()
 * @model abstract="true"
 * @generated
 */
public interface IpssWsFileItem extends IpssWsItem {
	/**
	 * Returns the value of the '<em><b>Init Status</b></em>' attribute.
	 * The default value is <code>"Close"</code>.
	 * The literals are from the enumeration {@link org.interpss.editor.ws.WsItemInitStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Status</em>' attribute.
	 * @see org.interpss.editor.ws.WsItemInitStatus
	 * @see #setInitStatus(WsItemInitStatus)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsFileItem_InitStatus()
	 * @model default="Close"
	 * @generated
	 */
	WsItemInitStatus getInitStatus();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWsFileItem#getInitStatus <em>Init Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Status</em>' attribute.
	 * @see org.interpss.editor.ws.WsItemInitStatus
	 * @see #getInitStatus()
	 * @generated
	 */
	void setInitStatus(WsItemInitStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getFilename();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getFileExt();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getFilenameNoExt();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isOpen();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isActive();

} // IpssWsFileItem
