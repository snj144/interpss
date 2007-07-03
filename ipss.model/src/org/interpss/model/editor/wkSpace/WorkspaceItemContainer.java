/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Item Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.WorkspaceItemContainer#getWsItemList <em>Ws Item List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getWorkspaceItemContainer()
 * @model
 * @generated
 */
public interface WorkspaceItemContainer extends WorkspaceItem {
	/**
	 * Returns the value of the '<em><b>Ws Item List</b></em>' containment reference list.
	 * The list contents are of type {@link org.interpss.model.editor.wkSpace.WorkspaceItem}.
	 * It is bidirectional and its opposite is '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ws Item List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ws Item List</em>' containment reference list.
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getWorkspaceItemContainer_WsItemList()
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItem#getParent
	 * @model opposite="parent" containment="true" keys="name"
	 * @generated
	 */
	EList<WorkspaceItem> getWsItemList();

} // WorkspaceItemContainer
