/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.model.editor.doc.docPackage
 * @generated
 */
public interface docFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	docFactory eINSTANCE = org.interpss.model.editor.doc.impl.docFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ipss Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Document</em>'.
	 * @generated
	 */
	IpssDocument createIpssDocument();

	/**
	 * Returns a new object of class '<em>Ipss Editor Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Editor Document</em>'.
	 * @generated
	 */
	<TViewer> IpssEditorDocument<TViewer> createIpssEditorDocument();

	/**
	 * Returns a new object of class '<em>Ipss Editable Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Editable Document</em>'.
	 * @generated
	 */
	<TEditor, TViewer> IpssEditableDocument<TEditor, TViewer> createIpssEditableDocument();

	/**
	 * Returns a new object of class '<em>Ipss Report Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Report Document</em>'.
	 * @generated
	 */
	<TViewer> IpssReportDocument<TViewer> createIpssReportDocument();

	/**
	 * Returns a new object of class '<em>Ipss DB Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss DB Document</em>'.
	 * @generated
	 */
	<TViewer> IpssDBDocument<TViewer> createIpssDBDocument();

	/**
	 * Returns a new object of class '<em>Ipss Text Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Text Document</em>'.
	 * @generated
	 */
	<TEditor, TViewer> IpssTextDocument<TEditor, TViewer> createIpssTextDocument();

	/**
	 * Returns a new object of class '<em>Ipss Simu Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Simu Document</em>'.
	 * @generated
	 */
	<TSimuCtx, TEditor, TViewer> IpssSimuDocument<TSimuCtx, TEditor, TViewer> createIpssSimuDocument();

	/**
	 * Returns a new object of class '<em>Ipss JGraph Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss JGraph Document</em>'.
	 * @generated
	 */
	<TAppSimuCtx, TEditor, TViewer> IpssJGraphDocument<TAppSimuCtx, TEditor, TViewer> createIpssJGraphDocument();

	/**
	 * Returns a new object of class '<em>Ipss Custom Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ipss Custom Document</em>'.
	 * @generated
	 */
	<TAppSimuCtx, TEditor, TViewer> IpssCustomDocument<TAppSimuCtx, TEditor, TViewer> createIpssCustomDocument();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	docPackage getdocPackage();

} //docFactory
