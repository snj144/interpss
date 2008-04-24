/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.impl;

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
 * An implementation of the model object '<em><b>Ipss Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.doc.impl.IpssDocumentImpl#getWsItem <em>Ws Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IpssDocumentImpl extends EObjectImpl implements IpssDocument {
	/**
	 * The cached value of the '{@link #getWsItem() <em>Ws Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsItem()
	 * @generated
	 * @ordered
	 */
	protected IpssWsItem wsItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssDocPackage.Literals.IPSS_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsItem getWsItem() {
		if (wsItem != null && wsItem.eIsProxy()) {
			InternalEObject oldWsItem = (InternalEObject)wsItem;
			wsItem = (IpssWsItem)eResolveProxy(oldWsItem);
			if (wsItem != oldWsItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IpssDocPackage.IPSS_DOCUMENT__WS_ITEM, oldWsItem, wsItem));
			}
		}
		return wsItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsItem basicGetWsItem() {
		return wsItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWsItem(IpssWsItem newWsItem, NotificationChain msgs) {
		IpssWsItem oldWsItem = wsItem;
		wsItem = newWsItem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IpssDocPackage.IPSS_DOCUMENT__WS_ITEM, oldWsItem, newWsItem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsItem(IpssWsItem newWsItem) {
		if (newWsItem != wsItem) {
			NotificationChain msgs = null;
			if (wsItem != null)
				msgs = ((InternalEObject)wsItem).eInverseRemove(this, IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC, IpssWsItem.class, msgs);
			if (newWsItem != null)
				msgs = ((InternalEObject)newWsItem).eInverseAdd(this, IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC, IpssWsItem.class, msgs);
			msgs = basicSetWsItem(newWsItem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssDocPackage.IPSS_DOCUMENT__WS_ITEM, newWsItem, newWsItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IpssDocPackage.IPSS_DOCUMENT__WS_ITEM:
				if (wsItem != null)
					msgs = ((InternalEObject)wsItem).eInverseRemove(this, IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC, IpssWsItem.class, msgs);
				return basicSetWsItem((IpssWsItem)otherEnd, msgs);
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
			case IpssDocPackage.IPSS_DOCUMENT__WS_ITEM:
				return basicSetWsItem(null, msgs);
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
			case IpssDocPackage.IPSS_DOCUMENT__WS_ITEM:
				if (resolve) return getWsItem();
				return basicGetWsItem();
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
			case IpssDocPackage.IPSS_DOCUMENT__WS_ITEM:
				setWsItem((IpssWsItem)newValue);
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
			case IpssDocPackage.IPSS_DOCUMENT__WS_ITEM:
				setWsItem((IpssWsItem)null);
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
			case IpssDocPackage.IPSS_DOCUMENT__WS_ITEM:
				return wsItem != null;
		}
		return super.eIsSet(featureID);
	}

} //IpssDocumentImpl
