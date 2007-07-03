/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Editable Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.doc.IpssEditableDocument#isModified <em>Modified</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.doc.docPackage#getIpssEditableDocument()
 * @model
 * @generated
 */
public interface IpssEditableDocument<TEditor, TViewer> extends IpssEditorDocument<TViewer> {
	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(boolean)
	 * @see org.interpss.model.editor.doc.docPackage#getIpssEditableDocument_Modified()
	 * @model
	 * @generated
	 */
	boolean isModified();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.doc.IpssEditableDocument#isModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #isModified()
	 * @generated
	 */
	void setModified(boolean value);

} // IpssEditableDocument
