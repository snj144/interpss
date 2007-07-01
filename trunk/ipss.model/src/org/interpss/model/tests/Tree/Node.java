/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.tests.Tree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.tests.Tree.Node#getLabel <em>Label</em>}</li>
 *   <li>{@link org.interpss.model.tests.Tree.Node#getChildList <em>Child List</em>}</li>
 *   <li>{@link org.interpss.model.tests.Tree.Node#getParent <em>Parent</em>}</li>
 *   <li>{@link org.interpss.model.tests.Tree.Node#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.tests.Tree.TreePackage#getNode()
 * @model
 * @generated
 */
public interface Node<T> extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>"\"Not defined\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.interpss.model.tests.Tree.TreePackage#getNode_Label()
	 * @model default="\"Not defined\""
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.interpss.model.tests.Tree.Node#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Child List</b></em>' containment reference list.
	 * The list contents are of type {@link org.interpss.model.tests.Tree.Node}&lt;T>.
	 * It is bidirectional and its opposite is '{@link org.interpss.model.tests.Tree.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child List</em>' containment reference list.
	 * @see org.interpss.model.tests.Tree.TreePackage#getNode_ChildList()
	 * @see org.interpss.model.tests.Tree.Node#getParent
	 * @model opposite="parent" containment="true" keys="label"
	 * @generated
	 */
	EList<Node<T>> getChildList();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.interpss.model.tests.Tree.Node#getChildList <em>Child List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Node)
	 * @see org.interpss.model.tests.Tree.TreePackage#getNode_Parent()
	 * @see org.interpss.model.tests.Tree.Node#getChildList
	 * @model opposite="childList"
	 * @generated
	 */
	Node<T> getParent();

	/**
	 * Sets the value of the '{@link org.interpss.model.tests.Tree.Node#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Node<T> value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(Object)
	 * @see org.interpss.model.tests.Tree.TreePackage#getNode_Data()
	 * @model
	 * @generated
	 */
	T getData();

	/**
	 * Sets the value of the '{@link org.interpss.model.tests.Tree.Node#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(T value);

} // Node
