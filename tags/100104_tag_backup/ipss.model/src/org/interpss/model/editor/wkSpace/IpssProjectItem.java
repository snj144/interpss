/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Project Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.IpssProjectItem#getInitStatus <em>Init Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssProjectItem()
 * @model
 * @generated
 */
public interface IpssProjectItem extends WorkspaceItem {
	/**
	 * Returns the value of the '<em><b>Init Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.interpss.model.editor.wkSpace.ProjectItemStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Status</em>' attribute.
	 * @see org.interpss.model.editor.wkSpace.ProjectItemStatus
	 * @see #setInitStatus(ProjectItemStatus)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssProjectItem_InitStatus()
	 * @model
	 * @generated
	 */
	ProjectItemStatus getInitStatus();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.IpssProjectItem#getInitStatus <em>Init Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Status</em>' attribute.
	 * @see org.interpss.model.editor.wkSpace.ProjectItemStatus
	 * @see #getInitStatus()
	 * @generated
	 */
	void setInitStatus(ProjectItemStatus value);

} // IpssProjectItem
