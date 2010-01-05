/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.doc.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.interpss.model.editor.appSimu.AppSimuContext;

import org.interpss.model.editor.doc.IpssSimuDocument;
import org.interpss.model.editor.doc.docPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Simu Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.doc.impl.IpssSimuDocumentImpl#getAppSimuCtx <em>App Simu Ctx</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssSimuDocumentImpl<TSimuCtx, TEditor, TViewer> extends IpssEditableDocumentImpl<TEditor, TViewer> implements IpssSimuDocument<TSimuCtx, TEditor, TViewer> {
	/**
	 * The cached value of the '{@link #getAppSimuCtx() <em>App Simu Ctx</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppSimuCtx()
	 * @generated
	 * @ordered
	 */
	protected AppSimuContext<TSimuCtx> appSimuCtx;

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
		return docPackage.Literals.IPSS_SIMU_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppSimuContext<TSimuCtx> getAppSimuCtx() {
		return appSimuCtx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAppSimuCtx(AppSimuContext<TSimuCtx> newAppSimuCtx, NotificationChain msgs) {
		AppSimuContext<TSimuCtx> oldAppSimuCtx = appSimuCtx;
		appSimuCtx = newAppSimuCtx;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX, oldAppSimuCtx, newAppSimuCtx);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppSimuCtx(AppSimuContext<TSimuCtx> newAppSimuCtx) {
		if (newAppSimuCtx != appSimuCtx) {
			NotificationChain msgs = null;
			if (appSimuCtx != null)
				msgs = ((InternalEObject)appSimuCtx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX, null, msgs);
			if (newAppSimuCtx != null)
				msgs = ((InternalEObject)newAppSimuCtx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX, null, msgs);
			msgs = basicSetAppSimuCtx(newAppSimuCtx, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX, newAppSimuCtx, newAppSimuCtx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				return basicSetAppSimuCtx(null, msgs);
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
			case docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				return getAppSimuCtx();
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
			case docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				setAppSimuCtx((AppSimuContext<TSimuCtx>)newValue);
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
			case docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				setAppSimuCtx((AppSimuContext<TSimuCtx>)null);
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
			case docPackage.IPSS_SIMU_DOCUMENT__APP_SIMU_CTX:
				return appSimuCtx != null;
		}
		return super.eIsSet(featureID);
	}

} //IpssSimuDocumentImpl
