/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.interpss.editor.ws.IpssWsItem;
import org.interpss.editor.ws.IpssWsItemContainer;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWsItemContainerImpl#getWsItemList <em>Ws Item List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssWsItemContainerImpl extends IpssWsItemImpl implements IpssWsItemContainer {
	/**
	 * The cached value of the '{@link #getWsItemList() <em>Ws Item List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsItemList()
	 * @generated
	 * @ordered
	 */
	protected EList<IpssWsItem> wsItemList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssWsItemContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssWsPackage.Literals.IPSS_WS_ITEM_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IpssWsItem> getWsItemList() {
		if (wsItemList == null) {
			wsItemList = new EObjectContainmentEList<IpssWsItem>(IpssWsItem.class, this, IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST);
		}
		return wsItemList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST:
				return ((InternalEList<?>)getWsItemList()).basicRemove(otherEnd, msgs);
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
			case IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST:
				return getWsItemList();
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
			case IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST:
				getWsItemList().clear();
				getWsItemList().addAll((Collection<? extends IpssWsItem>)newValue);
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
			case IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST:
				getWsItemList().clear();
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
			case IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST:
				return wsItemList != null && !wsItemList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IpssWsItemContainerImpl
