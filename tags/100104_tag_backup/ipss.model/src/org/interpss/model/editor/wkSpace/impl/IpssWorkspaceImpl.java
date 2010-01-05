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

import org.interpss.model.editor.wkSpace.IpssWorkspace;
import org.interpss.model.editor.wkSpace.wkSpacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Workspace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.interpss.model.editor.wkSpace.impl.IpssWorkspaceImpl#getAbsolutionPath <em>Absolution Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpssWorkspaceImpl extends WorkspaceItemContainerImpl implements IpssWorkspace {
	/**
	 * The default value of the '{@link #getAbsolutionPath() <em>Absolution Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolutionPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ABSOLUTION_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbsolutionPath() <em>Absolution Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolutionPath()
	 * @generated
	 * @ordered
	 */
	protected String absolutionPath = ABSOLUTION_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssWorkspaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return wkSpacePackage.Literals.IPSS_WORKSPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbsolutionPath() {
		return absolutionPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsolutionPath(String newAbsolutionPath) {
		String oldAbsolutionPath = absolutionPath;
		absolutionPath = newAbsolutionPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, wkSpacePackage.IPSS_WORKSPACE__ABSOLUTION_PATH, oldAbsolutionPath, absolutionPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case wkSpacePackage.IPSS_WORKSPACE__ABSOLUTION_PATH:
				return getAbsolutionPath();
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
			case wkSpacePackage.IPSS_WORKSPACE__ABSOLUTION_PATH:
				setAbsolutionPath((String)newValue);
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
			case wkSpacePackage.IPSS_WORKSPACE__ABSOLUTION_PATH:
				setAbsolutionPath(ABSOLUTION_PATH_EDEFAULT);
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
			case wkSpacePackage.IPSS_WORKSPACE__ABSOLUTION_PATH:
				return ABSOLUTION_PATH_EDEFAULT == null ? absolutionPath != null : !ABSOLUTION_PATH_EDEFAULT.equals(absolutionPath);
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
		result.append(" (absolutionPath: ");
		result.append(absolutionPath);
		result.append(')');
		return result.toString();
	}

} //IpssWorkspaceImpl
