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
import org.interpss.editor.ws.IpssWorkSpace;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Work Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.editor.ws.impl.IpssWorkSpaceImpl#getRootDir <em>Root Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssWorkSpaceImpl extends IpssWsItemContainerImpl implements IpssWorkSpace {
	/**
	 * The default value of the '{@link #getRootDir() <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootDir()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_DIR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRootDir() <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootDir()
	 * @generated
	 * @ordered
	 */
	protected String rootDir = ROOT_DIR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssWorkSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssWsPackage.Literals.IPSS_WORK_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootDir() {
		return rootDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootDir(String newRootDir) {
		String oldRootDir = rootDir;
		rootDir = newRootDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IpssWsPackage.IPSS_WORK_SPACE__ROOT_DIR, oldRootDir, rootDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IpssWsPackage.IPSS_WORK_SPACE__ROOT_DIR:
				return getRootDir();
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
			case IpssWsPackage.IPSS_WORK_SPACE__ROOT_DIR:
				setRootDir((String)newValue);
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
			case IpssWsPackage.IPSS_WORK_SPACE__ROOT_DIR:
				setRootDir(ROOT_DIR_EDEFAULT);
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
			case IpssWsPackage.IPSS_WORK_SPACE__ROOT_DIR:
				return ROOT_DIR_EDEFAULT == null ? rootDir != null : !ROOT_DIR_EDEFAULT.equals(rootDir);
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
		result.append(" (rootDir: ");
		result.append(rootDir);
		result.append(')');
		return result.toString();
	}

} //IpssWorkSpaceImpl
