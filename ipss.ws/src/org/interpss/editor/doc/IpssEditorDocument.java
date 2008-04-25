/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Editor Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.editor.doc.IpssEditorDocument#getFilePath <em>File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.editor.doc.IpssDocPackage#getIpssEditorDocument()
 * @model abstract="true"
 * @generated
 */
public interface IpssEditorDocument extends IpssDocumentItem {

	/**
	 * Returns the value of the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Path</em>' attribute.
	 * @see #setFilePath(String)
	 * @see org.interpss.editor.doc.IpssDocPackage#getIpssEditorDocument_FilePath()
	 * @model
	 * @generated
	 */
	String getFilePath();

	/**
	 * Sets the value of the '{@link org.interpss.editor.doc.IpssEditorDocument#getFilePath <em>File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Path</em>' attribute.
	 * @see #getFilePath()
	 * @generated
	 */
	void setFilePath(String value);
} // IpssEditorDocument
