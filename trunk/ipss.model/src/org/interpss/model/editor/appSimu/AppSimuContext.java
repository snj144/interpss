/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.appSimu;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Simu Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.interpss.model.editor.appSimu.AppSimuContext#getLastSimuRunType <em>Last Simu Run Type</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.AppSimuContext#isAclfConverged <em>Aclf Converged</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.AppSimuContext#isScCalculated <em>Sc Calculated</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.AppSimuContext#getProjData <em>Proj Data</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.AppSimuContext#getSimuCtx <em>Simu Ctx</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.interpss.model.editor.appSimu.appSimuPackage#getAppSimuContext()
 * @model
 * @generated
 */
public interface AppSimuContext<TSimuCtx> extends EObject {
	/**
	 * Returns the value of the '<em><b>Last Simu Run Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.interpss.model.editor.appSimu.SimuRunType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Simu Run Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Simu Run Type</em>' attribute.
	 * @see org.interpss.model.editor.appSimu.SimuRunType
	 * @see #setLastSimuRunType(SimuRunType)
	 * @see org.interpss.model.editor.appSimu.appSimuPackage#getAppSimuContext_LastSimuRunType()
	 * @model
	 * @generated
	 */
	SimuRunType getLastSimuRunType();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.appSimu.AppSimuContext#getLastSimuRunType <em>Last Simu Run Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Simu Run Type</em>' attribute.
	 * @see org.interpss.model.editor.appSimu.SimuRunType
	 * @see #getLastSimuRunType()
	 * @generated
	 */
	void setLastSimuRunType(SimuRunType value);

	/**
	 * Returns the value of the '<em><b>Aclf Converged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aclf Converged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aclf Converged</em>' attribute.
	 * @see #setAclfConverged(boolean)
	 * @see org.interpss.model.editor.appSimu.appSimuPackage#getAppSimuContext_AclfConverged()
	 * @model
	 * @generated
	 */
	boolean isAclfConverged();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.appSimu.AppSimuContext#isAclfConverged <em>Aclf Converged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aclf Converged</em>' attribute.
	 * @see #isAclfConverged()
	 * @generated
	 */
	void setAclfConverged(boolean value);

	/**
	 * Returns the value of the '<em><b>Sc Calculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sc Calculated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sc Calculated</em>' attribute.
	 * @see #setScCalculated(boolean)
	 * @see org.interpss.model.editor.appSimu.appSimuPackage#getAppSimuContext_ScCalculated()
	 * @model
	 * @generated
	 */
	boolean isScCalculated();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.appSimu.AppSimuContext#isScCalculated <em>Sc Calculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sc Calculated</em>' attribute.
	 * @see #isScCalculated()
	 * @generated
	 */
	void setScCalculated(boolean value);

	/**
	 * Returns the value of the '<em><b>Proj Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proj Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proj Data</em>' containment reference.
	 * @see #setProjData(ProjectData)
	 * @see org.interpss.model.editor.appSimu.appSimuPackage#getAppSimuContext_ProjData()
	 * @model containment="true"
	 * @generated
	 */
	ProjectData getProjData();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.appSimu.AppSimuContext#getProjData <em>Proj Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proj Data</em>' containment reference.
	 * @see #getProjData()
	 * @generated
	 */
	void setProjData(ProjectData value);

	/**
	 * Returns the value of the '<em><b>Simu Ctx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simu Ctx</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simu Ctx</em>' reference.
	 * @see #setSimuCtx(Object)
	 * @see org.interpss.model.editor.appSimu.appSimuPackage#getAppSimuContext_SimuCtx()
	 * @model kind="reference"
	 * @generated
	 */
	TSimuCtx getSimuCtx();

	/**
	 * Sets the value of the '{@link org.interpss.model.editor.appSimu.AppSimuContext#getSimuCtx <em>Simu Ctx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simu Ctx</em>' reference.
	 * @see #getSimuCtx()
	 * @generated
	 */
	void setSimuCtx(TSimuCtx value);

} // AppSimuContext
