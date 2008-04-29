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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.interpss.editor.doc.IpssDocPackage;
import org.interpss.editor.doc.IpssDocumentItem;
import org.interpss.editor.ws.IpssProject;
import org.interpss.editor.ws.IpssProjectItemGroup;
import org.interpss.editor.ws.IpssWsItem;
import org.interpss.editor.ws.IpssWsItemContainer;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWsItemImpl#getIpssDoc <em>Ipss Doc</em>}</li>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWsItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWsItemImpl#getParent <em>Parent</em>}</li>
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
	protected IpssDocumentItem ipssDoc;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "NewItem";
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
	public IpssDocumentItem getIpssDoc() {
		if (ipssDoc != null && ipssDoc.eIsProxy()) {
			InternalEObject oldIpssDoc = (InternalEObject)ipssDoc;
			ipssDoc = (IpssDocumentItem)eResolveProxy(oldIpssDoc);
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
	public IpssDocumentItem basicGetIpssDoc() {
		return ipssDoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIpssDoc(IpssDocumentItem newIpssDoc, NotificationChain msgs) {
		IpssDocumentItem oldIpssDoc = ipssDoc;
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
	public void setIpssDoc(IpssDocumentItem newIpssDoc) {
		if (newIpssDoc != ipssDoc) {
			NotificationChain msgs = null;
			if (ipssDoc != null)
				msgs = ((InternalEObject)ipssDoc).eInverseRemove(this, IpssDocPackage.IPSS_DOCUMENT_ITEM__WS_ITEM, IpssDocumentItem.class, msgs);
			if (newIpssDoc != null)
				msgs = ((InternalEObject)newIpssDoc).eInverseAdd(this, IpssDocPackage.IPSS_DOCUMENT_ITEM__WS_ITEM, IpssDocumentItem.class, msgs);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_WS_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsItemContainer getParent() {
		if (eContainerFeatureID != IpssWsPackage.IPSS_WS_ITEM__PARENT) return null;
		return (IpssWsItemContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(IpssWsItemContainer newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, IpssWsPackage.IPSS_WS_ITEM__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(IpssWsItemContainer newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID != IpssWsPackage.IPSS_WS_ITEM__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST, IpssWsItemContainer.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_WS_ITEM__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLoaded() {
		return this.getIpssDoc() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProject getParentProject() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProjectItemGroup getParentProjectItemGroup() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearDocument() {
		setIpssDoc(null);
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
					msgs = ((InternalEObject)ipssDoc).eInverseRemove(this, IpssDocPackage.IPSS_DOCUMENT_ITEM__WS_ITEM, IpssDocumentItem.class, msgs);
				return basicSetIpssDoc((IpssDocumentItem)otherEnd, msgs);
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((IpssWsItemContainer)otherEnd, msgs);
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
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				return basicSetParent(null, msgs);
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
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				return eInternalContainer().eInverseRemove(this, IpssWsPackage.IPSS_WS_ITEM_CONTAINER__WS_ITEM_LIST, IpssWsItemContainer.class, msgs);
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
			case IpssWsPackage.IPSS_WS_ITEM__IPSS_DOC:
				if (resolve) return getIpssDoc();
				return basicGetIpssDoc();
			case IpssWsPackage.IPSS_WS_ITEM__NAME:
				return getName();
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				return getParent();
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
				setIpssDoc((IpssDocumentItem)newValue);
				return;
			case IpssWsPackage.IPSS_WS_ITEM__NAME:
				setName((String)newValue);
				return;
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				setParent((IpssWsItemContainer)newValue);
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
				setIpssDoc((IpssDocumentItem)null);
				return;
			case IpssWsPackage.IPSS_WS_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				setParent((IpssWsItemContainer)null);
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
			case IpssWsPackage.IPSS_WS_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IpssWsPackage.IPSS_WS_ITEM__PARENT:
				return getParent() != null;
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

} //IpssWsItemImpl
