/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ipss Workspace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.IpssWorkspace#getAbsolutionPath <em>Absolution Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssWorkspace()
 * @model
 * @generated
 */
public interface IpssWorkspace extends WorkspaceItemContainer {
	/**
	 * Returns the value of the '<em><b>Absolution Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Absolution Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Absolution Path</em>' attribute.
	 * @see #setAbsolutionPath(String)
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#getIpssWorkspace_AbsolutionPath()
	 * @model
	 * @generated
	 */
	String getAbsolutionPath();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.wkSpace.IpssWorkspace#getAbsolutionPath <em>Absolution Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Absolution Path</em>' attribute.
	 * @see #getAbsolutionPath()
	 * @generated
	 */
	void setAbsolutionPath(String value);

} // IpssWorkspace
