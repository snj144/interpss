/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.interpss.editor.ws.IpssProject;
import org.interpss.editor.ws.IpssProjectItem;
import org.interpss.editor.ws.IpssWsPackage;
import org.interpss.editor.ws.WsItemInitStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Project Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssProjectItemImpl#getIntStatus <em>Int Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssProjectItemImpl extends IpssWsItemImpl implements IpssProjectItem {
	/**
	 * The default value of the '{@link #getIntStatus() <em>Int Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntStatus()
	 * @generated
	 * @ordered
	 */
	protected static final WsItemInitStatus INT_STATUS_EDEFAULT = WsItemInitStatus.CLOSE;
	/**
	 * The cached value of the '{@link #getIntStatus() <em>Int Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntStatus()
	 * @generated
	 * @ordered
	 */
	protected WsItemInitStatus intStatus = INT_STATUS_EDEFAULT;

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
		return IpssWsPackage.Literals.IPSS_PROJECT_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WsItemInitStatus getIntStatus() {
		return intStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntStatus(WsItemInitStatus newIntStatus) {
		WsItemInitStatus oldIntStatus = intStatus;
		intStatus = newIntStatus == null ? INT_STATUS_EDEFAULT : newIntStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_PROJECT_ITEM__INT_STATUS, oldIntStatus, intStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProject getParentProject() {
		return (IpssProject)getParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IpssWsPackage.IPSS_PROJECT_ITEM__INT_STATUS:
				return getIntStatus();
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
			case IpssWsPackage.IPSS_PROJECT_ITEM__INT_STATUS:
				setIntStatus((WsItemInitStatus)newValue);
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
			case IpssWsPackage.IPSS_PROJECT_ITEM__INT_STATUS:
				setIntStatus(INT_STATUS_EDEFAULT);
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
			case IpssWsPackage.IPSS_PROJECT_ITEM__INT_STATUS:
				return intStatus != INT_STATUS_EDEFAULT;
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
		result.append(" (intStatus: ");
		result.append(intStatus);
		result.append(')');
		return result.toString();
	}

} //IpssProjectItemImpl
