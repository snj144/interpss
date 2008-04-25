/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.interpss.editor.doc.IpssCustomDocument;
import org.interpss.editor.doc.IpssDocFactory;
import org.interpss.editor.doc.IpssDocPackage;
import org.interpss.editor.doc.IpssDocument;
import org.interpss.editor.doc.IpssDocumentItem;
import org.interpss.editor.doc.IpssEditableDocument;
import org.interpss.editor.doc.IpssEditorDocument;
import org.interpss.editor.doc.IpssGraphicDocument;
import org.interpss.editor.doc.IpssReportDocument;
import org.interpss.editor.doc.IpssSimuDocument;
import org.interpss.editor.doc.IpssTextDocument;
import org.interpss.editor.doc.IpssXmlDocument;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ws.IpssWsPackage;
import org.interpss.editor.ws.impl.IpssWsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IpssDocPackageImpl extends EPackageImpl implements IpssDocPackage {
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
	private EClass ipssDocumentItemEClass = null;

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
	private EClass ipssSimuDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssCustomDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssGraphicDocumentEClass = null;

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
	private EClass ipssTextDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipssXmlDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType appSimuContextEDataType = null;

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
	 * @see org.interpss.editor.doc.IpssDocPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IpssDocPackageImpl() {
		super(eNS_URI, IpssDocFactory.eINSTANCE);
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
	public static IpssDocPackage init() {
		if (isInited) return (IpssDocPackage)EPackage.Registry.INSTANCE.getEPackage(IpssDocPackage.eNS_URI);

		// Obtain or create and register package
		IpssDocPackageImpl theIpssDocPackage = (IpssDocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof IpssDocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new IpssDocPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		IpssWsPackageImpl theIpssWsPackage = (IpssWsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(IpssWsPackage.eNS_URI) instanceof IpssWsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(IpssWsPackage.eNS_URI) : IpssWsPackage.eINSTANCE);

		// Create package meta-data objects
		theIpssDocPackage.createPackageContents();
		theIpssWsPackage.createPackageContents();

		// Initialize created meta-data
		theIpssDocPackage.initializePackageContents();
		theIpssWsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIpssDocPackage.freeze();

		return theIpssDocPackage;
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
	public EReference getIpssDocument_WsItem() {
		return (EReference)ipssDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssDocumentItem() {
		return ipssDocumentItemEClass;
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
	public EAttribute getIpssEditorDocument_FilePath() {
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
	public EClass getIpssSimuDocument() {
		return ipssSimuDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpssSimuDocument_AppSimuCtx() {
		return (EAttribute)ipssSimuDocumentEClass.getEStructuralFeatures().get(0);
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
	public EClass getIpssGraphicDocument() {
		return ipssGraphicDocumentEClass;
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
	public EClass getIpssTextDocument() {
		return ipssTextDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpssXmlDocument() {
		return ipssXmlDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAppSimuContext() {
		return appSimuContextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocFactory getIpssDocFactory() {
		return (IpssDocFactory)getEFactoryInstance();
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
		createEReference(ipssDocumentEClass, IPSS_DOCUMENT__WS_ITEM);

		ipssDocumentItemEClass = createEClass(IPSS_DOCUMENT_ITEM);

		ipssEditorDocumentEClass = createEClass(IPSS_EDITOR_DOCUMENT);
		createEAttribute(ipssEditorDocumentEClass, IPSS_EDITOR_DOCUMENT__FILE_PATH);

		ipssEditableDocumentEClass = createEClass(IPSS_EDITABLE_DOCUMENT);
		createEAttribute(ipssEditableDocumentEClass, IPSS_EDITABLE_DOCUMENT__MODIFIED);

		ipssSimuDocumentEClass = createEClass(IPSS_SIMU_DOCUMENT);
		createEAttribute(ipssSimuDocumentEClass, IPSS_SIMU_DOCUMENT__APP_SIMU_CTX);

		ipssCustomDocumentEClass = createEClass(IPSS_CUSTOM_DOCUMENT);

		ipssGraphicDocumentEClass = createEClass(IPSS_GRAPHIC_DOCUMENT);

		ipssReportDocumentEClass = createEClass(IPSS_REPORT_DOCUMENT);

		ipssTextDocumentEClass = createEClass(IPSS_TEXT_DOCUMENT);

		ipssXmlDocumentEClass = createEClass(IPSS_XML_DOCUMENT);

		// Create data types
		appSimuContextEDataType = createEDataType(APP_SIMU_CONTEXT);
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
		IpssWsPackage theIpssWsPackage = (IpssWsPackage)EPackage.Registry.INSTANCE.getEPackage(IpssWsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ipssDocumentItemEClass.getESuperTypes().add(this.getIpssDocument());
		ipssEditorDocumentEClass.getESuperTypes().add(this.getIpssDocumentItem());
		ipssEditableDocumentEClass.getESuperTypes().add(this.getIpssEditorDocument());
		ipssSimuDocumentEClass.getESuperTypes().add(this.getIpssEditableDocument());
		ipssCustomDocumentEClass.getESuperTypes().add(this.getIpssSimuDocument());
		ipssGraphicDocumentEClass.getESuperTypes().add(this.getIpssSimuDocument());
		ipssReportDocumentEClass.getESuperTypes().add(this.getIpssEditorDocument());
		ipssTextDocumentEClass.getESuperTypes().add(this.getIpssEditableDocument());
		ipssXmlDocumentEClass.getESuperTypes().add(this.getIpssEditableDocument());

		// Initialize classes and features; add operations and parameters
		initEClass(ipssDocumentEClass, IpssDocument.class, "IpssDocument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIpssDocument_WsItem(), theIpssWsPackage.getIpssWsItem(), theIpssWsPackage.getIpssWsItem_IpssDoc(), "wsItem", null, 1, 1, IpssDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssDocumentItemEClass, IpssDocumentItem.class, "IpssDocumentItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssEditorDocumentEClass, IpssEditorDocument.class, "IpssEditorDocument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssEditorDocument_FilePath(), ecorePackage.getEString(), "filePath", null, 0, 1, IpssEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssEditableDocumentEClass, IpssEditableDocument.class, "IpssEditableDocument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssEditableDocument_Modified(), ecorePackage.getEBoolean(), "modified", null, 0, 1, IpssEditableDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssSimuDocumentEClass, IpssSimuDocument.class, "IpssSimuDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpssSimuDocument_AppSimuCtx(), this.getAppSimuContext(), "appSimuCtx", null, 0, 1, IpssSimuDocument.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipssCustomDocumentEClass, IpssCustomDocument.class, "IpssCustomDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssGraphicDocumentEClass, IpssGraphicDocument.class, "IpssGraphicDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssReportDocumentEClass, IpssReportDocument.class, "IpssReportDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssTextDocumentEClass, IpssTextDocument.class, "IpssTextDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipssXmlDocumentEClass, IpssXmlDocument.class, "IpssXmlDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(appSimuContextEDataType, IAppSimuContext.class, "AppSimuContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //IpssDocPackageImpl
