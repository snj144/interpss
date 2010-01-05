/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace.impl;

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
import org.interpss.model.editor.wkSpace.WorkspaceItemContainer;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.WorkspaceItemImpl#getIpssDocument <em>Ipss Document</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceItemImpl extends EObjectImpl implements WorkspaceItem {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIpssDocument() <em>Ipss Document</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpssDocument()
	 * @generated
	 * @ordered
	 */
	protected IpssDocument ipssDocument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return wkSpacePackage.Literals.WORKSPACE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceItemContainer getParent() {
		if (eContainerFeatureID != wkSpacePackage.WORKSPACE_ITEM__PARENT) return null;
		return (WorkspaceItemContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(WorkspaceItemContainer newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, wkSpacePackage.WORKSPACE_ITEM__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(WorkspaceItemContainer newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID != wkSpacePackage.WORKSPACE_ITEM__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST, WorkspaceItemContainer.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.WORKSPACE_ITEM__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.WORKSPACE_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssDocument getIpssDocument() {
		return ipssDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIpssDocument(IpssDocument newIpssDocument, NotificationChain msgs) {
		IpssDocument oldIpssDocument = ipssDocument;
		ipssDocument = newIpssDocument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT, oldIpssDocument, newIpssDocument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpssDocument(IpssDocument newIpssDocument) {
		if (newIpssDocument != ipssDocument) {
			NotificationChain msgs = null;
			if (ipssDocument != null)
				msgs = ((InternalEObject)ipssDocument).eInverseRemove(this, docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM, IpssDocument.class, msgs);
			if (newIpssDocument != null)
				msgs = ((InternalEObject)newIpssDocument).eInverseAdd(this, docPackage.IPSS_DOCUMENT__WORKSPACE_ITEM, IpssDocument.class, msgs);
			msgs = basicSetIpssDocument(newIpssDocument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT, newIpssDocument, newIpssDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((WorkspaceItemContainer)otherEnd, msgs);
			case wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT:
				if (ipssDocument != null)
					msgs = ((InternalEObject)ipssDocument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT, null, msgs);
				return basicSetIpssDocument((IpssDocument)otherEnd, msgs);
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
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				return basicSetParent(null, msgs);
			case wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT:
				return basicSetIpssDocument(null, msgs);
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
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				return eInternalContainer().eInverseRemove(this, wkSpacePackage.WORKSPACE_ITEM_CONTAINER__WS_ITEM_LIST, WorkspaceItemContainer.class, msgs);
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
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				return getParent();
			case wkSpacePackage.WORKSPACE_ITEM__NAME:
				return getName();
			case wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT:
				return getIpssDocument();
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
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				setParent((WorkspaceItemContainer)newValue);
				return;
			case wkSpacePackage.WORKSPACE_ITEM__NAME:
				setName((String)newValue);
				return;
			case wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT:
				setIpssDocument((IpssDocument)newValue);
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
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				setParent((WorkspaceItemContainer)null);
				return;
			case wkSpacePackage.WORKSPACE_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT:
				setIpssDocument((IpssDocument)null);
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
			case wkSpacePackage.WORKSPACE_ITEM__PARENT:
				return getParent() != null;
			case wkSpacePackage.WORKSPACE_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case wkSpacePackage.WORKSPACE_ITEM__IPSS_DOCUMENT:
				return ipssDocument != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //WorkspaceItemImpl
