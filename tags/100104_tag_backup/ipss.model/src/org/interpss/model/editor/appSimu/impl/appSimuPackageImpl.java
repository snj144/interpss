/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.appSimu.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.interpss.model.editor.appSimu.AppSimuContext;
import org.interpss.model.editor.appSimu.ProjectData;
import org.interpss.model.editor.appSimu.SimuRunType;
import org.interpss.model.editor.appSimu.appSimuFactory;
import org.interpss.model.editor.appSimu.appSimuPackage;

import org.interpss.model.editor.doc.docPackage;

import org.interpss.model.editor.doc.impl.docPackageImpl;

import org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl;

import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class appSimuPackageImpl extends EPackageImpl implements appSimuPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appSimuContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum simuRunTypeEEnum = null;

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
	 * @see org.interpss.model.editor.appSimu.appSimuPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private appSimuPackageImpl() {
		super(eNS_URI, appSimuFactory.eINSTANCE);
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
	public static appSimuPackage init() {
		if (isInited) return (appSimuPackage)EPackage.Registry.INSTANCE.getEPackage(appSimuPackage.eNS_URI);

		// Obtain or create and register package
		appSimuPackageImpl theappSimuPackage = (appSimuPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof appSimuPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new appSimuPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		wkSpacePackageImpl thewkSpacePackage = (wkSpacePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(wkSpacePackage.eNS_URI) instanceof wkSpacePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(wkSpacePackage.eNS_URI) : wkSpacePackage.eINSTANCE);
		docPackageImpl thedocPackage = (docPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(docPackage.eNS_URI) instanceof docPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(docPackage.eNS_URI) : docPackage.eINSTANCE);

		// Create package meta-data objects
		theappSimuPackage.createPackageContents();
		thewkSpacePackage.createPackageContents();
		thedocPackage.createPackageContents();

		// Initialize created meta-data
		theappSimuPackage.initializePackageContents();
		thewkSpacePackage.initializePackageContents();
		thedocPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theappSimuPackage.freeze();

		return theappSimuPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppSimuContext() {
		return appSimuContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppSimuContext_LastSimuRunType() {
		return (EAttribute)appSimuContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppSimuContext_AclfConverged() {
		return (EAttribute)appSimuContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppSimuContext_ScCalculated() {
		return (EAttribute)appSimuContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppSimuContext_ProjData() {
		return (EReference)appSimuContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppSimuContext_SimuCtx() {
		return (EReference)appSimuContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectData() {
		return projectDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSimuRunType() {
		return simuRunTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public appSimuFactory getappSimuFactory() {
		return (appSimuFactory)getEFactoryInstance();
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
		appSimuContextEClass = createEClass(APP_SIMU_CONTEXT);
		createEAttribute(appSimuContextEClass, APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE);
		createEAttribute(appSimuContextEClass, APP_SIMU_CONTEXT__ACLF_CONVERGED);
		createEAttribute(appSimuContextEClass, APP_SIMU_CONTEXT__SC_CALCULATED);
		createEReference(appSimuContextEClass, APP_SIMU_CONTEXT__PROJ_DATA);
		createEReference(appSimuContextEClass, APP_SIMU_CONTEXT__SIMU_CTX);

		projectDataEClass = createEClass(PROJECT_DATA);

		// Create enums
		simuRunTypeEEnum = createEEnum(SIMU_RUN_TYPE);
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

		// Create type parameters
		ETypeParameter appSimuContextEClass_TSimuCtx = addETypeParameter(appSimuContextEClass, "TSimuCtx");

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(appSimuContextEClass, AppSimuContext.class, "AppSimuContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAppSimuContext_LastSimuRunType(), this.getSimuRunType(), "lastSimuRunType", null, 0, 1, AppSimuContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSimuContext_AclfConverged(), ecorePackage.getEBoolean(), "aclfConverged", null, 0, 1, AppSimuContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSimuContext_ScCalculated(), ecorePackage.getEBoolean(), "scCalculated", null, 0, 1, AppSimuContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppSimuContext_ProjData(), this.getProjectData(), null, "projData", null, 0, 1, AppSimuContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(appSimuContextEClass_TSimuCtx);
		initEReference(getAppSimuContext_SimuCtx(), g1, null, "simuCtx", null, 0, 1, AppSimuContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectDataEClass, ProjectData.class, "ProjectData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(simuRunTypeEEnum, SimuRunType.class, "SimuRunType");
		addEEnumLiteral(simuRunTypeEEnum, SimuRunType.ACLF);
		addEEnumLiteral(simuRunTypeEEnum, SimuRunType.ACSC);
		addEEnumLiteral(simuRunTypeEEnum, SimuRunType.DSTAB);

		// Create resource
		createResource(eNS_URI);
	}

} //appSimuPackageImpl
