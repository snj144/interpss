/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.interpss.model.editor.appSimu.appSimuPackage;

import org.interpss.model.editor.appSimu.impl.appSimuPackageImpl;

import org.interpss.model.editor.doc.docPackage;

import org.interpss.model.editor.doc.impl.docPackageImpl;

import org.interpss.model.editor.wkSpace.IpssProject;
import org.interpss.model.editor.wkSpace.IpssProjectFolder;
import org.interpss.model.editor.wkSpace.IpssProjectItem;
import org.interpss.model.editor.wkSpace.IpssProjectItemGroup;
import org.interpss.model.editor.wkSpace.IpssWorkspace;
import org.interpss.model.editor.wkSpace.ProjectItemStatus;
import org.interpss.model.editor.wkSpace.WorkspaceItem;
import org.interpss.model.editor.wkSpace.WorkspaceItemContainer;
import org.interpss.model.editor.wkSpace.wkSpaceFactory;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class wkSpacePackageImpl extends EPackageImpl implements wkSpacePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceItemContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssProjectItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssWorkspaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssProjectFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssProjectItemGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum projectItemStatusEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.interpss.model.editor.wkSpace.wkSpacePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private wkSpacePackageImpl() {
		super(eNS_URI, wkSpaceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static wkSpacePackage init() {
		if (isInited) return (wkSpacePackage)EPackage.Registry.INSTANCE.getEPackage(wkSpacePackage.eNS_URI);

		// Obtain or create and register package
		wkSpacePackageImpl thewkSpacePackage = (wkSpacePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof wkSpacePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new wkSpacePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		docPackageImpl thedocPackage = (docPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(docPackage.eNS_URI) instanceof docPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(docPackage.eNS_URI) : docPackage.eINSTANCE);
		appSimuPackageImpl theappSimuPackage = (appSimuPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(appSimuPackage.eNS_URI) instanceof appSimuPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(appSimuPackage.eNS_URI) : appSimuPackage.eINSTANCE);

		// Create package meta-data objects
		thewkSpacePackage.createPackageContents();
		thedocPackage.createPackageContents();
		theappSimuPackage.createPackageContents();

		// Initialize created meta-data
		thewkSpacePackage.initializePackageContents();
		thedocPackage.initializePackageContents();
		theappSimuPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thewkSpacePackage.freeze();

		return thewkSpacePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceItem() {
		return workspaceItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceItem_Parent() {
		return (EReference)workspaceItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceItem_Name() {
		return (EAttribute)workspaceItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceItem_IpssDocument() {
		return (EReference)workspaceItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceItemContainer() {
		return workspaceItemContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceItemContainer_WsItemList() {
		return (EReference)workspaceItemContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssProjectItem() {
		return ipssProjectItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssProjectItem_InitStatus() {
		return (EAttribute)ipssProjectItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssWorkspace() {
		return ipssWorkspaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssWorkspace_AbsolutionPath() {
		return (EAttribute)ipssWorkspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssProjectFolder() {
		return ipssProjectFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssProject() {
		return ipssProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssProject_ProjDbId() {
		return (EAttribute)ipssProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssProject_ParentPath() {
		return (EAttribute)ipssProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssProjectItemGroup() {
		return ipssProjectItemGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProjectItemStatus() {
		return projectItemStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public wkSpaceFactory getwkSpaceFactory() {
		return (wkSpaceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		workspaceItemEClass = createEClass(WORKSPACE_ITEM);
		createEReference(workspaceItemEClass, WORKSPACE_ITEM__PARENT);
		createEAttribute(workspaceItemEClass, WORKSPACE_ITEM__NAME);
		createEReference(workspaceItemEClass, WORKSPACE_ITEM__IPSS_DOCUMENT);

		workspaceItemContainerEClass = createEClass(WORKSPACE_ITEM_CONTAINER);
		createEReference(workspaceItemContainerEClass, WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST);

		ipssProjectItemEClass = createEClass(IPSS_PROJECT_ITEM);
		createEAttribute(ipssProjectItemEClass, IPSS_PROJECT_ITEM__INIT_STATUS);

		ipssWorkspaceEClass = createEClass(IPSS_WORKSPACE);
		createEAttribute(ipssWorkspaceEClass, IPSS_WORKSPACE__ABSOLUTION_PATH);

		ipssProjectFolderEClass = createEClass(IPSS_PROJECT_FOLDER);

		ipssProjectEClass = createEClass(IPSS_PROJECT);
		createEAttribute(ipssProjectEClass, IPSS_PROJECT__PROJ_DB_ID);
		createEAttribute(ipssProjectEClass, IPSS_PROJECT__PARENT_PATH);

		ipssProjectItemGroupEClass = createEClass(IPSS_PROJECT_ITEM_GROUP);

		// Create enums
		projectItemStatusEEnum = createEEnum(PROJECT_ITEM_STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		docPackage thedocPackage = (docPackage)EPackage.Registry.INSTANCE.getEPackage(docPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		workspaceItemContainerEClass.getESuperTypes().add(this.getWorkspaceItem());
		ipssProjectItemEClass.getESuperTypes().add(this.getWorkspaceItem());
		ipssWorkspaceEClass.getESuperTypes().add(this.getWorkspaceItemContainer());
		ipssProjectFolderEClass.getESuperTypes().add(this.getWorkspaceItemContainer());
		ipssProjectEClass.getESuperTypes().add(this.getWorkspaceItemContainer());
		ipssProjectItemGroupEClass.getESuperTypes().add(this.getWorkspaceItemContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(workspaceItemEClass, WorkspaceItem.class, "WorkspaceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspaceItem_Parent(), this.getWorkspaceItemContainer(), this.getWorkspaceItemContainer_WsItemList(), "parent", null, 0, 1, WorkspaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspaceItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, WorkspaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspaceItem_IpssDocument(), thedocPackage.getIpssDocument(), thedocPackage.getIpssDocument_WorkspaceItem(), "ipssDocument", null, 0, 1, WorkspaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workspaceItemContainerEClass, WorkspaceItemContainer.class, "WorkspaceItemContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspaceItemContainer_WsItemList(), this.getWorkspaceItem(), this.getWorkspaceItem_Parent(), "wsItemList", null, 0, -1, WorkspaceItemContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getWorkspaceItemContainer_WsItemList().getEKeys().add(this.getWorkspaceItem_Name());

		initEClass(ipssProjectItemEClass, IpssProjectItem.class, "IpssProjectItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssProjectItem_InitStatus(), this.getProjectItemStatus(), "initStatus", null, 0, 1, IpssProjectItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssWorkspaceEClass, IpssWorkspace.class, "IpssWorkspace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssWorkspace_AbsolutionPath(), ecorePackage.getEString(), "absolutionPath", null, 0, 1, IpssWorkspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssProjectFolderEClass, IpssProjectFolder.class, "IpssProjectFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssProjectEClass, IpssProject.class, "IpssProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssProject_ProjDbId(), ecorePackage.getEInt(), "projDbId", null, 0, 1, IpssProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIpssProject_ParentPath(), ecorePackage.getEString(), "parentPath", null, 0, 1, IpssProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssProjectItemGroupEClass, IpssProjectItemGroup.class, "IpssProjectItemGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(projectItemStatusEEnum, ProjectItemStatus.class, "ProjectItemStatus");
		addEEnumLiteral(projectItemStatusEEnum, ProjectItemStatus.OPEN);
		addEEnumLiteral(projectItemStatusEEnum, ProjectItemStatus.CLOSE);
		addEEnumLiteral(projectItemStatusEEnum, ProjectItemStatus.ACTIVE);

		// Create resource
		createResource(eNS_URI);
	}

} //wkSpacePackageImpl
