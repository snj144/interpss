/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.interpss.model.editor.wkSpace.WorkspaceItem;
import org.interpss.model.editor.wkSpace.WorkspaceItemContainer;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Item Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemContainerImpl#getWsItemList <em>Ws Item List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceItemContainerImpl extends WorkspaceItemImpl implements WorkspaceItemContainer {
	/**
	 * The cached value of the '{@link #getWsItemList() <em>Ws Item List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsItemList()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkspaceItem> wsItemList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceItemContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return wkSpacePackage.Literals.WORKSPACE_ITEM_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkspaceItem> getWsItemList() {
		if (wsItemList == null) {
			wsItemList = new EObjectContainmentWithInverseEList<WorkspaceItem>(WorkspaceItem.class, this, wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST, wkSpacePackage.WORKSPACE_ITEM__PARENT);
		}
		return wsItemList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWsItemList()).basicAdd(otherEnd, msgs);
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
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST:
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
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST:
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
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST:
				getWsItemList().clear();
				getWsItemList().addAll((Collection<? extends WorkspaceItem>)newValue);
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
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST:
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
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST:
				return wsItemList != null && !wsItemList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorkspaceItemContainerImpl
