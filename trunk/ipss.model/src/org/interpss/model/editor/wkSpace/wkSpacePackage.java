/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.interpss.model.editor.wkSpace.wkSpaceFactory
 * @model kind="package"
 * @generated
 */
public interface wkSpacePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wkSpace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.interpss.org/editor/workspace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ipss.editor.workspace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	wkSpacePackage eINSTANCE = org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl <em>Workspace Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getWorkspaceItem()
	 * @generated
	 */
	int WORKSPACE_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM__NAME = 1;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM__IPSS_DOCUMENT = 2;

	/**
	 * The number of structural features of the '<em>Workspace Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemContainerImpl <em>Workspace Item Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.WorkspaceItemContainerImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getWorkspaceItemContainer()
	 * @generated
	 */
	int WORKSPACE_ITEM_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM_CONTAINER__PARENT = WORKSPACE_ITEM__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM_CONTAINER__NAME = WORKSPACE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM_CONTAINER__IPSS_DOCUMENT = WORKSPACE_ITEM__IPSS_DOCUMENT;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST = WORKSPACE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Workspace Item Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT = WORKSPACE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectItemImpl <em>Ipss Project Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectItemImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProjectItem()
	 * @generated
	 */
	int IPSS_PROJECT_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM__PARENT = WORKSPACE_ITEM__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM__NAME = WORKSPACE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM__IPSS_DOCUMENT = WORKSPACE_ITEM__IPSS_DOCUMENT;

	/**
	 * The feature id for the '<em><b>Init Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM__INIT_STATUS = WORKSPACE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ipss Project Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_FEATURE_COUNT = WORKSPACE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.IpssWorkspaceImpl <em>Ipss Workspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.IpssWorkspaceImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssWorkspace()
	 * @generated
	 */
	int IPSS_WORKSPACE = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORKSPACE__PARENT = WORKSPACE_ITEM_CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORKSPACE__NAME = WORKSPACE_ITEM_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORKSPACE__IPSS_DOCUMENT = WORKSPACE_ITEM_CONTAINER__IPSS_DOCUMENT;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORKSPACE__WS_ITEM_LIST = WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The feature id for the '<em><b>Absolution Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORKSPACE__ABSOLUTION_PATH = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ipss Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_WORKSPACE_FEATURE_COUNT = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectFolderImpl <em>Ipss Project Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectFolderImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProjectFolder()
	 * @generated
	 */
	int IPSS_PROJECT_FOLDER = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER__PARENT = WORKSPACE_ITEM_CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER__NAME = WORKSPACE_ITEM_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER__IPSS_DOCUMENT = WORKSPACE_ITEM_CONTAINER__IPSS_DOCUMENT;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER__WS_ITEM_LIST = WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The number of structural features of the '<em>Ipss Project Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FOLDER_FEATURE_COUNT = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectImpl <em>Ipss Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProject()
	 * @generated
	 */
	int IPSS_PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__PARENT = WORKSPACE_ITEM_CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__NAME = WORKSPACE_ITEM_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__IPSS_DOCUMENT = WORKSPACE_ITEM_CONTAINER__IPSS_DOCUMENT;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__WS_ITEM_LIST = WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The feature id for the '<em><b>Proj Db Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__PROJ_DB_ID = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT__PARENT_PATH = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ipss Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_FEATURE_COUNT = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectItemGroupImpl <em>Ipss Project Item Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectItemGroupImpl
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProjectItemGroup()
	 * @generated
	 */
	int IPSS_PROJECT_ITEM_GROUP = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_GROUP__PARENT = WORKSPACE_ITEM_CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_GROUP__NAME = WORKSPACE_ITEM_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Ipss Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_GROUP__IPSS_DOCUMENT = WORKSPACE_ITEM_CONTAINER__IPSS_DOCUMENT;

	/**
	 * The feature id for the '<em><b>Ws Item List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_GROUP__WS_ITEM_LIST = WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST;

	/**
	 * The number of structural features of the '<em>Ipss Project Item Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_PROJECT_ITEM_GROUP_FEATURE_COUNT = WORKSPACE_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.wkSpace.ProjectItemStatus <em>Project Item Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.wkSpace.ProjectItemStatus
	 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getProjectItemStatus()
	 * @generated
	 */
	int PROJECT_ITEM_STATUS = 7;


	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.WorkspaceItem <em>Workspace Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace Item</em>'.
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItem
	 * @generated
	 */
	EClass getWorkspaceItem();

	/**
	 * Returns the meta object for the container reference '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItem#getParent()
	 * @see #getWorkspaceItem()
	 * @generated
	 */
	EReference getWorkspaceItem_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItem#getName()
	 * @see #getWorkspaceItem()
	 * @generated
	 */
	EAttribute getWorkspaceItem_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.interpss.model.editor.wkSpace.WorkspaceItem#getIpssDocument <em>Ipss Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ipss Document</em>'.
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItem#getIpssDocument()
	 * @see #getWorkspaceItem()
	 * @generated
	 */
	EReference getWorkspaceItem_IpssDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.WorkspaceItemContainer <em>Workspace Item Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace Item Container</em>'.
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItemContainer
	 * @generated
	 */
	EClass getWorkspaceItemContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.interpss.model.editor.wkSpace.WorkspaceItemContainer#getWsItemList <em>Ws Item List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ws Item List</em>'.
	 * @see org.interpss.model.editor.wkSpace.WorkspaceItemContainer#getWsItemList()
	 * @see #getWorkspaceItemContainer()
	 * @generated
	 */
	EReference getWorkspaceItemContainer_WsItemList();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.IpssProjectItem <em>Ipss Project Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project Item</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProjectItem
	 * @generated
	 */
	EClass getIpssProjectItem();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.wkSpace.IpssProjectItem#getInitStatus <em>Init Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Status</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProjectItem#getInitStatus()
	 * @see #getIpssProjectItem()
	 * @generated
	 */
	EAttribute getIpssProjectItem_InitStatus();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.IpssWorkspace <em>Ipss Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Workspace</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssWorkspace
	 * @generated
	 */
	EClass getIpssWorkspace();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.wkSpace.IpssWorkspace#getAbsolutionPath <em>Absolution Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Absolution Path</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssWorkspace#getAbsolutionPath()
	 * @see #getIpssWorkspace()
	 * @generated
	 */
	EAttribute getIpssWorkspace_AbsolutionPath();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.IpssProjectFolder <em>Ipss Project Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project Folder</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProjectFolder
	 * @generated
	 */
	EClass getIpssProjectFolder();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.IpssProject <em>Ipss Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProject
	 * @generated
	 */
	EClass getIpssProject();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.wkSpace.IpssProject#getProjDbId <em>Proj Db Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proj Db Id</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProject#getProjDbId()
	 * @see #getIpssProject()
	 * @generated
	 */
	EAttribute getIpssProject_ProjDbId();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.wkSpace.IpssProject#getParentPath <em>Parent Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Path</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProject#getParentPath()
	 * @see #getIpssProject()
	 * @generated
	 */
	EAttribute getIpssProject_ParentPath();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.wkSpace.IpssProjectItemGroup <em>Ipss Project Item Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Project Item Group</em>'.
	 * @see org.interpss.model.editor.wkSpace.IpssProjectItemGroup
	 * @generated
	 */
	EClass getIpssProjectItemGroup();

	/**
	 * Returns the meta object for enum '{@link org.interpss.model.editor.wkSpace.ProjectItemStatus <em>Project Item Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Project Item Status</em>'.
	 * @see org.interpss.model.editor.wkSpace.ProjectItemStatus
	 * @generated
	 */
	EEnum getProjectItemStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	wkSpaceFactory getwkSpaceFactory();

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
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl <em>Workspace Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getWorkspaceItem()
		 * @generated
		 */
		EClass WORKSPACE_ITEM = eINSTANCE.getWorkspaceItem();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_ITEM__PARENT = eINSTANCE.getWorkspaceItem_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_ITEM__NAME = eINSTANCE.getWorkspaceItem_Name();

		/**
		 * The meta object literal for the '<em><b>Ipss Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_ITEM__IPSS_DOCUMENT = eINSTANCE.getWorkspaceItem_IpssDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemContainerImpl <em>Workspace Item Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.WorkspaceItemContainerImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getWorkspaceItemContainer()
		 * @generated
		 */
		EClass WORKSPACE_ITEM_CONTAINER = eINSTANCE.getWorkspaceItemContainer();

		/**
		 * The meta object literal for the '<em><b>Ws Item List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST = eINSTANCE.getWorkspaceItemContainer_WsItemList();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectItemImpl <em>Ipss Project Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectItemImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProjectItem()
		 * @generated
		 */
		EClass IPSS_PROJECT_ITEM = eINSTANCE.getIpssProjectItem();

		/**
		 * The meta object literal for the '<em><b>Init Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_PROJECT_ITEM__INIT_STATUS = eINSTANCE.getIpssProjectItem_InitStatus();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.IpssWorkspaceImpl <em>Ipss Workspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.IpssWorkspaceImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssWorkspace()
		 * @generated
		 */
		EClass IPSS_WORKSPACE = eINSTANCE.getIpssWorkspace();

		/**
		 * The meta object literal for the '<em><b>Absolution Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_WORKSPACE__ABSOLUTION_PATH = eINSTANCE.getIpssWorkspace_AbsolutionPath();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectFolderImpl <em>Ipss Project Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectFolderImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProjectFolder()
		 * @generated
		 */
		EClass IPSS_PROJECT_FOLDER = eINSTANCE.getIpssProjectFolder();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectImpl <em>Ipss Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProject()
		 * @generated
		 */
		EClass IPSS_PROJECT = eINSTANCE.getIpssProject();

		/**
		 * The meta object literal for the '<em><b>Proj Db Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_PROJECT__PROJ_DB_ID = eINSTANCE.getIpssProject_ProjDbId();

		/**
		 * The meta object literal for the '<em><b>Parent Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPSS_PROJECT__PARENT_PATH = eINSTANCE.getIpssProject_ParentPath();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.impl.IpssProjectItemGroupImpl <em>Ipss Project Item Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.impl.IpssProjectItemGroupImpl
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getIpssProjectItemGroup()
		 * @generated
		 */
		EClass IPSS_PROJECT_ITEM_GROUP = eINSTANCE.getIpssProjectItemGroup();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.wkSpace.ProjectItemStatus <em>Project Item Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.wkSpace.ProjectItemStatus
		 * @see org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl#getProjectItemStatus()
		 * @generated
		 */
		EEnum PROJECT_ITEM_STATUS = eINSTANCE.getProjectItemStatus();

	}

} //wkSpacePackage
