/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc;

import org.eclipse.emf.ecore.EObject;

import org.interpss.model.editor.wkSpace.WorkspaceItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.doc.IpssDocument#getWorkspaceItem <em>Workspace Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.doc.docPackage#getIpssDocument()
 * @model
 * @generated
 */
public interface IpssDocument extends EObject {
	/**
	 * Returns the value of the '<em><b>Workspace Item</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getIpssDocument <em>Ipss Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Item</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Item</em>' container reference.
	 * @see #setWorkspaceItem(WorkspaceItem)
	 * @see org.interpss.model.editor.doc.docPackage#getIpssDocument_WorkspaceItem()
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItem#getIpssDocument
	 * @model opposite="ipssDocument" transient="false"
	 * @generated
	 */
	WorkspaceItem getWorkspaceItem();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.doc.IpssDocument#getWorkspaceItem <em>Workspace Item</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Item</em>' container reference.
	 * @see #getWorkspaceItem()
	 * @generated
	 */
	void setWorkspaceItem(WorkspaceItem value);

} // IpssDocument
