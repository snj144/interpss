/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.interpss.editor.doc.IpssDocPackage;
import org.interpss.editor.doc.IpssDocument;
import org.interpss.editor.ws.IpssWsItem;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWsItemImpl#getIpssDoc <em>Ipss Doc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IpssWsItemImpl extends EObjectImpl implements IpssWsItem {
	/**
	 * The cached value of the '{@link #getIpssDoc() <em>Ipss Doc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpssDoc()
	 * @generated
	 * @ordered
	 */
	protected IpssDocument ipssDoc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssWsItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssWsPackage.Literals.IPSS_WS_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocument getIpssDoc() {
		if (ipssDoc != null && ipssDoc.eIsProxy()) {
			InternalEObject oldIpssDoc = (InternalEObject)ipssDoc;
			ipssDoc = (IpssDocument)eResolveProxy(oldIpssDoc);
			if (ipssDoc != oldIpssDoc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC, oldIpssDoc, ipssDoc));
			}
		}
		return ipssDoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocument basicGetIpssDoc() {
		return ipssDoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIpssDoc(IpssDocument newIpssDoc, NotificationChain msgs) {
		IpssDocument oldIpssDoc = ipssDoc;
		ipssDoc = newIpssDoc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC, oldIpssDoc, newIpssDoc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpssDoc(IpssDocument newIpssDoc) {
		if (newIpssDoc != ipssDoc) {
			NotificationChain msgs = null;
			if (ipssDoc != null)
				msgs = ((InternalEObject)ipssDoc).eInverseRemove(this, IpssDocPackage.IPSS_DOCUMENT__WS_ITEM, IpssDocument.class, msgs);
			if (newIpssDoc != null)
				msgs = ((InternalEObject)newIpssDoc).eInverseAdd(this, IpssDocPackage.IPSS_DOCUMENT__WS_ITEM, IpssDocument.class, msgs);
			msgs = basicSetIpssDoc(newIpssDoc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC, newIpssDoc, newIpssDoc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				if (ipssDoc != null)
					msgs = ((InternalEObject)ipssDoc).eInverseRemove(this, IpssDocPackage.IPSS_DOCUMENT__WS_ITEM, IpssDocument.class, msgs);
				return basicSetIpssDoc((IpssDocument)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				return basicSetIpssDoc(null, msgs);
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
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				if (resolve) return getIpssDoc();
				return basicGetIpssDoc();
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
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				setIpssDoc((IpssDocument)newValue);
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
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				setIpssDoc((IpssDocument)null);
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
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				return ipssDoc != null;
		}
		return super.eIsSet(featureID);
	}

} //IpssWsItemImpl
