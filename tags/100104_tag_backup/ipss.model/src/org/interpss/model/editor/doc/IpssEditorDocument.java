/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Editor Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.doc.IpssEditorDocument#getViewer <em>Viewer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.doc.docPackage#getIpssEditorDocument()
 * @model
 * @generated
 */
public interface IpssEditorDocument<TViewer> extends IpssDocument {
	/**
	 * Returns the value of the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewer</em>' attribute.
	 * @see #setViewer(Object)
	 * @see org.interpss.model.editor.doc.docPackage#getIpssEditorDocument_Viewer()
	 * @model
	 * @generated
	 */
	TViewer getViewer();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.doc.IpssEditorDocument#getViewer <em>Viewer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewer</em>' attribute.
	 * @see #getViewer()
	 * @generated
	 */
	void setViewer(TViewer value);

} // IpssEditorDocument
