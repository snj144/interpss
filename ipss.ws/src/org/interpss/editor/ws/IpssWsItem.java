/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;

import org.eclipse.emf.ecore.EObject;
import org.interpss.editor.doc.IpssDocument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssWsItem#getIpssDoc <em>Ipss Doc</em>}</li>
 *   <li>{@link org.interpss.editor.ws.IpssWsItem#getName <em>Name</em>}</li>
 *   <li>{@link org.interpss.editor.ws.IpssWsItem#getInitStatus <em>Init Status</em>}</li>
 *   <li>{@link org.interpss.editor.ws.IpssWsItem#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItem()
 * @model abstract="true"
 * @generated
 */
public interface IpssWsItem extends EObject {

	/**
	 * Returns the value of the '<em><b>Ipss Doc</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.editor.doc.IpssDocument#getWsItem <em>Ws Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ipss Doc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ipss Doc</em>' reference.
	 * @see #setIpssDoc(IpssDocument)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItem_IpssDoc()
	 * @see org.interpss.editor.doc.IpssDocument#getWsItem
	 * @model opposite="wsItem"
	 * @generated
	 */
	IpssDocument getIpssDoc();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWsItem#getIpssDoc <em>Ipss Doc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ipss Doc</em>' reference.
	 * @see #getIpssDoc()
	 * @generated
	 */
	void setIpssDoc(IpssDocument value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"NewItem"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItem_Name()
	 * @model default="NewItem"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWsItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItem_InitStatus()
	 * @model default="Close"
	 * @generated
	 */
	WsItemInitStatus getInitStatus();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWsItem#getInitStatus <em>Init Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Status</em>' attribute.
	 * @see org.interpss.editor.ws.WsItemInitStatus
	 * @see #getInitStatus()
	 * @generated
	 */
	void setInitStatus(WsItemInitStatus value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.editor.ws.IpssWsItemContainer#getWsItemList <em>Ws Item List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(IpssWsItemContainer)
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItem_Parent()
	 * @see org.interpss.editor.ws.IpssWsItemContainer#getWsItemList
	 * @model opposite="wsItemList" transient="false"
	 * @generated
	 */
	IpssWsItemContainer getParent();

	/**
	 * Sets the value of the '{@link org.interpss.editor.ws.IpssWsItem#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(IpssWsItemContainer value);

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLoaded();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clearDocument();
} // IpssWsItem
