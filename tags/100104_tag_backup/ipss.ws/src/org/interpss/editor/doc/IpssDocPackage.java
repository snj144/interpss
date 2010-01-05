/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.interpss.editor.doc.IpssDocFactory
 * @model kind="package"
 * @generated
 */
public interface IpssDocPackage extends EPackage {
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
	String eNS_URI = "http:///org/interpss/editor/doc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ipss";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IpssDocPackage eINSTANCE = org.interpss.editor.doc.impl.IpssDocPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssDocumentImpl <em>Ipss Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocument()
	 * @generated
	 */
	int IPSS_DOCUMENT = 0;

	/**
	 * The number of structural features of the '<em>Ipss Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssDocumentItemImpl <em>Ipss Document Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssDocumentItemImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocumentItem()
	 * @generated
	 */
	int IPSS_DOCUMENT_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT_ITEM__WS_ITEM = IPSS_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ipss Document Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT_ITEM_FEATURE_COUNT = IPSS_DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssEditorDocumentImpl <em>Ipss Editor Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssEditorDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditorDocument()
	 * @generated
	 */
	int IPSS_EDITOR_DOCUMENT = 2;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITOR_DOCUMENT__WS_ITEM = IPSS_DOCUMENT_ITEM__WS_ITEM;

	/**
	 * The number of structural features of the '<em>Ipss Editor Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITOR_DOCUMENT_FEATURE_COUNT = IPSS_DOCUMENT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssEditableDocumentImpl <em>Ipss Editable Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssEditableDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditableDocument()
	 * @generated
	 */
	int IPSS_EDITABLE_DOCUMENT = 3;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITABLE_DOCUMENT__WS_ITEM = IPSS_EDITOR_DOCUMENT__WS_ITEM;

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
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssSimuDocumentImpl <em>Ipss Simu Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssSimuDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssSimuDocument()
	 * @generated
	 */
	int IPSS_SIMU_DOCUMENT = 4;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT__WS_ITEM = IPSS_EDITABLE_DOCUMENT__WS_ITEM;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT__MODIFIED = IPSS_EDITABLE_DOCUMENT__MODIFIED;

	/**
	 * The feature id for the '<em><b>App Simu Ctx</b></em>' attribute.
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
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssCustomDocumentImpl <em>Ipss Custom Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssCustomDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssCustomDocument()
	 * @generated
	 */
	int IPSS_CUSTOM_DOCUMENT = 5;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT__WS_ITEM = IPSS_SIMU_DOCUMENT__WS_ITEM;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT__MODIFIED = IPSS_SIMU_DOCUMENT__MODIFIED;

	/**
	 * The feature id for the '<em><b>App Simu Ctx</b></em>' attribute.
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
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssGraphicDocumentImpl <em>Ipss Graphic Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssGraphicDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssGraphicDocument()
	 * @generated
	 */
	int IPSS_GRAPHIC_DOCUMENT = 6;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_GRAPHIC_DOCUMENT__WS_ITEM = IPSS_SIMU_DOCUMENT__WS_ITEM;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_GRAPHIC_DOCUMENT__MODIFIED = IPSS_SIMU_DOCUMENT__MODIFIED;

	/**
	 * The feature id for the '<em><b>App Simu Ctx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_GRAPHIC_DOCUMENT__APP_SIMU_CTX = IPSS_SIMU_DOCUMENT__APP_SIMU_CTX;

	/**
	 * The number of structural features of the '<em>Ipss Graphic Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_GRAPHIC_DOCUMENT_FEATURE_COUNT = IPSS_SIMU_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssReportDocumentImpl <em>Ipss Report Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssReportDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssReportDocument()
	 * @generated
	 */
	int IPSS_REPORT_DOCUMENT = 7;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_REPORT_DOCUMENT__WS_ITEM = IPSS_EDITOR_DOCUMENT__WS_ITEM;

	/**
	 * The number of structural features of the '<em>Ipss Report Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_REPORT_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssTextDocumentImpl <em>Ipss Text Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssTextDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssTextDocument()
	 * @generated
	 */
	int IPSS_TEXT_DOCUMENT = 8;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_TEXT_DOCUMENT__WS_ITEM = IPSS_EDITABLE_DOCUMENT__WS_ITEM;

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
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssXmlDocumentImpl <em>Ipss Xml Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssXmlDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssXmlDocument()
	 * @generated
	 */
	int IPSS_XML_DOCUMENT = 9;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_XML_DOCUMENT__WS_ITEM = IPSS_EDITABLE_DOCUMENT__WS_ITEM;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_XML_DOCUMENT__MODIFIED = IPSS_EDITABLE_DOCUMENT__MODIFIED;

	/**
	 * The number of structural features of the '<em>Ipss Xml Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_XML_DOCUMENT_FEATURE_COUNT = IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssDbDocumentImpl <em>Ipss Db Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssDbDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDbDocument()
	 * @generated
	 */
	int IPSS_DB_DOCUMENT = 10;

	/**
	 * The feature id for the '<em><b>Ws Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DB_DOCUMENT__WS_ITEM = IPSS_EDITOR_DOCUMENT__WS_ITEM;

	/**
	 * The number of structural features of the '<em>Ipss Db Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DB_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>App Simu Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.jgraph.ui.app.IAppSimuContext
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getAppSimuContext()
	 * @generated
	 */
	int APP_SIMU_CONTEXT = 11;


	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssDocument <em>Ipss Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Document</em>'.
	 * @see org.interpss.editor.doc.IpssDocument
	 * @generated
	 */
	EClass getIpssDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssDocumentItem <em>Ipss Document Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Document Item</em>'.
	 * @see org.interpss.editor.doc.IpssDocumentItem
	 * @generated
	 */
	EClass getIpssDocumentItem();

	/**
	 * Returns the meta object for the reference '{@link org.interpss.editor.doc.IpssDocumentItem#getWsItem <em>Ws Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ws Item</em>'.
	 * @see org.interpss.editor.doc.IpssDocumentItem#getWsItem()
	 * @see #getIpssDocumentItem()
	 * @generated
	 */
	EReference getIpssDocumentItem_WsItem();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssEditorDocument <em>Ipss Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Editor Document</em>'.
	 * @see org.interpss.editor.doc.IpssEditorDocument
	 * @generated
	 */
	EClass getIpssEditorDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssEditableDocument <em>Ipss Editable Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Editable Document</em>'.
	 * @see org.interpss.editor.doc.IpssEditableDocument
	 * @generated
	 */
	EClass getIpssEditableDocument();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.editor.doc.IpssEditableDocument#isModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see org.interpss.editor.doc.IpssEditableDocument#isModified()
	 * @see #getIpssEditableDocument()
	 * @generated
	 */
	EAttribute getIpssEditableDocument_Modified();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssSimuDocument <em>Ipss Simu Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Simu Document</em>'.
	 * @see org.interpss.editor.doc.IpssSimuDocument
	 * @generated
	 */
	EClass getIpssSimuDocument();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.editor.doc.IpssSimuDocument#getAppSimuCtx <em>App Simu Ctx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>App Simu Ctx</em>'.
	 * @see org.interpss.editor.doc.IpssSimuDocument#getAppSimuCtx()
	 * @see #getIpssSimuDocument()
	 * @generated
	 */
	EAttribute getIpssSimuDocument_AppSimuCtx();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssCustomDocument <em>Ipss Custom Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Custom Document</em>'.
	 * @see org.interpss.editor.doc.IpssCustomDocument
	 * @generated
	 */
	EClass getIpssCustomDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssGraphicDocument <em>Ipss Graphic Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Graphic Document</em>'.
	 * @see org.interpss.editor.doc.IpssGraphicDocument
	 * @generated
	 */
	EClass getIpssGraphicDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssReportDocument <em>Ipss Report Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Report Document</em>'.
	 * @see org.interpss.editor.doc.IpssReportDocument
	 * @generated
	 */
	EClass getIpssReportDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssTextDocument <em>Ipss Text Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Text Document</em>'.
	 * @see org.interpss.editor.doc.IpssTextDocument
	 * @generated
	 */
	EClass getIpssTextDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssXmlDocument <em>Ipss Xml Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Xml Document</em>'.
	 * @see org.interpss.editor.doc.IpssXmlDocument
	 * @generated
	 */
	EClass getIpssXmlDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssDbDocument <em>Ipss Db Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Db Document</em>'.
	 * @see org.interpss.editor.doc.IpssDbDocument
	 * @generated
	 */
	EClass getIpssDbDocument();

	/**
	 * Returns the meta object for data type '{@link org.interpss.editor.jgraph.ui.app.IAppSimuContext <em>App Simu Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>App Simu Context</em>'.
	 * @see org.interpss.editor.jgraph.ui.app.IAppSimuContext
	 * @model instanceClass="org.interpss.editor.jgraph.ui.app.IAppSimuContext"
	 * @generated
	 */
	EDataType getAppSimuContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IpssDocFactory getIpssDocFactory();

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
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssDocumentImpl <em>Ipss Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocument()
		 * @generated
		 */
		EClass IPSS_DOCUMENT = eINSTANCE.getIpssDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssDocumentItemImpl <em>Ipss Document Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssDocumentItemImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocumentItem()
		 * @generated
		 */
		EClass IPSS_DOCUMENT_ITEM = eINSTANCE.getIpssDocumentItem();

		/**
		 * The meta object literal for the '<em><b>Ws Item</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPSS_DOCUMENT_ITEM__WS_ITEM = eINSTANCE.getIpssDocumentItem_WsItem();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssEditorDocumentImpl <em>Ipss Editor Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssEditorDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditorDocument()
		 * @generated
		 */
		EClass IPSS_EDITOR_DOCUMENT = eINSTANCE.getIpssEditorDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssEditableDocumentImpl <em>Ipss Editable Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssEditableDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditableDocument()
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
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssSimuDocumentImpl <em>Ipss Simu Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssSimuDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssSimuDocument()
		 * @generated
		 */
		EClass IPSS_SIMU_DOCUMENT = eINSTANCE.getIpssSimuDocument();

		/**
		 * The meta object literal for the '<em><b>App Simu Ctx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_SIMU_DOCUMENT__APP_SIMU_CTX = eINSTANCE.getIpssSimuDocument_AppSimuCtx();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssCustomDocumentImpl <em>Ipss Custom Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssCustomDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssCustomDocument()
		 * @generated
		 */
		EClass IPSS_CUSTOM_DOCUMENT = eINSTANCE.getIpssCustomDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssGraphicDocumentImpl <em>Ipss Graphic Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssGraphicDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssGraphicDocument()
		 * @generated
		 */
		EClass IPSS_GRAPHIC_DOCUMENT = eINSTANCE.getIpssGraphicDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssReportDocumentImpl <em>Ipss Report Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssReportDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssReportDocument()
		 * @generated
		 */
		EClass IPSS_REPORT_DOCUMENT = eINSTANCE.getIpssReportDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssTextDocumentImpl <em>Ipss Text Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssTextDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssTextDocument()
		 * @generated
		 */
		EClass IPSS_TEXT_DOCUMENT = eINSTANCE.getIpssTextDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssXmlDocumentImpl <em>Ipss Xml Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssXmlDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssXmlDocument()
		 * @generated
		 */
		EClass IPSS_XML_DOCUMENT = eINSTANCE.getIpssXmlDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssDbDocumentImpl <em>Ipss Db Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssDbDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDbDocument()
		 * @generated
		 */
		EClass IPSS_DB_DOCUMENT = eINSTANCE.getIpssDbDocument();

		/**
		 * The meta object literal for the '<em>App Simu Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.jgraph.ui.app.IAppSimuContext
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getAppSimuContext()
		 * @generated
		 */
		EDataType APP_SIMU_CONTEXT = eINSTANCE.getAppSimuContext();

	}

} //IpssDocPackage
