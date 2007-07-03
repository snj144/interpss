/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.interpss.model.editor.appSimu.appSimuPackage;

import org.interpss.model.editor.appSimu.impl.appSimuPackageImpl;

import org.interpss.model.editor.doc.IpssCustomDocument;
import org.interpss.model.editor.doc.IpssDBDocument;
import org.interpss.model.editor.doc.IpssDocument;
import org.interpss.model.editor.doc.IpssEditableDocument;
import org.interpss.model.editor.doc.IpssEditorDocument;
import org.interpss.model.editor.doc.IpssJGraphDocument;
import org.interpss.model.editor.doc.IpssReportDocument;
import org.interpss.model.editor.doc.IpssSimuDocument;
import org.interpss.model.editor.doc.IpssTextDocument;
import org.interpss.model.editor.doc.docFactory;
import org.interpss.model.editor.doc.docPackage;

import org.interpss.model.editor.wkSpace.impl.wkSpacePackageImpl;

import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class docPackageImpl extends EPackageImpl implements docPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssEditorDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssEditableDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssReportDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssDBDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssTextDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssSimuDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssJGraphDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssCustomDocumentEClass = null;

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
	 * @see org.interpss.model.editor.doc.docPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private docPackageImpl() {
		super(eNS_URI, docFactory.eINSTANCE);
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
	public static docPackage init() {
		if (isInited) return (docPackage)EPackage.Registry.INSTANCE.getEPackage(docPackage.eNS_URI);

		// Obtain or create and register package
		docPackageImpl thedocPackage = (docPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof docPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new docPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		wkSpacePackageImpl thewkSpacePackage = (wkSpacePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(wkSpacePackage.eNS_URI) instanceof wkSpacePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(wkSpacePackage.eNS_URI) : wkSpacePackage.eINSTANCE);
		appSimuPackageImpl theappSimuPackage = (appSimuPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(appSimuPackage.eNS_URI) instanceof appSimuPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(appSimuPackage.eNS_URI) : appSimuPackage.eINSTANCE);

		// Create package meta-data objects
		thedocPackage.createPackageContents();
		thewkSpacePackage.createPackageContents();
		theappSimuPackage.createPackageContents();

		// Initialize created meta-data
		thedocPackage.initializePackageContents();
		thewkSpacePackage.initializePackageContents();
		theappSimuPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thedocPackage.freeze();

		return thedocPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssDocument() {
		return ipssDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpssDocument_WorkspaceItem() {
		return (EReference)ipssDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssEditorDocument() {
		return ipssEditorDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssEditorDocument_Viewer() {
		return (EAttribute)ipssEditorDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssEditableDocument() {
		return ipssEditableDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssEditableDocument_Modified() {
		return (EAttribute)ipssEditableDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssReportDocument() {
		return ipssReportDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssDBDocument() {
		return ipssDBDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssTextDocument() {
		return ipssTextDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssSimuDocument() {
		return ipssSimuDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpssSimuDocument_AppSimuCtx() {
		return (EReference)ipssSimuDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssJGraphDocument() {
		return ipssJGraphDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssCustomDocument() {
		return ipssCustomDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public docFactory getdocFactory() {
		return (docFactory)getEFactoryInstance();
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
		ipssDocumentEClass = createEClass(IPSS_DOCUMENT);
		createEReference(ipssDocumentEClass, IPSS_DOCUMENT__WORKSPACE_ITEM);

		ipssEditorDocumentEClass = createEClass(IPSS_EDITOR_DOCUMENT);
		createEAttribute(ipssEditorDocumentEClass, IPSS_EDITOR_DOCUMENT__VIEWER);

		ipssEditableDocumentEClass = createEClass(IPSS_EDITABLE_DOCUMENT);
		createEAttribute(ipssEditableDocumentEClass, IPSS_EDITABLE_DOCUMENT__MODIFIED);

		ipssReportDocumentEClass = createEClass(IPSS_REPORT_DOCUMENT);

		ipssDBDocumentEClass = createEClass(IPSS_DB_DOCUMENT);

		ipssTextDocumentEClass = createEClass(IPSS_TEXT_DOCUMENT);

		ipssSimuDocumentEClass = createEClass(IPSS_SIMU_DOCUMENT);
		createEReference(ipssSimuDocumentEClass, IPSS_SIMU_DOCUMENT__APP_SIMU_CTX);

		ipssJGraphDocumentEClass = createEClass(IPSS_JGRAPH_DOCUMENT);

		ipssCustomDocumentEClass = createEClass(IPSS_CUSTOM_DOCUMENT);
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
		wkSpacePackage thewkSpacePackage = (wkSpacePackage)EPackage.Registry.INSTANCE.getEPackage(wkSpacePackage.eNS_URI);
		appSimuPackage theappSimuPackage = (appSimuPackage)EPackage.Registry.INSTANCE.getEPackage(appSimuPackage.eNS_URI);

		// Create type parameters
		ETypeParameter ipssEditorDocumentEClass_TViewer = addETypeParameter(ipssEditorDocumentEClass, "TViewer");
		addETypeParameter(ipssEditableDocumentEClass, "TEditor");
		ETypeParameter ipssEditableDocumentEClass_TViewer = addETypeParameter(ipssEditableDocumentEClass, "TViewer");
		ETypeParameter ipssReportDocumentEClass_TViewer = addETypeParameter(ipssReportDocumentEClass, "TViewer");
		ETypeParameter ipssDBDocumentEClass_TViewer = addETypeParameter(ipssDBDocumentEClass, "TViewer");
		ETypeParameter ipssTextDocumentEClass_TEditor = addETypeParameter(ipssTextDocumentEClass, "TEditor");
		ETypeParameter ipssTextDocumentEClass_TViewer = addETypeParameter(ipssTextDocumentEClass, "TViewer");
		ETypeParameter ipssSimuDocumentEClass_TSimuCtx = addETypeParameter(ipssSimuDocumentEClass, "TSimuCtx");
		ETypeParameter ipssSimuDocumentEClass_TEditor = addETypeParameter(ipssSimuDocumentEClass, "TEditor");
		ETypeParameter ipssSimuDocumentEClass_TViewer = addETypeParameter(ipssSimuDocumentEClass, "TViewer");
		ETypeParameter ipssJGraphDocumentEClass_TAppSimuCtx = addETypeParameter(ipssJGraphDocumentEClass, "TAppSimuCtx");
		ETypeParameter ipssJGraphDocumentEClass_TEditor = addETypeParameter(ipssJGraphDocumentEClass, "TEditor");
		ETypeParameter ipssJGraphDocumentEClass_TViewer = addETypeParameter(ipssJGraphDocumentEClass, "TViewer");
		ETypeParameter ipssCustomDocumentEClass_TAppSimuCtx = addETypeParameter(ipssCustomDocumentEClass, "TAppSimuCtx");
		ETypeParameter ipssCustomDocumentEClass_TEditor = addETypeParameter(ipssCustomDocumentEClass, "TEditor");
		ETypeParameter ipssCustomDocumentEClass_TViewer = addETypeParameter(ipssCustomDocumentEClass, "TViewer");

		// Set bounds for type parameters

		// Add supertypes to classes
		ipssEditorDocumentEClass.getESuperTypes().add(this.getIpssDocument());
		EGenericType g1 = createEGenericType(this.getIpssEditorDocument());
		EGenericType g2 = createEGenericType(ipssEditableDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssEditableDocumentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIpssEditorDocument());
		g2 = createEGenericType(ipssReportDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssReportDocumentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIpssEditorDocument());
		g2 = createEGenericType(ipssDBDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssDBDocumentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIpssEditableDocument());
		g2 = createEGenericType(ipssTextDocumentEClass_TEditor);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ipssTextDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssTextDocumentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIpssEditableDocument());
		g2 = createEGenericType(ipssSimuDocumentEClass_TEditor);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ipssSimuDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssSimuDocumentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIpssSimuDocument());
		g2 = createEGenericType(ipssJGraphDocumentEClass_TAppSimuCtx);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ipssJGraphDocumentEClass_TEditor);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ipssJGraphDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssJGraphDocumentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIpssSimuDocument());
		g2 = createEGenericType(ipssCustomDocumentEClass_TAppSimuCtx);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ipssCustomDocumentEClass_TEditor);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ipssCustomDocumentEClass_TViewer);
		g1.getETypeArguments().add(g2);
		ipssCustomDocumentEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(ipssDocumentEClass, IpssDocument.class, "IpssDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIpssDocument_WorkspaceItem(), thewkSpacePackage.getWorkspaceItem(), thewkSpacePackage.getWorkspaceItem_IpssDocument(), "workspaceItem", null, 0, 1, IpssDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssEditorDocumentEClass, IpssEditorDocument.class, "IpssEditorDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ipssEditorDocumentEClass_TViewer);
		initEAttribute(getIpssEditorDocument_Viewer(), g1, "viewer", null, 0, 1, IpssEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssEditableDocumentEClass, IpssEditableDocument.class, "IpssEditableDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssEditableDocument_Modified(), ecorePackage.getEBoolean(), "modified", null, 0, 1, IpssEditableDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssReportDocumentEClass, IpssReportDocument.class, "IpssReportDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssDBDocumentEClass, IpssDBDocument.class, "IpssDBDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssTextDocumentEClass, IpssTextDocument.class, "IpssTextDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssSimuDocumentEClass, IpssSimuDocument.class, "IpssSimuDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theappSimuPackage.getAppSimuContext());
		g2 = createEGenericType(ipssSimuDocumentEClass_TSimuCtx);
		g1.getETypeArguments().add(g2);
		initEReference(getIpssSimuDocument_AppSimuCtx(), g1, null, "appSimuCtx", null, 0, 1, IpssSimuDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssJGraphDocumentEClass, IpssJGraphDocument.class, "IpssJGraphDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssCustomDocumentEClass, IpssCustomDocument.class, "IpssCustomDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //docPackageImpl
