/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.appSimu.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.interpss.model.editor.appSimu.AppSimuContext;
import org.interpss.model.editor.appSimu.ProjectData;
import org.interpss.model.editor.appSimu.SimuRunType;
import org.interpss.model.editor.appSimu.appSimuPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>App Simu Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl#getLastSimuRunType <em>Last Simu Run Type</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl#isAclfConverged <em>Aclf Converged</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl#isScCalculated <em>Sc Calculated</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl#getProjData <em>Proj Data</em>}</li>
 *   <li>{@link org.interpss.model.editor.appSimu.impl.AppSimuContextImpl#getSimuCtx <em>Simu Ctx</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AppSimuContextImpl<TSimuCtx> extends EObjectImpl implements AppSimuContext<TSimuCtx> {
	/**
	 * The default value of the '{@link #getLastSimuRunType() <em>Last Simu Run Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSimuRunType()
	 * @generated
	 * @ordered
	 */
	protected static final SimuRunType LAST_SIMU_RUN_TYPE_EDEFAULT = SimuRunType.ACLF;

	/**
	 * The cached value of the '{@link #getLastSimuRunType() <em>Last Simu Run Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSimuRunType()
	 * @generated
	 * @ordered
	 */
	protected SimuRunType lastSimuRunType = LAST_SIMU_RUN_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAclfConverged() <em>Aclf Converged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAclfConverged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACLF_CONVERGED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAclfConverged() <em>Aclf Converged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAclfConverged()
	 * @generated
	 * @ordered
	 */
	protected boolean aclfConverged = ACLF_CONVERGED_EDEFAULT;

	/**
	 * The default value of the '{@link #isScCalculated() <em>Sc Calculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isScCalculated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SC_CALCULATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isScCalculated() <em>Sc Calculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isScCalculated()
	 * @generated
	 * @ordered
	 */
	protected boolean scCalculated = SC_CALCULATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjData() <em>Proj Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjData()
	 * @generated
	 * @ordered
	 */
	protected ProjectData projData;

	/**
	 * The cached value of the '{@link #getSimuCtx() <em>Simu Ctx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimuCtx()
	 * @generated
	 * @ordered
	 */
	protected TSimuCtx simuCtx;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppSimuContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return appSimuPackage.Literals.APP_SIMU_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuRunType getLastSimuRunType() {
		return lastSimuRunType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSimuRunType(SimuRunType newLastSimuRunType) {
		SimuRunType oldLastSimuRunType = lastSimuRunType;
		lastSimuRunType = newLastSimuRunType == null ? LAST_SIMU_RUN_TYPE_EDEFAULT : newLastSimuRunType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, appSimuPackage.APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE, oldLastSimuRunType, lastSimuRunType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAclfConverged() {
		return aclfConverged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAclfConverged(boolean newAclfConverged) {
		boolean oldAclfConverged = aclfConverged;
		aclfConverged = newAclfConverged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, appSimuPackage.APP_SIMU_CONTEXT__ACLF_CONVERGED, oldAclfConverged, aclfConverged));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isScCalculated() {
		return scCalculated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScCalculated(boolean newScCalculated) {
		boolean oldScCalculated = scCalculated;
		scCalculated = newScCalculated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, appSimuPackage.APP_SIMU_CONTEXT__SC_CALCULATED, oldScCalculated, scCalculated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectData getProjData() {
		return projData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjData(ProjectData newProjData, NotificationChain msgs) {
		ProjectData oldProjData = projData;
		projData = newProjData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA, oldProjData, newProjData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjData(ProjectData newProjData) {
		if (newProjData != projData) {
			NotificationChain msgs = null;
			if (projData != null)
				msgs = ((InternalEObject)projData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA, null, msgs);
			if (newProjData != null)
				msgs = ((InternalEObject)newProjData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA, null, msgs);
			msgs = basicSetProjData(newProjData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA, newProjData, newProjData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TSimuCtx getSimuCtx() {
		if (simuCtx != null && ((EObject)simuCtx).eIsProxy()) {
			InternalEObject oldSimuCtx = (InternalEObject)simuCtx;
			simuCtx = (TSimuCtx)eResolveProxy(oldSimuCtx);
			if (simuCtx != oldSimuCtx) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, appSimuPackage.APP_SIMU_CONTEXT__SIMU_CTX, oldSimuCtx, simuCtx));
			}
		}
		return simuCtx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TSimuCtx basicGetSimuCtx() {
		return simuCtx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimuCtx(TSimuCtx newSimuCtx) {
		TSimuCtx oldSimuCtx = simuCtx;
		simuCtx = newSimuCtx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, appSimuPackage.APP_SIMU_CONTEXT__SIMU_CTX, oldSimuCtx, simuCtx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA:
				return basicSetProjData(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case appSimuPackage.APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE:
				return getLastSimuRunType();
			case appSimuPackage.APP_SIMU_CONTEXT__ACLF_CONVERGED:
				return isAclfConverged() ? Boolean.TRUE : Boolean.FALSE;
			case appSimuPackage.APP_SIMU_CONTEXT__SC_CALCULATED:
				return isScCalculated() ? Boolean.TRUE : Boolean.FALSE;
			case appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA:
				return getProjData();
			case appSimuPackage.APP_SIMU_CONTEXT__SIMU_CTX:
				if (resolve) return getSimuCtx();
				return basicGetSimuCtx();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case appSimuPackage.APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE:
				setLastSimuRunType((SimuRunType)newValue);
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__ACLF_CONVERGED:
				setAclfConverged(((Boolean)newValue).booleanValue());
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__SC_CALCULATED:
				setScCalculated(((Boolean)newValue).booleanValue());
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA:
				setProjData((ProjectData)newValue);
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__SIMU_CTX:
				setSimuCtx((TSimuCtx)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case appSimuPackage.APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE:
				setLastSimuRunType(LAST_SIMU_RUN_TYPE_EDEFAULT);
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__ACLF_CONVERGED:
				setAclfConverged(ACLF_CONVERGED_EDEFAULT);
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__SC_CALCULATED:
				setScCalculated(SC_CALCULATED_EDEFAULT);
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA:
				setProjData((ProjectData)null);
				return;
			case appSimuPackage.APP_SIMU_CONTEXT__SIMU_CTX:
				setSimuCtx((TSimuCtx)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case appSimuPackage.APP_SIMU_CONTEXT__LAST_SIMU_RUN_TYPE:
				return lastSimuRunType != LAST_SIMU_RUN_TYPE_EDEFAULT;
			case appSimuPackage.APP_SIMU_CONTEXT__ACLF_CONVERGED:
				return aclfConverged != ACLF_CONVERGED_EDEFAULT;
			case appSimuPackage.APP_SIMU_CONTEXT__SC_CALCULATED:
				return scCalculated != SC_CALCULATED_EDEFAULT;
			case appSimuPackage.APP_SIMU_CONTEXT__PROJ_DATA:
				return projData != null;
			case appSimuPackage.APP_SIMU_CONTEXT__SIMU_CTX:
				return simuCtx != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lastSimuRunType: ");
		result.append(lastSimuRunType);
		result.append(", aclfConverged: ");
		result.append(aclfConverged);
		result.append(", scCalculated: ");
		result.append(scCalculated);
		result.append(')');
		return result.toString();
	}

} //AppSimuContextImpl
