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

import org.interpss.editor.ws.IpssWsDbItem;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Db Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWsDbItemImpl#getDbId <em>Db Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IpssWsDbItemImpl extends IpssWsItemImpl implements IpssWsDbItem {
	/**
	 * The default value of the '{@link #getDbId() <em>Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbId()
	 * @generated
	 * @ordered
	 */
	protected static final int DB_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDbId() <em>Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbId()
	 * @generated
	 * @ordered
	 */
	protected int dbId = DB_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssWsDbItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssWsPackage.Literals.IPSS_WS_DB_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDbId() {
		return dbId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbId(int newDbId) {
		int oldDbId = dbId;
		dbId = newDbId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_WS_DB_ITEM__DB_ID, oldDbId, dbId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IpssWsPackage.IPSS_WS_DB_ITEM__DB_ID:
				return new Integer(getDbId());
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
			case IpssWsPackage.IPSS_WS_DB_ITEM__DB_ID:
				setDbId(((Integer)newValue).intValue());
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
			case IpssWsPackage.IPSS_WS_DB_ITEM__DB_ID:
				setDbId(DB_ID_EDEFAULT);
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
			case IpssWsPackage.IPSS_WS_DB_ITEM__DB_ID:
				return dbId != DB_ID_EDEFAULT;
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
		result.append(" (dbId: ");
		result.append(dbId);
		result.append(')');
		return result.toString();
	}

} //IpssWsDbItemImpl
