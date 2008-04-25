/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import org.eclipse.emf.ecore.EClass;

import org.interpss.editor.ws.IpssProjectFolder;
import org.interpss.editor.ws.IpssWorkSpace;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Project Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IpssProjectFolderImpl extends IpssWsItemContainerImpl implements IpssProjectFolder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssProjectFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssWsPackage.Literals.IPSS_PROJECT_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IpssWorkSpace getWorkSpace() {
		return (IpssWorkSpace)getParent();
	}

} //IpssProjectFolderImpl
