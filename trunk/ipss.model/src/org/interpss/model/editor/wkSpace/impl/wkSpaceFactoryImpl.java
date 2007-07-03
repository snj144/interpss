/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.wkSpace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.interpss.model.editor.wkSpace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class wkSpaceFactoryImpl extends EFactoryImpl implements wkSpaceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static wkSpaceFactory init() {
		try {
			wkSpaceFactory thewkSpaceFactory = (wkSpaceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.interpss.org/editor/workspace"); 
			if (thewkSpaceFactory != null) {
				return thewkSpaceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new wkSpaceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public wkSpaceFactoryImpl() {
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
			case wkSpacePackage.WORKSPACE_ITEM: return createWorkspaceItem();
			case wkSpacePackage.WORKSPACE_ITEM_CONTAINER: return createWorkspaceItemContainer();
			case wkSpacePackage.IPSS_PROJECT_ITEM: return createIpssProjectItem();
			case wkSpacePackage.IPSS_WORKSPACE: return createIpssWorkspace();
			case wkSpacePackage.IPSS_PROJECT_FOLDER: return createIpssProjectFolder();
			case wkSpacePackage.IPSS_PROJECT: return createIpssProject();
			case wkSpacePackage.IPSS_PROJECT_ITEM_GROUP: return createIpssProjectItemGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case wkSpacePackage.PROJECT_ITEM_STATUS:
				return createProjectItemStatusFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case wkSpacePackage.PROJECT_ITEM_STATUS:
				return convertProjectItemStatusToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceItem createWorkspaceItem() {
		WorkspaceItemImpl workspaceItem = new WorkspaceItemImpl();
		return workspaceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceItemContainer createWorkspaceItemContainer() {
		WorkspaceItemContainerImpl workspaceItemContainer = new WorkspaceItemContainerImpl();
		return workspaceItemContainer;
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
	public IpssWorkspace createIpssWorkspace() {
		IpssWorkspaceImpl ipssWorkspace = new IpssWorkspaceImpl();
		return ipssWorkspace;
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
	public IpssProject createIpssProject() {
		IpssProjectImpl ipssProject = new IpssProjectImpl();
		return ipssProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssProjectItemGroup createIpssProjectItemGroup() {
		IpssProjectItemGroupImpl ipssProjectItemGroup = new IpssProjectItemGroupImpl();
		return ipssProjectItemGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectItemStatus createProjectItemStatusFromString(EDataType eDataType, String initialValue) {
		ProjectItemStatus result = ProjectItemStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProjectItemStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public wkSpacePackage getwkSpacePackage() {
		return (wkSpacePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static wkSpacePackage getPackage() {
		return wkSpacePackage.eINSTANCE;
	}

} //wkSpaceFactoryImpl
