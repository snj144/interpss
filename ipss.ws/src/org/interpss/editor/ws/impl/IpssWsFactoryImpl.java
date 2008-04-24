/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.interpss.editor.ws.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IpssWsFactoryImpl extends EFactoryImpl implements IpssWsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IpssWsFactory init() {
		try {
			IpssWsFactory theIpssWsFactory = (IpssWsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/interpss/editor/ws"); 
			if (theIpssWsFactory != null) {
				return theIpssWsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IpssWsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IpssWsPackage.IPSS_PROJECT_ITEM: return createIpssProjectItem();
			case IpssWsPackage.IPSS_WORK_SPACE: return createIpssWorkSpace();
			case IpssWsPackage.IPSS_PROJECT: return createIpssProject();
			case IpssWsPackage.IPSS_PROJECT_FOLDER: return createIpssProjectFolder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProjectItem createIpssProjectItem() {
		IpssProjectItemImpl ipssProjectItem = new IpssProjectItemImpl();
		return ipssProjectItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWorkSpace createIpssWorkSpace() {
		IpssWorkSpaceImpl ipssWorkSpace = new IpssWorkSpaceImpl();
		return ipssWorkSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProject createIpssProject() {
		IpssProjectImpl ipssProject = new IpssProjectImpl();
		return ipssProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProjectFolder createIpssProjectFolder() {
		IpssProjectFolderImpl ipssProjectFolder = new IpssProjectFolderImpl();
		return ipssProjectFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsPackage getIpssWsPackage() {
		return (IpssWsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IpssWsPackage getPackage() {
		return IpssWsPackage.eINSTANCE;
	}

} //IpssWsFactoryImpl
