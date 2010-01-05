/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.interpss.editor.doc.IpssDocPackage;
import org.interpss.editor.doc.IpssSimuDocument;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Simu Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.doc.impl.IpssSimuDocumentImpl#getAppSimuCtx <em>App Simu Ctx</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssSimuDocumentImpl extends IpssEditableDocumentImpl implements IpssSimuDocument {
	/**
	 * The default value of the '{@link #getAppSimuCtx() <em>App Simu Ctx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppSimuCtx()
	 * @generated
	 * @ordered
	 */
	protected static final IAppSimuContext APP_SIMU_CTX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAppSimuCtx() <em>App Simu Ctx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppSimuCtx()
	 * @generated
	 * @ordered
	 */
	protected IAppSimuContext appSimuCtx = APP_SIMU_CTX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssSimuDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssDocPackage.Literals.IPSS_SIMU_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAppSimuContext getAppSimuCtx() {
		return appSimuCtx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppSimuCtx(IAppSimuContext newAppSimuCtx) {
		IAppSimuContext oldAppSimuCtx = appSimuCtx;
		appSimuCtx = newAppSimuCtx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssDocPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX, oldAppSimuCtx, appSimuCtx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IpssDocPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				return getAppSimuCtx();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IpssDocPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				setAppSimuCtx((IAppSimuContext)newValue);
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
			case IpssDocPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				setAppSimuCtx(APP_SIMU_CTX_EDEFAULT);
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
			case IpssDocPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				return APP_SIMU_CTX_EDEFAULT == null ? appSimuCtx != null : !APP_SIMU_CTX_EDEFAULT.equals(appSimuCtx);
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
		result.append(" (appSimuCtx: ");
		result.append(appSimuCtx);
		result.append(')');
		return result.toString();
	}

} //IpssSimuDocumentImpl
