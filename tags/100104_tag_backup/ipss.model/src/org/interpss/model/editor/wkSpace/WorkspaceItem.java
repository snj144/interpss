/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;

import org.eclipse.emf.ecore.EObject;

import org.interpss.model.editor.doc.IpssDocument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getParent <em>Parent</em>}</li>
 *   <li>{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getName <em>Name</em>}</li>
 *   <li>{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getIpssDocument <em>Ipss Document</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getWorkspaceItem()
 * @model
 * @generated
 */
public interface WorkspaceItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.model.editor.wkSpace.WorkspaceItemContainer#getWsItemList <em>Ws Item List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(WorkspaceItemContainer)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getWorkspaceItem_Parent()
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItemContainer#getWsItemList
	 * @model opposite="wsItemList" transient="false"
	 * @generated
	 */
	WorkspaceItemContainer getParent();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(WorkspaceItemContainer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getWorkspaceItem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ipss Document</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.model.editor.doc.IpssDocument#getWorkspaceItem <em>Workspace Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ipss Document</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ipss Document</em>' containment reference.
	 * @see #setIpssDocument(IpssDocument)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getWorkspaceItem_IpssDocument()
	 * @see org.interpss.model.editor.doc.IpssDocument#getWorkspaceItem
	 * @model opposite="workspaceItem" containment="true"
	 * @generated
	 */
	IpssDocument getIpssDocument();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getIpssDocument <em>Ipss Document</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ipss Document</em>' containment reference.
	 * @see #getIpssDocument()
	 * @generated
	 */
	void setIpssDocument(IpssDocument value);

} // WorkspaceItem
