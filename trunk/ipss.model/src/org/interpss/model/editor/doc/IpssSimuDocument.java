/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc;

import org.interpss.model.editor.appSimu.AppSimuContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Simu Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.doc.IpssSimuDocument#getAppSimuCtx <em>App Simu Ctx</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.doc.docPackage#getIpssSimuDocument()
 * @model
 * @generated
 */
public interface IpssSimuDocument<TSimuCtx, TEditor, TViewer> extends IpssEditableDocument<TEditor, TViewer> {
	/**
	 * Returns the value of the '<em><b>App Simu Ctx</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>App Simu Ctx</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>App Simu Ctx</em>' containment reference.
	 * @see #setAppSimuCtx(AppSimuContext)
	 * @see org.interpss.model.editor.doc.docPackage#getIpssSimuDocument_AppSimuCtx()
	 * @model containment="true"
	 * @generated
	 */
	AppSimuContext<TSimuCtx> getAppSimuCtx();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.doc.IpssSimuDocument#getAppSimuCtx <em>App Simu Ctx</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>App Simu Ctx</em>' containment reference.
	 * @see #getAppSimuCtx()
	 * @generated
	 */
	void setAppSimuCtx(AppSimuContext<TSimuCtx> value);

} // IpssSimuDocument
