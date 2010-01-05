/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc;

import org.interpss.editor.jgraph.ui.app.IAppSimuContext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Simu Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.doc.IpssSimuDocument#getAppSimuCtx <em>App Simu Ctx</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.doc.IpssDocPackage#getIpssSimuDocument()
 * @model
 * @generated
 */
public interface IpssSimuDocument extends IpssEditableDocument {

	/**
	 * Returns the value of the '<em><b>App Simu Ctx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>App Simu Ctx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>App Simu Ctx</em>' attribute.
	 * @see #setAppSimuCtx(IAppSimuContext)
	 * @see org.interpss.editor.doc.IpssDocPackage#getIpssSimuDocument_AppSimuCtx()
	 * @model dataType="org.interpss.editor.doc.AppSimuContext" transient="true"
	 * @generated
	 */
	IAppSimuContext getAppSimuCtx();

	/**
	 * Sets the value of the '{@link org.interpss.editor.doc.IpssSimuDocument#getAppSimuCtx <em>App Simu Ctx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>App Simu Ctx</em>' attribute.
	 * @see #getAppSimuCtx()
	 * @generated
	 */
	void setAppSimuCtx(IAppSimuContext value);
} // IpssSimuDocument
