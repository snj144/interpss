/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.interpss.editor.doc.IpssDocPackage;
import org.interpss.editor.doc.impl.IpssDocPackageImpl;
import org.interpss.editor.ws.IpssProject;
import org.interpss.editor.ws.IpssProjectFolder;
import org.interpss.editor.ws.IpssProjectItem;
import org.interpss.editor.ws.IpssWorkSpace;
import org.interpss.editor.ws.IpssWsFactory;
import org.interpss.editor.ws.IpssWsItem;
import org.interpss.editor.ws.IpssWsItemContainer;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IpssWsPackageImpl extends EPackageImpl implements IpssWsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssWsItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssWsItemContainerEClass = null;

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
	private EClass ipssWorkSpaceEClass = null;

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
	private EClass ipssProjectFolderEClass = null;

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
	 * @see org.interpss.editor.ws.IpssWsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IpssWsPackageImpl() {
		super(eNS_URI, IpssWsFactory.eINSTANCE);
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
	public static IpssWsPackage init() {
		if (isInited) return (IpssWsPackage)EPackage.Registry.INSTANCE.getEPackage(IpssWsPackage.eNS_URI);

		// Obtain or create and register package
		IpssWsPackageImpl theIpssWsPackage = (IpssWsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof IpssWsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new IpssWsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		IpssDocPackageImpl theIpssDocPackage = (IpssDocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(IpssDocPackage.eNS_URI) instanceof IpssDocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(IpssDocPackage.eNS_URI) : IpssDocPackage.eINSTANCE);

		// Create package meta-data objects
		theIpssWsPackage.createPackageContents();
		theIpssDocPackage.createPackageContents();

		// Initialize created meta-data
		theIpssWsPackage.initializePackageContents();
		theIpssDocPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIpssWsPackage.freeze();

		return theIpssWsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssWsItem() {
		return ipssWsItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpssWsItem_IpssDoc() {
		return (EReference)ipssWsItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssWsItemContainer() {
		return ipssWsItemContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpssWsItemContainer_WsItemList() {
		return (EReference)ipssWsItemContainerEClass.getEStructuralFeatures().get(0);
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
	public EClass getIpssWorkSpace() {
		return ipssWorkSpaceEClass;
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
	public EClass getIpssProjectFolder() {
		return ipssProjectFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsFactory getIpssWsFactory() {
		return (IpssWsFactory)getEFactoryInstance();
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
		ipssWsItemEClass = createEClass(IPSS_WS_ITEM);
		createEReference(ipssWsItemEClass, IPSS_WS_ITEM__IPSS_DOC);

		ipssWsItemContainerEClass = createEClass(IPSS_WS_ITEM_CONTAINER);
		createEReference(ipssWsItemContainerEClass, IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST);

		ipssProjectItemEClass = createEClass(IPSS_PROJECT_ITEM);

		ipssWorkSpaceEClass = createEClass(IPSS_WORK_SPACE);

		ipssProjectEClass = createEClass(IPSS_PROJECT);

		ipssProjectFolderEClass = createEClass(IPSS_PROJECT_FOLDER);
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
		IpssDocPackage theIpssDocPackage = (IpssDocPackage)EPackage.Registry.INSTANCE.getEPackage(IpssDocPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ipssWsItemContainerEClass.getESuperTypes().add(this.getIpssWsItem());
		ipssProjectItemEClass.getESuperTypes().add(this.getIpssWsItem());
		ipssWorkSpaceEClass.getESuperTypes().add(this.getIpssWsItemContainer());
		ipssProjectEClass.getESuperTypes().add(this.getIpssWsItemContainer());
		ipssProjectFolderEClass.getESuperTypes().add(this.getIpssWsItemContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(ipssWsItemEClass, IpssWsItem.class, "IpssWsItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIpssWsItem_IpssDoc(), theIpssDocPackage.getIpssDocument(), theIpssDocPackage.getIpssDocument_WsItem(), "ipssDoc", null, 0, 1, IpssWsItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssWsItemContainerEClass, IpssWsItemContainer.class, "IpssWsItemContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIpssWsItemContainer_WsItemList(), this.getIpssWsItem(), null, "wsItemList", null, 0, -1, IpssWsItemContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssProjectItemEClass, IpssProjectItem.class, "IpssProjectItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssWorkSpaceEClass, IpssWorkSpace.class, "IpssWorkSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssProjectEClass, IpssProject.class, "IpssProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssProjectFolderEClass, IpssProjectFolder.class, "IpssProjectFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //IpssWsPackageImpl
