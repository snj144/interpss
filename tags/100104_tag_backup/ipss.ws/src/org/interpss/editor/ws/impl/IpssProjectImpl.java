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
import org.interpss.editor.ws.IpssProjectFolder;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssProjectImpl#getProjDbId <em>Proj Db Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssProjectImpl extends IpssWsItemContainerImpl implements IpssProject {
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
		return IpssWsPackage.Literals.IPSS_PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_PROJECT__PROJ_DB_ID, oldProjDbId, projDbId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IpssProjectFolder getParanetFolder() {
		return (IpssProjectFolder)getParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IpssWsPackage.IPSS_PROJECT__PROJ_DB_ID:
				return new Integer(getProjDbId());
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
			case IpssWsPackage.IPSS_PROJECT__PROJ_DB_ID:
				setProjDbId(((Integer)newValue).intValue());
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
			case IpssWsPackage.IPSS_PROJECT__PROJ_DB_ID:
				setProjDbId(PROJ_DB_ID_EDEFAULT);
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
			case IpssWsPackage.IPSS_PROJECT__PROJ_DB_ID:
				return projDbId != PROJ_DB_ID_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //IpssProjectImpl
