/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.appSimu;

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
 * @see org.interpss.model.editor.appSimu.appSimuFactory
 * @model kind="package"
 * @generated
 */
public interface appSimuPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "appSimu";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.interpss.org/editor/appSimuCtx";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ipss.editor.appSimuCtx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	appSimuPackage eINSTANCE = org.interpss.model.editor.appSimu.impl.appSimuPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl <em>App Simu Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.appSimu.impl.AppSimuContextImpl
	 * @see org.interpss.model.editor.appSimu.impl.appSimuPackageImpl#getAppSimuContext()
	 * @generated
	 */
	int APP_SIMU_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Last Simu Run Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Aclf Converged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SIMU_CONTEXT__ACLF_CONVERGED = 1;

	/**
	 * The feature id for the '<em><b>Sc Calculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SIMU_CONTEXT__SC_CALCULATED = 2;

	/**
	 * The feature id for the '<em><b>Proj Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SIMU_CONTEXT__PROJ_DATA = 3;

	/**
	 * The feature id for the '<em><b>Simu Ctx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SIMU_CONTEXT__SIMU_CTX = 4;

	/**
	 * The number of structural features of the '<em>App Simu Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SIMU_CONTEXT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.appSimu.impl.ProjectDataImpl <em>Project Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.appSimu.impl.ProjectDataImpl
	 * @see org.interpss.model.editor.appSimu.impl.appSimuPackageImpl#getProjectData()
	 * @generated
	 */
	int PROJECT_DATA = 1;

	/**
	 * The number of structural features of the '<em>Project Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.interpss.model.editor.appSimu.SimuRunType <em>Simu Run Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.model.editor.appSimu.SimuRunType
	 * @see org.interpss.model.editor.appSimu.impl.appSimuPackageImpl#getSimuRunType()
	 * @generated
	 */
	int SIMU_RUN_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.appSimu.AppSimuContext <em>App Simu Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Simu Context</em>'.
	 * @see org.interpss.model.editor.appSimu.AppSimuContext
	 * @generated
	 */
	EClass getAppSimuContext();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.appSimu.AppSimuContext#getLastSimuRunType <em>Last Simu Run Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Simu Run Type</em>'.
	 * @see org.interpss.model.editor.appSimu.AppSimuContext#getLastSimuRunType()
	 * @see #getAppSimuContext()
	 * @generated
	 */
	EAttribute getAppSimuContext_LastSimuRunType();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.appSimu.AppSimuContext#isAclfConverged <em>Aclf Converged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aclf Converged</em>'.
	 * @see org.interpss.model.editor.appSimu.AppSimuContext#isAclfConverged()
	 * @see #getAppSimuContext()
	 * @generated
	 */
	EAttribute getAppSimuContext_AclfConverged();

	/**
	 * Returns the meta object for the attribute '{@link org.interpss.model.editor.appSimu.AppSimuContext#isScCalculated <em>Sc Calculated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sc Calculated</em>'.
	 * @see org.interpss.model.editor.appSimu.AppSimuContext#isScCalculated()
	 * @see #getAppSimuContext()
	 * @generated
	 */
	EAttribute getAppSimuContext_ScCalculated();

	/**
	 * Returns the meta object for the containment reference '{@link org.interpss.model.editor.appSimu.AppSimuContext#getProjData <em>Proj Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Proj Data</em>'.
	 * @see org.interpss.model.editor.appSimu.AppSimuContext#getProjData()
	 * @see #getAppSimuContext()
	 * @generated
	 */
	EReference getAppSimuContext_ProjData();

	/**
	 * Returns the meta object for the reference '{@link org.interpss.model.editor.appSimu.AppSimuContext#getSimuCtx <em>Simu Ctx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Simu Ctx</em>'.
	 * @see org.interpss.model.editor.appSimu.AppSimuContext#getSimuCtx()
	 * @see #getAppSimuContext()
	 * @generated
	 */
	EReference getAppSimuContext_SimuCtx();

	/**
	 * Returns the meta object for class '{@link org.interpss.model.editor.appSimu.ProjectData <em>Project Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Data</em>'.
	 * @see org.interpss.model.editor.appSimu.ProjectData
	 * @generated
	 */
	EClass getProjectData();

	/**
	 * Returns the meta object for enum '{@link org.interpss.model.editor.appSimu.SimuRunType <em>Simu Run Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Simu Run Type</em>'.
	 * @see org.interpss.model.editor.appSimu.SimuRunType
	 * @generated
	 */
	EEnum getSimuRunType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	appSimuFactory getappSimuFactory();

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
		 * The meta object literal for the '{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl <em>App Simu Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.appSimu.impl.AppSimuContextImpl
		 * @see org.interpss.model.editor.appSimu.impl.appSimuPackageImpl#getAppSimuContext()
		 * @generated
		 */
		EClass APP_SIMU_CONTEXT = eINSTANCE.getAppSimuContext();

		/**
		 * The meta object literal for the '<em><b>Last Simu Run Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE = eINSTANCE.getAppSimuContext_LastSimuRunType();

		/**
		 * The meta object literal for the '<em><b>Aclf Converged</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SIMU_CONTEXT__ACLF_CONVERGED = eINSTANCE.getAppSimuContext_AclfConverged();

		/**
		 * The meta object literal for the '<em><b>Sc Calculated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SIMU_CONTEXT__SC_CALCULATED = eINSTANCE.getAppSimuContext_ScCalculated();

		/**
		 * The meta object literal for the '<em><b>Proj Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP_SIMU_CONTEXT__PROJ_DATA = eINSTANCE.getAppSimuContext_ProjData();

		/**
		 * The meta object literal for the '<em><b>Simu Ctx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP_SIMU_CONTEXT__SIMU_CTX = eINSTANCE.getAppSimuContext_SimuCtx();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.appSimu.impl.ProjectDataImpl <em>Project Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.appSimu.impl.ProjectDataImpl
		 * @see org.interpss.model.editor.appSimu.impl.appSimuPackageImpl#getProjectData()
		 * @generated
		 */
		EClass PROJECT_DATA = eINSTANCE.getProjectData();

		/**
		 * The meta object literal for the '{@link org.interpss.model.editor.appSimu.SimuRunType <em>Simu Run Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.model.editor.appSimu.SimuRunType
		 * @see org.interpss.model.editor.appSimu.impl.appSimuPackageImpl#getSimuRunType()
		 * @generated
		 */
		EEnum SIMU_RUN_TYPE = eINSTANCE.getSimuRunType();

	}

} //appSimuPackage
