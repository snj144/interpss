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
} // IpssWsItem
