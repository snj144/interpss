/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc;

import javax.swing.JComponent;
import org.eclipse.emf.ecore.EObject;
import org.interpss.editor.ws.IpssWsItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.doc.IpssDocument#getWsItem <em>Ws Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.doc.IpssDocPackage#getIpssDocument()
 * @model abstract="true"
 * @generated
 */
public interface IpssDocument extends EObject {

	/**
	 * Returns the value of the '<em><b>Ws Item</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.editor.ws.IpssWsItem#getIpssDoc <em>Ipss Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ws Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ws Item</em>' reference.
	 * @see #setWsItem(IpssWsItem)
	 * @see org.interpss.editor.doc.IpssDocPackage#getIpssDocument_WsItem()
	 * @see org.interpss.editor.ws.IpssWsItem#getIpssDoc
	 * @model opposite="ipssDoc" required="true"
	 * @generated
	 */
	IpssWsItem getWsItem();

	/**
	 * Sets the value of the '{@link org.interpss.editor.doc.IpssDocument#getWsItem <em>Ws Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ws Item</em>' reference.
	 * @see #getWsItem()
	 * @generated
	 */
	void setWsItem(IpssWsItem value);
} // IpssDocument
