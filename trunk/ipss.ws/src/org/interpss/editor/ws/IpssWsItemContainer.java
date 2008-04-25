/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.IpssWsItemContainer#getWsItemList <em>Ws Item List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItemContainer()
 * @model abstract="true"
 * @generated
 */
public interface IpssWsItemContainer extends IpssWsItem {
	/**
	 * Returns the value of the '<em><b>Ws Item List</b></em>' containment reference list.
	 * The list contents are of type {@link org.interpss.editor.ws.IpssWsItem}.
	 * It is bidirectional and its opposite is '{@link org.interpss.editor.ws.IpssWsItem#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ws Item List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ws Item List</em>' containment reference list.
	 * @see org.interpss.editor.ws.IpssWsPackage#getIpssWsItemContainer_WsItemList()
	 * @see org.interpss.editor.ws.IpssWsItem#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<IpssWsItem> getWsItemList();

} // IpssWsItemContainer
