/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.interpss.editor.ws.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.editor.ws.IpssWsPackage
 * @generated
 */
public class IpssWsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IpssWsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IpssWsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssWsSwitch<Adapter> modelSwitch =
		new IpssWsSwitch<Adapter>() {
			@Override
			public Adapter caseIpssWsItem(IpssWsItem object) {
				return createIpssWsItemAdapter();
			}
			@Override
			public Adapter caseIpssWsItemContainer(IpssWsItemContainer object) {
				return createIpssWsItemContainerAdapter();
			}
			@Override
			public Adapter caseIpssProjectItem(IpssProjectItem object) {
				return createIpssProjectItemAdapter();
			}
			@Override
			public Adapter caseIpssWorkSpace(IpssWorkSpace object) {
				return createIpssWorkSpaceAdapter();
			}
			@Override
			public Adapter caseIpssProject(IpssProject object) {
				return createIpssProjectAdapter();
			}
			@Override
			public Adapter caseIpssProjectFolder(IpssProjectFolder object) {
				return createIpssProjectFolderAdapter();
			}
			@Override
			public Adapter caseIpssProjectItemGroup(IpssProjectItemGroup object) {
				return createIpssProjectItemGroupAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssWsItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssWsItem
	 * @generated
	 */
	public Adapter createIpssWsItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssWsItemContainer <em>Item Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssWsItemContainer
	 * @generated
	 */
	public Adapter createIpssWsItemContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssProjectItem <em>Ipss Project Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssProjectItem
	 * @generated
	 */
	public Adapter createIpssProjectItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssWorkSpace <em>Ipss Work Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssWorkSpace
	 * @generated
	 */
	public Adapter createIpssWorkSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssProject <em>Ipss Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssProject
	 * @generated
	 */
	public Adapter createIpssProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssProjectFolder <em>Ipss Project Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssProjectFolder
	 * @generated
	 */
	public Adapter createIpssProjectFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.interpss.editor.ws.IpssProjectItemGroup <em>Ipss Project Item Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.interpss.editor.ws.IpssProjectItemGroup
	 * @generated
	 */
	public Adapter createIpssProjectItemGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //IpssWsAdapterFactory
