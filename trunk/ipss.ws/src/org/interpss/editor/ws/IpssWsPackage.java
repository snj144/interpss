/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws;

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
 * @see org.interpss.editor.ws.IpssWsFactory
 * @model kind="package"
 * @generated
 */
public interface IpssWsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ws";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/interpss/editor/ws";

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
	IpssWsPackage eINSTANCE = org.interpss.editor.ws.impl.IpssWsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.interpss.editor.ws.impl.IpssWsItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.ws.impl.IpssWsItemImpl
	 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssWsItem()
	 * @generated
	 */
	int IPSS_WS_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Ipss Doc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WS_ITEM__IPSS_DOC = 0;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WS_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.interpss.editor.ws.impl.IpssWsItemContainerImpl <em>Item Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.ws.impl.IpssWsItemContainerImpl
	 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssWsItemContainer()
	 * @generated
	 */
	int IPSS_WS_ITEM_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Ipss Doc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WS_ITEM_CONTAINER__IPSS_DOC = IPSS_WS_ITEM__IPSS_DOC;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST = IPSS_WS_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Item Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WS_ITEM_CONTAINER_FEATURE_COUNT = IPSS_WS_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.editor.ws.impl.IpssProjectItemImpl <em>Ipss Project Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.ws.impl.IpssProjectItemImpl
	 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssProjectItem()
	 * @generated
	 */
	int IPSS_PROJECT_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Ipss Doc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM__IPSS_DOC = IPSS_WS_ITEM__IPSS_DOC;

	/**
	 * The number of structural features of the '<em>Ipss Project Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_FEATURE_COUNT = IPSS_WS_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.ws.impl.IpssWorkSpaceImpl <em>Ipss Work Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.ws.impl.IpssWorkSpaceImpl
	 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssWorkSpace()
	 * @generated
	 */
	int IPSS_WORK_SPACE = 3;

	/**
	 * The feature id for the '<em><b>Ipss Doc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORK_SPACE__IPSS_DOC = IPSS_WS_ITEM_CONTAINER__IPSS_DOC;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORK_SPACE__WS_ITEM_LIST = IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The number of structural features of the '<em>Ipss Work Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORK_SPACE_FEATURE_COUNT = IPSS_WS_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.ws.impl.IpssProjectImpl <em>Ipss Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.ws.impl.IpssProjectImpl
	 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssProject()
	 * @generated
	 */
	int IPSS_PROJECT = 4;

	/**
	 * The feature id for the '<em><b>Ipss Doc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__IPSS_DOC = IPSS_WS_ITEM_CONTAINER__IPSS_DOC;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__WS_ITEM_LIST = IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The number of structural features of the '<em>Ipss Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FEATURE_COUNT = IPSS_WS_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.ws.impl.IpssProjectFolderImpl <em>Ipss Project Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.ws.impl.IpssProjectFolderImpl
	 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssProjectFolder()
	 * @generated
	 */
	int IPSS_PROJECT_FOLDER = 5;

	/**
	 * The feature id for the '<em><b>Ipss Doc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER__IPSS_DOC = IPSS_WS_ITEM_CONTAINER__IPSS_DOC;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER__WS_ITEM_LIST = IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The number of structural features of the '<em>Ipss Project Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER_FEATURE_COUNT = IPSS_WS_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.ws.IpssWsItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see org.interpss.editor.ws.IpssWsItem
	 * @generated
	 */
	EClass getIpssWsItem();

	/**
	 * Returns the meta object for the reference '{@link org.interpss.editor.ws.IpssWsItem#getIpssDoc <em>Ipss Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ipss Doc</em>'.
	 * @see org.interpss.editor.ws.IpssWsItem#getIpssDoc()
	 * @see #getIpssWsItem()
	 * @generated
	 */
	EReference getIpssWsItem_IpssDoc();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.ws.IpssWsItemContainer <em>Item Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Container</em>'.
	 * @see org.interpss.editor.ws.IpssWsItemContainer
	 * @generated
	 */
	EClass getIpssWsItemContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.interpss.editor.ws.IpssWsItemContainer#getWsItemList <em>Ws Item List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ws Item List</em>'.
	 * @see org.interpss.editor.ws.IpssWsItemContainer#getWsItemList()
	 * @see #getIpssWsItemContainer()
	 * @generated
	 */
	EReference getIpssWsItemContainer_WsItemList();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.ws.IpssProjectItem <em>Ipss Project Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project Item</em>'.
	 * @see org.interpss.editor.ws.IpssProjectItem
	 * @generated
	 */
	EClass getIpssProjectItem();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.ws.IpssWorkSpace <em>Ipss Work Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Work Space</em>'.
	 * @see org.interpss.editor.ws.IpssWorkSpace
	 * @generated
	 */
	EClass getIpssWorkSpace();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.ws.IpssProject <em>Ipss Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project</em>'.
	 * @see org.interpss.editor.ws.IpssProject
	 * @generated
	 */
	EClass getIpssProject();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.ws.IpssProjectFolder <em>Ipss Project Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project Folder</em>'.
	 * @see org.interpss.editor.ws.IpssProjectFolder
	 * @generated
	 */
	EClass getIpssProjectFolder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IpssWsFactory getIpssWsFactory();

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
		 * The meta object literal for the '{@link org.interpss.editor.ws.impl.IpssWsItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.ws.impl.IpssWsItemImpl
		 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssWsItem()
		 * @generated
		 */
		EClass IPSS_WS_ITEM = eINSTANCE.getIpssWsItem();

		/**
		 * The meta object literal for the '<em><b>Ipss Doc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPSS_WS_ITEM__IPSS_DOC = eINSTANCE.getIpssWsItem_IpssDoc();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.ws.impl.IpssWsItemContainerImpl <em>Item Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.ws.impl.IpssWsItemContainerImpl
		 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssWsItemContainer()
		 * @generated
		 */
		EClass IPSS_WS_ITEM_CONTAINER = eINSTANCE.getIpssWsItemContainer();

		/**
		 * The meta object literal for the '<em><b>Ws Item List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST = eINSTANCE.getIpssWsItemContainer_WsItemList();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.ws.impl.IpssProjectItemImpl <em>Ipss Project Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.ws.impl.IpssProjectItemImpl
		 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssProjectItem()
		 * @generated
		 */
		EClass IPSS_PROJECT_ITEM = eINSTANCE.getIpssProjectItem();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.ws.impl.IpssWorkSpaceImpl <em>Ipss Work Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.ws.impl.IpssWorkSpaceImpl
		 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssWorkSpace()
		 * @generated
		 */
		EClass IPSS_WORK_SPACE = eINSTANCE.getIpssWorkSpace();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.ws.impl.IpssProjectImpl <em>Ipss Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.ws.impl.IpssProjectImpl
		 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssProject()
		 * @generated
		 */
		EClass IPSS_PROJECT = eINSTANCE.getIpssProject();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.ws.impl.IpssProjectFolderImpl <em>Ipss Project Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.ws.impl.IpssProjectFolderImpl
		 * @see org.interpss.editor.ws.impl.IpssWsPackageImpl#getIpssProjectFolder()
		 * @generated
		 */
		EClass IPSS_PROJECT_FOLDER = eINSTANCE.getIpssProjectFolder();

	}

} //IpssWsPackage
