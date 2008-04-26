/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import org.eclipse.emf.ecore.EClass;
import org.interpss.editor.ws.IpssProject;
import org.interpss.editor.ws.IpssProjectItem;
import org.interpss.editor.ws.IpssProjectItemGroup;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Project Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IpssProjectItemImpl extends IpssWsItemImpl implements IpssProjectItem {
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
	 * @generated NOT
	 */
	public IpssProject getParentProject() {
		return (IpssProject)getParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IpssProjectItemGroup getParentProjectItemGroup() {
		return (IpssProjectItemGroup)getParent();
	}

} //IpssProjectItemImpl
