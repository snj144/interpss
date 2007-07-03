/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.IpssProject#getProjDbId <em>Proj Db Id</em>}</li>
 *   <li>{@link org.interpss.model.editor.wkSpace.IpssProject#getParentPath <em>Parent Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssProject()
 * @model
 * @generated
 */
public interface IpssProject extends WorkspaceItemContainer {
	/**
	 * Returns the value of the '<em><b>Proj Db Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proj Db Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proj Db Id</em>' attribute.
	 * @see #setProjDbId(int)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssProject_ProjDbId()
	 * @model
	 * @generated
	 */
	int getProjDbId();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.IpssProject#getProjDbId <em>Proj Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proj Db Id</em>' attribute.
	 * @see #getProjDbId()
	 * @generated
	 */
	void setProjDbId(int value);

	/**
	 * Returns the value of the '<em><b>Parent Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Path</em>' attribute.
	 * @see #setParentPath(String)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssProject_ParentPath()
	 * @model
	 * @generated
	 */
	String getParentPath();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.IpssProject#getParentPath <em>Parent Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Path</em>' attribute.
	 * @see #getParentPath()
	 * @generated
	 */
	void setParentPath(String value);

} // IpssProject
