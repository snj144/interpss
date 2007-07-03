/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.interpss.model.editor.doc.docFactory
 * @model kind="package"
 * @generated
 */
public interface docPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "doc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.interpss.org/editor/document";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ipss.editor.doc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	docPackage eINSTANCE = org.interpss.model.editor.doc.impl.docPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssDocumentImpl <em>Ipss Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssDocument()
	 * @generated
	 */
	int IPSS_DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT__WORKSPACE_ITEM = 0;

	/**
	 * The number of structural features of the '<em>Ipss Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssEditorDocumentImpl <em>Ipss Editor Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssEditorDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssEditorDocument()
	 * @generated
	 */
	int IPSS_EDITOR_DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITOR_DOCUMENT__WORKSPACE_ITEM = IPSS_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITOR_DOCUMENT__VIEWER = IPSS_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ipss Editor Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITOR_DOCUMENT_FEATURE_COUNT = IPSS_DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssEditableDocumentImpl <em>Ipss Editable Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssEditableDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssEditableDocument()
	 * @generated
	 */
	int IPSS_EDITABLE_DOCUMENT = 2;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITABLE_DOCUMENT__WORKSPACE_ITEM = IPSS_EDITOR_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITABLE_DOCUMENT__VIEWER = IPSS_EDITOR_DOCUMENT__VIEWER;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITABLE_DOCUMENT__MODIFIED = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ipss Editable Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssReportDocumentImpl <em>Ipss Report Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssReportDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssReportDocument()
	 * @generated
	 */
	int IPSS_REPORT_DOCUMENT = 3;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_REPORT_DOCUMENT__WORKSPACE_ITEM = IPSS_EDITOR_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_REPORT_DOCUMENT__VIEWER = IPSS_EDITOR_DOCUMENT__VIEWER;

	/**
	 * The number of structural features of the '<em>Ipss Report Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_REPORT_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssDBDocumentImpl <em>Ipss DB Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssDBDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssDBDocument()
	 * @generated
	 */
	int IPSS_DB_DOCUMENT = 4;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DB_DOCUMENT__WORKSPACE_ITEM = IPSS_EDITOR_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DB_DOCUMENT__VIEWER = IPSS_EDITOR_DOCUMENT__VIEWER;

	/**
	 * The number of structural features of the '<em>Ipss DB Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DB_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssTextDocumentImpl <em>Ipss Text Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssTextDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssTextDocument()
	 * @generated
	 */
	int IPSS_TEXT_DOCUMENT = 5;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_TEXT_DOCUMENT__WORKSPACE_ITEM = IPSS_EDITABLE_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_TEXT_DOCUMENT__VIEWER = IPSS_EDITABLE_DOCUMENT__VIEWER;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_TEXT_DOCUMENT__MODIFIED = IPSS_EDITABLE_DOCUMENT__MODIFIED;

	/**
	 * The number of structural features of the '<em>Ipss Text Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_TEXT_DOCUMENT_FEATURE_COUNT = IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssSimuDocumentImpl <em>Ipss Simu Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssSimuDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssSimuDocument()
	 * @generated
	 */
	int IPSS_SIMU_DOCUMENT = 6;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT__WORKSPACE_ITEM = IPSS_EDITABLE_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT__VIEWER = IPSS_EDITABLE_DOCUMENT__VIEWER;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT__MODIFIED = IPSS_EDITABLE_DOCUMENT__MODIFIED;

	/**
	 * The feature id for the '<em><b>App Simu Ctx</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT__APP_SIMU_CTX = IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ipss Simu Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT_FEATURE_COUNT = IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssJGraphDocumentImpl <em>Ipss JGraph Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssJGraphDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssJGraphDocument()
	 * @generated
	 */
	int IPSS_JGRAPH_DOCUMENT = 7;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_JGRAPH_DOCUMENT__WORKSPACE_ITEM = IPSS_SIMU_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_JGRAPH_DOCUMENT__VIEWER = IPSS_SIMU_DOCUMENT__VIEWER;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_JGRAPH_DOCUMENT__MODIFIED = IPSS_SIMU_DOCUMENT__MODIFIED;

	/**
	 * The feature id for the '<em><b>App Simu Ctx</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_JGRAPH_DOCUMENT__APP_SIMU_CTX = IPSS_SIMU_DOCUMENT__APP_SIMU_CTX;

	/**
	 * The number of structural features of the '<em>Ipss JGraph Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_JGRAPH_DOCUMENT_FEATURE_COUNT = IPSS_SIMU_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.doc.impl.IpssCustomDocumentImpl <em>Ipss Custom Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.doc.impl.IpssCustomDocumentImpl
	 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssCustomDocument()
	 * @generated
	 */
	int IPSS_CUSTOM_DOCUMENT = 8;

	/**
	 * The feature id for the '<em><b>Workspace Item</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT__WORKSPACE_ITEM = IPSS_SIMU_DOCUMENT__WORKSPACE_ITEM;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT__VIEWER = IPSS_SIMU_DOCUMENT__VIEWER;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT__MODIFIED = IPSS_SIMU_DOCUMENT__MODIFIED;

	/**
	 * The feature id for the '<em><b>App Simu Ctx</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT__APP_SIMU_CTX = IPSS_SIMU_DOCUMENT__APP_SIMU_CTX;

	/**
	 * The number of structural features of the '<em>Ipss Custom Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT_FEATURE_COUNT = IPSS_SIMU_DOCUMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssDocument <em>Ipss Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssDocument
	 * @generated
	 */
	EClass getIpssDocument();

	/**
	 * Returns the meta object for the container reference '{@link org.interpss.model.editor.doc.IpssDocument#getWorkspaceItem <em>Workspace Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Workspace Item</em>'.
	 * @see org.interpss.model.editor.doc.IpssDocument#getWorkspaceItem()
	 * @see #getIpssDocument()
	 * @generated
	 */
	EReference getIpssDocument_WorkspaceItem();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssEditorDocument <em>Ipss Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Editor Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssEditorDocument
	 * @generated
	 */
	EClass getIpssEditorDocument();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.doc.IpssEditorDocument#getViewer <em>Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewer</em>'.
	 * @see org.interpss.model.editor.doc.IpssEditorDocument#getViewer()
	 * @see #getIpssEditorDocument()
	 * @generated
	 */
	EAttribute getIpssEditorDocument_Viewer();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssEditableDocument <em>Ipss Editable Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Editable Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssEditableDocument
	 * @generated
	 */
	EClass getIpssEditableDocument();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.doc.IpssEditableDocument#isModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see org.interpss.model.editor.doc.IpssEditableDocument#isModified()
	 * @see #getIpssEditableDocument()
	 * @generated
	 */
	EAttribute getIpssEditableDocument_Modified();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssReportDocument <em>Ipss Report Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Report Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssReportDocument
	 * @generated
	 */
	EClass getIpssReportDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssDBDocument <em>Ipss DB Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss DB Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssDBDocument
	 * @generated
	 */
	EClass getIpssDBDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssTextDocument <em>Ipss Text Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Text Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssTextDocument
	 * @generated
	 */
	EClass getIpssTextDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssSimuDocument <em>Ipss Simu Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Simu Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssSimuDocument
	 * @generated
	 */
	EClass getIpssSimuDocument();

	/**
	 * Returns the meta object for the containment reference '{@link org.interpss.model.editor.doc.IpssSimuDocument#getAppSimuCtx <em>App Simu Ctx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>App Simu Ctx</em>'.
	 * @see org.interpss.model.editor.doc.IpssSimuDocument#getAppSimuCtx()
	 * @see #getIpssSimuDocument()
	 * @generated
	 */
	EReference getIpssSimuDocument_AppSimuCtx();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssJGraphDocument <em>Ipss JGraph Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss JGraph Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssJGraphDocument
	 * @generated
	 */
	EClass getIpssJGraphDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.doc.IpssCustomDocument <em>Ipss Custom Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Custom Document</em>'.
	 * @see org.interpss.model.editor.doc.IpssCustomDocument
	 * @generated
	 */
	EClass getIpssCustomDocument();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	docFactory getdocFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssDocumentImpl <em>Ipss Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssDocument()
		 * @generated
		 */
		EClass IPSS_DOCUMENT = eINSTANCE.getIpssDocument();

		/**
		 * The meta object literal for the '<em><b>Workspace Item</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPSS_DOCUMENT__WORKSPACE_ITEM = eINSTANCE.getIpssDocument_WorkspaceItem();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssEditorDocumentImpl <em>Ipss Editor Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssEditorDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssEditorDocument()
		 * @generated
		 */
		EClass IPSS_EDITOR_DOCUMENT = eINSTANCE.getIpssEditorDocument();

		/**
		 * The meta object literal for the '<em><b>Viewer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_EDITOR_DOCUMENT__VIEWER = eINSTANCE.getIpssEditorDocument_Viewer();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssEditableDocumentImpl <em>Ipss Editable Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssEditableDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssEditableDocument()
		 * @generated
		 */
		EClass IPSS_EDITABLE_DOCUMENT = eINSTANCE.getIpssEditableDocument();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_EDITABLE_DOCUMENT__MODIFIED = eINSTANCE.getIpssEditableDocument_Modified();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssReportDocumentImpl <em>Ipss Report Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssReportDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssReportDocument()
		 * @generated
		 */
		EClass IPSS_REPORT_DOCUMENT = eINSTANCE.getIpssReportDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssDBDocumentImpl <em>Ipss DB Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssDBDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssDBDocument()
		 * @generated
		 */
		EClass IPSS_DB_DOCUMENT = eINSTANCE.getIpssDBDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssTextDocumentImpl <em>Ipss Text Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssTextDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssTextDocument()
		 * @generated
		 */
		EClass IPSS_TEXT_DOCUMENT = eINSTANCE.getIpssTextDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssSimuDocumentImpl <em>Ipss Simu Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssSimuDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssSimuDocument()
		 * @generated
		 */
		EClass IPSS_SIMU_DOCUMENT = eINSTANCE.getIpssSimuDocument();

		/**
		 * The meta object literal for the '<em><b>App Simu Ctx</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPSS_SIMU_DOCUMENT__APP_SIMU_CTX = eINSTANCE.getIpssSimuDocument_AppSimuCtx();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssJGraphDocumentImpl <em>Ipss JGraph Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssJGraphDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssJGraphDocument()
		 * @generated
		 */
		EClass IPSS_JGRAPH_DOCUMENT = eINSTANCE.getIpssJGraphDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.doc.impl.IpssCustomDocumentImpl <em>Ipss Custom Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.doc.impl.IpssCustomDocumentImpl
		 * @see org.interpss.model.editor.doc.impl.docPackageImpl#getIpssCustomDocument()
		 * @generated
		 */
		EClass IPSS_CUSTOM_DOCUMENT = eINSTANCE.getIpssCustomDocument();

	}

} //docPackage
