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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.interpss.model.editor.doc.IpssDocument;
import org.interpss.model.editor.doc.docPackage;

import org.interpss.model.editor.wkSpace.WorkspaceItem;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.doc.impl.IpssDocumentImpl#getWorkspaceItem <em>Workspace Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssDocumentImpl extends EObjectImpl implements IpssDocument {
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
		return docPackage.Literals.IPSS_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceItem getWorkspaceItem() {
		if (eContainerFeatureID != docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM) return null;
		return (WorkspaceItem)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkspaceItem(WorkspaceItem newWorkspaceItem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWorkspaceItem, docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspaceItem(WorkspaceItem newWorkspaceItem) {
		if (newWorkspaceItem != eInternalContainer() || (eContainerFeatureID != docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM && newWorkspaceItem != null)) {
			if (EcoreUtil.isAncestor(this, newWorkspaceItem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWorkspaceItem != null)
				msgs = ((InternalEObject)newWorkspaceItem).eInverseAdd(this, wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT, WorkspaceItem.class, msgs);
			msgs = basicSetWorkspaceItem(newWorkspaceItem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM, newWorkspaceItem, newWorkspaceItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWorkspaceItem((WorkspaceItem)otherEnd, msgs);
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
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				return basicSetWorkspaceItem(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				return eInternalContainer().eInverseRemove(this, wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT, WorkspaceItem.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				return getWorkspaceItem();
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
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				setWorkspaceItem((WorkspaceItem)newValue);
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
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				setWorkspaceItem((WorkspaceItem)null);
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
			case docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM:
				return getWorkspaceItem() != null;
		}
		return super.eIsSet(featureID);
	}

} //IpssDocumentImpl
