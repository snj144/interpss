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

import org.interpss.model.editor.wkSpace.IpssProject;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.IpssProjectImpl#getProjDbId <em>Proj Db Id</em>}</li>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.IpssProjectImpl#getParentPath <em>Parent Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssProjectImpl extends WorkspaceItemContainerImpl implements IpssProject {
	/**
	 * The default value of the '{@link #getProjDbId() <em>Proj Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjDbId()
	 * @generated
	 * @ordered
	 */
	protected static final int PROJ_DB_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProjDbId() <em>Proj Db Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjDbId()
	 * @generated
	 * @ordered
	 */
	protected int projDbId = PROJ_DB_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentPath() <em>Parent Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentPath() <em>Parent Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentPath()
	 * @generated
	 * @ordered
	 */
	protected String parentPath = PARENT_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return wkSpacePackage.Literals.IPSS_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProjDbId() {
		return projDbId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjDbId(int newProjDbId) {
		int oldProjDbId = projDbId;
		projDbId = newProjDbId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.IPSS_PROJECT__PROJ_DB_ID, oldProjDbId, projDbId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentPath() {
		return parentPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPath(String newParentPath) {
		String oldParentPath = parentPath;
		parentPath = newParentPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.IPSS_PROJECT__PARENT_PATH, oldParentPath, parentPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case wkSpacePackage.IPSS_PROJECT__PROJ_DB_ID:
				return new Integer(getProjDbId());
			case wkSpacePackage.IPSS_PROJECT__PARENT_PATH:
				return getParentPath();
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
			case wkSpacePackage.IPSS_PROJECT__PROJ_DB_ID:
				setProjDbId(((Integer)newValue).intValue());
				return;
			case wkSpacePackage.IPSS_PROJECT__PARENT_PATH:
				setParentPath((String)newValue);
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
			case wkSpacePackage.IPSS_PROJECT__PROJ_DB_ID:
				setProjDbId(PROJ_DB_ID_EDEFAULT);
				return;
			case wkSpacePackage.IPSS_PROJECT__PARENT_PATH:
				setParentPath(PARENT_PATH_EDEFAULT);
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
			case wkSpacePackage.IPSS_PROJECT__PROJ_DB_ID:
				return projDbId != PROJ_DB_ID_EDEFAULT;
			case wkSpacePackage.IPSS_PROJECT__PARENT_PATH:
				return PARENT_PATH_EDEFAULT == null ? parentPath != null : !PARENT_PATH_EDEFAULT.equals(parentPath);
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
		result.append(" (projDbId: ");
		result.append(projDbId);
		result.append(", parentPath: ");
		result.append(parentPath);
		result.append(')');
		return result.toString();
	}

} //IpssProjectImpl
