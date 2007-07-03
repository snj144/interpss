/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.interpss.model.editor.wkSpace.IpssProjectItem;
import org.interpss.model.editor.wkSpace.ProjectItemStatus;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Project Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.IpssProjectItemImpl#getInitStatus <em>Init Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssProjectItemImpl extends WorkspaceItemImpl implements IpssProjectItem {
	/**
	 * The default value of the '{@link #getInitStatus() <em>Init Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ProjectItemStatus INIT_STATUS_EDEFAULT = ProjectItemStatus.OPEN;

	/**
	 * The cached value of the '{@link #getInitStatus() <em>Init Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitStatus()
	 * @generated
	 * @ordered
	 */
	protected ProjectItemStatus initStatus = INIT_STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssProjectItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return wkSpacePackage.Literals.IPSS_PROJECT_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectItemStatus getInitStatus() {
		return initStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitStatus(ProjectItemStatus newInitStatus) {
		ProjectItemStatus oldInitStatus = initStatus;
		initStatus = newInitStatus == null ? INIT_STATUS_EDEFAULT : newInitStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.IPSS_PROJECT_ITEM__INIT_STATUS, oldInitStatus, initStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case wkSpacePackage.IPSS_PROJECT_ITEM__INIT_STATUS:
				return getInitStatus();
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
			case wkSpacePackage.IPSS_PROJECT_ITEM__INIT_STATUS:
				setInitStatus((ProjectItemStatus)newValue);
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
			case wkSpacePackage.IPSS_PROJECT_ITEM__INIT_STATUS:
				setInitStatus(INIT_STATUS_EDEFAULT);
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
			case wkSpacePackage.IPSS_PROJECT_ITEM__INIT_STATUS:
				return initStatus != INIT_STATUS_EDEFAULT;
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
		result.append(" (initStatus: ");
		result.append(initStatus);
		result.append(')');
		return result.toString();
	}

} //IpssProjectItemImpl
